import { useContext, useState } from "react";
import { CardElement, useElements, useStripe } from "@stripe/react-stripe-js"
import { ShoppingCartContext } from "./ShoppingCartContext";
import EndOfOrder from "../Pages/EndOfOrder";
import axios from 'axios'

let config = {
    baseURL: `http://localhost:9000/`,
    headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        'Access-Control-Allow-Headers': '*'
      }
}

function sendPayment(id, price) {
    console.log("creditCardTokenId, cena",id,price);
    return axios.post('/payments',  {creditCardTokenId: id, value: price}, config).then((res) =>{
        return res.data;
    });
}

const PaymentForm = () => {
    const { sendProductsInCart } = useContext(ShoppingCartContext)
    const [success, setSuccess] = useState(false)
    const stripe = useStripe()
    const elements = useElements()
    const { products } = useContext(ShoppingCartContext)
    const itemsPrice = products.reduce((a, c) => a + c.quantity * (c.item.price) ,0);

    const sendForm = async (values) => {
        console.log(values);
        sendPayment(values, itemsPrice * 100).then(
            (paymentStatus) => {
                console.log(paymentStatus);
                sendProductsInCart(paymentStatus.id)
                setSuccess(true)
            },
            () => {
                console.error("Błąd płatności")
                alert("Błąd płatności")
            });
    };

    const handleSubmitForm = async (values) => {
        console.log(values)
        console.log(elements.getElement(CardElement))
        values.preventDefault()
        const { error, paymentMethod } = await stripe.createPaymentMethod({
            type: "card",
            card: elements.getElement(CardElement)

        })
        console.log(paymentMethod)

        console.log("czy jest error",error)
        if (!error) {
            console.log(paymentMethod)
            const { id } = paymentMethod
            console.log(id)
            sendForm(id)
        }
}

    return (
        <>
            {!success ?
                <div className="payment">
                    <h4  className='titleCard'>Podaj numer karty, date waznowsci oraz CVC</h4>
                    <form id="payment-form" className="formCard"  onSubmit={(values) => { handleSubmitForm(values) }}>
                        <div id="card-element"><CardElement className="inputCard"/></div>
                        <h2 className='summaryh2'>Do zapłaty:<span className="priceValue">{itemsPrice} </span> PLN</h2>
                        <button className='buttonCard' id="submit">
                            <div className="spinner hidden" id="spinner"></div>
                            <span id="button-text">Zapłać teraz</span>
                        </button>
                    </form>   
                </div>
                :
                <EndOfOrder />
            }
        </>
    )
}

export default PaymentForm
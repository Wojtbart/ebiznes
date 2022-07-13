import * as React from 'react';
import { useContext } from "react";
import { ShoppingCartContext } from "../Components/ShoppingCartContext";
import { useNavigate } from "react-router-dom";
import '../App.css';

const EndOfOrder = () => {
    const { products } = useContext(ShoppingCartContext);
    let navigate = useNavigate();
    console.log("EndOfOrder",products);
    return (
        <div className="containerOrder">
           <h2>Twoje zamówienie</h2>
           <div className="summaryTable">
                <table className="fixed_headers">
                    <thead className="commentThead">
                    <tr className="commentTr">
                        <th className="commentTh">Produkt</th>
                        <th className="commentTh">Waga</th>
                        <th className="commentTh">Ilość x Cena</th>
                        <th className="commentTh">Suma</th>
                    </tr>
                    </thead>
                    { 
                        products.map((elem) => (
                            <tbody className="commentTbody">
                                <tr  className="commentTr">
                                    <td className="commentTd" >{elem.item.name}</td>
                                    <td className="commentTd">{elem.item.weight} kg</td>
                                    <td className="commentTd">{elem.quantity} x {elem.item.price} PLN</td>
                                    <td className="commentTd">{elem.quantity * elem.item.price } PLN</td>
                                </tr>
                            </tbody>         
                        )) 
                    }
                </table> 
            </div>
            <button className='back' onClick={() => navigate("/")}>
                Strona główna
            </button>
        </div>
    )
}

export default EndOfOrder;
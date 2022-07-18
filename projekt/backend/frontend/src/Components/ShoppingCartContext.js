import React from "react"
import { useState, createContext, useEffect } from "react";
import { useCookies } from 'react-cookie';
import axios from 'axios'

let config = {
    baseURL: 'https://shopershopy-back.azurewebsites.net/',
    headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
      }
}

function sendProducts(token, paymentId, ...cart) {
    console.log(cart)
    return axios.post('/shoppingCart/' + token, {payment_id: paymentId, products_in_cart: cart},config).then((res) =>{
        return res.data;
    });
}

export const ShoppingCartContext = createContext({
    products: [],
    addProduct: () => {
    },
    removeProduct: () => {
    },
    removeAllProducts: () => {
    },
    sendProductsInCart: () => {
    },
});



export const ShoppingCartContextProvider = ({ children }) => {
    const [products, setProducts] = useState([]);
    const [cookies] = useCookies(['token']);

    useEffect(() => {
        let productsToSet = products
        if (products.length === 0) {
            const savedProducts = localStorage.getItem("products");
            if (savedProducts && JSON.parse(savedProducts).length) {
                productsToSet = checkZeroQuantity(JSON.parse(savedProducts));
                setProducts(productsToSet);
            }
        }
        localStorage.setItem("products", JSON.stringify(productsToSet));
    }, [products]);

    const addProduct = (newProduct) => {
        console.log("jestem w AddProduct", products)
        console.log("newProduct",newProduct)
        let productInCart = products.findIndex((product) => product.item.id === newProduct.id);
        console.log("indexProduktu",productInCart);
        if (productInCart !== -1) {
            products[productInCart].quantity = products[productInCart].quantity + 1;
            setProducts([...products])
        } else {
            setProducts([...products, { item: { ...newProduct }, quantity: 1 }])
        }
    }

    const sendProductsInCart = (paymentId) => {
        console.log("jestem w sendProductsInCart")
        if (products.length !== 0){
            console.log(products);
            sendProducts(cookies.token, paymentId, ...products).then( (status) =>  {
                    console.log(status);
                    products.length = 0
                    localStorage.setItem("products", []);
                },
                () => {
                    console.error("Błąd koszyka")
                    alert("Udało się zakupić produkty!")
                }
            );
        }
        else{
            console.log("products jest równe 0")  
        }
         console.log("po sendProductsInCart") 
    }

    const removeProduct = (product) => {
        console.log("jestem w removeProduct")
        let updatedProducts = products.map((elem) => {
            if (elem.item.id === product.id) {
                elem.quantity = elem.quantity - 1;
            }
            return elem;
        })

        setProducts(checkZeroQuantity(updatedProducts));
        localStorage.setItem("products", JSON.stringify(checkZeroQuantity(updatedProducts)));
    }

    function checkZeroQuantity(productsQuantity) {
        return productsQuantity.filter((product) => product.quantity !== 0);
    }

    const removeAllProducts = (product) => {
        console.log("jestem w removeAllProducts")
        let updatedProducts = products.map((elem) => {
            if (elem.item.id === product.id) {
                elem.quantity = 0;
            }

            return elem;
        })

        setProducts(checkZeroQuantity(updatedProducts));
        localStorage.setItem("products", JSON.stringify(checkZeroQuantity(updatedProducts)));
    }


    return (
        <ShoppingCartContext.Provider value={{
            products,
            sendProductsInCart,
            addProduct,
            removeProduct,
            removeAllProducts
        }}>
            {children}
        </ShoppingCartContext.Provider>
    )
}
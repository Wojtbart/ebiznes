import React from 'react';
import { useState, createContext, useEffect } from "react";
import axios from 'axios';

let config = {
    baseURL: 'https://shopershopy-backend.azurewebsites.net/',
    headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
      }
}

//hook do pobierania produktów
async function getProducts() {
    const query = await axios.get('/product',config);
    const responseJson = query.data;
    console.log(responseJson);
    return responseJson;
}
 
//hook createContext
export const ProductsContext = createContext({
    productList: [], //kontekst lista produktów
});

export const ProductsContextProvider = ({ children }) => {
    //hook useState i useEffect
    const [productList, setProductsList] = useState([]);

    useEffect(() => {
        getProducts().then((data) => 
            setProductsList(data));
    }, [])

    return (
        <ProductsContext.Provider value={{productList}}>
            {children}
        </ProductsContext.Provider>
    )
}
import * as React from 'react';
import { useContext } from "react";
import { ProductsContext } from "./ProductsContext";
import Product from "./Product"
import { Link } from "react-router-dom";



function ProductList() {
    const { productList } = useContext(ProductsContext)

    return (
        <div>
            <div className="other">
                <h2 className="productsTitle">Dostępne produkty do kupienia!</h2>
                <div className="productsList">
                    {
                        productList.map((product) => (
                            <Product  key={product.id} product={product} />   /* key nie musi tu być */
                        ))
                    }
                </div>
                <button className="gotocart"> <Link to="/shoppingCart">Przejdż do koszyka</Link> </button>   
            </div>
        </div>   
    );
}

export default ProductList;
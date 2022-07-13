import * as React from 'react';
import { useContext } from "react";
import { ProductsContext } from "./ProductsContext";
import Product from "./Product"
import { Link } from "react-router-dom";

// let counter=0;

// export function isClicked () {
//     //dom not only ready, but everything is loaded
//     const element = document.querySelector('.btn')
//     const parent = document.querySelector('.other')
//     console.log("siemanko")

//     // always checking if the element is clicked, if so, do alert('hello')
//     element.addEventListener("click", () => {
//         console.log("click")
//         counter+=1;
//         console.log("parent",parent)
//         parent.append("ooo");
//         console.log("dodane")
//     });
// };


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
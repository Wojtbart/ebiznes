import * as React from 'react';
import { useContext } from "react";
import { ShoppingCartContext } from "./ShoppingCartContext";
import { Link } from "react-router-dom";

function ShoppingCartList() {

    const { products, addProduct, removeProduct, removeAllProducts } = useContext(ShoppingCartContext)
    const itemsPrice = products.reduce((a, c) => a + c.quantity * c.item.price, 0);

    return (
        <div className="container">
            <div className="insideContainer">
                <div className="basket">
                    <h2>Produkty w koszyku:</h2>
                    <aside className="block">
                        <div className="ProductItem">
                            {products.length === 0 && <div>Koszyk jest pusty</div>}

                            {products.map((elem) => (
                                <div key={elem.item.id}  className="single-item-wrap">
                                    <div className="singleItem">
                                        <div className="colLeft">{elem.item.name}</div>
                                        <div className="colRight">
                                            <button onClick={() => addProduct(elem.item)} className="add">
                                                +
                                            </button>
                                            <button onClick={() => removeProduct(elem.item)} className="remove">
                                                -
                                            </button>
                                            
                                            <button onClick={() => removeAllProducts(elem.item)}>
                                                usuń
                                            </button>
                                        </div>
                                        <div className="textBottom">
                                        {elem.quantity} x {elem.item.price} PLN
                                        </div>
                                    </div>
                                
                                </div>
                            ))}
                            {products.length !== 0 && (
                                <>
                                    <p>Razem: <span className="cena"> {itemsPrice}</span> PLN</p>
                                    <button><Link
                                        disabled={!products.length}
                                        to="/payments">
                                        Przejdź do zamówienia
                                        </Link>
                                    </button>
                                    
                                </>
                            )}
                        </div>
                    </aside>
                </div>
            </div>
        </div>
    )
}

export default ShoppingCartList;
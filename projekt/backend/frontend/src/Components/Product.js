import { ShoppingCartContext } from "./ShoppingCartContext";
import { useContext } from "react";

const Product = ({ product }) => {
    const { addProduct } = useContext(ShoppingCartContext);
    return (
        <div>
            <div className="products card card-body">
                <h2 className="productNumber">Numer: {product.id}</h2>
                <h2 className="productName"> {product.name}</h2>
                <p>Cena: {`${product.price} zł`}</p>
                <p>Waga: {`${product.weight} kg`}</p>
                <div className='product-buttons'>
                    <button className="btn" onClick={() => { addProduct(product); }}>Dodaj do koszyka</button>
                </div> 
            </div>
        </div>
    )
}

export default Product;
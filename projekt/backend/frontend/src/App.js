import React from "react";
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { useState } from "react";
import { useCookies } from 'react-cookie';

import NotFoundPage from "./Pages/NotFoundPage";
import Payment from "./Pages/Payment";
import Login from "./Pages/Login";
import EndOfOrder from "./Pages/EndOfOrder";
import Home from "./Pages/Home";

import AppHeader from "./Components/AppHeader";
import { ProductsContextProvider } from "./Components/ProductsContext";
import { ShoppingCartContextProvider } from "./Components/ShoppingCartContext";
import Logout  from "./Components/Logout";
import ProductsList from "./Components/ProductsList"
import ShoppingCartList from "./Components/ShoppingCartList";

function App() {
  const [cookies] = useCookies(['username']);
  const [isLogged, setIsLogged] = useState(cookies.username);

  return (
      <ProductsContextProvider>
        <ShoppingCartContextProvider>
            <Router>
              <AppHeader  {...{ isLogged }}/>
              <Routes>
                  <Route index element={<Home />} />
                  <Route path="/" element={<Home />} />
                  <Route path="*" element={<NotFoundPage />} />
                  <Route path="/products" element={<ProductsList />} />
                  <Route path="/login" element={<Login {...{ isLogged, setIsLogged }}/>} />
                  <Route path="/logout" element={<Logout />} />
                  <Route path="/shoppingCart" element={<ShoppingCartList />} />
                  <Route path="/payments" element={<Payment />} />
                  <Route path="/endOfOrder" element={<EndOfOrder />} />
              </Routes>
            </Router>
        </ShoppingCartContextProvider>
      </ProductsContextProvider>
  );
}

export default App;

import React from 'react';
import { Link } from "react-router-dom";
import {AppBar, Toolbar, Button} from '@material-ui/core';
import '../App.css';
import { useCookies } from 'react-cookie';

function AppHeader (props) {
  console.log(useCookies(['username']))
  console.log("props",props)
  const [cookies] = useCookies(['username']);

  let loginLink;
  let welcome;
  if (props.isLogged) {
      loginLink = <Link className="loginLink" to="/logout">Wyloguj się</Link>;
      welcome= <div className="headersButtonGreeting">Witamy <span>{cookies.username}</span>!</div>;
  } else {
    loginLink = <Link className="loginLink" to="/login">Zaloguj się</Link>;
  }

  return (
    <AppBar position="static">
      <Toolbar >
          <h2 className="headerTitle">Shoperrr</h2>        
          {getMenuButtons()}
          {welcome}
          {loginLink}
      </Toolbar>
    </AppBar>
  );
}

const headersData = [
  {
    label: "Główna",
    href: "/",
    key: "1"
  },
  {
    label: "Produkty",
    href: "/products",
    key: "12"
  },
  {
    label: "Koszyk",
    href: "/shoppingCart",
    key:"123"
  },
  {
    label: "Podsumowanie",
    href: "/endOfOrder",
    key:"1234"
  },
];

const optionsStyles={
  style:{
    base:{
      marginLeft:'20px'
    }
    
  }
  
}

const getMenuButtons = () => {
  return headersData.map(({ label, href }) => {
    return (
      <Button
      options={optionsStyles}  {...{key: label, color: "inherit", href: href, }  } 
      >
        {label}
      </Button>
    );
  });
};

export default  AppHeader;
import { useEffect } from "react";
import { useCookies } from 'react-cookie';
import axios from 'axios'

let config = {
    baseURL: `http://localhost:9000/`,
    headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
      }
}

const redirectToLogout = async () => {
    await axios.get('/logout', config).then((logoutURL)=>{
        console.log(logoutURL.data);
        window.open(logoutURL.data, "_self");
    });  
}

export default function Logout(){
    const [, , removeCookie] = useCookies();
    useEffect(() => {
        removeCookie("username");
        removeCookie("token");
        redirectToLogout();
    }, [removeCookie])
}
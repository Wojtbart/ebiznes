import React from 'react';
import axios from 'axios';
import { GithubLoginButton, GoogleLoginButton, FacebookLoginButton, LinkedInLoginButton} from "react-social-login-buttons";
import { useSearchParams } from "react-router-dom";
import { useCookies } from 'react-cookie';
import  { useEffect }  from "react";
import { Navigate  } from 'react-router-dom';
// import https from 'https';

// const httpsAgent = new https.Agent({rejectUnauthorized: false});
let config = {
    baseURL: 'https://shopershopy-backend.azurewebsites.net/',
    headers: {
        'Access-Control-Allow-Origin': 'https://shopershopy-backend.azurewebsites.net:8082',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token, Authorization',
        
      }
      
      
}

//hooki do logowania
const handleGoogleRedirect = async () => {
    axios.get("https://shopershopy-backend.azurewebsites.net/google/googleRedirect",{withCredentials: true},config)
    .then((googleLogin) => {
        console.log(googleLogin.data);
        window.open(googleLogin.data, "_self");
    });
}

const handleFacebookRedirect = async () => {
    axios.get("https://shopershopy-backend.azurewebsites.net/facebook/facebookRedirect",{withCredentials: true},config)
    .then((facebookLogin) => {
        console.log(facebookLogin.data);
        window.open(facebookLogin.data, "_self");
    });
}

const handleGithubRedirect = async () => {
    axios.get('https://shopershopy-backend.azurewebsites.net/github/githubRedirect',{withCredentials: true},config)
    .then((githubLogin) => {
        console.log(githubLogin.data);
        window.open(githubLogin.data, "_self");
    });
}

const handlelinkedinRedirect = async () => {
    axios.get("https://shopershopy-backend.azurewebsites.net/linkedin/linkedinRedirect",{withCredentials: true},config)
    .then((linkedinLogin) => {
        console.log(linkedinLogin.data);
        window.open(linkedinLogin.data, "_self");
    });
}

function Login(props) {
    const [searchParams] = useSearchParams();
    const [ , setCookie] = useCookies();

    useEffect(() => {
        if (searchParams.get("username")) {
            setCookie("username", searchParams.get("username"))
            setCookie("token", searchParams.get("token"))
            props.setIsLogged(true)
        }
    }, [searchParams, setCookie, props])

    return (
        !props.isLogged ?
        <div className="loginPageContainer">
            <h1>Zaloguj się na jedno z poniższych kont!</h1>
            <div className="loginPageDiv">
                <GoogleLoginButton className="googleButton" onClick={handleGoogleRedirect} />
                <FacebookLoginButton className="facebookButton" onClick={handleFacebookRedirect} />
                <GithubLoginButton className="githubButton" onClick={handleGithubRedirect} />
                <LinkedInLoginButton className="linkedinButton" onClick={handlelinkedinRedirect} />
            </div>
        </div>
        :
        <div>
            {
                <Navigate  to="/" />
            }
        </div>
    );
}

export default Login;
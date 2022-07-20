import React from 'react';
import axios from 'axios';
import { GithubLoginButton, GoogleLoginButton, FacebookLoginButton,DiscordLoginButton } from "react-social-login-buttons";
import { useSearchParams } from "react-router-dom";
import { useCookies } from 'react-cookie';
import  { useEffect }  from "react";
import { Navigate  } from 'react-router-dom';

let config = {
    baseURL: `http://localhost:9000/`,
    headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token, Authorization',
        
      }
      
      
}

//hooki do logowania
const handleGoogleRedirect = async () => {
    axios.get("http://localhost:9000/google/googleRedirect",{withCredentials: true},config)
    .then((googleLogin) => {
        console.log(googleLogin.data);
        window.open(googleLogin.data, "_self");
    });
}

const handleFacebookRedirect = async () => {
    axios.get("http://localhost:9000/facebook/facebookRedirect",{withCredentials: true},config)
    .then((facebookLogin) => {
        console.log(facebookLogin.data);
        window.open(facebookLogin.data, "_self");
    });
}

const handleGithubRedirect = async () => {
    axios.get('http://localhost:9000/github/githubRedirect',{withCredentials: true})
    .then((githubLogin) => {
        console.log(githubLogin.data);
        window.open(githubLogin.data, "_self");
    });
}

const handlelinkedinRedirect = async () => {
    axios.get("http://localhost:9000/discord/discordRedirect",{withCredentials: true})
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
                <DiscordLoginButton className="linkedinButton" onClick={handlelinkedinRedirect} />
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
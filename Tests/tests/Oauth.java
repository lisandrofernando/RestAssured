package tests;



import static io.restassured.RestAssured.*;


import files.URI;
import io.restassured.path.json.JsonPath;

/*Oauth 2.0 Authentication
An industry standard protocol for an Authorization. 
The oauth 2.0 is an architectural standard mechanism to access third party servers, which comes with multiple grant types: 
Authorization code and client credentials. 
The client is the application that is expected to be served. 
For example login in to Udemy or other webpage, you can log in with google gmail, and google will assign a client id and client secret id. 
Resource owner will enter the login information allowing google to send all my information. 
When hitting the url google will send a code which is an OTP. 
For example google will send from to the original server an access token, first name and last name, and email. 
Google will provide an authorization url, the scope will be sent through resources either user name and email, then client id, response type, redirect url and state.
1-Redirect url
2-Authorization server url
3-Access token url
4-Client ID
5-Client Secret code
6-Scope
7-State
8-Oauth request headers */

public class Oauth {
    
    public static void main(String[] args){

      String AccessTokenResponse =   given().queryParams("code","")
        .queryParams("client_id", "")
        .queryParams("client_secret","")
        .queryParams("redirect_uri","")
        .queryParams("grant_type","")
        .when().post(URI.uri()).asString();
        JsonPath js = new JsonPath(AccessTokenResponse);
        String token = js.getString("access_token");

        String response =    given().queryParam("access_token", token)
        .when().get(URI.uri()).asString();
        System.out.println(response);
    }
}

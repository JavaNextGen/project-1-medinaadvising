const url = "http://localhost:3000/";

document.getElementById("registerButton").addEventListener("click", registerFunction);

async function registerFunction() {

    //gather the user inputs from the login inputs
    let Username = document.getElementById("username").value;
    let Password = document.getElementById("password").value;
    let F_name = document.getElementById("f_name").value;
    let L_name = document.getElementById("l_name").value;
    let User_email = document.getElementById("user_email").value;
    let User_role = document.getElementById("user_role").value;

    //we want to send the user/pass as JSON, so we need a JS object to send
    let register = {
        username: Username,
        password: Password,
        f_name: F_name,
        l_name: L_name,
        user_email: User_email,
        user_role: User_role
    }
    //This object will reflect our DTO in Java... This is the data we want to transfer!

    console.log(register)

    //fetch request to the server
    //remember the second parameter fetch can take? It's essentially for configuring our fetch request
    //fetch sends a GET by default, but this seconds parameter can change that and more!
    let response = await fetch(url + "user", {

        method: "POST", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(register), //turn our user object into JSON
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back
    });

    console.log(response.status); //userful for debug :)

    


}
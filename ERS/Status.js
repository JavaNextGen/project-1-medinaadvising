const url = "http://localhost:3000/" //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in our fetch requests and make calls to our server by appending endpoints
document.getElementById("reimb_id").innerHTML = id;
//add eventListeners to our buttons to give them functionality
document.getElementById("getStatusButton").addEventListener("click", statusFunction);
//login button listener goes here
async function statusFunction(id) {

    //gather the user inputs from the login inputs
    let Reimb_status = document.getElementById("reimb_status").value;
    let Reimb_id = document.getElementById("reimb_id").value;
    
    

    //we want to send the user/pass as JSON, so we need a JS object to send
    let status = {
        reimb_status: Reimb_status,
        reimb_id: Reimb_id
    }
    //This object will reflect our DTO in Java... This is the data we want to transfer!

    console.log(status)

    //fetch request to the server
    //remember the second parameter fetch can take? It's essentially for configuring our fetch request
    //fetch sends a GET by default, but this seconds parameter can change that and more!
    
    let response = await fetch(url + "reimbursement/" + id, {

        method: 'PUT', //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(status), //turn our user object into JSON
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back
    });

    console.log(response.status); //userful for debug :)

    


}
//remember, async returns a promise (which fetch request return)

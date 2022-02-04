const url = "http://localhost:3000/";

document.getElementById("reimbButton").addEventListener("click", registerFunction);

async function registerFunction() {

    //gather the user inputs from the login inputs
    let Reimb_author = document.getElementById("reimb_author").value;
    let Reimb_amount = document.getElementById("reimb_amount").value;
    let Reimb_submitted = document.getElementById("reimb_submitted").value;
    let Reimb_description = document.getElementById("reimb_description").value;
    let Reimb_receipt = document.getElementById("reimb_receipt").value;
    let Reimb_type = document.getElementById("reimb_type").value;
    let Reimb_status = document.getElementById("reimb_status").value;

    //we want to send the user/pass as JSON, so we need a JS object to send
    let reimbursement = {
        reimb_author: Reimb_author,
        reimb_amount: Reimb_amount,
        reimb_submitted: Reimb_submitted,
        reimb_description: Reimb_description,
        reimb_receipt: Reimb_receipt,
        reimb_type: Reimb_type,
        reimb_status: Reimb_status
    }
    //This object will reflect our DTO in Java... This is the data we want to transfer!

    console.log(reimbursement)

    //fetch request to the server
    //remember the second parameter fetch can take? It's essentially for configuring our fetch request
    //fetch sends a GET by default, but this seconds parameter can change that and more!
    let response = await fetch(url + "reimbursement", {

        method: "POST", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(reimbursement), //turn our user object into JSON
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back
    });

    console.log(response.status); //userful for debug :)

    


}
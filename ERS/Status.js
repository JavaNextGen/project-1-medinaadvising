const url = "http://localhost:3000/"; //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in our fetch requests and make calls to our server by appending endpoints
//console.log("hello");
document.getElementById("statusButton").addEventListener("click", statusFunction);
//console.log("hello");

async function statusFunction() {
    let reimb_status = document.getElementById("reimb_status").value;
    let reimb_id = document.getElementById("reimb_id").value;

    //we want to send the user/pass as JSON, so we need a JS object to send
    let stat = {
        reimb_status: reimb_status,
        reimb_id: reimb_id
    };
    let id = document.getElementById("reimb_id").value;
    let response = await fetch(url + "reimbursement/" + id, {

        method: "PUT", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(stat), //turn our user object into JSON
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back
    }).then(response => {
        return response.json()
    }).then(data =>
        // this is the data we get after putting our data,
        console.log(data)
    );

}
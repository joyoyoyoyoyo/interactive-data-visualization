const helloMsg = "Welcome to your first Play-D3 application!";

if (window.console) {
    console.log(helloMsg);
}

// document.addEventListener("DOMContentLoaded", function(){
//     //....
// });

function appendFromD3() {
    console.log(helloMsg);
    d3.select(".container").append("p").text(helloMsg);

}

window.onload = appendFromD3;


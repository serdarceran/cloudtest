// division.js (package-1)
// @import multiplication.js
function divide(i, j) {
    var result = i/j;
    var verify = multiplicate(result, j);
    if(verify == i) {
        console.log("No remaining after divide")
    } else {
        console.log((i-verify) + " is remained after divide");
    }
    return result;
}

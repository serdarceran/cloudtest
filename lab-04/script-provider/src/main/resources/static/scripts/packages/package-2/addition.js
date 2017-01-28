// addition.js (package-2)
// @import subtraction.js
function add(i, j) {
    var result = i+j;
    var subresult = subtract(i,j);
    if(result === subresult) {
        console.log("Some of parameter is zero!");
    }
    return result;
}

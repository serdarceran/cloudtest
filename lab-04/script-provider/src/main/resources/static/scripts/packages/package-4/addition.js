// addition.js (package-4)
// @import subtraction.js
function add(i, j) {
    var result = i+j;
    var subresult = subtract(i,j);
    if(result === subresult) {
        console.log("Some of parameters is zero!");
    } else if(result < subresult){
        console.log("Some of parameters is negative")
    }
    return result;
}

// multiplication.js (package-3)
// @import addition.js
function multiplicate(i, j) {
    var result = 0;
    for(var c=0;c<j;c++) { // use j instead of i
        result = add(result,i);
    }
    return result;
}

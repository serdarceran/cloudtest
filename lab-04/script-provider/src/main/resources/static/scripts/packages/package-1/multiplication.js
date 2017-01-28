// multiplication.js (package-1)
// @import addition.js
function multiplicate(i, j) {
    var result = 0;
    for(var c=0;c<i;c++) {
        result = add(result,j);
    }
    return result;
}

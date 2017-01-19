

var myApp = angular.module("myApp", []);

myApp.controller("mainController", ['$scope','$http', function($scope, $http) {

    $scope.login = function() {
        $http({
            method : "GET",
            url : "/login?username=serdar&password=serdar"
        }).then(function mySuccess(response) {
            console.log("http get result: "  +  response.data.tokenKey)
            $scope.loginResult = response.data.tokenKey;
        }, function myError(response) {
            $scope.loginResult = response.statusText;
        });
    }
    
    $scope.sendMessage = function() {
    	var requestData = {  message: $scope.ask };
    	$http.post("/secure/hello/message", requestData, {
	        headers: { 'Authorization': 'Bearer ' + $scope.loginResult}
	    }).success(function(responseData) {
	    	$scope.messageResult = responseData.content;
	    });
    }
}]);
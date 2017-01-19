

var myApp = angular.module("myApp", []);

myApp.controller("mainController", ['$scope', '$filter','$timeout','$http', function($scope, $filter, $timeout, $http) {
    $scope.twHandle = '';
    $scope.characters = 5;
                                    
    $scope.lowercaseHandle = function() {
        return $filter('lowercase')($scope.twHandle);
    }
    
    $scope.lowercaseHandle2 = $filter('lowercase')($scope.twHandle);
    
    $scope.$watch('twHandle', function(newValue, oldValue) {
        console.log('old value:' + oldValue)
        console.log('new value:' + newValue);
        
    });
    
    $scope.rules = [
         { rulename: "Must be 5 characters"}
        ,{ rulename: "Must be unique"}
        ,{ rulename: "Must be cool"}
    ];
    
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
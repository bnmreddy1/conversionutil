var testApp = angular.module("unitConversionApp", []);

testApp.controller("unitConversionController", function($scope, $http) {


    $scope.history = [];

  $scope.getData = function (inputObject) {
	  $http.post("http://localhost:8080/api/validate/conversion",
      inputObject
    ).then(
      function successCallback(response) {
        //$scope.calculatedOutput = response.data.result;
        inputObject.output=response.data.result;
        $scope.history.push(angular.copy(inputObject));
        console.log($scope.history);
      },
      function errorCallback(response) {
        console.log("Unable to perform get request");
      }
    );
	};
  $scope.getUnitMesures =function (){
      $http.get("http://localhost:8080/api/conversionUnits").then(
          function successCallback(response) {
              console.log(response)
              $scope.unitList=response.data;
          }
      )
    }
});

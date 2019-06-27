angular.module("acordoCerto").controller("detalhesDividaCtrl", function ($scope, $routeParams, divida) {
	$scope.divida = divida.data;
});
angular.module("acordoCerto").controller("novaDividaCtrl", function ($scope, dividasAPI, $location, devedores) {
	$scope.devedores = devedores.data;

	$scope.adicionarDivida = function (divida) {
		divida.idCredor = 2;
		divida.idDevedor = divida.devedor.id;
		dividasAPI.saveDivida(divida).success(function (data) {
			delete $scope.divida;
			$scope.dividaForm.$setPristine();
			$location.path("/dividas");
		});
	};
});
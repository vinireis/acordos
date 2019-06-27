angular.module("acordoCerto").controller("listaDividasCtrl", function ($scope,$window, dividas, devedores,dividasAPI) {
	$scope.app = "Lista Telefonica";
	$scope.dividas = dividas.data;
	$scope.dividas = $scope.dividas.map(function(divida){
		return divida;
	});
	$scope.devedores = devedores.data;

	$scope.apagarDividas = function (dividas) {
		$scope.dividas = dividas.filter(function (divida) {
			if (divida.selecionado){
				dividasAPI.deleteDivida(divida.id);
			} else{
				return divida;	
			} 
		});
	};
	$scope.isDividaSelecionado = function (dividas) {
		return dividas.some(function (divida) {
			return divida.selecionado;
		});
	};
	$scope.ordenarPor = function (campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};
});
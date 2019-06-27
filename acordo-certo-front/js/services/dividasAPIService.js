angular.module("acordoCerto").factory("dividasAPI", function ($http, config) {
	var _getDividas = function () {
		return $http.get(config.baseUrl + "/dividas");
	};

	var _getDividasCredor = function (id) {
		return $http.get(config.baseUrl + "/dividas/credor/" + id);
	};

	var _getDivida = function (id) {
		return $http.get(config.baseUrl + "/dividas/" + id);
	};

	var _deleteDivida = function (id) {
		return $http.delete(config.baseUrl + "/dividas/" + id);
	};

	var _saveDivida = function (divida) {
		return $http.post(config.baseUrl + "/dividas", divida);
	};

	return {
		getDividasCredor: _getDividasCredor,
		getDividas: _getDividas,
		getDivida: _getDivida,
		deleteDivida: _deleteDivida,
		saveDivida: _saveDivida
	};
});
angular.module("acordoCerto").service("devedoresAPI", function ($http, config) {
	this.getDevedores = function () {
		return $http.get(config.baseUrl + "/devedores");
	};
});
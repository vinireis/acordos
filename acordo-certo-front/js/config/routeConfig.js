angular.module("acordoCerto").config(function ($routeProvider) {
	$routeProvider.when("/dividas", {
		templateUrl: "view/dividas.html",
		controller: "listaDividasCtrl",
		resolve: {
			dividas: function (dividasAPI) {
				return dividasAPI.getDividasCredor(2);
			},
			devedores: function (devedoresAPI) {
				return devedoresAPI.getDevedores();
			}
		}
	});
	$routeProvider.when("/novaDivida", {
		templateUrl: "view/novaDivida.html",
		controller: "novaDividaCtrl",
		resolve: {
			devedores: function (devedoresAPI) {
				return devedoresAPI.getDevedores();
			}
		}
	});
	$routeProvider.when("/detalhesDivida/:id", {
		templateUrl: "view/detalhesDivida.html",
		controller: "detalhesDividaCtrl",
		resolve: {
			divida: function (dividasAPI, $route) {
				return dividasAPI.getDivida($route.current.params.id);
			}
		}
	});
	$routeProvider.when("/error", {
		templateUrl: "view/error.html"
	});
	$routeProvider.otherwise({redirectTo: "/dividas"});
});
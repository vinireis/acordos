angular.module("acordoCerto").directive("uiAlert", function () {
	return {
		templateUrl: "view/alert.html",
		replace: true,
		restrict: "AE",
		scope: {
			title: "@"
		},
		transclude: true
	};
});
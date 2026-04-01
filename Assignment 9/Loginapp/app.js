var app = angular.module('loginApp', ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
        .when('/register', {
            templateUrl: 'views/register.html'
        })
        .when('/login', {
            templateUrl: 'views/login.html'
        })
        .otherwise({
            redirectTo: '/register'
        });
});
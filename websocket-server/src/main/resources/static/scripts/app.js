'use strict';

/**
 * @ngdoc overview
 * @name websocketClientApp
 * @description
 * # websocketClientApp
 *
 * Main module of the application.
 */
angular
  .module('websocketClientApp', [
    'ngCookies',
    'ngResource',
    'ngRoute',
    'cgNotify'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/admin', {
        templateUrl: 'views/admin.html',
        controller: 'AdminCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });

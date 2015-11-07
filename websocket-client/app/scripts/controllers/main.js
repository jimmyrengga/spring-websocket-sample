'use strict';

angular.module('websocketClientApp')
        .controller('MainCtrl', function ($scope) {

            var stompClient = null;

            $scope.connect = function() {
                console.log('username: ' + $scope.username);
                var socket = new SockJS('http://localhost:8080/sample');
                stompClient = Stomp.over(socket);
                stompClient.connect($scope.username, '', function () {
                    console.log('Connected: ' + $scope.username);
                    
                    stompClient.subscribe('/info', function (greeting) {
                        showGreeting(greeting.body);
                    });
                    
                    
                });
            };

        });

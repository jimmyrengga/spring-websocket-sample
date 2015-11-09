'use strict';

angular.module('websocketClientApp')
        .controller('MainCtrl', function ($scope, notify) {

            var stompClient = null;

            $scope.connect = function () {
                console.log('username: ' + $scope.username);
                var socket = new SockJS('http://localhost:8080/sample');
                stompClient = Stomp.over(socket);
                stompClient.connect($scope.username, 'test', function () {
                    console.log('Connected: ' + $scope.username);

                    stompClient.subscribe('/info', function (msg) {
                        $scope.showMessage(msg.body);
                    });
                    
                    stompClient.subscribe('/user/' + $scope.username +'/update', function (msg) {
                        $scope.showPrivateMessage(msg.body);
                    });


                });
            };

            $scope.showMessage = function (str) {
                notify({
                    message: str,
                    classes: 'alert-warning',
                    position: 'right',
                    duration: '20000'
                });
            };
            
            $scope.showPrivateMessage = function (str) {
                notify({
                    message: str,
                    classes: 'alert-warning',
                    position: 'left',
                    duration: '20000'
                });
            };

        });

'use strict';

angular.module('websocketClientApp')
        .controller('AdminCtrl', function ($scope, AdminService) {

            $scope.send = function() {
                AdminService.save($scope.msg).success(function () {
                    console.log("sending message...");
                });
            };

        });

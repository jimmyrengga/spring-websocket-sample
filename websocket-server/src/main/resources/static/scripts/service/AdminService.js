'use strict';

angular.module('websocketClientApp')
        .factory('AdminService', function ($http, $location) {
            var server = $location.protocol() + $location.host() + $location.port();

            return {
                save: function (obj) {
                    return $http.post(server + '/api/message', obj);
                }
            };
        });

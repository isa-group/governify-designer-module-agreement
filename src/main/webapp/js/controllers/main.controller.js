'use strict';
angular.module("module").controller("MainCtrl", function ($scope, $http, $sce) {
    $scope.trustAsHtml = $sce.trustAsHtml;

    // Load Manifest data
    $http.get("manifest").success(function (manifest) {
        if (manifest)
            $scope.manifest = manifest;
    }).catch(function (error) {
        console.log(error.status + " " + error.data);
    });
    
    $http.get("version").success(function (moduleVersion) {
        if (moduleVersion)
            $scope.version = moduleVersion;
    });

});
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
    
    angular.element(document).ready(function () {
        !function (a) {
            a(function () {
                (new WOW).init(), a(".button-collapse").sideNav(), a(".parallax").parallax()
            })
        }(jQuery), $(function () {
            $("a[href*=#]:not([href=#])").click(function () {
                if (location.pathname.replace(/^\//, "") === this.pathname.replace(/^\//, "") && location.hostname === this.hostname) {
                    var a = $(this.hash);
                    if (a = a.length ? a : $("[name=" + this.hash.slice(1) + "]"), a.length)
                        return $("html,body").animate({scrollTop: a.offset().top}, 1e3), !1
                }
            })
        });
    });

});
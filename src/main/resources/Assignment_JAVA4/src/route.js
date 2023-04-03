var myApp = angular.module("myApp",["ngRoute"]);

myApp.config(function($routeProvider , $locationProvider){
    $locationProvider.hashPrefix("");

    $routeProvider
    .otherwise({
        templateUrl  : "./page/trang-chu.html",
        controller: "trangchuCtrl",
    })
    .when("/books",{
        templateUrl : "./page/trang-chu.html",
        controller: "trangchuCtrl",
    })
    
    .when("/update",{
        templateUrl : "./page/sua.html"   
    })
    .when("/chitiet/:id",{
        templateUrl : "./page/chitiet.html"   

    })
    .when("/login",{
        templateUrl : "./page/login.html",
        controller: "trangchuCtrl",
    })
    // .when("/logout",{
    //     templateUrl : "./page/login.html",
    //     controller: "trangchuCtrl",
    // })
})

myApp.controller("trangchuCtrl",trangchuCtrl);
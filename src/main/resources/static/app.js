

app = angular.module('myapp', ['ngRoute']);
app.config(['$routeProvider',function($routeProvider){
    $routeProvider
        .when('/Add',{
            templateUrl: 'Insert.html'})
        .when('/Delete',{
            templateUrl: 'Delete.html'})
        .when('/Display',{
            templateUrl: 'Display.html'})
        .when('/Update',{
            templateUrl: 'update.html'})
        .when('/PurchaseInsert',{
            templateUrl: 'purchaseInsert.html'})
        .when('/PDisplay',{
            templateUrl: 'purchaseDisplay.html'})
        .when('/ProductInsert',{
            templateUrl: 'productionInsert.html'})
        .when('/ProductionDisplay',{
            templateUrl: 'productionDisplay.html'})
        .when('/UserInsert',{
            templateUrl: 'userInsert.html'})
        .when('/RolesDisplay',{
                templateUrl: 'displayUser.html'})
        .otherwise(
            { redirectTo: 'home.html'}
        );
}]);



/**
 * Created by shantanu on 2/8/16.
 */




(function(){

    var app = angular.module("main", []);

    app.controller("listController", ["$http", function($http){
        var self = this;
        self.globalProducts = [];
        self.userList = [];
        self.response = "empty yet..";

        self.loadGlobalList = function(){
            $http.get("/products").
                success(function(data){
                    self.globalProducts = data;
                });
        };
        self.loadGlobalList();


        $http.get("/users/products").success(function(data){
            self.userList = data;
        });

        self.addToUserList = function(product){
            if (-1 === self.userList.indexOf(product)){
                self.userList.push(product);
                $http.post("/users/products/"+product.id);
            }
        };
        self.removeFromUserList = function(product){
            var index = self.userList.indexOf(product);
            self.userList.splice(index, 1);
            $http.delete("/users/products/"+product.id);
        };
        self.addToGlobalList = function(product){
            $http.post
        };
        self.doRequestAboutList = function(){
            $http.get("/users/products").then(
                function success(data) {
                    self.response = data;
                },
                function error(data){
                    self.response = data;
                }
            );
        };

    }]);
    var PanelControllerConstructor = function () {
        this.tab = 1;
        this.selectTab = function (setTab) {
            this.tab = setTab;
        };
        this.isSelected = function (checkTab) {
            return this.tab === checkTab;
        };
    };
    app.controller("PanelController", PanelControllerConstructor);



    app.directive("addProduct", function () {
        return {
            restrict: "E",
            templateUrl: "/directives/add_product"//,
            //controller: "ClinicsController",
            //controllerAs: "clinics"
        };
    });

    app.directive("registration", function () {
        return {
            restrict: "E",
            templateUrl: "/directives/login"//,
            //controller: "ClinicsController",
            //controllerAs: "clinics"
        };
    });
    app.directive("userList", function () {
        return {
            restrict: "E",
            templateUrl: "/directives/userList",
            controller: "listController",
            controllerAs: "listCtrl"
        };
    });
    app.directive("globalList", function () {
        return {
            restrict: "E",
            templateUrl: "/directives/globalList",
            controller: "listController",
            controllerAs: "listCtrl"
        };
    });

})();
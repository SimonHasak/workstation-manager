
var managerModule = angular.module('managerController', []);

managerModule.controller("ManagerController", function($http) {
    var vm = this;

    vm.actualManager = "";
    vm.managers = [];
    vm.managerComputers = [];
    vm.stations = [];
    vm.showComputers = false;
    vm.isIpAddressSelected = false;
    vm.computerRoom = "";

    vm.list = function() {
        $http.get('/managers/getAll').then(function(response) {
            vm.managers = response.data;
        });
    };

    vm.getComputers = function(id,name){
        vm.actualManager = name;
        $http.get('/computers/getAllManagerComputers/'+id)
            .then(function (response) {
                vm.managerComputers = response.data;
                vm.showComputers = true;
                vm.isIpAddressSelected = false;
        });
    };

    vm.getRoom = function(ipAddress) {
        $http.get('/computers/getRoomByIpAddress/'+ipAddress,  {
            method: 'GET',
            transformResponse: function(data, headers) {
                return data;
            }
            }).then(function (response) {
                vm.computerRoom = response.data;
                vm.isIpAddressSelected = true;
                vm.getStations(vm.computerRoom);
        });
    };

    vm.getStations = function(room){
        $http.get('/computers/getAllStationsInTheRoom/'+room)
            .then(function (response) {
                vm.stations = response.data;
        });
    };
});
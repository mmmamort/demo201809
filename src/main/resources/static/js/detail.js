app.controller('detailCtrl', function ($scope, $state, $stateParams, httpService) {
    // $("[name='menu1']").css("color", "#22B0A3");
    httpService.requestPromise('GET', 'ball_history_detail', $stateParams).then(function (data) {
        $scope.historyDetail = data;
    });

    $scope.redirect = function (url) {
        $state.go(url, {pageNumber: $stateParams.pageNumber});
    }
});
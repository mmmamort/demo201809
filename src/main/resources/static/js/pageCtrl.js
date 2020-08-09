app.controller('pageCtrl', function ($scope, $state, $stateParams, httpService) {
    httpService.requestPromise('GET', 'ball_history_page', {pageNumber: $stateParams.pageNumber}).then(function (data) {
        $scope.historyPage = data.content;
        $scope.pageNow = data.number;
        $scope.pages = data;

        let arr = new Array();
        if ($scope.pageNow - 2 < 0) {
            for (let i = 0; i <= 4; i++) {
                arr.push(i + 1);
            }
        } else if ($scope.pages.totalPages - $scope.pageNow > 2) {
            for (let i = $scope.pageNow - 2; i <= $scope.pageNow + 2; i++) {
                arr.push(i + 1);
            }
        } else {
            for (let i = $scope.pages.totalPages - 4; i <= $scope.pages.totalPages - 1; i++) {
                arr.push(i + 1);
            }
        }
        $scope.liArr = arr;
    });

    $scope.redirect = function (url, param) {
        $state.go(url, param);
    }
});
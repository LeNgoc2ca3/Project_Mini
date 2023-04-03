let apiProduct = "http://localhost:8080/product";

let apiAccount = "http://localhost:8080/account";

// $routeParams Lấy đường dẫn trên link

function trangchuCtrl($scope, $http, $rootScope, $location) {


  $scope.listAccount = [];

  $http
    .get(apiAccount)
    .then(function (response) {
      $scope.listAccount = response.data;
    })
    .catch(function (e) {
      console.log(e);
    });

    $scope.listProduct = [];

  $scope.load_all = function () {
    $http
      .get(apiProduct)
      .then(function (response) {
        $scope.listProduct = response.data;
        // console.log(response.data);
      })
      .catch(function (e) {
        console.log(e);
      });
  };

  $scope.dangnhap = function () {
    let check = false;

    for (let i = 0; i < $scope.listAccount.length; i++) {
      if (
        $scope.user === $scope.listAccount[i].username &&
        $scope.listAccount[i].password === $scope.pass
      ) {
        alert("Đăng nhập thành công");
        check = true;
        $rootScope.isAdmin = $scope.listAccount[i].role === 1;
        $rootScope.isUser = $scope.listAccount[i].role === 0;
        $rootScope.AccountName = $scope.user;
        console.log("User: " + $rootScope.AccountName);
        $location.path("/books");
      }
    }
    if (check === false) {
      alert("Đăng nhập thất bại");
      $location.path("/login");
    }
  };

  $scope.logout = function () {
        $rootScope.isAdmin = "";
        $rootScope.isUser = "";
        $rootScope.AccountName = "";
  };


  $scope.product = {
    id: 0, //Là số mặc định là 0 không có dấu nếu thêm thì tự thay đổi
    productName: "",
    price: "",
    quantity: 0,
    createdUser: "",
    createDate: "",
    description: "",
    deleted: false,
    lastModifiedUser: "",
    lastModifiedDate: "",
    shape: "",
    taste: "",
  };

  // console.log($scope.product);

  $scope.onSua = function () {
      $scope.product.lastModifiedUser = $rootScope.AccountName; 
    $http
      .put(apiProduct + "/" + $scope.product.id, $scope.product)
      .then(function () {
        console.log($scope.product);
        $scope.vitriHientai = -1;
        alert("Sửa thành công");
        $scope.load_all();
      })
      .catch(function (e) {
        console.log(e);
      });
  };

  $scope.product1 = {
    id: 0, //Là số mặc định là 0 không có dấu nếu thêm thì tự thay đổi
    productName: "",
    price: "",
    quantity: 0,
    createdUser: $rootScope.AccountName,
    createDate: "",
    description: "",
    deleted: false,
    lastModifiedUser: "",
    lastModifiedDate: "",
    shape: "",
    taste: "",
  };

  $scope.vitriHientai = -1;
  $scope.selectShow = function (index) {
    $http
      .get(apiProduct + "/" + index)
      .then(function (response) {
        $scope.product = response.data;
      })
      .catch(function (e) {
        console.log(e);
      });
  };

  $scope.onSubmit = function () {
    $http
      .post(apiProduct, $scope.product1)
      .then(function () {
        $scope.listProduct.push($scope.product1);
        alert("Thêm thành công");
        $scope.load_all();
      })
      .catch(function (e) {
        console.log(e);
      });
  };

  $scope.onXoa = function (index) {
    // $scope.product.id = index; 
    $http
      .get(apiProduct + "/" + index)
      .then(function (response) {
        $scope.product = response.data;
        console.log($scope.product);
      })
    $http
      .put(apiProduct + "/delete/" + index,$scope.product)
      .then(function () {
        $scope.vitriHientai = -1;
        alert("Xóa thành công");
        $scope.load_all();
      })
      .catch(function (e) {
        console.log(e);
      });
  };

  $scope.load_all();
}

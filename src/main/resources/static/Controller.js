/**
 * Created by shantanu on 2/8/16.
 */

//--------------------------------------------------------------------------------------------------//
//INSERT CONTROLLER OF INVENTORY--------------------------------------------------------------------//


app.controller("Insert", function($scope,$http) {

    $scope.submit = function () {
        console.log("Insert");
        var pName=$scope.pName;
        var unit=$scope.unit;
        var initCount=$scope.initCount;
        var pCount=$scope.pCount;
        var pCost=$scope.pCost;


        var url="http://localhost:8080/create?pName="+pName+"&unit="+unit+"&initCount="+initCount+ "&pCount="+pCount+ "&pCost="+pCost;

        $http.get(url).success(function(response){
            console.log(response);
            $scope.name=response;
            console.log($scope.name);
        });
    }});




//-----------------------------------------------------------------------------------------------------//
//DISPLAY FUNCTION OF INVENTORY------------------------------------------------------------------------//


app.controller("Display", function($scope , $http)
{
    $scope.submit = function () {

        console.log("Display");

        var url = "http://localhost:8080/display";

        $http.get(url).success(function (response) {
            console.log(response);

            if (response.length == 0)
                $scope.name = "Does not Exist";

            else
                $scope.name = response;

            console.log($scope.name);
        });
    }});



//-----------------------------------------------------------------------------------------//
//DELETE CONTROLLER OF INVENTORY -----------------------------------------------------------//



app.controller("Delete", function($scope,$http) {

    var url = "http://localhost:8080/display";

    $http.get(url).success(function (response) {
        console.log(response);

        $scope.menu=response;
        console.log($scope.name);
    });



    $scope.submit = function () {

        console.log("Delete");
        var pName=$scope.menu;
        var url="http://localhost:8080/delete?pName="+pName;
        $http.get(url).success(function(response){
            console.log(response);
            if(response.pName==undefined)
                $scope.name="Does not Exist";

            else
                $scope.name=response+" is deleted";

            console.log($scope.name);
        });
    }});



//------------------------------------------------------------------------------------------------------//
//SEARCH CONTROLLER OF INVENTORY -----------------------------------------------------------------------//


//
//
//app.controller("Search", function($scope,$http) {
//
//    $scope.submit = function () {
//        console.log("Search");
//        var pName=$scope.pName;
//        var url="http://localhost:8080/Search?pName="+pName;
//        $http.get(url).success(function(response){
//            console.log(response);
//            $scope.name=response;
//            console.log($scope.name);
//        });
//    }});
//

//========================================================================================================//

//app.controller("Update", function($scope,$http) {
//
//    $scope.submit = function () {
//        console.log("Update");
//        var pName=$scope.pName;
//        var pCount=$scope.pCount;
//        var url="http://localhost:8080/Update?pName="+pName+"&pCount="+pCount;
//        $http.get(url).success(function(response){
//                console.log(response);
//
//                $scope.name=response;
//                console.log($scope.name);
//
//            })
//
//    }});



//#####################################################################################################//
//INSERT CONTROLLER OF PURCHASE ORDER *****************************************************************//



app.controller("PurchaseInsert", function($scope , $http) {


    var url = "http://localhost:8080/display";

    $http.get(url).success(function (response) {
        console.log(response);

       $scope.menu=response;
        for(var i=0;i<$scope.menu.length;i++) {
            $scope.menu[i] = $scope.menu[i].replace(" ","$");
        }
        console.log($scope.name);
    });

    $scope.table={pname :[] , pquantity:[] , pcost:[]};
    $scope.addFormField = function() {
        $scope.table.pname.push('');
        $scope.table.pquantity.push('');
        $scope.table.pcost.push('');

    }
  $scope.submit = function( ) {

      if($scope.vendorName==undefined||$scope.tax==undefined||$scope.table.pname.length<1)
      {
          $scope.message="fields required by user ";
          window.alert("fields required");

      }

      else {

          var flag = 0;

          for (var i = 0; i < $scope.table.pname.length; i++) {
              if ($scope.table.pname[i] == "" || $scope.table.pname[i] == null ||
                  $scope.table.pquantity[i] == "" || $scope.table.pquantity[i] == null ||
                  $scope.table.pcost[i] == "" || $scope.table.pcost[i] == null) {
                  flag = 1;

              }
          }

          if (flag == 1) {
              $scope.message = "all fields required";
              window.alert("fields required");
          }
          else {
              console.log("Insert");
              var vendorName = $scope.vendorName;
              var tax = $scope.tax;
              var prodCost = 0;
              var field = [];


              for (var i = 0; i < $scope.table.pname.length; i++) {
                  field[i] = {
                      "pName":$scope.table.pname[i],
                      "pCount":$scope.table.pquantity[i],
                      "pCost":$scope.table.pcost[i]
                  }
              }
              for (var i = 0; i < $scope.table.pname.length; i++) {
                  prodCost += $scope.table.pcost[i] * $scope.table.pquantity[i];
                  console.log("hello");
              }
              var net = (tax / 100) * prodCost + prodCost;


              var datas = {
                  "vendorName": vendorName,
                  "tax": tax,
                  "purchases": field,
                  "purchaseCost": prodCost,
                  "totalCost": net
              }
              console.log(datas);

              console.log($scope.table);


              var url = "http://localhost:8080/purchaseinsert";
              $http({
                  url: url,
                  data: datas,
                  dataType: 'json',
                  method: 'POST',
                  headers: {
                      "Content-Type": "application/json"
                  }
              });

          }}
}});



//---------------------------------------------------------------------------------------------------------//
//DISPLAY CONTROLLER OF PURCHASE ORDER---------------------------------------------------------------------//


app.controller("PDisplay", function($scope , $http)
{
    $scope.submit = function () {

        console.log("Display");

        var url = "http://localhost:8080/purchasedisplay";

        $http.get(url).success(function (response) {
            console.log(response);

            if (response.length == 0)
                $scope.name = "Does not Exist";

            else
                $scope.name = response;

            console.log($scope.name);
        });
    }});



//--------------------------------------------------------------------------------------------------------//
//INSERT CONTROLLER OF PRODUCTION ---------------------------------------------------------------------------//



app.controller("ProductInsert", function($scope , $http) {


    var url = "http://localhost:8080/display";

    $http.get(url).success(function (response) {
        console.log(response);

        $scope.menu=response;

        console.log($scope.name);
    });



    $scope.raw={pname :[] , pquantity:[] };
    $scope.addFormField = function() {
        $scope.raw.pname.push('');
        $scope.raw.pquantity.push('');

    }
    $scope.submit = function( ) {

        if($scope.productName==undefined ||$scope.productionQuantity==undefined||$scope.raw.pname.length<1)
        {
            $scope.message="all fields required ";
            window.alert("fields required");
        }
        else {

            var flag=0;

            for( var i =0;i<$scope.raw.pname.length;i++){

    if($scope.raw.pname[i]=="" || $scope.raw.pname[i]==null ||$scope.raw.pquantity[i]=="" || $scope.raw.pquantity[i]==null )
    {  flag=1; }


}
            if(flag==1) {
                $scope.message = "all fields required ";
                window.alert("field required");
            }
else{
                console.log("Insert");
                var productName = $scope.productName;
                var productionQuantity = $scope.productionQuantity;
                var field = [];

                for (var i = 0; i < $scope.raw.pname.length; i++) {
                    field[i] = {
                        "pName": $scope.raw.pname[i],
                        "pCount": $scope.raw.pquantity[i],

                    }
                }

            var productionData = {"productName":productName,"productionQuantity":productionQuantity ,  "raws":field }
            console.log(productionData);

            //console.log($scope.raw);



            var url="http://localhost:8080/productioninsert" ;
            $http({
                url: url,
                data: productionData,
                dataType: 'json',
                method: 'POST',
                headers: {
                    "Content-Type": "application/json"
                }
            });

        }}

            }});


//-------------------------------------------------------------------------------------------------------//
//DISPLAY CONTROLLER OF PRODUCTION -----------------------------------------------------------------------//



app.controller("ProductionDisplay", function($scope , $http)
{
    $scope.submit = function () {

        console.log("Display");

        var url = "http://localhost:8080/productiondisplay";

        $http.get(url).success(function (response) {
            console.log(response);

            if (response.length == 0)
                $scope.name = "Does not Exist";

            else
                $scope.name = response;

            console.log($scope.name);
        });
    }});




//========================================================================================================//
//========================================================================================================//
//USER ROLES INSERT ===================================================================================//






app.controller("UserInsert", function($scope , $http) {


    $scope.submit = function( ) {

        if($scope.username==undefined||$scope.password==undefined||$scope.roles==undefined)
        {
            $scope.message="fields required by user ";
            window.alert("fields required");

        }

        else {

                console.log("UserInsert");
                var username = $scope.username;
                var password = $scope.password;
                var roles = $scope.roles;

                var datauser ={
                    "username":username,
                    "password":password,
                    "roles": roles
                }

            console.log(datauser);

  $scope.username=$scope.password=$scope.roles="";
                var url = "http://localhost:8080/userinsert";
                $http({
                    url: url,
                    data: datauser,
                    dataType: 'json',
                    method: 'POST',
                    headers: {
                        "Content-Type": "application/json"
                    }
                });
window.alert("submitted");
            }}
    });
//========================================================================================================//




app.controller("RolesDisplay", function($scope , $http)
{
    $scope.submit = function () {

        console.log("Display");

        var url = "http://localhost:8080/displayroles";

        $http.get(url).success(function (response) {
            console.log(response);

            if (response.length == 0)
                $scope.role= "Does not Exist";

            else
                $scope.role = response;

            console.log($scope.role);
        });
    }});




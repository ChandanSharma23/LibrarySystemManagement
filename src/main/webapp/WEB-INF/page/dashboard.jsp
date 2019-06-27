<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script> var contextPath = "${pageContext.request.contextPath}/"</script>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>

<script src="https://npmcdn.com/vue-router/dist/vue-router.js"></script>
<script src="<c:url value="/resources/loadVueComponent.js"/>"></script>
<script src="<c:url value="/resources/vuetils.js"/>"></script>
<script src="<c:url value="/resources/api.js"/>"></script>
    <script>var user = ${user};</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        body {font-family: Arial;}

        /* Style the tab */
        .tab {
            overflow: hidden;
            border: 1px solid #ccc;
            background-color: #f1f1f1;
        }

        /* Style the buttons inside the tab */
        .tab button {
            background-color: inherit;
            float: left;
            border: none;
            outline: none;
            cursor: pointer;
            padding: 14px 16px;
            transition: 0.3s;
            font-size: 17px;
        }

        /* Change background color of buttons on hover */
        .tab button:hover {
            background-color: #ddd;
        }

        /* Create an active/current tablink class */
        .tab button.active {
            background-color: #ccc;
        }

        /* Style the tab content */
        .tabcontent {
            display: none;
            padding: 6px 12px;
            border: 1px solid #ccc;
            border-top: none;
        }
    </style>
</head>
<body bgcolor="#efefef">


    <nav class="navbar navbar-light bg-light justify-content-between" style="background-color: #e3f2fd;">
        <!-- Navbar content -->
        <p class="navbar-brand"> Welcome to e-Library Service Portal</p>
        <button class=" navbar-brand btn btn-primary my-2 my-sm-0" style="float: right;" @click="location.href='${pageContext.request.contextPath}/logout'" >Logout</button>
    </nav>



<div class="main">
<div class="tab">
    <button class="tablinks" @click="switchUI('User')" >User</button>
    <button class="tablinks" @click="switchUI('borrow')" target=>Borrow</button>
    <button class="tablinks" @click="switchUI('admin')" >add or delete books</button>
    <button class="tablinks" @click="switchUI('issue')" >Issue Request</button>
    <button class="tablinks" @click="switchUI('return')" >return Request</button>
</div>
<div style="margin-top: 50px; top: 30px  !important;">
s
<router-view></router-view>

</div>

<script>

Vue.config.devtools = true
Vue.use(Vuetils);
loadVueComponent("admin")
      var app = new Vue({
			el: ".main",

			router: new VueRouter({
					routes: [{
						name: 'borrow',
						path: '/borrow',
						component: loadVueComponent("borrow")
						},
						{
							name: 'admin',
							path: '/books',
							component: loadVueComponent("admin")
						},
						{
							name: 'User',
							path: '/',
							component: loadVueComponent("User")
							},
						{
							name: 'issue',
							path: '/issue',
							component: loadVueComponent("issue")
						},
						{
							name: 'return',
							path: '/return',
							component: loadVueComponent("return")
						}

					]
			}),
			methods: {
				switchUI: function(whichUI) {
					this.$router.push({name: whichUI});
				}
			}
              })

      
      </script>
      
 </body>
</html>
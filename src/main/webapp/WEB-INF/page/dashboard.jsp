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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body bgcolor="#efefef">

<h3>Welcome to our elibrary</h3>


<div class="main">
<div>
<button @click="switchUI('borrow')" target=>Borrow</button>
<button @click="location.href='${pageContext.request.contextPath}/logout'" >Logout</button>
<button @click="switchUI('admin')" >add or delete books</button>
</div>
<div style="margin-top: 50px; top: 30px  !important;">

<router-view></router-view>  
</div>

<script>
Vue.config.devtools = true
Vue.use(Vuetils);
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
						}
					]
			}),
			methods: {
				switchUI: function(whichUI) {
					debugger
					this.$router.push({name: whichUI});
				}
			}

              })
      
      </script>
      
 </body>
</html>
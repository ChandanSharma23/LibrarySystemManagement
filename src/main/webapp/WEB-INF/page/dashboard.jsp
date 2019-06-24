<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="63DBDA">
<script> var contextPath = "${pageContext.request.contextPath}/"</script>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>

<script src="https://npmcdn.com/vue-router/dist/vue-router.js"></script>
<script src="<c:url value="/resources/loadVueComponent.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<h3>Welcome to our elibrary</h3>


<div class="main">
<button @click="switchUI('dashboard')" target=>Borrow</button>
<button @click="location.href='${pageContext.request.contextPath}/logout'" target=>Logout</button>
<router-view></router-view>  
</div>


<script>
      var app = new Vue({
			el: ".main",
			router: new VueRouter({
					routes: [{
						name: 'dashboard',
						path: '/borrow',
						component: loadVueComponent("dashboard")
						}]
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
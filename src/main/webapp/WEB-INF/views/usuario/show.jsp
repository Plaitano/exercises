<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="background: #48762A;">
<div class="chamada row">
		
			<div class="twelve columns">
				<h3 style="color:white;">Detalhes do usu&aacute;rio</h3>
			</div>
		
</div>
</div>
<div class="row">
	<h4>La fessa di mammeta</h4>
</div>
<br/>
<div class="row">
	<div class="two columns"><b>Avatar:</b></div>
	<div class="ten columns"><img style="width:128px;" src='<c:url value="/user/avatar/${user.login}"/>'/></div>
</div>

<div class="row">
	<div class="two columns"><b>Nome:</b></div>
	<div class="ten columns">${user.name}</div>
</div>
<br/>
<div class="row">
	<div class="two columns"><b>Login:</b></div>
	<div class="ten columns">${user.login}</div>
</div>
<br/>
<div class="row">
	<div class="two columns"><b>E-mail:</b></div>
	<div class="ten columns"><a href="mailto:${user.email}">${user.email}</a></div>
</div>
<br/>
<div class="row">
	<h4>&Uacute;ltimos posts</h4>
	
	<div id="youtubeDiv"></div>

	<script>ytEmbed.init({'block':'youtubeDiv','type':'search','q':'baby laughing','results':'4','meta':'true'});</script>
	
	<form onsubmit="ytEmbed.init({'block':'youtubeDiv','type':'search','q':document.getElementById('ytSearchField').value,'results': 5,'meta':true}); return false;">
 	 	<input type="text" id="ytSearchField">  
 	 	<input type="submit" value="  Search   ">
	</form>
	
	<a href="javascript:exporPosts('${user.login}')">Expor posts</a>
	<div id="posts"></div>
</div>

<script type="text/javascript">
	function exporPosts(login) {
		var url = "<c:url value="/user/posts/"/>" + login
		$("#posts").load(url)
	}
</script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>Cadastro de Estagiario</title>
</head>

<body>
	<s:actionerror/>
	<s:actionmessage/>
	<s:form action="editar" method="post">
<!-- EDITAR  -->
 <div id="editardiv">
	<h2>Edição de Estagiario</h2>
	<table class="editatabela" align="center">
		<tr>
			<td><s:textfield label="Id" name="pessoa.id"/></td>	
			<td><s:textfield label="Nome" name="pessoa.nome"/></td>	
			<td><s:textfield label="CPF" name="pessoa.cpf"/></td>
			<td><s:textfield label="Nota" name="pessoa.nota"/></td>			
		</tr>
	</table>
	<br>	
	</div>	
<div id="botaoed">
	<s:submit value="Editar" align="left"></s:submit>
</div>
<!-- LISTANDO ITENS -->
<div id="listardiv">
	<table width="900" cellspacing="0" align="center">
		<tr>
			<th>Nome</th>
			<th>CPF</th>
			<th>Nota</th>
		</tr>	
		</br>	
		<s:iterator value="lista">
			<tr>
				<td align="center"><s:property value="nome"/></td>
				<td align="center"><s:property value="cpf"/></td>
				<td align="center"><s:property value="nota"/></td>			
			</tr>
		</s:iterator>	
	</table>
	</div>
	<br>
	</s:form>
</body>
</html>
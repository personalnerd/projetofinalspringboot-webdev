<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Locadora Spring Boot - Relatório de Funcionários</title>
</head>
<body class="text-light">
    <div class="conteudo mx-auto">
        <h1 class="bg-dark rounded my-3 p-3 fs-3 text-center">Locadora Spring Boot</h1>        
        <div class="d-grid gap-2">
            <a class="btn btn-primary" href="/home">Home</a>            
        </div>
        <hr class="bg-secondary">
        <h2 class="mb-3">Funcionários/Usuários Cadastrados</h2>
        <table class="table table-dark">
          <thead>
            <tr>
              <th scope="col">id</th>
              <th scope="col">Nome</th>
              <th scope="col">Telefone</th>
              <th scope="col">Login</th>
              <th scope="col">Senha</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${usuarios}" var="usuario">
              <tr>
                  <td scope="row">${usuario.id}</td>
                  <td>${usuario.nome}</td>
                  <td>${usuario.telefone}</td>
                  <td>${usuario.login}</td>
                  <td>${usuario.senha}</td>
              </tr>
          </c:forEach>
          </tbody>
        </table>
        <hr class="bg-secondary">
        <div class="d-grid gap-2">
          <a class="btn btn-success" href="/usuario/cadastrar">Cadastrar Funcionário/Usuário</a>
      </div>
    </div>    
</body>
</html>
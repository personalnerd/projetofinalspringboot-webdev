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
    <title>Locadora Spring Boot - Veículo Cadastrado</title>
</head>
<body class="text-light">
    <div class="conteudo mx-auto">
        <h1 class="bg-dark rounded my-3 p-3 fs-3 text-center">Locadora Spring Boot</h1>        
        <div class="d-grid gap-2">
            <a class="btn btn-primary" href="/home">Home</a>            
        </div>
        <hr class="bg-secondary">
        <p>Veículo cadastrado com sucesso!</p>
        <p>
          Modelo: <b><c:out value="${sessionScope.ultimoVeiculoCadastrado.get(0)}" /></b><br>
          Marca: <b><c:out value="${sessionScope.ultimoVeiculoCadastrado.get(1)}" /></b><br>
          Ano: <b><c:out value="${sessionScope.ultimoVeiculoCadastrado.get(2)}" /></b><br>
          Cor: <b><c:out value="${sessionScope.ultimoVeiculoCadastrado.get(3)}" /></b>
        </p>        
        <hr class="bg-secondary">
        <div class="d-grid gap-2">
          <a class="btn btn-success" href="/veiculo/cadastrar">Cadastrar outro veículo</a>
          <a class="btn btn-warning" href="/veiculo/relatorio">Relatório de Veículos</a>
      </div>
    </div>    
</body>
</html>
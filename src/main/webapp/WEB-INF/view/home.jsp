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
    <title>Locadora Spring Boot</title>
</head>
<body class="text-light">
    <div class="conteudo mx-auto">
        <h1 class="bg-dark rounded my-3 p-3 fs-3 text-center">Locadora Spring Boot</h1>
        <p class="text-center">Usuário logado: <b class="text-warning"><c:out value="${sessionScope.usuarioLogado}" /></b></p>        
        <hr class="bg-secondary">
        <div class="d-grid gap-2">
            <a class="btn btn-success" href="/cliente/cadastrar">Cadastrar Cliente</a>
            <a class="btn btn-success" href="/veiculo/cadastrar">Cadastrar Veículo</a>
            <a class="btn btn-success" href="/usuario/cadastrar">Cadastrar Funcionário</a>
        </div>
        <hr class="bg-secondary">
        <div class="d-grid gap-2">
            <a class="btn btn-info" href="/veiculo/alugar">Alugar Veículo</a>
            <a class="btn btn-info disabled" href="/veiculo/devolver">Devolver Veículo</a>
        </div>
        <hr class="bg-secondary">
        <div class="d-grid gap-2">
            <a class="btn btn-warning" href="/cliente/relatorio">Relatório de Clientes</a>
            <a class="btn btn-warning" href="/veiculo/relatorio">Relatório de Veículos</a>            
            <a class="btn btn-warning" href="/usuario/relatorio">Relatório de Funcionários</a>            
            <a class="btn btn-warning disabled" href="/veiculo/relatorio">Relatório de Locações</a>            
        </div>
        <hr class="bg-secondary">        
        <div class="d-grid gap-2">
            <a class="btn btn-danger" href="/logout">Logout</a>
        </div>

        <small class="d-block mt-4 text-muted">
            Infelizmente não foi possível finalizar Devolução de Veículos e Relatório de Locações.
          </small>
    </div>    
</body>
</html>
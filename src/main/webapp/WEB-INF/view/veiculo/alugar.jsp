<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
        crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Locadora Spring Boot - Alugar Veículo</title>
</head>

<body class="text-light">
    <div class="conteudo mx-auto">
        <h1 class="bg-dark rounded my-3 p-3 fs-3 text-center">Locadora Spring Boot</h1>
        <div class="d-grid gap-2">
            <a class="btn btn-primary" href="/home">Home</a>
        </div>
        <hr class="bg-secondary">
        <form method="post" action="/veiculo/alugado">
            <h2 class="mb-3">Alugar Veículo</h2>
            <div class="mb-3">
                <label for="cliente" class="form-label d-flex">
                    Selecione o cliente
                    <a class="btn badge bg-success ms-auto" href="/cliente/cadastrar">Cadastrar cliente</a>
                </label>
                <select name="cliente" class="form-select" required>
                    <option selected disabled></option>
                    <c:forEach items="${clientes}" var="cliente">
                        <option value="${cliente.id}">${cliente.nome}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="veiculo" class="form-label d-flex">
                    Selecione o veículo
                    <a class="btn badge bg-success ms-auto" href="/veiculo/cadastrar">Cadastrar veículo</a>
                </label>
                <select name="veiculo" class="form-select" required>
                    <option selected disabled></option>
                    <c:forEach items="${veiculos}" var="veiculo">
                        <option value="${veiculo.id}">${veiculo.fabricante} ${veiculo.modelo} (${veiculo.ano} ${veiculo.cor})</option>
                    </c:forEach>
                </select>
            </div>
            <hr class="bg-secondary">     
            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-success">Alugar veículo</button>
            </div>
        </form>
    </div>
</body>

</html>
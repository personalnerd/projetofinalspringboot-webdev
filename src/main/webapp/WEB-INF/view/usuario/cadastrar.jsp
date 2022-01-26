<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Locadora Spring Boot - Cadastrar Funcionário</title>
</head>

<body class="text-light">
    <div class="conteudo mx-auto">
        <h1 class="bg-dark rounded my-3 p-3 fs-3 text-center">Locadora Spring Boot</h1>
        <div class="d-grid gap-2">
            <a class="btn btn-primary" href="/home">Home</a>
        </div>
        <hr class="bg-secondary">
        <form method="post" action="/usuario/cadastrado">
            <h2 class="mb-3">Cadastrar Funcionário</h2>
            <div class="mb-3">
                <input type="text" class="form-control" name="nome" placeholder="Nome Completo" required>
            </div>
            <div class="mb-3">
                <input type="text" class="form-control" name="telefone" placeholder="Telefone" required>
            </div>
            <div class="mb-3">
                <input type="text" class="form-control" name="login" placeholder="Login" required>
            </div>
            <div class="mb-3">
                <input type="password" class="form-control" name="senha" placeholder="Senha" required>
            </div>
            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-success">Cadastrar Funcionário</button>
            </div>
        </form>        
    </div>
</body>

</html>
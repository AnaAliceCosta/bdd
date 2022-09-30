# language: pt

  Funcionalidade: Gerenciar cadastro de usuario

    Cenário: Criação de novo usuário
      Dado um usuário não cadastrado
      Quando realizo o cadastramento do usuário
      Então o usuário é registrado com sucesso
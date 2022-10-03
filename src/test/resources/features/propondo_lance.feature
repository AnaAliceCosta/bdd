#language:pt
Funcionalidade: Testes de leilao

  Cenario: Propondo varios lances validos em um mesmo leilao
    Dados um lace de 10.0 reais do usuario "Fulano"
    E um lace de 15.0 reais do usuario "Beltrano"
    Quando popoe varios lances
    Entao os lances sao aceitos


  Cenario: Propondo varios lances validos usndo dataTable
    Dado os lances abaixo
    | valor | usuario |
    | 10.0  | fuladno |
    | 15.0  | beltrano|
    | 30.0  | fulano  |
    Quando popoe varios lances
    Entao os lances sao aceitos

  Esquema do Cenario: Propondo varios lances validos em leiloes diferentes
    Dado um lace de <valor> reais do usuario '<usuario>'
    Quando propoe um lance
    Entao o lance é aceito
    Cenarios:
    |valor|usuario |
    |10.0 | fulano |
    |15.0 | fulano |
    |50.0 | fulano |

  Esquema do Cenario: Propondo varios lances invalidos em leiloes diferentes
    Dado um lace de <valor> reais do usuario '<usuario>'
    Quando propoe um lance
    Entao o lance não é aceito
    Cenarios:
      |valor|usuario |
      |0.0  | fulano |
      |-1.0 | fulano |





# TrabalhoDispositivosMoveis
## Nome: Lucas Ulbrecht Patrizi

#### Sorv Sorbet

  A sorveteria sorv sorbet, fez uma requisição ao grupo G6, é uma aplicação simples de gerenciamento de usuários, pedidos e estoque. Com a aplicação a sorbet, podera cadastrar e coordenar suas diversas variaveis num unico ambiente de facil acesso, e os clientes de fora poderão encontrar mais facilmente as multiplas sorveterias dos franqueados sorbet. Assim ajudando tanto em marketing quanto nas tarefas administrativas da empresa;

##### Usuários

  Pessoa: Nível maximo e mais abstrato de usuário, este representa qualquer pessoa que vá acessar o sistema, é referente a qualquer um que quer ter um acesso sem um cadastro amplo de informações, apenas tera acesso as localidades dos franqueados;
  Funcionario: Este podera acessar um nível mais interno, podera controlar pedidos, mesas de seus franqueados, e por fim pode ver informações do estoque;
  Administrador: Esse usuário podera gerenciar, estoque, usuários e todas as coisas que um funcionario gerencia;


### Requisitos funcionais


##### Lançamentos diversos:

  O sistema deve permitir a inclusão, alteração e remoção de sorvetes, com os seguintes atributos: código do produto, nome do produto, tipo do sorvete, valor do sorvete, foto do sorvete e quantidade em estoque.
  O sistema deve permitir a inclusão, alteração e remoção de pessoa, com os seguintes atributos: CPF, nome, endereço, cidade, estado, telefone, foto do usuário, local e e-mail. 
  O sistema deve permitir a inclusão, alteração e remoção de funcionário, com os seguintes atributos: CPF, nome, endereço, cidade, estado, telefone, salário, foto do usuário, local e e-mail. 
  O sistema deve permitir a inclusão, alteração e remoção de acompanhamentos, com os seguintes atributos: código do produto, nome do produto, tipo de acompanhamento, quantidade em estoque, e foto do acompanhamento.
  O sistema deve aguardar histórico de alterações ao longo do tempo para acompanhamentos e sorvetes, numa tabela log, contendo alterações e data de alterações do produto.


##### Controle e nível de acesso:

  O sistema deve exigir que os funcionários façam login.
  Somente o administrador pode realizar a inclusão, alteração e exclusão de funcionários usuários do sistema, bem como delegar a permissão de administrador a outro funcionário.
  O sistema deve permitir que somente o funcionário e o administrador façam a inclusão e alteração de sorvetes e acompanhamentos.
  O sistema deve permitir que somente o administrador faça a inclusão, alteração e exclusão de funcionários.


### Requisitos não-funcionais

###### Recursos:
  Para o gerenciamento de dados no sistema deve ser usado o RoomDataBase.
  O sistema deve ter acesso de camera.
  O sistema deve ter uso de lists, para listagem de informações num banco de dados.

###### Desempenho:
  O sistema deve salvar as informações no banco de dados imediatamente após a conclusão dos cadastros. O tempo limite deve ser de 15s. Após esse tempo, o sistema informa ao usuário que não foi possível estabelecer a conexão com o banco de dados.
  O sistema deve permitir o acesso simultâneo de até 5 funcionários conectados a uma rede local.


###### Confiabilidade:
  O sistema deve ter capacidade para recuperar os dados perdidos da última operação que realizou em caso de falha.
  O sistema deve fornecer facilidades para a realização de backups dos dados.


###### Segurança: 
  Todas as senhas do sistema devem ser criptografadas. 
  O sistema de acesso e controle de senhas deve ser fortemente seguro. 
  O sistema deve operar apenas na rede interna onde ele está sendo executado.  
  O sistema deve diferenciar as permissões de acesso e identificação para diferentes tipos de usuários: administrador do sistema e funcionários que têm acesso ao sistema.
  O sistema deve emitir uma mensagem de erro em caso de acesso não autorizado ou falta de permissão para realizar ações.


###### Manutenibilidade: 
  O sistema deve ser implantado em módulos, permitindo a adição, exclusão ou alteração de partes do sistema sem afetar o seu funcionamento total. 


###### Portabilidade:
  O sistema deve ser capaz de armazenar os dados em base de dados.

# Sobre o teste

O objetivo é criar um fomulário de cadastro aleatório para armazenar as informações digitadas na tela num banco de dados. 

Para este projeto, utilize Spring Boot e, para persistência de dados, Spring Data e Hibernate.

Ao finalizar, faça commit e envie o link do seu repositório para o email: italo.souza@acordocerto.com.br.

# Dicas

1) Dê um fork neste projeto, clone e importe no IntelliJ, Eclipse ou IDE de preferência;

2) Crie 2 módulos Maven com os seguintes nomes:
  - acordo-certo-test-service (jar)
  - acordo-certo-test-web (war)
  
Estes módulos deverão ser utilizar o "parent" (pom.xml) conforme o módulo "acordo-certo-test-domain", que foi criado como exemplo;

3) Configure o Spring MVC no projeto web (acordo-certo-test-web) através de anotações, sem utilização de XMLs;

4) Crie um formulário qualquer de cadastro que tenha no mínimo os seguintes elementos:
  - Input de texto;
  - Combobox;
  - Checkbox.
  
O envio dos dados do formulário deve ser via AJAX. Se preferir, utilize frameworks como AngularJS ou React;

5) Crie o modelo de dados para este formulário no banco de dados e também a entidade mapeada (JPA) no módulo acordo-certo-test-domain;

6) Implemente todas as camadas: a view chamando o controller, o controller chamando o service e, por fim, o service invocando o repository para persistência dos dados.

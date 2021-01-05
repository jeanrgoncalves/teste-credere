## teste-credere
API para movimentação de Sonda

## Documentação
Com a aplicação em execução, a documentação pode ser encontrada acessando o endereço http://localhost:8080/swagger-ui.html

## Execução local (Windows)
<b>Java 11</b>
  - Baixe o JDK 11 neste link https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html.
  - Faça a instalação
  - Crie uma variável de ambiente chamada JAVA_HOME apontando para o local da instalação (exemplo: C:\Program Files\Java\jdk-11.0.8)
  - Adicione o caminho %JAVA_HOME%\bin à variável Path
 
 <b>Maven</b> 
 - Baixe o Maven (Binary zip archive) neste link http://maven.apache.org/download.cgi
 - Extraia o conteúdo no local de sua escolha (exemplo: C:\apache-maven-3.6.3)
 - Crie uma variável de ambiente chamada MAVEN_HOME apontando para o local escolhido
 - Adicione o caminho %MAVEN_HOME%\bin à variável Path

<b>Mongo DB</b>
- Baixe o Mongo DB neste link https://www.mongodb.com/try/download/community
- Faça a instalação padrão - porta 27017 (obs: durante a instalação fique atento para instalar também o MongoDB Compass, pois ele será útil)
- Abra o Compass e faça uma conexão com a string padrão fornecida
- Crie um database com o nome "credere"

<b>Executando a solução</b>
- Pelo prompt de comando, navegue até à raiz do projeto (exemplo: C:\probe-jean
- Execute o comando "mvn spring-boot:run" (subirá na porta 8080)

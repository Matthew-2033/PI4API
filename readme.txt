http://localhost:8081/swagger-ui.html


senha Heroku Zoq86586,

autorização: 

Post: 
http://localhost:8081/oauth/token

Body:

    tipo : form-data

    parametros: 
        grant_type: password
        username: 
        password:

Autorization: 
    BasicAuth:
        Username: PI_3S
        Password: SenhaDoPI

Properties Para conectar no Banco de Producao:

spring.datasource.url=jdbc:mysql://mysql.hugolutke.com.br/hugolutke01
spring.datasource.username=hugolutke01
spring.datasource.password=projeto3

server.port=8081

security.oauth2.client.client-id=PI_3S
security.oauth2.client.client-secret=SenhaDoPI
security.oauth2.client.scope=password
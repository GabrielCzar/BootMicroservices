# Servidor de Configuração Centralizado

1. **ms-config-repo**:  
  Ambiente com as configuraçes do clients  
  Deve ser criado um repositorio com ```git init```  
  Os dados so seram utilizados se tiverem comitados  
  
2. **ms-config-server-demo**
  - ```http://localhost:8888```
3. **ms-client-demo**
  - ```http://localhost:8080```

#### Endpoints

- [2] ```/actuator/health``` Mostra estatisticas do servidor.
- [3] ```/refresh``` Atualiza app para receber alterações dos dados no _config-repo_.
- [3] ```/messages``` Mostra a mensagem que é um valor definido no _config-repo_.

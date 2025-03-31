# Configuração do Jenkins com Docker para Testes de Performance

## Requisitos
- **Docker Desktop** instalado na máquina

## Passos para configuração

### 1. Subindo o Jenkins com Docker
Abra um terminal e entre na pasta Jenkins e execute o comando:
```sh
docker compose up --build
```
Esse comando irá construir o Jenkins com as configurações necessárias para rodar os testes na pipeline.

### 2. Acessando o Jenkins
Após o Jenkins estar em execução, acesse no navegador:
```
http://127.0.0.1:8080
```

Utilize as seguintes credenciais padrão:
- **Usuário:** admin
- **Senha:** admin

### 3. Criando a Estrutura da Pipeline
1. Clique na opção **Novo Tarefa**.
2. Nomeie o workspace como `Teste performance` e selecione **Folder**.
3. Clique em **Tudo certo**.
4. Na página Configuration clique em **save**
5. Dentro da pasta criada, clique em **New Item**.
6. Nomeie como `Executar Teste` e selecione a opção **Pipeline**.
7. Clique em **Tudo certo**.
8. Role a página até a opção **Pipeline** e na opção **Definition** selecione **Pipeline script from SCM**.
9. Em **SCM** selecione **Git**.
10. Em **Repositoriy URL** cole está URL **https://github.com/Alexandresavio/performance-teste-viacep.git**. Ela está com pública, não precisa de credenciais.
11. Em **Branch Specifier** coloque como **main**
12. Em **Script Path** coloque **pipeline/Jenkinsfile**
13. Clique em **Salvar**.    
Agora o Jenkins estará executando os testes de performance conforme configurado. 

### 4. Executando o Teste
1. Clique em **Construir agora**.
2. Após finalizar o teste clique em workspace.
3. Clique no path do wokspace /var/jenkins_home/workspace/Teste performance/Executar Teste
4. Clique na pasta report e faça download dos relatórios.


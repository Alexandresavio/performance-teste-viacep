# Desafio de Teste de Performance de API

## Contexto
Você está em um time ágil. Foi priorizado pelo Product Owner (P.O.) a construção de uma API para consulta de CEPs do Brasil. O processo já passou pelas fases de refinamento, planejamento, desenvolvimento e testes funcionais. Agora, está nas suas mãos a responsabilidade de construir e executar os testes de performance desta aplicação.

Sugerimos a utilização da ferramenta **JMeter**. Os componentes utilizados para atender aos requisitos são de livre escolha.

## Requisitos
Durante o refinamento com o time e a área de negócio, foi informado que a aplicação terá um pico de utilização no quinto dia útil do mês. São esperados **1000 acessos por hora no período da manhã**, com o pico sendo atingido em **30 minutos**, mantendo-se estável até o final da manhã e reduzindo gradualmente até o final do dia.

A aplicação possui **duas operações**:
- Consulta pelo **código do CEP** (60% do uso)
- Busca pelo **endereço** (40% do uso)

A documentação e exemplos de utilização da API podem ser obtidos em: [ViaCEP](https://viacep.com.br)

## Objetivo
O objetivo deste desafio é criar um **projeto de performance** com as seguintes configurações e requisitos mínimos:

1. **Ramp up** de 30 minutos;
2. **Steady State** de 60 minutos;
3. **Think time** randômico entre os requests, variando de **100ms a 1000ms**;
4. **Pacing** de **1000 requests por hora** durante o período de steady state;
5. Utilize **datapools** ou outra forma de geração de dados para criar uma massa de dados variável durante a execução do teste de performance.

## Extra
Crie uma **pipeline declarativa no Jenkins**, que:
- Orquestrará a execução do teste;
- Exportará os resultados da execução em **HTML**.

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


# Spring-Rest-Cidades
Repositório para Rest envolvendo CSV de Cidades

Para funcionar deverá renomear o CSV para cidades.csv

- Rota padrão para a API "/api/cidade"
  Subrotas:
    - Rota ("/") Com GET, irá retornar todas as cidades
    - Rota ("/") Com POST, irá inserir a cidade, necessário informar por BODY a cidade 
    - Rota ("/{id}") Com GET, irá retornar a cidade com aquele ID    
    - Rota ("/{id}") Com DELETE, irá deletar a cidade com aquele ID    
    - Rota ("/{id}") Com PUT, irá editar a cidade com aquele ID    
    - Rota ("/capitais") com GET, irá retornar todas as capitais ordenadas de for ascendente 
    - Rota ("/count/{estado}) com GET, irá retornar quantas cidades há nesse estado
    - Rota ("/listar/{estado}) com GET, irá retornar a lista de informações de todas as cidades daquele estado
    - Rota ("/count") com GET, irá retornar a quantidade de cidades de todos os estados
    - Rota ("/estadomaiormenor") com GET, irá retornar o maior estado e o menor estado
    - Rota ("/populardb") com GET, irá popular o database com base no csv cidades.csv no desktop

* Pontos de melhoria;
  - Necessidade de implementar busca do CSV pela requisição (está realizando a busca no desktop)
  - Ajuste no enumerador estado (Está "poluindo" o controller)
  - Ajuste na query de buscar quantidade por estado (Está com objeto genérico)

# DesafioDeliveryMuch

<h2>Apresentação</h2>

Este projeto foi desenvolvido afim de entregar a resolução do desafio proposto pela Delivery Much para a posição de QA. E descreve o plano de testes produzido para validar o serviço [http://challengeqa.staging.devmuch.io](http://challengeqa.staging.devmuch.io/) que possui também uma rota para retornos de respostas em inglês [http://challengeqa.staging.devmuch.io/en](http://challengeqa.staging.devmuch.io/en).

É possível encontrar os testes automatizados na pasta test [clicando aqui](https://github.com/zero7um/DesafioDeliveryMuch/tree/main/src/test/java)

<h2>Execução do projeto</h2>

Para executar o projeto é necessário:

1. Possuir a versão 8 ou superior do Java instalada
2. Baixar e clonar este repositório em um local desejado 
3. Após abrir o projeto aguarde até que a IDE realize o download de todas as dependências necessárias e disponibilizadas no arquivo pom.xml (Intellij IDEA é recomendado para uma melhor experiência)


<h3>Ferramentas utilizadas </h3>

[IntelliJ IDEA Community Edition](https://www.jetbrains.com/pt-br/idea/download/#section=windows)

[Postman](https://www.postman.com/downloads/)

[JSON Schema Tool](https://jsonschema.net/home)

<h3>Requisitos </h3>

Encontre [aqui](https://github.com/zero7um/DesafioDeliveryMuch/blob/main/Delivery%20Much%20-%20QA%20Challenge.docx) os requisitos e solicitações do projeto.


<h2>Plano de Testes</h2>

1. Test Coverage Model
2. Aderência do contrato JSON
3. Testes exploratórios

<b>Test Coverage Model</h3>

O Test Coverage Model foi utilizado para identificar e categorizar as suítes de testes através de diferentes níveis de complexidade, sendo  o nível 0 o mais fraco e o nível 7 o mais forte/complexo, abaixo segue uma breve explicação de como cada nível é utilizado e o que cada um valida:

Nivel 0: aqui não há cobertura específica para ser realizada.

Nivel 1: possui cobertura bastante fraca, apenas requer conhecimento sobre os paths, sendo assim há 2 paths/end points a serem verificados. Aqui foi validado que é possível fazer uma chamada em cada end point para validar seu funcionamento. Logo, 2 endpoints e 1 teste para cada.

Nivel 2: nesse nível todas as operações que estão sendo enviadas ao serviço foram validadas estando de acordo com um dos requisitos disponibilizado. O serviço aceita apenas solicitações via método GET. Desse modo, 2 testes foram realizados, um para cada serviço.

Nivel 3: nesse nível foi validado o content-type de minha requisição, como meu escopo declara que apenas requisições via GET são aceitas e não há um body a ser inserido, é possível validar apenas o output da minha requisição que deve retornar um JSON. Sendo assim 2 testes são necessários para a validação. Mais adiante será possível visualizar os testes realizados usando o Json Schema assim como sua validação automatizada.

<i>Os nívels de 4 a 6 cobrem os PARÂMETROS</i>

Nivel 4: aqui os parâmetros são validados, tipos de variáveis, campos e os dados a serem enviados. Porém por não haver um body para ser enviado na requisição, esse nível cobre apenas o <b>status code class</b>. Foi definido nos requisitos que apenas dois status code devem ser retornados, 200 AUTHORIZED e 400 BAD REQUEST. Dessa forma, 4 testes são necessários. 2 para cada serviço sendo um de sucesso e outro de falha.

Nivel 5: nesse nível cada status code especificado é validado. Nesse contexto os testes validados no nível 4 validam comportam as validações desse niível.

Nivel 6: aqui o response body é checado afim de confirmar que atende ao formato esperado, JSON. O output precisa estar de acordo com o requisito. Sendo assim temos 2 testes um para cada serviço.

Nivel 7: aqui o fluxo dos serviços são validados, é esperado que se possam testar a comunicação entre os serviços. Como não há dependência ou integração direta entre os dois ou com uma interface de usuário que exiba os valores obtidos nos outputs. Dessa forma, não é possível realizar esse nível. 

<h3>Desse modo, temos:</h3>
<table> 
 <thead>
  <tr>
   <th align="center">Nivel</th>
   <th>Input Criteria</th>
   <th>Output Criteria</th>
   <th>Number of Tests</th>
  </tr> 
 </thead>
 <tbody>
  <tr>
   <th>0 </th>
   <th> - </th>
   <th> - </th>
   <th> - </th>
  </tr>
  <tr>
   <th> 1 - Paths </th>
   <th> 2 </th>
   <th> 2 </th>
   <th> 2 </th>
  </tr>
   <tr>
   <th> 2 - Operações </th>
   <th> 2 </th>
   <th> 2 </th>
   <th> 2 </th>
  </tr>
  <tr>
   <th> 3 - Content-type </th>
   <th> 2 </th>
   <th> 2 </th>
   <th> 2 </th>
  </tr>
  <tr>
   <th> 4 - Status Code Class </th>
   <th> 2 </th>
   <th> 2 </th>
   <th> 4 </th>
  </tr>
  <tr>
   <th> 5 - Status Code </th>
   <th> - </th>
   <th> - </th>
   <th> - </th>
  </tr>
  <tr>
   <th> 6 - Response Body </th>
   <th> 2 </th>
   <th> 2 </th>
   <th> 2 </th>
  </tr>
  <tr>
   <th> 7 - Operation Flows </th>
   <th> - </th>
   <th> - </th>
   <th> - </th>
  </tr>  
 </tbody>
  </table>
  

<h3>Inconsistências/Bugs</h3>

Após a realização de testes exploratórios, 3 bugs foram encontrados. Abaixo as respectivas descrições e evidências anexadas.

#bug01

Descrição:

Ao fazer uma requisição via GET no serviço que retorna respostas em inglês enviando o número -10000 (menos dez mil), a resposta é exibida fora do formato definido pelo contrato JSON. O Correto seria ""full": "minus ten thousand"

![](https://github.com/zero7um/DesafioDeliveryMuch/blob/main/img1.png)


#bug02

Descrição:

Ao fazer uma requisição via GET no serviço que retorna respostas em português enviando o número 10000 (dez mil), o número por extenso é retornado na língua inglesa.
![](https://github.com/zero7um/DesafioDeliveryMuch/blob/main/img2.png)


#bug03 

Descrição:

Ao fazer uma requisição via GET no serviço que retorna respostas em inglês enviando o número -10001 (menos dez mil e um), o status code exibido é o 401 UNAUTHORIZED. O correto de acordo com o contrato seria 400 BAD REQUEST.
![](https://github.com/zero7um/DesafioDeliveryMuch/blob/main/img3.png)


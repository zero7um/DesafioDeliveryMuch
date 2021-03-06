# DesafioDeliveryMuch

Apresentação

Este projeto foi desenvolvido afim de entregar a resolução do desafio proposto pela Delivery Much para a posição de QA. E descreve o plano de testes produzido para validar o serviço [http://challengeqa.staging.devmuch.io](http://challengeqa.staging.devmuch.io/). 

Contém a descrição do que foi realizado e as soluções encontradas para validar as funcionalidades descritas nos requisitos disponibilizados.  

Plano de testes

1. Test Coverage Model
2. Aderência do contrato JSON

Test Coverage Model

 O "modelo de cobertura de testes" foi utilizado para assim identificar e categorizar as suítes de testes através de diferentes níveis de complexidade sendo  o nível 0 o mais fraco e o nível 7 o mais forte/complexo, foi possível identificar os seguintes cenários:

Nivel 0: aqui não há cobertura específica para ser realizada.

Nivel 1: cobertura bastante fraca, apenas requer conhecimento sobre os paths, sendo assim há 2 paths/end points a serem verificados. Aqui validei que é possível fazer uma chamada em cada end point para validar seu funcionamento. Logo 2 endpoints e 1 teste para cara. 2 testes

Nivel 2: aqui todas as operações que estão sendo enviadas ao serviço foram validadas, estando de acordo com um dos requisitos disponibilizado, o serviço aceita apenas solicitações via método GET. Desse modo, 2 testes foram realizados, um para cada serviço.

Nivel 3: aqui estarei testando o content-type de minha requisição, como meu escopo declara que apenas requisições via GET são aceitas e não há um body a ser inserido, é possível validar apenas o output da minha requisição que deve retornar um JSON. Sendo assim 2 testes são necessários para a validação, um para cada serviço.

Os nívels de 4 a 6 cobrem os PARÂMETROS

Nivel 4: aqui os parâmetros são validados, tipos de variáveis, campos e os dados a serem enviados. Porém por não há um corpo para ser enviado na solicitação esse nível cobre apenas o status code class. Foi definido nos requisitos que apenas dois status code devem ser retornados. 200 AUTHORIZED e 400 BAD REQUEST. Dessa forma, 4 testes são necessários. 2 para cada serviço sendo um de sucesso e outro de falha para ambos.

Nivel 5: nesse nível cada status code especificado é validado. Nesse contexto os testes validados no nível 4 coincidentemente validam o comportamento aqui esperado.

Nivel 6: aqui o responde body é checado afim de confirmar que atende ao formato esperado no JSON. O output precisa estar de acordo com o requisito. Sendo assim temos 2 testes um para cada serviço.

Nivel 7: aqui o fluxo dos serviços são validados, é esperado que se possam testar a comunicação entre os serviços. Como não há dependência ou integração direta entre os dois ou com uma interface de usuário que exiba os valores obtidos nos outputs. Dessa forma, não é possível realizar esse nível. 

Desafios encontrados

Bugs

3 bugs encontrados

Ferramentas utilizadas 
Postman

JSON Schema Tool

Requisitos 

1. Servidor HTTP que funcionará apenas para requisições GET 

2. Sistema permitirá utilizar apenas números no intervalo entre [-10000, 10000]; 
Aplicando a técnica de análise de valor limite foi possível validar que o requisito está coberto pelo sistema.
3. Ao se fazer essa requisição, retornará um JSON cuja chave "extenso" terá, em seu
valor, o número inteiro por extenso, que foi inserido na path. **2 bugs encontrados**

#bug01
Ao fazer uma requisição via GET no serviço que retorna respostas em inglês enviando o número -10000 (menos dez mil), a resposta é exibida fora do formato definido pelo contrato JSON. O Correto seria ""full": "minus ten thousand"


#bug02
Ao fazer uma requisição via GET no serviço que retorna respostas em português enviando o número 10000 (dez mil), o número por extenso é retornado na língua inglesa.


4. Pensando-se na internacionalização deste, o serviço terá suporte, além de
portugues, para tambem em ingles;

5. Caso não seja possível converter o valor inserido na path, chave “extenso” terá valor “Invalid data”; 

 Requisito em concordância com o contrato

6. Para estes casos, resposta deve ter status 400; 

1 BUG encontrado

#BUG01

Ao fazer uma requisição via GET no serviço que retorna respostas em inglês enviando o número -10001 (menos dez mil e um), o status code exibido é o 401 UNAUTHORIZED. O correto de acordo com o contrato seria 400 BAD REQUEST.


7. Para os casos válidos, resposta deve ter status 200

Requisito em concordância com o contrato

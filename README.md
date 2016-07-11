# README #

* Este repositório contém o projeto Java desenvolvido para atender os requisitos do "Teste Desenvolvedor 1". O projeto foi desenvolvido utilizando a IDE NetBeans 8.1

## Requisitos para executar o programa ##

* Java SE 8

## Instruções ##

* Execute o arquivo "mars.jar" dentro da pasta "dist" ou abra o projeto em uma IDE e execute
* Durante a execução do programa entre as informações solicitadas

## Código ##

### br.com.mars.model/Rover.java ###
* Objeto model do tipo Rover com variaveis privadas e respectivos metodos de acesso (getters e setters)

### br.com.mars.controller/RoverController.java ###
* plateau_x, plateau_y : variáveis privadas do tipo inteiro para controle do tamanho da matriz (a plateau on Mars)

* metodos getters e setters para acesso as variáveis

* turnLeft : recebe um objeto do tipo Rover e não há retorno. Esse método vira o robo rover para a esquerda sem mover com base em sua orientação atual

* turnRight : recebe um objeto do tipo Rover e não há retorno. Esse método vira o robo rover para a direita sem mover com base em sua orientação atual

* move: recebe um objeto do tipo Rover e não há retorno. Esse método move o robo para 1 posição a frente de sua posição atual com base orientação atual

* deployRover: recebe 2 inteiros indicando a posição x e y respectivamente e um caracter e retorno um objeto do tipo Rover. Esse método cria e alimenta um objeto do tipo Rover, validando os valores digitados pelo usuário

* getRoverPosition: recebe um objeto do tipo Rover como parametro e retorna uma string. Esse método retorna a posição e orientação atual do Rover em forma de String

### mars/Mars.java ###
* Classe principal do projeto, essa classe é chamada ao executar o projeto e representa a interface do usuário. A mesma exibe as mensagens e coleta as informações inseridas pelo usuário para execução do programa
# Definição do Trabalho
Você deverá criar um programa para verificar a qualidade de um vinho, baseado em suas características utilizando uma Rede Neural Multi-Layer Perceptron.

O conjunto de testes deve ser buscado de https://archive.ics.uci.edu/ml/machine-learning-databases/wine-quality/ (ou de https://github.com/selatotal/InteligenciaArtificial/tree/master/Trabalhos/201701).
Este é um repositório de arquivos de dados utilizados para treinamentos de Aprendizado de Máquina pela Universidade da Califórnia.
Este arquivo possui a avaliação de 4.898 vinhos (tintos e brancos) em formato CSV. Você deve usar o conteúdo dos dois arquivos (winequality-red.csv e winequality-white.csv) como um arquivo único. O arquivo com a extensão .names possui a descrição de cada um dos campos.

Baseado nos atributos, a rede neural deverá determinar a qualidade do vinho (valor do campo 12).

Deverá ser possível executar a rede tanto em modo de treinamento como em modo de generalização (com os pesos já treinados)

# Importante
O programa deverá possuir um arquivo de configuração conforme abaixo (supondo uma rede MLP 2x2x3x2):
```
{ 
	"layers" : [ 2, 3, 2],
	"weights" : [ 
		[
			[1, 0, 1],
			[1, 0, 1]
		],
		[
			[1, 0, 0],
			[1, 0, 1],
			[1, 0, 0]
		],
		[
			[1, 0, 1, 1],
			[1, 0, 1, 1]
		],
	],
	"learningRate": 1
}
```
Onde:
- layers: array contendo a quantidade de neurônios em cada uma das camadas
- weights: peso de cada um dos neurônios, de cada uma das camadas
- learningRate: constante de aprendizado (eta)

# Execução
Deve ser possível executar o programa conforme abaixo:
```
redeMLP <fase> <arquivo>
```
Onde: 
- fase: "treinamento" ou "generalizacao"
- arquivo: Nome do arquivo a ser analisado

Ex:
```
redeMLP treinamento winequality.csv
```

# Premissas
O trabalho deve ser desenvolvido em uma linguagem que possa ser executada em ambiente Linux. Caso tenha dúvidas sobre se a linguagem pode ser utilizada, envie um e-mail ao professor.

# Entrega
Você deve entregar o código-fonte da rede neural e um artigo explicando:
- Roteiro de configuração e instalação do sistema
- Topologia da Rede
- Quantidade de neurônios em cada camada
- Função de Ativação escolhida
- Como é feito o pré e o pós processamento
- Como foi planejada a aprendizagem
- Abordagem utilizada
- Conjunto de treino
- Conjunto de teste
- Número de épocas para atender os padrões
- Quantidade de épocas necessária para aprendizagem
- Tempo de aprendizado
- Taxa de aprendizagem
- Quantos vinhos reconhece corretamente
- Quantos vinhos reconhece incorretamente
- Índice de acerto da rede na fase de generalização
- Percentual de acerto


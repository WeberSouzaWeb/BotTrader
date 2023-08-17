# BotTrader
FOREX - Meta Trader 5

# Introdução
O projeto fofi organizado de acordo com a imagem abaixo, e a primeira parte se preocupa em trata da extração e tratamento dos dados.

![image](https://github.com/WeberSouzaWeb/BotTrader/assets/107212929/3cc69fd7-9124-47f0-b8e6-63b24a524626)

## Extração e Tratamento dos Dados
### Leitura do Arquivo CSV
Inicialmente foi feita a coleta dos dados de 4 ativos de FOREX pelo MetaTrader 5 com um time frame de 10 minutos. Os ativos s˜ao : AUDUSD, EURUSD, NZDUSD, USDCAD. Foram selecionado dados de 20/05/2022 `a 19/08/22, totalizando em um ind´ıce de em 9505. Ap´os
fazer o download dos dados dos 4 ativos, foi feita a leitura do arquivo CSV no JAVA.

# Referencial Teórico
### Definição de Câmbio
-> Mercado de câmbio é o maior mercado do mundo, significando liquidez
-> Período de negociação é contínuo
-> Facilidade de acesso e alavancamento
-> Simplicidade de oferta
-> Comissões mais baixas

### Indicadores Técnicos
  Segunda Silva: "Indicadores de tendencia são o resultado de cálculos matemáticos baseados no preço e/ou volume do passado e do presente com o intuito de dar maior definição sobre a tendencia predominante num certo período. Trata-se de indicadores de atraso que visam a confirmação de movimentos e não a sua antecipação."

### Médias Móveis (MM)
  Uma media de um conjunto de valores em um perído temporal, permitindo analisar tendencia de valor. Os tipos mais usados são a simples, exponencial analisar tendencia de valor. Os tipos mais usados são a simples, exponencial e a ponderada. A diferença entre elas é o peso atribuído aos dados.

### Média Móvel Simples (MMS)
  A média móvel simples é calculada através da soma dos preços de fechamento, como se segue: 
  ![image](https://github.com/WeberSouzaWeb/BotTrader/assets/107212929/052270a9-e857-407f-bfa7-f65a755c94fe)

### Média Móvel Exponencial (MME)
  A média móvel exponencial é calculada através da soma de uma porcentagem do preço de fecha de hoje ao valor média de ontem, aplicando mais peso no preço recente, como se segue:
![image](https://github.com/WeberSouzaWeb/BotTrader/assets/107212929/bc258a9a-c44d-4e62-a418-fe3049cf1e2f)

### Média Mével Ponderada (MMP)
  A média móvel pondedrada leva em consideração os valores mais recentes maior fatores de ponderação. É calculada pela multiplicação de cada preço de fecho a um coeficiente de ponderação, como se segue:
  ![image](https://github.com/WeberSouzaWeb/BotTrader/assets/107212929/778443ba-c642-4506-b685-52660a807e2d)


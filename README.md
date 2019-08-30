# Remédios Scraping
A [Ultra Farma](https://www.ultrafarma.com.br/) possui um dos maiores e-commerces do país quando se trata de medicação.
<br>E todos os dias eles disponibilizam novos descontos.
<br>Este é composto por um web-scraper que vai até a página de descontos especiais da Ultra Farma e os catalóga em um arquivo csv, como no formato abaixo:

|Remedio|PrecoVenda(R$)|Desconto(%)|DataBusca|
|--------|--------------|--------------|------------|
|DORALGINA 20 DRÁGEAS|R$5.00|75%|30 de ago de 2019|

A primeira vez que o programa é executado cria-se um arquivo com os descontos dos dias. E quando o arquivo já existe, o programa o identifica e faz as adições no final do mesmo, para futuras comparações e/ou análises.

---
### Como executar o Programa:


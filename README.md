# Remédios Scraping
A [Ultra Farma](https://www.ultrafarma.com.br/) possui um dos maiores e-commerces do país quando se trata de medicação.
<br>Dentro do site pode-se realizar várias buscas, tanto por preço como por tipo de remédio.
<br>Este projeto é composto por um web-scraper que recebe uma URL da página da Ultra Farma e busca o nome dos produtos, os preços, o tamanho dos descontos dados e a data da pesquisa, depois armazena todas essas informações em um arquivo csv, como no formato abaixo:

|Remedio|PrecoVenda(R$)|Desconto(%)|DataBusca|
|--------|--------------|--------------|------------|
|DORALGINA 20 DRÁGEAS|R$5.00|75%|30 de ago de 2019|

A primeira vez que o programa é executado cria-se um arquivo com os descontos dos dias. E quando o arquivo já existe, o programa o identifica e faz as adições no final do mesmo, para futuras comparações e/ou análises.

---
## Exemplo de URL's funcionais do site:
* Antialérgicos: https://www.ultrafarma.com.br/categoria/genericos/alergias-e-infeccoes/antialergicos
* Antibióticos: https://www.ultrafarma.com.br/categoria/genericos/alergias-e-infeccoes/antibioticos
* Descontos Especiais: https://www.ultrafarma.com.br/categoria/promocoes/precos-especiais

---
### Como executar o Programa:
1. É necessário ter java instalado em sua máquina e estar conectado à internet.
2. Baixe a pasta _/exec_ e execute o arquivo **exec_remedios**.
3. Escreva alguma URL de busca da Ultra Farma.

---
### Bibliotecas Externas:
* **JSOUP:** Uma biblioteca para web-scraping que utiliza 'selector-syntax' para a escolha de elementos.
* **JUnit4:** Biblioteca utilizada para testes.

---
### Estrutura do Projeto Segundo Execução:
1. **_Classe_ VerificadorUrl:** Recebe e verifica se a Url é válida. Lança a exceção **EntradaUrlExcecao**.
2. **_Classe_ VerificadorCsv:** Verifica se o arquivo já existe e caso não, o cria. Lança a exceção **CriacaoArquivoExcecao**.
3. **_Classe_ DefinindoLimitador:** Verifica qual dos três dados recebidos é o limitador da informação.
4. **_Classe_ EscritorCsv:** Escreve no arquivo os dados capturados. Lança a exceção **ArmazenandoDadosExcecao**. 

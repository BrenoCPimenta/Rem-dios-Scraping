package main;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import main.Excecoes.ArmazenandoDadosExcecao;
import main.Excecoes.CriacaoArquivoExcecao;
import main.Excecoes.EntradaUrlExcecao;
import main.GerenciaCsv.EscritorCsv;
import main.GerenciaCsv.VerificadorCsv;
import main.InputVerificador.DefinindoLimitador;
import main.InputVerificador.VerificadorURL;

public class Main {
	private static Scanner scanner;
	static Date data = new Date();
    static DateFormat formataData = DateFormat.getDateInstance();

	public static void main(String[] args) {
		try {
			//Entrando com a URL
			VerificadorURL verificadorUrlObj = new VerificadorURL();
			final String url_ultra_farma = verificadorUrlObj.buscarUrl(false);
			  
	        
			//Verificando criacao do arquivo
			VerificadorCsv verificadorObj = new VerificadorCsv();
			verificadorObj.verificarCSV();
			
			
			//Busca no site
			Document doc = Jsoup.connect(url_ultra_farma).get();
			Elements nomes_produtos_ultra_farma = doc.getElementsByClass("product-name");
			Elements preco_produtos_ultra_farma = doc.getElementsByClass("product-price-sell");
			Elements desconto_produtos_ultra_farma = doc.getElementsByClass("tag-desconto product-tags-primary");
			
			//Definindo limmitador de itens da pagina:
			//Pois normalmente os ultimos itens ou estao fora do estoque ou sem promocao
			int limitador = 0;
			DefinindoLimitador limitadorObj = new DefinindoLimitador();
			limitador = limitadorObj.definir(	nomes_produtos_ultra_farma.size(), 
												preco_produtos_ultra_farma.size(), 
												desconto_produtos_ultra_farma.size());
			
			//Armazenamento no arquivo
			EscritorCsv escritorObj = new EscritorCsv();
			for(int i=0; i<limitador; i++) {
				escritorObj.escrever(	nomes_produtos_ultra_farma.get(i).text(),
										preco_produtos_ultra_farma.get(i).text().replace(',', '.'),  //A virgula do preco deve ser trocada para nao afetar a organizacao do csv
										desconto_produtos_ultra_farma.get(i).text(),
										formataData.format(data),
										false);
			}
			System.out.println("O arquivo da Ultra Farma foi atualizado com sucesso!");
			System.out.print("Tecle enter para fechar o programa.");
			scanner = new Scanner(System.in);
			scanner.nextLine();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Houve um problema com a conexão com o site.\nPor favor contactar o suporte.");
		}catch (EntradaUrlExcecao e) {
			System.out.println(e.getMessage());
		}catch (CriacaoArquivoExcecao e) {
			System.out.println(e.getMessage());
		}catch (ArmazenandoDadosExcecao e) {
			System.out.println(e.getMessage());
		}
	}
}

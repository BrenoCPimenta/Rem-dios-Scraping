package main.InputVerificador;

import java.net.URL;
import java.util.Scanner;

import main.Excecoes.EntradaUrlExcecao;
public class VerificadorURL {
	
	public String buscarUrl(boolean test) throws EntradaUrlExcecao {
	
		while(true) {
			String url = "";
			if(test==false) {
				System.out.println("Digite a URL da Ultra Farma abaixo:");
				Scanner scanner = new Scanner(System.in);
				url = scanner.nextLine();
			}
			
			try {
				//Teste de conexao
				new URL(url).toURI();
				
				//Teste se eh UltraFarma
				if(!url.contains("ultrafarma")) {
					throw new Exception();
				}
		
				return url;
			}catch(Exception e) {
				for(int i=0; i<50; i++) System.out.println(); //Limpando console
				System.out.println("A URL digitada é invalida, por favor tente novamente ou digite sair.");
				if(url == "sair" || url=="Sair" || url=="SAIR") {
					throw new EntradaUrlExcecao();
				}
				if(test == true) {
					throw new EntradaUrlExcecao();
				}
			}
		}
	}

}

package main.Excecoes;

public class CriacaoArquivoExcecao extends Exception {
	public String getMessage() {
		return "Houve um problema com a cria��o do arquivo.\nPor favor contactar o suporte.";
	}
}

package main.Excecoes;

public class CriacaoArquivoExcecao extends Exception {
	public String getMessage() {
		return "Houve um problema com a criação do arquivo.\nPor favor contactar o suporte.";
	}
}

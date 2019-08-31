package main.Excecoes;

public class ArmazenandoDadosExcecao extends Exception{
	public String getMessage() {
		return "Houve um problema com o armazenamento de dados no arquivo.\nPor favor contactar o suporte.";
	}
}

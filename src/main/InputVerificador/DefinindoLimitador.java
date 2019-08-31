package main.InputVerificador;

public class DefinindoLimitador {
	
	public int definir(int nome, int preco, int desconto) {
		if((preco <= nome) && (preco<=desconto)){
			return preco;
		}else if(desconto<=nome) {
			return desconto;
		}else {
			return nome;
		}
	}

}

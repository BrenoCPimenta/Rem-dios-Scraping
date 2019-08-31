package test;

import org.junit.Test;

import main.Excecoes.ArmazenandoDadosExcecao;
import main.GerenciaCsv.EscritorCsv;

public class ArmazenandoDadosExcecaoTeste{
	
	@Test(expected=ArmazenandoDadosExcecao.class)
	public void test() throws ArmazenandoDadosExcecao {
		EscritorCsv escritorObj = new EscritorCsv();
		escritorObj.escrever("nome", "preco", "desconto", "data", true);		
	}
}

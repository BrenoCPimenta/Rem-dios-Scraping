package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Excecoes.EntradaUrlExcecao;
import main.InputVerificador.VerificadorURL;

public class EntradaUrlExcecaoTeste {
	
	@Test(expected=EntradaUrlExcecao.class)
	public void test() throws EntradaUrlExcecao {
		VerificadorURL verificadorUrlObj = new VerificadorURL();
		verificadorUrlObj.buscarUrl(true);		
	}
}

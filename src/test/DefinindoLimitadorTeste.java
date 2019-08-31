package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.InputVerificador.DefinindoLimitador;

public class DefinindoLimitadorTeste {

	@Test
	public void testNormal() {
		DefinindoLimitador limitadorObj = new DefinindoLimitador();
		assertEquals(limitadorObj.definir(5, 4, 3), 3);
	}
	
	@Test
	public void testZero() {
		DefinindoLimitador limitadorObj = new DefinindoLimitador();
		assertEquals(limitadorObj.definir(0, 1, 90), 0);
	}
	
	@Test
	public void testNegativo() {
		DefinindoLimitador limitadorObj = new DefinindoLimitador();
		assertEquals(limitadorObj.definir(5, -1, 9), -1);
	}

}

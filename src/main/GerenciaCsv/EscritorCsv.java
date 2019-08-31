package main.GerenciaCsv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import main.Excecoes.ArmazenandoDadosExcecao;

public class EscritorCsv {
	
	public void escrever(String nome, String preco, String desconto, String data, boolean test) throws ArmazenandoDadosExcecao {
		String file_path = "";
		if(test == false) {
			String executionPath = System.getProperty("user.dir");
            String fileSeparator = System.getProperty("file.separator");
			file_path = executionPath + fileSeparator +"UltraFarma-Descontos.csv";
		}
		
		try {
            FileWriter fwObj = new FileWriter(file_path,true);
            BufferedWriter bwObj = new BufferedWriter(fwObj);
            PrintWriter pwObj = new PrintWriter(bwObj);
            
            pwObj.println(nome+','+preco+','+desconto+','+data);
            pwObj.flush();
            
            if(pwObj.checkError()) {
            	throw new ArmazenandoDadosExcecao();
            }
            
            pwObj.close();
            
		}catch (Exception e){
            System.out.println("Exception caught ="+e.getMessage());
            throw new ArmazenandoDadosExcecao();
        }   
	}
}

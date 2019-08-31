package main.GerenciaCsv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import main.Excecoes.CriacaoArquivoExcecao;

public class VerificadorCsv{
	
	public void verificarCSV() throws CriacaoArquivoExcecao{
		try {
	        String executionPath = System.getProperty("user.dir");
	        String fileSeparator = System.getProperty("file.separator");
	        File fileObj = new File(executionPath + fileSeparator +"UltraFarma-Descontos.csv");
	        
	        //Caso o arquivo ainda nao tenha sido criado, cria ele:
	        if(!fileObj.exists()) {
	            
					fileObj.createNewFile();
				
	            FileWriter fwObj = new FileWriter(fileObj);
	            BufferedWriter bwObj = new BufferedWriter(fwObj);
	            PrintWriter pwObj = new PrintWriter(bwObj);
	            
	            pwObj.println("Remedio,PrecoVenda(R$),Desconto(%),DataBusca");
	            pwObj.flush();
	            pwObj.close();                         
	        }
	        
	        //Caso ocorra problema com sua criacao:
	        if(!fileObj.exists()) {
	        	throw new CriacaoArquivoExcecao();
	        }
        } catch (IOException e) {
			e.printStackTrace();
			throw new CriacaoArquivoExcecao();
		}
	}
}

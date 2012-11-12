package br.com.senacrs.alp.aulas.trabalho12;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Testes {

	private final static String DIRETORIO_ENTRADA = System
			.getProperty("user.dir")
			+ File.separatorChar
			+ "diretorio"
			+ File.separatorChar;
	private final static String ROOT_DIR_ARQUIVO = "./diretorio/subdiretorio";
	private final static String ROOT_DIR_INICIOINCORRETO = "InicioIncorreto./diretorio/subdiretorio";
	private final static String ROOT_DIR_CORRETO = DIRETORIO_ENTRADA + "subdiretorio";
	private final static String PORT_CORRETO = "12345";
	private final static String PORT_INCORRETO = "ERRO";
	private final static String NOME_ARQUIVO_ENTRADA = "config.txt";
	private final static String ARQUIVO_ENTRADA = DIRETORIO_ENTRADA	+ NOME_ARQUIVO_ENTRADA;
	private final static String ARQUIVO_INEXISTENTE = DIRETORIO_ENTRADA	+ "arquivoInexistente.txt";
	private final static String ARQUIVO_ERRADO_PORT = DIRETORIO_ENTRADA	+ PORT_INCORRETO;
	private final static String[] CONTEUDO = new String[] {
			"root_dir = ./diretorio/subdiretorio", // 0
			"port = 12345", // 1
	};
	
	private final static String NOME_GET_ERRADO = "get1.nok";
	private final static String NOME_GET_ERRADO_HTTP = "get1.nok";
	private final static String NOME_GET_ERRADO_HOST = "get1.nok";
	
	private final static String NOME_GET_CORRETO = "get.txt";
	
	private final static String ARQUIVO_GET_ENTRADA = DIRETORIO_ENTRADA + NOME_GET_CORRETO;
	private final static String ARQUIVO_GET_ERRADO = DIRETORIO_ENTRADA + NOME_GET_ERRADO;
	private final static String ARQUIVO_GET_ERRADO_HTTP = DIRETORIO_ENTRADA + NOME_GET_ERRADO_HTTP;
	private final static String ARQUIVO_GET_ERRADO_HOST = DIRETORIO_ENTRADA + NOME_GET_ERRADO_HOST;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private Arquivo criarGerenciadoDeArquivo(String arquivo) {

		return new Arquivo(arquivo);
	}
	
	private Main iniciarMain (String argumentoInicial) {
		
		Main principal = new Main();
		String[] argumento = new String[1];
		argumento[0] = argumentoInicial;
		principal.main(argumento);
		return principal;
	}

	@Test
	public void testCriarNulo() {

		try {
			criarGerenciadoDeArquivo(null);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCriarDiretorio() {

		try {
			criarGerenciadoDeArquivo(DIRETORIO_ENTRADA);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCriarArquivoValido() {

		criarGerenciadoDeArquivo(ARQUIVO_ENTRADA);
	}

	@Test
	public void testLerArquivoInexistente() {

		Arquivo obj = null;

		try {
			obj = criarGerenciadoDeArquivo(ARQUIVO_INEXISTENTE);
			obj.lerArquivo();
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testLerArquivo() {

		Arquivo obj = null;
		String[] resultado = null;
		String msg = null;

		obj = criarGerenciadoDeArquivo(ARQUIVO_ENTRADA);
		resultado = obj.lerArquivo();
		msg = "Resultado :" + Arrays.toString(resultado);
		msg += " Esperado :" + Arrays.toString(CONTEUDO);
		Assert.assertTrue(msg, Arrays.deepEquals(CONTEUDO, resultado));
	}
	
	@Test
	public void testArgumentoNull() {
		
		try {
			iniciarMain(null);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testRootDir() {
		
		Arquivo obj = null;
		obj = criarGerenciadoDeArquivo(ARQUIVO_ENTRADA);
		
		String root_dir_resultado = obj.organizarRootDir(ROOT_DIR_ARQUIVO);
		
		if (ROOT_DIR_CORRETO.equals(root_dir_resultado)) {
			Assert.assertTrue(true);
		} else {
			fail("Resultados não estão iguais");
		}
	}
	
	@Test
	public void testRootDirInicioIncorreto() {
		
		Arquivo obj = null;
		obj = criarGerenciadoDeArquivo(ARQUIVO_ENTRADA);
		String root_dir_resultado = null;
		
		try {
			root_dir_resultado = obj.organizarRootDir(ROOT_DIR_INICIOINCORRETO);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testPortaResultadosIguais() {
		
		Arquivo obj = null;
		obj = criarGerenciadoDeArquivo(ARQUIVO_ENTRADA);
		int port_resultado = obj.organizarPorta(PORT_CORRETO);
		
		//transforma port_resultado em String e compara com a String PORT_CORRETO
		if (String.valueOf(port_resultado).equals(PORT_CORRETO)) {
			Assert.assertTrue(true);
		} else {
			fail("Resultados não estão iguais");
		}
	}
	
		@Test
		public void testPortaArgumentoIncorreto() {
		
			Arquivo obj = null;
			obj = criarGerenciadoDeArquivo(ARQUIVO_ENTRADA);
			int port_resultado = 0;
			
			try {
				port_resultado = obj.organizarPorta(PORT_INCORRETO);
				fail("Deveria ter abortado");
			} catch (IllegalArgumentException e) {
				Assert.assertTrue(true);
			}
		}
		
		@Test
		public void testCarregarGetInexistente() {
			
			String args[] = new String[2];
			
			try{
				args[0] = DIRETORIO_ENTRADA;
				args[1] = ARQUIVO_INEXISTENTE;
				fail("Deveria ter abortado"); 
			}catch(Exception e){
				Assert.assertTrue(true);
			}
			
		}
		
		@Test
		public void testCarregarGetInvalido() {
			
			String args[] = new String[2];
			
			try{
				args[0] = DIRETORIO_ENTRADA;
				args[1] = ARQUIVO_GET_ERRADO;
				fail("Deveria ter abortado"); 
			}catch(Exception e){
				Assert.assertTrue(true);
			}
		}
		
		@Test
		public void testCarregarGetHttpInvalido() {
			
			String args[] = new String[2];
			
			try{
				args[0] = DIRETORIO_ENTRADA;
				args[1] = ARQUIVO_GET_ERRADO_HTTP;
				fail("Deveria ter abortado"); 
			}catch(Exception e){
				Assert.assertTrue(true);
			}
		}
		
		@Test
		public void testCarregarGetHostInvalido() {
			
			String args[] = new String[2];
			
			try{
				args[0] = DIRETORIO_ENTRADA;
				args[1] = ARQUIVO_GET_ERRADO_HOST;
				fail("Deveria ter abortado"); 
			}catch(Exception e){
				Assert.assertTrue(true);
			}
		}
}

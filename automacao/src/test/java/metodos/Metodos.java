package metodos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import conexoes.DriversFactory;

public class Metodos extends DriversFactory {

	public void esperarElemento(By elemento) {
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(elemento));

	}

	public void clicar(By elemento) {
		driver.findElement(elemento).click();

	}

	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);

	}

	public void submit(By elemento) {
		driver.findElement(elemento).submit();
	}

	public void schrool() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("schroll(0,2000)", "");
	}

	public String getRandomEmail() {

		String email_int = "email";
		String email_final = "@random.com.br";

		Random random = new Random();

		int minimo = 1;
		int maximo = 9999999;
		int resultado = random.nextInt(maximo - minimo) + minimo;

		return email_int + resultado + email_final;

	}

	public String getNomeAleatorio() {
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
		int quantidadeDeSilabasNome;

		// getRandonIntInclive o m�nimo de letras a ser gerado � o e o m�ximo 15
		quantidadeDeSilabasNome = getRandomIntInclusive(8, 8);

		String nome = "";

		for (int contadorSilaba = 1; contadorSilaba < quantidadeDeSilabasNome; contadorSilaba++) {
			nome = nome + getConsoanteAleatorio() + getVogalAleatorio();
		}
		return nome;
	}

	public String getSobreNomeAleatorio() {
		String sobreNome = " ";
		// getRandonIntInclive o m�nimo de letras a ser gerado � o e o m�ximo 15
		int quantidadeDeSilabasSobreNome = getRandomIntInclusive(10, 10);

		for (int contadorSilaba = 1; contadorSilaba < quantidadeDeSilabasSobreNome; contadorSilaba++) {
			sobreNome = sobreNome + getConsoanteAleatorio() + getVogalAleatorio();
		}
		return sobreNome;
	}

	private int getRandomIntInclusive(int minimo, int maximo) {
		minimo = (int) Math.ceil(minimo);
		maximo = (int) Math.ceil(maximo);
		return (int) (Math.floor(Math.random() * (maximo - minimo + 1)) + minimo);

	}

	private String getVogalAleatorio() {
		// Gerando vogais aleat�ria
		String listaVogais = "AEIOU";
		int numeroAleatorio;

		// Gerando vogais aleat�rias o m�todo getRandomIntInclusive gera no m�nimo 3 e
		// no m�ximo 5
		numeroAleatorio = (int) getRandomIntInclusive(1, 5);
		return listaVogais.substring(numeroAleatorio - 1, numeroAleatorio);

	}

	private String getConsoanteAleatorio() {
		// Gerando consoantes aleat�ria
		String listaConsoantes = "BCDFGHJKLMNPQRSTWVXYZ ";
		int numeroAleatorio;
		// Gerando vogais aleat�rias o m�todo getRandomIntInclusive gera no m�nimo 1 e
		// no m�ximo 21
		numeroAleatorio = getRandomIntInclusive(1, 21);

		return listaConsoantes.substring(numeroAleatorio - 1, numeroAleatorio);

	}

	public class Random1senha {

		public void main(String[] args) {

			// inst�ncia um objeto da classe Random usando o construtor padr�o
			Random gerador = new Random();

			// imprime sequ�ncia de 10 n�meros inteiros aleat�rios
			for (int i = 0; i < 10; i++) {
				System.out.println(gerador.nextInt());
			}

		}

	}

	public void validarUrl(String url) {
		String atual = driver.getCurrentUrl();
		assertEquals(url, atual);

	}

}

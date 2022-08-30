package pages;

import org.openqa.selenium.By;

import conexoes.DriversFactory;
import metodos.Metodos;

public class Home extends DriversFactory{

	Metodos mtd = new Metodos();
	

	public By email = By.id("email_create");
	public By button = By.id("SubmitCreate");

	public void login(String string) {
		mtd.clicar(email);
		mtd.escrever(email,mtd.getRandomEmail());
		mtd.getNomeAleatorio();
		mtd.getSobreNomeAleatorio();
		mtd.esperarElemento(button);
		mtd.submit(button);
		
		

	}

}

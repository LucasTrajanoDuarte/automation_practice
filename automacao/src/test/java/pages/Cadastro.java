package pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import conexoes.DriversFactory;
import metodos.Metodos;

public class Cadastro extends DriversFactory {

	private By titleM = By.id("id_gender1");
	private By titleF = By.id("id_gender2");
	private By firstName = By.id("customer_firstname");
	private By lastName = By.id("customer_lastname");
	private By password = By.id("passwd");
	private By dia = By.id("days");
	private By mes = By.id("months");
	private By ano = By.id("years");
	private By address = By.id("address1");
	private By ct =By.id("city");
	private By state = By.id("id_state");
	private By zip = By.id("postcode");
	private By information = By.id("other");
	private By tel = By.id("phone_mobile");
	private By addres2 = By.id("alias");
	private By submit_final = By.id("submitAccount");
	

	Metodos mtd = new Metodos();
	
	

	public void esperarTitleM(By elemento) {
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
		.until(ExpectedConditions.elementToBeClickable(titleM));

			}

	public void esperarTitleF(By elemento) {
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
		.until(ExpectedConditions.elementToBeClickable(titleF));

			}

	
	public void escolher(Integer type) {
		if (type == 1) {
			driver.findElement(titleM).click();
		} else if (type == 2) {
			driver.findElement(titleF).click();
		}

	}

	

	public void cadastrar(String first, String last, String pass,String end) {

		driver.findElement(firstName).sendKeys(first);
		driver.findElement(lastName).sendKeys(last);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(address).sendKeys("37 E. Victoria St");
		driver.findElement(ct).sendKeys("PRIMARY");
		driver.findElement(state).sendKeys("Florida");
		driver.findElement(zip).sendKeys("32789");
		driver.findElement(tel).sendKeys("86351598");
		driver.findElement(information).sendKeys("test");
		driver.findElement(addres2).sendKeys("JANICE CALLAHAN FL");
	
	}

	public void selectAniversario(Integer d, Integer m, String a,String string,String Colorado ){
		Select selectday = new Select(driver.findElement(dia));
		selectday.selectByIndex(d);
		Select selectmes = new Select(driver.findElement(mes));
		selectmes.selectByIndex(m);
		Select selectano = new Select(driver.findElement(ano));
		selectano.selectByValue(a);
		

	}
	
	public void submit() {
		mtd.esperarElemento(submit_final);
		driver.findElement(submit_final).click();
		
	}

	


}

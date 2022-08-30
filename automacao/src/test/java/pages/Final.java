package pages;

import static org.junit.Assert.assertEquals;

import conexoes.DriversFactory;

public class Final extends DriversFactory{
	
	public void validar_Url(String url) {
		String atual = driver.getCurrentUrl();
		assertEquals(url, atual);
		
	}
}

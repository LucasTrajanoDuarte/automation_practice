package steps;

import elementos.Elementos;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import metodos.Metodos;
import pages.Cadastro;
import pages.Final;
import pages.Home;

public class Test {

	Metodos mt = new Metodos();
	Elementos el = new Elementos();
	Home hm = new Home();
	Cadastro cadastro = new Cadastro();
	Final fl = new Final();
	

	@Dado("que estou na tela de login")
	public void queEstouNaTelaDeLogin() {
		hm.login(null);

	}

	@Dado("acesso o cadastro de usuario")
	public void acessoOCadastroDeUsuario() {
		cadastro.esperarTitleM(null);
		cadastro.esperarTitleF(null);
		cadastro.escolher(1);
	}

	@Quando("preencho o formulario de cadastro")
	public void preenchoOFormularioDeCadastro() {
		cadastro.selectAniversario(1, 3,"2022", "Random1senha", null);
		cadastro.cadastrar(mt.getNomeAleatorio(), mt.getSobreNomeAleatorio(), "132217", null );
	}

	@Quando("clico em registar")
	public void clicoEmRegistar() {
		cadastro.submit();
	}

	@Entao("vejo a mensagem de cadastro realizado com sucesso")
	public void vejoAMensagemDeCadastroRealizadoComSucesso() {
		fl.validar_Url("http://automationpractice.com/index.php?controller=my-account");
		
	}
}

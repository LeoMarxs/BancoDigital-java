

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ValidacaoHelperTest {


	public void testDeveCadastrarContaComTodosDados() {
		Conta conta = new Conta();
		conta.getPessoa().setNome("Teste");
		conta.getPessoa().setCpf("111-111-111-11");
		conta.getPessoa().setGenero(Genero.modificarStringToGenero("Masculino"));
		conta.getPessoa().setDataNascimento(new Date());
		conta.setNumero("000000-0");
		
		assertTrue(ValidacaoHelper.isPossivelCadastrarConta(conta));
	}
	

	private void assertTrue(boolean possivelCadastrarConta) {
	
		throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
	}


	public void testNaoDeveCadastrarContaComTodosDados() {
		Conta conta = null;
		
		assertFalse(ValidacaoHelper.isPossivelCadastrarConta(conta));
	}
	

	private void assertFalse(boolean possivelCadastrarConta) {

		throw new UnsupportedOperationException("Unimplemented method 'assertFalse'");
	}


	public void testPossivelDepositarDinheiro() {
		assertTrue(ValidacaoHelper.isPossivelRealizarDeposito(10.0));
	}
	

	public void testNaoPossivelDepositarDinheiro() {
		assertFalse(ValidacaoHelper.isPossivelRealizarDeposito(0.0));
	}
	

	public void testDeveSerPossivelRealizarTransacao() {
		Conta conta = new Conta();
		conta.setSaldo(50.0);
		
		assertTrue(ValidacaoHelper.isPossivelRealizarOperacaoBancaria(conta, 10.0));
	}
	

	public void testNaoDeveSerPossivelRealizarTransacao() {
		Conta conta = new Conta();
		conta.setSaldo(50.0);
		
		assertFalse(ValidacaoHelper.isPossivelRealizarOperacaoBancaria(conta, 60.0));
	}
	

	public void testExisteConta() {
		List<Conta> contas = new ArrayList<Conta>();
		
		Conta conta = new Conta();
		conta.setPessoa(new Pessoa());
		conta.getPessoa().setCpf("111-111-111-11");
		
		contas.add(conta);
		
		assertTrue(ValidacaoHelper.isContaExistente(contas, conta.getPessoa().getCpf()));
	}
	

	public void testNaoExisteConta() {
		List<Conta> contas = new ArrayList<Conta>();
		
		assertFalse(ValidacaoHelper.isContaExistente(contas, "111-111-111-11"));
	}
	

	public void testDeveSolicitarCartaoCreditoComSaldoMaiorQueCinquentaReais() {
		Conta conta = new Conta();
		conta.setSaldo(60.0);
		
		assertTrue(ValidacaoHelper.isPossivelSolicitarCartao(conta));
	}
	

	public void testNaoDeveSolicitarCartaoCreditoComSaldoMenorQueCinquentaReais() {
		Conta conta = new Conta();
		conta.setSaldo(10.0);
		
		assertFalse(ValidacaoHelper.isPossivelSolicitarCartao(conta));
	}

}

public class TransacaoHelperTest {

	public void testDeveSacar() {
		Conta conta = new Conta();
		conta.setSaldo(50.0);
		
		TransacaoHelper transacaoHelper = new TransacaoHelper();
		transacaoHelper.sacar(conta, 10.0);
		
		assertTrue(conta.getSaldo() == 40.0);
	}
	
	private void assertTrue(boolean b) {
		
		throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
	}


	public void testNaoDeveSacar() {
		Conta conta = new Conta();
		conta.setSaldo(50.0);
		
		TransacaoHelper transacaoHelper = new TransacaoHelper();
		transacaoHelper.sacar(conta, 60.0);
		
		assertTrue(conta.getSaldo() == 50.0);
	}
	

	public void testDeveDepositar() {
		Conta conta = new Conta();
		
		TransacaoHelper transacaoHelper = new TransacaoHelper();
		transacaoHelper.depositar(conta, 10.0);
		
		assertTrue(conta.getSaldo() == 10.0);
	}
	

	public void testDeveTransferir() {
		Conta conta1 = new Conta();
		conta1.setSaldo(50.0);
		
		Conta conta2 = new Conta();
		
		TransacaoHelper transacaoHelper = new TransacaoHelper();
		transacaoHelper.transferir(conta1, conta2, 10.0);
		
		assertTrue(conta1.getSaldo() == 40.0 && conta2.getSaldo() == 10.0);
	}
	

	public void testNaoDeveTransferir() {
		Conta conta1 = new Conta();
		conta1.setSaldo(50.0);
		
		Conta conta2 = new Conta();
		
		TransacaoHelper transacaoHelper = new TransacaoHelper();
		transacaoHelper.transferir(conta1, conta2, 60.0);
		
		assertTrue(conta1.getSaldo() == 50.0 && conta2.getSaldo() == 0.0);
	}

}
package core;

import ui.Tela;

public class Programa {
	public static void main(String[] args) {
		Tela tela = new Tela();
		tela.exibeMarketingBanco();
		Cliente cliente1 = new Cliente("Maria");
		Conta conta1 = new Conta(cliente1, "1234-5", "001", 100);
		String numContaLida = tela.lerContaUsuario();
		
		if (numContaLida.equals(conta1.getNumero())) {
			int tipoOperacaoLida = tela.exibeMenuOperacoes();
			switch (tipoOperacaoLida) {
				case 1:
					double valorSacar = tela.lerValor();
					conta1.sacar(valorSacar);
					break;
				case 2:
					double valorDepositar = tela.lerValor();
					conta1.depositar(valorDepositar);
					break;
				case 3:
					tela.exibeSaldo(conta1, cliente1);
					break;
				default:
					break;
			}
		} else {
			tela.exibeMensagensDeAlertas(4);
		}
	}
}

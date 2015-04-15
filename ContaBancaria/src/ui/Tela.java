package ui;
import java.util.Scanner;
import core.Conta;
import core.Cliente;

public class Tela {
	
	private Scanner sc;
	
	public Tela() {
		this.sc = new Scanner(System.in);
	}
	
	public void exibeMarketingBanco() {
		System.out.println("Bem vindo ao Banco aqui Seu dinheiro rende mais para nós - S/A.");
		System.out.println("---------------------------------------------------------------");
	}

	public void exibeMensagensDeAlertas(int tipo) {
		
		switch (tipo) {
			case 1:
				System.out.println("Saldo insuficiente");
				break;
			case 2:
				System.out.println("Valor inválido");
				break;
			case 3:
				System.out.println("Saque realizado com sucesso.");
				break;
			case 4:
				System.out.println("Conta inválida ou inexistente.");
				break;	
			case 5:
				System.out.println("Depósito realizado com sucesso.");
				break;	
			default:
				break;
		}		
	}
	
	public String lerContaUsuario() {
		System.out.println("Digite o numnero da conta: ");
		String contaLida = sc.next();
		return contaLida;
	}
	
	public int exibeMenuOperacoes() {
		System.out.println("Selecione operação: [1 - Saque, 2 - Deposito, 3 - Consultar saldo]: ");
		int opcao = sc.nextInt();
		return opcao;
	}
	
	public double lerValor() {
		System.out.println("Informe o valor: ");
		double valor = sc.nextDouble();
		return valor;
	}
	
	public void exibeSaldo(Conta conta, Cliente titular) {
		System.out.println("Banco aqui Seu dinheiro rende mais para nós - S/A.");
		System.out.println("--------------------------------------------------");
		System.out.println("-------------------CONSULTA DE SALDO--------------");
		System.out.println("Cliente: " + titular.getNome());
		System.out.println("Número da conta: " + conta.getNumero());
		System.out.println("Agência: " + conta.getAgencia());
		System.out.println("Saldo Atual: R$ " + conta.getSaldo());
		System.out.println("-------------------------------------------------");
	}
}

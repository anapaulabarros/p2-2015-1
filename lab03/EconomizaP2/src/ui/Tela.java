package ui;

import java.util.Scanner;

public class Tela {
	private Scanner sc;
	
	public Tela() {
		this.sc = new Scanner(System.in);
	}
	
	public void exibeMensagensAlerta(int opcao) {
		switch (opcao) {
			case 1:
				System.out.println("= = = = Bem-vindo(a) ao EconomizaP2 = = = =");
				break;
			case 2:
				System.out.print("Digite nome do produto: ");
				break;
			case 3:
				System.out.print("Digite o preço unitário do produto: ");
				break;
			case 4:
				System.out.print("Digite o tipo do produto: ");
				break;	
			case 5:
				System.out.println("= = = = Cadastro de Produtos = = = =");
				System.out.println(" ");
				break;	
			case 6:
				System.out.println("= = = = Venda de Produtos = = = =");
				System.out.println(" ");
				break;
			default:
				break;
		}
	}
	
	public int exibeMenuOpcoes() {
		System.out.println("Digite a opção desejada:");
		System.out.println("1 - Cadastrar um produto");
		System.out.println("2 - Vender um produto");
		System.out.println("3 - Imprimir balaço");
		System.out.println("4 - Sair");
		System.out.println("   ");
		System.out.print("Opcao: ");
		int opcaoLida = sc.nextInt();
		sc.nextLine();
		return opcaoLida;
	}
	
	public String lerNomeProduto() {
		exibeMensagensAlerta(2);
		String nomeLida = sc.nextLine();
		return nomeLida;
	}
	
	public double lerPrecoUnitario() {
		exibeMensagensAlerta(3);
		double precoLido = sc.nextDouble();
		sc.nextLine();
		return precoLido;
	}
	
	public String lerTipoProduto() {
		exibeMensagensAlerta(4);
		String tipoLido = sc.nextLine();
		return tipoLido;
	}
	
	public void exibeResultadoCadastro(String nome) {
		System.out.println("   ");
		System.out.println(nome + " cadastrado com sucesso.");
		System.out.println("   ");
	}
	
	public String ContinuarCadastar() {
		System.out.print("Deseja cadastrar outro produto? ");
		String opcao = sc.nextLine();
		return opcao;
	}
}

package ui;

import java.util.Scanner;

import core.Produto;

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
				System.out.println(" ");
				System.out.println("= = = = Venda de Produtos = = = =");
				System.out.println(" ");
				break;
			case 7:
				System.out.println(" ");
				System.out.println("Ainda não há nenhum produto cadastrado no sistema.");
				System.out.println(" ");
				break;	
			case 8:
				System.out.println(" ");
				System.out.print("Digite a quantidade que deseja vender: ");
				System.out.println(" ");
				break;
			case 9:
				System.out.println(" ");
				System.out.println("= = = = Impressao de Balanco = = = =");
				System.out.println(" ");
				break;
			case 10:
				System.out.println(" ");
				System.out.println("Nao há balanço, pois ainda não há vendas realizadas.");
				System.out.println(" ");
				break;	
			case 11:
				System.out.print("Digite a quantidade no estoque: ");
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
	
	public int lerQuantidadeProduto() {
		exibeMensagensAlerta(8);
		int qtdLida = sc.nextInt();
		sc.nextLine();
		return qtdLida;
	}
	
	public int lerQuantidade() {
		exibeMensagensAlerta(11);
		int qtdLida = sc.nextInt();
		sc.nextLine();
		return qtdLida;
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
	
	public void exibeResultadoCadastro(String nome, int quantidade) {
		System.out.println("   ");
		System.out.println(quantidade + " " + nome + "(s) cadastrado com sucesso.");
		System.out.println("   ");
	}
	
	public String ContinuarCadastar() {
		System.out.print("Deseja cadastrar outro produto? ");
		String opcao = sc.nextLine();
		return opcao;
	}
	
	public String ContinuarVender() {
		System.out.println("Deseja vender outro produto? ");
		String opcao = sc.nextLine();
		return opcao;
	}
	
	public String ContinuarOperar() {
		System.out.print("Deseja realizar alguma operacao? ");
		String opcao = sc.nextLine();
		return opcao;
	}
	
	public void exibeMensagemProdutoNaoCadastrado(String nome) {
		System.out.print("==> "+ nome + " não cadastrado no sistema.");
		System.out.println(" ");
	}
	
	public void exibeDetalhesProduto(Produto produto) {
		System.out.println("==> " + produto.getNome() + " (" + produto.getCategoria() + "). R$ " + produto.getPreco());
	}
	
	public void exibeTotalArrecadado(double totalArrecadoPorProduto) {
		System.out.println("==> Total arrecadado: R$ " + totalArrecadoPorProduto);
	}
	
	public void exibeTotalDasVendas(double vendaTotal) {
		System.out.println(" ");
		System.out.println("Total arrecadado em vendas: R$ " + vendaTotal);
	}
	public void exibeTotalDasVendasNaoRealizadas(double vendasNaoRealizadas) {
		System.out.println("Total que pode ser arrecadado: R$ " + vendasNaoRealizadas);
		System.out.println(" ");
	}
	
	public void exibeProdutoCadastrado(int contador, Produto produto) {
		System.out.println(contador + " ) " + produto.getNome() + "(" + produto.getCategoria() + "). R$ " + produto.getPreco() +
				" Restante: " + produto.getQuantidade());
	}
	
	public void exibeVendaProibida(String nomeProduto) {
		System.out.println("Não é possível vender pois não há " + nomeProduto +" suficiente.");
	}
}

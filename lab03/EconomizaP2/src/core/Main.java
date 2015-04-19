package core;
import ui.Tela;

public class Main {
	public static void main(String[] args) {
			
		Tela tela = new Tela();
		Produto[] produtos = new Produto[5];
		double[] listaVendas = new double[5];
		int cont = 0;
		final int OP_CADASTRA = 1;
		final int OP_VENDE = 2;
		final int OP_BALANCO = 3;
		final int OP_SAIR = 4;
		
		tela.exibeMensagensAlerta(1);
			
		int opcaoEscolhida = tela.exibeMenuOpcoes(); 
		while (opcaoEscolhida != OP_SAIR) { 
			switch (opcaoEscolhida) {
				case OP_CADASTRA:
					String cadastra = "Sim";
					tela.exibeMensagensAlerta(5);
					while (cadastra.equals("Sim")) {
						cadastraProduto(tela, produtos, cont);
						String opcaoOperacao = tela.ContinuarCadastar();
						cont++;
						if (opcaoOperacao.equals("Nao")) {
							break;
						}
					}
					break;
				case OP_VENDE:
					if (cont > 0 && produtos[cont - 1] != null){
						String vendas = "Sim";
						while (vendas.equals("Sim")) {
							double valorVenda = vendaProdutos(tela, produtos);
							listaVendas[cont] = valorVenda; //armazena os valores arrecadados da venda
							String opcaoOperacao = tela.ContinuarVender();
							if (opcaoOperacao.equals("Nao")) {
								break;
							}
						}
					} else {
						tela.exibeMensagensAlerta(7);
					}
					break;
				case OP_BALANCO:
					double somaTotal = 0;
					double somaProdutosNaoVendidos = 0;
					if (cont > 0 && produtos[cont - 1] != null){
						tela.exibeMensagensAlerta(9);
						System.out.println("Produtos cadastrados:");
						for (int i = 0; i < produtos.length ; i++) {
							if (produtos[i] != null) {
								tela.exibeProdutoCadastrado(i + 1, produtos[i]);
								somaProdutosNaoVendidos += produtos[i].getPreco() * produtos[i].getQuantidade();
							}
							somaTotal += listaVendas[i];
						}
						tela.exibeTotalDasVendas(somaTotal);
						tela.exibeTotalDasVendasNaoRealizadas(somaProdutosNaoVendidos);
					}else {
						tela.exibeMensagensAlerta(10);
					}
					break;
				case OP_SAIR:
					System.exit(1);
				default:
					System.exit(1);
					
			}
			opcaoEscolhida = tela.exibeMenuOpcoes();
		}		
	}

	public static void cadastraProduto(Tela tela, Produto[] produtos,int controle) {	
		produtos[controle] = new Produto(tela.lerNomeProduto(), tela.lerPrecoUnitario(), tela.lerTipoProduto(), tela.lerQuantidade());
		tela.exibeResultadoCadastro(produtos[controle].getNome(), produtos[controle].getQuantidade());
	}
	
	public static int buscaProduto(Produto[] produtos, String nomeProduto) {
		int valor = -100;
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] == null) {
				break;
			}else if (produtos[i].getNome().equals(nomeProduto)) {
				valor = i;
				break;
			}
		}
		return valor;
	}
	public static double vendaProdutos(Tela tela, Produto[] produtos){
		double valorVenda = 0;
		tela.exibeMensagensAlerta(6);
		String produtoProcurado = tela.lerNomeProduto();
		
		int resultadoBusca = buscaProduto(produtos, produtoProcurado);
		if (resultadoBusca == -100) {
			tela.exibeMensagemProdutoNaoCadastrado(produtoProcurado);
		} else {
			tela.exibeDetalhesProduto(produtos[resultadoBusca]);
			int qtdProdutovender = tela.lerQuantidadeProduto();
			if (qtdProdutovender <= produtos[resultadoBusca].getQuantidade()) {
				double calculaTotal = calculaArracadacao(produtos[resultadoBusca].getPreco(), qtdProdutovender);
				valorVenda = calculaTotal;
				tela.exibeTotalArrecadado(calculaTotal);
				produtos[resultadoBusca].setQuantidade(produtos[resultadoBusca].getQuantidade() - qtdProdutovender); // atualiza estoque do produto
				
			}else {
				tela.exibeVendaProibida(produtos[resultadoBusca].getNome());
			}
			
		}
		return valorVenda;
	}
	
	public static double calculaArracadacao(double preco, int qtdProduto){
		double total = preco * qtdProduto;
		return total;
	}
	
}
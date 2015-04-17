package core;
import ui.Tela;

public class Main {
	public static void main(String[] args) {
			
		Tela tela = new Tela();
		Produto[] produtos = new Produto[5];
		int cont = 0;
		
		tela.exibeMensagensAlerta(1);
			
		int opcaoEscolhida = tela.exibeMenuOpcoes(); 
		while (opcaoEscolhida != 4) { 
			switch (opcaoEscolhida) {
				case 1:
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
				case 2:
					if (cont > 0 && produtos[cont - 1] != null){
						String vendas = "Sim";
						while (vendas.equals("Sim")) {
							vendaProdutos(tela, produtos);
							String opcaoOperacao = tela.ContinuarVender();
							if (opcaoOperacao.equals("Nao")) {
								break;
							}
						} 
					} else {
						tela.exibeMensagensAlerta(7);
					}
					break;
				case 3:
					System.out.println("balanco");
					System.exit(1);
				case 4:
					System.exit(1);
				default:
					System.exit(1);
					
			}
			opcaoEscolhida = tela.exibeMenuOpcoes();
		}		
	}

	public static void cadastraProduto(Tela tela, Produto[] produtos,int controle) {	
		produtos[controle] = new Produto(tela.lerNomeProduto(), tela.lerPrecoUnitario(), tela.lerTipoProduto());
		tela.exibeResultadoCadastro(produtos[controle].getNome());
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
	public static void vendaProdutos(Tela tela, Produto[] produtos){
		tela.exibeMensagensAlerta(6);
		String produtoProcurado = tela.lerNomeProduto();
		
		int resultadoBusca = buscaProduto(produtos, produtoProcurado);
		if (resultadoBusca == -100) {
			tela.exibeMensagemProdutoNaoCadastrado(produtoProcurado);
		} else {
			tela.exibeDetalhesProduto(produtos[resultadoBusca]);
			int qtdProdutovender = tela.lerQuantidadeProduto();
			double calculaTotal = calculaArracadacao(produtos[resultadoBusca].getPreco(), qtdProdutovender);
			tela.exibeTotalArrecadado(calculaTotal);
		}
	}
	
	public static double calculaArracadacao(double preco, int qtdProduto){
		double total = preco * qtdProduto;
		return total;
	}
	
}
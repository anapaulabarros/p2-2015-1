package core;
import ui.Tela;

public class Main {
	public static void main(String[] args) {
			Tela tela = new Tela();
			final int TAMANHO_ARRAY = 5;
			Produto[] produtos = new Produto[TAMANHO_ARRAY];
			
			tela.exibeMensagensAlerta(1);
			
			int opcaoEscolhida = tela.exibeMenuOpcoes();
			
				if (opcaoEscolhida == 1){
					tela.exibeMensagensAlerta(5);
					for (int i = 0; i < produtos.length; i++) {
					
						produtos[i] = new Produto(tela.lerNomeProduto(), tela.lerPrecoUnitario(), tela.lerTipoProduto());
						tela.exibeResultadoCadastro(produtos[i].getNome());
						
						String opcaoOperacao = tela.ContinuarCadastar();
						if (opcaoOperacao.equals("Nao")) {
							String manipularSistema = tela.ContinuarOperar();
							if (manipularSistema.equals("Sim")) {
								// venda do produto
								tela.exibeMensagensAlerta(6);
								String produtoProcurado = tela.lerNomeProduto();
								
								if (buscaProduto(produtos, produtoProcurado) == false){
									tela.exibeMensagemProdutoNaoCadastrado(produtoProcurado);
								} else {
									tela.exibeDetalhesProduto(produtos[i]);	
									int quantidade = tela.lerQuantidadeProduto();
									tela.exibeTotalArrecadado(produtos[i].getPreco(), quantidade);
									
								}
							}
							return;
						}
					}	
				} else if(opcaoEscolhida == 2) {
					if (produtos[0] == null) {
						tela.exibeMensagensAlerta(7);
						return;
					}
					
				} else if(opcaoEscolhida == 4) {
					tela.exibeMensagensAlerta(9);
					System.exit(1);
				}		
				
				
	}

	public static boolean buscaProduto(Produto[] produtos, String nomeProduto) {
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] == null) {
				return false;
			} else if (produtos[i].getNome().equals(nomeProduto)) {
				return true;
			} 			
		}
		return false;
	}
	
	
}
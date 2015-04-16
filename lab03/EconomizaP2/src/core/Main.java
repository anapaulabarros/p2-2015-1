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
							return;
						}
					}
				} else if(opcaoEscolhida == 4) {
					System.exit(1);
				}	
				
				
	}

	public static boolean buscaProduto(Produto[] produtos, String nomeProduto) {
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i].getNome().equals(nomeProduto)) {
				return true;
			} 			
		}
		return false;
	}
}
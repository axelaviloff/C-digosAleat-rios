programa {
	inclua biblioteca Util --> u //Biblioteca para permitir o computador gerar valores aleatórios
	
	funcao inicio() {
		cadeia nomeJogadorA
		cadeia nomeJogadorB
		cadeia aguarde
		inteiro opc
		inteiro opcJogadorA
		inteiro opcJogadorB
		inteiro opcComputador
		inteiro vencedor
		faca {
			limpa()
			escreva("\n      ##  #######   ######    #######  \n")
			escreva("      ## ##     ## ##    ##  ##     ## \n")
			escreva("      ## ##     ## ##        ##     ## \n")
			escreva("      ## ##     ## ##   #### ##     ## \n")
			escreva("##    ## ##     ## ##    ##  ##     ## \n")
			escreva("##    ## ##     ## ##    ##  ##     ## \n")
			escreva(" ######   #######   ######    #######  \n")
			
			escreva("----------PEDRA----------PAPEL----------TESOURA----------\n")
			escreva("------------------PRONTO PARA COMEÇAR?-------------------\n")
			escreva("1-JOGADOR(A) X COMPUTADOR\n")
		     escreva("2-JOGADOR(A) X JOGADOR(B)\n")
		     escreva("3-SAIR\n=> ")
		     leia(opc)

			se (opc == 1) {
				escreva("DIGITE O SEU NOME: ")
			     leia(nomeJogadorA)
			     limpa()
			     escreva(nomeJogadorA,", ESCOLHA UMA DAS OPÇÕES ABAIXO:\n")
			     escreva("\t0 - PEDRA\n")
			     escreva("\t1 - PAPEL\n")
			     escreva("\t2 - TESOURA\n")
			     escreva("OPÇÃO:")
			     leia(opcJogadorA)
			     opcComputador = u.sorteia(0, 2) // Escolha do computador. Um valor entre 0 e 2 (inclusive)
			     
			     vencedor = verificaGanhador(opcJogadorA, opcComputador)

				escreva("\nRESULTADO:\n")
			     escreva(nomeJogadorA," ESCOLHEU: ", opcJogadorA, "\n")
			     escreva("COMPUTADOR ESCOLHEU: ", opcComputador, "\n")
			     
			     se (vencedor == -1) {
			    		escreva(nomeJogadorA," GANHOU!\n\n")
					escreva("##     ##  #######   ######  ########     ######      ###    ##    ## ##     ##  #######  ##     ## \n")
					escreva("##     ## ##     ## ##    ## ##          ##    ##    ## ##   ###   ## ##     ## ##     ## ##     ## \n")
					escreva("##     ## ##     ## ##       ##          ##         ##   ##  ####  ## ##     ## ##     ## ##     ## \n")
					escreva("##     ## ##     ## ##       ######      ##   #### ##     ## ## ## ## ######### ##     ## ##     ## \n")
					escreva(" ##   ##  ##     ## ##       ##          ##    ##  ######### ##  #### ##     ## ##     ## ##     ## \n")
					escreva("  ## ##   ##     ## ##    ## ##          ##    ##  ##     ## ##   ### ##     ## ##     ## ##     ## \n")
					escreva("   ###     #######   ######  ########     ######   ##     ## ##    ## ##     ##  #######   #######  \n")
			     } senao
			     se (vencedor == 1) {
			     	escreva("COMPUTADOR GANHOU!\n\n")
				     escreva("##     ##  #######   ######  ########    ########  ######## ########  ########  ######## ##     ## \n")
				     escreva("##     ## ##     ## ##    ## ##          ##     ## ##       ##     ## ##     ## ##       ##     ## \n")
				     escreva("##     ## ##     ## ##       ##          ##     ## ##       ##     ## ##     ## ##       ##     ## \n")
				     escreva("##     ## ##     ## ##       ######      ########  ######   ########  ##     ## ######   ##     ## \n")
				     escreva(" ##   ##  ##     ## ##       ##          ##        ##       ##   ##   ##     ## ##       ##     ## \n")
				     escreva("  ## ##   ##     ## ##    ## ##          ##        ##       ##    ##  ##     ## ##       ##     ## \n")
				     escreva("   ###     #######   ######  ########    ##        ######## ##     ## ########  ########  #######  ")
			     } senao {
			     	escreva("NINGUÉM GANHOU!\n\n")
				     escreva("######## ##     ## ########     ###    ######## ######## \n")
				     escreva("##       ###   ### ##     ##   ## ##      ##    ##       \n")
				     escreva("##       #### #### ##     ##  ##   ##     ##    ##       \n")
				     escreva("######   ## ### ## ########  ##     ##    ##    ######   \n")
				     escreva("##       ##     ## ##        #########    ##    ##       \n")
				     escreva("##       ##     ## ##        ##     ##    ##    ##       \n")
				     escreva("######## ##     ## ##        ##     ##    ##    ######## \n")
			     }
			     escreva("\n\nPressione a tecla Enter para voltar ao menu principal\n")
			     leia(aguarde)
			     
			     
			} senao se (opc == 2) {
				escreva("JOGADOR A, DIGITE O SEU NOME: ")
			     leia(nomeJogadorA)
			     escreva(nomeJogadorA,", ESCOLHA UMA DAS OPÇÕES ABAIXO:\n")
			     escreva("\t0 - PEDRA\n")
			     escreva("\t1 - PAPEL\n")
			     escreva("\t2 - TESOURA\n")
			     escreva("OPÇÃO:")
			     leia(opcJogadorA)

			     escreva("\nJOGADOR B, DIGITE O SEU NOME: ")
			     leia(nomeJogadorB)
			     escreva(nomeJogadorB,", ESCOLHA UMA DAS OPÇÕES ABAIXO:\n")
			     escreva("\t0 - PEDRA\n")
			     escreva("\t1 - PAPEL\n")
			     escreva("\t2 - TESOURA\n")
			     escreva("OPÇÃO:")
			     leia(opcJogadorB)

			     vencedor = verificaGanhador(opcJogadorA, opcJogadorB)

			     escreva("\nRESULTADO:\n")
			     escreva(nomeJogadorA, " ESCOLHEU: ", opcJogadorA, "\n")
			     escreva(nomeJogadorB, " ESCOLHEU: ", opcJogadorB, "\n")

			     se (vencedor == -1) {
			     	escreva(nomeJogadorA, " GANHOU!\n\n")
			     	escreva("########     ###    ########     ###    ########  ######## ##    ##  ######  \n")
			     	escreva("##     ##   ## ##   ##     ##   ## ##   ##     ## ##       ###   ## ##    ## \n")
			     	escreva("##     ##  ##   ##  ##     ##  ##   ##  ##     ## ##       ####  ## ##       \n")
			     	escreva("########  ##     ## ########  ##     ## ########  ######   ## ## ##  ######  \n")
			     	escreva("##        ######### ##   ##   ######### ##     ## ##       ##  ####       ## \n")
			     	escreva("##        ##     ## ##    ##  ##     ## ##     ## ##       ##   ### ##    ## \n")
			     	escreva("##        ##     ## ##     ## ##     ## ########  ######## ##    ##  ######  \n")
			     } senao
			     se (vencedor == 1) {
			     	escreva(nomeJogadorB, " GANHOU!\n\n")
			     	escreva("########     ###    ########     ###    ########  ######## ##    ##  ######  \n")
			     	escreva("##     ##   ## ##   ##     ##   ## ##   ##     ## ##       ###   ## ##    ## \n")
			     	escreva("##     ##  ##   ##  ##     ##  ##   ##  ##     ## ##       ####  ## ##       \n")
			     	escreva("########  ##     ## ########  ##     ## ########  ######   ## ## ##  ######  \n")
			     	escreva("##        ######### ##   ##   ######### ##     ## ##       ##  ####       ## \n")
			     	escreva("##        ##     ## ##    ##  ##     ## ##     ## ##       ##   ### ##    ## \n")
			     	escreva("##        ##     ## ##     ## ##     ## ########  ######## ##    ##  ######  \n")
			     } senao {
			     	escreva("NINGUÉM GANHOU!\n\n")
				     escreva("######## ##     ## ########     ###    ######## ######## \n")
				     escreva("##       ###   ### ##     ##   ## ##      ##    ##       \n")
				     escreva("##       #### #### ##     ##  ##   ##     ##    ##       \n")
				     escreva("######   ## ### ## ########  ##     ##    ##    ######   \n")
				     escreva("##       ##     ## ##        #########    ##    ##       \n")
				     escreva("##       ##     ## ##        ##     ##    ##    ##       \n")
				     escreva("######## ##     ## ##        ##     ##    ##    ######## \n")
			     }
			     
			     escreva("\n\nPressione a tecla Enter para voltar ao menu principal\n")
			     leia(aguarde)
 
			}
			
			
		} enquanto (opc != 3)
		
	}
	//Se empate retorna 0, se jogador A ganhou retorna -1, se jogador B ganhou retorna 1
	funcao inteiro verificaGanhador(inteiro escolhaA, inteiro escolhaB) {
		se (escolhaA == escolhaB) {
			retorne 0
		} senao
		se (escolhaA == 0 e escolhaB == 1) {
			retorne 1
		} senao
		se (escolhaA == 0 e escolhaB == 2) {
			retorne -1
		} senao 
		se (escolhaA == 1 e escolhaB == 0) {
			retorne -1
		} senao
		se (escolhaA == 1 e escolhaB == 2) {
			retorne 1
		} senao
		se (escolhaA == 2 e escolhaB == 0) {
			retorne 1
		} senao {
			retorne -1
		}
				
	}

	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1044; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
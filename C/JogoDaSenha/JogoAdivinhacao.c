#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#define VERMELHO    "\x1b[31m"
#define VERDE   "\x1b[32m"
#define AZUL    "\x1b[34m"
#define RESET   "\x1b[0m"
#define AMARELO "\x1b[33m"
#define TITULO "\x1b[4;35m"


void SorteiaSenha(char senhaSorteada[4]) {
    srand(time(NULL));
    for (int i = 0; i < 4; i++) {
    senhaSorteada[i] = (rand() % 10) + '0';
    }
}


void MostraAcertos(char numeroDigitado[4], char senhaSorteada[4]) {
    printf("\nResultado: \t");
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if ((numeroDigitado[i] == senhaSorteada[j]) && (i == j)) {
                printf(VERDE "1\t" RESET);
                break;
            } else if (numeroDigitado[i] == senhaSorteada[j]) {
                printf(AZUL "0\t" RESET);
                break;
            } else {
                if (j == 3) {
                    printf(VERMELHO "-1\t" RESET);
                    break;
                }
            }
        } 
    }
}


int RealizaJogada(char senhaSorteada[4]) {
    char numeroDigitado[4];
    int tamanhoNumero;
    int contador = 0;
    for (int tentativas = 10; tentativas > 0; tentativas--) {
        printf("\nTente adivinhar a senha de 4 digitos.");
        printf("\nVoce tem %s%d%s tentativas.\nDigite a senha\n=> ", AMARELO, tentativas, RESET);
        scanf("%s", &numeroDigitado);
        tamanhoNumero = strlen(numeroDigitado);
        while (tamanhoNumero != 4) {
            printf("Entrada invalida.\n=> ");
            scanf("%s", &numeroDigitado);
            tamanhoNumero = strlen(numeroDigitado);
        }
        system("cls");
        printf("Sua tentativa: \t");
        for (int k = 0; k < 4; k++) {
            printf("%c\t", numeroDigitado[k]);
        }
        
        MostraAcertos(numeroDigitado, senhaSorteada);
        
        for (int i = 0; i < 4; i++) {
            if (numeroDigitado[i] == senhaSorteada[i])
                contador++;
        }
       
        if (contador == 4) 
            return 1;
        
        contador = 0;
    }
    return 0;
}


int main() {
    int resultado;
    char senhaSorteada[4];
    system("cls");
    printf(TITULO "JOGO DA ADIVINHACAO\n" RESET);
    SorteiaSenha(senhaSorteada);
    printf("%s\n", senhaSorteada);
    resultado = RealizaJogada(senhaSorteada);
    if (resultado == 1) {
        printf(VERDE "\nVOCE GANHOU!" RESET);
    } else {
        printf(VERMELHO "\nVOCE PERDEU!" RESET);
    }
    printf("\nA SENHA CORRETA ERA:\n");
    for (int i = 0; i < 4; i++) {
        printf("%c\t", senhaSorteada[i]);
    }

    system("PAUSE");

    return 0;
}
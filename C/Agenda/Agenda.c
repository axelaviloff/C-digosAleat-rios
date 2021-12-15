//Programa: Gerenciador de uma agênda de contatos.
//Autor(a): 
//Universidade: 
//Disciplina:
//Data:

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <locale.h>
#include <ctype.h>


typedef struct {
    int  telefone;
    char nome[100];
    char sexo;
    char email[100];
    char tipo; //C - Comercial P - Pessoal
} Contato;

void cadastrarContato(Contato *agenda, int *n, int *max);
void pesquisarContatoEmail(Contato *agenda, int *n);
void pesquisarContatoNome(Contato *agenda, int *n);
void listarContatoNome(Contato *agenda, int *n, char alfabeto[]);
void listarContatoEmail(Contato *agenda, int *n, char alfabeto[]);
void alterarContato(Contato *agenda, int *n);
void removerContato(Contato *agenda, int *n);
void listarContatoSexo(Contato *agenda, int *n);
void listarContatoTipo(Contato *agenda, int *n);

int main(void) {
    setlocale(LC_ALL, "Portuguese");
    char alfabeto[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M','N', 'O',
                       'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    int n = 0;
    int max = 10;
    Contato *agenda;
    agenda = (Contato *) malloc(sizeof(Contato) * max);
    int opc;
    do {
        printf("========== AGENDA DE CONTATOS ==========\n");
        printf("[1] Cadastrar Contato\n");
        printf("[2] Pesquisar contato pelo email\n");
        printf("[3] Pesquisar contato pelo nome\n");
        printf("[4] Listar todos os contatos ordenados pelo nome\n");
        printf("[5] Listar todos os contatos ordenados pelo email\n");
        printf("[6] Alterar dados de um contato\n");
        printf("[7] Remover um contato\n");
        printf("[8] Listar todos os contatos ordenados pelo sexo\n");
        printf("[9] Listar todos os contatos ordenados pelo tipo\n");
        printf("[10] Sair\n");
        printf("=> ");
        scanf("%d", &opc);

        switch(opc) {
            case 1:
                cadastrarContato(agenda, &n, &max);
                break;
            case 2:
                pesquisarContatoEmail(agenda, &n);
                break;
            case 3:
                pesquisarContatoNome(agenda, &n);
                break;
            case 4:
                listarContatoNome(agenda, &n, alfabeto);
                break;
            case 5:
                listarContatoEmail(agenda, &n, alfabeto);
                break;
            case 6:
                alterarContato(agenda, &n);
                break;
            case 7:
                removerContato(agenda, &n);
                break;
            case 8:
                listarContatoSexo(agenda, &n);
                break;
            case 9:
                listarContatoTipo(agenda, &n);
                break;
      }

    } while (opc != 10);

    return 0;
}


void flush_in() {
   int ch;
   while( (ch = fgetc(stdin)) != EOF && ch != '\n' ){}
}


void listarContatoTipo(Contato *agenda, int *n) {
    for (int i = 0; i < *n; i++) {
            if (agenda[i].tipo == 'P') {
                printf("%s\n", agenda[i].nome);
                printf("Tipo: Pessoal\n");
                printf("%s\n", agenda[i].email);
                printf("%d\n", agenda[i].telefone);
                printf("\n");
            }
        }
    for (int i = 0; i < *n; i++) {
            if (agenda[i].tipo == 'C') {
                printf("%s\n", agenda[i].nome);
                printf("Tipo: Comercial\n");
                printf("%s\n", agenda[i].email);
                printf("%d\n", agenda[i].telefone);
                printf("\n");
            }
        }
}


void listarContatoSexo(Contato *agenda, int *n) {
    for (int i = 0; i < *n; i++) {
            if (agenda[i].sexo == 'M') {
                printf("%s\n", agenda[i].nome);
                printf("Sexo: M\n");
                printf("%s\n", agenda[i].email);
                printf("%d\n", agenda[i].telefone);
                printf("\n");
            }
        }
    for (int i = 0; i < *n; i++) {
            if (agenda[i].sexo == 'F') {
                printf("%s\n", agenda[i].nome);
                printf("Sexo: F\n");
                printf("%s\n", agenda[i].email);
                printf("%d\n", agenda[i].telefone);
                printf("\n");
            }
        }
}


void removerContato(Contato *agenda, int *n) {
    char nome[100];
    int j, i;
    bool removido = false;
    flush_in();
    printf("Digite o nome do contato que sera removido: ");
    gets(nome);
    nome[0] = toupper(nome[0]);
    for (i = 0; i < *n; i ++){
        if (strcmp(agenda[i].nome, nome) == 0){
            removido = true;
            for (j = i + 1; j < *n; j++){
                agenda[j-1].telefone = agenda[j].telefone;
                strcpy(agenda[j-1].nome, agenda[j].nome);
                agenda[j-1].sexo = agenda[j].sexo;
                strcpy(agenda[j-1].email, agenda[j].email);
                agenda[j-1].tipo = agenda[j].tipo;                
            }
        (*n) --;
        i = *n;
        }
    }     
    if (removido)
        printf("Contato removido com sucesso.\n");
    else
        printf("Contato nao encontrado na agenda.\n");
}


void alterarContato(Contato *agenda, int *n) {
    int opc;
    char nome[100];
    printf("Digite o nome do contato que você deseja alterar: ");
    scanf("%s", nome);
    nome[0] = toupper(nome[0]);
    bool achou = false;
    for (int i = 0; i < *n; i++) {
        if (strcmp(agenda[i].nome, nome) == 0) {
            achou = true;
            do {
                printf("Qual dado voce deseja alterar?\n");
                printf("[1] Nome\n");
                printf("[2] Email\n");
                printf("[3] Telefone\n");
                printf("[4] Tipo\n");
                printf("[5] Voltar\n");
                printf("=> ");
                scanf("%d", &opc);

                switch (opc) {
                    case 1:
                        printf("Digite o novo nome: ");
                        flush_in();
                        gets(agenda[i].nome);
                        (agenda[i].nome)[0] = toupper((agenda[i].nome)[0]);
                        printf("Nome alterado com sucesso.\n");
                        break;
                    case 2:
                        printf("Digite o novo email: ");
                        flush_in();
                        gets(agenda[i].email);
                        printf("Email alterado com sucesso.\n");
                        break;
                    case 3:
                        printf("Digite o novo telefone: ");
                        scanf("%d", &agenda[i].telefone);
                        printf("Telefone alterado com sucesso.\n");
                        break;
                    case 4:
                        printf("Digite o novo tipo:\n[C] - Comercial\n[P] - Pessoal\n=> ");
                        flush_in();
                        scanf("%c", &agenda[i].tipo);
                        agenda[i].tipo = toupper(agenda[i].tipo);
                        printf("Tipo alterado com sucesso.\n");
                        break;
                    case 5:
                        break;

                }
            
            } while (opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5);
        }
    }
    if (!achou) {
        printf("Nome nao encontrado na lista de contatos.\n");
    }

}


void listarContatoEmail(Contato *agenda, int *n, char alfabeto[]) {
    for (int i = 0; i < 26; i++) {
        for (int j = 0; j < *n; j++) {
            if (alfabeto[i] == toupper((agenda[j].email)[0])) {
                printf("Email: %s\n", agenda[j].email);
                printf("Nome: %s\n", agenda[j].nome);
                printf("Telefone: %d\n", agenda[j].telefone);
                if (toupper(agenda[j].sexo) == 'M')
                    printf("Sexo: Masculino\n");
                else
                    printf("Sexo: Feminino\n");
                
                if (toupper(agenda[j].tipo) == 'C')
                    printf("Tipo: Comercial\n");
                else
                    printf("Tipo: Pessoal\n");
                printf("\n");
            }
        }
    }

}


void listarContatoNome(Contato *agenda, int *n, char alfabeto[]) {
    for (int i = 0; i < 26; i++) {
        for (int j = 0; j < *n; j++) {
            if (alfabeto[i] == toupper((agenda[j].nome)[0])) {
                printf("Nome: %s\n", agenda[j].nome);
                printf("Telefone: %d\n", agenda[j].telefone);
                printf("Email: %s\n", agenda[j].email);
                if (toupper(agenda[j].sexo) == 'M')
                    printf("Sexo: Masculino\n");
                else
                    printf("Sexo: Feminino\n");
                
                if (toupper(agenda[j].tipo) == 'C')
                    printf("Tipo: Comercial\n");
                else
                    printf("Tipo: Pessoal\n");
                printf("\n");
            }
        }
    }
}


void pesquisarContatoNome(Contato *agenda, int *n) {
    char nome[100];
    printf("Digite o nome para pesquisar: ");
    scanf("%s", nome);
    nome[0] = toupper(nome[0]);
    bool achou = false;
    for (int i = 0; i < *n; i++) {
        if (strcmp(agenda[i].nome, nome) == 0) {
            printf("Nome: %s\n", agenda[i].nome);
            printf("Telefone: %d\n", agenda[i].telefone);
            printf("Email: %s\n", agenda[i].email);
            if (toupper(agenda[i].sexo) == 'M')
                printf("Sexo: Masculino\n");
            else
                printf("Sexo: Feminino\n");
            
            if (toupper(agenda[i].tipo) == 'C')
                printf("Tipo: Comercial\n");
            else
                printf("Tipo: Pessoal\n");
            achou = true;
            break;
        }
    }
    if (!achou) {
        printf("Nome nao encontrado na lista de contatos.\n");
    }

}


void pesquisarContatoEmail(Contato *agenda, int *n) {
    char email[100];
    printf("Digite o email para pesquisar: ");
    scanf("%s", email);
    bool achou = false;
    for (int i = 0; i < *n; i++) {
        if (strcmp(agenda[i].email, email) == 0) {
            printf("Nome: %s\n", agenda[i].nome);
            printf("Telefone: %d\n", agenda[i].telefone);
            printf("Email: %s\n", agenda[i].email);
            if (toupper(agenda[i].sexo) == 'M')
                printf("Sexo: Masculino\n");
            else
                printf("Sexo: Feminino\n");
            
            if (toupper(agenda[i].tipo) == 'C')
                printf("Tipo: Comercial\n");
            else
                printf("Tipo: Pessoal\n");
            achou = true;
            break;
        }
    }
    if (!achou) {
        printf("Email nao encontrado na lista de contatos.\n");
    }

}


void cadastrarContato(Contato *agenda, int *n, int *max){
      if (*n == *max) {
	      *max = *max * 10;
          agenda = (Contato*)realloc(agenda, sizeof(Contato) * (*max));
      }
      printf("Digite o nome: ");
      flush_in();
      gets(agenda[*n].nome);
      (agenda[*n].nome)[0] = toupper((agenda[*n].nome)[0]);
      printf("Digite o sexo (M/F): ");
      scanf("%c", &agenda[*n].sexo);
      printf("Digite o email: ");
      flush_in();
      gets(agenda[*n].email);
      printf("Digite o tipo de contato.\n[C] Comercial\n[P] Pessoal\n=> ");
      scanf("%c", &agenda[*n].tipo);
      agenda[*n].tipo = toupper(agenda[*n].tipo);
      printf("Digite o telefone: ");
      scanf("%d", &agenda[*n].telefone);
      printf("\nContato adicionado com sucesso.");    
	  (*n)++; 
	
}
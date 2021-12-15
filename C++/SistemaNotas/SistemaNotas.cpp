#include <iostream>
#include <string.h>
#include <vector>
#include <algorithm>
using namespace std;

class Aluno{
public:
    string nome;
    float nota;
    Aluno(string x, float y) {nome = x; nota = y;}

};

int main() {
    setlocale(LC_ALL, "pt_BR.UTF-8");
    vector<Aluno> alunos;
    
    while (true) {
        int opc;
        cout << "\n";
        cout << "[1] Cadastrar Aluno" << endl;
        cout << "[2] Atualizar Aluno" << endl;
        cout << "[3] Remover Aluno" << endl;
        cout << "[4] Listar todos alunos" << endl;
        cout << "[5] Sair" << endl;
        cin >> opc;

        //Sair
        if (opc == 5) {
            break;

        } else {
            //Cadastrar um aluno no sistema
            if (opc == 1) {
                cout << "\n=== CADASTRO DE ALUNOS ===\n";
                string nome;
                float nota;
                bool registrado = false;
                cout << "Digite o nome do aluno: ";
                cin >> nome;
                transform(nome.begin(), nome.end(), nome.begin(), ::toupper); //Deixar o nome maíusculo
                for (int i = 0; i < alunos.size(); i++) {
                    if (alunos[i].nome == nome) {
                        cout << "\nAluno já cadastrado no sistema!" << endl;
                        registrado = true;
                        break;
                    }
                }
                if (!registrado) {
                    cout << "Digite a nota do aluno: ";
                    cin >> nota;
                    if (alunos.size() == 0) {
                        nota = nota + nota * 0.1;
                    }
                    if (alunos.size() == 1) {
                        nota = nota + nota * 0.075;
                    }
                    if (alunos.size() == 2) {
                        nota = nota + nota * 0.05;
                    }
                    Aluno *aluno = new Aluno(nome, nota);
                    alunos.push_back(*aluno);
                    cout << "Registro de " << nome << " realizado com sucesso!" << endl;
                }

            }
            //Atualizar dados de alunos
            if (opc == 2) {
                string nome;
                int escolha;
                bool encontrado = false;
                cout << "\n=== ATUALIZAÇÃO DE ALUNOS ===\n";
                cout << "Digite o nome do aluno a ser alterado: ";
                cin >> nome;
                transform(nome.begin(), nome.end(), nome.begin(), ::toupper);
                for (int i = 0; i < alunos.size(); i++) {
                    if (alunos[i].nome == nome) {
                        encontrado = true;
                        cout << "Alterar:\n[1] Nome\n[2] Nota\n=> ";
                        cin >> escolha;
                        while (escolha != 1 and escolha != 2) {
                            cout << "Digite uma opcão válida\n=> ";
                            cin >> escolha;
                        }
                        if (escolha == 1) {
                            cout << "Digite o novo nome: ";
                            cin >> alunos[i].nome;
                            transform(alunos[i].nome.begin(), alunos[i].nome.end(), alunos[i].nome.begin(), ::toupper);
                            cout << "Nome de " << nome << " alterado com sucesso!";

                        } else {
                            cout << "Digite a nova nota: ";
                            cin >> alunos[i].nota;
                            if (i == 0) {
                                alunos[i].nota += alunos[i].nota * 0.1;
                            }
                            if (i == 1) {
                                alunos[i].nota += alunos[i].nota * 0.075;

                            }
                            if (i == 2) {
                                alunos[i].nota += alunos[i].nota * 0.05;
                            }
                            cout << "Nota de " << nome << " alterada com sucesso!" << endl;

                        }
                    }
                }
                if (!encontrado) {
                    cout << "\nAluno não se encontra no registro." << endl;
                }
            }
            //Remover um aluno pelo nome
            if (opc == 3) {
                cout << "\n=== REMOCÃO DE ALUNOS ===\n";
                string nome;
                bool removido = false;
                cout << "Digite o nome do aluno a ser removido" << endl;
                cin >> nome;
                transform(nome.begin(), nome.end(), nome.begin(), ::toupper);
                for (int i = 0; i < alunos.size(); i++) {
                    if (alunos[i].nome == nome) {
                        alunos.erase(alunos.begin()+i); //Deletar um objeto da lista pelo índice
                        cout << "\n" << nome << " foi removido com sucesso!" << endl;
                        removido = true;
                        break;
                    }
                }
                if (!removido) {
                    cout << "\nAluno não se encontra no registro." << endl;
                }
            }
            //Listar todos os alunos cadastrados
            if (opc == 4) {
                if (alunos.size() == 0) {
                    cout << "\nNenhum aluno cadastrado no sistema." << endl;
                } else {
                    cout << "\n=== LISTA DE ALUNOS POR ORDEM DE ENTREGA ===\n";
                    cout << "--------------------------" << endl;
                    for (int i = 0; i < alunos.size(); i++) {
                        if (i == 0) {
                            cout << "1° Entregue + 10%" << endl;
                        }
                        if (i == 1) {
                            cout << "2° Entregue + 7,5%" << endl;
                        }
                        if (i == 2) {
                            cout << "° Entregue + 5%" << endl;  
                        }
                        cout << "Nome: " << alunos[i].nome << endl;
                        cout << "Nota: " << alunos[i].nota << endl;
                        cout << "--------------------------" << endl;
                    }
                }


            }
        }
    }
    return 0;
}
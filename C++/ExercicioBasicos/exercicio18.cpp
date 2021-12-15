#include <iostream>
using namespace std;

int main() {
    int numVezes;
    double preco, precoFinal;
    double juros;
    cin >> preco;
    cin >> numVezes;

    if (numVezes <= 1) {
        juros = -2.5;
    } else if (numVezes <= 5) {
        juros = 0;
    } else if (numVezes <= 10) {
        juros = 6;

    } else if (numVezes <= 15) {
        juros = 13;

    }
    precoFinal = preco + preco * (juros/100);
    cout << "PREÇO DE TABELA: " << preco << endl;
    cout << "NUM. DE VEZES: " << numVezes << endl;
    cout << "VALOR DE CADA PARCELA: R$" << precoFinal/numVezes << endl;
    cout << "PREÇO TOTAL: R$" << precoFinal << endl;
    return 0;
}
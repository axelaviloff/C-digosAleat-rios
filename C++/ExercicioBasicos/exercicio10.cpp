#include <iostream>
using namespace std;

int main() {
    int quantidade;
    double preco;
    cin >> quantidade;

    if (quantidade < 12) {
        preco = quantidade * 0.30;
    } else {
        preco = quantidade * 0.25;
    }

    cout << "Valor: " << preco << endl;

    return 0;
}
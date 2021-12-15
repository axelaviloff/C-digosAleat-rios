#include <iostream>
using namespace std;

int main() {
    int valor;
    cin >> valor;

    if (valor >= 1 && valor <= 9) {
        cout << "O valor está na faixa permitida" << endl;
    } else {
        cout << "O valor está fora da faixa permitida" << endl;
    }

    return 0;
}
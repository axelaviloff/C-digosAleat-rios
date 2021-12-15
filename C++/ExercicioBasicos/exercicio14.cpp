#include <iostream>
using namespace std;

int main() {
    int numero;
    cin >> numero;

    if (numero % 2 == 0) {
        cout << "Par" << endl;
    } else {
        cout << "Ímpar" << endl;
    }

    return 0;
}
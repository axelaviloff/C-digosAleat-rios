#include <iostream>
using namespace std;

int main() {
    int valor1, valor2;
    cin >> valor1 >> valor2;

    if (valor1 < valor2) {
        cout << valor1 << " - " << valor2 << endl;
    } else {
        cout << valor2 << " - " << valor1 << endl;
    }

    return 0;
}
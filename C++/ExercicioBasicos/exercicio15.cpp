#include <iostream>
using namespace std;

int main() {
    int numero1, numero2;
    cin >> numero1 >> numero2;

    if (numero1 == numero2) {
        cout << numero1 << " e " << numero2 << " são iguais" << endl;
    } else {
        if (numero1 > numero2) {
            cout << "Maior: " << numero1 << "\nMenor: " << numero2 << endl;
        } else {
            cout << "Maior: " << numero2 << "\nMenor: " << numero1 << endl;
        }
    }

    return 0;
}
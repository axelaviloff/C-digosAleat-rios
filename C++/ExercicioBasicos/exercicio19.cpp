#include <iostream>
using namespace std;

int main() {
    int idade;
    double peso;
    cin >> idade >> peso;

    if (idade <= 12) {
        cout << "Infatil" << endl;
    } else if (idade <= 16) {
        if (peso <= 40) {
            cout << "Juvenil leve" << endl;
        } else {
            cout << "Juvenil pesado" << endl;
        }
    } else if (idade <= 24) {
        if (peso <= 45) {
            cout << "Senior leve" << endl;
        } else if (peso <= 60) {
            cout << "Senior médio" << endl;
        } else {
            cout << "Senior pesado" << endl;  
        }
    } else {
        cout << "Veterano" << endl;
    }

    return 0;
}



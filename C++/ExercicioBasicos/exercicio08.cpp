#include <iostream>
using namespace std;

int main() {
    int ano;
    int idadeHoje;
    cin >> ano;
    idadeHoje = 2020 - ano;

    if (idadeHoje >= 16) {
        cout << "Poderá votar" << endl;
    } else {
        cout << "Não poderá votar" << endl;
    }

    return 0;
}
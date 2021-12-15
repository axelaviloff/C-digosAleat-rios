#include <iostream>
using namespace std;

int main() {
    int senha;
    cin >> senha;

    if (senha == 1234) {
        cout << "ACESSO PERMITIDO!" << endl;
    } else {
        cout << "ACESSO NÃO PERMITIDO!" << endl;
    }
    return 0;
}
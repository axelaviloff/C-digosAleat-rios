#include <iostream>
using namespace std;

int main() {
    int n1, n2, n3, n4, n5;
    cin >> n1 >> n2;

    if (n1 == n2) {
        cout << "São Iguais" << endl;
    } else {
        if (n1 % 2 == 0) {
            cin >> n3;
            if (n1 > n2 && n1 > n3) {
                cout << "Maior: " << n1 << endl;
            }
            if (n2 > n1 && n2 > n3) {
                cout << "Maior: " << n2 << endl;
            }
            if (n3 > n1 && n3 > n2) {
                cout << "Maior: " << n3 << endl;
            }

        } else {
            cin >> n4 >> n5;
            if (n1 > n2) {
                cout << "Maior entre os dois primeiros: " << n1 << endl;
            } else {
                cout << "Maior entre os dois primeiros: " << n2 << endl;
            }
            if (n4 > n5) {
                cout << "Maior entre os dois segundos: " << n4 << endl;
            } else {
                cout << "Maior entre os dois segundos: " << n5 << endl;
            }
        }
    }


    return 0;
}
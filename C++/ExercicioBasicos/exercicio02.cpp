#include <iostream>
using namespace std;

int main() {
    int valor;
    cin >> valor;
    if (valor >= 0) {
        cout << valor << endl;
    } else {
        cout << -valor << endl;
    }

    return 0;
}
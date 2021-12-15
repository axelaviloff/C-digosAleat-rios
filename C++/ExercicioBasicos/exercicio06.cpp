#include <iostream>
using namespace std;

int main() {
    int numero1, numero2;
    cin >> numero1 >> numero2;
    
    if (numero1 > numero2) {
        cout << numero1 << endl;
    } else {
        cout << numero2 << endl;
    }

    return 0;
}
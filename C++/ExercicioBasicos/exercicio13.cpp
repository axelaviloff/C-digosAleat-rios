#include <iostream>
using namespace std;

int main() {
    int sexo;
    double pesoIdeal, altura;
    cin >> altura >> sexo;

    if (sexo == 1) {
        pesoIdeal = (62.1 * altura) - 44.7;
    } else {
        pesoIdeal = (72.7 * altura) - 58;
    }

    cout << pesoIdeal << endl;

    return 0;
}
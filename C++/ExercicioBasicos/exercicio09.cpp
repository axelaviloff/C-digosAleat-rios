#include <iostream>
using namespace std;

int main() {
    int A, B, C;
    cin >> A >> B >> C;

    if (A < B+C && B < A+C && C < A+B) {
        cout << "Forma Triângulo." << endl;
        
        if (A==B && B==C) {
            cout << "Tipo: Equilátero" << endl;
        } else if (A == B || A==C || B==C) {
            cout << "Tipo: Isósceles" << endl;
        } else {
            cout << "Tipo: Escaleno" << endl;
        }

    } else {
        cout << "Não forma Triângulo." << endl;
    }

    return 0;
}
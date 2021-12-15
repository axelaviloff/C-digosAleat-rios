#include <iostream>
using namespace std;

int main() {
    double n1, n2, media;
    cin >> n1 >> n2;
    media = (n1+n2)/2;

    if (media >= 6) {
        cout << "APROVADO" << endl;
    } else if (media >= 3) {
        cout << "EXAME" << endl;
    } else {
        cout << "REPROVADO" << endl;
    }

    return 0;
}
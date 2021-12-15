#include <iostream>
using namespace std;

int main() {
    double n1, n2, media;
    cin >> n1 >> n2;
    media = (n1+n2)/2;

    if (media >= 6) {
        cout << "PARABÉNS! Você foi aprovado." << endl;
    } else {
        cout << "Você foi REPROVADO! Estude mais." << endl;
    }

    return 0;
}
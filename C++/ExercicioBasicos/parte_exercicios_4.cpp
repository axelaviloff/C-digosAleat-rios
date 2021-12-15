#include <iostream>
using namespace std;


//Exercício 01
/* 
int main() {
    int valor;
    cin >> valor;
    if (valor >= 0 ) {
        cout << "Positivo." << endl;
    } else {
        cout << "Negativo." << endl;
    }

    return 0;
}
*/

//Exercícios 02
/*
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
*/

//Exercício 03
/*
int main() {
    double n1, n2, media;
    cin >> n1 >> n2;
    media = (n1+n2)/2;

    if (media >= 6) {
        cout << "PARABÉNS! Você foi aprovado." << endl;
    }
    
    return 0;
}
*/

//Exercício 04
/*
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
*/

//Exercício 05
/*
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
*/

//Exercício 06
/*
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
*/

//Exercício 07
/*
int main() {
    int valor;
    cin >> valor;

    if (valor >= 1 && valor <= 9) {
        cout << "O valor está na faixa permitida" << endl;
    } else {
        cout << "O valor está fora da faixa permitida" << endl;
    }

    return 0;
}
*/

//Exercício 08
/*
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
*/

//Exercício 09
/*
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
*/

//Exercício 10
/*
int main() {
    int quantidade;
    double preco;
    cin >> quantidade;

    if (quantidade < 12) {
        preco = quantidade * 0.30;
    } else {
        preco = quantidade * 0.25;
    }

    cout << "Valor: " << preco << endl;

    return 0;
}
*/

//Exercício 11
/*
int main() {
    int valor1, valor2;
    cin >> valor1 >> valor2;

    if (valor1 < valor2) {
        cout << valor1 << " - " << valor2 << endl;
    } else {
        cout << valor2 << " - " << valor1 << endl;
    }

    return 0;
}
*/

//Exercício 12
/*
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
*/

//Exercício 13
/*
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
*/

//Exercício 14
/*
int main() {
    int numero;
    cin >> numero;

    if (numero % 2 == 0) {
        cout << "Par" << endl;
    } else {
        cout << "Ímpar" << endl;
    }

    return 0;
}
*/

//Exercício 15
/*
int main() {
    int numero1, numero2;
    cin >> numero1 >> numero2;

    if (numero1 == numero2) {
        cout << numero1 << " e " << numero2 << " são iguais" << endl;
    } else {
        if (numero1 > numero2) {
            cout << "Maior: " << numero1 << "\nMenor: " << numero2 << endl;
        } else {
            cout << "Maior: " << numero2 << "\nMenor: " << numero1 << endl;
        }
    }

    return 0;
}
*/

//Exercício 16
/*
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
*/

//Exercício 17
/*
int main() {
    int n1, n2, n3;
    cin >> n1 >> n2 >> n3;

    if (n1 >= n2 && n1 >= n3) {
        cout << n1 << endl;
    } else if (n2 >= n1 && n2 >= n3) {
        cout << n2 << endl;
    } else if (n3 >= n1 && n3 >= n2) {
        cout << n3 << endl;
    }

    return 0;
}
*/

//Exercício 18
/*
int main() {
    int numVezes;
    double preco, precoFinal;
    double juros;
    cin >> preco;
    cin >> numVezes;

    if (numVezes <= 1) {
        juros = -2.5;
    } else if (numVezes <= 5) {
        juros = 0;
    } else if (numVezes <= 10) {
        juros = 6;

    } else if (numVezes <= 15) {
        juros = 13;

    }
    precoFinal = preco + preco * (juros/100);
    cout << "PREÇO DE TABELA: " << preco << endl;
    cout << "NUM. DE VEZES: " << numVezes << endl;
    cout << "VALOR DE CADA PARCELA: R$" << precoFinal/numVezes << endl;
    cout << "PREÇO TOTAL: R$" << precoFinal << endl;
    return 0;
}
*/

//Exercício 19
/*
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
*/
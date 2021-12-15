import csv
import os
import matplotlib.pyplot as plt
import numpy as np

class Aluno:

    def __init__(self):
        self.nome = ''
        self.nota1 = 0.0
        self.nota2 = 0.0


def listaQuantidade():
    aprovados = 0
    reprovados = 0
    exame = 0
    for aluno in alunos:
        media = (aluno.nota1 + aluno.nota2)/2
        if media >= 7:
            aprovados += 1
        elif media < 4:
            reprovados += 1
        else:
            exame += 1
    print("Total de aprovados: {}\nTotal de reprovados: {}\nTotal em exame: {}".format(aprovados, reprovados, exame))


def listaNome():
    nomeMaior = ''
    nomeMenor = ''
    maiorMedia = 0
    menorMedia = 11
    for aluno in alunos:
        media = (aluno.nota1 + aluno.nota2)/2
        if media >= maiorMedia:
            maiorMedia = media
            nomeMaior = aluno.nome
        if media <= menorMedia:
            menorMedia = media
            nomeMenor = aluno.nome
    print("MAIOR MÉDIA:\nNome: {}\nMédia: {}".format(nomeMaior, maiorMedia))
    print("\nMENOR MÉDIA:\nNome: {}\nMédia: {}".format(nomeMenor, menorMedia))


def listaMediaAcima():
    acimaMediaNota1 = 0
    for aluno in alunos:
        if aluno.nota1 >= 7:
            acimaMediaNota1 += 1
    print("Quantidade de alunos que tiraram nota acima da média na primeira avaliação: {}".format(acimaMediaNota1))


def geraHistograma():
    x = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    for aluno in alunos:
        if 0 < aluno.nota2 <= 0.9:
            x[0] += 1
        elif 0.9 < aluno.nota2 <= 1.9:
            x[1] += 1
        elif 1.9 < aluno.nota2 <= 2.9:
            x[2] += 1
        elif 2.9 < aluno.nota2 <= 3.9:
            x[3] += 1
        elif 3.9 < aluno.nota2 <= 4.9:
            x[4] += 1
        elif 4.9 < aluno.nota2 <= 5.9:
            x[5] += 1
        elif 5.9 < aluno.nota2 <= 6.9:
            x[6] += 1
        elif 6.9 < aluno.nota2 <= 7.9:
            x[7] += 1
        elif 7.9 < aluno.nota2 <= 8.9:
            x[8] += 1
        elif 8.9 < aluno.nota2 <= 10:
            x[9] += 1

    intervalo = ['0-0.9', '1-1.9', '2-2.9', '3-3.9', '4-4.9', '5-5.9', '6-6.9', '7-7.9', '8-8.9', '9-10']

    pos = np.arange(len(intervalo))
    largura = 1

    ax = plt.axes()
    ax.set_xticks(pos + (largura / 10))
    ax.set_xticklabels(intervalo)
    ax.set_ylabel('Frequência')
    ax.set_xlabel('Intervalo de Notas')

    plt.bar(pos, x, largura, color='b')
    plt.show()

#Começo do programa.
alunos = []

with open('alunos.csv') as csv_file:   
    csv_reader = csv.reader(csv_file, delimiter=';')
    csv_reader.__next__()

    for row in csv_reader:
        aluno = Aluno()
        aluno.nome = row[0]
        aluno.nota1 = float(row[1])
        aluno.nota2 = float(row[2])
        alunos.append(aluno)

while True:
    print("[1] - Listar quantidade de alunos aprovados, reprovados e em exame do curso.")
    print("[2] - Listar aluno com maior e menor média.")
    print("[3] - Listar quantidade de alunos que tiveram nota acima da média na primeira avaliação.")
    print("[4] - Mostar histograma.")
    print("[5] - Sair.")
    opcao_menu = input(" => ")
    
    if opcao_menu == "1":
        listaQuantidade()

    if opcao_menu == "2":
        listaNome()
                        
    if opcao_menu == "3":
        listaMediaAcima()
    
    if opcao_menu == "4":
        geraHistograma()       
    
    if opcao_menu == "5":
        break



        
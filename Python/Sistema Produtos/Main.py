from time import sleep
import os  #Módulo para conseguir usar comandos do próprio terminal.

class Produto:
    
    def __init__(self, codigo, descricao, quantidade):
        self.codigo = codigo
        self.descricao = descricao;
        self.quantidade = quantidade;

#Limpa tela do terminal.
def limpaTela():
    os.system('cls' if os.name == 'nt' else 'clear')

#Exibe o menu principal de opções do sistema.
def mostraMenu():
    print(""" _  _  ____  ____  __  
( \/ )(  _ \(_  _)/  \ 
 )  (  ) __/  )( (  O )
(_/\_)(__)   (__) \__/ 
""")
    print("--------------------------------")
    print("""[1] Cadastrar Produto
[2] Alterar produto
[3] Excluir produto
[4] Listar estoque de produtos
[5] Comprar produto
[6] Vender produto
[7] Sair""")
    print("--------------------------------")
    
#se opcao_menu == 1 realiza o cadastro do produto, onde cada instância de Produto é armazenada em uma lista.
def cadastraProduto():
    limpaTela()
    
    print("=========== CADASTRO DE PRODUTOS ===========")

    codigo = int(input("Digite o código do produto (somente números): "))
    while produtoExiste(codigo):
        codigo = int(input("Produto já cadastrado.\nDigite novamente o código do produto: "))

    descricao = str(input("Digite a descrição do produto: "))

    quantidade = int(input("Digite a quantidade do produto: "))
    while quantidade < 1:
        quantidade = int(input("Quantidade não pode ser negativa.\nDigite a quantidade do produto: "))
    
   
    produto = Produto(codigo, descricao.upper(), quantidade)
    
    limpaTela()
    
    print("Cadastrando produto...")
    
    sleep(1)
    limpaTela()
    produtos.append(produto)
    
#se opcao_menu == 2 percorre a lista de produtos e muda sua descricão ou quantidade.
def alteraProduto():
    limpaTela()
    global master 
    
    if not master:
        logaAdmin()
          
    print("=========== ALTERAÇÃO DE PRODUTOS ===========")

    codigo = int(input("Digite o código do produto a ser alterado: "))
    
    if produtoExiste(codigo):
        for produto in produtos:
            if produto.codigo == codigo:
                print("DESCRIÇÃO: {}".format(produto.descricao))
                print("QUANTIDADE: {}".format(produto.quantidade))
                opc = str(input("O que você deseja alterar?\n[1] DESCRIÇÃO\n[2] QUANTIDADE\n=>"))
                while opc not in ["1", "2"]:
                    opc = str(input("=> "))
                if opc == "1":
                    descricao = str(input("Digite a nova descrição do produto: "))
                    produto.descricao = descricao.upper()
                else:
                    quantidade = int(input("Digite a nova quantidade do produto: "))
                    while quantidade < 1:
                        print("Quantidade deve ser positiva.")
                        quantidade = int(input("Digite a nova quantidade do produto: "))
                    produto.quantidade = quantidade
                
                print("Alterações realizadas com sucesso!")
    else:
        print("Este produto não está cadastrado!")

    
    sleep(1)

#se opcao_menu == 3 deleta um produto.       
def deletaProduto():
    contaErros = 0
    limpaTela()
    global master
    
    if not master:
        logaAdmin()
    
    codigo = int(input("Digite o código do produto a ser deletado: "))
    
    if produtoExiste(codigo):
        for produto in produtos:
            if produto.codigo == codigo:
                produtos.remove(produto)
                print("Produto removido com sucesso!")
    else:
        print("Produto não cadastrado!")

    sleep(1)

#se opcao_menu == 4 lista as informações dos clientes percorrendo a lista de clientes e mostrando seus atributos.
def listaProdutos():
    limpaTela() 
    print("Carregando lista de produtos...")
    sleep(1)
    limpaTela()
    
    if produtos == []:
        print("O Sistema não possuí nenhum produto cadastrado!")
    else:
        print("=========== LISTA DE PRODUTOS ===========\n")
        
        print("CÓDIGO          DESCRIÇÃO               QUANTIDADE EM ESTOQUE:")
        print("------          ---------               ---------------------")
        for produto in produtos:
            print("{}{}{}{}{}".format(produto.codigo," "*(16-len(str(produto.codigo))), produto.descricao, " "*(25-len(produto.descricao)), produto.quantidade))
    
    x = input("\n[1] Voltar\n=> ")
    while x != "1":
        x = input("=> ")

#se opcao_menu == 5 compra produto
def compraProduto():
    limpaTela()
    print("=========== COMPRA DE PRODUTOS ===========\n")

    codigo = int(input("Digite o código do produto a ser comprado: "))
    if produtoExiste(codigo):
        for produto in produtos:
            if produto.codigo == codigo:
                print("Descrição: {}\nQuantidade atual em estoque: {}".format(produto.descricao, produto.quantidade))
                quantidade = int(input("Digite a quantidade a ser comprado: "))
                while quantidade < 1:
                    print("Quantidade deve ser positiva!")
                    quantidade = int(input("Digite a quantidade a ser comprado: "))
                produto.quantidade += quantidade
                print("COMPRA REALIZADA COM SUCESSO!")
                
    else:
        print("PRODUTO NÃO CADASTRADO!")
    sleep(1)

#se opc_menu == 6 vende produto
def vendeProduto():
    limpaTela()
    print("=========== VENDA DE PRODUTOS ===========\n")

    codigo = int(input("Digite o código do produto a ser vendido: "))
    if produtoExiste(codigo):
        for produto in produtos:
            if produto.codigo == codigo:
                print("Descrição: {}\nQuantidade atual em estoque: {}".format(produto.descricao, produto.quantidade))
                quantidade = int(input("Digite a quantidade a ser vendido: "))
                while (produto.quantidade - quantidade < 0) or (quantidade < 0):
                    print("Quantidade inferior ao estoque")
                    quantidade = int(input("Digite a quantidade a ser vendido: "))
                produto.quantidade -= quantidade
                print("VENDA REALIZADA COM SUCESSO!")
                
    else:
        print("PRODUTO NÃO CADASTRADO!")
    sleep(1)


#se opcao_menu == 7 o programa finaliza.
def sair():
    limpaTela()
    
    print("Encerrando sistema...")
    
    sleep(1)

#Verifica se o produto já está cadastrado
def produtoExiste(codigo):
    for produto in produtos:
        if produto.codigo == codigo:
            return True
    return False

#Loga como administrador
def logaAdmin():
    global master
    contaErros = 0
    print("=========== ENTRAR COMO ADMINISTRADOR ===========\n")
    while contaErros < 3:
        limpaTela()
        print("Você possúi {} tentativa(s)".format(3-contaErros))
        senha = str(input("Digite a senha de acesso\n=> "))
        if senha == "yN1825*a":
            break
        contaErros += 1
        
    if contaErros == 3:
        limpaTela()
        print("SEU ACESSO FOI BLOQUEADO! PROCURE O ADMINISTRADOR")
        exit()

    master = True
    limpaTela()
    print("Logado como administrador.")
    sleep(1)
    limpaTela()

#Inicio do programa
limpaTela()
master = False
produtos = []

while True:
    limpaTela()
    mostraMenu()
    opcao_menu = input(" => ")
    if opcao_menu == "1":
        cadastraProduto()

    if opcao_menu == "2":
        alteraProduto()
                        
    if opcao_menu == "3":
        deletaProduto()
    
    if opcao_menu == "4":
        listaProdutos()       
    
    if opcao_menu == "5":
        compraProduto()
    
    if opcao_menu == "6":
        vendeProduto()

    if opcao_menu == "7":
        sair()
        break
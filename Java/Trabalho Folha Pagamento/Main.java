import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int opc;
        boolean running = true;
        ArrayList<Gerente> gerentes = new ArrayList();
        ArrayList<Funcionario> funcionarios = new ArrayList();

        while (running) {
            System.out.print("1 - Cadastrar Empregado\n2 - Atualizar Empregado\n3 - Remover Empregado" +
                    "\n4 - Exibir folha de pagamento\n5 - Sair\n => ");
            opc = read.nextInt();
            switch (opc) {
                //Cadastrar Empregado
                case 1:

                    int tipo;

                    do {
                        System.out.print("1 - Cadastrar Gerente\n2 - Cadastrar Funcionário\n => ");
                        tipo = read.nextInt();
                    } while (tipo != 1 && tipo != 2);

                    if (tipo == 1) {

                        System.out.print("Digite o primeiro nome do gerente\n => ");
                        String nome = read.next();
                        System.out.print("Digite o total de gratificações por desempenho do gerente\n => ");
                        int gratDesempenho = read.nextInt();
                        System.out.print("Digite o total de horas extras do gerente\n => ");
                        int gratHoraExtra = read.nextInt();
                        Gerente gerente = new Gerente(nome, 4000.0, gratDesempenho, gratHoraExtra, gratDesempenho+gratHoraExtra);
                        gerentes.add(gerente);

                    } else {

                        System.out.print("Digite o primeiro nome do funcionário\n => ");
                        String nome = read.next();
                        System.out.print("Digite o total de gratificações por desempenho do funcionário\n => ");
                        int gratDesempenho = read.nextInt();
                        System.out.print("Digite o total de horas extras do funcionário\n => ");
                        int gratHoraExtra = read.nextInt();
                        Funcionario funcionario = new Funcionario(nome, 2500.0, gratDesempenho, gratHoraExtra, gratDesempenho+gratHoraExtra);
                        funcionarios.add(funcionario);

                    }

                    System.out.println("\nCadastro realizado com sucesso!\n");
                    break;

                //Atualizar Empregado
                case 2:
                    boolean cadastrado = false;

                    do {
                        System.out.print("1 - Atualizar Gerente\n2 - Atualizar Funcionário\n => ");
                        tipo = read.nextInt();
                    } while (tipo != 1 && tipo != 2);

                    if (tipo == 1) {
                        int dado;
                        do {
                            System.out.print("Qual dado você deseja atualizar?\n1 - Nome\n2 - Gratificações\n => ");
                            dado = read.nextInt();
                        } while (dado != 1 && dado != 2);

                        if (dado == 1) {
                            System.out.print("Digite o nome atual do Gerente\n => ");
                            String nomeAtual = read.next();
                            System.out.print("Digite o novo nome do Gerente\n => ");
                            String novoNome = read.next();

                            for (Gerente g: gerentes) {
                                if (g.getNome().toUpperCase().equals(nomeAtual.toUpperCase())) {
                                    g.setNome(novoNome);
                                    cadastrado = true;
                                    System.out.println("\nNome atualizado com sucesso!\n");
                                    break;
                                }
                            }
                        } else {
                            System.out.print("Digite o nome do Gerente\n => ");
                            String nomeGerente = read.next();
                            System.out.print("Digite o total de gratificações por desempenho do Gerente\n => ");
                            int gratDesempenho = read.nextInt();
                            System.out.print("Digite o total de horas extras do Gerente\n => ");
                            int gratHoraExtra = read.nextInt();

                            for (Gerente g: gerentes) {
                                if (g.getNome().toUpperCase().equals(nomeGerente.toUpperCase())) {
                                    g.setGratDesempenho(gratDesempenho);
                                    g.setGratHoraExtra(gratHoraExtra);
                                    cadastrado = true;
                                    System.out.println("\nGratificações atualizadas com sucesso!\n");
                                }
                            }

                        }

                        if (!cadastrado) {
                            System.out.print("\nGerente não encontrado no sistema!\n");
                        }

                    } else {
                        int dado;
                        do {
                            System.out.print("Qual dado você deseja atualizar?\n1 - Nome\n2 - Gratificações\n => ");
                            dado = read.nextInt();
                        } while (dado != 1 && dado != 2);

                        if (dado == 1) {
                            System.out.print("Digite o nome atual do Funcionário\n => ");
                            String nomeAtual = read.next();
                            System.out.print("Digite o novo nome do Funcionário\n => ");
                            String novoNome = read.next();

                            for (Funcionario f: funcionarios) {
                                if (f.getNome().toUpperCase().equals(nomeAtual.toUpperCase())) {
                                    f.setNome(novoNome);
                                    cadastrado = true;
                                    System.out.println("\nNome atualizado com sucesso!\n");
                                }
                            }
                        } else {
                            System.out.print("Digite o nome do Funcionário\n => ");
                            String nomeGerente = read.next();
                            System.out.print("Digite o total de gratificações por desempenho do Funcionŕio\n => ");
                            int gratDesempenho = read.nextInt();
                            System.out.print("Digite o total de horas extras do Funcionário\n => ");
                            int gratHoraExtra = read.nextInt();

                            for (Funcionario f: funcionarios) {
                                if (f.getNome().toUpperCase().equals(nomeGerente.toUpperCase())) {
                                    f.setGratDesempenho(gratDesempenho);
                                    f.setGratHoraExtra(gratHoraExtra);
                                    cadastrado = true;
                                    System.out.println("\nGratificações atualizadas com sucesso!\n");
                                }
                            }
                        }
                        if (!cadastrado) {
                            System.out.print("\nFuncionário não encontrado no sistema!\n");
                        }
                    }
                    break;

                //Remover empregado
                case 3:

                    do {
                        System.out.print("1 - Remover Gerente\n2 - Remover Funcionário\n => ");
                        tipo = read.nextInt();
                    } while (tipo != 1 && tipo != 2);

                    if (tipo == 1) {
                        System.out.print("Digite o nome do Gerente a ser removido\n => ");
                        String nome = read.next();
                        boolean removido = removeGerente(gerentes, nome);
                        if (removido) {
                            System.out.println("Gerente removido com sucesso!");
                        } else {
                            System.out.println("Gerente não encontrado no sistema!");
                        }
                    } else {
                        System.out.print("Digite o nome do Funcionário a ser removido\n => ");
                        String nome = read.next();
                        boolean removido = removeFuncionario(funcionarios, nome);
                        if (removido) {
                            System.out.println("Funcionário removido com sucesso!");
                        } else {
                            System.out.println("Funcionário não encontrado no sistema!");
                        }

                    }
                    break;

                //Exibir folha de pagamento
                case 4:
                    if (funcionarios.size() + gerentes.size() == 0) {
                        System.out.println("\nNenhum cadastro encontrado!\n");

                    } else {
                        System.out.printf("%s %15s %20s %30s %30s %30s\n", "Nome", "Cargo", "Salário Base", "Qtde. de Gratificações",
                                "Valor das Gratificações", "Vencimento Mensal");
                        for (Gerente g: gerentes) {
                            System.out.printf("%s %15s %20s %30s %30s %30s\n", g.getNome(), "Gerente", "$" + String.valueOf(g.getSalarioBase()), g.getGratTotal(),
                                    "$" + String.valueOf(g.calculaGratificacoes()), "$" + String.valueOf(g.getSalarioBase() + g.calculaGratificacoes()));
                        }

                        for (Funcionario f: funcionarios) {
                            System.out.printf("%s %15s %20s %30s %30s %30s\n", f.getNome(), "Funcionário", "$" + String.valueOf(f.getSalarioBase()), f.getGratTotal(),
                                    "$" + String.valueOf(f.calculaGratificacoes()), "$" + String.valueOf(f.getSalarioBase() + f.calculaGratificacoes()));
                        }
                        System.out.println();
                    }
                    break;

                //Sair
                case 5:
                    read.close();
                    running = false;
                    break;
            }
        }

    }
    public static boolean removeGerente(ArrayList<Gerente> gerentes, String nome) {
        for(Gerente g: gerentes) {
            if (g.getNome().toUpperCase().equals(nome.toUpperCase())) {
                gerentes.remove(g);
                return true;
            }
        }
        return false;
    }

    public static boolean removeFuncionario(ArrayList<Funcionario> funcionarios, String nome) {
        for(Funcionario f: funcionarios) {
            if (f.getNome().toUpperCase().equals(nome.toUpperCase())) {
                funcionarios.remove(f);
                return true;
            }
        }
        return false;
    }

}



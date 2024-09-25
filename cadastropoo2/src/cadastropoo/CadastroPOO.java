package cadastropoo;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class CadastroPOO {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();
        
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("======================================");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo id");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Sair");
            System.out.println("======================================");
            opcao = Integer.parseInt(System.console().readLine());
            
            switch (opcao) {
                case 1:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    char tipo = System.console().readLine().charAt(0);

                    if (tipo == 'F') {
                        PessoaFisica pessoaFisica = new PessoaFisica();
                        System.out.print("Id: ");
                        pessoaFisica.setId(Integer.parseInt(System.console().readLine()));
                        System.out.print("Nome: ");
                        pessoaFisica.setNome(System.console().readLine());
                        System.out.print("CPF: ");
                        pessoaFisica.setCpf(System.console().readLine());
                        System.out.print("Idade: ");
                        pessoaFisica.setIdade(Integer.parseInt(System.console().readLine()));
                        pessoaFisicaRepo.inserir(pessoaFisica);
                    } else if (tipo == 'J') {
                        PessoaJuridica pessoaJuridica = new PessoaJuridica();
                        System.out.print("Id: ");
                        pessoaJuridica.setId(Integer.parseInt(System.console().readLine()));
                        System.out.print("Nome: ");
                        pessoaJuridica.setNome(System.console().readLine());
                        System.out.print("CNPJ: ");
                        pessoaJuridica.setCnpj(System.console().readLine());
                        pessoaJuridicaRepo.inserir(pessoaJuridica);
                    }
                    break;
                case 2:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    tipo = System.console().readLine().charAt(0);
                    if (tipo == 'F') {
                        System.out.print("Id: ");
                        int id = Integer.parseInt(System.console().readLine());
                        PessoaFisica pessoaFisica = pessoaFisicaRepo.obter(id);
                        pessoaFisica.exibir();
                        System.out.print("Nome: ");
                        pessoaFisica.setNome(System.console().readLine());
                        System.out.print("CPF: ");
                        pessoaFisica.setCpf(System.console().readLine());
                        System.out.print("Idade: ");
                        pessoaFisica.setIdade(Integer.parseInt(System.console().readLine()));
                        pessoaFisicaRepo.alterar(pessoaFisica);
                    } else if (tipo == 'J') {
                        System.out.print("Id: ");
                        int id = Integer.parseInt(System.console().readLine());
                        PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter(id);
                        pessoaJuridica.exibir();
                        System.out.print("Nome: ");
                        pessoaJuridica.setNome(System.console().readLine());
                        System.out.print("CNPJ: ");
                        pessoaJuridica.setCnpj(System.console().readLine());
                        pessoaJuridicaRepo.alterar(pessoaJuridica);
                    }
                    break;
                case 3:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    tipo = System.console().readLine().charAt(0);

                    if (tipo == 'F') {
                        System.out.print("Id: ");
                        int id = Integer.parseInt(System.console().readLine());
                        pessoaFisicaRepo.excluir(id);
                    } else if (tipo == 'J') {
                        System.out.print("Id: ");
                        int id = Integer.parseInt(System.console().readLine());
                        pessoaJuridicaRepo.excluir(id);
                    }
                    break;
                case 4:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    tipo = System.console().readLine().charAt(0);

                    if (tipo == 'F') {
                        System.out.print("Id: ");
                        int id = Integer.parseInt(System.console().readLine());
                        PessoaFisica pessoaFisica = pessoaFisicaRepo.obter(id);
                        pessoaFisica.exibir();
                    } else if (tipo == 'J') {
                        System.out.print("Id: ");
                        int id = Integer.parseInt(System.console().readLine());
                        PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter(id);
                        pessoaJuridica.exibir();
                    }
                    break;
                case 5:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    tipo = System.console().readLine().charAt(0);

                    if (tipo == 'F') {
                        for (PessoaFisica pf : pessoaFisicaRepo.obterTodos()) {
                            pf.exibir();
                        }
                    } else if (tipo == 'J') {
                        for (PessoaJuridica pj : pessoaJuridicaRepo.obterTodos()) {
                            pj.exibir();
                        }
                    }
                    break;
                case 6:
                    System.out.print("Prefixo: ");
                    String prefixo = System.console().readLine();
                    pessoaFisicaRepo.persistir(prefixo + ".fisica.bin");
                    pessoaJuridicaRepo.persistir(prefixo + ".juridica.bin");
                    break;
                case 7: 
                    System.out.print("Prefixo: ");
                    prefixo = System.console().readLine();
                    pessoaFisicaRepo.recuperar(prefixo + ".fisica.bin");
                    pessoaJuridicaRepo.recuperar(prefixo + ".juridica.bin");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");        
            }
        }
    } 
}


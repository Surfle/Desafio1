import model.Endereco;
import model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> chamada = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Endereco endereco = new Endereco();


        int opcao2 = 1;
        while (true){
            List<Endereco> enderecos = new ArrayList<>();

            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("1 - Pesquisar");
            System.out.println("0 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 1:
                    System.out.print("Insira o nome: ");
                    String nome = scanner.next();
                    System.out.print("Insira a idade: ");
                    int idade = scanner.nextInt();
                    String rua;
                    int numero;
                    while (opcao2 != 0) {
                        System.out.print("Insira a rua: ");
                        rua = scanner.next();
                        System.out.print("Insira a numero: ");
                        numero = scanner.nextInt();
                        endereco.setNumero(numero);
                        endereco.setRua(rua);
                        enderecos.add(endereco);
                        System.out.println("Adicionar mais endereços?\n1 - Sim\n0 - Não");
                        opcao2 = scanner.nextInt();
                    }
                  //  enderecos.clear();
                    opcao2 = 1;
                    chamada.add(new Pessoa(idade, nome, enderecos));
                    break;
                case 2:
                    for(int i = 0; i < chamada.size(); i++){
                        System.out.println("Nome: "+chamada.get(i).getNome());
                        System.out.println("Idade: "+chamada.get(i).getIdade());
                        System.out.println("---------------------");
                        for (int y = 1; y <= chamada.get(i).getEndereco().size();y++){
                            System.out.println("Endereco "+y+":\n" +
                                    "Rua - "+chamada.get(i).getEndereco().get(y-1).getRua()+"\n" +
                                    "Numero - "+chamada.get(i).getEndereco().get(y-1).getNumero()+"\n");
                            if(y != chamada.get(i).getEndereco().size())
                                System.out.println("---------------------");

                        }
                        if(i+1 != chamada.size())
                            System.out.println("========================================");
                    }
                    break;
                case 3:
                    System.out.println("Insira o nome para pesquisa: ");
                    String pesquisa = scanner.next();
                    for(int i = 0; i < chamada.size(); i++) {
                        if (pesquisa.equals(chamada.get(i).getNome())) {
                            System.out.println("Nome: " + chamada.get(i).getNome());
                            System.out.println("Idade: " + chamada.get(i).getIdade());
                            System.out.println("---------------------");
                            for (int y = 1; y <= chamada.get(i).getEndereco().size(); y++) {
                                System.out.println("Endereco " + y + ":\n" +
                                        "Rua - " + chamada.get(i).getEndereco().get(y - 1).getRua() + "\n" +
                                        "Numero - " + chamada.get(i).getEndereco().get(y - 1).getNumero() + "\n");
                                if(y != chamada.get(i).getEndereco().size())
                                    System.out.println("---------------------");                            }
                        }
                    }
                    break;
                case 0:
                    System.exit(0);
                    break; //vai que KKK
                default:
                    System.out.println("Valor inválido!");
            }

        }

    }
}
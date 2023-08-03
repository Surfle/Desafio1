import model.Endereco;
import model.Pedido;
import model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> chamada = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Endereco endereco = new Endereco();


        int opcao2 = 1;
        while (true){
            List<Endereco> enderecos = new ArrayList<>();

            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Pesquisar");
            System.out.println("4 - Editar");
            System.out.println("5 - Realizar Pedido");
            System.out.println("6 - Quantidade de pedidos");
            System.out.println("7 - Pedidos Ativos");
            System.out.println("8 - Pedidos Encerrados");
            System.out.println("9 - Finalizar e Imprimir pedido");


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
                case 4:
                    System.out.println("Insira o nome para editar: ");
                    String pesquisa2 = scanner.next();
                    for(int i = 0; i < chamada.size(); i++) {
                        if (pesquisa2.equals(chamada.get(i).getNome())) {
                            System.out.print("Nome: ");
                            chamada.get(i).setNome(scanner.next());
                            System.out.print("Idade: ");
                            chamada.get(i).setIdade(scanner.nextInt());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Insira o nome do cliente: ");
                    String pesquisa3 = scanner.next();
                    int cliente_id = -1;
                    for(int i = 0; i < chamada.size(); i++) {
                        if (pesquisa3.equals(chamada.get(i).getNome())) {
                            cliente_id = i;
                        }
                    }
                    System.out.println("Insira o nome do pedido");
                    String descricao = scanner.next();
                    pedidos.add(new Pedido (descricao,chamada.get(cliente_id),true));
                    break;
                case 6:
                    System.out.println("Numero de pedidos: "+pedidos.size());
                    break;
                case 7:
                    for (int i = 0; i < pedidos.size(); i++){
                        if (pedidos.get(i).isAtivo()){
                            System.out.println("Pedido"+(i-1)+": "+pedidos.get(i).getDescricao()+
                                    "\nCliente: "+pedidos.get(i).getPessoa().getNome());
                        }
                    }
                    break;
                case 8:
                    for (int i = 0; i < pedidos.size(); i++){
                        if (!pedidos.get(i).isAtivo()){
                            System.out.println("Pedido"+(i-1)+": "+pedidos.get(i).getDescricao()+
                                    "\nCliente: "+pedidos.get(i).getPessoa().getNome());
                        }
                    }
                    break;
                case 9:
                    System.out.println("Insira o nome do pedido");
                    String nomePedido = scanner.next();
                    for (int i = 0; i < pedidos.size(); i++){
                        if (pedidos.get(i).getDescricao().equals(nomePedido)){
                            pedidos.get(i).setAtivo(false);
                            String nomeArquivo = "Pedido_"+i+".txt";
                            String caminhoArquivo = "./";
                            FileWriter arquivoWriter;
                            try {
                                arquivoWriter = new FileWriter(caminhoArquivo + nomeArquivo);
                            } catch (IOException e) {
                                e.printStackTrace();
                                return;
                            }
                            BufferedWriter arquivoEscritor = new BufferedWriter(arquivoWriter);

                            try {
                                arquivoEscritor.write("Nome: "+pedidos.get(i).getPessoa().getNome());
                                arquivoEscritor.newLine();
                                arquivoEscritor.write("Endereco: "+pedidos.get(i).getPessoa().getEndereco().get(0).getRua()+" - Número "+pedidos.get(i).getPessoa().getEndereco().get(0).getNumero());
                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                try {
                                    arquivoEscritor.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("Pedido Encerrado e Imprimido");
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
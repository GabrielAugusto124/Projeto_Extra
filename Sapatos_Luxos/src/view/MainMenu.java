package view;
import java.util.Scanner;

import jdbc.DatabaseConnection;
import model.Category;
import service.CustomerService;
import service.OrderService;
import service.ShoeService;

public class MainMenu {
    public static void main(String[] args){
        DatabaseConnection.connect();
        Scanner sc=new Scanner(System.in);
        CustomerService cs=new CustomerService();
        ShoeService ss=new ShoeService();
        OrderService os=new OrderService();

        while(true){
            System.out.println("\n=== LOJA DE SAPATOS LUXOS ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Cadastrar Sapato");
            System.out.println("4 - Listar Sapatos");
            System.out.println("5 - Criar Pedido");
            System.out.println("6 - Listar Pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int op=sc.nextInt(); sc.nextLine();

            switch(op){
                case 1:
                    System.out.print("Nome: "); String n=sc.nextLine();
                    System.out.print("CPF: "); String cpf=sc.nextLine();
                    System.out.print("CEP: "); String cep=sc.nextLine();
                    cs.createCustomer(n,cpf,cep); break;
                case 2: cs.listCustomers(); break;
                case 3:
                    System.out.print("Nome: "); String sn=sc.nextLine();
                    System.out.print("Tamanho: "); int size=sc.nextInt();
                    System.out.print("Preço: "); double price=sc.nextDouble(); sc.nextLine();
                    System.out.print("Categoria (CASUAL,SPORT,SOCIAL): ");
                    Category cat=Category.valueOf(sc.nextLine().toUpperCase());
                    ss.createShoe(sn,size,price,cat); break;
                case 4: ss.listShoes(); break;
                case 5:
                    System.out.print("ID Cliente: "); int cid=sc.nextInt();
                    System.out.print("ID Sapato: "); int sid=sc.nextInt();
                    System.out.print("Quantidade: "); int qty=sc.nextInt();
                    os.createOrder(cid,sid,qty); break;
                case 6: os.listOrders(); break;
                case 0: System.exit(0);
            }
        }
    }
}

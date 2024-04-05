package application;


import entitys.Client;
import entitys.Order;
import entitys.OrderItem;
import entitys.Product;
import entitys.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");




        Scanner sc = new Scanner(System.in);

        System.out.println("Eneter Client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(name, email, birthDate);


        System.out.println("Eneter order data:");
        System.out.print("Status: ");

        OrderStatus status = OrderStatus.valueOf(sc.next());
        System.out.println("How many itens to this order?");
        int qi = sc.nextInt();
        Order order = new Order(new Date(), status, client);


        List <OrderItem> items = new ArrayList<>(qi);

        for (int i = 0; i < qi; i++){
            System.out.println("Enter #" + (i+1) + " item data:");


            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int prodcutQuantity = sc.nextInt();

            Product product = new Product(productName, productPrice);

            OrderItem orderItem = new OrderItem(prodcutQuantity, productPrice, product);
            order.addItem(orderItem);

        }
        System.out.println(order);


    }
}
package entitys;

import entitys.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static final SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> itens = new ArrayList<>();

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    public void addItem(OrderItem item) {
        this.itens.add(item);
    }
    public void removeItem(OrderItem item) {
        this.itens.remove(item);
    }

    public double totalPrice(){
        double som = 0;
        for (OrderItem x: itens){
            som += x.subTotal();
        }
        return som;

    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMARRY: \n");
        sb.append("ORDER MOMENT: " + fmt1.format(moment) + "\n");
        sb.append("ORDER STATUS: " + status + "\n");
        sb.append("CLIENT: " + client + "\n");
        sb.append("ORDER ITEMS: \n");
        for (OrderItem x : itens){
            sb.append(x);
        }
        sb.append("TOTAL PRICE: $" + totalPrice());
        return sb.toString();

    }




}

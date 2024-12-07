package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Item;

public class CustomerService {
    private List<Item> items;
    private Scanner sc;
    private Double billAmount;
    private String bill;

    public CustomerService(){
        billAmount = 0d;
        bill = "";
        items = new ArrayList<>();
        sc = new Scanner(System.in);
        System.out.print("Item: ");
        String[] inputs = sc.nextLine().split(",");
        for(String input: inputs){
            items.add(new Item(input));
        }
        generateBill();
        System.out.println("Amount to be paid: "+billAmount+" Rs "+bill);
    }

    public void generateBill(){
        bill = "";
        billAmount = 0d;
        for(Item item : items){
            if(!bill.isBlank()) bill += " + ";
            bill += item.generateBill();
            billAmount=billAmount+item.getTotalPrice();
        }

        bill  = "[Calculation: "+bill+" = "+billAmount+" RS]";
    }
}

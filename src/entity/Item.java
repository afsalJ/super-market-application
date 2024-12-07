package entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item {
    private String name;
    private Double price;
    private Double quanity;
    private Double total;
    private String regex = "(\\w+)\\s*\\((\\d+)\\s*[a-zA-Z]+\\s*@\\s*(\\d+)\\s*Rs/[a-zA-Z]+\\)";
    private Pattern pattern = Pattern.compile(regex);

    public Item(String item){
        try{
            Matcher matcher = pattern.matcher(item);
            if(matcher.find()){
                this.name = matcher.group(1);
                this.quanity = Double.parseDouble(matcher.group(2));
                this.price = Double.parseDouble(matcher.group(3));
                this.total = price * quanity;
            } else{
                throw new Exception("");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage() + "\nUnexpected error in Product creation!");
        }
    }

    public Double getTotalPrice(){
        return total;
    }

    public String generateBill(){
        return "("+quanity+" x "+price+")";
    }
}

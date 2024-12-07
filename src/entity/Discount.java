package entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Discount {
    private Double percentage;
    private String statement;
    private String regex = "(\\d+)%\\s*[a-zA-Z]+\\s*(\\w+)";
    private Pattern pattern = Pattern.compile(regex);
    private String on;

    public Discount(String discount){
        Matcher matcher = pattern.matcher(discount);
        if(matcher.find()){
            percentage = Double.parseDouble(matcher.group(1));
            on = matcher.group(2);
            statement =  "("+percentage+"% discount)";
        }else{
            percentage = 0d;
            on = "";
            statement = "";
        }
    }

    public String getStatement(){
        return statement;
    }

    public Double getDiscount(Double totalPrice){
        if(on.equalsIgnoreCase("total")){
            return totalPrice * (percentage/100.0);
        }
        return 0d;
    }

}

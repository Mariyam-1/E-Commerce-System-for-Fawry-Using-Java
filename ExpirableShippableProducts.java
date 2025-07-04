import java.time.LocalDate;
import Interfaces.Expirable;
import Interfaces.Shippable;

public class ExpirableShippableProducts extends Products implements Expirable, Shippable
 {
    private LocalDate expiryDate;
    private double weight;

    public ExpirableShippableProducts(String name, double price, int quantity, LocalDate expiryDate, double weight)
     {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() 
    {
        return  LocalDate.now().isAfter(expiryDate);
    }
     @Override
    public double getWeight()
     { 
        return weight; 
    }
    @Override
    public String getName() 
    { 
        return name; 
    }
   
}
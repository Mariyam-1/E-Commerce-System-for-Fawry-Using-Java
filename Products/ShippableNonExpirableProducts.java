package Products;
import Interfaces.Shippable;

public class ShippableNonExpirableProducts extends Products implements Shippable
 {
    private double weight;
    public ShippableNonExpirableProducts()
    {
        this.weight=0.0;
    }
    public ShippableNonExpirableProducts(String name, double price, int quantity, double weight)
    {
        super(name, price, quantity);
        this.weight=weight;
    }
   
    @Override
    public double getWeight()
     {
        return weight;
     }
    @Override
    public String getName(){
        return name;
    }
   


   

}

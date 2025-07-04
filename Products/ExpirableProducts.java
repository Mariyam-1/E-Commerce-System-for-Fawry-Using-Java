package Products;
import java.time.LocalDate;

import Interfaces.Expirable;

public class ExpirableProducts extends Products implements Expirable 
{
    private LocalDate expiryDate;

    public ExpirableProducts(String name, double price, int quantity,LocalDate expiryDate) 
    {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() 
    {
        return  LocalDate.now().isAfter(expiryDate);
    }
}

import java.util.ArrayList;
import java.util.List;
import Interfaces.Expirable;
import Interfaces.Shippable;


public class ShoppingCart {
    
    private List<Integer> quantities = new ArrayList<>();
    private List<Products> products = new ArrayList<>();

    public void add(Products product, int quantity) {
        if ( product.getQuantity() < quantity) 
        {
            throw new IllegalArgumentException("Sorry, There is no enough quantity available for " + product.getName());
        }

        if (product instanceof Expirable && ((Expirable) product).isExpired()) {
            throw new IllegalArgumentException(product.getName() + " is expired!");
        }

        int i = products.indexOf(product);
        if (i != -1) //Not empty  
        {
            int updatedQuantity = quantities.get(i) + quantity;
            if (updatedQuantity > product.getQuantity()) 
            {
                throw new IllegalArgumentException("Your needed quantity are more than our stock for " + product.getName());
            }
            quantities.set(i, updatedQuantity);
        }
         else
        {
            products.add(product);
            quantities.add(quantity);
        }
    }

    public int size() {
        return products.size();
    }

    public Products getProductAt(int index) {
        return products.get(index);
    }

    public int getQuantityAt(int index) {
        return quantities.get(index);
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < products.size(); i++) {
            subtotal += products.get(i).getPrice() * quantities.get(i);
        }
        return subtotal;
    }

    public List<Shippable> getShippableItems() 
    {
        List<Shippable> shippables = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) 
        {
            Products product = products.get(i);

            int quantity = quantities.get(i);
            if (product instanceof Shippable) {
                for (int j = 0; j < quantity; j++) {
                    shippables.add((Shippable) product);
                }
            }
        }
        return shippables;
    }
//To clear ypur cart
    public void clear() 
    {
        products.clear();
        quantities.clear();
    }
}

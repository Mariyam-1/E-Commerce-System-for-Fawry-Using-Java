package Customer;
import java.time.LocalDate;

import Products.ExpirableShippableProducts;
import Products.NonShippableProducts;
import Products.Products;
import Products.ShippableNonExpirableProducts;

public class ECommerceSystem {
    public static void main(String[] args) {
       

        Products cheese = new ExpirableShippableProducts("Cheese", 100, 10,getDateOffsetFromToday(7), 200);
        Products biscuits = new ExpirableShippableProducts("Biscuits", 150, 8, getDateOffsetFromToday(21), 700);
        Products scratchCard = new NonShippableProducts("Mobile scratch card", 50, 20);
        Products tv = new ShippableNonExpirableProducts("TV", 500, 5, 5000);

        Customer customer = new Customer("Fawry Company", 2500);

       
        ShoppingCart cart = new ShoppingCart();
        CheckOut checkoutService = new CheckOut();

        //test Case
        try {
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(tv, 1);
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }

    private static LocalDate getDateOffsetFromToday(int days) {
        return LocalDate.now().plusDays(days);
    }
}

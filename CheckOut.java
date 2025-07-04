import java.util.ArrayList;
import java.util.List;
import Interfaces.Expirable;
import Interfaces.Shippable;

public class CheckOut {
public void checkout(Customer customer, ShoppingCart cart) 
{
    if (cart.size() == 0) {
        throw new IllegalStateException("Your Cart is empty, Add products to Checkout");
    }

    for (int i = 0; i < cart.size(); i++) {
        Products product = cart.getProductAt(i);
        int quantity = cart.getQuantityAt(i);

        if (product.getQuantity() < quantity) {
            throw new IllegalStateException(product.getName() + " is out of stock");
        }

        if (product instanceof Expirable && ((Expirable) product).isExpired()) {
            throw new IllegalStateException(product.getName() + " is expired");
        }

        // ✅ Reject non-shippable items explicitly
        if (!(product instanceof Shippable)) {
            throw new IllegalStateException(product.getName() + " cannot be shipped.");
        }
    }

    List<Shippable> shippables = cart.getShippableItems();
    double subtotal = cart.calculateSubtotal();
    double shippingFee = calculateShippingFee(shippables);
    double total = subtotal + shippingFee;

    if (customer.getBalance() < total) {
        throw new IllegalStateException("Insufficient balance");
    }

    if (!shippables.isEmpty()) {
        shipItems(shippables);
    }

    for (int i = 0; i < cart.size(); i++) {
        Products product = cart.getProductAt(i);
        int quantity = cart.getQuantityAt(i);
        product.decreaseQuantity(quantity);
    }

    customer.decreaseBalance(total);
    
    printReceipt(cart, subtotal, shippingFee, total, customer.getBalance());
    cart.clear();
}

    private double calculateShippingFee(List<Shippable> shippables) {
        double totalWeight = 0;
        for (Shippable item : shippables) {
            if (item instanceof Products) {
                totalWeight += item.getWeight();
            } else {
                throw new IllegalStateException("Encountered non-product in shipping list");
            }
        }
        return (totalWeight / 1000.0) * 10; // 10 pounds per kilo
    }

    private void shipItems(List<Shippable> items) {
        System.out.println("** Shipment notice **");

        List<String> descriptions = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            if (!(item instanceof Products)) {
                throw new IllegalStateException("Attempted to ship a non-product item.");
            }

            String desc = item.getName() + " " + (int) item.getWeight() + "g";
            int index = descriptions.indexOf(desc);
            if (index >= 0) {
                counts.set(index, counts.get(index) + 1);
            } else {
                descriptions.add(desc);
                counts.add(1);
            }

            totalWeight += item.getWeight();
        }

        for (int i = 0; i < descriptions.size(); i++) {
            System.out.println(counts.get(i) + "x " + descriptions.get(i));
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight / 1000);
    }

    private void printReceipt(ShoppingCart cart, double subtotal, double shippingFee, double total, double newBalance) {
        System.out.println("** Checkout receipt **");

        for (int i = 0; i < cart.size(); i++) {
            Products product = cart.getProductAt(i);
            int quantity = cart.getQuantityAt(i);
            System.out.printf("%dx %s %.0f\n", quantity, product.getName(), product.getPrice() * quantity);
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shippingFee);
        System.out.printf("Amount %.0f\n", total);
        System.out.printf("New balance %.0f\n", newBalance);
    }
}

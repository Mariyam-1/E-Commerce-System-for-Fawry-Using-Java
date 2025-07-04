public abstract class Products 
 {
    protected String name;
    protected double price;
    protected int quantity;

    Products()
    {
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
    }
    Products(String name, double price, int quantity)
    {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public String getName()
    {
        return name;
    }
    public double getPrice()
    {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public boolean inStock(int required_amount)
    {
        return quantity>=required_amount; 
    }
    public void decreaseQuantity(int required_amount)
    {
         if (required_amount > quantity) {
            throw new IllegalArgumentException("Cannot reduce quantity more than available");
        }
        quantity -= required_amount;
    }

    
}

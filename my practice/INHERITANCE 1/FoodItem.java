public class FoodItem {
   private String name;
   private double price;
    private int quantity;
    public FoodItem(FoodItem ob){
        this.name = ob.getName();
        this.price = ob.getPrice();
        this.quantity = ob.getQuantity();
    }
    
    public FoodItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    void displayInfo(){
        System.out.println("Name: "+name+"   Price: "+ price+"  Quantity: "+quantity);
    }
    public void applyDiscount(double x){
        price = price - price*x/100;
    }
    
}

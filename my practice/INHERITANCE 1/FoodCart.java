public class FoodCart {
         private FoodItem[] items = new FoodItem[10];
         private int size =  0;
         public void addItem(FoodItem ob){
            items[size++] = ob;
         }
         public void showCart(){
            for(int i = 0; i<size; i++){
                items[i].displayInfo();
                System.out.println("---------------------------------");
            }
         }
         public double  calculateTotal(){
            double total = 0;
            for(int i = 0; i<size; i++){
                total += items[i].getPrice()*items[i].getQuantity();
                
            }
            return total;
         }

} 

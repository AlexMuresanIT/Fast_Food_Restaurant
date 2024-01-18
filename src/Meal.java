import java.util.ArrayList;
import java.util.List;

public class Meal {

    private Hamburger hamburger;
    private SideItem sideItem;
    private Drink drink;
    public boolean isDeluxe;



    public Meal(boolean isDeluxe, Hamburger hamburger, SideItem sideItem, Drink drink){
        this.hamburger=hamburger;
        this.sideItem=sideItem;
        this.drink=drink;
    }

    public void addTopping(String topping, double price) {
        hamburger.addTopping(topping,price);
    }

    public void changeSizeSide(SideItem side,String size){
        side.setSize(size);
    }

    public void changeSizeDrink(Drink drink, String size) {drink.setSize(size); }

    public void printPriceList()
    {
        System.out.println("Menu prices:");
        if(hamburger.type.equals("deluxe")){
            System.out.println("Deluxe hamburger price: $"+hamburger.price);
        }
        else{
            System.out.println(hamburger.type+" hamburger price: $"+hamburger.getPrice());
        }
        System.out.println("Toppings: \n"+hamburger);
        System.out.println("_________________________________");
        System.out.println(sideItem.getType()+ " size: "+sideItem.getSize()+" price: $"+sideItem.getPrice());
        System.out.println("_________________________________");
        System.out.println(drink.getType()+" size: "+drink.getSize()+" price: $"+drink.getPrice());
        System.out.println("_________________________________");
    }

    public void totalMealPrice(){
        System.out.println("Your total is: $"+(hamburger.getPrice()+ drink.getPrice()+ sideItem.getPrice()));
        System.out.println("Thank you for ordering from us!!!");
    }
}

class Item{

    protected String type;
    protected double price;

    public Item(String type,double price){
        this.type=type;
        this.price=price;
    }

    @Override
    public String toString() {
        return "%2s $%.2f".formatted(type,price);
    }
}

class Hamburger extends Item{
    private List<Item> toppings = new ArrayList<>();
    private static int nrTopping=0;

    public Hamburger(String type){

        super(type,0);
        if(type.equals("deluxe")){
            this.price=10;
        }
        if(type.equals("regular")){
            this.price=7;
        }
    }


    public void addTopping(String topping, double price){
        toppings.add(new Item(topping,price));
    }

    @Override
    public String toString() {

        StringBuilder item = new StringBuilder();
        for(Item topping:toppings){
            item.append("\n");
            item.append(topping);
        }
        return item.toString();
    }

    public double getPrice(){

        double total = super.price;
        for(Item topping:toppings){
            total+=topping.price;
        }
        return total;
    }

}


class SideItem{

    private String type;
    private int price;

    private String size;

    public SideItem(String type, String size){

        this.type=type;
        this.size=size;
        if(size.equals("small"))
            this.price=5;
        else if (size.equals("medium")) {
            this.price=7;
        } else if (size.equals("large")) {
            this.price=10;
        }
    }

    public int getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if(size.equals("small"))
            this.price=5;
        else if (size.equals("medium")) {
            this.price=7;
        } else if (size.equals("large")) {
            this.price=10;
        }
        this.size = size;
    }

    public String getType() {
        return type;
    }
}

class Drink{

    private String type;
    private String size;
    private int price;

    public Drink(String type, String size){
        this.type=type;
        this.size=size;
        if(size.equals("small"))
            price=3;
        else if (size.equals("medium")) {
            price=5;
        } else if (size.equals("large")) {
            price=7;
        }

    }

    public void setSize(String size) {
        if(size.equals("small"))
            price=3;
        else if (size.equals("medium")) {
            price=5;
        } else if (size.equals("large")) {
            price=7;
        }
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }


}

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

    public void addTopping(Hamburger burger,String topping) {
        String oneTopping=burger.addTopping(topping);
        System.out.println("Added topping: "+oneTopping);
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
            System.out.println(hamburger.type+" hamburger price: $"+hamburger.price);
        }
        System.out.println("Number of toppings: "+hamburger.getNrTopping());
        System.out.println("_________________________________");
        System.out.println(sideItem.getType()+ " size: "+sideItem.getSize()+" price: $"+sideItem.getPrice());
        System.out.println("_________________________________");
        System.out.println(drink.getType()+" size: "+drink.getSize()+" price: $"+drink.getPrice());
        System.out.println("_________________________________");
    }

    public void totalMealPrice(){
        System.out.println("Your total is: $"+(hamburger.price+ drink.getPrice()+ sideItem.getPrice()));
        System.out.println("Thank you for ordering from us!!!");
    }
}

class Item{

    protected String type;
    protected int price;

    public Item(String type){
        this.type=type;
    }
}

class Hamburger extends Item{

    private String topping;

    private static int nrTopping=0;

    public Hamburger(String type){

        super(type);
        if(type.equals("deluxe")){
            this.price=10;
        }
        if(type.equals("regular")){
            this.price=7;
        }
    }


    public String addTopping(String topping){
        if(nrTopping<=3 && type.equals("regular")){
            nrTopping++;
            this.topping=topping;
        }
        else
            if(nrTopping<=5 && type.equals("deluxe")){
                nrTopping++;
                this.topping=topping;
            }
            if(nrTopping == 3 && type.equals("regular")){
                System.out.println("You have regular menu. You can add up to 3 toppings");
            } else if (nrTopping == 5 && type.equals("deluxe")) {
                System.out.println("You have deluxe menu. You can add up to 5 toppings");
            }
            return topping;
    }

    public String getTopping() {
        return topping;
    }

    public int getNrTopping() {
        return nrTopping;
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
}

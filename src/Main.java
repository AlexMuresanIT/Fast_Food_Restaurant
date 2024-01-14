import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Order();
    }

    public static void Order(){

        Scanner s = new Scanner(System.in);

        while(true){


            System.out.println("-----------------------------");
            System.out.println("HAMBURGER");
            System.out.println("Regular burger: $7");
            System.out.println("Deluxe burger: $10");
            System.out.println("Topping: $3 each");
            System.out.println("Regular burger: up to 3 toppings");
            System.out.println("Deluxe burger: up to 5 toppings");
            System.out.println("-----------------------------");
            System.out.println("SIDE DISH");
            System.out.println("small side: $5");
            System.out.println("medium side: $7");
            System.out.println("large side: $10");
            System.out.println("-----------------------------");
            System.out.println("DRINK");
            System.out.println("small drink: $3");
            System.out.println("medium drink: $5");
            System.out.println("large drink: $7");
            System.out.println("-----------------------------");

            System.out.println("Choose your hambruger (regular or deluxe)");
            String ham = s.nextLine();
            boolean isDeluxe=false;
            if(ham.equals("deluxe"))
                isDeluxe=true;
            else
                if(ham.equals("regular"))
                    isDeluxe=false;

            Hamburger hamburger = new Hamburger(ham);

            System.out.println("Choose your side");
            String sid = s.nextLine();

            System.out.println("Choose your size");
            String siz = s.nextLine();
            SideItem side = new SideItem(sid,siz);

            System.out.println("Choose your drink");
            String dri = s.nextLine();
            System.out.println("Choose your size");
            String si = s.nextLine();
            Drink drink = new Drink(dri,si);

            Meal meal = new Meal(isDeluxe,hamburger,side,drink);

            String response;

            System.out.println("Do you want something else?");
            response=s.nextLine();

            if(response.equals("no")){
                meal.printPriceList();
                meal.totalMealPrice();
                break;
            }
            else {
                System.out.println("Do you want to change something?");
                response = s.nextLine();
            }
            if(response.equals("yes")){
                change(meal,hamburger,side,drink);
                break;
            } else if (response.equals("no")) {
                meal.printPriceList();
                meal.totalMealPrice();
                break;
            }

        }
    }

    public static void change(Meal meal,Hamburger ham, SideItem side, Drink drink){

        Scanner s = new Scanner(System.in);
        String choice;
       while(true){

           System.out.println("Do you want to change side or drink?");
           String response = s.nextLine();

           if(response.equals("side")){
               System.out.println("Your changed size for side:");
               choice=s.nextLine();
               meal.changeSizeSide(side,choice);
           }
           else
               if(response.equals("drink")){
                   System.out.println("Your changed size for drink:");
                   choice=s.nextLine();
                   meal.changeSizeDrink(drink,choice);
               } else if (response.equals("no")) {
                   meal.printPriceList();
                   meal.totalMealPrice();
                   break;
               }
       }

    }
}
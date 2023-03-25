import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArL {

    public static void arrayListSortPrice(ArrayList<Drink> menuList) {

        for (Drink drink : menuList) {
            System.out.println(drink.toString());
        }

        // System.out.println("\n" + menuList.get(3)); 

        // Comparator<Drink> cmpPrice = new Comparator<Drink>() {
        //     @Override
            // public int compare(Drink o1, Drink o2) {
            //     return (int)(o1.getPrice() - o2.getPrice());
            // }
        // }; Collections.sort(menuList, cmpPrice);

        Collections.sort(menuList, new Comparator<Drink>() {
            @Override
            public int compare(Drink o1, Drink o2) {
                //ascending
                //return (int)(o1.getPrice() - o2.getPrice());
                //decending
                return (int)-(o1.getPrice() - o2.getPrice());
            }
        });

        System.out.println();
        for (Drink drink : menuList) {
            System.out.println(drink.toString());
        }
    }

    public static void sortByMenu(ArrayList<Drink> menuList) {
        for (Drink drink : menuList) {
            System.out.println(drink.toString());
        }

        Collections.sort(menuList, new Comparator<Drink>() {
            @Override
            public int compare(Drink o1, Drink o2) {
                // TODO Auto-generated method stub
                return (int)(o1.getMenu().compareToIgnoreCase(o2.getMenu()));
            }
        });

        System.out.println("sorted--------------------------");
        for (Drink drink : menuList) {
            System.out.println(drink.toString());
        }
    }


    public static void sortbyCategoryAndMeny(ArrayList<Drink> menuList) {
        for (Drink drink : menuList) {
            System.out.println(drink.toString());
        }

        Collections.sort(menuList, new Comparator<Drink>() {
            @Override
            public int compare(Drink o1, Drink o2) {
                // TODO Auto-generated method stub
                if (o1.getCategory().equalsIgnoreCase(o2.getCategory())) {
                    return (int)(o1.getMenu().compareToIgnoreCase(o2.getMenu()));
                }
                else {
                    return o1.getCategory().compareToIgnoreCase(o2.getCategory());
                }

            }
        });

        System.out.println("sorted--------------------------");
        for (Drink drink : menuList) {
            System.out.println(drink.toString());
        }
        
    }

    public static void sortWithComaprable(ArrayList<Drink> menuList) {
        System.out.println("sorted--------------------------");
        for (Drink drink : menuList) {
            System.out.println(drink.toString());
        }

        Collections.sort(menuList);

        System.out.println("sorted--------------------------");
        for (Drink drink : menuList) {
            System.out.println(drink.toString());
        }
    }

    public static void sortWithComaprableJava8(ArrayList<Drink> menuList) {
        System.out.println("sorted--------------------------");
        for (Drink drink : menuList) {
            System.out.println(drink.toString());
        }

        // menuList.sort(Comparator.comparing(Drink::getPrice));
        menuList.sort(Comparator.comparing(Drink::getPrice).reversed());

        System.out.println("sorted--------------------------");
        for (Drink drink : menuList) {
            System.out.println(drink.toString());
        }
    }

    public static void sortWithComaprableJava8_2(ArrayList<Drink> menuList) {
        System.out.println("sorted--------------------------");
        for (Drink drink : menuList) {
            System.out.println(drink.toString());
        }

        menuList.sort(Comparator.comparing(Drink::getCategory).thenComparing(Drink::getPrice));
        // menuList.sort(Comparator.comparing(Drink::getPrice).thenComparing(Drink::getCategory).reversed());
        System.out.println("sorted--------------------------");
        for (Drink drink : menuList) {
            System.out.println(drink.toString());
        }
    }

    public static void main(String[] args) {
        ArrayList<Drink> menuList = new ArrayList<>();
        menuList.add(new Drink("Iced Americano", "Coffee", 120));
        menuList.add(new Drink("Hot Americano", "Coffee", 70));
        menuList.add(new Drink("Iced Greentea", "Tea", 115));
        menuList.add(new Drink("Iced Latte", "Cofee", 150));
        menuList.add(new Drink("Iced Lemon Soda", "Soda", 135));
        menuList.add(new Drink("Iced Peach Soda", "Soda", 140));
        menuList.add(new Drink("Iced Matcha Latte", "Tea", 175));
        // arrayListSortPrice();
        // sortByMenu(menuList);
        // sortbyCategoryAndMeny(menuList);
        // sortWithComaprable(menuList);
        // sortWithComaprableJava8(menuList);
        // sortWithComaprableJava8_2(menuList);

        Drink m = new Drink("Iced Americano", "Coffee", 120);
        
        System.out.println( menuList.contains(m) ) ;
    }

    
}

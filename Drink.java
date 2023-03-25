public class Drink implements Comparable<Drink> {
    private String menu, category;
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Drink drink = (Drink) o;

        if (price != drink.price) {
            return false;
        }
        if (!category.equals(drink.category)) {
            return false;
        }
        if (!menu.equalsIgnoreCase(drink.menu)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = menu.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + price;
        return result;
    }

    public Drink() {
        
    }

    public Drink(String menu, String categort, int price) {
        this.menu = menu;
        this.category = categort;
        this.price = price;
    }


    public String getMenu() {
        return this.menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategort(String category) {
        this.category = category;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Drink: {" +
                    "Menu: " + menu +
                    " Category: " + category + 
                    " Price: " + price + " }"; 
    }

    @Override
    public int compareTo(Drink o) { //natural ordering
        if (this.category.equals(o.category)) {
            return this.menu.compareToIgnoreCase(o.menu);
        } else {
            return this.category.compareToIgnoreCase(o.category);
        }
    }

}

package com.company;

/**
 * Created by prasert on 10/4/2014.
 */
public class Drink implements Comparable<Drink>{
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

    public Drink(String menu, String category, int price) {
        this.menu = menu;
        this.category = category;
        this.price = price;
    }

    public Drink() {
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "menu='" + menu + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Drink o) { // class's natural ordering
        if (this.getCategory().equalsIgnoreCase(o.getCategory())) {
            return this.getMenu().compareToIgnoreCase(o.getMenu());
        } else {
            return this.getCategory().compareToIgnoreCase(o.getCategory());
        }
    }
}

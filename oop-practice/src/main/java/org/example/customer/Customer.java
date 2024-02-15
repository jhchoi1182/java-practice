package org.example.customer;

public class Customer {
    public void order(String menuName, Menu menu, Cooking cooking) {
        MenuItem menuItem = menu.choose(menuName);
        cooking.makeCook(menuItem);

    }
}

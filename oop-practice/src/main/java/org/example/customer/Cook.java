package org.example.customer;

import java.util.Objects;

public class Cook {
    private final String name;
    private final int price;

    public Cook(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Cook(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
    }

    // 객체끼리 비교할 때 생성에서 ''equals()' 및 'hashCode()' 생성'을 해줘야 함
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cook cook = (Cook) o;
        return price == cook.price && Objects.equals(name, cook.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

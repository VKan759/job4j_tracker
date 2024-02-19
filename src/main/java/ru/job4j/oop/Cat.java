package ru.job4j.oop;

public class Cat {
    private String name;
    private String food;

    public void show() {
        System.out.println("There are " + this.name + '\'' + "s food - " + this.food);
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.giveNick("Vasya");
        cat.eat("Kotleta");
        cat.show();
    }
}

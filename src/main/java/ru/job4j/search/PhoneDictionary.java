package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getPhone().toLowerCase().contains(key.toLowerCase())
                    || person.getAddress().toLowerCase().contains(key.toLowerCase())
                    || person.getName().toLowerCase().contains(key.toLowerCase())
                    || person.getSurname().toLowerCase().contains(key.toLowerCase())) {
                result.add(person);
            }
        }
        return result;
    }
}
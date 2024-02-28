package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setNameSurname("Vyacheslav Kan");
        student.setGroup("E-13-7");
        student.setReceiptDate(LocalDate.of(2012, 9, 1));

        System.out.println("Student: " + student.getNameSurname() + System.lineSeparator()
                + "Group: " + student.getGroup() + System.lineSeparator()
                + "Receipt date: " + student.getReceiptDate());
    }
}

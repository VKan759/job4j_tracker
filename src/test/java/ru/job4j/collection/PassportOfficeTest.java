package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddDuplicateMethod() {
        PassportOffice passportOffice = new PassportOffice();
        Citizen citizen = new Citizen("1234567", "Vyacheslav");
        Citizen citizen1 = new Citizen("1234567", "Slava");
        passportOffice.add(citizen);
        passportOffice.add(citizen1);
        assertThat(passportOffice.get(citizen.getPassport())).isEqualTo(citizen1);
    }
}
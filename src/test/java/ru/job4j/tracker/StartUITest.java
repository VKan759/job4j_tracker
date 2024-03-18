package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Input input = new MockInput(
                new String[]{"0", "Item name", "1"}
        );
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "0. Добавить новую заявку" + ln
                        + "1. Показать все заявки" + ln
                        + "2. Изменить заявку" + ln
                        + "3. Удалить заявку" + ln
                        + "4. Показать заявку по id" + ln
                        + "5. Показать заявки по имени" + ln
                        + "6. Завершить программу" + ln
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "0. Добавить новую заявку" + ln
                        + "1. Показать все заявки" + ln
                        + "2. Изменить заявку" + ln
                        + "3. Удалить заявку" + ln
                        + "4. Показать заявку по id" + ln
                        + "5. Показать заявки по имени" + ln
                        + "6. Завершить программу" + ln
                        + "=== Редактирование заявки ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "0. Добавить новую заявку" + ln
                        + "1. Показать все заявки" + ln
                        + "2. Изменить заявку" + ln
                        + "3. Удалить заявку" + ln
                        + "4. Показать заявку по id" + ln
                        + "5. Показать заявки по имени" + ln
                        + "6. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenWhenFindAllActionIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item firstItem = new Item("First item");
        Item secondItem = new Item("Second item");
        tracker.add(firstItem);
        tracker.add(secondItem);
        Input input = new MockInput(new String[]{
                "0", "1"
        });
        UserAction[] actions = new UserAction[]{
                new FindAllAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(

                "0. Добавить новую заявку" + ln
                        + "1. Показать все заявки" + ln
                        + "2. Изменить заявку" + ln
                        + "3. Удалить заявку" + ln
                        + "4. Показать заявку по id" + ln
                        + "5. Показать заявки по имени" + ln
                        + "6. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + firstItem + ln
                        + secondItem + ln
                        + "0. Добавить новую заявку" + ln
                        + "1. Показать все заявки" + ln
                        + "2. Изменить заявку" + ln
                        + "3. Удалить заявку" + ln
                        + "4. Показать заявку по id" + ln
                        + "5. Показать заявки по имени" + ln
                        + "6. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln

        );
    }

    @Test
    void whenFindByNameIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input input = new MockInput(new String[]{
                "0", item.getName(), "1"
        });
        UserAction[] actions = {
                new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(

                "0. Добавить новую заявку" + ln
                        + "1. Показать все заявки" + ln
                        + "2. Изменить заявку" + ln
                        + "3. Удалить заявку" + ln
                        + "4. Показать заявку по id" + ln
                        + "5. Показать заявки по имени" + ln
                        + "6. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + item + ln
                        + "0. Добавить новую заявку" + ln
                        + "1. Показать все заявки" + ln
                        + "2. Изменить заявку" + ln
                        + "3. Удалить заявку" + ln
                        + "4. Показать заявку по id" + ln
                        + "5. Показать заявки по имени" + ln
                        + "6. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln);
    }

    @Test
    void whenFindByIdIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input input = new MockInput(new String[]{
                "0", String.valueOf(item.getId()), "1"
        });
        UserAction[] actions = {
                new FindByIdAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(

                "0. Добавить новую заявку" + ln
                        + "1. Показать все заявки" + ln
                        + "2. Изменить заявку" + ln
                        + "3. Удалить заявку" + ln
                        + "4. Показать заявку по id" + ln
                        + "5. Показать заявки по имени" + ln
                        + "6. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + item + ln
                        + "0. Добавить новую заявку" + ln
                        + "1. Показать все заявки" + ln
                        + "2. Изменить заявку" + ln
                        + "3. Удалить заявку" + ln
                        + "4. Показать заявку по id" + ln
                        + "5. Показать заявки по имени" + ln
                        + "6. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln);
    }
}
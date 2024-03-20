package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("ElementNotFoundException");
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"name1", "name2", "name3"}, "name");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
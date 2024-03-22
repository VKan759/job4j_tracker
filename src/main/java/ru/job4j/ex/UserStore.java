package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                result = user;
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("UserNotFoundException");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("UserInvalidException");
        }
        return user.isValid();
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("VKan", true)
        };
        User user;
        try {
            user = findUser(users, "VKan");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            System.out.println("Пользователь не валидный");
            ui.printStackTrace();
        } catch (UserNotFoundException e) {
            System.out.println("Пользователь не найден");
            e.printStackTrace();
        }
    }
}
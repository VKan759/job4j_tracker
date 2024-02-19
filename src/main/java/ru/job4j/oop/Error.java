package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Error status: " + active);
        System.out.println("Status amount: " + status);
        System.out.println("Message: " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        Error firstError = new Error(true, 1, "Обнаружена ошибка");
        Error secondError = new Error(false, 0, "Ошибка не обнаружена");
        Error thirdError = new Error(true, 2, "Обнаружена ошибка");
        defaultError.printInfo();
        firstError.printInfo();
        secondError.printInfo();
        thirdError.printInfo();
    }

}

package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса
 *
 * @author Vyacheslav Kan
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход 1 параметр типа User и добавляет его в коллекцию, если этот объект отсутствует в
     * коллекции. В случае, если пользователь существует, добавление не осуществляется.
     *
     * @param user новый пользователь, который добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход номер паспорта, который является полем объекта класса User и
     * удаляет пользователя с передаваемым номером паспорта
     *
     * @param passport номер паспорта, передаваемый в метод
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает на вход 2 парметра: номер паспорта, аккаунт
     * В случае если находится пользователь с указанным номером паспорта, выполняется проверка на наличие аккаунта у
     * найденного пользователя
     * В случае отсутствия у пользователя передаваемого в метод параметра типа Account выполняется добавление нового
     * аккаунта в список аккаунтов (коллекция типа ArrayList)
     *
     * @param passport номер паспорта пользователя
     * @param account  добавляемый аккаунт
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * метод принимает на вход номер паспорта
     * в случае нахождения пользователя с передаваемым на вход номером паспорта метод возвращает пользователя (объект
     * типа User)
     *
     * @param passport номер паспорта, передаваемый в метод
     * @return взвращает пользователя с указанным номером паспорта либо возвращает null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход 2 параметра: номер паспорта и реквизиты типа String
     * На основании входных параметров выполняет: поиск аккаунта у пользователя с вводимым номером паспорта.
     * В случае наличия пользователя с указанным папортом, выполняется поиск аккаунта с указанными реквизитами и
     * возвращается аккаунт после выполнения метода.
     * В случае отсутствия пользователя или аккаунта у пользователя, возвращается null
     *
     * @param passport  номер паспорта, передаваемый в метод
     * @param requisite реквизиты аккаунта пользователя, передаваемые в метод
     * @return возвращает аккаунт в случае его нахождения, либо возвращает null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход 5 параметров: номер паспорта и реквизиты аккаунта отправителя, номер паспорта и
     * реквизиты аккаунта получателя, сумма перевода
     * Если имеются получатель и отправитель с указанными паспортными данными, то выполняется проверка наличия
     * указанных аккаунтов. В случае наличия аккаунтов проверяется достаточно ли средств для перевода.
     *
     * @param sourcePassport       номер паспорта отправителя
     * @param sourceRequisite      реквизиты аккаунта отправителя
     * @param destinationPassport  номер паспорта отправителя
     * @param destinationRequisite реквизиты аккаунта получателя
     * @param amount               сумма перевода
     * @return возвращает true если перевод совершен успешно, в противном случае возвращает false
     */

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {

        boolean result = false;
        Account accountSource = findByRequisite(sourcePassport, sourceRequisite);
        Account accountDestination = findByRequisite(destinationPassport, destinationRequisite);
        if (accountSource != null
                && accountDestination != null
                && accountSource.getBalance() >= amount
        ) {
            accountSource.setBalance(accountSource.getBalance() - amount);
            accountDestination.setBalance(accountDestination.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * метод принимает на вход пользователя
     *
     * @param user пользователь, аккауны которого необходимо получить
     * @return возвращает коллекцию ArrayList аккаунтов. Если аккаунты не были добавлены, возвращает пустую коллекцию
     * ArrayList
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
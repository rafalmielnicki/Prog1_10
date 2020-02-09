package sda.prog1_10.bank1;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    static Integer customerNumber = 0;//statyczne, żeby było widoczne dla wszystkich instancji
    static Integer accountNumber = 0;//statyczne, żeby było widoczne dla wszystkich instancji

    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public boolean addCustomer(Customer customer) {
        if(checkCustomerOnList(customer)) {
            System.out.println("Klient " + customer + " już jest w systemie.");
            return false;
        }
        customer.setId(customerNumber.toString());
        customers.add(customer);
        customerNumber++;
        System.out.println("Klient " + customer + " dodany");
        return true;
    }

    public boolean removeCustomer(Customer customer) {
        if (checkCustomerOnList(customer)) {
            return removeCustomerIfHasNoAccounts(customer);
        }
        return customerNotFound(customer);
    }

    private boolean customerNotFound(Customer customer) {
        System.out.println("Klienta " + customer + " nie znaleziono w systemie.");
        return false;
    }

    private boolean removeCustomerIfHasNoAccounts(Customer customer) {
        if(customer.getAccounts().isEmpty()) {
            return removeCustomerWithEmptyAccountList(customer);
        }
        System.out.println("Nie można usunąć klienta " + customer
                + " bo ma otwarte rachunki");
        return false;
    }

    private boolean removeCustomerWithEmptyAccountList(Customer customer) {
        customers.remove(customer);
        System.out.println("Klient " + customer + " usunięty.");
        return true;
    }

    public boolean addAccount(Customer customer, AccountKind accountKind) {
        if(checkCustomerOnList(customer)) {
            List<Account> customerAccounts = customer.getAccounts();
            Account account = new Account("IBAN"+accountNumber.toString());
            account.setAccountKind(accountKind);
            customerAccounts.add(account);
            accountNumber++;
            System.out.println("Dla klienta " + customer +
                    " założono konto " + account);
            return true;
        }
        return customerNotFound(customer);
    }

    public boolean deposit(Customer customer, Account account, int amount) {
        if (customers.contains(customer)) {
            List<Account> accounts = customer.getAccounts();
            if(accounts.contains(account)) {
                accounts.get(accounts.indexOf(account))
                        .deposit(amount);
                customer.setAccounts(accounts);
                System.out.println("Wpłata " + amount + " na  rachunek "
                + account + " zaksięgowana.");
            }
        }
        return customerNotFound(customer);
    }

    public boolean withdraw(Customer customer, Account account, int amount) {
        if(checkCustomerOnList()) {
            List<Account> accounts = customer.getAccounts();
            if(accounts.contains(account)) {
                if(
                        accounts.get(accounts.indexOf(account)).withdraw(amount)
                ) {//lista kont, bierzemy konkretne konto metod get zwraca nam konkretne konto za pomocą indexu
                    System.out.println("Wypłata " + amount + " z rachunku "
                            + account + "zaksięgowana.");
                return true;
                }
                System.out.println("Wypłata nie powiodła się.");
                return false;
            }
            System.out.println("Nie znaleziono konta " + account
            + "dla klienta " + customer);
            return false;
        }
        return customerNotFound(customer);
    }

    public void printAccountList(Customer customer, boolean printBalance) {
        if(checkCustomerOnList(customer)) {
            List<Account> accounts = customer.getAccounts();
            accounts.stream()
                    .forEach(a -> System.out.println(
                            "\t" + a.getAccountNumber() +
                              " " + a.getAccountKind() +
                                    (printBalance ? a.getBalance() : "")
                    ));
        }
    }

    public void printCustomerList(boolean printBalance) {
        customers.stream().
                forEach(c ->
                    printCustomerAndHisAccounts(printBalance, c)
                );
    }

    private void printCustomerAndHisAccounts(boolean printBalance, Customer c) {
        System.out.println(c);
        printAccountList(c, printBalance);
    }

    private boolean checkCustomerOnList(Customer customer) {
        return customers.contains(customer);
    }

}

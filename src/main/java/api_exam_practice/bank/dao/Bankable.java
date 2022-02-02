package api_exam_practice.bank.dao;

import api_exam_practice.bank.beans.Client;

public interface Bankable {
    void showMenu();
    void startSystem();
    void endSystem();
    void addClient(Client client);
    void deleteClient(int id);
    void withdraw(double amount);
    void deposit(double amount);
    void printAll();
}

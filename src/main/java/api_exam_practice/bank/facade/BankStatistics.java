package api_exam_practice.bank.facade;

import api_exam_practice.bank.beans.Client;
import api_exam_practice.bank.beans.Person;

import java.util.List;

public class BankStatistics {

    public static int countMembers(){
        return Person.totalUsers;
    }

    public static double getBankBalance(){
        return Person.totalSum;
    }

    public static Client getRichestClient(List<Person> clients){
        return (Client) clients.get(clients.size()-1);
    }

    public static Client getPoorestClient(List<Person> clients){
        return (Client) clients.get(0);
    }
}

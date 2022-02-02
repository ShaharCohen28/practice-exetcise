package api_exam_practice.bank.facade;

import api_exam_practice.bank.beans.Client;
import api_exam_practice.bank.beans.Person;
import api_exam_practice.bank.beans.RegularClient;
import api_exam_practice.bank.beans.VipClient;
import api_exam_practice.bank.dao.Bankable;
import api_exam_practice.bank.threads.InterestTask;

import java.util.*;

public class BankSystem implements Bankable {
    private InterestTask task;
    private Set<Client> clientSet =new TreeSet<Client>(new Comparator<Client>() {
        @Override
        public int compare(Client c1, Client c2) {
            if(c1.getAccount().getBalance()>c2.getAccount().getBalance()){
                return 1;
            }else if(c1.getAccount().getBalance()<c2.getAccount().getBalance()){
                return 1;
            }else{
                return 0;
            }
        }
    });
    private static Scanner scanner=new Scanner(System.in);


    public BankSystem(){
        this.task=new InterestTask(this.clientSet);
        Thread thread=new Thread(this.task);
        thread.start();
        startSystem();
    }


    @Override
    public void showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MENU\nchoose between the options\n");
        stringBuilder.append("1- Add client\n");
        stringBuilder.append("2- delete client\n");
        stringBuilder.append("3- withdraw money\n");
        stringBuilder.append("4- deposit money\n");
        stringBuilder.append("5- print all clients\n");
        stringBuilder.append("6- find richest\n");
        stringBuilder.append("7- find poorest\n");
        stringBuilder.append("8- total money\n");
        stringBuilder.append("9- exit system\n");
        System.out.println(stringBuilder.toString());

    }

    @Override
    public void startSystem() {
        int choice, clientId;
        char clientType;
        double sum;
        do{
            showMenu();
            choice= scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("enter 'v' for vip client or 'r' for regular");
                    clientType=scanner.next().charAt(0);
                    if(clientType=='v'|| clientType=='V'){
                        addClient(new VipClient());
                    }else{
                        addClient(new RegularClient());
                    }
                    break;
                case 2:
                    System.out.println("enter client id to delete");
                    clientId=scanner.nextInt();
                    deleteClient(clientId);
                    break;
                case 3:
                    System.out.println("enter amount to withdraw");
                    sum= scanner.nextDouble();
                    withdraw(sum);
                    break;
                case 4:
                    System.out.println("enter amount to deposit");
                    sum= scanner.nextDouble();
                    deposit(sum);
                    break;
                case 5:
                    printAll();
                    break;
                case 6:
                    System.out.println("richest client: " + BankStatistics.getRichestClient(set2List()));
                    break;
                case 7:
                    System.out.println("poorest client: "+BankStatistics.getPoorestClient(set2List()));
                    break;
                case 8:
                    System.out.println("bank money: " + BankStatistics.getBankBalance());
                    break;
                case 9:
                    endSystem();
                    break;
                default:
                    System.out.println("invalid input, try again");
            }
        }while(choice!=9);

    }

    private List<Person> set2List(){
        List<Person> people=new ArrayList<>();
        for (Client item:this.clientSet) {
            people.add((Person)item);
        }
        return people;
    }

    @Override
    public void endSystem() {
        System.exit(0);
    }

    @Override
    public void addClient(Client client) {
        this.clientSet.add(client);

    }

    @Override
    public void deleteClient(int id) {
        for (Client client : this.clientSet) {
            if (client.getId() == id) {
                this.clientSet.remove(client);
                Person.totalUsers--;
                break;
            }
        }
    }

    public Client findClient(){
        System.out.println("enter client id to delete");
        int clientId=scanner.nextInt();
        for (Client item:clientSet) {
            if(item.getId()==clientId){
                return item;
            }
        }
        return null;
    }

    @Override
    public void withdraw(double amount) {
        Client myClient=findClient();
        if(myClient==null){
            System.out.println("Client not found");
            return;
        }
        if(myClient.getAccount().getBalance()-amount>=0){
            myClient.getAccount().setBalance(myClient.getAccount().getBalance()-amount);
            Person.totalSum-=amount;
        }else{
            System.out.println("you don't have enough money");
        }


    }

    @Override
    public void deposit(double amount) {
        Client myClient=findClient();
        if(myClient==null){
            System.out.println("Client not found");
            return;
        }
        myClient.getAccount().setBalance(myClient.getAccount().getBalance()+amount);
        Person.totalSum+=amount;

    }

    @Override
    public void printAll() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Client client:this.clientSet) {
            stringBuilder.append(client.toString());
        }
        System.out.println(stringBuilder.toString());
    }
}

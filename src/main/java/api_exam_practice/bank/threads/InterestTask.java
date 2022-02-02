package api_exam_practice.bank.threads;

import api_exam_practice.bank.beans.Client;

import java.util.Set;

public class InterestTask implements Runnable{
    private Set<Client> clients;

    public InterestTask(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void run() {
        System.out.println("System running");
        while(true){
            System.out.println("System is awake");
            for (Client item:this.clients) {
                double clientBalance=item.getAccount().getBalance();
                clientBalance=clientBalance*(1-item.getInterestRate());
                item.getAccount().setBalance(clientBalance);
                System.out.println(item.toString());
            }
            System.out.println("System going to sleep");
            try {
                Thread.sleep(1000*60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package api_exam_practice.birthdays.facades;

import api_exam_practice.birthdays.beans.Person;

import java.util.HashMap;
import java.util.Map;

public class BirthdayStatistics {

    public static int countMembers(){
        return BirthdaySystemReminder.getPeople().size();
    }

    public static int getHappyMonth(){
        Map<Integer,Integer> events =getEvents();
        int month=0,sum=0;
        for(Map.Entry<Integer,Integer> item: events.entrySet()){
            if(item.getValue()>sum){
                sum= item.getValue();
                month= item.getKey();
            }
        }
        return month;
    }

    public static int getSadMonth(){
        Map<Integer,Integer> events =getEvents();
        int month=0,sum=Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> item: events.entrySet()){
            if(item.getValue()<sum){
                sum= item.getValue();
                month= item.getKey();
            }
        }
        return month;
    }

    public static Map<Integer,Integer> getEvents(){
        Map<Integer,Integer> returnMap=new HashMap<>();
        int[] months=new int[12];
        for (Person item:BirthdaySystemReminder.getPeople()) {
            months[item.getBirthday().getMonthValue()-1]++;
        }
        for (int index = 0; index <months.length ; index++) {
            returnMap.put(index+1,months[index]);
        }
        return returnMap;
       }

}

package com.practice.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoOfTransactions {
    public static void main(String[] args){
        System.out.println();

      /* Given String of format person 1, person 2  and transaction between them, find the person who were involved in
      more than one transaction except when they are doing transaction with themselves

        1 2 100
        3 4 200
        5 5 100
        2 6 500
        7 3 100
        1 6 300*/

        List<String> transaction = new ArrayList<>();
        transaction.add("1 2 100");
        transaction.add("3 4 200");
        transaction.add("5 5 100");
        transaction.add("2 6 500");
        transaction.add("7 3 100");
        transaction.add("1 6 300");
        int limit = 2;

        for (Integer i:getCustomers(transaction,limit)
        ) {
            System.out.print(i+",");
        }

    }
    public static List<Integer> getCustomers(List<String> transaction, int limit){
        HashMap<Integer,Integer> map = new HashMap<>();

        for (String s : transaction
        ) {
            String[] str = s.split(" ");
            Integer person1 = Integer.valueOf(str[0]);
            Integer person2 = Integer.valueOf(str[1]);
            if((map.containsKey(person1) || map.containsKey(person2)) || (!person1.equals(person2))){
                if(map.containsKey(person1)){
                    Integer value = map.get(person1);
                    map.put(person1,++value);
                }else{
                    map.put(person1,1);
                }
                if(map.containsKey(person2)){
                    Integer value2 = map.get(person2);
                    map.put(person2,++value2);
                }else{
                    map.put(person2,1);
                }
            }else if((map.containsKey(person1)) && (person1.equals(person2))){
                Integer value = map.get(person1);
                map.put(person1,++value);
            }

        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry: map.entrySet()
        ) {
            if((Integer)entry.getValue()>=limit){
                ans.add((Integer) entry.getKey());
            }
        }

        return ans;
    }
}

package com.practice.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DefenceStrategy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Platoon> myPlatoon = new LinkedList<>();
        List<Platoon> oppPlatoon = new LinkedList<>();
        String[] platoon1 = sc.nextLine().split(",");
        for(String str : platoon1){
            String[] keyVal = str.split("#");
            myPlatoon.add(new Platoon(keyVal[0],Integer.valueOf(keyVal[1])));
        }

        String[] platoon2 = sc.nextLine().split(",");
        for(String str : platoon2){
            String[] keyVal = str.split("#");
            oppPlatoon.add(new Platoon(keyVal[0],Integer.valueOf(keyVal[1])));
        }

        HashMap<String,List> advantage = new HashMap<>();
        advantage.put("Militia", Arrays.asList("Spearmen", "LightCavalry"));
        advantage.put("Spearmen", Arrays.asList("LightCavalry, HeavyCavalry"));
        advantage.put("LightCavalry", Arrays.asList("FootArcher", "CavalryArcher"));
        advantage.put("HeavyCavalry", Arrays.asList("Militia","FootArcher", "LightCavalry"));
        advantage.put("CavalryArcher", Arrays.asList("Spearmen", "HeavyCavalry"));
        advantage.put("FootArcher", Arrays.asList("Militia", "CavalryArcher"));

        System.out.println(getDefenseStrategyToWin(myPlatoon,oppPlatoon,0,0,advantage,3,0,""));

    }

    private static String getDefenseStrategyToWin(List<Platoon> myPlatoon, List<Platoon> oppPlatoon,int myPlatoonPtr, int oppPlatoonPtr, HashMap<String,List> advantage,int totalWinReq, int winsSoFar,String ans) {
        if(winsSoFar==totalWinReq){
            return ans;
        }
        if(true/*canDefeat*/){
            //do something
            ans = ans+myPlatoon.get(0).pName+"#"+myPlatoon.get(0).pStrength;
            myPlatoon.remove(myPlatoonPtr);
            oppPlatoon.remove(oppPlatoonPtr);
            winsSoFar++;
            //recur
            getDefenseStrategyToWin(myPlatoon,oppPlatoon,myPlatoonPtr++,oppPlatoonPtr++,advantage,totalWinReq,winsSoFar,ans);

            //undo
        }

        getDefenseStrategyToWin(myPlatoon,oppPlatoon,myPlatoonPtr++,oppPlatoonPtr,advantage,totalWinReq,winsSoFar,ans);
        return ans;
    }
}

class Platoon{
    String pName;
    Integer pStrength;

    /**
     * We can implement this as an interface and then use abstract factory method design pattern to get object of implementing classes
     *
     * @param pName
     * @param pStrength
     */

    Platoon(String pName,Integer pStrength){
        this.pName = pName;
        this.pStrength=pStrength;
    }
}

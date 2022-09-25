package com.project2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class DBM {
    ArrayList<ArrayList<LinkedList<String>>>  join(ArrayList<LinkedList<String>> a1, ArrayList<LinkedList<String>> a2,int a) {
        ArrayList<ArrayList<LinkedList<String>>> res = new ArrayList<>();
        System.out.println("Select JOIN type: ");
        System.out.println("<1>: Left join");
        System.out.println(("<2>: Right Join"));
        Scanner sc = new Scanner(System.in);
        if (sc.nextInt() == 1) {
            for (int i = 0; i < a1.size(); i++) {
                if (a1.get(i).get(a).equals(a2.get(i).get(a))) {
                    ArrayList temp = new ArrayList();
                    temp.add(a1.get(i));
                    temp.add(a2.get(i));
                    res.add(temp);
                } else {
                    ArrayList temp = new ArrayList();
                    temp.add(a1.get(i));
                    temp.add(null);
                    res.add(temp);
                }
            }
            return res;
        }
        else if(sc.nextInt()==2){
            for (int i = 0; i < a2.size(); i++) {
                if (a2.get(i).get(a).equals(a1.get(i).get(a))) {
                    ArrayList temp = new ArrayList();
                    temp.add(a2.get(i));
                    temp.add(a1.get(i));
                    res.add(temp);
                } else {
                    ArrayList temp = new ArrayList();
                    temp.add(a2.get(i));
                    temp.add(null);
                    res.add(temp);
                }
            }
            return res;
        }
        return res;
    }
}
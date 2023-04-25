/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Chidie17
 */
public class Q5Class {
    private int total = 0;
    private float average = 0;
    private int siz = 0;
    
    //Define methods
    public void processList(ArrayList list){  //Passes in a list of integers and processes the list
        int i = 0;
        int j = 0;  //Counter for positive numbers
        if (list.isEmpty()){
            System.out.println("Error: the list is empty");
        }
        else {
            while (i < list.size()) {  //Calc total of all numbers
                int curNum = (int) list.get(i);  //Get current number

                if (curNum > 0) {
                    addTotal(curNum);
                    j++;
                }
                i++;
            }
            siz = j;
            setAverage();
        }
    }
            
    private void addTotal(int num){  //Adds the num to the total       
        total += num;
    }
    
    public int getTotal(){ //Returns the total
        return total;
    }
    
    private void setAverage(){  //Computes the average
        average = (float)getTotal()/siz;
    }
    
    public float getAverage(){  //Returns the average
        return average;
    }
            
    
    public static void main(String[] args) {
        ArrayList<Integer> listA = new ArrayList<Integer>();  //Instantiate list of integers
        listA.add(34);  //Adding values to list
        listA.add(0);
        listA.add(-2);
        listA.add(3);
        
        Q5Class ob = new Q5Class();  //Create object
        ob.processList(listA);  //Process list to find average
    }
}

package com.group2;

public class Schedule {
    int totalDistance;

    public void printResult(int[] sortedSchedule, int movement){

        for(int i = 0; i < sortedSchedule.length ; i++)
            System.out.print(sortedSchedule[i] + " ");
        System.out.println("");
        System.out.println("Total Head Movement Distance: " + movement);
    }
}

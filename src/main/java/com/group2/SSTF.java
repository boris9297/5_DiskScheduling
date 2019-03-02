package com.group2;

import java.util.HashSet;

public class SSTF extends Schedule {
    Disk disk;
    HashSet visited;

    public SSTF (Disk disk) {
        this.disk = disk;
        visited = new HashSet();
    }

    public void run() {
        int size = disk.request_array.length;
        int[] scheduled = new int[size];
        int curCylinder = disk.startPos; // 2255
        int curIndex = -1;
        totalDistance = 0;
        for (int i = 0; i < size; i++) {

            int nxtIndex = findClosestIndex(curCylinder);
            scheduled[i] = disk.request_array[nxtIndex];
            totalDistance += Math.abs(disk.request_array[nxtIndex] - curCylinder);

            // update states
            curIndex = nxtIndex;
            curCylinder = disk.request_array[curIndex];
        }


        //double check the distance
//        int totalCheck = Math.abs(disk.startPos - scheduled[0]);
//        for (int i = 1; i < size; i++) {
//            totalCheck += Math.abs(scheduled[i] - scheduled[i-1]);
//        }
//        assert (totalDistance == totalCheck);

        printResult(scheduled, totalDistance);
    }


    private int findClosestIndex(int curCylinder) {
        int rtnIndex = 0;
        int minDistance = 100000;

        for (int i = 0; i < disk.request_array.length; i++) {
            int curr = disk.request_array[i];
            if (!visited.contains(i) && Math.abs(curr - curCylinder) < minDistance) {
                minDistance = Math.abs(curr - curCylinder);
                rtnIndex = i;
            }
        }

        visited.add(rtnIndex);
        return rtnIndex;
    }

}

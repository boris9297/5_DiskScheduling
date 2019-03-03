package com.group2;

/*
SSTF: Shortest Seek Time First disk-scheduling algorithm
 */

import java.util.HashSet;

public class SSTF {
    Disk disk;
    Schedule schedule;
    HashSet visited;

    public SSTF() {
        disk = new Disk();
        schedule = new Schedule();
        visited = new HashSet();
    }

    public void run() {
        int size = disk.request_array.length;
        int[] scheduled = new int[size];
        int curCylinder = disk.startPos; // 2255
        int curIndex = -1;
        int totalDistance = 0;
        for (int i = 0; i < size; i++) {
            int nextIndex = findClosestIndex(curCylinder);
            scheduled[i] = disk.request_array[nextIndex];
            totalDistance += Math.abs(disk.request_array[nextIndex] - curCylinder);

            //Update states
            curIndex = nextIndex;
            curCylinder = disk.request_array[curIndex];
        }
        schedule.printResult(scheduled, totalDistance);
    }

    private int findClosestIndex(int curCylinder) {
        int rtnIndex = 0;
        int minDistance = Integer.MAX_VALUE;
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

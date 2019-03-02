package com.group2;

import java.util.Arrays;

public class LOOK extends Schedule {

    Disk disk;

    public LOOK (Disk disk) {
        this.disk = disk;
    }
    public void run() {
        int pre = disk.startPos;
        int[] tempSchedule = disk.request_array;
        Arrays.sort(tempSchedule);
        int[] sortSchedule = new int[disk.request_array.length];
        totalDistance = 0;
//        if (disk.up) {
            int startId = 0;
            for (int i = 0; i < tempSchedule.length; i ++) {
                int current = tempSchedule[i];
                if (disk.startPos < current) {
                    sortSchedule[startId] = current;
                    startId++;
                    totalDistance += Math.abs(current - pre);
                    pre = current;

                }
            }

            for (int i = tempSchedule.length - 1; 0 <= i ; i --) {
                int current = tempSchedule[i];
                if (current < disk.startPos) {
                    sortSchedule[startId] = current;
                    startId++;
                    totalDistance += Math.abs(current - pre);
                    pre = current;

                }
            }
//        }

        printResult(sortSchedule, totalDistance);
    }
}

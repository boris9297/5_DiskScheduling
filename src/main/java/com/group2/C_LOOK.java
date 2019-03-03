package com.group2;

/*
C-LOOK: similar to LOOK but serves in only one direction disk-scheduling algorithm
 */

import java.util.Arrays;

public class C_LOOK {
    Disk disk;
    Schedule schedule;

    public C_LOOK() {
        disk = new Disk();
        schedule = new Schedule();
    }
    public void run() {
        int pre = disk.startPos;
        int[] tempSchedule = disk.request_array;
        Arrays.sort(tempSchedule);
        int[] scheduled = new int[disk.request_array.length];
        int  totalDistance = 0;
        if (disk.up) {
            int startIdx = 0;
            for (int i = 0; i < tempSchedule.length; i++) {
                int current = tempSchedule[i];
                if (disk.startPos < current) {
                    scheduled[startIdx] = current;
                    startIdx++;
                    totalDistance += Math.abs(current - pre);
                    pre = current;
                }
            }
            for (int i = 0; i < tempSchedule.length; i++) {
                int current = tempSchedule[i];
                if (current < disk.startPos) {
                    scheduled[startIdx] = current;
                    startIdx++;
                    totalDistance += Math.abs(current - pre);
                    pre = current;
                }
            }
        } else {
            int startIdx = 0;
            for (int i = 0; i < tempSchedule.length; i++) {
                int current = tempSchedule[i];
                if (current < disk.startPos) {
                    scheduled[startIdx] = current;
                    startIdx++;
                    totalDistance += Math.abs(current - pre);
                    pre = current;
                }
            }
            for (int i = 0; i < tempSchedule.length; i++) {
                int current = tempSchedule[i];
                if (disk.startPos < current) {
                    scheduled[startIdx] = current;
                    startIdx++;
                    totalDistance += Math.abs(current - pre);
                    pre = current;
                }
            }
        }
        schedule.printResult(scheduled, totalDistance);
    }
}

package com.group2;

/*
C-SCAN: similar to SCAN but serves in only one direction disk-scheduling algorithm
 */

import java.util.Arrays;

public class C_SCAN {
    Disk disk;
    Schedule schedule;

    public C_SCAN() {
        disk = new Disk();
        schedule = new Schedule();
    }
    public void run() {
        int pre = disk.startPos;
        int[] tempSchedule = new int[disk.request_array.length + 2];
        for (int i = 0; i < disk.request_array.length; i++) {
            tempSchedule[i] = disk.request_array[i];
        }
        tempSchedule[disk.request_array.length] = 0;
        tempSchedule[disk.request_array.length + 1] = 4999;
        Arrays.sort(tempSchedule);

        int[] scheduled = new int[disk.request_array.length + 2];
        int totalDistance = 0;
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

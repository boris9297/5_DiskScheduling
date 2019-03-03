package com.group2;

/*
LOOK: similar to SCAN but reverses when no more request in current direction disk-scheduling algorithm
 */

import java.util.Arrays;

public class LOOK {
    Disk disk;
    Schedule schedule;

    public LOOK() {
        disk = new Disk();
        schedule = new Schedule();
    }

    public void run() {
        int pre = disk.startPos;
        int[] tempSchedule = disk.request_array;
        Arrays.sort(tempSchedule);
        int[] scheduled = new int[disk.request_array.length];
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
            for (int i = tempSchedule.length - 1; i >= 0; i--) {
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
            for (int i = tempSchedule.length - 1; i >= 0; i--) {
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

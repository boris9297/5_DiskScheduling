package com.group2;

/*
FCFS: First Come First Serve disk-scheduling algorithm
 */

public class FCFS {
    Disk disk;
    Schedule schedule;

    public FCFS() {
        disk = new Disk();
        schedule = new Schedule();
    }

    public void run() {
        int pre = disk.startPos;
        int[] scheduled = new int[disk.request_array.length];
        int totalDistance = 0;
        for (int i = 0; i < disk.request_array.length; i ++) {
            int current = disk.request_array[i];
            totalDistance += Math.abs(current - pre);
            pre = current;
            scheduled[i] = current;
        }
        schedule.printResult(scheduled, totalDistance);
    }
}

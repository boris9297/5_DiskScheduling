package com.group2;

public class LOOK extends Schedule {

    Disk disk;

    public LOOK (Disk disk) {
        this.disk = disk;
    }
    public void run() {
        int pre = disk.startPos;
        int[] sortSchedule = new int[disk.request_array.length];

        for (int i = 0; i < disk.request_array.length; i ++) {
            int current = disk.request_array[i];
            totalDistance += Math.abs(current - pre);
            pre = current;
            sortSchedule[i] = current;
        }

        printResult(sortSchedule, totalDistance);
    }
}

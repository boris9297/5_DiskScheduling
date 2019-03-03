package com.group2;

public class Main {
    public static void main(String[] args) {
        Disk disk = new Disk();
        System.out.println("===============================================================================");
        System.out.println("************************************");
        System.out.print("We have following default values:\ncylinder size: " + disk.size +
                "\ncurrent position: " + disk.startPos + "\nprevious position: " + disk.previousPos + "\nrequest array:");
        for (int i = 0; i < disk.request_array.length; i++) {
            System.out.print(disk.request_array[i]);
            if (i != disk.request_array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("************************************");
        for (int i = 0; i < 6; i++) {
            //Run differenct disk-scheduling algorithms seperately
            System.out.println("===============================================================================");
            select_algorithms(i);
        }
        System.out.println("===============================================================================");
    }
    private static void select_algorithms(int algorithm_num) {
        switch (algorithm_num) {
            case 0:
                System.out.println("First Come First Serve:");
                FCFS fcfs = new FCFS();
                fcfs.run();
                break;
            case 1:
                System.out.println("Shortest Seek Time First:");
                SSTF sstf = new SSTF();
                sstf.run();
                break;
            case 2:
                System.out.println("SCAN: server in both directions and always starts at two edges:");
                SCAN scan = new SCAN();
                scan.run();
                break;
            case 3:
                System.out.println("LOOK: similar to SCAN but reverses when no more request in current direction:");
                LOOK look = new LOOK();
                look.run();
                break;
            case 4:
                System.out.println("C-SCAN: similar to SCAN but serves in only one direction:");
                C_SCAN c_scan = new C_SCAN();
                c_scan.run();
                break;
            case 5:
                System.out.println("C-LOOK: similar to LOOK but serves in only one direction:");
                C_LOOK c_look = new C_LOOK();
                c_look.run();
                break;
        }
    }
}


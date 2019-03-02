package com.group2;

public class Main {
    private final static int cylinder_size = 5000;
    private final static int num_request = 10;
    private final static int current_pos = 2255;
    private final static int[] request_array = {2055, 1175, 2304, 2700, 513, 1680, 256, 1401, 4922, 3692};

    public static void main(String[] args) {
        System.out.println("************************************" + "\nWe have default value of:\ncylinder size: 5000" +
                "\ncurrent position: 2255\nnext request array: 2055, 1175, 2304, 2700, 513, 1680, 256, 1401, 4922, " +
                "3692\n************************************");
        for (int i = 0; i < 6; i++) {
            System.out.println("=================================================================");
            select_algorithms(new Disk(), i);
        }

        System.out.println("=================================================================");
    }
    private static void select_algorithms(Disk disk, int algorithm_num) {

        switch (algorithm_num) {
            case 0:
                System.out.println("First Come First Serve:");
                FCFS fcfs = new FCFS(disk);
                fcfs.run();
                break;
            case 1:
                System.out.println("Shortest Seek Time First:");
//                SSTF sstf = new SSTF(disk);
//                sstf.run();
                break;
            case 2:
                System.out.println("SCAN: Elevator Algorithm:");
                SCAN scan = new SCAN(disk);
                scan.run();
                break;
            case 3:
                System.out.println("LOOK:");
                LOOK look = new LOOK(disk);
                look.run();
                break;
            case 4:
                System.out.println("CSCAN: Similar to SCAN but severing in one direction only:");
                C_SCAN c_scan = new C_SCAN(disk);
                c_scan.run();
                break;
            case 5:
                System.out.println("C-LOOK:");
                C_LOOK c_look = new C_LOOK(disk);
                c_look.run();
                break;
        }
    }
    // create new object Disk
//    private static Disk copyDisk(Disk disk) {
//        Disk newDisk = new Disk();
//        newDisk.size = disk.cylinder;
//        newDisk.startPos = disk.startPos;
//        newDisk.numberOfRequest = disk.numberOfRequest;
//        newDisk.request = new int[disk.request.length];
//        for (int i = 0; i < disk.request.length; i++) {
//            newDisk.request[i] = disk.request[i];
//        }
//
//        return newDisk;
//    }



}


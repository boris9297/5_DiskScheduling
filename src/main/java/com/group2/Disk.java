package com.group2;

/*
Customize the Disk class which represents the initialized state of Disk including the total cylinder size, start position,
previous position and request array. Also, use start position and previous position to determine the current moving direction
 */

class Disk {
    final int size;
    final int startPos;
    final int previousPos;
    final int[] request_array;
    final boolean up;

    public Disk(){
        size = 5000;
        startPos = 2255;
        previousPos = 1723;
        request_array = new int[]{2055, 1175, 2304, 2700, 513, 1680, 256, 1401, 4922, 3692};
        up = (0 < startPos - previousPos)? true: false;
    }
}
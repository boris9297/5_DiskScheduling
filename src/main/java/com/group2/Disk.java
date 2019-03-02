package com.group2;

class Disk {

    final int size = 5000;
    final int startPos = 2255;
    final int previousPos = 1723;
    final int[] request_array = {2055, 1175, 2304, 2700, 513, 1680, 256, 1401, 4922, 3692};
    final boolean up = (0 < startPos - previousPos)? true: false ;

    public Disk(){

    }
//
//    /**
//     * Initialize all variables
//     * @param size Cylinder size
//     * @param position Current header position
//     * @param numOfReq Number of requests
//     * @param request_array All requests
//     */
//    public Disk(int size, int position,int numOfReq,int[] request_array) {
//        this.size = size;
//        startPos = position;
//        numberOfRequest = numOfReq;
//        request = new int[numOfReq];
//        request = request_array;
//    }
}
//package com.kodilla.snake;
//
//import java.util.ArrayList;
//
//public class SnakeClass {
//
//    ArrayList<Block> blocks = new ArrayList<Block>();
//
//    Block head;
//
//    public SnakeClass(int initialLength, Field f){
//        int initialPosX = (int) (f.getWidth() / 2);
//        int initialPosY = (int) (f.getHeight() / 2);
//
//        head= new Block(initialPosX, initialPosY, null);
//
//        Block previous = head;
//
//        for(int i=1; i< initialLength; i++){
//            Block b= new Block(initialPosX + i, initialPosY, previous);
//            blocks.add(b);
//            previous = b;
//        }
//
//    }
//}

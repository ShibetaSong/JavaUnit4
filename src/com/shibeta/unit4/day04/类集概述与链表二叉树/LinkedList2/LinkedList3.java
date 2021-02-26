//package com.shibeta.unit4.day04.类集概述与链表二叉树.LinkedList2;
//
///**
// * @author Shibeta
// */
//public class LinkedList3 {
//
//        private Object data;
//        private LinkedList3 n;
//        protected int thisLocation = 0;
//        protected static int location = 0;
//
//        LinkedList3() {
//            System.out.println("元素已添加！");
//            thisLocation = location;
//            location ++;
//        }
//
//        public <T> void add(T data) {
//            if (this.data == null) {
//                this.data = data;
//            } else {
//                if (n == null) {
//                    n = new LinkedList3();
//                }
//                n.add(data);
//            }
//        }
//
//        public String get() {
//            return data.toString();
//        }
//
//        public String get(int location) {
//
//            if (thisLocation < location) {
//                if (this.n != null) {
//                    return n.get(location);
//                } else {
//                    throw new RuntimeException("位置有误！");
//                }
//            }
//            return this.data.toString();
//        }
//
//        public int getNum() {
//            if (this.n == null) {
//                return 1;
//            } else {
//                return n.getNum() + 1;
//            }
//        }
//
//
//    }
//

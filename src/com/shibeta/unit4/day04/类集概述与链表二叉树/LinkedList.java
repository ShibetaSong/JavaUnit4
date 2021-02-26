package com.shibeta.unit4.day04.类集概述与链表二叉树;

/**
 * @author : Shibeta
 */
public class LinkedList {
    public static void main(String[] args) {
        Node n = new Node();
        n.setData(100);
        n.setData(98);
        n.setData(102);
        n.setData(99);
        n.setData(140);
        n.setData(103);
        n.setData(93);
        n.setData(96);
        System.out.println(n.getData());
        System.out.println(n.getData("first"));
        n.clear();
        System.out.println(n.getData("center"));
        n.clear();
        System.out.println(n.getData("last"));
        n.clear();
    }
}

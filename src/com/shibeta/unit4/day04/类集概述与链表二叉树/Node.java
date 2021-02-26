package com.shibeta.unit4.day04.类集概述与链表二叉树;

/**
 * 二叉树数据结构
 * @author Shibeta
 *
 * data: 整型，数据
 * left: 二叉树左分支
 * right: 二叉树右分支
 */
public class Node {
    int data = -1;
    Node left;
    Node right;
    static StringBuilder results = new StringBuilder();

    /**
     *
     * @param data - 存储的数据
     */
    public void setData(int data) {
        if (data < 0) {
            throw new RuntimeException("数据必须大于0！");
        }

        // 若数据等于-1，表示数据未曾被写入，即当前为二叉树根
        if (this.data == -1) {
            this.data = data;
        } else {
            // 若数据大于树根数据，则存储于右侧分支
            if (this.data < data) {
                // 若无右分支结构，则创建
                if (this.right == null) {
                    this.right = new Node();
                }
                right.setData(data);
            } else {
                // 若数据小于树根数据，则存储与左侧分支
                if (this.left == null) {
                    this.left = new Node();
                }
                left.setData(data);
            }
        }
    }

    /**
     *  无参getData方法，返回树根数据
     */
    public int getData() {
        if (this.data == -1) {
            throw new RuntimeException("数据为空");
        }
        return this.data;
    }

    /**
     * 有参getData方法， 通过不同方式遍历二叉树
     * @param side - 遍历方式类型;
     *             first: 先序遍历;
     *             center: 中序遍历;
     *             last: 后序遍历;
     *
     * @return - 返回 StringBuilder型遍历结果
     */
    public StringBuilder getData(String side) {
        String first = "first";
        String center = "center";
        String last = "last";

        if (side.equals(first)) {
            /*
            *   先序遍历
            *       先访问根节点，然后访问左节点，最后访问右节点
            * */
            results.append(this.data);
            results.append(" ");
            if (this.left != null || this.right != null) {
                // 依次访问左节点分支和右节点分支
                if (this.left != null) {
                    this.left.getData(first);
                }
                if (this.right != null) {
                    this.right.getData(first);
                }
            }

        } else if (side.equals(center)) {
            /*
            *   中序遍历
            *       先访问左节点，然后访问根节点，最后访问右节点
            * */
            if (this.left != null || this.right != null) {
                if (this.left != null) {
                    // 访问左节点
                    this.left.getData(center);
                    // 添加根节点
                    results.append(this.data);
                    results.append(" ");
                }

                if (this.right != null) {
                    // 若左节点为空，右节点不为空，该节点即为根节点
                    if (this.left == null) {
                        results.append(this.data);
                        results.append(" ");
                    }
                    // 访问右节点
                    this.right.getData(center);
                }
            } else {
                // 若无左右节点，则仅添加根节点
                results.append(this.data);
                results.append(" ");
            }

        } else if (side.equals(last)) {
            /*
             *   后序遍历
             *       先访问左节点，然后访问右节点，最后访问根节点
             * */
            if (this.left != null || this.right != null) {
                // 访问左节点
                if (this.left != null) {
                    this.left.getData(last);
                }
                // 访问右节点
                if (this.right != null) {
                    this.right.getData(last);
                }
            }
            // 访问根节点
            results.append(this.data);
            results.append(" ");
        } else {
            throw new RuntimeException("访问格式有误");
        }

        return results;
    }

    /**
     * 清除上次的遍历结果，
     * 每次遍历后都应调用
     */
    public void clear() {
        results.replace(0,results.length()+1, "");
    }

}

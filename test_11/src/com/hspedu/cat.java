package com.hspedu;

public class cat {
    public  int b = 2;
    protected int c = 3;
    int d = 4;
    private int e = 5;

    public cat() {
    }

    public cat(int b, int c, int d, int e) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    private void add(){
        System.out.printf("b + c=" +d);
    }

    public int getB() {
        return b;
    }

    /**
     * 设置
     * @param b
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * 获取
     * @return c
     */
    public int getC() {
        return c;
    }

    /**
     * 设置
     * @param c
     */
    public void setC(int c) {
        this.c = c;
    }

    /**
     * 获取
     * @return d
     */
    public int getD() {
        return d;
    }

    /**
     * 设置
     * @param d
     */
    public void setD(int d) {
        this.d = d;
    }

    /**
     * 获取
     * @return e
     */
    public int getE() {
        return e;
    }

    /**
     * 设置
     * @param e
     */
    public void setE(int e) {
        this.e = e;
    }

    public String toString() {
        return "cat{b = " + b + ", c = " + c + ", d = " + d + ", e = " + e + "}";
    }
}

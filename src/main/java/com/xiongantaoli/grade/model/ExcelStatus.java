package com.xiongantaoli.grade.model;

/**
 * @Author： LZL
 * @Date： 2019/1/17
 * @Description： This is a class
 */
public class ExcelStatus {
    private int line;
    private int col;


    public ExcelStatus() {
    }

    public ExcelStatus(int line, int col) {
        this.line = line;
        this.col = col;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}

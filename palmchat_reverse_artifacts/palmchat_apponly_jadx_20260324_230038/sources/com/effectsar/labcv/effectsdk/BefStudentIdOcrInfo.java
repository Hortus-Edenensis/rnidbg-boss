package com.effectsar.labcv.effectsdk;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BefStudentIdOcrInfo {
    private int height;
    private int length = 0;
    private byte[] result;
    private int width;
    private int x;
    private int y;

    public int getHeight() {
        return this.height;
    }

    public int getLength() {
        return this.length;
    }

    public byte[] getResult() {
        return this.result;
    }

    public int getWidth() {
        return this.width;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String toString() {
        return "BefStudentIdOcrInfo{width=" + this.width + ", height=" + this.height + ", x=" + this.x + ", y=" + this.y + ", length=" + this.length + ", result=" + Arrays.toString(this.result) + '}';
    }
}

package com.zenmen.palmchat.widget;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ShadowProperty implements Serializable {
    public static final int ALL = 4369;
    public static final int BOTTOM = 4096;
    public static final int LEFT = 1;
    public static final int RIGHT = 256;
    public static final int TOP = 16;
    private int shadowColor;
    private int shadowDx;
    private int shadowDy;
    private int shadowRadius;
    private int shadowSide = ALL;

    public int getShadowColor() {
        return this.shadowColor;
    }

    public int getShadowDx() {
        return this.shadowDx;
    }

    public int getShadowDy() {
        return this.shadowDy;
    }

    public int getShadowOffset() {
        return getShadowOffsetHalf() * 2;
    }

    public int getShadowOffsetHalf() {
        if (this.shadowRadius <= 0) {
            return 0;
        }
        return Math.max(this.shadowDx, this.shadowDy) + this.shadowRadius;
    }

    public int getShadowRadius() {
        return this.shadowRadius;
    }

    public int getShadowSide() {
        return this.shadowSide;
    }

    public ShadowProperty setShadowColor(int i) {
        this.shadowColor = i;
        return this;
    }

    public ShadowProperty setShadowDx(int i) {
        this.shadowDx = i;
        return this;
    }

    public ShadowProperty setShadowDy(int i) {
        this.shadowDy = i;
        return this;
    }

    public ShadowProperty setShadowRadius(int i) {
        this.shadowRadius = i;
        return this;
    }

    public ShadowProperty setShadowSide(int i) {
        this.shadowSide = i;
        return this;
    }
}

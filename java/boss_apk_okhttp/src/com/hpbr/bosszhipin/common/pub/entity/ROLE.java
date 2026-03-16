package com.hpbr.bosszhipin.common.pub.entity;

public final class ROLE {
    private final int value;

    private ROLE(int value) {
        this.value = value;
    }

    public static ROLE of(int value) {
        return new ROLE(value);
    }

    public int get() {
        return this.value;
    }
}

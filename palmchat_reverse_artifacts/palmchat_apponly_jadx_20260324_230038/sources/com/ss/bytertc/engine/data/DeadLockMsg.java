package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DeadLockMsg {
    public int lastingTimes;
    public String threadName;

    @CalledByNative
    public DeadLockMsg(String str, int i) {
        this.threadName = str;
        this.lastingTimes = i;
    }

    public String toString() {
        return "DeadLockMsg{threadName:" + this.threadName + "lastingTimes:" + this.lastingTimes + "}";
    }
}

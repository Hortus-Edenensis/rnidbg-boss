package com.bytedance.u.nr;

import com.uc.crashsdk.export.LogType;
import com.zenmen.palmchat.maintab.config.TurnInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public enum fx {
    LAUNCH("launch"),
    JAVA(LogType.JAVA_TYPE),
    NATIVE(TurnInfo.TYPE_NATIVE),
    ANR(LogType.ANR_TYPE),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL("all");

    private String jk;

    fx(String str) {
        this.jk = str;
    }

    public String u() {
        return this.jk;
    }
}

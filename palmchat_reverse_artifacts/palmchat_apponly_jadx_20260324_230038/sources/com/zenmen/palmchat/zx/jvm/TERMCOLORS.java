package com.zenmen.palmchat.zx.jvm;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/zenmen/palmchat/zx/jvm/TERMCOLORS;", "", "color", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getColor", "()Ljava/lang/String;", "RESET", "BLACK", "RED", "RED_BOLD", "GREEN", "YELLOW", "BLUE", "PURPLE", "CYAN", "WHITE", "zx-jvm"}, k = 1, mv = {1, 1, 16})
public enum TERMCOLORS {
    RESET("\u001b[0m"),
    BLACK("\u001b[30m"),
    RED("\u001b[31m"),
    RED_BOLD("\u001b[1;31m"),
    GREEN("\u001b[32m"),
    YELLOW("\u001b[33m"),
    BLUE("\u001b[34m"),
    PURPLE("\u001b[35m"),
    CYAN("\u001b[36m"),
    WHITE("\u001b[37m");

    private final String color;

    TERMCOLORS(String str) {
        this.color = str;
    }

    public final String getColor() {
        return this.color;
    }
}

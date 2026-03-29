package com.zenmen.palmchat.zx.compat;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"com/zenmen/palmchat/zx/compat/Keyboard$SHOW_FLAG", "", "Lcom/zenmen/palmchat/zx/compat/Keyboard$SHOW_FLAG;", "", "flag", "I", "getFlag", "()I", "<init>", "(Ljava/lang/String;II)V", "DEFAULT", "IMPLICIT", "FORCE", "zx-compat_release"}, k = 1, mv = {1, 4, 0})
public enum Keyboard$SHOW_FLAG {
    DEFAULT(0),
    IMPLICIT(1),
    FORCE(2);

    private final int flag;

    Keyboard$SHOW_FLAG(int i) {
        this.flag = i;
    }

    public final int getFlag() {
        return this.flag;
    }
}

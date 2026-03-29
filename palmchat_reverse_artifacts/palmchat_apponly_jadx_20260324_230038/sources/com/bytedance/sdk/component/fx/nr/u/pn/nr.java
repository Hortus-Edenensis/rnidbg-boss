package com.bytedance.sdk.component.fx.nr.u.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public enum nr {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);

    public final int x;

    nr(int i) {
        this.x = i;
    }

    public static nr u(int i) {
        try {
            for (nr nrVar : values()) {
                if (nrVar.x == i) {
                    return nrVar;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}

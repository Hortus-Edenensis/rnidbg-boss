package com.huawei.hms.ads;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class fq {
    private static final String Code = "fq";

    public static fp Code(int i, lt ltVar) {
        fh.V(Code, "create ad mediator: %s", Integer.valueOf(i));
        return (i == 2 || i == 3) ? new fs(ltVar) : new fr(ltVar);
    }
}

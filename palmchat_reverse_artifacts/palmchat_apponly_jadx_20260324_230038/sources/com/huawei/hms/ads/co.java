package com.huawei.hms.ads;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class co {
    private static volatile cz Code;
    private static final byte[] V = new byte[0];

    public static cz Code(Context context) {
        if (Code == null) {
            synchronized (V) {
                if (Code == null) {
                    Code = cn.Z(context) ? cu.Code(context) : cw.Code(context);
                }
            }
        }
        return Code;
    }
}

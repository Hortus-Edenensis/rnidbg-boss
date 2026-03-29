package com.bytedance.sdk.openadsdk.core.k.u;

import j$.util.DesugarTimeZone;
import java.util.Calendar;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static boolean fx() {
        int i = Calendar.getInstance().get(11);
        return i >= 6 && i < 18;
    }

    public static boolean nr() {
        return Calendar.getInstance().get(11) >= 18;
    }

    public static boolean u() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(DesugarTimeZone.getTimeZone("Asia/Shanghai"));
        int i = calendar.get(7);
        return i == 1 || i == 7;
    }
}

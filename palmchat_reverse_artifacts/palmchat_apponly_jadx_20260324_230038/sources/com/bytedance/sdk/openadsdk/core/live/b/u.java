package com.bytedance.sdk.openadsdk.core.live.b;

import com.bytedance.sdk.openadsdk.core.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public final List<String> nr = new ArrayList();
    public final String u;

    public u(String str) {
        this.u = str;
    }

    public static void u(String str, String str2) {
        u uVar = (u) c.u(str, u.class);
        if (uVar != null) {
            uVar.u(str2);
            return;
        }
        u uVar2 = new u(str);
        uVar2.u(str2);
        c.u(str, uVar2, u.class);
    }

    public void u(String str) {
        this.nr.add(str);
    }
}

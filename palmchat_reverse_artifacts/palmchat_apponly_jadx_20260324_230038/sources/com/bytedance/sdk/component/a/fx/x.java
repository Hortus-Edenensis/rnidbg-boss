package com.bytedance.sdk.component.a.fx;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private static HashMap<Integer, u> fx;
    private static HashMap<Integer, pn> nr;
    private static volatile x u;

    private x() {
        nr = new HashMap<>();
        fx = new HashMap<>();
    }

    public static synchronized x u() {
        if (u == null) {
            synchronized (x.class) {
                if (u == null) {
                    u = new x();
                }
            }
        }
        return u;
    }

    public pn u(int i) {
        pn pnVar = nr.get(Integer.valueOf(i));
        if (pnVar != null) {
            return pnVar;
        }
        pn pnVar2 = new pn(i);
        nr.put(Integer.valueOf(i), pnVar2);
        return pnVar2;
    }

    public u u(int i, Context context) {
        u uVar = fx.get(Integer.valueOf(i));
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(context, i);
        fx.put(Integer.valueOf(i), uVar2);
        return uVar2;
    }
}

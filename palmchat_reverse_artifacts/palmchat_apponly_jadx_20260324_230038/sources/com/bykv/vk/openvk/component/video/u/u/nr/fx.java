package com.bykv.vk.openvk.component.video.u.u.nr;

import android.content.Context;
import android.os.Build;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.pn.u;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx {
    public static final ConcurrentHashMap<String, nr> u = new ConcurrentHashMap<>();

    public static synchronized void u(Context context, iz izVar, u.InterfaceC0155u interfaceC0155u) {
        if (izVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            ConcurrentHashMap<String, nr> concurrentHashMap = u;
            nr nrVar = concurrentHashMap.get(izVar.o());
            if (nrVar == null) {
                nrVar = new nr(context, izVar);
                concurrentHashMap.put(izVar.o(), nrVar);
                izVar.iz();
                izVar.o();
            }
            nrVar.u(interfaceC0155u);
        }
        izVar.iz();
        izVar.o();
    }

    public static synchronized void u(iz izVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            nr nrVarRemove = u.remove(izVar.o());
            if (nrVarRemove != null) {
                nrVarRemove.u(true);
            }
            izVar.iz();
            izVar.o();
        }
    }
}

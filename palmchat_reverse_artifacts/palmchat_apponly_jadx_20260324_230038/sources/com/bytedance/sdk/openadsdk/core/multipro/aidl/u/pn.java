package com.bytedance.sdk.openadsdk.core.multipro.aidl.u;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.mv;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends u {
    private static volatile pn nr;
    private static Map<String, RemoteCallbackList<mv>> u = DesugarCollections.synchronizedMap(new HashMap());

    private synchronized void fx(String str, String str2) {
        try {
            if (u != null) {
                RemoteCallbackList<mv> remoteCallbackListRemove = "recycleRes".equals(str2) ? u.remove(str) : u.get(str);
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            mv mvVar = (mv) remoteCallbackListRemove.getBroadcastItem(i);
                            if (mvVar != null) {
                                if ("onAdShow".equals(str2)) {
                                    mvVar.nr();
                                } else if ("onAdClose".equals(str2)) {
                                    mvVar.b();
                                } else if ("onVideoComplete".equals(str2)) {
                                    mvVar.pn();
                                } else if ("onSkippedVideo".equals(str2)) {
                                    mvVar.iz();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    mvVar.fx();
                                } else if ("recycleRes".equals(str2)) {
                                    mvVar.u();
                                }
                            }
                        } catch (Throwable th) {
                            k.u("MultiProcess", "fullScreen2 method " + str2 + " throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            k.u("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th2);
        }
    }

    public static pn nr() {
        if (nr == null) {
            synchronized (pn.class) {
                if (nr == null) {
                    nr = new pn();
                }
            }
        }
        return nr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public synchronized void u(String str, mv mvVar) throws RemoteException {
        RemoteCallbackList<mv> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(mvVar);
        u.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public void u(String str, String str2) throws RemoteException {
        fx(str, str2);
    }
}

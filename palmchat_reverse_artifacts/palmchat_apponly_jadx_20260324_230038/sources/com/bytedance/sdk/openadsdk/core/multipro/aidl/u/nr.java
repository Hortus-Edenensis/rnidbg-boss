package com.bytedance.sdk.openadsdk.core.multipro.aidl.u;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.o;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends u {
    private static volatile nr nr;
    private static Map<String, RemoteCallbackList<o>> u = DesugarCollections.synchronizedMap(new HashMap());

    public static nr nr() {
        if (nr == null) {
            synchronized (nr.class) {
                if (nr == null) {
                    nr = new nr();
                }
            }
        }
        return nr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public void u(String str, o oVar) throws RemoteException {
        RemoteCallbackList<o> remoteCallbackList = u.get(str);
        if (remoteCallbackList == null) {
            remoteCallbackList = new RemoteCallbackList<>();
        }
        remoteCallbackList.register(oVar);
        u.put(str, remoteCallbackList);
        k.nr("DMLibManager", "aidl registerTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        k.nr("DMLibManager", "aidl registerTTAppDownloadListener, mListenerMap size:" + u.size());
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public void nr(String str, o oVar) throws RemoteException {
        Map<String, RemoteCallbackList<o>> map = u;
        if (map == null) {
            k.nr("DMLibManager", "aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        RemoteCallbackList<o> remoteCallbackListRemove = map.remove(str);
        if (remoteCallbackListRemove == null) {
            k.nr("DMLibManager", "aidl unregisterTTAppDownloadListener cbs = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        u(remoteCallbackListRemove);
        k.nr("DMLibManager", "aidl unregisterTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        k.nr("DMLibManager", "aidl unregisterTTAppDownloadListener, mListenerMap size:" + u.size());
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public void u(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
        nr(str, str2, j, j2, str3, str4);
    }

    private void u(RemoteCallbackList<o> remoteCallbackList) {
        if (remoteCallbackList != null) {
            try {
                int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        o oVar = (o) remoteCallbackList.getBroadcastItem(i);
                        if (oVar != null) {
                            ((com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.iz) oVar).fx();
                        }
                    } catch (Throwable th) {
                        k.u("MultiProcess", "recycleRes1 throw Exception : ", th);
                    }
                }
                remoteCallbackList.finishBroadcast();
                remoteCallbackList.kill();
            } catch (Throwable th2) {
                k.u("MultiProcess", "recycleRes2 throw Exception : ", th2);
            }
        }
    }

    private synchronized void nr(String str, String str2, long j, long j2, String str3, String str4) {
        try {
            if (u == null) {
                return;
            }
            if ("recycleRes".equals(str2)) {
                u(u.remove(str));
                k.nr("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:".concat(String.valueOf(str)));
                k.nr("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:" + u.size());
                return;
            }
            RemoteCallbackList<o> remoteCallbackList = u.get(str);
            if (remoteCallbackList != null) {
                int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        o oVar = (o) remoteCallbackList.getBroadcastItem(i);
                        if (oVar != null) {
                            if ("onIdle".equals(str2)) {
                                oVar.u();
                            } else if ("onDownloadActive".equals(str2)) {
                                oVar.u(j, j2, str3, str4);
                            } else if ("onDownloadPaused".equals(str2)) {
                                oVar.nr(j, j2, str3, str4);
                            } else if ("onDownloadFailed".equals(str2)) {
                                oVar.fx(j, j2, str3, str4);
                            } else if ("onDownloadFinished".equals(str2)) {
                                try {
                                    oVar.u(j, str3, str4);
                                } catch (Throwable th) {
                                    th = th;
                                    k.u("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                                }
                            } else if ("onInstalled".equals(str2)) {
                                oVar.u(str3, str4);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                remoteCallbackList.finishBroadcast();
            }
        } catch (Throwable th3) {
            k.u("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess2: " + str2 + " throws Exception :", th3);
        }
    }
}

package com.bytedance.sdk.openadsdk.core.multipro.aidl.u;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.l;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends u {
    private static volatile b nr;
    private static HashMap<String, RemoteCallbackList<l>> u = new HashMap<>();

    public static b nr() {
        if (nr == null) {
            synchronized (b.class) {
                if (nr == null) {
                    nr = new b();
                }
            }
        }
        return nr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public void u(String str, l lVar) throws RemoteException {
        if (lVar == null) {
            return;
        }
        RemoteCallbackList<l> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(lVar);
        u.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public void nr(String str, String str2) throws RemoteException {
        RemoteCallbackList<l> remoteCallbackListRemove = u.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i = 0; i < iBeginBroadcast; i++) {
            l lVar = (l) remoteCallbackListRemove.getBroadcastItem(i);
            if (lVar != null) {
                if (str2 == null) {
                    lVar.u();
                } else {
                    lVar.u(str2);
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}

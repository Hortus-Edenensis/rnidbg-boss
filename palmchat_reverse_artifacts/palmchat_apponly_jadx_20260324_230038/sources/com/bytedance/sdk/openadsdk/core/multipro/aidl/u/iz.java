package com.bytedance.sdk.openadsdk.core.multipro.aidl.u;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.k;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends u {
    private static volatile iz nr;
    private static final Map<String, RemoteCallbackList<k>> u = DesugarCollections.synchronizedMap(new HashMap());

    private synchronized Bundle fx(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        bundle2 = new Bundle();
        try {
            Map<String, RemoteCallbackList<k>> map = u;
            if (map != null) {
                RemoteCallbackList<k> remoteCallbackListRemove = "recycleRes".equals(str2) ? map.remove(str) : map.get(str);
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            k kVar = (k) remoteCallbackListRemove.getBroadcastItem(i);
                            if (kVar != null && "getPlayAgainCondition".equals(str2)) {
                                bundle2 = kVar.u(bundle.getInt("callback_extra_key_next_play_again_count"));
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return bundle2;
    }

    public static iz nr() {
        if (nr == null) {
            synchronized (iz.class) {
                if (nr == null) {
                    nr = new iz();
                }
            }
        }
        return nr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public void u(String str, k kVar) throws RemoteException {
        RemoteCallbackList<k> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(kVar);
        u.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public Bundle nr(String str, String str2, Bundle bundle) throws RemoteException {
        return fx(str, str2, bundle);
    }
}

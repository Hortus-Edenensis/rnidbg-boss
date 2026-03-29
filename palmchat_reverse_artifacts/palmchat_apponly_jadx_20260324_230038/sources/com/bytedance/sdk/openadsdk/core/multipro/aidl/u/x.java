package com.bytedance.sdk.openadsdk.core.multipro.aidl.u;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.kj.w;
import com.bytedance.sdk.openadsdk.core.my;
import com.bytedance.sdk.openadsdk.core.y.jp;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends u {
    private static volatile x nr;
    private static Map<String, RemoteCallbackList<my>> u = DesugarCollections.synchronizedMap(new HashMap());

    private synchronized void fx(String str, String str2, Bundle bundle) {
        RemoteCallbackList<my> remoteCallbackListRemove;
        RemoteCallbackList<my> remoteCallbackListRemove2;
        try {
            if (u != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = u.remove(str);
                    remoteCallbackListRemove2 = u.remove(w.u(str));
                } else {
                    remoteCallbackListRemove = u.get(str);
                    remoteCallbackListRemove2 = null;
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            my myVar = (my) remoteCallbackListRemove.getBroadcastItem(i);
                            if (myVar != null) {
                                if ("onAdShow".equals(str2)) {
                                    myVar.nr();
                                } else if ("onAdClose".equals(str2)) {
                                    myVar.b();
                                } else if ("onVideoComplete".equals(str2)) {
                                    myVar.pn();
                                } else if ("onVideoError".equals(str2)) {
                                    myVar.iz();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    myVar.fx();
                                } else if ("onRewardVerify".equals(str2)) {
                                    u(myVar, bundle);
                                } else if ("onRewardArrived".equals(str2)) {
                                    nr(myVar, bundle);
                                } else if ("onSkippedVideo".equals(str2)) {
                                    myVar.x();
                                } else if ("recycleRes".equals(str2)) {
                                    myVar.u();
                                }
                            }
                        } catch (Throwable th) {
                            k.u("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
                if (remoteCallbackListRemove2 != null) {
                    int iBeginBroadcast2 = remoteCallbackListRemove2.beginBroadcast();
                    for (int i2 = 0; i2 < iBeginBroadcast2; i2++) {
                        try {
                            my myVar2 = (my) remoteCallbackListRemove2.getBroadcastItem(i2);
                            if (myVar2 != null && "recycleRes".equals(str2)) {
                                myVar2.u();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remoteCallbackListRemove2.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove2.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            k.u("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th2);
        }
    }

    public static x nr() {
        if (nr == null) {
            synchronized (x.class) {
                if (nr == null) {
                    nr = new x();
                }
            }
        }
        return nr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public synchronized void u(String str, my myVar) throws RemoteException {
        RemoteCallbackList<my> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(myVar);
        u.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public void u(String str, String str2, Bundle bundle) throws RemoteException {
        fx(str, str2, bundle);
    }

    private void u(my myVar, Bundle bundle) throws RemoteException {
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i2 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        myVar.u(z, i, string != null ? string : "", i2, string2 != null ? string2 : "");
    }

    private void nr(my myVar, Bundle bundle) throws RemoteException {
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_type");
        myVar.u(z, i, jp.u(i, bundle));
    }
}

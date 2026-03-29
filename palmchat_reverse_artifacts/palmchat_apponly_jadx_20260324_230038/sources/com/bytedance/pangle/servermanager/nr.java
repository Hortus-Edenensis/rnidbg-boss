package com.bytedance.pangle.servermanager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.fx;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.pn;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static fx iz;
    private static final Object u = new Object();
    private static final Object nr = new Object();
    private static final Object fx = new Object();
    private static final Map<String, Boolean> b = new ConcurrentHashMap();
    private static final Map<String, pn> pn = new ConcurrentHashMap();

    public static pn u(String str) {
        Boolean bool = b.get(str);
        if (bool == null || !bool.booleanValue()) {
            pn.remove(str);
        }
        Map<String, pn> map = pn;
        if (map.get(str) == null) {
            synchronized (nr) {
                pn pnVar = (pn) u("service", str);
                if (pnVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                map.put(str, pnVar);
            }
        }
        return map.get(str);
    }

    public static fx u() {
        Boolean bool = b.get("main");
        if (bool == null || !bool.booleanValue()) {
            iz = null;
        }
        if (iz == null) {
            synchronized (fx) {
                fx fxVar = (fx) u("package", "main");
                if (fxVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                iz = fxVar;
            }
        }
        return iz;
    }

    private static IBinder u(Uri uri, String str) {
        Bundle bundleCall = Zeus.getAppApplication().getContentResolver().call(uri, "query_binder", str, (Bundle) null);
        if (bundleCall != null) {
            bundleCall.setClassLoader(AbsServerManager.class.getClassLoader());
            u uVar = (u) bundleCall.getParcelable("binder");
            if (uVar != null) {
                return uVar.u();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static IInterface u(String str, final String str2) {
        if (Zeus.hasInit()) {
            ProviderInfo providerInfo = Zeus.getServerManagerHashMap().get(str2);
            if (providerInfo != null) {
                final IBinder iBinderU = u(Uri.parse("content://" + providerInfo.authority), str);
                if (iBinderU == null || !iBinderU.isBinderAlive()) {
                    return null;
                }
                try {
                    byte b2 = 0;
                    iBinderU.linkToDeath(new IBinder.DeathRecipient() { // from class: com.bytedance.pangle.servermanager.nr.1
                        @Override // android.os.IBinder.DeathRecipient
                        public void binderDied() {
                            nr.b.put(str2, Boolean.FALSE);
                            ZeusLogger.w(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                            HashMap<ServiceConnection, HashSet<ComponentName>> map = ServiceManagerNative.getInstance().process2ConnAndService.get(iBinderU);
                            if (map != null) {
                                for (ServiceConnection serviceConnection : map.keySet()) {
                                    Iterator<ComponentName> it = map.get(serviceConnection).iterator();
                                    while (it.hasNext()) {
                                        serviceConnection.onServiceDisconnected(it.next());
                                    }
                                }
                            }
                        }
                    }, 0);
                    b.put(str2, Boolean.TRUE);
                    int iHashCode = str.hashCode();
                    if (iHashCode != -807062458) {
                        b2 = (iHashCode == 1984153269 && str.equals("service")) ? (byte) 1 : (byte) -1;
                    } else if (str.equals("package")) {
                    }
                    if (b2 == 0) {
                        return fx.u.u(iBinderU);
                    }
                    if (b2 != 1) {
                        return null;
                    }
                    return pn.u.u(iBinderU);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "generateServerManager failed.", e);
                    return null;
                }
            }
            throw new RuntimeException("宿主中没有找对对应进程的serverManager ".concat(String.valueOf(str2)));
        }
        throw new RuntimeException("generateServerManager 请先初始化Zeus, processName:".concat(String.valueOf(str2)));
    }
}

package cn.jpush.android.service;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import defpackage.ad;
import defpackage.aw2;
import defpackage.k63;
import defpackage.ll2;
import defpackage.tv2;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class DataShare extends ll2.a {
    private static final String TAG = "DataShare";
    private static final Map<String, ll2> aidlMap = new HashMap();
    private static boolean isBinding = false;

    public static ll2 getInstance(String str) {
        return aidlMap.get(str);
    }

    public static void init(ll2 ll2Var, String str) {
        if (ll2Var != getInstance(str)) {
            aidlMap.put(str, ll2Var);
            k63.a(TAG, str + "'s aidl created");
            try {
                Context contextA = tv2.a(null);
                if (contextA != null) {
                    String strI = ad.i(contextA);
                    if (contextA.getPackageName().equals(strI)) {
                        ll2Var.bind(new DataShare(), strI);
                    }
                }
            } catch (RemoteException e) {
                k63.c(TAG, "bind failed=" + e);
            }
        }
        isBinding = false;
    }

    public static boolean isBinding() {
        return isBinding;
    }

    public static void setBinding() {
        isBinding = true;
    }

    @Override // defpackage.ll2
    public String bind(ll2 ll2Var, String str) throws RemoteException {
        aidlMap.put(str, ll2Var);
        k63.a(TAG, str + "'s aidl bound");
        return ad.i(null);
    }

    @Override // defpackage.ll2
    public Bundle execute(String str, String str2, Bundle bundle) throws RemoteException {
        try {
            return aw2.c().b(tv2.p, str, str2, bundle);
        } catch (Throwable th) {
            k63.n(TAG, "onAction error:" + th);
            return null;
        }
    }

    @Override // defpackage.ll2
    public IBinder getBinderByType(String str, String str2) throws RemoteException {
        return null;
    }

    @Override // defpackage.ll2
    public void onAction(String str, String str2, Bundle bundle) throws RemoteException {
        try {
            aw2.c().b(tv2.p, str, str2, bundle);
        } catch (Throwable th) {
            k63.n(TAG, "onAction error:" + th);
        }
    }
}

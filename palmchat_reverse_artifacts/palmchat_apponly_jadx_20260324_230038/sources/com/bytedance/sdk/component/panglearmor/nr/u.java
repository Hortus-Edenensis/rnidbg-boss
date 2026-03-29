package com.bytedance.sdk.component.panglearmor.nr;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.panglearmor.iz;
import java.lang.reflect.Method;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile u u;
    private volatile int b = -1;
    private ConnectivityManager fx;
    private volatile int nr;
    private TelephonyManager pn;

    public u() {
        this.fx = null;
        this.pn = null;
        Context contextFx = iz.fx();
        if (contextFx != null) {
            this.fx = (ConnectivityManager) contextFx.getSystemService("connectivity");
            this.pn = (TelephonyManager) contextFx.getSystemService("phone");
        }
        u((int) (((pn.u().fx() / 1000) / 60) / 60));
    }

    private int iz() {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.fx;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Network activeNetwork = this.fx.getActiveNetwork();
                    if (activeNetwork != null && (networkCapabilities = this.fx.getNetworkCapabilities(activeNetwork)) != null) {
                        boolean zHasTransport = networkCapabilities.hasTransport(0);
                        boolean zHasTransport2 = networkCapabilities.hasTransport(1);
                        if (u(this.fx) && zHasTransport2) {
                            return 3;
                        }
                        if (zHasTransport2) {
                            return 1;
                        }
                        return zHasTransport ? 2 : 0;
                    }
                } else {
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        return u(this.fx) ? 3 : 1;
                    }
                    if (type == 0) {
                        return 2;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static u u() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    public int b() {
        this.b = iz();
        return this.b;
    }

    @NonNull
    public int[] fx() {
        int[] iArr = new int[this.nr];
        LinkedList<JSONObject> linkedListU = nr.u().u("sp_screen");
        if (linkedListU != null && linkedListU.size() > 0) {
            int iCurrentTimeMillis = (int) (((System.currentTimeMillis() / 1000) / 60) / 60);
            for (JSONObject jSONObject : linkedListU) {
                long jOptLong = jSONObject.optLong("t", 0L);
                int iOptInt = jSONObject.optInt("val", 0);
                int i = iCurrentTimeMillis - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.nr) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    @NonNull
    public int[] nr() {
        int[] iArr = new int[this.nr];
        LinkedList<JSONObject> linkedListU = nr.u().u("sp_net");
        if (linkedListU != null && !linkedListU.isEmpty()) {
            int iOptLong = (int) (((linkedListU.get(linkedListU.size() - 1).optLong("t", 0L) / 1000) / 60) / 60);
            for (JSONObject jSONObject : linkedListU) {
                long jOptLong = jSONObject.optLong("t", 0L);
                int iOptInt = jSONObject.optInt("val", 0);
                int i = iOptLong - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.nr) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    public int pn() {
        TelephonyManager telephonyManager = this.pn;
        if (telephonyManager != null) {
            return telephonyManager.getSimState();
        }
        return -1;
    }

    private static boolean u(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public void u(int i) {
        if (i <= 0) {
            this.nr = 1;
        } else if (i > 168) {
            this.nr = 168;
        } else {
            this.nr = i;
        }
    }
}

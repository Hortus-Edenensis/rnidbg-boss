package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class aj {
    private static final String Code = "JsbCmdManager";
    private static final byte[] I = new byte[0];
    private static aj V;
    private final List<String> B;
    private final Map<String, Class<? extends ae>> C;
    private final Map<String, ae> Z = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class a<T> implements Runnable {
        private ae B;
        private final Context Code;
        private final String I;
        private final String V;
        private final RemoteCallResultCallback<String> Z;

        public a(Context context, ae aeVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
            this.Code = context;
            this.V = str;
            this.I = str2;
            this.Z = remoteCallResultCallback;
            this.B = aeVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            aj.V(this.Code, this.B, this.V, this.I, this.Z);
        }
    }

    private aj() {
        ArrayList arrayList = new ArrayList();
        this.B = arrayList;
        HashMap map = new HashMap();
        this.C = map;
        map.put(ak.V, com.huawei.openalliance.ad.utils.au.Code(com.huawei.openalliance.ad.constant.x.bF));
        map.put(ak.F, com.huawei.openalliance.ad.utils.au.Code(com.huawei.openalliance.ad.constant.x.bF));
        map.put(ak.J, com.huawei.openalliance.ad.utils.au.Code(com.huawei.openalliance.ad.constant.x.bF));
        map.put(ak.I, com.huawei.openalliance.ad.utils.au.Code("com.huawei.openalliance.ad.jsb.JsbRewardProxy"));
        map.put(ak.Z, com.huawei.openalliance.ad.utils.au.Code("com.huawei.openalliance.ad.jsb.JsbInterstitialProxy"));
        map.put(ak.B, com.huawei.openalliance.ad.utils.au.Code(com.huawei.openalliance.ad.constant.x.bK));
        map.put(ak.C, af.class);
        map.put(ak.c, bd.class);
        map.put(ak.d, be.class);
        map.put(ak.S, bi.class);
        map.put(ak.L, bg.class);
        map.put(ak.D, bh.class);
        map.put(ak.f6529a, bc.class);
        map.put(ak.b, av.class);
        map.put(ak.e, bb.class);
        map.put(ak.i, ba.class);
        map.put(ak.g, ax.class);
        map.put(ak.h, ay.class);
        map.put(ak.j, com.huawei.openalliance.ad.utils.au.Code("com.huawei.openalliance.ad.jsb.JsbRewardProxy"));
        map.put(ak.k, com.huawei.openalliance.ad.utils.au.Code("com.huawei.openalliance.ad.jsb.JsbInterstitialProxy"));
        map.put(ak.m, bv.class);
        map.put(ak.H, bt.class);
        map.put(ak.l, bu.class);
        map.put(ak.o, bm.class);
        map.put(ak.n, bl.class);
        map.put(ak.p, bs.class);
        map.put(ak.q, br.class);
        map.put(ak.r, bp.class);
        map.put(ak.s, bq.class);
        map.put(ak.t, bo.class);
        map.put(ak.Code, ap.class);
        map.put(ak.u, ao.class);
        map.put(ak.y, bf.class);
        map.put(ak.z, bj.class);
        map.put(ak.f, aw.class);
        if (com.huawei.openalliance.ad.utils.au.Code(com.huawei.openalliance.ad.constant.x.bL) != null) {
            map.put(ak.v, ar.class);
            map.put(ak.w, at.class);
            map.put(ak.x, as.class);
        }
        map.put(ak.A, aq.class);
        map.put(ak.E, am.class);
        map.put(ak.G, an.class);
        map.put(ak.K, bn.class);
        map.put(ak.M, al.class);
        arrayList.add(ak.C);
        arrayList.add(ak.j);
        arrayList.add(ak.k);
        arrayList.add(ak.F);
        arrayList.add(ak.J);
    }

    public static String V(String str) {
        return new JSONObject(str).optString(com.huawei.openalliance.ad.constant.az.Y);
    }

    public ae Code(String str) throws IllegalAccessException, InstantiationException {
        StringBuilder sb;
        String str2;
        String string;
        if (!TextUtils.isEmpty(str)) {
            ae aeVarNewInstance = this.Z.get(str);
            if (aeVarNewInstance == null) {
                fh.Code(Code, "create command %s", str);
                Class<? extends ae> cls = this.C.get(str);
                if (cls == null) {
                    sb = new StringBuilder();
                    str2 = "no class found for cmd: ";
                } else {
                    try {
                        aeVarNewInstance = cls.newInstance();
                    } catch (InstantiationException unused) {
                        fh.I(Code, "get cmd %s Instantiation Exception", str);
                    } catch (Throwable th) {
                        fh.I(Code, "get cmd %s: %s", str, th.getClass().getSimpleName());
                    }
                    if (aeVarNewInstance == null) {
                        sb = new StringBuilder();
                        str2 = "no instance created for cmd: ";
                    } else {
                        this.Z.put(str, aeVarNewInstance);
                    }
                }
                sb.append(str2);
                sb.append(str);
                string = sb.toString();
            }
            return aeVarNewInstance;
        }
        string = "get cmd, method is empty";
        fh.I(Code, string);
        return null;
    }

    public static aj Code() {
        aj ajVar;
        synchronized (I) {
            if (V == null) {
                V = new aj();
            }
            ajVar = V;
        }
        return ajVar;
    }

    public void V() {
        this.Z.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, ae aeVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (aeVar != null) {
            fh.V(Code, "call method: " + str);
            if (fh.Code()) {
                fh.Code(Code, "param: %s", com.huawei.openalliance.ad.utils.bl.Code(str2));
            }
            try {
                aeVar.execute(context, str2, remoteCallResultCallback);
                return;
            } catch (Throwable th) {
                fh.I(Code, "call method %s, ex: %s", str, th.getClass().getSimpleName());
                ah.Code(remoteCallResultCallback, str, -1, th.getClass().getSimpleName() + ":" + th.getMessage(), true);
                fh.Code(3, th);
                return;
            }
        }
        String str3 = "api for " + str + " is not found";
        fh.V(Code, "call " + str3);
        ah.Code(remoteCallResultCallback, str, -1, str3, true);
    }

    public boolean Code(String str, Context context) {
        return (context instanceof Activity) && this.B.contains(str);
    }
}

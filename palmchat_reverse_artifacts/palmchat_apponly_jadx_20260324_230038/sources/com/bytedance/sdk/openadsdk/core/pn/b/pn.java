package com.bytedance.sdk.openadsdk.core.pn.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.pn.b.x;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f5358a;
    private static final pn u = new pn(7);
    private static final pn nr = new pn(8);
    private static final pn fx = new pn(3);
    private static final pn b = new pn(1);
    private static final pn pn = new pn(5);
    private static final pn iz = new pn(9);
    private static final pn x = new pn(6);
    private static final pn n = new pn(0);

    private pn(int i) {
        this.f5358a = new x(i);
    }

    public static pn u(int i) {
        if (i == 1) {
            return b;
        }
        if (i == 3) {
            return fx;
        }
        switch (i) {
            case 5:
                return pn;
            case 6:
                return x;
            case 7:
                return u;
            case 8:
                return nr;
            case 9:
                return iz;
            default:
                return n;
        }
    }

    public void fx(String str) {
        this.f5358a.fx(str);
    }

    public void nr(String str) {
        this.f5358a.nr(str);
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar, boolean z) {
        if (nrVar == null || bcVar == null) {
            return;
        }
        if ((bcVar.is() != null ? bcVar.is().optInt("save_type") : 0) == 1) {
            return;
        }
        String strB = nrVar.b();
        String strNr = com.bytedance.sdk.component.utils.u.nr(bcVar.et().toString());
        long jCurrentTimeMillis = ((((System.currentTimeMillis() / 1000) / 60) / 60) / 3) + ((long) jp.o(bcVar));
        long jQn = bcVar.qn();
        int iBv = bcVar.bv();
        if (bcVar.fi() > 0) {
            jQn = Math.min(jQn, bcVar.fi());
        }
        this.f5358a.u(strB, new x.nr(strNr, bcVar.ln(), jQn * 1000, bcVar.nu()), z, jCurrentTimeMillis, iBv);
    }

    public bc u(String str, boolean z, long j) {
        System.currentTimeMillis();
        x.nr nrVarU = this.f5358a.u(str, z, j);
        if (nrVarU == null) {
            System.currentTimeMillis();
            return null;
        }
        System.currentTimeMillis();
        try {
            bc bcVarU = com.bytedance.sdk.openadsdk.core.u.u(new JSONObject(com.bytedance.sdk.component.utils.u.fx(nrVarU.fx)));
            bcVarU.n(true);
            bcVarU.oa(101);
            bcVarU.x(nrVarU.u);
            bcVarU.z(nrVarU.pn);
            bcVarU.pm().nr(2);
            return bcVarU;
        } catch (Exception unused) {
            return null;
        }
    }

    public List<bc> u(String str, boolean z, long j, int i) {
        System.currentTimeMillis();
        List<x.nr> listU = this.f5358a.u(str, z, j, i);
        if (listU != null && !listU.isEmpty()) {
            System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (x.nr nrVar : listU) {
                try {
                    bc bcVarU = com.bytedance.sdk.openadsdk.core.u.u(new JSONObject(com.bytedance.sdk.component.utils.u.fx(nrVar.fx)));
                    bcVarU.n(true);
                    bcVarU.oa(101);
                    bcVarU.x(nrVar.u);
                    bcVarU.z(nrVar.pn);
                    bcVarU.pm().nr(2);
                    arrayList.add(bcVarU);
                } catch (Exception unused) {
                }
            }
            return arrayList;
        }
        System.currentTimeMillis();
        return Collections.emptyList();
    }

    public void u(String str) {
        this.f5358a.u(str);
    }

    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f5358a.u(str, str2);
    }

    public void u(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f5358a.u(str, str2, z);
    }

    public void u() {
        this.f5358a.u();
    }

    public static boolean u(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        return (bcVar.is() != null ? bcVar.is().optInt("save_type") : 0) != 1;
    }
}

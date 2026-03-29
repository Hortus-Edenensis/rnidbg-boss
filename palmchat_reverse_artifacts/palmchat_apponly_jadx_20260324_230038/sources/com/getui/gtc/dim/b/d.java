package com.getui.gtc.dim.b;

import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.db.DbManager;
import com.getui.gtc.dim.Caller;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f5721a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f5722a = new d(0);
    }

    private d() {
        this.f5721a = new HashMap();
        try {
            DbManager.init(GtcProvider.context(), com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class);
            ((com.getui.gtc.dim.a.b) DbManager.getTable(com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class)).a();
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
    }

    public static h a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ((com.getui.gtc.dim.a.b) DbManager.getTable(com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class)).a(str);
    }

    private Long b(String str) {
        try {
            if (this.f5721a.containsKey(str)) {
                return this.f5721a.get(str);
            }
            d unused = a.f5722a;
            h hVarA = a(str);
            Long l = hVarA != null ? (Long) hVarA.f5729a : null;
            com.getui.gtc.dim.e.b.a("dim interval from db : " + str + " : " + l);
            this.f5721a.put(str, l);
            return l;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("interval", th);
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static long c(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 320892099:
                if (str.equals("dim-2-1-14-1")) {
                    b = 0;
                }
                break;
            case 320894021:
                if (str.equals("dim-2-1-16-1")) {
                    b = 1;
                }
                break;
            case 320894022:
                if (str.equals("dim-2-1-16-2")) {
                    b = 2;
                }
                break;
            case 320894982:
                if (str.equals("dim-2-1-17-1")) {
                    b = 3;
                }
                break;
            case 320894983:
                if (str.equals("dim-2-1-17-2")) {
                    b = 4;
                }
                break;
            case 320894984:
                if (str.equals("dim-2-1-17-3")) {
                    b = 5;
                }
                break;
            case 320894985:
                if (str.equals("dim-2-1-17-4")) {
                    b = 6;
                }
                break;
            case 320895943:
                if (str.equals("dim-2-1-18-1")) {
                    b = 7;
                }
                break;
            case 320895944:
                if (str.equals("dim-2-1-18-2")) {
                    b = 8;
                }
                break;
            case 320895945:
                if (str.equals("dim-2-1-18-3")) {
                    b = 9;
                }
                break;
            case 320895946:
                if (str.equals("dim-2-1-18-4")) {
                    b = 10;
                }
                break;
            case 320896904:
                if (str.equals("dim-2-1-19-1")) {
                    b = 11;
                }
                break;
            case 320896905:
                if (str.equals("dim-2-1-19-2")) {
                    b = 12;
                }
                break;
            case 320919007:
                if (str.equals("dim-2-1-21-1")) {
                    b = dn.k;
                }
                break;
            case 320919008:
                if (str.equals("dim-2-1-21-2")) {
                    b = dn.l;
                }
                break;
            case 320919009:
                if (str.equals("dim-2-1-21-3")) {
                    b = 15;
                }
                break;
            case 320919011:
                if (str.equals("dim-2-1-21-5")) {
                    b = 16;
                }
                break;
            case 1672919129:
                if (str.equals("dim-2-1-1-1")) {
                    b = 17;
                }
                break;
            case 1672919131:
                if (str.equals("dim-2-1-1-3")) {
                    b = 18;
                }
                break;
            case 1672919132:
                if (str.equals("dim-2-1-1-4")) {
                    b = 19;
                }
                break;
            case 1672920090:
                if (str.equals("dim-2-1-2-1")) {
                    b = 20;
                }
                break;
            case 1672920092:
                if (str.equals("dim-2-1-2-3")) {
                    b = 21;
                }
                break;
            case 1672920093:
                if (str.equals("dim-2-1-2-4")) {
                    b = 22;
                }
                break;
            case 1672921051:
                if (str.equals("dim-2-1-3-1")) {
                    b = 23;
                }
                break;
            case 1672921052:
                if (str.equals("dim-2-1-3-2")) {
                    b = 24;
                }
                break;
            case 1672922012:
                if (str.equals("dim-2-1-4-1")) {
                    b = 25;
                }
                break;
            case 1672922973:
                if (str.equals("dim-2-1-5-1")) {
                    b = 26;
                }
                break;
            case 1672922974:
                if (str.equals("dim-2-1-5-2")) {
                    b = 27;
                }
                break;
            case 1672923934:
                if (str.equals("dim-2-1-6-1")) {
                    b = 28;
                }
                break;
            case 1672923936:
                if (str.equals("dim-2-1-6-3")) {
                    b = 29;
                }
                break;
            case 1672923937:
                if (str.equals("dim-2-1-6-4")) {
                    b = 30;
                }
                break;
            case 1672924895:
                if (str.equals("dim-2-1-7-1")) {
                    b = TELogUtils.DEBUG_LEVEL_V;
                }
                break;
            case 1672925856:
                if (str.equals("dim-2-1-8-1")) {
                    b = 32;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return 5000L;
            case 13:
            case 14:
            case 15:
            case 16:
                return 21600000L;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                return 86400000L;
            default:
                return 0L;
        }
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public final Long a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return b(str + ":" + Caller.valueOf(str2).name());
        }
        g gVarD = g.d();
        int iC = gVarD.c();
        com.getui.gtc.dim.b.a aVarA = com.getui.gtc.dim.b.a.a(str);
        if (aVarA == null) {
            return null;
        }
        Long l = null;
        for (Caller caller : Caller.values()) {
            if (caller.containAt(iC)) {
                Boolean boolB = gVarD.b(aVarA.f5716a, caller.name());
                Long lB = b(str + ":" + caller.name());
                com.getui.gtc.dim.e.b.a("dim check interval for " + str + ", inited caller = " + caller + ", callable = " + boolB + ", interval = " + lB);
                if (boolB == null || boolB.booleanValue()) {
                    if (lB == null) {
                        return null;
                    }
                    if (l == null || lB.longValue() < l.longValue()) {
                        l = lB;
                    }
                }
            }
        }
        return l;
    }

    public final void a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5721a.put(str, Long.valueOf(j));
        com.getui.gtc.dim.e.b.a("dim storage globalValidTime set: " + str + " : " + j);
    }

    public final boolean a(h hVar, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jC = c(str);
        Long l = this.f5721a.get(str);
        if (l == null) {
            l = this.f5721a.get("dim-2-2-0-1");
        }
        long jLongValue = l != null ? l.longValue() : jC;
        Long lA = null;
        if ((g.d().a() & 2) != 0) {
            com.getui.gtc.dim.b.a aVarA = com.getui.gtc.dim.b.a.a(str);
            if (aVarA != null) {
                lA = a(aVarA.b, (String) null);
            }
        } else {
            com.getui.gtc.dim.e.b.a("dim ig in");
        }
        if (lA != null) {
            jLongValue = lA.longValue();
        }
        com.getui.gtc.dim.e.b.a("dim storageValidTime check for " + str + ", dycValue = " + l + ", localValue = " + jC + ", interval = " + lA + ", use " + jLongValue);
        boolean z = jCurrentTimeMillis - hVar.b > jLongValue;
        if (z) {
            com.getui.gtc.dim.e.b.b("dim storage source expired for ".concat(String.valueOf(str)));
        }
        return z;
    }

    public static boolean a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((com.getui.gtc.dim.a.b) DbManager.getTable(com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class)).a(str, obj);
    }
}

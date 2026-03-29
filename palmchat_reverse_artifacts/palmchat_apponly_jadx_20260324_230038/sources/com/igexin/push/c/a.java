package com.igexin.push.c;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f7097a = com.igexin.push.c.b.f7102a + a.class.getName();
    private static final int q = 10;
    int b;
    protected int g;
    protected volatile long h;
    protected volatile long i;
    boolean j;
    private int l;
    private int m;
    private d n;
    final List<d> c = new ArrayList();
    private final List<b> o = new ArrayList();
    final Object d = new Object();
    private final Object p = new Object();
    public volatile EnumC0465a e = EnumC0465a.NORMAL;
    private int r = 0;
    public AtomicBoolean f = new AtomicBoolean(false);
    final Comparator<d> k = new Comparator<d>() { // from class: com.igexin.push.c.a.1
        private static int a(d dVar, d dVar2) {
            return (int) (dVar.c() - dVar2.c());
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(d dVar, d dVar2) {
            return (int) (dVar.c() - dVar2.c());
        }
    };

    /* JADX INFO: renamed from: com.igexin.push.c.a$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7099a;

        static {
            int[] iArr = new int[EnumC0465a.values().length];
            f7099a = iArr;
            try {
                iArr[EnumC0465a.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7099a[EnumC0465a.BACKUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7099a[EnumC0465a.TRY_NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public enum EnumC0465a {
        NORMAL(0),
        BACKUP(1),
        TRY_NORMAL(2);

        int d;

        EnumC0465a(int i) {
            this.d = i;
        }

        private int a() {
            return this.d;
        }

        public static EnumC0465a a(int i) {
            for (EnumC0465a enumC0465a : values()) {
                if (enumC0465a.d == i) {
                    return enumC0465a;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7101a;
        public long b;

        public final b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            try {
                this.f7101a = jSONObject.getString("address");
                this.b = jSONObject.getLong("outdateTime");
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            return this;
        }

        public final String toString() {
            return "ServerAddress{address='" + this.f7101a + "', outdateTime=" + this.b + '}';
        }

        public final JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("address", this.f7101a);
                jSONObject.put("outdateTime", this.b);
                return jSONObject;
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                return null;
            }
        }
    }

    private String a(boolean z) {
        try {
            synchronized (this.p) {
                String str = this.j ? com.igexin.push.core.e.at : com.igexin.push.core.e.au;
                if (this.o.isEmpty() && TextUtils.isEmpty(str)) {
                    com.igexin.c.a.c.a.a(f7097a + "cm list size = 0", new Object[0]);
                    this.m = 0;
                    this.l = 0;
                    return null;
                }
                if (this.o.isEmpty() && !TextUtils.isEmpty(str)) {
                    a(str);
                }
                StringBuilder sb = new StringBuilder();
                String str2 = f7097a;
                sb.append(str2);
                sb.append("cm try = ");
                sb.append(this.m);
                sb.append(" times");
                com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
                if (this.m >= this.o.size() * 1) {
                    com.igexin.c.a.c.a.a(str2 + "cm invalid", new Object[0]);
                    this.m = 0;
                    this.l = 0;
                    this.o.clear();
                    return null;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator<b> it = this.o.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.b < jCurrentTimeMillis) {
                        com.igexin.c.a.c.a.a(f7097a + "|add[" + next.f7101a + "] outDate", new Object[0]);
                        it.remove();
                    }
                }
                h();
                if (this.o.isEmpty()) {
                    return null;
                }
                if (z) {
                    this.m++;
                }
                int i = this.l >= this.o.size() ? 0 : this.l;
                this.l = i;
                String str3 = this.o.get(i).f7101a;
                this.l++;
                return str3;
            }
        } catch (Exception e) {
            String str4 = f7097a;
            com.igexin.c.a.c.a.a(str4, e.toString());
            com.igexin.c.a.c.a.a(str4 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + e.toString(), new Object[0]);
            return null;
        }
    }

    private String b(boolean z) {
        String strA;
        synchronized (this.d) {
            int i = this.b >= this.c.size() ? 0 : this.b;
            this.b = i;
            d dVar = this.c.get(i);
            this.n = dVar;
            strA = dVar.a(z);
        }
        return strA;
    }

    private List<b> g() {
        return this.o;
    }

    private void h() {
        JSONArray jSONArray = new JSONArray();
        Iterator<b> it = this.o.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        com.igexin.push.core.e.f.a().c(jSONArray.length() == 0 ? com.igexin.push.core.b.m : jSONArray.toString(), !this.j);
    }

    private void i() {
        synchronized (this.d) {
            this.b = 0;
            Collections.sort(this.c, this.k);
        }
    }

    private void j() {
        com.igexin.c.a.c.a.a(f7097a + "|detect success, current type = " + this.e, new Object[0]);
        if (this.e == EnumC0465a.BACKUP) {
            a(EnumC0465a.TRY_NORMAL);
            com.igexin.push.core.d unused = d.a.f7200a;
            com.igexin.push.e.a.a(true);
        }
    }

    private void k() {
        com.igexin.c.a.c.a.a(f7097a + "|before disconnect, type = " + this.e, new Object[0]);
        int i = AnonymousClass2.f7099a[this.e.ordinal()];
        if (i != 1) {
            if (i == 2 && System.currentTimeMillis() - this.h > com.igexin.push.config.d.r) {
                a(EnumC0465a.TRY_NORMAL);
                return;
            }
            return;
        }
        if (System.currentTimeMillis() - this.i <= 86400000 || this.g <= com.igexin.push.config.d.t) {
            return;
        }
        a(EnumC0465a.BACKUP);
    }

    public final synchronized void c() {
        this.g++;
        com.igexin.c.a.c.a.a(f7097a + "|loginFailedCnt = " + this.g, new Object[0]);
    }

    public final void d() {
        if (AnonymousClass2.f7099a[this.e.ordinal()] == 2 && System.currentTimeMillis() - this.h > com.igexin.push.config.d.r) {
            a(EnumC0465a.TRY_NORMAL);
        }
    }

    public final void e() {
        if (this.e != EnumC0465a.BACKUP) {
            this.g = 0;
        }
        int i = AnonymousClass2.f7099a[this.e.ordinal()];
        if (i == 1) {
            this.i = System.currentTimeMillis();
            c.a().f().n();
            this.f.set(false);
        } else {
            if (i != 3) {
                return;
            }
            a(EnumC0465a.NORMAL);
            this.f.set(false);
        }
    }

    public final void f() {
        EnumC0465a enumC0465a;
        com.igexin.c.a.c.a.a(f7097a + "|before disconnect, type = " + this.e, new Object[0]);
        int[] iArr = AnonymousClass2.f7099a;
        int i = iArr[this.e.ordinal()];
        if (i != 1) {
            if (i == 2 && System.currentTimeMillis() - this.h > com.igexin.push.config.d.r) {
                enumC0465a = EnumC0465a.TRY_NORMAL;
                a(enumC0465a);
            }
        } else if (System.currentTimeMillis() - this.i > 86400000 && this.g > com.igexin.push.config.d.t) {
            enumC0465a = EnumC0465a.BACKUP;
            a(enumC0465a);
        }
        if (com.igexin.push.core.e.u && this.e != EnumC0465a.BACKUP) {
            this.i = System.currentTimeMillis();
            c.a().f().n();
        }
        if (iArr[this.e.ordinal()] != 3) {
            return;
        }
        int i2 = this.r + 1;
        this.r = i2;
        if (i2 >= 10) {
            this.g = 0;
            this.h = System.currentTimeMillis();
            a(EnumC0465a.BACKUP);
        }
    }

    private void c(boolean z) {
        this.j = z;
    }

    public final synchronized void a(EnumC0465a enumC0465a) {
        StringBuilder sb = new StringBuilder();
        String str = f7097a;
        sb.append(str);
        sb.append("|set domain type = ");
        sb.append(enumC0465a);
        com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
        if (com.igexin.push.config.d.g) {
            if (this.e != enumC0465a) {
                a((List<b>) null);
            }
            int i = AnonymousClass2.f7099a[enumC0465a.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.f.set(true);
                    if (this.e != enumC0465a) {
                        this.h = System.currentTimeMillis();
                    }
                    SDKUrlConfig.setConnectAddress(SDKUrlConfig.XFR_ADDRESS_BAK[0]);
                    SDKUrlConfig.getConnectAddress();
                    com.igexin.c.a.c.a.a(str + "|set domain type backup cm = " + SDKUrlConfig.getConnectAddress(), new Object[0]);
                } else if (i == 3) {
                    if (this.e != enumC0465a) {
                        this.r = 0;
                    }
                }
                this.e = enumC0465a;
                c.a().f().n();
            }
            this.b = 0;
            SDKUrlConfig.setConnectAddress(b(true));
            if (enumC0465a == EnumC0465a.NORMAL) {
                this.f.set(false);
            }
            SDKUrlConfig.getConnectAddress();
            com.igexin.c.a.c.a.a(str + "|set domain type normal cm = " + SDKUrlConfig.getConnectAddress(), new Object[0]);
            this.e = enumC0465a;
            c.a().f().n();
        }
    }

    public final synchronized void b() {
        this.m = 0;
        d dVar = this.n;
        if (dVar != null) {
            dVar.e();
        }
    }

    private void a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.o.add(new b().a(jSONArray.getJSONObject(i)));
            }
            com.igexin.c.a.c.a.a(f7097a + "|get cm from cache, isWf = " + this.j + ", lastCmList = " + str, new Object[0]);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final void b(List<d> list) {
        synchronized (this.d) {
            this.c.clear();
            this.c.addAll(list);
            Collections.sort(this.c, this.k);
        }
    }

    public final void a(List<b> list) {
        synchronized (this.p) {
            this.l = 0;
            this.m = 0;
            this.o.clear();
            if (list != null) {
                this.o.addAll(list);
                com.igexin.c.a.c.a.a(f7097a + "|set cm list: " + list.toString(), new Object[0]);
            }
            h();
        }
    }

    public final boolean a() {
        boolean z;
        String strA;
        String str;
        try {
            com.igexin.push.core.d unused = d.a.f7200a;
            z = true;
            boolean z2 = !com.igexin.push.e.a.e();
            strA = a(z2);
            StringBuilder sb = new StringBuilder();
            str = f7097a;
            sb.append(str);
            sb.append("|get from cm = ");
            sb.append(strA);
            com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
            if (strA == null) {
                if (com.igexin.push.config.d.g && this.e == EnumC0465a.BACKUP) {
                    int i = this.b;
                    String[] strArr = SDKUrlConfig.XFR_ADDRESS_BAK;
                    if (i >= strArr.length) {
                        i = 0;
                    }
                    strA = strArr[i];
                    this.b = i + 1;
                } else {
                    d dVar = this.n;
                    if (dVar != null && !dVar.d()) {
                        this.b++;
                    }
                    strA = b(z2);
                }
                z = false;
            }
        } catch (Exception e) {
            e = e;
            z = false;
        }
        try {
            if (!SDKUrlConfig.getConnectAddress().equals(strA)) {
                SDKUrlConfig.getConnectAddress();
                com.igexin.c.a.c.a.a(str + "|address changed : form [" + SDKUrlConfig.getConnectAddress() + "] to [" + strA + "]", new Object[0]);
            }
            SDKUrlConfig.setConnectAddress(strA);
        } catch (Exception e2) {
            e = e2;
            com.igexin.c.a.c.a.a(e);
            String str2 = f7097a;
            com.igexin.c.a.c.a.a(str2, e.toString());
            com.igexin.c.a.c.a.a(str2 + "|switch address|" + e.toString(), new Object[0]);
        }
        return z;
    }
}

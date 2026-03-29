package com.getui.gtc.dim.b;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.dim.AppDataProvider;
import com.getui.gtc.dim.Caller;
import com.getui.gtc.dim.DimSource;
import com.getui.gtc.dim.b.d;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final List<String> f5724a = Arrays.asList("dim-2-1-21-5", "dim-2-1-21-3", "dim-2-1-21-1");
    AppDataProvider e;
    String f;
    private volatile int k;
    private volatile String r;
    int c = 0;
    int d = 1;
    private int m = 3;
    private final int[] n = {-1, 33};
    private volatile boolean s = true;
    final Map<String, Integer> b = new HashMap();
    private final Map<String, Integer> g = new HashMap();
    private final List<String> i = new ArrayList();
    private final List<String> j = new ArrayList();
    private final Map<String, String> h = new HashMap();
    private final Map<String, Boolean> o = new HashMap(4);
    private final List<String> p = new ArrayList();
    private final List<String> q = new ArrayList();
    private final Map<String, Boolean> l = new HashMap();

    /* JADX INFO: renamed from: com.getui.gtc.dim.b.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5725a;

        static {
            int[] iArr = new int[Caller.values().length];
            f5725a = iArr;
            try {
                iArr[Caller.PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5725a[Caller.IDO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5725a[Caller.GY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5725a[Caller.WUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5725a[Caller.ONEID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static boolean h(String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "dim-2-1-21-1":
                case "dim-2-1-21-2":
                case "dim-2-1-21-3":
                case "dim-2-1-21-5":
                    return true;
            }
        }
        return false;
    }

    private static boolean i(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private Boolean j(String str) {
        try {
            if (this.l.containsKey(str)) {
                return this.l.get(str);
            }
            d unused = d.a.f5722a;
            h hVarA = d.a(str);
            Boolean bool = hVarA != null ? (Boolean) hVarA.f5729a : null;
            com.getui.gtc.dim.e.b.a("dim sys callable from db : " + str + " : " + bool);
            this.l.put(str, bool);
            return bool;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("callable", th);
            return null;
        }
    }

    public int a() {
        return this.m;
    }

    public final int b(String str) {
        Integer num = 0;
        if (!TextUtils.isEmpty(str) && (num = this.g.get(str)) == null) {
            num = this.g.get("dim-2-2-0-1");
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int c() {
        return this.k;
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.h.put(str, str2);
        com.getui.gtc.dim.e.b.a("dim sys global trace order set: " + str + " : " + str2);
    }

    public final DimSource e(String str) {
        ArrayList<Caller> arrayList;
        int i;
        String str2;
        try {
            arrayList = new ArrayList();
            for (Caller caller : Caller.values()) {
                if (a(caller, str)) {
                    arrayList.add(caller);
                }
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("allowSource key:".concat(String.valueOf(str)), th);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (this.h.isEmpty()) {
            str2 = null;
        } else {
            str2 = this.h.get(str);
            if (str2 == null) {
                str2 = this.h.get("dim-2-2-0-1");
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            String[] strArrSplit = str2.split("#");
            if (strArrSplit.length >= 4) {
                for (String str3 : strArrSplit) {
                    for (Caller caller2 : arrayList) {
                        if (b(caller2).equals(str3)) {
                            return DimSource.of(caller2);
                        }
                    }
                }
            } else {
                com.getui.gtc.dim.e.b.b("dim sys trace order: " + str2 + " not match for " + str);
            }
        }
        Caller caller3 = Caller.IDO;
        if (arrayList.contains(caller3)) {
            return DimSource.of(caller3);
        }
        Caller caller4 = Caller.PUSH;
        if (arrayList.contains(caller4)) {
            return DimSource.of(caller4);
        }
        Caller caller5 = Caller.GY;
        if (arrayList.contains(caller5)) {
            return DimSource.of(caller5);
        }
        Caller caller6 = Caller.WUS;
        if (arrayList.contains(caller6)) {
            return DimSource.of(caller6);
        }
        Caller caller7 = Caller.ONEID;
        if (arrayList.contains(caller7)) {
            return DimSource.of(caller7);
        }
        return null;
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i.add(str);
        com.getui.gtc.dim.e.b.a("dim sys app provider globalAllow set: " + str + " : true");
    }

    public void g(String str, String str2) {
        String[] strArrSplit = str2.split("#");
        int length = strArrSplit.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (strArrSplit[i].equals(Build.MODEL)) {
                this.p.add(str);
                z = true;
                break;
            }
            i++;
        }
        com.getui.gtc.dim.e.b.a("dim sys black model set: " + str + " : " + str2 + " : " + z);
    }

    public void a(int i) {
        this.m = i;
        com.getui.gtc.dim.e.b.a("dim sys busi enable set: ".concat(String.valueOf(i)));
    }

    public Boolean b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return j(str + ":" + Caller.valueOf(str2).name());
        }
        for (Caller caller : Caller.values()) {
            if (caller.containAt(this.k)) {
                Boolean boolJ = j(str + ":" + caller.name());
                if (boolJ == null || boolJ.booleanValue()) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    public void c(int i) {
        this.d = i;
        com.getui.gtc.dim.e.b.a("dim sys trace hw oaid enable set: ".concat(String.valueOf(i)));
    }

    public final boolean d(String str) {
        for (Caller caller : Caller.values()) {
            if (a(caller, str)) {
                return true;
            }
        }
        return false;
    }

    public void e(String str, String str2) {
        boolean zA = a(false, str2);
        this.o.put(str, Boolean.valueOf(zA));
        com.getui.gtc.dim.e.b.a("dim sys black version set: " + str + " : " + str2 + " : " + zA);
    }

    public void f(String str, String str2) {
        String string;
        String str3;
        String[] strArrSplit;
        StringBuilder sb;
        boolean z = false;
        try {
            str3 = Build.BRAND;
            strArrSplit = str2.split(ContainerUtils.FIELD_DELIMITER);
        } catch (Throwable th) {
            th = th;
        }
        if (str3.equalsIgnoreCase(strArrSplit[0]) && a(true, strArrSplit[1])) {
            String str4 = strArrSplit[2];
            if (!str4.equals("*")) {
                if (this.r == null) {
                    this.r = com.getui.gtc.dim.c.a.d();
                }
                if (TextUtils.isEmpty(this.r)) {
                    sb = new StringBuilder("dim sys black rom set: ");
                } else {
                    String[] strArrSplit2 = str4.split("#");
                    int length = strArrSplit2.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        if (this.r.startsWith(strArrSplit2[i])) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                    if (!z) {
                        sb = new StringBuilder("dim sys black rom set: ");
                    }
                }
            }
            try {
                this.q.add(str);
                sb = new StringBuilder("dim sys black rom set: ");
                sb.append(str);
                sb.append(" : ");
                sb.append(str2);
                sb.append(" : true");
                string = sb.toString();
            } catch (Throwable th2) {
                th = th2;
                z = true;
                try {
                    com.getui.gtc.dim.e.b.b(th);
                    string = "dim sys black rom set: " + str + " : " + str2 + " : " + z;
                } catch (Throwable th3) {
                    com.getui.gtc.dim.e.b.a("dim sys black rom set: " + str + " : " + str2 + " : " + z);
                    throw th3;
                }
            }
            com.getui.gtc.dim.e.b.a(string);
        }
        sb = new StringBuilder("dim sys black rom set: ");
        sb.append(str);
        sb.append(" : ");
        sb.append(str2);
        sb.append(" : false");
        string = sb.toString();
        com.getui.gtc.dim.e.b.a(string);
    }

    public final boolean g(String str) {
        try {
            Boolean bool = this.o.get(str);
            if (bool == null) {
                bool = this.o.get("dim-2-2-0-1");
            }
            if (bool == null) {
                if (Build.VERSION.SDK_INT >= 34 && h(str)) {
                    com.getui.gtc.dim.e.b.a("dim sys black version use ld for: " + str + " : true");
                    return true;
                }
            } else if (bool.booleanValue()) {
                return true;
            }
            return this.p.contains(str) || this.q.contains(str);
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            return true;
        }
    }

    private static String b(Caller caller) {
        if (caller == null) {
            return "";
        }
        int i = AnonymousClass1.f5725a[caller.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "oneid" : "wus" : "gy" : "ido" : "gt";
    }

    public void a(AppDataProvider appDataProvider) {
        this.e = appDataProvider;
        com.getui.gtc.dim.e.b.a("dim sys app data provider set: ".concat(String.valueOf(appDataProvider)));
    }

    public void c(String str) {
        if (str != null) {
            try {
                if (str.contains(new String(Base64.decode("Y29tLmdldHVpLmd0Yy5leHRlbnNpb24uZGlzdHJpYnV0aW9uLmdkaS5zdHViLlB1c2hFeHRlbnNpb24=", 2)))) {
                    this.f = str;
                }
            } catch (Throwable th) {
                com.getui.gtc.dim.e.b.b(th);
                return;
            }
        }
        com.getui.gtc.dim.e.b.a("dim sys gtc dyc config set: ".concat(String.valueOf(str)));
    }

    public void a(Caller caller) {
        if (caller != null) {
            synchronized (this) {
                this.k |= caller.index;
            }
        }
        com.getui.gtc.dim.e.b.a("dim sys gtc init caller set: ".concat(String.valueOf(caller)));
    }

    public void b(int i) {
        this.c = i;
        com.getui.gtc.dim.e.b.a("dim sys trace enable set: ".concat(String.valueOf(i)));
    }

    public void c(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g.put(str, Integer.valueOf(i));
        com.getui.gtc.dim.e.b.a("dim sys globalAllow policy set: " + str + " : " + i);
    }

    public void a(String str, int i) {
        if (str.equalsIgnoreCase(Build.BRAND)) {
            this.n[0] = i;
        } else if (str.equals("dim-2-2-0-1")) {
            this.n[1] = i;
        }
        com.getui.gtc.dim.e.b.a("dim sys pm policy set: " + str + " : " + i);
    }

    public void b(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, Integer.valueOf(i));
        com.getui.gtc.dim.e.b.a("dim sys globalAllow set: " + str + " : " + i);
    }

    public void c(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (String str3 : str2.split("#")) {
                this.j.add(str + ":" + str3);
            }
            com.getui.gtc.dim.e.b.a("dim sys global disallow set: " + str + " : " + str2);
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("dim sys global disallow set: " + str + " : " + str2, th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        if (r6.j.contains(r8 + ":" + b(r7)) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Caller caller, String str) {
        if (caller != null && caller != Caller.UNKNOWN && caller.containAt(this.k)) {
            try {
                if (!this.j.isEmpty()) {
                }
                if ((this.m & 1) == 0) {
                    com.getui.gtc.dim.e.b.a("dim sys ig ca");
                    return true;
                }
                a aVarA = a.a(str);
                if (aVarA != null) {
                    Boolean boolJ = j(aVarA.f5716a + ":" + caller.name());
                    com.getui.gtc.dim.e.b.a("dim sys get callable " + caller + " : " + str + " : " + boolJ);
                    if (boolJ != null && !boolJ.booleanValue()) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                com.getui.gtc.dim.e.b.b(th);
            }
        }
        return false;
    }

    public final boolean b() {
        int[] iArr = this.n;
        int i = iArr[0];
        return i >= 0 ? Build.VERSION.SDK_INT >= i : Build.VERSION.SDK_INT >= iArr[1];
    }

    public final boolean a(String str) {
        try {
            return this.i.contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b(String str, Caller caller, boolean z) {
        if (caller != Caller.IDO || i("com.igexin.sdk.PushManager") || i("com.g.gysdk.GYManager") || !i("com.getui.gs.sdk.GsManager")) {
            com.getui.gtc.dim.e.b.a("dim sys gbdExecutable set ignored");
            return false;
        }
        this.s = z;
        com.getui.gtc.dim.e.b.a("dim sys gbdExecutable set: ".concat(String.valueOf(z)));
        return true;
    }

    public boolean a(String str, Caller caller, boolean z) {
        this.l.put(str + ":" + caller.name(), Boolean.valueOf(z));
        d unused = d.a.f5722a;
        d.a(str + ":" + caller.name(), Boolean.valueOf(z));
        com.getui.gtc.dim.e.b.a("dim sys callable set: " + str + " : " + caller + " : " + z);
        return true;
    }

    public boolean a(String str, String str2) {
        if (Caller.valueOf(str2) == Caller.IDO) {
            return this.s;
        }
        com.getui.gtc.dim.e.b.a("dim sys gbdExecutable get always true");
        return true;
    }

    private static boolean a(boolean z, String str) {
        if (z && "*".equals(str)) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        for (String str2 : str.split("#")) {
            if (str2.contains("-")) {
                String[] strArrSplit = str2.split("-");
                if (strArrSplit.length == 2 && i >= Integer.parseInt(strArrSplit[0]) && i <= Integer.parseInt(strArrSplit[1])) {
                    return true;
                }
            } else if (String.valueOf(i).equals(str2)) {
                return true;
            }
        }
        return false;
    }
}

package defpackage;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class gx2 extends yw2 {
    public Context c;
    public kx2 d;
    public String e;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends yw2 {
        public Context c;

        public a(Context context) {
            this.c = context;
            this.f22293a = "JWake#RequestConfigAction";
        }

        @Override // defpackage.yw2
        public void a() {
            gx2.j(this.c);
        }
    }

    public gx2(Context context, String str) {
        this.c = context;
        this.e = str;
        this.f22293a = "JWake";
    }

    public static void c(Context context, kx2 kx2Var) {
        boolean z = false;
        if (!kv2.s(context) && !kx2Var.e) {
            ix2.h(context, false);
            return;
        }
        if (kx2Var.b && kx2Var.d) {
            z = true;
        }
        ix2.h(context, z);
    }

    public static void d(Context context, String str) {
        try {
            rv2.F(new gx2(context, str));
        } catch (Throwable th) {
            p63.f("JWake", "[doAction failed] " + str + " :" + th.getMessage());
        }
    }

    public static void i(Context context) {
        try {
            rv2.F(new a(context));
        } catch (Throwable th) {
            p63.f("JWake", "[requestConfig failed] " + th.getMessage());
        }
    }

    public static kx2 j(Context context) {
        try {
            JSONObject jSONObjectF = jx2.f(context);
            if (jSONObjectF == null) {
                return null;
            }
            jx2.g(context, m86.d(jSONObjectF.toString()));
            return jx2.e(context, jSONObjectF);
        } catch (Throwable th) {
            p63.f("JWake", "[requestConfigNow] failed:" + th.getMessage());
            return null;
        }
    }

    public static Object k(Context context) {
        boolean z = jx2.d(context).e || kv2.s(context);
        p63.a("JWake", "isActionUserEnable :" + z);
        return Boolean.valueOf(z);
    }

    public static Object l(Context context, Object obj) {
        if (!(obj instanceof List)) {
            return obj;
        }
        return mx2.k(jx2.d(context), (List) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x014d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<qx2> m(Context context, List<rx2> list) {
        boolean z;
        Object obj;
        Bundle bundleI;
        Intent intent;
        p63.a("JWake", "[wake] wakeTargets:" + list);
        kv2.E(context, "JWake");
        kv2.M(context);
        if (list == null || list.size() <= 0) {
            p63.f("JWake", "there are no wakeTarget");
            return null;
        }
        HashMap map = new HashMap();
        map.put("from_package", context.getPackageName());
        ArrayList arrayList = new ArrayList();
        for (rx2 rx2Var : list) {
            p63.a("JWake", "start wake target:" + rx2Var);
            if (rx2Var == null) {
                p63.f("JWake", "wakeTarget is null, continue another wake");
            } else if (rx2Var.c == 2) {
                p63.f("JWake", "command this app is not allow to wake package:" + rx2Var.f20619a + ",service:" + rx2Var.b);
            } else {
                qx2 qx2Var = new qx2();
                qx2Var.f20349a = rx2Var.f20619a;
                if ((rx2Var.f & 1) == 0 || rx2Var.e == null || ix2.e(context)) {
                    z = false;
                    if (z) {
                        p63.a("JWake", "wake success, continue wake other target");
                        arrayList.add(qx2Var);
                    } else if ((rx2Var.f & 4) == 0) {
                        arrayList.add(qx2Var);
                        p63.a("JWake", "wake end, no service or provider wake, wakeType: " + rx2Var.f);
                    } else {
                        int i = !TextUtils.isEmpty(rx2Var.b) ? (Build.VERSION.SDK_INT < 26 || rx2Var.c < 26) ? 3 : 2 : 0;
                        if (!TextUtils.isEmpty(rx2Var.d)) {
                            i |= 4;
                        }
                        int i2 = i;
                        p63.a("JWake", "use OLD wake up ,wake type is :" + i2);
                        int i3 = i2 & 2;
                        if (i3 != 0 || (i2 & 1) != 0) {
                            ComponentName componentName = new ComponentName(rx2Var.f20619a, rx2Var.b);
                            Intent intent2 = new Intent();
                            intent2.setComponent(componentName);
                            intent2.setFlags(32);
                            Bundle bundleI2 = mx2.i(map);
                            bundleI2.putInt("type", 2);
                            intent2.putExtras(bundleI2);
                            if (i3 != 0) {
                                try {
                                    qx2Var.b.put(2, Integer.valueOf(context.getApplicationContext().bindService(intent2, new b(context), 1) ? 1 : 102));
                                } catch (Throwable th) {
                                    p63.f("JWake", "bindService throwable:" + th.getMessage());
                                    qx2Var.b.put(2, 101);
                                }
                            }
                            if ((i2 & 1) != 0) {
                                try {
                                    qx2Var.b.put(1, Integer.valueOf(context.startService(intent2) != null ? 1 : 102));
                                } catch (Throwable th2) {
                                    p63.f("JWake", "startService throwable:" + th2.getMessage());
                                    qx2Var.b.put(1, 101);
                                }
                            }
                        }
                        if ((i2 & 4) != 0) {
                            try {
                                if (!TextUtils.isEmpty(rx2Var.d)) {
                                    ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
                                    String str = rx2Var.d;
                                    if (!str.startsWith("content://")) {
                                        str = "content://" + str;
                                    }
                                    map.put("type", "4");
                                    String strJ = mx2.j(map);
                                    if (!TextUtils.isEmpty(strJ)) {
                                        str = str + strJ;
                                    }
                                    Cursor cursorQuery = contentResolver.query(Uri.parse(str), null, null, null, null);
                                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                                        cursorQuery.close();
                                    }
                                    qx2Var.b.put(4, 1);
                                }
                            } catch (Throwable th3) {
                                p63.f("JWake", "getContentResolver throwable:" + th3.getMessage());
                                qx2Var.b.put(4, 101);
                            }
                        }
                        p63.a("JWake", "wakeResult:" + qx2Var.toString());
                        arrayList.add(qx2Var);
                    }
                } else {
                    try {
                        bundleI = mx2.i(map);
                        bundleI.putInt("type", 8);
                        intent = rx2Var.e;
                    } catch (Throwable th4) {
                        obj = th4;
                        z = false;
                    }
                    if (intent != null) {
                        intent.addFlags(276824064);
                        intent.putExtras(bundleI);
                        context.startActivity(intent);
                        try {
                            if (intent.getComponent() != null) {
                                if ("cn.jpush.android.service.DActivity".equals(intent.getComponent().getClassName())) {
                                    kv2.E(context, "JWake_dactivity");
                                } else {
                                    kv2.E(context, "JWake_activity");
                                }
                            }
                            p63.a("JWake", "use ACTIVITY wake up ,start activity:" + rx2Var.f20619a + "," + rx2Var.e);
                            qx2Var.b.put(8, 1);
                            z = true;
                        } catch (Throwable th5) {
                            obj = th5;
                            z = true;
                            p63.a("JWake", "Fail to start activity caused by:" + obj);
                            qx2Var.b.put(8, 101);
                        }
                        if (z) {
                        }
                    } else {
                        p63.f("JWake", "Fail to start activity ,activityIntent is null !!");
                        z = false;
                        if (z) {
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // defpackage.yw2
    public void a() {
        try {
            p63.a("JWake", "wake with:" + this.e);
            if (!rv2.z(this.c)) {
                p63.f("JWake", "can't wake because not registered yet");
                return;
            }
            this.d = jx2.d(this.c);
            h();
            p63.a("JWake", "use config:" + this.d);
            c(this.c, this.d);
            if (!e()) {
                p63.a("JWake", "wake is disabled by user");
                return;
            }
            kx2 kx2Var = this.d;
            if (kx2Var.f18847a && kx2Var.c) {
                if (kx2Var.v == 7) {
                    p63.a("JWake", "all wakeup type is unsupported of app, not wakeup any package");
                    return;
                }
                if (!mx2.c()) {
                    LogUtil.d(getClass().getSimpleName(), "LX forbidden launcher other app a");
                    return;
                }
                if (this.d.i && this.e.equals("start")) {
                    sx2.d().a(this.c, this.d, g());
                    return;
                }
                if (!this.d.h) {
                    p63.a("JWake", "time disabled");
                    return;
                }
                long jK = kv2.k(this.c, "JWake");
                long j = this.d.g;
                long jCurrentTimeMillis = System.currentTimeMillis();
                p63.a("JWake", "[wakeUp]currentTimeMillis:" + jCurrentTimeMillis + ",lastBusinessTime:" + jK + ",wakeInterval:" + j);
                if (jCurrentTimeMillis - jK < j) {
                    p63.a("JWake", "need not wake up");
                    return;
                } else {
                    sx2.d().a(this.c, this.d, g());
                    return;
                }
            }
            p63.a("JWake", "wake is disabled by server");
        } catch (Throwable th) {
            p63.f("JWake", "wake failed:" + th.getMessage());
        }
    }

    public final boolean e() {
        boolean z = this.d.e || kv2.s(this.c);
        p63.a("JWake", "isActionUserEnable :" + z);
        return z;
    }

    public final boolean f(String str) {
        List<String> list = this.d.p;
        if (list != null && list.contains(str)) {
            p63.a("JWake", str + " is in black list");
            return true;
        }
        if (TextUtils.isEmpty(this.d.n)) {
            return false;
        }
        if (this.d.n.equals("exclude")) {
            if (!this.d.o.contains(str)) {
                return false;
            }
            p63.a("JWake", str + " is in excloude list");
            return true;
        }
        if (!this.d.n.equals("include") || this.d.o.contains(str)) {
            return false;
        }
        p63.a("JWake", str + " is not in include list");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x017c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0181 A[Catch: URISyntaxException -> 0x019e, TRY_LEAVE, TryCatch #2 {URISyntaxException -> 0x019e, blocks: (B:63:0x017e, B:64:0x0181, B:56:0x016b, B:59:0x0172), top: B:111:0x017e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<rx2> g() {
        ux2 ux2Var;
        HashMap<String, rx2> map;
        boolean zA;
        ArrayList arrayList = new ArrayList();
        HashMap<String, rx2> mapP = mx2.p(this.c);
        HashMap<String, rx2> mapM = mx2.m(this.c, mapP);
        HashMap map2 = (HashMap) this.d.k;
        long jK = kv2.k(this.c, "JWake_account");
        long jK2 = kv2.k(this.c, "JWake_activity");
        long jK3 = kv2.k(this.c, "JWake_dactivity");
        long jCurrentTimeMillis = System.currentTimeMillis();
        kx2 kx2Var = this.d;
        long j = kx2Var.q;
        HashMap<String, rx2> map3 = mapP;
        HashMap<String, rx2> map4 = mapM;
        ArrayList arrayList2 = arrayList;
        boolean z = jCurrentTimeMillis - jK2 >= kx2Var.s;
        boolean z2 = jCurrentTimeMillis - jK3 >= kx2Var.r || this.e.equals("start");
        p63.a("JWake", "currentTimeMillis:" + jCurrentTimeMillis + ",lastAccountTime:" + jK + ",lastActivityTime:" + jK2 + ",lastDActivityTime:" + jK3);
        if (map2 != null) {
            Iterator it = map2.entrySet().iterator();
            while (it.hasNext() && arrayList2.size() < this.d.f) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                if (!f(str)) {
                    ux2 ux2Var2 = (ux2) entry.getValue();
                    if (ux2Var2.f21313a == 0) {
                        p63.a("JWake", str + " not need any method to wake, type is 0");
                    } else {
                        Intent uri = null;
                        HashMap<String, rx2> map5 = map3;
                        rx2 rx2VarO = (map3 == null || !map5.containsKey(str)) ? ux2Var2.d ? mx2.o(this.c, str) : null : map5.get(str);
                        if (rx2VarO != null || map4 == null) {
                            map = map4;
                        } else {
                            map = map4;
                            if (map.containsKey(str)) {
                                rx2VarO = map.get(str);
                            }
                        }
                        if (rx2VarO == null) {
                            p63.f("JWake", str + " not found targetInfo");
                        } else {
                            int i = ux2Var2.f21313a;
                            rx2VarO.f = i;
                            rx2VarO.i = ux2Var2.g;
                            if ((i & 1) != 0) {
                                try {
                                    if (TextUtils.isEmpty(ux2Var2.f)) {
                                        if (z2) {
                                            uri = new Intent();
                                            uri.setClassName(str, "cn.jpush.android.service.DActivity");
                                            zA = ix2.a(this.c, str, uri, false);
                                            if (zA || uri == null) {
                                                p63.f("JWake", "do not use Activity wake , activityEnable = " + zA + ",  intent=" + uri);
                                            } else {
                                                try {
                                                    rx2VarO.e = uri;
                                                } catch (URISyntaxException e) {
                                                    e = e;
                                                    p63.c("JWake", "parse package:" + str + " activity intent error:" + e);
                                                }
                                            }
                                        } else {
                                            p63.a("JWake", "not DActivity time");
                                            zA = false;
                                            if (zA) {
                                                p63.f("JWake", "do not use Activity wake , activityEnable = " + zA + ",  intent=" + uri);
                                            }
                                        }
                                    } else if (z) {
                                        try {
                                            uri = Intent.parseUri(ux2Var2.f, 0);
                                            zA = ix2.a(this.c, str, uri, true);
                                            if (zA) {
                                            }
                                        } catch (URISyntaxException e2) {
                                            e = e2;
                                            p63.c("JWake", "parse package:" + str + " activity intent error:" + e);
                                            ArrayList arrayList3 = arrayList2;
                                            arrayList3.add(rx2VarO);
                                            arrayList2 = arrayList3;
                                            map3 = map5;
                                            map4 = map;
                                        }
                                    } else {
                                        p63.a("JWake", "not custom Activity time");
                                        zA = false;
                                        if (zA) {
                                        }
                                    }
                                } catch (URISyntaxException e3) {
                                    e = e3;
                                }
                            }
                            ArrayList arrayList32 = arrayList2;
                            arrayList32.add(rx2VarO);
                            arrayList2 = arrayList32;
                        }
                        map3 = map5;
                        map4 = map;
                    }
                }
            }
        }
        HashMap<String, rx2> map6 = map3;
        ArrayList arrayList4 = arrayList2;
        if (arrayList4.size() < this.d.f && map6 != null && !map6.isEmpty()) {
            if ((this.d.v & 4) != 0) {
                p63.a("JWake", "wakeTargetList less maxWakeCount, but not add local wake list for app not support service wakeup type, app_unsupported_wake_type: " + this.d.v);
                return arrayList4;
            }
            List<String> listK = mx2.k(this.d, new ArrayList(map6.keySet()));
            Collections.shuffle(listK);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str2 : listK) {
                if (map6.containsKey(str2)) {
                    linkedHashMap.put(str2, map6.get(str2));
                }
            }
            Iterator it2 = linkedHashMap.entrySet().iterator();
            while (it2.hasNext() && arrayList4.size() < this.d.f) {
                rx2 rx2Var = (rx2) ((Map.Entry) it2.next()).getValue();
                if (!arrayList4.contains(rx2Var)) {
                    if (map2 == null || !map2.containsKey(rx2Var.f20619a) || (ux2Var = (ux2) map2.get(rx2Var.f20619a)) == null || ux2Var.f21313a != 0) {
                        rx2Var.f = 4;
                        arrayList4.add(rx2Var);
                    } else {
                        p63.a("JWake", "not support any wake type, continue add other to target from local");
                    }
                }
            }
        }
        return arrayList4;
    }

    public final void h() {
        long j = this.d.l;
        long jK = kv2.k(this.c, "JWakeConfigHelper");
        long jCurrentTimeMillis = System.currentTimeMillis();
        p63.a("JWake", "[refeshWakeConfig] currentTimeMillis:" + jCurrentTimeMillis + ",lastBusinessTime:" + jK + ",wakeConfigInterval:" + j);
        if (jCurrentTimeMillis - jK < j) {
            p63.a("JWake", "need not get wake config");
            return;
        }
        kx2 kx2VarJ = j(this.c);
        if (kx2VarJ != null) {
            this.d = kx2VarJ;
        }
        nx2.a(this.c);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f17830a;

        public b(Context context) {
            this.f17830a = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                p63.a("JWake", "unbind wake ServiceConnection");
                this.f17830a.getApplicationContext().unbindService(this);
            } catch (Throwable th) {
                p63.f("JWake", "onServiceConnected throwable" + th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}

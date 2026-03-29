package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.igexin.sdk.PushConsts;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.ac;
import com.vivo.push.util.ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile m f11251a;
    private Context h;
    private String j;
    private Boolean m;
    private Long n;
    private boolean o;
    private int q;
    private long b = -1;
    private long c = -1;
    private long d = -1;
    private long e = -1;
    private long f = -1;
    private long g = -1;
    private boolean i = true;
    private SparseArray<a> k = new SparseArray<>();
    private int l = 0;
    private IPushClientFactory p = new l();

    private m() {
    }

    public static List<String> c() {
        String strG = com.vivo.push.restructure.a.a().e().g();
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(strG)) {
                return arrayList;
            }
            Iterator<String> itKeys = new JSONObject(strG).keys();
            while (itKeys.hasNext()) {
                arrayList.add(itKeys.next());
            }
        } catch (JSONException unused) {
            com.vivo.push.restructure.a.a().e().h();
            arrayList.clear();
            com.vivo.push.util.t.d("PushClientManager", "getTags error");
        }
        return arrayList;
    }

    private boolean l() {
        if (this.m == null) {
            this.m = Boolean.valueOf(k() >= 1230 && ag.d(this.h));
        }
        return this.m.booleanValue();
    }

    public final boolean d() {
        if (this.h == null) {
            com.vivo.push.util.t.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean boolValueOf = Boolean.valueOf(l());
        this.m = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public final void e() {
        this.j = null;
        com.vivo.push.restructure.a.a().e().j();
    }

    public final boolean f() {
        return this.o;
    }

    public final boolean g() {
        return this.i;
    }

    public final Context h() {
        return this.h;
    }

    public final String i() {
        return this.j;
    }

    public final int j() {
        return this.q;
    }

    public final long k() {
        Context context = this.h;
        if (context == null) {
            return -1L;
        }
        if (this.n == null) {
            this.n = Long.valueOf(ag.a(context));
        }
        return this.n.longValue();
    }

    public static synchronized m a() {
        if (f11251a == null) {
            f11251a = new m();
        }
        return f11251a;
    }

    public final void b() throws VivoPushException {
        Context context = this.h;
        if (context != null) {
            ag.b(context);
        }
    }

    public static void b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String strG = com.vivo.push.restructure.a.a().e().g();
            if (TextUtils.isEmpty(strG)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strG);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.remove(it.next());
            }
            String string = jSONObject.toString();
            if (TextUtils.isEmpty(string)) {
                com.vivo.push.restructure.a.a().e().h();
            } else {
                com.vivo.push.restructure.a.a().e().d(string);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            com.vivo.push.restructure.a.a().e().h();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IPushActionListener f11252a;
        private com.vivo.push.b.c b;
        private IPushActionListener c;
        private Runnable d;
        private Object[] e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.b = cVar;
            this.f11252a = iPushActionListener;
        }

        public final void a(int i, Object... objArr) {
            this.e = objArr;
            IPushActionListener iPushActionListener = this.c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i);
            }
            IPushActionListener iPushActionListener2 = this.f11252a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i);
            }
        }

        public final Object[] b() {
            return this.e;
        }

        public final void a(Runnable runnable) {
            this.d = runnable;
        }

        public final void a() {
            Runnable runnable = this.d;
            if (runnable == null) {
                com.vivo.push.util.t.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.c = iPushActionListener;
        }
    }

    public final synchronized void a(Context context) {
        if (this.h == null) {
            this.h = ContextDelegate.getContext(context);
            this.o = com.vivo.push.util.z.c(context, context.getPackageName());
            ac.c().a(this.h);
            a(new com.vivo.push.b.g());
            this.j = com.vivo.push.restructure.a.a().e().i();
        }
    }

    public final void c(List<String> list) {
        if (list.contains(this.j)) {
            e();
        }
    }

    public static void a(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String strG = com.vivo.push.restructure.a.a().e().g();
            if (TextUtils.isEmpty(strG)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strG);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.put(it.next(), System.currentTimeMillis());
            }
            String string = jSONObject.toString();
            if (TextUtils.isEmpty(string)) {
                com.vivo.push.restructure.a.a().e().h();
            } else {
                com.vivo.push.restructure.a.a().e().d(string);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            com.vivo.push.restructure.a.a().e().h();
        }
    }

    public final void c(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        t.a(new RunnableC1322r(this, str));
    }

    public final void b(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 11);
    }

    public final void b(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.j)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (str.length() > 70) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(PushConsts.ALIAS_REQUEST_FILTER);
                return;
            }
            return;
        }
        if (!a(this.e)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.e = SystemClock.elapsedRealtime();
        String strA = a(new a(aVar, iPushActionListener));
        aVar.b(strA);
        a(aVar);
        c(strA);
    }

    public final void a(boolean z) {
        this.i = z;
    }

    public final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
                return;
            }
            return;
        }
        com.vivo.push.restructure.a.a().h().b();
        if (!a(this.b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.b = SystemClock.elapsedRealtime();
        String packageName = this.h.getPackageName();
        a aVarA = null;
        if (this.h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
            bVar.e();
            bVar.c(str);
            bVar.d(str2);
            bVar.b(100);
            if (!this.o || l()) {
                aVarA = a(bVar, iPushActionListener);
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(101);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVarA == null) {
            return;
        }
        aVarA.a(new n(this, aVarA, str, str2));
        aVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a b(String str) {
        if (str != null) {
            try {
                int i = Integer.parseInt(str);
                a aVar = this.k.get(i);
                this.k.delete(i);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void b(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.g)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.g = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20002);
                return;
            }
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20003);
                    return;
                }
                return;
            }
        }
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20001);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, this.h.getPackageName(), arrayList);
        zVar.b(500);
        zVar.c(str);
        zVar.d(str2);
        String strA = a(new a(zVar, iPushActionListener));
        zVar.b(strA);
        a(zVar);
        c(strA);
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        a aVar = new a(bVar, iPushActionListener);
        String strA = a(aVar);
        bVar.b(strA);
        aVar.a(new o(this, bVar, strA));
        return aVar;
    }

    private void a(IPushActionListener iPushActionListener, String str, String str2, int i) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
            }
        } else if (!a(this.c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.c = SystemClock.elapsedRealtime();
            a aVarA = a(iPushActionListener, this.h.getPackageName(), str, str2, i);
            if (aVarA == null) {
                return;
            }
            aVarA.a(new p(this));
            aVarA.a();
        }
    }

    private a a(IPushActionListener iPushActionListener, String str, String str2, String str3, int i) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            return null;
        }
        com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, str);
        bVar.c(str2);
        bVar.d(str3);
        if (i > 0) {
            bVar.a(i);
        }
        bVar.e();
        bVar.b(100);
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
                return null;
            }
            a aVar = new a(bVar, iPushActionListener);
            String strA = a(aVar);
            bVar.b(strA);
            aVar.a(new q(this, bVar, strA));
            return aVar;
        }
        if (bVar.a(this.h) == 2) {
            return a(bVar, iPushActionListener);
        }
        return a(bVar, iPushActionListener);
    }

    public final void a(String str, int i, Object... objArr) {
        a aVarB = b(str);
        if (aVarB != null) {
            aVarB.a(i, objArr);
        } else {
            com.vivo.push.util.t.d("PushClientManager", "notifyApp token is null");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0082 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (!com.vivo.push.restructure.a.a().g().f()) {
            boolean z = false;
            if (TextUtils.isEmpty(this.j) || !this.j.equals(str)) {
                if (str.length() <= 70) {
                    if (this.o) {
                        if (l()) {
                            if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                                if (iPushActionListener != null) {
                                    iPushActionListener.onStateChanged(30001);
                                }
                            }
                        } else if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                        }
                    }
                    if (z) {
                        return;
                    }
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(PushConsts.ALIAS_REQUEST_FILTER);
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
            z = true;
            if (z) {
            }
        }
        if (!a(this.d)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.d = SystemClock.elapsedRealtime();
        String strA = a(new a(aVar, iPushActionListener));
        aVar.b(strA);
        a(aVar);
        c(strA);
    }

    private static boolean a(long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return j == -1 || jElapsedRealtime <= j || jElapsedRealtime >= j + 2000;
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    public final void a(String str) {
        this.j = str;
        com.vivo.push.restructure.a.a().e().e(str);
    }

    public final void a(String str, int i) {
        a aVarB = b(str);
        if (aVarB != null) {
            aVarB.a(i, new Object[0]);
        } else {
            com.vivo.push.util.t.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(a aVar) {
        int i;
        this.k.put(this.l, aVar);
        i = this.l;
        this.l = i + 1;
        return Integer.toString(i);
    }

    public final void a(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20002);
                return;
            }
            return;
        }
        if (arrayList.size() + c().size() > 500) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20004);
                return;
            }
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20003);
                    return;
                }
                return;
            }
        }
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20001);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, this.h.getPackageName(), arrayList);
        zVar.b(500);
        zVar.c(str);
        zVar.d(str2);
        String strA = a(new a(zVar, iPushActionListener));
        zVar.b(strA);
        a(zVar);
        c(strA);
    }

    public final int a(Intent intent, PushMessageCallback pushMessageCallback) {
        v vVarCreateReceiverCommand = this.p.createReceiverCommand(intent);
        Context context = a().h;
        if (vVarCreateReceiverCommand == null) {
            com.vivo.push.util.t.a("PushClientManager", "sendCommand, null command!");
            if (context == null) {
                return 2805;
            }
            com.vivo.push.util.t.c(context, "[执行指令失败]指令空！");
            return 2805;
        }
        com.vivo.push.g.aa aaVarCreateReceiveTask = this.p.createReceiveTask(vVarCreateReceiverCommand);
        if (aaVarCreateReceiveTask == null) {
            com.vivo.push.util.t.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(vVarCreateReceiverCommand)));
            if (context == null) {
                return 2806;
            }
            com.vivo.push.util.t.c(context, "[执行指令失败]指令" + vVarCreateReceiverCommand + "任务空！");
            return 2806;
        }
        if (context != null && !(vVarCreateReceiverCommand instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.t.a(context, "[接收指令]".concat(String.valueOf(vVarCreateReceiverCommand)));
        }
        aaVarCreateReceiveTask.a(pushMessageCallback);
        aaVarCreateReceiveTask.run();
        return aaVarCreateReceiveTask.c();
    }

    public final void a(v vVar) {
        Context context = a().h;
        if (vVar == null) {
            com.vivo.push.util.t.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.t.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        s sVarCreateTask = this.p.createTask(vVar);
        if (sVarCreateTask == null) {
            com.vivo.push.util.t.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(vVar)));
            if (context != null) {
                com.vivo.push.util.t.c(context, "[执行指令失败]指令" + vVar + "任务空！");
                return;
            }
            return;
        }
        com.vivo.push.util.t.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(vVar)));
        t.a(sVarCreateTask);
    }
}

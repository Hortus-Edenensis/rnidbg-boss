package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.az;
import com.wft.caller.trans.EmptyActivity;
import com.wft.caller.trans.EnhActivity;
import com.wft.caller.trans.TransActivity;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1144a;
    public Application b;
    public sp2 c;
    public xw6 d;
    public c27 e;
    public s87 f;
    public e27 g;
    public Application.ActivityLifecycleCallbacks i;
    public BlockingQueue<String> h = new PriorityBlockingQueue();
    public Map<String, Integer> k = new HashMap();
    public Map<String, List<String>> l = new HashMap();
    public Map<Integer, Integer> m = new HashMap();
    public c j = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class b implements eo6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1146a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.f1146a = str;
            this.b = str2;
        }

        @Override // defpackage.eo6
        public void onError(Exception exc) {
            yw6.a("packageName : " + this.f1146a + ", report fail : " + this.b + ", reason : " + exc.getMessage());
        }

        @Override // defpackage.eo6
        public void onSuccess(Object obj) {
            if (obj == null || !(obj instanceof String)) {
                return;
            }
            yw6.a("packageName : " + this.f1146a + ", " + ((String) obj));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends Handler {
        public c() {
        }

        public void a() {
            if (hasMessages(102)) {
                return;
            }
            sendEmptyMessageDelayed(102, 3000L);
        }

        public void b(String str) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.what = 103;
            messageObtainMessage.obj = str;
            sendMessageDelayed(messageObtainMessage, 1000L);
        }

        public void c() {
            removeMessages(102);
        }

        public void d() {
            if (hasMessages(101)) {
                removeMessages(101);
            }
            sendEmptyMessageDelayed(101, 20000L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    Object obj = message.obj;
                    if (obj != null && (obj instanceof String) && a37.this.d != null) {
                        a37.this.o((String) message.obj, 1);
                        break;
                    }
                    break;
                case 101:
                    a37.this.r();
                    break;
                case 102:
                    int iH = a37.this.e.h();
                    if (iH == 0) {
                        a37.this.e.i(4);
                        a37.this.b.unregisterActivityLifecycleCallbacks(a37.this.i);
                        break;
                    } else if (2 == iH && a37.this.c != null) {
                        String strL = a37.this.e.l();
                        if (!TextUtils.isEmpty(strL)) {
                            a37.this.c.d(strL);
                        }
                        break;
                    }
                    break;
                case 103:
                    Object obj2 = message.obj;
                    if (obj2 != null && (obj2 instanceof String)) {
                        String str = (String) obj2;
                        if (a37.this.s(str) && a37.this.c != null) {
                            a37.this.c.c(str);
                            break;
                        }
                    }
                    break;
                case 104:
                    Object obj3 = message.obj;
                    if (obj3 != null && (obj3 instanceof String)) {
                        String str2 = (String) obj3;
                        if (a37.this.s(str2)) {
                            if (a37.this.c == null) {
                            }
                        } else if (!na7.n(a37.this.f1144a.getApplicationContext()) || !na7.i(a37.this.f1144a.getApplicationContext(), str2) || a37.this.c == null) {
                        }
                        a37.this.c.a(str2);
                        break;
                    }
                    break;
            }
        }
    }

    public a37(Context context) {
        this.f1144a = context;
        this.e = new c27(context);
        this.f = new s87(context);
        e27 e27Var = new e27(this.f1144a, this.j, this.h);
        this.g = e27Var;
        e27Var.start();
    }

    public static boolean u(String str) throws Throwable {
        LineNumberReader lineNumberReader;
        InputStreamReader inputStreamReader = null;
        try {
            InputStreamReader inputStreamReader2 = new InputStreamReader(Runtime.getRuntime().exec("ps").getInputStream());
            try {
                lineNumberReader = new LineNumberReader(inputStreamReader2);
                String line = "";
                while (line != null) {
                    try {
                        line = lineNumberReader.readLine();
                        if (line != null && line.contains(str)) {
                            inputStreamReader2.close();
                            lineNumberReader.close();
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader = inputStreamReader2;
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (lineNumberReader != null) {
                            lineNumberReader.close();
                        }
                        throw th;
                    }
                }
                inputStreamReader2.close();
                lineNumberReader.close();
                return false;
            } catch (Throwable th2) {
                th = th2;
                lineNumberReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            lineNumberReader = null;
        }
    }

    public void b() {
        f("com.snda.wifilocating");
    }

    public void c(sp2 sp2Var) {
        this.c = sp2Var;
        if (sp2Var != null) {
            m();
        }
    }

    public void d(xw6 xw6Var) {
        this.d = xw6Var;
    }

    public final void f(String str) {
        if (na7.k(this.f1144a)) {
            return;
        }
        this.h.add(str);
    }

    public final void g(String str, String str2, String str3) {
        if (na7.k(this.f1144a)) {
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(str, str2));
            intent.addFlags(268435456);
            intent.putExtra(az.at, this.f1144a.getApplicationContext().getPackageName());
            intent.putExtra("version", na7.l(this.f1144a));
            ax6.a(this.f1144a, intent);
            return;
        }
        String str4 = str3 + this.f1144a.getApplicationContext().getPackageName();
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(str4));
        if (!TextUtils.isEmpty(str2)) {
            intent2.setClassName(str, str2);
        }
        intent2.addFlags(268435456);
        intent2.putExtra(az.at, this.f1144a.getApplicationContext().getPackageName());
        intent2.putExtra("version", na7.l(this.f1144a));
        ax6.a(this.f1144a, intent2);
    }

    public final void h(String str, List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2)) {
                new ma7(str2, new b(str, str2)).q();
            }
        }
    }

    public void i(boolean z) {
        List<qu2> listA;
        xw6 xw6Var = this.d;
        if (xw6Var == null || (listA = xw6Var.a()) == null || listA.size() <= 0) {
            return;
        }
        for (qu2 qu2Var : listA) {
            String strE = qu2Var.e();
            String packageName = this.f1144a.getPackageName();
            if (!TextUtils.isEmpty(strE) && !strE.equalsIgnoreCase(packageName)) {
                if (this.f.h(strE) < (qu2Var.i() == 0 ? 1 : qu2Var.i())) {
                    this.k.put(strE, Integer.valueOf(qu2Var.d()));
                    this.l.put(strE, qu2Var.f());
                    int iJ = qu2Var.j();
                    if (k(strE, iJ)) {
                        if (iJ == 0) {
                            l(strE, qu2Var.c(), qu2Var.g(), qu2Var.h());
                            o(strE, 3);
                            this.j.b(strE);
                        } else if (iJ != 1) {
                            if (iJ == 2 && z) {
                                try {
                                    g(strE, qu2Var.a(), qu2Var.b());
                                    o(strE, 1);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                try {
                                    Thread.sleep(3000L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } else if (z) {
                            f(strE);
                        }
                    }
                }
            }
        }
    }

    public final boolean k(String str, int i) {
        if (!na7.e(this.f1144a, str)) {
            return false;
        }
        if (i == 1) {
            if (p(str)) {
                return false;
            }
        } else if (i == 0) {
            if (s(str)) {
                return false;
            }
        } else if (i == 2 && s(str)) {
            return false;
        }
        return true;
    }

    public final boolean l(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return false;
        }
        yw6.a("startService packageName : " + str + ", actionName : " + str2 + ", serviceName : " + str3);
        try {
            Intent intent = new Intent();
            if (TextUtils.isEmpty(str3)) {
                intent.setPackage(str);
            } else {
                intent.setComponent(new ComponentName(str, str3));
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.setAction(str2);
            }
            if (!TextUtils.isEmpty(str4)) {
                intent.putExtra(str4, this.f1144a.getPackageName());
            }
            if (!"from".equalsIgnoreCase(str4)) {
                intent.putExtra("from", this.f1144a.getPackageName());
            }
            intent.putExtra(az.at, this.f1144a.getApplicationContext().getPackageName());
            intent.putExtra("version", na7.l(this.f1144a));
            if (na7.d(this.f1144a, intent)) {
                this.f1144a.startService(intent);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public final void m() {
        try {
            Application application = (Application) this.f1144a;
            this.b = application;
            if (application == null) {
                return;
            }
            this.j.a();
            a aVar = new a();
            this.i = aVar;
            this.b.registerActivityLifecycleCallbacks(aVar);
        } catch (Exception unused) {
        }
    }

    public final void o(String str, int i) {
        yw6.a("wake up success : " + str + " by " + i);
        this.f.j(str, this.f.h(str) + 1);
        Integer num = this.k.get(str);
        if (num != null) {
            this.m.put(num, 1);
            this.j.d();
        }
        h(str, this.l.get(str));
        sp2 sp2Var = this.c;
        if (sp2Var != null) {
            sp2Var.b(str, i);
        }
    }

    public final boolean p(String str) {
        try {
            int i = this.f1144a.getContentResolver().call(Uri.parse("content://" + str + ".wft.provider/share"), "Query", this.f1144a.getPackageName(), (Bundle) null).getInt("id");
            StringBuilder sb = new StringBuilder();
            sb.append("Query method by provider result is ");
            sb.append(i);
            yw6.a(sb.toString());
            if (i != 100) {
                return true;
            }
            o(str, 2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void r() {
        new m47(this.f1144a, bx6.a(this.f1144a), this.m, null).q();
    }

    public final boolean s(String str) {
        try {
            return u(str);
        } catch (IOException | Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            yw6.a("activity " + activity.getLocalClassName() + " is created");
            int iH = a37.this.e.h();
            if (((activity instanceof EmptyActivity) || (activity instanceof TransActivity) || (activity instanceof EnhActivity)) && iH == 0) {
                a37.this.e.i(1);
                Intent intent = activity.getIntent();
                String stringExtra = intent != null ? intent.getStringExtra("from_packageName") : "";
                a37.this.e.k(stringExtra);
                if (a37.this.c != null) {
                    a37.this.c.d(stringExtra);
                }
                a37.this.j.c();
            }
            a37.this.b.unregisterActivityLifecycleCallbacks(a37.this.i);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}

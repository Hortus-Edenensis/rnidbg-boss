package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class xw6 {
    public static String h = ",";
    public static String i = "&";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f22071a;
    public c27 b;
    public s87 c;
    public b d;
    public List<qu2> e;
    public c f;
    public eo6<jx3> g = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements eo6<jx3> {
        public a() {
        }

        @Override // defpackage.eo6
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(jx3 jx3Var) {
            xw6.this.c(jx3Var);
        }

        @Override // defpackage.eo6
        public void onError(Exception exc) {
            yw6.b("request config err : " + exc.getMessage());
            xw6.this.b(180000L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<xw6> f22073a;

        public b(Looper looper, xw6 xw6Var) {
            super(looper);
            this.f22073a = new WeakReference<>(xw6Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f22073a.get() != null && message.what == 0 && xw6.this.j()) {
                xw6.this.k();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void b();
    }

    public xw6(Context context, c cVar) {
        this.f22071a = context;
        this.f = cVar;
        this.b = new c27(context);
        this.c = new s87(context);
        HandlerThread handlerThread = new HandlerThread(xw6.class.getName(), 10);
        handlerThread.start();
        this.d = new b(handlerThread.getLooper(), this);
        b(0L);
    }

    public List<qu2> a() {
        return this.e;
    }

    public final void b(long j) {
        b bVar = this.d;
        if (bVar != null) {
            Message messageObtainMessage = bVar.obtainMessage();
            messageObtainMessage.what = 0;
            this.d.sendMessageDelayed(messageObtainMessage, j);
        }
    }

    public final void c(jx3 jx3Var) {
        if (this.b == null || jx3Var == null) {
            return;
        }
        int iG = jx3Var.g();
        int iH = jx3Var.h();
        int i2 = jx3Var.i();
        int iO = this.b.o();
        this.b.p(iG);
        this.b.r(iH);
        this.b.m(i2);
        if (i2 != iO) {
            i(jx3Var.e());
            k();
        } else {
            List<qu2> listF = jx3Var.f();
            this.e = listF;
            f(listF);
            l();
        }
    }

    public final void f(List<qu2> list) {
        if (list != null) {
            for (qu2 qu2Var : list) {
                this.c.k(qu2Var.e(), qu2Var.i());
            }
        }
    }

    public final void i(List<se> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (se seVar : list) {
            stringBuffer.append(seVar.b());
            stringBuffer.append(i);
            stringBuffer.append(seVar.a());
            stringBuffer.append(h);
        }
        this.b.n(stringBuffer.toString());
    }

    public final boolean j() {
        if (this.b.w() >= this.b.u()) {
            return false;
        }
        return System.currentTimeMillis() - this.b.v() >= ((long) (((this.b.s() * 60) * 60) * 1000));
    }

    public final void k() {
        new q87(this.f22071a, bx6.a(this.f22071a), this.b.o(), (String[]) m().toArray(new String[0]), this.g).q();
        yw6.a("request config");
    }

    public final void l() {
        this.b.j(System.currentTimeMillis());
        this.b.t(this.b.w() + 1);
        c cVar = this.f;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final List<String> m() {
        String strQ = this.b.q();
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(strQ)) {
            for (String str : strQ.split(h)) {
                String[] strArrSplit = str.split(i);
                if (strArrSplit.length == 2) {
                    String str2 = strArrSplit[0];
                    String str3 = strArrSplit[1];
                    int i2 = this.c.i(str2);
                    int iH = this.c.h(str2);
                    if (na7.e(this.f22071a, str2) && (iH == 0 || iH < i2)) {
                        arrayList.add(str3);
                    }
                }
            }
        }
        return arrayList;
    }
}

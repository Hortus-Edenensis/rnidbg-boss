package ms.bz.bd.c.Pgl;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Display;
import com.bytedance.sdk.component.jk.b.fx;
import com.umeng.analytics.pro.dn;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class r1 {
    public static r1 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerThread f19348a;
    public Context b;
    public boolean c = false;
    public DisplayManager d;
    public pbll e;

    /* JADX INFO: compiled from: SearchBox */
    public class pgla implements Runnable {
        public pgla() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (r1.this.b != null) {
                    r1.this.f19348a.start();
                    Handler handler = new Handler(r1.this.f19348a.getLooper());
                    r1 r1Var = r1.this;
                    r1Var.d = (DisplayManager) r1Var.b.getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b9ec41", new byte[]{119, 50, 5, 7, 7, 39, 120}));
                    if (r1.this.d != null) {
                        Display[] displays = r1.this.d.getDisplays();
                        int length = displays.length;
                        if (length > 1) {
                            q1 q1VarI = q1.i();
                            q1VarI.getClass();
                            String strH = q1.h(displays);
                            String strC = q1.c(displays);
                            q1VarI.j(length);
                            q1VarI.d();
                            if (!TextUtils.isEmpty(strH)) {
                                q1VarI.l(strH);
                            }
                            if (!TextUtils.isEmpty(strC)) {
                                q1VarI.f(strC);
                            }
                        }
                        r1 r1Var2 = r1.this;
                        r1Var2.e = new pbll(r1Var2.d);
                        r1.this.d.registerDisplayListener(r1.this.e, handler);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public r1(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        if (!(applicationContext instanceof Application)) {
            Context contextC = c();
            this.b = contextC == null ? this.b : contextC;
        }
        this.f19348a = new HandlerThread((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2f2d61", new byte[]{dn.l, 87, 114, 34}));
    }

    public static Application c() {
        try {
            return (Application) Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a6d5c1", new byte[]{113, 58, 19, 83, 83, 47, 102, 89, 52, 117, 96, 122, 54, 66, 72, 47, 116, 30, 33, 124, 68, 60, 5, 68, 93, 34})).getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b6f0a5", new byte[]{112, 33, 7, 86, 91, 44, 117, 54, 39, 112, ByteCompanionObject.MAX_VALUE, Base64.padSymbol, 22, 69, 74, 43, 110, 25}), new Class[0]).invoke(null, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static r1 f(Context context) {
        r1 r1Var;
        synchronized (r1.class) {
            if (f == null) {
                f = new r1(context);
            }
            r1Var = f;
        }
        return r1Var;
    }

    public final void finalize() throws Throwable {
        pbll pbllVar;
        synchronized (this) {
            try {
                DisplayManager displayManager = this.d;
                if (displayManager != null && (pbllVar = this.e) != null) {
                    displayManager.unregisterDisplayListener(pbllVar);
                }
            } catch (Throwable unused) {
            }
            HandlerThread handlerThread = this.f19348a;
            if (handlerThread != null) {
                try {
                    handlerThread.quitSafely();
                } catch (Throwable unused2) {
                }
            }
        }
        super.finalize();
    }

    public final synchronized void g() {
        if (this.c) {
            return;
        }
        this.c = true;
        new fx(new pgla(), "z/bd/c/Pgl/r1").start();
    }
}

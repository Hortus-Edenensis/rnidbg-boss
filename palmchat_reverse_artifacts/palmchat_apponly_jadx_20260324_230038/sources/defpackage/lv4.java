package defpackage;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import com.zenmen.palmchat.video.recorder.b;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class lv4 extends Handler {
    public static final String b = "lv4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<b> f19085a;

    public lv4(b bVar) {
        this.f19085a = new WeakReference<>(bVar);
    }

    public void a(Rect rect) {
        sendMessageDelayed(obtainMessage(10, rect), 200L);
    }

    public void b() {
        sendMessage(obtainMessage(4));
    }

    public void c() {
        sendMessage(obtainMessage(3));
    }

    public void d(SurfaceHolder surfaceHolder, boolean z) {
        sendMessage(obtainMessage(0, z ? 1 : 0, 0, surfaceHolder));
    }

    public void e(int i, int i2, int i3) {
        sendMessage(obtainMessage(1, i2, i3));
    }

    public void f() {
        sendMessage(obtainMessage(2));
    }

    public void g(int i) {
        sendMessage(obtainMessage(5, i, 0));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        b bVar = this.f19085a.get();
        if (bVar == null) {
            Log.w(b, "RenderHandler.handleMessage: weak ref is null");
            return;
        }
        switch (i) {
            case 0:
                bVar.u((SurfaceHolder) message.obj, message.arg1 != 0);
                return;
            case 1:
                bVar.v(message.arg1, message.arg2);
                return;
            case 2:
                bVar.w();
                return;
            case 3:
                bVar.t();
                return;
            case 4:
                bVar.e();
                return;
            case 5:
                bVar.s(message.arg1);
                return;
            case 6:
                bVar.r(message.arg1);
                return;
            case 7:
                bVar.q(message.arg1);
                return;
            case 8:
                bVar.p(message.arg1, message.arg2);
                return;
            case 9:
                bVar.b();
                return;
            case 10:
                bVar.i((Rect) message.obj);
                return;
            default:
                throw new RuntimeException("unknown message " + i);
        }
    }
}

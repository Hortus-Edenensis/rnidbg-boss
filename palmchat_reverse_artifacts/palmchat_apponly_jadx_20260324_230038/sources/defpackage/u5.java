package defpackage;

import android.app.Activity;
import android.view.Choreographer;
import android.view.ViewTreeObserver;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class u5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21134a = false;
    public c b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: u5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class ChoreographerFrameCallbackC1277a implements Choreographer.FrameCallback {
            public ChoreographerFrameCallbackC1277a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                LogUtil.i("ActivityUIReadyHelper", "doFrame  hasReady=" + u5.this.f21134a);
                if (u5.this.f21134a) {
                    return;
                }
                u5.this.e();
            }
        }

        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            u5.this.f();
            if (u5.this.f21134a) {
                return;
            }
            Choreographer.getInstance().postFrameCallback(new ChoreographerFrameCallbackC1277a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ViewTreeObserver.OnWindowFocusChangeListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            LogUtil.i("ActivityUIReadyHelper", "onWindowFocusChanged hasFocus=" + z + " hasReady=" + u5.this.f21134a);
            if (z) {
                u5.this.f();
            }
            if (!z || u5.this.f21134a) {
                return;
            }
            u5.this.e();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();

        void b();
    }

    public u5(c cVar) {
        this.b = cVar;
    }

    public void d(Activity activity) {
        activity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(new a());
        activity.getWindow().getDecorView().getViewTreeObserver().addOnWindowFocusChangeListener(new b());
    }

    public final void e() {
        LogUtil.i("ActivityUIReadyHelper", " onReady!!!!!!");
        this.f21134a = true;
        c cVar = this.b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void f() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.b();
        }
    }
}

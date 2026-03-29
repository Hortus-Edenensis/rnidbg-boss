package defpackage;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class e03 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f17186a;
    public WeakReference<Activity> b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17187a = -1;
        public int b = 0;
        public Rect c = new Rect();
        public boolean d = false;
        public final /* synthetic */ View e;

        public a(View view) {
            this.e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.c.setEmpty();
            this.e.getWindowVisibleDisplayFrame(this.c);
            int iHeight = this.c.height();
            if (this.b == 0) {
                this.b = iHeight;
            }
            int height = this.e.getHeight();
            int i = this.b - iHeight;
            if (this.f17187a != i) {
                boolean z = ((((float) iHeight) * 1.0f) / ((float) height)) * 1.0f < 0.75f;
                if (z != this.d) {
                    e03.this.f17186a.a(i, z);
                    this.d = z;
                }
            }
            this.f17187a = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(int i, boolean z);
    }

    public e03(Activity activity, b bVar) {
        this.b = new WeakReference<>(activity);
        this.f17186a = bVar;
    }

    public static void b(Activity activity, b bVar) {
        new e03(activity, bVar).c();
    }

    public void c() {
        Activity activity;
        if (this.f17186a == null || (activity = this.b.get()) == null) {
            return;
        }
        d(this.f17186a);
        View decorView = activity.getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(decorView));
    }

    public void d(b bVar) {
        this.f17186a = bVar;
    }
}

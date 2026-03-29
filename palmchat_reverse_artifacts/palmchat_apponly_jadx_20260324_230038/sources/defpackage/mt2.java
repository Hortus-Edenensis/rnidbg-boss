package defpackage;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class mt2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f19362a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19363a = -1;
        public int b = 0;
        public int c = 0;
        public int d = 0;
        public final /* synthetic */ View e;
        public final /* synthetic */ Activity f;

        public a(View view, Activity activity) {
            this.e = view;
            this.f = activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.e.getWindowVisibleDisplayFrame(rect);
            int height = this.e.getRootView().getHeight();
            int i = rect.bottom;
            int i2 = i - rect.top;
            if (this.c == 0) {
                this.c = i2;
            }
            if (this.d == 0) {
                this.d = i;
            }
            int iAbs = Math.abs(i - this.d);
            this.d = rect.bottom;
            if (this.b != iAbs && height > 0 && (iAbs * 1.0f) / height > 0.2f) {
                this.b = iAbs;
                r75.p(this.f, "soft_input_height_b", iAbs);
            }
            int i3 = this.c - i2;
            if (this.f19363a != i3) {
                c cVar = mt2.this.f19362a;
                if (cVar != null) {
                    cVar.onSoftKeyboardStatusChanged(1 ^ (((double) i3) / ((double) height) > 0.2d ? 1 : 0), i3);
                }
                this.f19363a = i3;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f19364a;
        public final /* synthetic */ c b;

        public b(Activity activity, c cVar) {
            this.f19364a = activity;
            this.b = cVar;
        }

        @Override // mt2.c
        public void onSoftKeyboardStatusChanged(int i, int i2) {
            if (i == 0) {
                r75.p(this.f19364a, "soft_input_height_n2", i2);
            }
            c cVar = this.b;
            if (cVar != null) {
                cVar.onSoftKeyboardStatusChanged(i, i2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void onSoftKeyboardStatusChanged(int i, int i2);
    }

    public mt2(Activity activity, c cVar) {
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            return;
        }
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(decorView, activity));
        this.f19362a = new b(activity, cVar);
    }

    public static void a(Activity activity, c cVar) {
        new mt2(activity, cVar);
    }
}

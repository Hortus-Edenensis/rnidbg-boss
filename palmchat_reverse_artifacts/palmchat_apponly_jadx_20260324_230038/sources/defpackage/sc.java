package defpackage;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f20710a;
    public int b;
    public FrameLayout.LayoutParams c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            sc.this.d();
        }
    }

    public sc(Activity activity) {
        View childAt = ((FrameLayout) activity.findViewById(R.id.content)).getChildAt(0);
        this.f20710a = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.c = (FrameLayout.LayoutParams) this.f20710a.getLayoutParams();
    }

    public static void b(Activity activity) {
        new sc(activity);
    }

    public final int c() {
        Rect rect = new Rect();
        this.f20710a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    public final void d() {
        int iC = c();
        if (iC != this.b) {
            int height = this.f20710a.getRootView().getHeight();
            int i = height - iC;
            if (i > height / 4) {
                this.c.height = (height - i) + me1.h(this.f20710a.getContext());
            } else {
                this.c.height = height;
            }
            this.f20710a.requestLayout();
            this.b = iC;
        }
    }
}

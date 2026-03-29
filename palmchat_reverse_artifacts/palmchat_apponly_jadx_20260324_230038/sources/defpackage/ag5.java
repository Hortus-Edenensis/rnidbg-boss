package defpackage;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ag5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f1227a;
    public FrameLayout.LayoutParams b;
    public int c;
    public int d = 0;
    public int e = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f1228a;
        public final /* synthetic */ Activity b;

        public a(FrameLayout frameLayout, Activity activity) {
            this.f1228a = frameLayout;
            this.b = activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f1228a.getRootView().getHeight();
            int height = this.f1228a.getHeight();
            int iG = ag5.this.g();
            if (iG != ag5.this.d) {
                ag5.this.d = iG;
                int i = height - iG;
                if (Build.VERSION.SDK_INT >= 24 && this.b.isInMultiWindowMode()) {
                    if (i > 0) {
                        ag5.this.j(height - i);
                        return;
                    } else {
                        ag5.this.j(-1);
                        return;
                    }
                }
                if (i <= height / 4) {
                    ag5.this.j(-1);
                } else {
                    ag5 ag5Var = ag5.this;
                    ag5Var.j((height - i) + ag5Var.c);
                }
            }
        }
    }

    public ag5(Activity activity) {
        this.c = 0;
        this.c = i(activity);
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
        View childAt = frameLayout.getChildAt(0);
        this.f1227a = childAt;
        this.b = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        this.f1227a.getViewTreeObserver().addOnGlobalLayoutListener(new a(frameLayout, activity));
    }

    public static void f(Activity activity) {
        new ag5(activity);
    }

    public static int h(Context context, String str) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier(str, "dimen", "android"));
    }

    public static int i(Activity activity) {
        return h(activity, "status_bar_height");
    }

    public final int g() {
        Rect rect = new Rect();
        this.f1227a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    public final void j(int i) {
        FrameLayout.LayoutParams layoutParams = this.b;
        if (layoutParams.height != i) {
            layoutParams.height = i;
            this.f1227a.requestLayout();
        }
    }
}

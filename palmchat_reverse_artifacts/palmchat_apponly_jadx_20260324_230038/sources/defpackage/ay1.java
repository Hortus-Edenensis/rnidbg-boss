package defpackage;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.core.view.ViewCompat;
import com.zenmen.media.roomchat.floatingview.EnFloatingView;
import com.zenmen.media.roomchat.floatingview.FloatingMagnetView;
import com.zenmen.palmchat.R;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ay1 {
    public static volatile ay1 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FloatingMagnetView f1606a;
    public WeakReference<FrameLayout> b;

    @LayoutRes
    public int c = R.layout.manychats_en_floating_view;

    @DrawableRes
    public int d = R.drawable.manychats_icon_phone;
    public ViewGroup.LayoutParams e = n();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ay1.this.f1606a == null) {
                return;
            }
            if (ViewCompat.isAttachedToWindow(ay1.this.f1606a) && ay1.this.m() != null) {
                ay1.this.m().removeView(ay1.this.f1606a);
            }
            ay1.this.f1606a = null;
        }
    }

    public static ay1 k() {
        if (f == null) {
            synchronized (ay1.class) {
                if (f == null) {
                    f = new ay1();
                }
            }
        }
        return f;
    }

    public ay1 d() {
        j();
        return this;
    }

    public final void e(View view) {
        if (m() == null) {
            return;
        }
        m().addView(view);
    }

    public ay1 f(Activity activity) {
        g(l(activity));
        return this;
    }

    public ay1 g(FrameLayout frameLayout) {
        FloatingMagnetView floatingMagnetView;
        if (frameLayout == null || (floatingMagnetView = this.f1606a) == null) {
            this.b = new WeakReference<>(frameLayout);
            return this;
        }
        if (floatingMagnetView.getParent() == frameLayout) {
            return this;
        }
        if (m() != null && this.f1606a.getParent() == m()) {
            m().removeView(this.f1606a);
        }
        this.b = new WeakReference<>(frameLayout);
        frameLayout.addView(this.f1606a);
        return this;
    }

    public ay1 h(Activity activity) {
        i(l(activity));
        return this;
    }

    public ay1 i(FrameLayout frameLayout) {
        FloatingMagnetView floatingMagnetView = this.f1606a;
        if (floatingMagnetView != null && frameLayout != null && ViewCompat.isAttachedToWindow(floatingMagnetView)) {
            frameLayout.removeView(this.f1606a);
        }
        if (m() == frameLayout) {
            this.b = null;
        }
        return this;
    }

    public final void j() {
        synchronized (this) {
            if (this.f1606a != null) {
                return;
            }
            EnFloatingView enFloatingView = new EnFloatingView(gm1.a(), this.c);
            this.f1606a = enFloatingView;
            enFloatingView.setLayoutParams(this.e);
            enFloatingView.setIconImage(this.d);
            e(enFloatingView);
        }
    }

    public final FrameLayout l(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            return (FrameLayout) activity.getWindow().getDecorView().findViewById(android.R.id.content);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final FrameLayout m() {
        WeakReference<FrameLayout> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final FrameLayout.LayoutParams n() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388691;
        layoutParams.setMargins(13, layoutParams.topMargin, layoutParams.rightMargin, 500);
        return layoutParams;
    }

    public ay1 o(yb3 yb3Var) {
        FloatingMagnetView floatingMagnetView = this.f1606a;
        if (floatingMagnetView != null) {
            floatingMagnetView.setMagnetViewListener(yb3Var);
        }
        return this;
    }

    public ay1 p() {
        new Handler(Looper.getMainLooper()).post(new a());
        return this;
    }
}

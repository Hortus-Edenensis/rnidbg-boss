package defpackage;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ru4 {
    void a(MotionEvent motionEvent);

    void b(x35 x35Var);

    void c(boolean z);

    ValueAnimator.AnimatorUpdateListener d(int i);

    void e(int i, int i2, int i3);

    boolean f();

    void g(wu4 wu4Var, View view, View view2);

    @NonNull
    View getView();

    @NonNull
    View h();

    boolean i();
}

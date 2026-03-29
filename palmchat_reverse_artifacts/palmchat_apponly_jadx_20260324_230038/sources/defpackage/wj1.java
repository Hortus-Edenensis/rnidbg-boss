package defpackage;

import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import com.daasuu.ei.Ease;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class wj1 implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ease f21724a;

    public wj1(@NonNull Ease ease) {
        this.f21724a = ease;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return xj1.a(this.f21724a, f);
    }
}

package defpackage;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class kf6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f18682a;
    public int b;
    public int c;

    public kf6(View view) {
        this.f18682a = view;
    }

    public boolean a(int i) {
        if (!b() || this.b == i) {
            return false;
        }
        this.b = i;
        c(true);
        return true;
    }

    public final boolean b() {
        View view = this.f18682a;
        return view != null && view.getVisibility() == 0;
    }

    public final void c(boolean z) {
        if (z) {
            View view = this.f18682a;
            ViewCompat.offsetTopAndBottom(view, this.b - view.getTop());
        } else {
            View view2 = this.f18682a;
            ViewCompat.offsetLeftAndRight(view2, this.c - view2.getLeft());
        }
    }
}

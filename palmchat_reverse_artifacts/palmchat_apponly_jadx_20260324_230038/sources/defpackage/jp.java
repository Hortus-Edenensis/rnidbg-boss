package defpackage;

import android.content.Context;
import android.widget.Scroller;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class jp extends Scroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18460a;

    public jp(Context context) {
        super(context);
        this.f18460a = 800;
    }

    public void a(int i) {
        this.f18460a = i;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.f18460a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.f18460a);
    }
}

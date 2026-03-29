package defpackage;

import android.content.Context;
import android.widget.Scroller;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a45 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends a45 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Scroller f1149a;

        public a(Context context) {
            this.f1149a = new Scroller(context);
        }

        @Override // defpackage.a45
        public boolean a() {
            return this.f1149a.computeScrollOffset();
        }

        @Override // defpackage.a45
        public void b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            this.f1149a.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        @Override // defpackage.a45
        public void c(boolean z) {
            this.f1149a.forceFinished(z);
        }

        @Override // defpackage.a45
        public int d() {
            return this.f1149a.getCurrX();
        }

        @Override // defpackage.a45
        public int e() {
            return this.f1149a.getCurrY();
        }
    }

    public static a45 f(Context context) {
        return new a(context);
    }

    public abstract boolean a();

    public abstract void b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    public abstract void c(boolean z);

    public abstract int d();

    public abstract int e();
}

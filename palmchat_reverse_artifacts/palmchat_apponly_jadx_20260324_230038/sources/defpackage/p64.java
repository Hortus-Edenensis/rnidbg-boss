package defpackage;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class p64 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f19948a;
    public final int b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i, View view);
    }

    public p64(a aVar, int i) {
        this.f19948a = aVar;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f19948a.a(this.b, view);
    }
}

package defpackage;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class cs0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f16906a;
    public long b = 1000;

    public abstract void a();

    public abstract void b();

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f16906a <= this.b) {
            a();
        } else {
            b();
            this.f16906a = jCurrentTimeMillis;
        }
    }
}

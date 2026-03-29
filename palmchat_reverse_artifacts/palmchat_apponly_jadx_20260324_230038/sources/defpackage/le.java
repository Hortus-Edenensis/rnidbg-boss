package defpackage;

import android.content.Context;
import defpackage.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class le {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f18963a;

    public le(Context context) {
        this.f18963a = new z(context);
    }

    public void a(z.b bVar) {
        this.f18963a.d(bVar);
    }

    public void b(boolean z) {
        this.f18963a.e(true);
        if (z) {
            if (this.f18963a.isAlive()) {
                return;
            }
            this.f18963a.start();
        } else if (this.f18963a.isAlive()) {
            this.f18963a.quit();
        }
    }
}

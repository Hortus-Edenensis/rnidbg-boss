package a.a.c.a.c;

import a.a.c.a.a.e;
import android.os.Bundle;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class b extends e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f1109a = false;

    @Override // a.a.c.a.a.e
    public void a(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // a.a.c.a.a.e
    public void a(int i, Bundle bundle) {
        Objects.toString(bundle);
        if (i != 0 || bundle == null) {
            return;
        }
        this.f1109a = bundle.getBoolean("oa_id_limit_state");
    }
}

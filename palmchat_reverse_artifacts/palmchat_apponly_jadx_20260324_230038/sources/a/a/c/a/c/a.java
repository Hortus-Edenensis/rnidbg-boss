package a.a.c.a.c;

import a.a.c.a.a.e;
import android.os.Bundle;
import com.umeng.analytics.pro.bi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class a extends e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f1108a = "";

    @Override // a.a.c.a.a.e
    public void a(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // a.a.c.a.a.e
    public void a(int i, Bundle bundle) {
        if (i != 0 || bundle == null) {
            return;
        }
        this.f1108a = bundle.getString(bi.c.b);
    }
}

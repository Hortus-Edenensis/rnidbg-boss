package defpackage;

import com.zenmen.palmchat.c;
import com.zenmen.palmchat.kotlin.common.SPUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class b66 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1658a;
    public long b;

    public b66() {
        String str = "key_used_tag" + v4.e(c.b());
        this.f1658a = str;
        this.b = SPUtil.f14322a.i(SPUtil.SCENE.APP_COMMON, str, 0L);
    }

    public boolean a(long j) {
        return (this.b & j) == j;
    }

    public void b(long j) {
        long j2 = this.b;
        long j3 = j | j2;
        if (j3 != j2) {
            this.b = j3;
            SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, this.f1658a, Long.valueOf(j3));
        }
    }
}

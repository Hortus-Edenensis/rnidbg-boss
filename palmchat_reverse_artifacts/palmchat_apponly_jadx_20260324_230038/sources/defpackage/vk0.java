package defpackage;

import cn.jiguang.sdk.impl.dnssrv.Name;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class vk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b[] f21463a = new b[17];

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Name f21464a;
        public int b;
        public b c;

        public b() {
        }
    }

    public void a(int i, Name name) {
        if (i > 16383) {
            return;
        }
        int iHashCode = (name.hashCode() & Integer.MAX_VALUE) % 17;
        b bVar = new b();
        bVar.f21464a = name;
        bVar.b = i;
        b[] bVarArr = this.f21463a;
        bVar.c = bVarArr[iHashCode];
        bVarArr[iHashCode] = bVar;
    }

    public int b(Name name) {
        int i = -1;
        for (b bVar = this.f21463a[(name.hashCode() & Integer.MAX_VALUE) % 17]; bVar != null; bVar = bVar.c) {
            if (bVar.f21464a.equals(name)) {
                i = bVar.b;
            }
        }
        return i;
    }
}

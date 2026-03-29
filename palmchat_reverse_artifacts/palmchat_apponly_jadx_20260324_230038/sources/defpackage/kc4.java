package defpackage;

import org.jsoup.nodes.a;
import org.jsoup.nodes.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class kc4 {
    public static final kc4 c = new kc4(false, false);
    public static final kc4 d = new kc4(true, true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18621a;
    public final boolean b;

    public kc4(boolean z, boolean z2) {
        this.f18621a = z;
        this.b = z2;
    }

    public b a(b bVar) {
        if (!this.b) {
            for (a aVar : bVar) {
                aVar.h(aVar.getKey().toLowerCase());
            }
        }
        return bVar;
    }

    public String b(String str) {
        String strTrim = str.trim();
        return !this.f18621a ? strTrim.toLowerCase() : strTrim;
    }
}

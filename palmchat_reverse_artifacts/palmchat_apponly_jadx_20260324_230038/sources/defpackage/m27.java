package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class m27 implements bu6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static bu6 f19132a;
    public static iw6 b;

    public static bu6 b(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (f19132a == null) {
            b = w87.a(context, str);
            f19132a = new m27();
        }
        return f19132a;
    }

    @Override // defpackage.bu6
    public t47 a(y87 y87Var) {
        return l27.a(b.a(l27.b(y87Var)));
    }

    @Override // defpackage.bu6
    public boolean logCollect(String str) {
        return b.logCollect(str);
    }
}

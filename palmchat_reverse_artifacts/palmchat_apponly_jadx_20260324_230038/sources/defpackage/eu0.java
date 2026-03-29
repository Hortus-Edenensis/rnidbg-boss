package defpackage;

import com.google.android.exoplayer2.upstream.b;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class eu0 {
    public static b a(ow4 ow4Var, String str, bt4 bt4Var, int i, Map<String, String> map) {
        return new b.C0361b().i(bt4Var.b(str)).h(bt4Var.f1816a).g(bt4Var.b).f(b(ow4Var, bt4Var)).b(i).e(map).a();
    }

    public static String b(ow4 ow4Var, bt4 bt4Var) {
        String strJ = ow4Var.j();
        return strJ != null ? strJ : bt4Var.b(ow4Var.c.get(0).f16905a).toString();
    }
}

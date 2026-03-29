package defpackage;

import android.content.Context;
import defpackage.bn2;
import defpackage.qp4;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class zo4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22470a = true;

    public static String a(Context context) {
        return r75.i(context, "sp_publish_text_draft");
    }

    public static void b(Context context) {
        r75.o(context, k86.a("sp_first_click_moment_camera"), true);
    }

    public static void c(Context context, String str) {
        r75.r(context, "sp_publish_text_draft", str);
    }

    public static qp4 d(List<String> list, boolean z, int i, qp4.f fVar) {
        qp4 qp4Var = new qp4(list, fVar, z, i);
        qp4Var.m();
        return qp4Var;
    }

    public static qp4 e(List<String> list, boolean z, int i, qp4.f fVar, int i2) {
        qp4 qp4Var = new qp4(list, fVar, z, i);
        qp4Var.l(i2);
        qp4Var.m();
        return qp4Var;
    }

    public static qp4 f(List<String> list, boolean z, int i, int i2, qp4.f fVar, bn2.d dVar) {
        qp4 qp4Var = new qp4(list, fVar, z, i, dVar);
        qp4Var.l(i2);
        qp4Var.m();
        return qp4Var;
    }

    public static qp4 g(List<String> list, boolean z, int i, qp4.f fVar, bn2.d dVar) {
        qp4 qp4Var = new qp4(list, fVar, z, i, dVar);
        qp4Var.m();
        return qp4Var;
    }
}

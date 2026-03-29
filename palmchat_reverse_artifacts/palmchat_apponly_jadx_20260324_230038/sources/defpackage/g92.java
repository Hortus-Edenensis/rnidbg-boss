package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class g92 extends wr<String, Void, qt5> {
    public g92(pt5<qt5> pt5Var) {
        super(pt5Var, g92.class.getSimpleName());
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public qt5 doInBackground(String... strArr) {
        Map<String, String> mapA = m44.a();
        mapA.put("thirdAppId", strArr[0]);
        return qt5.a(wn.i(n44.c(), ja5.c("00200102", mapA, "lxf48f512f7d6a47c2", "b25a6fa5cad0420e8cb9c6776f8c323e")), g92.class.getSimpleName());
    }
}

package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class m46 extends wr<String, Void, qt5> {
    public Map<String, String> c;

    public m46(pt5<qt5> pt5Var, Map<String, String> map) {
        super(pt5Var, m46.class.getSimpleName());
        this.c = map;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public qt5 doInBackground(String... strArr) {
        Map<String, String> mapA = m44.a();
        mapA.putAll(this.c);
        return qt5.a(wn.i(n44.c(), ja5.c("00200101", mapA, "lxf48f512f7d6a47c2", "b25a6fa5cad0420e8cb9c6776f8c323e")), this.b);
    }
}

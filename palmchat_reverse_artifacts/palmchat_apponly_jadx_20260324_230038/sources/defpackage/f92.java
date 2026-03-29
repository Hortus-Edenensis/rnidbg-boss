package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class f92 extends wr<String, Void, qt5> {
    public f92(pt5<qt5> pt5Var) {
        super(pt5Var, f92.class.getSimpleName());
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public qt5 doInBackground(String... strArr) {
        Map<String, String> mapA = m44.a();
        mapA.put("oAuthKey", strArr[0]);
        return qt5.a(wn.i(n44.c(), ja5.c("getOauthCode", mapA, strArr[1], strArr[2])), f92.class.getSimpleName());
    }
}

package defpackage;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vy3 extends wr<String, Void, qt5> {
    public Map<String, String> c;
    public String d;

    public vy3(pt5 pt5Var, String str, Map<String, String> map, String str2) {
        super(pt5Var, str);
        this.c = map;
        this.d = str2;
    }

    public static vy3 b(String str, pt5<qt5> pt5Var, Map<String, String> map) {
        return c(str, null, pt5Var, map, null);
    }

    public static vy3 c(String str, String str2, pt5<qt5> pt5Var, Map<String, String> map, String str3) {
        vy3 vy3Var = new vy3(pt5Var, str2, map, str3);
        vy3Var.executeOnExecutor(jo1.b(), str);
        return vy3Var;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public qt5 doInBackground(String[] strArr) {
        Map<String, String> mapA = m44.a();
        Map<String, String> map = this.c;
        if (map != null && !map.isEmpty()) {
            mapA.putAll(this.c);
        }
        return qt5.a(wn.i(TextUtils.isEmpty(this.d) ? n44.l(strArr[0]) : this.d, ja5.c(strArr[0], mapA, "lxf48f512f7d6a47c2", "b25a6fa5cad0420e8cb9c6776f8c323e")), TextUtils.isEmpty(this.b) ? vy3.class.getSimpleName() : this.b);
    }
}

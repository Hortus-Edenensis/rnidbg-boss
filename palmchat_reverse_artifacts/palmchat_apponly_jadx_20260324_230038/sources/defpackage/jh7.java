package defpackage;

import android.content.Context;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class jh7 implements zl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f18415a = new ConcurrentHashMap();
    public final zf7 b;

    public jh7(Context context, String str) {
        this.b = new zf7(context, str);
    }

    @Override // defpackage.zl0
    public String getString(String str, String str2) {
        String str3 = this.f18415a.get(str);
        if (str3 != null) {
            return str3;
        }
        String strB = this.b.b(str, str2);
        if (strB == null) {
            return str2;
        }
        this.f18415a.put(str, strB);
        return strB;
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=true}";
    }
}

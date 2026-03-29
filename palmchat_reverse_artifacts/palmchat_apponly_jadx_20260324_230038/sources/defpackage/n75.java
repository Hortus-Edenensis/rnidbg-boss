package defpackage;

import android.text.TextUtils;
import com.zenmen.openapi.OpenApiManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class n75 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19455a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;

    public n75(String str) {
        this.f19455a = str;
    }

    public xg a() {
        if (TextUtils.isEmpty(this.f19455a)) {
            return null;
        }
        return OpenApiManager.getAppInfoFromCache(this.f19455a);
    }
}

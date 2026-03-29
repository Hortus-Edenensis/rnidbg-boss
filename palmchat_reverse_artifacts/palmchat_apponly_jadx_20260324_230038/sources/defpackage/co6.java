package defpackage;

import android.util.Log;
import com.android.volley.toolbox.HttpClientStack;
import com.baidu.mapapi.http.wrapper.HttpManager;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.qiniu.android.http.request.Request;
import com.zm.fissionsdk.WVVzW;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class co6<T> {
    public static final String i = do6.class.getSimpleName();
    public static boolean j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2496a;
    public String b;
    public final byte[] c;
    public int d;
    public int e;
    public boolean f;
    public id7 g;
    public final eo6 h;

    public co6(int i2, String str, eo6<T> eo6Var) {
        this(i2, str, null, eo6Var);
    }

    public void a(String str) {
        if (j) {
            Log.d(i, str);
        }
    }

    public void b(Exception exc) {
        eo6 eo6Var = this.h;
        if (eo6Var != null) {
            eo6Var.onError(exc);
        }
    }

    public void c(T t) {
        eo6 eo6Var = this.h;
        if (eo6Var != null) {
            eo6Var.onSuccess(t);
        }
    }

    public boolean d() {
        return true;
    }

    public byte[] e() {
        return this.c;
    }

    public Map<String, String> f() {
        return Collections.emptyMap();
    }

    public abstract Map<String, List<String>> g();

    public int h() {
        return this.f2496a;
    }

    public String i() {
        switch (this.f2496a) {
            case 0:
                return "GET";
            case 1:
                return "POST";
            case 2:
                return "PUT";
            case 3:
                return HttpManager.HTTP_DELETE;
            case 4:
                return Request.HttpMethodHEAD;
            case 5:
                return "OPTIONS";
            case 6:
                return WVVzW.b;
            case 7:
                return HttpClientStack.HttpPatch.METHOD_NAME;
            default:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public id7 j() {
        return this.g;
    }

    public final int k() {
        return this.g.a();
    }

    public String l() {
        return this.b;
    }

    public boolean m() {
        return this.f;
    }

    public abstract do6<T> n(bo6 bo6Var);

    public void o(id7 id7Var) {
        this.g = id7Var;
    }

    public void p(String str) {
        this.b = str;
    }

    public void q() {
        t87.a().b(this);
    }

    public co6(int i2, String str, byte[] bArr, eo6<T> eo6Var) {
        this.d = 30000;
        this.e = 30000;
        this.f = false;
        this.f2496a = i2;
        this.b = str;
        this.c = bArr;
        this.h = eo6Var;
        o(new ex6());
    }
}

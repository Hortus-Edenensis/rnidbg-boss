package defpackage;

import android.content.Context;
import defpackage.xy2;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e17 implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17203a;
    public final Context b;
    public final String c;
    public final h d;
    public final zl0 e;
    public final ea7 f;
    public final Map<String, String> g;
    public final List<z55> h;
    public final Map<String, String> i = new HashMap();

    public e17(Context context, String str, h hVar, InputStream inputStream, Map<String, String> map, List<z55> list, String str2) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.b = context;
        str = str == null ? context.getPackageName() : str;
        this.c = str;
        if (inputStream != null) {
            this.e = new te7(inputStream, str);
            t86.a(inputStream);
        } else {
            this.e = new jh7(context, str);
        }
        this.f = new ea7(this.e);
        h hVar2 = h.b;
        if (hVar != hVar2 && "1.0".equals(this.e.getString("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.d = (hVar == null || hVar == hVar2) ? t86.f(this.e.getString("/region", null), this.e.getString("/agcgw/url", null)) : hVar;
        this.g = t86.d(map);
        this.h = list;
        this.f17203a = str2 == null ? e() : str2;
    }

    @Override // defpackage.j
    public String a() {
        return this.f17203a;
    }

    @Override // defpackage.j
    public h b() {
        h hVar = this.d;
        return hVar == null ? h.b : hVar;
    }

    public final String c(String str) {
        Map<String, xy2.a> mapA = xy2.a();
        if (!mapA.containsKey(str)) {
            return null;
        }
        if (this.i.containsKey(str)) {
            return this.i.get(str);
        }
        xy2.a aVar = mapA.get(str);
        if (aVar == null) {
            return null;
        }
        String strA = aVar.a(this);
        this.i.put(str, strA);
        return strA;
    }

    public List<z55> d() {
        return this.h;
    }

    public final String e() {
        return String.valueOf(("{packageName='" + this.c + "', routePolicy=" + this.d + ", reader=" + this.e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.g).toString().hashCode() + '}').hashCode());
    }

    public String f(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String strE = t86.e(str);
        String str3 = this.g.get(strE);
        if (str3 != null) {
            return str3;
        }
        String strC = c(strE);
        if (strC != null) {
            return strC;
        }
        String string = this.e.getString(strE, str2);
        return ea7.c(string) ? this.f.a(string, str2) : string;
    }

    @Override // defpackage.j
    public Context getContext() {
        return this.b;
    }

    @Override // defpackage.j
    public String getString(String str) {
        return f(str, null);
    }
}

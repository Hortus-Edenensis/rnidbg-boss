package defpackage;

import com.google.gson.reflect.TypeToken;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class v02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21335a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<List<v02>> {
    }

    public v02(int i, String str, String str2, String str3) {
        this.f21335a = i;
        this.b = str;
        this.c = str2;
        this.e = str3;
    }

    public static List<v02> a(String str) {
        return (List) az2.b(str, new a().getType());
    }
}

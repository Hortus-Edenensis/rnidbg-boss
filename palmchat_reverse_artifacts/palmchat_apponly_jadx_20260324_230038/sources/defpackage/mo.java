package defpackage;

import com.google.gson.reflect.TypeToken;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class mo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19278a;
    public String b;
    public String c;
    public String d;
    public String e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<List<mo>> {
    }

    public mo(int i, String str, String str2, String str3, String str4) {
        this.f19278a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    public static List<mo> a(String str) {
        return (List) az2.b(str, new a().getType());
    }
}

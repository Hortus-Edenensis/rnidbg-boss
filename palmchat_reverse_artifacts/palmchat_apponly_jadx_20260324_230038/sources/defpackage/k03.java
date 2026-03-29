package defpackage;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class k03 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JsonReader.a f18544a = JsonReader.a.a(t.f7496a);

    public static <T> List<h03<T>> a(JsonReader jsonReader, u73 u73Var, float f, i96<T> i96Var, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.p() == JsonReader.Token.STRING) {
            u73Var.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.d();
        while (jsonReader.g()) {
            if (jsonReader.r(f18544a) != 0) {
                jsonReader.x();
            } else if (jsonReader.p() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.c();
                if (jsonReader.p() == JsonReader.Token.NUMBER) {
                    arrayList.add(j03.c(jsonReader, u73Var, f, i96Var, false, z));
                } else {
                    while (jsonReader.g()) {
                        arrayList.add(j03.c(jsonReader, u73Var, f, i96Var, true, z));
                    }
                }
                jsonReader.e();
            } else {
                arrayList.add(j03.c(jsonReader, u73Var, f, i96Var, false, z));
            }
        }
        jsonReader.f();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends h03<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            h03<T> h03Var = list.get(i2);
            i2++;
            h03<T> h03Var2 = list.get(i2);
            h03Var.h = Float.valueOf(h03Var2.g);
            if (h03Var.c == null && (t = h03Var2.b) != null) {
                h03Var.c = t;
                if (h03Var instanceof sc4) {
                    ((sc4) h03Var).i();
                }
            }
        }
        h03<T> h03Var3 = list.get(i);
        if ((h03Var3.b == null || h03Var3.c == null) && list.size() > 1) {
            list.remove(h03Var3);
        }
    }
}

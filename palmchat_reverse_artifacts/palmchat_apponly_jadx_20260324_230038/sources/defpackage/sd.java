package defpackage;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class sd {
    public static <T> List<h03<T>> a(JsonReader jsonReader, float f, u73 u73Var, i96<T> i96Var) throws IOException {
        return k03.a(jsonReader, u73Var, f, i96Var, false);
    }

    public static <T> List<h03<T>> b(JsonReader jsonReader, u73 u73Var, i96<T> i96Var) throws IOException {
        return k03.a(jsonReader, u73Var, 1.0f, i96Var, false);
    }

    public static cd c(JsonReader jsonReader, u73 u73Var) throws IOException {
        return new cd(b(jsonReader, u73Var, rh0.f20476a));
    }

    public static md d(JsonReader jsonReader, u73 u73Var) throws IOException {
        return new md(b(jsonReader, u73Var, qe1.f20239a));
    }

    public static dd e(JsonReader jsonReader, u73 u73Var) throws IOException {
        return f(jsonReader, u73Var, true);
    }

    public static dd f(JsonReader jsonReader, u73 u73Var, boolean z) throws IOException {
        return new dd(a(jsonReader, z ? r86.e() : 1.0f, u73Var, wx1.f21829a));
    }

    public static ed g(JsonReader jsonReader, u73 u73Var, int i) throws IOException {
        return new ed(b(jsonReader, u73Var, new gd2(i)));
    }

    public static fd h(JsonReader jsonReader, u73 u73Var) throws IOException {
        return new fd(b(jsonReader, u73Var, qt2.f20318a));
    }

    public static id i(JsonReader jsonReader, u73 u73Var) throws IOException {
        return new id(k03.a(jsonReader, u73Var, r86.e(), dk4.f17060a, true));
    }

    public static jd j(JsonReader jsonReader, u73 u73Var) throws IOException {
        return new jd(b(jsonReader, u73Var, n25.f19424a));
    }

    public static kd k(JsonReader jsonReader, u73 u73Var) throws IOException {
        return new kd(a(jsonReader, r86.e(), u73Var, a75.f1165a));
    }
}

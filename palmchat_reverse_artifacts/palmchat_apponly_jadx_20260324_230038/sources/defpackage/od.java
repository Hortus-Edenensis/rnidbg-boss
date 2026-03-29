package defpackage;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.igexin.push.g.o;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class od {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f19739a = JsonReader.a.a("a");
    public static final JsonReader.a b = JsonReader.a.a("fc", o.e, "sw", "t");

    public static nd a(JsonReader jsonReader, u73 u73Var) throws IOException {
        jsonReader.d();
        nd ndVarB = null;
        while (jsonReader.g()) {
            if (jsonReader.r(f19739a) != 0) {
                jsonReader.s();
                jsonReader.x();
            } else {
                ndVarB = b(jsonReader, u73Var);
            }
        }
        jsonReader.f();
        return ndVarB == null ? new nd(null, null, null, null) : ndVarB;
    }

    public static nd b(JsonReader jsonReader, u73 u73Var) throws IOException {
        jsonReader.d();
        cd cdVarC = null;
        cd cdVarC2 = null;
        dd ddVarE = null;
        dd ddVarE2 = null;
        while (jsonReader.g()) {
            int iR = jsonReader.r(b);
            if (iR == 0) {
                cdVarC = sd.c(jsonReader, u73Var);
            } else if (iR == 1) {
                cdVarC2 = sd.c(jsonReader, u73Var);
            } else if (iR == 2) {
                ddVarE = sd.e(jsonReader, u73Var);
            } else if (iR != 3) {
                jsonReader.s();
                jsonReader.x();
            } else {
                ddVarE2 = sd.e(jsonReader, u73Var);
            }
        }
        jsonReader.f();
        return new nd(cdVarC, cdVarC2, ddVarE, ddVarE2);
    }
}

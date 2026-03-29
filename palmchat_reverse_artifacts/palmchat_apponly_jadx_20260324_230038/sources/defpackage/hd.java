package defpackage;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f17930a = JsonReader.a.a(t.f7496a, "x", "y");

    public static gd a(JsonReader jsonReader, u73 u73Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.p() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            while (jsonReader.g()) {
                arrayList.add(uc4.a(jsonReader, u73Var));
            }
            jsonReader.e();
            k03.b(arrayList);
        } else {
            arrayList.add(new h03(bz2.e(jsonReader, r86.e())));
        }
        return new gd(arrayList);
    }

    public static rd<PointF, PointF> b(JsonReader jsonReader, u73 u73Var) throws IOException {
        jsonReader.d();
        gd gdVarA = null;
        dd ddVarE = null;
        dd ddVarE2 = null;
        boolean z = false;
        while (jsonReader.p() != JsonReader.Token.END_OBJECT) {
            int iR = jsonReader.r(f17930a);
            if (iR == 0) {
                gdVarA = a(jsonReader, u73Var);
            } else if (iR != 1) {
                if (iR != 2) {
                    jsonReader.s();
                    jsonReader.x();
                } else if (jsonReader.p() == JsonReader.Token.STRING) {
                    jsonReader.x();
                    z = true;
                } else {
                    ddVarE2 = sd.e(jsonReader, u73Var);
                }
            } else if (jsonReader.p() == JsonReader.Token.STRING) {
                jsonReader.x();
                z = true;
            } else {
                ddVarE = sd.e(jsonReader, u73Var);
            }
        }
        jsonReader.f();
        if (z) {
            u73Var.a("Lottie doesn't support expressions.");
        }
        return gdVarA != null ? gdVarA : new ld(ddVarE, ddVarE2);
    }
}

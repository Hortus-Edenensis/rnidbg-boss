package defpackage;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ji1 {
    public static final JsonReader.a f = JsonReader.a.a("ef");
    public static final JsonReader.a g = JsonReader.a.a("nm", "v");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cd f18418a;
    public dd b;
    public dd c;
    public dd d;
    public dd e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(JsonReader jsonReader, u73 u73Var) throws IOException {
        jsonReader.d();
        String strM = "";
        while (jsonReader.g()) {
            int iR = jsonReader.r(g);
            if (iR != 0) {
                if (iR == 1) {
                    strM.hashCode();
                    switch (strM) {
                        case "Distance":
                            this.d = sd.e(jsonReader, u73Var);
                            break;
                        case "Opacity":
                            this.b = sd.f(jsonReader, u73Var, false);
                            break;
                        case "Direction":
                            this.c = sd.f(jsonReader, u73Var, false);
                            break;
                        case "Shadow Color":
                            this.f18418a = sd.c(jsonReader, u73Var);
                            break;
                        case "Softness":
                            this.e = sd.e(jsonReader, u73Var);
                            break;
                        default:
                            jsonReader.x();
                            break;
                    }
                } else {
                    jsonReader.s();
                    jsonReader.x();
                }
            } else {
                strM = jsonReader.m();
            }
        }
        jsonReader.f();
    }

    @Nullable
    public ii1 b(JsonReader jsonReader, u73 u73Var) throws IOException {
        dd ddVar;
        dd ddVar2;
        dd ddVar3;
        dd ddVar4;
        while (jsonReader.g()) {
            if (jsonReader.r(f) != 0) {
                jsonReader.s();
                jsonReader.x();
            } else {
                jsonReader.c();
                while (jsonReader.g()) {
                    a(jsonReader, u73Var);
                }
                jsonReader.e();
            }
        }
        cd cdVar = this.f18418a;
        if (cdVar == null || (ddVar = this.b) == null || (ddVar2 = this.c) == null || (ddVar3 = this.d) == null || (ddVar4 = this.e) == null) {
            return null;
        }
        return new ii1(cdVar, ddVar, ddVar2, ddVar3, ddVar4);
    }
}

package defpackage;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class w02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f21574a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");

    public static q02 a(JsonReader jsonReader) throws IOException {
        jsonReader.d();
        String strM = null;
        String strM2 = null;
        String strM3 = null;
        float fI = 0.0f;
        while (jsonReader.g()) {
            int iR = jsonReader.r(f21574a);
            if (iR == 0) {
                strM = jsonReader.m();
            } else if (iR == 1) {
                strM2 = jsonReader.m();
            } else if (iR == 2) {
                strM3 = jsonReader.m();
            } else if (iR != 3) {
                jsonReader.s();
                jsonReader.x();
            } else {
                fI = (float) jsonReader.i();
            }
        }
        jsonReader.f();
        return new q02(strM, strM2, strM3, fI);
    }
}

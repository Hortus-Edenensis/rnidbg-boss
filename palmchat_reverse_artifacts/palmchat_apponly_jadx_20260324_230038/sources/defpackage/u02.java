package defpackage;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.cdo.oaps.ad.wrapper.download.RedirectReqWrapper;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class u02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f21108a = JsonReader.a.a(RedirectReqWrapper.KEY_CHANNEL, "size", RXScreenCaptureService.KEY_WIDTH, "style", "fFamily", "data");
    public static final JsonReader.a b = JsonReader.a.a("shapes");

    public static t02 a(JsonReader jsonReader, u73 u73Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.d();
        double dI = 0.0d;
        String strM = null;
        String strM2 = null;
        double dI2 = 0.0d;
        char cCharAt = 0;
        while (jsonReader.g()) {
            int iR = jsonReader.r(f21108a);
            if (iR == 0) {
                cCharAt = jsonReader.m().charAt(0);
            } else if (iR == 1) {
                dI2 = jsonReader.i();
            } else if (iR == 2) {
                dI = jsonReader.i();
            } else if (iR == 3) {
                strM = jsonReader.m();
            } else if (iR == 4) {
                strM2 = jsonReader.m();
            } else if (iR != 5) {
                jsonReader.s();
                jsonReader.x();
            } else {
                jsonReader.d();
                while (jsonReader.g()) {
                    if (jsonReader.r(b) != 0) {
                        jsonReader.s();
                        jsonReader.x();
                    } else {
                        jsonReader.c();
                        while (jsonReader.g()) {
                            arrayList.add((e75) op0.a(jsonReader, u73Var));
                        }
                        jsonReader.e();
                    }
                }
                jsonReader.f();
            }
        }
        jsonReader.f();
        return new t02(arrayList, cCharAt, dI2, dI, strM, strM2);
    }
}

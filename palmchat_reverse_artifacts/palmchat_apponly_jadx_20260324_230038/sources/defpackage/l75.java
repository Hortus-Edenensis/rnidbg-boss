package defpackage;

import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class l75 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f18924a = JsonReader.a.a("nm", "c", RXScreenCaptureService.KEY_WIDTH, "o", "lc", "lj", "ml", LiveConfigKey.HIGH, "d");
    public static final JsonReader.a b = JsonReader.a.a("n", "v");

    public static ShapeStroke a(JsonReader jsonReader, u73 u73Var) throws IOException {
        dd ddVarE;
        ArrayList arrayList = new ArrayList();
        String strM = null;
        dd ddVar = null;
        cd cdVarC = null;
        dd ddVarE2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float fI = 0.0f;
        boolean zH = false;
        fd fdVar = null;
        while (jsonReader.g()) {
            switch (jsonReader.r(f18924a)) {
                case 0:
                    strM = jsonReader.m();
                    break;
                case 1:
                    cdVarC = sd.c(jsonReader, u73Var);
                    break;
                case 2:
                    ddVarE2 = sd.e(jsonReader, u73Var);
                    break;
                case 3:
                    fdVar = sd.h(jsonReader, u73Var);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.j() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.j() - 1];
                    break;
                case 6:
                    fI = (float) jsonReader.i();
                    break;
                case 7:
                    zH = jsonReader.h();
                    break;
                case 8:
                    jsonReader.c();
                    while (jsonReader.g()) {
                        jsonReader.d();
                        String strM2 = null;
                        ddVarE = null;
                        while (jsonReader.g()) {
                            int iR = jsonReader.r(b);
                            if (iR == 0) {
                                strM2 = jsonReader.m();
                            } else if (iR != 1) {
                                jsonReader.s();
                                jsonReader.x();
                            } else {
                                ddVarE = sd.e(jsonReader, u73Var);
                            }
                        }
                        jsonReader.f();
                        strM2.hashCode();
                        switch (strM2) {
                            case "d":
                            case "g":
                                u73Var.u(true);
                                arrayList.add(ddVarE);
                                break;
                            case "o":
                                ddVar = ddVarE;
                                break;
                        }
                    }
                    jsonReader.e();
                    if (arrayList.size() == 1) {
                        arrayList.add((dd) arrayList.get(0));
                    }
                    break;
                default:
                    jsonReader.x();
                    break;
            }
        }
        if (fdVar == null) {
            fdVar = new fd(Collections.singletonList(new h03(100)));
        }
        return new ShapeStroke(strM, ddVar, arrayList, cdVarC, fdVar, ddVarE2, lineCapType, lineJoinType, fI, zH);
    }
}

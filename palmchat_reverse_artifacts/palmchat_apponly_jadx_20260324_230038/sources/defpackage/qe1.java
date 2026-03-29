package defpackage;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.amap.api.col.p0002sl.hb;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.igexin.push.g.o;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class qe1 implements i96<DocumentData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qe1 f20239a = new qe1();
    public static final JsonReader.a b = JsonReader.a.a("t", "f", "s", hb.j, "tr", "lh", "ls", "fc", o.e, "sw", MapBundleKey.MapObjKey.OBJ_OFFSET);

    @Override // defpackage.i96
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DocumentData a(JsonReader jsonReader, float f) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.d();
        DocumentData.Justification justification2 = justification;
        String strM = null;
        String strM2 = null;
        float fI = 0.0f;
        int iJ = 0;
        float fI2 = 0.0f;
        float fI3 = 0.0f;
        int iD = 0;
        int iD2 = 0;
        float fI4 = 0.0f;
        boolean zH = true;
        while (jsonReader.g()) {
            switch (jsonReader.r(b)) {
                case 0:
                    strM = jsonReader.m();
                    break;
                case 1:
                    strM2 = jsonReader.m();
                    break;
                case 2:
                    fI = (float) jsonReader.i();
                    break;
                case 3:
                    int iJ2 = jsonReader.j();
                    justification2 = DocumentData.Justification.CENTER;
                    if (iJ2 <= justification2.ordinal() && iJ2 >= 0) {
                        justification2 = DocumentData.Justification.values()[iJ2];
                    }
                    break;
                case 4:
                    iJ = jsonReader.j();
                    break;
                case 5:
                    fI2 = (float) jsonReader.i();
                    break;
                case 6:
                    fI3 = (float) jsonReader.i();
                    break;
                case 7:
                    iD = bz2.d(jsonReader);
                    break;
                case 8:
                    iD2 = bz2.d(jsonReader);
                    break;
                case 9:
                    fI4 = (float) jsonReader.i();
                    break;
                case 10:
                    zH = jsonReader.h();
                    break;
                default:
                    jsonReader.s();
                    jsonReader.x();
                    break;
            }
        }
        jsonReader.f();
        return new DocumentData(strM, strM2, fI, justification2, iJ, fI2, fI3, iD, iD2, fI4, zH);
    }
}

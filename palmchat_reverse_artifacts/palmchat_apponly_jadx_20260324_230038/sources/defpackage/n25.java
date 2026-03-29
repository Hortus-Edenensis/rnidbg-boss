package defpackage;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class n25 implements i96<m25> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n25 f19424a = new n25();

    @Override // defpackage.i96
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m25 a(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.p() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.c();
        }
        float fI = (float) jsonReader.i();
        float fI2 = (float) jsonReader.i();
        while (jsonReader.g()) {
            jsonReader.x();
        }
        if (z) {
            jsonReader.e();
        }
        return new m25((fI / 100.0f) * f, (fI2 / 100.0f) * f);
    }
}

package defpackage;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class rh0 implements i96<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rh0 f20476a = new rh0();

    @Override // defpackage.i96
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.p() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.c();
        }
        double dI = jsonReader.i();
        double dI2 = jsonReader.i();
        double dI3 = jsonReader.i();
        double dI4 = jsonReader.p() == JsonReader.Token.NUMBER ? jsonReader.i() : 1.0d;
        if (z) {
            jsonReader.e();
        }
        if (dI <= 1.0d && dI2 <= 1.0d && dI3 <= 1.0d) {
            dI *= 255.0d;
            dI2 *= 255.0d;
            dI3 *= 255.0d;
            if (dI4 <= 1.0d) {
                dI4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dI4, (int) dI, (int) dI2, (int) dI3));
    }
}

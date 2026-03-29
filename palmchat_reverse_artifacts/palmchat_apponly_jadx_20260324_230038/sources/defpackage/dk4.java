package defpackage;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dk4 implements i96<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dk4 f17060a = new dk4();

    @Override // defpackage.i96
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(JsonReader jsonReader, float f) throws IOException {
        JsonReader.Token tokenP = jsonReader.p();
        if (tokenP == JsonReader.Token.BEGIN_ARRAY) {
            return bz2.e(jsonReader, f);
        }
        if (tokenP == JsonReader.Token.BEGIN_OBJECT) {
            return bz2.e(jsonReader, f);
        }
        if (tokenP == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.i()) * f, ((float) jsonReader.i()) * f);
            while (jsonReader.g()) {
                jsonReader.x();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + tokenP);
    }
}

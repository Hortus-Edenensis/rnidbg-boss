package defpackage;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bz2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f1856a = JsonReader.a.a("x", "y");

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1857a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f1857a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1857a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1857a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PointF a(JsonReader jsonReader, float f) throws IOException {
        jsonReader.c();
        float fI = (float) jsonReader.i();
        float fI2 = (float) jsonReader.i();
        while (jsonReader.p() != JsonReader.Token.END_ARRAY) {
            jsonReader.x();
        }
        jsonReader.e();
        return new PointF(fI * f, fI2 * f);
    }

    public static PointF b(JsonReader jsonReader, float f) throws IOException {
        float fI = (float) jsonReader.i();
        float fI2 = (float) jsonReader.i();
        while (jsonReader.g()) {
            jsonReader.x();
        }
        return new PointF(fI * f, fI2 * f);
    }

    public static PointF c(JsonReader jsonReader, float f) throws IOException {
        jsonReader.d();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (jsonReader.g()) {
            int iR = jsonReader.r(f1856a);
            if (iR == 0) {
                fG = g(jsonReader);
            } else if (iR != 1) {
                jsonReader.s();
                jsonReader.x();
            } else {
                fG2 = g(jsonReader);
            }
        }
        jsonReader.f();
        return new PointF(fG * f, fG2 * f);
    }

    @ColorInt
    public static int d(JsonReader jsonReader) throws IOException {
        jsonReader.c();
        int i = (int) (jsonReader.i() * 255.0d);
        int i2 = (int) (jsonReader.i() * 255.0d);
        int i3 = (int) (jsonReader.i() * 255.0d);
        while (jsonReader.g()) {
            jsonReader.x();
        }
        jsonReader.e();
        return Color.argb(255, i, i2, i3);
    }

    public static PointF e(JsonReader jsonReader, float f) throws IOException {
        int i = a.f1857a[jsonReader.p().ordinal()];
        if (i == 1) {
            return b(jsonReader, f);
        }
        if (i == 2) {
            return a(jsonReader, f);
        }
        if (i == 3) {
            return c(jsonReader, f);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.p());
    }

    public static List<PointF> f(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.c();
        while (jsonReader.p() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            arrayList.add(e(jsonReader, f));
            jsonReader.e();
        }
        jsonReader.e();
        return arrayList;
    }

    public static float g(JsonReader jsonReader) throws IOException {
        JsonReader.Token tokenP = jsonReader.p();
        int i = a.f1857a[tokenP.ordinal()];
        if (i == 1) {
            return (float) jsonReader.i();
        }
        if (i != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + tokenP);
        }
        jsonReader.c();
        float fI = (float) jsonReader.i();
        while (jsonReader.g()) {
            jsonReader.x();
        }
        jsonReader.e();
        return fI;
    }
}

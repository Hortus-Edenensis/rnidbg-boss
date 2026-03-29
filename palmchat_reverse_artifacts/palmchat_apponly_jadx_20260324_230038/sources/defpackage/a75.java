package defpackage;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class a75 implements i96<z65> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a75 f1165a = new a75();
    public static final JsonReader.a b = JsonReader.a.a("c", "v", "i", "o");

    @Override // defpackage.i96
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public z65 a(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.p() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
        }
        jsonReader.d();
        List<PointF> listF = null;
        List<PointF> listF2 = null;
        List<PointF> listF3 = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iR = jsonReader.r(b);
            if (iR == 0) {
                zH = jsonReader.h();
            } else if (iR == 1) {
                listF = bz2.f(jsonReader, f);
            } else if (iR == 2) {
                listF2 = bz2.f(jsonReader, f);
            } else if (iR != 3) {
                jsonReader.s();
                jsonReader.x();
            } else {
                listF3 = bz2.f(jsonReader, f);
            }
        }
        jsonReader.f();
        if (jsonReader.p() == JsonReader.Token.END_ARRAY) {
            jsonReader.e();
        }
        if (listF == null || listF2 == null || listF3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listF.isEmpty()) {
            return new z65(new PointF(), false, Collections.emptyList());
        }
        int size = listF.size();
        PointF pointF = listF.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = listF.get(i);
            int i2 = i - 1;
            arrayList.add(new nr0(sp3.a(listF.get(i2), listF3.get(i2)), sp3.a(pointF2, listF2.get(i)), pointF2));
        }
        if (zH) {
            PointF pointF3 = listF.get(0);
            int i3 = size - 1;
            arrayList.add(new nr0(sp3.a(listF.get(i3), listF3.get(i3)), sp3.a(pointF3, listF2.get(0)), pointF3));
        }
        return new z65(pointF, zH, arrayList);
    }
}

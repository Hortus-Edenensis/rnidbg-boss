package defpackage;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class wx1 implements i96<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wx1 f21829a = new wx1();

    @Override // defpackage.i96
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float a(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(bz2.g(jsonReader) * f);
    }
}

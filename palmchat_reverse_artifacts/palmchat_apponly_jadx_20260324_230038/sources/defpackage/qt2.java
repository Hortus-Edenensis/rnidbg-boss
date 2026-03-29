package defpackage;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class qt2 implements i96<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qt2 f20318a = new qt2();

    @Override // defpackage.i96
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(bz2.g(jsonReader) * f));
    }
}

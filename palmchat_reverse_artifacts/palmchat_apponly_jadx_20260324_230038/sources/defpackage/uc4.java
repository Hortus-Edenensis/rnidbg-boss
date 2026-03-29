package defpackage;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class uc4 {
    public static sc4 a(JsonReader jsonReader, u73 u73Var) throws IOException {
        return new sc4(u73Var, j03.c(jsonReader, u73Var, r86.e(), vc4.f21405a, jsonReader.p() == JsonReader.Token.BEGIN_OBJECT, false));
    }
}

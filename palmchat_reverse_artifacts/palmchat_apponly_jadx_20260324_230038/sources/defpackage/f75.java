package defpackage;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.igexin.push.g.o;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class f75 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f17473a = JsonReader.a.a("nm", LiveConfigKey.HIGH, o.f);

    public static e75 a(JsonReader jsonReader, u73 u73Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strM = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iR = jsonReader.r(f17473a);
            if (iR == 0) {
                strM = jsonReader.m();
            } else if (iR == 1) {
                zH = jsonReader.h();
            } else if (iR != 2) {
                jsonReader.x();
            } else {
                jsonReader.c();
                while (jsonReader.g()) {
                    np0 np0VarA = op0.a(jsonReader, u73Var);
                    if (np0VarA != null) {
                        arrayList.add(np0VarA);
                    }
                }
                jsonReader.e();
            }
        }
        return new e75(strM, arrayList, zH);
    }
}

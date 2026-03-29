package defpackage;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f17596a = JsonReader.a.a("ef");
    public static final JsonReader.a b = JsonReader.a.a(MapBundleKey.MapObjKey.OBJ_TYPE, "v");

    @Nullable
    public static eu a(JsonReader jsonReader, u73 u73Var) throws IOException {
        jsonReader.d();
        eu euVar = null;
        while (true) {
            boolean z = false;
            while (jsonReader.g()) {
                int iR = jsonReader.r(b);
                if (iR != 0) {
                    if (iR != 1) {
                        jsonReader.s();
                        jsonReader.x();
                    } else if (z) {
                        euVar = new eu(sd.e(jsonReader, u73Var));
                    } else {
                        jsonReader.x();
                    }
                } else if (jsonReader.j() == 0) {
                    z = true;
                }
            }
            jsonReader.f();
            return euVar;
        }
    }

    @Nullable
    public static eu b(JsonReader jsonReader, u73 u73Var) throws IOException {
        eu euVar = null;
        while (jsonReader.g()) {
            if (jsonReader.r(f17596a) != 0) {
                jsonReader.s();
                jsonReader.x();
            } else {
                jsonReader.c();
                while (jsonReader.g()) {
                    eu euVarA = a(jsonReader, u73Var);
                    if (euVarA != null) {
                        euVar = euVarA;
                    }
                }
                jsonReader.e();
            }
        }
        return euVar;
    }
}

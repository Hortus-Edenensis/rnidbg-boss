package defpackage;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class tn3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f21027a = JsonReader.a.a("nm", "mm", LiveConfigKey.HIGH);

    public static MergePaths a(JsonReader jsonReader) throws IOException {
        String strM = null;
        MergePaths.MergePathsMode mergePathsModeForId = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iR = jsonReader.r(f21027a);
            if (iR == 0) {
                strM = jsonReader.m();
            } else if (iR == 1) {
                mergePathsModeForId = MergePaths.MergePathsMode.forId(jsonReader.j());
            } else if (iR != 2) {
                jsonReader.s();
                jsonReader.x();
            } else {
                zH = jsonReader.h();
            }
        }
        return new MergePaths(strM, mergePathsModeForId, zH);
    }
}

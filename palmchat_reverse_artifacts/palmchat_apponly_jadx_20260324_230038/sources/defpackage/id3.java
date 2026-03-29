package defpackage;

import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class id3 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Mask a(JsonReader jsonReader, u73 u73Var) throws IOException {
        String strK;
        jsonReader.d();
        Mask.MaskMode maskMode = null;
        kd kdVarK = null;
        fd fdVarH = null;
        boolean zH = false;
        while (jsonReader.g()) {
            strK = jsonReader.k();
            strK.hashCode();
            switch (strK) {
                case "o":
                    fdVarH = sd.h(jsonReader, u73Var);
                    break;
                case "pt":
                    kdVarK = sd.k(jsonReader, u73Var);
                    break;
                case "inv":
                    zH = jsonReader.h();
                    break;
                case "mode":
                    String strM = jsonReader.m();
                    strM.hashCode();
                    switch (strM) {
                        case "a":
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                        case "i":
                            u73Var.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                            break;
                        case "s":
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            m63.c("Unknown mask mode " + strK + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.x();
                    break;
            }
        }
        jsonReader.f();
        return new Mask(maskMode, kdVarK, fdVarH, zH);
    }
}

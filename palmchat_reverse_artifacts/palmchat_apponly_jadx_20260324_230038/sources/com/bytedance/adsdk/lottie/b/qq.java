package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.nr.n;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class qq {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.bytedance.adsdk.lottie.model.nr.n u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        String strNextName;
        jsonReader.beginObject();
        n.u uVar = null;
        com.bytedance.adsdk.lottie.model.u.n nVarPn = null;
        com.bytedance.adsdk.lottie.model.u.b bVarNr = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "o":
                    bVarNr = b.nr(jsonReader, izVar);
                    break;
                case "pt":
                    nVarPn = b.pn(jsonReader, izVar);
                    break;
                case "inv":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.hashCode();
                    switch (strNextString) {
                        case "a":
                            uVar = n.u.MASK_MODE_ADD;
                            break;
                        case "i":
                            izVar.u("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            uVar = n.u.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            uVar = n.u.MASK_MODE_NONE;
                            break;
                        case "s":
                            uVar = n.u.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            com.bytedance.adsdk.lottie.pn.pn.nr("Unknown mask mode " + strNextName + ". Defaulting to Add.");
                            uVar = n.u.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.nr.n(uVar, nVarPn, bVarNr, zNextBoolean);
    }
}

package com.bytedance.adsdk.lottie.b;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx {
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean fx(com.bytedance.adsdk.lottie.model.u.nr nrVar) {
        if (nrVar != null) {
            return nrVar.nr() && ((Float) ((com.bytedance.adsdk.lottie.iz.u) nrVar.fx().get(0)).u).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean nr(com.bytedance.adsdk.lottie.model.u.nr nrVar) {
        if (nrVar != null) {
            return nrVar.nr() && ((Float) ((com.bytedance.adsdk.lottie.iz.u) nrVar.fx().get(0)).u).floatValue() == 0.0f;
        }
        return true;
    }

    public static com.bytedance.adsdk.lottie.model.u.l u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.bytedance.adsdk.lottie.model.u.nr nrVar = null;
        com.bytedance.adsdk.lottie.model.u.pn pnVarU = null;
        com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> mvVarNr = null;
        com.bytedance.adsdk.lottie.model.u.x xVarB = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU2 = null;
        com.bytedance.adsdk.lottie.model.u.b bVarNr = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU3 = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(com.kuaishou.weapon.p0.t.f7496a)) {
                            pnVarU = u.u(jsonReader, izVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "o":
                    bVarNr = b.nr(jsonReader, izVar);
                    continue;
                    break;
                case "p":
                    mvVarNr = u.nr(jsonReader, izVar);
                    continue;
                    break;
                case "r":
                    break;
                case "s":
                    xVarB = b.b(jsonReader, izVar);
                    continue;
                    break;
                case "eo":
                    nrVarU4 = b.u(jsonReader, izVar, false);
                    continue;
                    break;
                case "rz":
                    izVar.u("Lottie doesn't support 3D layers.");
                    break;
                case "sa":
                    nrVarU2 = b.u(jsonReader, izVar, false);
                    continue;
                    break;
                case "sk":
                    nrVarU = b.u(jsonReader, izVar, false);
                    continue;
                    break;
                case "so":
                    nrVarU3 = b.u(jsonReader, izVar, false);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            com.bytedance.adsdk.lottie.model.u.nr nrVarU5 = b.u(jsonReader, izVar, false);
            if (nrVarU5.fx().isEmpty()) {
                nrVarU5.fx().add(new com.bytedance.adsdk.lottie.iz.u(izVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(izVar.x())));
            } else if (((com.bytedance.adsdk.lottie.iz.u) nrVarU5.fx().get(0)).u == 0) {
                nrVarU5.fx().set(0, new com.bytedance.adsdk.lottie.iz.u(izVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(izVar.x())));
            }
            nrVar = nrVarU5;
        }
        if (z) {
            jsonReader.endObject();
        }
        if (u(pnVarU)) {
            pnVarU = null;
        }
        return new com.bytedance.adsdk.lottie.model.u.l(pnVarU, u(mvVarNr) ? null : mvVarNr, u(xVarB) ? null : xVarB, u(nrVar) ? null : nrVar, bVarNr, nrVarU3, nrVarU4, nr(nrVarU) ? null : nrVarU, fx(nrVarU2) ? null : nrVarU2);
    }

    private static boolean u(com.bytedance.adsdk.lottie.model.u.pn pnVar) {
        if (pnVar != null) {
            return pnVar.nr() && pnVar.fx().get(0).u.equals(0.0f, 0.0f);
        }
        return true;
    }

    private static boolean u(com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> mvVar) {
        if (mvVar != null) {
            return !(mvVar instanceof com.bytedance.adsdk.lottie.model.u.a) && mvVar.nr() && mvVar.fx().get(0).u.equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean u(com.bytedance.adsdk.lottie.model.u.nr nrVar) {
        if (nrVar != null) {
            return nrVar.nr() && ((Float) ((com.bytedance.adsdk.lottie.iz.u) nrVar.fx().get(0)).u).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean u(com.bytedance.adsdk.lottie.model.u.x xVar) {
        if (xVar != null) {
            return xVar.nr() && ((com.bytedance.adsdk.lottie.iz.b) ((com.bytedance.adsdk.lottie.iz.u) xVar.fx().get(0)).u).nr(1.0f, 1.0f);
        }
        return true;
    }
}

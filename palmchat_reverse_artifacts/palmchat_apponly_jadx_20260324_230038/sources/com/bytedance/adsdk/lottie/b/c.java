package com.bytedance.adsdk.lottie.b;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.model.layer.n;
import com.lantern.core.configuration.ConfigConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.umeng.analytics.pro.dn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.b.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[n.nr.values().length];
            u = iArr;
            try {
                iArr[n.nr.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[n.nr.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static com.bytedance.adsdk.lottie.model.layer.n u(com.bytedance.adsdk.lottie.iz izVar) {
        Rect rectB = izVar.b();
        return new com.bytedance.adsdk.lottie.model.layer.n(Collections.emptyList(), izVar, "__container", -1L, n.u.PRE_COMP, -1L, null, Collections.emptyList(), new com.bytedance.adsdk.lottie.model.u.l(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, Collections.emptyList(), n.nr.NONE, null, false, null, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.adsdk.lottie.model.layer.n u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        ArrayList arrayList;
        n.nr nrVar = n.nr.NONE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        n.nr nrVar2 = nrVar;
        n.u uVar = null;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.u.l lVarU = null;
        com.bytedance.adsdk.lottie.model.u.jk jkVarIz = null;
        com.bytedance.adsdk.lottie.model.u.t tVarU = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU = null;
        com.bytedance.adsdk.lottie.model.nr.u uVarU = null;
        jk jkVarU = null;
        long jNextInt = 0;
        long jNextInt2 = -1;
        float fNextDouble = 0.0f;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        float fNextDouble2 = 1.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        float fNextDouble5 = 0.0f;
        boolean zNextBoolean = false;
        float fX = 0.0f;
        String strNextString2 = "UNSET";
        String strNextString3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case -995424086:
                    if (strNextName.equals("parent")) {
                        b = 0;
                    }
                    break;
                case -903568142:
                    if (strNextName.equals("shapes")) {
                        b = 1;
                    }
                    break;
                case 104:
                    if (strNextName.equals("h")) {
                        b = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
                        b = 3;
                    }
                    break;
                case 119:
                    if (strNextName.equals(RXScreenCaptureService.KEY_WIDTH)) {
                        b = 4;
                    }
                    break;
                case 3177:
                    if (strNextName.equals("cl")) {
                        b = 5;
                    }
                    break;
                case 3233:
                    if (strNextName.equals("ef")) {
                        b = 6;
                    }
                    break;
                case 3324:
                    if (strNextName.equals(LiveConfigKey.HIGH)) {
                        b = 7;
                    }
                    break;
                case 3367:
                    if (strNextName.equals("ip")) {
                        b = 8;
                    }
                    break;
                case 3432:
                    if (strNextName.equals("ks")) {
                        b = 9;
                    }
                    break;
                case 3519:
                    if (strNextName.equals("nm")) {
                        b = 10;
                    }
                    break;
                case 3553:
                    if (strNextName.equals(ConfigConstant.COLUMN_OP)) {
                        b = 11;
                    }
                    break;
                case 3664:
                    if (strNextName.equals(com.igexin.push.g.o.e)) {
                        b = 12;
                    }
                    break;
                case 3669:
                    if (strNextName.equals("sh")) {
                        b = dn.k;
                    }
                    break;
                case 3679:
                    if (strNextName.equals("sr")) {
                        b = dn.l;
                    }
                    break;
                case 3681:
                    if (strNextName.equals("st")) {
                        b = 15;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b = 16;
                    }
                    break;
                case 3705:
                    if (strNextName.equals("tm")) {
                        b = 17;
                    }
                    break;
                case 3712:
                    if (strNextName.equals("tt")) {
                        b = 18;
                    }
                    break;
                case 3717:
                    if (strNextName.equals(MapBundleKey.MapObjKey.OBJ_TYPE)) {
                        b = 19;
                    }
                    break;
                case 104415:
                    if (strNextName.equals("ind")) {
                        b = 20;
                    }
                    break;
                case 108390670:
                    if (strNextName.equals("refId")) {
                        b = 21;
                    }
                    break;
                case 1441620890:
                    if (strNextName.equals("masksProperties")) {
                        b = 22;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    jNextInt2 = jsonReader.nextInt();
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.lottie.model.nr.fx fxVarU = n.u(jsonReader, izVar);
                        if (fxVarU != null) {
                            arrayList3.add(fxVarU);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 2:
                    fNextDouble5 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.lottie.pn.a.u()));
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                tVarU = nr.u(jsonReader, izVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (!strNextName2.equals("d")) {
                            jsonReader.skipValue();
                        } else {
                            jkVarIz = b.iz(jsonReader, izVar);
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 4:
                    fNextDouble4 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.lottie.pn.a.u()));
                    break;
                case 5:
                    strNextString3 = jsonReader.nextString();
                    break;
                case 6:
                    jsonReader.beginArray();
                    ArrayList arrayList4 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("nm")) {
                                arrayList4.add(jsonReader.nextString());
                            } else if (!strNextName3.equals(MapBundleKey.MapObjKey.OBJ_TYPE)) {
                                jsonReader.skipValue();
                            } else {
                                int iNextInt3 = jsonReader.nextInt();
                                if (iNextInt3 == 29) {
                                    uVarU = pn.u(jsonReader, izVar);
                                } else if (iNextInt3 == 25) {
                                    jkVarU = new t().u(jsonReader, izVar);
                                }
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    izVar.u("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList4)));
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 8:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 9:
                    lVarU = fx.u(jsonReader, izVar);
                    break;
                case 10:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 11:
                    fX = (float) jsonReader.nextDouble();
                    break;
                case 12:
                    color = Color.parseColor(jsonReader.nextString());
                    break;
                case 13:
                    iNextInt2 = (int) (jsonReader.nextInt() * com.bytedance.adsdk.lottie.pn.a.u());
                    break;
                case 14:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 16:
                    iNextInt = (int) (jsonReader.nextInt() * com.bytedance.adsdk.lottie.pn.a.u());
                    break;
                case 17:
                    nrVarU = b.u(jsonReader, izVar, false);
                    break;
                case 18:
                    int iNextInt4 = jsonReader.nextInt();
                    if (iNextInt4 >= n.nr.values().length) {
                        izVar.u("Unsupported matte type: ".concat(String.valueOf(iNextInt4)));
                    } else {
                        nrVar2 = n.nr.values()[iNextInt4];
                        int i = AnonymousClass1.u[nrVar2.ordinal()];
                        if (i == 1) {
                            izVar.u("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            izVar.u("Unsupported matte type: Luma Inverted");
                        }
                        izVar.u(1);
                    }
                    break;
                case 19:
                    int iNextInt5 = jsonReader.nextInt();
                    uVar = n.u.UNKNOWN;
                    if (iNextInt5 < uVar.ordinal()) {
                        uVar = n.u.values()[iNextInt5];
                    }
                    break;
                case 20:
                    jNextInt = jsonReader.nextInt();
                    break;
                case 21:
                    strNextString = jsonReader.nextString();
                    break;
                case 22:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList2.add(qq.u(jsonReader, izVar));
                    }
                    izVar.u(arrayList2.size());
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList5 = new ArrayList();
        if (fNextDouble > 0.0f) {
            arrayList = arrayList2;
            arrayList5.add(new com.bytedance.adsdk.lottie.iz.u(izVar, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fNextDouble)));
        } else {
            arrayList = arrayList2;
        }
        if (fX <= 0.0f) {
            fX = izVar.x();
        }
        arrayList5.add(new com.bytedance.adsdk.lottie.iz.u(izVar, fValueOf2, fValueOf2, null, fNextDouble, Float.valueOf(fX)));
        arrayList5.add(new com.bytedance.adsdk.lottie.iz.u(izVar, fValueOf, fValueOf, null, fX, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            izVar.u("Convert your Illustrator layers to shape layers.");
        }
        return new com.bytedance.adsdk.lottie.model.layer.n(arrayList3, izVar, strNextString2, jNextInt, uVar, jNextInt2, strNextString, arrayList, lVarU, iNextInt, iNextInt2, color, fNextDouble2, fNextDouble3, fNextDouble4, fNextDouble5, jkVarIz, tVarU, arrayList5, nrVar2, nrVarU, zNextBoolean, uVarU, jkVarU);
    }
}

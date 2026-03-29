package com.bytedance.adsdk.lottie.b;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.LongSparseArray;
import android.util.SparseArray;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.iz;
import com.bytedance.adsdk.lottie.model.layer.n;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.OapsKey;
import com.lantern.core.configuration.ConfigConstant;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.umeng.analytics.pro.dn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class q {
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static JSONArray b(JsonReader jsonReader) {
        byte b;
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    int iHashCode = strNextName.hashCode();
                    if (iHashCode != 3324) {
                        b = (iHashCode == 116753 && strNextName.equals(OapsKey.KEY_VERID)) ? (byte) 0 : (byte) -1;
                    } else if (strNextName.equals(LiveConfigKey.HIGH)) {
                        b = 1;
                    }
                    if (b == 0) {
                        jSONObject.put(OapsKey.KEY_VERID, jsonReader.nextString());
                    } else if (b != 1) {
                        jsonReader.skipValue();
                    } else {
                        try {
                            jSONObject.put(LiveConfigKey.HIGH, jsonReader.nextInt());
                        } catch (JSONException unused) {
                        }
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception unused2) {
        }
        return jSONArray;
    }

    private static String[] fx(JsonReader jsonReader) {
        try {
            jsonReader.beginArray();
            String[] strArr = new String[3];
            for (int i = 0; i < 3; i++) {
                try {
                    if (jsonReader.hasNext()) {
                        strArr[i] = jsonReader.nextString();
                    }
                } catch (Exception unused) {
                    return strArr;
                }
            }
            jsonReader.endArray();
            return strArr;
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a.fx.u iz(JsonReader jsonReader) {
        byte b;
        try {
            a.fx.u uVar = new a.fx.u();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 99) {
                    b = (iHashCode == 3706 && strNextName.equals("tn")) ? (byte) 0 : (byte) -1;
                } else if (strNextName.equals("c")) {
                    b = 1;
                }
                if (b == 0) {
                    uVar.u = jsonReader.nextInt();
                } else if (b != 1) {
                    jsonReader.skipValue();
                } else {
                    uVar.nr = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            return uVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void nr(JsonReader jsonReader, iz.nr nrVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3239) {
                    if (iHashCode != 3276) {
                        b = (iHashCode == 107027 && strNextName.equals("lel")) ? (byte) 2 : (byte) -1;
                    } else if (strNextName.equals("fr")) {
                        b = 0;
                    }
                } else if (strNextName.equals(com.kuaishou.weapon.p0.t.n)) {
                    b = 1;
                }
                if (b == 0) {
                    nrVar.pn = jsonReader.nextInt();
                } else if (b == 1) {
                    nrVar.iz = jsonReader.nextString();
                } else if (b != 2) {
                    jsonReader.skipValue();
                } else {
                    nrVar.x = b(jsonReader);
                }
            }
            jsonReader.endObject();
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<a.fx> pn(JsonReader jsonReader) {
        byte b;
        try {
            ArrayList arrayList = new ArrayList();
            while (jsonReader.hasNext()) {
                a.fx fxVar = new a.fx();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    switch (jsonReader.nextName()) {
                        case "l":
                            fxVar.u = jsonReader.nextInt();
                            break;
                        case "le":
                            fxVar.nr = jsonReader.nextInt();
                            break;
                        case "s":
                            fxVar.iz = jsonReader.nextInt();
                            break;
                        case "els":
                            fxVar.x = jsonReader.nextString();
                            break;
                        case "c":
                            fxVar.b = jsonReader.nextString();
                            break;
                        case "fcl":
                            fxVar.fx = jsonReader.nextString();
                            break;
                        case "bold":
                            fxVar.n = jsonReader.nextInt();
                            break;
                        case "f":
                            fxVar.pn = jsonReader.nextString();
                            break;
                        case "bs":
                            fxVar.f4980a = jsonReader.nextInt();
                            break;
                        case "ali":
                            fxVar.jk = jsonReader.nextString();
                            break;
                        case "ul":
                            fxVar.t = iz(jsonReader);
                            break;
                        case "st":
                            fxVar.l = iz(jsonReader);
                            break;
                        case "ml":
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                String strNextName = jsonReader.nextName();
                                int iHashCode = strNextName.hashCode();
                                if (iHashCode != 108) {
                                    b = (iHashCode == 109 && strNextName.equals("m")) ? (byte) 0 : (byte) -1;
                                } else if (strNextName.equals("l")) {
                                    b = 1;
                                }
                                if (b == 0) {
                                    fxVar.mv = jsonReader.nextInt();
                                } else if (b != 1) {
                                    jsonReader.skipValue();
                                } else {
                                    fxVar.s = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endObject();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                arrayList.add(fxVar);
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.adsdk.lottie.iz u(JsonReader jsonReader) throws IOException {
        float f;
        float fU = com.bytedance.adsdk.lottie.pn.a.u();
        LongSparseArray<com.bytedance.adsdk.lottie.model.layer.n> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.bytedance.adsdk.lottie.model.b> sparseArray = new SparseArray<>();
        iz.b bVar = new iz.b();
        iz.nr nrVar = new iz.nr();
        iz.fx fxVar = new iz.fx();
        iz.u uVar = new iz.u();
        com.bytedance.adsdk.lottie.iz izVar = new com.bytedance.adsdk.lottie.iz();
        jsonReader.beginObject();
        String strNextString = null;
        int iNextInt = 0;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case -1408207997:
                    f = fU;
                    if (strNextName.equals("assets")) {
                        b = 0;
                    }
                    break;
                case -1109732030:
                    f = fU;
                    if (strNextName.equals("layers")) {
                        b = 1;
                    }
                    break;
                case -865448777:
                    f = fU;
                    if (strNextName.equals("globalEvent")) {
                        b = 2;
                    }
                    break;
                case 104:
                    f = fU;
                    if (strNextName.equals("h")) {
                        b = 3;
                    }
                    break;
                case 118:
                    f = fU;
                    if (strNextName.equals("v")) {
                        b = 4;
                    }
                    break;
                case 119:
                    f = fU;
                    if (strNextName.equals(RXScreenCaptureService.KEY_WIDTH)) {
                        b = 5;
                    }
                    break;
                case 3208:
                    f = fU;
                    if (strNextName.equals(CmcdConfiguration.KEY_DEADLINE)) {
                        b = 6;
                    }
                    break;
                case 3276:
                    f = fU;
                    if (strNextName.equals("fr")) {
                        b = 7;
                    }
                    break;
                case 3292:
                    f = fU;
                    if (strNextName.equals(Launcher.Host.GC)) {
                        b = 8;
                    }
                    break;
                case 3367:
                    f = fU;
                    if (strNextName.equals("ip")) {
                        b = 9;
                    }
                    break;
                case 3553:
                    f = fU;
                    if (strNextName.equals(ConfigConstant.COLUMN_OP)) {
                        b = 10;
                    }
                    break;
                case 3002509:
                    f = fU;
                    if (strNextName.equals("area")) {
                        b = 11;
                    }
                    break;
                case 94623709:
                    f = fU;
                    if (strNextName.equals("chars")) {
                        b = 12;
                    }
                    break;
                case 97615364:
                    f = fU;
                    if (strNextName.equals("fonts")) {
                        b = dn.k;
                    }
                    break;
                case 110364485:
                    f = fU;
                    if (strNextName.equals("timer")) {
                        b = dn.l;
                    }
                    break;
                case 839250809:
                    f = fU;
                    if (strNextName.equals("markers")) {
                        b = 15;
                    }
                    break;
                default:
                    f = fU;
                    break;
            }
            switch (b) {
                case 0:
                    u(jsonReader, izVar, map, map2);
                    break;
                case 1:
                    u(jsonReader, izVar, arrayList, longSparseArray);
                    break;
                case 2:
                    u(jsonReader, fxVar);
                    break;
                case 3:
                    iNextInt2 = jsonReader.nextInt();
                    break;
                case 4:
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!com.bytedance.adsdk.lottie.pn.a.u(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        izVar.u("Lottie only supports bodymovin >= 4.4.0");
                    }
                    break;
                case 5:
                    iNextInt = jsonReader.nextInt();
                    break;
                case 6:
                    strNextString = jsonReader.nextString();
                    break;
                case 7:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 8:
                    u(jsonReader, nrVar);
                    break;
                case 9:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case 11:
                    u(jsonReader, uVar);
                    break;
                case 12:
                    u(jsonReader, izVar, sparseArray);
                    break;
                case 13:
                    u(jsonReader, map3);
                    break;
                case 14:
                    u(jsonReader, bVar);
                    break;
                case 15:
                    u(jsonReader, arrayList2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            fU = f;
        }
        float f2 = fU;
        jsonReader.endObject();
        izVar.u(new Rect(0, 0, (int) (iNextInt * f2), (int) (iNextInt2 * f2)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, longSparseArray, map, map2, sparseArray, map3, arrayList2, bVar, strNextString, nrVar, fxVar, uVar);
        return izVar;
    }

    private static Map<String, Object> nr(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("lel")) {
                map.put("lel", b(jsonReader));
            } else if (!strNextName.equals("lottie_back")) {
                jsonReader.skipValue();
            } else {
                JSONObject jSONObject = new JSONObject();
                map.put("lottie_back", jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.hashCode();
                    if (!strNextName2.equals(LiveConfigKey.HIGH)) {
                        jsonReader.skipValue();
                    } else {
                        try {
                            jSONObject.putOpt(LiveConfigKey.HIGH, Integer.valueOf(jsonReader.nextInt()));
                            jSONObject.putOpt(OapsKey.KEY_VERID, "lottie_back");
                        } catch (JSONException unused) {
                        }
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
        Object objRemove = map.remove("lottie_back");
        if (objRemove instanceof JSONObject) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(objRemove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(objRemove);
                map.put("lel", jSONArray);
            }
        }
        return map;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void u(JsonReader jsonReader, iz.u uVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 104) {
                    switch (iHashCode) {
                        case 119:
                            b = !strNextName.equals(RXScreenCaptureService.KEY_WIDTH) ? (byte) -1 : (byte) 2;
                            break;
                        case 120:
                            if (strNextName.equals("x")) {
                                b = 0;
                                break;
                            }
                            break;
                        case 121:
                            if (strNextName.equals("y")) {
                                b = 1;
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                } else if (strNextName.equals("h")) {
                    b = 3;
                }
                if (b == 0) {
                    uVar.u = jsonReader.nextString();
                } else if (b == 1) {
                    uVar.nr = jsonReader.nextString();
                } else if (b == 2) {
                    uVar.fx = jsonReader.nextString();
                } else if (b != 3) {
                    jsonReader.skipValue();
                } else {
                    uVar.b = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void u(JsonReader jsonReader, iz.fx fxVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3239) {
                    if (iHashCode != 107027) {
                        b = (iHashCode == 3237004 && strNextName.equals("inel")) ? (byte) 0 : (byte) -1;
                    } else if (strNextName.equals("lel")) {
                        b = 2;
                    }
                } else if (strNextName.equals(com.kuaishou.weapon.p0.t.n)) {
                    b = 1;
                }
                if (b == 0) {
                    fxVar.nr = new int[][]{new int[]{-1, -1}};
                    jsonReader.beginArray();
                    if (jsonReader.hasNext()) {
                        jsonReader.beginArray();
                        for (int i = 0; i < 2; i++) {
                            if (jsonReader.hasNext()) {
                                fxVar.nr[0][i] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                    }
                    jsonReader.endArray();
                } else if (b == 1) {
                    fxVar.u = jsonReader.nextString();
                } else if (b != 2) {
                    jsonReader.skipValue();
                } else {
                    fxVar.fx = b(jsonReader);
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void u(JsonReader jsonReader, iz.nr nrVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3139) {
                    if (iHashCode != 3232) {
                        if (iHashCode != 3571) {
                            if (iHashCode != 3666) {
                                b = (iHashCode == 98713 && strNextName.equals("cpf")) ? (byte) 4 : (byte) -1;
                            } else if (strNextName.equals("se")) {
                                b = 0;
                            }
                        } else if (strNextName.equals(com.kuaishou.weapon.p0.t.x)) {
                            b = 3;
                        }
                    } else if (strNextName.equals("ee")) {
                        b = 2;
                    }
                } else if (strNextName.equals("be")) {
                    b = 1;
                }
                if (b == 0) {
                    nrVar.u = jsonReader.nextInt();
                } else if (b == 1) {
                    nrVar.nr = nr(jsonReader);
                } else if (b == 2) {
                    nrVar.fx = nr(jsonReader);
                } else if (b == 3) {
                    nrVar.b = jsonReader.nextInt();
                } else if (b != 4) {
                    jsonReader.skipValue();
                } else {
                    nr(jsonReader, nrVar);
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void u(JsonReader jsonReader, iz.b bVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3123) {
                    if (iHashCode != 3239) {
                        if (iHashCode != 3355) {
                            if (iHashCode != 3418) {
                                if (iHashCode != 3459) {
                                    if (iHashCode != 3704) {
                                        if (iHashCode != 3708) {
                                            if (iHashCode != 104120) {
                                                if (iHashCode != 107027) {
                                                    b = (iHashCode == 3237004 && strNextName.equals("inel")) ? (byte) 4 : (byte) -1;
                                                } else if (strNextName.equals("lel")) {
                                                    b = 6;
                                                }
                                            } else if (strNextName.equals(OapsKey.KEY_IDS)) {
                                                b = 9;
                                            }
                                        } else if (strNextName.equals(OapsKey.KEY_TYPE)) {
                                            b = 8;
                                        }
                                    } else if (strNextName.equals("tl")) {
                                        b = 2;
                                    }
                                } else if (strNextName.equals("lo")) {
                                    b = 7;
                                }
                            } else if (strNextName.equals("ke")) {
                                b = 0;
                            }
                        } else if (strNextName.equals("id")) {
                            b = 1;
                        }
                    } else if (strNextName.equals(com.kuaishou.weapon.p0.t.n)) {
                        b = 5;
                    }
                } else if (strNextName.equals(com.kuaishou.weapon.p0.t.u)) {
                    b = 3;
                }
                switch (b) {
                    case 0:
                        bVar.u = jsonReader.nextInt();
                        break;
                    case 1:
                        bVar.nr = jsonReader.nextString();
                        break;
                    case 2:
                        bVar.fx = jsonReader.nextString();
                        break;
                    case 3:
                        bVar.b = jsonReader.nextString();
                        break;
                    case 4:
                        bVar.pn = new int[]{-1, -1};
                        jsonReader.beginArray();
                        for (int i = 0; i < 2; i++) {
                            if (jsonReader.hasNext()) {
                                bVar.pn[i] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                        break;
                    case 5:
                        bVar.iz = jsonReader.nextString();
                        break;
                    case 6:
                        bVar.x = b(jsonReader);
                        break;
                    case 7:
                        bVar.n = jsonReader.nextInt();
                        break;
                    case 8:
                        bVar.f4982a = jsonReader.nextInt();
                        break;
                    case 9:
                        bVar.jk = fx(jsonReader);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    private static void u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar, List<com.bytedance.adsdk.lottie.model.layer.n> list, LongSparseArray<com.bytedance.adsdk.lottie.model.layer.n> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.lottie.model.layer.n nVarU = c.u(jsonReader, izVar);
            if (nVarU.t() == n.u.IMAGE) {
                i++;
            }
            list.add(nVarU);
            longSparseArray.put(nVarU.pn(), nVarU);
            if (i > 4) {
                com.bytedance.adsdk.lottie.pn.pn.nr("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar, Map<String, List<com.bytedance.adsdk.lottie.model.layer.n>> map, Map<String, com.bytedance.adsdk.lottie.a> map2) throws IOException {
        byte b;
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            String strNextString4 = null;
            List<a.fx> listPn = null;
            String strNextString5 = null;
            int[][] iArr = null;
            JSONArray jSONArrayB = null;
            String strNextString6 = null;
            String strNextString7 = null;
            a.u uVar = null;
            a.nr nrVar = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName.hashCode()) {
                    case -1109732030:
                        b = strNextName.equals("layers") ? (byte) 0 : (byte) -1;
                        break;
                    case -925180581:
                        if (strNextName.equals(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
                            b = 1;
                            break;
                        }
                        break;
                    case -847116302:
                        if (strNextName.equals("ugen_v")) {
                            b = 2;
                            break;
                        }
                        break;
                    case 104:
                        if (strNextName.equals("h")) {
                            b = 3;
                            break;
                        }
                        break;
                    case 112:
                        if (strNextName.equals("p")) {
                            b = 4;
                            break;
                        }
                        break;
                    case 117:
                        if (strNextName.equals("u")) {
                            b = 5;
                            break;
                        }
                        break;
                    case 119:
                        if (strNextName.equals(RXScreenCaptureService.KEY_WIDTH)) {
                            b = 6;
                            break;
                        }
                        break;
                    case 3239:
                        if (strNextName.equals(com.kuaishou.weapon.p0.t.n)) {
                            b = 7;
                            break;
                        }
                        break;
                    case 3355:
                        if (strNextName.equals("id")) {
                            b = 8;
                            break;
                        }
                        break;
                    case 3633:
                        if (strNextName.equals("rc")) {
                            b = 9;
                            break;
                        }
                        break;
                    case 3695:
                        if (strNextName.equals("tc")) {
                            b = 10;
                            break;
                        }
                        break;
                    case 107027:
                        if (strNextName.equals("lel")) {
                            b = 11;
                            break;
                        }
                        break;
                    case 107902:
                        if (strNextName.equals("md5")) {
                            b = 12;
                            break;
                        }
                        break;
                    case 112793:
                        if (strNextName.equals("rel")) {
                            b = dn.k;
                            break;
                        }
                        break;
                    case 3237004:
                        if (strNextName.equals("inel")) {
                            b = dn.l;
                            break;
                        }
                        break;
                }
                switch (b) {
                    case 0:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.lottie.model.layer.n nVarU = c.u(jsonReader, izVar);
                            longSparseArray.put(nVarU.pn(), nVarU);
                            arrayList.add(nVarU);
                        }
                        jsonReader.endArray();
                        break;
                    case 1:
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                        } else {
                            a.nr nrVar2 = new a.nr();
                            jsonReader.beginObject();
                            u(jsonReader, nrVar2);
                            jsonReader.endObject();
                            nrVar = nrVar2;
                        }
                        break;
                    case 2:
                        strNextString7 = jsonReader.nextString();
                        break;
                    case 3:
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case 4:
                        strNextString2 = jsonReader.nextString();
                        break;
                    case 5:
                        strNextString3 = jsonReader.nextString();
                        break;
                    case 6:
                        iNextInt = jsonReader.nextInt();
                        break;
                    case 7:
                        strNextString5 = jsonReader.nextString();
                        break;
                    case 8:
                        strNextString = jsonReader.nextString();
                        break;
                    case 9:
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                        } else {
                            a.u uVar2 = new a.u();
                            jsonReader.beginObject();
                            u(jsonReader, uVar2);
                            jsonReader.endObject();
                            uVar = uVar2;
                        }
                        break;
                    case 10:
                        jsonReader.beginArray();
                        listPn = pn(jsonReader);
                        jsonReader.endArray();
                        break;
                    case 11:
                        jSONArrayB = b(jsonReader);
                        break;
                    case 12:
                        strNextString6 = jsonReader.nextString();
                        break;
                    case 13:
                        strNextString4 = jsonReader.nextString();
                        break;
                    case 14:
                        iArr = new int[][]{new int[]{-1, -1}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i = 0; i < 2; i++) {
                                if (jsonReader.hasNext()) {
                                    iArr[0][i] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.bytedance.adsdk.lottie.a aVar = new com.bytedance.adsdk.lottie.a(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3, strNextString4, listPn, strNextString5, iArr, jSONArrayB, strNextString6, strNextString7, uVar, nrVar);
                map2.put(aVar.l(), aVar);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void u(JsonReader jsonReader, a.u uVar) {
        byte b;
        while (jsonReader.hasNext()) {
            try {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != -2128704353) {
                    b = (iHashCode == 3308 && strNextName.equals("gs")) ? (byte) 1 : (byte) -1;
                } else if (strNextName.equals("is_secondary")) {
                    b = 0;
                }
                if (b == 0) {
                    uVar.nr = jsonReader.nextBoolean();
                } else if (b != 1) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    uVar.u = new a.u.C0163u();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        if (((strNextName2.hashCode() == 114 && strNextName2.equals(com.kuaishou.weapon.p0.t.k)) ? (byte) 0 : (byte) -1) != 0) {
                            jsonReader.skipValue();
                        } else {
                            uVar.u.u = (float) jsonReader.nextDouble();
                        }
                    }
                    jsonReader.endObject();
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void u(JsonReader jsonReader, a.nr nrVar) {
        byte b;
        while (jsonReader.hasNext()) {
            try {
                String strNextName = jsonReader.nextName();
                switch (strNextName.hashCode()) {
                    case 120:
                        b = !strNextName.equals("x") ? (byte) -1 : (byte) 0;
                        break;
                    case 121:
                        if (strNextName.equals("y")) {
                            b = 1;
                            break;
                        }
                        break;
                    case 122:
                        if (strNextName.equals("z")) {
                            b = 2;
                            break;
                        }
                        break;
                    default:
                        break;
                }
                if (b == 0) {
                    nrVar.u = jsonReader.nextInt();
                } else if (b == 1) {
                    nrVar.nr = jsonReader.nextInt();
                } else if (b != 2) {
                    jsonReader.skipValue();
                } else {
                    nrVar.fx = jsonReader.nextInt();
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    private static void u(JsonReader jsonReader, Map<String, com.bytedance.adsdk.lottie.model.fx> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (!strNextName.equals("list")) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.lottie.model.fx fxVarU = s.u(jsonReader);
                    map.put(fxVarU.nr(), fxVarU);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    private static void u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar, SparseArray<com.bytedance.adsdk.lottie.model.b> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.lottie.model.b bVarU = mv.u(jsonReader, izVar);
            sparseArray.put(bVarU.hashCode(), bVarU);
        }
        jsonReader.endArray();
    }

    private static void u(JsonReader jsonReader, List<com.bytedance.adsdk.lottie.model.iz> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            String strNextString = null;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "cm":
                        strNextString = jsonReader.nextString();
                        break;
                    case "dr":
                        fNextDouble2 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.bytedance.adsdk.lottie.model.iz(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}

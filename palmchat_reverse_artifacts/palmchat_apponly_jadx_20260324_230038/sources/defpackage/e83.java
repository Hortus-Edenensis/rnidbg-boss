package defpackage;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.lantern.core.configuration.ConfigConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class e83 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f17232a = JsonReader.a.a(RXScreenCaptureService.KEY_WIDTH, "h", "ip", ConfigConstant.COLUMN_OP, "fr", "v", "layers", "assets", "fonts", "chars", "markers");
    public static JsonReader.a b = JsonReader.a.a("id", "layers", RXScreenCaptureService.KEY_WIDTH, "h", "p", "u");
    public static final JsonReader.a c = JsonReader.a.a("list");
    public static final JsonReader.a d = JsonReader.a.a("cm", "tm", "dr");

    public static u73 a(JsonReader jsonReader) throws IOException {
        HashMap map;
        ArrayList arrayList;
        JsonReader jsonReader2 = jsonReader;
        float fE = r86.e();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<t02> sparseArrayCompat = new SparseArrayCompat<>();
        u73 u73Var = new u73();
        jsonReader.d();
        int iJ = 0;
        float fI = 0.0f;
        float fI2 = 0.0f;
        float fI3 = 0.0f;
        int iJ2 = 0;
        while (jsonReader.g()) {
            switch (jsonReader2.r(f17232a)) {
                case 0:
                    iJ = jsonReader.j();
                    break;
                case 1:
                    iJ2 = jsonReader.j();
                    break;
                case 2:
                    fI = (float) jsonReader.i();
                    break;
                case 3:
                    map = map4;
                    arrayList = arrayList3;
                    fI2 = ((float) jsonReader.i()) - 0.01f;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 4:
                    map = map4;
                    arrayList = arrayList3;
                    fI3 = (float) jsonReader.i();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 5:
                    String[] strArrSplit = jsonReader.m().split("\\.");
                    if (!r86.j(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        u73Var.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 6:
                    e(jsonReader2, u73Var, arrayList2, longSparseArray);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 7:
                    b(jsonReader2, u73Var, map2, map3);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 8:
                    d(jsonReader2, map4);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 9:
                    c(jsonReader2, u73Var, sparseArrayCompat);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 10:
                    f(jsonReader2, arrayList3);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                default:
                    map = map4;
                    arrayList = arrayList3;
                    jsonReader.s();
                    jsonReader.x();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
            }
            jsonReader2 = jsonReader;
        }
        u73Var.s(new Rect(0, 0, (int) (iJ * fE), (int) (iJ2 * fE)), fI, fI2, fI3, arrayList2, longSparseArray, map2, map3, sparseArrayCompat, map4, arrayList3);
        return u73Var;
    }

    public static void b(JsonReader jsonReader, u73 u73Var, Map<String, List<Layer>> map, Map<String, x83> map2) throws IOException {
        jsonReader.c();
        while (jsonReader.g()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.d();
            String strM = null;
            String strM2 = null;
            String strM3 = null;
            int iJ = 0;
            int iJ2 = 0;
            while (jsonReader.g()) {
                int iR = jsonReader.r(b);
                if (iR == 0) {
                    strM = jsonReader.m();
                } else if (iR == 1) {
                    jsonReader.c();
                    while (jsonReader.g()) {
                        Layer layerB = o13.b(jsonReader, u73Var);
                        longSparseArray.put(layerB.d(), layerB);
                        arrayList.add(layerB);
                    }
                    jsonReader.e();
                } else if (iR == 2) {
                    iJ = jsonReader.j();
                } else if (iR == 3) {
                    iJ2 = jsonReader.j();
                } else if (iR == 4) {
                    strM2 = jsonReader.m();
                } else if (iR != 5) {
                    jsonReader.s();
                    jsonReader.x();
                } else {
                    strM3 = jsonReader.m();
                }
            }
            jsonReader.f();
            if (strM2 != null) {
                x83 x83Var = new x83(iJ, iJ2, strM, strM2, strM3);
                map2.put(x83Var.d(), x83Var);
            } else {
                map.put(strM, arrayList);
            }
        }
        jsonReader.e();
    }

    public static void c(JsonReader jsonReader, u73 u73Var, SparseArrayCompat<t02> sparseArrayCompat) throws IOException {
        jsonReader.c();
        while (jsonReader.g()) {
            t02 t02VarA = u02.a(jsonReader, u73Var);
            sparseArrayCompat.put(t02VarA.hashCode(), t02VarA);
        }
        jsonReader.e();
    }

    public static void d(JsonReader jsonReader, Map<String, q02> map) throws IOException {
        jsonReader.d();
        while (jsonReader.g()) {
            if (jsonReader.r(c) != 0) {
                jsonReader.s();
                jsonReader.x();
            } else {
                jsonReader.c();
                while (jsonReader.g()) {
                    q02 q02VarA = w02.a(jsonReader);
                    map.put(q02VarA.b(), q02VarA);
                }
                jsonReader.e();
            }
        }
        jsonReader.f();
    }

    public static void e(JsonReader jsonReader, u73 u73Var, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.c();
        int i = 0;
        while (jsonReader.g()) {
            Layer layerB = o13.b(jsonReader, u73Var);
            if (layerB.f() == Layer.LayerType.IMAGE) {
                i++;
            }
            list.add(layerB);
            longSparseArray.put(layerB.d(), layerB);
            if (i > 4) {
                m63.c("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.e();
    }

    public static void f(JsonReader jsonReader, List<dd3> list) throws IOException {
        jsonReader.c();
        while (jsonReader.g()) {
            jsonReader.d();
            float fI = 0.0f;
            String strM = null;
            float fI2 = 0.0f;
            while (jsonReader.g()) {
                int iR = jsonReader.r(d);
                if (iR == 0) {
                    strM = jsonReader.m();
                } else if (iR == 1) {
                    fI = (float) jsonReader.i();
                } else if (iR != 2) {
                    jsonReader.s();
                    jsonReader.x();
                } else {
                    fI2 = (float) jsonReader.i();
                }
            }
            jsonReader.f();
            list.add(new dd3(strM, fI, fI2));
        }
        jsonReader.e();
    }
}

package defpackage;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.igexin.push.g.o;
import com.lantern.core.configuration.ConfigConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class o13 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f19654a = JsonReader.a.a("nm", "ind", "refId", MapBundleKey.MapObjKey.OBJ_TYPE, "parent", "sw", "sh", o.e, "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", RXScreenCaptureService.KEY_WIDTH, "h", "ip", ConfigConstant.COLUMN_OP, "tm", "cl", LiveConfigKey.HIGH);
    public static final JsonReader.a b = JsonReader.a.a("d", "a");
    public static final JsonReader.a c = JsonReader.a.a(MapBundleKey.MapObjKey.OBJ_TYPE, "nm");

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19655a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f19655a = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19655a[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Layer a(u73 u73Var) {
        Rect rectB = u73Var.b();
        return new Layer(Collections.emptyList(), u73Var, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new pd(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false, null, null);
    }

    public static Layer b(JsonReader jsonReader, u73 u73Var) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.d();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        String strM = "UNSET";
        Layer.LayerType layerType = null;
        String strM2 = null;
        pd pdVarG = null;
        md mdVarD = null;
        nd ndVarA = null;
        dd ddVarF = null;
        eu euVarB = null;
        ii1 ii1VarB = null;
        long j = 0;
        long j2 = -1;
        float fI = 0.0f;
        int iJ = 0;
        int iJ2 = 0;
        int color = 0;
        float fI2 = 1.0f;
        float fI3 = 0.0f;
        int iJ3 = 0;
        int iJ4 = 0;
        boolean zH = false;
        float f = 0.0f;
        String strM3 = null;
        while (jsonReader.g()) {
            switch (jsonReader.r(f19654a)) {
                case 0:
                    strM = jsonReader.m();
                    break;
                case 1:
                    j = jsonReader.j();
                    break;
                case 2:
                    strM2 = jsonReader.m();
                    break;
                case 3:
                    int iJ5 = jsonReader.j();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (iJ5 < layerType.ordinal()) {
                        layerType = Layer.LayerType.values()[iJ5];
                    }
                    break;
                case 4:
                    j2 = jsonReader.j();
                    break;
                case 5:
                    iJ = (int) (jsonReader.j() * r86.e());
                    break;
                case 6:
                    iJ2 = (int) (jsonReader.j() * r86.e());
                    break;
                case 7:
                    color = Color.parseColor(jsonReader.m());
                    break;
                case 8:
                    pdVarG = qd.g(jsonReader, u73Var);
                    break;
                case 9:
                    int iJ6 = jsonReader.j();
                    if (iJ6 < Layer.MatteType.values().length) {
                        matteType2 = Layer.MatteType.values()[iJ6];
                        int i = a.f19655a[matteType2.ordinal()];
                        if (i == 1) {
                            u73Var.a("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            u73Var.a("Unsupported matte type: Luma Inverted");
                        }
                        u73Var.r(1);
                    } else {
                        u73Var.a("Unsupported matte type: " + iJ6);
                    }
                    break;
                case 10:
                    jsonReader.c();
                    while (jsonReader.g()) {
                        arrayList3.add(id3.a(jsonReader, u73Var));
                    }
                    u73Var.r(arrayList3.size());
                    jsonReader.e();
                    break;
                case 11:
                    jsonReader.c();
                    while (jsonReader.g()) {
                        np0 np0VarA = op0.a(jsonReader, u73Var);
                        if (np0VarA != null) {
                            arrayList4.add(np0VarA);
                        }
                    }
                    jsonReader.e();
                    break;
                case 12:
                    jsonReader.d();
                    while (jsonReader.g()) {
                        int iR = jsonReader.r(b);
                        if (iR == 0) {
                            mdVarD = sd.d(jsonReader, u73Var);
                        } else if (iR != 1) {
                            jsonReader.s();
                            jsonReader.x();
                        } else {
                            jsonReader.c();
                            if (jsonReader.g()) {
                                ndVarA = od.a(jsonReader, u73Var);
                            }
                            while (jsonReader.g()) {
                                jsonReader.x();
                            }
                            jsonReader.e();
                        }
                    }
                    jsonReader.f();
                    break;
                case 13:
                    jsonReader.c();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.g()) {
                        jsonReader.d();
                        while (jsonReader.g()) {
                            int iR2 = jsonReader.r(c);
                            if (iR2 == 0) {
                                int iJ7 = jsonReader.j();
                                if (iJ7 == 29) {
                                    euVarB = fu.b(jsonReader, u73Var);
                                } else if (iJ7 == 25) {
                                    ii1VarB = new ji1().b(jsonReader, u73Var);
                                }
                            } else if (iR2 != 1) {
                                jsonReader.s();
                                jsonReader.x();
                            } else {
                                arrayList5.add(jsonReader.m());
                            }
                        }
                        jsonReader.f();
                    }
                    jsonReader.e();
                    u73Var.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    fI2 = (float) jsonReader.i();
                    break;
                case 15:
                    fI3 = (float) jsonReader.i();
                    break;
                case 16:
                    iJ3 = (int) (jsonReader.j() * r86.e());
                    break;
                case 17:
                    iJ4 = (int) (jsonReader.j() * r86.e());
                    break;
                case 18:
                    fI = (float) jsonReader.i();
                    break;
                case 19:
                    f = (float) jsonReader.i();
                    break;
                case 20:
                    ddVarF = sd.f(jsonReader, u73Var, false);
                    break;
                case 21:
                    strM3 = jsonReader.m();
                    break;
                case 22:
                    zH = jsonReader.h();
                    break;
                default:
                    jsonReader.s();
                    jsonReader.x();
                    break;
            }
        }
        jsonReader.f();
        ArrayList arrayList6 = new ArrayList();
        if (fI > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new h03(u73Var, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(fI)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f <= 0.0f) {
            f = u73Var.f();
        }
        arrayList2.add(new h03(u73Var, fValueOf, fValueOf, null, fI, Float.valueOf(f)));
        arrayList2.add(new h03(u73Var, fValueOf2, fValueOf2, null, f, Float.valueOf(Float.MAX_VALUE)));
        if (strM.endsWith(".ai") || "ai".equals(strM3)) {
            u73Var.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, u73Var, strM, j, layerType, j2, strM2, arrayList, pdVarG, iJ, iJ2, color, fI2, fI3, iJ3, iJ4, mdVarD, ndVarA, arrayList2, matteType2, ddVarF, zH, euVarB, ii1VarB);
    }
}

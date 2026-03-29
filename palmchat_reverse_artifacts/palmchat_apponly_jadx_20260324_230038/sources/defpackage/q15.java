package defpackage;

import android.graphics.Matrix;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.kuaishou.weapon.p0.t;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.Layout;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020*¢\u0006\u0004\b(\u0010+R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0011\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010!\u001a\u0004\b\u0019\u0010\"\"\u0004\b#\u0010$¨\u0006,"}, d2 = {"Lq15;", "", "", "a", "D", "()D", "setAlpha", "(D)V", "alpha", "Li15;", t.l, "Li15;", "()Li15;", "setLayout", "(Li15;)V", "layout", "Landroid/graphics/Matrix;", "c", "Landroid/graphics/Matrix;", "e", "()Landroid/graphics/Matrix;", "setTransform", "(Landroid/graphics/Matrix;)V", "transform", "Le15;", "d", "Le15;", "()Le15;", "setMaskPath", "(Le15;)V", "maskPath", "", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity;", "Ljava/util/List;", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "shapes", "Lorg/json/JSONObject;", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "<init>", "(Lorg/json/JSONObject;)V", "Lcom/opensource/svgaplayer/proto/FrameEntity;", "(Lcom/opensource/svgaplayer/proto/FrameEntity;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class q15 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public double alpha;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public i15 layout;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public Matrix transform;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public e15 maskPath;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public List<SVGAVideoShapeEntity> shapes;

    public q15(JSONObject jSONObject) {
        boolean z;
        q15 q15Var = this;
        q15Var.layout = new i15(0.0d, 0.0d, 0.0d, 0.0d);
        q15Var.transform = new Matrix();
        q15Var.shapes = CollectionsKt__CollectionsKt.emptyList();
        q15Var.alpha = jSONObject.optDouble("alpha", 0.0d);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("layout");
        if (jSONObjectOptJSONObject != null) {
            q15Var.layout = new i15(jSONObjectOptJSONObject.optDouble("x", 0.0d), jSONObjectOptJSONObject.optDouble("y", 0.0d), jSONObjectOptJSONObject.optDouble("width", 0.0d), jSONObjectOptJSONObject.optDouble("height", 0.0d));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("transform");
        if (jSONObjectOptJSONObject2 != null) {
            double dOptDouble = jSONObjectOptJSONObject2.optDouble("a", 1.0d);
            double dOptDouble2 = jSONObjectOptJSONObject2.optDouble(t.l, 0.0d);
            double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("c", 0.0d);
            double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("d", 1.0d);
            double dOptDouble5 = jSONObjectOptJSONObject2.optDouble(MapBundleKey.MapObjKey.OBJ_TEXT, 0.0d);
            double dOptDouble6 = jSONObjectOptJSONObject2.optDouble(MapBundleKey.MapObjKey.OBJ_TYPE, 0.0d);
            float f = (float) dOptDouble3;
            z = true;
            float f2 = (float) 0.0d;
            float[] fArr = {(float) dOptDouble, f, (float) dOptDouble5, (float) dOptDouble2, (float) dOptDouble4, (float) dOptDouble6, f2, f2, (float) 1.0d};
            q15Var = this;
            q15Var.transform.setValues(fArr);
        } else {
            z = true;
        }
        String strOptString = jSONObject.optString("clipPath");
        if (strOptString != null) {
            if (strOptString.length() <= 0 ? false : z) {
                q15Var.maskPath = new e15(strOptString);
            }
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("shapes");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject3 != null) {
                    arrayList.add(new SVGAVideoShapeEntity(jSONObjectOptJSONObject3));
                }
            }
            q15Var.shapes = CollectionsKt___CollectionsKt.toList(arrayList);
        }
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final double getAlpha() {
        return this.alpha;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final i15 getLayout() {
        return this.layout;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final e15 getMaskPath() {
        return this.maskPath;
    }

    public final List<SVGAVideoShapeEntity> d() {
        return this.shapes;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Matrix getTransform() {
        return this.transform;
    }

    public final void f(List<SVGAVideoShapeEntity> list) {
        this.shapes = list;
    }

    public q15(FrameEntity frameEntity) {
        this.layout = new i15(0.0d, 0.0d, 0.0d, 0.0d);
        this.transform = new Matrix();
        this.shapes = CollectionsKt__CollectionsKt.emptyList();
        this.alpha = frameEntity.alpha != null ? r0.floatValue() : 0.0f;
        Layout layout = frameEntity.layout;
        if (layout != null) {
            Float f = layout.x;
            double dFloatValue = f != null ? f.floatValue() : 0.0f;
            Float f2 = layout.y;
            double dFloatValue2 = f2 != null ? f2.floatValue() : 0.0f;
            Float f3 = layout.width;
            this.layout = new i15(dFloatValue, dFloatValue2, f3 != null ? f3.floatValue() : 0.0f, layout.height != null ? r0.floatValue() : 0.0f);
        }
        Transform transform = frameEntity.transform;
        if (transform != null) {
            float[] fArr = new float[9];
            Float f4 = transform.f7563a;
            float fFloatValue = f4 != null ? f4.floatValue() : 1.0f;
            Float f5 = transform.b;
            float fFloatValue2 = f5 != null ? f5.floatValue() : 0.0f;
            Float f6 = transform.c;
            float fFloatValue3 = f6 != null ? f6.floatValue() : 0.0f;
            Float f7 = transform.d;
            float fFloatValue4 = f7 != null ? f7.floatValue() : 1.0f;
            Float f8 = transform.tx;
            float fFloatValue5 = f8 != null ? f8.floatValue() : 0.0f;
            Float f9 = transform.ty;
            float fFloatValue6 = f9 != null ? f9.floatValue() : 0.0f;
            fArr[0] = fFloatValue;
            fArr[1] = fFloatValue3;
            fArr[2] = fFloatValue5;
            fArr[3] = fFloatValue2;
            fArr[4] = fFloatValue4;
            fArr[5] = fFloatValue6;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            this.transform.setValues(fArr);
        }
        String str = frameEntity.clipPath;
        if (str != null) {
            str = str.length() > 0 ? str : null;
            if (str != null) {
                this.maskPath = new e15(str);
            }
        }
        List<ShapeEntity> list = frameEntity.shapes;
        Intrinsics.checkExpressionValueIsNotNull(list, "obj.shapes");
        List<ShapeEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        for (ShapeEntity it : list2) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            arrayList.add(new SVGAVideoShapeEntity(it));
        }
        this.shapes = arrayList;
    }
}

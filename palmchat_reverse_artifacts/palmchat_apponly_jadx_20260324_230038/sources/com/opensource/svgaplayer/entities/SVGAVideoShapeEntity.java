package com.opensource.svgaplayer.entities;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.amap.api.col.p0002sl.hb;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.kuaishou.weapon.p0.t;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import defpackage.e15;
import defpackage.n15;
import defpackage.o15;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0003;B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b8\u00109B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0007¢\u0006\u0004\b8\u0010:J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002R$\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR@\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001d2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001d8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010!R(\u0010'\u001a\u0004\u0018\u00010#2\b\u0010\u0018\u001a\u0004\u0018\u00010#8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010&R(\u0010,\u001a\u0004\u0018\u00010(2\b\u0010\u0018\u001a\u0004\u0018\u00010(8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010+R$\u00103\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00107\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity;", "", "", "a", "Lorg/json/JSONObject;", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "q", "Lcom/opensource/svgaplayer/proto/ShapeEntity;", "p", t.f7496a, hb.j, "Lorg/json/JSONArray;", "", "e", "c", "m", "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeStyle$RGBAColor;", "color", "d", t.l, "l", "o", "n", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "<set-?>", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "getType", "()Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "type", "", "", "Ljava/util/Map;", "getArgs", "()Ljava/util/Map;", "args", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$a;", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$a;", "g", "()Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$a;", "styles", "Landroid/graphics/Matrix;", "Landroid/graphics/Matrix;", "h", "()Landroid/graphics/Matrix;", "transform", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "f", "()Landroid/graphics/Path;", "setShapePath", "(Landroid/graphics/Path;)V", "shapePath", "", "i", "()Z", "isKeep", "<init>", "(Lorg/json/JSONObject;)V", "(Lcom/opensource/svgaplayer/proto/ShapeEntity;)V", "Type", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class SVGAVideoShapeEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Type type = Type.shape;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public Map<String, ? extends Object> args;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public a styles;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public Matrix transform;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public Path shapePath;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "", "(Ljava/lang/String;I)V", "shape", "rect", "ellipse", "keep", "com.opensource.svgaplayer"}, k = 1, mv = {1, 1, 15})
    public enum Type {
        shape,
        rect,
        ellipse,
        keep
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R*\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR*\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\n\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001e\u0010\u001bR*\u0010!\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b \u0010\bR*\u0010'\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010#\u001a\u0004\b\u000f\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$a;", "", "", "<set-?>", "a", "I", "()I", "h", "(I)V", "fill", t.l, "f", "m", "stroke", "", "c", "F", "g", "()F", "n", "(F)V", "strokeWidth", "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "lineCap", "e", t.f7496a, "lineJoin", "l", "miterLimit", "", "[F", "()[F", hb.j, "([F)V", "lineDash", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public int fill;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public int stroke;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public float strokeWidth;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public int miterLimit;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public String lineCap = "butt";

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public String lineJoin = "miter";

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public float[] lineDash = new float[0];

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getFill() {
            return this.fill;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getLineCap() {
            return this.lineCap;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final float[] getLineDash() {
            return this.lineDash;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final String getLineJoin() {
            return this.lineJoin;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final int getMiterLimit() {
            return this.miterLimit;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final int getStroke() {
            return this.stroke;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final float getStrokeWidth() {
            return this.strokeWidth;
        }

        public final void h(int i) {
            this.fill = i;
        }

        public final void i(String str) {
            this.lineCap = str;
        }

        public final void j(float[] fArr) {
            this.lineDash = fArr;
        }

        public final void k(String str) {
            this.lineJoin = str;
        }

        public final void l(int i) {
            this.miterLimit = i;
        }

        public final void m(int i) {
            this.stroke = i;
        }

        public final void n(float f) {
            this.strokeWidth = f;
        }
    }

    public SVGAVideoShapeEntity(JSONObject jSONObject) throws JSONException {
        q(jSONObject);
        k(jSONObject);
        m(jSONObject);
        o(jSONObject);
    }

    public final void a() {
        if (this.shapePath != null) {
            return;
        }
        o15.a().reset();
        Type type = this.type;
        if (type == Type.shape) {
            Map<String, ? extends Object> map = this.args;
            Object obj = map != null ? map.get("d") : null;
            String str = (String) (obj instanceof String ? obj : null);
            if (str != null) {
                new e15(str).a(o15.a());
            }
        } else if (type == Type.ellipse) {
            Map<String, ? extends Object> map2 = this.args;
            Object obj2 = map2 != null ? map2.get("x") : null;
            if (!(obj2 instanceof Number)) {
                obj2 = null;
            }
            Number number = (Number) obj2;
            if (number == null) {
                return;
            }
            Map<String, ? extends Object> map3 = this.args;
            Object obj3 = map3 != null ? map3.get("y") : null;
            if (!(obj3 instanceof Number)) {
                obj3 = null;
            }
            Number number2 = (Number) obj3;
            if (number2 == null) {
                return;
            }
            Map<String, ? extends Object> map4 = this.args;
            Object obj4 = map4 != null ? map4.get("radiusX") : null;
            if (!(obj4 instanceof Number)) {
                obj4 = null;
            }
            Number number3 = (Number) obj4;
            if (number3 == null) {
                return;
            }
            Map<String, ? extends Object> map5 = this.args;
            Object obj5 = map5 != null ? map5.get("radiusY") : null;
            Number number4 = (Number) (obj5 instanceof Number ? obj5 : null);
            if (number4 == null) {
                return;
            }
            float fFloatValue = number.floatValue();
            float fFloatValue2 = number2.floatValue();
            float fFloatValue3 = number3.floatValue();
            float fFloatValue4 = number4.floatValue();
            o15.a().addOval(new RectF(fFloatValue - fFloatValue3, fFloatValue2 - fFloatValue4, fFloatValue + fFloatValue3, fFloatValue2 + fFloatValue4), Path.Direction.CW);
        } else if (type == Type.rect) {
            Map<String, ? extends Object> map6 = this.args;
            Object obj6 = map6 != null ? map6.get("x") : null;
            if (!(obj6 instanceof Number)) {
                obj6 = null;
            }
            Number number5 = (Number) obj6;
            if (number5 == null) {
                return;
            }
            Map<String, ? extends Object> map7 = this.args;
            Object obj7 = map7 != null ? map7.get("y") : null;
            if (!(obj7 instanceof Number)) {
                obj7 = null;
            }
            Number number6 = (Number) obj7;
            if (number6 == null) {
                return;
            }
            Map<String, ? extends Object> map8 = this.args;
            Object obj8 = map8 != null ? map8.get("width") : null;
            if (!(obj8 instanceof Number)) {
                obj8 = null;
            }
            Number number7 = (Number) obj8;
            if (number7 == null) {
                return;
            }
            Map<String, ? extends Object> map9 = this.args;
            Object obj9 = map9 != null ? map9.get("height") : null;
            if (!(obj9 instanceof Number)) {
                obj9 = null;
            }
            Number number8 = (Number) obj9;
            if (number8 == null) {
                return;
            }
            Map<String, ? extends Object> map10 = this.args;
            Object obj10 = map10 != null ? map10.get("cornerRadius") : null;
            Number number9 = (Number) (obj10 instanceof Number ? obj10 : null);
            if (number9 == null) {
                return;
            }
            float fFloatValue5 = number5.floatValue();
            float fFloatValue6 = number6.floatValue();
            float fFloatValue7 = number7.floatValue();
            float fFloatValue8 = number8.floatValue();
            float fFloatValue9 = number9.floatValue();
            o15.a().addRoundRect(new RectF(fFloatValue5, fFloatValue6, fFloatValue7 + fFloatValue5, fFloatValue8 + fFloatValue6), fFloatValue9, fFloatValue9, Path.Direction.CW);
        }
        Path path = new Path();
        this.shapePath = path;
        path.set(o15.a());
    }

    public final float b(ShapeEntity.ShapeStyle.RGBAColor color) {
        return color.f7561a.floatValue() <= 1.0f ? 255.0f : 1.0f;
    }

    public final float c(JSONArray obj) {
        return obj.optDouble(3) <= ((double) 1) ? 255.0f : 1.0f;
    }

    public final float d(ShapeEntity.ShapeStyle.RGBAColor color) {
        Float f = color.r;
        float f2 = 1;
        if ((f != null ? f.floatValue() : 0.0f) <= f2) {
            Float f3 = color.g;
            if ((f3 != null ? f3.floatValue() : 0.0f) <= f2) {
                Float f4 = color.b;
                if ((f4 != null ? f4.floatValue() : 0.0f) <= f2) {
                    return 255.0f;
                }
            }
        }
        return 1.0f;
    }

    public final float e(JSONArray obj) {
        double d = 1;
        return (obj.optDouble(0) > d || obj.optDouble(1) > d || obj.optDouble(2) > d) ? 1.0f : 255.0f;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final Path getShapePath() {
        return this.shapePath;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final a getStyles() {
        return this.styles;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final Matrix getTransform() {
        return this.transform;
    }

    public final boolean i() {
        return this.type == Type.keep;
    }

    public final void j(ShapeEntity obj) {
        String str;
        HashMap map = new HashMap();
        ShapeEntity.ShapeArgs shapeArgs = obj.shape;
        if (shapeArgs != null && (str = shapeArgs.d) != null) {
            map.put("d", str);
        }
        ShapeEntity.EllipseArgs ellipseArgs = obj.ellipse;
        if (ellipseArgs != null) {
            Float fValueOf = ellipseArgs.x;
            if (fValueOf == null) {
                fValueOf = Float.valueOf(0.0f);
            }
            map.put("x", fValueOf);
            Float fValueOf2 = ellipseArgs.y;
            if (fValueOf2 == null) {
                fValueOf2 = Float.valueOf(0.0f);
            }
            map.put("y", fValueOf2);
            Float fValueOf3 = ellipseArgs.radiusX;
            if (fValueOf3 == null) {
                fValueOf3 = Float.valueOf(0.0f);
            }
            map.put("radiusX", fValueOf3);
            Float fValueOf4 = ellipseArgs.radiusY;
            if (fValueOf4 == null) {
                fValueOf4 = Float.valueOf(0.0f);
            }
            map.put("radiusY", fValueOf4);
        }
        ShapeEntity.RectArgs rectArgs = obj.rect;
        if (rectArgs != null) {
            Float fValueOf5 = rectArgs.x;
            if (fValueOf5 == null) {
                fValueOf5 = Float.valueOf(0.0f);
            }
            map.put("x", fValueOf5);
            Float fValueOf6 = rectArgs.y;
            if (fValueOf6 == null) {
                fValueOf6 = Float.valueOf(0.0f);
            }
            map.put("y", fValueOf6);
            Float fValueOf7 = rectArgs.width;
            if (fValueOf7 == null) {
                fValueOf7 = Float.valueOf(0.0f);
            }
            map.put("width", fValueOf7);
            Float fValueOf8 = rectArgs.height;
            if (fValueOf8 == null) {
                fValueOf8 = Float.valueOf(0.0f);
            }
            map.put("height", fValueOf8);
            Float fValueOf9 = rectArgs.cornerRadius;
            if (fValueOf9 == null) {
                fValueOf9 = Float.valueOf(0.0f);
            }
            map.put("cornerRadius", fValueOf9);
        }
        this.args = map;
    }

    public final void k(JSONObject obj) throws JSONException {
        HashMap map = new HashMap();
        JSONObject jSONObjectOptJSONObject = obj.optJSONObject("args");
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            Intrinsics.checkExpressionValueIsNotNull(itKeys, "values.keys()");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj2 = jSONObjectOptJSONObject.get(next);
                if (obj2 != null) {
                    map.put(next, obj2);
                }
            }
            this.args = map;
        }
    }

    public final void l(ShapeEntity obj) {
        ShapeEntity.ShapeStyle shapeStyle = obj.styles;
        if (shapeStyle != null) {
            a aVar = new a();
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor = shapeStyle.fill;
            if (rGBAColor != null) {
                float fD = d(rGBAColor);
                float fB = b(rGBAColor);
                Float f = rGBAColor.f7561a;
                int iFloatValue = (int) ((f != null ? f.floatValue() : 0.0f) * fB);
                Float f2 = rGBAColor.r;
                int iFloatValue2 = (int) ((f2 != null ? f2.floatValue() : 0.0f) * fD);
                Float f3 = rGBAColor.g;
                int iFloatValue3 = (int) ((f3 != null ? f3.floatValue() : 0.0f) * fD);
                Float f4 = rGBAColor.b;
                aVar.h(Color.argb(iFloatValue, iFloatValue2, iFloatValue3, (int) ((f4 != null ? f4.floatValue() : 0.0f) * fD)));
            }
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor2 = shapeStyle.stroke;
            if (rGBAColor2 != null) {
                float fD2 = d(rGBAColor2);
                float fB2 = b(rGBAColor2);
                Float f5 = rGBAColor2.f7561a;
                int iFloatValue4 = (int) ((f5 != null ? f5.floatValue() : 0.0f) * fB2);
                Float f6 = rGBAColor2.r;
                int iFloatValue5 = (int) ((f6 != null ? f6.floatValue() : 0.0f) * fD2);
                Float f7 = rGBAColor2.g;
                int iFloatValue6 = (int) ((f7 != null ? f7.floatValue() : 0.0f) * fD2);
                Float f8 = rGBAColor2.b;
                aVar.m(Color.argb(iFloatValue4, iFloatValue5, iFloatValue6, (int) ((f8 != null ? f8.floatValue() : 0.0f) * fD2)));
            }
            Float f9 = shapeStyle.strokeWidth;
            aVar.n(f9 != null ? f9.floatValue() : 0.0f);
            ShapeEntity.ShapeStyle.LineCap lineCap = shapeStyle.lineCap;
            if (lineCap != null) {
                int i = n15.$EnumSwitchMapping$1[lineCap.ordinal()];
                if (i == 1) {
                    aVar.i("butt");
                } else if (i == 2) {
                    aVar.i("round");
                } else if (i == 3) {
                    aVar.i("square");
                }
            }
            ShapeEntity.ShapeStyle.LineJoin lineJoin = shapeStyle.lineJoin;
            if (lineJoin != null) {
                int i2 = n15.$EnumSwitchMapping$2[lineJoin.ordinal()];
                if (i2 == 1) {
                    aVar.k("bevel");
                } else if (i2 == 2) {
                    aVar.k("miter");
                } else if (i2 == 3) {
                    aVar.k("round");
                }
            }
            Float f10 = shapeStyle.miterLimit;
            aVar.l((int) (f10 != null ? f10.floatValue() : 0.0f));
            aVar.j(new float[3]);
            Float f11 = shapeStyle.lineDashI;
            if (f11 != null) {
                aVar.getLineDash()[0] = f11.floatValue();
            }
            Float f12 = shapeStyle.lineDashII;
            if (f12 != null) {
                aVar.getLineDash()[1] = f12.floatValue();
            }
            Float f13 = shapeStyle.lineDashIII;
            if (f13 != null) {
                aVar.getLineDash()[2] = f13.floatValue();
            }
            this.styles = aVar;
        }
    }

    public final void m(JSONObject obj) {
        JSONObject jSONObjectOptJSONObject = obj.optJSONObject("styles");
        if (jSONObjectOptJSONObject != null) {
            a aVar = new a();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("fill");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 4) {
                double dE = e(jSONArrayOptJSONArray);
                aVar.h(Color.argb((int) (jSONArrayOptJSONArray.optDouble(3) * ((double) c(jSONArrayOptJSONArray))), (int) (jSONArrayOptJSONArray.optDouble(0) * dE), (int) (jSONArrayOptJSONArray.optDouble(1) * dE), (int) (jSONArrayOptJSONArray.optDouble(2) * dE)));
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("stroke");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() == 4) {
                double dE2 = e(jSONArrayOptJSONArray2);
                aVar.m(Color.argb((int) (jSONArrayOptJSONArray2.optDouble(3) * ((double) c(jSONArrayOptJSONArray2))), (int) (jSONArrayOptJSONArray2.optDouble(0) * dE2), (int) (jSONArrayOptJSONArray2.optDouble(1) * dE2), (int) (jSONArrayOptJSONArray2.optDouble(2) * dE2)));
            }
            aVar.n((float) jSONObjectOptJSONObject.optDouble("strokeWidth", 0.0d));
            String strOptString = jSONObjectOptJSONObject.optString("lineCap", "butt");
            Intrinsics.checkExpressionValueIsNotNull(strOptString, "it.optString(\"lineCap\", \"butt\")");
            aVar.i(strOptString);
            String strOptString2 = jSONObjectOptJSONObject.optString("lineJoin", "miter");
            Intrinsics.checkExpressionValueIsNotNull(strOptString2, "it.optString(\"lineJoin\", \"miter\")");
            aVar.k(strOptString2);
            aVar.l(jSONObjectOptJSONObject.optInt("miterLimit", 0));
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("lineDash");
            if (jSONArrayOptJSONArray3 != null) {
                aVar.j(new float[jSONArrayOptJSONArray3.length()]);
                int length = jSONArrayOptJSONArray3.length();
                for (int i = 0; i < length; i++) {
                    aVar.getLineDash()[i] = (float) jSONArrayOptJSONArray3.optDouble(i, 0.0d);
                }
            }
            this.styles = aVar;
        }
    }

    public final void n(ShapeEntity obj) {
        Transform transform = obj.transform;
        if (transform != null) {
            Matrix matrix = new Matrix();
            float[] fArr = new float[9];
            Float f = transform.f7563a;
            float fFloatValue = f != null ? f.floatValue() : 1.0f;
            Float f2 = transform.b;
            float fFloatValue2 = f2 != null ? f2.floatValue() : 0.0f;
            Float f3 = transform.c;
            float fFloatValue3 = f3 != null ? f3.floatValue() : 0.0f;
            Float f4 = transform.d;
            float fFloatValue4 = f4 != null ? f4.floatValue() : 1.0f;
            Float f5 = transform.tx;
            float fFloatValue5 = f5 != null ? f5.floatValue() : 0.0f;
            Float f6 = transform.ty;
            float fFloatValue6 = f6 != null ? f6.floatValue() : 0.0f;
            fArr[0] = fFloatValue;
            fArr[1] = fFloatValue3;
            fArr[2] = fFloatValue5;
            fArr[3] = fFloatValue2;
            fArr[4] = fFloatValue4;
            fArr[5] = fFloatValue6;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            matrix.setValues(fArr);
            this.transform = matrix;
        }
    }

    public final void o(JSONObject obj) {
        JSONObject jSONObjectOptJSONObject = obj.optJSONObject("transform");
        if (jSONObjectOptJSONObject != null) {
            Matrix matrix = new Matrix();
            double dOptDouble = jSONObjectOptJSONObject.optDouble("a", 1.0d);
            double dOptDouble2 = jSONObjectOptJSONObject.optDouble(t.l, 0.0d);
            double dOptDouble3 = jSONObjectOptJSONObject.optDouble("c", 0.0d);
            double dOptDouble4 = jSONObjectOptJSONObject.optDouble("d", 1.0d);
            double dOptDouble5 = jSONObjectOptJSONObject.optDouble(MapBundleKey.MapObjKey.OBJ_TEXT, 0.0d);
            double dOptDouble6 = jSONObjectOptJSONObject.optDouble(MapBundleKey.MapObjKey.OBJ_TYPE, 0.0d);
            float f = (float) 0.0d;
            matrix.setValues(new float[]{(float) dOptDouble, (float) dOptDouble3, (float) dOptDouble5, (float) dOptDouble2, (float) dOptDouble4, (float) dOptDouble6, f, f, (float) 1.0d});
            this.transform = matrix;
        }
    }

    public final void p(ShapeEntity obj) {
        Type type;
        ShapeEntity.ShapeType shapeType = obj.type;
        if (shapeType != null) {
            int i = n15.$EnumSwitchMapping$0[shapeType.ordinal()];
            if (i == 1) {
                type = Type.shape;
            } else if (i == 2) {
                type = Type.rect;
            } else if (i == 3) {
                type = Type.ellipse;
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                type = Type.keep;
            }
            this.type = type;
        }
    }

    public final void q(JSONObject obj) {
        String strOptString = obj.optString("type");
        if (strOptString != null) {
            if (StringsKt__StringsJVMKt.equals(strOptString, "shape", true)) {
                this.type = Type.shape;
                return;
            }
            if (StringsKt__StringsJVMKt.equals(strOptString, "rect", true)) {
                this.type = Type.rect;
            } else if (StringsKt__StringsJVMKt.equals(strOptString, "ellipse", true)) {
                this.type = Type.ellipse;
            } else if (StringsKt__StringsJVMKt.equals(strOptString, "keep", true)) {
                this.type = Type.keep;
            }
        }
    }

    public SVGAVideoShapeEntity(ShapeEntity shapeEntity) {
        p(shapeEntity);
        j(shapeEntity);
        l(shapeEntity);
        n(shapeEntity);
    }
}

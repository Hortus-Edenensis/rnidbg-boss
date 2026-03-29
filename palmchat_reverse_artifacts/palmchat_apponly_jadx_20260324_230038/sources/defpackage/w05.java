package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.os.Build;
import android.text.BoringLayout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.ImageView;
import com.amap.api.col.p0002sl.hb;
import com.kuaishou.weapon.p0.t;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import defpackage.xz4;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0002\t>B\u0017\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u00109\u001a\u000205¢\u0006\u0004\b<\u0010=J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00042\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\fR\u00020\u00010\u000bH\u0002J\"\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00042\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\fR\u00020\u00010\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J$\u0010\u0016\u001a\u00020\b2\n\u0010\u0015\u001a\u00060\fR\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0017\u001a\u00020\b2\n\u0010\u0015\u001a\u00060\fR\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\n\u0010\u0015\u001a\u00060\fR\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u001c\u0010\u001c\u001a\u00020\b2\n\u0010\u0015\u001a\u00060\fR\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J$\u0010 \u001a\u00020\b2\n\u0010\u0015\u001a\u00060\fR\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R0\u0010*\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00180%j\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0018`'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010,R\u001e\u00100\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010/R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010/R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u00103R\u0017\u00109\u001a\u0002058\u0006¢\u0006\f\n\u0004\b\u001b\u00106\u001a\u0004\b7\u00108¨\u0006?"}, d2 = {"Lw05;", "Lxz4;", "Landroid/graphics/Canvas;", "canvas", "", "frameIndex", "Landroid/widget/ImageView$ScaleType;", "scaleType", "", "a", "spriteIndex", "", "Lxz4$a;", "sprites", "", t.f7496a, "l", "n", "Landroid/graphics/Matrix;", "transform", "o", "sprite", "i", "g", "Landroid/graphics/Bitmap;", "drawingBitmap", "frameMatrix", hb.j, "h", "matrix", "", "m", "f", "Lw05$b;", "d", "Lw05$b;", "sharedValues", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "drawTextCache", "Lw05$a;", "Lw05$a;", "pathCache", "", "[Ljava/lang/Boolean;", "beginIndexList", "endIndexList", "", "[F", "matrixScaleTempValues", "Lz05;", "Lz05;", "getDynamicItem", "()Lz05;", "dynamicItem", "Lm15;", "videoItem", "<init>", "(Lm15;Lz05;)V", t.l, "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class w05 extends xz4 {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final b sharedValues;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final HashMap<String, Bitmap> drawTextCache;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final a pathCache;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public Boolean[] beginIndexList;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public Boolean[] endIndexList;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final float[] matrixScaleTempValues;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final z05 dynamicItem;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lw05$a;", "", "Landroid/graphics/Canvas;", "canvas", "", t.l, "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity;", "shape", "Landroid/graphics/Path;", "a", "", "I", "canvasWidth", "canvasHeight", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "cache", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public int canvasWidth;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public int canvasHeight;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final HashMap<SVGAVideoShapeEntity, Path> cache = new HashMap<>();

        public final Path a(SVGAVideoShapeEntity shape) {
            if (!this.cache.containsKey(shape)) {
                Path path = new Path();
                path.set(shape.getShapePath());
                this.cache.put(shape, path);
            }
            Path path2 = this.cache.get(shape);
            if (path2 == null) {
                Intrinsics.throwNpe();
            }
            return path2;
        }

        public final void b(Canvas canvas) {
            if (this.canvasWidth != canvas.getWidth() || this.canvasHeight != canvas.getHeight()) {
                this.cache.clear();
            }
            this.canvasWidth = canvas.getWidth();
            this.canvasHeight = canvas.getHeight();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001d¨\u0006!"}, d2 = {"Lw05$b;", "", "Landroid/graphics/Paint;", "f", "Landroid/graphics/Path;", "g", "h", "Landroid/graphics/Matrix;", "c", "d", t.l, "Landroid/graphics/Bitmap;", "e", "", "width", "height", "Landroid/graphics/Canvas;", "a", "Landroid/graphics/Paint;", "sharedPaint", "Landroid/graphics/Path;", "sharedPath", "sharedPath2", "Landroid/graphics/Matrix;", "sharedMatrix", "sharedMatrix2", "shareMattePaint", "Landroid/graphics/Canvas;", "shareMatteCanvas", "Landroid/graphics/Bitmap;", "sharedMatteBitmap", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Paint sharedPaint = new Paint();

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final Path sharedPath = new Path();

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final Path sharedPath2 = new Path();

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public final Matrix sharedMatrix = new Matrix();

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public final Matrix sharedMatrix2 = new Matrix();

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public final Paint shareMattePaint = new Paint();

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public Canvas shareMatteCanvas;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public Bitmap sharedMatteBitmap;

        public final Canvas a(int width, int height) {
            if (this.shareMatteCanvas == null) {
                this.sharedMatteBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ALPHA_8);
            }
            return new Canvas(this.sharedMatteBitmap);
        }

        public final Paint b() {
            this.shareMattePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            return this.shareMattePaint;
        }

        public final Matrix c() {
            this.sharedMatrix.reset();
            return this.sharedMatrix;
        }

        public final Matrix d() {
            this.sharedMatrix2.reset();
            return this.sharedMatrix2;
        }

        public final Bitmap e() {
            Bitmap bitmap = this.sharedMatteBitmap;
            if (bitmap != null) {
                return bitmap;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
        }

        public final Paint f() {
            this.sharedPaint.reset();
            return this.sharedPaint;
        }

        public final Path g() {
            this.sharedPath.reset();
            return this.sharedPath;
        }

        public final Path h() {
            this.sharedPath2.reset();
            return this.sharedPath2;
        }
    }

    public w05(m15 m15Var, z05 z05Var) {
        super(m15Var);
        this.dynamicItem = z05Var;
        this.sharedValues = new b();
        this.drawTextCache = new HashMap<>();
        this.pathCache = new a();
        this.matrixScaleTempValues = new float[16];
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    @Override // defpackage.xz4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Canvas canvas, int frameIndex, ImageView.ScaleType scaleType) {
        xz4.a aVar;
        int i;
        int i2;
        xz4.a aVar2;
        super.a(canvas, frameIndex, scaleType);
        n(frameIndex);
        this.pathCache.b(canvas);
        List<xz4.a> listE = e(frameIndex);
        if (listE.size() <= 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object obj = null;
        this.beginIndexList = null;
        this.endIndexList = null;
        boolean z = false;
        String str = listE.get(0).get_imageKey();
        int i3 = 2;
        boolean zEndsWith$default = str != null ? StringsKt__StringsJVMKt.endsWith$default(str, ".matte", false, 2, null) : false;
        int iSaveLayer = -1;
        int i4 = 0;
        for (Object obj2 : listE) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            xz4.a aVar3 = (xz4.a) obj2;
            String str2 = aVar3.get_imageKey();
            if (str2 == null) {
                if (k(i4, listE)) {
                    aVar = aVar3;
                    i = i4;
                    i2 = -1;
                } else {
                    aVar = aVar3;
                    i = i4;
                    i2 = -1;
                    iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
                }
                i(aVar, canvas, frameIndex);
                if (!l(i, listE) && (aVar2 = (xz4.a) linkedHashMap.get(aVar.get_matteKey())) != null) {
                    i(aVar2, this.sharedValues.a(canvas.getWidth(), canvas.getHeight()), frameIndex);
                    canvas.drawBitmap(this.sharedValues.e(), 0.0f, 0.0f, this.sharedValues.b());
                    if (iSaveLayer != i2) {
                        canvas.restoreToCount(iSaveLayer);
                    } else {
                        canvas.restore();
                    }
                }
            } else if (zEndsWith$default) {
                if (StringsKt__StringsJVMKt.endsWith$default(str2, ".matte", z, i3, obj)) {
                    linkedHashMap.put(str2, aVar3);
                }
                if (k(i4, listE)) {
                }
                i(aVar, canvas, frameIndex);
                if (!l(i, listE)) {
                }
            } else {
                i(aVar3, canvas, frameIndex);
            }
            i4 = i5;
            obj = null;
            z = false;
            i3 = 2;
        }
        d(listE);
    }

    public final void f(xz4.a sprite, Canvas canvas, int frameIndex) {
        String str = sprite.get_imageKey();
        if (str != null) {
            Function2<Canvas, Integer, Boolean> function2 = this.dynamicItem.b().get(str);
            if (function2 != null) {
                Matrix matrixO = o(sprite.a().getTransform());
                canvas.save();
                canvas.concat(matrixO);
                function2.mo5invoke(canvas, Integer.valueOf(frameIndex));
                canvas.restore();
            }
            Function4<Canvas, Integer, Integer, Integer, Boolean> function4 = this.dynamicItem.c().get(str);
            if (function4 != null) {
                Matrix matrixO2 = o(sprite.a().getTransform());
                canvas.save();
                canvas.concat(matrixO2);
                function4.invoke(canvas, Integer.valueOf(frameIndex), Integer.valueOf((int) sprite.a().getLayout().getWidth()), Integer.valueOf((int) sprite.a().getLayout().getHeight()));
                canvas.restore();
            }
        }
    }

    public final void g(xz4.a sprite, Canvas canvas) {
        String strSubstring;
        String str = sprite.get_imageKey();
        if (str == null || Intrinsics.areEqual(this.dynamicItem.d().get(str), Boolean.TRUE)) {
            return;
        }
        if (StringsKt__StringsJVMKt.endsWith$default(str, ".matte", false, 2, null)) {
            strSubstring = str.substring(0, str.length() - 6);
            Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        } else {
            strSubstring = str;
        }
        Bitmap bitmap = this.dynamicItem.f().get(strSubstring);
        if (bitmap == null) {
            bitmap = getVideoItem().o().get(strSubstring);
        }
        Bitmap bitmap2 = bitmap;
        if (bitmap2 != null) {
            Matrix matrixO = o(sprite.a().getTransform());
            Paint paintF = this.sharedValues.f();
            paintF.setAntiAlias(getVideoItem().getAntiAlias());
            paintF.setFilterBitmap(getVideoItem().getAntiAlias());
            paintF.setAlpha((int) (sprite.a().getAlpha() * ((double) 255)));
            if (sprite.a().getMaskPath() != null) {
                e15 maskPath = sprite.a().getMaskPath();
                if (maskPath == null) {
                    return;
                }
                canvas.save();
                Path pathG = this.sharedValues.g();
                maskPath.a(pathG);
                pathG.transform(matrixO);
                canvas.clipPath(pathG);
                matrixO.preScale((float) (sprite.a().getLayout().getWidth() / ((double) bitmap2.getWidth())), (float) (sprite.a().getLayout().getHeight() / ((double) bitmap2.getHeight())));
                if (!bitmap2.isRecycled()) {
                    canvas.drawBitmap(bitmap2, matrixO, paintF);
                }
                canvas.restore();
            } else {
                matrixO.preScale((float) (sprite.a().getLayout().getWidth() / ((double) bitmap2.getWidth())), (float) (sprite.a().getLayout().getHeight() / ((double) bitmap2.getHeight())));
                if (!bitmap2.isRecycled()) {
                    canvas.drawBitmap(bitmap2, matrixO, paintF);
                }
            }
            vk2 vk2Var = this.dynamicItem.e().get(str);
            if (vk2Var != null) {
                float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                matrixO.getValues(fArr);
                vk2Var.a(str, (int) fArr[2], (int) fArr[5], (int) ((bitmap2.getWidth() * fArr[0]) + fArr[2]), (int) ((bitmap2.getHeight() * fArr[4]) + fArr[5]));
            }
            j(canvas, bitmap2, sprite, matrixO);
        }
    }

    public final void h(xz4.a sprite, Canvas canvas) {
        float[] lineDash;
        String lineJoin;
        String lineCap;
        int fill;
        Matrix matrixO = o(sprite.a().getTransform());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : sprite.a().d()) {
            sVGAVideoShapeEntity.a();
            if (sVGAVideoShapeEntity.getShapePath() != null) {
                Paint paintF = this.sharedValues.f();
                paintF.reset();
                paintF.setAntiAlias(getVideoItem().getAntiAlias());
                double d = 255;
                paintF.setAlpha((int) (sprite.a().getAlpha() * d));
                Path pathG = this.sharedValues.g();
                pathG.reset();
                pathG.addPath(this.pathCache.a(sVGAVideoShapeEntity));
                Matrix matrixD = this.sharedValues.d();
                matrixD.reset();
                Matrix transform = sVGAVideoShapeEntity.getTransform();
                if (transform != null) {
                    matrixD.postConcat(transform);
                }
                matrixD.postConcat(matrixO);
                pathG.transform(matrixD);
                SVGAVideoShapeEntity.a styles = sVGAVideoShapeEntity.getStyles();
                if (styles != null && (fill = styles.getFill()) != 0) {
                    paintF.setStyle(Paint.Style.FILL);
                    paintF.setColor(fill);
                    int iMin = Math.min(255, Math.max(0, (int) (sprite.a().getAlpha() * d)));
                    if (iMin != 255) {
                        paintF.setAlpha(iMin);
                    }
                    if (sprite.a().getMaskPath() != null) {
                        canvas.save();
                    }
                    e15 maskPath = sprite.a().getMaskPath();
                    if (maskPath != null) {
                        Path pathH = this.sharedValues.h();
                        maskPath.a(pathH);
                        pathH.transform(matrixO);
                        canvas.clipPath(pathH);
                    }
                    canvas.drawPath(pathG, paintF);
                    if (sprite.a().getMaskPath() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a styles2 = sVGAVideoShapeEntity.getStyles();
                if (styles2 != null) {
                    float f = 0;
                    if (styles2.getStrokeWidth() > f) {
                        paintF.setAlpha((int) (sprite.a().getAlpha() * d));
                        paintF.setStyle(Paint.Style.STROKE);
                        SVGAVideoShapeEntity.a styles3 = sVGAVideoShapeEntity.getStyles();
                        if (styles3 != null) {
                            paintF.setColor(styles3.getStroke());
                            int iMin2 = Math.min(255, Math.max(0, (int) (sprite.a().getAlpha() * d)));
                            if (iMin2 != 255) {
                                paintF.setAlpha(iMin2);
                            }
                        }
                        float fM = m(matrixO);
                        SVGAVideoShapeEntity.a styles4 = sVGAVideoShapeEntity.getStyles();
                        if (styles4 != null) {
                            paintF.setStrokeWidth(styles4.getStrokeWidth() * fM);
                        }
                        SVGAVideoShapeEntity.a styles5 = sVGAVideoShapeEntity.getStyles();
                        if (styles5 != null && (lineCap = styles5.getLineCap()) != null) {
                            if (StringsKt__StringsJVMKt.equals(lineCap, "butt", true)) {
                                paintF.setStrokeCap(Paint.Cap.BUTT);
                            } else if (StringsKt__StringsJVMKt.equals(lineCap, "round", true)) {
                                paintF.setStrokeCap(Paint.Cap.ROUND);
                            } else if (StringsKt__StringsJVMKt.equals(lineCap, "square", true)) {
                                paintF.setStrokeCap(Paint.Cap.SQUARE);
                            }
                        }
                        SVGAVideoShapeEntity.a styles6 = sVGAVideoShapeEntity.getStyles();
                        if (styles6 != null && (lineJoin = styles6.getLineJoin()) != null) {
                            if (StringsKt__StringsJVMKt.equals(lineJoin, "miter", true)) {
                                paintF.setStrokeJoin(Paint.Join.MITER);
                            } else if (StringsKt__StringsJVMKt.equals(lineJoin, "round", true)) {
                                paintF.setStrokeJoin(Paint.Join.ROUND);
                            } else if (StringsKt__StringsJVMKt.equals(lineJoin, "bevel", true)) {
                                paintF.setStrokeJoin(Paint.Join.BEVEL);
                            }
                        }
                        if (sVGAVideoShapeEntity.getStyles() != null) {
                            paintF.setStrokeMiter(r8.getMiterLimit() * fM);
                        }
                        SVGAVideoShapeEntity.a styles7 = sVGAVideoShapeEntity.getStyles();
                        if (styles7 != null && (lineDash = styles7.getLineDash()) != null && lineDash.length == 3 && (lineDash[0] > f || lineDash[1] > f)) {
                            float[] fArr = new float[2];
                            float f2 = lineDash[0];
                            if (f2 < 1.0f) {
                                f2 = 1.0f;
                            }
                            fArr[0] = f2 * fM;
                            float f3 = lineDash[1];
                            if (f3 < 0.1f) {
                                f3 = 0.1f;
                            }
                            fArr[1] = f3 * fM;
                            paintF.setPathEffect(new DashPathEffect(fArr, lineDash[2] * fM));
                        }
                        if (sprite.a().getMaskPath() != null) {
                            canvas.save();
                        }
                        e15 maskPath2 = sprite.a().getMaskPath();
                        if (maskPath2 != null) {
                            Path pathH2 = this.sharedValues.h();
                            maskPath2.a(pathH2);
                            pathH2.transform(matrixO);
                            canvas.clipPath(pathH2);
                        }
                        canvas.drawPath(pathG, paintF);
                        if (sprite.a().getMaskPath() != null) {
                            canvas.restore();
                        }
                    }
                }
            }
        }
    }

    public final void i(xz4.a sprite, Canvas canvas, int frameIndex) {
        g(sprite, canvas);
        h(sprite, canvas);
        f(sprite, canvas, frameIndex);
    }

    public final void j(Canvas canvas, Bitmap drawingBitmap, xz4.a sprite, Matrix frameMatrix) {
        int i;
        StaticLayout layout;
        TextPaint drawingTextPaint;
        if (this.dynamicItem.getIsTextDirty()) {
            this.drawTextCache.clear();
            this.dynamicItem.l(false);
        }
        String str = sprite.get_imageKey();
        if (str != null) {
            String str2 = this.dynamicItem.h().get(str);
            Bitmap bitmapCreateBitmap = null;
            if (str2 != null && (drawingTextPaint = this.dynamicItem.i().get(str)) != null && (bitmapCreateBitmap = this.drawTextCache.get(str)) == null) {
                bitmapCreateBitmap = Bitmap.createBitmap(drawingBitmap.getWidth(), drawingBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Rect rect = new Rect(0, 0, drawingBitmap.getWidth(), drawingBitmap.getHeight());
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                Intrinsics.checkExpressionValueIsNotNull(drawingTextPaint, "drawingTextPaint");
                drawingTextPaint.setAntiAlias(true);
                Paint.FontMetrics fontMetrics = drawingTextPaint.getFontMetrics();
                float f = 2;
                canvas2.drawText(str2, rect.centerX(), (rect.centerY() - (fontMetrics.top / f)) - (fontMetrics.bottom / f), drawingTextPaint);
                HashMap<String, Bitmap> map = this.drawTextCache;
                if (bitmapCreateBitmap == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                map.put(str, bitmapCreateBitmap);
            }
            BoringLayout it = this.dynamicItem.a().get(str);
            if (it != null && (bitmapCreateBitmap = this.drawTextCache.get(str)) == null) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                TextPaint paint = it.getPaint();
                Intrinsics.checkExpressionValueIsNotNull(paint, "it.paint");
                paint.setAntiAlias(true);
                bitmapCreateBitmap = Bitmap.createBitmap(drawingBitmap.getWidth(), drawingBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas3 = new Canvas(bitmapCreateBitmap);
                canvas3.translate(0.0f, (drawingBitmap.getHeight() - it.getHeight()) / 2);
                it.draw(canvas3);
                HashMap<String, Bitmap> map2 = this.drawTextCache;
                if (bitmapCreateBitmap == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                map2.put(str, bitmapCreateBitmap);
            }
            StaticLayout it2 = this.dynamicItem.g().get(str);
            if (it2 != null && (bitmapCreateBitmap = this.drawTextCache.get(str)) == null) {
                Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                TextPaint paint2 = it2.getPaint();
                Intrinsics.checkExpressionValueIsNotNull(paint2, "it.paint");
                paint2.setAntiAlias(true);
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        Field field = StaticLayout.class.getDeclaredField("mMaximumVisibleLineCount");
                        Intrinsics.checkExpressionValueIsNotNull(field, "field");
                        field.setAccessible(true);
                        i = field.getInt(it2);
                    } catch (Exception unused) {
                        i = Integer.MAX_VALUE;
                    }
                    layout = StaticLayout.Builder.obtain(it2.getText(), 0, it2.getText().length(), it2.getPaint(), drawingBitmap.getWidth()).setAlignment(it2.getAlignment()).setMaxLines(i).setEllipsize(TextUtils.TruncateAt.END).build();
                } else {
                    layout = new StaticLayout(it2.getText(), 0, it2.getText().length(), it2.getPaint(), drawingBitmap.getWidth(), it2.getAlignment(), it2.getSpacingMultiplier(), it2.getSpacingAdd(), false);
                }
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(drawingBitmap.getWidth(), drawingBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas4 = new Canvas(bitmapCreateBitmap2);
                int height = drawingBitmap.getHeight();
                Intrinsics.checkExpressionValueIsNotNull(layout, "layout");
                canvas4.translate(0.0f, (height - layout.getHeight()) / 2);
                layout.draw(canvas4);
                HashMap<String, Bitmap> map3 = this.drawTextCache;
                if (bitmapCreateBitmap2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                map3.put(str, bitmapCreateBitmap2);
                bitmapCreateBitmap = bitmapCreateBitmap2;
            }
            if (bitmapCreateBitmap != null) {
                Paint paintF = this.sharedValues.f();
                paintF.setAntiAlias(getVideoItem().getAntiAlias());
                paintF.setAlpha((int) (sprite.a().getAlpha() * ((double) 255)));
                if (sprite.a().getMaskPath() == null) {
                    paintF.setFilterBitmap(getVideoItem().getAntiAlias());
                    canvas.drawBitmap(bitmapCreateBitmap, frameMatrix, paintF);
                    return;
                }
                e15 maskPath = sprite.a().getMaskPath();
                if (maskPath != null) {
                    canvas.save();
                    canvas.concat(frameMatrix);
                    canvas.clipRect(0, 0, drawingBitmap.getWidth(), drawingBitmap.getHeight());
                    Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                    paintF.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
                    Path pathG = this.sharedValues.g();
                    maskPath.a(pathG);
                    canvas.drawPath(pathG, paintF);
                    canvas.restore();
                }
            }
        }
    }

    public final boolean k(int spriteIndex, List<xz4.a> sprites) {
        Boolean bool;
        String str;
        xz4.a aVar;
        if (this.beginIndexList == null) {
            int size = sprites.size();
            Boolean[] boolArr = new Boolean[size];
            for (int i = 0; i < size; i++) {
                boolArr[i] = Boolean.FALSE;
            }
            int i2 = 0;
            for (Object obj : sprites) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                xz4.a aVar2 = (xz4.a) obj;
                String str2 = aVar2.get_imageKey();
                if ((str2 == null || !StringsKt__StringsJVMKt.endsWith$default(str2, ".matte", false, 2, null)) && (str = aVar2.get_matteKey()) != null && str.length() > 0 && (aVar = sprites.get(i2 - 1)) != null) {
                    String str3 = aVar.get_matteKey();
                    if (str3 == null || str3.length() == 0) {
                        boolArr[i2] = Boolean.TRUE;
                    } else if (!Intrinsics.areEqual(aVar.get_matteKey(), aVar2.get_matteKey())) {
                        boolArr[i2] = Boolean.TRUE;
                    }
                }
                i2 = i3;
            }
            this.beginIndexList = boolArr;
        }
        Boolean[] boolArr2 = this.beginIndexList;
        if (boolArr2 == null || (bool = boolArr2[spriteIndex]) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean l(int spriteIndex, List<xz4.a> sprites) {
        Boolean bool;
        String str;
        if (this.endIndexList == null) {
            List<xz4.a> list = sprites;
            int size = list.size();
            Boolean[] boolArr = new Boolean[size];
            for (int i = 0; i < size; i++) {
                boolArr[i] = Boolean.FALSE;
            }
            int i2 = 0;
            for (Object obj : sprites) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                xz4.a aVar = (xz4.a) obj;
                String str2 = aVar.get_imageKey();
                if ((str2 == null || !StringsKt__StringsJVMKt.endsWith$default(str2, ".matte", false, 2, null)) && (str = aVar.get_matteKey()) != null && str.length() > 0) {
                    if (i2 == list.size() - 1) {
                        boolArr[i2] = Boolean.TRUE;
                    } else {
                        xz4.a aVar2 = sprites.get(i3);
                        if (aVar2 != null) {
                            String str3 = aVar2.get_matteKey();
                            if (str3 == null || str3.length() == 0) {
                                boolArr[i2] = Boolean.TRUE;
                            } else if (!Intrinsics.areEqual(aVar2.get_matteKey(), aVar.get_matteKey())) {
                                boolArr[i2] = Boolean.TRUE;
                            }
                        }
                    }
                }
                i2 = i3;
            }
            this.endIndexList = boolArr;
        }
        Boolean[] boolArr2 = this.endIndexList;
        if (boolArr2 == null || (bool = boolArr2[spriteIndex]) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final float m(Matrix matrix) {
        matrix.getValues(this.matrixScaleTempValues);
        float[] fArr = this.matrixScaleTempValues;
        float f = fArr[0];
        if (f == 0.0f) {
            return 0.0f;
        }
        double d = f;
        double d2 = fArr[3];
        double d3 = fArr[1];
        double d4 = fArr[4];
        if (d * d4 == d2 * d3) {
            return 0.0f;
        }
        double dSqrt = Math.sqrt((d * d) + (d2 * d2));
        double d5 = d / dSqrt;
        double d6 = d2 / dSqrt;
        double d7 = (d5 * d3) + (d6 * d4);
        double d8 = d3 - (d5 * d7);
        double d9 = d4 - (d7 * d6);
        double dSqrt2 = Math.sqrt((d8 * d8) + (d9 * d9));
        if (d5 * (d9 / dSqrt2) < d6 * (d8 / dSqrt2)) {
            dSqrt = -dSqrt;
        }
        return Math.abs(getScaleInfo().getRatioX() ? (float) dSqrt : (float) dSqrt2);
    }

    public final void n(int frameIndex) {
        Integer soundID;
        for (r05 r05Var : getVideoItem().l()) {
            if (r05Var.getStartFrame() == frameIndex) {
                l15 l15Var = l15.e;
                if (l15Var.b()) {
                    Integer soundID2 = r05Var.getSoundID();
                    if (soundID2 != null) {
                        r05Var.e(Integer.valueOf(l15Var.d(soundID2.intValue())));
                    }
                } else {
                    SoundPool soundPool = getVideoItem().getSoundPool();
                    if (soundPool != null && (soundID = r05Var.getSoundID()) != null) {
                        r05Var.e(Integer.valueOf(soundPool.play(soundID.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
                    }
                }
            }
            if (r05Var.getEndFrame() <= frameIndex) {
                Integer playID = r05Var.getPlayID();
                if (playID != null) {
                    int iIntValue = playID.intValue();
                    l15 l15Var2 = l15.e;
                    if (l15Var2.b()) {
                        l15Var2.e(iIntValue);
                    } else {
                        SoundPool soundPool2 = getVideoItem().getSoundPool();
                        if (soundPool2 != null) {
                            soundPool2.stop(iIntValue);
                        }
                    }
                }
                r05Var.e(null);
            }
        }
    }

    public final Matrix o(Matrix transform) {
        Matrix matrixC = this.sharedValues.c();
        matrixC.postScale(getScaleInfo().getScaleFx(), getScaleInfo().getScaleFy());
        matrixC.postTranslate(getScaleInfo().getTranFx(), getScaleInfo().getTranFy());
        matrixC.preConcat(transform);
        return matrixC;
    }
}

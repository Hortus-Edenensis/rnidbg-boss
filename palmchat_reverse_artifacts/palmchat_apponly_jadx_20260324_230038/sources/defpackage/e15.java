package defpackage;

import android.graphics.Path;
import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import java.util.StringTokenizer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002R\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u000e¨\u0006\u0013"}, d2 = {"Le15;", "", "Landroid/graphics/Path;", "toPath", "", "a", "finalPath", "", ActionUtils.METHOD, "Ljava/util/StringTokenizer;", "args", t.l, "Ljava/lang/String;", "replacedValue", "Landroid/graphics/Path;", "cachedPath", "originValue", "<init>", "(Ljava/lang/String;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class e15 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String replacedValue;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public Path cachedPath;

    public e15(String str) {
        this.replacedValue = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) ",", false, 2, (Object) null) ? StringsKt__StringsJVMKt.replace$default(str, ",", " ", false, 4, (Object) null) : str;
    }

    public final void a(Path toPath) {
        Path path = this.cachedPath;
        if (path != null) {
            toPath.set(path);
            return;
        }
        Path path2 = new Path();
        StringTokenizer stringTokenizer = new StringTokenizer(this.replacedValue, "MLHVCSQRAZmlhvcsqraz", true);
        String str = "";
        while (stringTokenizer.hasMoreTokens()) {
            String segment = stringTokenizer.nextToken();
            Intrinsics.checkExpressionValueIsNotNull(segment, "segment");
            if (!(segment.length() == 0)) {
                if (f15.f17411a.contains(segment)) {
                    if (Intrinsics.areEqual(segment, "Z") || Intrinsics.areEqual(segment, "z")) {
                        b(path2, segment, new StringTokenizer("", ""));
                    }
                    str = segment;
                } else {
                    b(path2, str, new StringTokenizer(segment, " "));
                }
            }
        }
        this.cachedPath = path2;
        toPath.set(path2);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Path finalPath, String method, StringTokenizer args) {
        g15 g15Var;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        int i = 0;
        while (args.hasMoreTokens()) {
            try {
                String s = args.nextToken();
                Intrinsics.checkExpressionValueIsNotNull(s, "s");
                if (!(s.length() == 0)) {
                    if (i == 0) {
                        f = Float.parseFloat(s);
                    }
                    if (i == 1) {
                        f2 = Float.parseFloat(s);
                    }
                    if (i == 2) {
                        f3 = Float.parseFloat(s);
                    }
                    if (i == 3) {
                        f4 = Float.parseFloat(s);
                    }
                    if (i == 4) {
                        f5 = Float.parseFloat(s);
                    }
                    if (i == 5) {
                        f6 = Float.parseFloat(s);
                    }
                    i++;
                }
            } catch (Exception unused) {
            }
        }
        float f7 = f;
        float f8 = f2;
        float f9 = f3;
        float f10 = f4;
        g15 g15Var2 = new g15(0.0f, 0.0f, 0.0f);
        if (!Intrinsics.areEqual(method, "M")) {
            if (Intrinsics.areEqual(method, "m")) {
                finalPath.rMoveTo(f7, f8);
                g15Var = new g15(g15Var2.getX() + f7, g15Var2.getY() + f8, 0.0f);
            }
            if (!Intrinsics.areEqual(method, "L")) {
                finalPath.lineTo(f7, f8);
            } else if (Intrinsics.areEqual(method, "l")) {
                finalPath.rLineTo(f7, f8);
            }
            if (!Intrinsics.areEqual(method, WkAdxAdConfigMg.DSP_NAME_CSJ)) {
                finalPath.cubicTo(f7, f8, f9, f10, f5, f6);
            } else if (Intrinsics.areEqual(method, "c")) {
                finalPath.rCubicTo(f7, f8, f9, f10, f5, f6);
            }
            if (!Intrinsics.areEqual(method, "Q")) {
                finalPath.quadTo(f7, f8, f9, f10);
            } else if (Intrinsics.areEqual(method, "q")) {
                finalPath.rQuadTo(f7, f8, f9, f10);
            }
            if (!Intrinsics.areEqual(method, "H")) {
                finalPath.lineTo(f7, g15Var.getY());
            } else if (Intrinsics.areEqual(method, "h")) {
                finalPath.rLineTo(f7, 0.0f);
            }
            if (!Intrinsics.areEqual(method, ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                finalPath.lineTo(g15Var.getX(), f7);
            } else if (Intrinsics.areEqual(method, "v")) {
                finalPath.rLineTo(0.0f, f7);
            }
            if (!Intrinsics.areEqual(method, "Z")) {
                finalPath.close();
                return;
            } else {
                if (Intrinsics.areEqual(method, "z")) {
                    finalPath.close();
                    return;
                }
                return;
            }
        }
        finalPath.moveTo(f7, f8);
        g15Var2 = new g15(f7, f8, 0.0f);
        g15Var = g15Var2;
        if (!Intrinsics.areEqual(method, "L")) {
        }
        if (!Intrinsics.areEqual(method, WkAdxAdConfigMg.DSP_NAME_CSJ)) {
        }
        if (!Intrinsics.areEqual(method, "Q")) {
        }
        if (!Intrinsics.areEqual(method, "H")) {
        }
        if (!Intrinsics.areEqual(method, ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
        }
        if (!Intrinsics.areEqual(method, "Z")) {
        }
    }
}

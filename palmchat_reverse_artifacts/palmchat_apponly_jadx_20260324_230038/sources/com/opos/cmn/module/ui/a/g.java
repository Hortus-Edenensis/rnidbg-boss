package com.opos.cmn.module.ui.a;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class g {
    @NonNull
    public static Path a(@NonNull Path path, RectF rectF, float f) {
        return a(path, rectF, f, true, true, true, true);
    }

    @NonNull
    public static Path a(@NonNull Path path, RectF rectF, float f, boolean z, boolean z2, boolean z3, boolean z4) {
        float f2;
        float f3;
        float f4 = f < 0.0f ? 0.0f : f;
        path.reset();
        float f5 = rectF.left;
        float f6 = rectF.right;
        float f7 = rectF.bottom;
        float f8 = rectF.top;
        float f9 = f6 - f5;
        float f10 = f7 - f8;
        float f11 = f9 / 2.0f;
        float f12 = f10 / 2.0f;
        float fMin = ((double) (f4 / Math.min(f11, f12))) > 0.5d ? 1.0f - (Math.min(1.0f, ((f4 / Math.min(f11, f12)) - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float fMin2 = f4 / Math.min(f11, f12) > 0.6f ? 1.0f + (Math.min(1.0f, ((f4 / Math.min(f11, f12)) - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        path.moveTo(f5 + f11, f8);
        if (z2) {
            float f13 = f4 / 100.0f;
            float f14 = f13 * 128.19f * fMin;
            path.lineTo(Math.max(f11, f9 - f14) + f5, f8);
            float f15 = f5 + f9;
            float f16 = f13 * 83.62f * fMin2;
            float f17 = f13 * 67.45f;
            float f18 = f13 * 4.64f;
            float f19 = f13 * 51.16f;
            float f20 = f13 * 13.36f;
            f2 = f11;
            path.cubicTo(f15 - f16, f8, f15 - f17, f8 + f18, f15 - f19, f8 + f20);
            float f21 = f13 * 34.86f;
            float f22 = f13 * 22.07f;
            path.cubicTo(f15 - f21, f8 + f22, f15 - f22, f8 + f21, f15 - f20, f8 + f19);
            path.cubicTo(f15 - f18, f8 + f17, f15, f8 + f16, f15, f8 + Math.min(f12, f14));
        } else {
            path.lineTo(f5 + f9, f8);
            f2 = f11;
        }
        if (z4) {
            float f23 = f5 + f9;
            float f24 = f4 / 100.0f;
            float f25 = f24 * 128.19f * fMin;
            path.lineTo(f23, Math.max(f12, f10 - f25) + f8);
            float f26 = f8 + f10;
            float f27 = f24 * 83.62f * fMin2;
            float f28 = f24 * 4.64f;
            float f29 = f24 * 67.45f;
            float f30 = f24 * 13.36f;
            float f31 = f24 * 51.16f;
            path.cubicTo(f23, f26 - f27, f23 - f28, f26 - f29, f23 - f30, f26 - f31);
            float f32 = f24 * 22.07f;
            float f33 = f24 * 34.86f;
            path.cubicTo(f23 - f32, f26 - f33, f23 - f33, f26 - f32, f23 - f31, f26 - f30);
            float f34 = f23 - f27;
            f3 = f2;
            path.cubicTo(f23 - f29, f26 - f28, f34, f26, f5 + Math.max(f3, f9 - f25), f26);
        } else {
            path.lineTo(f9 + f5, f8 + f10);
            f3 = f2;
        }
        if (z3) {
            float f35 = f4 / 100.0f;
            float f36 = f35 * 128.19f * fMin;
            float f37 = f8 + f10;
            path.lineTo(Math.min(f3, f36) + f5, f37);
            float f38 = f35 * 83.62f * fMin2;
            float f39 = f35 * 67.45f;
            float f40 = f35 * 4.64f;
            float f41 = f35 * 51.16f;
            float f42 = f35 * 13.36f;
            path.cubicTo(f5 + f38, f37, f5 + f39, f37 - f40, f5 + f41, f37 - f42);
            float f43 = f35 * 34.86f;
            float f44 = f35 * 22.07f;
            path.cubicTo(f5 + f43, f37 - f44, f5 + f44, f37 - f43, f5 + f42, f37 - f41);
            path.cubicTo(f5 + f40, f37 - f39, f5, f37 - f38, f5, f8 + Math.max(f12, f10 - f36));
        } else {
            path.lineTo(f5, f10 + f8);
        }
        if (z) {
            float f45 = f4 / 100.0f;
            float f46 = 128.19f * f45 * fMin;
            path.lineTo(f5, Math.min(f12, f46) + f8);
            float f47 = 83.62f * f45 * fMin2;
            float f48 = 4.64f * f45;
            float f49 = 67.45f * f45;
            float f50 = 13.36f * f45;
            float f51 = 51.16f * f45;
            path.cubicTo(f5, f8 + f47, f5 + f48, f8 + f49, f5 + f50, f8 + f51);
            float f52 = 22.07f * f45;
            float f53 = f45 * 34.86f;
            path.cubicTo(f5 + f52, f8 + f53, f5 + f53, f8 + f52, f5 + f51, f8 + f50);
            path.cubicTo(f5 + f49, f8 + f48, f5 + f47, f8, f5 + Math.min(f3, f46), f8);
        } else {
            path.lineTo(f5, f8);
        }
        path.close();
        return path;
    }
}

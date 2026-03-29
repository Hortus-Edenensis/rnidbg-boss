package defpackage;

import android.hardware.Camera;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21320a = "uy";

    public static void a(Camera.Parameters parameters, int i, int i2) {
        Camera.Size size = null;
        Camera.Size size2 = null;
        for (Camera.Size size3 : parameters.getSupportedPreviewSizes()) {
            float f = size3.width / size3.height;
            if (Math.abs(f - 1.3333334f) <= 0.001f && (size == null || size.width < size3.width)) {
                size = size3;
            }
            if (Math.abs(f - 1.7777778f) < 0.001f && (size2 == null || size2.width < size3.width)) {
                size2 = size3;
            }
        }
        Log.i(f21320a, "set preview size to " + size.width + "x" + size.height + "==" + size2.width + "x" + size2.height);
        parameters.setPreviewSize(size.width, size.height);
        int i3 = size.width;
        int i4 = size2.width;
        if (i3 < i4 || size.height < size2.height) {
            parameters.setPreviewSize(i4, size2.height);
        }
    }
}

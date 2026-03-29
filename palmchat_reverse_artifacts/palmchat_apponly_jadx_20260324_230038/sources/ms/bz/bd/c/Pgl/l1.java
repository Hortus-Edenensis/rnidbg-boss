package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f19317a;
    public static int b;

    public static String a(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            f19317a = point.x;
            b = point.y;
        } catch (Throwable unused) {
        }
        return f19317a + "*" + b;
    }
}

package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Window;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class tk5 {
    @TargetApi(19)
    public static void a(Activity activity) {
        Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }
}

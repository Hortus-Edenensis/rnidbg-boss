package ms.bz.bd.c.Pgl;

import android.annotation.SuppressLint;
import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"NewApi"})
public final class pbll implements DisplayManager.DisplayListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DisplayManager f19330a;

    public pbll(DisplayManager displayManager) {
        this.f19330a = displayManager;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
        try {
            Display[] displays = this.f19330a.getDisplays();
            int length = displays.length;
            if (length > 0) {
                q1 q1VarI = q1.i();
                q1VarI.getClass();
                String strH = q1.h(displays);
                String strC = q1.c(displays);
                q1VarI.j(length);
                if (!TextUtils.isEmpty(strH)) {
                    q1VarI.l(strH);
                }
                if (!TextUtils.isEmpty(strC)) {
                    q1VarI.f(strC);
                }
                q1VarI.k(System.currentTimeMillis() / 1000);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
        try {
            Display[] displays = this.f19330a.getDisplays();
            int length = displays.length;
            if (length > 0) {
                q1 q1VarI = q1.i();
                q1VarI.getClass();
                String strH = q1.h(displays);
                String strC = q1.c(displays);
                q1VarI.j(length);
                if (!TextUtils.isEmpty(strH)) {
                    q1VarI.l(strH);
                }
                if (!TextUtils.isEmpty(strC)) {
                    q1VarI.f(strC);
                }
                q1VarI.e(System.currentTimeMillis() / 1000);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
    }
}

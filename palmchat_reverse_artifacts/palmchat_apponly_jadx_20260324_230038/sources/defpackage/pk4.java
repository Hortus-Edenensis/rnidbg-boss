package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class pk4 extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20033a;
    public final boolean b;
    public volatile int c;
    public ok4 d;

    public pk4(View view, int i, int i2, ok4 ok4Var) {
        super(view, i, i2);
        int i3 = Build.VERSION.SDK_INT;
        this.f20033a = i3 == 24;
        this.b = i3 > 24;
        this.c = 0;
        this.d = ok4Var;
    }

    public void a() {
        super.dismiss();
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        try {
            view.setSystemUiVisibility(5894);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(View view) {
        try {
            if (view.getSystemUiVisibility() == 5894) {
                b(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Activity d(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper) || this.c > 50) {
            return null;
        }
        this.c++;
        return d(((ContextWrapper) context).getBaseContext());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        ok4 ok4Var = this.d;
        if (ok4Var != null && ok4Var.b() && this.d.d()) {
            a();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (!this.f20033a || view == null) {
            if (this.b) {
                setHeight(-2);
            }
            setFocusable(false);
            super.showAsDropDown(view, i, i2, i3);
            c(getContentView());
            update();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Activity activityD = d(view.getContext());
        if (activityD == null) {
            Log.e("PopupWindowProxy", "please make sure that context is instance of activity");
            return;
        }
        int i4 = iArr[0] + i;
        int height = iArr[1] + view.getHeight() + i2;
        setFocusable(false);
        super.showAtLocation(activityD.getWindow().getDecorView(), 0, i4, height);
        c(getContentView());
        update();
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        setFocusable(false);
        super.showAtLocation(view, i, i2, i3);
        c(getContentView());
        update();
    }
}

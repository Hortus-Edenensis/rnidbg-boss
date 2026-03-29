package com.opos.mobad.g.a;

import android.R;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b implements DialogInterface.OnKeyListener, DialogInterface.OnShowListener, com.opos.mobad.video.player.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f8902a;
    private a b;
    private com.opos.mobad.video.player.b.a c;

    @Override // com.opos.mobad.video.player.b.b
    public void a() {
        if (this.f8902a == null || !this.b.isShowing()) {
            com.opos.cmn.an.f.a.b("InterstitialDialog", "dismiss dialog but fail");
        } else {
            this.b.dismiss();
        }
        if (this.f8902a != null) {
            this.f8902a = null;
        }
    }

    public boolean b() {
        a aVar;
        boolean z = false;
        try {
            if (!com.opos.cmn.i.b.a(this.f8902a) && (aVar = this.b) != null) {
                if (aVar.isShowing()) {
                    z = true;
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterstitialDialog", "isShowing", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("InterstitialDialog", "isShowing=" + z);
        return z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        boolean z = false;
        if (i == 4) {
            try {
                if (b() && keyEvent.getAction() == 0) {
                    com.opos.mobad.video.player.b.a aVar = this.c;
                    if (aVar != null) {
                        aVar.a();
                    }
                    z = true;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterstitialDialog", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("dialog onKey=");
        sb.append(i);
        sb.append(",keyEvent=");
        String string = keyEvent.toString();
        Object obj = keyEvent;
        if (string == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(z);
        com.opos.cmn.an.f.a.b("InterstitialDialog", sb.toString());
        return z;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        com.opos.cmn.an.f.a.b("InterstitialDialog", "dialog show");
    }

    private void a(Activity activity) {
        a aVar = this.b;
        if (aVar != null && (aVar.getContext() instanceof Activity)) {
            if (((Activity) this.b.getContext()) == activity) {
                com.opos.cmn.an.f.a.b("InterstitialDialog", "same activity");
                return;
            }
            a();
        }
        a aVar2 = new a(activity, com.opos.cmn.an.h.f.a.a(activity) ? R.style.Theme.Translucent.NoTitleBar.Fullscreen : R.style.Theme.Translucent.NoTitleBar);
        this.b = aVar2;
        aVar2.getWindow().getDecorView().setBackgroundColor(1711276032);
        this.b.getWindow().setStatusBarColor(0);
        this.b.getWindow().addFlags(Integer.MIN_VALUE);
        this.b.setOnKeyListener(this);
        this.b.setOnShowListener(this);
    }

    @Override // com.opos.mobad.video.player.b.b
    public void a(Activity activity, View view) {
        this.f8902a = activity;
        a(activity);
        if (view != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                view.setForceDarkAllowed(false);
            }
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.opos.mobad.g.a.b.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return b.this.b();
                }
            });
            this.b.setContentView(view, new ViewGroup.LayoutParams(-1, -1));
            this.b.show();
            if (i >= 28) {
                WindowManager.LayoutParams attributes = this.b.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                this.b.getWindow().setAttributes(attributes);
            }
            int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
            int i2 = (systemUiVisibility & 1024) == 1024 ? 1280 : 0;
            if ((systemUiVisibility & 4) == 4) {
                i2 = i2 | 4 | 4096;
            }
            this.b.getWindow().getDecorView().setSystemUiVisibility(i2);
        }
    }

    @Override // com.opos.mobad.video.player.b.b
    public void a(com.opos.mobad.video.player.b.a aVar) {
        this.c = aVar;
    }
}

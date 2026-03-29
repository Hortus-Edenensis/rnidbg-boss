package com.opos.mobad.g.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import com.opos.cmn.i.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Boolean f8901a;
    private Activity b;

    public a(Activity activity, int i) {
        super(activity, i);
        this.f8901a = null;
        this.b = activity;
    }

    private void a() {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Boolean bool = this.f8901a;
        if (bool == null || !bool.booleanValue()) {
            super.dismiss();
        } else {
            com.opos.cmn.an.f.a.a("", "dialog has detach do not dismiss");
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8901a = Boolean.FALSE;
        com.opos.cmn.an.f.a.b("", "dialog onAttachedToWindow");
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8901a = Boolean.TRUE;
        com.opos.cmn.an.f.a.b("", "dialog onDetachedFromWindow");
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity = this.b;
        if (activity == null || activity.isFinishing() || this.b.isDestroyed()) {
            com.opos.cmn.an.f.a.b("", "show but activity has destroy");
        } else {
            g.a(getContext().getApplicationContext(), getWindow());
            super.show();
        }
    }
}

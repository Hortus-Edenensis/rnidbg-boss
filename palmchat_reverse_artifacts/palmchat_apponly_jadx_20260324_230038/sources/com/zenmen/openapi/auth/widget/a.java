package com.zenmen.openapi.auth.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.NonNull;
import com.zenmen.openapi.comm.widget.LxDialogView;
import defpackage.fa3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a extends Dialog implements fa3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f12016a;
    public LxDialogView b;
    public Activity c;

    /* JADX INFO: renamed from: com.zenmen.openapi.auth.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class DialogInterfaceOnCancelListenerC0940a implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC0940a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.f12016a != null) {
                a.this.f12016a.onConfirmback(1);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onConfirmback(int i);
    }

    public a(@NonNull Context context, int i) {
        super(context, i);
        this.c = null;
        if (context instanceof Activity) {
            this.c = (Activity) context;
        }
    }

    public void b(b bVar) {
        this.f12016a = bVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Activity activity = this.c;
        if (activity == null || !activity.isFinishing()) {
            super.dismiss();
            this.c = null;
        }
    }

    @Override // defpackage.fa3
    public void onEvent(int i, Object obj) {
        b bVar = this.f12016a;
        if (bVar != null) {
            bVar.onConfirmback(i);
        }
        this.f12016a = null;
        dismiss();
    }

    @Override // android.app.Dialog
    public void setContentView(@NonNull View view) {
        super.setContentView(view);
        if (view instanceof LxDialogView) {
            LxDialogView lxDialogView = (LxDialogView) view;
            this.b = lxDialogView;
            lxDialogView.setEventCallback(this);
        }
        setOnCancelListener(new DialogInterfaceOnCancelListenerC0940a());
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity = this.c;
        if (activity == null || !activity.isFinishing()) {
            super.show();
        }
    }
}

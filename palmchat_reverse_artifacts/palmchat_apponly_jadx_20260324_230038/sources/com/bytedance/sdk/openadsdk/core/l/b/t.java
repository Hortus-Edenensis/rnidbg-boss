package com.bytedance.sdk.openadsdk.core.l.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.widget.jk;
import com.bytedance.sdk.openadsdk.core.y.iz;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t {
    private static AlertDialog u(Activity activity, final com.bytedance.sdk.openadsdk.core.l.b.u uVar) {
        return new com.bytedance.sdk.openadsdk.core.widget.jk(activity).u(uVar.u).nr(uVar.nr).fx(uVar.fx).b(uVar.b).u(uVar.pn).u(new jk.u() { // from class: com.bytedance.sdk.openadsdk.core.l.b.t.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.jk.u
            public void onClickNo(Dialog dialog) {
                nr nrVar = uVar.iz;
                if (nrVar != null) {
                    nrVar.nr(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.jk.u
            public void onClickYes(Dialog dialog) {
                nr nrVar = uVar.iz;
                if (nrVar != null) {
                    nrVar.u(dialog);
                }
            }
        }).u(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.l.b.t.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                nr nrVar = uVar.iz;
                if (nrVar != null) {
                    nrVar.fx(dialogInterface);
                }
            }
        });
    }

    public static void u(WeakReference<Context> weakReference, boolean z, final com.bytedance.sdk.openadsdk.core.l.b.u uVar) {
        iz.u uVar2 = new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.l.b.t.3
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
                nr nrVar = uVar.iz;
                if (nrVar != null) {
                    nrVar.nr(new u());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                nr nrVar = uVar.iz;
                if (nrVar != null) {
                    nrVar.u(new u());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
                nr nrVar = uVar.iz;
                if (nrVar != null) {
                    nrVar.fx(new u());
                }
            }
        };
        if (z) {
            com.bytedance.sdk.openadsdk.core.y.iz.u(weakReference.get(), String.valueOf(uVar.hashCode()), uVar.u, uVar.nr, uVar.fx, uVar.b, uVar2);
        } else {
            com.bytedance.sdk.openadsdk.core.y.iz.u(weakReference.get(), String.valueOf(uVar.hashCode()), uVar.u, uVar.nr, uVar2);
        }
    }

    public static AlertDialog u(Activity activity, boolean z, com.bytedance.sdk.openadsdk.core.l.b.u uVar) {
        if (z) {
            AlertDialog alertDialogU = u(activity, uVar);
            if (activity != null && !activity.isFinishing()) {
                alertDialogU.show();
            }
            return alertDialogU;
        }
        return u(activity, q.x(activity, "Theme.Dialog.TTDownload"), uVar);
    }

    private static AlertDialog u(Activity activity, int i, final com.bytedance.sdk.openadsdk.core.l.b.u uVar) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i).setTitle(uVar.u).setMessage(uVar.nr).setPositiveButton(uVar.fx, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.l.b.t.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                nr nrVar = uVar.iz;
                if (nrVar != null) {
                    nrVar.u(dialogInterface);
                }
            }
        }).setNegativeButton(uVar.b, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.l.b.t.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                nr nrVar = uVar.iz;
                if (nrVar != null) {
                    nrVar.nr(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.l.b.t.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                nr nrVar = uVar.iz;
                if (nrVar != null) {
                    nrVar.fx(dialogInterface);
                }
            }
        });
        Drawable drawable = uVar.pn;
        if (drawable != null) {
            onCancelListener.setIcon(drawable);
        }
        AlertDialog alertDialogCreate = onCancelListener.create();
        if (activity != null && !activity.isFinishing()) {
            alertDialogCreate.show();
        }
        return alertDialogCreate;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements DialogInterface {
        private u() {
        }

        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }
    }
}

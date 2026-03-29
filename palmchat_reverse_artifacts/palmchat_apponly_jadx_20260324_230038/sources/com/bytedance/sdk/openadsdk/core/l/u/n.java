package com.bytedance.sdk.openadsdk.core.l.u;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.widget.jk;
import com.bytedance.sdk.openadsdk.core.y.iz;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    private static AlertDialog createAlertDialog(Activity activity, int i, final DialogBuilder dialogBuilder) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i).setTitle(dialogBuilder.title).setMessage(dialogBuilder.message).setPositiveButton(dialogBuilder.positiveBtnText, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.l.u.n.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(dialogInterface);
                }
            }
        }).setNegativeButton(dialogBuilder.negativeBtnText, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.l.u.n.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.l.u.n.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
        if (dialogBuilder.icon != null) {
            onCancelListener.setIcon(dialogBuilder.icon);
        }
        AlertDialog alertDialogCreate = onCancelListener.create();
        if (activity != null && !activity.isFinishing()) {
            alertDialogCreate.show();
        }
        return alertDialogCreate;
    }

    private static AlertDialog getBackInstallDialog(Activity activity, final DialogBuilder dialogBuilder) {
        return new com.bytedance.sdk.openadsdk.core.widget.jk(activity).u(dialogBuilder.title).nr(dialogBuilder.message).fx(dialogBuilder.positiveBtnText).b(dialogBuilder.negativeBtnText).u(dialogBuilder.icon).u(new jk.u() { // from class: com.bytedance.sdk.openadsdk.core.l.u.n.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.jk.u
            public void onClickNo(Dialog dialog) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.jk.u
            public void onClickYes(Dialog dialog) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(dialog);
                }
            }
        }).u(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.l.u.n.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
    }

    public static void showDialogByDelegate(WeakReference<Context> weakReference, boolean z, final DialogBuilder dialogBuilder) {
        iz.u uVar = new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.l.u.n.3
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(new u());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(new u());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(new u());
                }
            }
        };
        if (z) {
            com.bytedance.sdk.openadsdk.core.y.iz.u(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, dialogBuilder.positiveBtnText, dialogBuilder.negativeBtnText, uVar);
        } else {
            com.bytedance.sdk.openadsdk.core.y.iz.u(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, uVar);
        }
    }

    public static AlertDialog showDialogBySelf(Activity activity, boolean z, DialogBuilder dialogBuilder) {
        if (!z) {
            return createAlertDialog(activity, q.x(activity, "Theme.Dialog.TTDownload"), dialogBuilder);
        }
        AlertDialog backInstallDialog = getBackInstallDialog(activity, dialogBuilder);
        if (activity != null && !activity.isFinishing()) {
            backInstallDialog.show();
        }
        return backInstallDialog;
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

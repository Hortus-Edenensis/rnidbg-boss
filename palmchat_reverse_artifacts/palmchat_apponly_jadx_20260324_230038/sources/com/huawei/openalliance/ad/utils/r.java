package com.huawei.openalliance.ad.utils;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class r {
    private static final String Code = "DialogUtil";

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void Code();

        void V();
    }

    public static AlertDialog.Builder Code(Context context) {
        if (cn.V(context)) {
            return new AlertDialog.Builder(context);
        }
        int i = Build.VERSION.SDK_INT;
        return (i < 22 || !z.C(context)) ? i >= 22 ? new AlertDialog.Builder(context, R.style.Theme.DeviceDefault.Light.Dialog.Alert) : new AlertDialog.Builder(context, R.style.Theme.Material.Light.Dialog.Alert) : new AlertDialog.Builder(context, R.style.Theme.DeviceDefault.Dialog.Alert);
    }

    private static Dialog Code(Context context, AlertDialog.Builder builder, String str, String str2, String str3, final a aVar) {
        Window window;
        if (str != null) {
            builder.setTitle(str);
        }
        builder.setPositiveButton(str2, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.utils.r.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.Code();
                }
            }
        });
        builder.setNegativeButton(str3, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.utils.r.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.V();
                }
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.huawei.openalliance.ad.utils.r.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.V();
                }
            }
        });
        if (!(context instanceof Activity) && (window = alertDialogCreate.getWindow()) != null) {
            window.setType(Build.VERSION.SDK_INT >= 26 ? 2038 : 2003);
        }
        return alertDialogCreate;
    }

    public static Dialog Code(Context context, String str, String str2, String str3, String str4, a aVar) {
        AlertDialog.Builder builderCode = Code(context);
        if (str2 != null) {
            builderCode.setMessage(str2);
        }
        Dialog dialogCode = Code(context, builderCode, str, str3, str4, aVar);
        Code(dialogCode);
        return dialogCode;
    }

    private static void Code(Dialog dialog) {
        try {
            dialog.show();
        } catch (WindowManager.BadTokenException unused) {
            fh.I(Code, "showDialog BadTokenException");
        } catch (Throwable th) {
            fh.I(Code, "showDialog exception %s", th.getClass().getSimpleName());
        }
    }
}

package com.ss.android.download.api.u;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.mv;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u implements mv {
    @Override // com.ss.android.download.api.config.mv
    public Dialog nr(@NonNull com.ss.android.download.api.model.nr nrVar) {
        return u(nrVar);
    }

    @Override // com.ss.android.download.api.config.mv
    public void u(int i, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    private static Dialog u(final com.ss.android.download.api.model.nr nrVar) {
        if (nrVar == null) {
            return null;
        }
        AlertDialog alertDialogShow = new AlertDialog.Builder(nrVar.u).setTitle(nrVar.nr).setMessage(nrVar.fx).setPositiveButton(nrVar.b, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.u.u.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                nr.InterfaceC0840nr interfaceC0840nr = nrVar.n;
                if (interfaceC0840nr != null) {
                    interfaceC0840nr.u(dialogInterface);
                }
            }
        }).setNegativeButton(nrVar.pn, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.u.u.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                nr.InterfaceC0840nr interfaceC0840nr = nrVar.n;
                if (interfaceC0840nr != null) {
                    interfaceC0840nr.nr(dialogInterface);
                }
            }
        }).show();
        alertDialogShow.setCanceledOnTouchOutside(nrVar.iz);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.u.u.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                nr.InterfaceC0840nr interfaceC0840nr = nrVar.n;
                if (interfaceC0840nr != null) {
                    interfaceC0840nr.fx(dialogInterface);
                }
            }
        });
        Drawable drawable = nrVar.x;
        if (drawable != null) {
            alertDialogShow.setIcon(drawable);
        }
        return alertDialogShow;
    }
}

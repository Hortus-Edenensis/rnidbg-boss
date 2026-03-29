package com.wifi.ad.core.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.wifi.ad.core.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DisLikeDialog extends Dialog implements View.OnClickListener {
    private DialogClickListener listener;

    /* JADX INFO: compiled from: SearchBox */
    public interface DialogClickListener {
        void onDiskLikeClick();
    }

    public DisLikeDialog(@NonNull Context context) {
        super(context, R.style.AdDiskLikeStyle);
        setCanceledOnTouchOutside(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DialogClickListener dialogClickListener;
        dismiss();
        if (view.getId() != R.id.ll_dislike || (dialogClickListener = this.listener) == null) {
            return;
        }
        dialogClickListener.onDiskLikeClick();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_ad_dislike);
        findViewById(R.id.ll_dislike).setOnClickListener(this);
    }

    public DisLikeDialog setDialogListener(DialogClickListener dialogClickListener) {
        this.listener = dialogClickListener;
        return this;
    }
}

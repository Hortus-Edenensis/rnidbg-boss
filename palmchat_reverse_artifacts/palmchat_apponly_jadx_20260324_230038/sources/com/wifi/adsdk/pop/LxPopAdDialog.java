package com.wifi.adsdk.pop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.wifi.lxad.ad.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxPopAdDialog extends Dialog {
    private LxAdPopView adPopView;
    private Activity mAct;
    private Context mContext;

    public LxPopAdDialog(@NonNull Context context, LxAdPopView lxAdPopView) {
        super(context, R.style.AdPopFullScreenDialog);
        this.adPopView = null;
        this.mAct = null;
        setCanceledOnTouchOutside(false);
        this.adPopView = lxAdPopView;
        this.mContext = context.getApplicationContext();
        if (context instanceof Activity) {
            this.mAct = (Activity) context;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
            LxAdPopView lxAdPopView = this.adPopView;
            if (lxAdPopView != null) {
                lxAdPopView.adDestroy();
                this.adPopView.adCloseEvent();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.adPopView);
        this.adPopView.initView(this);
    }

    @Override // android.app.Dialog
    public void show() {
        WindowManager.LayoutParams attributes;
        try {
            super.show();
            Window window = getWindow();
            if (window == null || (attributes = window.getAttributes()) == null) {
                return;
            }
            attributes.width = -1;
            attributes.height = -2;
            window.addFlags(2);
            attributes.dimAmount = 0.6f;
            attributes.gravity = 17;
            window.setAttributes(attributes);
        } catch (Exception unused) {
        }
    }
}

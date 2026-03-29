package com.zenmen.palmchat.ad;

import android.app.Activity;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.framework.R$style;
import defpackage.a92;
import defpackage.l6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GenericVipEntranceDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12431a;
    public Activity b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GenericVipEntranceDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l6.k(GenericVipEntranceDialog.this.f12431a);
            GenericVipEntranceDialog.this.dismiss();
        }
    }

    public GenericVipEntranceDialog(Activity activity, int i) {
        super(activity, R$style.GenericVipEntranceDialogTheme);
        this.b = activity;
        this.f12431a = i;
        setCancelable(false);
        setContentView(R$layout.frame_generic_vip_entrance_content);
        n();
    }

    public final void n() {
        View viewFindViewById = findViewById(R$id.close);
        View viewFindViewById2 = findViewById(R$id.vip_entrance);
        viewFindViewById.setOnClickListener(new a());
        viewFindViewById2.setOnClickListener(new b());
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            Activity activity = this.b;
            if (activity != null && !activity.isFinishing()) {
                super.show();
                a92.c++;
                l6.l(this.f12431a);
            }
        } catch (Exception unused) {
        }
    }
}

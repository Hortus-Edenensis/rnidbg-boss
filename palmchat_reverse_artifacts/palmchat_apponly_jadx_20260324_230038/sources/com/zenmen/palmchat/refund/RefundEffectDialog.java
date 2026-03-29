package com.zenmen.palmchat.refund;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.av4;
import defpackage.l50;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RefundEffectDialog extends FrameworkBaseActivity {
    public View q = null;
    public View r = null;
    public boolean s = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            RefundEffectDialog.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            RefundEffectDialog.this.s = true;
            RefundEffectDialog.this.finish();
        }
    }

    public final void B1() {
        View viewFindViewById = findViewById(R$id.refund_redpkg_effect_close);
        this.q = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        View viewFindViewById2 = findViewById(R$id.refund_redpkg_effeft_success_botton);
        this.r = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.dialog_refund_effect);
        LogUtil.d("RefundManager", "RefundEffectDialog onCreate ");
        B1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.s) {
            av4.a();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }
}

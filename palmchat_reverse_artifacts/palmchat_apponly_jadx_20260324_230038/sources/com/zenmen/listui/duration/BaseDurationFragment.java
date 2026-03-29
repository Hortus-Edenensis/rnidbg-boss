package com.zenmen.listui.duration;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.BaseFragment;
import defpackage.a23;
import defpackage.qi1;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class BaseDurationFragment extends BaseFragment {
    public String f;
    public qi1 g;
    public boolean h = false;

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        qi1 qi1Var = this.g;
        if (qi1Var != null) {
            qi1Var.i(z);
        }
    }

    public boolean R() {
        return false;
    }

    public void T(a23 a23Var) {
        if (this.g == null || !R()) {
            return;
        }
        this.g.h(a23Var);
    }

    public String getSid() {
        return this.f;
    }

    public void i(boolean z) {
        this.h = z;
        qi1 qi1Var = this.g;
        if (qi1Var != null) {
            qi1Var.e(z);
        }
    }

    public abstract int o();

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (TextUtils.isEmpty(this.f)) {
            this.f = UUID.randomUUID().toString().replace("-", "");
        }
        qi1 qi1Var = new qi1(this.f, o());
        this.g = qi1Var;
        qi1Var.g(this);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.g.c();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.g.d();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    public void u(String str) {
        this.f = str;
        qi1 qi1Var = this.g;
        if (qi1Var != null) {
            qi1Var.l(str);
        }
    }
}

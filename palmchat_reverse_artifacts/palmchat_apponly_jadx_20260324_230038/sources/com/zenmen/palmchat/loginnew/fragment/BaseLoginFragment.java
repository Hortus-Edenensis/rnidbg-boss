package com.zenmen.palmchat.loginnew.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import defpackage.k86;
import defpackage.me1;
import defpackage.sd3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class BaseLoginFragment extends BaseFragment {
    public int f;
    public int g;

    public int R() {
        return this.f;
    }

    public boolean T() {
        return me1.c(AppContext.getContext()) > k86.e(AppContext.getContext(), 640.0f);
    }

    public void V(int i) {
        this.g = i;
    }

    public void W(Activity activity, String str, String str2) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        new sd3(activity).k(str).O(R.string.alert_dialog_ok).f(null).e().show();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f = arguments.getInt("page_index", 0);
        }
    }
}

package com.zenmen.palmchat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b05;
import defpackage.wn4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BaseFragment extends Fragment {
    public wn4 d;
    public boolean e = false;

    public static int D() {
        return 1;
    }

    public static int E() {
        return 1;
    }

    public final String F() {
        return getClass().getSimpleName();
    }

    public void G() {
        wn4 wn4Var = this.d;
        if (wn4Var != null) {
            try {
                wn4Var.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean J() {
        return false;
    }

    public void K(boolean z) {
        LogUtil.i("LXBaseFragment", F() + " : onUserVisibleChange()" + z);
        b05.a(F() + " : onUserVisibleChange()====》" + z);
    }

    public void L() {
        if (this.d == null) {
            wn4 wn4Var = new wn4(getActivity());
            this.d = wn4Var;
            wn4Var.setCancelable(false);
            this.d.b(getString(com.zenmen.palmchat.framework.R$string.progress_sending));
        }
        this.d.show();
    }

    public void M(String str, boolean z) {
        O(str, z, true);
    }

    public void O(String str, boolean z, boolean z2) {
        wn4 wn4Var = this.d;
        if (wn4Var == null || !wn4Var.isShowing()) {
            wn4 wn4Var2 = new wn4(getActivity());
            this.d = wn4Var2;
            wn4Var2.setCancelable(false);
            this.d.b(str);
            this.d.setCanceledOnTouchOutside(z);
            this.d.setCancelable(z2);
        }
        this.d.show();
    }

    public final void P() {
        if (this.e) {
            return;
        }
        this.e = true;
        I();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b05.a(F() + " : onCreate()");
        LogUtil.i("LXBaseFragment", F() + " : onCreate()");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        LogUtil.i("LXBaseFragment", F() + " : onCreateView()");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LogUtil.i("LXBaseFragment", F() + " : onDestroy()");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.i("LXBaseFragment", F() + " : onDestroyView()");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        K(false);
        LogUtil.i("LXBaseFragment", F() + " : onPause()" + getUserVisibleHint());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        P();
        K(true);
        LogUtil.i("LXBaseFragment", F() + " : onResume()" + getUserVisibleHint());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LogUtil.i("LXBaseFragment", F() + " : onStart()" + getUserVisibleHint());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        LogUtil.i("LXBaseFragment", F() + " : onStop()");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        LogUtil.i("LXBaseFragment", F() + " : onViewCreated()" + getUserVisibleHint());
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        LogUtil.i("LXBaseFragment", F() + " : setUserVisibleHint()" + z);
    }

    public void I() {
    }
}

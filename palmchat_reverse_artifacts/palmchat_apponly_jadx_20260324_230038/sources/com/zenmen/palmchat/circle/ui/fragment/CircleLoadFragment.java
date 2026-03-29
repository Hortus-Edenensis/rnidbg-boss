package com.zenmen.palmchat.circle.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class CircleLoadFragment extends BaseFragment {
    public static String l = "CircleLoadFragment";
    public boolean f = true;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;
    public View k = null;

    private String V() {
        return getClass().getSimpleName();
    }

    public void R() {
        LogUtil.d(l, "fragmentShowScreen:" + V());
        this.g = true;
        c0();
    }

    public void T() {
        LogUtil.d(l, "fragmentShowScreen ignore:" + V());
        this.g = true;
        this.h = true;
        c0();
    }

    public abstract View W(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle);

    public abstract void Y();

    public void Z(boolean z) {
        this.j = z;
    }

    public final void c0() {
        LogUtil.d(l, "load:" + this.j + " show:" + this.g + " vis:" + this.h + " resume:" + this.i + V());
        if (!this.j && this.g && this.h && this.i) {
            this.j = true;
            Y();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtil.d(l, "onAttach:" + V());
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtil.d(l, "on create load:" + this.j + " show:" + this.g + " vis:" + this.h + " resume:" + this.i + V());
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewW = W(layoutInflater, viewGroup, bundle);
        this.k = viewW;
        return viewW;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.d(l, "onDestroyView:" + V());
        this.j = false;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LogUtil.d(l, "onPause:" + V());
        this.i = false;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.d(l, "onResume:" + V());
        this.i = true;
        c0();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        LogUtil.d(l, "visible change:" + z + V());
        if (z && this.f) {
            this.f = false;
            this.h = true;
            c0();
        }
    }
}

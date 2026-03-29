package com.zenmen.palmchat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ir5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class BaseLazyFragment extends BaseFragment {
    public FrameLayout f = null;
    public State g = State.NONE;
    public String h = getClass().getSimpleName();
    public final String i = "BaseLazyFragment_" + this.h;

    /* JADX INFO: compiled from: SearchBox */
    public enum State {
        NONE,
        INIT,
        LOADING,
        LOADED
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f12074a;

        public a(long j) {
            this.f12074a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BaseLazyFragment.this.getContext() != null) {
                long jB = ir5.b();
                BaseLazyFragment.this.f.addView(BaseLazyFragment.this.W(), -1, -1);
                LogUtil.i(BaseLazyFragment.this.i, BaseLazyFragment.this.getClass().getName() + " loadViewImp " + ir5.e(jB) + " total=" + ir5.e(this.f12074a));
                BaseLazyFragment.this.g = State.LOADED;
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        LogUtil.i(this.i, " onUserVisibleChange " + z);
        if (z) {
            c0();
        }
    }

    public abstract View W();

    public int Y() {
        return com.zenmen.palmchat.framework.R$layout.layout_fragment_empty;
    }

    public boolean Z() {
        return this.g == State.LOADED;
    }

    public final void c0() {
        LogUtil.i(this.i, " loadView " + this.g + " " + getUserVisibleHint());
        if (this.g == State.INIT && isResumed()) {
            e0();
        }
    }

    public void e0() {
        long jB = ir5.b();
        this.g = State.LOADING;
        this.f.post(new a(jB));
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = getClass().getName();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public final View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.g = State.INIT;
        this.f = (FrameLayout) layoutInflater.inflate(Y(), viewGroup, false);
        LogUtil.i(this.i, " onCreateView ");
        return this.f;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.g = State.NONE;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        LogUtil.i(this.i, " setUserVisibleHint " + z);
        if (z) {
            c0();
        }
    }
}

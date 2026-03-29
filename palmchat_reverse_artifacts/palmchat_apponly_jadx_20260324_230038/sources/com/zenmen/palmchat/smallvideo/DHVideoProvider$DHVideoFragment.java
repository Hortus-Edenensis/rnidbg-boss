package com.zenmen.palmchat.smallvideo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.zenmen.palmchat.databinding.FragmentDhvideoContentBinding;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.TabsBarLayout;
import defpackage.fc1;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class DHVideoProvider$DHVideoFragment extends Fragment {
    public final String d = "video_child";
    public FragmentDhvideoContentBinding e;
    public TabsBarLayout f;
    public Context g;
    public long h;
    public String i;

    public final void D() {
        E(this.i);
    }

    public final void E(String str) {
        LogUtil.d("", "CSJAD initIDPWidget groupId " + str);
    }

    public final boolean F() {
        return false;
    }

    public final void G() {
        HashMap map = new HashMap();
        map.put("time_len", Long.valueOf(Math.abs(System.currentTimeMillis() - this.h)));
        fc1.a("svideo_tab_quit", map);
    }

    public final void I() {
        HashMap map = new HashMap();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.h = jCurrentTimeMillis;
        map.put("time_stamp", Long.valueOf(jCurrentTimeMillis));
        fc1.a("svideo_tab_page_show", map);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.e = FragmentDhvideoContentBinding.b(layoutInflater);
        this.g = getContext();
        try {
            FragmentDhvideoContentBinding fragmentDhvideoContentBinding = this.e;
            if (fragmentDhvideoContentBinding != null) {
                fragmentDhvideoContentBinding.b.removeAllViews();
                TabsBarLayout tabsBarLayout = this.f;
                if (tabsBarLayout != null) {
                    this.e.b.addView(tabsBarLayout, new ViewGroup.LayoutParams(-1, -1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.e.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.e = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        F();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (F() && getUserVisibleHint()) {
            G();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (F() && getUserVisibleHint()) {
            I();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            D();
        }
        if (F()) {
            if (z) {
                I();
            } else {
                G();
            }
        }
    }
}

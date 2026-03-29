package com.zenmen.palmchat.maintab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ax4;
import defpackage.ec3;
import defpackage.f22;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class DynamicConfigFragment extends BaseFragment {
    public static final String h = "com.zenmen.palmchat.maintab.DynamicConfigFragment";
    public TabItem f;
    public f22 g = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CellUpdateEvent f14599a;

        public a(CellUpdateEvent cellUpdateEvent) {
            this.f14599a = cellUpdateEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupItem next;
            CellUpdateEvent cellUpdateEvent = this.f14599a;
            int i = cellUpdateEvent.type;
            if (i == 0) {
                if (cellUpdateEvent.data == null || DynamicConfigFragment.this.f == null) {
                    return;
                }
                TabItem tabItemE = ec3.j().e(this.f14599a.data, DynamicConfigFragment.this.f.tag);
                if (tabItemE != null) {
                    tabItemE = DynamicConfigFragment.this.V(tabItemE);
                }
                if (tabItemE == null || tabItemE.isSame(DynamicConfigFragment.this.f)) {
                    return;
                }
                DynamicConfigFragment.this.f = tabItemE;
                DynamicConfigFragment.this.g.w(tabItemE);
                DynamicConfigFragment.this.g.y();
                if (DynamicConfigFragment.this.isResumed()) {
                    DynamicConfigFragment.this.g.s();
                    return;
                }
                return;
            }
            if (i != 6) {
                DynamicConfigFragment.this.g.A();
                return;
            }
            if ("tab_mine".equals(DynamicConfigFragment.this.f.tag)) {
                if (DynamicConfigFragment.this.f.groups != null) {
                    Iterator<GroupItem> it = DynamicConfigFragment.this.f.groups.iterator();
                    while (it.hasNext()) {
                        next = it.next();
                        if (GroupItem.TAG_RECENT_USE.equals(next.tag)) {
                            break;
                        }
                    }
                    next = null;
                } else {
                    next = null;
                }
                if (next != null) {
                    List<CellItem> list = next.items;
                    List<CellItem> listI = ax4.i();
                    Log.d("RequestMineInfoManagers", "oldRecent: " + list.size() + "newRecent" + listI.size());
                    if (ax4.j(list, listI)) {
                        next.items = listI;
                        DynamicConfigFragment dynamicConfigFragment = DynamicConfigFragment.this;
                        dynamicConfigFragment.g.w(dynamicConfigFragment.f);
                        DynamicConfigFragment dynamicConfigFragment2 = DynamicConfigFragment.this;
                        dynamicConfigFragment2.g.z(dynamicConfigFragment2.getContext(), next);
                    }
                }
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        f22 f22Var = this.g;
        if (f22Var != null) {
            f22Var.x(z);
        }
    }

    public TabItem V(TabItem tabItem) {
        return ec3.j().f(tabItem);
    }

    public int W() {
        return 0;
    }

    public TabItem Y() {
        return this.f;
    }

    public f22 Z() {
        return this.g;
    }

    public int c0() {
        return R.layout.layout_fragment_dynamic_content;
    }

    public void e0(CellUpdateEvent cellUpdateEvent) {
        LogUtil.i("DynamicConfigFragment", "onCellUpdateEvent" + cellUpdateEvent.type);
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        getActivity().runOnUiThread(new a(cellUpdateEvent));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.g.o(i, i2, intent);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f = (TabItem) bundle.getParcelable("DynamicConfigFragment_SAVE_KEY");
            LogUtil.i("DynamicConfigFragment", "onCreate 1111" + this.f);
        }
        if (getArguments() != null && this.f == null) {
            this.f = V((TabItem) getArguments().getParcelable("DynamicConfigFragment_EXTRA_KEY"));
            LogUtil.i("DynamicConfigFragment", "onCreate 2222" + this.f);
        }
        f22 f22Var = new f22(this, c0());
        this.g = f22Var;
        f22Var.w(this.f);
        LogUtil.i("DynamicConfigFragment", "onCreate" + this + "savedInstanceState" + bundle);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        LogUtil.i("DynamicConfigFragment", "onCreateView");
        return this.g.p(layoutInflater, viewGroup, bundle);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LogUtil.i("DynamicConfigFragment", "onDestroy");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.g.q();
        super.onDestroyView();
        LogUtil.i("DynamicConfigFragment", "onDestroyView");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.g.r();
        LogUtil.i("DynamicConfigFragment", "onPause");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.g.s();
        LogUtil.i("DynamicConfigFragment", "onResume");
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        try {
            bundle.putParcelable("DynamicConfigFragment_SAVE_KEY", this.f);
            super.onSaveInstanceState(bundle);
            LogUtil.i("DynamicConfigFragment", "onSaveInstanceState" + this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.g.t();
        LogUtil.i("DynamicConfigFragment", "onStart");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.g.u();
        LogUtil.i("DynamicConfigFragment", "onStop");
    }
}

package com.zenmen.square.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.friendcircle.MomentsBaseFragment;
import com.zenmen.palmchat.friendcircle.a;
import defpackage.a23;
import defpackage.bj5;
import defpackage.gj5;
import defpackage.to2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareMomentsFragment extends MomentsBaseFragment<gj5> implements to2 {
    public RecyclerView.OnScrollListener E;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            RecyclerView.OnScrollListener onScrollListener = SquareMomentsFragment.this.E;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(recyclerView, i);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if ((layoutManager instanceof LinearLayoutManager) && i == 0) {
                int iFindLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                int itemCount = layoutManager.getItemCount();
                if (itemCount < 10 || iFindLastVisibleItemPosition != itemCount - 1) {
                    return;
                }
                bj5.b().a().e0(SquareMomentsFragment.this.getActivity(), 11);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            RecyclerView.OnScrollListener onScrollListener = SquareMomentsFragment.this.E;
            if (onScrollListener != null) {
                onScrollListener.onScrolled(recyclerView, i, i2);
            }
        }
    }

    @Override // defpackage.to2
    public void A() {
        x();
    }

    @Override // com.zenmen.palmchat.friendcircle.MomentsBaseFragment
    public String A0() {
        return "friend";
    }

    @Override // com.zenmen.palmchat.friendcircle.MomentsBaseFragment
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public gj5 y0(Activity activity, a.InterfaceC1048a interfaceC1048a) {
        return new gj5(activity, interfaceC1048a);
    }

    @Override // defpackage.to2
    public RecyclerView e() {
        T t = this.i;
        if (t == 0) {
            return null;
        }
        return ((gj5) t).c();
    }

    @Override // defpackage.to2
    public void n(RecyclerView.OnScrollListener onScrollListener) {
        this.E = onScrollListener;
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 2;
    }

    @Override // com.zenmen.palmchat.friendcircle.MomentsBaseFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.zenmen.palmchat.friendcircle.MomentsBaseFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        e().addOnScrollListener(new a());
        T(new a23() { // from class: fj5
            @Override // defpackage.a23
            public final void a() {
                this.f17536a.x();
            }
        });
        return viewOnCreateView;
    }

    @Override // com.zenmen.palmchat.friendcircle.MomentsBaseFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // defpackage.to2
    public void x() {
        T t = this.i;
        if (t == 0) {
            return;
        }
        ((gj5) t).b(2);
    }

    @Override // defpackage.to2
    public void z(boolean z) {
    }
}

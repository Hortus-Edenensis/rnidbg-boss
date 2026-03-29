package com.zenmen.palmchat.lxvoip.vertc.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.lxvoip.vertc.R$layout;
import com.zenmen.palmchat.lxvoip.vertc.databinding.LayoutUserCustomListPagerBinding;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.ek2;
import defpackage.me1;
import defpackage.va6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CustomUserListPagerLayout extends FrameLayout {
    private va6 currentBigShowItm;
    private GridLayoutManager gridLayoutManager;
    private final List<va6> mUserInfoList;
    private final a mUserListAdapter;
    private ek2<va6> mUserViewClick;
    private final ek2<va6> mUserViewClickDelegate;
    private LayoutUserCustomListPagerBinding mViewBinding;

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends RecyclerView.ViewHolder {
        public va6 d;
        public final CustomUserRenderView e;
        public final ek2<va6> f;

        public b(@NonNull View view, ek2<va6> ek2Var) {
            super(view);
            if (view instanceof CustomUserRenderView) {
                this.e = (CustomUserRenderView) view;
            } else {
                this.e = null;
            }
            this.f = ek2Var;
            view.setOnClickListener(new View.OnClickListener() { // from class: ks0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f18821a.o(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(View view) {
            ek2<va6> ek2Var = this.f;
            if (ek2Var != null) {
                ek2Var.a(this.d);
            }
        }

        public void n(va6 va6Var) {
            this.d = va6Var;
            CustomUserRenderView customUserRenderView = this.e;
            if (customUserRenderView != null) {
                customUserRenderView.bindInfo(va6Var);
            }
        }

        public void p(String str, boolean z, boolean z2) {
            CustomUserRenderView customUserRenderView = this.e;
            if (customUserRenderView != null) {
                customUserRenderView.updateVideoStatus(str, z, z2);
            }
        }

        public void q(String str, boolean z) {
            CustomUserRenderView customUserRenderView = this.e;
            if (customUserRenderView != null) {
                customUserRenderView.updateAudioStatus(str, z);
            }
        }

        public void r(String str, boolean z) {
            CustomUserRenderView customUserRenderView = this.e;
            if (customUserRenderView != null) {
                customUserRenderView.updateSpeakingStatus(str, z);
            }
        }
    }

    public CustomUserListPagerLayout(@NonNull Context context) {
        super(context);
        this.mUserInfoList = new ArrayList();
        this.currentBigShowItm = null;
        ek2<va6> ek2Var = new ek2() { // from class: js0
            @Override // defpackage.ek2
            public final void a(Object obj) {
                this.f18487a.lambda$new$0((va6) obj);
            }
        };
        this.mUserViewClickDelegate = ek2Var;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        this.gridLayoutManager = gridLayoutManager;
        this.mUserListAdapter = new a(ek2Var, gridLayoutManager);
        initView();
    }

    private void exchangedMainAndSmallViewData() {
        if (this.mUserInfoList.size() != 2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<va6> it = this.mUserInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(0, it.next());
        }
        setUserList(arrayList);
    }

    private void initView() {
        LayoutUserCustomListPagerBinding layoutUserCustomListPagerBindingA = LayoutUserCustomListPagerBinding.a(View.inflate(getContext(), R$layout.layout_user_custom_list_pager, this));
        this.mViewBinding = layoutUserCustomListPagerBindingA;
        layoutUserCustomListPagerBindingA.c.setLayoutManager(this.gridLayoutManager);
        this.mViewBinding.c.setAdapter(this.mUserListAdapter);
        setUserList(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(va6 va6Var) {
        ek2<va6> ek2Var = this.mUserViewClick;
        if (ek2Var != null) {
            ek2Var.a(va6Var);
        }
        showBigItem(va6Var);
    }

    private void setUserListImp(List<va6> list) {
        int i;
        LogUtil.i("RTC", "setUserListImp" + az2.c(list));
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        if (list != null) {
            va6 va6Var = this.currentBigShowItm;
            if (va6Var == null || !list.contains(va6Var)) {
                i = list.size() <= 4 ? 2 : 3;
            } else {
                arrayList.clear();
                arrayList.add(this.currentBigShowItm);
                i = 1;
            }
            if (this.gridLayoutManager.getSpanCount() != i) {
                this.gridLayoutManager.setSpanCount(i);
            }
        }
        this.mUserListAdapter.a(arrayList);
    }

    private void showBigItem(va6 va6Var) {
        if (this.currentBigShowItm != null) {
            this.currentBigShowItm = null;
        } else {
            this.currentBigShowItm = va6Var;
        }
        setUserListImp(this.mUserInfoList);
    }

    public void setOnUserViewClick(ek2<va6> ek2Var) {
        this.mUserViewClick = ek2Var;
    }

    public void setUserList(List<va6> list) {
        this.mUserInfoList.clear();
        if (list != null) {
            this.mUserInfoList.addAll(list);
        }
        setUserListImp(list);
    }

    public void updateUserAudioStatus(String str, boolean z) {
        this.mViewBinding.b.updateAudioStatus(str, z);
        this.mUserListAdapter.c(str, z);
    }

    public void updateUserSpeakingStatus(String str, boolean z) {
        this.mViewBinding.b.updateSpeakingStatus(str, z);
        this.mUserListAdapter.d(str, z);
    }

    public void updateUserVideoStatus(String str, boolean z, boolean z2) {
        this.mViewBinding.b.updateVideoStatus(str, z, z2);
        this.mUserListAdapter.b(str, z, z2);
    }

    public CustomUserListPagerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUserInfoList = new ArrayList();
        this.currentBigShowItm = null;
        ek2<va6> ek2Var = new ek2() { // from class: js0
            @Override // defpackage.ek2
            public final void a(Object obj) {
                this.f18487a.lambda$new$0((va6) obj);
            }
        };
        this.mUserViewClickDelegate = ek2Var;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        this.gridLayoutManager = gridLayoutManager;
        this.mUserListAdapter = new a(ek2Var, gridLayoutManager);
        initView();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final ek2<va6> f;
        public GridLayoutManager g;
        public final List<va6> e = new ArrayList();
        public final String h = "is_speaking";
        public final String i = "is_not_speaking";
        public final String j = "mic_on";
        public final String k = "mic_off";
        public final String l = "camera_on";
        public final String m = "camera_off";
        public final String n = "screen_share_on";

        public a(ek2<va6> ek2Var, GridLayoutManager gridLayoutManager) {
            this.f = ek2Var;
            this.g = gridLayoutManager;
        }

        public void a(List<va6> list) {
            this.e.clear();
            if (list == null || list.size() <= 0) {
                notifyDataSetChanged();
            } else {
                this.e.addAll(list);
                notifyDataSetChanged();
            }
        }

        public void b(String str, boolean z, boolean z2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (int i = 0; i < this.e.size(); i++) {
                va6 va6Var = this.e.get(i);
                if (TextUtils.equals(str, va6Var.b)) {
                    va6Var.f = z2;
                    if (z) {
                        notifyItemChanged(i, "screen_share_on");
                    } else {
                        notifyItemChanged(i, z2 ? "camera_on" : "camera_off");
                    }
                }
            }
        }

        public void c(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (int i = 0; i < this.e.size(); i++) {
                va6 va6Var = this.e.get(i);
                if (TextUtils.equals(str, va6Var.b)) {
                    va6Var.e = z;
                    notifyItemChanged(i, z ? "mic_on" : "mic_off");
                }
            }
        }

        public void d(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (int i = 0; i < this.e.size(); i++) {
                if (TextUtils.equals(str, this.e.get(i).b)) {
                    notifyItemChanged(i, z ? "is_speaking" : "is_not_speaking");
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.e.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                CustomUserRenderView customUserRenderView = bVar.e;
                ViewGroup.LayoutParams layoutParams = customUserRenderView.getLayoutParams();
                if (layoutParams != null) {
                    int iG = me1.g() / this.g.getSpanCount();
                    if (layoutParams.width != iG) {
                        layoutParams.width = iG;
                        layoutParams.height = iG;
                    }
                    customUserRenderView.setLayoutParams(layoutParams);
                }
                bVar.n(this.e.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            CustomUserRenderView customUserRenderView = new CustomUserRenderView(viewGroup.getContext());
            customUserRenderView.setLayoutParams(new FrameLayout.LayoutParams(me1.g() / this.g.getSpanCount(), me1.g() / this.g.getSpanCount()));
            return new b(customUserRenderView, this.f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            if (list.isEmpty()) {
                super.onBindViewHolder(viewHolder, i, list);
                return;
            }
            if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                va6 va6Var = this.e.get(i);
                if (list.contains("is_speaking")) {
                    bVar.r(va6Var.b, true);
                } else if (list.contains("is_not_speaking")) {
                    bVar.r(va6Var.b, false);
                }
                if (list.contains("mic_on")) {
                    bVar.q(va6Var.b, true);
                } else if (list.contains("mic_off")) {
                    bVar.q(va6Var.b, false);
                }
                if (list.contains("camera_on") || list.contains("camera_off")) {
                    bVar.p(va6Var.b, false, va6Var.f);
                }
                if (list.contains("screen_share_on")) {
                    bVar.p(va6Var.b, true, true);
                }
            }
        }
    }

    public CustomUserListPagerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mUserInfoList = new ArrayList();
        this.currentBigShowItm = null;
        ek2<va6> ek2Var = new ek2() { // from class: js0
            @Override // defpackage.ek2
            public final void a(Object obj) {
                this.f18487a.lambda$new$0((va6) obj);
            }
        };
        this.mUserViewClickDelegate = ek2Var;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        this.gridLayoutManager = gridLayoutManager;
        this.mUserListAdapter = new a(ek2Var, gridLayoutManager);
        initView();
    }
}

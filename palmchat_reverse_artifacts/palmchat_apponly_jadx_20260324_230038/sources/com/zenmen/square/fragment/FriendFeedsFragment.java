package com.zenmen.square.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.adapter.SuperExposeV2PublishSucessAdapter;
import com.zenmen.square.dynamiclife.DynamicSuperExposeV1Config;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import com.zenmen.square.support.SquareSingleton;
import defpackage.b05;
import defpackage.bj5;
import defpackage.ds0;
import defpackage.ij5;
import defpackage.k42;
import defpackage.kj1;
import defpackage.q05;
import defpackage.qm5;
import defpackage.to2;
import defpackage.wh5;
import defpackage.ym;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FriendFeedsFragment extends FeedsFragment<k42> implements to2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeedEvent f16293a;

        public a(SquareFeedEvent squareFeedEvent) {
            this.f16293a = squareFeedEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareFeedEvent squareFeedEvent = this.f16293a;
            if (squareFeedEvent == null || squareFeedEvent.feed == null || FriendFeedsFragment.this.k == null || this.f16293a.eventType != 1) {
                return;
            }
            ((k42) FriendFeedsFragment.this.k).M(0, this.f16293a.feed);
            FriendFeedsFragment.this.T0(this.f16293a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeedEvent f16294a;
        public final /* synthetic */ MaterialDialog b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("button", 1);
            }
        }

        public b(SquareFeedEvent squareFeedEvent, MaterialDialog materialDialog) {
            this.f16294a = squareFeedEvent;
            this.b = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("postboost_postSucceed_pop", 2, new a());
            bj5.b().a().K(FriendFeedsFragment.this.getActivity(), MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, this.f16294a.feed);
            this.b.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f16296a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("button", 2);
            }
        }

        public c(MaterialDialog materialDialog) {
            this.f16296a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("postboost_postSucceed_pop", 2, new a());
            this.f16296a.dismiss();
        }
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        ym ymVar = this.q;
        if (ymVar != null) {
            ymVar.n(z);
        }
        ij5 ij5Var = this.r;
        if (ij5Var != null) {
            ij5Var.h(z);
        }
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public k42 c0() {
        if (this.k == 0) {
            this.k = new k42("square.friend.feed.list.v8", o());
        }
        return (k42) this.k;
    }

    public final void T0(SquareFeedEvent squareFeedEvent) {
        if (squareFeedEvent.feed.visibleType != 2 && kj1.b().c().booleanValue()) {
            long jLongValue = ((Long) q05.k("KEY_LAST_SHOW_DYNAMiC_PUBLISH_SUCCESS_DIALOG_TIME", 0L)).longValue();
            int iIntValue = ((Integer) q05.k("KEY_LAST_SHOW_DYNAMiC_PUBLISH_SUCCESS_DIALOG_COUNT", 0)).intValue();
            b05.a("lastShowTime===>" + jLongValue);
            b05.a("showCount===>" + iIntValue);
            DynamicSuperExposeV1Config dynamicSuperExposeV1ConfigA = kj1.b().a();
            if (jLongValue > 0) {
                if (dynamicSuperExposeV1ConfigA == null || dynamicSuperExposeV1ConfigA.newpost_popFrequency == null) {
                    DynamicSuperExposeV1Config dynamicSuperExposeV1Config = new DynamicSuperExposeV1Config();
                    DynamicSuperExposeV1Config.DynamicSuperExposeV1newpost_popFrequency dynamicSuperExposeV1newpost_popFrequency = new DynamicSuperExposeV1Config.DynamicSuperExposeV1newpost_popFrequency();
                    dynamicSuperExposeV1newpost_popFrequency.count = 24;
                    dynamicSuperExposeV1newpost_popFrequency.time = 1;
                    dynamicSuperExposeV1Config.newpost_popFrequency = dynamicSuperExposeV1newpost_popFrequency;
                    dynamicSuperExposeV1ConfigA = dynamicSuperExposeV1Config;
                }
                if (System.currentTimeMillis() - jLongValue < dynamicSuperExposeV1ConfigA.newpost_popFrequency.time * 60 * 60 * 1000) {
                    b05.a("时间段内");
                    if (iIntValue >= dynamicSuperExposeV1ConfigA.newpost_popFrequency.count) {
                        b05.a("超过次数");
                        return;
                    }
                    b05.a("没超过次数");
                } else {
                    b05.a("超过时间段");
                    iIntValue = 0;
                }
            }
            q05.w("KEY_LAST_SHOW_DYNAMiC_PUBLISH_SUCCESS_DIALOG_TIME", Long.valueOf(System.currentTimeMillis()));
            q05.w("KEY_LAST_SHOW_DYNAMiC_PUBLISH_SUCCESS_DIALOG_COUNT", Integer.valueOf(iIntValue + 1));
            MaterialDialog materialDialogD = q05.d(getActivity(), R$layout.dialog_dynamic_super_expose_publish_success);
            View viewFindViewById = materialDialogD.j().findViewById(R$id.close_layout);
            View viewFindViewById2 = materialDialogD.j().findViewById(R$id.btn_submit);
            ((TextView) materialDialogD.j().findViewById(R$id.btn_submit_txt)).setText(dynamicSuperExposeV1ConfigA.getPostboost_postSucceed_pop_button_text());
            RecyclerView recyclerView = (RecyclerView) materialDialogD.j().findViewById(R$id.recycler_view);
            materialDialogD.setCancelable(false);
            materialDialogD.setCanceledOnTouchOutside(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(dynamicSuperExposeV1ConfigA.getPostboost_postSucceed_pop_content()));
            recyclerView.setAdapter(new SuperExposeV2PublishSucessAdapter(arrayList, getContext()));
            viewFindViewById2.setOnClickListener(new b(squareFeedEvent, materialDialogD));
            viewFindViewById.setOnClickListener(new c(materialDialogD));
            q05.a("postboost_postSucceed_pop", 1, null);
            materialDialogD.show();
        }
    }

    @qm5
    public void addSquareFeed(SquareFeedEvent squareFeedEvent) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new a(squareFeedEvent));
        }
    }

    @Override // defpackage.to2
    public /* bridge */ /* synthetic */ RecyclerView e() {
        return super.e();
    }

    @Override // com.zenmen.square.fragment.SquareBaseFragment, com.zenmen.listui.duration.BaseDurationFragment
    public void i(boolean z) {
        super.i(z);
        ym ymVar = this.q;
        if (ymVar != null) {
            ymVar.n(z && isResumed());
        }
        ij5 ij5Var = this.r;
        if (ij5Var != null) {
            ij5Var.h(z && isResumed());
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 74;
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.square.fragment.SquareBaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        wh5.r(c0());
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.listui.list.BaseListFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ds0.a().d(this);
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.square.fragment.SquareBaseFragment, com.zenmen.listui.list.BaseListFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (SquareSingleton.getInstance().getMessageCountManager().g().booleanValue()) {
            x();
        }
    }

    @Override // com.zenmen.listui.list.BaseListFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ds0.a().c(this);
    }

    @Override // defpackage.to2
    public void A() {
    }
}

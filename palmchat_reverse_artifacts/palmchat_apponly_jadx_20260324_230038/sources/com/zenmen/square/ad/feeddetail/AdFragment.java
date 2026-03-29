package com.zenmen.square.ad.feeddetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperDrawVideo;
import com.wifi.ad.core.listener.DrawShowListener;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.lxpager.BasePagerBean;
import com.zenmen.square.lxpager.LxFragmentViewHolder;
import com.zenmen.square.lxpager.PagerFragment;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.b6;
import defpackage.d66;
import defpackage.hg1;
import defpackage.l6;
import defpackage.p66;
import defpackage.q66;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class AdFragment extends PagerFragment {
    public SquareFeed e;
    public NestAdData f;
    public View g;
    public FrameLayout h;
    public int i;
    public boolean j = false;
    public ImageView k = null;
    public String l = "";

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdFragment.this.R();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements DrawShowListener {
        public b() {
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onAdClicked(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onAdClicked " + nestAdData);
            if (nestAdData != null) {
                d66.a(nestAdData.getRequestId(), nestAdData, AdFragment.this.i, AdFragment.this.l);
            }
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onAdClose(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onAdClose " + nestAdData);
            AdFragment.this.R();
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onAdExposed(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment initAdView onAdExposed " + nestAdData);
            if (nestAdData != null) {
                d66.f(nestAdData.getRequestId(), nestAdData, AdFragment.this.i, AdFragment.this.l);
            }
            if (l6.a()) {
                q66.b = null;
                WifiLog.d("UserDetailRequestManager onAdExpose mCurAdData = null");
            }
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onDisLikeDialogDismiss(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onDisLikeDialogDismiss " + nestAdData);
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onDisLikeDialogShow(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onDisLikeDialogShow " + nestAdData);
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onDownloadComplete(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onDownloadComplete " + nestAdData);
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onDownloadFailed(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onDownloadFailed " + nestAdData);
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onDownloadInstalled(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onDownloadInstalled " + nestAdData);
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onDownloadStart(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onDownloadStart " + nestAdData);
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onRenderFail(@NonNull String str, @NonNull NestAdData nestAdData, @NonNull int i, @NonNull String str2) {
            LogUtil.d("UserDetailAd", "AdFragment onRenderFail " + nestAdData);
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onRenderSuccess(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onRenderSuccess " + nestAdData);
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onVideoComplete(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onVideoComplete " + nestAdData);
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onVideoError(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onVideoError " + nestAdData);
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onVideoPause(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onVideoPause " + nestAdData);
        }

        @Override // com.wifi.ad.core.listener.DrawShowListener
        public void onVideoStart(@NonNull String str, @NonNull NestAdData nestAdData) {
            LogUtil.d("UserDetailAd", "AdFragment onVideoStart " + nestAdData);
        }
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public View D() {
        return null;
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public boolean E() {
        return false;
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void G(BasePagerBean basePagerBean, int i) {
        if (basePagerBean instanceof SquareFeed) {
            this.e = (SquareFeed) basePagerBean;
            this.i = i;
        }
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void J() {
        LogUtil.d("UserDetailAd", "AdFragment swipeLeft");
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void K() {
        LogUtil.d("UserDetailAd", "AdFragment swipeRight");
    }

    public final void R() {
        SquareFeed squareFeed;
        LxFragmentViewHolder lxFragmentViewHolder = this.d;
        if (lxFragmentViewHolder == null || (squareFeed = this.e) == null) {
            return;
        }
        lxFragmentViewHolder.m(squareFeed);
    }

    public final void T() {
        LogUtil.d("UserDetailAd", "UserDetailAdControlV2L AdFragment showAd mShowAd " + this.j + " mCurPosition " + this.i + " mShowAdData " + this.f + " UserDetailRequestManager.mCurAdData " + q66.b);
        if (this.j || this.h == null) {
            return;
        }
        NestAdData nestAdData = q66.b;
        if (nestAdData != null) {
            this.f = nestAdData;
            q66.b = null;
        }
        if (this.f != null) {
            this.j = true;
            this.k.setVisibility(8);
            LogUtil.d("UserDetailAd", "AdFragment showNativeDrawAdVideo mCurPosition " + this.i + " mShowAdData " + this.f);
            AdHelperDrawVideo.INSTANCE.showNativeDrawAdVideo(this.f, this.h, new b());
        }
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public String getSid() {
        return this.l;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R$layout.layout_square_detail_ad_fragment, viewGroup, false);
        this.g = viewInflate;
        this.h = (FrameLayout) viewInflate.findViewById(R$id.ad_container);
        this.k = (ImageView) this.g.findViewById(R$id.img_noad_bg);
        if (p66.f()) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.l = arguments.getString("key_sid", "");
        }
        ((ImageView) this.g.findViewById(R$id.ad_native_close)).setOnClickListener(new a());
        if (!p66.f()) {
            T();
        }
        if (q66.b == null && getActivity() != null) {
            q66.d(getActivity(), this.l, false);
        }
        return this.g;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        NestAdData nestAdData;
        super.onDestroy();
        if (b6.d() && (nestAdData = this.f) != null) {
            SPCacheManager.INSTANCE.destroyOneAd(nestAdData);
        }
        this.f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.d("UserDetailAd", "AdFragment onResume mCurPosition " + this.i + " mShowAdData " + this.f + " UserDetailRequestManager.mCurAdData " + q66.b);
        T();
        if (q66.b != null || getActivity() == null) {
            return;
        }
        q66.d(getActivity(), this.l, false);
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void L(hg1 hg1Var) {
    }
}

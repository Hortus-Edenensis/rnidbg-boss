package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.wifi.ad.core.config.EventParams;
import com.wifi.csj.ad.NestCsjProvider;
import com.zenmen.palmchat.ad.view.AdView;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.friendcircle.R$string;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.e6;
import defpackage.gr2;
import defpackage.je1;
import defpackage.w50;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AdViewHolderForCSJ extends MomentsBaseViewHolder {
    public Context I;
    public ViewGroup J;
    public Feed K;
    public boolean L;
    public TextView M;
    public ImageView N;
    public FrameLayout O;
    public TextView P;
    public Button Q;
    public LinearLayout R;
    public TextView S;
    public int T;
    public Map<Long, TTAppDownloadListener> U;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TTAppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Button f13999a;
        public final /* synthetic */ e6 b;

        public a(Button button, e6 e6Var) {
            this.f13999a = button;
            this.b = e6Var;
        }

        public final boolean a() {
            return AdViewHolderForCSJ.this.U.get(Long.valueOf(this.b.b)) == this;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        @SuppressLint({"SetTextI18n"})
        public void onDownloadActive(long j, long j2, String str, String str2) {
            if (a()) {
                if (j <= 0) {
                    this.f13999a.setText("0%");
                } else {
                    this.f13999a.setText(((j2 * 100) / j) + "%");
                }
                w50.y("lx_client_sdkad_downloadS", this.b.f17220a.getImageMode(), this.b.f17220a.getInteractionType(), this.b.b, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            if (a()) {
                this.f13999a.setText("重新下载");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            LogUtil.d("AdViewHolderForCSJ", "onDownloadFinished");
            if (a()) {
                this.f13999a.setText("点击安装");
                w50.y("lx_client_sdkad_downloadF", this.b.f17220a.getImageMode(), this.b.f17220a.getInteractionType(), this.b.b, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        @SuppressLint({"SetTextI18n"})
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            if (a()) {
                if (j <= 0) {
                    this.f13999a.setText("0%");
                    return;
                }
                this.f13999a.setText(((j2 * 100) / j) + "%");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            if (a()) {
                this.f13999a.setText(AdViewHolderForCSJ.this.L() ? "下载" : "开始下载");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            if (a()) {
                this.f13999a.setText("点击打开");
                w50.y("lx_client_sdkad_downloadO", this.b.f17220a.getImageMode(), this.b.f17220a.getInteractionType(), this.b.b, str2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TTAdDislike f14001a;

        public c(TTAdDislike tTAdDislike) {
            this.f14001a = tTAdDislike;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTAdDislike tTAdDislike = this.f14001a;
            if (tTAdDislike != null) {
                tTAdDislike.showDislikeDialog();
            }
        }
    }

    public AdViewHolderForCSJ(Context context, ViewGroup viewGroup, int i, boolean z) {
        super(context, viewGroup, i);
        this.U = new WeakHashMap();
        this.I = context;
        this.T = i;
        this.L = z;
    }

    public final void H(e6 e6Var, int i) {
        Context context;
        int i2;
        View adView;
        TTFeedAd tTFeedAd = e6Var.f17220a;
        M(true);
        this.P.setText(tTFeedAd.getDescription());
        TextView textView = this.S;
        if (w50.r()) {
            context = this.I;
            i2 = R$string.personalize_ad;
        } else {
            context = this.I;
            i2 = R$string.common_ad;
        }
        textView.setText(context.getString(i2));
        if (tTFeedAd.getImageMode() == 5) {
            this.N.setVisibility(8);
        } else {
            this.N.setVisibility(0);
            List<TTImage> imageList = tTFeedAd.getImageList();
            if (imageList != null && imageList.size() != 0) {
                gr2.j().h(imageList.get(0).getImageUrl(), this.N, AdView.getDisplayImageOptions());
                LogUtil.d("AdViewHolderForCSJ", "setData title = " + tTFeedAd.getDescription() + ", imgurl = " + imageList.get(0).getImageUrl());
            }
        }
        if (tTFeedAd.getIcon() != null) {
            je1.a aVarQ = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565);
            int i3 = R$drawable.ad_head;
            gr2.j().h(tTFeedAd.getIcon().getImageUrl(), this.f, aVarQ.B(i3).A(i3).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(i3).r());
        } else {
            this.f.setImageDrawable(this.I.getResources().getDrawable(com.zenmen.palmchat.friendcircle.R$drawable.ad_head));
        }
        this.M.setText(tTFeedAd.getTitle());
        this.h.setText(TextUtils.isEmpty(tTFeedAd.getSource()) ? this.I.getString(R$string.ad_moments_name) : tTFeedAd.getSource());
        I(this.R, tTFeedAd);
        ArrayList arrayList = new ArrayList();
        if (tTFeedAd.getImageMode() == 5) {
            arrayList.add(this.O);
            if (this.O != null && (adView = tTFeedAd.getAdView()) != null && adView.getParent() == null) {
                this.O.removeAllViews();
                this.O.addView(adView);
            }
            tTFeedAd.setVideoAdListener(new w50.c(e6Var));
        }
        List<View> arrayList2 = new ArrayList<>();
        arrayList2.add(this.J);
        List<View> arrayList3 = new ArrayList<>();
        arrayList3.add(this.Q);
        tTFeedAd.registerViewForInteraction(this.J, arrayList, arrayList2, arrayList3, this.R, new w50.b(e6Var, w50.i()));
        int interactionType = tTFeedAd.getInteractionType();
        if (interactionType == 2 || interactionType == 3) {
            this.Q.setVisibility(0);
            this.Q.setText("查看详情");
        } else if (interactionType == 4) {
            Context context2 = this.I;
            if (context2 instanceof Activity) {
                tTFeedAd.setActivityForDownloadApp((Activity) context2);
            }
            this.Q.setVisibility(0);
            this.Q.setText(L() ? "下载" : "立即下载");
            J(this.Q, e6Var);
        } else if (interactionType != 5) {
            this.Q.setVisibility(8);
        } else {
            this.Q.setVisibility(0);
            this.Q.setText("立即拨打");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("place", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("qads1", null, null, jSONObject.toString());
    }

    public final void I(View view, TTFeedAd tTFeedAd) {
        TTAdDislike dislikeDialog = tTFeedAd.getDislikeDialog((Activity) this.I);
        if (dislikeDialog != null) {
            tTFeedAd.getDislikeDialog((Activity) this.I).setDislikeInteractionCallback(new b(tTFeedAd));
        }
        view.setOnClickListener(new c(dislikeDialog));
    }

    public final void J(Button button, e6 e6Var) {
        a aVar = new a(button, e6Var);
        e6Var.b(aVar);
        this.U.put(Long.valueOf(e6Var.b), aVar);
    }

    public final void K(int i) {
        e6 e6VarH = w50.h(this.K.getFeedId());
        if (e6VarH != null) {
            LogUtil.d("AdViewHolderForCSJ", "getNativeAd from cache, position = " + i);
            H(e6VarH, i);
            return;
        }
        LogUtil.d("AdViewHolderForCSJ", "getNativeAd from sdk, position = " + i);
        w50.t(this.I, 1, i);
    }

    public final boolean L() {
        return this.T == R$layout.moments_ad_csj_style2;
    }

    public final void M(boolean z) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
        if (z) {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
            this.itemView.setVisibility(0);
        } else {
            this.itemView.setVisibility(8);
            ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
        }
        this.itemView.setLayoutParams(layoutParams);
    }

    public void N(boolean z) {
        this.L = z;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void x(@NonNull Feed feed, int i, int i2) {
        this.K = feed;
        M(false);
        if (this.L) {
            K(i);
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void z(@NonNull View view) {
        LogUtil.i("AdViewHolderForCSJ", "onFindView");
        this.J = (ViewGroup) l(R$id.moment_ad_view);
        this.M = (TextView) l(R$id.ad_title);
        this.N = (ImageView) l(R$id.ad_image);
        this.P = (TextView) l(R$id.ad_des);
        this.Q = (Button) l(R$id.ad_progress_btn);
        this.O = (FrameLayout) l(R$id.ad_view);
        this.R = (LinearLayout) l(R$id.ad_close_container);
        this.S = (TextView) l(R$id.ad_tag);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TTAdDislike.DislikeInteractionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TTFeedAd f14000a;

        public b(TTFeedAd tTFeedAd) {
            this.f14000a = tTFeedAd;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i, String str, boolean z) {
            AdViewHolderForCSJ adViewHolderForCSJ = AdViewHolderForCSJ.this;
            adViewHolderForCSJ.x.d(adViewHolderForCSJ.m(), AdViewHolderForCSJ.this.K);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("codeid", w50.i());
                jSONObject.put(com.umeng.ccg.a.x, NestCsjProvider.SDK_FROM);
                jSONObject.put(EventParams.KEY_PARAM_TEMPLATE, this.f14000a.getImageMode());
                jSONObject.put("reaction", this.f14000a.getInteractionType());
                jSONObject.put("reason", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.d("AdViewHolderForCSJ", "reportMDAForMainTab  params = " + jSONObject.toString());
            zn6.d("lx_client_sdkad_dislike", null, jSONObject.toString());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
        }
    }
}

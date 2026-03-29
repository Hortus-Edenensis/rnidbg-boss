package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.adsdk.utils.LxAdConst;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.friendcircle.R$string;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.je1;
import defpackage.l6;
import defpackage.me1;
import defpackage.ou3;
import defpackage.sd5;
import defpackage.su3;
import defpackage.vq3;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AdViewHolderForNestNew extends MomentsBaseViewHolder implements su3 {
    public static je1 g0;
    public static je1 h0;
    public final Context I;
    public Feed J;
    public boolean K;
    public int L;
    public NestAdData M;
    public ViewGroup N;
    public View O;
    public ImageView P;
    public TextView Q;
    public TextView R;
    public View S;
    public View T;
    public TextView U;
    public ViewGroup V;
    public View W;
    public ViewGroup X;
    public ImageView Y;
    public ImageView Z;
    public TextView e0;
    public TextView f0;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l6.k(43);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements sd5.e {
            public a() {
            }

            @Override // sd5.e
            public void a(sd5 sd5Var, int i, CharSequence charSequence) {
                AdViewHolderForNestNew.this.N(false);
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AdViewHolderForNestNew.this.I instanceof Activity) {
                String[] strArr = {AdViewHolderForNestNew.this.I.getString(R$string.fcircle_more_dislike_content)};
                new sd5.c(AdViewHolderForNestNew.this.I).c(strArr).b(new int[]{R$drawable.fcircle_icon_dislike_content}).d(new a()).a().a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f14006a;

        public d(TextView textView) {
            this.f14006a = textView;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
            this.f14006a.setText(R$string.ad_download_install);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
            Toast.makeText(this.f14006a.getContext(), R$string.ad_download_failed, 0).show();
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
            this.f14006a.setText(R$string.ad_download_open);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
            this.f14006a.setText(R$string.ad_download_resume);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
            this.f14006a.setText(R$string.ad_download_pause);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
            this.f14006a.setText(R$string.ad_download_start);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements NestAdData.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14007a;

        public e(int i) {
            this.f14007a = i;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            LogUtil.d("AdViewHolderForNestNew", "onAdClicked");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("requestId", vq3.j(nestAdData));
                jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
                jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(com.zenmen.palmchat.c.b()));
                jSONObject.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
                jSONObject.put("appid", nestAdData.getAppId());
                jSONObject.put("srcid", nestAdData.getAdCode());
                jSONObject.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
                jSONObject.put("scene", vq3.i);
                jSONObject.put("taichi", "LX-24412");
                jSONObject.put("exp_group", vq3.i());
                jSONObject.put(EventParams.KEY_CT_SDK_POSITION, this.f14007a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("lx_client_nestad_click", null, jSONObject.toString());
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            LogUtil.d("AdViewHolderForNestNew", "onAdExposed");
        }
    }

    public AdViewHolderForNestNew(Context context, ViewGroup viewGroup, boolean z) {
        super(context, viewGroup, R$layout.moments_ad_nest_new);
        this.I = context;
        this.K = z;
    }

    public static String I(NestAdData nestAdData) {
        List<String> imageList;
        if (nestAdData == null || (imageList = nestAdData.getImageList()) == null || imageList.isEmpty()) {
            return null;
        }
        return imageList.get(0);
    }

    public static boolean J(NestAdData nestAdData) {
        int iIntValue = nestAdData.getAdMode().intValue();
        return iIntValue == 4 || iIntValue == 5;
    }

    public static int L(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    public static String M(String str, String str2, String str3) {
        if (str2.equals("")) {
            throw new IllegalArgumentException("Old pattern must have content.");
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf < 0) {
                stringBuffer.append(str.substring(length));
                return stringBuffer.toString();
            }
            stringBuffer.append(str.substring(length, iIndexOf));
            stringBuffer.append(str3);
            length = str2.length() + iIndexOf;
        }
    }

    public final void G(ou3 ou3Var, int i) {
        NestAdData nestAdData = this.M;
        if (nestAdData != null) {
            nestAdData.setAppDownloadListener(new a());
        }
        NestAdData nestAdData2 = ou3Var.f19878a;
        this.M = nestAdData2;
        if (nestAdData2 != null && nestAdData2.getAdSPStrategy()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(1);
            arrayList.add(4);
            NestAdData nestAdDataChangeFeedCheckMaxAd = SPCacheManager.INSTANCE.changeFeedCheckMaxAd(this.M, arrayList);
            this.M = nestAdDataChangeFeedCheckMaxAd;
            ou3Var.f19878a = nestAdDataChangeFeedCheckMaxAd;
        }
        N(true);
        LogUtil.d("AdViewHolderForNestNew", "bindNestAdData position = " + i + ",sdkfrom = " + this.M.getSdkFrom() + ", mode = " + this.M.getAdMode() + ",title = " + this.M.getTitle() + ",desc = " + this.M.getDescription() + ", sid = " + this.M.getNestSid());
        String adIcon = this.M.getAdIcon();
        if (g0 == null) {
            g0 = a46.i(R$drawable.default_portrait);
        }
        gr2 gr2VarJ = gr2.j();
        if (adIcon == null) {
            adIcon = "";
        }
        gr2VarJ.h(adIcon, this.P, g0);
        String adAppName = this.M.getAdAppName();
        TextView textView = this.Q;
        if (TextUtils.isEmpty(adAppName)) {
            adAppName = this.I.getString(com.zenmen.palmchat.framework.R$string.ad_moments_name);
        }
        textView.setText(adAppName);
        this.R.setText(M(M("&分钟前 · 最近有$人查看过", ContainerUtils.FIELD_DELIMITER, L(1, 60) + ""), "$", L(50, 500) + ""));
        l6.l(43);
        this.S.setOnClickListener(new b());
        this.T.setOnClickListener(new c());
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            this.U.setText(R$string.personalize_ad);
        } else {
            this.U.setText(R$string.common_ad);
        }
        if (h0 == null) {
            h0 = a46.i(R$drawable.fcircle_bg_feed_item_loading);
        }
        this.X.removeAllViews();
        if (J(this.M)) {
            this.Y.setVisibility(8);
            View adView = this.M.getAdView();
            if (adView != null) {
                ViewParent parent = adView.getParent();
                boolean z = parent instanceof ViewGroup;
                if (z) {
                    ((ViewGroup) parent).removeView(adView);
                }
                if (parent == null || z) {
                    this.X.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                }
            }
        } else {
            this.Y.setVisibility(0);
            String strI = I(this.M);
            gr2.j().h(strI != null ? strI : "", this.Y, h0);
        }
        this.Z.setImageResource(this.M.getAdLogoResId());
        TextView textView2 = this.e0;
        if (this.M.getInteractionType().intValue() == 1) {
            textView2.setText(R$string.ad_download_start);
            this.M.setAppDownloadListener(new d(textView2));
        } else {
            textView2.setText(R$string.ad_show_more);
        }
        String title = this.M.getTitle();
        if (!TextUtils.isEmpty(title) && title.equals(this.M.getAdAppName())) {
            title = this.M.getDescription();
        }
        if (TextUtils.isEmpty(title)) {
            title = this.I.getString(com.zenmen.palmchat.framework.R$string.ad_moments_default_desc);
        }
        this.f0.setText(title);
        this.M.setAdInteractionListener(new e(i));
        int childCount = this.N.getChildCount();
        if (childCount > 1) {
            this.N.removeViews(1, childCount - 1);
        }
        AdHelperFeed.INSTANCE.registerViewAndAction((ViewGroup) this.itemView, textView2, new View[]{this.O}, null, null, this.M);
    }

    public final void H(int i) {
        ou3 ou3VarH = vq3.h(this.J.getFeedId());
        this.L = i;
        if (ou3VarH != null) {
            LogUtil.d("AdViewHolderForNestNew", "getNativeAd from cache, position = " + i);
            G(ou3VarH, i);
            return;
        }
        LogUtil.d("AdViewHolderForNestNew", "getNativeAd from sdk, position = " + i);
        vq3.n(this.I, i);
    }

    public void K() {
        LogUtil.i("AdViewHolderForNestNew", "onDestroy");
        if (this.M != null) {
            WifiNestAd.INSTANCE.createAdFeed().destroyAd(this.M);
        }
    }

    public final void N(boolean z) {
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

    public void O(boolean z) {
        this.K = z;
    }

    @Override // defpackage.su3
    public void d(ou3 ou3Var, double d2) {
        LogUtil.d("AdViewHolderForNestNew", "onAdInvisiable area = " + d2);
        if (ou3Var == null || ou3Var.f19878a == null) {
            return;
        }
        WifiNestAd.INSTANCE.createAdFeed().stopAd(ou3Var.f19878a);
    }

    @Override // defpackage.su3
    public ou3 f() {
        return vq3.h(this.J.getFeedId());
    }

    @Override // defpackage.su3
    public ViewGroup getContainerView() {
        return this.V;
    }

    @Override // defpackage.su3
    public int h() {
        return this.L;
    }

    @Override // defpackage.su3
    public void j(ou3 ou3Var, double d2, int i) {
        if (ou3Var == null || ou3Var.f19878a == null) {
            return;
        }
        WifiNestAd.INSTANCE.createAdFeed().startAd(ou3Var.f19878a);
        NestAdData nestAdData = ou3Var.f19878a;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", vq3.j(nestAdData));
            jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
            jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(com.zenmen.palmchat.c.b()));
            jSONObject.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
            jSONObject.put("appid", nestAdData.getAppId());
            jSONObject.put("srcid", nestAdData.getAdCode());
            jSONObject.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
            jSONObject.put("scene", vq3.i);
            jSONObject.put("taichi", "LX-24412");
            jSONObject.put("exp_group", vq3.i());
            jSONObject.put(EventParams.KEY_CT_SDK_POSITION, i);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("lx_client_nestad_show", null, jSONObject.toString());
    }

    public void onPause() {
        LogUtil.i("AdViewHolderForNestNew", "onPause");
        if (this.M != null) {
            WifiNestAd.INSTANCE.createAdFeed().pauseAd(this.M);
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void x(@NonNull Feed feed, int i, int i2) {
        this.J = feed;
        N(false);
        if (this.K) {
            H(i);
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void z(@NonNull View view) {
        LogUtil.i("AdViewHolderForNestNew", "onFindView");
        this.N = (ViewGroup) l(R$id.ad_struts);
        this.O = l(R$id.ad_container);
        this.P = (ImageView) l(R$id.ad_app_icon);
        this.Q = (TextView) l(R$id.ad_app_name);
        this.R = (TextView) l(R$id.ad_infor);
        this.S = l(R$id.vip_entrance);
        this.T = l(R$id.ad_drop);
        this.U = (TextView) l(R$id.ad_sign);
        this.V = (ViewGroup) l(R$id.ad_container_main);
        this.W = l(R$id.ad_video_wrapper);
        this.X = (ViewGroup) l(R$id.ad_video);
        this.Y = (ImageView) l(R$id.ad_img);
        this.Z = (ImageView) l(R$id.ad_logo_normal);
        this.e0 = (TextView) l(R$id.ad_action_normal);
        this.f0 = (TextView) l(R$id.ad_title);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#B3000000"));
        gradientDrawable.setCornerRadius(me1.b(this.e0.getContext(), 100));
        gradientDrawable.setStroke(me1.a(this.e0.getContext(), 0.5f), Color.parseColor("#99FFFFFF"));
        this.e0.setBackgroundDrawable(gradientDrawable);
        this.e0.setTextColor(Color.parseColor("#FFFFFF"));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements NestAdData.AppDownloadListener {
        public a() {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
        }
    }
}

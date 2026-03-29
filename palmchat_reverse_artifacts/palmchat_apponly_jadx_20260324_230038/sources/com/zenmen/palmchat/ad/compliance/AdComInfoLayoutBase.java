package com.zenmen.palmchat.ad.compliance;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wifi.ad.core.R;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.n6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdComInfoLayoutBase extends RelativeLayout {
    private ViewGroup mAllFunctionLayout;
    private TextView mAppVersion;
    private TextView mCompany;
    protected ViewGroup mComplianceLayout;
    protected Context mContext;
    public TextView mFunction;
    public TextView mPermission;
    public TextView mPrivacy;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestAdData f12437a;

        public a(NestAdData nestAdData) {
            this.f12437a = nestAdData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdComplianceUtil.startCommonWebView(this.f12437a.getAdAppFunctionDescUrl(), AdComInfoLayoutBase.this.mContext.getString(R.string.ad_function), AdComInfoLayoutBase.this.mContext);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestAdData f12438a;

        public b(NestAdData nestAdData) {
            this.f12438a = nestAdData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdComplianceUtil.startCommonWebView(this.f12438a.getAdAppPermissionsUrl(), AdComInfoLayoutBase.this.mContext.getString(R.string.adsdk_generic_ad_info_permission), AdComInfoLayoutBase.this.mContext);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestAdData f12439a;

        public c(NestAdData nestAdData) {
            this.f12439a = nestAdData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdComplianceUtil.startCommonWebView(this.f12439a.getAdAppPrivacyUrl(), AdComInfoLayoutBase.this.mContext.getString(R.string.adsdk_generic_ad_info_privacy), AdComInfoLayoutBase.this.mContext);
        }
    }

    public AdComInfoLayoutBase(Context context) {
        super(context);
        initContext(context);
    }

    private void initContext(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void initComInfo(NestAdData nestAdData) {
        if (nestAdData != null) {
            int i = nestAdData.getInteractionType().intValue() != 1 ? 2 : 1;
            NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
            if (TextUtils.isEmpty(nestInfoTaker.getChannel())) {
                nestInfoTaker.putChannel(ac1.m);
            }
            boolean zC = n6.c(nestAdData.getAdScene() + "", i);
            LogUtil.d("", "AdDownViVoConfig initComInfo showInfo " + zC + " downType " + i + " adData.getAdScene() " + nestAdData.getAdScene());
            if (!zC) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            if (this.mCompany != null && !TextUtils.isEmpty(nestAdData.getAdAppDeveloperName())) {
                this.mCompany.setText(nestAdData.getAdAppDeveloperName());
            }
            if (this.mAppVersion != null && !TextUtils.isEmpty(nestAdData.getAdAppVersion())) {
                this.mAppVersion.setText("版本号:" + nestAdData.getAdAppVersion());
            }
            if (this.mAllFunctionLayout != null) {
                if (TextUtils.isEmpty(nestAdData.getAdAppFunctionDescUrl())) {
                    this.mAllFunctionLayout.setVisibility(8);
                } else {
                    this.mAllFunctionLayout.setVisibility(0);
                }
                TextView textView = this.mFunction;
                if (textView != null) {
                    textView.setOnClickListener(new a(nestAdData));
                }
            }
            LogUtil.d("", "AdDownViVoConfig initComInfo adData.getAdScene() " + nestAdData.getAdScene() + " mPermission " + nestAdData.getAdAppPermissionsUrl());
            if (this.mPermission != null && !TextUtils.isEmpty(nestAdData.getAdAppPermissionsUrl())) {
                this.mPermission.setOnClickListener(new b(nestAdData));
            }
            LogUtil.d("", "AdDownViVoConfig initComInfo adData.getAdScene() " + nestAdData.getAdScene() + " mPrivacy " + nestAdData.getAdAppPrivacyUrl());
            if (this.mPrivacy == null || TextUtils.isEmpty(nestAdData.getAdAppPrivacyUrl())) {
                return;
            }
            this.mPrivacy.setOnClickListener(new c(nestAdData));
        }
    }

    public void initView() {
        ViewGroup viewGroup = this.mComplianceLayout;
        if (viewGroup != null) {
            addView(viewGroup, new ViewGroup.LayoutParams(-1, -2));
            this.mPermission = (TextView) this.mComplianceLayout.findViewById(R$id.permission);
            this.mFunction = (TextView) this.mComplianceLayout.findViewById(R$id.function);
            this.mAllFunctionLayout = (ViewGroup) this.mComplianceLayout.findViewById(R$id.function_all_layout);
            this.mPrivacy = (TextView) this.mComplianceLayout.findViewById(R$id.privacy);
            this.mAppVersion = (TextView) this.mComplianceLayout.findViewById(R$id.version);
            this.mCompany = (TextView) this.mComplianceLayout.findViewById(R$id.company);
            LogUtil.d("", "AdDownViVoConfig AdComInfoAllLayout mComplianceLayout " + this.mComplianceLayout + " mAllFunctionLayout " + this.mAllFunctionLayout + " mAppVersion " + this.mAppVersion);
        }
    }

    public AdComInfoLayoutBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initContext(context);
    }

    public AdComInfoLayoutBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initContext(context);
    }

    public AdComInfoLayoutBase(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initContext(context);
    }
}

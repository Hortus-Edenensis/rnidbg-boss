package com.wifi.adsdk.baseview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.utils.BLPlatform;
import com.wifi.adsdk.utils.CheckDoubleClick;
import com.wifi.lxad.ad.R;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AdComInfoLayoutBase extends RelativeLayout {
    private ViewGroup mAllFunctionLayout;
    private TextView mAppVersion;
    private TextView mCompany;
    protected ViewGroup mComplianceLayout;
    protected Context mContext;
    public TextView mFunction;
    public TextView mPermission;
    public TextView mPrivacy;

    public AdComInfoLayoutBase(Context context) {
        super(context);
        initContext(context);
    }

    private void initContext(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private boolean isAppDown(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getClickTargetUrl() == null) {
            return false;
        }
        return (TextUtils.isEmpty(lxAdBeanData.getClickTargetUrl().getMarketUrl()) && TextUtils.isEmpty(lxAdBeanData.getClickTargetUrl().getPackageUrl())) ? false : true;
    }

    public void initComInfo(final LxAdBeanData lxAdBeanData) {
        TextView textView;
        if (!isAppDown(lxAdBeanData)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.mCompany != null && !TextUtils.isEmpty(lxAdBeanData.getAdvertiserName())) {
            this.mCompany.setText(lxAdBeanData.getAdvertiserName());
        }
        if (this.mAppVersion != null && !TextUtils.isEmpty(lxAdBeanData.getAppVersion())) {
            this.mAppVersion.setText("版本号:" + lxAdBeanData.getAppVersion());
        }
        if (this.mAllFunctionLayout != null && (textView = this.mFunction) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.baseview.AdComInfoLayoutBase.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    String descriptionUrl = lxAdBeanData.getDescriptionUrl();
                    if (descriptionUrl == null || !descriptionUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        BLPlatform.startTextActivity(descriptionUrl, "功能", AdComInfoLayoutBase.this.getContext());
                    } else {
                        AdComplianceUtil.startCommonWebView(descriptionUrl, "功能", AdComInfoLayoutBase.this.getContext());
                    }
                }
            });
        }
        TextView textView2 = this.mPermission;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.baseview.AdComInfoLayoutBase.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    String permissionUrl = lxAdBeanData.getPermissionUrl();
                    if (permissionUrl == null || !permissionUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        BLPlatform.startTextActivity(permissionUrl, "权限", AdComInfoLayoutBase.this.getContext());
                    } else {
                        AdComplianceUtil.startCommonWebView(permissionUrl, "权限", AdComInfoLayoutBase.this.getContext());
                    }
                }
            });
        }
        TextView textView3 = this.mPrivacy;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.baseview.AdComInfoLayoutBase.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    String privacyPolicyUrl = lxAdBeanData.getPrivacyPolicyUrl();
                    if (privacyPolicyUrl == null || !privacyPolicyUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        BLPlatform.startTextActivity(privacyPolicyUrl, "隐私", AdComInfoLayoutBase.this.getContext());
                    } else {
                        AdComplianceUtil.startCommonWebView(privacyPolicyUrl, "隐私", AdComInfoLayoutBase.this.getContext());
                    }
                }
            });
        }
    }

    public void initView() {
        ViewGroup viewGroup = this.mComplianceLayout;
        if (viewGroup != null) {
            addView(viewGroup, new ViewGroup.LayoutParams(-1, -2));
            this.mPermission = (TextView) this.mComplianceLayout.findViewById(R.id.permission);
            this.mFunction = (TextView) this.mComplianceLayout.findViewById(R.id.function);
            this.mAllFunctionLayout = (ViewGroup) this.mComplianceLayout.findViewById(R.id.function_all_layout);
            this.mPrivacy = (TextView) this.mComplianceLayout.findViewById(R.id.privacy);
            this.mAppVersion = (TextView) this.mComplianceLayout.findViewById(R.id.version);
            this.mCompany = (TextView) this.mComplianceLayout.findViewById(R.id.company);
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
}

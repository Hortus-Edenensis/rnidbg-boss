package com.wifi.adsdk.download;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.wifi.adsdk.entity.LxAdBaseView;
import com.wifi.adsdk.utils.BLPlatform;
import com.wifi.adsdk.utils.CheckDoubleClick;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.lxad.ad.R;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdDownDialog extends Dialog {
    private String advertiserName;
    private int appSize;
    private String appVersion;
    private View btnView;
    private View closeView;
    private String curPkgName;
    private String curPkgUrl;
    private String desc;
    private TextView descView;
    private String descriptionUrl;
    private TextView devView;
    private View funView;
    private String iconUrl;
    private ImageView iconView;
    private JSONObject jsonObject;
    private Activity mAct;
    private LxAdDownMdaData mAdDownMdaData;
    private LxAdBaseView mBaseView;
    private ViewGroup mContentView;
    private Context mContext;
    private View perView;
    private String permissionUrl;
    private String privacyPolicyUrl;
    private TextView sizeView;
    private String title;
    private TextView titleView;
    private TextView verView;
    private View ysView;

    public LxAdDownDialog(@NonNull Context context, JSONObject jSONObject, LxAdBaseView lxAdBaseView, LxAdDownMdaData lxAdDownMdaData) {
        super(context, R.style.AdPopFullScreenDialog);
        setCanceledOnTouchOutside(false);
        this.mContentView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_download_apk_info, (ViewGroup) null);
        this.mContext = context;
        this.jsonObject = jSONObject;
        this.mBaseView = lxAdBaseView;
        this.mAdDownMdaData = lxAdDownMdaData;
        if (context instanceof Activity) {
            this.mAct = (Activity) context;
        }
        initData(jSONObject);
    }

    private void initData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.curPkgName = jSONObject.optString("pkgName");
            this.curPkgUrl = jSONObject.optString(LxAdDLManager.ITEM_PKGURL);
            this.descriptionUrl = jSONObject.optString(LxAdDLManager.ITEM_DESCURL);
            this.permissionUrl = jSONObject.optString(LxAdDLManager.ITEM_PERURL);
            this.privacyPolicyUrl = jSONObject.optString("privacyPolicyUrl");
            this.iconUrl = jSONObject.optString(LxAdDLManager.ITEM_ICONURL);
            this.title = jSONObject.optString("title");
            this.desc = jSONObject.optString(LxAdDLManager.ITEM_DESC);
            this.appVersion = jSONObject.optString("appVersion");
            this.advertiserName = jSONObject.optString(LxAdDLManager.ITEM_ADVERNAME);
            this.appSize = jSONObject.optInt(LxAdDLManager.ITEM_APPSIZE);
        }
    }

    private void initView() {
        this.iconView = (ImageView) this.mContentView.findViewById(R.id.download_icon);
        View viewFindViewById = this.mContentView.findViewById(R.id.download_close);
        this.closeView = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.download.LxAdDownDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                LxAdDownDialog.this.dismiss();
            }
        });
        this.titleView = (TextView) this.mContentView.findViewById(R.id.download_title);
        this.descView = (TextView) this.mContentView.findViewById(R.id.download_desc);
        this.verView = (TextView) this.mContentView.findViewById(R.id.download_ver);
        this.sizeView = (TextView) this.mContentView.findViewById(R.id.download_size);
        this.devView = (TextView) this.mContentView.findViewById(R.id.download_dev);
        View viewFindViewById2 = this.mContentView.findViewById(R.id.download_function);
        this.funView = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.download.LxAdDownDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                LxAdDownDialog lxAdDownDialog = LxAdDownDialog.this;
                lxAdDownDialog.landPage(lxAdDownDialog.descriptionUrl, "功能");
            }
        });
        View viewFindViewById3 = this.mContentView.findViewById(R.id.download_per);
        this.perView = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.download.LxAdDownDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                LxAdDownDialog lxAdDownDialog = LxAdDownDialog.this;
                lxAdDownDialog.landPage(lxAdDownDialog.permissionUrl, "权限");
            }
        });
        View viewFindViewById4 = this.mContentView.findViewById(R.id.download_ys);
        this.ysView = viewFindViewById4;
        viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.download.LxAdDownDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                LxAdDownDialog lxAdDownDialog = LxAdDownDialog.this;
                lxAdDownDialog.landPage(lxAdDownDialog.privacyPolicyUrl, "隐私");
            }
        });
        View viewFindViewById5 = this.mContentView.findViewById(R.id.download_btn);
        this.btnView = viewFindViewById5;
        viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.download.LxAdDownDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                LxAdDownDialog.this.startDownApp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void landPage(String str, String str2) {
        if (str == null || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            BLPlatform.startTextActivity(str, str2, getContext());
        } else {
            AdComplianceUtil.startCommonWebView(str, str2, getContext());
        }
    }

    private void setData() {
        if (!TextUtils.isEmpty(this.iconUrl)) {
            Glide.with(this.mContext).load2(this.iconUrl).error(R.drawable.lxad_head_default).into(this.iconView);
        }
        if (!TextUtils.isEmpty(this.title)) {
            this.titleView.setText(this.title);
        }
        if (!TextUtils.isEmpty(this.desc)) {
            this.descView.setText(this.desc);
        }
        if (!TextUtils.isEmpty(this.appVersion)) {
            this.verView.setText("版本号:" + this.appVersion);
        }
        int i = this.appSize;
        if (i > 0) {
            this.sizeView.setText("应用大小:" + ((int) (i / 1024.0f)) + "M");
        }
        if (TextUtils.isEmpty(this.advertiserName)) {
            return;
        }
        this.devView.setText("开发者:" + this.advertiserName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownApp() {
        LxAdBaseView lxAdBaseView = this.mBaseView;
        if (lxAdBaseView != null) {
            lxAdBaseView.firstClickDown = false;
        }
        LxAdDLManager.getInstance(this.mContext).createOrAddLxAllDataByPkg(this.mBaseView, this.curPkgName, this.curPkgUrl, this.mAdDownMdaData);
        int downStatus = LxAdDLManager.getInstance(this.mContext).getDownStatus(this.curPkgName);
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        boolean zHasDownPkg = wifiNestAd.getMAdRequestCallBack() != null ? wifiNestAd.getMAdRequestCallBack().hasDownPkg(this.curPkgName) : false;
        LxAdLog.d("LXadDown LxAdDownDialog startDownApp  downStatus " + downStatus + " jsonObject " + this.jsonObject + " hasDownPkg " + zHasDownPkg);
        if (downStatus == LxAdDLManager.STATUS_DOWNED || downStatus == LxAdDLManager.STATUS_INSTALLED) {
            LxAdDLManager.getInstance(this.mContext).startDownClick(downStatus, this.curPkgUrl, this.curPkgName);
        } else if (downStatus == LxAdDLManager.STATUS_NORMAL || !zHasDownPkg) {
            LxAdDLManager.getInstance(this.mContext).startDlAd(this.curPkgUrl, this.curPkgName, this.jsonObject);
        } else {
            LxAdDLManager.getInstance(this.mContext).startDownClick(downStatus, this.curPkgUrl, this.curPkgName);
        }
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Activity activity = this.mAct;
        if (activity instanceof LxAdDownFullActivity) {
            activity.finish();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.mContentView);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            initView();
            setData();
            LxAdLog.d("LXadDown LxAdDownDialog show curPkgName " + this.curPkgName);
        } catch (Exception unused) {
        }
    }
}

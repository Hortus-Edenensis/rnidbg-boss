package com.wifi.ad.core.helper;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.wifi.ad.core.R;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.utils.DeviceUtils;
import com.wifi.ad.core.utils.ScreenUtil;
import com.wifi.ad.core.view.WifiDownButton;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DefInterstitialLandscapeDialog extends DefInterstitialAdDialog implements View.OnClickListener {
    private TextView mAd;
    private ImageView mAdLogo;
    private TextView mAppName;
    private ImageView mClose;
    private RelativeLayout mContent;
    private View mContentView;
    private Context mContext;
    private WifiDownButton mDownload;
    private RelativeLayout mGroup;
    private TextView mHeGui;
    private RelativeLayout mHeGuiBg;
    private RelativeLayout mImageGroup;
    private ImageView mImageView;
    private TextView mPermission;
    private TextView mPrivacy;
    private TextView mTitle;
    private ViewGroup mVideoView;

    public DefInterstitialLandscapeDialog(@NonNull Context context) {
        super(context);
        this.mContentView = LayoutInflater.from(context).inflate(R.layout.adsdk_dialog_pop_landscape, (ViewGroup) null);
        this.mContext = context.getApplicationContext();
    }

    private String getName() {
        NestAdData nestAdData = this.mResultBean;
        if (nestAdData == null) {
            return "";
        }
        String adAppName = nestAdData.getAdAppName();
        if (TextUtils.isEmpty(adAppName)) {
            adAppName = this.mResultBean.getDspName();
            if (TextUtils.isEmpty(adAppName)) {
                return "";
            }
        }
        return adAppName;
    }

    private void initView() {
        this.mGroup = (RelativeLayout) findViewById(R.id.pop_layout);
        this.mImageGroup = (RelativeLayout) findViewById(R.id.image_group);
        this.mContent = (RelativeLayout) findViewById(R.id.pop_content);
        this.mImageView = (ImageView) findViewById(R.id.pop_image);
        this.mDownload = (WifiDownButton) findViewById(R.id.def_button);
        this.mHeGui = (TextView) findViewById(R.id.hegui);
        this.mPermission = (TextView) findViewById(R.id.permission);
        this.mPrivacy = (TextView) findViewById(R.id.privacy);
        this.mAppName = (TextView) findViewById(R.id.appname);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mAd = (TextView) findViewById(R.id.ad);
        this.mAdLogo = (ImageView) findViewById(R.id.ad_logo);
        this.mClose = (ImageView) findViewById(R.id.close);
        this.mHeGuiBg = (RelativeLayout) findViewById(R.id.hegui_group);
        this.mVideoView = (ViewGroup) findViewById(R.id.videoView);
        this.mClose.setOnClickListener(this);
    }

    private void setAppName() {
        if (TextUtils.isEmpty(getName())) {
            this.mAppName.setVisibility(8);
        } else {
            this.mAppName.setVisibility(0);
            this.mAppName.setText(getName());
        }
    }

    private void setImageGroupParams() {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.LayoutParams layoutParams = this.mImageGroup.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = width;
            layoutParams.height = height;
            this.mImageGroup.setLayoutParams(layoutParams);
        }
    }

    private void updateHeGui() {
        this.mDownload.setAction(getActionType());
        if (getActionType() == 1) {
            setHeGui(this.mContext, this.mHeGui);
            return;
        }
        this.mHeGuiBg.setVisibility(4);
        this.mHeGui.setVisibility(8);
        this.mPrivacy.setVisibility(8);
        this.mPermission.setVisibility(8);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    public int getHeight() {
        int width = getWidth(this.mResultBean);
        int height = getHeight(this.mResultBean);
        int iDp2px = ScreenUtil.INSTANCE.dp2px(this.mContext, 177.0f);
        return (width <= 0 || height <= 0 || height > width) ? iDp2px : (int) ((getWidth() / width) * height);
    }

    public int getWidth() {
        return DeviceUtils.getScreenWidthPixels(this.mContext) - (ScreenUtil.INSTANCE.dp2px(this.mContext, 20.0f) * 2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.close) {
            dismiss();
        }
    }

    @Override // com.wifi.ad.core.helper.DefInterstitialAdDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.mContentView);
        initView();
    }

    @Override // com.wifi.ad.core.helper.DefInterstitialAdDialog
    public void refreshDownloadView(NestAdData nestAdData, int i, int i2) {
        super.refreshDownloadView(nestAdData, i, i2);
        WifiDownButton wifiDownButton = this.mDownload;
        if (wifiDownButton != null) {
            wifiDownButton.updateDownloadStatus(i2, i);
        }
    }

    @Override // com.wifi.ad.core.helper.DefInterstitialAdDialog
    public void setData() {
        updateHeGui();
        switchVideoOrImage(this.mVideoView, this.mImageView);
        setImageGroupParams();
        setAdText(this.mAd);
        this.mAdLogo.setImageResource(this.mResultBean.getAdLogoResId());
        setTitle(this.mResultBean, this.mTitle);
        setAppName();
        wrapDecorationIfGDT(this.mContent, true);
        registerViewAndAction(this.mGroup, this.mDownload, null, this.mPrivacy, this.mPermission);
    }

    @Override // com.wifi.ad.core.helper.DefInterstitialAdDialog, android.app.Dialog
    public void show() {
        super.show();
    }
}

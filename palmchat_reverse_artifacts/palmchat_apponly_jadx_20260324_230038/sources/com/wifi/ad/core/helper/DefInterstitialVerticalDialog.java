package com.wifi.ad.core.helper;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.ss.android.ttvecamera.TECameraResult;
import com.wifi.ad.core.R;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.utils.DeviceUtils;
import com.wifi.ad.core.utils.ScreenUtil;
import com.wifi.ad.core.view.WifiDownButton;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DefInterstitialVerticalDialog extends DefInterstitialAdDialog implements View.OnClickListener {
    private TextView mAd;
    private ImageView mAdLogo;
    private ImageView mClose;
    private RelativeLayout mContent;
    private View mContentView;
    private Context mContext;
    private WifiDownButton mDownload;
    private RelativeLayout mGroup;
    private TextView mHeGui;
    private RelativeLayout mHeGuiBg;
    private ImageView mImageView;
    private TextView mPermission;
    private TextView mPrivacy;
    private TextView mTitle;
    private ViewGroup mVideoView;

    public DefInterstitialVerticalDialog(@NonNull Context context) {
        super(context);
        this.mContentView = LayoutInflater.from(context).inflate(R.layout.adsdk_dialog_pop_vertical, (ViewGroup) null);
        this.mContext = context.getApplicationContext();
    }

    private void initView() {
        this.mGroup = (RelativeLayout) findViewById(R.id.pop_layout);
        this.mContent = (RelativeLayout) findViewById(R.id.pop_content);
        this.mImageView = (ImageView) findViewById(R.id.pop_image);
        this.mDownload = (WifiDownButton) findViewById(R.id.def_button);
        this.mHeGui = (TextView) findViewById(R.id.hegui);
        this.mPermission = (TextView) findViewById(R.id.permission);
        this.mTitle = (TextView) findViewById(R.id.desc);
        this.mPrivacy = (TextView) findViewById(R.id.privacy);
        this.mHeGuiBg = (RelativeLayout) findViewById(R.id.hegui_group);
        this.mAd = (TextView) findViewById(R.id.ad);
        this.mAdLogo = (ImageView) findViewById(R.id.ad_logo);
        this.mClose = (ImageView) findViewById(R.id.close);
        this.mVideoView = (ViewGroup) findViewById(R.id.videoView);
        this.mClose.setOnClickListener(this);
    }

    private void setContentViewParams() {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.LayoutParams layoutParams = this.mContent.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = width;
            layoutParams.height = height;
            this.mContent.setLayoutParams(layoutParams);
        }
    }

    private void updateHeGui() {
        this.mDownload.setAction(getActionType());
        if (getActionType() == 1) {
            setHeGui(this.mContext, this.mHeGui);
            return;
        }
        this.mHeGui.setVisibility(8);
        this.mPrivacy.setVisibility(8);
        this.mPermission.setVisibility(8);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    public int getHeight() {
        int screenHeightPixels = DeviceUtils.getScreenHeightPixels(this.mContext);
        int iDp2px = screenHeightPixels - (ScreenUtil.INSTANCE.dp2px(this.mContext, 95.0f) * 2);
        int width = getWidth(this.mResultBean);
        int height = getHeight(this.mResultBean);
        int width2 = getWidth();
        if (width > 0 && height > 0 && height > width) {
            iDp2px = (int) ((width2 / width) * height);
        }
        return Math.min(screenHeightPixels + TECameraResult.TER_GL_ERROR, iDp2px);
    }

    public int getWidth() {
        return DeviceUtils.getScreenWidthPixels(this.mContext) - (ScreenUtil.INSTANCE.dp2px(this.mContext, 30.0f) * 2);
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
        setContentViewParams();
        setAdText(this.mAd);
        this.mAdLogo.setImageResource(this.mResultBean.getAdLogoResId());
        setTitle(this.mResultBean, this.mTitle);
        wrapDecorationIfGDT(this.mContent, true);
        registerViewAndAction(this.mGroup, this.mDownload, new View[]{this.mContent}, this.mPrivacy, this.mPermission);
    }

    @Override // com.wifi.ad.core.helper.DefInterstitialAdDialog, android.app.Dialog
    public void show() {
        super.show();
    }
}

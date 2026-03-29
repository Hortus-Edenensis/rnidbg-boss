package com.wifi.ad.core.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.dialog.DisLikeDialog;
import com.wifi.ad.core.listener.NativeViewListener;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.csj.ad.NestCsjProvider;
import com.wifi.ks.ad.NestKsProvider;
import com.wifi.self.ad.NestWifiProvider;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AdRootViewWrapper extends FrameLayout {
    private Runnable countDownRunnable;
    private int downX;
    private int downY;
    private boolean isLongClick;
    private boolean isRelease;
    private NestAdData mAdData;
    private int mDefaultLongPressTime;
    private ViewGroup mGroup;
    private NativeViewListener mListener;
    private int mTouchSlop;

    public AdRootViewWrapper(Context context, ViewGroup viewGroup, NestAdData nestAdData, NativeViewListener nativeViewListener) {
        super(context);
        this.mDefaultLongPressTime = 500;
        this.downX = 0;
        this.downY = 0;
        this.isLongClick = false;
        this.isRelease = false;
        this.countDownRunnable = new Runnable() { // from class: com.wifi.ad.core.view.AdRootViewWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                AdRootViewWrapper.this.isLongClick = true;
                WifiLog.d("AdRootViewWrapper onLongClick");
                AdRootViewWrapper.this.showDislikeDialog();
            }
        };
        init(context);
        this.mAdData = nestAdData;
        this.mListener = nativeViewListener;
        this.mGroup = viewGroup;
        viewGroup.addView(this);
    }

    private EventParams buildParams(NestAdData nestAdData) {
        return new EventParams.Builder().setScene("nestSdk").setDspName(nestAdData.getDspName()).setNestSid(nestAdData.getNestSid()).setPosition(nestAdData.getPosition()).setTmAdBtnShow(nestAdData.getShowAdButtonTime()).setRedAdBtnShow(nestAdData.getChangeAdBtnColorTime()).setCtAdBtnShow(nestAdData.getShowAdCardTime()).setSdkFrom(nestAdData.getSdkFrom()).setInventoryId(nestAdData.getInventoryId()).setAdType(getSdkType(nestAdData.getSdkFrom())).setRenderStyle(nestAdData.getRenderStyle()).setMediaId(nestAdData.getAppId()).setSrcId(nestAdData.getAdCode()).build();
    }

    private String getSdkType(String str) {
        return TextUtils.equals(str, NestCsjProvider.SDK_FROM) ? "1" : TextUtils.equals(str, "guangdiantong") ? "5" : TextUtils.equals(str, NestKsProvider.SDK_FROM) ? "6" : TextUtils.equals(str, NestWifiProvider.SDK_FROM) ? "2" : "0";
    }

    private void init(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mDefaultLongPressTime = ViewConfiguration.getLongPressTimeout();
        WifiLog.d("AdRootViewWrapper mDefaultTouchSlop = " + this.mTouchSlop + " mDefaultLongPressTime =" + this.mDefaultLongPressTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDislikeEvent(NestAdData nestAdData) {
        buildParams(nestAdData);
    }

    private void onDislikePerEvent(NestAdData nestAdData) {
        buildParams(nestAdData);
    }

    private void onDislikeWhyEvent(NestAdData nestAdData) {
        buildParams(nestAdData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDislikeDialog() {
        if (checkActivityValid(getContext())) {
            onDislikePerEvent(this.mAdData);
            DisLikeDialog disLikeDialog = new DisLikeDialog(getContext());
            NativeViewListener nativeViewListener = this.mListener;
            if (nativeViewListener != null) {
                nativeViewListener.onDisLikeDialogShow(this.mAdData.getAdType(), this.mAdData);
            }
            disLikeDialog.show();
            disLikeDialog.setDialogListener(new DisLikeDialog.DialogClickListener() { // from class: com.wifi.ad.core.view.AdRootViewWrapper.2
                @Override // com.wifi.ad.core.dialog.DisLikeDialog.DialogClickListener
                public void onDiskLikeClick() {
                    AdRootViewWrapper adRootViewWrapper = AdRootViewWrapper.this;
                    if (!adRootViewWrapper.checkActivityValid(adRootViewWrapper.getContext()) || AdRootViewWrapper.this.mAdData == null || AdRootViewWrapper.this.mListener == null) {
                        return;
                    }
                    AdRootViewWrapper adRootViewWrapper2 = AdRootViewWrapper.this;
                    adRootViewWrapper2.onDislikeEvent(adRootViewWrapper2.mAdData);
                    if (AdRootViewWrapper.this.mListener != null) {
                        AdRootViewWrapper.this.mListener.onAdClose(AdRootViewWrapper.this.mAdData.getAdType(), AdRootViewWrapper.this.mAdData);
                    }
                    if (AdRootViewWrapper.this.mGroup != null) {
                        AdRootViewWrapper.this.mGroup.removeAllViews();
                    }
                }
            });
            disLikeDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.wifi.ad.core.view.AdRootViewWrapper.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AdRootViewWrapper.this.mListener != null) {
                        AdRootViewWrapper.this.mListener.onDisLikeDialogDismiss(AdRootViewWrapper.this.mAdData.getAdType(), AdRootViewWrapper.this.mAdData);
                    }
                }
            });
        }
    }

    public boolean checkActivityValid(Context context) {
        if (context != null && (context instanceof Activity)) {
            return !((Activity) context).isFinishing();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downX = (int) motionEvent.getX();
            this.downY = (int) motionEvent.getY();
            this.isRelease = false;
            this.isLongClick = false;
            postDelayed(this.countDownRunnable, this.mDefaultLongPressTime);
        } else if (action == 1) {
            this.isRelease = true;
            if (this.isLongClick) {
                WifiLog.d("AdRootViewWrapper isLongClick = true, return true");
                return true;
            }
            WifiLog.d("AdRootViewWrapper isLongClick = false, remove callback");
            removeCallbacks(this.countDownRunnable);
        } else if (action != 2) {
            if (action == 3 || action == 4) {
            }
        } else if (Math.abs(motionEvent.getX() - this.downX) < this.mTouchSlop || Math.abs(motionEvent.getY() - this.downY) < this.mTouchSlop || this.isRelease) {
            WifiLog.d("AdRootViewWrapper ACTION_MOVE break");
        }
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() != 0 || zDispatchTouchEvent) {
            return zDispatchTouchEvent;
        }
        WifiLog.d("AdRootViewWrapper event.getAction() == MotionEvent.ACTION_DOWN && ACTION_DOWN return false, we return true");
        return true;
    }
}

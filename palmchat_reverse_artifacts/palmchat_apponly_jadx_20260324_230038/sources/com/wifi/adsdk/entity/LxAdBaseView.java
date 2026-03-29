package com.wifi.adsdk.entity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.hardware.SensorEvent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.callback.LxAdDownListener;
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.wifi.adsdk.LxAdManager;
import com.wifi.adsdk.download.LxAdDLManager;
import com.wifi.adsdk.download.LxAdDownMdaData;
import com.wifi.adsdk.listener.LxBaseShowListener;
import com.wifi.adsdk.listener.LxNativeDownListener;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.sensor.LxAdSensorUtil;
import com.wifi.adsdk.sensor.OnShakeListener;
import com.wifi.adsdk.splash.LxAdSplashView;
import com.wifi.adsdk.utils.BLUtils;
import com.wifi.adsdk.utils.CheckDoubleClick;
import com.wifi.adsdk.utils.LxAdConst;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.adsdk.utils.Md5Utils;
import com.wifi.adsdk.video.LxAdVideoView;
import com.wifi.lxad.ad.R;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class LxAdBaseView extends FrameLayout {
    private static final int DOWN_STATUS_DOWNED = 8196;
    private static final int DOWN_STATUS_ERROR = 8198;
    private static final int DOWN_STATUS_INSTALLED = 8197;
    private static final int DOWN_STATUS_NORMAL = 8193;
    private static final int DOWN_STATUS_PAUSE = 8195;
    private static final int DOWN_STATUS_PROCESS = 8194;
    public static final int SHAKE_SLOP_TIME_MS = 2000;
    public float SHAKE_THRESHOLD_GRAVITY;
    public TextView adAction;
    private int clickDownX;
    private int clickDownY;
    public int clickType;
    private int clickUpX;
    private int clickUpY;
    private ViewGroup contentNativeVideoLayout;
    private String curPkgName;
    private String curPkgUrl;
    private String deepLink;
    private String deeplinkButtonUrl;
    private String downActionText;
    public LxAdDownListener downListener;
    private long downTime;
    public boolean firstClickDown;
    public boolean isHasVoice;
    public boolean isShowAd;
    private String landUrl;
    public LxEventReplace lxEventReplace;
    private Activity mAct;
    public LxAdBeanData mAdItem;
    public Context mContext;
    public LxAdReqParams mReqParams;
    public long mShakeTimestamp;
    public Handler mainHandler;
    private String marketLink;
    public LxNativeDownListener nativeDownListener;
    private String onlyId;
    private String pkgUrl;
    private String quickAppLink;
    public View reStartVideoView;
    private Handler sendMainHandler;
    public OnShakeListener shakeListener;
    public LxBaseShowListener showListener;
    public int srcHeight;
    public int srcWidth;
    private long upTime;
    public ImageView videoFinishImg;
    public View videoFinishLayout;
    public LxAdVideoView videoView;
    public ImageView voiceView;
    private WindowManager windowManager;
    private String wxAppPath;
    private String wxUserName;
    public int xAcc;
    public int yAcc;
    public int zAcc;

    public LxAdBaseView(Context context, LxAdBeanData lxAdBeanData, LxAdReqParams lxAdReqParams) {
        super(context);
        this.mContext = null;
        this.mReqParams = null;
        this.shakeListener = null;
        this.SHAKE_THRESHOLD_GRAVITY = -1.0f;
        this.clickType = 0;
        this.srcWidth = 0;
        this.srcHeight = 0;
        this.clickDownX = SkuConfig.INFINITE_COUNT;
        this.clickDownY = SkuConfig.INFINITE_COUNT;
        this.clickUpX = SkuConfig.INFINITE_COUNT;
        this.clickUpY = SkuConfig.INFINITE_COUNT;
        this.lxEventReplace = null;
        this.wxUserName = "";
        this.wxAppPath = "";
        this.deeplinkButtonUrl = "";
        this.deepLink = "";
        this.marketLink = "";
        this.landUrl = "";
        this.pkgUrl = "";
        this.quickAppLink = "";
        this.windowManager = null;
        this.downActionText = "点击下载";
        this.isHasVoice = false;
        this.mainHandler = null;
        this.contentNativeVideoLayout = null;
        this.downListener = new LxAdDownListener() { // from class: com.wifi.adsdk.entity.LxAdBaseView.9
            @Override // com.wifi.ad.core.callback.LxAdDownListener
            public void deleteDownApp(String str) {
                LxAdBaseView lxAdBaseView = LxAdBaseView.this;
                lxAdBaseView.firstClickDown = true;
                lxAdBaseView.downStatusChangeUi(lxAdBaseView.downActionText);
            }

            @Override // com.wifi.ad.core.callback.LxAdDownListener
            public void onError(int i, String str, String str2) {
                LxAdBaseView.this.sendNativeDownListenerStatus(LxAdDLManager.STATUS_ERROR, 0);
            }

            @Override // com.wifi.ad.core.callback.LxAdDownListener
            public void onFinish(String str) {
                LxAdBaseView.this.sendNativeDownListenerStatus(LxAdDLManager.STATUS_DOWNED, 0);
                LxAdBaseView.this.downStatusChangeUi("立即安装");
            }

            @Override // com.wifi.ad.core.callback.LxAdDownListener
            public void onInstalled(String str) {
                LxAdBaseView.this.sendNativeDownListenerStatus(LxAdDLManager.STATUS_INSTALLED, 0);
                LxAdBaseView.this.downStatusChangeUi("立即打开");
            }

            @Override // com.wifi.ad.core.callback.LxAdDownListener
            public void onProgress(int i, String str) {
                LxAdBaseView.this.sendNativeDownListenerStatus(LxAdDLManager.STATUS_DOWNING, i);
            }

            @Override // com.wifi.ad.core.callback.LxAdDownListener
            public void onResume(String str) {
                LxAdBaseView.this.downStatusChangeUi("暂停下载");
            }

            @Override // com.wifi.ad.core.callback.LxAdDownListener
            public void onStart(String str) {
                LxAdBaseView.this.sendNativeDownListenerStatus(LxAdDLManager.STATUS_NORMAL, 0);
                LxAdBaseView.this.downStatusChangeUi("暂停下载");
            }

            @Override // com.wifi.ad.core.callback.LxAdDownListener
            public void onStop(String str) {
                LxAdBaseView.this.sendNativeDownListenerStatus(LxAdDLManager.STATUS_PAUSE, 0);
                LxAdBaseView.this.downStatusChangeUi("继续下载");
            }

            @Override // com.wifi.ad.core.callback.LxAdDownListener
            public void onStartInstall() {
            }
        };
        this.firstClickDown = true;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mAdItem = lxAdBeanData;
        this.mContext = context;
        this.mReqParams = lxAdReqParams;
        this.lxEventReplace = lxAdBeanData.getEventReplace();
        this.onlyId = Md5Utils.md5(System.currentTimeMillis() + "" + hashCode() + "");
        LxAdBeanData lxAdBeanData2 = this.mAdItem;
        if (lxAdBeanData2 != null) {
            this.clickType = lxAdBeanData2.getAdInteractType();
            if (isYYAd()) {
                LxAdSensorUtil.initSensor(this.mContext);
            }
            this.curPkgName = this.mAdItem.getAppBundleId();
            ClickTargetBean clickTargetUrl = this.mAdItem.getClickTargetUrl();
            if (clickTargetUrl != null) {
                this.deepLink = clickTargetUrl.getCustomizedInvokeUrl();
                this.marketLink = clickTargetUrl.getMarketUrl();
                this.landUrl = clickTargetUrl.getLandingPageUrl();
                this.pkgUrl = clickTargetUrl.getPackageUrl();
                this.quickAppLink = clickTargetUrl.getQuickAppUrl();
                this.deeplinkButtonUrl = clickTargetUrl.getDeeplinkButtonUrl();
            }
            if (this.mAdItem.getClickTargetUrl() != null) {
                this.curPkgUrl = this.mAdItem.getClickTargetUrl().getPackageUrl();
            }
        }
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.wifi.adsdk.entity.LxAdBaseView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                LxAdBaseView lxAdBaseView = LxAdBaseView.this;
                TextView textView = lxAdBaseView.adAction;
                if (textView != null) {
                    lxAdBaseView.downActionText = textView.getText().toString();
                }
                LxAdBaseView.this.readyToShowEvent();
                LxAdLog.d("LxAdBaseView onViewAttachedToWindow shakeListener " + LxAdBaseView.this.shakeListener);
                LxAdBaseView.this.initSensor();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                LxAdLog.d("LxAdBaseView onViewDetachedFromWindow shakeListener " + LxAdBaseView.this.shakeListener);
                OnShakeListener onShakeListener = LxAdBaseView.this.shakeListener;
                if (onShakeListener != null) {
                    LxAdSensorUtil.removeShakeListener(onShakeListener);
                }
            }
        });
    }

    private void checkDownStatus() {
        if (isDownloadAd()) {
            int downStatus = LxAdDLManager.getInstance(getContext()).getDownStatus(this.curPkgName);
            if (downStatus != LxAdDLManager.STATUS_DOWNED) {
                if (downStatus != LxAdDLManager.STATUS_INSTALLED || BLUtils.isAppInstalled(this.curPkgName, getContext())) {
                    return;
                }
                LxAdDLManager.getInstance(getContext()).onDownError(this.pkgUrl, this.curPkgName, -10003, "apk not AppInstalled", false);
                LxAdLog.d("LxAdBaseView adDestroy STATUS_INSTALLED but not AppInstalled curPkgName " + this.curPkgName);
                return;
            }
            String filepathByPkg = LxAdDLManager.getInstance(getContext()).getFilepathByPkg(this.curPkgName);
            if (TextUtils.isEmpty(filepathByPkg)) {
                return;
            }
            File file = new File(filepathByPkg);
            LxAdLog.d("LxAdBaseView checkDownStatus STATUS_DOWNED  curPkgName " + this.curPkgName + " fileLength " + file.length());
            if (file.exists()) {
                return;
            }
            LxAdLog.d("LxAdBaseView adDestroy STATUS_DOWNED but apk filePath not exists curPkgName " + this.curPkgName);
            LxAdDLManager.getInstance(getContext()).onDownError(this.pkgUrl, this.curPkgName, -10002, "apk filePath not exists", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBackground() {
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (wifiNestAd.getMAdRequestCallBack() != null) {
            return wifiNestAd.getMAdRequestCallBack().isAppBackGround();
        }
        try {
            Method declaredMethod = Class.forName("com.zenmen.palmchat.modulemanager.lifecircle").getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("isBackground", new Class[0]);
            declaredMethod2.setAccessible(true);
            Object objInvoke2 = declaredMethod2.invoke(objInvoke, new Object[0]);
            LxAdLog.d("LxAd isBackground result event " + objInvoke2);
            if (objInvoke2 instanceof Boolean) {
                return ((Boolean) objInvoke2).booleanValue();
            }
        } catch (Exception e) {
            LxAdLog.d("LxAd isBackground eet " + e.toString());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCurVisible() {
        return getLocalVisibleRect(new Rect());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isViewShowIng() {
        try {
            if (this.windowManager == null) {
                this.windowManager = (WindowManager) this.mContext.getSystemService("window");
            }
            Field declaredField = this.windowManager.getClass().getDeclaredField("mGlobal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.windowManager);
            Field declaredField2 = obj.getClass().getDeclaredField("mViews");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (!(obj2 instanceof List)) {
                return false;
            }
            Object obj3 = ((List) obj2).get(((List) obj2).size() - 1);
            if (obj3 instanceof View) {
                return ((View) obj3).getWindowToken() == getWindowToken();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private void lxSdkDeepLingSuccessEvent() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        if (lxAdBeanData != null) {
            LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_DEEPLINK_SUCCESS, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdBeanData.getReqParams(), this.mAdItem.getEcpm(), this.mAdItem.getMaterialType(), this.mAdItem.getApiId(), 0, "", this.mAdItem.getApiSlotId(), "")));
        }
    }

    private void lxSdkMiniProgramSuccessEvent() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        if (lxAdBeanData != null) {
            LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_MINIPROGRAM_SUCCESS, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdBeanData.getReqParams(), this.mAdItem.getEcpm(), this.mAdItem.getMaterialType(), this.mAdItem.getApiId(), 0, "", this.mAdItem.getApiSlotId(), "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNativeDownListenerStatus(int i, int i2) {
        if (this.sendMainHandler == null) {
            this.sendMainHandler = new Handler(Looper.getMainLooper()) { // from class: com.wifi.adsdk.entity.LxAdBaseView.8
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    LxNativeDownListener lxNativeDownListener = LxAdBaseView.this.nativeDownListener;
                    if (lxNativeDownListener != null) {
                        switch (message.what) {
                            case 8193:
                                lxNativeDownListener.onDownloadStart();
                                break;
                            case 8194:
                                lxNativeDownListener.onDownloadProcess(message.arg1);
                                break;
                            case 8195:
                                lxNativeDownListener.onDownloadPause();
                                break;
                            case 8196:
                                lxNativeDownListener.onDownloadFinish();
                                break;
                            case 8197:
                                lxNativeDownListener.onInstall();
                                break;
                            case LxAdBaseView.DOWN_STATUS_ERROR /* 8198 */:
                                lxNativeDownListener.onDownloadFail(message.arg1, "error");
                                break;
                        }
                    }
                }
            };
        }
        Message messageObtain = Message.obtain();
        if (i == LxAdDLManager.STATUS_NORMAL) {
            messageObtain.what = 8193;
        } else if (i == LxAdDLManager.STATUS_DOWNING) {
            messageObtain.what = 8194;
            messageObtain.arg1 = i2;
        } else if (i == LxAdDLManager.STATUS_PAUSE) {
            messageObtain.what = 8195;
        } else if (i == LxAdDLManager.STATUS_DOWNED) {
            messageObtain.what = 8196;
        } else if (i == LxAdDLManager.STATUS_INSTALLED) {
            messageObtain.what = 8197;
        } else if (i == LxAdDLManager.STATUS_ERROR) {
            messageObtain.what = DOWN_STATUS_ERROR;
            messageObtain.arg1 = i2;
        }
        this.sendMainHandler.sendMessage(messageObtain);
    }

    private void startDefDeepLink() {
        String str;
        LxAdLog.d("startDefDeepLink deepLink " + this.deepLink);
        if (TextUtils.isEmpty(this.deepLink)) {
            startDefMarket();
            return;
        }
        int iStartDeepUrlActivity = BLUtils.startDeepUrlActivity(this.deepLink, this.mContext);
        LxAdLog.d("LxAdBaseView itemClick deepLink type " + iStartDeepUrlActivity);
        if (iStartDeepUrlActivity == 1) {
            lxSdkDeepLingSuccessEvent();
            str = "0";
        } else {
            startDefMarket();
            str = "1";
        }
        LxEventReplace eventReplace = this.mAdItem.getEventReplace();
        if (eventReplace != null) {
            eventReplace.setDpResult(str);
            eventReplace.setDpReason(iStartDeepUrlActivity + "");
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportDeepSuccess(this.mAdItem);
        }
    }

    private void startDefLandPage() {
        if (!TextUtils.isEmpty(this.landUrl)) {
            AdComplianceUtil.startCommonWebView(this.landUrl, "", getContext());
            return;
        }
        if (TextUtils.isEmpty(this.wxUserName) || TextUtils.isEmpty(this.wxAppPath) || LxAdManager.getAdManager().getConfig().getWxMiniProgramListener() == null) {
            return;
        }
        boolean zOnLaunchWechatMinProgram = LxAdManager.getAdManager().getConfig().getWxMiniProgramListener().onLaunchWechatMinProgram(this.mAdItem.getWechatAppUsername(), this.mAdItem.getWechatAppPath(), "");
        LxAdLog.d("LxAdBaseView itemClick WxMini result " + zOnLaunchWechatMinProgram);
        String str = !zOnLaunchWechatMinProgram ? "0" : "1";
        LxEventReplace eventReplace = this.mAdItem.getEventReplace();
        if (eventReplace != null) {
            eventReplace.setWxCall(str);
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportWxAppSuccess(this.mAdItem);
        }
    }

    private void startDefMarket() {
        if (TextUtils.isEmpty(this.marketLink) || BLUtils.startDeepUrlActivity(this.marketLink, this.mContext) != 1) {
            startDefPkgUrl();
        } else {
            LxAdLog.d("LxAdBaseView itemClick marketLink success");
        }
    }

    private void startDefPkgUrl() {
        if (TextUtils.isEmpty(this.pkgUrl)) {
            startDefQuickAppLink();
        } else {
            startDownloadApp();
        }
    }

    private void startDefQuickAppLink() {
        if (TextUtils.isEmpty(this.quickAppLink) || BLUtils.startDeepUrlActivity(this.quickAppLink, this.mContext) != 1) {
            startDefLandPage();
        } else if (this.mAdItem.getEventReplace() != null) {
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportAppOpenLink(this.mAdItem);
        }
    }

    private void startDownloadApp() {
        LxAdDownMdaData lxAdDownMdaDataFindMdaDownData = LxAdDLManager.getInstance(this.mContext).findMdaDownData(this.mAdItem, this.curPkgName, this.onlyId);
        LxAdLog.d("LXadDown baseView startDownloadApp curPkgName " + this.curPkgName + " firstClickDown " + this.firstClickDown + " onlyId " + this.onlyId);
        if (this instanceof LxAdSplashView) {
            LxAdDLManager.getInstance(this.mContext).startDownActDialog(this.mAdItem, lxAdDownMdaDataFindMdaDownData);
            return;
        }
        if (this.firstClickDown) {
            if (this.mAct != null) {
                LxAdDLManager.getInstance(this.mContext).startDownDialog(this.mAct, this.mAdItem, this, lxAdDownMdaDataFindMdaDownData);
                return;
            }
            return;
        }
        int downStatus = LxAdDLManager.getInstance(this.mContext).getDownStatus(this.curPkgName);
        if (downStatus != LxAdDLManager.STATUS_NORMAL) {
            LxAdDLManager.getInstance(this.mContext).startDownClick(downStatus, this.curPkgUrl, this.curPkgName);
        } else if (this.mAct != null) {
            LxAdDLManager.getInstance(this.mContext).startDownDialog(this.mAct, this.mAdItem, this, lxAdDownMdaDataFindMdaDownData);
        }
    }

    private void startHonorClick(int i) {
        String str;
        LxAdLog.d("LxAdBaseViewHonor startHonorClick deeplinkButtonUrl " + this.deeplinkButtonUrl + " clickFrom " + i);
        if (!TextUtils.isEmpty(this.deeplinkButtonUrl)) {
            if (i != 1 && i != 4) {
                if (BLUtils.startDeepUrlActivity(this.deeplinkButtonUrl, this.mContext) == 1) {
                    LxAdLog.d("LxAdBaseView startHonorClick deeplinkButtonUrl success");
                    return;
                } else {
                    startHonorLandUrl();
                    return;
                }
            }
            if (TextUtils.isEmpty(this.marketLink) || BLUtils.startDeepUrlActivity(this.marketLink, this.mContext) != 1) {
                startHonorLandUrl();
                return;
            } else {
                LxAdLog.d("LxAdBaseView startHonorClick marketLink success");
                return;
            }
        }
        if (TextUtils.isEmpty(this.deepLink)) {
            startHonorLandUrl();
            return;
        }
        int iStartDeepUrlActivity = BLUtils.startDeepUrlActivity(this.deepLink, this.mContext);
        LxAdLog.d("LxAdBaseViewHonor startHonorClick deepLink type " + iStartDeepUrlActivity);
        if (iStartDeepUrlActivity == 1) {
            lxSdkDeepLingSuccessEvent();
            str = "0";
        } else {
            startHonorLandUrl();
            str = "1";
        }
        LxEventReplace eventReplace = this.mAdItem.getEventReplace();
        if (eventReplace != null) {
            eventReplace.setDpResult(str);
            eventReplace.setDpReason(iStartDeepUrlActivity + "");
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportDeepSuccess(this.mAdItem);
        }
    }

    private void startHonorLandUrl() {
        if (TextUtils.isEmpty(this.landUrl)) {
            return;
        }
        AdComplianceUtil.startCommonWebView(this.landUrl, "", getContext());
    }

    private void startHuaweiDeepLink() {
        LxAdLog.d("startHuaweiDeepLink deepLink " + this.deepLink);
        if (TextUtils.isEmpty(this.deepLink)) {
            startHuaweiLandPage();
            return;
        }
        LxEventReplace eventReplace = this.mAdItem.getEventReplace();
        if (this.deepLink.startsWith("hwpps://landingpage")) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.deepLink));
            intent.addFlags(268435456);
            try {
                this.mContext.startActivity(intent);
                if (eventReplace != null) {
                    LxAdManager.getAdManager().getConfig().getUrlEvent().reportDeepSuccess(this.mAdItem);
                }
                lxSdkDeepLingSuccessEvent();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        int iStartDeepUrlActivity = BLUtils.startDeepUrlActivity(this.deepLink, this.mContext);
        LxAdLog.d("LxAdBaseView itemClick deepLink type " + iStartDeepUrlActivity);
        if (iStartDeepUrlActivity == 1) {
            if (eventReplace != null) {
                LxAdManager.getAdManager().getConfig().getUrlEvent().reportDeepSuccess(this.mAdItem);
            }
            lxSdkDeepLingSuccessEvent();
        } else {
            startHuaweiLandPage();
            if (eventReplace != null) {
                LxAdManager.getAdManager().getConfig().getUrlEvent().reportDeeplinkFailLink(this.mAdItem);
            }
        }
    }

    private void startHuaweiLandPage() {
        LxAdLog.d("LxAdBaseView startHuaweiLandPage landUrl " + this.landUrl);
        if (TextUtils.isEmpty(this.landUrl)) {
            startHuaweiPkg();
        } else {
            AdComplianceUtil.startCommonWebView(this.landUrl, "", getContext());
            LxAdLog.d("LxAdBaseView startHuaweiLandPage landUrl success");
        }
    }

    private void startHuaweiPkg() {
        String str;
        LxAdLog.d("LxAdBaseView startHuaweiMarkLink pkgUrl " + this.pkgUrl);
        if (!TextUtils.isEmpty(this.pkgUrl)) {
            LxAdLog.d("LxAdBaseView itemClick startHuaweiPkg success");
            startDownloadApp();
            return;
        }
        if (TextUtils.isEmpty(this.wxUserName) || TextUtils.isEmpty(this.wxAppPath) || LxAdManager.getAdManager().getConfig().getWxMiniProgramListener() == null) {
            return;
        }
        boolean zOnLaunchWechatMinProgram = LxAdManager.getAdManager().getConfig().getWxMiniProgramListener().onLaunchWechatMinProgram(this.mAdItem.getWechatAppUsername(), this.mAdItem.getWechatAppPath(), "");
        LxAdLog.d("LxAdBaseView itemClick startHuaweiPkg result " + zOnLaunchWechatMinProgram);
        if (zOnLaunchWechatMinProgram) {
            lxSdkMiniProgramSuccessEvent();
            str = "1";
        } else {
            str = "0";
        }
        LxEventReplace eventReplace = this.mAdItem.getEventReplace();
        if (eventReplace != null) {
            eventReplace.setWxCall(str);
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportWxAppSuccess(this.mAdItem);
        }
    }

    private void startVivoDeepLink() {
        String str;
        if (TextUtils.isEmpty(this.deepLink)) {
            startVivoMarkLink();
            return;
        }
        int iStartDeepUrlActivity = BLUtils.startDeepUrlActivity(this.deepLink, this.mContext);
        LxAdLog.d("LxAdBaseView itemClick deepLink type " + iStartDeepUrlActivity);
        if (iStartDeepUrlActivity == 1) {
            lxSdkDeepLingSuccessEvent();
            str = "0";
        } else {
            startVivoMarkLink();
            str = "1";
        }
        LxEventReplace eventReplace = this.mAdItem.getEventReplace();
        if (eventReplace != null) {
            eventReplace.setDpResult(str);
            eventReplace.setDpReason(iStartDeepUrlActivity + "");
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportDeepSuccess(this.mAdItem);
        }
    }

    private void startVivoMarkLink() {
        if (!TextUtils.isEmpty(this.marketLink) && BLUtils.startDeepUrlActivity(this.marketLink, this.mContext) == 1) {
            LxAdLog.d("LxAdBaseView itemClick marketLink success");
        } else {
            if (TextUtils.isEmpty(this.landUrl)) {
                return;
            }
            AdComplianceUtil.startCommonWebView(this.landUrl, "", getContext());
            LxAdLog.d("LxAdBaseView itemClick landUrl success");
        }
    }

    private void startVivoWxApp() {
        String str;
        if (TextUtils.isEmpty(this.wxUserName) || TextUtils.isEmpty(this.wxAppPath) || LxAdManager.getAdManager().getConfig().getWxMiniProgramListener() == null) {
            startVivoDeepLink();
            return;
        }
        boolean zOnLaunchWechatMinProgram = LxAdManager.getAdManager().getConfig().getWxMiniProgramListener().onLaunchWechatMinProgram(this.mAdItem.getWechatAppUsername(), this.mAdItem.getWechatAppPath(), "");
        LxAdLog.d("LxAdBaseView itemClick WxMini result " + zOnLaunchWechatMinProgram);
        if (zOnLaunchWechatMinProgram) {
            lxSdkMiniProgramSuccessEvent();
            str = "1";
        } else {
            startVivoDeepLink();
            str = "0";
        }
        LxEventReplace eventReplace = this.mAdItem.getEventReplace();
        if (eventReplace != null) {
            eventReplace.setWxCall(str);
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportWxAppSuccess(this.mAdItem);
        }
    }

    public void adCloseEvent() {
        LxAdManager.getAdManager().getConfig().getUrlEvent().reportClose(this.mAdItem);
        if (isVideoAd()) {
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportVideoClose(this.mAdItem);
        }
    }

    public void adDestroy() {
        LxAdLog.d("LxAdBaseView adDestroy shakeListener " + this.shakeListener);
        OnShakeListener onShakeListener = this.shakeListener;
        if (onShakeListener != null) {
            LxAdSensorUtil.removeShakeListener(onShakeListener);
        }
        LxAdVideoView lxAdVideoView = this.videoView;
        if (lxAdVideoView != null) {
            lxAdVideoView.onDestroy();
        }
        LxAdDLManager.getInstance(this.mContext).removeDownViewMap(this);
        if (WifiNestAd.INSTANCE.getSwitch77583()) {
            this.mAct = null;
        }
    }

    public void addVideoView(ViewGroup viewGroup) {
        if (viewGroup != null) {
            LxAdVideoView lxAdVideoView = new LxAdVideoView(this.mContext, this.mAdItem, this);
            this.videoView = lxAdVideoView;
            viewGroup.addView(lxAdVideoView, new FrameLayout.LayoutParams(-1, -1));
            this.videoView.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.entity.LxAdBaseView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LxAdBaseView.this.clickEventReplace("0", 4);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clickEventReplace(String str, int i) {
        LxAdLog.d("LxAdBaseViewHonor clickEventReplace isShowAd " + this.isShowAd + " lxEventReplace " + this.lxEventReplace + " clickSld " + str + " clickFrom " + i);
        if (!this.isShowAd) {
            showEventReplace("点击之前判断");
        }
        LxEventReplace lxEventReplace = this.lxEventReplace;
        if (lxEventReplace == null || !this.isShowAd) {
            return;
        }
        lxEventReplace.setDensity(this.mContext.getResources().getDisplayMetrics().density + "");
        this.lxEventReplace.setTS(System.currentTimeMillis() + "");
        this.lxEventReplace.setClickX(this.clickDownX + "");
        this.lxEventReplace.setClickY(this.clickDownY + "");
        this.lxEventReplace.setUpX(this.clickUpX + "");
        this.lxEventReplace.setUpY(this.clickUpY + "");
        this.lxEventReplace.setHwXAcc(this.xAcc + "");
        this.lxEventReplace.setHwYAcc(this.yAcc + "");
        this.lxEventReplace.setHwZAcc(this.zAcc + "");
        this.lxEventReplace.setHwDownTime(this.downTime + "");
        this.lxEventReplace.setHwUpTime(this.upTime + "");
        if (isOppoAd()) {
            if ("0".equals(str)) {
                str = "1";
            } else if ("1".equals(str)) {
                str = "3";
            }
        } else if (isHonorAd()) {
            if (!"0".equals(str)) {
                if (!"1".equals(str)) {
                    str = "2".equals(str) ? "2" : "0";
                }
            }
        }
        LxAdLog.d("LxAdBaseView clickEventReplace sld " + str);
        this.lxEventReplace.setSld(str);
        this.lxEventReplace.setClickAre("");
        if (!isHonorAd()) {
            this.lxEventReplace.setClickAre("2");
        } else if ("1".equals(str)) {
            if (i == 1) {
                this.lxEventReplace.setClickAre("1");
            } else if (i == 4) {
                this.lxEventReplace.setClickAre("4");
            } else if (i == 2) {
                this.lxEventReplace.setClickAre("2");
            }
        }
        LxAdManager.getAdManager().getConfig().getUrlEvent().reportClick(this.mAdItem);
        LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_CLICK, LxAdEventParams.toJson(LxAdEventParams.createEventParams(this.mReqParams, this.mAdItem.getEcpm(), this.mAdItem.getMaterialType(), this.mAdItem.getApiId(), 0, "", this.mAdItem.getApiSlotId(), "")));
        itemClick(i);
        LxBaseShowListener lxBaseShowListener = this.showListener;
        if (lxBaseShowListener != null) {
            lxBaseShowListener.onAdClick(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.clickDownX = (int) motionEvent.getX();
            this.clickDownY = (int) motionEvent.getY();
            this.downTime = System.currentTimeMillis();
            LxAdLog.d("LxAdBaseView ACTION_DOWN dispatchTouchEvent clickDownX " + this.clickDownX + " clickDownY " + this.clickDownY);
        } else if (action == 1) {
            this.clickUpX = (int) motionEvent.getX();
            this.clickUpY = (int) motionEvent.getY();
            this.upTime = System.currentTimeMillis();
            LxAdLog.d("LxAdBaseView ACTION_UP dispatchTouchEvent clickUpX " + this.clickUpX + " clickUpY " + this.clickUpY);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void downStatusChangeUi(final String str) {
        TextView textView = this.adAction;
        if (textView != null) {
            textView.post(new Runnable() { // from class: com.wifi.adsdk.entity.LxAdBaseView.7
                @Override // java.lang.Runnable
                public void run() {
                    LxAdBaseView.this.adAction.setText(str);
                }
            });
        }
    }

    public String getPkgName() {
        return this.curPkgName;
    }

    public View getVideoView() {
        if (!isVideoAd()) {
            return null;
        }
        if (this.contentNativeVideoLayout == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.lxad_native_feed_video_layout, (ViewGroup) null);
            this.contentNativeVideoLayout = viewGroup;
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ad_video);
            if (this.videoView == null) {
                this.videoView = new LxAdVideoView(this.mContext, this.mAdItem, this);
            }
            this.contentNativeVideoLayout.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.entity.LxAdBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LxAdBaseView.this.clickEventReplace("0", 4);
                }
            });
            viewGroup2.addView(this.videoView);
            this.voiceView = (ImageView) this.contentNativeVideoLayout.findViewById(R.id.voice_video);
            this.reStartVideoView = this.contentNativeVideoLayout.findViewById(R.id.video_finish_restart);
            this.videoFinishLayout = this.contentNativeVideoLayout.findViewById(R.id.video_finish_layout);
            this.videoFinishImg = (ImageView) this.contentNativeVideoLayout.findViewById(R.id.video_finish_img);
            initVoiceView();
        }
        return this.contentNativeVideoLayout;
    }

    public void initSensor() {
        if (isYYAd()) {
            if (this.shakeListener == null) {
                this.shakeListener = new OnShakeListener() { // from class: com.wifi.adsdk.entity.LxAdBaseView.6
                    @Override // com.wifi.adsdk.sensor.OnShakeListener
                    public boolean curViewVisible() {
                        return LxAdBaseView.this.isCurVisible();
                    }

                    @Override // com.wifi.adsdk.sensor.OnShakeListener
                    public String getCurAdSrcId() {
                        LxAdBeanData lxAdBeanData = LxAdBaseView.this.mAdItem;
                        return lxAdBeanData != null ? lxAdBeanData.getSlotId() : "";
                    }

                    @Override // com.wifi.adsdk.sensor.OnShakeListener
                    public void onSensorChanged(SensorEvent sensorEvent) {
                        if (sensorEvent != null) {
                            float[] fArr = sensorEvent.values;
                            boolean zIsViewShowIng = false;
                            float f = fArr[0];
                            float f2 = fArr[1];
                            float f3 = fArr[2];
                            LxAdBaseView lxAdBaseView = LxAdBaseView.this;
                            lxAdBaseView.xAcc = (int) (f * 100.0f);
                            lxAdBaseView.yAcc = (int) (f2 * 100.0f);
                            lxAdBaseView.zAcc = (int) (100.0f * f3);
                            float f4 = f / 9.80665f;
                            float f5 = f2 / 9.80665f;
                            float f6 = f3 / 9.80665f;
                            float fSqrt = (float) Math.sqrt((f4 * f4) + (f5 * f5) + (f6 * f6));
                            LxAdBaseView lxAdBaseView2 = LxAdBaseView.this;
                            if (lxAdBaseView2.SHAKE_THRESHOLD_GRAVITY < 0.0f) {
                                float f7 = lxAdBaseView2.mAdItem.getxAccMax();
                                if (f7 == 0.0f) {
                                    f7 = 15.0f;
                                }
                                float f8 = LxAdBaseView.this.mAdItem.getyAccMax();
                                if (f8 == 0.0f) {
                                    f8 = 15.0f;
                                }
                                float f9 = LxAdBaseView.this.mAdItem.getzAccMax();
                                float f10 = f7 / 9.80665f;
                                float f11 = f8 / 9.80665f;
                                float f12 = (f9 != 0.0f ? f9 : 15.0f) / 9.80665f;
                                LxAdBaseView.this.SHAKE_THRESHOLD_GRAVITY = (float) Math.sqrt((f10 * f10) + (f11 * f11) + (f12 * f12));
                                LxAdLog.d("LxAdBaseView onSensorChanged SHAKE_THRESHOLD_GRAVITY " + LxAdBaseView.this.SHAKE_THRESHOLD_GRAVITY);
                            }
                            if (fSqrt > LxAdBaseView.this.SHAKE_THRESHOLD_GRAVITY) {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                LxAdBaseView lxAdBaseView3 = LxAdBaseView.this;
                                if (lxAdBaseView3.mShakeTimestamp + 2000 > jCurrentTimeMillis) {
                                    return;
                                }
                                lxAdBaseView3.mShakeTimestamp = jCurrentTimeMillis;
                                boolean z = lxAdBaseView3.getWindowVisibility() == 0;
                                boolean zIsBackground = LxAdBaseView.this.isBackground();
                                if (!zIsBackground && z && (zIsViewShowIng = LxAdBaseView.this.isViewShowIng())) {
                                    LxAdBaseView.this.sensorClick();
                                }
                                LxAdLog.d("LxAdBaseView onSensorChanged click done isBack " + zIsBackground + " windowVisible " + z + " otherDialogShow " + zIsViewShowIng);
                            }
                        }
                    }
                };
            }
            LxAdSensorUtil.setOnShakeListener(this.shakeListener);
        }
    }

    public void initVoiceView() {
        ImageView imageView = this.voiceView;
        if (imageView != null) {
            imageView.setVisibility(8);
            this.voiceView.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.entity.LxAdBaseView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    LxAdLog.d("initVoiceView click isHasVoice " + LxAdBaseView.this.isHasVoice);
                    LxAdBaseView lxAdBaseView = LxAdBaseView.this;
                    if (lxAdBaseView.videoView != null) {
                        if (lxAdBaseView.isHasVoice) {
                            lxAdBaseView.isHasVoice = false;
                            lxAdBaseView.voiceView.setImageResource(R.drawable.lxad_voice_close);
                            LxAdManager.getAdManager().getConfig().getUrlEvent().reportVideoMute(LxAdBaseView.this.mAdItem);
                        } else {
                            lxAdBaseView.isHasVoice = true;
                            lxAdBaseView.voiceView.setImageResource(R.drawable.lxad_voice_normal);
                        }
                        LxAdBaseView lxAdBaseView2 = LxAdBaseView.this;
                        lxAdBaseView2.videoView.changeVoiceStatus(lxAdBaseView2.isHasVoice);
                    }
                }
            });
        }
    }

    public boolean isDownloadAd() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        if (lxAdBeanData == null || lxAdBeanData.getClickTargetUrl() == null) {
            return false;
        }
        return (TextUtils.isEmpty(this.mAdItem.getClickTargetUrl().getMarketUrl()) && TextUtils.isEmpty(this.mAdItem.getClickTargetUrl().getPackageUrl())) ? false : true;
    }

    public boolean isHonorAd() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        return lxAdBeanData != null && "honor".equals(lxAdBeanData.getApiId());
    }

    public boolean isHuaWeiAd() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        return lxAdBeanData != null && "huawei".equals(lxAdBeanData.getApiId());
    }

    public boolean isOppoAd() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        return lxAdBeanData != null && "oppo".equals(lxAdBeanData.getApiId());
    }

    public boolean isVideoAd() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        return (lxAdBeanData == null || lxAdBeanData.getMaterialType() != 3 || this.mAdItem.getVideo() == null || TextUtils.isEmpty(this.mAdItem.getVideo().getVideoUrl())) ? false : true;
    }

    public boolean isVivoAd() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        return lxAdBeanData != null && "vivo".equals(lxAdBeanData.getApiId());
    }

    public boolean isYYAd() {
        return this.clickType == 1;
    }

    public void itemClick(int i) {
        LxAdDLManager.getInstance(this.mContext).saveViewClickTime(System.currentTimeMillis(), this.onlyId, this.curPkgName);
        LxAdBeanData lxAdBeanData = this.mAdItem;
        if (lxAdBeanData != null) {
            this.wxUserName = lxAdBeanData.getWechatAppUsername();
            this.wxAppPath = this.mAdItem.getWechatAppPath();
            LxAdLog.d("LxAdBaseView itemClick wxUserName " + this.wxUserName + " wxAppPath " + this.wxAppPath + " deepLink " + this.deepLink + " marketLink " + this.marketLink + " landUrl " + this.landUrl + " pkgUrl " + this.pkgUrl);
            if (isVivoAd()) {
                startVivoWxApp();
                return;
            }
            if (isHuaWeiAd()) {
                startHuaweiDeepLink();
            } else if (isHonorAd()) {
                startHonorClick(i);
            } else {
                startDefDeepLink();
            }
        }
    }

    public abstract void readyToShowEvent();

    public abstract void sensorClick();

    public void setAdText(TextView textView) {
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            textView.setText(R.string.lxad_generic_ad_group_personalize);
        } else {
            textView.setText(R.string.lxad_generic_ad_group_normal);
        }
    }

    public void setShowAct(Activity activity) {
        this.mAct = activity;
    }

    public void showEventReplace(String str) {
        if (this.isShowAd) {
            return;
        }
        LxAdLog.d("showEventReplace fromResult " + str);
        LxEventReplace lxEventReplace = this.lxEventReplace;
        if (lxEventReplace != null) {
            this.isShowAd = true;
            lxEventReplace.setShowEvent(true);
            this.lxEventReplace.setTS(System.currentTimeMillis() + "");
            this.lxEventReplace.setWinPrice(this.mAdItem.getEcpm() + "");
            if (this.mAdItem.getVideo() != null && this.mAdItem.getVideo().getVideoDuration() > 0) {
                this.lxEventReplace.setVideoTime(this.mAdItem.getVideo().getVideoDuration() + "");
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.lxEventReplace.setlTX(iArr[0] + "");
            this.lxEventReplace.setlTY(iArr[1] + "");
            LxAdLog.d("viewLoc x " + iArr[0] + " y " + iArr[1]);
            LxEventReplace lxEventReplace2 = this.lxEventReplace;
            StringBuilder sb = new StringBuilder();
            sb.append(this.srcWidth);
            sb.append("");
            lxEventReplace2.setrBX(sb.toString());
            this.lxEventReplace.setrBY(this.srcHeight + "");
            int iNextInt = 5000 - new Random().nextInt(4000);
            this.lxEventReplace.setHwShowTime(iNextInt + "");
            this.lxEventReplace.setHwMaxShowRatio("100");
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportShow(this.mAdItem);
            LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_SHOW, LxAdEventParams.toJson(LxAdEventParams.createEventParams(this.mReqParams, this.mAdItem.getEcpm(), this.mAdItem.getMaterialType(), this.mAdItem.getApiId(), 0, "", this.mAdItem.getApiSlotId(), "")));
            LxBaseShowListener lxBaseShowListener = this.showListener;
            if (lxBaseShowListener != null) {
                lxBaseShowListener.onAdShow();
            }
        }
    }

    public void videoAdFinish() {
        View view = this.videoFinishLayout;
        if (view != null) {
            view.setVisibility(0);
            View view2 = this.reStartVideoView;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.entity.LxAdBaseView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (CheckDoubleClick.isFastDoubleClick()) {
                            return;
                        }
                        LxAdVideoView lxAdVideoView = LxAdBaseView.this.videoView;
                        if (lxAdVideoView != null) {
                            lxAdVideoView.restartVideo();
                            LxAdBaseView.this.videoFinishLayout.setVisibility(8);
                        }
                        LxAdManager.getAdManager().getConfig().getUrlEvent().reportVideoReplay(LxAdBaseView.this.mAdItem);
                    }
                });
            }
            if (this.videoFinishImg != null && this.mAdItem.getVideo() != null && !TextUtils.isEmpty(this.mAdItem.getVideo().getPreImgUrl())) {
                this.videoFinishImg.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(this.mContext).load2(this.mAdItem.getVideo().getPreImgUrl()).into(this.videoFinishImg);
            }
        }
        LxAdVideoView lxAdVideoView = this.videoView;
        if (lxAdVideoView != null) {
            lxAdVideoView.videoAdFinish();
        }
    }

    public void initDownActionUi() {
    }
}

package com.wifi.adsdk;

import android.content.Context;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.entity.LxAdEventParams;
import com.wifi.adsdk.listener.LxAdBaseListener;
import com.wifi.adsdk.listener.LxAdNativeFeedListener;
import com.wifi.adsdk.listener.LxAdPopListener;
import com.wifi.adsdk.listener.LxAdResponseListener;
import com.wifi.adsdk.listener.LxAdSplashListener;
import com.wifi.adsdk.listener.LxAdTempFeedListener;
import com.wifi.adsdk.nativefeed.LxNativeFeedAd;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.pop.LxPopAd;
import com.wifi.adsdk.splash.LxSplashAd;
import com.wifi.adsdk.tempfeed.LxTempFeedAd;
import com.wifi.adsdk.utils.LxAdConst;
import com.wifi.adsdk.utils.LxAdLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdNative implements IAdNative {
    public static final int SLOTTYPE_FEED = 1;
    public static final int SLOTTYPE_TEMP_FEED = -1;
    private final LxAdConfig config;
    private final Context context;
    private final int SLOTTYPE_SPLASH = 4;
    private final int SLOTTYPE_POP = 5;
    private boolean adLoad = false;

    public LxAdNative(Context context, LxAdConfig lxAdConfig) {
        this.context = context;
        this.config = lxAdConfig;
        LxAdManager.getAdManager().getConfig().getRealAppRuntime().getLatitude();
        LxAdManager.getAdManager().getConfig().getRealAppRuntime().getLongitude();
        LxAdLog.d("LxAdNative init");
    }

    private void loadAdData(final LxAdReqParams lxAdReqParams, final LxAdBaseListener lxAdBaseListener, final int i) {
        this.adLoad = false;
        LxAdLog.d("LxAdNative loadAdData start222  ");
        LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_AD_REQ_FROM_NEST, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdReqParams, 0, 0, "", 0, "", "", "")));
        LxAdManager.getAdManager().getConfig().getCachedThreadPool().execute(new Runnable() { // from class: com.wifi.adsdk.LxAdNative.1
            @Override // java.lang.Runnable
            public void run() {
                LxAdNative.this.config.getHttpManager().post(i, lxAdReqParams, LxAdNative.this.context, new LxAdResponseListener(LxAdNative.this.context) { // from class: com.wifi.adsdk.LxAdNative.1.1
                    @Override // com.wifi.adsdk.listener.LxAdResponseListener
                    public void onAdError(int i2, String str) {
                        LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_AD_NORESP, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdReqParams, 0, 0, "", i2, str, "", "")));
                        if (LxAdNative.this.adLoad) {
                            return;
                        }
                        LxAdNative.this.adLoad = true;
                        LxAdBaseListener lxAdBaseListener2 = lxAdBaseListener;
                        if (lxAdBaseListener2 != null) {
                            lxAdBaseListener2.onFailed(i2, str);
                        }
                    }

                    @Override // com.wifi.adsdk.listener.LxAdResponseListener
                    public void onAdGet(String str, List<LxAdBeanData> list, LxAdReqParams lxAdReqParams2) {
                        if (list != null && list.size() > 0) {
                            LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_AD_RESP, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdReqParams2, list.get(0).getEcpm(), list.get(0).getMaterialType(), list.get(0).getApiId(), 0, "", list.get(0).getApiSlotId(), "")));
                            LxAdManager.getAdManager().getConfig().getUrlEvent().reportWinNoticeLink(list.get(0));
                        }
                        if (LxAdNative.this.adLoad) {
                            return;
                        }
                        LxAdNative.this.adLoad = true;
                        int i2 = i;
                        if (i2 == 4) {
                            ArrayList arrayList = new ArrayList();
                            for (LxAdBeanData lxAdBeanData : list) {
                                lxAdBeanData.setReqParams(lxAdReqParams2);
                                LxSplashAd lxSplashAd = new LxSplashAd(LxAdNative.this.context);
                                lxSplashAd.setAdBeanData(lxAdBeanData, lxAdReqParams2);
                                arrayList.add(lxSplashAd);
                            }
                            LxAdBaseListener lxAdBaseListener2 = lxAdBaseListener;
                            if (lxAdBaseListener2 instanceof LxAdSplashListener) {
                                ((LxAdSplashListener) lxAdBaseListener2).onSuccess(arrayList, lxAdReqParams2);
                                return;
                            }
                            return;
                        }
                        if (i2 == 5) {
                            ArrayList arrayList2 = new ArrayList();
                            for (LxAdBeanData lxAdBeanData2 : list) {
                                lxAdBeanData2.setReqParams(lxAdReqParams2);
                                LxPopAd lxPopAd = new LxPopAd(LxAdNative.this.context);
                                lxPopAd.setAdBeanData(lxAdBeanData2, lxAdReqParams2);
                                arrayList2.add(lxPopAd);
                            }
                            LxAdBaseListener lxAdBaseListener3 = lxAdBaseListener;
                            if (lxAdBaseListener3 instanceof LxAdPopListener) {
                                ((LxAdPopListener) lxAdBaseListener3).onSuccess(arrayList2, lxAdReqParams2);
                                return;
                            }
                            return;
                        }
                        if (i2 == -1) {
                            ArrayList arrayList3 = new ArrayList();
                            for (LxAdBeanData lxAdBeanData3 : list) {
                                lxAdBeanData3.setReqParams(lxAdReqParams2);
                                LxTempFeedAd lxTempFeedAd = new LxTempFeedAd(LxAdNative.this.context);
                                lxTempFeedAd.setAdBeanData(lxAdBeanData3, lxAdReqParams2);
                                arrayList3.add(lxTempFeedAd);
                            }
                            LxAdBaseListener lxAdBaseListener4 = lxAdBaseListener;
                            if (lxAdBaseListener4 instanceof LxAdTempFeedListener) {
                                ((LxAdTempFeedListener) lxAdBaseListener4).onSuccess(arrayList3, lxAdReqParams2);
                                return;
                            }
                            return;
                        }
                        if (i2 == 1) {
                            ArrayList arrayList4 = new ArrayList();
                            for (LxAdBeanData lxAdBeanData4 : list) {
                                lxAdBeanData4.setReqParams(lxAdReqParams2);
                                LxNativeFeedAd lxNativeFeedAd = new LxNativeFeedAd(LxAdNative.this.context);
                                lxNativeFeedAd.setAdBeanData(lxAdBeanData4, lxAdReqParams2);
                                arrayList4.add(lxNativeFeedAd);
                            }
                            LxAdBaseListener lxAdBaseListener5 = lxAdBaseListener;
                            if (lxAdBaseListener5 instanceof LxAdNativeFeedListener) {
                                ((LxAdNativeFeedListener) lxAdBaseListener5).onSuccess(arrayList4, lxAdReqParams2);
                            }
                        }
                    }
                });
                new Timer().schedule(new TimerTask() { // from class: com.wifi.adsdk.LxAdNative.1.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        LxAdLog.d("LxAdNative loadAdData TimerTask adLoad " + LxAdNative.this.adLoad);
                        if (LxAdNative.this.adLoad) {
                            return;
                        }
                        LxAdNative.this.adLoad = true;
                        LxAdBaseListener lxAdBaseListener2 = lxAdBaseListener;
                        if (lxAdBaseListener2 != null) {
                            lxAdBaseListener2.onFailed(-1001, "adtime out");
                        }
                        LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_AD_OVERTIME, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdReqParams, 0, 0, "", 0, "", "", "")));
                    }
                }, AdAllInitConfig.adTimeOut);
            }
        });
    }

    @Override // com.wifi.adsdk.IAdNative
    public void loadNativeFeedAd(LxAdReqParams lxAdReqParams, LxAdNativeFeedListener lxAdNativeFeedListener) {
        loadAdData(lxAdReqParams, lxAdNativeFeedListener, 1);
    }

    @Override // com.wifi.adsdk.IAdNative
    public void loadPopAd(LxAdReqParams lxAdReqParams, LxAdPopListener lxAdPopListener) {
        loadAdData(lxAdReqParams, lxAdPopListener, 5);
    }

    @Override // com.wifi.adsdk.IAdNative
    public void loadSplashAd(LxAdReqParams lxAdReqParams, LxAdSplashListener lxAdSplashListener) {
        loadAdData(lxAdReqParams, lxAdSplashListener, 4);
    }

    @Override // com.wifi.adsdk.IAdNative
    public void loadTempFeedAd(LxAdReqParams lxAdReqParams, LxAdTempFeedListener lxAdTempFeedListener) {
        loadAdData(lxAdReqParams, lxAdTempFeedListener, -1);
    }
}

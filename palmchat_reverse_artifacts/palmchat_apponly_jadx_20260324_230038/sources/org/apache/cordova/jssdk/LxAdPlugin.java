package org.apache.cordova.jssdk;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.wifi.ad.core.helper.AdHelperH5Ad;
import com.wifi.ad.core.listener.H5CallListener;
import com.zenmen.openapi.webapp.WebViewFragment;
import com.zenmen.palmchat.R;
import defpackage.a46;
import defpackage.ma3;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxAdPlugin extends LxBaseAdPlugin {
    public static final String PLUGIN_NAME = "LxAd";
    private RelativeLayout mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchEventToJs(String str, String str2, String str3) {
        String str4 = String.format("javascript:LxAdView.fireDomEvent('%s','%s','%s')", this.mCallbacks.get(str), str2, str3);
        ma3.a("dispatchEventToJs: " + str4, new Object[0]);
        this.webView.evaluateJavascript(str4, new ValueCallback<String>() { // from class: org.apache.cordova.jssdk.LxAdPlugin.3
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str5) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View findBannerAdView() {
        return findSpecificViewByType(1);
    }

    private boolean findInnerScreenAdViewAndRemove() {
        RelativeLayout relativeLayout;
        View viewFindSpecificViewByType = findSpecificViewByType(2);
        if (viewFindSpecificViewByType == null || (relativeLayout = this.mRootView) == null) {
            return false;
        }
        relativeLayout.removeView(viewFindSpecificViewByType);
        AdHelperH5Ad.INSTANCE.hideH5Ad((String) viewFindSpecificViewByType.getTag());
        return true;
    }

    private View findSpecificViewByType(int i) {
        RelativeLayout relativeLayout = this.mRootView;
        if (relativeLayout == null) {
            return null;
        }
        int childCount = relativeLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.mRootView.getChildAt(i2);
            Object tag = childAt.getTag(R.id.tag_adtype);
            if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                return childAt;
            }
        }
        return null;
    }

    private void getAdRequestId(CallbackContext callbackContext) {
        String adRequestId = AdHelperH5Ad.INSTANCE.getAdRequestId();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", adRequestId);
        } catch (JSONException e) {
            ma3.c(e);
        }
        callbackContext.success(jSONObject.toString());
    }

    private void getAdSDKVersion(Activity activity, CallbackContext callbackContext) {
        String adSDKVersion = AdHelperH5Ad.INSTANCE.getAdSDKVersion(activity);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adSDKVersion", adSDKVersion);
        } catch (JSONException e) {
            ma3.c(e);
        }
        callbackContext.success(jSONObject);
    }

    private void hideAdView(String str, CallbackContext callbackContext) {
        ma3.a("hideAdView: " + str, new Object[0]);
        try {
            String string = new JSONObject(str).getString("requestId");
            if (!TextUtils.isEmpty(string)) {
                if (this.cordova instanceof WebViewFragment) {
                    removeAdView(string, 0);
                }
                callbackContext.success();
                return;
            }
        } catch (JSONException e) {
            ma3.c(e);
        }
        callbackContext.error("error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAdView(String str, int i) {
        if (this.mRootView == null || TextUtils.isEmpty(str)) {
            return;
        }
        removeAdView(this.mRootView.findViewWithTag(str), i);
    }

    private void showAd(final String str, CallbackContext callbackContext) throws JSONException {
        ma3.f("showAd: " + str);
        Activity ownerActivity2 = this.cordova.getOwnerActivity2();
        if (ownerActivity2 == null) {
            return;
        }
        final JSONObject jSONObject = new JSONObject(str);
        final int iOptInt = jSONObject.optInt("adType", 1);
        final String string = jSONObject.getString("requestId");
        this.mCallbacks.put(string, jSONObject.getString("domId"));
        this.mRequestIds.add(string);
        ma3.f("real start show ad " + str);
        ownerActivity2.runOnUiThread(new Runnable() { // from class: org.apache.cordova.jssdk.LxAdPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                Activity ownerActivity22 = LxAdPlugin.this.cordova.getOwnerActivity2();
                if (ownerActivity22 == null) {
                    return;
                }
                int i = iOptInt;
                if (i == 3) {
                    LxAdPlugin.this.showRewardVideo(ownerActivity22, str);
                } else if (i == 4) {
                    LxAdPlugin.this.showInterstitialAd(ownerActivity22, str);
                } else {
                    LxAdPlugin.this.showNormalAd(ownerActivity22, jSONObject, i, string);
                }
            }
        });
    }

    private void showAdView(Activity activity, final RelativeLayout relativeLayout, final RelativeLayout.LayoutParams layoutParams, final int i) {
        activity.runOnUiThread(new Runnable() { // from class: org.apache.cordova.jssdk.LxAdPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                if (LxAdPlugin.this.mRootView != null) {
                    Object tag = relativeLayout.getTag(R.id.tag_adtype);
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == 2) {
                        TranslateAnimation translateAnimationK = a46.k(i, true);
                        translateAnimationK.setAnimationListener(new Animation.AnimationListener() { // from class: org.apache.cordova.jssdk.LxAdPlugin.4.1
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation) {
                                View viewFindBannerAdView = LxAdPlugin.this.findBannerAdView();
                                if (viewFindBannerAdView != null) {
                                    LxAdPlugin.this.mRootView.removeView(viewFindBannerAdView);
                                    LxAdPlugin.this.mRootView.addView(viewFindBannerAdView);
                                }
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation animation) {
                            }
                        });
                        relativeLayout.startAnimation(translateAnimationK);
                    }
                    LxAdPlugin.this.mRootView.addView(relativeLayout, layoutParams);
                }
            }
        });
    }

    private RelativeLayout showBannerAdView(Activity activity, String str, int i, int i2) {
        RelativeLayout relativeLayout = new RelativeLayout(activity);
        relativeLayout.setTag(str);
        relativeLayout.setTag(R.id.tag_adtype, 1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(12);
        showAdView(activity, relativeLayout, layoutParams, 0);
        return relativeLayout;
    }

    private RelativeLayout showInnerScreenAdView(Activity activity, String str, int i, int i2, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(activity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(6, R.id.openapi_webapp_view);
        relativeLayout.setTag(str);
        relativeLayout.setTag(R.id.tag_adtype, 2);
        showAdView(activity, relativeLayout, layoutParams, i3);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInterstitialAd(Activity activity, String str) {
        if (activity == null) {
            return;
        }
        AdHelperH5Ad.INSTANCE.showH5InterstitialAd(activity, str, new H5CallListener() { // from class: org.apache.cordova.jssdk.LxAdPlugin.7
            @Override // com.wifi.ad.core.listener.H5CallListener
            public void onResult(String str2, String str3, String str4) {
                ma3.a(String.format("showH5InterstitialAd s:%s s1:%s s2:%s", str2, str3, str4), new Object[0]);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("requestId", str2);
                    jSONObject.put("action", str3);
                    try {
                        jSONObject.put("msg", new JSONObject(str4));
                    } catch (Exception e) {
                        ma3.c(e);
                        jSONObject.put("msg", str4);
                    }
                } catch (JSONException e2) {
                    ma3.c(e2);
                }
                LxAdPlugin.this.dispatchEventToJs(str2, "onInteraction", jSONObject.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalAd(Activity activity, JSONObject jSONObject, int i, String str) {
        if (activity == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("adWidth", 0);
        int iOptInt2 = jSONObject.optInt("adHeight", 0);
        int iOptInt3 = jSONObject.optInt("fromSide", 0);
        if (iOptInt == 0 || iOptInt2 == 0) {
            if (i == 1) {
                iOptInt = this.webView.getWidth();
                iOptInt2 = (iOptInt * MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD) / 1000;
            } else if (i == 2) {
                iOptInt = this.webView.getWidth();
                iOptInt2 = this.webView.getHeight();
            }
            try {
                jSONObject.put("adWidth", iOptInt);
                jSONObject.put("adHeight", iOptInt2);
            } catch (JSONException e) {
                ma3.c(e);
            }
        }
        int i2 = iOptInt;
        AdHelperH5Ad.INSTANCE.showH5Ad(activity, i == 1 ? showBannerAdView(activity, str, i2, iOptInt2) : i == 2 ? showInnerScreenAdView(activity, str, i2, iOptInt2, iOptInt3) : null, jSONObject.toString(), new H5CallListener() { // from class: org.apache.cordova.jssdk.LxAdPlugin.2
            @Override // com.wifi.ad.core.listener.H5CallListener
            public void onResult(String str2, String str3, String str4) {
                int iOptInt4 = 0;
                ma3.a(String.format("showH5AdOnResult s:%s s1:%s s2:%s", str2, str3, str4), new Object[0]);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("requestId", str2);
                    jSONObject2.put("action", str3);
                    try {
                        JSONObject jSONObject3 = new JSONObject(str4);
                        iOptInt4 = jSONObject3.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, 0);
                        jSONObject2.put("msg", jSONObject3);
                    } catch (Exception e2) {
                        ma3.c(e2);
                        jSONObject2.put("msg", str4);
                    }
                } catch (JSONException e3) {
                    ma3.c(e3);
                }
                if ("onAdRemove".equals(str3)) {
                    LxAdPlugin lxAdPlugin = LxAdPlugin.this;
                    if (lxAdPlugin.cordova instanceof WebViewFragment) {
                        lxAdPlugin.removeAdView(str2, iOptInt4);
                    }
                }
                LxAdPlugin.this.dispatchEventToJs(str2, "onInteraction", jSONObject2.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRewardVideo(Activity activity, String str) {
        if (activity == null) {
            return;
        }
        AdHelperH5Ad.INSTANCE.showH5RewardVideoAd(activity, str, new H5CallListener() { // from class: org.apache.cordova.jssdk.LxAdPlugin.6
            @Override // com.wifi.ad.core.listener.H5CallListener
            public void onResult(String str2, String str3, String str4) {
                ma3.a(String.format("showH5RewardVideoAdOnResult s:%s s1:%s s2:%s", str2, str3, str4), new Object[0]);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("requestId", str2);
                    jSONObject.put("action", str3);
                    try {
                        jSONObject.put("msg", new JSONObject(str4));
                    } catch (Exception e) {
                        ma3.c(e);
                        jSONObject.put("msg", str4);
                    }
                } catch (JSONException e2) {
                    ma3.c(e2);
                }
                LxAdPlugin.this.dispatchEventToJs(str2, "onInteraction", jSONObject.toString());
            }
        });
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, String str2, CallbackContext callbackContext) throws JSONException {
        Activity ownerActivity2 = this.cordova.getOwnerActivity2();
        if (ownerActivity2 == null) {
            return false;
        }
        CordovaInterface cordovaInterface = this.cordova;
        if ((cordovaInterface instanceof WebViewFragment) && this.mRootView == null) {
            this.mRootView = (RelativeLayout) ((WebViewFragment) cordovaInterface).getView();
        }
        if ("lx_preloadAd".equals(str)) {
            requestH5Banner(str2, callbackContext);
            return true;
        }
        if ("lx_showAd".equals(str)) {
            showAd(str2, callbackContext);
            return true;
        }
        if ("lx_getAdRequestId".equals(str)) {
            getAdRequestId(callbackContext);
            return true;
        }
        if ("lx_getAdSDKVersion".equals(str)) {
            getAdSDKVersion(ownerActivity2, callbackContext);
            return true;
        }
        if (!"lx_hideAdView".equals(str)) {
            return super.execute(str, str2, callbackContext);
        }
        hideAdView(str2, callbackContext);
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public Object onMessage(String str, Object obj) {
        if ("webappbackkeyup".equals(str)) {
            findInnerScreenAdViewAndRemove();
        }
        return super.onMessage(str, obj);
    }

    private void removeAdView(final View view, final int i) {
        Activity ownerActivity2 = this.cordova.getOwnerActivity2();
        if (ownerActivity2 == null) {
            return;
        }
        ownerActivity2.runOnUiThread(new Runnable() { // from class: org.apache.cordova.jssdk.LxAdPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                if (LxAdPlugin.this.mRootView == null || view == null) {
                    return;
                }
                TranslateAnimation translateAnimationK = a46.k(i, false);
                translateAnimationK.setAnimationListener(new Animation.AnimationListener() { // from class: org.apache.cordova.jssdk.LxAdPlugin.5.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        LxAdPlugin.this.mRootView.removeView(view);
                        AdHelperH5Ad.INSTANCE.hideH5Ad((String) view.getTag());
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                view.startAnimation(translateAnimationK);
            }
        });
    }
}

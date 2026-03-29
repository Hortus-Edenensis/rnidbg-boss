package com.wifi.ad.core.interactive;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.opensource.svgaplayer.SVGAImageView;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.utils.UIUtils;
import com.wifi.ad.core.utils.WifiLog;
import defpackage.c15;
import defpackage.m15;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WkInteractiveManager {
    public static final int AD_TYPE_FIND = 1002;
    public static final int AD_TYPE_MINE = 1005;
    public static final int AD_TYPE_POP = 1001;
    public static final int AD_TYPE_PUBLIC = 1004;
    public static final int AD_TYPE_SQUARE = 1003;
    public static final int AD_TYPE_USER = 1006;
    public static final String Sld_NORMAL = "0";
    public static final String Sld_XS = "1";
    public static final int TYPE_CP = 102;
    public static final int TYPE_SH = 101;
    public static final int TYPE_XH = 103;
    public static final int TYPE_YH = 104;
    public static final String TimingTypeAll = "all";
    public static final String TimingTypeFirst = "daily_first_ad";
    public static final String TimingTypeFixEd = "fixed_interval";
    public static final String TimingTypeOff = "off";
    public static final int adWHType169 = 0;
    public static final int adWHType32 = 1;
    public static final int adWHType916 = 2;
    private static final String interactiveSp = "nest_ad_interactive_all_sp";
    private static final String spData = "data";
    private static final String spLastTime = "lastTime";
    private static final String spShowTime = "showAllTime";

    public static boolean addInteractiveView(ViewGroup viewGroup, NestAdData nestAdData, int i, boolean z, int i2) {
        boolean z2 = false;
        if (viewGroup != null && nestAdData != null) {
            Context context = viewGroup.getContext();
            boolean zAllowShow = allowShow(nestAdData, context);
            WifiLog.d("interactive WkInteractiveManager addInteractiveView adWHType " + i + " isDownLoad " + z + " adType " + i2 + " adcode " + nestAdData.getAdCode() + " allowShow " + zAllowShow);
            if (zAllowShow) {
                viewGroup.setVisibility(0);
                int interactiveType = nestAdData.getInteractiveType();
                RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
                if (interactiveType == 102) {
                    relativeLayout.addView(new WkInteractiveCCView(viewGroup.getContext(), nestAdData), new ViewGroup.LayoutParams(-1, -1));
                    View viewCreateSvgaLayout = createSvgaLayout(i, z, interactiveType, context, i2);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(14);
                    layoutParams.topMargin = getSvgaTopMargin(i, i2, interactiveType, context);
                    relativeLayout.addView(viewCreateSvgaLayout, layoutParams);
                    viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    relativeLayout.addView(new WkInteractiveHDView(viewGroup.getContext(), nestAdData, interactiveType, i2), new ViewGroup.LayoutParams(-1, -1));
                    View viewCreateSvgaLayout2 = createSvgaLayout(i, z, interactiveType, context, i2);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.addRule(14);
                    layoutParams2.topMargin = getSvgaTopMargin(i, i2, interactiveType, context);
                    relativeLayout.addView(viewCreateSvgaLayout2, layoutParams2);
                    viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
                }
                z2 = true;
            } else {
                nestAdData.setInteractiveType(0);
            }
            saveShowSceneSp(nestAdData, viewGroup.getContext(), z2);
        }
        return z2;
    }

    private static boolean allowShow(NestAdData nestAdData, Context context) {
        if (nestAdData != null && context != null) {
            String timing = nestAdData.getTiming();
            if (TimingTypeOff.equals(timing) || nestAdData.getInteractiveType() == 0) {
                WifiLog.d("interactive WkInteractiveManager allowShow not allow timing || InteractiveType == 0" + timing);
                return false;
            }
            if ("all".equals(timing)) {
                WifiLog.d("interactive WkInteractiveManager allowShow allow timing " + timing);
                return true;
            }
            int adScene = nestAdData.getAdScene();
            String string = context.getSharedPreferences(interactiveSp, 0).getString(getSceneSp(adScene), "");
            WifiLog.d("interactive WkInteractiveManager allowShow scene " + adScene + " sceneResult " + string);
            if (TextUtils.isEmpty(string)) {
                WifiLog.d("interactive WkInteractiveManager allowShow first  allow timing " + timing);
                return true;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                String strOptString = jSONObject.optString("data");
                String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis()));
                if (TimingTypeFirst.equals(timing)) {
                    if (!str.equals(strOptString)) {
                        WifiLog.d("interactive WkInteractiveManager allowShow allow TimingTypeFirst !curData.equals(dataResult)");
                        return true;
                    }
                } else if (TimingTypeFixEd.equals(timing)) {
                    if (!str.equals(strOptString)) {
                        WifiLog.d("interactive WkInteractiveManager allowShow allow TimingTypeFixEd !curData.equals(dataResult)");
                        return true;
                    }
                    int iOptInt = jSONObject.optInt(spShowTime);
                    int iOptInt2 = jSONObject.optInt(spLastTime);
                    int fixed_interval_extra = nestAdData.getFixed_interval_extra();
                    WifiLog.d("interactive WkInteractiveManager allowShow TimingTypeFixEd showAllTime " + iOptInt + " lastTime " + iOptInt2 + " fixed_interval_extra " + fixed_interval_extra);
                    if (fixed_interval_extra > 0 && iOptInt > 0 && iOptInt2 > 0 && iOptInt - iOptInt2 >= fixed_interval_extra) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        WifiLog.d("interactive WkInteractiveManager allowShow not allow end");
        return false;
    }

    private static View createSvgaLayout(int i, boolean z, int i2, Context context, int i3) {
        int iDip2px;
        int iDip2px2;
        int iDip2px3;
        int iDip2px4;
        int iDip2px5;
        String str;
        String str2;
        WifiLog.d("interactive WkInteractiveManager createSvgaLayout adWHType " + i + " interactiveType " + i2 + " adType " + i3);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        final SVGAImageView sVGAImageView = new SVGAImageView(context);
        if (i != 0 && i != 1) {
            if (i3 == 1002) {
                iDip2px3 = UIUtils.dip2px(context, 115.0f);
                iDip2px4 = UIUtils.dip2px(context, 58.0f);
            } else if (i3 == 1003) {
                iDip2px3 = UIUtils.dip2px(context, 128.0f);
                iDip2px4 = UIUtils.dip2px(context, 100.0f);
            } else if (i3 == 1001) {
                iDip2px = UIUtils.dip2px(context, 161.0f);
                iDip2px2 = UIUtils.dip2px(context, 81.0f);
                iDip2px5 = 0;
                int i4 = iDip2px;
                iDip2px4 = iDip2px2;
                iDip2px3 = i4;
            } else {
                iDip2px3 = UIUtils.dip2px(context, 144.0f);
                iDip2px4 = UIUtils.dip2px(context, 72.0f);
            }
            iDip2px5 = 0;
        } else if (i3 == 1002) {
            iDip2px3 = UIUtils.dip2px(context, 128.0f);
            iDip2px4 = UIUtils.dip2px(context, 64.0f);
            iDip2px5 = 0;
        } else if (i3 == 1003) {
            iDip2px3 = UIUtils.dip2px(context, 112.0f);
            iDip2px4 = UIUtils.dip2px(context, 86.0f);
            iDip2px5 = UIUtils.dip2px(context, -9.0f);
        } else {
            iDip2px = UIUtils.dip2px(context, 161.0f);
            iDip2px2 = UIUtils.dip2px(context, 81.0f);
            iDip2px5 = 0;
            int i42 = iDip2px;
            iDip2px4 = iDip2px2;
            iDip2px3 = i42;
        }
        if (i2 == 102) {
            str = z ? "擦屏幕立即下载" : "擦屏幕查看详情";
            str2 = "svga/ad_interactive_type_cp.svga";
        } else if (i2 == 101) {
            str = z ? "上滑立即下载" : "上滑查看详情";
            str2 = "svga/ad_interactive_type_sh.svga";
        } else if (i2 == 103) {
            str = z ? "上下滑立即下载" : "上下滑查看详情";
            str2 = "svga/ad_interactive_type_xh.svga";
        } else if (i2 == 104) {
            str = z ? "右滑立即下载" : "右滑查看详情";
            str2 = "svga/ad_interactive_type_yh.svga";
        } else {
            str = "";
            str2 = "";
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iDip2px3, iDip2px4);
        layoutParams.gravity = 1;
        if (i3 == 1003 && i == 2) {
            layoutParams.gravity = 17;
        }
        linearLayout.addView(sVGAImageView, layoutParams);
        TextView textView = new TextView(context);
        textView.setTextSize(1, i3 == 1002 ? 10 : 12);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setText(str);
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = iDip2px5;
        linearLayout.addView(textView, layoutParams2);
        try {
            new c15(context).n(str2, new c15.d() { // from class: com.wifi.ad.core.interactive.WkInteractiveManager.1
                @Override // c15.d
                public void onComplete(@NonNull m15 m15Var) {
                    sVGAImageView.setVideoItem(m15Var);
                    sVGAImageView.startAnimation();
                }

                @Override // c15.d
                public void onError() {
                }
            }, new c15.e() { // from class: com.wifi.ad.core.interactive.WkInteractiveManager.2
                @Override // c15.e
                public void onPlay(@NonNull List<? extends File> list) {
                }
            });
            sVGAImageView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.wifi.ad.core.interactive.WkInteractiveManager.3
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (sVGAImageView.getIsAnimating()) {
                        return;
                    }
                    sVGAImageView.startAnimation();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    sVGAImageView.pauseAnimation();
                }
            });
        } catch (Exception unused) {
        }
        return linearLayout;
    }

    private static String getSceneSp(int i) {
        return i + "_interactive";
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int getSvgaTopMargin(int i, int i2, int i3, Context context) {
        int i4 = 20;
        if (i2 == 1001) {
            if (i == 0) {
                i4 = i3 == 101 ? 109 : i3 == 102 ? 103 : i3 == 103 ? 96 : i3 == 104 ? 106 : 10;
            } else if (i3 == 101) {
                i4 = 30;
            } else if (i3 == 102) {
                i4 = 27;
            } else if (i3 != 103) {
                if (i3 == 104) {
                    i4 = 36;
                }
            }
        } else if (i == 2) {
            if (i3 == 101) {
                i4 = 17;
            } else if (i3 == 102) {
                i4 = 16;
            } else if (i3 != 103 && i3 == 104) {
                i4 = 15;
            }
        } else if (i == 0) {
            if (i2 == 1002) {
                if (i3 != 101) {
                    if (i3 != 102) {
                        if (i3 != 103) {
                            if (i3 == 104) {
                                i4 = 7;
                            }
                        }
                        i4 = 8;
                    }
                    i4 = 13;
                }
                i4 = 16;
            } else if (i2 == 1003) {
                i4 = -7;
            } else if (i3 == 101) {
                i4 = 21;
            } else if (i3 != 102) {
                if (i3 == 103) {
                    i4 = 18;
                } else if (i3 != 104) {
                }
            }
        } else {
            if (i2 == 1002) {
                if (i3 != 101) {
                    if (i3 != 102) {
                        if (i3 != 103) {
                            if (i3 == 104) {
                            }
                        }
                        i4 = 8;
                    }
                    i4 = 13;
                }
                i4 = 16;
            } else if (i2 != 1003) {
                if (i3 != 101) {
                    if (i3 != 102) {
                        if (i3 == 103) {
                            i4 = 25;
                        } else if (i3 != 104) {
                        }
                    }
                }
            }
        }
        WifiLog.d("interactive WkInteractiveManager getSvgaTopMargin value " + i4 + " adWHType " + i + " adType " + i2 + " interactiveType " + i3);
        return UIUtils.dip2px(context, i4);
    }

    public static void nestAdClick(NestAdData nestAdData, String str) {
        if (nestAdData != null) {
            try {
                if (SDKAlias.LXAD.getType().equals(nestAdData.getAdType())) {
                    Method declaredMethod = nestAdData.getAdData().getClass().getDeclaredMethod("clickFromOther", String.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(nestAdData.getAdData(), str);
                }
            } catch (Exception e) {
                WifiLog.d("nestAdClick Exception " + e.toString());
            }
        }
    }

    public static void saveShowSceneSp(NestAdData nestAdData, Context context, boolean z) {
        if (nestAdData == null || context == null) {
            return;
        }
        try {
            int adScene = nestAdData.getAdScene();
            SharedPreferences sharedPreferences = context.getSharedPreferences(interactiveSp, 0);
            String string = sharedPreferences.getString(getSceneSp(adScene), "");
            if (TextUtils.isEmpty(string)) {
                String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis()));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", str);
                jSONObject.put(spShowTime, 1);
                jSONObject.put(spLastTime, 1);
                sharedPreferences.edit().putString(getSceneSp(adScene), jSONObject.toString()).apply();
                WifiLog.d("interactive WkInteractiveManager 1saveShowSceneSp resultObj " + jSONObject);
                return;
            }
            String str2 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject2 = new JSONObject(string);
            if (str2.equals(jSONObject2.optString("data"))) {
                int iOptInt = jSONObject2.optInt(spShowTime) + 1;
                jSONObject2.put(spShowTime, iOptInt);
                if (z) {
                    jSONObject2.put(spLastTime, iOptInt);
                }
                sharedPreferences.edit().putString(getSceneSp(adScene), jSONObject2.toString()).apply();
            } else {
                jSONObject2.put("data", str2);
                jSONObject2.put(spShowTime, 1);
                jSONObject2.put(spLastTime, 1);
                sharedPreferences.edit().putString(getSceneSp(adScene), jSONObject2.toString()).apply();
            }
            WifiLog.d("interactive WkInteractiveManager 2saveShowSceneSp resultObj " + jSONObject2);
        } catch (Exception unused) {
        }
    }

    public static void setInteractiveValue(NestAdData nestAdData, String str) {
        if (nestAdData == null || nestAdData.getInteractSettings() == null) {
            return;
        }
        try {
            nestAdData.setTiming(nestAdData.getInteractSettings().optString("timing", ""));
            nestAdData.setFixed_interval_extra(nestAdData.getInteractSettings().optInt("fixed_interval_extra"));
            if (!TextUtils.isEmpty(str)) {
                Iterator<String> itKeys = nestAdData.getInteractSettings().keys();
                while (true) {
                    if (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (str.equals(next)) {
                            JSONObject jSONObjectOptJSONObject = nestAdData.getInteractSettings().optJSONObject(next);
                            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(EventParams.KEY_INTERACTIVETYPE);
                            nestAdData.setWipeScreenExtra(jSONObjectOptJSONObject.optInt("wipe_screen_extra"));
                            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                                if (jSONArrayOptJSONArray.length() == 1) {
                                    nestAdData.setInteractiveType(jSONArrayOptJSONArray.optInt(0));
                                } else {
                                    nestAdData.setInteractiveType(jSONArrayOptJSONArray.optInt(new Random().nextInt(jSONArrayOptJSONArray.length())));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}

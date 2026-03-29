package com.wifi.adsdk.splash;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.opensource.svgaplayer.SVGAImageView;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.wifi.ad.core.utils.UIUtils;
import com.wifi.adsdk.AdAllInitConfig;
import com.wifi.adsdk.entity.LxAdBaseView;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.entity.SingleImage;
import com.wifi.adsdk.listener.LxBaseShowListener;
import com.wifi.adsdk.listener.LxSplashShowListener;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.utils.BLPlatform;
import com.wifi.adsdk.utils.BLUtils;
import com.wifi.adsdk.utils.CheckDoubleClick;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.lxad.ad.R;
import defpackage.c15;
import defpackage.m15;
import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdSplashView extends LxAdBaseView {
    private static final int SPLASH_SKIP = 1;
    private ImageView bigImgView;
    private int curSkipNum;
    private Handler mHandler;
    private int skipAllDelayTime;
    private boolean skipClick;
    private TextView skipView;
    private boolean splashDestroy;
    private int splashShowDelay;
    private boolean timeDone;
    private float touchCurrentY;
    private float touchDuration;
    private float touchStartY;

    public LxAdSplashView(@NonNull Context context, LxAdBeanData lxAdBeanData, LxAdReqParams lxAdReqParams) {
        super(context, lxAdBeanData, lxAdReqParams);
        this.skipView = null;
        this.curSkipNum = 5;
        this.skipClick = false;
        this.timeDone = false;
        this.splashDestroy = false;
        this.bigImgView = null;
        this.mHandler = null;
        this.touchStartY = 0.0f;
        this.touchCurrentY = 0.0f;
        this.touchDuration = -1.0f;
        this.splashShowDelay = -1;
        this.skipAllDelayTime = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.wifi.adsdk.splash.LxAdSplashView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                LxAdSplashView.access$008(LxAdSplashView.this);
                LxAdSplashView.this.startCheckAllowShow();
                if (LxAdSplashView.this.skipView != null) {
                    LxAdSplashView.access$310(LxAdSplashView.this);
                    if (LxAdSplashView.this.curSkipNum <= 0) {
                        LxAdSplashView.this.onTimeDone();
                        return;
                    }
                    LxAdSplashView.this.skipView.setText("跳过 0" + LxAdSplashView.this.curSkipNum);
                    LxAdSplashView.this.startSkip();
                }
            }
        };
        this.curSkipNum = lxAdBeanData.getSplashSkipTime();
        initView();
    }

    public static /* synthetic */ int access$008(LxAdSplashView lxAdSplashView) {
        int i = lxAdSplashView.skipAllDelayTime;
        lxAdSplashView.skipAllDelayTime = i + 1;
        return i;
    }

    public static /* synthetic */ int access$310(LxAdSplashView lxAdSplashView) {
        int i = lxAdSplashView.curSkipNum;
        lxAdSplashView.curSkipNum = i - 1;
        return i;
    }

    private void addGhOneLayout(LinearLayout linearLayout, final String str, final String str2) {
        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = BLUtils.dp2px(this.mContext, 2.0f);
        TextView textView = new TextView(this.mContext);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(1, 9.0f);
        textView.setText(str2);
        textView.setShadowLayer(5.0f, 3.0f, 1.0f, Color.parseColor("#80474749"));
        linearLayout2.addView(textView, new FrameLayout.LayoutParams(-2, -2));
        View view = new View(this.mContext);
        view.setBackgroundColor(Color.parseColor("#CCFFFFFF"));
        linearLayout2.addView(view, new FrameLayout.LayoutParams(-1, BLUtils.dp2px(this.mContext, 1.0f)));
        linearLayout.addView(linearLayout2, layoutParams);
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.splash.LxAdSplashView.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    AdComplianceUtil.startCommonWebView(str, str2, LxAdSplashView.this.getContext());
                } else {
                    BLPlatform.startTextActivity(str, str2, LxAdSplashView.this.getContext());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkTouchClick() {
        if (this.touchDuration < 0.0f) {
            int i = this.mAdItem.getySwipeMax();
            if (i == 0) {
                i = 100;
            }
            this.touchDuration = BLUtils.dp2px(this.mContext, i);
        }
        LxAdLog.d("sxClickSvgaView checkTouchClick touchCurrentY " + this.touchCurrentY + " touchDuration " + this.touchDuration);
        if (this.touchCurrentY <= this.touchDuration) {
            return false;
        }
        splashClick("1", 3);
        return true;
    }

    private int getSplashShowConfig() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        if (lxAdBeanData == null || TextUtils.isEmpty(lxAdBeanData.getApiId())) {
            return 0;
        }
        return AdAllInitConfig.getSplashDelayTime(this.mAdItem.getApiId());
    }

    private void initView() {
        int i;
        int i2;
        String str;
        int i3;
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        this.srcWidth = UIUtils.getScreenAllWidth(this.mContext);
        this.srcHeight = UIUtils.getRealHeight(this.mContext);
        ViewGroup frameLayout2 = new FrameLayout(this.mContext);
        ImageView imageView2 = new ImageView(this.mContext);
        this.bigImgView = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        frameLayout2.addView(this.bigImgView, new FrameLayout.LayoutParams(-1, -1));
        SingleImage singleImage = this.mAdItem.getSingleImage() != null ? this.mAdItem.getSingleImage() : (this.mAdItem.getGroupImage() == null || this.mAdItem.getGroupImage().size() <= 0) ? null : this.mAdItem.getGroupImage().get(0);
        String preImgUrl = "";
        if (singleImage != null) {
            float width = ((singleImage.getWidth() * 1.0f) / singleImage.getHeight()) * 1.0f;
            if (width > 0.56f) {
                i = BLPlatform.getScreenSize(this.mContext).x;
                i2 = (int) (i / width);
            } else {
                i2 = BLPlatform.getScreenSize(this.mContext).y;
                i = (int) (i2 * width);
            }
            LxAdLog.d("LxAdSplashView  srcWidth " + this.srcWidth + " srcHeight " + this.srcHeight + " adWidth " + i + " adHeight " + i2 + " scale " + width);
            if (!TextUtils.isEmpty(singleImage.getUrl())) {
                preImgUrl = singleImage.getUrl();
                if (preImgUrl.endsWith(".gif")) {
                    Glide.with(this.mContext).asGif().load2(singleImage.getUrl()).into(this.bigImgView);
                } else {
                    Glide.with(this.mContext).load2(singleImage.getUrl()).into(this.bigImgView);
                }
            }
        } else {
            i = -1;
            i2 = -1;
        }
        if (TextUtils.isEmpty(preImgUrl) && this.mAdItem.getVideo() != null && !TextUtils.isEmpty(this.mAdItem.getVideo().getPreImgUrl())) {
            preImgUrl = this.mAdItem.getVideo().getPreImgUrl();
        }
        if (!TextUtils.isEmpty(preImgUrl) && !preImgUrl.endsWith(".gif")) {
            try {
                WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
                if (wifiNestAd.getMAdRequestCallBack() != null) {
                    wifiNestAd.getMAdRequestCallBack().showBlurImg(preImgUrl, imageView);
                }
            } catch (Exception unused) {
            }
        }
        if (isVideoAd()) {
            LxAdLog.d("LxAdSplashView splash isVideoAd");
            addVideoView(frameLayout2);
            this.bigImgView.setVisibility(8);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.gravity = 17;
        frameLayout.addView(frameLayout2, layoutParams);
        FrameLayout frameLayout3 = new FrameLayout(this.mContext);
        int iDp2px = BLUtils.dp2px(this.mContext, 70.0f);
        int iDp2px2 = BLUtils.dp2px(this.mContext, 28.0f);
        frameLayout3.setBackgroundResource(R.drawable.splash_skip_bg);
        TextView textView = new TextView(this.mContext);
        this.skipView = textView;
        textView.setTextSize(1, 12.0f);
        this.skipView.setTextColor(Color.parseColor("#FFFFFF"));
        this.skipView.setText("跳过 0" + this.curSkipNum);
        this.skipView.setIncludeFontPadding(false);
        this.skipView.setGravity(17);
        frameLayout3.addView(this.skipView, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iDp2px, iDp2px2);
        layoutParams2.gravity = 5;
        layoutParams2.rightMargin = BLUtils.dp2px(this.mContext, 16.0f);
        layoutParams2.topMargin = BLUtils.dp2px(this.mContext, 40.0f);
        frameLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.splash.LxAdSplashView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                LxAdSplashView.this.skipClick();
            }
        });
        frameLayout.addView(frameLayout3, layoutParams2);
        int i4 = this.clickType;
        if (i4 == 1) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 81;
            layoutParams3.bottomMargin = BLUtils.dp2px(this.mContext, 57.0f);
            frameLayout.addView(linearLayout, layoutParams3);
            LinearLayout linearLayout2 = new LinearLayout(this.mContext);
            linearLayout2.setOrientation(1);
            linearLayout2.setBackgroundResource(R.drawable.splash_yy_svga_bg);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(BLUtils.dp2px(this.mContext, 120.0f), BLUtils.dp2px(this.mContext, 120.0f));
            layoutParams4.gravity = 1;
            linearLayout.addView(linearLayout2, layoutParams4);
            final SVGAImageView sVGAImageView = new SVGAImageView(this.mContext);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(BLUtils.dp2px(this.mContext, 75.0f), BLUtils.dp2px(this.mContext, 70.0f));
            layoutParams5.gravity = 1;
            layoutParams5.topMargin = BLUtils.dp2px(this.mContext, 10.0f);
            linearLayout2.addView(sVGAImageView, layoutParams5);
            TextView textView2 = new TextView(this.mContext);
            textView2.setTextSize(1, 14.0f);
            textView2.setTextColor(Color.parseColor("#FFFFFF"));
            textView2.setText("摇一摇");
            textView2.setIncludeFontPadding(false);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams6.gravity = 1;
            layoutParams6.topMargin = BLUtils.dp2px(this.mContext, 2.0f);
            linearLayout2.addView(textView2, layoutParams6);
            try {
                new c15(this.mContext).n("lxsdk_splash_yy_svga_bg.svga", new c15.d() { // from class: com.wifi.adsdk.splash.LxAdSplashView.3
                    @Override // c15.d
                    public void onComplete(@NonNull m15 m15Var) {
                        sVGAImageView.setVideoItem(m15Var);
                        sVGAImageView.startAnimation();
                    }

                    @Override // c15.d
                    public void onError() {
                    }
                }, new c15.e() { // from class: com.wifi.adsdk.splash.LxAdSplashView.4
                    @Override // c15.e
                    public void onPlay(@NonNull List<? extends File> list) {
                    }
                });
            } catch (Exception unused2) {
            }
            TextView textView3 = new TextView(this.mContext);
            textView3.setTextSize(1, 13.0f);
            textView3.setTextColor(Color.parseColor("#FFFFFF"));
            textView3.setText("摇一摇或点击前往详情页或第三方应用");
            if (isDownloadAd()) {
                textView3.setText("摇一摇或点击开始下载");
            }
            textView3.setShadowLayer(5.0f, 3.0f, 1.0f, Color.parseColor("#80474749"));
            textView3.setIncludeFontPadding(false);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams7.gravity = 1;
            layoutParams7.topMargin = BLUtils.dp2px(this.mContext, 14.0f);
            linearLayout.addView(textView3, layoutParams7);
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.splash.LxAdSplashView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    LxAdSplashView.this.splashClick("0", 2);
                }
            });
        } else if (i4 == 4) {
            View view = new View(this.mContext);
            FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-1, BLUtils.dp2px(this.mContext, 300.0f));
            layoutParams8.gravity = 80;
            view.setBackgroundResource(R.drawable.splash_sx_bg);
            frameLayout.addView(view, layoutParams8);
            LinearLayout linearLayout3 = new LinearLayout(this.mContext);
            linearLayout3.setOnTouchListener(new View.OnTouchListener() { // from class: com.wifi.adsdk.splash.LxAdSplashView.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        LxAdSplashView.this.touchStartY = motionEvent.getY();
                        return false;
                    }
                    if (action != 1) {
                        return false;
                    }
                    LxAdSplashView lxAdSplashView = LxAdSplashView.this;
                    lxAdSplashView.touchCurrentY = lxAdSplashView.touchStartY - motionEvent.getY();
                    return LxAdSplashView.this.checkTouchClick();
                }
            });
            linearLayout3.setOrientation(1);
            FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams9.gravity = 81;
            layoutParams9.bottomMargin = BLUtils.dp2px(this.mContext, 57.0f);
            frameLayout.addView(linearLayout3, layoutParams9);
            FrameLayout frameLayout4 = new FrameLayout(this.mContext);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(BLUtils.dp2px(this.mContext, 180.0f), BLUtils.dp2px(this.mContext, 180.0f));
            layoutParams10.gravity = 1;
            linearLayout3.addView(frameLayout4, layoutParams10);
            final SVGAImageView sVGAImageView2 = new SVGAImageView(this.mContext);
            frameLayout4.addView(sVGAImageView2, new FrameLayout.LayoutParams(-1, -1));
            TextView textView4 = new TextView(this.mContext);
            textView4.setTextSize(1, 19.0f);
            textView4.setTextColor(Color.parseColor("#FFFFFF"));
            textView4.setText("向上滑动");
            textView4.setShadowLayer(5.0f, 3.0f, 1.0f, Color.parseColor("#80474749"));
            textView4.setIncludeFontPadding(false);
            FrameLayout.LayoutParams layoutParams11 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams11.gravity = 81;
            layoutParams11.bottomMargin = BLUtils.dp2px(this.mContext, 6.0f);
            frameLayout4.addView(textView4, layoutParams11);
            try {
                new c15(this.mContext).n("lxsdk_splash_xs_svga_bg.svga", new c15.d() { // from class: com.wifi.adsdk.splash.LxAdSplashView.7
                    @Override // c15.d
                    public void onComplete(@NonNull m15 m15Var) {
                        sVGAImageView2.setVideoItem(m15Var);
                        sVGAImageView2.startAnimation();
                    }

                    @Override // c15.d
                    public void onError() {
                    }
                }, new c15.e() { // from class: com.wifi.adsdk.splash.LxAdSplashView.8
                    @Override // c15.e
                    public void onPlay(@NonNull List<? extends File> list) {
                    }
                });
            } catch (Exception unused3) {
            }
            TextView textView5 = new TextView(this.mContext);
            textView5.setTextSize(1, 13.0f);
            textView5.setTextColor(Color.parseColor("#FFFFFF"));
            textView5.setText("向上滑动或点击前往详情页或第三方应用");
            if (isDownloadAd()) {
                textView5.setText("向上滑动或点击开始下载");
            }
            textView5.setShadowLayer(5.0f, 3.0f, 1.0f, Color.parseColor("#80474749"));
            textView5.setIncludeFontPadding(false);
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams12.gravity = 1;
            linearLayout3.addView(textView5, layoutParams12);
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.splash.LxAdSplashView.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    LxAdLog.d("sxClickSvgaView onClick");
                }
            });
        } else {
            FrameLayout frameLayout5 = new FrameLayout(this.mContext);
            FrameLayout.LayoutParams layoutParams13 = new FrameLayout.LayoutParams(BLUtils.dp2px(this.mContext, 292.0f), BLUtils.dp2px(this.mContext, 100.0f));
            layoutParams13.gravity = 81;
            layoutParams13.bottomMargin = BLUtils.dp2px(this.mContext, 83.0f);
            frameLayout.addView(frameLayout5, layoutParams13);
            frameLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.splash.LxAdSplashView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    LxAdSplashView.this.splashClick("0", 2);
                }
            });
            final SVGAImageView sVGAImageView3 = new SVGAImageView(this.mContext);
            frameLayout5.addView(sVGAImageView3, new FrameLayout.LayoutParams(-1, -1));
            try {
                new c15(this.mContext).n(isDownloadAd() ? "lxsdk_splash_normal_down_svga_bg.svga" : "lxsdk_splash_normal_svga_bg.svga", new c15.d() { // from class: com.wifi.adsdk.splash.LxAdSplashView.11
                    @Override // c15.d
                    public void onComplete(@NonNull m15 m15Var) {
                        sVGAImageView3.setVideoItem(m15Var);
                        sVGAImageView3.startAnimation();
                    }

                    @Override // c15.d
                    public void onError() {
                    }
                }, new c15.e() { // from class: com.wifi.adsdk.splash.LxAdSplashView.12
                    @Override // c15.e
                    public void onPlay(@NonNull List<? extends File> list) {
                    }
                });
            } catch (Exception unused4) {
            }
        }
        FrameLayout frameLayout6 = new FrameLayout(this.mContext);
        frameLayout6.setBackgroundResource(R.drawable.splash_adlogo_bg);
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            i3 = 65;
            str = "个性化广告";
        } else {
            str = "广告";
            i3 = 38;
        }
        FrameLayout.LayoutParams layoutParams14 = new FrameLayout.LayoutParams(BLUtils.dp2px(this.mContext, i3), BLUtils.dp2px(this.mContext, 14.0f));
        layoutParams14.gravity = 85;
        layoutParams14.rightMargin = BLUtils.dp2px(this.mContext, 16.0f);
        layoutParams14.bottomMargin = BLUtils.dp2px(this.mContext, 20.0f);
        frameLayout.addView(frameLayout6, layoutParams14);
        ImageView imageView3 = new ImageView(this.mContext);
        FrameLayout.LayoutParams layoutParams15 = new FrameLayout.LayoutParams(BLUtils.dp2px(this.mContext, 10.0f), BLUtils.dp2px(this.mContext, 10.0f));
        layoutParams15.gravity = 16;
        layoutParams15.leftMargin = BLUtils.dp2px(this.mContext, 4.0f);
        imageView3.setImageResource(R.drawable.icon_lxad_logo);
        frameLayout6.addView(imageView3, layoutParams15);
        TextView textView6 = new TextView(this.mContext);
        FrameLayout.LayoutParams layoutParams16 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams16.gravity = 21;
        layoutParams16.rightMargin = BLUtils.dp2px(this.mContext, 4.0f);
        textView6.setText(str);
        textView6.setTextSize(1, 9.0f);
        textView6.setIncludeFontPadding(false);
        textView6.setTextColor(Color.parseColor("#FFFFFF"));
        frameLayout6.addView(textView6, layoutParams16);
        if (isDownloadAd()) {
            LinearLayout linearLayout4 = new LinearLayout(this.mContext);
            linearLayout4.setOrientation(1);
            FrameLayout.LayoutParams layoutParams17 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams17.gravity = 80;
            layoutParams17.leftMargin = BLUtils.dp2px(this.mContext, 16.0f);
            layoutParams17.bottomMargin = BLUtils.dp2px(this.mContext, 20.0f);
            frameLayout.addView(linearLayout4, layoutParams17);
            TextView textView7 = new TextView(this.mContext);
            textView7.setTextColor(Color.parseColor("#FFFFFF"));
            textView7.setTextSize(1, 9.0f);
            textView7.setMaxWidth(BLUtils.dp2px(this.mContext, 230.0f));
            textView7.setShadowLayer(5.0f, 3.0f, 1.0f, Color.parseColor("#80474749"));
            textView7.setLines(1);
            textView7.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            textView7.setText(this.mAdItem.getAppName() + " " + this.mAdItem.getAdvertiserName());
            linearLayout4.addView(textView7, new LinearLayout.LayoutParams(-2, -2));
            LinearLayout linearLayout5 = new LinearLayout(this.mContext);
            LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams18.topMargin = BLUtils.dp2px(this.mContext, 2.0f);
            linearLayout5.setOrientation(0);
            linearLayout4.addView(linearLayout5, layoutParams18);
            TextView textView8 = new TextView(this.mContext);
            textView8.setTextColor(Color.parseColor("#FFFFFF"));
            textView8.setTextSize(1, 9.0f);
            textView8.setMaxWidth(BLUtils.dp2px(this.mContext, 130.0f));
            textView8.setShadowLayer(5.0f, 3.0f, 1.0f, Color.parseColor("#80474749"));
            textView8.setLines(1);
            textView8.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            textView8.setText("版本号:" + this.mAdItem.getAppVersion());
            linearLayout5.addView(textView8, new LinearLayout.LayoutParams(-2, -2));
            if (!TextUtils.isEmpty(this.mAdItem.getDescriptionUrl())) {
                addGhOneLayout(linearLayout5, this.mAdItem.getDescriptionUrl(), "功能");
            }
            if (!TextUtils.isEmpty(this.mAdItem.getPermissionUrl())) {
                addGhOneLayout(linearLayout5, this.mAdItem.getPermissionUrl(), "权限");
            }
            if (TextUtils.isEmpty(this.mAdItem.getPrivacyPolicyUrl())) {
                return;
            }
            addGhOneLayout(linearLayout5, this.mAdItem.getPrivacyPolicyUrl(), "隐私");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimeDone() {
        this.timeDone = true;
        LxAdLog.d("LxAdSplashView onTimeDone skipClick " + this.skipClick + " timeDone " + this.timeDone);
        LxBaseShowListener lxBaseShowListener = this.showListener;
        if ((lxBaseShowListener instanceof LxSplashShowListener) && !this.skipClick) {
            ((LxSplashShowListener) lxBaseShowListener).onTimeDone();
        }
        adDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void skipClick() {
        this.skipClick = true;
        LxAdLog.d("LxAdSplashView skipClick timeDone " + this.timeDone + " skipClick " + this.skipClick);
        LxBaseShowListener lxBaseShowListener = this.showListener;
        if ((lxBaseShowListener instanceof LxSplashShowListener) && !this.timeDone) {
            ((LxSplashShowListener) lxBaseShowListener).onAdSkip();
        }
        adDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void splashClick(String str, int i) {
        LxAdLog.d("LxAdSplashView start splashClick ");
        this.skipClick = true;
        clickEventReplace(str, i);
        adDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCheckAllowShow() {
        int i = this.splashShowDelay;
        if (i <= 0 || this.skipAllDelayTime * 1000 < i) {
            return;
        }
        showEventReplace("开屏为>0时候展示splashShowDelay:" + this.splashShowDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSkip() {
        if (this.curSkipNum < 0 || this.skipClick) {
            return;
        }
        new Timer().schedule(new TimerTask() { // from class: com.wifi.adsdk.splash.LxAdSplashView.13
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                LxAdSplashView.this.mHandler.sendMessage(messageObtain);
            }
        }, 1000L);
    }

    @Override // com.wifi.adsdk.entity.LxAdBaseView
    public void adDestroy() {
        if (this.splashShowDelay > 0) {
            showEventReplace("开屏>0时候销毁展示splashShowDelay:" + this.splashShowDelay);
        }
        super.adDestroy();
        LxAdLog.d("LxAdSplashView splashDestroy timeDone " + this.timeDone + " skipClick " + this.skipClick + " splashDestroy " + this.splashDestroy + " shakeListener " + this.shakeListener);
        this.splashDestroy = true;
    }

    public void addParentView() {
        startSkip();
        initSensor();
        adShow();
    }

    @Override // com.wifi.adsdk.entity.LxAdBaseView
    public void readyToShowEvent() {
        if (this.splashShowDelay == -1) {
            int splashShowConfig = getSplashShowConfig();
            this.splashShowDelay = splashShowConfig;
            if (splashShowConfig == 0) {
                showEventReplace("开屏splashShowDelay为0正常展示");
            }
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdBaseView
    public void sensorClick() {
        LxAdLog.d("LxAdSensorUtil splashad sensorClick");
        splashClick("2", 3);
    }

    public void setShowListener(LxSplashShowListener lxSplashShowListener) {
        this.showListener = lxSplashShowListener;
    }

    private void adShow() {
    }
}

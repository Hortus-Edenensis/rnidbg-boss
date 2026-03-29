package com.wifi.ad.core.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.wifi.ad.core.R;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdNativeStyleManagerSDK;
import com.wifi.ad.core.custom.flow.GlideImageLoader;
import com.wifi.ad.core.imageloader.DefaultDisplayConfig;
import com.wifi.ad.core.imageloader.GlideCircleTransform;
import com.wifi.ad.core.utils.AdComplianceUtil;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WifiAdMagicView extends RelativeLayout implements View.OnClickListener {
    public static final int AD_SCENE_CLICK_CARD = 2;
    public static final int AD_SCENE_CLICK_COMPLETE_BG = 3;
    public static final int AD_SCENE_CLICK_NONE = 0;
    public static final int AD_SCENE_CLICK_RED_BTN = 5;
    public static final int AD_SCENE_CLICK_TITLE = 1;
    public static final int AD_SCENE_CLICK_TRANS_BTN = 4;
    private static final int TAG_RED = 3179;
    private int CHANGE_COLOR_DEF;
    private int SHOW_BTN_DEF;
    private int SHOW_CARD_DEF;
    private int adSceneClick;
    private OnAdViewListener adViewListener;
    private WifiDownWebButton bgDownload;
    private ImageView bgIcon;
    private TextView bgInfo;
    private LinearLayout bgLayout;
    private TextView bgReply;
    private TextView bgTitle;
    private int changeAdBtnColorTime;
    private TextView completeAdDeveloperInfo;
    private TextView completeAdFunction;
    private View completeAdFunctionLine;
    private LinearLayout completeAdInfoContainer;
    private TextView completeAdPermissionList;
    private LinearLayout completeAdPermissionPrivacyContainer;
    private TextView completeAdPrivacy;
    private TextView completeAdVersion;
    private Config config;
    private TextView firstAdDeveloperName;
    private TextView firstAdFunction;
    private LinearLayout firstAdInfo;
    private ImageView firstAdLogo;
    private TextView firstAdPermissionList;
    private LinearLayout firstAdPermissionPrivacyContainer;
    private TextView firstAdPrivacy;
    private TextView firstAdVersion;
    private WifiDownWebButton firstButton;
    private LinearLayout firstRootLayout;
    private TextView firstUserInfo;
    private TextView firstUserName;
    private TextView firstUserTime;
    private Handler handler;
    private boolean isActive;
    private boolean isCardClosed;
    private boolean isThirdSdk;
    private int likeNum;
    private OnClickViewListener mOnClickViewListener;
    private boolean mTabVideoActiveState;
    private ImageView rightViewAppLogo;
    private TextView rightViewComment;
    private LinearLayout rightViewCommentContainer;
    private LinearLayout rightViewContainer;
    private LinearLayout rightViewLikeContainer;
    private ImageView rightViewLikeImg;
    private TextView rightViewLikeText;
    private ImageView secondAdClose;
    private TextView secondAdDeveloperInfo;
    private TextView secondAdFunction;
    private ImageView secondAdIcon;
    private TextView secondAdPermissionList;
    private TextView secondAdPrivacy;
    private TextView secondAdVersion;
    private RelativeLayout secondAdView;
    private WifiDownWebButton secondButton;
    private TextView secondDesc;
    private TextView secondTitle;
    private int showAdButtonTime;
    private int showAdCardTime;
    private String[] timeArray;

    /* JADX INFO: compiled from: SearchBox */
    public static class Config {
        private String adType;
        private String appName;
        private String appVersion;
        private String authorInfo;
        private String authorName;
        private String bgInfo;
        private String bgName;
        private String button;
        private String cardIcon;
        private String cardInfo;
        private String cardTitle;
        private int changeAdBtnColorTime;
        private String developerName;
        private int downLoadType;
        private String functionUrl;
        private boolean isNewStyleEnable;
        private int logoResId;
        private String permissionsUrl;
        private String privacyUrl;
        private int scene;
        private int showAdBtnTime;
        private int showAdCardTime;

        /* JADX INFO: compiled from: SearchBox */
        public static class Builder {
            private final Config config = new Config();

            public Config build() {
                return this.config;
            }

            public Builder setAdType(String str) {
                this.config.adType = str;
                return this;
            }

            public Builder setAppName(String str) {
                this.config.appName = str;
                return this;
            }

            public Builder setAppVersion(String str) {
                this.config.appVersion = str;
                return this;
            }

            public Builder setAuthorInfo(String str) {
                this.config.authorInfo = str;
                return this;
            }

            public Builder setAuthorName(String str) {
                this.config.authorName = str;
                return this;
            }

            public Builder setBgInfo(String str) {
                this.config.bgInfo = str;
                return this;
            }

            public Builder setBgName(String str) {
                this.config.bgName = str;
                return this;
            }

            public Builder setButton(String str) {
                this.config.button = str;
                return this;
            }

            public Builder setCardIcon(String str) {
                this.config.cardIcon = str;
                return this;
            }

            public Builder setCardInfo(String str) {
                this.config.cardInfo = str;
                return this;
            }

            public Builder setCardTitle(String str) {
                this.config.cardTitle = str;
                return this;
            }

            public Builder setChangeAdBtnColorTime(int i) {
                this.config.changeAdBtnColorTime = i;
                return this;
            }

            public Builder setDeveloperName(String str) {
                this.config.developerName = str;
                return this;
            }

            public Builder setDownLoadType(int i) {
                this.config.downLoadType = i;
                return this;
            }

            public Builder setFunctionUrl(String str) {
                this.config.functionUrl = str;
                return this;
            }

            public Builder setLogoResId(int i) {
                this.config.logoResId = i;
                return this;
            }

            public Builder setNewStyleEnable(boolean z) {
                this.config.isNewStyleEnable = z;
                return this;
            }

            public Builder setPermissionsUrl(String str) {
                this.config.permissionsUrl = str;
                return this;
            }

            public Builder setPrivacyUrl(String str) {
                this.config.privacyUrl = str;
                return this;
            }

            public Builder setScene(int i) {
                this.config.scene = i;
                return this;
            }

            public Builder setShowAdBtnTime(int i) {
                this.config.showAdBtnTime = i;
                return this;
            }

            public Builder setShowAdCardTime(int i) {
                this.config.showAdCardTime = i;
                return this;
            }
        }

        public String getAdType() {
            return this.adType;
        }

        public String getAppName() {
            return this.appName;
        }

        public String getAppVersion() {
            return this.appVersion;
        }

        public String getAuthorInfo() {
            if (TextUtils.isEmpty(this.authorInfo)) {
                this.authorInfo = "点击查看更多精彩内容";
            }
            return this.authorInfo;
        }

        public String getAuthorName() {
            if (TextUtils.isEmpty(this.authorName)) {
                this.authorName = "推荐";
            }
            return this.authorName;
        }

        public String getBgInfo() {
            return this.bgInfo;
        }

        public String getBgName() {
            return this.bgName;
        }

        public String getButton() {
            return this.button;
        }

        public String getCardIcon() {
            return this.cardIcon;
        }

        public String getCardInfo() {
            if (TextUtils.isEmpty(this.cardInfo)) {
                this.cardInfo = "点击查看更多精彩内容";
            }
            return this.cardInfo;
        }

        public String getCardTitle() {
            if (TextUtils.isEmpty(this.cardTitle)) {
                this.cardTitle = "推荐";
            }
            return this.cardTitle;
        }

        public int getChangeAdBtnColorTime() {
            return this.changeAdBtnColorTime;
        }

        public String getDeveloperName() {
            return this.developerName;
        }

        public int getDownLoadType() {
            return this.downLoadType;
        }

        public String getFunctionUrl() {
            return this.functionUrl;
        }

        public int getLogoResId() {
            return this.logoResId;
        }

        public String getPermissionsUrl() {
            return this.permissionsUrl;
        }

        public String getPrivacyUrl() {
            return this.privacyUrl;
        }

        public int getScene() {
            return this.scene;
        }

        public int getShowAdBtnTime() {
            return this.showAdBtnTime;
        }

        public int getShowAdCardTime() {
            return this.showAdCardTime;
        }

        public boolean isNewStyleEnable() {
            return this.isNewStyleEnable;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnAdViewListener {
        void onAdTagClick(View view);

        void onCardCloseClick(View view);

        void onCardShow();

        void onCompleteBgShow();

        void onRedBtnShow();

        void onReplayClick(View view);

        void onTransparentBtnShow();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnClickViewListener {
        void onViewClick(View view);
    }

    public WifiAdMagicView(Context context) {
        super(context);
        this.isActive = false;
        this.isCardClosed = false;
        this.showAdButtonTime = -1;
        this.changeAdBtnColorTime = -1;
        this.showAdCardTime = -1;
        this.adSceneClick = 0;
        this.SHOW_BTN_DEF = 5;
        this.CHANGE_COLOR_DEF = 2;
        this.SHOW_CARD_DEF = 2;
        this.isThirdSdk = true;
        this.timeArray = new String[]{"1分钟前", "5分钟前", "10分钟前"};
        initView(context);
    }

    private void check2ShowSdkProperty(int i, String str, String str2, String str3) {
        String str4;
        if (this.isThirdSdk) {
            if (TextUtils.isEmpty(str) || !SDKAlias.GDT.getType().equals(str)) {
                setAdComplianceVisibility(8);
            } else {
                setAdComplianceVisibility(8);
                if (TextUtils.isEmpty(str2)) {
                    this.firstAdDeveloperName.setVisibility(8);
                    this.secondAdDeveloperInfo.setVisibility(8);
                    this.completeAdDeveloperInfo.setVisibility(8);
                } else {
                    this.firstAdDeveloperName.setText(str2);
                    this.secondAdDeveloperInfo.setText(str2);
                    this.completeAdDeveloperInfo.setText(String.format(getContext().getString(R.string.ad_developer_info), str2));
                }
                if (TextUtils.isEmpty(str3)) {
                    this.firstAdVersion.setVisibility(8);
                    this.secondAdVersion.setVisibility(8);
                    this.completeAdVersion.setVisibility(8);
                } else {
                    TextView textView = this.firstAdVersion;
                    Context context = getContext();
                    int i2 = R.string.ad_version;
                    textView.setText(String.format(context.getString(i2), str3));
                    this.secondAdVersion.setText(String.format(getContext().getString(i2), str3));
                    this.completeAdVersion.setText(String.format(getContext().getString(i2), str3));
                }
                if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str3)) {
                    this.firstAdInfo.setVisibility(8);
                }
            }
            this.secondDesc.setMaxLines(2);
            String authorInfo = this.config.getAuthorInfo();
            if (TextUtils.isEmpty(authorInfo)) {
                str4 = "AB";
            } else {
                str4 = authorInfo + " AB";
            }
            new SpannableStringBuilder(str4);
        }
    }

    private void checkComInfoShow(String str, String str2, String str3, int i, String str4) {
        if (!AdNativeStyleManagerSDK.isShowComplianceInfo(str3, i)) {
            setAdComplianceVisibility(8);
            return;
        }
        setAdComplianceVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.firstAdDeveloperName.setVisibility(8);
            this.secondAdDeveloperInfo.setVisibility(8);
            this.completeAdDeveloperInfo.setVisibility(8);
        } else {
            this.firstAdDeveloperName.setText(str);
            this.secondAdDeveloperInfo.setText(str);
            this.completeAdDeveloperInfo.setText(String.format(getContext().getString(R.string.ad_developer_info), str));
        }
        if (TextUtils.isEmpty(str2)) {
            this.firstAdVersion.setVisibility(8);
            this.secondAdVersion.setVisibility(8);
            this.completeAdVersion.setVisibility(8);
        } else {
            TextView textView = this.firstAdVersion;
            Context context = getContext();
            int i2 = R.string.ad_version;
            textView.setText(String.format(context.getString(i2), str2));
            this.secondAdVersion.setText(String.format(getContext().getString(i2), str2));
            this.completeAdVersion.setText(String.format(getContext().getString(i2), str2));
        }
        if (TextUtils.isEmpty(str4)) {
            this.firstAdFunction.setVisibility(8);
            this.secondAdFunction.setVisibility(8);
            this.completeAdFunction.setVisibility(8);
            this.completeAdFunctionLine.setVisibility(8);
        }
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str2)) {
            this.firstAdInfo.setVisibility(8);
        }
    }

    public static String getContinueText() {
        return "继续下载";
    }

    private Drawable getDefaultLogo() {
        Drawable drawable = getResources().getDrawable(R.drawable.nest_ad_icon);
        drawable.setBounds(0, 0, dp2px(24.0f), dp2px(14.0f));
        return drawable;
    }

    public static String getDownloadingString(String str) {
        return WifiDownWebButton.setProgressStyleString("下载中..." + str + "% ").toString();
    }

    public static String getInstallText() {
        return "点击安装";
    }

    private Drawable getLogo(int i) {
        if (i <= 0) {
            return getDefaultLogo();
        }
        Drawable drawable = getResources().getDrawable(i);
        if (drawable == null) {
            return getDefaultLogo();
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public static String getOpenText() {
        return "立即打开";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideInfoLeftOutAnimation() {
        this.firstRootLayout.clearAnimation();
        this.firstRootLayout.animate().translationX(-dp2px(295.0f)).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.wifi.ad.core.view.WifiAdMagicView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WifiAdMagicView.this.firstRootLayout.setVisibility(8);
                WifiAdMagicView.this.startCardShowAnimation();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                WifiAdMagicView.this.mTabVideoActiveState = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        }).start();
    }

    private void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_wifi_ad_magic, (ViewGroup) this, true);
        this.firstAdLogo = (ImageView) viewInflate.findViewById(R.id.first_ad_logo);
        this.firstUserName = (TextView) viewInflate.findViewById(R.id.first_user_name);
        this.firstUserTime = (TextView) viewInflate.findViewById(R.id.first_user_time);
        this.firstUserInfo = (TextView) viewInflate.findViewById(R.id.first_user_info);
        this.firstRootLayout = (LinearLayout) viewInflate.findViewById(R.id.first_user_root);
        this.firstButton = (WifiDownWebButton) viewInflate.findViewById(R.id.first_ad_button);
        this.firstAdPermissionPrivacyContainer = (LinearLayout) viewInflate.findViewById(R.id.first_ad_permission_privacy_container);
        this.firstAdPermissionList = (TextView) viewInflate.findViewById(R.id.first_ad_permission_list);
        this.firstAdPrivacy = (TextView) viewInflate.findViewById(R.id.first_ad_privacy);
        this.firstAdFunction = (TextView) viewInflate.findViewById(R.id.first_ad_function);
        this.firstAdInfo = (LinearLayout) viewInflate.findViewById(R.id.first_ad_info);
        this.firstAdDeveloperName = (TextView) viewInflate.findViewById(R.id.first_ad_developer_info);
        this.firstAdVersion = (TextView) viewInflate.findViewById(R.id.first_ad_version_info);
        this.secondTitle = (TextView) viewInflate.findViewById(R.id.second_tv_title);
        this.secondDesc = (TextView) viewInflate.findViewById(R.id.second_tv_desc);
        this.secondButton = (WifiDownWebButton) viewInflate.findViewById(R.id.second_button);
        this.secondAdView = (RelativeLayout) viewInflate.findViewById(R.id.second_bottom_ad);
        this.secondAdClose = (ImageView) viewInflate.findViewById(R.id.second_ad_close);
        this.secondAdIcon = (ImageView) viewInflate.findViewById(R.id.second_ad_icon);
        this.secondAdPermissionList = (TextView) viewInflate.findViewById(R.id.second_ad_permission_list);
        this.secondAdPrivacy = (TextView) viewInflate.findViewById(R.id.second_ad_privacy);
        this.secondAdDeveloperInfo = (TextView) viewInflate.findViewById(R.id.second_ad_developer_info);
        this.secondAdVersion = (TextView) viewInflate.findViewById(R.id.second_ad_version);
        this.secondAdFunction = (TextView) viewInflate.findViewById(R.id.second_ad_function);
        this.bgLayout = (LinearLayout) viewInflate.findViewById(R.id.bg_ad);
        this.bgIcon = (ImageView) viewInflate.findViewById(R.id.bg_ad_icon);
        this.bgTitle = (TextView) viewInflate.findViewById(R.id.bg_ad_title);
        this.bgInfo = (TextView) viewInflate.findViewById(R.id.bg_ad_info);
        this.bgDownload = (WifiDownWebButton) viewInflate.findViewById(R.id.bg_ad_download);
        this.bgReply = (TextView) viewInflate.findViewById(R.id.bg_ad_replay);
        this.completeAdInfoContainer = (LinearLayout) viewInflate.findViewById(R.id.complete_ad_info_container);
        this.completeAdVersion = (TextView) viewInflate.findViewById(R.id.complete_ad_version);
        this.completeAdDeveloperInfo = (TextView) viewInflate.findViewById(R.id.complete_ad_developer_info);
        this.completeAdPermissionPrivacyContainer = (LinearLayout) viewInflate.findViewById(R.id.complete_ad_permission_privacy_container);
        this.completeAdPermissionList = (TextView) viewInflate.findViewById(R.id.complete_ad_permission_list);
        this.completeAdPrivacy = (TextView) viewInflate.findViewById(R.id.complete_ad_privacy);
        this.completeAdFunction = (TextView) viewInflate.findViewById(R.id.complete_ad_funtion_list);
        this.completeAdFunctionLine = viewInflate.findViewById(R.id.complete_ad_funtion_line);
        this.rightViewContainer = (LinearLayout) viewInflate.findViewById(R.id.right_view_container);
        this.rightViewAppLogo = (ImageView) viewInflate.findViewById(R.id.right_view_app_logo);
        this.rightViewLikeContainer = (LinearLayout) viewInflate.findViewById(R.id.right_view_like_container);
        this.rightViewLikeImg = (ImageView) viewInflate.findViewById(R.id.right_view_like_img);
        this.rightViewLikeText = (TextView) viewInflate.findViewById(R.id.right_view_like_text);
        this.rightViewCommentContainer = (LinearLayout) viewInflate.findViewById(R.id.right_view_comment_container);
        this.rightViewComment = (TextView) viewInflate.findViewById(R.id.right_view_comment);
        this.firstAdPrivacy.setOnClickListener(this);
        this.firstAdFunction.setOnClickListener(this);
        this.firstAdPermissionList.setOnClickListener(this);
        this.secondAdClose.setOnClickListener(this);
        this.bgReply.setOnClickListener(this);
        this.bgIcon.setOnClickListener(this);
        this.bgLayout.setOnClickListener(this);
        this.secondAdPermissionList.setOnClickListener(this);
        this.secondAdPrivacy.setOnClickListener(this);
        this.secondAdFunction.setOnClickListener(this);
        this.completeAdPermissionList.setOnClickListener(this);
        this.completeAdPrivacy.setOnClickListener(this);
        this.completeAdFunction.setOnClickListener(this);
        this.rightViewLikeContainer.setOnClickListener(this);
        this.rightViewCommentContainer.setOnClickListener(this);
        this.rightViewComment.setOnClickListener(this);
        this.rightViewAppLogo.setOnClickListener(this);
        this.handler = new Handler(context.getMainLooper());
    }

    private void onCompleteDetailClick() {
        this.adSceneClick = 3;
    }

    private void setAdComplianceVisibility(int i) {
        this.firstAdPermissionPrivacyContainer.setVisibility(i);
        this.firstAdInfo.setVisibility(i);
        this.secondAdPermissionList.setVisibility(i);
        this.secondAdPrivacy.setVisibility(i);
        this.secondAdFunction.setVisibility(i);
        this.secondAdDeveloperInfo.setVisibility(i);
        this.secondAdVersion.setVisibility(i);
        this.completeAdPermissionPrivacyContainer.setVisibility(i);
        this.completeAdInfoContainer.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAdBtnAnimation() {
        this.firstRootLayout.clearAnimation();
        this.firstRootLayout.animate().setInterpolator(new DecelerateInterpolator()).setDuration(500L).translationY(-dp2px(34.0f)).start();
        OnAdViewListener onAdViewListener = this.adViewListener;
        if (onAdViewListener != null) {
            onAdViewListener.onTransparentBtnShow();
        }
        this.firstButton.setVisibility(0);
        WifiDownWebButton wifiDownWebButton = this.secondButton;
        int i = R.drawable.video_tab_download_btn_active_background;
        wifiDownWebButton.setBackgroundResource(i);
        this.bgDownload.setBackgroundResource(i);
        this.handler.postDelayed(new Runnable() { // from class: com.wifi.ad.core.view.WifiAdMagicView.2
            @Override // java.lang.Runnable
            public void run() {
                WifiAdMagicView.this.isActive = true;
                WifiAdMagicView.this.firstButton.setTag(Integer.valueOf(WifiAdMagicView.TAG_RED));
                WifiAdMagicView.this.firstButton.setBackgroundResource(R.drawable.video_tab_download_btn_active_background);
                if (WifiAdMagicView.this.adViewListener != null) {
                    WifiAdMagicView.this.adViewListener.onRedBtnShow();
                }
                WifiAdMagicView.this.handler.postDelayed(new Runnable() { // from class: com.wifi.ad.core.view.WifiAdMagicView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WifiAdMagicView.this.secondTitle.setText(WifiAdMagicView.this.config.getCardTitle());
                        WifiAdMagicView.this.secondDesc.setText(WifiAdMagicView.this.config.getCardInfo());
                        if (WifiAdMagicView.this.mTabVideoActiveState) {
                            return;
                        }
                        WifiAdMagicView.this.hideInfoLeftOutAnimation();
                    }
                }, WifiAdMagicView.this.showAdCardTime * 1000);
            }
        }, this.changeAdBtnColorTime * 1000);
    }

    private void showInfoLeftInAnimation() {
        this.firstRootLayout.clearAnimation();
        this.firstRootLayout.setVisibility(0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.firstRootLayout, "translationX", -dp2px(295.0f), 0.0f);
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCardShowAnimation() {
        this.secondAdView.clearAnimation();
        this.secondAdView.setVisibility(0);
        WifiNestAd.INSTANCE.getImageLoader().display(this.secondAdIcon, this.config.cardIcon, new DefaultDisplayConfig.Builder().setErrorImage(R.drawable.small_video_default_app_icon).build());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.secondAdView, "translationX", -dp2px(285.0f), 0.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.start();
        OnAdViewListener onAdViewListener = this.adViewListener;
        if (onAdViewListener != null) {
            onAdViewListener.onCardShow();
        }
    }

    public void configViewData(Config config) {
        this.config = config;
        if (config.isNewStyleEnable()) {
            this.rightViewAppLogo.setVisibility(0);
            this.firstUserName.setVisibility(0);
            this.firstUserTime.setVisibility(0);
            this.firstUserName.setText(config.getAuthorName());
            this.firstUserTime.setText(this.timeArray[new Random().nextInt(2)]);
            new GlideImageLoader().loadImage(getContext(), this.rightViewAppLogo, config.cardIcon, new GlideCircleTransform(getContext()));
        } else {
            this.rightViewAppLogo.setVisibility(8);
            this.firstUserName.setVisibility(8);
            this.firstUserTime.setVisibility(8);
        }
        this.likeNum = new Random().nextInt(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME) + 50;
        this.rightViewLikeText.setText(this.likeNum + "");
        this.firstUserInfo.setText(config.getAuthorInfo());
        this.firstButton.setText(config.getButton());
        this.secondButton.setText(config.getButton());
        this.bgDownload.setText(config.getButton());
        this.bgTitle.setText(config.getBgName());
        this.bgInfo.setText(config.getBgInfo());
        this.showAdButtonTime = config.getShowAdBtnTime() == 0 ? this.SHOW_BTN_DEF : config.getShowAdBtnTime();
        this.changeAdBtnColorTime = config.getChangeAdBtnColorTime() == 0 ? this.CHANGE_COLOR_DEF : config.getChangeAdBtnColorTime();
        this.showAdCardTime = config.getShowAdCardTime() == 0 ? this.SHOW_CARD_DEF : config.getShowAdCardTime();
        int logoResId = config.getLogoResId();
        if (logoResId > 0) {
            this.firstAdLogo.setImageDrawable(getResources().getDrawable(logoResId));
            this.firstAdLogo.setVisibility(0);
        } else {
            this.firstAdLogo.setVisibility(8);
        }
        checkComInfoShow(config.getDeveloperName(), config.getAppVersion(), config.getScene() + "", config.downLoadType, config.getFunctionUrl());
    }

    public int dp2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public WifiDownWebButton getBgDownload() {
        return this.bgDownload;
    }

    public ImageView getBgIcon() {
        return this.bgIcon;
    }

    public TextView getBgInfo() {
        return this.bgInfo;
    }

    public LinearLayout getBgLayout() {
        return this.bgLayout;
    }

    public TextView getBgReply() {
        return this.bgReply;
    }

    public TextView getBgTitle() {
        return this.bgTitle;
    }

    public ArrayList<View> getClickViews() {
        ArrayList<View> arrayList = new ArrayList<>();
        arrayList.add(this.firstButton);
        arrayList.add(this.firstUserName);
        arrayList.add(this.firstUserTime);
        arrayList.add(this.firstUserInfo);
        arrayList.add(this.firstRootLayout);
        arrayList.add(this.firstAdLogo);
        arrayList.add(this.secondAdView);
        arrayList.add(this.secondButton);
        arrayList.add(this.secondTitle);
        arrayList.add(this.secondDesc);
        arrayList.add(this.bgTitle);
        arrayList.add(this.bgDownload);
        arrayList.add(this.bgIcon);
        arrayList.add(this.bgInfo);
        arrayList.add(this.bgLayout);
        arrayList.add(this.firstAdInfo);
        arrayList.add(this.secondAdDeveloperInfo);
        arrayList.add(this.secondAdVersion);
        arrayList.add(this.completeAdPermissionPrivacyContainer);
        arrayList.add(this.completeAdInfoContainer);
        return arrayList;
    }

    public ImageView getFirstAdLogo() {
        return this.firstAdLogo;
    }

    public WifiDownWebButton getFirstButton() {
        return this.firstButton;
    }

    public LinearLayout getFirstRootLayout() {
        return this.firstRootLayout;
    }

    public TextView getFirstUserInfo() {
        return this.firstUserInfo;
    }

    public TextView getFirstUserName() {
        return this.firstUserName;
    }

    public TextView getFirstUserTime() {
        return this.firstUserTime;
    }

    public ImageView getSecondAdClose() {
        return this.secondAdClose;
    }

    public ImageView getSecondAdIcon() {
        return this.secondAdIcon;
    }

    public RelativeLayout getSecondAdView() {
        return this.secondAdView;
    }

    public WifiDownWebButton getSecondButton() {
        return this.secondButton;
    }

    public TextView getSecondDesc() {
        return this.secondDesc;
    }

    public TextView getSecondTitle() {
        return this.secondTitle;
    }

    public void hideFinishBgView() {
        this.bgLayout.setVisibility(8);
        this.secondAdView.setVisibility(8);
        this.firstRootLayout.setTranslationX(0.0f);
        this.firstRootLayout.setVisibility(0);
        this.rightViewContainer.setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.mTabVideoActiveState) {
            this.handler.postDelayed(new Runnable() { // from class: com.wifi.ad.core.view.WifiAdMagicView.1
                @Override // java.lang.Runnable
                public void run() {
                    WifiAdMagicView.this.showAdBtnAnimation();
                }
            }, this.showAdButtonTime * 1000);
            return;
        }
        this.firstRootLayout.setTranslationX(0.0f);
        this.firstRootLayout.setVisibility(0);
        this.rightViewContainer.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Config config;
        Config config2;
        Config config3;
        int id = view.getId();
        System.out.println("onClick " + id);
        if (id == R.id.second_ad_close) {
            this.isCardClosed = true;
            this.firstRootLayout.setVisibility(0);
            this.secondAdView.setVisibility(8);
            this.rightViewContainer.setVisibility(0);
            showInfoLeftInAnimation();
            OnAdViewListener onAdViewListener = this.adViewListener;
            if (onAdViewListener != null) {
                onAdViewListener.onCardCloseClick(view);
                return;
            }
            return;
        }
        if (id == R.id.bg_ad_replay || id == R.id.bg_ad_icon || id == R.id.bg_ad) {
            this.bgLayout.setVisibility(8);
            this.secondAdView.setVisibility(8);
            this.firstRootLayout.setTranslationX(0.0f);
            this.firstRootLayout.setVisibility(0);
            this.rightViewContainer.setVisibility(0);
            OnAdViewListener onAdViewListener2 = this.adViewListener;
            if (onAdViewListener2 != null) {
                onAdViewListener2.onReplayClick(view);
            }
        } else if (id == R.id.first_ad_permission_list || id == R.id.second_ad_permission_list || id == R.id.complete_ad_permission_list) {
            if (getContext() != null && (config = this.config) != null && !TextUtils.isEmpty(config.getPermissionsUrl())) {
                AdComplianceUtil.startCommonWebView(this.config.getPermissionsUrl(), getContext().getString(R.string.ad_permission_list), getContext());
            }
        } else if (id == R.id.first_ad_privacy || id == R.id.second_ad_privacy || id == R.id.complete_ad_privacy) {
            if (getContext() != null && (config2 = this.config) != null && !TextUtils.isEmpty(config2.getPrivacyUrl())) {
                AdComplianceUtil.startCommonWebView(this.config.getPrivacyUrl(), getContext().getString(R.string.ad_privacy), getContext());
            }
        } else if (id == R.id.first_ad_function || id == R.id.second_ad_function || id == R.id.complete_ad_funtion_list) {
            if (getContext() != null && (config3 = this.config) != null && !TextUtils.isEmpty(config3.getFunctionUrl())) {
                AdComplianceUtil.startCommonWebView(this.config.getFunctionUrl(), getContext().getString(R.string.ad_function), getContext());
            }
        } else if (id == R.id.right_view_like_container) {
            this.rightViewLikeImg.clearAnimation();
            this.rightViewLikeImg.startAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.magic_view_click_like_anim));
            if (this.rightViewLikeImg.isSelected()) {
                this.likeNum--;
            } else {
                this.likeNum++;
            }
            this.rightViewLikeText.setText(this.likeNum + "");
            ImageView imageView = this.rightViewLikeImg;
            imageView.setSelected(imageView.isSelected() ^ true);
        } else if (id == R.id.right_view_comment_container || id == R.id.right_view_comment) {
            Toast.makeText(getContext(), R.string.no_comment, 0).show();
        }
        OnClickViewListener onClickViewListener = this.mOnClickViewListener;
        if (onClickViewListener != null) {
            onClickViewListener.onViewClick(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void setOnAdViewListener(OnAdViewListener onAdViewListener) {
        this.adViewListener = onAdViewListener;
    }

    public void setOnClickViewListener(OnClickViewListener onClickViewListener) {
        this.mOnClickViewListener = onClickViewListener;
    }

    public void startShowCompleteBg() {
        this.bgLayout.setVisibility(0);
        this.firstRootLayout.setVisibility(8);
        this.secondAdView.setVisibility(8);
        this.rightViewContainer.setVisibility(8);
        WifiNestAd.INSTANCE.getImageLoader().display(this.bgIcon, this.config.getCardIcon(), new DefaultDisplayConfig.Builder().setErrorImage(R.drawable.small_video_default_app_icon).build());
        OnAdViewListener onAdViewListener = this.adViewListener;
        if (onAdViewListener != null) {
            onAdViewListener.onCompleteBgShow();
        }
    }

    public void updateAdBtnShow(String str) {
        this.firstButton.setText(str);
        this.secondButton.setText(str);
        this.bgDownload.setText(str);
    }

    public static String getDownloadingString(long j, long j2) {
        if (j2 <= 0) {
            return "";
        }
        return WifiDownWebButton.setProgressStyleString("下载中..." + ((int) ((100 * j) / j2)) + "% " + WifiDownWebButton.getDownLoadMemoryProgress(j, j2)).toString();
    }

    public WifiAdMagicView(Context context, boolean z) {
        super(context);
        this.isActive = false;
        this.isCardClosed = false;
        this.showAdButtonTime = -1;
        this.changeAdBtnColorTime = -1;
        this.showAdCardTime = -1;
        this.adSceneClick = 0;
        this.SHOW_BTN_DEF = 5;
        this.CHANGE_COLOR_DEF = 2;
        this.SHOW_CARD_DEF = 2;
        this.timeArray = new String[]{"1分钟前", "5分钟前", "10分钟前"};
        this.isThirdSdk = z;
        initView(context);
    }

    public WifiAdMagicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isActive = false;
        this.isCardClosed = false;
        this.showAdButtonTime = -1;
        this.changeAdBtnColorTime = -1;
        this.showAdCardTime = -1;
        this.adSceneClick = 0;
        this.SHOW_BTN_DEF = 5;
        this.CHANGE_COLOR_DEF = 2;
        this.SHOW_CARD_DEF = 2;
        this.isThirdSdk = true;
        this.timeArray = new String[]{"1分钟前", "5分钟前", "10分钟前"};
        initView(context);
    }

    public WifiAdMagicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isActive = false;
        this.isCardClosed = false;
        this.showAdButtonTime = -1;
        this.changeAdBtnColorTime = -1;
        this.showAdCardTime = -1;
        this.adSceneClick = 0;
        this.SHOW_BTN_DEF = 5;
        this.CHANGE_COLOR_DEF = 2;
        this.SHOW_CARD_DEF = 2;
        this.isThirdSdk = true;
        this.timeArray = new String[]{"1分钟前", "5分钟前", "10分钟前"};
        initView(context);
    }
}

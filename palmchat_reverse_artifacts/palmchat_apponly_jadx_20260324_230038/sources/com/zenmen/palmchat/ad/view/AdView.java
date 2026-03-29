package com.zenmen.palmchat.ad.view;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.ad.model.AdInfoBean;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$string;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a7;
import defpackage.ac1;
import defpackage.cj;
import defpackage.g6;
import defpackage.gr2;
import defpackage.h13;
import defpackage.ir5;
import defpackage.je1;
import defpackage.jo6;
import defpackage.l6;
import defpackage.qd3;
import defpackage.rp2;
import defpackage.s7;
import defpackage.sd3;
import defpackage.t6;
import defpackage.vj6;
import defpackage.zn6;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdView extends RelativeLayout implements View.OnTouchListener {
    public static final int CLICK_TYPE_AVATAR = 5;
    public static final int CLICK_TYPE_BTN = 2;
    public static final int CLICK_TYPE_CLOSE = 3;
    public static final int CLICK_TYPE_DIALOG_CANCEL = 8;
    public static final int CLICK_TYPE_DIALOG_CONFIRM = 9;
    public static final int CLICK_TYPE_NICK = 6;
    public static final int CLICK_TYPE_ROOT = 1;
    public static final int CLICK_TYPE_SHOWMORE = 7;
    public static final int CLICK_TYPE_VIDEO_START = 4;
    public static final String DOUYIN = "com.ss.android.ugc.aweme";
    public static final String DOUYIN_LITE = "com.ss.android.ugc.aweme.lite";
    private static final String TAG = "AdView";
    g6 adDoubleCheckHelper;
    protected AdInfoBean adInfoBean;
    protected TextView adPermission;
    protected TextView adTitle;
    protected ImageView attachArrow;
    protected TextView attatchBtn;
    public TextView attatchDes;
    protected View attatchView;
    protected int[] clickPoint;
    private String defaultBtnText;
    protected View deleteClickArea;
    protected ImageView deleteImg;
    private String downloadSid;
    protected long inviewTime;
    private boolean isAttachFake;
    protected s7 mAdsBean;
    protected t6 mCloseCallBack;
    protected Context mContext;
    protected int mFrom;
    protected ArrayList<String> mPkgName;
    protected String manufacture;
    public ProgressButton progressButton;
    protected View rootView;
    private boolean shouldMineDoubleCheck;
    private boolean shouldPMDoubleCheck;
    protected ImageView tag1;
    protected TextView tag2;
    protected ImageView tag3;
    protected View tagView;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f12451a;

        public a(Intent intent) {
            this.f12451a = intent;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            LogUtil.d(AdView.TAG, "onPositive");
            super.onPositive(materialDialog);
            AdView.this.mContext.startActivity(this.f12451a);
            AdView.this.mAdsBean.H();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {
        public b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            LogUtil.d(AdView.TAG, "onPositive");
            super.onPositive(materialDialog);
            AdView.this.onRedirectClick();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            LogUtil.d(AdView.TAG, "onPositive");
            super.onPositive(materialDialog);
            AdView.this.onDeepClick();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.zenmen.palmchat.c.g()) {
                AdView.this.mAdsBean.O();
            } else {
                AdView.this.mAdsBean.M();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f12455a;
        public final /* synthetic */ boolean b;

        public e(Intent intent, boolean z) {
            this.f12455a = intent;
            this.b = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            LogUtil.d(AdView.TAG, "onPositive");
            super.onPositive(materialDialog);
            AdView.this.mContext.startActivity(this.f12455a);
            l6.d().g(AdView.this.mAdsBean, this.b);
            AdView.this.reportJumpMarket();
            if (this.b) {
                AdView.this.mAdsBean.J();
            } else {
                AdView.this.mAdsBean.P();
            }
        }
    }

    public AdView(Context context) {
        super(context);
        this.isAttachFake = false;
        this.defaultBtnText = null;
        this.shouldPMDoubleCheck = false;
        this.shouldMineDoubleCheck = false;
        this.clickPoint = new int[]{SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT};
        this.mPkgName = new ArrayList<>();
        this.mContext = context;
    }

    private boolean canExtJumpMarket() {
        s7 s7Var = this.mAdsBean;
        if (s7Var != null && s7Var.k() != null && this.mAdsBean.k().b() != null) {
            LogUtil.d(TAG, "canExtJumpMarket jumpMarket = " + this.mAdsBean.k().b());
            try {
                Intent handleIntent = getHandleIntent(this.mAdsBean.k().b);
                if (handleIntent == null) {
                    LogUtil.d(TAG, "canExtJumpMarket intent is null");
                    return false;
                }
                if (this.shouldMineDoubleCheck) {
                    new sd3(this.mContext).T(R$string.ad_download_dialog_title).j(R$string.ad_jump_market_dialog_content).O(R$string.alert_dialog_ok).K(R$string.alert_dialog_cancel).f(new a(handleIntent)).e().show();
                    return true;
                }
                this.mContext.startActivity(handleIntent);
                this.mAdsBean.H();
                return true;
            } catch (ActivityNotFoundException e2) {
                LogUtil.d(TAG, "canExtJumpMarket e = " + e2.toString());
                e2.printStackTrace();
            }
        }
        return false;
    }

    private boolean canJumpMarket(boolean z, boolean z2) {
        ArrayList<String> arrayList;
        s7 s7Var = this.mAdsBean;
        if (s7Var != null && s7Var.o() != null && !this.mAdsBean.A()) {
            LogUtil.d(TAG, "canJumpMarket pkgName = " + this.mAdsBean.o() + ", manufacture = " + ac1.f1194a);
            if (!TextUtils.isEmpty(this.manufacture) && this.manufacture.equalsIgnoreCase(ac1.f1194a) && (arrayList = this.mPkgName) != null && arrayList.size() > 0) {
                for (String str : this.mPkgName) {
                    if (str != null && str.equals(this.mAdsBean.o())) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + this.mAdsBean.o()));
                        if (!z) {
                            return true;
                        }
                        try {
                            LogUtil.d(TAG, "canJumpMarket isLX15877Open = " + jo6.m());
                            if (!jo6.m()) {
                                return false;
                            }
                            if (this.shouldMineDoubleCheck) {
                                new sd3(this.mContext).T(R$string.ad_download_dialog_title).j(R$string.ad_jump_market_dialog_content).O(R$string.alert_dialog_ok).K(R$string.alert_dialog_cancel).f(new e(intent, z2)).e().show();
                            } else {
                                this.mContext.startActivity(intent);
                                l6.d().g(this.mAdsBean, z2);
                                reportJumpMarket();
                                if (z2) {
                                    this.mAdsBean.J();
                                } else {
                                    this.mAdsBean.P();
                                }
                            }
                            return true;
                        } catch (ActivityNotFoundException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    private int getAdType() {
        s7 s7Var = this.mAdsBean;
        if (s7Var == null) {
            return 0;
        }
        boolean z = (s7Var.i() == null || this.mAdsBean.i().c() == 0) ? false : true;
        if (this.mAdsBean.r() == 103) {
            return z ? 11 : 1;
        }
        if (this.mAdsBean.r() == 122) {
            return z ? 21 : 2;
        }
        if (this.mAdsBean.r() == 101) {
            return z ? 31 : 3;
        }
        if (this.mAdsBean.r() == 102) {
            return z ? 41 : 4;
        }
        return 0;
    }

    public static je1 getDisplayImageOptions() {
        return new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
    }

    private static Intent getHandleIntent(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Intent uri = Intent.parseUri(str, 1);
            if (!isHasAppByIntent(uri)) {
                return null;
            }
            uri.addCategory("android.intent.category.BROWSABLE");
            uri.addFlags(268435456);
            uri.setComponent(null);
            uri.setSelector(null);
            return uri;
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    private boolean isDeepLink() {
        s7 s7Var = this.mAdsBean;
        if (s7Var == null || s7Var.n() == null || TextUtils.isEmpty(this.mAdsBean.n().c())) {
            return false;
        }
        LogUtil.d(TAG, "isDeepLink deeplink url = " + this.mAdsBean.n().c());
        if (getHandleIntent(this.mAdsBean.n().c()) == null) {
            return false;
        }
        this.mAdsBean.N();
        return true;
    }

    private static synchronized boolean isHasAppByIntent(Intent intent) {
        if (intent == null) {
            return false;
        }
        return com.zenmen.palmchat.c.b().getPackageManager().resolveActivity(intent, 0) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeepClick() {
        this.mAdsBean.K();
        LogUtil.d(TAG, "AdManager onClick deeplink");
        try {
            this.mContext.startActivity(getHandleIntent(this.mAdsBean.n().c()));
            new Handler().postDelayed(new d(), 5000L);
            this.mAdsBean.L();
        } catch (ActivityNotFoundException e2) {
            LogUtil.d(TAG, "activity not found for " + this.mAdsBean.n().c(), e2);
            this.mAdsBean.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRedirectClick() {
        this.mAdsBean.K();
        LogUtil.d(TAG, "onClick direct, url = " + this.mAdsBean.n().g());
        Context context = this.mContext;
        if (context instanceof Activity) {
            this.mAdsBean.c((Activity) context);
        }
    }

    private void reportInview() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adType", getAdType());
            int i = 0;
            if (!canJumpMarket(false, false)) {
                i = 1;
            }
            jSONObject.put("jumpcfg", i);
            jSONObject.put(EventParams.KEY_PARAM_PVID, this.mAdsBean.p());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        int i2 = this.mFrom;
        if (i2 == 1) {
            LogUtil.uploadInfoImmediate("mad1", null, null, jSONObject.toString());
        } else if (i2 == 2) {
            LogUtil.uploadInfoImmediate("qad1", null, null, jSONObject.toString());
        }
    }

    private void showDialogAndDeepLink() {
        LogUtil.d(TAG, "showDialogAndDeepLink");
        new sd3(this.mContext).T(R$string.ad_download_dialog_title).j(R$string.ad_deeplink_dialog_content).O(R$string.alert_dialog_ok).K(R$string.alert_dialog_cancel).f(new c()).e().show();
    }

    private void showDialogAndRedirectLink() {
        LogUtil.d(TAG, "showDialogAndRedirectLink");
        new sd3(this.mContext).T(R$string.ad_download_dialog_title).j(R$string.ad_redirect_dialog_content).O(R$string.alert_dialog_ok).K(R$string.alert_dialog_cancel).f(new b()).e().show();
    }

    public s7 getmAdsBean() {
        return this.mAdsBean;
    }

    public void initView() {
        LogUtil.d(TAG, "initView");
        this.adTitle = (TextView) this.rootView.findViewById(R$id.ad_title);
        this.adPermission = (TextView) this.rootView.findViewById(R$id.ad_permission);
        this.tagView = this.rootView.findViewById(R$id.ad_tag_banner);
        this.tag1 = (ImageView) this.rootView.findViewById(R$id.ad_tag1);
        this.tag2 = (TextView) this.rootView.findViewById(R$id.ad_tag2);
        this.tag3 = (ImageView) this.rootView.findViewById(R$id.ad_tag3);
        this.deleteImg = (ImageView) this.rootView.findViewById(R$id.ad_delete);
        this.deleteClickArea = this.rootView.findViewById(R$id.ad_delete_click);
        this.attatchView = this.rootView.findViewById(R$id.ad_attatch_banner);
        this.attatchDes = (TextView) this.rootView.findViewById(R$id.ad_attatch_des);
        this.attatchBtn = (TextView) this.rootView.findViewById(R$id.ad_attatch_btn);
        this.attachArrow = (ImageView) this.rootView.findViewById(R$id.ad_attach_arrow);
        this.progressButton = (ProgressButton) this.rootView.findViewById(R$id.ad_attatch_progress_btn);
        this.rootView.setOnTouchListener(this);
        this.attatchBtn.setOnTouchListener(this);
        this.deleteClickArea.setOnTouchListener(this);
        this.progressButton.setOnTouchListener(this);
        this.adPermission.setOnTouchListener(this);
    }

    public void onAttachBtnClick() {
        s7 s7Var = this.mAdsBean;
        if (s7Var == null || s7Var.i() == null) {
            return;
        }
        this.mAdsBean.I();
        if (this.mAdsBean.y()) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                this.mAdsBean.b((Activity) context);
                return;
            }
            return;
        }
        if (!this.mAdsBean.x() || canExtJumpMarket() || canJumpMarket(true, true)) {
            return;
        }
        onDownloadClick(true);
    }

    public void onMomentsExtraClick(int i) {
        s7 s7Var = this.mAdsBean;
        if (s7Var == null || !s7Var.C()) {
            return;
        }
        this.mAdsBean.K();
        reportClick(i);
        reportMDAClick();
        LogUtil.d(TAG, "onClick direct, url = " + this.mAdsBean.n().g());
        Context context = this.mContext;
        if (context instanceof Activity) {
            this.mAdsBean.c((Activity) context);
        }
    }

    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        LogUtil.i(TAG, "onPermissionGrant downloadsid = " + this.downloadSid);
    }

    public void onResume() {
        updateProgressBtn(null);
    }

    public void onRootViewClick() {
        if (this.mAdsBean != null) {
            reportMDAClick();
            if (isDeepLink()) {
                if (this.shouldMineDoubleCheck) {
                    showDialogAndDeepLink();
                    return;
                } else {
                    onDeepClick();
                    return;
                }
            }
            if (this.mAdsBean.C()) {
                if (this.shouldMineDoubleCheck) {
                    showDialogAndRedirectLink();
                    return;
                } else {
                    onRedirectClick();
                    return;
                }
            }
            if (this.mAdsBean.z()) {
                if (canJumpMarket(true, false) || canExtJumpMarket()) {
                    this.mAdsBean.K();
                } else {
                    onDownloadClick(false);
                }
            }
        }
    }

    public void onTagClick() {
        if (this.mAdsBean.w()) {
            String strA = this.mAdsBean.k().a().a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            rp2.a aVar = new rp2.a();
            aVar.l(strA);
            aVar.g(-1);
            aVar.k(false);
            aVar.i(h13.p);
            this.mContext.startActivity(vj6.a(this.mContext, aVar));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.clickPoint[0] = (int) motionEvent.getX();
            this.clickPoint[1] = (int) motionEvent.getY();
        } else if (action == 1) {
            this.clickPoint[2] = (int) motionEvent.getX();
            this.clickPoint[3] = (int) motionEvent.getY();
            setAdInfoBean();
            LogUtil.d(TAG, "onTouch  adInfoBean = " + this.adInfoBean.toString());
            View view2 = this.rootView;
            if (view == view2) {
                if (this.mFrom == 1) {
                    if (this.adDoubleCheckHelper == null) {
                        this.adDoubleCheckHelper = new g6(this.mAdsBean, view.getWidth(), view.getHeight(), this.inviewTime);
                    }
                    g6 g6Var = this.adDoubleCheckHelper;
                    int[] iArr = this.clickPoint;
                    g6Var.c(iArr[0], iArr[1]);
                    if (this.adDoubleCheckHelper.d()) {
                        this.shouldMineDoubleCheck = this.adDoubleCheckHelper.e();
                        LogUtil.d(TAG, "shouldMineDoubleCheck = " + this.shouldMineDoubleCheck);
                        onRootViewClick();
                        reportClick(1);
                    }
                } else {
                    onRootViewClick();
                    reportClick(1);
                }
            } else if (view == this.attatchBtn || view == this.progressButton) {
                onAttachBtnClick();
                reportClick(2);
            } else if (view == this.deleteClickArea) {
                view2.setVisibility(8);
                if (this.rootView.getParent() != null) {
                    ((ViewGroup) this.rootView.getParent()).setVisibility(8);
                }
                reportClick(3);
                if (a7.e()) {
                    a7.g();
                }
            } else if (view == this.tagView) {
                if (this.mAdsBean.w()) {
                    onTagClick();
                }
            } else if (view == this.adPermission) {
                onAdPermissionClick();
            }
        }
        return true;
    }

    public void reportClick(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adType", getAdType());
            jSONObject.put("clickType", i);
            int i2 = 0;
            if (!canJumpMarket(false, false)) {
                i2 = 1;
            }
            jSONObject.put("jumpcfg", i2);
            jSONObject.put(EventParams.KEY_PARAM_PVID, this.mAdsBean.p());
            jSONObject.put("pkgname", this.mAdsBean.o());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        int i3 = this.mFrom;
        if (i3 == 1) {
            LogUtil.uploadInfoImmediate("mad2", null, null, jSONObject.toString());
        } else if (i3 == 2) {
            LogUtil.uploadInfoImmediate("qad2", null, null, jSONObject.toString());
        }
    }

    public void reportJumpMarket() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pkgname", this.mAdsBean.o());
            jSONObject.put(EventParams.KEY_PARAM_PVID, this.mAdsBean.p());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("ad43", null, null, jSONObject.toString());
    }

    public void reportMDAClick() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i = this.mFrom;
            if (i == 1) {
                jSONObject.put("di", MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE);
            } else if (i == 2) {
                jSONObject.put("di", MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS);
            } else if (i == 3) {
                jSONObject.put("di", 308);
            }
            jSONObject.put("type", a7.a(this.mAdsBean));
            jSONObject.put(EventParams.KEY_PARAM_PVID, this.mAdsBean.p());
            jSONObject.put("sid", this.mAdsBean.h());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("lx_client_ad_31", null, jSONObject.toString());
    }

    public void reportMDAInView() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", a7.a(this.mAdsBean));
            jSONObject.put(EventParams.KEY_PARAM_PVID, this.mAdsBean.p());
            jSONObject.put("sid", this.mAdsBean.h());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("lx_client_ad_21", null, jSONObject.toString());
    }

    public void reportMomentsAdTagClick() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adType", getAdType());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("qad3", null, null, jSONObject.toString());
    }

    public void reportMomentsNotIntrestedClick() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adType", getAdType());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("qad4", null, null, jSONObject.toString());
    }

    public void setAdInfoBean() {
        s7 s7Var = this.mAdsBean;
        if (s7Var == null || s7Var.e() == null) {
            this.adInfoBean = new AdInfoBean(this.rootView.getLeft(), this.rootView.getTop(), this.rootView.getRight(), this.rootView.getBottom());
        } else {
            this.adInfoBean = this.mAdsBean.e();
        }
        this.adInfoBean.setClickX(this.clickPoint[0]);
        this.adInfoBean.setClickY(this.clickPoint[1]);
        this.adInfoBean.setClickUpX(this.clickPoint[2]);
        this.adInfoBean.setClickUpY(this.clickPoint[3]);
        s7 s7Var2 = this.mAdsBean;
        if (s7Var2 != null) {
            s7Var2.u(this.adInfoBean);
        }
        LogUtil.d(TAG, "setAdInfoBean = " + this.adInfoBean.toString());
    }

    public void setData(s7 s7Var) {
        LogUtil.d(TAG, "setData");
        if (s7Var != null) {
            this.mAdsBean = s7Var;
            qd3 qd3VarN = s7Var.n();
            if (qd3VarN != null) {
                this.adTitle.setText(qd3VarN.i());
            }
            if (this.mAdsBean.w()) {
                je1.a aVarQ = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565);
                int i = R$drawable.ad_tag;
                gr2.j().h(this.mAdsBean.k().a().b(), this.tag1, aVarQ.B(i).A(i).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(i).r());
                this.tag2.setVisibility(8);
                this.tag3.setVisibility(0);
                String strC = this.mAdsBean.k().a().c();
                if (!TextUtils.isEmpty(strC)) {
                    gr2.j().h(strC, this.tag3, getDisplayImageOptions());
                }
                this.tagView.setOnTouchListener(this);
            } else {
                this.tag1.setImageDrawable(com.zenmen.palmchat.c.b().getResources().getDrawable(R$drawable.ad_tag));
                this.tag2.setVisibility(0);
                this.tag2.setText(this.mAdsBean.q());
                this.tag3.setVisibility(8);
            }
            cj cjVarI = s7Var.i();
            if (cjVarI == null && this.mFrom == 2 && s7Var.z() && jo6.o()) {
                cjVarI = new cj();
                cjVarI.l("下载领福利!");
                cjVarI.j(2);
                this.isAttachFake = true;
                s7Var.c0(cjVarI);
            }
            if (cjVarI == null || cjVarI.c() == 0) {
                this.attatchView.setVisibility(8);
            } else {
                LogUtil.d(TAG, "setData attachDetailBean  " + cjVarI.e() + "buttonText =" + cjVarI.b());
                this.attatchView.setVisibility(0);
                this.attatchDes.setText(cjVarI.e());
                if (s7Var.r() == 101 || s7Var.r() == 102) {
                    this.attatchBtn.setVisibility(0);
                    this.attachArrow.setVisibility(0);
                    this.progressButton.setVisibility(8);
                } else if (s7Var.r() == 103 || s7Var.r() == 122) {
                    this.progressButton.setVisibility(0);
                    this.attatchBtn.setVisibility(8);
                    this.attachArrow.setVisibility(8);
                }
                if (s7Var.x()) {
                    updateProgressBtn(null);
                } else {
                    this.attatchBtn.setText(cjVarI.b());
                    this.progressButton.setText(cjVarI.b());
                }
            }
            if (this.mAdsBean.E()) {
                this.adPermission.setVisibility(0);
            } else {
                this.adPermission.setVisibility(8);
            }
            if (!this.mAdsBean.B() || this.mFrom == 1) {
                this.mAdsBean.Q();
                this.inviewTime = ir5.b();
            }
            reportInview();
            reportMDAInView();
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setManufacture(String str) {
        LogUtil.d(TAG, "setManufacture = " + str);
        this.manufacture = str;
    }

    public void setPkgName(ArrayList<String> arrayList) {
        if (arrayList != null) {
            for (String str : arrayList) {
                LogUtil.d(TAG, "pkgName = " + str);
                this.mPkgName.add(str);
            }
        }
    }

    public void setShouldDoubleCheck(boolean z) {
        this.shouldPMDoubleCheck = z;
    }

    public void setmAdsBean(s7 s7Var) {
        this.mAdsBean = s7Var;
    }

    public void switchBtnText() {
        String string = this.progressButton.getText().toString();
        Resources resources = com.zenmen.palmchat.c.b().getResources();
        int i = R$string.ad_download_resume;
        if (string.equals(resources.getString(i)) || string.equals(com.zenmen.palmchat.c.b().getResources().getString(R$string.ad_download_start))) {
            string = com.zenmen.palmchat.c.b().getResources().getString(R$string.ad_download_pause);
        } else if (string.equals(com.zenmen.palmchat.c.b().getResources().getString(R$string.ad_download_pause)) || string.equals(com.zenmen.palmchat.c.b().getResources().getString(R$string.ad_download_downloading))) {
            string = com.zenmen.palmchat.c.b().getResources().getString(i);
        }
        if (string != null) {
            this.progressButton.setText(string);
            TextView textView = this.attatchBtn;
            if (textView != null) {
                textView.setText(string);
            }
        }
    }

    public AdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isAttachFake = false;
        this.defaultBtnText = null;
        this.shouldPMDoubleCheck = false;
        this.shouldMineDoubleCheck = false;
        this.clickPoint = new int[]{SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT};
        this.mPkgName = new ArrayList<>();
        this.mContext = context;
    }

    public AdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isAttachFake = false;
        this.defaultBtnText = null;
        this.shouldPMDoubleCheck = false;
        this.shouldMineDoubleCheck = false;
        this.clickPoint = new int[]{SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT};
        this.mPkgName = new ArrayList<>();
        this.mContext = context;
    }

    private void onDownloadClick(boolean z) {
    }

    public void setAdCloseCallBack(t6 t6Var) {
    }

    public void updateProgressBtn(String str) {
    }

    public void onAdPermissionClick() {
    }

    public void onAppeared() {
    }

    public void onPause() {
    }

    public void onSwiped() {
    }

    public void release() {
    }
}

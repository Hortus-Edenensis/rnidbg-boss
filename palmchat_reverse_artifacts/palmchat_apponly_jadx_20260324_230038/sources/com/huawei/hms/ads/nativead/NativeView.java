package com.huawei.hms.ads.nativead;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.ClickAreaSource;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.cb;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.kx;
import com.huawei.hms.ads.ky;
import com.huawei.hms.ads.ll;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.d;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public class NativeView extends PPSNativeView implements INativeView {
    private final Map<String, View> B;
    private ChoicesView C;
    private View D;
    private View F;
    private View L;
    private View S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6602a;
    private View b;
    private MediaView c;
    private View d;
    private View e;
    private View f;
    private cb g;
    private MaterialClickInfo.a h;

    @GlobalApi
    public NativeView(Context context) {
        super(context);
        this.B = new HashMap();
        this.h = new MaterialClickInfo.a();
    }

    private void c() {
        if (this.g != null) {
            this.h.V(ky.Code(this));
            this.h.I((Integer) 0);
            this.h.Code(Float.valueOf(d.a(getContext())));
            fh.Code("NativeView", "fastAppClickInfo is %s ", this.h.Code().toString());
            this.g.Code().Code(this.h.Code());
        }
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void destroy() {
        this.B.clear();
        cb cbVar = this.g;
        if (cbVar != null) {
            cbVar.destroy();
        }
        MediaView mediaView = this.c;
        if (mediaView != null) {
            mediaView.Code();
        }
        super.B();
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getAdSourceView() {
        return this.B.get("5");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getCallToActionView() {
        return this.B.get("2");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public ChoicesView getChoicesView() {
        View view = this.B.get("11");
        if (view instanceof ChoicesView) {
            return (ChoicesView) view;
        }
        return null;
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getDescriptionView() {
        return this.B.get("4");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getIconView() {
        return this.B.get("3");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getImageView() {
        return this.B.get("8");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getMarketView() {
        return this.B.get("6");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public MediaView getMediaView() {
        View view = this.B.get("10");
        if (view instanceof MediaView) {
            return (MediaView) view;
        }
        return null;
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getPriceView() {
        return this.B.get("7");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getRatingView() {
        return this.B.get("9");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getTitleView() {
        return this.B.get("1");
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    public void gotoWhyThisAdPage() {
        super.gotoWhyThisAdPage();
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    @GlobalApi
    public void hideAdvertiserInfoDialog() {
        super.hideAdvertiserInfoDialog();
    }

    @GlobalApi
    public void listenClickButtonInfo(MotionEvent motionEvent, String str) {
        Context context = getContext();
        if (context == null || !z.V(context, context.getPackageName())) {
            fh.Code("NativeView", "context is null or the app is not trust app");
            return;
        }
        if (motionEvent == null || !ClickAreaSource.ADBUTTON.equals(str)) {
            return;
        }
        int iCode = kx.Code(motionEvent);
        if (iCode == 0) {
            Rect rectV = ky.V(this);
            if (rectV != null) {
                this.h.Code(Integer.valueOf(((int) motionEvent.getRawX()) - rectV.left));
                this.h.V(Integer.valueOf(((int) motionEvent.getRawY()) - rectV.top));
            }
            this.h.V(Long.valueOf(z.Code(motionEvent.getEventTime())));
        }
        if (1 == iCode) {
            Rect rectV2 = ky.V(this);
            if (rectV2 != null) {
                this.h.Z(Integer.valueOf(((int) motionEvent.getRawX()) - rectV2.left));
                this.h.B(Integer.valueOf(((int) motionEvent.getRawY()) - rectV2.top));
            }
            this.h.Code(Long.valueOf(z.Code(motionEvent.getEventTime())));
            c();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView, com.huawei.hms.ads.nativead.INativeView
    @GlobalApi
    public void onViewUpdate() {
        super.onViewUpdate();
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public boolean register(AppDownloadButton appDownloadButton) {
        return super.Code((ll) appDownloadButton);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setAdSourceView(View view) {
        this.S = view;
        this.B.put("5", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setCallToActionView(View view) {
        this.D = view;
        this.B.put("2", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setChoicesView(ChoicesView choicesView) {
        this.C = choicesView;
        this.B.put("11", choicesView);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setDescriptionView(View view) {
        this.F = view;
        this.B.put("4", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setIconView(View view) {
        this.f6602a = view;
        this.B.put("3", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setImageView(View view) {
        this.b = view;
        this.B.put("8", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setMarketView(View view) {
        this.f = view;
        this.B.put("6", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setMediaView(MediaView mediaView) {
        this.c = mediaView;
        this.B.put("10", mediaView);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setNativeAd(NativeAd nativeAd) {
        View viewB;
        NativeAdConfiguration nativeAdConfigurationAt;
        if (nativeAd instanceof cb) {
            cb cbVar = (cb) nativeAd;
            this.g = cbVar;
            cbVar.Code(this);
            setIsCustomDislikeThisAdEnabled(nativeAd.isCustomDislikeThisAdEnabled());
            MediaView mediaView = this.c;
            if (mediaView != null) {
                b mediaViewAdapter = mediaView.getMediaViewAdapter();
                mediaViewAdapter.Code(nativeAd);
                viewB = mediaViewAdapter.B();
                VideoOperator videoOperator = this.g.getVideoOperator();
                if (videoOperator instanceof c) {
                    ((c) videoOperator).Code(this.c);
                }
            } else {
                viewB = null;
            }
            l lVarCode = this.g.Code();
            List<View> arrayList = new ArrayList<>();
            arrayList.add(this);
            View callToActionView = getCallToActionView();
            if (callToActionView != null && callToActionView.isEnabled()) {
                arrayList.add(callToActionView);
            }
            if ((lVarCode instanceof l) && (nativeAdConfigurationAt = lVarCode.at()) != null) {
                setChoiceViewPosition(nativeAdConfigurationAt.getChoicesPosition());
            }
            if (viewB instanceof NativeWindowImageView) {
                Code(lVarCode, arrayList, (NativeWindowImageView) viewB);
            } else {
                if (!(viewB instanceof NativeVideoView)) {
                    Code(lVarCode, arrayList);
                    return;
                }
                NativeVideoView nativeVideoView = (NativeVideoView) viewB;
                arrayList.add(nativeVideoView.getPreviewImageView());
                Code(lVarCode, arrayList, nativeVideoView);
            }
        }
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setPriceView(View view) {
        this.d = view;
        this.B.put("7", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setRatingView(View view) {
        this.e = view;
        this.B.put("9", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setTitleView(View view) {
        this.L = view;
        this.B.put("1", view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    @GlobalApi
    public void showAdvertiserInfoDialog(View view, boolean z) {
        super.showAdvertiserInfoDialog(view, z);
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    public void showFeedback(View view) {
        super.showFeedback(view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void unregister(AppDownloadButton appDownloadButton) {
        super.V((ll) appDownloadButton);
    }

    @GlobalApi
    public NativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = new HashMap();
        this.h = new MaterialClickInfo.a();
    }

    @GlobalApi
    public NativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.B = new HashMap();
        this.h = new MaterialClickInfo.a();
    }

    @GlobalApi
    @SuppressLint({"NewApi"})
    public NativeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.B = new HashMap();
        this.h = new MaterialClickInfo.a();
    }
}

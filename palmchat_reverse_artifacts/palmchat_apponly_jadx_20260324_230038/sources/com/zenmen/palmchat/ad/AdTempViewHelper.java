package com.zenmen.palmchat.ad;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.ap3;
import defpackage.hx3;
import defpackage.y6;
import defpackage.zn6;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdTempViewHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f12428a;
    public a b;
    public boolean c;
    public ImageView d = null;
    public y6 e;
    public int f;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(View view);
    }

    public AdTempViewHelper(y6 y6Var, View view, a aVar, int i) {
        this.f12428a = view;
        this.b = aVar;
        this.e = y6Var;
        this.f = i;
    }

    public static boolean j(String str, String str2) {
        try {
            String strN = ap3.a().n(str, "A");
            LogUtil.d("", "AdTempViewHelper isAllowAdTemp result " + strN + " sdkFrom " + str2);
            if ("A".equals(strN)) {
                return false;
            }
            return SDKAlias.KS.getType().equals(str2);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void h() {
        if (this.e != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("requestId", this.e.g());
                jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
                jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
                jSONObject.put(EventParams.KEY_CT_SDK_FROM, this.e.i());
                jSONObject.put("appid", this.e.c());
                jSONObject.put("srcid", this.e.j());
                jSONObject.put("scene", this.e.h());
                jSONObject.put("taichi", this.e.k());
                jSONObject.put("exp_group", this.e.e());
                jSONObject.put("dspname", this.e.d());
                jSONObject.put("adcost", this.e.b());
                jSONObject.put("newRequestId", this.e.f());
                zn6.d("nest_sdk_addCloseButton", null, jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public View i() {
        if (this.f12428a != null) {
            try {
                TempParentView tempParentView = new TempParentView(this.f12428a.getContext());
                tempParentView.addView(this.f12428a, new ViewGroup.LayoutParams(-2, -2));
                ImageView imageView = new ImageView(this.f12428a.getContext());
                this.d = imageView;
                imageView.setBackgroundResource(R$drawable.ad_temp_close_bg);
                int iB = a46.b(this.f12428a.getContext(), 16.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iB, iB);
                layoutParams.topMargin = a46.b(this.f12428a.getContext(), 10.0f);
                layoutParams.rightMargin = a46.b(this.f12428a.getContext(), 10.0f);
                layoutParams.gravity = 5;
                tempParentView.addView(this.d, layoutParams);
                this.d.setVisibility(8);
                LogUtil.d("", "AdTempViewHelper initParentView mScene " + this.f + " parentView " + tempParentView);
                return tempParentView;
            } catch (Exception unused) {
            }
        }
        return this.f12428a;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class TempParentView extends FrameLayout {
        private boolean isDestroy;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TempParentView tempParentView = TempParentView.this;
                if (tempParentView.isFullyVisible(tempParentView)) {
                    TempParentView.this.checkAdError();
                } else {
                    TempParentView.this.startFullScreenCheck();
                }
            }
        }

        public TempParentView(@NonNull Context context) {
            super(context);
            this.isDestroy = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkAdError() {
            LogUtil.d("", "AdTempViewHelper checkAdError mScene " + AdTempViewHelper.this.f + " mAdErrorFind " + AdTempViewHelper.this.c);
            if (AdTempViewHelper.this.c || !(AdTempViewHelper.this.f12428a instanceof ViewGroup)) {
                return;
            }
            findAllChildView((ViewGroup) AdTempViewHelper.this.f12428a);
        }

        private void findAllChildView(ViewGroup viewGroup) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                try {
                    View childAt = viewGroup.getChildAt(i);
                    int visibility = childAt.getVisibility();
                    int width = childAt.getWidth();
                    if (visibility == 0 && width > 0) {
                        boolean globalVisibleRect = childAt.getGlobalVisibleRect(new Rect());
                        boolean zIsViewPartiallyOrFullyObscured = isViewPartiallyOrFullyObscured(childAt);
                        if ((!globalVisibleRect || zIsViewPartiallyOrFullyObscured) && !AdTempViewHelper.this.c) {
                            AdTempViewHelper.this.c = true;
                            LogUtil.d("", "AdTempViewHelper findAllChildView find error mScene " + AdTempViewHelper.this.f + " childResult:" + globalVisibleRect + " fullScreen:" + zIsViewPartiallyOrFullyObscured + " view " + childAt);
                            if (AdTempViewHelper.this.b != null) {
                                AdTempViewHelper.this.b.a(AdTempViewHelper.this.d);
                            }
                            AdTempViewHelper.this.h();
                            return;
                        }
                    }
                    if (childAt instanceof ViewGroup) {
                        findAllChildView((ViewGroup) childAt);
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isFullyVisible(View view) {
            if (view == null) {
                return false;
            }
            try {
                Rect rect = new Rect();
                if (!view.getGlobalVisibleRect(rect) || rect.width() < view.getMeasuredWidth()) {
                    return false;
                }
                return rect.height() >= view.getMeasuredHeight();
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean isViewPartiallyOrFullyObscured(View view) {
            if (view != null) {
                try {
                    Rect rect = new Rect();
                    view.getLocalVisibleRect(rect);
                    int iWidth = rect.width();
                    int width = view.getWidth();
                    int i = width - iWidth;
                    int iHeight = rect.height();
                    int height = view.getHeight();
                    int i2 = height - iHeight;
                    if (i > 0 || i2 > 0) {
                        float f = i > 0 ? (i * 1.0f) / width : 0.0f;
                        float f2 = i2 > 0 ? (i2 * 1.0f) / height : 0.0f;
                        LogUtil.d("", "AdTempViewHelper isViewPartiallyOrFullyObscured fw " + f + " fh " + f2);
                        if (f > 0.15f || f2 > 0.15f) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startFullScreenCheck() {
            if (this.isDestroy) {
                return;
            }
            postDelayed(new a(), 1000L);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.isDestroy = true;
            LogUtil.d("", "AdTempViewHelperWindow onDetachedFromWindow mScene " + AdTempViewHelper.this.f + this);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                startFullScreenCheck();
            }
        }

        public TempParentView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.isDestroy = false;
        }

        public TempParentView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.isDestroy = false;
        }
    }
}

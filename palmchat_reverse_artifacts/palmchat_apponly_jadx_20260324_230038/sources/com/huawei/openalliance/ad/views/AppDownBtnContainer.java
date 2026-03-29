package com.huawei.openalliance.ad.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.nativead.R;
import com.huawei.hms.ads.uiengine.common.IProgressButton;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.utils.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AppDownBtnContainer extends PPSSafeRelativeLayout implements View.OnClickListener, IProgressButton, IProgressButton.ProgressButtonResetListener {
    protected boolean B;
    private RelativeLayout.LayoutParams D;
    private ImageView F;
    protected a I;
    private int L;
    private IProgressButton S;
    protected String V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6962a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;

    public AppDownBtnContainer(Context context) {
        super(context);
        this.V = "AppDownBtn_" + hashCode();
        this.f6962a = false;
        this.b = true;
        this.g = false;
        this.h = false;
        Code(context, null, false, null, null);
    }

    private void Code() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f;
            layoutParams.width = this.e;
            setLayoutParams(layoutParams);
        }
        if (this.g) {
            Code(this.f);
        }
    }

    private void V(int i) {
        if (this.b || this.e <= 0) {
            int i2 = this.c;
            if ((i2 <= 0 || i <= i2) && ((i2 = this.d) <= 0 || i >= i2)) {
                this.e = i;
            } else {
                this.e = i2;
            }
        }
    }

    private Drawable getCancelBtnDrawable() {
        a aVar = this.I;
        return aVar == null ? getContext().getResources().getDrawable(R.drawable.hiad_app_down_cancel_btn) : aVar.C;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public int getProgress() {
        return this.S.getProgress();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public Drawable getProgressDrawable() {
        return this.S.getProgressDrawable();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public Rect getPromptRect() {
        return this.S.getPromptRect();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public abstract AppStatus getStatus();

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public CharSequence getText() {
        return this.S.getText();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void incrementProgressBy(int i) {
        this.S.incrementProgressBy(i);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public boolean isFastClick() {
        return this.S.isFastClick();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        IProgressButton iProgressButton = this.S;
        if (iProgressButton != null && this.f6962a) {
            ViewGroup.LayoutParams layoutParams = iProgressButton.getProgressBtn().getLayoutParams();
            layoutParams.height = View.MeasureSpec.getSize(i2);
            layoutParams.width = View.MeasureSpec.getSize(i);
            int i4 = this.f;
            if (i4 > 0) {
                layoutParams.height = i4;
            }
            if (this.b && (i3 = this.e) > 0) {
                layoutParams.width = i3;
            }
            int i5 = this.c;
            if (i5 > 0 && layoutParams.width > i5) {
                layoutParams.width = i5;
            }
            int i6 = this.d;
            if (i6 > 0 && layoutParams.width < i6) {
                layoutParams.width = i6;
            }
            if (layoutParams.width > 0 && layoutParams.height > 0) {
                this.S.getProgressBtn().setLayoutParams(layoutParams);
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton.ProgressButtonResetListener
    public void onSizeReset(int i, int i2) {
        fh.Code("AppDownBtn", "on size reset: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (this.h) {
            this.e = i;
            this.h = false;
        } else {
            V(i);
        }
        this.f = i2;
        Code();
    }

    public void setCancelBtnClickListener(View.OnClickListener onClickListener) {
        this.F.setOnClickListener(onClickListener);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setFixedWidth(boolean z) {
        this.S.setFixedWidth(z);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setFontFamily(String str) {
        this.S.setFontFamily(str);
    }

    public void setLayoutParamsSkipSizeReset(ViewGroup.LayoutParams layoutParams) {
        this.h = true;
        setLayoutParams(layoutParams);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setMax(int i) {
        this.S.setMax(i);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setMaxWidth(int i) {
        this.S.setMaxWidth(i);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setMinWidth(int i) {
        this.S.setMinWidth(i);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setPaintTypeface(Typeface typeface) {
        this.S.setPaintTypeface(typeface);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setProgress(int i) {
        this.S.setProgress(i);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setProgressDrawable(Drawable drawable) {
        this.S.setProgressDrawable(drawable);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setResetWidth(boolean z) {
        this.b = z;
        this.S.setResetWidth(z);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setText(CharSequence charSequence) {
        this.S.setTextInner(charSequence, this.g);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setTextColor(int i) {
        this.S.setTextColor(i);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setTextSize(float f) {
        this.S.setTextSize(f);
    }

    public void setVisibilityInner(int i) {
        this.S.getProgressBtn().setVisibility(i);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    @AllApi
    public void updateLayoutHeight() {
        this.S.updateLayoutHeight();
    }

    public AppDownBtnContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = "AppDownBtn_" + hashCode();
        this.f6962a = false;
        this.b = true;
        this.g = false;
        this.h = false;
        Code(context, attributeSet, false, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i) {
        this.L = i < z.V(getContext(), 40.0f) ? z.V(getContext(), 12.0f) : z.V(getContext(), 16.0f);
        int cancelBtnHeight = this.S.getCancelBtnHeight(i);
        fh.Code("AppDownBtn", "btnHeight: %s, cancelBtnSize: %s, realBtnHeight: %s", Integer.valueOf(i), Integer.valueOf(this.L), Integer.valueOf(cancelBtnHeight));
        RelativeLayout.LayoutParams layoutParams = this.D;
        layoutParams.height = cancelBtnHeight;
        layoutParams.width = cancelBtnHeight;
        layoutParams.setMarginEnd(0);
        int i2 = this.L;
        int i3 = (cancelBtnHeight - i2) / 2;
        if (i3 <= 0) {
            RelativeLayout.LayoutParams layoutParams2 = this.D;
            layoutParams2.height = i2;
            layoutParams2.width = i2;
            layoutParams2.setMarginEnd(z.V(getContext(), 12.0f));
            i3 = 0;
        }
        this.F.setPaddingRelative(i3, i3, i3, i3);
        if (this.B) {
            this.S.setCancelBtnHeight(this.L);
            this.F.setBackground(this.I.Z().Code());
        }
        try {
            if (this.F.getParent() != this) {
                addView(this.F, this.D);
            }
        } catch (Throwable th) {
            fh.I("AppDownBtn", "add cancel btn ex: %s", th.getClass().getSimpleName());
        }
    }

    public void V(int i, int i2, int i3, int i4) {
        this.S.getProgressBtn().setPaddingRelative(i, i2, i3, i4);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setPaintTypeface(Typeface typeface, int i) {
        this.S.setPaintTypeface(typeface, i);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setProgressDrawable(Drawable drawable, int i) {
        this.S.setProgressDrawable(drawable, i);
    }

    public AppDownBtnContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.V = "AppDownBtn_" + hashCode();
        this.f6962a = false;
        this.b = true;
        this.g = false;
        this.h = false;
        Code(context, attributeSet, false, null, null);
    }

    public void Code(int i, int i2, int i3, int i4) {
        this.S.getProgressBtn().setPadding(i, i2, i3, i4);
    }

    public void V(AppStatus appStatus) {
        if (appStatus == null) {
            return;
        }
        this.g = Code(appStatus);
        fh.Code("AppDownBtn", "configCancelBtn, status: %s", appStatus);
        if (this.g) {
            this.F.setImageDrawable(getCancelBtnDrawable());
            this.S.setShowCancelBtn(this.g);
            int measuredHeight = getMeasuredHeight();
            if (measuredHeight <= 0) {
                post(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownBtnContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        fh.Code("AppDownBtn", "post run");
                        AppDownBtnContainer appDownBtnContainer = AppDownBtnContainer.this;
                        appDownBtnContainer.Code(appDownBtnContainer.getMeasuredHeight());
                    }
                });
                return;
            } else {
                Code(measuredHeight);
                return;
            }
        }
        try {
            if (this.F.getParent() == this) {
                this.S.setShowCancelBtn(this.g);
                removeView(this.F);
            }
        } catch (Throwable th) {
            fh.I("AppDownBtn", "remove cancel btn ex: %s", th.getClass().getSimpleName());
        }
    }

    @SuppressLint({"NewApi"})
    public AppDownBtnContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.V = "AppDownBtn_" + hashCode();
        this.f6962a = false;
        this.b = true;
        this.g = false;
        this.h = false;
        Code(context, attributeSet, false, null, null);
    }

    private void Code(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return;
        }
        this.f6962a = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.hiad_progress_button);
        try {
            this.b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.hiad_progress_button_hiad_resetWidth, true);
            this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.hiad_progress_button_hiad_maxWidth, 0);
            this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.hiad_progress_button_hiad_minWidth, 0);
        } finally {
            try {
            } finally {
            }
        }
    }

    public AppDownBtnContainer(Context context, Boolean bool) {
        super(context);
        this.V = "AppDownBtn_" + hashCode();
        this.f6962a = false;
        this.b = true;
        this.g = false;
        this.h = false;
        Code(context, null, (bool == null ? Boolean.TRUE : bool).booleanValue(), null, null);
    }

    private void Code(Context context, AttributeSet attributeSet, boolean z, IProgressButton iProgressButton, ImageView imageView) {
        View progressBtn;
        int i;
        Code(context, attributeSet);
        fh.Code("AppDownBtn", "init, create with attrs: %s", Boolean.valueOf(this.f6962a));
        if (iProgressButton == null || iProgressButton.getProgressBtn() == null) {
            this.S = z ? new ProgressButtonForNarrowBounds(context, attributeSet) : new ProgressButton(context, attributeSet);
            progressBtn = this.S.getProgressBtn();
            i = R.id.haid_down_btn_progress;
        } else {
            fh.Code(this.V, "init btn for uiengine");
            this.S = iProgressButton;
            progressBtn = iProgressButton.getProgressBtn();
            i = R.id.haid_down_btn_progress_uiengine;
        }
        progressBtn.setId(i);
        fh.V(this.V, "progressBtn: %s", Integer.valueOf(this.S.hashCode()));
        setOnClickListener(this);
        this.S.setResetListener(this);
        this.S.getProgressBtn().setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        addView(this.S.getProgressBtn(), layoutParams);
        this.B = z;
        Code(context, imageView);
    }

    public AppDownBtnContainer(Context context, Boolean bool, IProgressButton iProgressButton) {
        super(context);
        this.V = "AppDownBtn_" + hashCode();
        this.f6962a = false;
        this.b = true;
        this.g = false;
        this.h = false;
        Code(context, null, (bool == null ? Boolean.TRUE : bool).booleanValue(), iProgressButton, null);
    }

    private void Code(Context context, ImageView imageView) {
        if (context == null) {
            return;
        }
        if (imageView != null) {
            fh.Code(this.V, "init cancelBtn for uiengine");
        } else {
            imageView = new ImageView(context);
        }
        this.F = imageView;
        this.L = z.V(context, 16.0f);
        if (this.F.getDrawable() == null) {
            this.F.setImageDrawable(context.getResources().getDrawable(R.drawable.hiad_app_down_cancel_btn));
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.D = layoutParams;
        layoutParams.addRule(19, this.S.getProgressBtn().getId());
        this.D.addRule(15);
    }

    public AppDownBtnContainer(Context context, Boolean bool, IProgressButton iProgressButton, ImageView imageView) {
        super(context);
        this.V = "AppDownBtn_" + hashCode();
        this.f6962a = false;
        this.b = true;
        this.g = false;
        this.h = false;
        Code(context, null, (bool == null ? Boolean.TRUE : bool).booleanValue(), iProgressButton, imageView);
    }

    public void Code(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.S.getProgressBtn().setOnClickListener(onClickListener);
    }

    private static boolean Code(AppStatus appStatus) {
        return AppStatus.PAUSE == appStatus || AppStatus.WAITING_FOR_WIFI == appStatus;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}

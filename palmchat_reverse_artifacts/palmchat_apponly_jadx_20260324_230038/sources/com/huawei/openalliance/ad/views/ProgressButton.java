package com.huawei.openalliance.ad.views;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.uiengine.common.IProgressButton;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.z;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ProgressButton extends View implements View.OnClickListener, IProgressButton {
    private long A;
    String B;
    int C;
    protected Rect Code;
    protected final byte[] D;
    private Paint E;
    protected Drawable F;
    private boolean G;
    private IProgressButton.ProgressButtonResetListener H;
    protected CharSequence I;
    protected int L;
    int S;
    protected Paint V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f6980a;
    protected int b;
    protected int c;
    protected boolean d;
    protected boolean e;
    protected int f;
    private String n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private float v;
    private Float w;
    private int x;
    private int y;
    private Drawable z;

    public ProgressButton(Context context) {
        this(context, null);
        V();
    }

    private void B() {
        synchronized (this.D) {
            int[] drawableState = getDrawableState();
            Drawable drawable = this.F;
            if (drawable != null && drawable.isStateful()) {
                this.F.setState(drawableState);
            }
        }
    }

    private float Code(CharSequence charSequence, float f) {
        fh.Code(this.n, "startSize:%s", Float.valueOf(f));
        int paddingSize = getPaddingSize();
        int buttonSize = getButtonSize();
        int iCode = z.Code(getContext(), f);
        while (iCode > 9 && !Code(charSequence, iCode, paddingSize, buttonSize)) {
            iCode--;
        }
        float fZ = z.Z(getContext(), iCode);
        fh.Code(this.n, "resultSize:%s", Float.valueOf(fZ));
        return fZ;
    }

    private void I() {
        if (this.d) {
            int measuredHeight = this.t;
            if (measuredHeight <= 0) {
                measuredHeight = getMeasuredHeight();
            }
            if (measuredHeight <= 0) {
                return;
            }
            boolean z = measuredHeight < this.L;
            this.f6980a = z.V(getContext(), z ? 24 : 36);
            this.b = z.V(getContext(), z ? 8 : 16);
            this.c = (measuredHeight / 2) + (z.V(getContext(), 12) / 2) + z.V(getContext(), z ? 4 : 8);
            fh.Code(this.n, "update text safe padding, start: %s, end: %s", Integer.valueOf(this.b), Integer.valueOf(this.c));
        }
    }

    private void V() {
        Paint paint = new Paint();
        this.V = paint;
        paint.setAntiAlias(true);
        this.V.setTextSize(this.v);
        this.V.setColor(this.u);
        Paint paint2 = new Paint();
        this.E = paint2;
        paint2.setTextSize(this.v);
        int i = this.S;
        if (i != -1) {
            this.B = null;
        }
        Code(this.B, this.C, i);
        setClickable(true);
        Paint paint3 = new Paint();
        paint3.setTextSize(this.v);
        Rect rect = new Rect();
        paint3.getTextBounds("...", 0, 3, rect);
        this.o = rect.width();
        this.G = bg.C();
        this.L = z.V(getContext(), 40.0f);
    }

    private void Z() {
        Paint paint = new Paint();
        paint.setTextSize(this.v);
        Rect rect = new Rect();
        paint.getTextBounds("...", 0, 3, rect);
        this.o = rect.width();
    }

    private int getButtonSize() {
        if (!this.p) {
            return this.r;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int width = getWidth();
        return width <= 0 ? layoutParams.width : width;
    }

    private int getPaddingSize() {
        return Code(getPaddingStart(), getPaddingLeft(), this.b) + Code(getPaddingEnd(), getPaddingRight(), this.c);
    }

    private void setOriginTextSize(Float f) {
        if (f != null) {
            Float f2 = this.w;
            if (f2 == null || f2.floatValue() == 0.0f) {
                this.w = f;
            }
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        fh.Code(this.n, "drawableStateChanged");
        super.drawableStateChanged();
        B();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public int getProgress() {
        int i;
        synchronized (this.D) {
            i = this.x;
        }
        return i;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public Drawable getProgressDrawable() {
        Drawable drawable;
        synchronized (this.D) {
            drawable = this.F;
        }
        return drawable;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public Rect getPromptRect() {
        Rect rect;
        synchronized (this.D) {
            rect = this.Code;
        }
        return rect;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public AppStatus getStatus() {
        return null;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public CharSequence getText() {
        CharSequence charSequence;
        synchronized (this.D) {
            charSequence = this.I;
        }
        return charSequence;
    }

    public int getTextStart() {
        if (bg.C()) {
            return this.c;
        }
        int width = ((getWidth() - this.Code.width()) - this.f6980a) / 2;
        int i = this.b;
        if (width < i) {
            width = i;
        }
        fh.Code(this.n, "safeTextStart: %s", Integer.valueOf(width));
        return width;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public final void incrementProgressBy(int i) {
        synchronized (this.D) {
            setProgress(this.x + i);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public boolean isFastClick() {
        if (System.currentTimeMillis() - this.A < 500) {
            return true;
        }
        this.A = System.currentTimeMillis();
        return false;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        synchronized (this.D) {
            super.jumpDrawablesToCurrentState();
            Drawable drawable = this.F;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        synchronized (this.D) {
            super.onDraw(canvas);
            Drawable drawable = this.z;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            if (Code(drawable)) {
                canvas.scale(-1.0f, 1.0f, getWidth() / 2.0f, getHeight() / 2.0f);
            }
            Code(canvas);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        try {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setProgress(savedState.Code);
        } catch (ClassCastException unused) {
            fh.I("ProgressBtn", "onRestoreInstanceState ClassCastException");
        } catch (Throwable th) {
            fh.I("ProgressBtn", "onRestoreInstanceState err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedStateCode;
        synchronized (this.D) {
            savedStateCode = SavedState.Code(super.onSaveInstanceState());
            savedStateCode.Code = this.x;
        }
        return savedStateCode;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Code(i, i2);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setCancelBtnHeight(int i) {
        this.f = i;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setFixedWidth(boolean z) {
        this.p = z;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setFontFamily(String str) {
        this.B = str;
        Code(str, this.C, this.S);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setMax(int i) {
        synchronized (this.D) {
            if (i < 0) {
                i = 0;
            }
            if (i != this.y) {
                this.y = i;
                postInvalidate();
                if (this.x > i) {
                    this.x = i;
                }
                V(this.x, false);
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setMaxWidth(int i) {
        synchronized (this.D) {
            this.r = i;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setMinWidth(int i) {
        synchronized (this.D) {
            this.s = i;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setPaintTypeface(Typeface typeface) {
        synchronized (this.D) {
            this.V.setTypeface(typeface);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setProgress(int i) {
        synchronized (this.D) {
            Code(i, false);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setProgressDrawable(Drawable drawable) {
        setProgressDrawable(drawable, 0);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setResetListener(IProgressButton.ProgressButtonResetListener progressButtonResetListener) {
        this.H = progressButtonResetListener;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setResetWidth(boolean z) {
        this.q = z;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setShowCancelBtn(boolean z) {
        this.e = z;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setText(CharSequence charSequence) {
        fh.Code(this.n, "setText:%s, need safepadding: %s", charSequence, Boolean.valueOf(this.d));
        synchronized (this.D) {
            I();
            this.I = String.valueOf(charSequence).toUpperCase(Locale.getDefault());
            Float f = this.w;
            float fCode = Code(this.I, f != null ? f.floatValue() : this.v);
            if (!TextUtils.isEmpty(charSequence) && Math.abs(fCode - this.v) >= 0.5f) {
                setTextSize(fCode);
            }
            if (getWidth() > 0 || this.q) {
                Code();
            } else {
                post(new Runnable() { // from class: com.huawei.openalliance.ad.views.ProgressButton.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (fh.Code()) {
                            fh.Code(ProgressButton.this.n, "view post, resetButtonSize");
                        }
                        ProgressButton.this.Code();
                    }
                });
            }
            postInvalidate();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setTextColor(int i) {
        this.u = i;
        Paint paint = this.V;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setTextInner(CharSequence charSequence, boolean z) {
        this.d = z;
        setText(charSequence);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setTextSize(float f) {
        this.v = f;
        setOriginTextSize(Float.valueOf(f));
        Paint paint = this.V;
        if (paint != null) {
            paint.setAntiAlias(true);
            this.V.setTextSize(this.v);
        }
        Z();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void updateLayoutHeight() {
        this.t = ((int) this.v) + getPaddingTop() + getPaddingBottom();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        boolean z;
        synchronized (this.D) {
            z = drawable == this.F || super.verifyDrawable(drawable);
        }
        return z;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.huawei.openalliance.ad.views.ProgressButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private static SavedState V;
        int Code;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Code = parcel.readInt();
        }

        public static SavedState Code(Parcelable parcelable) {
            if (V == null) {
                V = new SavedState(parcelable);
            }
            return V;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Code);
        }

        private SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.progressBarStyle);
        Code(context, attributeSet);
        V();
    }

    private int Code(int i, int i2, int i3) {
        if (i <= 0) {
            i = i2;
        }
        return (!this.d || i3 <= 0 || i >= i3) ? i : i3;
    }

    private void V(int i, ViewGroup.LayoutParams layoutParams) {
        int width = getWidth();
        if (width <= 0 && this.q) {
            width = layoutParams.width;
        }
        if (i > width && width > 0) {
            CharSequence charSequenceCode = Code(this.I, i, width);
            this.I = charSequenceCode;
            this.V.getTextBounds(charSequenceCode.toString(), 0, this.I.length(), this.Code);
        } else {
            if (width > 0 || !this.q) {
                return;
            }
            layoutParams.width = i;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setPaintTypeface(Typeface typeface, int i) {
        if (i <= 0) {
            this.V.setFakeBoldText(false);
            this.V.setTextSkewX(0.0f);
            setPaintTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
            setPaintTypeface(typefaceDefaultFromStyle);
            int i2 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i;
            this.V.setFakeBoldText((i2 & 1) != 0);
            this.V.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setProgressDrawable(Drawable drawable, int i) {
        boolean z;
        synchronized (this.D) {
            Drawable drawable2 = this.F;
            if (drawable2 == null || drawable == drawable2) {
                z = false;
            } else {
                drawable2.setCallback(null);
                this.F.setState(new int[0]);
                z = true;
            }
            if (drawable != null) {
                drawable.setCallback(this);
            }
            this.F = drawable;
            this.z = drawable;
            if (z) {
                Code(getWidth(), getHeight());
                if (i < 0) {
                    i = 0;
                }
                int i2 = this.y;
                if (i > i2) {
                    i = i2;
                }
                this.x = i;
                Code(i, false, false);
            } else {
                setProgress(i);
            }
        }
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
        Code(context, attributeSet);
        V();
    }

    private CharSequence Code(CharSequence charSequence, int i, int i2) {
        int length = getText().length();
        int iCeil = (int) Math.ceil((((double) (i - i2)) / ((double) getPromptRect().width())) * ((double) length));
        int iCeil2 = (int) Math.ceil(((double) (this.o * length)) / ((double) getPromptRect().width()));
        int i3 = length - iCeil;
        if (i3 - iCeil2 <= 0) {
            return i3 > 0 ? charSequence.toString().substring(0, i3) : charSequence;
        }
        return charSequence.toString().substring(0, length - (iCeil + iCeil2)) + "...";
    }

    private void V(int i, boolean z) {
        synchronized (this.D) {
            Code(i, z, true);
        }
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.n = "ProgressBtn_" + hashCode();
        this.Code = new Rect();
        this.p = false;
        this.q = true;
        this.u = -1;
        this.v = 12.0f;
        this.w = null;
        this.B = null;
        this.C = -1;
        this.S = -1;
        this.x = 0;
        this.y = 100;
        this.D = new byte[0];
        this.d = false;
        setOnClickListener(this);
        Code(context, attributeSet);
        V();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007f A[Catch: all -> 0x008a, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000f, B:11:0x004d, B:13:0x004f, B:15:0x0053, B:16:0x0055, B:18:0x0059, B:19:0x0068, B:21:0x006c, B:22:0x006f, B:26:0x007b, B:28:0x007f, B:29:0x0086, B:23:0x0073, B:25:0x0077, B:31:0x0088), top: B:36:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Code() {
        IProgressButton.ProgressButtonResetListener progressButtonResetListener;
        synchronized (this.D) {
            CharSequence charSequence = this.I;
            if (charSequence != null && charSequence.length() != 0) {
                this.V.getTextBounds(this.I.toString(), 0, this.I.length(), this.Code);
                int iCode = Code(getPaddingStart(), getPaddingLeft(), this.b);
                int iWidth = this.Code.width() + iCode + Code(getPaddingEnd(), getPaddingRight(), this.c);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams == null) {
                    return;
                }
                int i = this.t;
                if (i > 0) {
                    layoutParams.height = i;
                }
                if (layoutParams.height <= 0) {
                    layoutParams.height = ((int) this.v) + getPaddingTop() + getPaddingBottom();
                }
                if (!this.p) {
                    if (iWidth != layoutParams.width) {
                        Code(iWidth, layoutParams);
                    }
                    progressButtonResetListener = this.H;
                    if (progressButtonResetListener != null) {
                        progressButtonResetListener.onSizeReset(layoutParams.width, layoutParams.height);
                    }
                }
                V(iWidth, layoutParams);
                setLayoutParams(layoutParams);
                progressButtonResetListener = this.H;
                if (progressButtonResetListener != null) {
                }
            }
        }
    }

    public void Code(float f, boolean z) {
    }

    public void Code(int i, int i2) {
        synchronized (this.D) {
            Drawable drawable = this.F;
            if (drawable != null) {
                drawable.setBounds(0, 0, i, i2);
            }
        }
    }

    private void Code(int i, ViewGroup.LayoutParams layoutParams) {
        int i2 = this.r;
        if (i <= i2 || i2 <= 0) {
            int i3 = this.s;
            if (i < i3) {
                i = i3;
            }
        } else {
            CharSequence charSequenceCode = Code(this.I, i, i2);
            this.I = charSequenceCode;
            this.V.getTextBounds(charSequenceCode.toString(), 0, this.I.length(), this.Code);
            i = this.r;
        }
        layoutParams.width = i;
    }

    public void Code(int i, boolean z) {
        synchronized (this.D) {
            if (i < 0) {
                i = 0;
            }
            int i2 = this.y;
            if (i > i2) {
                i = i2;
            }
            if (i != this.x) {
                this.x = i;
                V(i, z);
            }
        }
    }

    private void Code(int i, boolean z, boolean z2) {
        synchronized (this.D) {
            int i2 = this.y;
            float f = i2 > 0 ? i / i2 : 0.0f;
            Drawable drawable = this.z;
            if (drawable != null) {
                drawable.setLevel((int) (10000.0f * f));
            } else {
                invalidate();
            }
            if (z2) {
                Code(f, z);
            }
        }
    }

    private void Code(Context context, AttributeSet attributeSet) {
        synchronized (this.D) {
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button);
                TypedArray typedArrayObtainStyledAttributes2 = null;
                try {
                    typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.layout_height});
                    int dimensionPixelSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -2);
                    this.t = dimensionPixelSize;
                    fh.Code(this.n, "layoutHeight: %s", Integer.valueOf(dimensionPixelSize));
                } catch (Throwable th) {
                    try {
                        fh.I(this.n, "get layout height ex: %s", th.getClass().getSimpleName());
                    } finally {
                        if (typedArrayObtainStyledAttributes2 != null) {
                            typedArrayObtainStyledAttributes2.recycle();
                        }
                    }
                }
                try {
                    try {
                        this.p = typedArrayObtainStyledAttributes.getBoolean(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_fixedWidth, false);
                        this.q = typedArrayObtainStyledAttributes.getBoolean(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_resetWidth, true);
                        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_maxWidth, 0);
                        this.s = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_minWidth, 0);
                        float dimension = typedArrayObtainStyledAttributes.getDimension(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_textSize, 0.0f);
                        this.v = dimension;
                        setOriginTextSize(Float.valueOf(dimension));
                        this.u = typedArrayObtainStyledAttributes.getColor(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_textColor, -1);
                        this.B = typedArrayObtainStyledAttributes.getString(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_fontFamily);
                        this.S = typedArrayObtainStyledAttributes.getInt(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_styleIndex, -1);
                        this.C = typedArrayObtainStyledAttributes.getInt(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_typefaceIndex, -1);
                    } catch (RuntimeException unused) {
                        fh.I(this.n, "initButtonAttr RuntimeException");
                    } catch (Exception unused2) {
                        fh.I(this.n, "initButtonAttr error");
                    }
                    if (this.t <= 0) {
                        this.t = ((int) this.v) + getPaddingTop() + getPaddingBottom();
                    }
                } finally {
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
        }
    }

    public void Code(Canvas canvas) {
        Rect rect;
        synchronized (this.D) {
            CharSequence charSequence = this.I;
            if (charSequence != null && charSequence.length() > 0) {
                if (this.V != null && (rect = this.Code) != null && rect.width() <= 0) {
                    this.V.getTextBounds(this.I.toString(), 0, this.I.length(), this.Code);
                }
                String strIntern = this.I.toString().intern();
                int width = (getWidth() / 2) - this.Code.centerX();
                if (this.d && width < this.f6980a) {
                    width = getTextStart();
                }
                canvas.drawText((CharSequence) strIntern, 0, strIntern.length(), width, (getHeight() / 2) - this.Code.centerY(), this.V);
            }
        }
    }

    private void Code(String str, int i, int i2) {
        Typeface typefaceCreate;
        fh.Code(this.n, "setTypefaceFromAttrs");
        if (str != null) {
            typefaceCreate = Typeface.create(str, i2);
            if (typefaceCreate != null) {
                fh.Code(this.n, "setTypeface");
                setPaintTypeface(typefaceCreate);
                this.V.setTypeface(typefaceCreate);
                return;
            }
        } else {
            typefaceCreate = null;
        }
        if (i == 1) {
            typefaceCreate = Typeface.SANS_SERIF;
        } else if (i == 2) {
            typefaceCreate = Typeface.SERIF;
        } else if (i == 3) {
            typefaceCreate = Typeface.MONOSPACE;
        }
        setPaintTypeface(typefaceCreate, i2);
    }

    private boolean Code(Drawable drawable) {
        Drawable drawableFindDrawableByLayerId;
        if (drawable == null || !(drawable instanceof LayerDrawable) || (drawableFindDrawableByLayerId = ((LayerDrawable) drawable).findDrawableByLayerId(R.id.progress)) == null) {
            return false;
        }
        if ((drawableFindDrawableByLayerId instanceof f) || (drawableFindDrawableByLayerId instanceof g)) {
            return this.G;
        }
        return false;
    }

    private boolean Code(CharSequence charSequence, int i, int i2, int i3) {
        float fZ = z.Z(getContext(), i);
        fh.Code(this.n, "currentSize:%s", Float.valueOf(fZ));
        fh.Code(this.n, "buttonSize:%s", Integer.valueOf(i3));
        if (i3 < 0) {
            return true;
        }
        this.E.setTextSize(fZ);
        this.E.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.Code);
        int iWidth = this.Code.width() + i2;
        fh.Code(this.n, "textWidth:%s, btnWidth:%s", Integer.valueOf(iWidth), Integer.valueOf(i3));
        return iWidth <= i3;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public View getProgressBtn() {
        return this;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public int getCancelBtnHeight(int i) {
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}

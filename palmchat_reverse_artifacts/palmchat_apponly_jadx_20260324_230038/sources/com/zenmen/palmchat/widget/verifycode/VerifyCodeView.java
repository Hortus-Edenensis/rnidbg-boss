package com.zenmen.palmchat.widget.verifycode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.h46;
import defpackage.r96;
import defpackage.vy4;
import defpackage.zj5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class VerifyCodeView extends View {
    private static final int WRAPPER_ROUND = 2;
    private static final int WRAPPER_SQUARE = 1;
    private static final int WRAPPER_UNDER_LINE = 0;
    private boolean autoHideKeyboard;
    EditText dismissEdit;
    public boolean hideBg;
    public boolean hideInput;
    private int mHeight;
    private int mWidth;
    private b onAllFilledListener;
    private c onTextChangedListener;
    private float rectRadius;
    private int screenHeight;
    private int screenWidth;
    private float vcDividerWidth;
    private int vcEmptyWrapperColor;
    private int vcNextWrapperColor;
    private RectF[] vcOuterRects;
    private StringBuilder vcTextBuilder;
    private int vcTextColor;
    private int vcTextCount;
    private Typeface vcTextFont;
    private Paint vcTextPaint;
    private PointF[] vcTextPositions;
    private RectF[] vcTextRects;
    private float vcTextSize;
    private r96 vcWrapper;
    private int vcWrapperColor;
    private Paint vcWrapperPaint;
    private float vcWrapperStrokeWidth;

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void d(String str);
    }

    public VerifyCodeView(Context context) {
        super(context);
        this.vcTextCount = 6;
        this.rectRadius = 0.0f;
        this.vcTextColor = -16777216;
        this.vcTextSize = 28.0f;
        this.vcTextFont = Typeface.defaultFromStyle(1);
        this.vcDividerWidth = 10.0f;
        this.hideBg = false;
        this.hideInput = false;
        this.vcWrapperColor = -2565928;
        this.vcNextWrapperColor = -16468830;
        this.vcEmptyWrapperColor = -2565928;
        this.vcWrapperStrokeWidth = 2.0f;
        this.autoHideKeyboard = true;
        init(context, null);
    }

    private void calculatePositions() {
        Paint.FontMetricsInt fontMetricsInt = this.vcTextPaint.getFontMetricsInt();
        float fMeasureText = this.vcTextPaint.measureText("8");
        float f = ((this.mHeight / 2) + ((r2 - fontMetricsInt.top) / 2.0f)) - fontMetricsInt.bottom;
        float f2 = this.mWidth;
        float f3 = (f2 - ((r3 - 1) * this.vcDividerWidth)) / this.vcTextCount;
        int i = 0;
        while (i < this.vcTextCount) {
            float f4 = i;
            float f5 = f4 * f3;
            this.vcTextPositions[i] = new PointF((this.vcDividerWidth * f4) + f5 + (f3 / 2.0f), f);
            RectF[] rectFArr = this.vcOuterRects;
            float f6 = this.vcDividerWidth;
            int i2 = i + 1;
            rectFArr[i] = new RectF(f5 + (f4 * f6) + 1.0f, 1.0f, ((i2 * f3) + (f4 * f6)) - 1.0f, this.mHeight - 1);
            RectF[] rectFArr2 = this.vcTextRects;
            PointF pointF = this.vcTextPositions[i];
            float f7 = pointF.x;
            float f8 = fMeasureText / 2.0f;
            float f9 = pointF.y;
            rectFArr2[i] = new RectF(f7 - f8, fontMetricsInt.top + f9, f7 + f8, f9 + fontMetricsInt.bottom);
            i = i2;
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VerifyCodeView);
            int i = typedArrayObtainStyledAttributes.getInt(4, this.vcTextCount);
            this.vcTextCount = i;
            if (i < 2) {
                throw new IllegalArgumentException("The Text Length should more than 1");
            }
            this.vcTextColor = typedArrayObtainStyledAttributes.getColor(3, this.vcTextColor);
            this.rectRadius = typedArrayObtainStyledAttributes.getDimension(9, 0.0f);
            this.vcTextSize = typedArrayObtainStyledAttributes.getDimension(6, TypedValue.applyDimension(2, this.vcTextSize, context.getResources().getDisplayMetrics()));
            this.vcDividerWidth = typedArrayObtainStyledAttributes.getDimension(0, TypedValue.applyDimension(1, this.vcDividerWidth, context.getResources().getDisplayMetrics()));
            int i2 = typedArrayObtainStyledAttributes.getInt(7, 0);
            if (i2 == 1) {
                this.vcWrapper = new zj5();
            } else if (i2 != 2) {
                this.vcWrapper = new h46();
            } else {
                this.vcWrapper = new vy4();
            }
            this.vcWrapperStrokeWidth = typedArrayObtainStyledAttributes.getDimension(10, TypedValue.applyDimension(1, this.vcWrapperStrokeWidth, context.getResources().getDisplayMetrics()));
            this.vcWrapperColor = typedArrayObtainStyledAttributes.getColor(8, this.vcWrapperColor);
            this.vcNextWrapperColor = typedArrayObtainStyledAttributes.getColor(2, this.vcNextWrapperColor);
            this.vcEmptyWrapperColor = typedArrayObtainStyledAttributes.getColor(1, this.vcEmptyWrapperColor);
            String string = typedArrayObtainStyledAttributes.getString(5);
            if (!TextUtils.isEmpty(string)) {
                this.vcTextFont = Typeface.createFromAsset(context.getAssets(), string);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.vcTextBuilder = new StringBuilder(this.vcTextCount);
        int i3 = this.vcTextCount;
        this.vcTextPositions = new PointF[i3];
        this.vcOuterRects = new RectF[i3];
        this.vcTextRects = new RectF[i3];
        initPaint();
        setFocusableInTouchMode(true);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.screenWidth = displayMetrics.widthPixels;
            this.screenHeight = displayMetrics.heightPixels;
        }
    }

    private void initPaint() {
        if (this.vcTextPaint == null) {
            this.vcTextPaint = new Paint(1);
        }
        this.vcTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.vcTextPaint.setColor(this.vcTextColor);
        this.vcTextPaint.setTextSize(this.vcTextSize);
        this.vcTextPaint.setTypeface(this.vcTextFont);
        this.vcTextPaint.setTextAlign(Paint.Align.CENTER);
        if (this.vcWrapperPaint == null) {
            this.vcWrapperPaint = new Paint(1);
        }
        this.vcWrapperPaint.setStyle(Paint.Style.STROKE);
        this.vcWrapperPaint.setColor(this.vcWrapperColor);
        this.vcWrapperPaint.setStrokeWidth(this.vcWrapperStrokeWidth);
    }

    public void clearVcText() {
        if (this.vcTextBuilder.length() == 0) {
            return;
        }
        StringBuilder sb = this.vcTextBuilder;
        sb.delete(0, sb.length());
        c cVar = this.onTextChangedListener;
        if (cVar != null) {
            cVar.d(this.vcTextBuilder.toString());
        }
        invalidate();
    }

    public float getVcDividerWidth() {
        return this.vcDividerWidth;
    }

    public int getVcNextWrapperColor() {
        return this.vcNextWrapperColor;
    }

    public String getVcText() {
        StringBuilder sb = this.vcTextBuilder;
        return sb != null ? sb.toString() : "";
    }

    public int getVcTextColor() {
        return this.vcTextColor;
    }

    public int getVcTextCount() {
        return this.vcTextCount;
    }

    public float getVcTextSize() {
        return this.vcTextSize;
    }

    public int getVcWrapperColor() {
        return this.vcWrapperColor;
    }

    public float getVcWrapperStrokeWidth() {
        return this.vcWrapperStrokeWidth;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();
        int length = this.vcTextBuilder.length();
        String str = "";
        int i = 0;
        for (int i2 = 0; i2 < this.vcTextBuilder.toString().length(); i2++) {
            str = str + "*";
        }
        while (i < this.vcTextCount) {
            r96 r96Var = this.vcWrapper;
            if (r96Var != null && (!r96Var.a() || i >= length)) {
                if (this.vcWrapper instanceof vy4) {
                    this.vcWrapperPaint.setColor(this.vcWrapperColor);
                    this.vcWrapperPaint.setStyle(Paint.Style.FILL);
                    this.vcWrapper.b(canvas, this.vcWrapperPaint, this.vcOuterRects[i], this.rectRadius, this.vcTextRects[i]);
                }
                if (this.hideBg) {
                    this.vcWrapperPaint.setColor(this.vcWrapperColor);
                } else {
                    this.vcWrapperPaint.setColor(i == length ? this.vcNextWrapperColor : i < length ? this.vcWrapperColor : this.vcEmptyWrapperColor);
                }
                this.vcWrapperPaint.setStyle(Paint.Style.STROKE);
                this.vcWrapper.b(canvas, this.vcWrapperPaint, this.vcOuterRects[i], this.rectRadius, this.vcTextRects[i]);
            }
            if (i < length) {
                if (this.hideInput) {
                    PointF pointF = this.vcTextPositions[i];
                    canvas.drawText("*", 0, 1, pointF.x, pointF.y, this.vcTextPaint);
                } else {
                    PointF pointF2 = this.vcTextPositions[i];
                    canvas.drawText(this.vcTextBuilder.toString(), i, i + 1, pointF2.x, pointF2.y, this.vcTextPaint);
                }
            }
            i++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            this.mWidth = (this.screenWidth * 2) / 3;
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.screenHeight / 5;
        }
        calculatePositions();
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (motionEvent.getAction() != 0) {
            return true;
        }
        KeyboardKt.c(this.dismissEdit, this, Keyboard$SHOW_FLAG.IMPLICIT, 0L);
        return true;
    }

    public void setAutoHideKeyboard(boolean z) {
        this.autoHideKeyboard = z;
    }

    public void setEditText(EditText editText) {
        this.dismissEdit = editText;
        editText.addTextChangedListener(new a());
    }

    public void setOnTextChangedListener(c cVar) {
        this.onTextChangedListener = cVar;
    }

    public void setVcDividerWidth(float f) {
        if (this.vcDividerWidth == f) {
            return;
        }
        this.vcDividerWidth = f;
        invalidate();
    }

    public void setVcNextWrapperColor(int i) {
        if (this.vcNextWrapperColor == i) {
            return;
        }
        this.vcNextWrapperColor = i;
        invalidate();
    }

    public void setVcText(String str) {
        if (str == null) {
            throw new NullPointerException("Code must not null!");
        }
        int length = str.length();
        int i = this.vcTextCount;
        if (length > i) {
            str = str.substring(0, i);
        }
        if (this.vcTextBuilder.toString().equals(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        this.vcTextBuilder = sb;
        sb.append(str);
        c cVar = this.onTextChangedListener;
        if (cVar != null) {
            cVar.d(this.vcTextBuilder.toString());
        }
        str.length();
        int i2 = this.vcTextCount;
        invalidate();
    }

    public void setVcTextColor(int i) {
        if (this.vcTextColor == i) {
            return;
        }
        this.vcTextColor = i;
        invalidate();
    }

    public void setVcTextCount(int i) {
        if (this.vcTextCount == i) {
            return;
        }
        this.vcTextCount = i;
        invalidate();
    }

    public void setVcTextFont(String str) {
        this.vcTextFont = Typeface.createFromAsset(getContext().getAssets(), str);
        invalidate();
    }

    public void setVcTextSize(float f) {
        if (this.vcTextSize == f) {
            return;
        }
        this.vcTextSize = f;
        invalidate();
    }

    public void setVcWrapper(r96 r96Var) {
        this.vcWrapper = r96Var;
        invalidate();
    }

    public void setVcWrapperColor(int i) {
        if (this.vcWrapperColor == i) {
            return;
        }
        this.vcWrapperColor = i;
        invalidate();
    }

    public void setVcWrapperStrokeWidth(float f) {
        if (this.vcWrapperStrokeWidth == f) {
            return;
        }
        this.vcWrapperStrokeWidth = f;
        invalidate();
    }

    public void setVcTextFont(Typeface typeface) {
        this.vcTextFont = typeface;
        invalidate();
    }

    public VerifyCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vcTextCount = 6;
        this.rectRadius = 0.0f;
        this.vcTextColor = -16777216;
        this.vcTextSize = 28.0f;
        this.vcTextFont = Typeface.defaultFromStyle(1);
        this.vcDividerWidth = 10.0f;
        this.hideBg = false;
        this.hideInput = false;
        this.vcWrapperColor = -2565928;
        this.vcNextWrapperColor = -16468830;
        this.vcEmptyWrapperColor = -2565928;
        this.vcWrapperStrokeWidth = 2.0f;
        this.autoHideKeyboard = true;
        init(context, attributeSet);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            VerifyCodeView.this.vcTextBuilder = new StringBuilder(charSequence);
            if (VerifyCodeView.this.onTextChangedListener != null) {
                VerifyCodeView.this.onTextChangedListener.d(VerifyCodeView.this.vcTextBuilder.toString());
            }
            VerifyCodeView.this.invalidate();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public void setOnAllFilledListener(b bVar) {
    }

    public VerifyCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vcTextCount = 6;
        this.rectRadius = 0.0f;
        this.vcTextColor = -16777216;
        this.vcTextSize = 28.0f;
        this.vcTextFont = Typeface.defaultFromStyle(1);
        this.vcDividerWidth = 10.0f;
        this.hideBg = false;
        this.hideInput = false;
        this.vcWrapperColor = -2565928;
        this.vcNextWrapperColor = -16468830;
        this.vcEmptyWrapperColor = -2565928;
        this.vcWrapperStrokeWidth = 2.0f;
        this.autoHideKeyboard = true;
        init(context, attributeSet);
    }
}

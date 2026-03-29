package com.zenmen.palmchat.loginnew.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.bq;
import com.kuaishou.weapon.p0.t;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.k86;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 M2\u00020\u0001:\u0003NOPB'\b\u0007\u0012\u0006\u0010G\u001a\u00020F\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010J\u001a\u00020\u0002¢\u0006\u0004\bK\u0010LJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0014J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u0019\u001a\u00020\u0004H\u0014J\b\u0010\u001a\u001a\u00020\u0004H\u0014J*\u0010 \u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0014J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0011H\u0016J\"\u0010'\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%H\u0014J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(R\u0014\u0010,\u001a\u00020+8\u0002X\u0082D¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010/R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010/R\u0016\u00108\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00102R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010/R\u0018\u0010:\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00105R\u001c\u0010<\u001a\b\u0018\u00010;R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006Q"}, d2 = {"Lcom/zenmen/palmchat/loginnew/view/VerificationCodeEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "", "maxLength", "", "setMaxLength", "Landroid/view/View;", "view", "hideSoftInput", "Landroid/graphics/Canvas;", "canvas", "drawBackground", "drawText", "drawCursor", "suspendBlink", "resumeBlink", "makeBlink", "", "shouldBlink", "id", "onTextContextMenuItem", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "onDraw", "onAttachedToWindow", "onDetachedFromWindow", "", "text", "start", "lengthBefore", "lengthAfter", "onTextChanged", "hasWindowFocus", "onWindowFocusChanged", "focused", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "Landroid/graphics/Rect;", "previouslyFocusedRect", "onFocusChanged", "Lcom/zenmen/palmchat/loginnew/view/VerificationCodeEditText$c;", bq.f.s, "setOnInputTextListener", "", "TAG", "Ljava/lang/String;", "mCodeLength", "I", "", "mCodeMargin", "F", "Landroid/graphics/drawable/Drawable;", "mCodeBackground", "Landroid/graphics/drawable/Drawable;", "mCodeWidth", "mCodeHeight", "mCodeSize", "mCursorDrawableRes", "mCursorDrawable", "Lcom/zenmen/palmchat/loginnew/view/VerificationCodeEditText$a;", "mBlink", "Lcom/zenmen/palmchat/loginnew/view/VerificationCodeEditText$a;", "mCursorVisible", "Z", "mCursorFlag", "inputTextListener", "Lcom/zenmen/palmchat/loginnew/view/VerificationCodeEditText$c;", "Landroid/graphics/Paint;", "textPaint", "Landroid/graphics/Paint;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", t.l, "c", "app_release"}, k = 1, mv = {1, 8, 0})
public final class VerificationCodeEditText extends AppCompatEditText {
    public static final long BLINK = 500;
    public static final int DEFAULT_CODE_HEIGHT = 150;
    public static final int DEFAULT_CODE_LENGTH = 6;
    public static final float DEFAULT_CODE_MARGIN = 20.0f;
    public static final float DEFAULT_CODE_SIZE = 14.0f;
    public static final int DEFAULT_CODE_WIDTH = 150;
    private final String TAG;
    private c inputTextListener;
    private a mBlink;
    private Drawable mCodeBackground;
    private int mCodeHeight;
    private int mCodeLength;
    private float mCodeMargin;
    private float mCodeSize;
    private int mCodeWidth;
    private Drawable mCursorDrawable;
    private int mCursorDrawableRes;
    private boolean mCursorFlag;
    private boolean mCursorVisible;
    private Paint textPaint;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/zenmen/palmchat/loginnew/view/VerificationCodeEditText$a;", "Ljava/lang/Runnable;", "", "run", "a", t.l, "", "Z", "mCancelled", "<init>", "(Lcom/zenmen/palmchat/loginnew/view/VerificationCodeEditText;)V", "app_release"}, k = 1, mv = {1, 8, 0})
    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public boolean mCancelled;

        public a() {
        }

        public final void a() {
            if (this.mCancelled) {
                return;
            }
            VerificationCodeEditText.this.removeCallbacks(this);
            this.mCancelled = true;
        }

        public final void b() {
            this.mCancelled = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mCancelled) {
                return;
            }
            VerificationCodeEditText.this.removeCallbacks(this);
            if (VerificationCodeEditText.this.shouldBlink()) {
                if (VerificationCodeEditText.this.getLayout() != null) {
                    VerificationCodeEditText.this.invalidate();
                }
                VerificationCodeEditText.this.postDelayed(this, 500L);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/zenmen/palmchat/loginnew/view/VerificationCodeEditText$c;", "", "app_release"}, k = 1, mv = {1, 8, 0})
    public interface c {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerificationCodeEditText(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void drawBackground(Canvas canvas) {
        Drawable drawable = this.mCodeBackground;
        if (drawable != null) {
            int iCoerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, getEditableText().length());
            int iSave = canvas.save();
            int i = this.mCodeLength;
            for (int i2 = 0; i2 < i; i2++) {
                drawable.setBounds(new Rect(0, 0, this.mCodeWidth, this.mCodeHeight));
                if (iCoerceAtLeast == i2) {
                    drawable.setState(new int[]{R.attr.state_selected});
                } else {
                    drawable.setState(new int[]{R.attr.state_enabled});
                }
                drawable.draw(canvas);
                canvas.translate(this.mCodeWidth + this.mCodeMargin, 0.0f);
            }
            canvas.restoreToCount(iSave);
        }
    }

    private final void drawCursor(Canvas canvas) {
        if (this.mCursorVisible) {
            boolean z = !this.mCursorFlag;
            this.mCursorFlag = z;
            if (z) {
                if (this.mCursorDrawable == null && this.mCursorDrawableRes != 0) {
                    this.mCursorDrawable = getContext().getDrawable(this.mCursorDrawableRes);
                }
                Drawable drawable = this.mCursorDrawable;
                if (drawable != null) {
                    int iCoerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, getEditableText().length());
                    int iSave = canvas.save();
                    drawable.getPadding(new Rect());
                    drawable.setBounds(new Rect(0, 0, drawable.getIntrinsicWidth(), (int) this.mCodeSize));
                    int i = this.mCodeWidth;
                    canvas.translate((((i + this.mCodeMargin) * iCoerceAtLeast) + (i / 2.0f)) - (drawable.getIntrinsicWidth() / 2.0f), (this.mCodeHeight - drawable.getBounds().height()) / 2.0f);
                    drawable.draw(canvas);
                    canvas.restoreToCount(iSave);
                }
            }
        }
    }

    private final void drawText(Canvas canvas) {
        int iSave = canvas.save();
        canvas.translate(0.0f, 0.0f);
        int currentTextColor = getCurrentTextColor();
        int length = getEditableText().length();
        for (int i = 0; i < length; i++) {
            float fMeasureText = this.textPaint.measureText(String.valueOf(getEditableText().charAt(i)));
            Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
            this.textPaint.getFontMetrics(fontMetrics);
            this.textPaint.setColor(currentTextColor);
            int i2 = this.mCodeWidth;
            canvas.drawText(String.valueOf(getEditableText().charAt(i)), (((i2 + this.mCodeMargin) * i) + (i2 / 2.0f)) - (fMeasureText / 2.0f), (this.mCodeHeight / 2.0f) - ((fontMetrics.top + fontMetrics.bottom) / 2.0f), this.textPaint);
        }
        canvas.restoreToCount(iSave);
    }

    private final void hideSoftInput(View view) {
        if (view != null) {
            Object systemService = view.getContext().getApplicationContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private final void makeBlink() {
        if (shouldBlink()) {
            if (this.mBlink == null) {
                this.mBlink = new a();
            }
            removeCallbacks(this.mBlink);
            postDelayed(this.mBlink, 500L);
            return;
        }
        a aVar = this.mBlink;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
    }

    private final void resumeBlink() {
        a aVar = this.mBlink;
        if (aVar != null) {
            if (aVar != null) {
                aVar.b();
            }
            makeBlink();
        }
    }

    private final void setMaxLength(int maxLength) {
        if (maxLength >= 0) {
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldBlink() {
        int selectionStart;
        int selectionEnd;
        return this.mCursorVisible && isFocused() && (selectionStart = getSelectionStart()) >= 0 && (selectionEnd = getSelectionEnd()) >= 0 && selectionStart == selectionEnd;
    }

    private final void suspendBlink() {
        a aVar = this.mBlink;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeBlink();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        suspendBlink();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        LogUtil.d(this.TAG, "onDraw:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()) + ",cursor:" + isCursorVisible());
        drawBackground(canvas);
        drawText(canvas);
        drawCursor(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
            makeBlink();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        if (mode == Integer.MIN_VALUE) {
            this.mCodeHeight = this.mCodeWidth;
            int i = this.mCodeLength;
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int) ((r5 * i) + ((i - 1) * this.mCodeMargin)), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCodeHeight, 1073741824));
            return;
        }
        float f = size;
        float f2 = this.mCodeMargin;
        int i2 = (int) ((f - (f2 * (r1 - 1))) / this.mCodeLength);
        this.mCodeWidth = i2;
        this.mCodeHeight = i2;
        setMeasuredDimension(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        Log.d(this.TAG, "onTextChanged() called with: text = " + ((Object) text) + ", start = " + start + ", lengthBefore = " + lengthBefore + ", lengthAfter = " + lengthAfter);
        if (text != null) {
            if (text.length() >= this.mCodeLength) {
                suspendBlink();
                hideSoftInput(this);
            } else if (text.length() + 1 == this.mCodeLength && lengthBefore == 1) {
                resumeBlink();
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int id) {
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus) {
            a aVar = this.mBlink;
            if (aVar != null) {
                aVar.b();
            }
            makeBlink();
            return;
        }
        a aVar2 = this.mBlink;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    public final void setOnInputTextListener(c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerificationCodeEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VerificationCodeEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerificationCodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "VerificationCodeEditTex";
        this.mCodeLength = 6;
        this.mCodeMargin = 20.0f;
        this.mCodeWidth = 150;
        this.mCodeHeight = 150;
        this.mCodeSize = 14.0f;
        this.textPaint = new Paint();
        Log.d("VerificationCodeEditTex", "init called");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.zenmen.palmchat.R.styleable.VerificationCodeEditText);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…VerificationCodeEditText)");
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            switch (index) {
                case 0:
                    this.mCodeBackground = typedArrayObtainStyledAttributes.getDrawable(index);
                    break;
                case 1:
                    this.mCursorDrawableRes = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    break;
                case 2:
                    this.mCursorVisible = typedArrayObtainStyledAttributes.getBoolean(index, false);
                    break;
                case 3:
                    this.mCodeLength = typedArrayObtainStyledAttributes.getInteger(index, 6);
                    break;
                case 4:
                    this.mCodeMargin = typedArrayObtainStyledAttributes.getDimension(index, 20.0f);
                    break;
                case 5:
                    this.mCodeSize = typedArrayObtainStyledAttributes.getDimension(index, 14.0f);
                    break;
                case 6:
                    this.mCodeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 150);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        if (this.mCodeLength > 0) {
            if (this.mCodeBackground != null) {
                if (this.mCursorVisible && this.mCursorDrawable == null && this.mCursorDrawableRes == 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(ContextCompat.getColor(context, com.zenmen.palmchat.R.color.colorAccent));
                    gradientDrawable.setSize(k86.e(context, 1.0f), 0);
                    this.mCursorDrawable = gradientDrawable;
                }
                this.textPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                this.textPaint.setTextSize(this.mCodeSize);
                setTextSize(1.0f);
                setLongClickable(false);
                setCursorVisible(false);
                setMaxLength(this.mCodeLength);
                setBackgroundColor(0);
                return;
            }
            throw new NullPointerException("code background drawable not allowed to be null!!!");
        }
        throw new IllegalArgumentException("code length must large than 0!!!");
    }
}

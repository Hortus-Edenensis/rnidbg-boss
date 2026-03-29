package com.zenmen.square.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.square.R$color;
import com.zenmen.square.R$styleable;
import defpackage.l50;
import defpackage.vl1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ExpandableTextView extends TextView {
    private static final int STATE_ELLIPSE = 1;
    private static final int STATE_UNELLIPSE = 2;
    public static Map<Long, Integer> TEXT = new HashMap();
    private SpannableString ellipseString;
    private long feedId;
    private int limitWidth;
    private int maxLine;
    private int maxLinesUpLimited;
    private CharSequence originContent;
    private int originLineCount;
    private int suffixColor;
    private boolean syncState;
    private SpannableString unEllipseString;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends LinkMovementMethod {
        public a() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            boolean zOnTouchEvent = super.onTouchEvent(textView, spannable, motionEvent);
            if (!zOnTouchEvent && motionEvent.getAction() == 1) {
                ViewParent parent = textView.getParent();
                if (parent instanceof ViewGroup) {
                    return ((ViewGroup) parent).performClick();
                }
            }
            return zOnTouchEvent;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            if (l50.a()) {
                return;
            }
            ExpandableTextView.this.unEllipseString();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(ExpandableTextView.this.suffixColor);
            textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, ExpandableTextView.this.getResources().getColor(R$color.white));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends ClickableSpan {
        public c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            ExpandableTextView.this.ellipseString();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(ExpandableTextView.this.suffixColor);
            textPaint.setUnderlineText(false);
            textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, ExpandableTextView.this.getResources().getColor(R$color.white));
        }
    }

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    private void calculateForLimitDisplay(CharSequence charSequence, long j) {
        StaticLayout staticLayout = new StaticLayout(charSequence, getPaint(), this.limitWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int iIntValue = TEXT.containsKey(Long.valueOf(j)) ? TEXT.get(Long.valueOf(j)).intValue() : 1;
        this.originLineCount = staticLayout.getLineCount();
        if (staticLayout.getLineCount() <= this.maxLine) {
            setText(charSequence);
            return;
        }
        if (iIntValue == 1 || !this.syncState) {
            ellipseString();
        } else {
            unEllipseString();
        }
        setMovementMethod(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ellipseString() {
        if (this.ellipseString == null) {
            int lineStart = new StaticLayout(this.originContent, getPaint(), this.limitWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineStart(this.maxLine) - 1;
            CharSequence charSequence = this.originContent;
            if (lineStart > 2) {
                lineStart -= 2;
            }
            CharSequence charSequenceSubSequence = charSequence.subSequence(0, lineStart);
            for (int length = charSequenceSubSequence.length(); length > 0; length--) {
                charSequenceSubSequence = charSequenceSubSequence.subSequence(0, length);
                if (new StaticLayout(((Object) charSequenceSubSequence) + "...全文", getPaint(), this.limitWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() <= this.maxLine) {
                    break;
                }
            }
            SpannableString spannableString = new SpannableString(((Object) charSequenceSubSequence) + "...全文");
            this.ellipseString = spannableString;
            spannableString.setSpan(new b(), this.ellipseString.length() - 2, this.ellipseString.length(), 33);
        }
        SpannableString spannableStringC = vl1.c(this.ellipseString, getContext(), vl1.i);
        this.ellipseString = spannableStringC;
        setText(spannableStringC);
        if (this.syncState) {
            TEXT.put(Long.valueOf(this.feedId), 1);
        }
    }

    private void initAttr(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        if (attributeSet == null || (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandableTextView)) == null) {
            return;
        }
        this.maxLine = typedArrayObtainStyledAttributes.getInt(R$styleable.ExpandableTextView_ellipse_maxLines, 3);
        this.maxLinesUpLimited = typedArrayObtainStyledAttributes.getInt(R$styleable.ExpandableTextView_maxLines_up_limited, Integer.MAX_VALUE);
        this.suffixColor = typedArrayObtainStyledAttributes.getColor(R$styleable.ExpandableTextView_suffix_color, Color.parseColor("#339cff"));
        this.syncState = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_sync_state, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unEllipseString() {
        if (this.unEllipseString == null) {
            String str = ((Object) this.originContent) + "  收起";
            StaticLayout staticLayout = new StaticLayout(str, getPaint(), this.limitWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            if (staticLayout.getLineCount() > this.originLineCount) {
                str = ((Object) this.originContent) + "\n收起";
            }
            int i = this.originLineCount;
            int i2 = this.maxLinesUpLimited;
            if (i > i2) {
                str = str.substring(0, staticLayout.getLineStart(i2 - 1) - 1).trim() + "\n收起";
            }
            SpannableString spannableString = new SpannableString(str);
            this.unEllipseString = spannableString;
            spannableString.setSpan(new c(), this.unEllipseString.length() - 2, this.unEllipseString.length(), 33);
        }
        SpannableString spannableStringC = vl1.c(this.unEllipseString, getContext(), vl1.i);
        this.unEllipseString = spannableStringC;
        setText(spannableStringC);
        if (this.syncState) {
            TEXT.put(Long.valueOf(this.feedId), 2);
        }
    }

    public void setOriginText(CharSequence charSequence, int i, long j) {
        this.originContent = charSequence;
        this.limitWidth = (i - getPaddingLeft()) - getPaddingRight();
        this.feedId = j;
        this.ellipseString = null;
        this.unEllipseString = null;
        calculateForLimitDisplay(charSequence, j);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.syncState = true;
        this.maxLine = 3;
        this.maxLinesUpLimited = Integer.MAX_VALUE;
        initAttr(context, attributeSet);
    }
}

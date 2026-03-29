package com.zenmen.square.comment.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.zenmen.square.R$color;
import com.zenmen.square.R$styleable;
import defpackage.pe6;
import defpackage.tn;
import defpackage.xl1;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RichTextView extends AppCompatTextView {
    private int emojiSize;
    private int linkColor;
    private a onSpanTopicCallBack;
    private b onSpanUrlCallBack;
    private int richMaxLength;
    private int topicColor;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends LinkMovementMethod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static LinkMovementMethod f16216a;

        public static LinkMovementMethod a() {
            if (f16216a == null) {
                f16216a = new c();
            }
            return f16216a;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int totalPaddingLeft = x - textView.getTotalPaddingLeft();
                int totalPaddingTop = y - textView.getTotalPaddingTop();
                int scrollX = totalPaddingLeft + textView.getScrollX();
                int scrollY = totalPaddingTop + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0 && action == 1) {
                    clickableSpanArr[0].onClick(textView);
                }
            }
            return true;
        }
    }

    public RichTextView(Context context) {
        super(context);
        int i = R$color.square_blue;
        this.topicColor = pe6.a(i);
        this.linkColor = pe6.a(i);
        this.richMaxLength = 256;
        init(context, null);
    }

    private Spannable getTopicText(String str, boolean z, int i, a aVar) {
        setMovementMethod(c.a());
        return new SpannableString(str);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.emojiSize = tn.b(context, 20);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SquareRichTextView);
        this.richMaxLength = typedArrayObtainStyledAttributes.getInteger(R$styleable.SquareRichTextView_square_maxTextLength, 256);
        int i = R$styleable.SquareRichTextView_square_topicColor;
        int i2 = R$color.square_blue;
        this.topicColor = typedArrayObtainStyledAttributes.getColor(i, pe6.a(i2));
        this.linkColor = typedArrayObtainStyledAttributes.getColor(R$styleable.SquareRichTextView_square_linkColor, pe6.a(i2));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static boolean isMobileSimple(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^[1]\\d{10}$", str);
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean isTopURL(String str) {
        return str.split("\\.").length >= 3;
    }

    private Spannable resolveUrlLogic(Spannable spannable, int i, boolean z, boolean z2, b bVar) {
        CharSequence text = getText();
        if (text instanceof Spannable) {
            int length = text.length();
            Spannable spannable2 = (Spannable) getText();
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable2.getSpans(0, length, URLSpan.class);
            if (uRLSpanArr.length > 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
                spannableStringBuilder.clearSpans();
                for (URLSpan uRLSpan : uRLSpanArr) {
                    String url = uRLSpan.getURL();
                    if (z && isNumeric(url.replace("tel:", ""))) {
                        if (z || isMobileSimple(url.replace("tel:", ""))) {
                            spannableStringBuilder.setSpan(new com.zenmen.square.comment.widget.a(uRLSpan.getURL(), i, bVar), spannable2.getSpanStart(uRLSpan), spannable2.getSpanEnd(uRLSpan), 34);
                        } else {
                            spannableStringBuilder.setSpan(new StyleSpan(0), spannable2.getSpanStart(uRLSpan), spannable2.getSpanEnd(uRLSpan), 34);
                        }
                    } else if (z2 && isTopURL(url.toLowerCase())) {
                        spannableStringBuilder.setSpan(new com.zenmen.square.comment.widget.a(uRLSpan.getURL(), i, bVar), spannable2.getSpanStart(uRLSpan), spannable2.getSpanEnd(uRLSpan), 34);
                    } else {
                        spannableStringBuilder.setSpan(new StyleSpan(0), spannable2.getSpanStart(uRLSpan), spannable2.getSpanEnd(uRLSpan), 34);
                    }
                }
                return spannableStringBuilder;
            }
        }
        return spannable;
    }

    public int getLinkColor() {
        return this.linkColor;
    }

    public a getOnSpanTopicCallBack() {
        return null;
    }

    public b getOnSpanUrlCallBack() {
        return null;
    }

    public int getTopicColor() {
        return this.topicColor;
    }

    public void insertIcon(String str) {
        if (getText().toString().length() + str.length() > this.richMaxLength) {
            return;
        }
        Drawable drawable = getResources().getDrawable(xl1.c(str));
        if (drawable == null) {
            return;
        }
        int i = this.emojiSize;
        drawable.setBounds(0, 0, i, i);
        ImageSpan imageSpan = new ImageSpan(drawable);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(imageSpan, 0, spannableString.length(), 33);
        int iMax = Math.max(getText().length(), 0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
        spannableStringBuilder.insert(iMax, (CharSequence) spannableString);
        setText(spannableStringBuilder);
    }

    public void setEmojiText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        SpannableString spannableString = new SpannableString(charSequence);
        xl1.a(getContext(), this.emojiSize, 0, spannableString);
        setText(spannableString);
    }

    public void setLinkColor(int i) {
        this.linkColor = i;
    }

    public void setRichText(String str) {
        setText(!TextUtils.isEmpty(str) ? getTopicText(str, true, this.topicColor, null) : new SpannableString(""));
        invalidate();
    }

    public void setTopicColor(int i) {
        this.topicColor = i;
    }

    public RichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = R$color.square_blue;
        this.topicColor = pe6.a(i);
        this.linkColor = pe6.a(i);
        this.richMaxLength = 256;
        init(context, attributeSet);
    }

    public RichTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = R$color.square_blue;
        this.topicColor = pe6.a(i2);
        this.linkColor = pe6.a(i2);
        this.richMaxLength = 256;
        init(context, attributeSet);
    }

    public void setOnSpanTopicCallBack(a aVar) {
    }

    public void setOnSpanUrlCallBack(b bVar) {
    }
}

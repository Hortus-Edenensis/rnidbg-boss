package com.zenmen.square.comment.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import com.zenmen.square.R$color;
import com.zenmen.square.R$string;
import com.zenmen.square.R$styleable;
import com.zenmen.square.comment.widget.MentionEditText;
import defpackage.pe6;
import defpackage.tn;
import defpackage.uy5;
import defpackage.xl1;
import defpackage.yn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RichEditText extends MentionEditText {
    private int colorTopic;
    private int emojiSize;

    public RichEditText(Context context) {
        super(context);
        this.colorTopic = pe6.a(R$color.square_color_red);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SquareRichEditText);
            int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.SquareRichEditText_square_richMaxLength, 256);
            String string = typedArrayObtainStyledAttributes.getString(R$styleable.SquareRichEditText_square_richEditColorTopic);
            this.richMaxLength = integer;
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.richMaxLength)});
            typedArrayObtainStyledAttributes.recycle();
            if (!TextUtils.isEmpty(string)) {
                this.colorTopic = Color.parseColor(string);
            }
        }
        this.emojiSize = tn.b(context, 20);
        setMentionTextColor(this.colorTopic);
    }

    public void addSpace() {
        if (getText().length() >= this.richMaxLength) {
            uy5.a(getContext().getString(R$string.square_comment_input_max_toast, Integer.valueOf(this.richMaxLength)));
            return;
        }
        int selectionStart = getSelectionStart();
        getEditableText().insert(selectionStart, " ");
        setSelection(selectionStart + 1);
    }

    public void addTopic(String str, boolean z) {
        int length;
        if (str == null) {
            return;
        }
        String strReplace = str.replace("#", "");
        if (getText().length() >= this.richMaxLength) {
            uy5.a(getContext().getString(R$string.square_comment_input_max_toast, Integer.valueOf(this.richMaxLength)));
            return;
        }
        int length2 = getText().length() + strReplace.length() + 1;
        int i = this.richMaxLength;
        if (length2 >= i && strReplace.length() > (length = (i - getText().length()) - 1)) {
            strReplace = strReplace.substring(0, length);
        }
        int selectionStart = getSelectionStart();
        Editable editableText = getEditableText();
        if (editableText.toString().endsWith("#")) {
            editableText.insert(selectionStart, strReplace + " ");
        } else if (z) {
            editableText.insert(selectionStart, "#" + strReplace + " ");
        } else if (getRangeArrayList() != null && !getRangeArrayList().isEmpty()) {
            MentionEditText.e eVar = getRangeArrayList().get(getRangeArrayList().size() - 1);
            editableText.replace(eVar.f16215a, eVar.b, "#" + strReplace + " ");
        }
        setSelection(getText().length());
    }

    public void addTopicChar() {
        if (getText().length() >= this.richMaxLength) {
            uy5.a(getContext().getString(R$string.square_comment_input_max_toast, Integer.valueOf(this.richMaxLength)));
            return;
        }
        int selectionStart = getSelectionStart();
        Editable editableText = getEditableText();
        if (!editableText.toString().endsWith("#")) {
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append("#");
                setSelection(getText().length());
            } else {
                editableText.insert(selectionStart, "#");
                setSelection(selectionStart + 1);
            }
        }
        yn.e(getContext(), this);
    }

    public void insertIcon(String str) {
        if (getText().toString().length() + str.length() > this.richMaxLength) {
            uy5.a(getContext().getString(R$string.square_comment_input_max_toast, Integer.valueOf(this.richMaxLength)));
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
        int iMax = Math.max(getSelectionStart(), 0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
        spannableStringBuilder.insert(iMax, (CharSequence) spannableString);
        setText(spannableStringBuilder);
        setSelection(iMax + spannableString.length());
    }

    public void setEmojiText(String str) {
        if (str == null) {
            str = "";
        }
        SpannableString spannableString = new SpannableString(str);
        xl1.a(getContext(), this.emojiSize, 0, spannableString);
        setText(spannableString);
    }

    public RichEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.colorTopic = pe6.a(R$color.square_color_red);
        init(context, attributeSet);
    }

    public RichEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.colorTopic = pe6.a(R$color.square_color_red);
        init(context, attributeSet);
    }
}

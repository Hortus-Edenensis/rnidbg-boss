package com.zenmen.palmchat.publish;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.ui.widget.expression.ExpressionViewPager;
import com.zenmen.palmchat.ui.widget.expression.a;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.g03;
import defpackage.k36;
import defpackage.mt2;
import defpackage.vl1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PublishEmojiView extends FrameLayout implements mt2.c {
    private static final int MAX_INPUT_LENGTH = 6000;
    private static final String TAG = "PublishEmojiView";
    private ImageView emojiFace;
    private com.zenmen.palmchat.ui.widget.expression.a expressionHelper;
    private LinearLayout mAddArea;
    private ExpressionViewPager mExpressionViewPager;
    private Handler mHandler;
    private LinearLayout mHeader;
    private EditText mInputBox;
    private c mInputMode;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a.c {
        public a() {
        }

        @Override // com.zenmen.palmchat.ui.widget.expression.a.c
        public void a() {
            PublishEmojiView.this.deleteFace();
        }

        @Override // com.zenmen.palmchat.ui.widget.expression.a.c
        public void b(String str, boolean z) {
            PublishEmojiView.this.appendInput(str, z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PublishEmojiView.this.mInputMode != c.TEXT) {
                if (PublishEmojiView.this.mInputMode == c.EMOJI) {
                    k36.h(PublishEmojiView.this.mInputBox);
                }
            } else {
                k36.f(PublishEmojiView.this.mInputBox);
                PublishEmojiView.this.onEmojiMode();
                g03.a(PublishEmojiView.this.mAddArea, g03.d());
                PublishEmojiView.this.expressionHelper.f();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c {
        NONE,
        TEXT,
        EMOJI
    }

    public PublishEmojiView(@NonNull Context context) {
        this(context, null);
    }

    private void initViews() {
        View.inflate(getContext(), R$layout.view_publish_emoji, this);
        this.mHeader = (LinearLayout) findViewById(R$id.view_header);
        this.mAddArea = (LinearLayout) findViewById(R$id.add_area);
        this.mExpressionViewPager = (ExpressionViewPager) findViewById(R$id.faceViewPager);
        this.expressionHelper = new com.zenmen.palmchat.ui.widget.expression.a(getContext(), this.mAddArea, null, new a());
        ImageView imageView = (ImageView) findViewById(R$id.face);
        this.emojiFace = imageView;
        imageView.setOnClickListener(new b());
        g03.a(this.mAddArea, g03.e(getContext()));
        this.expressionHelper.f();
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEmojiMode() {
        this.mInputMode = c.EMOJI;
        setVisibility(0);
        this.mAddArea.setVisibility(0);
        this.emojiFace.setImageResource(R$drawable.icon_input_keyboard);
    }

    private void onNoneMode() {
        this.mInputMode = c.NONE;
        setVisibility(8);
    }

    private void onTextMode() {
        this.mInputMode = c.TEXT;
        setVisibility(0);
        this.mAddArea.setVisibility(4);
        this.emojiFace.setImageResource(R$drawable.icon_input_face);
    }

    public void appendInput(String str, boolean z) {
        Editable editableText = this.mInputBox.getEditableText();
        EditText editText = this.mInputBox;
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        if (selectionStart < 0 || selectionEnd < 0) {
            selectionStart = editText.getText().length();
            selectionEnd = selectionStart;
        }
        int length = this.mInputBox.getText().length();
        editableText.replace(selectionStart, selectionEnd, str);
        editText.setText(vl1.c(editableText.toString(), getContext(), vl1.f));
        int length2 = str.length();
        if (length + length2 > 6000) {
            length2 = 6000 - length;
        }
        editText.setSelection(selectionStart + length2);
        this.mInputBox.requestFocus();
        if (z) {
            k36.h(this.mInputBox);
        }
    }

    public void deleteFace() {
        int selectionStart;
        if (TextUtils.isEmpty(this.mInputBox.getText()) || (selectionStart = this.mInputBox.getSelectionStart()) <= 0) {
            return;
        }
        String strSubstring = this.mInputBox.getText().toString().substring(0, selectionStart);
        int iLastIndexOf = strSubstring.lastIndexOf("[");
        if (iLastIndexOf == -1) {
            this.mInputBox.getEditableText().delete(selectionStart - 1, selectionStart);
        } else if (vl1.a(strSubstring.substring(iLastIndexOf, selectionStart).toString())) {
            this.mInputBox.getEditableText().delete(iLastIndexOf, selectionStart);
        } else {
            this.mInputBox.getEditableText().delete(selectionStart - 1, selectionStart);
        }
    }

    @Override // mt2.c
    public void onSoftKeyboardStatusChanged(int i, int i2) {
        if (i == 1 && this.mInputMode == c.TEXT) {
            onNoneMode();
        } else if (i == 0 && this.mInputMode == c.NONE) {
            onTextMode();
            g03.b(this.mAddArea, i2);
            g03.h(com.zenmen.palmchat.c.b(), i2);
        } else if (i == 0 && this.mInputMode == c.EMOJI) {
            onTextMode();
            g03.b(this.mAddArea, i2);
            g03.h(com.zenmen.palmchat.c.b(), i2);
        }
        if (i == 0) {
            LogUtil.i(TAG, "onSoftKeyboardStatusChanged height:" + i2);
        }
    }

    public void setInputBox(EditText editText) {
        this.mInputBox = editText;
    }

    public PublishEmojiView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PublishEmojiView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mInputMode = c.NONE;
        this.mHandler = new Handler();
        mt2.a((FrameworkBaseActivity) context, this);
        initViews();
    }
}

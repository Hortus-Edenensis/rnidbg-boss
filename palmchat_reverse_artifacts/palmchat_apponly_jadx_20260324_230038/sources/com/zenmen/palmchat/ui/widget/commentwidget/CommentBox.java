package com.zenmen.palmchat.ui.widget.commentwidget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.ui.widget.expression.a;
import defpackage.g03;
import defpackage.ii0;
import defpackage.ji0;
import defpackage.k36;
import defpackage.mt2;
import defpackage.vl1;
import defpackage.xk2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CommentBox extends FrameLayout implements mt2.c {
    public static final String FROM_MOMENTSFRAGMENT = "from_moment_fragment";
    public static final String FROM_SINGLE_ITEM_ACTIVITY = "from_single_item_fragment";
    private static final int MAX_INPUT_LENGTH = 1000;
    private com.zenmen.palmchat.ui.widget.expression.a expressionHelper;
    private boolean isShowing;
    private View mAddArea;
    private ImageView mFaceButton;
    private String mFrom;
    private TextView mHintTextView;
    private xk2 mIComment;
    public Input mInput;
    private EditText mInputContent;
    private TextView mSend;
    private long momentid;
    private f onCommentSendClickListener;

    /* JADX INFO: compiled from: SearchBox */
    public enum Input {
        TEXT,
        EXPRESSION
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a.c {
        public a() {
        }

        @Override // com.zenmen.palmchat.ui.widget.expression.a.c
        public void a() {
            CommentBox.this.deleteFace();
        }

        @Override // com.zenmen.palmchat.ui.widget.expression.a.c
        public void b(String str, boolean z) {
            CommentBox.this.appendInput(str, z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommentBox.this.switchToTextMode();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommentBox.access$300(CommentBox.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g03.a(CommentBox.this.mAddArea, g03.f(CommentBox.this.getContext()));
                CommentBox.this.mAddArea.setVisibility(0);
                CommentBox.this.mFaceButton.setImageResource(R$drawable.icon_input_keyboard);
                CommentBox.this.requestLayout();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CommentBox.this.setAddAreaInVisible();
                CommentBox.this.mFaceButton.setImageResource(R$drawable.icon_input_face);
                CommentBox.this.requestLayout();
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CommentBox.this.mAddArea.getVisibility() != 0) {
                CommentBox commentBox = CommentBox.this;
                commentBox.mInput = Input.EXPRESSION;
                k36.f(commentBox.mInputContent);
                view.postDelayed(new a(), 200L);
                return;
            }
            CommentBox commentBox2 = CommentBox.this;
            commentBox2.mInput = Input.TEXT;
            k36.h(commentBox2.mInputContent);
            view.postDelayed(new b(), 200L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
    }

    public CommentBox(Context context) {
        this(context, null);
    }

    public static /* synthetic */ f access$300(CommentBox commentBox) {
        commentBox.getClass();
        return null;
    }

    public static boolean containsNonBlankChar(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            for (int i = 0; i < charSequence.length(); i++) {
                if (!Character.isWhitespace(charSequence.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void initView(Context context) {
        View.inflate(context, R$layout.widget_comment_box, this);
        this.mAddArea = findViewById(R$id.add_area);
        this.mFaceButton = (ImageView) findViewById(R$id.face);
        this.expressionHelper = new com.zenmen.palmchat.ui.widget.expression.a(context, (LinearLayout) findViewById(R$id.faceLayout), null, new a());
        TextView textView = (TextView) findViewById(R$id.btn_send);
        this.mSend = textView;
        textView.setEnabled(false);
        this.mHintTextView = (TextView) findViewById(R$id.hint_msg_text_view);
        EditText editText = (EditText) findViewById(R$id.ed_comment_content);
        this.mInputContent = editText;
        editText.addTextChangedListener(new b());
        this.mInputContent.setOnClickListener(new c());
        this.mSend.setOnClickListener(new d());
        this.mFaceButton.setOnClickListener(new e());
        setVisibility(8);
        g03.a(this.mAddArea, g03.f(getContext()));
        this.expressionHelper.f();
        resetToInit();
    }

    private void resetToInit() {
        this.mFaceButton.setImageResource(R$drawable.icon_input_face);
        this.mAddArea.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddAreaInVisible() {
        this.mAddArea.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToTextMode() {
        this.mInputContent.requestFocus();
        this.mInput = Input.TEXT;
        setAddAreaInVisible();
        k36.h(this.mInputContent);
        this.mFaceButton.setImageResource(R$drawable.icon_input_face);
    }

    public void appendInput(String str, boolean z) {
        Editable editableText = this.mInputContent.getEditableText();
        EditText editText = this.mInputContent;
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        if (selectionStart < 0 || selectionEnd < 0) {
            selectionStart = editText.getText().length();
            selectionEnd = selectionStart;
        }
        int length = this.mInputContent.getText().length();
        editableText.replace(selectionStart, selectionEnd, str);
        editText.setText(vl1.c(editableText.toString(), getContext(), vl1.f));
        int length2 = str.length();
        if (length + length2 > 1000) {
            length2 = 1000 - length;
        }
        editText.setSelection(selectionStart + length2);
        this.mInputContent.requestFocus();
        if (z) {
            k36.h(this.mInputContent);
        }
    }

    public void clearCommentBox() {
        this.isShowing = false;
        k36.f(this.mInputContent);
        this.mInputContent.setText("");
    }

    public void clearCommentBoxOnFace() {
        this.isShowing = false;
        k36.f(this.mInputContent);
        this.mAddArea.setVisibility(8);
        this.mInputContent.setText("");
    }

    public void deleteCommentDraft(ii0 ii0Var) {
        ji0.d().b(ii0Var);
    }

    public void deleteFace() {
        int selectionStart;
        if (TextUtils.isEmpty(this.mInputContent.getText()) || (selectionStart = this.mInputContent.getSelectionStart()) <= 0) {
            return;
        }
        String strSubstring = this.mInputContent.getText().toString().substring(0, selectionStart);
        int iLastIndexOf = strSubstring.lastIndexOf("[");
        if (iLastIndexOf == -1) {
            this.mInputContent.getEditableText().delete(selectionStart - 1, selectionStart);
        } else if (vl1.a(strSubstring.substring(iLastIndexOf, selectionStart).toString())) {
            this.mInputContent.getEditableText().delete(iLastIndexOf, selectionStart);
        } else {
            this.mInputContent.getEditableText().delete(selectionStart - 1, selectionStart);
        }
    }

    public void dismissCommentBox(boolean z) {
        if (this.isShowing) {
            this.isShowing = false;
            String strTrim = this.mInputContent.getText().toString().trim();
            if (z && !TextUtils.isEmpty(strTrim)) {
                ii0 ii0Var = new ii0();
                ii0Var.c = Long.valueOf(this.momentid);
                xk2 xk2Var = this.mIComment;
                if (xk2Var != null) {
                    ii0Var.b = ((Comment) xk2Var.getData()).getId();
                }
                ii0Var.f18171a = strTrim;
                ji0.d().a(ii0Var);
            }
            k36.f(this.mInputContent);
            setVisibility(8);
        }
    }

    public void dismissCommentBoxWithoutGone() {
        this.isShowing = false;
        k36.f(this.mInputContent);
        this.mAddArea.setVisibility(8);
    }

    public void dismissCommentBoxWithoutGoneOnFace() {
        if (this.isShowing) {
            this.isShowing = false;
            resetToInit();
            k36.f(this.mInputContent);
        }
    }

    public int getCommentType() {
        return this.mIComment == null ? 16 : 17;
    }

    public f getOnCommentSendClickListener() {
        return null;
    }

    public void hideInoutMethod() {
        k36.f(this.mInputContent);
    }

    public void hideInoutMethodOnFace() {
        resetToInit();
        k36.f(this.mInputContent);
    }

    public boolean isReply() {
        xk2 xk2Var = this.mIComment;
        return (xk2Var == null || TextUtils.isEmpty(xk2Var.getReplyerName())) ? false : true;
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean isShowingExpression() {
        return this.isShowing && this.mInput == Input.EXPRESSION;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        dismissCommentBox(false);
        super.onDetachedFromWindow();
    }

    @Override // mt2.c
    public void onSoftKeyboardStatusChanged(int i, int i2) {
        if (i == 0) {
            setAddAreaInVisible();
        }
    }

    public void resetCommentInfo() {
        this.mIComment = null;
        this.mInputContent.setHint("评论");
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setMomentid(long j) {
        this.momentid = j;
    }

    public void showCommentBox(long j, @Nullable xk2 xk2Var, boolean z) {
        if (this.isShowing) {
            return;
        }
        this.isShowing = true;
        this.mIComment = xk2Var;
        if (xk2Var != null) {
            this.mInputContent.setHint("回复 " + this.mIComment.getCommentCreatorName() + ":");
        } else {
            this.mInputContent.setHint("评论");
        }
        if (z) {
            Long l = new Long(-1L);
            xk2 xk2Var2 = this.mIComment;
            if (xk2Var2 != null) {
                l = ((Comment) xk2Var2.getData()).getId();
            }
            String strC = ji0.d().c(Long.valueOf(j), l);
            if (strC != null) {
                this.mInputContent.setText(vl1.c(strC, getContext(), vl1.i));
                this.mInputContent.setSelection(strC.length());
            } else {
                this.mInputContent.setText((CharSequence) null);
            }
        } else {
            this.mInputContent.setText((CharSequence) null);
        }
        setMomentid(j);
        setVisibility(0);
        k36.i(this.mInputContent, 150L);
        switchToTextMode();
    }

    public void showCommentHint(@Nullable xk2 xk2Var) {
        this.mIComment = xk2Var;
        if (xk2Var != null) {
            this.mInputContent.setHint("回复 " + this.mIComment.getCommentCreatorName() + ":");
        }
    }

    public void toggleCommentBox(long j, @Nullable xk2 xk2Var, boolean z) {
        if (this.isShowing) {
            dismissCommentBox(true);
        } else {
            showCommentBox(j, xk2Var, z);
        }
    }

    public CommentBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInput = Input.TEXT;
        mt2.a((FrameworkBaseActivity) context, this);
        initView(context);
    }

    public void appendInput(String str) {
        appendInput(str, true);
    }

    public void setOnCommentSendClickListener(f fVar) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0 || !CommentBox.containsNonBlankChar(editable)) {
                CommentBox.this.mSend.setEnabled(false);
            } else {
                CommentBox.this.mSend.setEnabled(true);
            }
            if (editable.length() <= 1000) {
                CommentBox.this.mHintTextView.setVisibility(4);
                return;
            }
            CommentBox.this.mHintTextView.setVisibility(0);
            CommentBox.this.mHintTextView.setText(Integer.valueOf(1000 - editable.length()).toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}

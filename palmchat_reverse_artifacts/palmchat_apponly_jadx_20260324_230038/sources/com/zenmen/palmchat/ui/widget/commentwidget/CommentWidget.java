package com.zenmen.palmchat.ui.widget.commentwidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import com.zenmen.palmchat.friendcircle.R$color;
import com.zenmen.palmchat.friendcircle.bean.SquareSimpleComment;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.az2;
import defpackage.dn0;
import defpackage.fg6;
import defpackage.hi0;
import defpackage.og5;
import defpackage.r64;
import defpackage.vl1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CommentWidget extends TextView {
    private static final String TAG = "CommentWidget";
    public static int allPadding = a46.b(c.b(), 20.0f);
    private static final int textSize = 14;
    private Context mContext;
    private r64 mOnCommentUserClickListener;
    og5 mSpannableStringBuilderCompat;
    private int textColor;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            CommentWidget.this.removeOnLayoutChangeListener(this);
            CommentWidget commentWidget = CommentWidget.this;
            commentWidget.setText(a46.e(commentWidget.getText(), CommentWidget.this.getTextSize(), CommentWidget.this.getMeasuredWidth() - CommentWidget.allPadding));
        }
    }

    public CommentWidget(Context context) {
        this(context, null);
        this.mContext = context;
    }

    private void createCommentStringBuilder(@NonNull SquareSimpleComment squareSimpleComment) {
        String nameForShow;
        boolean zQ;
        ContactExtBean contactExtBean;
        ContactInfoItem contactInfoItemB;
        ContactInfoItem contactInfoItemA;
        og5 og5Var = this.mSpannableStringBuilderCompat;
        if (og5Var == null) {
            this.mSpannableStringBuilderCompat = new og5();
        } else {
            og5Var.clear();
            this.mSpannableStringBuilderCompat.clearSpans();
        }
        String str = ": " + squareSimpleComment.content + "\u0000";
        if (TextUtils.isEmpty(squareSimpleComment.fromUid) || (contactInfoItemA = dn0.a(squareSimpleComment.fromUid)) == null) {
            nameForShow = null;
            zQ = false;
        } else {
            nameForShow = contactInfoItemA.getNameForShow();
            zQ = fg6.q(fg6.g(contactInfoItemA.getExt()));
        }
        if (TextUtils.isEmpty(nameForShow) && !TextUtils.isEmpty(squareSimpleComment.exFromUid) && (contactInfoItemB = dn0.b(squareSimpleComment.exFromUid)) != null) {
            nameForShow = contactInfoItemB.getNameForShow();
            zQ = fg6.q(fg6.g(contactInfoItemB.getExt()));
        }
        if (!zQ && (contactExtBean = (ContactExtBean) az2.a(squareSimpleComment.userExt, ContactExtBean.class)) != null) {
            zQ = fg6.q(fg6.g(contactExtBean));
        }
        if (TextUtils.isEmpty(nameForShow)) {
            nameForShow = squareSimpleComment.nickname;
        }
        if (zQ) {
            this.mSpannableStringBuilderCompat.append(nameForShow, new ForegroundColorSpan(Color.parseColor("#FF463C")), 0);
        } else {
            this.mSpannableStringBuilderCompat.append(nameForShow, new ForegroundColorSpan(Color.parseColor("#666666")), 0);
        }
        this.mSpannableStringBuilderCompat.a(0, new StyleSpan(1), 0);
        this.mSpannableStringBuilderCompat.append(str);
        int measuredWidth = getMeasuredWidth();
        SpannableString spannableStringC = vl1.c(this.mSpannableStringBuilderCompat, this.mContext, vl1.h);
        if (measuredWidth > 0) {
            setText(a46.e(spannableStringC, getTextSize(), measuredWidth - allPadding));
        } else {
            setText(spannableStringC);
        }
    }

    public SquareSimpleComment getData() throws ClassCastException {
        return (SquareSimpleComment) getTag();
    }

    public r64 getOnCommentUserClickListener() {
        return this.mOnCommentUserClickListener;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        LogUtil.i(TAG, "onTouchEvent: " + motionEvent.getAction());
        return super.onTouchEvent(motionEvent);
    }

    public void setCommentText(SquareSimpleComment squareSimpleComment) {
        if (squareSimpleComment == null) {
            return;
        }
        try {
            setTag(squareSimpleComment);
            createCommentStringBuilder(squareSimpleComment);
        } catch (NullPointerException e) {
            e.printStackTrace();
            Log.e(TAG, e.toString());
        }
    }

    public void setOnCommentUserClickListener(r64 r64Var) {
        this.mOnCommentUserClickListener = r64Var;
        og5 og5Var = this.mSpannableStringBuilderCompat;
        if (og5Var != null) {
            hi0[] hi0VarArr = (hi0[]) og5Var.getSpans(0, og5Var.length(), hi0.class);
            if (hi0VarArr == null || hi0VarArr.length <= 0) {
                return;
            }
            for (hi0 hi0Var : hi0VarArr) {
                hi0Var.c(this.mOnCommentUserClickListener);
            }
        }
    }

    public CommentWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.textColor = Color.parseColor("#6683C0");
        setHighlightColor(-16777216);
        setTextColor(getResources().getColor(R$color.Gb));
        setTextSize(1, 14.0f);
        addOnLayoutChangeListener(new a());
    }

    @TargetApi(21)
    public CommentWidget(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.textColor = Color.parseColor("#6683C0");
        setHighlightColor(-16777216);
        setTextColor(getResources().getColor(R$color.Gb));
        setTextSize(14.0f);
    }
}

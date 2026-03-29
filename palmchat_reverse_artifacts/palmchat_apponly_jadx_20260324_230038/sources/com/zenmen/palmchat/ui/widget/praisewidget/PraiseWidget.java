package com.zenmen.palmchat.ui.widget.praisewidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.LruCache;
import android.widget.TextView;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$styleable;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.ui.widget.praisewidget.a;
import defpackage.dn0;
import defpackage.es0;
import defpackage.me1;
import defpackage.og5;
import defpackage.zc0;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PraiseWidget extends TextView {
    private static final String TAG = "PraiseWidget";
    private static final LruCache<String, og5> praiseCache = new a(50);
    private int clickBg;
    private int iconRes;
    private int textColor;
    private int textSize;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends LruCache<String, og5> {
        public a(int i) {
            super(i);
        }

        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, og5 og5Var) {
            return 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Html.ImageGetter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f15642a;

        public b(Context context) {
            this.f15642a = context;
        }

        @Override // android.text.Html.ImageGetter
        public Drawable getDrawable(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Drawable drawable = this.f15642a.getResources().getDrawable(Integer.parseInt(str));
            if (drawable != null) {
                int iB = me1.b(this.f15642a, 13);
                drawable.setBounds(0, 0, iB, iB);
            }
            return drawable;
        }
    }

    public PraiseWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void createSpanStringBuilder(List<Comment> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        String string = Integer.toString(list.hashCode() + list.size());
        CharSequence charSequence = (og5) praiseCache.get(string);
        if (charSequence == null) {
            Spanned imageSpan = getImageSpan(getContext(), this.iconRes);
            og5 og5Var = new og5(imageSpan);
            ImageSpan[] imageSpanArr = (ImageSpan[]) imageSpan.getSpans(0, imageSpan.length(), ImageSpan.class);
            if (imageSpanArr != null) {
                for (ImageSpan imageSpan2 : imageSpanArr) {
                    og5Var.setSpan(new es0(imageSpan2.getDrawable()), imageSpan.getSpanStart(imageSpan2), imageSpan.getSpanEnd(imageSpan2), 33);
                }
            }
            og5Var.append(" ");
            for (int i = 0; i < list.size(); i++) {
                com.zenmen.palmchat.ui.widget.praisewidget.a aVarF = new a.b(getContext(), list.get(i)).i(this.textSize).h(this.textColor).g(this.clickBg).f();
                try {
                    String nickNameFromLikeItem = getNickNameFromLikeItem(list.get(i));
                    if (i != list.size() - 1) {
                        og5Var.append(nickNameFromLikeItem + ", ", aVarF, 0);
                    } else {
                        og5Var.append(nickNameFromLikeItem + "\u0000", aVarF, 0);
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    Log.e(TAG, "praiseUserInfo是空的哦");
                }
            }
            praiseCache.put(string, og5Var);
            charSequence = og5Var;
        }
        setText(charSequence);
    }

    private static Spanned getImageSpan(Context context, int i) {
        return Html.fromHtml("<img src='" + i + "'/> ", new b(context), null);
    }

    private String getNickNameFromLikeItem(Comment comment) {
        ContactInfoItem contactInfoItemA = dn0.a(comment.getFromUid());
        if (contactInfoItemA != null) {
            return contactInfoItemA.getNameForShow();
        }
        return null;
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PraiseWidget);
        this.textColor = typedArrayObtainStyledAttributes.getColor(R$styleable.PraiseWidget_font_color, -10058816);
        this.textSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.PraiseWidget_font_size, 14);
        this.clickBg = typedArrayObtainStyledAttributes.getColor(R$styleable.PraiseWidget_click_bg_color, 0);
        this.iconRes = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PraiseWidget_like_icon, R$drawable.ic_feed_likes);
        typedArrayObtainStyledAttributes.recycle();
        setMovementMethod(LinkMovementMethod.getInstance());
        setOnTouchListener(new zc0.a());
        setTextSize(this.textSize);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LruCache<String, og5> lruCache = praiseCache;
        lruCache.evictAll();
        if (lruCache.size() == 0) {
            Log.d(TAG, "clear cache success!");
        }
    }

    public void setDatas(List<Comment> list) {
        createSpanStringBuilder(list);
    }

    public PraiseWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.textColor = -10058816;
        this.iconRes = R$drawable.ic_feed_likes;
        this.textSize = 14;
        this.clickBg = 0;
        init(context, attributeSet);
    }

    @TargetApi(21)
    public PraiseWidget(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.textColor = -10058816;
        this.iconRes = R$drawable.ic_feed_likes;
        this.textSize = 14;
        this.clickBg = 0;
        init(context, attributeSet);
    }
}

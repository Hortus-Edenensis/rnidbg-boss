package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.framework.R$styleable;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class UserLevelView extends RelativeLayout {
    public static final int STYLE_NORMAL = 1;
    public static final int STYLE_SMALL = 2;
    public static final int TYPE_CHARM_LEVEL = 2;
    public static final int TYPE_FANS_LEVEL = 3;
    public static final int TYPE_RICH_LEVEL = 1;
    protected AppCompatImageView bgView;
    protected int levelType;
    protected int style;
    protected AppCompatTextView textView;

    public UserLevelView(Context context) {
        this(context, null);
    }

    public static int getCharmLevelIconRes(int i) {
        return i <= 1 ? R$drawable.ic_charm_level_icon_1 : i <= 4 ? R$drawable.ic_charm_level_icon_2_4 : i <= 9 ? R$drawable.ic_charm_level_icon_5_9 : i <= 14 ? R$drawable.ic_charm_level_icon_10_14 : i <= 19 ? R$drawable.ic_charm_level_icon_15_19 : i <= 24 ? R$drawable.ic_charm_level_icon_20_24 : R$drawable.ic_charm_level_icon_25_29;
    }

    public static int getFansLevelIconRes(int i) {
        return R$drawable.ic_fans_level_icon_card;
    }

    public static int getLevelIconRes(int i, int i2) {
        return i2 == 1 ? getRichLevelIconRes(i) : i2 == 2 ? getCharmLevelIconRes(i) : getFansLevelIconRes(i);
    }

    public static int getRichLevelIconRes(int i) {
        return i <= 1 ? R$drawable.ic_rich_level_icon_1 : i <= 4 ? R$drawable.ic_rich_level_icon_2_4 : i <= 9 ? R$drawable.ic_rich_level_icon_5_9 : i <= 14 ? R$drawable.ic_rich_level_icon_10_14 : i <= 19 ? R$drawable.ic_rich_level_icon_15_19 : i <= 24 ? R$drawable.ic_rich_level_icon_20_24 : i <= 29 ? R$drawable.ic_rich_level_icon_25_29 : R$drawable.ic_rich_level_icon_30_34;
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.user_level);
        if (typedArrayObtainStyledAttributes == null) {
            return;
        }
        this.levelType = typedArrayObtainStyledAttributes.getInt(R$styleable.user_level_type, 1);
        this.style = typedArrayObtainStyledAttributes.getInt(R$styleable.user_level_style, 1);
        setLevelType(this.levelType);
        float dimension = typedArrayObtainStyledAttributes.getDimension(R$styleable.user_level_textSize, me1.b(context, 8));
        int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.user_level_textLeftMargin, me1.b(context, 22));
        if ((typedArrayObtainStyledAttributes.getInt(R$styleable.user_level_textStyle, 0) & 1) == 1) {
            this.textView.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.textView.setTypeface(Typeface.DEFAULT);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.leftMargin = dimension2;
        this.textView.setLayoutParams(layoutParams);
        this.textView.setTextSize(0, dimension);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R$layout.layout_rich_level, (ViewGroup) this, true);
        this.bgView = (AppCompatImageView) findViewById(R$id.iv_bg);
        this.textView = (AppCompatTextView) findViewById(R$id.tv_level_desc);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setLevel(int i) {
        int i2;
        int i3 = this.levelType;
        if (i3 == 1) {
            i2 = i <= 34 ? i : 34;
        }
        if (i3 == 2 && i2 > 29) {
            i2 = 29;
        }
        if (i2 < 1) {
            i = 1;
            i2 = 1;
        }
        this.bgView.setImageLevel(i2);
        setLevelDesc(String.format("Lv.%d", Integer.valueOf(i)));
    }

    public void setLevelDesc(String str) {
        this.textView.setText(str);
    }

    public void setLevelType(int i) {
        this.levelType = i;
        if (i == 1) {
            this.bgView.setImageResource(this.style == 1 ? R$drawable.rich_level_res : R$drawable.rich_level_res_small);
        } else if (i == 2) {
            this.bgView.setImageResource(this.style == 1 ? R$drawable.charm_level_res : R$drawable.charm_level_res_small);
        }
    }

    public UserLevelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UserLevelView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public UserLevelView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.levelType = 1;
        this.style = 1;
        initView(context);
        initAttrs(context, attributeSet);
    }
}

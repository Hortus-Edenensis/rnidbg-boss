package com.zenmen.palmchat.contacts.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserDetailLevelViewV2 extends FrameLayout {
    private ImageView iconView;
    private TextView levelView;
    private View rootView;
    private int type;

    public UserDetailLevelViewV2(@NonNull Context context) {
        this(context, null);
    }

    public static int getCharmLevelBgResId(int i) {
        return i >= 2 ? R.drawable.shape_user_detail_charm_bg_2 : R.drawable.shape_user_detail_charm_bg;
    }

    public static int getCharmLevelIconResId(int i) {
        return i >= 25 ? R.drawable.ic_user_level_charm_25 : i >= 20 ? R.drawable.ic_user_level_charm_20 : i >= 15 ? R.drawable.ic_user_level_charm_15 : i >= 10 ? R.drawable.ic_user_level_charm_10 : i >= 5 ? R.drawable.ic_user_level_charm_5 : i >= 2 ? R.drawable.ic_user_level_charm_2 : R.drawable.ic_user_level_charm_1;
    }

    public static int getRichLevelBgResId(int i) {
        return i >= 5 ? R.drawable.shape_user_detail_rich_bg_5 : i >= 2 ? R.drawable.shape_user_detail_rich_bg_2 : R.drawable.shape_user_detail_rich_bg;
    }

    public static int getRichLevelIconResId(int i) {
        return i >= 30 ? R.drawable.ic_rich_level_icon_30_34 : i >= 25 ? R.drawable.ic_rich_level_icon_25_29 : i >= 20 ? R.drawable.ic_rich_level_icon_20_24 : i >= 15 ? R.drawable.ic_user_level_rich_15 : i >= 10 ? R.drawable.ic_user_level_rich_10 : i >= 5 ? R.drawable.ic_user_level_rich_5 : i >= 2 ? R.drawable.ic_user_level_rich_2 : R.drawable.ic_user_level_rich_1;
    }

    private void init(Context context) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.layout_user_detail_level_view_v2, (ViewGroup) this, true);
        this.iconView = (ImageView) findViewById(R.id.level_icon);
        this.levelView = (TextView) findViewById(R.id.level_text);
    }

    public void setLevel(int i) {
        if (i > 0) {
            this.rootView.setBackgroundResource(this.type == 0 ? getRichLevelBgResId(i) : getCharmLevelBgResId(i));
            this.iconView.setImageResource(this.type == 0 ? getRichLevelIconResId(i) : getCharmLevelIconResId(i));
            int i2 = this.type;
            if (i2 == 0) {
                if (i == 1) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("财富 1");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#666666")), 3, 4, 18);
                    this.levelView.setText(spannableStringBuilder);
                } else {
                    this.levelView.setText("财富 " + i);
                }
            } else if (i2 == 1) {
                if (i == 1) {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("魅力 1");
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(Color.parseColor("#666666")), 3, 4, 18);
                    this.levelView.setText(spannableStringBuilder2);
                } else {
                    this.levelView.setText("魅力 " + i);
                }
            }
            if (i >= 5) {
                int i3 = this.type;
                if (i3 == 0) {
                    this.levelView.setTextColor(Color.parseColor("#fda230"));
                } else if (i3 == 1) {
                    this.levelView.setTextColor(Color.parseColor("#ff77b7"));
                }
            } else if (i >= 2) {
                int i4 = this.type;
                if (i4 == 0) {
                    this.levelView.setTextColor(Color.parseColor("#28c10f"));
                } else if (i4 == 1) {
                    this.levelView.setTextColor(Color.parseColor("#ff77b7"));
                }
            } else {
                int i5 = this.type;
                if (i5 == 0 || i5 == 1) {
                    this.levelView.setTextColor(Color.parseColor("#66222222"));
                }
            }
            setVisibility(0);
        }
    }

    public UserDetailLevelViewV2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UserDetailLevelViewV2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UserDetailLevelView);
            this.type = typedArrayObtainStyledAttributes.getInteger(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
        init(context);
    }
}

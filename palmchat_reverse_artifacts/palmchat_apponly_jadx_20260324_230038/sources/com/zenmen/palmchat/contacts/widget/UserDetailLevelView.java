package com.zenmen.palmchat.contacts.widget;

import android.content.Context;
import android.content.res.TypedArray;
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
public class UserDetailLevelView extends FrameLayout {
    private TextView NameView;
    private ImageView iconView;
    private TextView levelView;
    private View rootView;
    private int type;

    public UserDetailLevelView(@NonNull Context context) {
        this(context, null);
    }

    public static int getCharmLevelBgResId(int i) {
        return i >= 20 ? R.drawable.bg_user_level_charm_20 : i >= 5 ? R.drawable.bg_user_level_charm_5 : i >= 2 ? R.drawable.bg_user_level_charm_2 : R.drawable.bg_user_level_default;
    }

    public static int getCharmLevelIconResId(int i) {
        return i >= 25 ? R.drawable.ic_user_level_charm_25 : i >= 20 ? R.drawable.ic_user_level_charm_20 : i >= 15 ? R.drawable.ic_user_level_charm_15 : i >= 10 ? R.drawable.ic_user_level_charm_10 : i >= 5 ? R.drawable.ic_user_level_charm_5 : i >= 2 ? R.drawable.ic_user_level_charm_2 : R.drawable.ic_user_level_charm_1;
    }

    public static int getRichLevelBgResId(int i) {
        return i >= 20 ? R.drawable.bg_user_level_rich_20 : i >= 5 ? R.drawable.bg_user_level_rich_5 : i >= 2 ? R.drawable.bg_user_level_rich_2 : R.drawable.bg_user_level_default;
    }

    public static int getRichLevelIconResId(int i) {
        return i >= 30 ? R.drawable.ic_rich_level_icon_30_34 : i >= 25 ? R.drawable.ic_rich_level_icon_25_29 : i >= 20 ? R.drawable.ic_rich_level_icon_20_24 : i >= 15 ? R.drawable.ic_user_level_rich_15 : i >= 10 ? R.drawable.ic_user_level_rich_10 : i >= 5 ? R.drawable.ic_user_level_rich_5 : i >= 2 ? R.drawable.ic_user_level_rich_2 : R.drawable.ic_user_level_rich_1;
    }

    private void init(Context context) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.layout_user_detail_level_view, (ViewGroup) this, true);
        this.iconView = (ImageView) findViewById(R.id.level_icon);
        this.levelView = (TextView) findViewById(R.id.level_text);
        TextView textView = (TextView) findViewById(R.id.name);
        this.NameView = textView;
        int i = this.type;
        if (i == 0) {
            textView.setText("财富等级");
        } else if (i == 1) {
            textView.setText("魅力等级");
        }
    }

    public void setLevel(int i) {
        if (i > 0) {
            this.rootView.setBackgroundResource(this.type == 0 ? getRichLevelBgResId(i) : getCharmLevelBgResId(i));
            this.iconView.setImageResource(this.type == 0 ? getRichLevelIconResId(i) : getCharmLevelIconResId(i));
            this.levelView.setText(i + "");
            setVisibility(0);
        }
    }

    public UserDetailLevelView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UserDetailLevelView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UserDetailLevelView);
            this.type = typedArrayObtainStyledAttributes.getInteger(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
        init(context);
    }
}

package com.zenmen.palmchat.contacts.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import defpackage.k86;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UpgradeCharmView extends FrameLayout {
    private ImageView iconView;
    private TextView levelView;
    private int type;

    public UpgradeCharmView(@NonNull Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_upgrade_charm_level_view, (ViewGroup) this, true);
        this.iconView = (ImageView) findViewById(R.id.level_icon);
        TextView textView = (TextView) findViewById(R.id.level_text);
        this.levelView = textView;
        int i = this.type;
        if (i != 0) {
            if (i == 1) {
                textView.setBackgroundResource(R.drawable.upgrade_charm_level_bg);
            }
        } else {
            ViewGroup.LayoutParams layoutParams = this.iconView.getLayoutParams();
            layoutParams.width = k86.e(getContext(), 40.0f);
            layoutParams.height = k86.e(getContext(), 40.0f);
            this.iconView.setLayoutParams(layoutParams);
            this.levelView.setBackgroundResource(R.drawable.upgrade_charm_level_before_bg);
        }
    }

    public void setLevel(int i) {
        this.iconView.setImageResource(UserDetailLevelView.getCharmLevelIconResId(i));
        this.levelView.setText("Lv." + i);
        setVisibility(0);
    }

    public UpgradeCharmView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UpgradeCharmView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UpgradeCharmView);
            this.type = typedArrayObtainStyledAttributes.getInteger(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
        init(context);
    }
}

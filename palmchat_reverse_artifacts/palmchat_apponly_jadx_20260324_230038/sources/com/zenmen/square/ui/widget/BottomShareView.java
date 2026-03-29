package com.zenmen.square.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import defpackage.ai5;
import defpackage.qj5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class BottomShareView extends ConstraintLayout {
    public static final int FROM_PAGE_MULTI = 2;
    public static final int FROM_PAGE_SINGLE = 1;
    public static final int TYPE_BLACK = 2;
    public static final int TYPE_WHITE = 1;
    private View dividerLine;
    private ImageView friendChoice;
    private View friendItemView;
    private int pageFrom;
    private ImageView squareChoice;
    private View squareItemView;
    private AppCompatTextView tvBottom1;
    private AppCompatTextView tvBottom2;
    private AppCompatTextView tvTop1;
    private AppCompatTextView tvTop2;

    public BottomShareView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R$layout.bottom_square_share_view, (ViewGroup) this, true);
        this.tvTop1 = (AppCompatTextView) findViewById(R$id.tv_top_1);
        this.tvTop2 = (AppCompatTextView) findViewById(R$id.tv_top_2);
        this.tvBottom1 = (AppCompatTextView) findViewById(R$id.tv_bottom_1);
        this.tvBottom2 = (AppCompatTextView) findViewById(R$id.tv_bottom_2);
        this.dividerLine = findViewById(R$id.divider_line);
        this.squareChoice = (ImageView) findViewById(R$id.square_choice);
        this.friendChoice = (ImageView) findViewById(R$id.moment_choice);
        this.squareItemView = findViewById(R$id.item_share_square);
        this.friendItemView = findViewById(R$id.item_share_moment);
        ai5.k().m();
        this.squareChoice.setSelected(true);
        this.squareItemView.setOnClickListener(new View.OnClickListener() { // from class: mu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19367a.lambda$initView$0(view);
            }
        });
        this.friendItemView.setOnClickListener(new View.OnClickListener() { // from class: nu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19602a.lambda$initView$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        this.squareChoice.setSelected(true);
        this.friendChoice.setSelected(false);
        qj5.v(this.pageFrom, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(View view) {
        this.squareChoice.setSelected(false);
        this.friendChoice.setSelected(true);
        qj5.v(this.pageFrom, 2);
    }

    public int getShareTarget() {
        return (!this.squareChoice.isSelected() && this.friendChoice.isSelected()) ? 2 : 0;
    }

    public void setBgColorType(int i) {
        if (i == 1) {
            this.tvTop1.setTextColor(Color.parseColor("#222222"));
            this.tvTop2.setTextColor(Color.parseColor("#222222"));
            this.tvBottom1.setTextColor(Color.parseColor("#999999"));
            this.tvBottom2.setTextColor(Color.parseColor("#999999"));
            ImageView imageView = this.squareChoice;
            int i2 = R$drawable.selector_square_share_icon_white;
            imageView.setImageResource(i2);
            this.friendChoice.setImageResource(i2);
            this.tvBottom1.setAlpha(1.0f);
            this.tvBottom2.setAlpha(1.0f);
            this.dividerLine.setAlpha(1.0f);
            return;
        }
        this.tvTop1.setTextColor(Color.parseColor("#ffffff"));
        this.tvTop2.setTextColor(Color.parseColor("#ffffff"));
        this.tvBottom1.setTextColor(Color.parseColor("#ffffff"));
        this.tvBottom2.setTextColor(Color.parseColor("#ffffff"));
        ImageView imageView2 = this.squareChoice;
        int i3 = R$drawable.selector_square_share_icon_black;
        imageView2.setImageResource(i3);
        this.friendChoice.setImageResource(i3);
        this.tvBottom1.setAlpha(0.75f);
        this.tvBottom2.setAlpha(0.75f);
        this.dividerLine.setAlpha(0.36f);
    }

    public void setPageFrom(int i) {
        this.pageFrom = i;
    }

    public BottomShareView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomShareView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public BottomShareView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.pageFrom = 1;
        initView(context);
    }
}

package com.zenmen.square.comment.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.comment.model.CommentViewModel;
import defpackage.ri0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommentLikeView extends LinearLayout {
    private TextView count;
    private ImageView icon;
    private CommentViewModel model;

    public CommentLikeView(Context context) {
        super(context, null);
    }

    public ImageView getIconView() {
        return this.icon;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.icon = (ImageView) findViewById(R$id.likeIcon);
        this.count = (TextView) findViewById(R$id.likeCount);
        CommentViewModel commentViewModel = this.model;
        if (commentViewModel != null) {
            updateView(commentViewModel);
        }
    }

    public void updateView(CommentViewModel commentViewModel) {
        this.model = commentViewModel;
        if (this.icon != null) {
            if (commentViewModel.isCRLike()) {
                this.icon.setImageResource(R$drawable.icon_praise_selected_new);
            } else {
                this.icon.setImageResource(R$drawable.icon_comment_like_none);
            }
            String strB = ri0.b(commentViewModel.getCRLikeCnt());
            if ("0".equals(strB)) {
                strB = "";
            }
            this.count.setText(strB);
        }
    }

    public CommentLikeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, -1);
    }

    public CommentLikeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public CommentLikeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private void init() {
    }
}

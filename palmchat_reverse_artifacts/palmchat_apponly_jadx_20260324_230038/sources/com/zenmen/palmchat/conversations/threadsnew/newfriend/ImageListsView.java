package com.zenmen.palmchat.conversations.threadsnew.newfriend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Glide;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.a46;
import defpackage.gu;
import defpackage.je1;
import defpackage.me1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ImageListsView extends LinearLayout {
    private static je1 options;
    private List<EffectiveShapeView> thumbnailViewList;
    private List<String> urls;

    public ImageListsView(Context context) {
        this(context, null);
    }

    private je1 getOptions() {
        if (options == null) {
            options = a46.j(getContext(), 4.0f, R.drawable.icon_default_thumbnail);
        }
        return options;
    }

    public void setFeedThumbnail(List<String> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.urls = list;
        int size = list.size() - this.thumbnailViewList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                EffectiveShapeView effectiveShapeView = new EffectiveShapeView(getContext());
                effectiveShapeView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                effectiveShapeView.changeShapeType(3);
                effectiveShapeView.setDegreeForRoundRectangle(me1.b(getContext(), 4), me1.b(getContext(), 4));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(me1.b(getContext(), 62), me1.b(getContext(), 62));
                if (this.thumbnailViewList.size() > 0) {
                    layoutParams.leftMargin = a46.b(getContext(), 5.0f);
                }
                addView(effectiveShapeView, layoutParams);
                this.thumbnailViewList.add(effectiveShapeView);
            }
        } else if (size < 0) {
            for (int i2 = 0; i2 > size; i2--) {
                removeView(this.thumbnailViewList.remove(r4.size() - 1));
            }
        }
        for (int i3 = 0; i3 < this.thumbnailViewList.size(); i3++) {
            Glide.with(getContext().getApplicationContext()).load2(list.get(i3)).placeholder(R.drawable.icon_default_thumbnail).transform(new gu(4, 2)).into(this.thumbnailViewList.get(i3));
        }
    }

    public ImageListsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageListsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.thumbnailViewList = new ArrayList();
    }

    @RequiresApi(api = 21)
    public ImageListsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.thumbnailViewList = new ArrayList();
    }
}

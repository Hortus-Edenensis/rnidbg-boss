package com.zenmen.palmchat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import defpackage.a46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SimpleFeedInfoCellView extends FrameLayout {
    private EffectiveShapeView coverIv;
    private ImageView videoIv;

    public SimpleFeedInfoCellView(@NonNull Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.layout_cell_view_simple_feed, (ViewGroup) this, true);
        this.coverIv = (EffectiveShapeView) findViewById(R.id.cover);
        this.videoIv = (ImageView) findViewById(R.id.iv_video);
    }

    public void update(String str, boolean z) {
        a46.u(str, this.coverIv, R.drawable.icon_default_thumbnail);
        if (z) {
            this.videoIv.setVisibility(0);
        } else {
            this.videoIv.setVisibility(8);
        }
    }

    public SimpleFeedInfoCellView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleFeedInfoCellView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}

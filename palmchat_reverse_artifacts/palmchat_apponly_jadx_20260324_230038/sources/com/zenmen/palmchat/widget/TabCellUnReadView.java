package com.zenmen.palmchat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TabCellUnReadView extends FrameLayout {
    public static final int STATUS_DOT = -1;
    public static final int STATUS_NEW = -2;
    public static final int STATUS_NONE = 0;
    private TextView badgeTv;
    private View dotView;
    private int mStatus;
    private View newView;

    public TabCellUnReadView(@NonNull Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_cell_view_unread_view, (ViewGroup) this, true);
        this.dotView = findViewById(R.id.dotView);
        this.newView = findViewById(R.id.newIv);
        this.badgeTv = (TextView) findViewById(R.id.badgeTv);
        updateView(0);
    }

    public int getViewStatus() {
        return this.mStatus;
    }

    public void updateView(int i) {
        this.dotView.setVisibility(8);
        this.newView.setVisibility(8);
        this.badgeTv.setVisibility(8);
        if (i > 0) {
            this.badgeTv.setVisibility(0);
            this.badgeTv.setText(i >= 100 ? AppContext.getContext().getString(R.string.notification_ellipsis) : String.valueOf(i));
        } else if (i == -2) {
            this.newView.setVisibility(0);
        }
        if (i == -1) {
            this.dotView.setVisibility(0);
        }
        this.mStatus = i;
    }

    public TabCellUnReadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabCellUnReadView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}

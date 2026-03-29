package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.R;
import defpackage.a46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleTabItemView extends LxRelativeLayout implements View.OnClickListener {
    private View btmView;
    private int index;
    private boolean isSelected;
    private RelativeLayout mRootLayout;
    private a selectedListener;
    private TextView tvTitle;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onSelect(int i);
    }

    public CircleTabItemView(Context context) {
        super(context);
        this.isSelected = false;
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R.layout.circle_tab_item_view, this);
        this.mRootLayout = (RelativeLayout) findViewById(R.id.root_layout);
        this.tvTitle = (TextView) findViewById(R.id.square_tab_item_text);
        this.btmView = findViewById(R.id.square_tab_item_bottom);
        setOnClickListener(this);
    }

    public int getIndex() {
        return this.index;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        setCurrentSelected(true, true);
    }

    public void setCurrentSelected(boolean z, boolean z2) {
        if (this.isSelected == z) {
            return;
        }
        if (z) {
            this.btmView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.btmView.getLayoutParams();
            layoutParams.width = a46.b(getContext(), 16.0f);
            this.btmView.setLayoutParams(layoutParams);
            this.tvTitle.setTextColor(getResources().getColor(R.color.Gb));
            this.tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
            a aVar = this.selectedListener;
            if (aVar != null && z2) {
                aVar.onSelect(((Integer) getTag()).intValue());
            }
        } else {
            this.btmView.setVisibility(4);
            ViewGroup.LayoutParams layoutParams2 = this.btmView.getLayoutParams();
            layoutParams2.width = a46.b(getContext(), 1.0f);
            this.btmView.setLayoutParams(layoutParams2);
            this.tvTitle.setTextColor(getResources().getColor(R.color.Gd));
            this.tvTitle.setTypeface(Typeface.DEFAULT);
        }
        this.isSelected = z;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setOnSelectedListener(a aVar) {
        this.selectedListener = aVar;
    }

    public void setTabMatch() {
        ViewGroup.LayoutParams layoutParams = this.mRootLayout.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = -1;
            this.mRootLayout.setLayoutParams(layoutParams2);
        }
    }

    public void setViewText(String str) {
        TextView textView = this.tvTitle;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public CircleTabItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSelected = false;
    }

    public CircleTabItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSelected = false;
    }

    @RequiresApi(api = 21)
    public CircleTabItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isSelected = false;
    }
}

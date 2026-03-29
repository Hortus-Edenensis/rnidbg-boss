package com.zenmen.square.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestDynamicLifeTabItemView extends LxRelativeLayout implements View.OnClickListener {
    private View btmView;
    private View dotView;
    private int index;
    private boolean isSelected;
    private a selectedListener;
    private TextView tvTitle;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onSelect(int i);
    }

    public NestDynamicLifeTabItemView(Context context) {
        super(context);
        this.isSelected = false;
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.nest_dynamic_life_layout_tab_item_view, this);
        this.tvTitle = (TextView) findViewById(R$id.square_tab_item_text);
        this.btmView = findViewById(R$id.square_tab_item_bottom);
        this.dotView = findViewById(R$id.square_tab_item_dot);
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
            this.dotView.setVisibility(4);
            this.btmView.setVisibility(0);
            this.tvTitle.setTextColor(Color.parseColor("#222222"));
            this.tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
            a aVar = this.selectedListener;
            if (aVar != null && z2) {
                aVar.onSelect(((Integer) getTag()).intValue());
            }
        } else {
            this.btmView.setVisibility(4);
            this.tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
            this.tvTitle.setTextColor(Color.parseColor("#999999"));
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

    public void setViewText(String str) {
        TextView textView = this.tvTitle;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void showDot() {
        if (this.isSelected) {
            return;
        }
        this.dotView.setVisibility(0);
    }

    public NestDynamicLifeTabItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSelected = false;
    }

    public NestDynamicLifeTabItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSelected = false;
    }

    @RequiresApi(api = 21)
    public NestDynamicLifeTabItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isSelected = false;
    }
}

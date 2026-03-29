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
import com.zenmen.square.SquareMessageActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MessageTabItemView extends LxRelativeLayout implements View.OnClickListener {
    private View btmView;
    private View dotView;
    private boolean isSelected;
    private a selectedListener;
    private TextView tvTitle;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onSelect(SquareMessageActivity.Tab tab);
    }

    public MessageTabItemView(Context context) {
        super(context);
        this.isSelected = false;
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.square_layout_message_tab_item_view, this);
        this.tvTitle = (TextView) findViewById(R$id.square_tab_item_text);
        this.btmView = findViewById(R$id.square_tab_item_bottom);
        this.dotView = findViewById(R$id.square_tab_item_dot);
        setOnClickListener(this);
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
            this.tvTitle.setTextColor(Color.parseColor("#222222"));
            this.tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
            a aVar = this.selectedListener;
            if (aVar != null && z2) {
                aVar.onSelect((SquareMessageActivity.Tab) getTag());
            }
        } else {
            this.btmView.setVisibility(4);
            this.tvTitle.setTextColor(Color.parseColor("#666666"));
            this.tvTitle.setTypeface(Typeface.DEFAULT);
        }
        this.isSelected = z;
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

    public void updateDot(int i) {
        this.dotView.setVisibility(i > 0 ? 0 : 4);
    }

    public MessageTabItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSelected = false;
    }

    public MessageTabItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSelected = false;
    }

    @RequiresApi(api = 21)
    public MessageTabItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isSelected = false;
    }
}

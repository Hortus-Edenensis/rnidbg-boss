package com.zenmen.square.ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$style;
import defpackage.a46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TabItemView extends LxRelativeLayout implements View.OnClickListener {
    private View btmView;
    private View dotView;
    private String fragmentClass;
    private boolean hideFilter;
    private int index;
    private boolean isSelected;
    private String redText;
    private b selectedListener;
    private TextView tvTitleDefault;
    private TextView tvTitleSelected;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = TabItemView.this.tvTitleDefault.getLayoutParams();
            layoutParams.width = TabItemView.this.tvTitleSelected.getWidth();
            TabItemView.this.tvTitleDefault.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onItemSelect(int i);
    }

    public TabItemView(Context context) {
        super(context);
        this.isSelected = false;
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.square_layout_tab_item_view, this);
        this.tvTitleDefault = (TextView) findViewById(R$id.square_tab_item_text_default);
        this.tvTitleSelected = (TextView) findViewById(R$id.square_tab_item_text_selected);
        this.dotView = findViewById(R$id.square_tab_item_dot);
        this.btmView = findViewById(R$id.square_tab_item_bottom);
        setOnClickListener(this);
    }

    public String getFragmentClass() {
        return this.fragmentClass;
    }

    public int getIndex() {
        return this.index;
    }

    public String getRedText() {
        return this.redText;
    }

    public boolean isHideFilter() {
        return this.hideFilter;
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
            layoutParams.width = a46.b(getContext(), 34.0f);
            this.btmView.setLayoutParams(layoutParams);
            if (Build.VERSION.SDK_INT >= 23) {
                this.tvTitleDefault.setTextAppearance(R$style.SquareTitleAppearanceSelected);
            } else {
                this.tvTitleDefault.setTextAppearance(getContext(), R$style.SquareTitleAppearanceSelected);
            }
            this.tvTitleDefault.setTypeface(Typeface.DEFAULT_BOLD);
            b bVar = this.selectedListener;
            if (bVar != null && z2) {
                bVar.onItemSelect(((Integer) getTag()).intValue());
            }
        } else {
            this.btmView.setVisibility(4);
            ViewGroup.LayoutParams layoutParams2 = this.btmView.getLayoutParams();
            layoutParams2.width = a46.b(getContext(), 1.0f);
            this.btmView.setLayoutParams(layoutParams2);
            if (Build.VERSION.SDK_INT >= 23) {
                this.tvTitleDefault.setTextAppearance(R$style.SquareTitleAppearanceDefault);
            } else {
                this.tvTitleDefault.setTextAppearance(getContext(), R$style.SquareTitleAppearanceDefault);
            }
            this.tvTitleDefault.setTypeface(Typeface.DEFAULT);
        }
        this.isSelected = z;
    }

    public void setFragmentClass(String str) {
        this.fragmentClass = str;
    }

    public void setHideFilter(boolean z) {
        this.hideFilter = z;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setOnSelectedListener(b bVar) {
        this.selectedListener = bVar;
    }

    public void setRedText(String str) {
        this.redText = str;
    }

    public void setViewText(String str) {
        TextView textView = this.tvTitleDefault;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.tvTitleSelected;
        if (textView2 != null) {
            textView2.setText(str);
            post(new a());
        }
    }

    public void updateDot(int i) {
        this.dotView.setVisibility(i > 0 ? 0 : 4);
    }

    public TabItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSelected = false;
    }

    public TabItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSelected = false;
    }

    @RequiresApi(api = 21)
    public TabItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isSelected = false;
    }
}

package com.zenmen.palmchat.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SystemUiTestView extends LinearLayout implements View.OnSystemUiVisibilityChangeListener, View.OnClickListener {
    int mBaseSystemUiVisibility;
    int mLastSystemUiVis;
    Runnable mNavHider;
    boolean mNavVisible;
    TextView mText;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemUiTestView.this.setNavVisibility(false);
        }
    }

    public SystemUiTestView(Context context) {
        this(context, null);
    }

    public void init(TextView textView, SeekBar seekBar) {
        setNavVisibility(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        setNavVisibility((getSystemUiVisibility() & 1) != 0);
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        setNavVisibility(false);
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int i) {
        int i2 = this.mLastSystemUiVis ^ i;
        this.mLastSystemUiVis = i;
        if ((i2 & 1) == 0 || (i & 1) != 0) {
            return;
        }
        setNavVisibility(true);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setBaseSystemUiVisibility(int i) {
        this.mBaseSystemUiVisibility = i;
    }

    public void setNavVisibility(boolean z) {
        Handler handler;
        int i = this.mBaseSystemUiVisibility;
        if (!z) {
            i |= 5;
        }
        if (((i == getSystemUiVisibility()) || z) && (handler = getHandler()) != null) {
            handler.removeCallbacks(this.mNavHider);
        }
        setSystemUiVisibility(i);
    }

    public SystemUiTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBaseSystemUiVisibility = 1280;
        this.mNavHider = new a();
        TextView textView = new TextView(context);
        this.mText = textView;
        textView.setTextSize(1, 16.0f);
        this.mText.setText("test");
        this.mText.setClickable(false);
        this.mText.setOnClickListener(this);
        this.mText.setTextIsSelectable(true);
        this.mText.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        addView(this.mText, new ViewGroup.LayoutParams(-1, -1));
        setOnSystemUiVisibilityChangeListener(this);
        init(null, null);
    }
}

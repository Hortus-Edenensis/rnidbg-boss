package com.zenmen.openapi.webapp.widget;

import android.app.Instrumentation;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.palmchat.R;
import defpackage.g13;
import defpackage.ma3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WebAppActionBar extends RelativeLayout implements View.OnClickListener {
    private ImageView backView;
    private TextView titleView;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends g13 {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                new Instrumentation().sendKeyDownUpSync(4);
            } catch (Exception unused) {
                ma3.d("Exception when sendKeyDownUpSync");
            }
        }
    }

    public WebAppActionBar(Context context) {
        this(context, null);
    }

    private void createView(Context context) {
        View.inflate(context, R.layout.webapp_actionbar, this);
        this.backView = (ImageView) findViewById(R.id.webapp_iv_action_bar_back);
        this.titleView = (TextView) findViewById(R.id.webapp_tv_action_bar_title);
        setBlackStyle(true);
        this.backView.setOnClickListener(this);
    }

    private void dispatchBackKeyEvent() {
        new a().start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.webapp_iv_action_bar_back) {
            dispatchBackKeyEvent();
        }
    }

    public void setActionBarTitle(String str) {
        this.titleView.setText(str);
    }

    public void setBlackStyle(boolean z) {
        if (z) {
            this.backView.setImageResource(R.drawable.webapp_action_bar_back_black_selector);
            this.titleView.setTextColor(-16777216);
        } else {
            this.backView.setImageResource(R.drawable.webapp_action_bar_back_white_selector);
            this.titleView.setTextColor(-1);
        }
    }

    public WebAppActionBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebAppActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        createView(context);
    }

    @RequiresApi(api = 21)
    public WebAppActionBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        createView(context);
    }
}

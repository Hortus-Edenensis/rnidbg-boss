package com.zenmen.openapi.webapp.floatview;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.R$id;
import com.zenmen.openapi.R$layout;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.a46;
import defpackage.fz4;
import defpackage.gr2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MainFloatViewProc extends LxRelativeLayout implements View.OnClickListener {
    public static final int CLICK_EVENT_ID_CANCEL = 2;
    public static final int CLICK_EVENT_ID_OPEN = 1;
    private fz4 mInfo;
    private ImageView mIvAppIcon;
    private ImageView mIvClose;
    private View mSelf;
    private TextView mTvName;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Point f12050a;

        public a(Point point) {
            this.f12050a = point;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainFloatViewProc.this.mSelf.setTranslationX(this.f12050a.x - MainFloatViewProc.this.mSelf.getWidth());
            MainFloatViewProc.this.mSelf.setVisibility(0);
        }
    }

    public MainFloatViewProc(Context context) {
        super(context);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.lx_webapp_main_floatview_proc, this);
        this.mSelf = findViewById(R$id.lx_webapp_main_floatview_proc);
        this.mIvAppIcon = (ImageView) findViewById(R$id.lx_webapp_main_floatview_icon);
        this.mTvName = (TextView) findViewById(R$id.lx_webapp_main_floatview_name);
        this.mIvClose = (ImageView) findViewById(R$id.lx_webapp_main_floatview_close);
        this.mSelf.setOnClickListener(this);
        this.mIvClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.lx_webapp_main_floatview_proc) {
            disPatchEvent(1, null);
        } else if (view.getId() == R$id.lx_webapp_main_floatview_close) {
            disPatchEvent(2, null);
        }
    }

    public void setAppInfo(fz4 fz4Var) {
        this.mInfo = fz4Var;
        gr2.j().h(fz4Var.a("appIcon"), this.mIvAppIcon, a46.j(getContext(), 15.0f, 0));
        this.mTvName.setText(this.mInfo.a(WfConstant.EVENT_KEY_APP_NAME));
    }

    public void setPosition(float f) {
        View view = this.mSelf;
        if (view != null) {
            view.setVisibility(4);
            post(new a(a46.m(getContext())));
            this.mSelf.setTranslationY(f);
        }
    }

    public MainFloatViewProc(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainFloatViewProc(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public MainFloatViewProc(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}

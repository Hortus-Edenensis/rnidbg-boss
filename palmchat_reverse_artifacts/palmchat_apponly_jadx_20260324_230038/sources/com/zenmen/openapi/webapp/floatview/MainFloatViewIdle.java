package com.zenmen.openapi.webapp.floatview;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.R$id;
import com.zenmen.openapi.R$layout;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import defpackage.a46;
import defpackage.fz4;
import defpackage.gr2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MainFloatViewIdle extends LxRelativeLayout implements View.OnTouchListener {
    private fz4 appInfo;
    private long dowmTime;
    private ImageView ivIcon;
    private double lastX;
    private double lastY;
    private int mMaxY;
    private int mMinY;
    private double startX;
    private double startY;

    public MainFloatViewIdle(Context context) {
        this(context, null);
    }

    private void fitSide() {
        Point pointM = a46.m(getContext());
        int iB = a46.b(getContext(), 16.0f);
        this.mMinY = iB - getTop();
        int height = pointM.y;
        if (getParent() instanceof ViewGroup) {
            height = ((ViewGroup) getParent()).getHeight();
        }
        this.mMaxY = (height - getBottom()) - iB;
        float translationY = getTranslationY();
        int i = this.mMaxY;
        if (translationY >= i) {
            setTranslationY(i);
            return;
        }
        float translationY2 = getTranslationY();
        int i2 = this.mMinY;
        if (translationY2 <= i2) {
            setTranslationY(i2);
        }
    }

    private void moveSelf(double d, double d2) {
        setTranslationY((float) (((double) getTranslationY()) + d2));
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        LayoutInflater.from(context).inflate(R$layout.lx_webapp_main_floatview_idle, (ViewGroup) this, true);
        this.ivIcon = (ImageView) findViewById(R$id.lx_webapp_main_floatview_idle_icon);
        setOnTouchListener(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        double rawX = motionEvent.getRawX();
        double rawY = motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.dowmTime = System.currentTimeMillis();
            this.lastX = rawX;
            this.lastY = rawY;
            this.startX = rawX;
            this.startY = rawY;
        } else if (action == 1) {
            fitSide();
            if (System.currentTimeMillis() - this.dowmTime < 500 && Math.abs(this.startX - this.lastX) < 5.0d && Math.abs(this.startY - this.lastY) < 5.0d) {
                performClick();
            }
        } else if (action == 2) {
            moveSelf(rawX - this.lastX, rawY - this.lastY);
            this.lastX = rawX;
            this.lastY = rawY;
        } else if (action == 3) {
        }
        return true;
    }

    public void setAppInfo(fz4 fz4Var) {
        this.appInfo = fz4Var;
        gr2.j().h(fz4Var.a("appIcon"), this.ivIcon, a46.j(getContext(), 15.0f, 0));
    }

    public MainFloatViewIdle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainFloatViewIdle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public MainFloatViewIdle(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}

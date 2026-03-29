package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.ap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RegionClickView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    GradientDrawable f4782a;
    TextView b;
    private boolean c;
    private Boolean d;

    public RegionClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        init(context);
    }

    private void a(Context context, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f4782a = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        if (i == 1) {
            this.f4782a.setStroke(1, Color.parseColor("#E8E8E8"));
        }
        this.f4782a.setCornerRadius(ap.a(context, 30.0f));
        setBackgroundDrawable(this.f4782a);
    }

    public void init(Context context) {
        if (this.c) {
            return;
        }
        this.c = true;
        a(context, 1);
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setLines(1);
        this.b.setTextSize(2, 18.0f);
        this.b.setTextColor(Color.parseColor("#949494"));
        this.b.setText("点击跳转详情页或第三方应用     >");
        this.b.setGravity(17);
        setGravity(17);
        setOrientation(1);
        addView(this.b);
    }

    public void setBackGroundAlpha(double d) {
        GradientDrawable gradientDrawable = this.f4782a;
        if (gradientDrawable == null || d <= 0.0d) {
            return;
        }
        gradientDrawable.setAlpha((int) (d * 255.0d));
    }

    public void setBackgroundColor(String str) {
        GradientDrawable gradientDrawable = this.f4782a;
        if (gradientDrawable == null || str == null) {
            return;
        }
        try {
            gradientDrawable.setColor(Color.parseColor(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDownloadApp(Boolean bool) {
        this.d = bool;
    }

    public void setRegionalClickViewBean(AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean) {
        String downloadTitle;
        if (regionalClickViewBean == null) {
            return;
        }
        if (this.d.booleanValue()) {
            downloadTitle = regionalClickViewBean.getDownloadTitle();
            if (TextUtils.isEmpty(downloadTitle)) {
                downloadTitle = "点击下载应用";
            }
        } else {
            downloadTitle = regionalClickViewBean.getTitle();
        }
        setTitle(downloadTitle);
        setTitleColor(regionalClickViewBean.getTitleColor());
        setBackGroundAlpha(regionalClickViewBean.getBackgroundAlpha());
        setBackgroundColor(regionalClickViewBean.getBackgroundColor());
    }

    public void setTitle(String str) {
        TextView textView = this.b;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setText(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTitleColor(String str) {
        TextView textView = this.b;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setTextColor(Color.parseColor(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegionClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        init(context);
    }

    public RegionClickView(Context context) {
        super(context);
        this.c = false;
        init(context);
    }
}

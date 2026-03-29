package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.RegionClickView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ag {
    private static String d;
    private static String e;
    private static String f;
    private static String g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4702a;
    private a b;
    private AdSpacesBean.BuyerBean.RegionalClickViewBean c = null;
    private Boolean h;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public ag(Context context) {
        this.f4702a = context;
    }

    public void a(AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean) {
        this.c = regionalClickViewBean;
    }

    public View a(int i, int i2, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean, boolean z) {
        if (this.f4702a == null || percentPositionBean == null) {
            return null;
        }
        aa.c("BeiZis", "adWidthDp = " + i + ",adHeightDp = " + i2);
        RegionClickView regionClickView = new RegionClickView(this.f4702a);
        if (this.c != null) {
            regionClickView.setDownloadApp(this.h);
            regionClickView.setRegionalClickViewBean(this.c);
        }
        regionClickView.setLayoutParams(a(i, i2, percentPositionBean));
        if (z) {
            regionClickView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.tool.ag.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ag.this.b != null) {
                        ag.this.b.a(ag.d, ag.e, ag.f, ag.g, ag.d, ag.e, ag.f, ag.g);
                    }
                }
            });
            regionClickView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.tool.ag.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (motionEvent.getAction() != 0) {
                            return false;
                        }
                        String unused = ag.d = motionEvent.getX() + "";
                        String unused2 = ag.e = motionEvent.getY() + "";
                        String unused3 = ag.f = motionEvent.getRawX() + "";
                        String unused4 = ag.g = motionEvent.getRawY() + "";
                        return false;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return false;
                    }
                }
            });
        }
        return regionClickView;
    }

    @NonNull
    private ViewGroup.MarginLayoutParams a(int i, int i2, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean) {
        int i3;
        int i4;
        int i5;
        int i6;
        String centerX = percentPositionBean.getCenterX();
        String centerY = percentPositionBean.getCenterY();
        String width = percentPositionBean.getWidth();
        String height = percentPositionBean.getHeight();
        float fJ = ap.j(this.f4702a);
        if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
            centerX = "50%";
        }
        if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
            aa.a("BeiZis", "screenHeightDp = " + fJ + ",adHeightDp = " + i2);
            centerY = fJ > ((float) i2) ? "63" : "188";
        }
        if (TextUtils.isEmpty(width) || "0".equals(width)) {
            width = "325";
        }
        if (TextUtils.isEmpty(height) || "0".equals(height)) {
            height = "65";
        }
        float fI = ap.i(this.f4702a);
        if (centerX.endsWith("%")) {
            i3 = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i) / 100;
        } else {
            i3 = Integer.parseInt(centerX);
        }
        if (centerY.endsWith("%")) {
            i4 = (Integer.parseInt(centerY.substring(0, centerY.indexOf("%"))) * i2) / 100;
        } else {
            i4 = i2 - Integer.parseInt(centerY);
            aa.a("BeiZis", "adHeightDp = " + i2 + ", centerYInt = " + i4);
        }
        int i7 = 400;
        if (width.endsWith("%")) {
            int i8 = Integer.parseInt(width.substring(0, width.indexOf("%")));
            if (fI >= 400.0f) {
                i5 = (i8 * 400) / 100;
                i7 = i5;
            } else {
                i7 = (((int) fI) * i8) / 100;
            }
        } else {
            i5 = Integer.parseInt(width);
            if (i5 < 400) {
                i7 = i5;
            }
        }
        if (height.endsWith("%")) {
            i6 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i7) / 100;
        } else {
            i6 = Integer.parseInt(height);
        }
        int iA = ap.a(this.f4702a, i7);
        int iA2 = ap.a(this.f4702a, i6);
        int iA3 = ap.a(this.f4702a, i3);
        int iA4 = ap.a(this.f4702a, i4);
        aa.a("BeiZis", "widthInt = " + iA + ",heightInt = " + iA2);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(iA, iA2);
        aa.a("BeiZis", "centerYInt = " + iA4 + ",centerXInt = " + iA3 + ",adWidthDp = " + i + ",adHeightDp = " + i2);
        marginLayoutParams.topMargin = iA4 - (iA2 / 2);
        marginLayoutParams.leftMargin = iA3 - (iA / 2);
        return marginLayoutParams;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a() {
        this.f4702a = null;
        this.c = null;
    }

    public void a(Boolean bool) {
        this.h = bool;
    }
}

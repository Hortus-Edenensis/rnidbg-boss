package com.beizi.fusion.tool;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.TwistView;
import com.huawei.hms.ads.gh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4705a = "ah";
    private static SensorManager c;
    private static String n;
    private static String o;
    private static String p;
    private static String q;
    private Context b;
    private long j;
    private double k;
    private double l;
    private TwistView m;
    private Boolean u;
    private long d = 0;
    private double e = -999.0d;
    private double f = -999.0d;
    private boolean g = false;
    private boolean h = false;
    private int i = 0;
    private boolean r = false;
    private boolean s = false;
    private a t = null;
    private final SensorEventListener v = new SensorEventListener() { // from class: com.beizi.fusion.tool.ah.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                if (System.currentTimeMillis() - ah.this.d < 80) {
                    return;
                }
                ah.this.d = System.currentTimeMillis();
                float[] fArr = sensorEvent.values;
                double d = ((double) fArr[0]) / 9.8d;
                double d2 = ((double) fArr[1]) / 9.8d;
                double d3 = ((double) fArr[2]) / 9.8d;
                double degrees = Math.toDegrees(Math.atan2(d, d2));
                double d4 = degrees <= 0.0d ? (-degrees) - 180.0d : 180.0d - degrees;
                double degrees2 = Math.toDegrees(Math.atan2(d, d3));
                double d5 = degrees2 <= 0.0d ? (-degrees2) - 180.0d : 180.0d - degrees2;
                double degrees3 = Math.toDegrees(Math.atan2(d3, Math.sqrt((d * d) + (d2 * d2)))) + 90.0d;
                if (degrees3 > 45.0d && degrees3 < 135.0d && (Math.abs((Math.sin(d2) / 3.141592653589793d) * 180.0d) >= 45.0d || !ah.this.g)) {
                    if (ah.this.f != -999.0d && ah.this.h) {
                        if ((d4 >= ah.this.f && d4 - ah.this.f > ah.this.k && d4 - ah.this.f <= 180.0d) || (d4 < ah.this.f && ah.this.f > 0.0d && (360.0d - ah.this.f) + d4 > ah.this.k && (360.0d - ah.this.f) + d4 <= 180.0d)) {
                            aa.c(ah.f4705a, "11111发生垂直状态滚动 rollStatus:" + ah.this.i);
                            ah.this.i = 1;
                            ah.this.i();
                            return;
                        }
                        if (d4 < ah.this.f || ((d4 - ah.this.f >= ah.this.l || Math.abs(d4 - ah.this.f) > 180.0d) && (Math.abs(d4 - ah.this.f) < 180.0d || (-(360.0d - Math.abs(d4 - ah.this.f))) >= ah.this.l))) {
                            if (d4 >= ah.this.f) {
                                return;
                            }
                            if ((d4 - ah.this.f >= ah.this.l || Math.abs(d4 - ah.this.f) > 180.0d) && (Math.abs(d4 - ah.this.f) < 180.0d || 360.0d - Math.abs(d4 - ah.this.f) >= ah.this.l)) {
                                return;
                            }
                        }
                        if (ah.this.i == 1) {
                            ah.this.i = 2;
                            aa.a(ah.f4705a, "发生垂直状态回滚");
                            ah.this.i();
                            return;
                        }
                        return;
                    }
                    ah.this.f = d4;
                    ah.this.h = true;
                    ah.this.g = false;
                    return;
                }
                if (ah.this.e != -999.0d && ah.this.g) {
                    if ((d5 >= ah.this.e && d5 - ah.this.e > ah.this.k && d5 - ah.this.e <= 180.0d) || (d5 < ah.this.e && ah.this.e > 0.0d && (360.0d - ah.this.e) + d5 > ah.this.k && (360.0d - ah.this.e) + d5 <= 180.0d)) {
                        aa.c(ah.f4705a, "11111发生水平状态滚动 rollStatus:" + ah.this.i);
                        ah.this.i = 1;
                        ah.this.i();
                        return;
                    }
                    if (d5 < ah.this.e || ((d5 - ah.this.e >= ah.this.l || Math.abs(d5 - ah.this.e) > 180.0d) && (Math.abs(d5 - ah.this.e) < 180.0d || (-(360.0d - Math.abs(d5 - ah.this.e))) >= ah.this.l))) {
                        if (d5 >= ah.this.e) {
                            return;
                        }
                        if ((d5 - ah.this.e >= ah.this.l || Math.abs(d5 - ah.this.e) > 180.0d) && (Math.abs(d5 - ah.this.e) < 180.0d || 360.0d - Math.abs(d5 - ah.this.e) >= ah.this.l)) {
                            return;
                        }
                    }
                    aa.a(ah.f4705a, "2222发生水平状态回滚 rollStatus:" + ah.this.i);
                    if (ah.this.i == 1) {
                        ah.this.i = 2;
                        aa.a(ah.f4705a, "发生水平状态回滚");
                        ah.this.i();
                        return;
                    }
                    return;
                }
                ah.this.e = d5;
                ah.this.g = true;
                ah.this.h = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public ah(Context context) {
        this.b = context;
        c = (SensorManager) context.getApplicationContext().getSystemService("sensor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        TwistView twistView = this.m;
        if (twistView != null) {
            twistView.updateRollStatus(this.i);
        }
    }

    public void c() {
        this.s = false;
    }

    public void b() {
        SensorManager sensorManager = c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.v);
        }
        TwistView twistView = this.m;
        if (twistView != null) {
            twistView.destroyView();
            this.m = null;
        }
        this.s = false;
        this.r = false;
    }

    public void a(ViewGroup viewGroup, int i, int i2, AdSpacesBean.BuyerBean.RollViewBean rollViewBean) {
        AdSpacesBean.BuyerBean.PercentPositionBean position;
        int i3;
        int i4;
        int i5;
        int i6;
        String downloadSubTitle;
        aa.a("BeiZis", "enter addRollView");
        if (this.b == null || viewGroup == null || rollViewBean == null || (position = rollViewBean.getPosition()) == null) {
            return;
        }
        this.m = new TwistView(this.b);
        String centerX = position.getCenterX();
        String centerY = position.getCenterY();
        String width = position.getWidth();
        String height = position.getHeight();
        if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
            centerX = "85%";
        }
        if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
            centerY = "50%";
        }
        if (TextUtils.isEmpty(width) || "0".equals(width)) {
            width = "340";
        }
        if (TextUtils.isEmpty(height) || "0".equals(height)) {
            height = gh.Code;
        }
        float fI = ap.i(this.b);
        if (centerX.endsWith("%")) {
            i3 = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i) / 100;
        } else {
            i3 = Integer.parseInt(centerX);
        }
        if (centerY.endsWith("%")) {
            i4 = (Integer.parseInt(centerY.substring(0, centerY.indexOf("%"))) * i2) / 100;
        } else {
            i4 = Integer.parseInt(centerY);
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
        int iA = ap.a(this.b, i7);
        int iA2 = ap.a(this.b, i6 + 95);
        int iA3 = ap.a(this.b, i3);
        int iA4 = ap.a(this.b, i4);
        aa.a("BeiZis", "widthInt = " + iA + ",heightInt = " + iA2);
        int iA5 = ap.a(this.b, 340.0f);
        int iA6 = ap.a(this.b, 165.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA5, iA6);
        aa.a("BeiZis", "centerYInt = " + iA4 + ",centerXInt = " + iA3 + ",adWidthDp = " + i + ",adHeightDp = " + i2);
        if (iA4 == 0) {
            iA4 = ap.a(this.b, i2) / 2;
        }
        if (iA3 == 0) {
            iA3 = ap.a(this.b, i) / 2;
        }
        layoutParams.topMargin = iA4 - (iA6 / 2);
        layoutParams.leftMargin = iA3 - (iA5 / 2);
        this.m.setTwistTotalLayoutWidthAndHeight(iA5, iA6);
        this.m.setLayoutParams(layoutParams);
        this.m.setTwistTotalLayoutBg(rollViewBean.getBgColor());
        this.m.setMainTitleText(rollViewBean.getTitle());
        if (!this.u.booleanValue()) {
            downloadSubTitle = rollViewBean.getSubTitle();
        } else {
            downloadSubTitle = rollViewBean.getDownloadSubTitle();
            if (TextUtils.isEmpty(downloadSubTitle)) {
                downloadSubTitle = "下载应用";
            }
        }
        this.m.setDescribeText(downloadSubTitle);
        this.m.setJumpClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.tool.ah.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ah.this.s) {
                    return;
                }
                ah.this.s = true;
                if (ah.this.t != null) {
                    ah.this.t.a(ah.n, ah.o, ah.p, ah.q, ah.n, ah.o, ah.p, ah.q);
                }
            }
        });
        this.m.setJumpOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.tool.ah.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                try {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    String unused = ah.n = motionEvent.getX() + "";
                    String unused2 = ah.o = motionEvent.getY() + "";
                    String unused3 = ah.p = motionEvent.getRawX() + "";
                    String unused4 = ah.q = motionEvent.getRawY() + "";
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        });
        this.m.setRotationEndCallback(new TwistView.a() { // from class: com.beizi.fusion.tool.ah.4
            @Override // com.beizi.fusion.widget.TwistView.a
            public void a() {
                if (ah.this.r) {
                    return;
                }
                ah.this.r = true;
                if (ah.this.t != null) {
                    ah.this.t.a();
                }
            }
        });
        viewGroup.addView(this.m, layoutParams);
    }

    public void b(double d) {
        this.l = d;
    }

    public void a() {
        SensorManager sensorManager = c;
        if (sensorManager != null) {
            sensorManager.registerListener(this.v, sensorManager.getDefaultSensor(1), 100000);
        }
    }

    public void a(AdSpacesBean.BuyerBean.RollViewBean rollViewBean) {
        if (rollViewBean == null) {
            return;
        }
        try {
            aa.a(f4705a, "setRollParams getRollTime:" + rollViewBean.getRollTime() + ";getRollPlusAmplitude:" + rollViewBean.getRollPlusAmplitude() + ";getRollMinusAmplitude:" + rollViewBean.getRollMinusAmplitude());
            a(rollViewBean.getRollTime());
            a(rollViewBean.getRollPlusAmplitude());
            b(rollViewBean.getRollMinusAmplitude());
            TwistView twistView = this.m;
            if (twistView != null) {
                twistView.setDurationAnimation(rollViewBean.getRollTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.CoolRollViewBean coolRollViewBean) {
        if (coolRollViewBean == null) {
            return;
        }
        try {
            aa.a(f4705a, "setRollCoolParams getRollTime:" + coolRollViewBean.getRollTime() + ";getRollPlusAmplitude:" + coolRollViewBean.getRollPlusAmplitude() + ";getRollMinusAmplitude:" + coolRollViewBean.getRollMinusAmplitude());
            a(coolRollViewBean.getRollTime());
            a(coolRollViewBean.getRollPlusAmplitude());
            b(coolRollViewBean.getRollMinusAmplitude());
            TwistView twistView = this.m;
            if (twistView != null) {
                twistView.setDurationAnimation(coolRollViewBean.getRollTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(long j) {
        this.j = j;
    }

    public void a(double d) {
        this.k = d;
    }

    public void a(a aVar) {
        this.t = aVar;
    }

    public void a(Boolean bool) {
        this.u = bool;
    }
}

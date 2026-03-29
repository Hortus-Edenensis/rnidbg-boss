package com.bytedance.adsdk.ugeno.pn.fx;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.beizi.fusion.widget.ScrollClickView;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends nr {
    private int k;
    private float l;
    private int mv;
    private AtomicBoolean my;
    private int o;
    private int s;
    private String sx;
    private float t;

    public b(Context context) {
        super(context);
        this.mv = 0;
        this.s = Integer.MAX_VALUE;
        this.k = Integer.MAX_VALUE;
        this.my = new AtomicBoolean(true);
        this.o = 0;
        this.sx = "up";
    }

    @Override // com.bytedance.adsdk.ugeno.pn.fx.nr
    public boolean u(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        Map<String, String> map = this.pn;
        if (map != null) {
            this.sx = TextUtils.isEmpty(map.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)) ? "all" : this.pn.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
            this.mv = com.bytedance.adsdk.ugeno.iz.fx.u(this.pn.get("distance"), 0);
            if (this.s == Integer.MAX_VALUE) {
                this.s = com.bytedance.adsdk.ugeno.iz.fx.u(this.pn.get("frequency"), Integer.MAX_VALUE);
            }
            if (this.k == Integer.MAX_VALUE) {
                this.k = com.bytedance.adsdk.ugeno.iz.fx.u(this.pn.get("effectiveDuration"), Integer.MAX_VALUE);
            }
            this.o = com.bytedance.adsdk.ugeno.iz.fx.u(this.pn.get("inView"), 0);
            this.my.get();
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        u();
        return u(this.nr, motionEvent);
    }

    private void u() {
        if (this.k == Integer.MAX_VALUE || this.nr == null || System.currentTimeMillis() - this.nr.q() < this.k) {
            return;
        }
        this.my.set(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean u(com.bytedance.adsdk.ugeno.nr.fx fxVar, MotionEvent motionEvent) {
        byte b;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.t = motionEvent.getX();
            this.l = motionEvent.getY();
        } else if (action == 1 || action == 3) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.mv == 0 && this.u != null) {
                return u(fxVar, x, y);
            }
            int iNr = com.bytedance.adsdk.ugeno.iz.n.nr(this.jk, x - this.t);
            int iNr2 = com.bytedance.adsdk.ugeno.iz.n.nr(this.jk, y - this.l);
            String str = this.sx;
            switch (str.hashCode()) {
                case 3739:
                    b = !str.equals("up") ? (byte) -1 : (byte) 0;
                    break;
                case 96673:
                    if (str.equals("all")) {
                        b = 4;
                        break;
                    }
                    break;
                case 3089570:
                    if (str.equals(ScrollClickView.DIR_DOWN)) {
                        b = 1;
                        break;
                    }
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        b = 2;
                        break;
                    }
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        b = 3;
                        break;
                    }
                    break;
            }
            if (b == 0) {
                iNr = -iNr2;
            } else if (b == 1) {
                iNr = iNr2;
            } else if (b == 2) {
                iNr = -iNr;
            } else if (b != 3) {
                iNr = (int) Math.abs(Math.sqrt(Math.pow(iNr, 2.0d) + Math.pow(iNr2, 2.0d)));
            }
            if (iNr < this.mv) {
                return false;
            }
            if (this.u != null) {
                this.t = 0.0f;
                this.l = 0.0f;
                return u(fxVar, x, y);
            }
        }
        return true;
    }

    private boolean u(com.bytedance.adsdk.ugeno.nr.fx fxVar, float f, float f2) {
        if (this.s <= 0 || !this.my.get()) {
            return false;
        }
        if (this.o == 1 && !u(fxVar.a(), f, f2)) {
            return false;
        }
        this.u.u(fxVar, this.iz, this.fx.nr());
        int i = this.s;
        if (i != Integer.MAX_VALUE) {
            this.s = i - 1;
        }
        return true;
    }

    private boolean u(View view, float f, float f2) {
        return f >= 0.0f && f < ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
    }
}

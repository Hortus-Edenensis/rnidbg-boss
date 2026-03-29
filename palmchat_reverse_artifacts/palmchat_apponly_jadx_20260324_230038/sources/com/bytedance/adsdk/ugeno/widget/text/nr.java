package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.igexin.push.core.b;
import com.umeng.analytics.pro.dn;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr extends fx<UGTextView> {
    private float ec;
    private int fn;
    private int gb;
    private int gl;
    private boolean hm;
    private float hs;

    @Deprecated
    private TextUtils.TruncateAt ic;
    private TextUtils.TruncateAt iq;
    private int je;
    private float jn;
    protected int ki;
    private int pq;
    private float r;
    private float te;
    private int ti;
    protected String u;
    private float uk;
    private float wj;

    @Deprecated
    private float wu;

    @Deprecated
    private float xh;
    private float zn;

    public nr(Context context) {
        super(context);
        this.ki = -16777216;
        this.hs = 12.0f;
        this.te = -1.0f;
        this.gb = Integer.MAX_VALUE;
        this.fn = GravityCompat.START;
        this.iq = TextUtils.TruncateAt.END;
        this.wj = -1.0f;
        this.ec = 400.0f;
    }

    private void ay() {
        float f = this.wj;
        if (f <= 3.0f) {
            ((UGTextView) this.pn).setLineSpacing(0.0f, f);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int iRound = Math.round(n.u(this.nr, (f - (this.hs * 1.2f)) / 2.0f));
            int paddingTop = ((UGTextView) this.pn).getPaddingTop() + iRound;
            int paddingBottom = ((UGTextView) this.pn).getPaddingBottom() + iRound;
            T t = this.pn;
            ((UGTextView) t).setPadding(((UGTextView) t).getPaddingLeft(), paddingTop, ((UGTextView) this.pn).getPaddingRight(), paddingBottom);
            ((UGTextView) this.pn).setLineHeight(Math.round(n.u(this.nr, this.wj)));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int k(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    b = 0;
                }
                break;
            case -348726240:
                if (str.equals("center_vertical")) {
                    b = 1;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    b = 2;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    b = 3;
                }
                break;
            case 1063616078:
                if (str.equals("center_horizontal")) {
                    b = 4;
                }
                break;
        }
        switch (b) {
            case 0:
                return 17;
            case 1:
                return 16;
            case 2:
            default:
                return 3;
            case 3:
                return 5;
            case 4:
                return 1;
        }
    }

    private TextUtils.TruncateAt l(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.ic = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.ic = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.ic = TextUtils.TruncateAt.START;
                break;
            default:
                this.ic = null;
                break;
        }
        return this.ic;
    }

    private TextUtils.TruncateAt mv(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    private int my(String str) {
        str.hashCode();
        switch (str) {
            case "underline":
                return 8;
            case "strikethrough":
                return 16;
            case "none":
            default:
                return Integer.MAX_VALUE;
        }
    }

    private void n() {
        ((UGTextView) this.pn).setLineSpacing(0.0f, this.wj);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int s(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1178781136) {
            if (iHashCode != -1039745817) {
                b = (iHashCode == 3029637 && str.equals("bold")) ? (byte) 0 : (byte) -1;
            } else if (str.equals(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL)) {
                b = 2;
            }
        } else if (str.equals("italic")) {
            b = 1;
        }
        if (b != 0) {
            return b != 1 ? 0 : 2;
        }
        return 1;
    }

    public void iz(int i) {
        this.je = i;
        if (i == Integer.MAX_VALUE) {
            return;
        }
        ((UGTextView) this.pn).setPaintFlags(i);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        if (TextUtils.equals(b.m, this.u)) {
            this.u = "";
        }
        t(this.u);
        ((UGTextView) this.pn).setTextSize(1, this.hs);
        ((UGTextView) this.pn).setTextColor(this.ki);
        ((UGTextView) this.pn).setLines(this.gl);
        ((UGTextView) this.pn).setMaxLines(this.gb);
        ((UGTextView) this.pn).setGravity(this.fn);
        ((UGTextView) this.pn).setIncludeFontPadding(false);
        ((UGTextView) this.pn).setMinTextSize(n.u(this.nr, this.te));
        iz(this.je);
        if (h()) {
            u(this.iq);
        } else {
            u(this.ic);
        }
        if (this.wj > 0.0f) {
            if (h()) {
                ay();
            } else {
                n();
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            ((UGTextView) this.pn).setBreakStrategy(0);
        }
        if (!h()) {
            ((UGTextView) this.pn).setShadowLayer(this.uk, this.wu, this.xh, this.pq);
        } else if (this.hm) {
            if (this.uk <= 0.0f) {
                this.uk = 1.0E-5f;
            }
            ((UGTextView) this.pn).setShadowLayer(this.uk, this.zn, this.r, this.pq);
        }
        int i2 = this.ti;
        if (i2 == 1) {
            ((UGTextView) this.pn).setTypeface(Typeface.DEFAULT, i2);
        } else if (i >= 28) {
            ((UGTextView) this.pn).setTypeface(Typeface.create(Typeface.DEFAULT, (int) this.ec, i2 == 2));
        } else if (this.ec >= 500.0f) {
            ((UGTextView) this.pn).setTypeface(Typeface.DEFAULT, 1);
        }
        if (n.u(this.nr, this.hs) > 0.0f) {
            ((UGTextView) this.pn).setLetterSpacing(this.jn / n.u(this.nr, this.hs));
        }
    }

    public void t(String str) {
        this.u = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals(b.m, str)) {
            this.u = "";
        }
        ((UGTextView) this.pn).setText(this.u);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UGTextView u() {
        UGTextView uGTextView = new UGTextView(this.nr);
        uGTextView.u(this);
        return uGTextView;
    }

    public void u(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((UGTextView) this.pn).setEllipsize(truncateAt);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.u(str, str2);
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1621067310:
                if (str.equals("shadowRadius")) {
                    b = 0;
                }
                break;
            case -1589741021:
                if (str.equals("shadowColor")) {
                    b = 1;
                }
                break;
            case -1230714651:
                if (str.equals("shadowOffsetX")) {
                    b = 2;
                }
                break;
            case -1230714650:
                if (str.equals("shadowOffsetY")) {
                    b = 3;
                }
                break;
            case -1065511464:
                if (str.equals("textAlign")) {
                    b = 4;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    b = 5;
                }
                break;
            case -1048634236:
                if (str.equals("textStyle")) {
                    b = 6;
                }
                break;
            case -1021145689:
                if (str.equals("shadowBlur")) {
                    b = 7;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    b = 8;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    b = 9;
                }
                break;
            case -756368940:
                if (str.equals("shadowDx")) {
                    b = 10;
                }
                break;
            case -756368939:
                if (str.equals("shadowDy")) {
                    b = 11;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    b = 12;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    b = dn.k;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    b = dn.l;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    b = 15;
                }
                break;
            case 188702929:
                if (str.equals("ellipsis")) {
                    b = 16;
                }
                break;
            case 351195968:
                if (str.equals("minTextSize")) {
                    b = 17;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    b = 18;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    b = 19;
                }
                break;
            case 2111078717:
                if (str.equals("letterSpacing")) {
                    b = 20;
                }
                break;
        }
        switch (b) {
            case 0:
            case 7:
                this.uk = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 1:
                this.pq = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                this.hm = true;
                break;
            case 2:
                this.zn = n.u(this.nr, com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f));
                break;
            case 3:
                this.r = n.u(this.nr, com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f));
                break;
            case 4:
                this.fn = k(str2);
                break;
            case 5:
                this.ki = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                break;
            case 6:
                this.ti = s(str2);
                break;
            case 8:
                this.hs = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 9:
                this.je = my(str2);
                break;
            case 10:
                this.wu = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 11:
                this.xh = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 12:
                float fU = com.bytedance.adsdk.ugeno.iz.fx.u(str2, -1.0f);
                this.ec = fU;
                if (fU < 1.0f || fU > 1000.0f) {
                    this.ec = 400.0f;
                }
                break;
            case 13:
                this.wj = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 1.0f);
                break;
            case 14:
                this.u = str2;
                break;
            case 15:
                this.gl = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0);
                break;
            case 16:
                this.iq = mv(str2);
                break;
            case 17:
                this.te = com.bytedance.adsdk.ugeno.iz.fx.u(str2, -1.0f);
                break;
            case 18:
                int iU = com.bytedance.adsdk.ugeno.iz.fx.u(str2, Integer.MAX_VALUE);
                this.gb = iU > 0 ? iU : Integer.MAX_VALUE;
                break;
            case 19:
                this.ic = l(str2);
                break;
            case 20:
                this.jn = n.u(this.nr, com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f));
                break;
        }
    }
}

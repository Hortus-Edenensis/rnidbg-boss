package com.bytedance.adsdk.ugeno.flexbox;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout;
import com.bytedance.adsdk.ugeno.nr.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn extends com.bytedance.adsdk.ugeno.nr.u<FlexboxLayout> {
    private int gb;
    private int hs;
    private int ki;
    private int te;
    private int ti;

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends u.C0171u {
        public int bf;
        public float d;
        public float gi;
        public int h;
        public int ja;
        public int pb;
        public float rh;
        public int wq;
        public int z;

        public u(com.bytedance.adsdk.ugeno.nr.u uVar) {
            super(uVar);
            this.z = 1;
            this.gi = 0.0f;
            this.d = 0.0f;
            this.h = -1;
            this.rh = -1.0f;
            this.ja = -1;
            this.bf = -1;
            this.wq = 16777215;
            this.pb = 16777215;
        }

        private float b(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return -1.0f;
            }
        }

        private float fx(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private float nr(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0010  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int pn(String str) {
            str.hashCode();
            switch (str) {
                case "stretch":
                    return 4;
                case "baseline":
                    return 3;
                case "center":
                    return 2;
                case "flex_start":
                    return 0;
                case "flex_end":
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.nr.u.C0171u
        public String toString() {
            return "LayoutParams{mWidth=" + this.u + ", mHeight=" + this.nr + ", mMargin=" + this.pn + ", mMarginLeft=" + this.iz + ", mMarginRight=" + this.x + ", mMarginTop=" + this.n + ", mMarginBottom=" + this.f5036a + ", mParams=" + this.qq + ", mOrder=" + this.z + ", mFlexGrow=" + this.gi + ", mFlexShrink=" + this.d + ", mAlignSelf=" + this.h + ", mFlexBasisPercent=" + this.rh + ", mMinWidth=" + this.ja + ", mMinHeight=" + this.bf + ", mMaxWidth=" + this.wq + ", mMaxHeight=" + this.pb + "} " + super.toString();
        }

        @Override // com.bytedance.adsdk.ugeno.nr.u.C0171u
        /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
        public FlexboxLayout.u u() {
            FlexboxLayout.u uVar = new FlexboxLayout.u((int) this.u, (int) this.nr);
            ((ViewGroup.MarginLayoutParams) uVar).leftMargin = (int) this.iz;
            ((ViewGroup.MarginLayoutParams) uVar).rightMargin = (int) this.x;
            ((ViewGroup.MarginLayoutParams) uVar).topMargin = (int) this.n;
            ((ViewGroup.MarginLayoutParams) uVar).bottomMargin = (int) this.f5036a;
            uVar.fx(this.z);
            uVar.b(this.h);
            uVar.u(this.gi);
            uVar.nr(this.d);
            uVar.fx(this.rh);
            return uVar;
        }

        @Override // com.bytedance.adsdk.ugeno.nr.u.C0171u
        public void u(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.u(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasisPercent":
                    this.rh = b(str2);
                    break;
                case "order":
                    this.z = u(str2);
                    break;
                case "flexShrink":
                    this.d = fx(str2);
                    break;
                case "flexGrow":
                    this.gi = nr(str2);
                    break;
                case "alignSelf":
                    this.h = pn(str2);
                    break;
            }
        }

        private int u(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 1;
            }
        }
    }

    public pn(Context context) {
        super(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int k(String str) {
        byte b;
        switch (str.hashCode()) {
            case -1881872635:
                b = !str.equals("stretch") ? (byte) -1 : (byte) 5;
                break;
            case -1364013995:
                if (str.equals("center")) {
                    b = 2;
                    break;
                }
                break;
            case -932331738:
                if (str.equals("space_around")) {
                    b = 3;
                    break;
                }
                break;
            case 1384876188:
                if (str.equals("flex_start")) {
                    b = 0;
                    break;
                }
                break;
            case 1682480591:
                if (str.equals("space_between")) {
                    b = 4;
                    break;
                }
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    b = 1;
                    break;
                }
                break;
        }
        if (b == 0) {
            return 0;
        }
        if (b == 1) {
            return 1;
        }
        if (b == 2) {
            return 2;
        }
        if (b != 3) {
            return b != 4 ? 5 : 3;
        }
        return 4;
    }

    private int l(String str) {
        str.hashCode();
        return !str.equals("wrap") ? 0 : 1;
    }

    private int mv(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "flex_end":
                return 1;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int s(String str) {
        byte b;
        switch (str.hashCode()) {
            case -1881872635:
                b = !str.equals("stretch") ? (byte) -1 : (byte) 4;
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    b = 3;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    b = 2;
                    break;
                }
                break;
            case 1384876188:
                if (str.equals("flex_start")) {
                    b = 0;
                    break;
                }
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    b = 1;
                    break;
                }
                break;
        }
        if (b == 0) {
            return 0;
        }
        if (b == 1) {
            return 1;
        }
        if (b != 2) {
            return b != 3 ? 4 : 3;
        }
        return 2;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: ay, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout u() {
        FlexboxLayout flexboxLayout = new FlexboxLayout(this.nr);
        flexboxLayout.u(this);
        return flexboxLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u
    public u.C0171u n() {
        return new u(this);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        ((FlexboxLayout) this.pn).setFlexDirection(this.ki);
        ((FlexboxLayout) this.pn).setFlexWrap(this.hs);
        ((FlexboxLayout) this.pn).setJustifyContent(this.te);
        ((FlexboxLayout) this.pn).setAlignItems(this.ti);
        ((FlexboxLayout) this.pn).setAlignContent(this.gb);
    }

    public int t(String str) {
        str.hashCode();
        switch (str) {
            case "column_reverse":
                return 3;
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.ti = s(str2);
                break;
            case "flexDirection":
                this.ki = t(str2);
                break;
            case "alignContent":
                this.gb = k(str2);
                break;
            case "flexWrap":
                this.hs = l(str2);
                break;
            case "justifyContent":
                this.te = mv(str2);
                break;
        }
    }
}

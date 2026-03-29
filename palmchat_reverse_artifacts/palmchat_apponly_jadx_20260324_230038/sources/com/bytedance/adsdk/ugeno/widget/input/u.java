package com.bytedance.adsdk.ugeno.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.core.app.NotificationCompat;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.wifi.ad.core.config.EventParams;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends fx<EditText> {
    private int fn;
    private int gb;
    private String gl;
    private float hs;
    private String ic;
    private String je;
    private int ki;
    private String te;
    private int ti;
    private int u;

    public u(Context context) {
        super(context);
        this.u = 1;
        this.ti = Integer.MAX_VALUE;
        this.fn = 2;
    }

    private int l(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 17;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return 2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int t(String str) {
        byte b;
        switch (str.hashCode()) {
            case -1034364087:
                b = !str.equals(EventParams.KEY_PARAM_NUMBER) ? (byte) -1 : (byte) 2;
                break;
            case 3556653:
                if (str.equals("text")) {
                    b = 4;
                    break;
                }
                break;
            case 96619420:
                if (str.equals(NotificationCompat.CATEGORY_EMAIL)) {
                    b = 3;
                    break;
                }
                break;
            case 106642798:
                if (str.equals("phone")) {
                    b = 1;
                    break;
                }
                break;
            case 1216985755:
                if (str.equals("password")) {
                    b = 0;
                    break;
                }
                break;
        }
        if (b == 0) {
            return 128;
        }
        if (b == 1) {
            return 3;
        }
        if (b != 2) {
            return b != 3 ? 1 : 32;
        }
        return 2;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        ((EditText) this.pn).setInputType(this.u);
        ((EditText) this.pn).setText(this.je);
        ((EditText) this.pn).setTextSize(1, this.hs);
        ((EditText) this.pn).setTextColor(this.ki);
        ((EditText) this.pn).setLines(this.gb);
        ((EditText) this.pn).setMaxLines(this.ti);
        ((EditText) this.pn).setGravity(this.fn);
        ((EditText) this.pn).setHint(this.ic);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public EditText u() {
        UGEditText uGEditText = new UGEditText(this.nr);
        uGEditText.u(this);
        return uGEditText;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "textAlign":
                this.fn = l(str2);
                break;
            case "textColor":
                this.ki = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                break;
            case "textStyle":
                this.te = str2;
                break;
            case "textSize":
                this.hs = Float.parseFloat(str2);
                break;
            case "hint":
                this.ic = str2;
                break;
            case "text":
                this.je = str2;
                break;
            case "lines":
                this.gb = Integer.parseInt(str2);
                break;
            case "maxLines":
                this.ti = Integer.parseInt(str2);
                break;
            case "ellipsize":
                this.gl = str2;
                break;
            case "inputType":
                this.u = t(str2);
                break;
        }
    }
}

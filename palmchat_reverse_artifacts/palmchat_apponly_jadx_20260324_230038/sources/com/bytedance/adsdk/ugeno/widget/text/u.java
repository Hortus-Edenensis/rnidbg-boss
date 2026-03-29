package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.nr.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends fx<RichTextView> {
    private int fn;
    private int gb;
    private String gl;
    private float hs;
    private int ki;
    private String te;
    private int ti;
    private String u;

    public u(Context context) {
        super(context);
        this.ti = Integer.MAX_VALUE;
        this.fn = 2;
    }

    private int t(String str) {
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

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        ((RichTextView) this.pn).setRichText(this.u);
        ((RichTextView) this.pn).setTextSize(1, this.hs);
        ((RichTextView) this.pn).setTextColor(this.ki);
        ((RichTextView) this.pn).setLines(this.gb);
        ((RichTextView) this.pn).setMaxLines(this.ti);
        ((RichTextView) this.pn).setGravity(this.fn);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public RichTextView u() {
        RichTextView richTextView = new RichTextView(this.nr);
        richTextView.u(this);
        return richTextView;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "textAlign":
                this.fn = t(str2);
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
            case "text":
                this.u = str2;
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
        }
    }
}

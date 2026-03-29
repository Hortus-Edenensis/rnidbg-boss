package com.bytedance.adsdk.ugeno.widget.u;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.b;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.iz.u;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.adsdk.ugeno.u;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;
import com.bytedance.adsdk.ugeno.widget.text.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends nr {
    private u.C0170u fn;
    private String gb;
    private int gl;
    private String hs;
    private boolean ic;
    private boolean iq;
    private int je;
    private String te;
    private String ti;

    public u(Context context) {
        super(context);
        this.te = "row";
    }

    private void n() {
        if (TextUtils.isEmpty(this.hs)) {
            return;
        }
        ((UGTextView) this.pn).setCompoundDrawables(null, null, null, null);
        if (!this.hs.startsWith("local://")) {
            b.u().nr().u(this.f5034a, this.hs, new u.InterfaceC0173u() { // from class: com.bytedance.adsdk.ugeno.widget.u.u.1
                @Override // com.bytedance.adsdk.ugeno.u.InterfaceC0173u
                public void u(final Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    n.u(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.u.u.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            u.this.nr(new BitmapDrawable(((fx) u.this).nr.getResources(), bitmap));
                        }
                    });
                }
            });
            return;
        }
        try {
            String strReplace = this.hs.replace("local://", "");
            Context context = this.nr;
            nr(n.u(context, com.bytedance.adsdk.ugeno.iz.b.nr(context, strReplace)));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void bc() {
        super.bc();
        if (this.ic) {
            ((UGTextView) this.pn).setTextColor(this.je);
        }
        if (this.iq) {
            if (this.ex) {
                u(this.fn);
            } else {
                fx(this.gl);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.nr, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        n();
        ((UGTextView) this.pn).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void xw() {
        super.xw();
        if (this.ic) {
            ((UGTextView) this.pn).setTextColor(((nr) this).ki);
        }
        if (this.iq) {
            if (this.ex) {
                u(this.df);
            } else {
                fx(this.m);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.nr, com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "direction":
                this.te = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.je = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                this.ic = true;
                break;
            case "image":
                this.hs = str2;
                break;
            case "highlightImage":
                this.ti = str2;
                break;
            case "highlightBackgroundColor":
                if (com.bytedance.adsdk.ugeno.iz.u.fx(str2)) {
                    this.ex = true;
                    this.fn = com.bytedance.adsdk.ugeno.iz.u.nr(str2);
                } else {
                    this.gl = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                    this.ex = false;
                }
                this.iq = true;
                break;
            case "highlightBackgroundImage":
                this.gb = str2;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nr(Drawable drawable) {
        byte b;
        if (drawable == null) {
            return;
        }
        String str = this.te;
        switch (str.hashCode()) {
            case -1781065991:
                b = !str.equals("column_reverse") ? (byte) -1 : (byte) 2;
                break;
            case -1354837162:
                if (str.equals("column")) {
                    b = 1;
                    break;
                }
                break;
            case -207799939:
                if (str.equals("row_reverse")) {
                    b = 0;
                    break;
                }
                break;
            case 113114:
                if (str.equals("row")) {
                    b = 3;
                    break;
                }
                break;
        }
        if (b == 0) {
            ((UGTextView) this.pn).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            return;
        }
        if (b == 1) {
            ((UGTextView) this.pn).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (b != 2) {
            ((UGTextView) this.pn).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ((UGTextView) this.pn).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        }
    }
}

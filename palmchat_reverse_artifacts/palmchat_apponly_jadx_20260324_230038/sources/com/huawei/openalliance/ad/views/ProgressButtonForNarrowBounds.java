package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ProgressButtonForNarrowBounds extends ProgressButton {
    public ProgressButtonForNarrowBounds(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.ad.views.ProgressButton
    public void Code(int i, int i2) {
        int width;
        int width2;
        synchronized (this.D) {
            if (this.e) {
                width = (getWidth() / 2) - this.Code.centerX();
                if (this.d && width < this.f6980a) {
                    width = getTextStart();
                }
                width2 = this.Code.width() + width;
            } else {
                width = (getWidth() - this.Code.width()) - z.V(getContext(), 1.0f);
                if (this.d && width < this.f6980a) {
                    width = getTextStart();
                }
                width2 = getWidth();
            }
            Drawable drawable = this.F;
            if (drawable != null) {
                drawable.setBounds(width, 0, width2, i2);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.ProgressButton
    public int getTextStart() {
        if (bg.C()) {
            return this.c;
        }
        int width = ((getWidth() - this.Code.width()) - this.f) - z.V(getContext(), 8.0f);
        int i = this.b;
        if (width < i) {
            width = i;
        }
        fh.V("ProgressButtonNew", "safeTextStart: %s", Integer.valueOf(width));
        return width;
    }

    public ProgressButtonForNarrowBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.openalliance.ad.views.ProgressButton
    public void Code(Canvas canvas) {
        int width;
        int height;
        Rect rect;
        synchronized (this.D) {
            CharSequence charSequence = this.I;
            if (charSequence != null && charSequence.length() > 0) {
                String strIntern = this.I.toString().intern();
                if (this.e) {
                    width = (getWidth() / 2) - this.Code.centerX();
                    if (this.d && width < this.f6980a) {
                        width = getTextStart();
                    }
                    height = getHeight() / 2;
                    rect = this.Code;
                } else {
                    width = (getWidth() - this.Code.width()) - z.V(getContext(), 1.0f);
                    if (this.d && width < this.f6980a) {
                        width = getTextStart();
                    }
                    height = getHeight() / 2;
                    rect = this.Code;
                }
                canvas.drawText((CharSequence) strIntern, 0, strIntern.length(), width, height - rect.centerY(), this.V);
                Code(getWidth(), getHeight());
            }
        }
    }

    public ProgressButtonForNarrowBounds(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

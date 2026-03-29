package com.zenmen.palmchat.route;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import com.zenmen.palmchat.R;
import defpackage.h5;
import defpackage.mb4;
import defpackage.ve;
import defpackage.y56;
import defpackage.yn2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PagerRouter implements yn2 {
    @Override // defpackage.yn2
    public void c(Activity activity, String str, boolean z) {
        ve.o(activity, str, z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ActionSpan extends URLSpan {
        private String contactRelate;
        public int end;
        private int mColor;
        private Context mContext;
        private h5 mListener;
        private y56 mProperty;
        private String mUrl;
        public int start;

        public ActionSpan(Context context, String str, int i, int i2, y56 y56Var, h5 h5Var) {
            super(str);
            this.mColor = -1;
            this.mContext = context;
            this.mUrl = str;
            this.start = i;
            this.end = i2;
            this.mProperty = y56Var;
            onShow();
        }

        private Integer getFontColor() {
            y56 y56Var = this.mProperty;
            if (y56Var != null && !TextUtils.isEmpty(y56Var.h())) {
                try {
                    return Integer.valueOf(Color.parseColor(this.mProperty.h()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            if ("onLongClick".equals(view.getTag())) {
                view.setTag(null);
            } else {
                if (TextUtils.isEmpty(this.mUrl)) {
                    return;
                }
                mb4.g(this.mUrl);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            Integer fontColor = getFontColor();
            if (fontColor != null) {
                textPaint.setColor(fontColor.intValue());
                return;
            }
            int i = this.mColor;
            if (-1 != i) {
                textPaint.setColor(i);
            } else {
                textPaint.setColor(this.mContext.getResources().getColor(R.color.text_color_secretary));
            }
        }

        public ActionSpan(Context context, String str, int i, int i2, int i3, y56 y56Var, h5 h5Var) {
            super(str);
            this.mContext = context;
            this.mUrl = str;
            this.start = i;
            this.end = i2;
            this.mColor = i3;
            this.mProperty = y56Var;
            onShow();
        }

        public ActionSpan(Context context, String str, int i, int i2, int i3, y56 y56Var, String str2, h5 h5Var) {
            super(str);
            this.mContext = context;
            this.mUrl = str;
            this.start = i;
            this.end = i2;
            this.mColor = i3;
            this.mProperty = y56Var;
            this.contactRelate = str2;
            onShow();
        }

        private void onShow() {
        }
    }
}

package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.b.t;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.adexpress.widget.AnimationText;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.q;
import com.huawei.openalliance.ad.constant.az;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicTextView extends DynamicBaseWidgetImp {
    public DynamicTextView(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        this.n += 6;
        if (this.l.jp()) {
            AnimationText animationText = new AnimationText(context, this.l.x(), this.l.pn(), 1, this.l.n());
            this.k = animationText;
            animationText.setMaxLines(1);
        } else {
            TextView textView = new TextView(context);
            this.k = textView;
            textView.setIncludeFontPadding(false);
        }
        this.k.setTag(Integer.valueOf(getClickArea()));
        addView(this.k, getWidgetLayoutParams());
    }

    private boolean a() {
        DynamicRootView dynamicRootView = this.s;
        return (dynamicRootView == null || dynamicRootView.getRenderRequest() == null || this.s.getRenderRequest().mv() == 4) ? false : true;
    }

    private void jk() {
        int iU;
        if (TextUtils.equals(this.mv.jk().getType(), az.at) || TextUtils.equals(this.mv.jk().getType(), "title") || TextUtils.equals(this.mv.jk().getType(), "text_star")) {
            int[] iArrNr = t.nr(this.l.iz(), this.l.pn(), true);
            int iU2 = (int) com.bytedance.sdk.component.adexpress.b.n.u(getContext(), this.l.nr());
            int iU3 = (int) com.bytedance.sdk.component.adexpress.b.n.u(getContext(), this.l.fx());
            int iU4 = (int) com.bytedance.sdk.component.adexpress.b.n.u(getContext(), this.l.b());
            int iU5 = (int) com.bytedance.sdk.component.adexpress.b.n.u(getContext(), this.l.u());
            int iMin = Math.min(iU2, iU5);
            if (TextUtils.equals(this.mv.jk().getType(), az.at) && (iU = ((this.n - ((int) com.bytedance.sdk.component.adexpress.b.n.u(getContext(), this.l.pn()))) - iU2) - iU5) > 1 && iU <= iMin * 2) {
                int i = iU / 2;
                this.k.setPadding(iU3, iU2 - i, iU4, iU5 - (iU - i));
                return;
            }
            int i2 = (((iArrNr[1] + iU2) + iU5) - this.n) - 2;
            if (i2 <= 1) {
                return;
            }
            if (i2 <= iMin * 2) {
                int i3 = i2 / 2;
                this.k.setPadding(iU3, iU2 - i3, iU4, iU5 - (i2 - i3));
            } else if (i2 > iU2 + iU5) {
                final int i4 = (i2 - iU2) - iU5;
                this.k.setPadding(iU3, 0, iU4, 0);
                if (i4 <= ((int) com.bytedance.sdk.component.adexpress.b.n.u(getContext(), 1.0f)) + 1) {
                    ((TextView) this.k).setTextSize(this.l.pn() - 1.0f);
                } else if (i4 <= (((int) com.bytedance.sdk.component.adexpress.b.n.u(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.k).setTextSize(this.l.pn() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTextView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = DynamicTextView.this.k.getLayoutParams();
                                DynamicTextView dynamicTextView = DynamicTextView.this;
                                layoutParams.height = dynamicTextView.n + i4;
                                dynamicTextView.k.setLayoutParams(layoutParams);
                                DynamicTextView.this.k.setTranslationY(-i4);
                                ((ViewGroup) DynamicTextView.this.k.getParent()).setClipChildren(false);
                                ((ViewGroup) DynamicTextView.this.k.getParent().getParent()).setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (iU2 > iU5) {
                this.k.setPadding(iU3, iU2 - (i2 - iMin), iU4, iU5 - iMin);
            } else {
                this.k.setPadding(iU3, iU2 - iMin, iU4, iU5 - (i2 - iMin));
            }
        }
        if (TextUtils.equals(this.mv.jk().getType(), "fillButton")) {
            this.k.setTextAlignment(2);
            ((TextView) this.k).setGravity(17);
        }
    }

    private void t() {
        if (this.k instanceof AnimationText) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException unused) {
                arrayList.add(text);
            }
            ((AnimationText) this.k).setMaxLines(1);
            ((AnimationText) this.k).setTextColor(this.l.x());
            ((AnimationText) this.k).setTextSize(this.l.pn());
            ((AnimationText) this.k).setAnimationText(arrayList);
            ((AnimationText) this.k).setAnimationType(this.l.bc());
            ((AnimationText) this.k).setAnimationDuration(this.l.y() * 1000);
            ((AnimationText) this.k).u();
        }
    }

    public String getText() {
        String strIz = this.l.iz();
        if (TextUtils.isEmpty(strIz)) {
            if (!com.bytedance.sdk.component.adexpress.b.u() && TextUtils.equals(this.mv.jk().getType(), "text_star")) {
                strIz = "5";
            }
            if (!com.bytedance.sdk.component.adexpress.b.u() && TextUtils.equals(this.mv.jk().getType(), "score-count")) {
                strIz = "6870";
            }
        }
        return (TextUtils.equals(this.mv.jk().getType(), "title") || TextUtils.equals(this.mv.jk().getType(), MediaFormat.KEY_SUBTITLE)) ? strIz.replace("\n", "") : strIz;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        int i;
        double d;
        super.n();
        if (TextUtils.isEmpty(getText())) {
            this.k.setVisibility(4);
            return true;
        }
        if (this.l.jp()) {
            t();
            return true;
        }
        ((TextView) this.k).setText(this.l.iz());
        ((TextView) this.k).setTextDirection(5);
        this.k.setTextAlignment(this.l.n());
        ((TextView) this.k).setTextColor(this.l.x());
        ((TextView) this.k).setTextSize(this.l.pn());
        if (this.l.c()) {
            int iQ = this.l.q();
            if (iQ > 0) {
                ((TextView) this.k).setLines(iQ);
                ((TextView) this.k).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.k).setMaxLines(1);
            ((TextView) this.k).setGravity(17);
            ((TextView) this.k).setEllipsize(TextUtils.TruncateAt.END);
        }
        n nVar = this.mv;
        if (nVar != null && nVar.jk() != null) {
            if (com.bytedance.sdk.component.adexpress.b.u() && a() && (TextUtils.equals(this.mv.jk().getType(), "text_star") || TextUtils.equals(this.mv.jk().getType(), "score-count") || TextUtils.equals(this.mv.jk().getType(), "score-count-type-1") || TextUtils.equals(this.mv.jk().getType(), "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (TextUtils.equals(this.mv.jk().getType(), "score-count") || TextUtils.equals(this.mv.jk().getType(), "score-count-type-2")) {
                try {
                    try {
                        i = Integer.parseInt(getText());
                    } catch (NumberFormatException unused) {
                        i = -1;
                    }
                    if (i < 0) {
                        if (com.bytedance.sdk.component.adexpress.b.u()) {
                            setVisibility(8);
                            return true;
                        }
                        this.k.setVisibility(0);
                    }
                    if (TextUtils.equals(this.mv.jk().getType(), "score-count-type-2")) {
                        ((TextView) this.k).setText(String.format(new DecimalFormat("(###,###,###)").format(i), Integer.valueOf(i)));
                        ((TextView) this.k).setGravity(17);
                        return true;
                    }
                    u((TextView) this.k, i, getContext(), "tt_comment_num");
                } catch (Exception unused2) {
                }
            } else if (TextUtils.equals(this.mv.jk().getType(), "text_star")) {
                try {
                    d = Double.parseDouble(getText());
                } catch (Exception e) {
                    k.nr("DynamicStarView applyNativeStyle", e.toString());
                    d = -1.0d;
                }
                if (d < 0.0d || d > 5.0d) {
                    if (com.bytedance.sdk.component.adexpress.b.u()) {
                        setVisibility(8);
                        return true;
                    }
                    this.k.setVisibility(0);
                }
                ((TextView) this.k).setIncludeFontPadding(false);
                ((TextView) this.k).setText(String.format("%.1f", Double.valueOf(d)));
            } else if (TextUtils.equals("privacy-detail", this.mv.jk().getType())) {
                ((TextView) this.k).setText("功能 | 权限 | 隐私");
            } else if (TextUtils.equals(this.mv.jk().getType(), "development-name")) {
                ((TextView) this.k).setText(q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_text_privacy_development") + getText());
            } else if (TextUtils.equals(this.mv.jk().getType(), "app-version")) {
                ((TextView) this.k).setText(q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_text_privacy_app_version") + getText());
            } else {
                ((TextView) this.k).setText(getText());
            }
            this.k.setTextAlignment(this.l.n());
            ((TextView) this.k).setGravity(this.l.a());
            if (com.bytedance.sdk.component.adexpress.b.u()) {
                jk();
            }
        }
        return true;
    }

    public void u(TextView textView, int i, Context context, String str) {
        textView.setText("(" + String.format(q.u(context, str), Integer.valueOf(i)) + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }
}

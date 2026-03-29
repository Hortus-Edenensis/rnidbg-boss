package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends com.bytedance.adsdk.ugeno.widget.text.nr {
    private String gb;
    private String gl;
    private String hs;
    private String te;
    private String ti;

    public fx(Context context) {
        super(context);
    }

    public void l(String str) {
        ((UGTextView) this.pn).setText(str);
        try {
            float fMeasureText = ((UGTextView) this.pn).getPaint().measureText(str);
            if (fMeasureText >= 0.0f) {
                b((int) fMeasureText);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.nr, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        l(((com.bytedance.adsdk.ugeno.widget.text.nr) this).u);
        ((UGTextView) this.pn).setGravity(17);
    }

    public void u(int i, int i2, int i3, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("remain", i);
            jSONObject.put("index", i2);
            jSONObject.put("count", i3);
            Matcher matcher = Pattern.compile("\\$\\{([^}]+)\\}").matcher(z ? i2 == 1 ? this.ti : this.gb : z2 ? this.te : this.hs);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(jSONObject.optString(matcher.group(1), "")));
            }
            matcher.appendTail(stringBuffer);
            String string = stringBuffer.toString();
            this.gl = string;
            l(string);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.nr, com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "text1":
                this.hs = str2;
                break;
            case "text2":
                this.te = str2;
                break;
            case "text3":
                this.ti = str2;
                break;
            case "text4":
                this.gb = str2;
                break;
        }
    }
}

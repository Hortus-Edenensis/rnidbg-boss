package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.b.nr;
import com.bytedance.sdk.component.adexpress.nr.mv;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.q;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.dc;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t {
    private static String nr;
    private static final Set<String> u = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", "close", "close-fill", "webview-close")));

    public static double nr(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:218:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0488 A[Catch: Exception -> 0x049a, TryCatch #1 {Exception -> 0x049a, blocks: (B:219:0x047e, B:221:0x0488, B:226:0x0492), top: B:272:0x047e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static nr.fx u(String str, String str2, String str3, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar, double d, int i2, double d2, String str4, mv mvVar) {
        String str5;
        int i3;
        int i4;
        int i5;
        float fOptDouble;
        float fOptDouble2;
        float fOptDouble3;
        float f;
        float f2;
        float f3;
        com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn;
        String strOptString = str;
        int i6 = i;
        String strIz = mvVar.iz();
        int iJk = mvVar.jk();
        if (com.bytedance.sdk.component.adexpress.b.u() && i2 != 4 && (TextUtils.equals(str2, "text_star") || TextUtils.equals(str2, "score-count") || TextUtils.equals(str2, "score-count-type-1") || TextUtils.equals(str2, "score-count-type-2"))) {
            return new nr.fx(0.0f, 0.0f);
        }
        nr.fx fxVar = new nr.fx();
        if (strOptString.startsWith("<svg") || u.contains(str2)) {
            try {
                if ("close".equals(str2) || (com.bytedance.sdk.component.adexpress.b.u() && "close-fill".equals(str2))) {
                    float fOptDouble4 = (float) new JSONObject(str3).optDouble("fontSize");
                    fxVar.u = fOptDouble4;
                    fxVar.nr = fOptDouble4;
                    return fxVar;
                }
            } catch (Exception unused) {
            }
            fxVar.u = 10.0f;
            fxVar.nr = 10.0f;
            return fxVar;
        }
        if ("logo".equals(str2)) {
            if (!com.bytedance.sdk.component.adexpress.b.u() && ((!TextUtils.isEmpty(str) && strOptString.contains("adx:")) || nr())) {
                return nr() ? u(fxVar, strOptString, str3, nr) : u(fxVar, strOptString, str3, "");
            }
            fxVar.u = "union".equals(strOptString) ? 10.0f : 20.0f;
            fxVar.nr = 10.0f;
            if (com.bytedance.sdk.component.adexpress.b.u()) {
                String str6 = str2 + strOptString;
                float fNr = (float) nr(str3);
                if (str6.contains("logoad")) {
                    return u(q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_logo_en"), str3);
                }
                fxVar.nr = fNr;
            }
            return fxVar;
        }
        if ("development-name".equals(str2)) {
            StringBuilder sb = new StringBuilder();
            str5 = "";
            sb.append(q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_text_privacy_development"));
            sb.append(strOptString);
            strOptString = sb.toString();
        } else {
            str5 = "";
        }
        if ("app-version".equals(str2)) {
            StringBuilder sb2 = new StringBuilder();
            i3 = iJk;
            sb2.append(q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_text_privacy_app_version"));
            sb2.append(strOptString);
            strOptString = sb2.toString();
        } else {
            i3 = iJk;
        }
        if ("score-count".equals(str2)) {
            try {
                i4 = Integer.parseInt(strOptString);
            } catch (NumberFormatException unused2) {
                i4 = 0;
            }
            if (com.bytedance.sdk.component.adexpress.b.u() && i4 < 0) {
                return new nr.fx(0.0f, 0.0f);
            }
            return u("(" + String.format(q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_comment_num"), Integer.valueOf(i4)) + ")", str3);
        }
        if ("score-count-type-2".equals(str2)) {
            try {
                i5 = Integer.parseInt(strOptString);
            } catch (NumberFormatException unused3) {
                i5 = 0;
            }
            if (com.bytedance.sdk.component.adexpress.b.u() && i5 < 0) {
                return new nr.fx(0.0f, 0.0f);
            }
            return u("(" + String.format(new DecimalFormat("###,###,###").format(i5), Integer.valueOf(i5)) + ")", str3);
        }
        if ("feedback-dislike".equals(str2)) {
            if (!com.bytedance.sdk.component.adexpress.b.u()) {
                return u(q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_reward_feedback"), str3);
            }
            nr.fx fxVar2 = new nr.fx();
            float fNr2 = (float) nr(str3);
            fxVar2.u = fNr2;
            fxVar2.nr = fNr2;
            return fxVar2;
        }
        if ("skip-with-time-countdown".equals(str2) || TextUtils.equals("skip-with-countdowns-video-countdown", str2)) {
            return (mvVar.fx() && com.bytedance.sdk.component.adexpress.b.x.nr(strIz)) ? ((int) (d + 0.5d)) - i3 < 10 ? com.bytedance.sdk.component.adexpress.b.u() ? u("0s", str3) : u(String.format(q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_reward_full_skip"), "0"), str3) : com.bytedance.sdk.component.adexpress.b.u() ? u("00s", str3) : u(String.format(q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_reward_full_skip"), "00"), str3) : d < 10.0d ? u("0S", str3) : u("00S", str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-btn", str2)) {
            return u("| " + q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_reward_screen_skip_tx"), str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-countdown", str2)) {
            return u("| ".concat(String.valueOf(String.format(q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_reward_full_skip_count_down"), "00"))), str3);
        }
        if ("skip-with-time-skip-btn".equals(str2)) {
            nr.fx fxVarU = u("| " + q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_reward_screen_skip_tx"), str3);
            if (com.bytedance.sdk.component.adexpress.b.u()) {
                try {
                    fxVarU.nr = (float) ((((double) fxVarU.nr) * new JSONObject(str3).optDouble("lineHeight")) / 1.2d);
                } catch (Throwable unused4) {
                }
                fxVarU.u = fxVarU.nr;
            }
            return fxVarU;
        }
        if (dc.F.equals(str2)) {
            return u(q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_reward_screen_skip_tx"), str3);
        }
        if ("timedown".equals(str2)) {
            return u("0.0", str3);
        }
        if ("text_star".equals(str2)) {
            return (!com.bytedance.sdk.component.adexpress.b.u() || (d2 >= 0.0d && d2 <= 5.0d)) ? u("0.0", str3) : new nr.fx(0.0f, 0.0f);
        }
        if (TextUtils.equals("privacy-detail", str2)) {
            return u("功能 | 权限 | 隐私", str3);
        }
        if ("arrowButton".equals(str2)) {
            return u("Download", str3);
        }
        if ("text".equals(str2) && com.bytedance.sdk.component.adexpress.b.u() && TextUtils.isEmpty(strOptString) && (izVarPn = nVar.jk().pn()) != null) {
            strOptString = izVarPn.za() != null ? nVar.jk().pn().za().optString(com.bytedance.sdk.component.adexpress.b.n.b(com.bytedance.sdk.component.adexpress.b.getContext())) : str5;
        }
        if ("fillButton".equals(str2) || "text".equals(str2) || "button".equals(str2) || "downloadWithIcon".equals(str2) || "downloadButton".equals(str2) || "laceButton".equals(str2) || "cardButton".equals(str2) || "colourMixtureButton".equals(str2) || "arrowButton".equals(str2) || ((az.at.equals(str2) && !(com.bytedance.sdk.component.adexpress.b.u() && "open_ad".equals(strIz))) || TextUtils.equals("app-version", str2) || TextUtils.equals("development-name", str2))) {
            return u(strOptString, str3);
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int length = strOptString.length();
            fOptDouble = (float) jSONObject.optDouble("fontSize");
            float fOptDouble5 = (float) jSONObject.optDouble("letterSpacing");
            fOptDouble2 = (float) jSONObject.optDouble("lineHeight");
            fOptDouble3 = (float) jSONObject.optDouble("maxWidth");
            f = (length * (fOptDouble + fOptDouble5)) - fOptDouble5;
            k.nr("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + fOptDouble5 + ",lineHeight==" + fOptDouble2 + ",maxWidth ==" + fOptDouble3 + ",totalStrLength" + f);
        } catch (JSONException unused5) {
        }
        if ("muted".equals(str2)) {
            fxVar.u = fOptDouble;
            fxVar.nr = fOptDouble;
            return fxVar;
        }
        if ("star".equals(str2)) {
            if (com.bytedance.sdk.component.adexpress.b.u() && (d2 < 0.0d || d2 > 5.0d || i2 != 4)) {
                return new nr.fx(0.0f, 0.0f);
            }
            nr.fx fxVarU2 = u("str", str3);
            fxVarU2.u = fOptDouble * 5.0f;
            return fxVarU2;
        }
        if ("icon".equals(str2)) {
            fxVar.u = fOptDouble;
            fxVar.nr = fOptDouble;
            return fxVar;
        }
        if (z) {
            int i7 = ((int) (f / fOptDouble3)) + 1;
            if (z2 && i7 >= i6) {
                i7 = i6;
            }
            f2 = (float) (((double) (fOptDouble2 * fOptDouble * i7)) * 1.2d);
        } else {
            f2 = (float) (((double) (fOptDouble2 * fOptDouble)) * 1.2d);
            if (f <= fOptDouble3) {
                f3 = f;
                if (!"title".equals(str2) || (com.bytedance.sdk.component.adexpress.b.u() && "open_ad".equals(strIz) && az.at.equals(str2))) {
                    try {
                        nr.fx fxVarU3 = u(strOptString.replace('\n', ' '), str3, false);
                        if (z) {
                            int i8 = ((int) (f / fOptDouble3)) + 1;
                            if (!z2 || i8 < i6) {
                                i6 = i8;
                            }
                            fxVarU3.nr *= i6;
                        }
                        return fxVarU3;
                    } catch (Exception unused6) {
                    }
                }
                fxVar.u = f3;
                fxVar.nr = f2;
                return fxVar;
            }
        }
        f3 = fOptDouble3;
        if (!"title".equals(str2)) {
            nr.fx fxVarU32 = u(strOptString.replace('\n', ' '), str3, false);
            if (z) {
            }
            return fxVarU32;
        }
        return fxVar;
    }

    public static int[] nr(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.b.getContext());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static boolean nr() {
        return !TextUtils.isEmpty(nr);
    }

    public static String u(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    private static nr.fx u(nr.fx fxVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            fxVar.u = 0.0f;
            fxVar.nr = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = u(str);
            }
            if (TextUtils.isEmpty(str3)) {
                fxVar.u = 0.0f;
                fxVar.nr = 0.0f;
            } else {
                return u(str3, str2);
            }
        }
        return fxVar;
    }

    public static nr.fx u(String str, String str2) {
        return u(str, str2, false);
    }

    public static nr.fx u(String str, String str2, boolean z) {
        nr.fx fxVar = new nr.fx();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] iArrU = u(str, (float) nr(str2), z);
            fxVar.u = iArrU[0];
            fxVar.nr = iArrU[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                fxVar.nr = 0.0f;
            }
        } catch (Exception unused) {
        }
        return fxVar;
    }

    public static int[] u(String str, float f, boolean z) {
        int[] iArrNr = nr(str, f, z);
        return new int[]{com.bytedance.sdk.component.adexpress.b.n.nr(com.bytedance.sdk.component.adexpress.b.getContext(), iArrNr[0]), com.bytedance.sdk.component.adexpress.b.n.nr(com.bytedance.sdk.component.adexpress.b.getContext(), iArrNr[1])};
    }

    public static String u() {
        return nr;
    }
}

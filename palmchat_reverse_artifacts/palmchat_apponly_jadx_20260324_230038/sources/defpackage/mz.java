package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class mz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19394a;
    public String b;
    public String c;
    public boolean d;

    public mz(JSONObject jSONObject, String str, String str2, boolean z) {
        this.d = z;
        this.f19394a = str;
        this.b = str2;
        LogUtil.i("CaptchaParams", "init data=" + jSONObject);
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("modeType");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.c = strOptString;
        }
    }

    public String a() {
        return TextUtils.isEmpty(this.c) ? "slide" : this.c;
    }

    public mz b(String str) {
        this.c = str;
        return this;
    }
}

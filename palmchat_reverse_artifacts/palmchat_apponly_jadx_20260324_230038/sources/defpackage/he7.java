package defpackage;

import android.content.Context;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class he7 implements j8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17944a;
    public final String b;
    public nl2 c;

    public he7(Context context, String str) {
        Log.d("AGC_FlexibleDecrypt", "init");
        this.f17944a = context;
        this.b = str;
    }

    @Override // defpackage.j8
    public String a(String str, String str2) {
        if (this.c == null) {
            this.c = b();
        }
        if (this.c == null) {
            Log.w("AGC_FlexibleDecrypt", "decrypt Flexible Decrypt error, use old instead");
            this.c = new pd7(this.f17944a, this.b).b();
        }
        return this.c.a(ig7.b(this.f17944a, this.b, "agc_plugin_", str), str2);
    }

    public nl2 b() {
        String strB = ig7.b(this.f17944a, this.b, "agc_plugin_", "crypto_component");
        if (strB == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(nh2.b(strB), "utf-8"));
            return new yb7(new c87(jSONObject.getString("rx"), jSONObject.getString("ry"), jSONObject.getString("rz"), jSONObject.getString("salt"), jSONObject.getString("algorithm"), jSONObject.getInt("iterationCount")));
        } catch (UnsupportedEncodingException | IllegalArgumentException | JSONException e) {
            Log.e("AGC_FlexibleDecrypt", "FlexibleDecrypt exception: " + e.getMessage());
            return null;
        }
    }
}

package defpackage;

import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class k56 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18580a;

    public k56(String str) {
        this.f18580a = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v17 */
    @Override // java.lang.Runnable
    public void run() {
        File[] fileArrD;
        ?? r6;
        if (xn1.h().m() && (fileArrD = xn1.h().g().d()) != null) {
            for (File file : fileArrD) {
                v.a("start upload file:" + file.getAbsolutePath(), new Object[0]);
                if (file.length() > 51200) {
                    file.delete();
                } else {
                    if (TextUtils.isEmpty(this.f18580a)) {
                        return;
                    }
                    String strN = xn.n(this.f18580a, xn1.h().i("005011", un.b(file, "utf-8")));
                    v.a("JSON:" + strN, new Object[0]);
                    if (strN != null && strN.length() != 0) {
                        try {
                            JSONObject jSONObject = new JSONObject(strN);
                            ?? Equals = "0".equals(jSONObject.getString(WkParams.RETCD));
                            v.a("retcode=%s,retmsg=%s", Integer.valueOf((int) Equals), jSONObject.has(WkParams.RETMSG) ? jSONObject.getString(WkParams.RETMSG) : null);
                            r6 = Equals;
                        } catch (JSONException e) {
                            v.c(e);
                            r6 = 30;
                        }
                        if (r6 == 1) {
                            xn1.h().g().g(file.getName());
                        }
                    }
                }
            }
        }
    }
}

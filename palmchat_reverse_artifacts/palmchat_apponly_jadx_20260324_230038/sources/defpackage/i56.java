package defpackage;

import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import com.zm.fda.Z2500.O022Z;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class i56 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18109a;

    public i56(String str) {
        this.f18109a = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v15 */
    @Override // java.lang.Runnable
    public void run() {
        ne neVarF;
        File[] fileArrC;
        ?? r7;
        if (xn1.h().m() && (fileArrC = (neVarF = xn1.h().f()).c()) != null) {
            for (File file : fileArrC) {
                v.f("start upload file:" + file.getAbsolutePath());
                if (file.length() > O022Z.k) {
                    file.delete();
                } else {
                    if (TextUtils.isEmpty(this.f18109a)) {
                        return;
                    }
                    String strN = xn.n(this.f18109a, xn1.h().d("005011", un.b(file, "utf-8")));
                    v.f("JSON:" + strN);
                    if (strN != null && strN.length() != 0) {
                        try {
                            JSONObject jSONObject = new JSONObject(strN);
                            ?? Equals = "0".equals(jSONObject.getString(WkParams.RETCD));
                            v.a("retcode=%s,retmsg=%s", Integer.valueOf((int) Equals), jSONObject.has(WkParams.RETMSG) ? jSONObject.getString(WkParams.RETMSG) : null);
                            r7 = Equals;
                        } catch (JSONException e) {
                            v.c(e);
                            r7 = 30;
                        }
                        if (r7 == 1) {
                            neVarF.e(file.getName());
                        }
                    }
                }
            }
        }
    }
}

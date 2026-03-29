package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cp {
    public static void a(Context context, String str) {
        try {
            a(context, str, null, false, true);
        } catch (Throwable unused) {
        }
    }

    public static void a(final Context context, String str, final String str2, final boolean z, boolean z2) {
        JSONObject jSONObject;
        try {
            String str3 = cu.f7451a + cu.e;
            String strA = cv.a(context);
            if (!TextUtils.isEmpty(strA)) {
                if (!cu.a() || str2 == null) {
                    str3 = str3 + Constants.STRING_VALUE_UNSET + strA;
                } else {
                    str3 = str3 + "?logId=" + str2 + ContainerUtils.FIELD_DELIMITER + strA;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z2) {
                jSONObject = new JSONObject();
                String strC = new bn(context).c(str);
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject.put("data", strC);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            l lVarA = l.a(context);
            m mVar = new m(str3, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            lVarA.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cp.1
                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str4) {
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    try {
                        if (str2.equals(ck.b)) {
                            df.a(context).a(System.currentTimeMillis());
                        } else if (str2.equals(ck.c)) {
                            df.a(context).a(df.bj, System.currentTimeMillis());
                        } else if (str2.equals(ck.d)) {
                            df.a(context).a(df.bi, System.currentTimeMillis());
                        } else if (str2.equals(ck.g)) {
                            df.a(context).a(df.bm, System.currentTimeMillis());
                        } else if (str2.equals(ck.i)) {
                            df.a(context).a(df.bh, System.currentTimeMillis());
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str4) {
                    if (z) {
                        TextUtils.isEmpty(str2);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}

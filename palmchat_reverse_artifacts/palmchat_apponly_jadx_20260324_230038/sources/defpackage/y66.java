package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.bridge.risk.RiskConfig;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class y66 {
    public static y66 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f22150a;
    public RiskConfig b;

    public y66() {
        String strC = yi1.c();
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        i(strC);
    }

    public static y66 b() {
        if (c == null) {
            synchronized (y66.class) {
                if (c == null) {
                    c = new y66();
                }
            }
        }
        return c;
    }

    public static boolean g() {
        return c != null;
    }

    public String a(ContactInfoItem contactInfoItem) {
        if (this.f22150a != null && contactInfoItem != null && !e(contactInfoItem.getUid())) {
            int accountType = contactInfoItem.getAccountType();
            if (accountType == -2) {
                return this.f22150a.optString("chat_30");
            }
            if (accountType == -3) {
                return this.f22150a.optString("chat_40");
            }
            if (accountType == -4) {
                return this.f22150a.optString("chat_50");
            }
        }
        return null;
    }

    public String c(ContactInfoItem contactInfoItem) {
        if (this.f22150a != null && contactInfoItem != null) {
            int accountType = contactInfoItem.getAccountType();
            if (accountType == -2) {
                return this.f22150a.optString("profile_30");
            }
            if (accountType == -3) {
                return this.f22150a.optString("profile_40");
            }
            if (accountType == -4) {
                return this.f22150a.optString("profile_50");
            }
        }
        return null;
    }

    public RiskConfig d() {
        return this.b;
    }

    public boolean e(String str) {
        return SPUtil.f14322a.a(SPUtil.SCENE.CHAT_RISK, k86.a("key_chat_risk_banner_ignore" + str), false);
    }

    public boolean f(ContactInfoItem contactInfoItem) {
        if (this.f22150a != null && contactInfoItem != null) {
            int accountType = contactInfoItem.getAccountType();
            if (accountType == -2) {
                return this.f22150a.optBoolean("closure_30", false);
            }
            if (accountType == -3) {
                return this.f22150a.optBoolean("closure_40", false);
            }
            if (accountType == -4) {
                return this.f22150a.optBoolean("closure_50", true);
            }
        }
        return false;
    }

    public void h(String str) {
        SPUtil.f14322a.t(SPUtil.SCENE.CHAT_RISK, k86.a("key_chat_risk_banner_ignore" + str), Boolean.TRUE);
    }

    public void i(String str) {
        try {
            this.f22150a = new JSONObject(str);
            this.b = (RiskConfig) az2.a(str, RiskConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

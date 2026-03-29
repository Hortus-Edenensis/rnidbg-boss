package defpackage;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class rw6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f20598a = new HashMap();

    public static /* synthetic */ String d(String str, String str2, NumberFormatException numberFormatException) {
        return "getLong key=" + str + ", value=" + str2 + ", exception=" + numberFormatException.toString();
    }

    public long b(final String str, long j) {
        final String str2 = this.f20598a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return j;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            n87.c("MemoryPreference", new la7() { // from class: kt6
                @Override // defpackage.la7
                public final Object get() {
                    return rw6.d(str, str2, e);
                }
            });
            return j;
        }
    }

    public String c(String str, String str2) {
        String str3 = this.f20598a.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public void e(String str, long j) {
        this.f20598a.put(str, String.valueOf(j));
    }

    public void f(String str, String str2) {
        this.f20598a.put(str, str2);
    }
}

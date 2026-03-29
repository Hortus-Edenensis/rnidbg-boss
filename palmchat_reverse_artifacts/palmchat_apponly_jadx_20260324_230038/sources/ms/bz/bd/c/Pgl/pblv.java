package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class pblv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19339a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = null;
    public int k = -1;
    public int l = -1;
    public int m = 99999;
    public Map<String, String> n = new HashMap();
    public HashMap o = new HashMap();
    public HashSet p = new HashSet();

    /* JADX INFO: compiled from: SearchBox */
    public interface pblb {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class pgla<T extends pblb> extends pblv implements pblb {
        public pgla(String str, String str2, String str3, int i) {
            this.g = str;
            this.h = str2;
            this.i = str3;
            this.m = i;
            if (TextUtils.isEmpty(str) || "0".equals(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                throw new IllegalArgumentException("sdkID or license must be set.");
            }
        }

        public final pgla b() {
            this.k = 1;
            return this;
        }

        public T c(String str, String str2) {
            this.o.put(str, str2);
            return this;
        }

        public T d(PglITokenObserver pglITokenObserver) {
            if (pglITokenObserver != null) {
                this.p.add(pglITokenObserver);
            }
            return this;
        }

        public T e(int i) {
            this.k = i;
            return this;
        }

        public T f(String str) {
            this.c = str;
            return this;
        }

        public T g(String str) {
            if (!str.equals(WkAdConfigModel.TAG_TIMEOUT) && !str.equals("error")) {
                if (!str.isEmpty()) {
                    this.o.put("kOA1", "1");
                }
                return this;
            }
            this.o.put("kOA1", "1");
            str = null;
            this.j = str;
            return this;
        }
    }

    public static String a(Object obj) {
        return (obj == null || !(obj instanceof String)) ? "" : ((String) obj).trim();
    }
}

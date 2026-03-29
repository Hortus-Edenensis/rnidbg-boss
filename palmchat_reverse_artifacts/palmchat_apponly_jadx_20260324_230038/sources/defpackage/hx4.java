package defpackage;

import cn.jiguang.sdk.impl.dnssrv.Name;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hx4 {
    public static hx4 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f18070a = null;
    public Name[] b = null;
    public int c = -1;

    static {
        l();
    }

    public hx4() {
        if (f() || h()) {
            return;
        }
        if (this.f18070a == null || this.b == null) {
            if (System.getProperty("java.vendor").indexOf(AnalyticsConstants.SDK_TYPE) != -1) {
                e();
            } else {
                i();
            }
        }
    }

    public static synchronized hx4 j() {
        return d;
    }

    public static void l() {
        hx4 hx4Var = new hx4();
        synchronized (hx4.class) {
            d = hx4Var;
        }
    }

    public final void a(String str, List list) {
        try {
            Name nameFromString = Name.fromString(str, Name.root);
            if (list.contains(nameFromString)) {
                return;
            }
            list.add(nameFromString);
        } catch (Exception unused) {
        }
    }

    public final void b(String str, List list) {
        if (list.contains(str)) {
            return;
        }
        list.add(str);
    }

    public final void c(List list, List list2) {
        if (this.f18070a == null && list.size() > 0) {
            this.f18070a = (String[]) list.toArray(new String[0]);
        }
        if (this.b != null || list2.size() <= 0) {
            return;
        }
        this.b = (Name[]) list2.toArray(new Name[0]);
    }

    public final void d(int i) {
        if (this.c >= 0 || i <= 0) {
            return;
        }
        this.c = i;
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke(null, strArr[i]);
                if (str != null && ((str.matches("^\\d+(\\.\\d+){3}$") || str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(str))) {
                    arrayList.add(str);
                }
            }
        } catch (Exception unused) {
        }
        c(arrayList, arrayList2);
    }

    public final boolean f() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        String property = System.getProperty("dns.server");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                b(stringTokenizer.nextToken(), arrayList);
            }
        }
        String property2 = System.getProperty("dns.search");
        if (property2 != null) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(property2, ",");
            while (stringTokenizer2.hasMoreTokens()) {
                a(stringTokenizer2.nextToken(), arrayList2);
            }
        }
        c(arrayList, arrayList2);
        return (this.f18070a == null || this.b == null) ? false : true;
    }

    public final void g(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            ArrayList arrayList = new ArrayList(0);
            ArrayList arrayList2 = new ArrayList(0);
            int iK = -1;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.startsWith("nameserver")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(line);
                        stringTokenizer.nextToken();
                        b(stringTokenizer.nextToken(), arrayList);
                    } else if (line.startsWith("domain")) {
                        StringTokenizer stringTokenizer2 = new StringTokenizer(line);
                        stringTokenizer2.nextToken();
                        if (stringTokenizer2.hasMoreTokens() && arrayList2.isEmpty()) {
                            a(stringTokenizer2.nextToken(), arrayList2);
                        }
                    } else if (line.startsWith(BaseConstants.MARKET_URI_AUTHORITY_SEARCH)) {
                        if (!arrayList2.isEmpty()) {
                            arrayList2.clear();
                        }
                        StringTokenizer stringTokenizer3 = new StringTokenizer(line);
                        stringTokenizer3.nextToken();
                        while (stringTokenizer3.hasMoreTokens()) {
                            a(stringTokenizer3.nextToken(), arrayList2);
                        }
                    } else if (line.startsWith("options")) {
                        StringTokenizer stringTokenizer4 = new StringTokenizer(line);
                        stringTokenizer4.nextToken();
                        while (stringTokenizer4.hasMoreTokens()) {
                            String strNextToken = stringTokenizer4.nextToken();
                            if (strNextToken.startsWith("ndots:")) {
                                iK = k(strNextToken);
                            }
                        }
                    }
                } catch (IOException unused) {
                }
                c(arrayList, arrayList2);
                d(iK);
            }
            bufferedReader.close();
            c(arrayList, arrayList2);
            d(iK);
        } catch (FileNotFoundException unused2) {
        }
    }

    public final boolean h() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        try {
            Class<?>[] clsArr = new Class[0];
            Object[] objArr = new Object[0];
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            Object objInvoke = cls.getDeclaredMethod("open", clsArr).invoke(null, objArr);
            List list = (List) cls.getMethod("nameservers", clsArr).invoke(objInvoke, objArr);
            List list2 = (List) cls.getMethod("searchlist", clsArr).invoke(objInvoke, objArr);
            if (list.size() == 0) {
                return false;
            }
            if (list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    b((String) it.next(), arrayList);
                }
            }
            if (list2.size() > 0) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    a((String) it2.next(), arrayList2);
                }
            }
            c(arrayList, arrayList2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void i() {
        g("/etc/resolv.conf");
    }

    public final int k(String str) {
        try {
            int i = Integer.parseInt(str.substring(6));
            if (i >= 0) {
                return i;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public String[] m() {
        return this.f18070a;
    }
}

package com.amap.api.col.p0002sl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.amap.api.col.2sl.if, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Cif {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f2903a = true;
    private static Cif b;
    private final Map<String, Map<String, List<String>>> c = new HashMap();
    private final Map<String, List<String>> d = new HashMap();
    private final List<String> e = new ArrayList();

    public static synchronized Cif a() {
        if (b == null) {
            b = new Cif();
        }
        return b;
    }

    private static a b(String str) {
        try {
            return new a(new URL(str));
        } catch (MalformedURLException unused) {
            String str2 = null;
            if (str.contains("://")) {
                return null;
            }
            while (str.startsWith("/")) {
                str = str.substring(1);
            }
            String[] strArrSplit = str.split("/");
            int i = 0;
            if (strArrSplit[0].contains(".")) {
                str2 = strArrSplit[0];
                i = 1;
            }
            StringBuilder sb = new StringBuilder();
            while (i < strArrSplit.length) {
                if (sb.length() > 0) {
                    sb.append("/");
                }
                sb.append(strArrSplit[i]);
                i++;
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '/') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return new a(str2, sb.toString());
        }
    }

    /* JADX INFO: renamed from: com.amap.api.col.2sl.if$a */
    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2904a;
        public String b;
        public String c;

        public a(URL url) {
            this.f2904a = url.getProtocol();
            this.b = url.getHost();
            this.c = url.getPath();
        }

        public a(String str, String str2) {
            this.f2904a = null;
            this.b = str;
            this.c = str2;
        }
    }

    public final boolean a(String str) {
        a aVarA;
        if (str == null || str.length() == 0 || (aVarA = a(b(str))) == null) {
            return false;
        }
        return b(aVarA);
    }

    private static a a(a aVar) {
        if (aVar == null) {
            return null;
        }
        String str = aVar.c;
        if (str == null || str.length() == 0) {
            return aVar;
        }
        while (true) {
            String str2 = aVar.c;
            if (str2.charAt(str2.length() - 1) != '/') {
                break;
            }
            String str3 = aVar.c;
            aVar.c = str3.substring(0, str3.length() - 1);
        }
        while (aVar.c.charAt(0) == '/') {
            aVar.c = aVar.c.substring(1);
        }
        return aVar;
    }

    private static boolean a(String str, String str2) {
        String[] strArrSplit = str.split("/");
        String[] strArrSplit2 = str2.split("/");
        if (strArrSplit2.length < strArrSplit.length) {
            return false;
        }
        for (int i = 0; i < strArrSplit.length; i++) {
            if (!strArrSplit[i].equals("*") && !strArrSplit[i].equals(strArrSplit2[i])) {
                return false;
            }
        }
        return true;
    }

    private synchronized boolean b(a aVar) {
        if (aVar != null) {
            if (aVar.c.length() != 0) {
                Map<String, List<String>> map = this.d;
                String str = aVar.f2904a;
                if (str != null && this.c.containsKey(str)) {
                    map = this.c.get(aVar.f2904a);
                }
                List<String> list = this.e;
                boolean z = f2903a;
                if (!z && map == null) {
                    throw new AssertionError();
                }
                String str2 = aVar.b;
                if (str2 != null && map.containsKey(str2)) {
                    list = map.get(aVar.b);
                }
                if (!z && list == null) {
                    throw new AssertionError();
                }
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (a(it.next(), aVar.c)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}

package defpackage;

import android.os.Debug;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class tv1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21075a = "TracerPid";

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21076a;
        public long b;
        public int c;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
            this.f21076a = Integer.parseInt(str, 16);
            this.b = Long.parseLong(str2, 16);
            this.c = Integer.parseInt(str3, 16);
        }

        public static a a(String[] strArr) {
            return new a(strArr[1], strArr[2], strArr[3], strArr[4], strArr[5], strArr[6], strArr[7], strArr[8], strArr[9], strArr[10], strArr[11], strArr[12], strArr[13], strArr[14]);
        }
    }

    public static boolean a() throws Throwable {
        BufferedReader bufferedReader;
        Exception e;
        ArrayList<a> arrayList;
        int i;
        boolean z = false;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/net/tcp")), 1000);
            try {
                try {
                    bufferedReader.readLine();
                    arrayList = new ArrayList();
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                bufferedReader2.close();
                throw th;
            }
        } catch (Exception e3) {
            bufferedReader = null;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2.close();
            throw th;
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            arrayList.add(a.a(line.split("\\W+")));
            bufferedReader.close();
            return z;
        }
        bufferedReader.close();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            a aVar = (a) it.next();
            if (aVar.b == 0) {
                i = aVar.c;
                break;
            }
        }
        if (i != -1) {
            for (a aVar2 : arrayList) {
                if (aVar2.b != 0 && aVar2.c == i) {
                    z = true;
                }
            }
        }
        bufferedReader.close();
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0051, code lost:
    
        if (java.lang.Integer.decode(r1.substring(defpackage.tv1.f21075a.length() + 1).trim()).intValue() <= 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0053, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0056, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b() throws Throwable {
        BufferedReader bufferedReader;
        Exception e;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/status")), 1000);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            if (line.length() > f21075a.length() && line.substring(0, f21075a.length()).equalsIgnoreCase(f21075a)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                bufferedReader2.close();
                throw th;
            }
        } catch (Exception e3) {
            bufferedReader = null;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2.close();
            throw th;
        }
        bufferedReader.close();
        return false;
    }

    public static boolean c() {
        return Debug.isDebuggerConnected();
    }
}

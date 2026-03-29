package defpackage;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class z77 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends c {
        public a(File file) {
            super(file);
            this.b = "Total FD Count:";
            this.c = ":";
            this.d = -2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends c {
        public b(File file) {
            super(file);
            this.b = "VmSize:";
            this.c = "\\s+";
            this.d = -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f22375a;
        public String b;
        public String c;
        public int d;

        public c(File file) {
            this.f22375a = file;
        }

        public int a() {
            Throwable th;
            int i;
            if (!this.f22375a.exists() || !this.f22375a.isFile()) {
                return -1;
            }
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.f22375a));
                int iB = -1;
                do {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        iB = b(line);
                    } catch (Throwable th2) {
                        th = th2;
                        i = iB;
                        bufferedReader = bufferedReader2;
                        try {
                            n37.a();
                            n37.b("NPTH_CATCH", th);
                            return i;
                        } finally {
                            if (bufferedReader != null) {
                                wf7.a(bufferedReader);
                            }
                        }
                    }
                } while (iB == -1);
                wf7.a(bufferedReader2);
                return iB;
            } catch (Throwable th3) {
                th = th3;
                i = -1;
            }
        }

        public int b(String str) {
            int i = this.d;
            if (!str.startsWith(this.b)) {
                return i;
            }
            try {
                i = Integer.parseInt(str.split(this.c)[1].trim());
            } catch (NumberFormatException e) {
                n37.a();
                n37.b("NPTH_CATCH", e);
            }
            if (i < 0) {
                return -2;
            }
            return i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d extends c {
        public d(File file) {
            super(file);
        }

        public HashMap<String, List<String>> c() {
            HashMap<String, List<String>> map = new HashMap<>();
            try {
                JSONArray jSONArrayU = re7.u(this.f22375a.getAbsolutePath());
                if (jSONArrayU == null) {
                    return map;
                }
                for (int i = 0; i < jSONArrayU.length(); i++) {
                    String strOptString = jSONArrayU.optString(i);
                    if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("[tid:0") && strOptString.endsWith("sigstack:0x0]")) {
                        int iIndexOf = strOptString.indexOf("[routine:0x");
                        int i2 = iIndexOf + 11;
                        String strSubstring = iIndexOf > 0 ? strOptString.substring(i2, strOptString.indexOf(93, i2)) : "unknown addr";
                        List<String> arrayList = map.get(strSubstring);
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            map.put(strSubstring, arrayList);
                        }
                        arrayList.add(strOptString);
                    }
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
            }
            return map;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e extends c {
        public e(File file) {
            super(file);
        }

        public JSONArray c(HashMap<String, List<String>> map) {
            int iIndexOf;
            List<String> list;
            JSONArray jSONArray = new JSONArray();
            if (map.isEmpty()) {
                return jSONArray;
            }
            try {
                JSONArray jSONArrayU = re7.u(this.f22375a.getAbsolutePath());
                if (jSONArrayU == null) {
                    return jSONArray;
                }
                for (int i = 0; i < jSONArrayU.length(); i++) {
                    String strOptString = jSONArrayU.optString(i);
                    if (!TextUtils.isEmpty(strOptString) && (iIndexOf = strOptString.indexOf(":")) > 2) {
                        String strSubstring = strOptString.substring(2, iIndexOf);
                        if (map.containsKey(strSubstring) && (list = map.get(strSubstring)) != null) {
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                jSONArray.put(it.next() + " " + strOptString);
                            }
                            map.remove(strSubstring);
                        }
                    }
                }
                Iterator<List<String>> it2 = map.values().iterator();
                while (it2.hasNext()) {
                    Iterator<String> it3 = it2.next().iterator();
                    while (it3.hasNext()) {
                        jSONArray.put(it3.next() + "  0x000000:unknown");
                    }
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
            }
            return jSONArray;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f extends c {
        public f(File file) {
            super(file);
            this.b = "Total Threads Count:";
            this.c = ":";
            this.d = -2;
        }
    }

    public static int a(String str) {
        return new a(wi7.f(str)).a();
    }

    public static JSONArray b(File file, File file2) {
        return new e(file2).c(new d(file).c());
    }

    public static int c(String str) {
        return new f(wi7.j(str)).a();
    }

    public static int d(String str) {
        return new b(wi7.n(str)).a();
    }
}

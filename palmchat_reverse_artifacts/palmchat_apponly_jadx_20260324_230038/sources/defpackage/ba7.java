package defpackage;

import com.apm.lite.nativecrash.NativeImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ba7 {
    public static final Pattern i = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
    public static final Pattern j = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");
    public static final Pattern k = Pattern.compile("^Abort message: (.*)$");
    public static final Pattern l = Pattern.compile("^Crash message: (.*)$");
    public static final Pattern m = Pattern.compile("^    \\/(\\w*)\\/.*\\/(.*\\.so)\\s\\(BuildId: ([a-f0-9]*)\\)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1676a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public Map<String, String> h = new HashMap();

    public ba7(File file) {
        f(wi7.i(file));
    }

    public String a() {
        return this.g;
    }

    public void b(File file) {
        File fileI = wi7.i(file);
        if (fileI.exists()) {
            fileI.renameTo(new File(fileI.getAbsoluteFile() + ".old"));
        }
        NativeImpl.rebuildTombstone(file);
        f(wi7.i(file));
    }

    public Map<String, String> c() {
        return this.h;
    }

    public void d(File file) {
        f(wi7.i(file));
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        String str = this.e;
        if (str != null) {
            sb.append(str);
        }
        String str2 = this.f;
        if (str2 != null) {
            sb.append(str2);
        }
        String str3 = this.g;
        if (str3 != null) {
            sb.append(str3);
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x018c, code lost:
    
        r12 = r3.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0190, code lost:
    
        if (r12 == null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0198, code lost:
    
        if (r12.contains("BuildId:") != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x019b, code lost:
    
        r12 = defpackage.ba7.m.matcher(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a5, code lost:
    
        if (r12.find() != false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a8, code lost:
    
        r0 = r12.group(1);
        r1 = r12.group(2);
        r12 = r12.group(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ba, code lost:
    
        if (r0.equals("data") == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01bc, code lost:
    
        r11.h.put(r1, r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(File file) {
        String str;
        if (!file.exists() || file.length() == 0) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            int i2 = 0;
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null || i2 >= 64) {
                        break;
                    }
                    if (this.f1676a == null && line.startsWith("pid: ")) {
                        Matcher matcher = i.matcher(line);
                        if (matcher.find() && matcher.groupCount() == 4) {
                            this.f1676a = matcher.group(1);
                            this.b = matcher.group(2);
                            this.d = matcher.group(3);
                            this.c = matcher.group(4);
                        }
                    } else if (this.e == null && line.startsWith("signal ")) {
                        Matcher matcher2 = j.matcher(line);
                        if (matcher2.find() && matcher2.groupCount() == 3) {
                            String strReplace = matcher2.group(1).replace(" ", "");
                            String strReplace2 = matcher2.group(2).replace(" ", "");
                            int iIndexOf = strReplace2.indexOf("frompid");
                            if (iIndexOf > 0) {
                                strReplace2 = strReplace2.substring(0, iIndexOf) + ")";
                            }
                            this.e = "Signal " + strReplace + ", Code " + strReplace2 + "\n";
                        }
                    } else if (this.f == null && line.startsWith("Abort ")) {
                        Matcher matcher3 = k.matcher(line);
                        if (matcher3.find() && matcher3.groupCount() == 1) {
                            str = "abort message: " + matcher3.group(1) + "\n";
                            this.f = str;
                        }
                    } else if (this.f == null && line.startsWith("Crash ")) {
                        Matcher matcher4 = l.matcher(line);
                        if (matcher4.find() && matcher4.groupCount() == 1) {
                            str = "crash message: " + matcher4.group(1) + "\n";
                            this.f = str;
                        }
                    } else if (this.g != null || !line.startsWith("backtrace:")) {
                        if (this.h.isEmpty() && line.startsWith("build id:")) {
                            break;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line2 = bufferedReader2.readLine();
                            if (line2 == null || !line2.startsWith("    #")) {
                                break;
                            }
                            sb.append(line2.substring(4));
                            sb.append('\n');
                        }
                        i2++;
                        this.g = sb.toString();
                    }
                    i2++;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        n37.a();
                        n37.b("NPTH_CATCH", th);
                        return;
                    } finally {
                        wf7.a(bufferedReader);
                    }
                }
            }
            wf7.a(bufferedReader2);
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

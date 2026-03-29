package defpackage;

import android.os.Build;
import com.vivo.push.PushClientConstants;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class no5 {
    public static String a() {
        String str;
        String str2;
        int i;
        int i2;
        LogUtil.d("PKG", "VersionCode:" + Build.VERSION.SDK_INT);
        int i3 = Integer.MAX_VALUE;
        String str3 = null;
        for (File file : new File("/proc").listFiles()) {
            if (file.isDirectory()) {
                try {
                    int i4 = Integer.parseInt(file.getName());
                    try {
                        String[] strArrSplit = b(String.format("/proc/%d/cgroup", Integer.valueOf(i4))).split("\n");
                        for (String str4 : strArrSplit) {
                            LogUtil.d("PKG", str4);
                        }
                        if (strArrSplit.length == 2) {
                            str = strArrSplit[0];
                            str2 = strArrSplit[1];
                        } else if (strArrSplit.length == 3) {
                            str = strArrSplit[0];
                            str2 = strArrSplit[2];
                        } else if (strArrSplit.length == 5) {
                            str = strArrSplit[2];
                            str2 = strArrSplit[4];
                        }
                        if (str2.endsWith(Integer.toString(i4)) && !str.endsWith("bg_non_interactive")) {
                            String strB = b(String.format("/proc/%d/cmdline", Integer.valueOf(i4)));
                            if (!strB.contains(PushClientConstants.COM_ANDROID_SYSTEMUI) && ((i = Integer.parseInt(str2.split(":")[2].split("/")[1].replace("uid_", ""))) < 1000 || i > 1038)) {
                                int i5 = i - 10000;
                                while (i5 > 100000) {
                                    i5 -= 100000;
                                }
                                if (i5 >= 0) {
                                    File file2 = new File(String.format("/proc/%d/oom_score_adj", Integer.valueOf(i4)));
                                    if ((!file2.canRead() || Integer.parseInt(b(file2.getAbsolutePath())) == 0) && (i2 = Integer.parseInt(b(String.format("/proc/%d/oom_score", Integer.valueOf(i4))))) < i3) {
                                        i3 = i2;
                                        str3 = strB;
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return str3;
    }

    public static String b(String str) throws Throwable {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            try {
                sb.append(bufferedReader2.readLine());
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        pu1.u(bufferedReader2);
                        return sb.toString().trim();
                    }
                    sb.append('\n');
                    sb.append(line);
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                pu1.u(bufferedReader);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

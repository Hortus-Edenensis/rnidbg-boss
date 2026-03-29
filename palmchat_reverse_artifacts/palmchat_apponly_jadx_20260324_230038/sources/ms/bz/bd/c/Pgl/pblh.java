package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pblh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19327a = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "b3839c", new byte[]{67, 35, 68, 68, 3, 103, 114, 29, 123});
    public static final String b = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "1b8110", new byte[]{8, 97, 89, 65, 25, 38, 32, 70});
    public static final String c = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "65bd67", new byte[]{1, 50, 16, 4, 28, 50, 48, 7});
    public static final String d = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "7f521f", new byte[]{54, 103});
    public static final String e = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "47bfa1", new byte[]{45, 34});
    public static final String f = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "ef2f72", new byte[]{114, 112});
    public static final String g = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "27e543", new byte[]{46, 52, dn.l});
    public static final String h = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "a0798a", new byte[]{125, 59, 74});
    public static final String i = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "e71a7f", new byte[]{119, 58, 80, 16});
    public static final FileFilter j = new pgla();

    /* JADX INFO: compiled from: SearchBox */
    public class pgla implements FileFilter {
        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return Pattern.matches((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7cc867", new byte[]{37, 113, 5, 119, 89, 109, 109, ByteCompanionObject.MAX_VALUE}), file.getName());
        }
    }

    public static int a() {
        try {
            return new File((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5e92aa", new byte[]{107, 116, 83, 85, 17, 114, 51, 82, 97, 97, 33, 116, 5, 85, 71, 101, 34, 65, 101, 45, 39, 119, 95, 9})).listFiles(j).length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static HashMap<String, String> b() {
        FileReader fileReader;
        HashMap<String, String> map = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6e65a3", new byte[]{104, 119, 87, 78, 93, 107, 54, 84, 114, 108, 41, 97, 74}));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        } else {
                            String[] strArrSplit = line.split((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8358ff", new byte[]{115}), 2);
                            if (strArrSplit.length >= 2) {
                                String strTrim = strArrSplit[0].trim();
                                String strTrim2 = strArrSplit[1].trim();
                                if (map.get(strTrim) == null) {
                                    map.put(strTrim, strTrim2);
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (fileReader != null) {
                        }
                        return map;
                    }
                }
                bufferedReader2.close();
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
        }
        return map;
    }

    public static String c() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> mapB = b();
            jSONObject.put(i, a());
            String str3 = null;
            try {
                str = mapB.get(f19327a);
            } catch (Throwable unused) {
                str = null;
            }
            jSONObject.put(d, str == null ? "" : str.trim());
            try {
                str2 = mapB.get(b);
            } catch (Throwable unused2) {
                str2 = null;
            }
            jSONObject.put(e, str2 == null ? "" : str2.trim());
            jSONObject.put(g, d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "24cd00", new byte[]{108, 37, 9, 3, 64, 35, 52, 3, 59, 55, 38, 37, 95, 3, 22, 52, 37, 16, Utf8.REPLACEMENT_BYTE, 123, 32, 38, 5, 95, 12, 55, 36, 69, 125, 55, 51, 35, 22, 2, 10, 54, 126, 22, 34, 33, 42, 56, 22, TELogUtils.DEBUG_LEVEL_V, 48, 42, 48, dn.k, dn.k, 50, 49, 51, 1})));
            jSONObject.put(h, d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a4bfbf", new byte[]{Utf8.REPLACEMENT_BYTE, 37, 8, 1, 18, 117, 103, 3, 58, 53, 117, 37, 94, 1, 68, 98, 118, 16, 62, 121, 115, 38, 4, 93, 94, 97, 119, 69, 124, 53, 96, 35, 23, 0, 88, 96, 45, 22, 35, 35, 121, 56, 23, 29, 98, 124, 107, 27, 12, 48, 98, 51, 0})));
            try {
                str3 = mapB.get(c);
            } catch (Throwable unused3) {
            }
            jSONObject.put(f, str3 != null ? str3.trim() : "");
        } catch (Throwable unused4) {
        }
        String string = jSONObject.toString();
        return TextUtils.isEmpty(string) ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "456f78", new byte[]{62, 42}) : string.trim();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        File file;
        String line = null;
        try {
            file = new File(str);
        } catch (Throwable unused) {
            fileReader = null;
            bufferedReader = null;
        }
        if (!file.exists()) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "49b168", new byte[]{117});
        }
        fileReader = new FileReader(file);
        try {
            bufferedReader = new BufferedReader(fileReader);
            try {
                line = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused4) {
                    }
                }
                if (fileReader != null) {
                }
                if (line != null) {
                }
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
        }
        return line != null ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e8c456", new byte[]{36}) : line.trim();
    }
}

package com.bykv.vk.openvk.component.video.u.fx;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.bykv.vk.openvk.component.video.u.nr.b;
import com.bykv.vk.openvk.component.video.u.nr.iz;
import com.bykv.vk.openvk.component.video.u.nr.nr.fx;
import com.bykv.vk.openvk.component.video.u.nr.pn.pn;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.utils.k;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class u {
    private static final Handler nr = new Handler(Looper.getMainLooper());
    public static final Charset u = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.u.fx.u$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class AnonymousClass1 implements FilenameFilter {
        private Pattern u = Pattern.compile("^cpu[0-9]+$");

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.u.matcher(str).matches();
        }
    }

    public static String nr(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            return i + "-" + i2;
        }
        if (i > 0) {
            return i + "-";
        }
        if (i >= 0 || i2 <= 0) {
            return null;
        }
        return "-" + i2;
    }

    public static void u(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void u(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean nr(String str) {
        if (str != null) {
            return str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str);
        }
        return false;
    }

    public static boolean u(String str) {
        if (str != null) {
            return str.startsWith("http://") || str.startsWith("https://");
        }
        return false;
    }

    public static boolean nr() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static int u(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static String nr(List<iz.nr> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            iz.nr nrVar = list.get(0);
            if (nrVar != null) {
                sb.append(nrVar.u);
                sb.append(": ");
                sb.append(nrVar.nr);
                sb.append(HttpClient.NEWLINE);
            }
        }
        return sb.toString();
    }

    public static String u(int i, int i2) {
        String strNr = nr(i, i2);
        if (strNr == null) {
            return null;
        }
        return "bytes=" + strNr;
    }

    public static List<String> u(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (u(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String nr(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append((Object) entry.getKey());
            sb.append(": ");
            sb.append((Object) entry.getValue());
            sb.append(HttpClient.NEWLINE);
        }
        return sb.toString();
    }

    public static int u() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }

    public static int u(com.bykv.vk.openvk.component.video.u.nr.pn.u uVar) {
        int iLastIndexOf;
        if (uVar == null) {
            return -1;
        }
        if (uVar.u() == 200) {
            return u(uVar.u("Content-Length", null), -1);
        }
        if (uVar.u() == 206) {
            String strU = uVar.u(HttpHeaders.CONTENT_RANGE, null);
            if (!TextUtils.isEmpty(strU) && (iLastIndexOf = strU.lastIndexOf("/")) >= 0 && iLastIndexOf < strU.length() - 1) {
                return u(strU.substring(iLastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String u(com.bykv.vk.openvk.component.video.u.nr.pn.u uVar, boolean z, boolean z2) {
        String strU;
        if (uVar == null) {
            if (b.pn) {
                k.nr("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!uVar.nr()) {
            if (b.pn) {
                k.nr("TAG_PROXY_Response", "response code: " + uVar.u());
            }
            return "response code: " + uVar.u();
        }
        String strU2 = uVar.u("Content-Type", null);
        if (!nr(strU2)) {
            if (b.pn) {
                k.nr("TAG_PROXY_Response", "Content-Type: " + strU2);
            }
            return "Content-Type: " + strU2;
        }
        int iU = u(uVar);
        if (iU <= 0) {
            if (b.pn) {
                k.nr("TAG_PROXY_Response", "Content-Length: " + iU);
            }
            return "Content-Length: " + iU;
        }
        if (z && ((strU = uVar.u(HttpHeaders.ACCEPT_RANGES, null)) == null || !strU.contains("bytes"))) {
            if (b.pn) {
                k.nr("TAG_PROXY_Response", "Accept-Ranges: " + strU);
            }
            return "Accept-Ranges: " + strU;
        }
        if (!z2 || uVar.b() != null) {
            return null;
        }
        if (b.pn) {
            k.nr("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static void u(a aVar) {
        if (aVar != null) {
            if (nr()) {
                x.nr(aVar);
                if (b.pn) {
                    k.nr("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            aVar.run();
            if (b.pn) {
                k.nr("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void u(Runnable runnable) {
        if (runnable != null) {
            if (nr()) {
                runnable.run();
            } else {
                nr.post(runnable);
            }
        }
    }

    public static List<iz.nr> u(List<iz.nr> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (b.pn) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (iz.nr nrVar : list) {
            if ("Host".equals(nrVar.u) || HTTP.CONN_KEEP_ALIVE.equals(nrVar.u) || "Connection".equals(nrVar.u) || "Proxy-Connection".equals(nrVar.u)) {
                arrayList.add(nrVar);
            }
        }
        list.removeAll(arrayList);
        if (b.pn) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                list.get(i2);
            }
        }
        return list;
    }

    public static List<iz.nr> u(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : setEntrySet) {
                    arrayList.add(new iz.nr(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static com.bykv.vk.openvk.component.video.u.nr.nr.u u(com.bykv.vk.openvk.component.video.u.nr.pn.u uVar, fx fxVar, String str, int i) {
        String strNr;
        String str2;
        String string;
        com.bykv.vk.openvk.component.video.u.nr.nr.u uVarQuery = fxVar.query(str, i);
        if (uVarQuery != null) {
            return uVarQuery;
        }
        int iU = u(uVar);
        String strU = uVar.u("Content-Type", null);
        if (iU <= 0 || TextUtils.isEmpty(strU)) {
            return uVarQuery;
        }
        pn pnVarPn = uVar.pn();
        if (pnVarPn != null) {
            str2 = pnVarPn.nr;
            strNr = nr(pnVarPn.pn);
        } else {
            strNr = "";
            str2 = strNr;
        }
        String strNr2 = nr(uVar.fx());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestUrl", str2);
            jSONObject.put("requestHeaders", strNr);
            jSONObject.put("responseHeaders", strNr2);
            string = jSONObject.toString();
        } catch (Throwable unused) {
            string = "";
        }
        com.bykv.vk.openvk.component.video.u.nr.nr.u uVar2 = new com.bykv.vk.openvk.component.video.u.nr.nr.u(str, strU, iU, i, string);
        fxVar.insert(uVar2);
        return uVar2;
    }
}

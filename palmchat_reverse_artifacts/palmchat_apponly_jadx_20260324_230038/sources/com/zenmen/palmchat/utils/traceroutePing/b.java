package com.zenmen.palmchat.utils.traceroutePing;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.zenmen.palmchat.utils.traceroutePing.ReportVo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15775a = "ping -c 1 -W 3 ";

    public static Pair<String, Float> a(String str) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("Will launch : ");
        String str2 = "";
        sb.append("");
        sb.append(str);
        Log.d("TraceroutePing", sb.toString());
        long jNanoTime = System.nanoTime();
        Process processExec = Runtime.getRuntime().exec(f15775a + str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
        float fNanoTime = 0.0f;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                processExec.waitFor();
                processExec.destroy();
                return new Pair<>(str2, Float.valueOf(fNanoTime));
            }
            str2 = str2 + line + "\n";
            if (line.contains(HttpHeaders.FROM) || line.contains("from")) {
                fNanoTime = (System.nanoTime() - jNanoTime) / 1000000.0f;
            }
        }
    }

    public static String b(String str) {
        if (!str.contains(HttpHeaders.FROM)) {
            return str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        }
        String strSubstring = str.substring(str.indexOf(HttpHeaders.FROM) + 5);
        if (strSubstring.contains("(")) {
            return strSubstring.substring(strSubstring.indexOf("(") + 1, strSubstring.indexOf(")"));
        }
        String strSubstring2 = strSubstring.substring(0, strSubstring.indexOf("\n"));
        return strSubstring2.substring(0, strSubstring2.contains(":") ? strSubstring2.indexOf(":") : strSubstring2.indexOf(" "));
    }

    public static String c(String str) {
        if (!str.contains("time=")) {
            return "";
        }
        String strSubstring = str.substring(str.indexOf("time=") + 5);
        return strSubstring.substring(0, strSubstring.indexOf(" "));
    }

    public static ReportVo.PingResult d(String str) {
        ReportVo.PingResult pingResult = new ReportVo.PingResult(false, str, null, null, 0.0f);
        try {
            Pair<String, Float> pairA = a(str);
            String strB = !TextUtils.isEmpty((CharSequence) pairA.first) ? b((String) pairA.first) : null;
            if (strB != null && (!((String) pairA.first).contains("100%") || ((String) pairA.first).contains("exceed"))) {
                return new ReportVo.PingResult(true, str, (String) pairA.first, strB, Float.parseFloat(c((String) pairA.first)));
            }
            return new ReportVo.PingResult(false, str, (String) pairA.first, null, ((Float) pairA.second).floatValue());
        } catch (Exception e) {
            e.printStackTrace();
            return pingResult;
        }
    }
}

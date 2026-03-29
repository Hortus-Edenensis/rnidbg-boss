package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.ax;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class d {
    private static final Pattern aPG = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern aPH = Pattern.compile("GET /(.*) HTTP");
    public final long aPI;
    public final boolean aPJ;
    public final String uri;

    private d(String str) {
        ax.hy(str);
        long jEX = eX(str);
        this.aPI = Math.max(0L, jEX);
        this.aPJ = jEX >= 0;
        this.uri = eY(str);
    }

    public static d b(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                return new d(sb.toString());
            }
            sb.append(line);
            sb.append('\n');
        }
    }

    private static long eX(String str) {
        Matcher matcher = aPG.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private static String eY(String str) {
        Matcher matcher = aPH.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.aPI + ", partial=" + this.aPJ + ", uri='" + this.uri + "'}";
    }
}

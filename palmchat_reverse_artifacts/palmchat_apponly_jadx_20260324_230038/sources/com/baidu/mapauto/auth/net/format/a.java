package com.baidu.mapauto.auth.net.format;

import com.baidu.mapapi.http.HttpClient;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3862a;
    public static final String b;
    public static final String c;

    static {
        String string = UUID.randomUUID().toString();
        f3862a = string;
        b = "\r\n--" + string + HttpClient.NEWLINE;
        c = "\r\n--" + string + "--\r\n";
    }

    public final String a(HashMap map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof File) {
                throw new UnsupportedOperationException();
            }
            if (obj != null) {
                String string = obj.toString();
                sb.append(b);
                sb.append("Content-Disposition: form-data; name=\"");
                sb.append(str);
                sb.append("\"\r\n");
                sb.append(HttpClient.NEWLINE);
                sb.append(string);
            }
        }
        sb.append(c);
        return sb.toString();
    }
}

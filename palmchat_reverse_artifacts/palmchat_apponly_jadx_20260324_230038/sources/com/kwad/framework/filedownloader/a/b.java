package com.kwad.framework.filedownloader.a;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface b {
    void addHeader(String str, String str2);

    String bz(String str);

    void execute();

    InputStream getInputStream();

    int getResponseCode();

    Map<String, List<String>> zu();

    Map<String, List<String>> zv();

    void zw();
}

package com.android.volley;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface Cache {

    /* JADX INFO: compiled from: SearchBox */
    public static class Entry {
        public byte[] data;
        public String etag;
        public long maxAge;
        public Map<String, String> responseHeaders = Collections.emptyMap();
        public long responseTime;
        public long serverDate;
        public long softTtl;

        public boolean isExpired() {
            return Math.abs(this.responseTime - System.currentTimeMillis()) > this.maxAge;
        }

        public boolean refreshNeeded() {
            return this.softTtl < System.currentTimeMillis();
        }
    }

    void clear();

    Entry get(String str);

    void initialize();

    void invalidate(String str, boolean z);

    void put(String str, Entry entry);

    void remove(String str);
}

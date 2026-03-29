package com.bykv.vk.component.ttvideo.net;

import com.bykv.vk.component.ttvideo.player.AVThreadPool;
import com.bykv.vk.component.ttvideo.player.CalledByNative;
import com.bykv.vk.component.ttvideo.player.Keep;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Keep
public class AVResolver {
    public static int HOST_MAX_CACHE_TIME = 600000;
    private static final int MAX_CACHED = 128;
    private static final String TAG = "ttmj";
    private static final Hashtable<String, HostInfo> mCacheHosts = new Hashtable<>();
    private String mError;
    private HostInfo mHostInfo;
    private String mHostName;
    private String[] mIPStr;
    private boolean mRet = false;
    private Thread mThread = null;

    /* JADX INFO: compiled from: SearchBox */
    public static class HostInfo {
        public String ip;
        public long time;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ParserHost implements Runnable {
        String mHostName;
        AVResolver mResolver;

        public ParserHost(AVResolver aVResolver, String str) {
            this.mResolver = aVResolver;
            this.mHostName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            InetAddress byName;
            String hostAddress = null;
            try {
                byName = InetAddress.getByName(this.mHostName);
                try {
                    hostAddress = byName.getHostAddress();
                } catch (Throwable th) {
                    th = th;
                    this.mResolver.mError = th.getMessage();
                }
            } catch (Throwable th2) {
                th = th2;
                byName = null;
            }
            this.mResolver.mRet = true;
            if (byName == null || hostAddress == null) {
                return;
            }
            this.mResolver.mIPStr = new String[1];
            this.mResolver.mIPStr[0] = hostAddress;
            HostInfo hostInfo = new HostInfo();
            hostInfo.time = System.currentTimeMillis();
            hostInfo.ip = hostAddress;
            AVResolver.putHostInfo(this.mHostName, hostInfo);
            hostInfo.time = System.currentTimeMillis();
        }
    }

    public static final boolean isIP(String str) {
        return (str.length() < 7 || str.length() > 15) ? str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']' : Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }

    public static synchronized void putHostInfo(String str, HostInfo hostInfo) {
        Object obj;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Hashtable<String, HostInfo> hashtable = mCacheHosts;
        Object obj2 = null;
        if (hashtable.size() > 128) {
            Iterator<Map.Entry<String, HostInfo>> it = hashtable.entrySet().iterator();
            Object obj3 = null;
            while (it.hasNext()) {
                HostInfo value = it.next().getValue();
                obj2 = (String) it.next().getKey();
                if (value != null) {
                    long j = value.time;
                    if (j < jCurrentTimeMillis) {
                        obj3 = value;
                        jCurrentTimeMillis = j;
                    }
                }
            }
            obj = obj2;
            obj2 = obj3;
        } else {
            obj = null;
        }
        if (obj2 != null && obj != null) {
            mCacheHosts.remove(obj);
        }
        mCacheHosts.put(str, hostInfo);
    }

    @CalledByNative
    public void freeAddress() {
        Thread thread = this.mThread;
        if (thread != null) {
            try {
                thread.interrupt();
            } catch (Exception unused) {
            }
        }
    }

    @CalledByNative
    public String getAddress() {
        String[] strArr;
        String str;
        if (this.mRet && (strArr = this.mIPStr) != null && (str = strArr[0]) != null) {
            return str;
        }
        return "parser host name: " + this.mHostName + " error.err msg:" + this.mError;
    }

    @CalledByNative
    public void getAddressInfo(String str) {
        this.mHostName = str;
        if (str == null || str.length() <= 0 || "".equals(str)) {
            this.mRet = true;
            return;
        }
        if (isIP(this.mHostName)) {
            this.mIPStr = new String[]{this.mHostName};
            this.mRet = true;
            return;
        }
        Hashtable<String, HostInfo> hashtable = mCacheHosts;
        HostInfo hostInfo = hashtable.get(str);
        this.mHostInfo = hostInfo;
        if (hostInfo != null) {
            if (hostInfo.ip != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                HostInfo hostInfo2 = this.mHostInfo;
                if (jCurrentTimeMillis - hostInfo2.time < HOST_MAX_CACHE_TIME) {
                    this.mIPStr = new String[]{hostInfo2.ip};
                    this.mRet = true;
                    return;
                }
            }
            hashtable.remove(str);
            this.mHostInfo = null;
        }
        try {
            AVThreadPool.addTask(new ParserHost(this, this.mHostName));
        } catch (Exception e) {
            this.mRet = true;
            this.mError = e.getMessage();
        }
    }

    @CalledByNative
    public int isSuccess() {
        if (!this.mRet) {
            return 0;
        }
        String[] strArr = this.mIPStr;
        return (strArr == null || strArr[0] == null) ? -1 : 1;
    }
}

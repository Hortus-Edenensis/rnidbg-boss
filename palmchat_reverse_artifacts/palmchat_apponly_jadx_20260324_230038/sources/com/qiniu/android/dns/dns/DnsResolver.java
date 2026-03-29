package com.qiniu.android.dns.dns;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class DnsResolver implements IResolver {
    private final ExecutorService executorService;
    private final int recordType;
    private final String[] servers;
    protected final int timeout;
    private static ScheduledExecutorService timeoutExecutorService = Executors.newSingleThreadScheduledExecutor();
    private static ExecutorService defaultExecutorService = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public DnsResolver(String str) {
        this(str, 1, 10);
    }

    private DnsResponse lookupHost(String str) throws IOException {
        return request(str, this.recordType);
    }

    private DnsResponse request(final String str, final int i) throws IOException {
        String[] strArr = this.servers;
        if (strArr == null || strArr.length == 0) {
            throw new IOException("server can not empty");
        }
        if (str == null || str.length() == 0) {
            throw new IOException("host can not empty");
        }
        String[] strArr2 = this.servers;
        DnsResponse dnsResponseRequest = null;
        if (strArr2.length == 1 || this.executorService == null) {
            for (String str2 : strArr2) {
                dnsResponseRequest = request(str2, str, i);
                if (dnsResponseRequest != null) {
                    break;
                }
            }
            return dnsResponseRequest;
        }
        final DnsResponse[] dnsResponseArr = {null};
        final IOException[] iOExceptionArr = {null};
        final int[] iArr = {0};
        final Object obj = new Object();
        timeoutExecutorService.schedule(new Callable<Object>() { // from class: com.qiniu.android.dns.dns.DnsResolver.1
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                synchronized (obj) {
                    obj.notify();
                    iOExceptionArr[0] = new IOException("resolver timeout for server:" + DnsResolver.this.servers.toString() + " host:" + str);
                }
                return null;
            }
        }, this.timeout, TimeUnit.SECONDS);
        String[] strArr3 = this.servers;
        int length = strArr3.length;
        int i2 = 0;
        while (i2 < length) {
            final String str3 = strArr3[i2];
            this.executorService.submit(new Runnable() { // from class: com.qiniu.android.dns.dns.DnsResolver.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (obj) {
                        try {
                            dnsResponseArr[0] = DnsResolver.this.request(str3, str, i);
                        } catch (Exception e) {
                            e.printStackTrace();
                            iOExceptionArr[0] = new IOException(e);
                        }
                        int[] iArr2 = iArr;
                        int i3 = iArr2[0] + 1;
                        iArr2[0] = i3;
                        if (i3 == DnsResolver.this.servers.length || dnsResponseArr[0] != null) {
                            obj.notify();
                        }
                    }
                }
            });
            i2++;
            length = length;
            strArr3 = strArr3;
        }
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        IOException iOException = iOExceptionArr[0];
        if (iOException == null) {
            return dnsResponseArr[0];
        }
        throw iOException;
    }

    public abstract DnsResponse request(String str, String str2, int i) throws IOException;

    @Override // com.qiniu.android.dns.IResolver
    public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
        DnsResponse dnsResponseLookupHost = lookupHost(domain.domain);
        if (dnsResponseLookupHost == null) {
            throw new IOException("response is null");
        }
        List<Record> answerArray = dnsResponseLookupHost.getAnswerArray();
        if (answerArray == null || answerArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Record record : answerArray) {
            if (record.isA() || record.isCname() || record.isAAAA()) {
                arrayList.add(record);
            }
        }
        return (Record[]) arrayList.toArray(new Record[0]);
    }

    public DnsResolver(String str, int i) {
        this(str, 1, i);
    }

    public DnsResolver(String str, int i, int i2) {
        this(str == null ? null : new String[]{str}, i, i2, null);
    }

    public DnsResolver(String[] strArr, int i, int i2) {
        this(strArr, i, i2, (strArr == null || strArr.length <= 0) ? null : defaultExecutorService);
    }

    public DnsResolver(String[] strArr, int i, int i2, ExecutorService executorService) {
        this.recordType = i;
        this.timeout = i2 <= 0 ? 10 : i2;
        this.servers = strArr;
        this.executorService = executorService;
    }
}

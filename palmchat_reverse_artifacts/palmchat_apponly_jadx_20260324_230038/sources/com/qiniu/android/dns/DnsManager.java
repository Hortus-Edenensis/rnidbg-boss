package com.qiniu.android.dns;

import com.qiniu.android.dns.http.DomainNotOwn;
import com.qiniu.android.dns.local.Hosts;
import com.qiniu.android.dns.util.LruCache;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class DnsManager {
    private final LruCache<String, Record[]> cache;
    private final Hosts hosts;
    private volatile int index;
    private volatile NetworkInfo info;
    public QueryErrorHandler queryErrorHandler;
    private final IResolver[] resolvers;
    private final RecordSorter sorter;

    /* JADX INFO: compiled from: SearchBox */
    public interface QueryErrorHandler {
        void queryError(Exception exc, String str);
    }

    public DnsManager(NetworkInfo networkInfo, IResolver[] iResolverArr) {
        this(networkInfo, iResolverArr, null);
    }

    private void clearCache() {
        synchronized (this.cache) {
            this.cache.clear();
        }
    }

    private static Record[] filterInvalidRecords(Record[] recordArr) {
        String str;
        if (recordArr == null || recordArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(recordArr.length);
        for (Record record : recordArr) {
            if (record != null && (str = record.value) != null && str.length() > 0 && !record.isExpired()) {
                arrayList.add(record);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (Record[]) arrayList.toArray(new Record[arrayList.size()]);
    }

    public static boolean needHttpDns() {
        try {
            String id = TimeZone.getDefault().getID();
            if (!"Asia/Shanghai".equals(id) && !"Asia/Chongqing".equals(id) && !"Asia/Harbin".equals(id)) {
                if (!"Asia/Urumqi".equals(id)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private Record[] queryRecordInternal(Domain domain) throws IOException {
        Record[] recordArrFilterInvalidRecords;
        Record[] recordArrFilterInvalidRecords2;
        if (domain.hostsFirst && (recordArrFilterInvalidRecords2 = filterInvalidRecords(this.hosts.query(domain, this.info))) != null && recordArrFilterInvalidRecords2.length > 0) {
            return recordArrFilterInvalidRecords2;
        }
        synchronized (this.cache) {
            if (this.info.equals(NetworkInfo.normal) && Network.isNetworkChanged()) {
                this.cache.clear();
                synchronized (this.resolvers) {
                    this.index = 0;
                }
            } else {
                Record[] recordArrFilterInvalidRecords3 = filterInvalidRecords(this.cache.get(domain.domain));
                if (recordArrFilterInvalidRecords3 != null && recordArrFilterInvalidRecords3.length > 0) {
                    return recordArrFilterInvalidRecords3;
                }
            }
            int i = this.index;
            Record[] recordArrResolve = null;
            IOException e = null;
            int i2 = 0;
            while (true) {
                IResolver[] iResolverArr = this.resolvers;
                if (i2 >= iResolverArr.length) {
                    break;
                }
                int length = (i + i2) % iResolverArr.length;
                NetworkInfo networkInfo = this.info;
                String ip = Network.getIp();
                try {
                    recordArrResolve = this.resolvers[length].resolve(domain, this.info);
                } catch (DomainNotOwn unused) {
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    QueryErrorHandler queryErrorHandler = this.queryErrorHandler;
                    if (queryErrorHandler != null) {
                        queryErrorHandler.queryError(e, domain.domain);
                    }
                } catch (Exception e3) {
                    IOException iOException = new IOException(e3);
                    e3.printStackTrace();
                    QueryErrorHandler queryErrorHandler2 = this.queryErrorHandler;
                    if (queryErrorHandler2 != null) {
                        queryErrorHandler2.queryError(e3, domain.domain);
                    }
                    e = iOException;
                }
                String ip2 = Network.getIp();
                if (this.info != networkInfo || ((recordArrResolve != null && recordArrResolve.length != 0) || !ip.equals(ip2))) {
                    break;
                }
                synchronized (this.resolvers) {
                    if (this.index == i) {
                        this.index++;
                        if (this.index == this.resolvers.length) {
                            this.index = 0;
                        }
                    }
                }
                i2++;
            }
            if (recordArrResolve != null && recordArrResolve.length != 0) {
                Record[] recordArrTrimCname = trimCname(recordArrResolve);
                if (recordArrTrimCname.length == 0) {
                    throw new UnknownHostException("no A/AAAA records");
                }
                synchronized (this.cache) {
                    this.cache.put(domain.domain, recordArrTrimCname);
                }
                return recordArrTrimCname;
            }
            if (!domain.hostsFirst && (recordArrFilterInvalidRecords = filterInvalidRecords(this.hosts.query(domain, this.info))) != null && recordArrFilterInvalidRecords.length != 0) {
                return recordArrFilterInvalidRecords;
            }
            if (e != null) {
                throw e;
            }
            UnknownHostException unknownHostException = new UnknownHostException(domain.domain);
            QueryErrorHandler queryErrorHandler3 = this.queryErrorHandler;
            if (queryErrorHandler3 == null) {
                throw unknownHostException;
            }
            queryErrorHandler3.queryError(unknownHostException, domain.domain);
            throw unknownHostException;
        }
    }

    private static String[] records2Ip(Record[] recordArr) {
        if (recordArr == null || recordArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(recordArr.length);
        for (Record record : recordArr) {
            arrayList.add(record.value);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static Record[] trimCname(Record[] recordArr) {
        ArrayList arrayList = new ArrayList(recordArr.length);
        for (Record record : recordArr) {
            if (record != null && (record.isA() || record.isAAAA())) {
                arrayList.add(record);
            }
        }
        return (Record[]) arrayList.toArray(new Record[arrayList.size()]);
    }

    public static boolean validIP(String str) {
        if (str == null || str.length() < 7 || str.length() > 15 || str.contains("-")) {
            return false;
        }
        try {
            int iIndexOf = str.indexOf(46);
            if (iIndexOf != -1 && Integer.parseInt(str.substring(0, iIndexOf)) > 255) {
                return false;
            }
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(46, i);
            if (iIndexOf2 != -1 && Integer.parseInt(str.substring(i, iIndexOf2)) > 255) {
                return false;
            }
            int i2 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(46, i2);
            if (iIndexOf3 != -1 && Integer.parseInt(str.substring(i2, iIndexOf3)) > 255 && Integer.parseInt(str.substring(iIndexOf3 + 1, str.length() - 1)) > 255) {
                if (str.charAt(str.length() - 1) != '.') {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public void onNetworkChange(NetworkInfo networkInfo) {
        clearCache();
        if (networkInfo == null) {
            networkInfo = NetworkInfo.normal;
        }
        this.info = networkInfo;
        synchronized (this.resolvers) {
            this.index = 0;
        }
    }

    public DnsManager putHosts(String str, Record record, int i) {
        this.hosts.put(str, new Hosts.Value(new Record(record.value, record.type, record.ttl, record.timeStamp, 1, record.server), i));
        return this;
    }

    public InetAddress[] queryInetAdress(Domain domain) throws IOException {
        String[] strArrRecords2Ip = records2Ip(queryRecords(domain));
        if (strArrRecords2Ip == null || strArrRecords2Ip.length == 0) {
            return null;
        }
        InetAddress[] inetAddressArr = new InetAddress[strArrRecords2Ip.length];
        for (int i = 0; i < strArrRecords2Ip.length; i++) {
            inetAddressArr[i] = InetAddress.getByName(strArrRecords2Ip[i]);
        }
        return inetAddressArr;
    }

    public Record[] queryRecords(String str) throws IOException {
        return queryRecords(new Domain(str));
    }

    public DnsManager(NetworkInfo networkInfo, IResolver[] iResolverArr, RecordSorter recordSorter) {
        this.hosts = new Hosts();
        this.info = null;
        this.index = 0;
        this.info = networkInfo == null ? NetworkInfo.normal : networkInfo;
        this.resolvers = (IResolver[]) iResolverArr.clone();
        this.cache = new LruCache<>();
        this.sorter = recordSorter == null ? new DummySorter() : recordSorter;
    }

    public Record[] queryRecords(Domain domain) throws IOException {
        if (domain == null) {
            throw new IOException("null domain");
        }
        String str = domain.domain;
        if (str != null && str.trim().length() != 0) {
            return validIP(domain.domain) ? new Record[]{new Record(domain.domain, 1, -1, new Date().getTime(), 0)} : this.sorter.sort(queryRecordInternal(domain));
        }
        throw new IOException("empty domain " + domain.domain);
    }

    public DnsManager putHosts(String str, int i, String str2, int i2) {
        putHosts(str, new Record(str2, i, -1, new Date().getTime() / 1000, 1), i2);
        return this;
    }

    public DnsManager putHosts(String str, int i, String str2) {
        putHosts(str, i, str2, 0);
        return this;
    }

    public DnsManager putHosts(String str, String str2) {
        putHosts(str, 1, str2);
        return this;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class DummySorter implements RecordSorter {
        private AtomicInteger pos;

        private DummySorter() {
            this.pos = new AtomicInteger();
        }

        @Override // com.qiniu.android.dns.RecordSorter
        public Record[] sort(Record[] recordArr) {
            return recordArr;
        }
    }
}

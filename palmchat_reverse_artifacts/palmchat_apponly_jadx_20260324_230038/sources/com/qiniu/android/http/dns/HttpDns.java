package com.qiniu.android.http.dns;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.dns.DohResolver;
import com.qiniu.android.storage.GlobalConfiguration;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class HttpDns extends BaseDns implements Dns {
    private IResolver httpIpv4Resolver;
    private IResolver httpIpv6Resolver;

    public HttpDns(int i) {
        String[] dohIpv4Servers = GlobalConfiguration.getInstance().getDohIpv4Servers();
        if (dohIpv4Servers != null && dohIpv4Servers.length > 0) {
            this.httpIpv4Resolver = new DohResolver(dohIpv4Servers, 1, i, BaseDns.executor);
        }
        String[] dohIpv6Servers = GlobalConfiguration.getInstance().getDohIpv6Servers();
        if (dohIpv6Servers == null || dohIpv6Servers.length <= 0) {
            return;
        }
        this.httpIpv6Resolver = new DohResolver(dohIpv6Servers, 1, i, BaseDns.executor);
    }

    @Override // com.qiniu.android.http.dns.Dns
    public List<IDnsNetworkAddress> lookup(String str) throws UnknownHostException {
        Record[] recordArrResolve;
        IResolver iResolver;
        ArrayList arrayList = null;
        if (!GlobalConfiguration.getInstance().dohEnable) {
            return null;
        }
        IResolver iResolver2 = this.httpIpv4Resolver;
        if (iResolver2 == null && this.httpIpv6Resolver == null) {
            throw new UnknownHostException("resolver server is invalid");
        }
        if (iResolver2 != null) {
            try {
                recordArrResolve = iResolver2.resolve(new Domain(str), null);
            } catch (IOException unused) {
                recordArrResolve = null;
            }
        } else {
            recordArrResolve = null;
        }
        if ((recordArrResolve == null || recordArrResolve.length == 0) && (iResolver = this.httpIpv6Resolver) != null) {
            try {
                recordArrResolve = iResolver.resolve(new Domain(str), null);
            } catch (IOException unused2) {
            }
        }
        if (recordArrResolve != null && recordArrResolve.length != 0) {
            arrayList = new ArrayList();
            for (Record record : recordArrResolve) {
                if (record.isA() || record.isAAAA()) {
                    arrayList.add(new DnsNetworkAddress(str, record.value, Long.valueOf(record.timeStamp), "doh:<" + record.server + ">", Long.valueOf(record.timeStamp)));
                }
            }
        }
        return arrayList;
    }
}

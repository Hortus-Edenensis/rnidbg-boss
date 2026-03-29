package com.qiniu.android.http.dns;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.dns.DnsUdpResolver;
import com.qiniu.android.storage.GlobalConfiguration;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UdpDns extends BaseDns implements Dns {
    private IResolver udpIpv4Resolver;
    private IResolver udpIpv6Resolver;

    public UdpDns(int i) {
        String[] udpDnsIpv4Servers = GlobalConfiguration.getInstance().getUdpDnsIpv4Servers();
        if (udpDnsIpv4Servers != null && udpDnsIpv4Servers.length > 0) {
            this.udpIpv4Resolver = new DnsUdpResolver(udpDnsIpv4Servers, 1, i, BaseDns.executor);
        }
        String[] udpDnsIpv6Servers = GlobalConfiguration.getInstance().getUdpDnsIpv6Servers();
        if (udpDnsIpv6Servers == null || udpDnsIpv6Servers.length <= 0) {
            return;
        }
        this.udpIpv6Resolver = new DnsUdpResolver(udpDnsIpv6Servers, 1, i, BaseDns.executor);
    }

    @Override // com.qiniu.android.http.dns.Dns
    public List<IDnsNetworkAddress> lookup(String str) throws UnknownHostException {
        Record[] recordArrResolve;
        IResolver iResolver;
        ArrayList arrayList = null;
        if (!GlobalConfiguration.getInstance().udpDnsEnable) {
            return null;
        }
        IResolver iResolver2 = this.udpIpv4Resolver;
        if (iResolver2 == null && this.udpIpv6Resolver == null) {
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
        if ((recordArrResolve == null || recordArrResolve.length == 0) && (iResolver = this.udpIpv6Resolver) != null) {
            try {
                recordArrResolve = iResolver.resolve(new Domain(str), null);
            } catch (IOException unused2) {
            }
        }
        if (recordArrResolve != null && recordArrResolve.length != 0) {
            arrayList = new ArrayList();
            for (Record record : recordArrResolve) {
                if (record.isA() || record.isAAAA()) {
                    arrayList.add(new DnsNetworkAddress(str, record.value, Long.valueOf(record.timeStamp), "dns:<" + record.server + ">", Long.valueOf(record.timeStamp)));
                }
            }
        }
        return arrayList;
    }
}

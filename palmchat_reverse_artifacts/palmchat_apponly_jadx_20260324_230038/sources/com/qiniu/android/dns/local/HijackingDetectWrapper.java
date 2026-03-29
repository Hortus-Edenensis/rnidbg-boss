package com.qiniu.android.dns.local;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.dns.DnsUdpResolver;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class HijackingDetectWrapper implements IResolver {
    private final DnsUdpResolver resolver;

    public HijackingDetectWrapper(DnsUdpResolver dnsUdpResolver) {
        this.resolver = dnsUdpResolver;
    }

    @Override // com.qiniu.android.dns.IResolver
    public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
        String str;
        boolean z;
        Record[] recordArrResolve = this.resolver.resolve(domain, networkInfo);
        if (domain.hasCname) {
            int length = recordArrResolve.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    str = null;
                    z = false;
                    break;
                }
                Record record = recordArrResolve[i];
                if (record.isCname()) {
                    str = record.server;
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                throw new DnshijackingException(domain.domain, str);
            }
        }
        if (domain.maxTtl != 0) {
            for (Record record2 : recordArrResolve) {
                if (!record2.isCname() && record2.ttl > domain.maxTtl) {
                    throw new DnshijackingException(domain.domain, record2.server, record2.ttl);
                }
            }
        }
        return recordArrResolve;
    }
}

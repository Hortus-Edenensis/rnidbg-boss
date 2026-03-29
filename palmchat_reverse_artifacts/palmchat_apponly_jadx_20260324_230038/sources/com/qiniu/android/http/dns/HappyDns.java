package com.qiniu.android.http.dns;

import com.qiniu.android.dns.DnsManager;
import com.qiniu.android.storage.GlobalConfiguration;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class HappyDns implements Dns {
    private DnsQueryErrorHandler errorHandler;
    private SystemDns systemDns = new SystemDns(GlobalConfiguration.getInstance().dnsResolveTimeout);
    private Dns customDns = GlobalConfiguration.getInstance().dns;

    /* JADX INFO: compiled from: SearchBox */
    public interface DnsQueryErrorHandler extends DnsManager.QueryErrorHandler {
    }

    private void handleDnsError(IOException iOException, String str) {
        DnsQueryErrorHandler dnsQueryErrorHandler = this.errorHandler;
        if (dnsQueryErrorHandler != null) {
            dnsQueryErrorHandler.queryError(iOException, str);
        }
    }

    @Override // com.qiniu.android.http.dns.Dns
    public List<IDnsNetworkAddress> lookup(String str) throws UnknownHostException {
        int i = GlobalConfiguration.getInstance().dnsResolveTimeout;
        Dns dns = this.customDns;
        List<IDnsNetworkAddress> listLookup = null;
        if (dns != null) {
            try {
                listLookup = dns.lookup(str);
            } catch (IOException e) {
                handleDnsError(e, str);
            }
            if (listLookup != null && listLookup.size() > 0) {
                return listLookup;
            }
        }
        try {
            listLookup = this.systemDns.lookup(str);
        } catch (IOException e2) {
            handleDnsError(e2, str);
        }
        if (listLookup != null && listLookup.size() > 0) {
            return listLookup;
        }
        try {
            listLookup = new HttpDns(i).lookup(str);
        } catch (IOException e3) {
            handleDnsError(e3, str);
        }
        if (listLookup != null && listLookup.size() > 0) {
            return listLookup;
        }
        try {
            return new UdpDns(i).lookup(str);
        } catch (IOException e4) {
            handleDnsError(e4, str);
            return listLookup;
        }
    }

    public void setQueryErrorHandler(DnsQueryErrorHandler dnsQueryErrorHandler) {
        this.errorHandler = dnsQueryErrorHandler;
    }
}

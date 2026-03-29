package defpackage;

import com.zenmen.palmchat.framework.httpdns.DNSNode;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class oe1 {
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b8, code lost:
    
        defpackage.pe1.a("DnsHelper", "UPDATE_REASON_NO_CACHE_WHEN_DOING_HTTP_REQUEST  else ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00be, code lost:
    
        defpackage.pe1.a("DnsHelper", "create HttpURLConnection by origion url:::" + r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d6, code lost:
    
        return r9.a(r10, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d7, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d8, code lost:
    
        defpackage.pe1.a("DnsHelper", "exception when create HttpURLConnection by origion url:::" + r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ec, code lost:
    
        if (r12 != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ee, code lost:
    
        defpackage.pe1.a("DnsHelper", "update  ipList UPDATE_REASON_ALL_IP_FAILED");
        defpackage.it0.k().s("all ip failed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fc, code lost:
    
        if (r13 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fe, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ff, code lost:
    
        throw r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpURLConnection a(pn2 pn2Var, String str, Map<String, String> map, boolean z, boolean z2) throws Exception {
        pe1.a("DnsHelper", "origion URL:::" + str);
        Iterator<te1> it = it0.k().g().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            te1 next = it.next();
            if (next.a(str)) {
                int i = 0;
                while (true) {
                    if (i >= 2) {
                        break;
                    }
                    DNSNode[] dNSNodeArrI = it0.k().i(next.f20971a);
                    if (dNSNodeArrI != null) {
                        for (DNSNode dNSNode : dNSNodeArrI) {
                            String strQ = it0.q(str, next, dNSNode);
                            pe1.a("DnsHelper", "replace URL:::" + strQ);
                            HashMap map2 = new HashMap();
                            if (map != null) {
                                map2.putAll(map);
                            }
                            map2.put("Host", next.f20971a);
                            try {
                                HttpURLConnection httpURLConnectionA = pn2Var.a(strQ, map2);
                                pe1.a("DnsHelper", "create HttpURLConnection by ip.");
                                return httpURLConnectionA;
                            } catch (Exception e) {
                                pe1.a("DnsHelper", "exception when create HttpURLConnection by ip.");
                                e.printStackTrace();
                            }
                        }
                    } else {
                        if (!it0.k().n() || i != 0 || !z) {
                            break;
                        }
                        pe1.a("DnsHelper", "UPDATE_REASON_NO_CACHE_WHEN_DOING_HTTP_REQUEST");
                        it0.k().t("dns cache is empty when doing HTTP request" + str);
                        i++;
                    }
                }
            }
        }
    }
}

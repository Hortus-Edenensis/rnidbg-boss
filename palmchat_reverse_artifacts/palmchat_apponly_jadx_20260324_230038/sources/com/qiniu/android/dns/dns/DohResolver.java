package com.qiniu.android.dns.dns;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DohResolver extends DnsResolver {
    public DohResolver(String str) {
        super(str);
    }

    @Override // com.qiniu.android.dns.dns.DnsResolver
    public DnsResponse request(String str, String str2, int i) throws IOException {
        int contentLength;
        DnsRequest dnsRequest = new DnsRequest((short) (Math.random() * 65535.0d), i, str2);
        byte[] dnsQuestionData = dnsRequest.toDnsQuestionData();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setConnectTimeout(3000);
        httpsURLConnection.setReadTimeout(this.timeout * 1000);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("Content-Type", "application/dns-message");
        httpsURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/dns-message");
        httpsURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "");
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.write(dnsQuestionData);
        dataOutputStream.close();
        if (httpsURLConnection.getResponseCode() != 200 || (contentLength = httpsURLConnection.getContentLength()) <= 0 || contentLength > 1048576) {
            return null;
        }
        InputStream inputStream = httpsURLConnection.getInputStream();
        byte[] bArr = new byte[contentLength];
        int i2 = inputStream.read(bArr);
        inputStream.close();
        if (i2 <= 0) {
            return null;
        }
        return new DnsResponse(str, 5, dnsRequest, bArr);
    }

    public DohResolver(String str, int i) {
        super(str, i);
    }

    public DohResolver(String str, int i, int i2) {
        super(str, i, i2);
    }

    public DohResolver(String[] strArr, int i, int i2) {
        super(strArr, i, i2);
    }

    public DohResolver(String[] strArr, int i, int i2, ExecutorService executorService) {
        super(strArr, i, i2, executorService);
    }
}

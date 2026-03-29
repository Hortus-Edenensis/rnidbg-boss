package com.qiniu.android.dns.http;

import com.huawei.openalliance.ad.constant.x;
import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.util.Hex;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class DnspodEnterprise implements IResolver {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final String id;
    private final String ip;
    private final SecretKeySpec key;
    private final int timeout;

    public DnspodEnterprise(String str, String str2, String str3) {
        this(str, str2, str3, 10);
    }

    private String decrypt(String str) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(2, this.key);
            return new String(cipher.doFinal(Hex.decodeHex(str.toCharArray())));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String encrypt(String str) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(1, this.key);
            return Hex.encodeHexString(cipher.doFinal(str.getBytes(UTF_8))) + "&id=" + this.id;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.qiniu.android.dns.IResolver
    public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
        int contentLength;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://" + this.ip + "/d?ttl=1&dn=" + encrypt(domain.domain) + "&id=" + this.id).openConnection();
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.setReadTimeout(this.timeout * 1000);
        if (httpURLConnection.getResponseCode() == 200 && (contentLength = httpURLConnection.getContentLength()) > 0 && contentLength <= 1024) {
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[contentLength];
            int i = inputStream.read(bArr);
            inputStream.close();
            if (i <= 0) {
                return null;
            }
            String[] strArrSplit = decrypt(new String(bArr, 0, i)).split(",");
            if (strArrSplit.length != 2) {
                return null;
            }
            try {
                int i2 = Integer.parseInt(strArrSplit[1]);
                String[] strArrSplit2 = strArrSplit[0].split(x.aQ);
                if (strArrSplit2.length == 0) {
                    return null;
                }
                Record[] recordArr = new Record[strArrSplit2.length];
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                for (int i3 = 0; i3 < strArrSplit2.length; i3++) {
                    recordArr[i3] = new Record(strArrSplit2[i3], 1, i2, jCurrentTimeMillis, 2);
                }
                return recordArr;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public DnspodEnterprise(String str, String str2, String str3, int i) {
        this.id = str;
        this.ip = str3;
        this.timeout = i;
        this.key = new SecretKeySpec(str2.getBytes(UTF_8), "DES");
    }

    public DnspodEnterprise(String str, String str2) {
        this(str, str2, "119.29.29.29");
    }
}

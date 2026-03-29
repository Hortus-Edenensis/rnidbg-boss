package com.qiniu.android.dns.dns;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DnsUdpResolver extends DnsResolver {
    private static final int DnsUdpPort = 53;

    public DnsUdpResolver(String str) {
        super(str);
    }

    @Override // com.qiniu.android.dns.dns.DnsResolver
    public DnsResponse request(String str, String str2, int i) throws Throwable {
        DnsRequest dnsRequest = new DnsRequest((short) (Math.random() * 65535.0d), i, str2);
        byte[] dnsQuestionData = dnsRequest.toDnsQuestionData();
        InetAddress byName = InetAddress.getByName(str);
        DatagramSocket datagramSocket = null;
        try {
            DatagramSocket datagramSocket2 = new DatagramSocket();
            try {
                DatagramPacket datagramPacket = new DatagramPacket(dnsQuestionData, dnsQuestionData.length, byName, 53);
                datagramSocket2.setSoTimeout(this.timeout * 1000);
                datagramSocket2.send(datagramPacket);
                DatagramPacket datagramPacket2 = new DatagramPacket(new byte[TTAdConstant.STYLE_SIZE_RADIO_3_2], TTAdConstant.STYLE_SIZE_RADIO_3_2);
                datagramSocket2.receive(datagramPacket2);
                DnsResponse dnsResponse = new DnsResponse(str, 4, dnsRequest, datagramPacket2.getData());
                datagramSocket2.close();
                return dnsResponse;
            } catch (Throwable th) {
                th = th;
                datagramSocket = datagramSocket2;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public DnsUdpResolver(String str, int i) {
        super(str, i);
    }

    public DnsUdpResolver(String str, int i, int i2) {
        super(str, i, i2);
    }

    public DnsUdpResolver(String[] strArr, int i, int i2) {
        super(strArr, i, i2);
    }

    public DnsUdpResolver(String[] strArr, int i, int i2, ExecutorService executorService) {
        super(strArr, i, i2, executorService);
    }
}

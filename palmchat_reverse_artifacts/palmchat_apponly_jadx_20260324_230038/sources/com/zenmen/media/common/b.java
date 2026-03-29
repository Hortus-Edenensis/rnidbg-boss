package com.zenmen.media.common;

import com.huawei.openalliance.ad.constant.x;
import com.zenmen.media.common.IPInfo;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import defpackage.it0;
import defpackage.nl0;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static IPInfo a() {
        IPInfo iPInfo;
        DNSNode[] dNSNodeArrI = it0.k().i(nl0.y);
        if (dNSNodeArrI == null || dNSNodeArrI.length <= 0) {
            iPInfo = null;
        } else {
            int iRandom = (int) (Math.random() * ((double) dNSNodeArrI.length));
            if (iRandom < 0 || iRandom > dNSNodeArrI.length) {
                iRandom = 0;
            }
            IPInfo.IP_Type iP_Type = IPInfo.IP_Type.Cmd;
            DNSNode dNSNode = dNSNodeArrI[iRandom];
            iPInfo = new IPInfo(iP_Type, dNSNode.host, dNSNode.port);
        }
        if (iPInfo != null) {
            return iPInfo;
        }
        if (nl0.f()) {
            iPInfo = new IPInfo(IPInfo.IP_Type.Cmd, "121.46.192.67", 9180);
        } else if (nl0.c().equals("debug") || RTCParameters.k().equals("debug2")) {
            iPInfo = new IPInfo(IPInfo.IP_Type.Cmd, "43.247.90.31", 9180);
        } else if (RTCParameters.k().equals("dev")) {
            iPInfo = new IPInfo(IPInfo.IP_Type.Cmd, "43.247.90.217", 9180);
        } else if (nl0.c().equals("release")) {
            try {
                String[] strArrSplit = "121.46.192.70:9180;121.46.192.75:9180".split(x.aQ);
                int iNextInt = new Random().nextInt(strArrSplit.length);
                if (iNextInt >= strArrSplit.length) {
                    iNextInt = 0;
                }
                String[] strArrSplit2 = strArrSplit[iNextInt].split(":");
                iPInfo = new IPInfo(IPInfo.IP_Type.Cmd, strArrSplit2[0], Integer.valueOf(strArrSplit2[1]).intValue());
            } catch (Exception unused) {
                iPInfo = System.currentTimeMillis() % 2 == 0 ? new IPInfo(IPInfo.IP_Type.Cmd, "121.46.192.70", 9180) : new IPInfo(IPInfo.IP_Type.Cmd, "121.46.192.75", 9180);
            }
        }
        return iPInfo != null ? iPInfo : new IPInfo(IPInfo.IP_Type.Cmd, "43.247.90.217", 9180);
    }
}

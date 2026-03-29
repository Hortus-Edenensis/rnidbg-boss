package defpackage;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l27 {
    public static t47 a(DataReportResult dataReportResult) {
        t47 t47Var = new t47();
        if (dataReportResult == null) {
            return null;
        }
        t47Var.f19389a = dataReportResult.success;
        t47Var.b = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            t47Var.c = map.get("apdid");
            t47Var.d = map.get("apdidToken");
            t47Var.g = map.get("dynamicKey");
            t47Var.h = map.get("timeInterval");
            t47Var.i = map.get("webrtcUrl");
            t47Var.j = "";
            String str = map.get("drmSwitch");
            if (xu6.f(str)) {
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(0));
                    t47Var.e = sb.toString();
                }
                if (str.length() >= 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(2));
                    t47Var.f = sb2.toString();
                }
            }
            if (map.containsKey("apse_degrade")) {
                t47Var.k = map.get("apse_degrade");
            }
        }
        return t47Var;
    }

    public static DataReportRequest b(y87 y87Var) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (y87Var == null) {
            return null;
        }
        dataReportRequest.os = y87Var.f22163a;
        dataReportRequest.rpcVersion = y87Var.j;
        dataReportRequest.bizType = "1";
        HashMap map = new HashMap();
        dataReportRequest.bizData = map;
        map.put("apdid", y87Var.b);
        dataReportRequest.bizData.put("apdidToken", y87Var.c);
        dataReportRequest.bizData.put("umidToken", y87Var.d);
        dataReportRequest.bizData.put("dynamicKey", y87Var.e);
        dataReportRequest.deviceData = y87Var.f;
        return dataReportRequest;
    }
}

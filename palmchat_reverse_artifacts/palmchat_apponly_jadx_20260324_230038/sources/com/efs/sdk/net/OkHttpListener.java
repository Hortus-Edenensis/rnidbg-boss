package com.efs.sdk.net;

import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.efs.sdk.net.a.a;
import com.efs.sdk.net.a.b;
import com.efs.sdk.net.a.c;
import com.efs.sdk.net.a.d;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class OkHttpListener extends EventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f5626a = new AtomicInteger(0);
    private String b;
    private boolean c;
    private List d = new ArrayList();

    private void a(String str) {
        Map<String, Long> map;
        try {
            d dVarC = a.a().c(this.b);
            if (dVarC == null || (map = dVarC.E) == null) {
                return;
            }
            map.put(str, Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        try {
            final d dVarC = a.a().c(this.b);
            final c cVarA = a.a().a(this.b);
            if (dVarC == null || cVarA == null) {
                return;
            }
            Map<String, Long> map = dVarC.E;
            Map<String, Long> map2 = dVarC.F;
            Log.i("NetTrace-Listener", cVarA.toString());
            if (TextUtils.isEmpty(dVarC.B)) {
                Log.d("NetTrace-Listener", "url is null.");
                return;
            }
            final EfsJSONLog efsJSONLog = new EfsJSONLog("netperf");
            if (map.containsKey(d.d)) {
                efsJSONLog.put("wd_dns", map.get(d.d));
            }
            if (map.containsKey(d.e)) {
                efsJSONLog.put("wd_dnstm", map.get(d.e));
            }
            if (map2.containsKey(d.t)) {
                efsJSONLog.put("wl_dns", map2.get(d.t));
            }
            if (map.containsKey(d.f)) {
                efsJSONLog.put("wd_tcp", map.get(d.f));
            }
            if (map.containsKey(d.i)) {
                efsJSONLog.put("wd_tcptm", map.get(d.i));
            }
            if (map2.containsKey(d.v)) {
                efsJSONLog.put("wl_tcp", map2.get(d.v));
            }
            if (map.containsKey(d.g)) {
                efsJSONLog.put("wd_ssl", map.get(d.g));
            }
            if (map.containsKey(d.h)) {
                efsJSONLog.put("wd_ssltm", map.get(d.h));
            }
            if (map2.containsKey(d.u)) {
                efsJSONLog.put("wl_ssl", map2.get(d.u));
            }
            if (map.containsKey(d.k)) {
                efsJSONLog.put("wd_ds", map.get(d.k));
            }
            if (map.containsKey(d.n)) {
                efsJSONLog.put("wd_dstm", map.get(d.n));
            }
            if (map2.containsKey(d.w) && map2.containsKey(d.x)) {
                efsJSONLog.put("wl_ds", Long.valueOf(map2.get(d.w).longValue() + map2.get(d.x).longValue()));
            }
            if (map.containsKey(d.o)) {
                efsJSONLog.put("wd_srt", map.get(d.o));
            }
            if (map.containsKey(d.r)) {
                efsJSONLog.put("wd_srttm", map.get(d.r));
            }
            if (map2.containsKey(d.y) && map2.containsKey(d.z)) {
                efsJSONLog.put("wl_srt", Long.valueOf(map2.get(d.y).longValue() + map2.get(d.z).longValue()));
            }
            String[] strArrSplit = dVarC.B.split("\\?");
            String str = strArrSplit != null ? strArrSplit[0] : null;
            List list = this.d;
            if (list == null || str == null || list.contains(str)) {
                efsJSONLog.put("wd_ttfb", 0);
                efsJSONLog.put("wd_ttfbtm", 0);
                efsJSONLog.put("wl_ttfb", 0);
            } else {
                this.d.add(str);
                if (map.containsKey(d.n)) {
                    efsJSONLog.put("wd_ttfb", map.get(d.n));
                } else if (map.containsKey(d.l)) {
                    efsJSONLog.put("wd_ttfb", map.get(d.l));
                }
                if (map.containsKey(d.o)) {
                    efsJSONLog.put("wd_ttfbtm", map.get(d.o));
                }
                if (map.containsKey(d.o)) {
                    if (map.containsKey(d.n)) {
                        efsJSONLog.put("wl_ttfb", Long.valueOf(map.get(d.o).longValue() - map.get(d.n).longValue()));
                    } else if (map.containsKey(d.l)) {
                        efsJSONLog.put("wl_ttfb", Long.valueOf(map.get(d.o).longValue() - map.get(d.l).longValue()));
                    }
                }
            }
            if (map.containsKey(d.f5639a)) {
                efsJSONLog.put("wd_rt", map.get(d.f5639a));
            }
            if (map.containsKey(d.b)) {
                efsJSONLog.put("wd_rttm", map.get(d.b));
            }
            if (map2.containsKey(d.s)) {
                efsJSONLog.put("wl_rt", map2.get(d.s));
            }
            efsJSONLog.put("wk_res", cVarA.c);
            efsJSONLog.put("wk_res_ori", dVarC.B);
            efsJSONLog.put("wk_ip", dVarC.C);
            efsJSONLog.put("wk_method", cVarA.e);
            efsJSONLog.put("wk_rc", Integer.valueOf(cVarA.i));
            efsJSONLog.put("wl_up", Long.valueOf(cVarA.g));
            efsJSONLog.put("wl_down", Long.valueOf(cVarA.m));
            efsJSONLog.put("wl_total", Long.valueOf(cVarA.g + cVarA.m));
            b.a(new Runnable() { // from class: com.efs.sdk.net.OkHttpListener.2
                @Override // java.lang.Runnable
                public final void run() {
                    Map<String, String> map3;
                    Map<String, String> map4;
                    try {
                        try {
                            String strA = com.efs.sdk.net.b.a.a((dVarC.E.containsKey(d.f5639a) ? String.valueOf(dVarC.E.get(d.f5639a)) : "") + ControllerCenter.getGlobalEnvStruct().getAppid() + ControllerCenter.getGlobalEnvStruct().getSecret());
                            if (NetManager.getNetConfigManager().getNetRequestBodyCollectState() && !TextUtils.isEmpty(cVarA.h)) {
                                efsJSONLog.put("wk_bd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(cVarA.h.getBytes(), strA.getBytes())));
                            }
                            if (NetManager.getNetConfigManager().getNetResponseBodyCollectState() && !TextUtils.isEmpty(cVarA.k)) {
                                efsJSONLog.put("wk_res_bd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(cVarA.k.getBytes(), strA.getBytes())));
                            }
                            if (NetManager.getNetConfigManager().getNetRequestHeaderCollectState() && (map4 = cVarA.f) != null && !map4.isEmpty()) {
                                efsJSONLog.put("wk_req_hd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(new JSONObject(cVarA.f).toString().getBytes(), strA.getBytes())));
                            }
                            if (NetManager.getNetConfigManager().getNetResponseHeaderCollectState() && (map3 = cVarA.l) != null && !map3.isEmpty()) {
                                efsJSONLog.put("wk_res_hd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(new JSONObject(cVarA.l).toString().getBytes(), strA.getBytes())));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        OkHttpListener.a(dVarC, cVarA, efsJSONLog);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            });
            a.a().d(this.b);
            a.a().b(this.b);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static EventListener.Factory get() {
        return new EventListener.Factory() { // from class: com.efs.sdk.net.OkHttpListener.1
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call call) {
                return new OkHttpListener();
            }
        };
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        super.callEnd(call);
        try {
            Log.d("NetTrace-Listener", "callEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callEnd net enable false.");
                return;
            }
            a(d.b);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        try {
            Log.d("NetTrace-Listener", "callFailed");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callFailed net enable false.");
                return;
            }
            a(d.c);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        super.callStart(call);
        try {
            Log.d("NetTrace-Listener", "callStart");
            if (NetManager.getNetConfigManager() != null && NetManager.getNetConfigManager().enableTracer()) {
                this.c = true;
            }
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callStart net enable false.");
                return;
            }
            this.b = String.valueOf(f5626a.getAndIncrement());
            Log.i("NetTrace-Listener", "requestId is" + this.b);
            a(d.f5639a);
            String string = call.request().url().getUrl();
            try {
                d dVarC = a.a().c(this.b);
                if (dVarC != null) {
                    dVarC.B = string;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        try {
            Log.d("NetTrace-Listener", "connectEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectEnd net enable false.");
                return;
            }
            a(d.i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        try {
            Log.d("NetTrace-Listener", "connectFailed");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectFailed net enable false.");
                return;
            }
            a(d.j);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        try {
            Log.d("NetTrace-Listener", "connectStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectStart net enable false.");
                return;
            }
            a(d.f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        try {
            Log.d("NetTrace-Listener", "connectionAcquired");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callStart net enable false.");
                return;
            }
            InetAddress inetAddress = connection.socket().getInetAddress();
            if (inetAddress != null) {
                String hostAddress = inetAddress.getHostAddress();
                try {
                    d dVarC = a.a().c(this.b);
                    if (dVarC != null) {
                        dVarC.C = hostAddress;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        try {
            Log.d("NetTrace-Listener", "dnsEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "dnsEnd net enable false.");
                return;
            }
            a(d.e);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        try {
            Log.d("NetTrace-Listener", "dnsStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "dnsStart net enable false.");
                return;
            }
            a(d.d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        try {
            Log.d("NetTrace-Listener", "requestBodyEnd");
            call.request().body();
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestBodyEnd net enable false.");
                return;
            }
            a(d.n);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        try {
            Log.d("NetTrace-Listener", "requestBodyStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestBodyStart net enable false.");
                return;
            }
            a(d.m);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        try {
            Log.d("NetTrace-Listener", "requestHeadersEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestHeadersEnd net enable false.");
                return;
            }
            a(d.l);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        try {
            Log.d("NetTrace-Listener", "requestHeadersStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestHeadersStart net enable false.");
                return;
            }
            a(d.k);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        try {
            Log.d("NetTrace-Listener", "responseBodyEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseBodyEnd net enable false.");
                return;
            }
            a(d.r);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        try {
            Log.d("NetTrace-Listener", "responseBodyStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseBodyStart net enable false.");
                return;
            }
            a(d.q);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        try {
            Log.d("NetTrace-Listener", "responseHeadersEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseHeadersEnd net enable false.");
                return;
            }
            a(d.p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        try {
            Log.d("NetTrace-Listener", "responseHeadersStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseHeadersStart net enable false.");
                return;
            }
            a(d.o);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        try {
            Log.d("NetTrace-Listener", "secureConnectEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "secureConnectEnd net enable false.");
                return;
            }
            a(d.h);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        try {
            Log.d("NetTrace-Listener", "secureConnectStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "secureConnectStart net enable false.");
                return;
            }
            a(d.g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() {
        try {
            d dVarC = a.a().c(this.b);
            if (dVarC != null) {
                Map<String, Long> map = dVarC.E;
                Map<String, Long> map2 = dVarC.F;
                map2.put(d.s, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f5639a, d.b)));
                map2.put(d.t, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.d, d.e)));
                map2.put(d.u, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.g, d.h)));
                map2.put(d.v, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f, d.i)));
                map2.put(d.w, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.k, d.l)));
                map2.put(d.x, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.m, d.n)));
                map2.put(d.y, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.o, d.p)));
                map2.put(d.z, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.q, d.r)));
                b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(EfsJSONLog efsJSONLog) {
        try {
            EfsReporter reporter = NetManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog);
                if (SamplingWhiteListUtil.isHitWL()) {
                    return;
                }
                SharedPreferences sharedPreferences = ControllerCenter.getGlobalEnvStruct().mAppContext.getSharedPreferences("net_launch" + ProcessUtil.getCurrentProcessName(), 0);
                String str = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(System.currentTimeMillis()));
                if (sharedPreferences != null) {
                    int i = sharedPreferences.getInt(str, 0);
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    if (editorEdit != null) {
                        editorEdit.putInt(str, i + 1);
                        editorEdit.apply();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static String a(Map<String, String> map, boolean z, boolean z2) {
        try {
            StringBuilder sb = new StringBuilder();
            if (!SamplingWhiteListUtil.isHitWL()) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(NetManager.getNetConfigManager().getExtraRateFlag());
            if (map.size() != 0 && !z && z2) {
                sb.append("|1");
            } else {
                sb.append("|0");
            }
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(new JSONObject(map).toString());
            return com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(sb.toString().getBytes(), ControllerCenter.getGlobalEnvStruct().getSecret().getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(d dVar, c cVar, EfsJSONLog efsJSONLog) {
        boolean z;
        boolean zA;
        boolean z2;
        boolean z3;
        int iOptInt;
        try {
            SharedPreferences sharedPreferences = ControllerCenter.getGlobalEnvStruct().mAppContext.getSharedPreferences("net_launch" + ProcessUtil.getCurrentProcessName(), 0);
            String str = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(System.currentTimeMillis()));
            if (sharedPreferences != null) {
                int i = sharedPreferences.getInt(str, 0);
                if (!SamplingWhiteListUtil.isHitWL() && NetManager.getNetConfigManager().getDayLimit() != -1) {
                    if (i >= NetManager.getNetConfigManager().getDayLimit()) {
                        return;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        Map<String, Object> strategyMap = NetManager.getReporter().getStrategyMap();
        boolean zA2 = com.efs.sdk.net.b.a.a(NetManager.getNetConfigManager().getDataRate());
        String strA = "";
        if (strategyMap == null || strategyMap.size() != 2) {
            z = false;
            zA = false;
        } else {
            try {
                zA = com.efs.sdk.net.b.a.a(((Integer) strategyMap.get("rate")).intValue());
                if (!zA2 && !zA) {
                    try {
                        if (!SamplingWhiteListUtil.isHitWL()) {
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        th.printStackTrace();
                        if (TextUtils.isEmpty(strA)) {
                        }
                        efsJSONLog.put("dx", strA);
                        if (!SamplingWhiteListUtil.isHitWL()) {
                        }
                    }
                }
                JSONArray jSONArray = (JSONArray) strategyMap.get("stra");
                HashMap map = new HashMap();
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                        if (!TextUtils.isEmpty(dVar.B)) {
                            String strOptString = jSONObjectOptJSONObject.optString("u");
                            if (TextUtils.isEmpty(strOptString)) {
                                z3 = false;
                            } else if (!strOptString.startsWith("^")) {
                                Uri uri = Uri.parse(dVar.B);
                                int port = uri.getPort();
                                if (com.efs.sdk.net.b.a.a((port >= 0 && port <= 65535) ? uri.getHost() + ":" + port + uri.getPath() : uri.getHost() + uri.getPath()).equalsIgnoreCase(strOptString)) {
                                    iOptInt = jSONObjectOptJSONObject.optInt("v", -1);
                                    if (iOptInt == -1 && iOptInt <= 3) {
                                        int iOptInt2 = jSONObjectOptJSONObject.optInt("s", -1);
                                        if (iOptInt2 != 0) {
                                            if (iOptInt2 == 2 && NetManager.getNetConfigManager().getNetRequestBodyCollectState()) {
                                                if (!TextUtils.isEmpty(cVar.h)) {
                                                }
                                            }
                                            z3 = false;
                                        }
                                        z3 = true;
                                    }
                                }
                                z3 = false;
                            } else if (Pattern.matches(strOptString, dVar.B)) {
                                iOptInt = jSONObjectOptJSONObject.optInt("v", -1);
                                if (iOptInt == -1) {
                                    z3 = false;
                                }
                            }
                        }
                        if (z3) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(jSONObjectOptJSONObject.optInt("i"));
                            map.put(sb.toString(), "");
                        }
                    }
                }
                z = map.size() != 0;
                if (z) {
                    try {
                        NetManager.getNetConfigManager().setStrategyHitCurrentProcess(true);
                    } catch (Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                    }
                }
                strA = a(map, zA2, zA);
            } catch (Throwable th3) {
                th = th3;
                z = false;
                zA = false;
            }
        }
        if (TextUtils.isEmpty(strA)) {
            z2 = false;
        } else {
            z2 = false;
            strA = a((Map<String, String>) new HashMap(), zA2, false);
        }
        efsJSONLog.put("dx", strA);
        if (!SamplingWhiteListUtil.isHitWL()) {
            a(efsJSONLog);
            return;
        }
        if (z) {
            if (zA2 || zA) {
                a(efsJSONLog);
                return;
            }
            return;
        }
        if (!(NetManager.getNetConfigManager().getExtraRateFlag() == 1)) {
            if (zA2) {
                a(efsJSONLog);
            }
        } else if (NetManager.getNetConfigManager().isStrategyHitCurrentProcess()) {
            int extraDataRate = NetManager.getNetConfigManager().getExtraDataRate();
            if (extraDataRate != 0 && (extraDataRate == 100000 || new Random().nextInt(100000) <= extraDataRate)) {
                z2 = true;
            }
            if (z2) {
                a(efsJSONLog);
            }
        }
    }
}

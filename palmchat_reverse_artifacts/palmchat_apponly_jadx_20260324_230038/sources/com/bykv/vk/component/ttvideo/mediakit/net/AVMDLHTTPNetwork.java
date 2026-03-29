package com.bykv.vk.component.ttvideo.mediakit.net;

import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient;
import com.bytedance.sdk.component.nr.u.fx;
import com.bytedance.sdk.component.nr.u.jk;
import com.bytedance.sdk.component.nr.u.k;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.nr;
import com.bytedance.sdk.component.nr.u.o;
import com.bytedance.sdk.component.nr.u.s;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AVMDLHTTPNetwork extends AVMDLNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final jk JSON = jk.u("application/json");
    private static l mClient;
    private nr mCall;

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void cancel() {
        nr nrVar = this.mCall;
        if (nrVar == null || nrVar.b()) {
            return;
        }
        this.mCall.fx();
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                l.u uVarNr = new l().nr();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                mClient = uVarNr.u(10L, timeUnit).fx(10L, timeUnit).nr(10L, timeUnit).u();
            }
        }
        s.u uVarU = new s.u().u(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                uVarU.u(str2, map.get(str2));
            }
        }
        nr nrVarU = mClient.u(uVarU.nr());
        this.mCall = nrVarU;
        nrVarU.u(new fx() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.1
            @Override // com.bytedance.sdk.component.nr.u.fx
            public void onFailure(nr nrVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.bytedance.sdk.component.nr.u.fx
            public void onResponse(nr nrVar, my myVar) throws Throwable {
                o oVarIz;
                Throwable th;
                JSONObject jSONObject;
                try {
                    oVarIz = myVar.iz();
                    try {
                        try {
                            jSONObject = new JSONObject(oVarIz.nr());
                            e = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (oVarIz != null) {
                                try {
                                    oVarIz.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        jSONObject = null;
                    }
                    if (e == null && !myVar.b()) {
                        e = new Exception("http fail");
                        myVar.fx();
                    }
                    if (oVarIz != null) {
                        try {
                            oVarIz.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (e == null) {
                        completionListener.onCompletion(jSONObject, null);
                    } else {
                        completionListener.onCompletion(jSONObject, new Error(0, null, null, e.toString()));
                    }
                } catch (Throwable th3) {
                    oVarIz = null;
                    th = th3;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                l.u uVarNr = new l().nr();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                mClient = uVarNr.u(10L, timeUnit).fx(10L, timeUnit).nr(10L, timeUnit).u();
            }
        }
        s.u uVarU = new s.u().u(str);
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                uVarU.nr(str2, map.get(str2));
            }
        }
        if (i == 1) {
            uVarU.u(k.u(JSON, String.valueOf(jSONObject)));
        }
        nr nrVarU = mClient.u(uVarU.nr());
        this.mCall = nrVarU;
        nrVarU.u(new fx() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.2
            @Override // com.bytedance.sdk.component.nr.u.fx
            public void onFailure(nr nrVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.bytedance.sdk.component.nr.u.fx
            public void onResponse(nr nrVar, my myVar) throws Throwable {
                o oVarIz;
                Throwable th;
                String string;
                JSONObject jSONObject2;
                try {
                    oVarIz = myVar.iz();
                    try {
                        try {
                            jSONObject2 = new JSONObject(oVarIz.nr());
                            string = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (oVarIz != null) {
                                try {
                                    oVarIz.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        string = e.toString();
                        jSONObject2 = null;
                    }
                    if (!myVar.b()) {
                        string = myVar.pn();
                        myVar.fx();
                    }
                    if (oVarIz != null) {
                        try {
                            oVarIz.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (string == null) {
                        completionListener.onCompletion(jSONObject2, null);
                    } else {
                        completionListener.onCompletion(jSONObject2, new Error(0, null, null, string));
                    }
                } catch (Throwable th3) {
                    oVarIz = null;
                    th = th3;
                }
            }
        });
    }
}

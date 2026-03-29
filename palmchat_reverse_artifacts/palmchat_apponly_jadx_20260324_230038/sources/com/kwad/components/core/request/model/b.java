package com.kwad.components.core.request.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.l.a.d;
import com.kwad.sdk.l.a.e;
import com.kwad.sdk.l.a.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.cd;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b implements com.kwad.sdk.core.b {
    private String Mk;
    private int QI;
    private int aaX;
    private String aaY;
    private Long aaZ;
    private Long aba;
    private Long abb;
    private Long abc;
    private String abd;
    private String abe;
    private long abg;
    private String abh;
    private long abi;
    private String abk;
    private String abl;
    private boolean abm;
    private List<a> abn;
    private f abo;
    private d abp;
    private com.kwad.sdk.l.a.b abq;
    private List<e> abr;
    private List<cd.a> abf = new CopyOnWriteArrayList();
    private int abj = -1;
    private float screenBrightness = -1.0f;
    private int QL = -1;

    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int abs = -1;
        public int abt = -1;
        public int abu = -1;
        public int streamType;

        private a(int i) {
            this.streamType = i;
        }

        public static List<a> aF(Context context) {
            ArrayList arrayList = new ArrayList();
            if (context == null || com.kwad.sdk.core.config.e.ai(256L)) {
                return arrayList;
            }
            try {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (audioManager == null) {
                    return arrayList;
                }
                for (int i = 0; i <= 5; i++) {
                    a aVar = new a(i);
                    int iBn = bn(i);
                    aVar.abu = audioManager.getStreamVolume(iBn);
                    aVar.abs = audioManager.getStreamMaxVolume(iBn);
                    if (Build.VERSION.SDK_INT >= 28) {
                        aVar.abt = audioManager.getStreamMinVolume(iBn);
                    }
                    arrayList.add(aVar);
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        private static int bn(int i) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
            if (i == 3) {
                return 3;
            }
            if (i != 4) {
                return i != 5 ? 0 : 5;
            }
            return 4;
        }
    }

    private void aE(@NonNull Context context) {
        if (com.kwad.sdk.core.config.e.ai(512L)) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, intentFilter);
            if (intentRegisterReceiver != null) {
                int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
                this.abm = intExtra == 2 || intExtra == 5;
                int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", -1);
                if (intExtra2 == 2) {
                    this.QL = 1;
                    return;
                }
                if (intExtra2 == 1) {
                    this.QL = 2;
                } else if (intExtra2 == 4) {
                    this.QL = 3;
                } else if (intExtra2 == 0) {
                    this.QL = 0;
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private static Context getContext() {
        return ServiceProvider.Re();
    }

    @WorkerThread
    public static b tS() {
        b bVar = new b();
        bVar.aaX = br.TJ();
        bVar.aaY = AbiUtil.cy(getContext());
        bVar.QI = br.ed(getContext());
        bVar.aaZ = Long.valueOf(br.ee(getContext()));
        bVar.aba = Long.valueOf(br.ea(getContext()));
        bVar.abb = Long.valueOf(br.TG());
        bVar.abc = Long.valueOf(br.TH());
        bVar.abd = bd.dF(getContext());
        bVar.abe = bd.dG(getContext());
        bVar.abf.addAll(bd.o(getContext(), 15));
        bVar.abg = br.TO();
        bVar.abi = br.TP();
        bVar.abl = br.TQ();
        bVar.abk = br.TR();
        bVar.Mk = br.TS();
        bVar.abh = br.TT();
        Context context = getContext();
        if (context != null) {
            bVar.abj = br.el(context);
            bVar.abn = new CopyOnWriteArrayList(a.aF(context));
            bVar.aE(context);
        }
        bVar.abp = r.RF();
        bVar.abq = bd.QD();
        bVar.abr = bj.Tp().Tq();
        bVar.abo = bd.QE();
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "cpuCount", this.aaX);
        aa.putValue(jSONObject, "cpuAbi", this.aaY);
        aa.putValue(jSONObject, "batteryPercent", this.QI);
        aa.putValue(jSONObject, "totalMemorySize", this.aaZ.longValue());
        aa.putValue(jSONObject, "availableMemorySize", this.aba.longValue());
        aa.putValue(jSONObject, "totalDiskSize", this.abb.longValue());
        aa.putValue(jSONObject, "availableDiskSize", this.abc.longValue());
        aa.putValue(jSONObject, "imsi", this.abd);
        aa.putValue(jSONObject, "iccid", this.abe);
        aa.putValue(jSONObject, "wifiList", this.abf);
        aa.putValue(jSONObject, "bootTime", this.abg);
        aa.putValue(jSONObject, "romName", this.Mk);
        aa.putValue(jSONObject, "romVersion", this.abh);
        aa.putValue(jSONObject, "romBuildTimestamp", this.abi);
        aa.putValue(jSONObject, "ringerMode", this.abj);
        aa.putValue(jSONObject, "audioStreamInfo", this.abn);
        aa.putValue(jSONObject, "baseBandVersion", this.abk);
        aa.putValue(jSONObject, "fingerPrint", this.abl);
        aa.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        aa.putValue(jSONObject, "isCharging", this.abm);
        aa.putValue(jSONObject, "chargeType", this.QL);
        f fVar = this.abo;
        if (fVar != null) {
            aa.a(jSONObject, "simCardInfo", fVar);
        }
        d dVar = this.abp;
        if (dVar != null) {
            aa.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.l.a.b bVar = this.abq;
        if (bVar != null) {
            aa.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.abr;
        if (list != null) {
            aa.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }
}

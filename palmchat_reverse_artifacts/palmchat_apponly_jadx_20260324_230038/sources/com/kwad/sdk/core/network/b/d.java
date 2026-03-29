package com.kwad.sdk.core.network.b;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import com.oplus.tblplayer.Constants;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d implements b {
    private static boolean aKs = true;
    public static double aKt = 1.0d;
    private static volatile boolean aKx = false;
    private static String aKy = "";
    private long aKu = -1;
    private long aKv = -1;
    private long aKw = -1;
    private j aKz = new j();

    public d() {
        aKt = new Random().nextDouble();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: JP, reason: merged with bridge method [inline-methods] */
    public d JH() {
        this.aKz.aJD = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: JQ, reason: merged with bridge method [inline-methods] */
    public d JI() {
        this.aKv = SystemClock.elapsedRealtime();
        eA("this.responseReceiveTime:" + this.aKv);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: JR, reason: merged with bridge method [inline-methods] */
    public d JJ() {
        if (aA(this.aKu) && aA(this.aKv)) {
            this.aKz.aJK = this.aKv - this.aKu;
            eA("info.waiting_response_cost:" + this.aKz.aJK);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: JS, reason: merged with bridge method [inline-methods] */
    public d JK() {
        if (aA(this.aKz.aJD)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.aKu = jElapsedRealtime;
            j jVar = this.aKz;
            jVar.aJx = jElapsedRealtime - jVar.aJD;
            if (aA(jVar.aJv)) {
                j jVar2 = this.aKz;
                jVar2.aJw = jVar2.aJx - jVar2.aJv;
            }
            eA("info.request_create_cost:" + this.aKz.aJx);
            eA("info.requestAddParamsCost:" + this.aKz.aJw);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: JT, reason: merged with bridge method [inline-methods] */
    public d JM() {
        if (aA(this.aKv)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.aKw = jElapsedRealtime;
            this.aKz.aJI = jElapsedRealtime - this.aKv;
            eA("info.response_parse_cost:" + this.aKz.aJI);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: JU, reason: merged with bridge method [inline-methods] */
    public d JN() {
        if (aA(this.aKw)) {
            this.aKz.aJP = SystemClock.elapsedRealtime() - this.aKw;
            JV();
            eA("info.response_done_cost:" + this.aKz.aJP);
        }
        return this;
    }

    private void JV() {
        j jVar = this.aKz;
        if (jVar == null || jVar.aJO != 1 || aD(jVar.aJP)) {
            return;
        }
        this.aKz.aJP = -1L;
    }

    private d JW() {
        this.aKz.aJS = (int) com.kwad.sdk.ip.direct.a.On();
        this.aKz.aJT = (int) com.kwad.sdk.ip.direct.a.Oo();
        this.aKz.aJU = (int) com.kwad.sdk.ip.direct.a.Op();
        return this;
    }

    private void JX() {
        i iVarC = c(this.aKz);
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(iVarC);
        }
        com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", "reportError" + iVarC.toJson().toString());
    }

    private static boolean aA(long j) {
        return j != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: aB, reason: merged with bridge method [inline-methods] */
    public d az(long j) {
        this.aKz.aJJ = j;
        eA("responseSize:" + j);
        return this;
    }

    private d aC(long j) {
        this.aKz.aJL = j;
        eA("totalCost:" + j);
        return this;
    }

    private static boolean aD(long j) {
        return j >= 50;
    }

    private static boolean c(@NonNull i iVar) {
        if (TextUtils.isEmpty(iVar.url)) {
            return true;
        }
        String lowerCase = iVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: dT, reason: merged with bridge method [inline-methods] */
    public d dP(int i) {
        this.aKz.httpCode = i;
        eA("http_code:" + i);
        return this;
    }

    private d dU(int i) {
        this.aKz.aJO = i;
        eA("hasData:" + i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: dV, reason: merged with bridge method [inline-methods] */
    public d dR(int i) {
        this.aKz.result = i;
        eA("result:" + i);
        return this;
    }

    private static void eA(String str) {
        if (aKs) {
            com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: eB, reason: merged with bridge method [inline-methods] */
    public d ev(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.aKz.url = str;
        if (str.contains(Constants.STRING_VALUE_UNSET)) {
            String[] strArrSplit = str.split("\\?");
            if (strArrSplit.length > 0) {
                str = strArrSplit[0];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            eA("url:" + str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: eC, reason: merged with bridge method [inline-methods] */
    public d ew(String str) {
        try {
            this.aKz.host = Uri.parse(str).getHost();
            eA("host:" + this.aKz.host);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("NetworkMonitorRecorder", Log.getStackTraceString(e));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: eD, reason: merged with bridge method [inline-methods] */
    public d ex(String str) {
        this.aKz.errorMsg = str;
        eA(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: eE, reason: merged with bridge method [inline-methods] */
    public d ey(String str) {
        this.aKz.aJt = str;
        eA("reqType:" + str);
        eG(com.kwad.sdk.ip.direct.a.Om());
        JW();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: eF, reason: merged with bridge method [inline-methods] */
    public d ez(String str) {
        this.aKz.aJN = str;
        eA("requestId:" + str);
        return this;
    }

    private d eG(String str) {
        this.aKz.aJQ = str;
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b JL() {
        if (aA(this.aKz.aJD)) {
            this.aKz.aJv = SystemClock.elapsedRealtime() - this.aKz.aJD;
            eA("info.request_prepare_cost:" + this.aKz.aJv);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final /* synthetic */ b dQ(int i) {
        return dU(1);
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b dS(int i) {
        j jVar = this.aKz;
        jVar.aJR = i;
        if (i != 0) {
            jVar.aJu = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final void report() {
        if (c((i) this.aKz)) {
            return;
        }
        if (this.aKz.httpCode != 200) {
            JX();
            return;
        }
        long jElapsedRealtime = aA(this.aKz.aJD) ? SystemClock.elapsedRealtime() - this.aKz.aJD : -1L;
        aC(jElapsedRealtime);
        if (jElapsedRealtime > 30000 || jElapsedRealtime <= -1) {
            return;
        }
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(this.aKz);
        }
        eA("report normal" + this.aKz.toString());
    }

    private static i c(j jVar) {
        i iVar = new i();
        iVar.errorMsg = jVar.errorMsg;
        iVar.host = jVar.host;
        iVar.httpCode = jVar.httpCode;
        iVar.aJt = jVar.aJt;
        iVar.url = jVar.url;
        iVar.aJu = jVar.aJu;
        return iVar;
    }
}

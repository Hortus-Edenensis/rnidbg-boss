package com.opos.mobad.activity.webview.a;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.opos.cmn.biz.web.c.b.c;
import com.opos.cmn.func.a.a.d;
import com.opos.mobad.ad.e;
import com.opos.mobad.service.c.a;
import com.opos.mobad.service.d.d;
import java.util.StringTokenizer;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends com.opos.cmn.biz.web.c.b.b {
    private com.opos.mobad.activity.webview.b.b e;

    public b(Context context, c cVar, com.opos.mobad.activity.webview.b.b bVar) {
        super(context, cVar);
        this.e = bVar;
    }

    @JavascriptInterface
    public void actionDownloader(String str, String str2, String str3, String str4, int i) {
        actionDownloader(str, str2, str3, str4, i, null);
    }

    @JavascriptInterface
    public void addCallableName(String str, String str2) {
        com.opos.mobad.activity.webview.b.b bVar = this.e;
        if (bVar == null) {
            return;
        }
        bVar.e(str, str2);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "addCallableFunc: key = " + str + ", funcName = " + str2);
    }

    @JavascriptInterface
    public void closeWebview() {
        if (this.b) {
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.activity.webview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.e != null) {
                            b.this.e.c();
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public int getApiVer() {
        int iA = com.opos.mobad.activity.webview.a.a.a.a();
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getApiVer=" + iA);
        return iA;
    }

    @JavascriptInterface
    public String getDownloaderStatus(String str, String str2) {
        String strB = "";
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    strB = bVar.b(str, str2);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getDownloaderStatus url=" + str + ",pkgName:" + str2 + ",downloadStatus:" + strB);
        return strB;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getDuId() {
        String strI = "";
        if (this.b) {
            try {
                strI = com.opos.mobad.service.c.a.a().i();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getDuId=");
        sb.append(strI != null ? strI : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return strI;
    }

    @JavascriptInterface
    public String getGps() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                double[] dArr = {0.0d, 0.0d};
                e.a location = com.opos.mobad.service.d.b.a().getLocation();
                if (location != null) {
                    dArr[0] = location.getLatitude();
                    dArr[1] = location.getLongitude();
                }
                jSONObject.put("lt", String.valueOf(dArr[0]));
                jSONObject.put("lg", String.valueOf(dArr[1]));
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getGps=" + string);
        return string;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getGuId() {
        String strJ = "";
        if (this.b) {
            try {
                strJ = com.opos.mobad.service.c.a.a().j();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getGuId=");
        sb.append(strJ != null ? strJ : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return strJ;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getImei() {
        String str = "";
        if (this.b) {
            try {
                a.C0768a c0768aM = com.opos.mobad.service.c.a.a().m();
                if (c0768aM != null) {
                    str = c0768aM.f9210a;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getImei=" + str);
        return str;
    }

    @JavascriptInterface
    public String getInstantSdkVer() {
        String strB = "";
        if (this.b) {
            try {
                strB = d.a().b();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getInstantSdkVer=");
        sb.append(strB != null ? strB : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return strB;
    }

    @JavascriptInterface
    public String getInstantVer() {
        String strD = "";
        if (this.b) {
            try {
                strD = d.a().d();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getInstantVer=");
        sb.append(strD != null ? strD : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return strD;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public boolean getOUIDStatus() {
        boolean zL;
        if (this.b) {
            try {
                zL = com.opos.mobad.service.c.a.a().l();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
                zL = false;
            }
        } else {
            zL = false;
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOUIDStatus=" + zL);
        return zL;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public int getOri() {
        int i;
        if (this.b) {
            try {
                i = com.opos.cmn.an.h.f.a.i(this.f7910a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                i = 0;
            }
        } else {
            i = 0;
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOri=" + i);
        return i;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getOuId() {
        String strH = "";
        if (this.b) {
            try {
                strH = com.opos.mobad.service.c.a.a().h();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getOuId=");
        sb.append(strH != null ? strH : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return strH;
    }

    @JavascriptInterface
    public String getPosId() {
        String strE = "";
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    strE = bVar.e();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getPosId=");
        sb.append(strE != null ? strE : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return strE;
    }

    @JavascriptInterface
    public String getSdkInfo() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                jSONObject.put("verName", bVar != null ? bVar.b() : "");
                com.opos.mobad.activity.webview.b.b bVar2 = this.e;
                jSONObject.put("verCode", bVar2 != null ? bVar2.a() : 0);
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getSdkInfo=" + string);
        return string;
    }

    @JavascriptInterface
    public void goBackOrFinish() {
        com.opos.mobad.activity.webview.b.b bVar = this.e;
        if (bVar == null) {
            return;
        }
        bVar.d();
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "goBackOrFinish");
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String hasPkgListInstalled(String str) {
        String string = "";
        if (this.b) {
            try {
                if (!com.opos.cmn.an.d.b.a(str) && 2 <= str.length()) {
                    com.opos.cmn.an.f.a.b("MixAdJsEngine", "pkgList=" + str);
                    String strSubstring = str.substring(1, str.length() - 1);
                    if (strSubstring.length() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        StringTokenizer stringTokenizer = new StringTokenizer(strSubstring, ",");
                        while (stringTokenizer.hasMoreTokens()) {
                            String strNextToken = stringTokenizer.nextToken();
                            if (!com.opos.cmn.an.d.b.a(strNextToken)) {
                                jSONObject.put(strNextToken, com.opos.cmn.an.h.d.a.d(this.f7910a, strNextToken));
                            }
                        }
                        string = jSONObject.toString();
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("hasPkgListInstalled = ");
        sb.append(string != null ? string : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return string;
    }

    @JavascriptInterface
    public boolean isSupportSensorType(String str) {
        com.opos.mobad.activity.webview.b.b bVar = this.e;
        if (bVar == null) {
            return false;
        }
        return bVar.a(str);
    }

    @JavascriptInterface
    public boolean launchAppHomePage(String str) {
        return launchAppHomePage(str, null);
    }

    @JavascriptInterface
    public boolean launchAppPage(String str) {
        return launchAppPage(str, null);
    }

    @JavascriptInterface
    public boolean launchBrowserViewPage(String str) {
        return launchBrowserViewPage(str, null);
    }

    @JavascriptInterface
    public void launchInstant(String str, String str2, String str3, String str4, String str5) {
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    bVar.a(str, str5);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchInstant instantUrl=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
    }

    @JavascriptInterface
    public void launchMarketDLPage(String str, String str2, String str3, String str4, boolean z) {
        launchMarketDLPage(str, str2, str3, str4, z, null);
    }

    @JavascriptInterface
    public void launchMarketDLPageForTrack(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        launchMarketDLPageForTrack(str, str2, str3, str4, str5, str6, z, null);
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApk(String str, String str2) {
        launchMarketDeeplinkDLApk(str, str2, null);
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApkForSafe(String str, String str2) {
        launchMarketDeeplinkDLApkForSafe(str, str2, null);
    }

    @JavascriptInterface
    public boolean openMiniProgram(String str, String str2) {
        return openMiniProgram(str, str2, null);
    }

    @JavascriptInterface
    public void removeCallableName(String str) {
        com.opos.mobad.activity.webview.b.b bVar = this.e;
        if (bVar == null) {
            return;
        }
        bVar.c(str);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "removeCallableFunc: key = " + str);
    }

    @JavascriptInterface
    public void request(final String str, final String str2) {
        if (this.b) {
            com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.activity.webview.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.opos.cmn.func.a.a.b.a().a(((com.opos.cmn.biz.web.c.b.a) b.this).f7910a, new d.a().b(str).a(str2.getBytes()).a("POST").a());
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("MixAdJsEngine", "request fail", e);
                    }
                }
            });
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "request url=" + str + ",data:" + str2);
    }

    public void a() {
        this.e = null;
    }

    @JavascriptInterface
    public void actionDownloader(String str, String str2, String str3, String str4, int i, String str5) {
        actionDownloader(str, str2, str3, str4, i, str5, null);
    }

    @JavascriptInterface
    public boolean launchAppHomePage(String str, String str2) {
        return launchAppHomePage(str, str2, null);
    }

    @JavascriptInterface
    public boolean launchAppPage(String str, String str2) {
        return launchAppPage(str, str2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean launchBrowserViewPage(String str, String str2) {
        com.opos.mobad.activity.webview.b.b bVar;
        boolean zC;
        if (this.b) {
            try {
                bVar = this.e;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
            zC = bVar != null ? bVar.c(str, str2) : false;
        }
        Object[] objArr = new Object[5];
        objArr[0] = "launchBrowserViewPage url=";
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        objArr[1] = str;
        objArr[2] = "result=";
        objArr[3] = Boolean.valueOf(zC);
        objArr[4] = str2;
        com.opos.cmn.an.f.a.b("MixAdJsEngine", objArr);
        return zC;
    }

    @JavascriptInterface
    public void launchMarketDLPage(String str, String str2, String str3, String str4, boolean z, String str5) {
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    bVar.a(str, z, str5);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchMarketDLPage pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",exchange=");
        sb.append(z);
        sb.append(",");
        sb.append(str5);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
    }

    @JavascriptInterface
    public void launchMarketDLPageForTrack(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    bVar.a(str, z, str5, str6, str7);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchMarketDLPage pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",exchange=");
        sb.append(z);
        sb.append(",trackContent=");
        sb.append(str5);
        sb.append(",trackReference=");
        sb.append(str6);
        sb.append(",");
        sb.append(str7);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApk(String str, String str2, String str3) {
        launchMarketDeeplinkDLApk(str, str2, str3, null);
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApkForSafe(String str, String str2, String str3) {
        launchMarketDeeplinkDLApkForSafe(str, str2, str3, null);
    }

    @JavascriptInterface
    public boolean openMiniProgram(String str, String str2, String str3) {
        boolean zA;
        if (this.b) {
            try {
                zA = this.e.a(str, str2, str3);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
                zA = false;
            }
        } else {
            zA = false;
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "openMiniProgram=" + str + "," + str2 + "," + zA + "," + str3);
        return zA;
    }

    @JavascriptInterface
    public void actionDownloader(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    bVar.a(str, str2, str3, str4, i, str5, str6);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "actionDownloader=", str, str2, Integer.valueOf(i), str5, str6);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean launchAppHomePage(String str, String str2, String str3) {
        com.opos.mobad.activity.webview.b.b bVar;
        boolean zB;
        if (this.b) {
            try {
                bVar = this.e;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
            zB = bVar != null ? bVar.b(str, str2, str3) : false;
        }
        Object[] objArr = new Object[6];
        objArr[0] = "launchAppHomePage pkgName=";
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        objArr[1] = str;
        objArr[2] = "result=";
        objArr[3] = Boolean.valueOf(zB);
        objArr[4] = str2;
        objArr[5] = str3;
        com.opos.cmn.an.f.a.b("MixAdJsEngine", objArr);
        return zB;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean launchAppPage(String str, String str2, String str3) {
        com.opos.mobad.activity.webview.b.b bVar;
        boolean zC;
        if (this.b) {
            try {
                bVar = this.e;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
            zC = bVar != null ? bVar.c(str, str2, str3) : false;
        }
        Object[] objArr = new Object[6];
        objArr[0] = "launchAppPage url=";
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        objArr[1] = str;
        objArr[2] = "result=";
        objArr[3] = Boolean.valueOf(zC);
        objArr[4] = str2;
        objArr[5] = str3;
        com.opos.cmn.an.f.a.b("MixAdJsEngine", objArr);
        return zC;
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApk(String str, String str2, String str3, String str4) {
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    bVar.a(str, str2, str3, str4);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "launchMarketDeeplinkDLApk url=", str, "pkgName:", str2, str3, str4);
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApkForSafe(String str, String str2, String str3, String str4) {
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    bVar.b(str, str2, str3, str4);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "launchMarketDeeplinkDLApkForSafe url=", str, "pkgName:", str2, str3, str4);
    }
}

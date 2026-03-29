package com.opos.cmn.biz.web.c.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.huawei.openalliance.ad.constant.be;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.lantern.auth.server.WkParams;
import com.opos.cmn.an.c.d;
import com.opos.cmn.biz.ststrategy.StStrategyManager;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b extends a {
    private final Handler e;
    private String f;

    public b(Context context, c cVar) {
        super(context, cVar != null ? cVar.c : "", cVar != null ? cVar.b : true);
        this.e = new Handler(Looper.getMainLooper());
        this.f7910a = context.getApplicationContext();
        this.f = cVar != null ? cVar.f7912a : "";
    }

    private String a() {
        try {
            return !com.opos.cmn.an.f.a.b(this.f7910a) ? StStrategyManager.getInstance(this.f7910a).getAnId(this.f7910a) : "";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            return "";
        }
    }

    @JavascriptInterface
    public String getAllInstalledPkgName() {
        String string = "";
        if (this.b) {
            try {
                List<String> listB = com.opos.cmn.an.h.d.a.b(this.f7910a);
                if (listB != null && listB.size() > 0) {
                    String[] strArr = new String[listB.size()];
                    listB.toArray(strArr);
                    string = Arrays.toString(strArr);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getAllInstalledPkgName=");
        sb.append(string != null ? string : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return string;
    }

    @JavascriptInterface
    public String getAndroidInfo() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                String packageName = this.f7910a.getPackageName();
                jSONObject.put("pkgName", packageName);
                jSONObject.put("verName", com.opos.cmn.an.h.d.a.c(this.f7910a, packageName));
                jSONObject.put("verCode", com.opos.cmn.an.h.d.a.b(this.f7910a, packageName));
                jSONObject.put(WkParams.IMEI, getImei());
                jSONObject.put("localId", getLocalId());
                jSONObject.put("anId", a());
                jSONObject.put("mac", "");
                jSONObject.put(WkParams.OSVER, d.b());
                jSONObject.put("romVer", d.a());
                jSONObject.put("anVer", com.opos.cmn.an.c.c.c());
                jSONObject.put(TKDownloadReason.KSAD_TK_NET, com.opos.cmn.biz.web.c.a.a.a.a(this.f7910a));
                jSONObject.put("opt", com.opos.cmn.an.h.e.a.c(this.f7910a));
                jSONObject.put("ori", com.opos.cmn.an.h.f.a.i(this.f7910a));
                jSONObject.put("hg", com.opos.cmn.an.h.f.a.c(this.f7910a));
                jSONObject.put("wd", com.opos.cmn.an.h.f.a.b(this.f7910a));
                jSONObject.put(be.ar, com.opos.cmn.an.h.f.a.f(this.f7910a));
                jSONObject.put(WkParams.MODEL, com.opos.cmn.an.c.c.a());
                jSONObject.put("brand", com.opos.cmn.biz.a.b.a(this.f7910a));
                jSONObject.put(WkParams.LANG, com.opos.cmn.an.c.b.a());
                jSONObject.put("country", com.opos.cmn.an.c.b.b());
                jSONObject.put("ouId", getOuId());
                jSONObject.put("duId", getDuId());
                jSONObject.put("guId", getGuId());
                jSONObject.put("ouIdStatus", getOUIDStatus());
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getAndroidInfo = " + string);
        return string;
    }

    @JavascriptInterface
    public String getBrand() {
        String strA = "";
        if (this.b) {
            try {
                strA = com.opos.cmn.biz.a.b.a(this.f7910a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getBrand=");
        sb.append(strA != null ? strA : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return strA;
    }

    @JavascriptInterface
    public String getBuildInfo() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WkParams.MODEL, com.opos.cmn.an.c.c.a());
                jSONObject.put("brand", com.opos.cmn.biz.a.b.a(this.f7910a));
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getBuildInfo=" + string);
        return string;
    }

    @JavascriptInterface
    public String getBusinessType() {
        return this.f;
    }

    @JavascriptInterface
    public int getCommonApiVer() {
        int iA = com.opos.cmn.biz.web.c.a.a.a.a();
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getCommonApiVer=" + iA);
        return iA;
    }

    @JavascriptInterface
    public String getDevId() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WkParams.IMEI, getImei());
                jSONObject.put("localId", getLocalId());
                jSONObject.put("anId", a());
                jSONObject.put("mac", "");
                jSONObject.put("ouId", getOuId());
                jSONObject.put("duId", getDuId());
                jSONObject.put("guId", getGuId());
                jSONObject.put("ouIdStatus", getOUIDStatus());
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getDevId=" + string);
        return string;
    }

    @JavascriptInterface
    public String getDevOS() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WkParams.OSVER, d.b());
                jSONObject.put("romVer", d.a());
                jSONObject.put("anVer", com.opos.cmn.an.c.c.c());
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getDevOS=" + string);
        return string;
    }

    @JavascriptInterface
    public String getDuId() {
        String strB = "";
        if (this.b) {
            try {
                strB = com.opos.cmn.g.a.b.b(this.f7910a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getDuId=");
        sb.append(strB != null ? strB : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return strB;
    }

    @JavascriptInterface
    public String getGuId() {
        String guid = "";
        if (this.b) {
            try {
                if (!com.opos.cmn.an.f.a.b(this.f7910a)) {
                    guid = StStrategyManager.getInstance(this.f7910a).getGUID();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getGuId=");
        sb.append(guid != null ? guid : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return guid;
    }

    @JavascriptInterface
    public String getImei() {
        String imei = "";
        if (this.b) {
            try {
                if (!com.opos.cmn.an.f.a.b(this.f7910a)) {
                    imei = StStrategyManager.getInstance(this.f7910a).getImei();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getImei=" + imei);
        return imei;
    }

    @JavascriptInterface
    public String getLocal() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WkParams.LANG, com.opos.cmn.an.c.b.a());
                jSONObject.put("country", com.opos.cmn.an.c.b.b());
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getLocal=" + string);
        return string;
    }

    @JavascriptInterface
    public String getLocalId() {
        String strB = "";
        if (this.b) {
            try {
                strB = com.opos.cmn.g.a.c.b(this.f7910a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getLocalId=" + strB);
        return strB;
    }

    @JavascriptInterface
    public String getNetType() {
        String strA = "";
        if (this.b) {
            try {
                strA = com.opos.cmn.biz.web.c.a.a.a.a(this.f7910a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getNetType=" + strA);
        return strA;
    }

    @JavascriptInterface
    public boolean getOUIDStatus() {
        boolean zG;
        if (this.b) {
            try {
                zG = com.opos.cmn.g.a.b.g(this.f7910a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                zG = false;
            }
        } else {
            zG = false;
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOUIDStatus=" + zG);
        return zG;
    }

    @JavascriptInterface
    public String getOperator() {
        String strC = "";
        if (this.b) {
            try {
                strC = com.opos.cmn.an.h.e.a.c(this.f7910a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOperator=" + strC);
        return strC;
    }

    @JavascriptInterface
    public int getOri() {
        int i;
        if (this.b) {
            try {
                i = com.opos.cmn.an.h.f.a.i(this.f7910a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                i = 0;
            }
        } else {
            i = 0;
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOri=" + i);
        return i;
    }

    @JavascriptInterface
    public String getOuId() {
        String strA = "";
        if (this.b) {
            try {
                strA = com.opos.cmn.g.a.b.a(this.f7910a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getOUID=");
        sb.append(strA != null ? strA : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return strA;
    }

    @JavascriptInterface
    public String getPkgInfo(String str) {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                String packageName = com.opos.cmn.an.d.b.a(str) ? this.f7910a.getPackageName() : str;
                jSONObject.put("pkgName", packageName);
                jSONObject.put("verName", com.opos.cmn.an.h.d.a.c(this.f7910a, packageName));
                jSONObject.put("verCode", com.opos.cmn.an.h.d.a.b(this.f7910a, packageName));
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getPkgInfo pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(string);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return string;
    }

    @JavascriptInterface
    public String getRegion() {
        String strA = "";
        if (this.b) {
            try {
                strA = com.opos.cmn.biz.a.d.a(this.f7910a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getRegion=");
        sb.append(strA != null ? strA : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return strA;
    }

    @JavascriptInterface
    public String getScreen() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("hg", com.opos.cmn.an.h.f.a.c(this.f7910a));
                jSONObject.put("wd", com.opos.cmn.an.h.f.a.b(this.f7910a));
                jSONObject.put(be.ar, com.opos.cmn.an.h.f.a.f(this.f7910a));
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getScreen=" + string);
        return string;
    }

    @JavascriptInterface
    public boolean getTouristModeSwitch() {
        boolean zB;
        if (this.b) {
            try {
                zB = com.opos.cmn.an.f.a.b(this.f7910a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                zB = false;
            }
        } else {
            zB = false;
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getTouristModeSwitch=" + zB);
        return zB;
    }

    @JavascriptInterface
    public boolean hasPkgInstalled(String str) {
        boolean zD;
        if (this.b) {
            try {
                zD = com.opos.cmn.an.h.d.a.d(this.f7910a, str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                zD = false;
            }
        } else {
            zD = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("hasPkgInstalled pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(zD);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return zD;
    }

    @JavascriptInterface
    public String hasPkgListInstalled(String str) {
        String string = "";
        if (this.b) {
            try {
                if (!com.opos.cmn.an.d.b.a(str) && 2 <= str.length()) {
                    com.opos.cmn.an.f.a.b("JSCommonEngine", "pkgList=" + str);
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
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("hasPkgListInstalled = ");
        sb.append(string != null ? string : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return string;
    }

    @JavascriptInterface
    public boolean installApk(String str) {
        boolean zA;
        if (this.b) {
            try {
                zA = com.opos.cmn.biz.web.c.a.a.a.a(this.f7910a, str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                zA = false;
            }
        } else {
            zA = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("installApk url=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(zA);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return zA;
    }

    @JavascriptInterface
    public void showToast(final String str, final boolean z) {
        if (this.b) {
            this.e.post(new Runnable() { // from class: com.opos.cmn.biz.web.c.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Toast.makeText(b.this.f7910a, str, z ? 0 : 1).show();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                    }
                }
            });
        }
    }
}

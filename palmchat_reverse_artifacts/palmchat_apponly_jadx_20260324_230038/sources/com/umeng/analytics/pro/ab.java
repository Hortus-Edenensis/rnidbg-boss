package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ab implements aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10843a;
    private ArrayList<ac> b;
    private String c;
    private String d;
    private String e;
    private String f;

    public ab(String str, ArrayList<ac> arrayList) {
        this.f10843a = null;
        new ArrayList();
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.f10843a = str;
        this.b = arrayList;
    }

    public String a() {
        return this.f10843a;
    }

    @Override // com.umeng.analytics.pro.aj
    public void b(String str, JSONObject jSONObject) {
    }

    public String c() {
        return this.d;
    }

    private String c(String str) {
        String[] strArrSplit = str.split(",");
        String str2 = "";
        if (strArrSplit.length <= 0) {
            return "";
        }
        ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(this.f10843a);
        if (forbidSdkArray != null && forbidSdkArray.size() > 0) {
            this.f = forbidSdkArray.toString();
            for (String str3 : strArrSplit) {
                if (CcgAgent.getActionInfo(str3) != null && !forbidSdkArray.contains(str3)) {
                    return str3;
                }
            }
            return "";
        }
        for (String str4 : strArrSplit) {
            ActionInfo actionInfo = CcgAgent.getActionInfo(str4);
            if (actionInfo != null) {
                String[] supportAction = actionInfo.getSupportAction(UMGlobalContext.getAppContext());
                if (supportAction.length > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= supportAction.length) {
                            break;
                        }
                        if (this.f10843a.equals(supportAction[i])) {
                            str2 = str4;
                            break;
                        }
                        i++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                } else {
                    continue;
                }
            }
        }
        return str2;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.c;
    }

    @Override // com.umeng.analytics.pro.aj
    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            int size = this.b.size();
            if (size == 0) {
                return null;
            }
            for (int i = 0; i < size; i++) {
                if (this.b.get(i).b()) {
                    return null;
                }
            }
            if (CcgAgent.hasRegistedActionInfo() && !TextUtils.isEmpty(this.d)) {
                String strC = c(this.d);
                this.e = strC;
                if (TextUtils.isEmpty(strC)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.f10843a + "; 未选中可用Module ; sdk: " + this.d);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.f10843a + "; 选中Module: " + this.e + "; sdk: " + this.d);
                }
            }
            ac acVar = this.b.get(size - 1);
            if (acVar == null || !(acVar instanceof af)) {
                return null;
            }
            long jC = acVar.c();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("actionName", this.f10843a);
                jSONObject2.put(com.umeng.ccg.a.x, this.d);
                jSONObject2.put(com.umeng.ccg.a.u, this.c);
                jSONObject2.put("delay", jC);
                jSONObject2.put(com.umeng.ccg.a.v, this.e);
                jSONObject2.put(com.umeng.ccg.a.w, this.f);
            } catch (Throwable unused) {
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void b(String str) {
        this.d = str;
    }
}

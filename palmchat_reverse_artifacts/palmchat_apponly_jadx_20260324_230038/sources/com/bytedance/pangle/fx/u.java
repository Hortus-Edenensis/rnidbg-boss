package com.bytedance.pangle.fx;

import android.text.TextUtils;
import com.bytedance.pangle.jk;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.iz;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    private List<File> b;
    private JSONObject fx;
    private JSONObject iz;
    private String nr;
    private File pn;
    private String u;
    private String x;

    private boolean a() {
        JSONObject jSONObject;
        List<File> list = this.b;
        boolean z = false;
        if (list == null || list.size() == 0 || (jSONObject = this.fx) == null || jSONObject.length() == 0) {
            StringBuilder sb = new StringBuilder("DexPluginConfig check md5 fail, packageName=");
            sb.append(this.nr);
            sb.append(" dexlist is ");
            sb.append(this.b);
            sb.append(" dexlist size is ");
            List<File> list2 = this.b;
            sb.append(list2 == null ? -1 : list2.size());
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        int size = this.b.size();
        int length = this.fx.length();
        for (File file : this.b) {
            String strU = iz.u(file);
            if (strU != null) {
                strU = strU.toLowerCase();
            }
            String strU2 = u(file.getName());
            if (TextUtils.equals(strU2, strU)) {
                size--;
                length--;
            } else {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 fail, packageName=" + this.nr + "downloadFileMd5=" + strU + " configMd5=" + strU2);
            }
        }
        if (size == 0 && length == 0) {
            z = true;
        }
        StringBuilder sb2 = new StringBuilder("DexPluginConfig check md5 ");
        sb2.append(z ? "success" : "fail");
        sb2.append(", packageName=");
        sb2.append(this.nr);
        sb2.append(" fileSize=");
        sb2.append(size);
        sb2.append(" configFileSize=");
        sb2.append(length);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb2.toString());
        return z;
    }

    private boolean n() {
        JSONObject jSONObject;
        Map<String, JSONObject> mapPn = jk.u().pn();
        if (mapPn != null && mapPn.size() > 0 && (jSONObject = mapPn.get(this.nr)) != null && jSONObject.has("packageName") && TextUtils.equals(jSONObject.optString("packageName"), this.nr)) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName success , packageName=" + this.nr);
            return true;
        }
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName fail, packageName=" + this.nr + ", packageManager=" + mapPn);
        return false;
    }

    public static u u(JSONObject jSONObject, File file, List<File> list) {
        u uVar = new u();
        uVar.u = jSONObject.optString("version");
        uVar.nr = jSONObject.optString("package_name");
        uVar.fx = jSONObject.optJSONObject("adn_adapter_md5");
        uVar.x = jSONObject.optString("alias_package_name");
        uVar.b = list;
        uVar.pn = file;
        uVar.iz = jSONObject;
        return uVar;
    }

    public List<File> b() {
        return this.b;
    }

    public int fx() {
        if (TextUtils.isEmpty(this.u)) {
            return -1;
        }
        String strReplace = this.u.replace(".", "");
        if (TextUtils.isEmpty(strReplace)) {
            return -1;
        }
        try {
            return Integer.valueOf(strReplace).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public JSONObject iz() {
        return this.iz;
    }

    public String nr() {
        return this.nr;
    }

    public File pn() {
        return this.pn;
    }

    public String toString() {
        return "DexPluginConfig{mVersion='" + this.u + "', mPackageName='" + this.nr + "'}";
    }

    public String x() {
        return this.x;
    }

    public boolean u() {
        return n() && a();
    }

    public String u(String str) {
        JSONObject jSONObject;
        return (TextUtils.isEmpty(str) || (jSONObject = this.fx) == null || !jSONObject.has(str)) ? "" : this.fx.optString(str);
    }
}

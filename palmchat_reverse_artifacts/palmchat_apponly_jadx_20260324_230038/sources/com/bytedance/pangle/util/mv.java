package com.bytedance.pangle.util;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mv {
    private static volatile mv u;
    private SharedPreferences nr = Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    private mv() {
    }

    public static mv u() {
        if (u == null) {
            synchronized (mv.class) {
                if (u == null) {
                    u = new mv();
                }
            }
        }
        return u;
    }

    public boolean a(String str) {
        return this.nr.getBoolean("UNINSTALL__".concat(String.valueOf(str)), false);
    }

    public void b(String str) {
        String string = this.nr.getString("HOST_ABI_".concat(String.valueOf(str)), "");
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.putString("HOST_ABI_".concat(String.valueOf(str)), Zeus.getHostAbi());
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
    }

    public boolean fx(String str) {
        boolean z = !TextUtils.equals(this.nr.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + this.nr.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z);
        return z;
    }

    public String iz(String str) {
        String string = this.nr.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public String jk(String str) {
        return this.nr.getString("IDENTITY_".concat(String.valueOf(str)), "");
    }

    public void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strU = iz.u(str);
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.remove("ALIAS_".concat(String.valueOf(strU)));
        editorEdit.apply();
    }

    public List<String> mv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = this.nr.getString("ALIAS_LAST_TIME_".concat(String.valueOf(iz.u(str))), "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Arrays.asList(string.split("_"));
    }

    public void n(String str) {
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.remove("UNINSTALL__".concat(String.valueOf(str)));
        editorEdit.apply();
    }

    public boolean nr(String str) {
        return !TextUtils.isEmpty(this.nr.getString("HOST_ABI_".concat(String.valueOf(str)), ""));
    }

    public int pn(String str) {
        int i = this.nr.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i);
        return i;
    }

    public void s(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strU = iz.u(str);
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.remove("ALIAS_LAST_TIME_".concat(String.valueOf(strU)));
        editorEdit.apply();
    }

    public String t(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.nr.getString("ALIAS_".concat(String.valueOf(iz.u(str))), "");
    }

    public void x(String str) {
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.putBoolean("UNINSTALL__".concat(String.valueOf(str)), true);
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=".concat(String.valueOf(str)));
    }

    public int a(String str, int i) {
        return this.nr.getInt("remove_entry_flag_" + str + "_" + i, 0);
    }

    public int nr(String str, int i) {
        return this.nr.getInt("API_MIN_" + str + "_" + i, 0);
    }

    public int fx(String str, int i) {
        int i2 = this.nr.getInt("API_MAX_" + str + "_" + i, Integer.MAX_VALUE);
        if (i2 == 0) {
            return Integer.MAX_VALUE;
        }
        return i2;
    }

    public boolean iz(String str, int i) {
        return this.nr.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", str), -1) == i;
    }

    public void nr(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.putString("IDENTITY_".concat(String.valueOf(str)), str2);
        editorEdit.apply();
    }

    public void pn(String str, int i) {
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.putInt("OFFLINE_INTERNAL_".concat(String.valueOf(str)), i);
        editorEdit.apply();
    }

    public void fx(String str, int i, boolean z) {
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.putBoolean("dex_opt_state_" + str + "_" + i, z);
        editorEdit.apply();
    }

    public boolean n(String str, int i) {
        return this.nr.getBoolean("dex_remove_state_" + str + "_" + i, false);
    }

    public boolean x(String str, int i) {
        return this.nr.getBoolean("dex_opt_state_" + str + "_" + i, false);
    }

    public boolean b(String str, int i) {
        return this.nr.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i)), false);
    }

    public void nr(String str, int i, boolean z) {
        SharedPreferences.Editor editorEdit = this.nr.edit();
        String str2 = "INSTALLED_" + str + "-" + i;
        if (z) {
            editorEdit.putBoolean(str2, true);
        } else {
            editorEdit.remove(str2);
        }
        editorEdit.apply();
    }

    public void b(String str, int i, boolean z) {
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.putBoolean("dex_remove_state_" + str + "_" + i, z);
        editorEdit.apply();
    }

    public void u(String str) {
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.putString("ROM_LAST_".concat(String.valueOf(str)), Build.VERSION.INCREMENTAL);
        editorEdit.apply();
    }

    public void fx(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strU = iz.u(str);
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.putString("ALIAS_".concat(String.valueOf(strU)), str2);
        editorEdit.apply();
    }

    public void u(String str, int i) {
        int iPn = pn(str);
        if (iPn != i) {
            SharedPreferences.Editor editorEdit = this.nr.edit();
            editorEdit.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), i);
            editorEdit.apply();
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + iPn + " --> " + i);
    }

    public void b(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.nr.edit();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strU = iz.u(str);
        String string = this.nr.getString("ALIAS_LAST_TIME_".concat(String.valueOf(strU)), "");
        if (TextUtils.isEmpty(string)) {
            editorEdit.putString("ALIAS_LAST_TIME_".concat(String.valueOf(strU)), str2);
        } else {
            editorEdit.putString("ALIAS_LAST_TIME_".concat(String.valueOf(strU)), string + "_" + str2);
        }
        editorEdit.apply();
    }

    public int nr(String str, int i, String str2) {
        return this.nr.getInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, 0);
    }

    public void u(String str, String str2) {
        String strIz = iz(str);
        if (!TextUtils.equals(strIz, str2)) {
            SharedPreferences.Editor editorEdit = this.nr.edit();
            editorEdit.putString("HOST_IDENTITY_".concat(String.valueOf(str)), str2);
            editorEdit.apply();
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str + ") " + strIz + " --> " + str2);
    }

    public void u(String str, int i, int i2, int i3) {
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.putInt("API_MIN_" + str + "_" + i, i2);
        editorEdit.putInt("API_MAX_" + str + "_" + i, i3);
        editorEdit.apply();
    }

    public void u(String str, int i, boolean z) {
        SharedPreferences.Editor editorEdit = this.nr.edit();
        String str2 = "DISABLE_DOWNLOAD_" + str + "_" + i;
        if (z) {
            editorEdit.putInt(str2, 0);
        } else {
            editorEdit.remove(str2);
        }
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + str + " version=" + i + " disable=" + z);
    }

    public void u(String str, int i, int i2) {
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.putInt("remove_entry_flag_" + str + "_" + i, i2);
        editorEdit.apply();
    }

    public void u(String str, int i, String str2) {
        int iNr = nr(str, i, str2);
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.putInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, iNr + 1);
        editorEdit.apply();
    }
}

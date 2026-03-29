package com.umeng.logsdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ULogConfigManager {
    private Context b;
    private EfsReporter c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11112a = "ULogConfigManager";
    private Vector<b> d = new Vector<>();

    public ULogConfigManager(Context context, EfsReporter efsReporter) {
        this.b = context.getApplicationContext();
        this.c = efsReporter;
        if (efsReporter != null) {
            Log.i("ULogConfigManager", "[log register] begin.");
            this.c.getAllSdkConfig(new String[]{a.d, a.c, a.g}, new IConfigCallback() { // from class: com.umeng.logsdk.ULogConfigManager.1
                @Override // com.efs.sdk.base.observer.IConfigCallback
                public final void onChange(Map<String, Object> map) {
                    SharedPreferences.Editor editorEdit;
                    String string;
                    String strA;
                    StringBuilder sb;
                    if (map != null) {
                        try {
                            Log.i("ULogConfigManager", "[log register] call back config.");
                            SharedPreferences sharedPreferences = ULogConfigManager.this.b.getSharedPreferences("efs_ulog", 0);
                            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
                                return;
                            }
                            Object obj = map.get(a.d);
                            String string2 = "";
                            if (obj != null) {
                                string = obj.toString();
                                editorEdit.putString(a.d, string);
                                Log.i("ULogConfigManager", "[log register] save did is ".concat(String.valueOf(string)));
                            } else {
                                string = "";
                            }
                            Object obj2 = map.get(a.c);
                            if (obj2 != null) {
                                String string3 = obj2.toString();
                                Log.i("ULogConfigManager", "[log register] save uid before base64 is ".concat(String.valueOf(string3)));
                                strA = c.a(string3.getBytes());
                                editorEdit.putString(a.c, strA);
                                Log.i("ULogConfigManager", "[log register] save uid after base64 is ".concat(String.valueOf(strA)));
                            } else {
                                strA = "";
                            }
                            Object obj3 = map.get(a.g);
                            if (obj3 != null && strA.equals(ULogManager.getUserID()) && string.equals(ULogManager.getDeviceID())) {
                                String string4 = obj3.toString();
                                if (!TextUtils.isEmpty(string4)) {
                                    JSONArray jSONArray = new JSONArray(string4);
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                                        if (jSONObject != null) {
                                            String strOptString = jSONObject.optString(a.h, a.p);
                                            if (!TextUtils.isEmpty(strOptString)) {
                                                if (TextUtils.isEmpty(string2)) {
                                                    sb = new StringBuilder();
                                                    sb.append(string2);
                                                    sb.append(strOptString);
                                                } else {
                                                    sb = new StringBuilder();
                                                    sb.append(string2);
                                                    sb.append("_");
                                                    sb.append(strOptString);
                                                }
                                                string2 = sb.toString();
                                                editorEdit.putString(strOptString, jSONObject.toString());
                                                Log.i("ULogConfigManager", "[log register] save task id is " + strOptString + ", task is " + jSONObject.toString());
                                                b bVar = new b();
                                                int iOptInt = jSONObject.optInt(a.i, -1);
                                                int iOptInt2 = jSONObject.optInt(a.j, -1);
                                                if (iOptInt == 0) {
                                                    String str = iOptInt2 == 0 ? strA : iOptInt2 == 1 ? string : null;
                                                    if (!TextUtils.isEmpty(str)) {
                                                        bVar.f11117a = strOptString;
                                                        bVar.b = iOptInt;
                                                        bVar.c = iOptInt2;
                                                        bVar.d = str;
                                                        bVar.e = jSONObject.optLong(a.l, 0L);
                                                        bVar.f = jSONObject.optLong(a.m, 0L);
                                                        Log.i("ULogConfigManager", "[log register] add mem task id is ".concat(String.valueOf(strOptString)));
                                                        ULogConfigManager.this.d.add(bVar);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(string2)) {
                                editorEdit.putString(a.e, string2);
                                Log.i("ULogConfigManager", "[log register] save task id set is ".concat(String.valueOf(string2)));
                            }
                            editorEdit.commit();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public List<b> getTaskList() {
        return this.d;
    }

    public void reMoveTaskFroSP(String str) {
        String[] strArrSplit;
        try {
            Log.i("ULogConfigManager", "[log remove] remove sp. delete task id is ".concat(String.valueOf(str)));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            SharedPreferences sharedPreferences = this.b.getSharedPreferences("efs_ulog", 0);
            if (sharedPreferences == null || sharedPreferences.edit() == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            String string = sharedPreferences.getString(a.d, "");
            String string2 = sharedPreferences.getString(a.c, "");
            String string3 = sharedPreferences.getString(a.e, "");
            if (!string2.equals(ULogManager.getUserID()) || !string.equals(ULogManager.getDeviceID()) || TextUtils.isEmpty(string3) || (strArrSplit = string3.split("_")) == null) {
                return;
            }
            for (int i = 0; i < strArrSplit.length; i++) {
                String str2 = strArrSplit[i];
                if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                    Log.i("ULogConfigManager", "[log remove] taskId is ".concat(str2));
                    if (string3.equals(str2)) {
                        string3 = "";
                    } else {
                        string3 = string3.replaceFirst(i == strArrSplit.length - 1 ? "_".concat(str2) : str2 + "_", "");
                    }
                    Log.i("ULogConfigManager", "[log remove] put id set is ".concat(String.valueOf(string3)));
                    editorEdit.putString(a.e, string3);
                    editorEdit.remove(str2);
                    editorEdit.commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeTask(b bVar) {
        Vector<b> vector = this.d;
        if (vector == null || !vector.contains(bVar)) {
            return;
        }
        Log.i("ULogConfigManager", "[log remove] remove mem. task id is " + bVar.f11117a);
        this.d.remove(bVar);
    }
}

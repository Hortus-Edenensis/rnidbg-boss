package com.bytedance.sdk.component.x.fx;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.b.a;
import com.bytedance.sdk.component.b.x;
import com.cdo.oaps.ad.Launcher;
import com.kuaishou.weapon.p0.t;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements com.bytedance.sdk.component.x.nr, com.bytedance.sdk.component.x.u {
    private final boolean fx;
    private final com.bytedance.sdk.component.b.nr.u nr;
    private com.bytedance.sdk.component.b.nr.u u;

    public nr(com.bytedance.sdk.component.b.nr.u uVar, boolean z) {
        this.u = uVar;
        this.nr = uVar;
        this.fx = z;
    }

    private Pair<String, String> getType(String str) {
        if (str.contains(".")) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length >= 2) {
                return new Pair<>(strArrSplit[0], strArrSplit[1]);
            }
        }
        return new Pair<>("s", str);
    }

    private void u(String str) {
        int i;
        a aVar;
        com.bytedance.sdk.component.b.nr.u encrypt;
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            try {
                i = Integer.parseInt(str);
            } catch (Throwable unused) {
                i = 0;
            }
        }
        if (i == 0) {
            this.u = null;
            return;
        }
        com.bytedance.sdk.component.b.nr.u uVar = this.u;
        if ((uVar != null && uVar.type() == i) || (aVar = (a) com.bytedance.sdk.openadsdk.ats.fx.u("kv_store_factory")) == null || (encrypt = aVar.getEncrypt(i)) == null) {
            return;
        }
        this.u = encrypt;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012f A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #6 {all -> 0x013f, blocks: (B:12:0x0022, B:14:0x002b, B:15:0x0032, B:16:0x003f, B:18:0x0045, B:20:0x0051, B:22:0x0057, B:24:0x005b, B:25:0x0061, B:27:0x0065, B:28:0x0069, B:65:0x00dd, B:67:0x00e3, B:68:0x00f7, B:70:0x00fd, B:71:0x0107, B:72:0x010b, B:73:0x0117, B:74:0x0123, B:75:0x012f, B:41:0x0096, B:44:0x00a0, B:47:0x00aa, B:50:0x00b4, B:53:0x00be, B:56:0x00c8), top: B:115:0x0022 }] */
    @Override // com.bytedance.sdk.component.x.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, Object> u(File file) {
        FileReader fileReader;
        byte b;
        if (file == null || !file.exists()) {
            return null;
        }
        if (!file.canRead()) {
            return null;
        }
        Properties properties = new Properties();
        try {
            fileReader = new FileReader(file);
        } catch (Throwable th) {
            th = th;
            fileReader = null;
        }
        try {
            properties.load(fileReader);
            Object obj = properties.get(".i.tt_ect");
            if (obj != null) {
                u(String.valueOf(obj));
            }
            Enumeration<?> enumerationPropertyNames = properties.propertyNames();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(properties.size());
            while (enumerationPropertyNames.hasMoreElements()) {
                String strDecrypt = (String) enumerationPropertyNames.nextElement();
                String property = properties.getProperty(strDecrypt);
                if (strDecrypt != null && !strDecrypt.startsWith(".i.tt_ect")) {
                    if (this.fx) {
                        strDecrypt = this.u.decrypt(strDecrypt);
                    }
                    com.bytedance.sdk.component.b.nr.u uVar = this.u;
                    if (uVar != null) {
                        property = uVar.decrypt(property);
                    }
                    Pair<String, String> type = getType(strDecrypt);
                    String str = (String) type.second;
                    String str2 = (String) type.first;
                    int iHashCode = str2.hashCode();
                    if (iHashCode == 98) {
                        if (str2.equals(t.l)) {
                            b = 3;
                        }
                        if (b != 0) {
                        }
                    } else if (iHashCode == 102) {
                        if (str2.equals("f")) {
                            b = 2;
                        }
                        if (b != 0) {
                        }
                    } else if (iHashCode == 105) {
                        if (str2.equals("i")) {
                            b = 0;
                        }
                        if (b != 0) {
                        }
                    } else if (iHashCode == 108) {
                        if (str2.equals("l")) {
                            b = 1;
                        }
                        if (b != 0) {
                        }
                    } else if (iHashCode != 115) {
                        b = (iHashCode == 3680 && str2.equals("ss")) ? (byte) 4 : (byte) -1;
                        if (b != 0) {
                            concurrentHashMap.put(str, Integer.valueOf(Integer.parseInt(property)));
                        } else if (b == 1) {
                            concurrentHashMap.put(str, Long.valueOf(Long.parseLong(property)));
                        } else if (b == 2) {
                            concurrentHashMap.put(str, Float.valueOf(Float.parseFloat(property)));
                        } else if (b == 3) {
                            concurrentHashMap.put(str, Boolean.valueOf(Boolean.parseBoolean(property)));
                        } else if (b != 4) {
                            concurrentHashMap.put(str, property);
                        } else {
                            JSONArray jSONArray = new JSONArray(property);
                            HashSet hashSet = new HashSet((int) (((double) jSONArray.length()) / 0.75d));
                            for (int i = 0; i < jSONArray.length(); i++) {
                                hashSet.add(jSONArray.optString(i));
                            }
                            concurrentHashMap.put(str, hashSet);
                        }
                    } else {
                        if (str2.equals("s")) {
                            b = 6;
                        }
                        if (b != 0) {
                        }
                    }
                }
            }
            try {
                fileReader.close();
            } catch (Throwable unused) {
            }
            return concurrentHashMap;
        } catch (Throwable th2) {
            th = th2;
            try {
                boolean zDelete = file.delete();
                x xVar = (x) com.bytedance.sdk.openadsdk.ats.fx.u("event");
                if (xVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("file", file.getAbsolutePath());
                        jSONObject.put(Launcher.Method.DELETE_CALLBACK, zDelete);
                        jSONObject.put("msg", "read failed");
                        jSONObject.put("class", "PropReaderWriter");
                    } catch (JSONException unused2) {
                    }
                    xVar.onExceptionEvent("kv", jSONObject, th);
                }
                file.getAbsolutePath();
                if (fileReader == null) {
                    return null;
                }
                try {
                    fileReader.close();
                    return null;
                } catch (Throwable unused3) {
                    return null;
                }
            } catch (Throwable th3) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th3;
            }
        }
    }

    @Override // com.bytedance.sdk.component.x.nr
    public void u(Map<String, Object> map, File file) throws IOException {
        FileWriter fileWriter;
        Throwable th;
        String strConcat;
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Properties properties = new Properties();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    strConcat = "ss.".concat(key);
                    value = jSONArray.toString();
                } else if (entry.getValue() instanceof Boolean) {
                    strConcat = "b.".concat(key);
                } else if (entry.getValue() instanceof Integer) {
                    strConcat = "i.".concat(key);
                } else if (entry.getValue() instanceof Long) {
                    strConcat = "l.".concat(key);
                } else if ((entry.getValue() instanceof Float) || (entry.getValue() instanceof Double)) {
                    strConcat = "f.".concat(key);
                } else {
                    strConcat = "s.".concat(key);
                }
                String strValueOf = String.valueOf(value);
                if (this.fx) {
                    strConcat = this.nr.encrypt(strConcat);
                }
                com.bytedance.sdk.component.b.nr.u uVar = this.nr;
                if (uVar != null) {
                    strValueOf = uVar.encrypt(strValueOf);
                }
                properties.put(strConcat, strValueOf);
            }
        }
        try {
            fileWriter = new FileWriter(file);
            try {
                com.bytedance.sdk.component.b.nr.u uVar2 = this.nr;
                properties.put(".i.tt_ect", uVar2 != null ? String.valueOf(uVar2.type()) : "0");
                properties.store(fileWriter, (String) null);
                fileWriter.flush();
                try {
                    fileWriter.close();
                } catch (Exception unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileWriter = null;
            th = th3;
        }
    }
}

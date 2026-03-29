package com.bytedance.sdk.openadsdk.core.pb.u;

import android.text.TextUtils;
import com.baidu.location.LocationConst;
import com.bytedance.sdk.component.b.nr.fx;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private byte[] b(String str) {
        byte[] bytes = com.bytedance.sdk.component.utils.u.nr(str).getBytes(StandardCharsets.UTF_8);
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 1);
        byteBufferAllocate.put((byte) 3);
        byteBufferAllocate.put(bytes);
        return byteBufferAllocate.array();
    }

    private JSONObject fx(String str) {
        byte[] bArrB = n.b(new File(com.bytedance.sdk.openadsdk.api.plugin.nr.u(dw.getContext()), new File(str).getName()));
        if (bArrB == null) {
            return null;
        }
        try {
            String strU = u(bArrB);
            if (strU != null) {
                return new JSONObject(strU);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private void nr(JSONObject jSONObject, String str) {
        FileOutputStream fileOutputStream;
        byte[] bArrB = b(jSONObject.toString());
        if (bArrB == null || bArrB.length <= 0) {
            return;
        }
        try {
            fileOutputStream = new FileOutputStream(new File(com.bytedance.sdk.openadsdk.api.plugin.nr.u(dw.getContext()), new File(str).getName()));
            try {
                fileOutputStream.write(bArrB);
                com.bytedance.sdk.component.iz.fx.fx.nr.u(fileOutputStream);
            } catch (Throwable unused) {
                com.bytedance.sdk.component.iz.fx.fx.nr.u(fileOutputStream);
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
    }

    private boolean pn(String str) {
        File[] fileArrListFiles;
        long jLastModified;
        File file = new File(str);
        boolean z = true;
        if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                if (name.startsWith("._tt_")) {
                    try {
                        jLastModified = Long.parseLong(name.substring(5));
                    } catch (Throwable unused) {
                        jLastModified = file2.lastModified();
                    }
                    if (jp.u(jLastModified, System.currentTimeMillis())) {
                        z = false;
                    } else {
                        file2.delete();
                    }
                }
            }
        }
        if (z) {
            new File(file, "._tt_" + System.currentTimeMillis()).mkdirs();
        }
        return z;
    }

    private boolean u(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return j2 == 0 ? !jp.u(j, jCurrentTimeMillis) : jCurrentTimeMillis - j >= j2;
    }

    public void u(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectU;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("id_conf")) == null) {
            return;
        }
        try {
            fx fxVarU = com.bytedance.sdk.openadsdk.core.nr.u();
            long j = fxVarU.getLong("last_gather_id_time", 0L);
            long jOptLong = jSONObjectOptJSONObject.optLong("delt", 0L);
            if (j <= 0 || u(j, jOptLong)) {
                String strOptString = jSONObjectOptJSONObject.optString("store");
                int iOptInt = jSONObjectOptJSONObject.optInt(LocationConst.HDYawConst.KEY_HD_YAW_STATE, 0);
                if (iOptInt != 1) {
                    if (iOptInt != 2) {
                        if (iOptInt != 4) {
                            return;
                        }
                        File file = new File(strOptString);
                        File file2 = new File(com.bytedance.sdk.openadsdk.api.plugin.nr.u(dw.getContext()), file.getName());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        u(file);
                    }
                    jSONObjectU = null;
                } else {
                    jSONObjectU = u(strOptString);
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("upload", 0);
                if (iOptInt2 > 0) {
                    fxVarU.put("last_gather_id_time", System.currentTimeMillis());
                    File file3 = new File(strOptString);
                    jSONObjectU.put("c_r", file3.canRead());
                    jSONObjectU.put("c_w", file3.canWrite());
                    jSONObjectU.put("d", strOptString);
                    u(strOptString, jSONObjectU, iOptInt2 == 2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        JSONObject jSONObjectFx = fx(str);
        if (file.exists() && file.isDirectory() && file.canRead()) {
            HashMap map = new HashMap();
            u(file, str, map);
            if (map.size() == 0) {
                return jSONObjectFx;
            }
            if (jSONObjectFx == null) {
                jSONObjectFx = new JSONObject();
            }
            JSONObject jSONObjectOptJSONObject = jSONObjectFx.optJSONObject("aid");
            try {
                if (jSONObjectOptJSONObject == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObjectFx.put("aid", jSONObject);
                    } catch (JSONException unused) {
                    }
                    jSONObjectOptJSONObject = jSONObject;
                } else {
                    for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(entry.getKey());
                        if (jSONArrayOptJSONArray != null) {
                            Set<String> value = entry.getValue();
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                String strOptString = jSONArrayOptJSONArray.optString(i);
                                if (!TextUtils.isEmpty(strOptString)) {
                                    value.add(strOptString);
                                }
                            }
                        }
                    }
                }
            } catch (JSONException unused2) {
            }
            for (Map.Entry<String, Set<String>> entry2 : map.entrySet()) {
                String key = entry2.getKey();
                Set<String> value2 = entry2.getValue();
                if (!TextUtils.isEmpty(key) && value2 != null && value2.size() != 0) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        Iterator<String> it = value2.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next());
                        }
                        jSONObjectOptJSONObject.put(key, jSONArray);
                    } catch (JSONException unused3) {
                    }
                }
            }
        }
        return jSONObjectFx;
    }

    private void u(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        u(file2);
                    }
                }
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject u(String str) throws JSONException {
        String strU = jk.u();
        if (TextUtils.isEmpty(strU)) {
            return null;
        }
        String str2 = (!sx.pn() ? 1 : 0) + strU;
        JSONObject jSONObjectNr = nr(str);
        if (jSONObjectNr == null) {
            jSONObjectNr = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectNr.optJSONObject("aid");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectNr.putOpt("aid", jSONObjectOptJSONObject);
        }
        String packageName = dw.getContext().getPackageName();
        if (packageName == null) {
            packageName = com.bytedance.sdk.openadsdk.core.n.o().c();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(packageName);
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectOptJSONObject.put(packageName, jSONArrayOptJSONArray);
        }
        int i = 0;
        while (true) {
            if (i >= jSONArrayOptJSONArray.length()) {
                i = -1;
                break;
            }
            if (TextUtils.equals(jSONArrayOptJSONArray.optString(i), str2)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            jSONArrayOptJSONArray.put(str2);
        }
        nr(jSONObjectNr, str);
        u(jSONObjectOptJSONObject, str);
        return jSONObjectNr;
    }

    private void u(JSONObject jSONObject, String str) {
        File file = new File(str);
        if (file.exists()) {
            if (!file.canWrite()) {
                return;
            }
        } else if (!file.mkdirs()) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        byte[] bArrB = b(next + "/" + strOptString);
                        if (bArrB != null) {
                            File file2 = new File(str, u.u(bArrB, 20));
                            if (file2.isFile()) {
                                file2.delete();
                            }
                            file2.mkdirs();
                            file2.getAbsolutePath();
                        }
                    }
                }
            }
        }
    }

    private void u(File file, String str, Map<String, Set<String>> map) {
        if (file == null || !file.exists() || !file.canRead() || file.getName().startsWith("._tt_")) {
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                for (File file2 : fileArrListFiles) {
                    if (!file2.getName().startsWith("._tt_") && file2.isDirectory()) {
                        u(file2, str, map);
                        file2.delete();
                    }
                }
                return;
            }
            file.delete();
            String absolutePath = file.getAbsolutePath();
            if (absolutePath.length() <= str.length()) {
                return;
            }
            try {
                String strU = u(u.u(absolutePath.substring(str.length() + 1)));
                if (strU == null) {
                    return;
                }
                String[] strArrSplit = strU.split("/");
                if (strArrSplit.length != 2) {
                    return;
                }
                String str2 = strArrSplit[0];
                String str3 = strArrSplit[1];
                Set<String> hashSet = map.get(str2);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    map.put(str2, hashSet);
                }
                hashSet.add(str3);
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        try {
            file.delete();
        } catch (Throwable unused2) {
        }
    }

    private String u(byte[] bArr) throws JSONException {
        byte b = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        if (b == 3) {
            return com.bytedance.sdk.component.utils.u.fx(new String(bArr2));
        }
        return null;
    }

    private void u(String str, JSONObject jSONObject, boolean z) {
        if (z || pn(str)) {
            u(str, jSONObject);
        }
    }

    private void u(String str, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            jSONObject = nr(str);
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("aid");
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            HashSet hashSet = new HashSet();
            int i = 0;
            while (itKeys.hasNext()) {
                i++;
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(itKeys.next());
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(strOptString)) {
                            hashSet.add(strOptString);
                        }
                    }
                }
            }
            try {
                jSONObject.put("size", i);
                if (!hashSet.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    jSONObject.put("all", jSONArray);
                }
            } catch (JSONException unused) {
            }
        }
        s.u().u("s_d_i_c", jSONObject);
    }
}

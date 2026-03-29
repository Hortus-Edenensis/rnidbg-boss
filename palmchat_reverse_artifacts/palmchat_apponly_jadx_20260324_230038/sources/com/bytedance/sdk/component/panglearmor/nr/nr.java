package com.bytedance.sdk.component.panglearmor.nr;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static volatile nr u;
    private LinkedList<JSONObject> b;
    private LinkedList<JSONObject> fx;
    private long iz;
    private SharedPreferences nr;
    private LinkedList<JSONObject> pn;

    public nr() {
        this.nr = null;
        this.fx = null;
        this.b = null;
        this.pn = null;
        this.iz = 0L;
        this.nr = SoftDecTool.getSharedPreferences("pithar");
        this.fx = fx("sp_angle");
        this.b = fx("sp_screen");
        this.pn = fx("sp_net");
        this.iz = pn.u().fx() / pn.u().b();
    }

    private LinkedList<JSONObject> fx(String str) {
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        SharedPreferences sharedPreferences = this.nr;
        if (sharedPreferences == null) {
            return linkedList;
        }
        String string = sharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            for (String str2 : string.split("\\|")) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        linkedList.add(new JSONObject(str2));
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return linkedList;
    }

    public static nr u() {
        if (u == null) {
            synchronized (nr.class) {
                if (u == null) {
                    u = new nr();
                }
            }
        }
        return u;
    }

    public synchronized void nr(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ("android.intent.action.SCREEN_OFF".equals(str)) {
            LinkedList<JSONObject> linkedListU = u("sp_screen");
            int i = 1;
            if (linkedListU != null && !linkedListU.isEmpty()) {
                JSONObject jSONObject = linkedListU.get(linkedListU.size() - 1);
                if (jSONObject.optLong("t", 0L) / 3600000 == jCurrentTimeMillis / 3600000) {
                    int iOptInt = jSONObject.optInt("val", 0) + 1;
                    linkedListU.remove(linkedListU.size() - 1);
                    i = iOptInt;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("t", jCurrentTimeMillis);
                jSONObject2.put("val", i);
                u(jSONObject2, "sp_screen");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public LinkedList<JSONObject> u(String str) {
        if ("sp_angle".equals(str)) {
            return this.fx;
        }
        if ("sp_screen".equals(str)) {
            return this.b;
        }
        if ("sp_net".equals(str)) {
            return this.pn;
        }
        return null;
    }

    public void u(JSONObject jSONObject, String str) {
        LinkedList<JSONObject> linkedListU = u(str);
        if (linkedListU == null) {
            return;
        }
        linkedListU.add(jSONObject);
        if (linkedListU.size() > this.iz) {
            linkedListU.remove(0);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jFx = jCurrentTimeMillis - pn.u().fx();
        Iterator<JSONObject> it = linkedListU.iterator();
        JSONObject jSONObject2 = null;
        while (it.hasNext()) {
            JSONObject next = it.next();
            long jOptLong = next.optLong("t", 0L);
            if (jOptLong < jFx) {
                it.remove();
                jSONObject2 = next;
            } else if (jOptLong > jCurrentTimeMillis) {
                it.remove();
            }
        }
        if (jSONObject2 != null && linkedListU.size() < 2) {
            linkedListU.add(0, jSONObject2);
        }
        u(str, linkedListU);
    }

    public synchronized void u(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iOptInt = i == 4 ? 1 : i > 0 ? 2 : 0;
        LinkedList<JSONObject> linkedListU = u("sp_net");
        if (linkedListU != null && !linkedListU.isEmpty()) {
            JSONObject jSONObject = linkedListU.get(linkedListU.size() - 1);
            if (jSONObject.optLong("t", 0L) / 3600000 == jCurrentTimeMillis / 3600000) {
                iOptInt |= jSONObject.optInt("val", 0);
                linkedListU.remove(linkedListU.size() - 1);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("t", jCurrentTimeMillis);
            jSONObject2.put("val", iOptInt);
            u(jSONObject2, "sp_net");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void u(String str, LinkedList<JSONObject> linkedList) {
        if (linkedList == null || this.nr == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<JSONObject> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append("\\|");
        }
        SharedPreferences.Editor editorEdit = this.nr.edit();
        editorEdit.putString(str, sb.toString());
        editorEdit.apply();
    }

    public LinkedList<JSONObject> u(long j) {
        if (j == 0) {
            return this.fx;
        }
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = null;
        for (JSONObject jSONObject2 : this.fx) {
            if (jCurrentTimeMillis - jSONObject2.optLong("t", 0L) < j) {
                linkedList.add(jSONObject2);
            } else {
                jSONObject = jSONObject2;
            }
        }
        if (jSONObject != null && linkedList.size() < 2) {
            linkedList.add(0, jSONObject);
        }
        return linkedList;
    }
}

package com.bytedance.sdk.component.n.nr.u.u.nr;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.igexin.push.f.b.d;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends nr {
    private final Context b;
    protected List<String> fx;
    protected com.bytedance.sdk.component.n.u.pn nr;
    private com.bytedance.sdk.component.n.nr.b.nr.u pn;

    public iz(Context context, com.bytedance.sdk.component.n.nr.b.nr.u uVar, com.bytedance.sdk.component.n.u.pn pnVar) {
        super(context, pnVar, uVar == null ? com.bytedance.sdk.component.n.nr.b.nr.u.fx() : uVar);
        this.fx = new ArrayList();
        this.b = context;
        this.pn = uVar;
        this.nr = pnVar;
        if (uVar == null) {
            this.pn = com.bytedance.sdk.component.n.nr.b.nr.u.fx();
        }
    }

    public static String pn(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.nr
    public com.bytedance.sdk.component.n.u.pn b() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.fx
    public String delete(List<com.bytedance.sdk.component.n.u.nr> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.n.u.nr> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().fx());
        }
        com.bytedance.sdk.component.n.nr.fx.u.u(list, this.nr, u());
        String strU = com.bytedance.sdk.component.n.nr.u.u.nr.u(getContext(), "DELETE FROM " + u() + " WHERE " + u("id", (List<?>) linkedList, 1000, true), this.nr);
        u(linkedList);
        return strU;
    }

    public byte fx() {
        return (byte) 0;
    }

    public byte nr() {
        return (byte) 2;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u
    public boolean u(com.bytedance.sdk.component.n.u.nr nrVar) {
        return com.bytedance.sdk.component.n.nr.fx.u.fx(nrVar);
    }

    private void b(List<com.bytedance.sdk.component.n.u.nr> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.n.u.nr> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().fx());
        }
        com.bytedance.sdk.component.n.nr.u.u.nr.u(getContext(), "UPDATE " + u() + " SET retry = retry+1 WHERE " + u("id", (List<?>) linkedList, 1000, true), this.nr);
    }

    public String fx(List<String> list) {
        u();
        list.size();
        String strU = com.bytedance.sdk.component.n.nr.u.u.nr.u(getContext(), "DELETE FROM " + u() + " WHERE " + u("id", (List<?>) list, 1000, true), this.nr);
        com.bytedance.sdk.component.n.nr.fx.nr.u(com.bytedance.sdk.component.n.nr.nr.nr.u.k(), list.size(), this.nr);
        u(list);
        return strU;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.nr
    public String u() {
        com.bytedance.sdk.component.n.u.iz izVarNr = this.nr.nr();
        if (izVarNr != null) {
            return izVarNr.nr();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.fx
    public List<com.bytedance.sdk.component.n.u.nr> u(int i, String str, int i2, boolean z) {
        String str2;
        com.bytedance.sdk.component.n.u.b bVar;
        String string;
        String string2;
        int i3;
        long jU = com.bytedance.sdk.component.n.nr.nr.u.u(i, getContext(), this.nr);
        u();
        if (jU <= 0) {
            jU = 1;
        } else if (jU > 100) {
            jU = 100;
        }
        String str3 = str + " DESC limit " + jU;
        List<com.bytedance.sdk.component.n.u.nr> arrayList = new ArrayList<>();
        this.fx.clear();
        Context context = getContext();
        String strU = u();
        String[] strArr = {"id", ActionUtils.PAYMENT_AMOUNT, "encrypt", "retry"};
        com.bytedance.sdk.component.n.u.pn pnVar = this.nr;
        String str4 = BaseConstants.EVENT_LABEL_AD_EXTRA_DATA;
        Cursor cursorQuery = com.bytedance.sdk.component.n.nr.u.u.nr.query(context, strU, strArr, null, null, null, null, str3, pnVar);
        if (cursorQuery != null) {
            try {
                com.bytedance.sdk.component.n.u.b bVarB = this.nr.b();
                while (cursorQuery.moveToNext()) {
                    try {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        string2 = cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                        i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                        if (i4 == 1) {
                            string2 = bVarB.u(string2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        str2 = str4;
                    }
                    if (TextUtils.isEmpty(string2)) {
                        this.fx.add(string);
                    } else {
                        if (arrayList.size() > 100) {
                            break;
                        }
                        JSONObject jSONObject = new JSONObject(string2);
                        str2 = str4;
                        try {
                            String strOptString = jSONObject.optString(str2);
                            if (TextUtils.isEmpty(strOptString)) {
                                bVar = bVarB;
                            } else {
                                JSONObject jSONObject2 = new JSONObject(strOptString);
                                jSONObject2.put("retry_count", i3);
                                bVar = bVarB;
                                try {
                                    jSONObject2.put("db_rd", System.currentTimeMillis());
                                    jSONObject.put(str2, jSONObject2.toString());
                                } catch (Throwable th2) {
                                    th = th2;
                                    com.bytedance.sdk.component.n.nr.fx.fx.u(th.getMessage(), this.nr);
                                }
                            }
                            com.bytedance.sdk.component.n.nr.b.u.u uVar = new com.bytedance.sdk.component.n.nr.b.u.u(string, jSONObject);
                            uVar.u(fx());
                            uVar.nr(nr());
                            com.bytedance.sdk.component.n.nr.fx.u.u(jSONObject, uVar, this.nr, i3);
                            arrayList.add(uVar);
                        } catch (Throwable th3) {
                            th = th3;
                            bVar = bVarB;
                            com.bytedance.sdk.component.n.nr.fx.fx.u(th.getMessage(), this.nr);
                            bVarB = bVar;
                            str4 = str2;
                        }
                        bVarB = bVar;
                        str4 = str2;
                    }
                }
            } finally {
                try {
                    cursorQuery.close();
                    if (!this.fx.isEmpty()) {
                        fx(this.fx);
                        this.fx.clear();
                    }
                    if (com.bytedance.sdk.component.n.nr.fx.u.u(i2) && !z) {
                        u(arrayList, 5, d.b);
                    }
                } catch (Exception unused) {
                }
            }
        }
        u();
        arrayList.size();
        return arrayList;
    }

    public static String b(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.fx
    public List<com.bytedance.sdk.component.n.u.nr> u(String str, int i, boolean z) {
        com.bytedance.sdk.component.n.nr.b.nr.u uVar = this.pn;
        if (uVar == null) {
            return new ArrayList();
        }
        return u(uVar.nr(), str, i, z);
    }

    private void u(int i, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        Context context = getContext();
        String strU = u();
        StringBuilder sb = new StringBuilder();
        sb.append(jCurrentTimeMillis);
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        com.bytedance.sdk.component.n.nr.u.u.nr.delete(context, strU, "gen_time <? OR retry >?", new String[]{string, sb2.toString()}, this.nr);
    }

    public void u(List<com.bytedance.sdk.component.n.u.nr> list, int i, long j) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            b(list);
            u(i, j);
        } catch (Exception unused) {
        }
    }

    private static String u(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int iMin = Math.min(i, 1000);
        int size = list.size();
        if (size % iMin == 0) {
            i2 = size / iMin;
        } else {
            i2 = (size / iMin) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * iMin;
            String strU = u(TextUtils.join("','", list.subList(i4, Math.min(i4 + iMin, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(strU);
            sb.append("')");
        }
        return u(sb.toString(), str + str2 + "('')");
    }

    private static String u(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}

package com.bytedance.sdk.component.n.nr.u.u.nr;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.igexin.push.f.b.d;
import com.qq.gdt.action.ActionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends nr {
    private com.bytedance.sdk.component.n.nr.b.nr.u b;
    protected List<String> fx;
    protected com.bytedance.sdk.component.n.u.pn nr;

    public x(Context context, com.bytedance.sdk.component.n.nr.b.nr.u uVar, com.bytedance.sdk.component.n.u.pn pnVar) {
        super(context, pnVar, uVar == null ? com.bytedance.sdk.component.n.nr.b.nr.u.fx() : uVar);
        this.fx = new ArrayList();
        this.b = uVar;
        this.nr = pnVar;
        if (uVar == null) {
            this.b = com.bytedance.sdk.component.n.nr.b.nr.u.fx();
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
        return (byte) 2;
    }

    public byte nr() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u
    public boolean u(com.bytedance.sdk.component.n.u.nr nrVar) {
        return com.bytedance.sdk.component.n.nr.fx.u.b(nrVar);
    }

    private void b(List<com.bytedance.sdk.component.n.u.nr> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.n.u.nr> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().fx());
        }
        com.bytedance.sdk.component.n.nr.u.u.nr.u(getContext(), "UPDATE " + u() + " SET retry = retry+1 WHERE " + u("id", (List<?>) linkedList, 1000, true), this.nr);
    }

    public void fx(List<String> list) {
        u();
        list.size();
        com.bytedance.sdk.component.n.nr.u.u.nr.u(getContext(), "DELETE FROM " + u() + " WHERE " + u("id", (List<?>) list, 1000, true), this.nr);
        com.bytedance.sdk.component.n.nr.fx.nr.u(com.bytedance.sdk.component.n.nr.nr.nr.u.k(), list.size(), this.nr);
        u(list);
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.nr
    public String u() {
        return this.nr.nr().b();
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.fx
    public List<com.bytedance.sdk.component.n.u.nr> u(int i, String str, int i2, boolean z) {
        long jU = com.bytedance.sdk.component.n.nr.nr.u.u(i, getContext(), this.nr);
        if (jU <= 0) {
            jU = 1;
        } else if (jU > 100) {
            jU = 100;
        }
        ArrayList arrayList = new ArrayList();
        this.fx.clear();
        Cursor cursorQuery = com.bytedance.sdk.component.n.nr.u.u.nr.query(getContext(), u(), new String[]{"id", ActionUtils.PAYMENT_AMOUNT, "encrypt"}, null, null, null, null, str + " DESC limit " + jU, this.nr);
        if (cursorQuery != null) {
            while (true) {
                try {
                    if (cursorQuery.moveToNext()) {
                        try {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt")) == 1) {
                                string2 = this.nr.b().u(string2);
                            }
                            if (TextUtils.isEmpty(string2)) {
                                this.fx.add(string);
                            } else {
                                if (arrayList.size() > 100) {
                                    break;
                                }
                                com.bytedance.sdk.component.n.nr.b.u.u uVar = new com.bytedance.sdk.component.n.nr.b.u.u(string, new JSONObject(string2));
                                uVar.nr(fx());
                                uVar.u(nr());
                                arrayList.add(uVar);
                            }
                        } catch (Throwable unused) {
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
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        return arrayList;
    }

    public static String b(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.fx
    public List<com.bytedance.sdk.component.n.u.nr> u(String str, int i, boolean z) {
        com.bytedance.sdk.component.n.nr.b.nr.u uVar = this.b;
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

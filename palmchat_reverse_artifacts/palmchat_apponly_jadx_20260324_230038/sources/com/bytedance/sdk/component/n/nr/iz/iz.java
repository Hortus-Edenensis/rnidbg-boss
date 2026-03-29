package com.bytedance.sdk.component.n.nr.iz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements pn {
    private Context nr;
    private com.bytedance.sdk.component.n.u.pn u;

    public iz(com.bytedance.sdk.component.n.u.pn pnVar) {
        this.nr = pnVar.getContext();
        this.u = pnVar;
    }

    public static String b() {
        return "ALTER TABLE trackurl ADD COLUMN encrypt INTEGER default 0";
    }

    public static String fx() {
        return "ALTER TABLE trackurl ADD COLUMN extra TEXT";
    }

    public static String nr() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0,retry INTEGER default 0,extra TEXT ,encrypt INTEGER default 0)").toString();
    }

    @Override // com.bytedance.sdk.component.n.nr.iz.pn
    public void delete(b bVar) {
        com.bytedance.sdk.component.n.nr.u.u.nr.delete(this.nr, "trackurl", "id=?", new String[]{bVar.nr()}, this.u);
    }

    @Override // com.bytedance.sdk.component.n.nr.iz.pn
    public void insert(b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", bVar.nr());
        contentValues.put("url", bVar.fx());
        contentValues.put("replaceholder", Integer.valueOf(bVar.b() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(bVar.pn()));
        contentValues.put(BaseConstants.EVENT_LABEL_EXTRA, com.bytedance.sdk.component.utils.u.nr(bVar.u().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.bytedance.sdk.component.n.nr.u.u.nr.insert(this.nr, "trackurl", contentValues, this.u);
    }

    @Override // com.bytedance.sdk.component.n.nr.iz.pn
    public List<b> u() {
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        Cursor cursorQuery = com.bytedance.sdk.component.n.nr.u.u.nr.query(this.nr, "trackurl", null, null, null, null, null, null, this.u);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        boolean z = cursorQuery.getInt(cursorQuery.getColumnIndex("replaceholder")) > 0;
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(BaseConstants.EVENT_LABEL_EXTRA));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                        if (i2 > 0) {
                            string3 = com.bytedance.sdk.component.utils.u.fx(string3);
                        }
                        try {
                            jSONObject = new JSONObject(string3);
                        } catch (Exception unused) {
                            jSONObject = null;
                        }
                        linkedList.add(new b(string, string2, z, i, jSONObject, i2));
                    } finally {
                        cursorQuery.close();
                    }
                } catch (Throwable unused2) {
                }
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.component.n.nr.iz.pn
    public void update(b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", bVar.nr());
        contentValues.put("url", bVar.fx());
        contentValues.put("replaceholder", Integer.valueOf(bVar.b() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(bVar.pn()));
        contentValues.put(BaseConstants.EVENT_LABEL_EXTRA, com.bytedance.sdk.component.utils.u.nr(bVar.u().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.bytedance.sdk.component.n.nr.u.u.nr.update(this.nr, "trackurl", contentValues, "id=?", new String[]{bVar.nr()}, this.u);
    }
}

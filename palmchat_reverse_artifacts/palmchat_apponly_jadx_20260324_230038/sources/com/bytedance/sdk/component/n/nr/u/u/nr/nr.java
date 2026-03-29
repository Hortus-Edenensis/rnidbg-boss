package com.bytedance.sdk.component.n.nr.u.u.nr;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr extends com.bytedance.sdk.component.n.nr.u.u implements fx {
    private com.bytedance.sdk.component.n.nr.b.nr.u b;
    private com.bytedance.sdk.component.n.u.pn fx;
    private final Context nr;
    protected final List<com.bytedance.sdk.component.n.u.nr> u = new ArrayList();
    private boolean pn = false;
    private final Runnable iz = new Runnable() { // from class: com.bytedance.sdk.component.n.nr.u.u.nr.nr.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (nr.this) {
                if (nr.this.u.isEmpty()) {
                    nr.this.pn = false;
                    return;
                }
                ArrayList arrayList = new ArrayList(nr.this.u);
                nr.this.u.clear();
                nr.this.pn = false;
                nr.this.nr(arrayList);
            }
        }
    };

    public nr(Context context, com.bytedance.sdk.component.n.u.pn pnVar, com.bytedance.sdk.component.n.nr.b.nr.u uVar) {
        this.nr = context;
        this.fx = pnVar;
        this.b = uVar;
    }

    private void nr() {
        if (this.pn) {
            return;
        }
        com.bytedance.sdk.component.n.nr.x.u.u(b()).u().postDelayed(this.iz, r0.nr());
        this.pn = true;
    }

    public abstract com.bytedance.sdk.component.n.u.pn b();

    public Context getContext() {
        return this.nr;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0027 A[EXC_TOP_SPLITTER, PHI: r0 r1
      0x0027: PHI (r0v3 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:13:0x0032, B:6:0x0025] A[DONT_GENERATE, DONT_INLINE]
      0x0027: PHI (r1v3 int) = (r1v0 int), (r1v5 int) binds: [B:13:0x0032, B:6:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int pn() {
        Cursor cursorQuery = null;
        int i = 0;
        try {
            cursorQuery = com.bytedance.sdk.component.n.nr.u.u.nr.query(getContext(), u(), new String[]{"count(1)"}, null, null, null, null, null, this.fx);
            if (cursorQuery != null) {
                cursorQuery.moveToFirst();
                i = cursorQuery.getInt(0);
            }
        } catch (Exception unused) {
            if (cursorQuery != null) {
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Exception unused3) {
            }
        }
        return i;
    }

    public abstract String u();

    public List<com.bytedance.sdk.component.n.u.nr> u(int i, int i2, com.bytedance.sdk.component.n.u.nr nrVar, boolean z) {
        int iNr;
        if (this.b == null || nrVar == null || !com.bytedance.sdk.component.n.nr.fx.u.u(i) || !u(nrVar) || (iNr = this.b.nr()) <= i2) {
            return null;
        }
        return u(iNr - i2, "_id", i, z);
    }

    public synchronized void nr(com.bytedance.sdk.component.n.u.nr nrVar) {
        if (u(nrVar) && nrVar.x() != null && !TextUtils.isEmpty(nrVar.fx())) {
            this.u.add(nrVar);
            nr();
        }
    }

    public com.bytedance.sdk.component.n.nr.u.nr u(int i, List<com.bytedance.sdk.component.n.u.nr> list) {
        com.bytedance.sdk.component.n.nr.u.nr nrVar = new com.bytedance.sdk.component.n.nr.u.nr();
        if (list != null && list.size() != 0 && list.get(0) != null && u(list.get(0))) {
            if (i != 200 && i != -1 && i != -3) {
                nrVar.u("code:".concat(String.valueOf(i)));
            } else {
                nrVar.u(delete(list));
            }
            nrVar.u(true);
            return nrVar;
        }
        nrVar.u(false);
        return nrVar;
    }

    public void nr(List<com.bytedance.sdk.component.n.u.nr> list) {
        com.bytedance.sdk.component.n.nr.u.u.nr.insert(getContext(), u(), list, this.fx);
        Iterator<com.bytedance.sdk.component.n.u.nr> it = list.iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.n.nr.fx.u.u(it.next(), this.fx, "_db");
        }
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u
    public List<com.bytedance.sdk.component.n.u.nr> nr(int i, com.bytedance.sdk.component.n.u.nr nrVar, boolean z, List<String> list, String str) {
        List<com.bytedance.sdk.component.n.u.nr> listU = u("_id", i, z);
        if (!u(listU, list)) {
            return null;
        }
        u();
        listU.size();
        return listU;
    }

    public void u(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<com.bytedance.sdk.component.n.u.nr> it = this.u.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.n.u.nr next = it.next();
                if (next != null) {
                    String strFx = next.fx();
                    if (!TextUtils.isEmpty(strFx) && list.contains(strFx)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            u();
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u
    public boolean nr(int i, String str, com.bytedance.sdk.component.n.u.nr nrVar) {
        if (this.b == null) {
            return false;
        }
        int iPn = pn();
        int iU = this.b.u();
        u();
        com.bytedance.sdk.component.n.nr.fx.u.nr(i);
        return iPn >= iU;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u
    public boolean u(String str) {
        if (this.b == null) {
            return false;
        }
        int iPn = pn();
        u();
        return iPn > 0;
    }

    private boolean u(List<com.bytedance.sdk.component.n.u.nr> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.n.u.nr> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.n.u.nr next = it.next();
                    if (next != null) {
                        String strFx = next.fx();
                        if (!TextUtils.isEmpty(strFx) && list2.contains(strFx)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }
}

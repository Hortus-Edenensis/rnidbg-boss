package cn.fly.verify;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.fly.verify.ce;
import cn.fly.verify.fq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ck extends ce {
    private a c;
    private String d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2149a;
        private ck b;

        public a(ck ckVar, int i) {
            super(null);
            this.f2149a = i;
            this.b = ckVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            ck ckVar = this.b;
            if (ckVar != null) {
                ckVar.a(z, this.f2149a);
            }
        }
    }

    public ck(Context context) {
        super(context);
        this.c = null;
        this.d = "100215079";
        if (!TextUtils.isEmpty(ec.j)) {
            this.d = ec.j;
        }
        en.a().a("oamt vivo appid: " + this.d, new Object[0]);
    }

    private void c(int i) {
        if (i == 0 && this.c == null) {
            this.c = new a(this, 0);
            this.f2142a.getContentResolver().registerContentObserver(Uri.parse(b(0)), true, this.c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x003b A[EXC_TOP_SPLITTER, PHI: r0
      0x003b: PHI (r0v3 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:22:0x004b, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i) {
        Cursor cursorQuery;
        String strB = b(i);
        if (strB == null) {
            return null;
        }
        try {
            cursorQuery = this.f2142a.getContentResolver().query(Uri.parse(strB), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(dx.a("005Nbb-beEbeAd")));
                        try {
                            cursorQuery.close();
                        } catch (Throwable unused) {
                        }
                        try {
                            c(i);
                        } catch (Throwable unused2) {
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        en.a().a(th);
                        if (cursorQuery != null) {
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable unused3) {
            }
        }
        try {
            c(i);
        } catch (Throwable unused4) {
        }
        return null;
    }

    @Override // cn.fly.verify.ce
    public ce.b b() {
        ce.b bVar = new ce.b();
        bVar.b = a(0);
        return bVar;
    }

    @Override // cn.fly.verify.ce
    public synchronized boolean e() {
        return "1".equals(fq.d.c(dx.a("034hdIbhdfbgdfNgDdbdfbidfdbbgbaUdcgIbgcdbgXdAbhbgbadbdfbeFhh-cbbh%gd!ba")));
    }

    private String b(int i) {
        if (i == 0) {
            return dx.a("051a1cbGcgdcgijja5cbbddbbbbgbbcbdbbbbddfdbcgbaejbhcbbbbgbaDd4bhKj<cgba:dcg.bgcdbg]d6bhcgba4j eecjcgdi");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i) {
        try {
            String strA = a(i);
            if (i == 0) {
                a(strA);
            }
        } catch (Throwable unused) {
        }
    }
}

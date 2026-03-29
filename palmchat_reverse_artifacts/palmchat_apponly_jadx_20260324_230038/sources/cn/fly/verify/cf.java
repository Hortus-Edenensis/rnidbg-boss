package cn.fly.verify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cf extends ce {
    private a c;
    private a d;
    private BroadcastReceiver e;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2146a;
        private long b;
        private String c;

        public a(String str) {
            this.f2146a = str;
        }

        public String a() {
            return this.c;
        }

        public boolean b() {
            return this.b > System.currentTimeMillis();
        }

        public void a(long j) {
            this.b = j;
        }

        public void a(String str) {
            this.c = str;
        }
    }

    public cf(Context context) {
        super(context);
        this.c = new a(bq.a("004;fe*e7ejed"));
        this.d = new a(bq.a("009^gieh@kk9feek.jgEed"));
    }

    private void f() {
        try {
            if (this.e == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(bq.a("044d?feeggeeg5g%ejhdehgefg5h7elegHgUgefe+kgfKejedgefmhlflfjhhfieihhhmhifieifjgleihlgkfmfijehi"));
                BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: cn.fly.verify.cf.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        String stringExtra;
                        ArrayList<String> stringArrayListExtra;
                        if (context == null || intent == null) {
                            return;
                        }
                        try {
                            boolean zContains = false;
                            if (intent.getIntExtra(bq.a("0168fe*kgfOfjedfife?j*ejfgelgmWheJff"), 0) == 2 && (stringArrayListExtra = intent.getStringArrayListExtra(bq.a("017Ufe>kgf_fjedhm1edBemWe3ff3g'gdejgiTj"))) != null) {
                                zContains = stringArrayListExtra.contains(context.getPackageName());
                            }
                            if (zContains && (stringExtra = intent.getStringExtra(bq.a("010 fe(kgfYfjedflelGkg"))) != null && stringExtra.equals(bq.a("004+fe=eAejed"))) {
                                cf.this.c.a(0L);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                };
                this.e = broadcastReceiver;
                if (Build.VERSION.SDK_INT < 33) {
                    this.f2142a.registerReceiver(broadcastReceiver, intentFilter, bq.a("048dEfeeggeeg2gWejhdehgefg'hFelegBg;gefe)kgf_ejedgeFkg+ekegejgigiejfeVfMgehhhmhifieifjgleihlgkfmfijehi"), null);
                } else {
                    this.f2142a.registerReceiver(broadcastReceiver, intentFilter, bq.a("048d>feeggeeg'gHejhdehgefg?h=eleg%g5gefeUkgf3ejedge9kg)ekegejgigiejfe-fZgehhhmhifieifjgleihlgkfmfijehi"), null, 4);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.fly.verify.ce
    public synchronized String d() {
        Context context = this.f2142a;
        if (context == null) {
            return null;
        }
        return a(context.getApplicationContext(), this.c, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0097 A[EXC_TOP_SPLITTER, PHI: r1
      0x0097: PHI (r1v4 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:43:0x00a4, B:37:0x0095] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(Context context, a aVar, boolean z) {
        Cursor cursorQuery;
        String string;
        if (aVar == null) {
            return null;
        }
        if (!z && aVar.b()) {
            return aVar.c;
        }
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse(bq.a("036dMfe7fjgfjlmmd+feeggeeg,gYejhdehgefg@hUeleg=g*gefe-kgfIejedgiedem4m")), null, null, new String[]{aVar.f2146a}, null);
            try {
            } catch (Throwable th) {
                th = th;
                try {
                    en.a().a(th);
                    if (cursorQuery != null) {
                    }
                } catch (Throwable th2) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
        if (cursorQuery == null) {
            if (z) {
                aVar.a("1");
            }
            if (a(false)) {
                a(true);
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable unused2) {
                }
            }
            return null;
        }
        cursorQuery.moveToFirst();
        int columnIndex = cursorQuery.getColumnIndex(bq.a("005VeeAeh0ehWg"));
        if (columnIndex >= 0) {
            string = cursorQuery.getString(columnIndex);
            aVar.a(string);
        } else {
            string = null;
        }
        if (!z) {
            int columnIndex2 = cursorQuery.getColumnIndex(bq.a("007g8fd kWejek;gSed"));
            if (columnIndex2 >= 0) {
                aVar.a(cursorQuery.getLong(columnIndex2));
            }
            int columnIndex3 = cursorQuery.getColumnIndex(bq.a("004d,feedYg"));
            if (columnIndex3 >= 0 && cursorQuery.getInt(columnIndex3) != 1000) {
                f();
                if (!a(false)) {
                    a(true);
                }
            }
        }
        try {
            cursorQuery.close();
        } catch (Throwable unused3) {
        }
        return string;
    }

    private boolean a(boolean z) {
        a aVar;
        if (!z && (aVar = this.d) != null && aVar.a() != null) {
            return this.d.a().equals("0");
        }
        String strA = a(this.f2142a, this.d, true);
        return strA != null && "0".equals(strA);
    }
}

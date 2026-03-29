package com.zenmen.palmchat.test;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.mapapi.http.HttpClient;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.utils.SqliteRecover;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.dv;
import defpackage.g13;
import defpackage.ho0;
import defpackage.ho3;
import defpackage.ir5;
import defpackage.nn0;
import defpackage.u93;
import defpackage.vh5;
import defpackage.xf5;
import defpackage.xn3;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SqliteTestActivity extends BaseActionBarActivity {
    public static String v = "SqliteTestActivity";
    public int q = 100;
    public TextView r;
    public TextView s;
    public EditText t;
    public EditText u;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SqliteTestActivity.this.W1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SqliteTestActivity.this.showBaseProgressBar();
            SqliteTestActivity.this.d2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i(SqliteTestActivity.v, "insertContact start");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 100; i++) {
                ContentValues contentValuesR1 = SqliteTestActivity.this.R1(i);
                if (contentValuesR1 != null) {
                    arrayList.add(contentValuesR1);
                }
            }
            if (arrayList.size() > 0) {
                dv.a("processContactsSync", ho0.f18003a, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]), true);
            }
            LogUtil.i(SqliteTestActivity.v, "insertContact end");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w f15449a;

            public a(w wVar) {
                this.f15449a = wVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SqliteTestActivity.this.r.setText("" + this.f15449a.a());
                SqliteTestActivity.this.hideBaseProgressBar();
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SQLiteDatabase writableDatabase = xf5.a(AccountUtils.p(AppContext.getContext())).getWritableDatabase();
            w wVar = new w(SqliteTestActivity.v, "createIndex", ho3.c("tb_messages"));
            wVar.b();
            writableDatabase.execSQL(ho3.c("tb_messages"));
            wVar.c();
            SqliteTestActivity.this.r.post(new a(wVar));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SqliteTestActivity.this.hideBaseProgressBar();
            }
        }

        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SQLiteDatabase writableDatabase = xf5.a(AccountUtils.p(AppContext.getContext())).getWritableDatabase();
            w wVar = new w(SqliteTestActivity.v, "removeIndex", "drop index msg_table_idx;");
            wVar.b();
            writableDatabase.execSQL(ho3.a("tb_messages"));
            wVar.c();
            SqliteTestActivity.this.r.post(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w f15453a;

            public a(w wVar) {
                this.f15453a = wVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SqliteTestActivity.this.hideBaseProgressBar();
                SqliteTestActivity.this.r.setText("" + this.f15453a.a());
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Class<ho3> cls;
            f fVar = this;
            w wVar = new w(SqliteTestActivity.v, "newData", "insert into messasge " + SqliteTestActivity.this.q);
            wVar.b();
            ArrayList arrayListU1 = SqliteTestActivity.this.U1();
            int i = 0;
            while (true) {
                cls = ho3.class;
                if (i >= SqliteTestActivity.this.q / 10000) {
                    break;
                }
                ContentValues[] contentValuesArr = new ContentValues[10000];
                String strP = AccountUtils.p(SqliteTestActivity.this);
                w wVar2 = wVar;
                int i2 = 10000;
                int i3 = 0;
                while (i3 < i2) {
                    ContentValues contentValues = new ContentValues();
                    StringBuilder sb = new StringBuilder();
                    sb.append("test");
                    Class<ho3> cls2 = cls;
                    sb.append(xn3.a());
                    sb.append(i3);
                    contentValues.put("packet_id", sb.toString());
                    contentValues.put("message", "test" + xn3.b());
                    contentValues.put("contact_relate", arrayListU1.size() == 0 ? strP : ((ContactInfoItem) arrayListU1.get(((i * 10000) + i3) % arrayListU1.size())).getUid());
                    contentValues.put("msg_type", (Integer) 1);
                    contentValues.put("msg_status", (Integer) 2);
                    contentValues.put("type", (Integer) 2);
                    contentValues.put("read", (Integer) 1);
                    contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(ir5.b()));
                    contentValuesArr[i3] = contentValues;
                    i3++;
                    i2 = 10000;
                    cls = cls2;
                }
                AppContext.getContext().getContentResolver().bulkInsert(DBUriManager.a(cls, 0), contentValuesArr);
                Log.e(SqliteTestActivity.v, "bulkInsert " + SqliteTestActivity.this.q + " msg");
                i++;
                fVar = this;
                wVar = wVar2;
            }
            f fVar2 = fVar;
            w wVar3 = wVar;
            if (SqliteTestActivity.this.q % 10000 > 0) {
                int i4 = SqliteTestActivity.this.q % 10000;
                ContentValues[] contentValuesArr2 = new ContentValues[i4];
                String strP2 = AccountUtils.p(SqliteTestActivity.this);
                int i5 = 0;
                while (i5 < i4) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("packet_id", "test" + xn3.a());
                    contentValues2.put("message", "test" + xn3.b());
                    contentValues2.put("contact_relate", strP2);
                    contentValues2.put("msg_type", (Integer) 1);
                    contentValues2.put("msg_status", (Integer) 2);
                    contentValues2.put("type", (Integer) 2);
                    contentValues2.put("read", (Integer) 1);
                    contentValues2.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(ir5.b()));
                    contentValuesArr2[i5] = contentValues2;
                    i5++;
                    i4 = i4;
                }
                AppContext.getContext().getContentResolver().bulkInsert(DBUriManager.a(cls, 0), contentValuesArr2);
            }
            wVar3.c();
            SqliteTestActivity.this.r.post(new a(wVar3));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SqliteTestActivity.this.hideBaseProgressBar();
            }
        }

        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xf5.a(AccountUtils.p(AppContext.getContext())).getWritableDatabase();
            AccountUtils.p(SqliteTestActivity.this);
            SqliteTestActivity.this.U1();
            w wVar = new w(SqliteTestActivity.v, "removeData", HttpClient.ENDFLAG);
            wVar.b();
            AppContext.getContext().getContentResolver().delete(DBUriManager.a(ho3.class, 0), null, null);
            wVar.c();
            SqliteTestActivity.this.r.post(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w f15457a;

            public a(w wVar) {
                this.f15457a = wVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SqliteTestActivity.this.s.setText("" + this.f15457a.a());
                SqliteTestActivity.this.hideBaseProgressBar();
            }
        }

        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xf5.a(AccountUtils.p(AppContext.getContext())).getWritableDatabase();
            w wVar = new w(SqliteTestActivity.v, "insertTest", "100");
            wVar.b();
            ContentValues[] contentValuesArr = new ContentValues[100];
            String strP = AccountUtils.p(SqliteTestActivity.this);
            for (int i = 0; i < 100; i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("packet_id", "test" + xn3.a());
                contentValues.put("message", "test" + xn3.b());
                contentValues.put("contact_relate", strP);
                contentValues.put("msg_type", (Integer) 1);
                contentValues.put("msg_status", (Integer) 2);
                contentValues.put("type", (Integer) 2);
                contentValues.put("read", (Integer) 1);
                contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(ir5.b()));
                contentValuesArr[i] = contentValues;
            }
            AppContext.getContext().getContentResolver().bulkInsert(DBUriManager.a(ho3.class, 0), contentValuesArr);
            wVar.c();
            SqliteTestActivity.this.s.post(new a(wVar));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SqliteTestActivity.this.hideBaseProgressBar();
            }
        }

        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SqliteRecover.backupDatabases();
            SqliteTestActivity.this.r.post(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SqliteTestActivity.this.hideBaseProgressBar();
            }
        }

        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SqliteRecover.restoreDatabases();
            SqliteTestActivity.this.r.post(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SqliteTestActivity.this.showBaseProgressBar();
            SqliteTestActivity.this.Y1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w f15464a;

            public a(w wVar) {
                this.f15464a = wVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SqliteTestActivity.this.hideBaseProgressBar();
                SqliteTestActivity.this.r.setText("" + this.f15464a.a());
            }
        }

        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w wVar;
            String str;
            l lVar = this;
            w wVar2 = new w(SqliteTestActivity.v, "newData", "insert into messasge " + SqliteTestActivity.this.q);
            wVar2.b();
            ArrayList arrayListU1 = SqliteTestActivity.this.U1();
            int i = 0;
            while (true) {
                String str2 = "read";
                String str3 = "type";
                wVar = wVar2;
                str = "/";
                if (i >= SqliteTestActivity.this.q / 10000) {
                    break;
                }
                ContentValues[] contentValuesArr = new ContentValues[10000];
                String strA = xn3.a();
                String strP = AccountUtils.p(SqliteTestActivity.this);
                int i2 = 0;
                for (int i3 = 10000; i2 < i3; i3 = 10000) {
                    ContentValues contentValues = new ContentValues();
                    String str4 = str2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("test");
                    String str5 = str3;
                    sb.append(xn3.a());
                    sb.append(i2);
                    contentValues.put("packet_id", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(strA);
                    sb2.append("@muc.youni");
                    sb2.append("/");
                    sb2.append(arrayListU1.size() == 0 ? strP : ((ContactInfoItem) arrayListU1.get(((i * 10000) + i2) % arrayListU1.size())).getUid());
                    contentValues.put("src", sb2.toString());
                    contentValues.put("message", "test" + xn3.b());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(strA);
                    sb3.append("@muc.youni");
                    sb3.append("/");
                    sb3.append(arrayListU1.size() == 0 ? strP : ((ContactInfoItem) arrayListU1.get(((i * 10000) + i2) % arrayListU1.size())).getUid());
                    contentValues.put("contact_relate", sb3.toString());
                    contentValues.put("msg_type", (Integer) 1);
                    contentValues.put("msg_status", (Integer) 2);
                    str3 = str5;
                    contentValues.put(str3, (Integer) 2);
                    contentValues.put(str4, (Integer) 1);
                    contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(ir5.b()));
                    contentValuesArr[i2] = contentValues;
                    i2++;
                    str2 = str4;
                    strA = strA;
                }
                AppContext.getContext().getContentResolver().bulkInsert(DBUriManager.a(ho3.class, 0), contentValuesArr);
                Log.e(SqliteTestActivity.v, "bulkInsert " + SqliteTestActivity.this.q + " msg");
                i++;
                lVar = this;
                wVar2 = wVar;
            }
            String str6 = FFmpegMediaMetadataRetriever.METADATA_KEY_DATE;
            String str7 = "read";
            l lVar2 = lVar;
            if (SqliteTestActivity.this.q % 10000 > 0) {
                int i4 = SqliteTestActivity.this.q % 10000;
                ContentValues[] contentValuesArr2 = new ContentValues[i4];
                String strP2 = AccountUtils.p(SqliteTestActivity.this);
                String strA2 = xn3.a();
                int i5 = 0;
                while (i5 < i4) {
                    int i6 = i4;
                    ContentValues contentValues2 = new ContentValues();
                    ContentValues[] contentValuesArr3 = contentValuesArr2;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("test");
                    String str8 = str6;
                    sb4.append(xn3.a());
                    contentValues2.put("packet_id", sb4.toString());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(strA2);
                    sb5.append("@muc.youni");
                    sb5.append(str);
                    sb5.append(arrayListU1.size() == 0 ? strP2 : ((ContactInfoItem) arrayListU1.get(i5 % arrayListU1.size())).getUid());
                    contentValues2.put("src", sb5.toString());
                    contentValues2.put("message", "test" + xn3.b());
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(strA2);
                    sb6.append("@muc.youni");
                    sb6.append(str);
                    sb6.append(arrayListU1.size() == 0 ? strP2 : ((ContactInfoItem) arrayListU1.get(i5 % arrayListU1.size())).getUid());
                    contentValues2.put("contact_relate", sb6.toString());
                    contentValues2.put("msg_type", (Integer) 1);
                    contentValues2.put("msg_status", (Integer) 2);
                    contentValues2.put("type", (Integer) 2);
                    String str9 = str7;
                    contentValues2.put(str9, (Integer) 1);
                    contentValues2.put(str8, Long.valueOf(ir5.b()));
                    contentValuesArr3[i5] = contentValues2;
                    i5++;
                    i4 = i6;
                    contentValuesArr2 = contentValuesArr3;
                    str6 = str8;
                    str = str;
                    str7 = str9;
                }
                AppContext.getContext().getContentResolver().bulkInsert(DBUriManager.a(ho3.class, 0), contentValuesArr2);
            }
            wVar.c();
            SqliteTestActivity.this.r.post(new a(wVar));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SQLiteDatabase f15465a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w f15466a;

            public a(w wVar) {
                this.f15466a = wVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SqliteTestActivity.this.hideBaseProgressBar();
                SqliteTestActivity.this.r.setText("" + this.f15466a.a());
            }
        }

        public m(SQLiteDatabase sQLiteDatabase) {
            this.f15465a = sQLiteDatabase;
        }

        @Override // java.lang.Runnable
        public void run() {
            w wVar = new w(SqliteTestActivity.v, "newData", "transfer messasge ");
            wVar.b();
            new vh5(this.f15465a, AccountUtils.p(AppContext.getContext()));
            com.zenmen.palmchat.database.a.g();
            wVar.c();
            SqliteTestActivity.this.r.post(new a(wVar));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SQLiteDatabase f15467a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w f15468a;

            public a(w wVar) {
                this.f15468a = wVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SqliteTestActivity.this.hideBaseProgressBar();
                SqliteTestActivity.this.r.setText("" + this.f15468a.a());
            }
        }

        public n(SQLiteDatabase sQLiteDatabase) {
            this.f15467a = sQLiteDatabase;
        }

        @Override // java.lang.Runnable
        public void run() {
            w wVar = new w(SqliteTestActivity.v, "newData", "transfer messasge ");
            wVar.b();
            com.zenmen.palmchat.database.a.e(new vh5(this.f15467a, AccountUtils.p(AppContext.getContext())));
            wVar.c();
            SqliteTestActivity.this.r.post(new a(wVar));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SqliteTestActivity.this.showBaseProgressBar();
            SqliteTestActivity.this.a2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SqliteTestActivity.this.showBaseProgressBar();
            SqliteTestActivity.this.S1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SqliteTestActivity.this.showBaseProgressBar();
            SqliteTestActivity.this.b2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SqliteTestActivity.this.showBaseProgressBar();
            SqliteTestActivity.this.X1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SqliteTestActivity.this.showBaseProgressBar();
            SqliteTestActivity.this.T1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SqliteTestActivity.this.showBaseProgressBar();
            SqliteTestActivity.this.V1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SqliteTestActivity.this.showBaseProgressBar();
            SqliteTestActivity.this.Z1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SqliteTestActivity.this.showBaseProgressBar();
            SqliteTestActivity.this.c2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f15477a;
        public String b;
        public String c;
        public String d;
        public long e = 0;
        public long f = 0;

        public w(String str, String str2, String str3) {
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        public long a() {
            return this.f;
        }

        public void b() {
            Log.e(this.b, "action:" + this.c + "  info: " + this.d);
            this.f15477a = System.currentTimeMillis();
        }

        public void c() {
            this.f = System.currentTimeMillis() - this.f15477a;
            Log.e(this.b, "Index : " + this.e + " action:" + this.c + "  info: " + this.d + " cost: " + this.f + " ms");
            this.f15477a = System.currentTimeMillis();
        }
    }

    public final ContentValues R1(int i2) {
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(String.valueOf(ir5.b() + ((long) i2)));
        ContentValues contentValuesA = nn0.a(contactInfoItem);
        contentValuesA.put("contact_operation", (Integer) 1);
        contentValuesA.put("data2", (Integer) 0);
        return contentValuesA;
    }

    public final void S1() {
        new g13(new d()).start();
    }

    public final void T1() {
        new g13(new i()).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005c A[PHI: r1
      0x005c: PHI (r1v3 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:15:0x005a, B:9:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<ContactInfoItem> U1() {
        ArrayList<ContactInfoItem> arrayList = new ArrayList<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(ho0.f18003a, null, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToNext()) {
                    do {
                        ContactInfoItem contactInfoItem = new ContactInfoItem();
                        contactInfoItem.setUid(cursorQuery.getString(cursorQuery.getColumnIndex(DeviceInfoUtil.UID_TAG)));
                        contactInfoItem.setNickName(cursorQuery.getString(cursorQuery.getColumnIndex("nick_name")));
                        cursorQuery.getString(cursorQuery.getColumnIndex("data2"));
                        arrayList.add(contactInfoItem);
                    } while (cursorQuery.moveToNext());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final void V1() {
        new g13(new j()).start();
    }

    public final void W1() {
        u93.e(new c());
    }

    public final void X1() {
        new g13(new h()).start();
    }

    public final void Y1() {
        xf5.a(AccountUtils.p(AppContext.getContext())).getWritableDatabase();
        String string = this.t.getText().toString();
        if (string == null || string.length() == 0) {
            string = "0";
        }
        this.q = 0;
        this.q = new Integer(string).intValue();
        Log.e(v, "mMsgCountEditText.getText().toString():" + string);
        new g13(new f()).start();
    }

    public final void Z1() {
        xf5.a(AccountUtils.p(AppContext.getContext())).getWritableDatabase();
        String string = this.u.getText().toString();
        if (string == null || string.length() == 0) {
            string = "0";
        }
        this.q = 0;
        this.q = new Integer(string).intValue();
        Log.e(v, "mGroupMsgCountEditText.getText().toString():" + string);
        new g13(new l()).start();
    }

    public final void a2() {
        new g13(new g()).start();
    }

    public final void b2() {
        new g13(new e()).start();
    }

    public final void c2() {
        new g13(new m(xf5.a(AccountUtils.p(AppContext.getContext())).getWritableDatabase())).start();
    }

    public final void d2() {
        new g13(new n(xf5.a(AccountUtils.p(AppContext.getContext())).getWritableDatabase())).start();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sqlite_test);
        this.r = (TextView) findViewById(R.id.index_text_view);
        this.s = (TextView) findViewById(R.id.insert_text_view);
        this.t = (EditText) findViewById(R.id.msg_count_edit_text);
        this.u = (EditText) findViewById(R.id.group_edit_text);
        ((Button) findViewById(R.id.new_data_button)).setOnClickListener(new k());
        ((Button) findViewById(R.id.clear_data_button)).setOnClickListener(new o());
        ((Button) findViewById(R.id.create_index_button)).setOnClickListener(new p());
        ((Button) findViewById(R.id.remove_index_button)).setOnClickListener(new q());
        ((Button) findViewById(R.id.insert_test_button)).setOnClickListener(new r());
        ((Button) findViewById(R.id.export_database_button)).setOnClickListener(new s());
        ((Button) findViewById(R.id.restore_database_button)).setOnClickListener(new t());
        ((Button) findViewById(R.id.insert_group_msg_button)).setOnClickListener(new u());
        ((Button) findViewById(R.id.data_transfer)).setOnClickListener(new v());
        ((Button) findViewById(R.id.data_insert_contact)).setOnClickListener(new a());
        ((Button) findViewById(R.id.data_transfer_reverse)).setOnClickListener(new b());
    }
}

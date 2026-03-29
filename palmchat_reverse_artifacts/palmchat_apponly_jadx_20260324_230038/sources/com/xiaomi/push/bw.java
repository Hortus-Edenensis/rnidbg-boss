package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bw f11454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f166a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private bv f167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final HashMap<String, bu> f169a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ThreadPoolExecutor f170a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ArrayList<a> f168a = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private a f172a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f173a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private WeakReference<Context> f174a;
        protected String b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected bu f171a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Random f175a = new Random();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11456a = 0;

        public a(String str) {
            this.f173a = str;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public Object mo217a() {
            return null;
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        @Override // java.lang.Runnable
        public final void run() {
            final Context context;
            WeakReference<Context> weakReference = this.f174a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f171a == null || TextUtils.isEmpty(this.f173a)) {
                return;
            }
            File file = new File(this.f173a);
            u.a(context, new File(file.getParentFile(), ba.b(file.getAbsolutePath())), new Runnable() { // from class: com.xiaomi.push.bw.a.1
                @Override // java.lang.Runnable
                public void run() {
                    SQLiteDatabase sQLiteDatabaseA = null;
                    try {
                        try {
                            sQLiteDatabaseA = a.this.a();
                            if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                                sQLiteDatabaseA.beginTransaction();
                                a.this.a(context, sQLiteDatabaseA);
                                sQLiteDatabaseA.setTransactionSuccessful();
                            }
                            if (sQLiteDatabaseA != null) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Exception e) {
                                    e = e;
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                }
                            }
                            bu buVar = a.this.f171a;
                            if (buVar != null) {
                                buVar.close();
                            }
                        } catch (Exception e2) {
                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                            if (sQLiteDatabaseA != null) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Exception e3) {
                                    e = e3;
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                }
                            }
                            bu buVar2 = a.this.f171a;
                            if (buVar2 != null) {
                                buVar2.close();
                            }
                        }
                        a.this.a(context);
                    } catch (Throwable th) {
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Exception e4) {
                                com.xiaomi.channel.commonutils.logger.b.a(e4);
                                a.this.a(context);
                                throw th;
                            }
                        }
                        bu buVar3 = a.this.f171a;
                        if (buVar3 != null) {
                            buVar3.close();
                        }
                        a.this.a(context);
                        throw th;
                    }
                }
            });
        }

        public void a(bu buVar, Context context) {
            this.f171a = buVar;
            this.b = buVar.a();
            this.f174a = new WeakReference<>(context);
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m219a() {
            return this.f171a == null || TextUtils.isEmpty(this.b) || this.f174a == null;
        }

        public void a(a aVar) {
            this.f172a = aVar;
        }

        public void a(Context context, Object obj) {
            bw.a(context).a(this);
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m218a() {
            return this.f173a;
        }

        public SQLiteDatabase a() {
            return this.f171a.getWritableDatabase();
        }

        public void a(Context context) {
            a aVar = this.f172a;
            if (aVar != null) {
                aVar.a(context, mo217a());
            }
            b(context);
        }

        public void b(Context context) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f11460a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected String[] f180a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f11460a = str2;
            this.f180a = strArr;
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.f11460a, this.f180a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ContentValues f11461a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f11461a = contentValues;
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.f11461a);
        }
    }

    private bw(Context context) {
        this.f166a = context;
    }

    public void b(a aVar) {
        bu buVarA;
        if (aVar == null) {
            return;
        }
        if (this.f167a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String strM218a = aVar.m218a();
        synchronized (this.f169a) {
            buVarA = this.f169a.get(strM218a);
            if (buVarA == null) {
                buVarA = this.f167a.a(this.f166a, strM218a);
                this.f169a.put(strM218a, buVarA);
            }
        }
        if (this.f170a.isShutdown()) {
            return;
        }
        aVar.a(buVarA, this.f166a);
        a((Runnable) aVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList<a> f11459a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.f11459a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            for (a aVar : this.f11459a) {
                if (aVar != null) {
                    aVar.a(context, sQLiteDatabase);
                }
            }
        }

        @Override // com.xiaomi.push.bw.a
        public final void a(Context context) {
            super.a(context);
            for (a aVar : this.f11459a) {
                if (aVar != null) {
                    aVar.a(context);
                }
            }
        }
    }

    public static bw a(Context context) {
        if (f11454a == null) {
            synchronized (bw.class) {
                if (f11454a == null) {
                    f11454a = new bw(context);
                }
            }
        }
        return f11454a;
    }

    private void a() {
        ae.a(this.f166a).b(new ae.a() { // from class: com.xiaomi.push.bw.1
            @Override // com.xiaomi.push.ae.a
            /* JADX INFO: renamed from: a */
            public String mo207a() {
                return "100957";
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (bw.this.f168a) {
                    if (bw.this.f168a.size() > 0) {
                        if (bw.this.f168a.size() > 1) {
                            bw bwVar = bw.this;
                            bwVar.a(bwVar.f168a);
                        } else {
                            bw bwVar2 = bw.this;
                            bwVar2.b((a) bwVar2.f168a.get(0));
                        }
                        bw.this.f168a.clear();
                        System.gc();
                    }
                }
            }
        }, com.xiaomi.push.service.ah.a(this.f166a).a(gk.StatDataProcessFrequency.a(), 5));
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b<T> extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11458a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f177a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private List<String> f178a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String[] f179a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f178a = list;
            this.f177a = str2;
            this.f179a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f11458a = i;
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            List<String> list = this.f178a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f178a.size()];
                this.f178a.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.f11458a;
            Cursor cursorQuery = sQLiteDatabase.query(super.b, strArr, this.f177a, this.f179a, this.c, this.d, this.e, i > 0 ? String.valueOf(i) : null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    T tA = a(context, cursorQuery);
                    if (tA != null) {
                        this.b.add(tA);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
            }
            a(context, (List) this.b);
        }

        public abstract void a(Context context, List<T> list);

        @Override // com.xiaomi.push.bw.a
        public SQLiteDatabase a() {
            return ((a) this).f171a.getReadableDatabase();
        }
    }

    public void a(a aVar) {
        bu buVarA;
        if (aVar == null) {
            return;
        }
        if (this.f167a != null) {
            String strM218a = aVar.m218a();
            synchronized (this.f169a) {
                buVarA = this.f169a.get(strM218a);
                if (buVarA == null) {
                    buVarA = this.f167a.a(this.f166a, strM218a);
                    this.f169a.put(strM218a, buVarA);
                }
            }
            if (this.f170a.isShutdown()) {
                return;
            }
            aVar.a(buVarA, this.f166a);
            synchronized (this.f168a) {
                this.f168a.add(aVar);
                a();
            }
            return;
        }
        throw new IllegalStateException("should exec init method first!");
    }

    public void a(Runnable runnable) {
        if (this.f170a.isShutdown()) {
            return;
        }
        this.f170a.execute(runnable);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m216a(String str) {
        return a(str).a();
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f167a != null) {
            HashMap map = new HashMap();
            if (this.f170a.isShutdown()) {
                return;
            }
            for (a aVar : arrayList) {
                if (aVar.m219a()) {
                    aVar.a(a(aVar.m218a()), this.f166a);
                }
                ArrayList arrayList2 = (ArrayList) map.get(aVar.m218a());
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(aVar.m218a(), arrayList2);
                }
                arrayList2.add(aVar);
            }
            for (String str : map.keySet()) {
                ArrayList arrayList3 = (ArrayList) map.get(str);
                if (arrayList3 != null && arrayList3.size() > 0) {
                    c cVar = new c(str, arrayList3);
                    cVar.a(((a) arrayList3.get(0)).f171a, this.f166a);
                    this.f170a.execute(cVar);
                }
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    private bu a(String str) {
        bu buVarA = this.f169a.get(str);
        if (buVarA == null) {
            synchronized (this.f169a) {
                if (buVarA == null) {
                    buVarA = this.f167a.a(this.f166a, str);
                    this.f169a.put(str, buVarA);
                }
            }
        }
        return buVarA;
    }
}

package com.igexin.push.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.c.a.b.e;
import com.igexin.c.a.d.f;
import com.igexin.push.core.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class d extends f {
    public static final int l = -2147483640;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7096a;
    protected SQLiteDatabase d;
    protected Cursor e;
    Context f;
    protected String[] g;
    protected ContentValues h;
    protected ContentValues[] i;
    protected Object j;
    public c k;

    public d() {
        super(1);
        this.f7096a = getClass().getName();
    }

    private void a(c cVar) {
        this.k = cVar;
    }

    public abstract void a_() throws Exception;

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws Exception {
        super.b_();
        this.d = d.a.f7200a.i.getWritableDatabase();
        a_();
        if (this.k != null) {
            e.a().a(this.k);
            e.a().b();
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return l;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
        this.o = true;
        this.L = true;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d_() {
        super.d_();
        Cursor cursor = this.e;
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        try {
            this.e.close();
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    public d(ContentValues contentValues) {
        super(1);
        this.f7096a = getClass().getName();
        this.h = contentValues;
    }

    private d(Context context) {
        super(1);
        this.f7096a = getClass().getName();
        this.f = context;
    }

    private d(Context context, ContentValues contentValues) {
        super(1);
        this.f7096a = getClass().getName();
        this.f = context;
        this.h = contentValues;
    }

    private d(Context context, c cVar) {
        super(1);
        this.f7096a = getClass().getName();
        this.f = context;
        this.k = cVar;
    }

    private d(Context context, Object obj) {
        super(1);
        this.f7096a = getClass().getName();
        this.f = context;
        this.j = obj;
    }

    private d(Context context, ContentValues[] contentValuesArr) {
        super(1);
        this.f7096a = getClass().getName();
        this.f = context;
        this.i = contentValuesArr;
    }

    private d(Context context, String[] strArr) {
        super(1);
        this.f7096a = getClass().getName();
        this.f = context;
        this.g = strArr;
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }
}

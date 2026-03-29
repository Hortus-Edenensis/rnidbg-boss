package com.ss.android.socialbase.downloader.nr;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.jk.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x {
    private final String[] b;
    private final String[] fx;
    private SQLiteStatement iz;
    private SQLiteStatement n;
    private final String nr;
    private SQLiteStatement pn;
    private final SQLiteDatabase u;
    private SQLiteStatement x;

    public x(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.u = sQLiteDatabase;
        this.nr = str;
        this.fx = strArr;
        this.b = strArr2;
    }

    public SQLiteStatement b() {
        if (this.n == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.u.compileStatement(a.nr(this.nr, this.fx, this.b));
            synchronized (this) {
                if (this.n == null) {
                    this.n = sQLiteStatementCompileStatement;
                }
            }
            if (this.n != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.n;
    }

    public SQLiteStatement fx() {
        if (this.iz == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.u.compileStatement(a.u(this.nr, this.fx, this.b));
            synchronized (this) {
                if (this.iz == null) {
                    this.iz = sQLiteStatementCompileStatement;
                }
            }
            if (this.iz != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.iz;
    }

    public SQLiteStatement nr() {
        if (this.x == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.u.compileStatement(a.u(this.nr, this.b));
            synchronized (this) {
                if (this.x == null) {
                    this.x = sQLiteStatementCompileStatement;
                }
            }
            if (this.x != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.x;
    }

    public SQLiteStatement u() {
        if (this.pn == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.u.compileStatement(a.u("INSERT INTO ", this.nr, this.fx));
            synchronized (this) {
                if (this.pn == null) {
                    this.pn = sQLiteStatementCompileStatement;
                }
            }
            if (this.pn != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.pn;
    }
}

package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class fi extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fr f11572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fs f457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Throwable f458a;

    public fi() {
        this.f11572a = null;
        this.f457a = null;
        this.f458a = null;
    }

    public Throwable a() {
        return this.f458a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        fr frVar;
        fs fsVar;
        String message = super.getMessage();
        return (message != null || (fsVar = this.f457a) == null) ? (message != null || (frVar = this.f11572a) == null) ? message : frVar.toString() : fsVar.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        fs fsVar = this.f457a;
        if (fsVar != null) {
            sb.append(fsVar);
        }
        fr frVar = this.f11572a;
        if (frVar != null) {
            sb.append(frVar);
        }
        if (this.f458a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f458a);
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f458a != null) {
            printStream.println("Nested Exception: ");
            this.f458a.printStackTrace(printStream);
        }
    }

    public fi(String str) {
        super(str);
        this.f11572a = null;
        this.f457a = null;
        this.f458a = null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f458a != null) {
            printWriter.println("Nested Exception: ");
            this.f458a.printStackTrace(printWriter);
        }
    }

    public fi(Throwable th) {
        this.f11572a = null;
        this.f457a = null;
        this.f458a = th;
    }

    public fi(fr frVar) {
        this.f457a = null;
        this.f458a = null;
        this.f11572a = frVar;
    }

    public fi(String str, Throwable th) {
        super(str);
        this.f11572a = null;
        this.f457a = null;
        this.f458a = th;
    }
}

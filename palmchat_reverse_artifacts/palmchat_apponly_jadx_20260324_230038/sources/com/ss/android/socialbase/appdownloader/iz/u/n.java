package com.ss.android.socialbase.appdownloader.iz.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n extends Exception {
    protected int fx;
    protected int nr;
    protected Throwable u;

    public n(String str, x xVar, Throwable th) {
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        if (str == null) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        sb.append(str2);
        if (xVar == null) {
            str3 = "";
        } else {
            str3 = "(position:" + xVar.b() + ") ";
        }
        sb.append(str3);
        if (th != null) {
            str4 = "caused by: " + th;
        }
        sb.append(str4);
        super(sb.toString());
        this.nr = -1;
        this.fx = -1;
        if (xVar != null) {
            this.nr = xVar.fx();
            this.fx = xVar.iz();
        }
        this.u = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.u == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
        }
    }
}

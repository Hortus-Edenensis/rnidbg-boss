package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class r87 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f20416a;

    public r87(Context context, String str, int i) {
        this.f20416a = context.getSharedPreferences(str, i);
    }

    public void a(String str, int i) {
        SharedPreferences.Editor editorEdit = this.f20416a.edit();
        editorEdit.putInt(str, i);
        editorEdit.apply();
    }

    public void b(String str, long j) {
        SharedPreferences.Editor editorEdit = this.f20416a.edit();
        editorEdit.putLong(str, j);
        editorEdit.apply();
    }

    public void c(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f20416a.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public int d(String str, int i) {
        return this.f20416a.getInt(str, i);
    }

    public String e(String str) {
        return this.f20416a.getString(str, "");
    }

    public int f(String str) {
        return this.f20416a.getInt(str, 0);
    }

    public long g(String str) {
        return this.f20416a.getLong(str, 0L);
    }
}

package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class l16 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f18888a;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f18889a;
        public SharedPreferences b;

        public a(Context context) {
            this.b = null;
            this.f18889a = context;
            this.b = xp3.c("sp_tray_transfer");
        }

        public final Object c(String str, Object obj) {
            try {
                SharedPreferences sharedPreferencesD = d();
                if (obj instanceof String) {
                    obj = sharedPreferencesD.getString(str, (String) obj);
                } else if (obj instanceof Integer) {
                    obj = Integer.valueOf(sharedPreferencesD.getInt(str, ((Integer) obj).intValue()));
                } else if (obj instanceof Long) {
                    obj = Long.valueOf(sharedPreferencesD.getLong(str, ((Long) obj).longValue()));
                } else if (obj instanceof Float) {
                    obj = Float.valueOf(sharedPreferencesD.getFloat(str, ((Float) obj).floatValue()));
                } else if (obj instanceof Boolean) {
                    obj = Boolean.valueOf(sharedPreferencesD.getBoolean(str, ((Boolean) obj).booleanValue()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("TraySpDataHelper", "getKeyImp end key=" + str + " result =" + obj);
            return obj;
        }

        public final SharedPreferences d() {
            return this.b;
        }

        public final void e(String str, Object obj) {
            try {
                SharedPreferences.Editor editorEdit = d().edit();
                if (obj instanceof String) {
                    editorEdit.putString(str, (String) obj);
                } else if (obj instanceof Integer) {
                    editorEdit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    editorEdit.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Float) {
                    editorEdit.putFloat(str, ((Float) obj).floatValue());
                } else if (obj instanceof Boolean) {
                    editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
                }
                editorEdit.apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("TraySpDataHelper", "put end key=" + str + " value =" + obj);
        }
    }

    public l16(Context context) {
        this.f18888a = null;
        this.f18888a = new a(context);
    }

    public boolean a(@NonNull String str, boolean z) {
        return ((Boolean) this.f18888a.c(str, Boolean.valueOf(z))).booleanValue();
    }

    public int b(@NonNull String str, int i) {
        return ((Integer) this.f18888a.c(str, Integer.valueOf(i))).intValue();
    }

    public long c(@NonNull String str, long j) {
        return ((Long) this.f18888a.c(str, Long.valueOf(j))).longValue();
    }

    @Nullable
    public String d(@NonNull String str) {
        return (String) this.f18888a.c(str, "");
    }

    @Nullable
    public String e(@NonNull String str, @Nullable String str2) {
        return (String) this.f18888a.c(str, str2);
    }

    public void f(@NonNull String str, int i) {
        this.f18888a.e(str, Integer.valueOf(i));
    }

    public void g(@NonNull String str, long j) {
        this.f18888a.e(str, Long.valueOf(j));
    }

    public void h(@NonNull String str, @Nullable String str2) {
        this.f18888a.e(str, str2);
    }

    public void i(@NonNull String str, boolean z) {
        this.f18888a.e(str, Boolean.valueOf(z));
    }
}

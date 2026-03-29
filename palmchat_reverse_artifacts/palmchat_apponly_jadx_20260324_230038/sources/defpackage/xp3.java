package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.mmkv.MMKV;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class xp3 implements SharedPreferences {
    public static HashMap<String, xp3> d = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MMKV f22029a;
    public String b;
    public a c;

    public xp3(String str) {
        this(str, 0);
    }

    public static final xp3 c(String str) {
        xp3 xp3Var = d.get(str);
        if (xp3Var != null) {
            return xp3Var;
        }
        xp3 xp3Var2 = new xp3(str);
        d.put(str, xp3Var2);
        return xp3Var2;
    }

    public static void e(Context context) {
        long jB = ir5.b();
        Log.i("MmkvSpWrapper", "rootDir=" + MMKV.initialize(context) + " time =" + ir5.e(jB));
    }

    public final boolean a(String str) {
        long jB = ir5.b();
        boolean z = MMKV.mmkvWithID("ImportStatus").getBoolean(str, false);
        if (!z) {
            MMKV.mmkvWithID("ImportStatus").putBoolean(str, true);
            this.f22029a.importFromSharedPreferences(c.b().getSharedPreferences(str, 0));
        }
        LogUtil.i("MmkvSpWrapper", "checkAndImportOldData_name=" + str + " result =" + z + " time =" + ir5.e(jB));
        return z;
    }

    public String[] b() {
        return this.f22029a.allKeys();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f22029a.contains(str);
    }

    public void d(SharedPreferences sharedPreferences) {
        this.f22029a.importFromSharedPreferences(sharedPreferences);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        if (this.c == null) {
            this.c = new a(this.f22029a.edit());
        }
        return this.c;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return !nl0.k() ? this.f22029a.getAll() : new HashMap();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        LogUtil.i("MmkvSpWrapper", "getBoolean " + this.b + " key=" + str);
        return this.f22029a.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        LogUtil.i("MmkvSpWrapper", "getFloat " + this.b + " key=" + str);
        return this.f22029a.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        LogUtil.i("MmkvSpWrapper", "getInt " + this.b + " key=" + str);
        return this.f22029a.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        LogUtil.i("MmkvSpWrapper", "getLong " + this.b + " key=" + str);
        return this.f22029a.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        LogUtil.i("MmkvSpWrapper", "getString " + this.b + " key=" + str);
        return this.f22029a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f22029a.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f22029a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f22029a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public xp3(String str, int i) {
        this.b = str;
        this.f22029a = MMKV.mmkvWithID(str, i);
        a(str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SharedPreferences.Editor f22030a;

        public a(SharedPreferences.Editor editor) {
            this.f22030a = editor;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f22030a.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f22030a.putBoolean(str, z);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            this.f22030a.putFloat(str, f);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            this.f22030a.putInt(str, i);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            this.f22030a.putLong(str, j);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            this.f22030a.putString(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            this.f22030a.putStringSet(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.f22030a.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }
    }
}

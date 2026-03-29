package defpackage;

import android.content.SharedPreferences;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.location.LocationEx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qu3 {
    public static String a() {
        SharedPreferences sharedPreferences = c.b().getSharedPreferences("nest_ad_location_sp", 0);
        return sharedPreferences != null ? sharedPreferences.getString("location_latitude", "") : "";
    }

    public static String b() {
        SharedPreferences sharedPreferences = c.b().getSharedPreferences("nest_ad_location_sp", 0);
        return sharedPreferences != null ? sharedPreferences.getString("location_longitude", "") : "";
    }

    public static void c(LocationEx locationEx) {
        SharedPreferences sharedPreferences;
        if (locationEx == null || (sharedPreferences = c.b().getSharedPreferences("nest_ad_location_sp", 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString("location_longitude", Double.valueOf(locationEx.getLongitude()).toString()).apply();
        sharedPreferences.edit().putString("location_latitude", Double.valueOf(locationEx.getLatitude()).toString()).apply();
        sharedPreferences.edit().putLong("location_received_time", System.currentTimeMillis()).apply();
    }
}

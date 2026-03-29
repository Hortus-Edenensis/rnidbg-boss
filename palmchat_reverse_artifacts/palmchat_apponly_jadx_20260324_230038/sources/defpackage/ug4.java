package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.kuaishou.weapon.p0.g;
import com.umeng.analytics.pro.dn;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ug4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f21209a = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationManager f21210a;

        public a(LocationManager locationManager) {
            this.f21210a = locationManager;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            this.f21210a.removeUpdates(this);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            this.f21210a.removeUpdates(this);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            this.f21210a.removeUpdates(this);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            this.f21210a.removeUpdates(this);
            ug4.f21209a = true;
        }
    }

    public static boolean b(Activity activity) throws Exception {
        SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        b bVar = new b();
        sensorManager.registerListener(bVar, defaultSensor, 1);
        sensorManager.unregisterListener(bVar, defaultSensor);
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean c(Activity activity) throws Exception {
        f21209a = false;
        LocationManager locationManager = (LocationManager) activity.getSystemService("location");
        List<String> providers = locationManager.getProviders(true);
        if (providers.contains(GeocodeSearch.GPS) || providers.contains("network")) {
            return true;
        }
        if (!locationManager.isProviderEnabled(GeocodeSearch.GPS)) {
            locationManager.requestLocationUpdates(GeocodeSearch.GPS, 0L, 0.0f, new a(locationManager));
        }
        return f21209a;
    }

    public static boolean d(Activity activity) throws Exception {
        Cursor cursorQuery = activity.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        if (cursorQuery == null) {
            return false;
        }
        if (j() && k(cursorQuery, cursorQuery.getColumnIndex("data1"))) {
            cursorQuery.close();
            return false;
        }
        cursorQuery.close();
        return true;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static boolean e(Activity activity) throws Exception {
        TelephonyManager telephonyManager = (TelephonyManager) activity.getSystemService("phone");
        return (TextUtils.isEmpty(telephonyManager.getDeviceId()) && TextUtils.isEmpty(telephonyManager.getSubscriberId())) ? false : true;
    }

    public static boolean f(Activity activity) throws Exception {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath()).listFiles() != null;
    }

    public static boolean g(Activity activity) throws Exception {
        return true;
    }

    public static boolean h(Activity activity) throws Exception {
        if (!d(activity)) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = activity.getContentResolver();
        long id = ContentUris.parseId(contentResolver.insert(ContactsContract.RawContacts.CONTENT_URI, contentValues));
        contentValues.put("mimetype", "vnd.android.cursor.item/name");
        contentValues.put("raw_contact_id", Long.valueOf(id));
        contentValues.put("data2", "permissions4m");
        contentValues.put("data1", "1");
        contentResolver.insert(ContactsContract.Data.CONTENT_URI, contentValues);
        Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
        ContentResolver contentResolver2 = activity.getContentResolver();
        Cursor cursorQuery = contentResolver2.query(uri, new String[]{"_id"}, "display_name=?", new String[]{"permissions4m"}, null);
        if (cursorQuery == null) {
            return true;
        }
        if (cursorQuery.moveToFirst()) {
            int i = cursorQuery.getInt(0);
            contentResolver2.delete(uri, "display_name=?", new String[]{"permissions4m"});
            contentResolver2.delete(Uri.parse("content://com.android.contacts/data"), "raw_contact_id=?", new String[]{i + ""});
        }
        cursorQuery.close();
        return true;
    }

    public static boolean i(Activity activity) throws Exception {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath(), "permissions4m");
        if (file.exists()) {
            return file.delete();
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean j() {
        return true;
    }

    public static boolean k(Cursor cursor, int i) {
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                if (!TextUtils.isEmpty(cursor.getString(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean l(Activity activity, String str) {
        byte b2;
        try {
            switch (str.hashCode()) {
                case -1888586689:
                    b2 = !str.equals(g.g) ? (byte) -1 : (byte) 11;
                    break;
                case -1479758289:
                    if (str.equals("android.permission.RECEIVE_WAP_PUSH")) {
                        b2 = 15;
                        break;
                    }
                    break;
                case -1238066820:
                    if (str.equals("android.permission.BODY_SENSORS")) {
                        b2 = 8;
                        break;
                    }
                    break;
                case -895679497:
                    if (str.equals("android.permission.RECEIVE_MMS")) {
                        b2 = 16;
                        break;
                    }
                    break;
                case -895673731:
                    if (str.equals("android.permission.RECEIVE_SMS")) {
                        b2 = 17;
                        break;
                    }
                    break;
                case -406040016:
                    if (str.equals(g.i)) {
                        b2 = 12;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals(g.h)) {
                        b2 = 10;
                        break;
                    }
                    break;
                case -5573545:
                    if (str.equals(g.c)) {
                        b2 = 3;
                        break;
                    }
                    break;
                case 112197485:
                    if (str.equals("android.permission.CALL_PHONE")) {
                        b2 = 4;
                        break;
                    }
                    break;
                case 214526995:
                    if (str.equals("android.permission.WRITE_CONTACTS")) {
                        b2 = 1;
                        break;
                    }
                    break;
                case 463403621:
                    if (str.equals("android.permission.CAMERA")) {
                        b2 = 9;
                        break;
                    }
                    break;
                case 784519842:
                    if (str.equals("android.permission.USE_SIP")) {
                        b2 = 5;
                        break;
                    }
                    break;
                case 952819282:
                    if (str.equals("android.permission.PROCESS_OUTGOING_CALLS")) {
                        b2 = 6;
                        break;
                    }
                    break;
                case 1271781903:
                    if (str.equals(g.f)) {
                        b2 = 2;
                        break;
                    }
                    break;
                case 1365911975:
                    if (str.equals(g.j)) {
                        b2 = dn.k;
                        break;
                    }
                    break;
                case 1831139720:
                    if (str.equals("android.permission.RECORD_AUDIO")) {
                        b2 = dn.l;
                        break;
                    }
                    break;
                case 1977429404:
                    if (str.equals("android.permission.READ_CONTACTS")) {
                        b2 = 0;
                        break;
                    }
                    break;
                case 2133799037:
                    if (str.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
                        b2 = 7;
                        break;
                    }
                    break;
                default:
                    break;
            }
            if (b2 == 0) {
                return d(activity);
            }
            if (b2 == 1) {
                return h(activity);
            }
            if (b2 == 3) {
                return e(activity);
            }
            if (b2 == 8) {
                return b(activity);
            }
            switch (b2) {
                case 10:
                case 11:
                    return c(activity);
                case 12:
                    return f(activity);
                case 13:
                    return i(activity);
                case 14:
                    return g(activity);
                default:
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("permissions4m", "throwing exception in PermissionChecker:  ", e);
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }
}

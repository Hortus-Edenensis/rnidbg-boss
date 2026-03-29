package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.cdadata.sdk.api.ZMDataSDKManager;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class r57 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f20397a;
    public static final char[] b = "0123456789ABCDEF".toCharArray();

    public static String a() {
        String strSubstring = "";
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = ZMDataSDKManager.getInstance().getContext().getContentResolver().query(MediaStore.Files.getContentUri("external"), null, "_display_name like '%_system_sdk_udid.m3u8%' ", null, "date_added desc");
                if (cursorQuery != null && cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    if (string.indexOf("_system_sdk_udid.m3u8") != -1) {
                        strSubstring = string.substring(0, string.indexOf("_"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return strSubstring;
        } catch (Throwable th) {
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            char[] cArr2 = b;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static void c(String str) throws IOException {
        if (TextUtils.isEmpty(a())) {
            String.format("%s/system/", Environment.DIRECTORY_DOWNLOADS);
            String str2 = String.format("%s/system/", Environment.DIRECTORY_DOCUMENTS);
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str + "_system_sdk_udid.m3u8");
            contentValues.put("relative_path", str2);
            Uri uriInsert = ZMDataSDKManager.getInstance().getContext().getContentResolver().insert(MediaStore.Files.getContentUri("external"), contentValues);
            if (uriInsert != null) {
                OutputStream outputStreamOpenOutputStream = ZMDataSDKManager.getInstance().getContext().getContentResolver().openOutputStream(uriInsert);
                Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888).compress(Bitmap.CompressFormat.PNG, 100, outputStreamOpenOutputStream);
                outputStreamOpenOutputStream.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d() throws Throwable {
        if (!l67.a(ZMDataSDKManager.getInstance().getContext(), g.j) || !l67.a(ZMDataSDKManager.getInstance().getContext(), g.i)) {
            return "";
        }
        if (Build.VERSION.SDK_INT > 29) {
            String strC = r67.a().c("cid", "");
            if (TextUtils.isEmpty(strC)) {
                strC = a();
                if (TextUtils.isEmpty(strC)) {
                    strC = e67.d(UUID.randomUUID().toString());
                }
            }
            try {
                c(strC);
                r67 r67VarA = r67.a();
                synchronized (r67VarA) {
                    r67VarA.f20404a.edit().putString("cid", strC).apply();
                }
                return strC;
            } catch (IOException unused) {
                return "";
            }
        }
        String strC2 = r67.a().c("cid", "");
        if (TextUtils.isEmpty(strC2)) {
            String str = a57.b;
            try {
            } catch (Exception e) {
                g57.d("SDCardStorage", e);
            }
            if (a57.a()) {
                File file = new File(str);
                strC2 = file.exists() ? e67.b(file) : "";
                if (TextUtils.isEmpty(strC2)) {
                    strC2 = e67.d(UUID.randomUUID().toString());
                }
            }
        }
        String str2 = a57.b;
        try {
            if (a57.a()) {
                File file2 = new File(a57.f1158a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                e67.j(new File(str2), strC2);
            }
        } catch (Exception e2) {
            g57.d("SDCardStorage", e2);
        }
        r67 r67VarA2 = r67.a();
        synchronized (r67VarA2) {
            r67VarA2.f20404a.edit().putString("cid", strC2).apply();
        }
        return strC2;
    }
}

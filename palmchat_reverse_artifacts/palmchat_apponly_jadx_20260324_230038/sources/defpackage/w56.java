package defpackage;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.kuaishou.weapon.p0.t;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class w56 {
    /* JADX WARN: Removed duplicated region for block: B:131:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, Uri uri, String str) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptor;
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel2;
        FileInputStream fileInputStream;
        FileChannel fileChannel3;
        FileOutputStream fileOutputStream2;
        FileChannel fileChannel4;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        String str2;
        FileChannel fileChannel5;
        FileChannel fileChannel6;
        FileOutputStream fileOutputStream3;
        FileChannel fileChannel7;
        FileInputStream fileInputStream2;
        FileChannel channel;
        FileOutputStream fileOutputStream4;
        FileChannel channel2;
        FileInputStream fileInputStream3 = null;
        fileInputStream3 = null;
        FileInputStream fileInputStream4 = null;
        str = null;
        str = null;
        String str3 = null;
        try {
        } catch (Exception e) {
            e = e;
            parcelFileDescriptor = null;
            fileInputStream = null;
            fileChannel3 = null;
            fileOutputStream2 = null;
            fileChannel4 = null;
        } catch (Throwable th) {
            th = th;
            parcelFileDescriptor = null;
            fileChannel = null;
            fileOutputStream = null;
            fileChannel2 = null;
        }
        if (TextUtils.isEmpty(str)) {
            parcelFileDescriptorOpenFileDescriptor = null;
            str2 = null;
            fileChannel5 = null;
        } else {
            str2 = pu1.f + File.separator + rb3.c(uri.toString());
            if (pu1.g(str2) != 1) {
                LogUtil.i("UriUtils", "getDataColumn  getContentFilePath not exist=" + str2);
                parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, t.k);
                try {
                    fileInputStream2 = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        channel = fileInputStream2.getChannel();
                    } catch (Exception e2) {
                        e = e2;
                        channel = null;
                        fileOutputStream4 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        channel = null;
                        fileOutputStream4 = null;
                    }
                    try {
                        fileOutputStream4 = new FileOutputStream(str2);
                        try {
                            channel2 = fileOutputStream4.getChannel();
                        } catch (Exception e3) {
                            e = e3;
                            channel2 = null;
                        } catch (Throwable th3) {
                            th = th3;
                            channel2 = null;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileOutputStream4 = null;
                        channel = channel;
                        channel2 = fileOutputStream4;
                        parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                        e = e;
                        fileInputStream = fileInputStream2;
                        fileChannel3 = channel;
                        fileOutputStream2 = fileOutputStream4;
                        fileChannel4 = channel2;
                        try {
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (fileChannel3 != null) {
                                try {
                                    fileChannel3.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (fileChannel4 != null) {
                                try {
                                    fileChannel4.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            if (parcelFileDescriptor != null) {
                                try {
                                    parcelFileDescriptor.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            LogUtil.i("UriUtils", "getDataColumn  getContentFilePath final=" + str3);
                            return str3;
                        } catch (Throwable th4) {
                            th = th4;
                            fileInputStream3 = fileInputStream;
                            fileChannel = fileChannel3;
                            fileOutputStream = fileOutputStream2;
                            fileChannel2 = fileChannel4;
                            if (fileInputStream3 != null) {
                                try {
                                    fileInputStream3.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                            }
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                }
                            }
                            if (fileChannel2 != null) {
                                try {
                                    fileChannel2.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                            }
                            if (parcelFileDescriptor == null) {
                                throw th;
                            }
                            try {
                                parcelFileDescriptor.close();
                                throw th;
                            } catch (IOException e14) {
                                e14.printStackTrace();
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream4 = null;
                        channel = channel;
                        channel2 = fileOutputStream4;
                        fileInputStream3 = fileInputStream2;
                        parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                        th = th;
                        fileChannel = channel;
                        fileOutputStream = fileOutputStream4;
                        fileChannel2 = channel2;
                        if (fileInputStream3 != null) {
                        }
                        if (fileChannel != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (fileChannel2 != null) {
                        }
                        if (parcelFileDescriptor == null) {
                        }
                    }
                } catch (Exception e15) {
                    fileInputStream = null;
                    fileChannel3 = null;
                    fileOutputStream2 = null;
                    fileChannel4 = null;
                    parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                    e = e15;
                } catch (Throwable th6) {
                    fileChannel = null;
                    fileOutputStream = null;
                    fileChannel2 = null;
                    parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                    th = th6;
                }
                try {
                    channel.transferTo(0L, channel.size(), channel2);
                    if (pu1.g(str2) <= 0) {
                        str2 = null;
                    }
                    fileInputStream4 = fileInputStream2;
                    fileChannel7 = channel;
                    fileOutputStream3 = fileOutputStream4;
                    fileChannel6 = channel2;
                    if (fileInputStream4 != null) {
                        try {
                            fileInputStream4.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                    if (fileChannel7 != null) {
                        try {
                            fileChannel7.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                    if (fileOutputStream3 != null) {
                        try {
                            fileOutputStream3.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    if (fileChannel6 != null) {
                        try {
                            fileChannel6.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (IOException e20) {
                            e20.printStackTrace();
                        }
                    }
                    str3 = str2;
                } catch (Exception e21) {
                    e = e21;
                    parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                    e = e;
                    fileInputStream = fileInputStream2;
                    fileChannel3 = channel;
                    fileOutputStream2 = fileOutputStream4;
                    fileChannel4 = channel2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                    }
                    if (fileChannel3 != null) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    if (fileChannel4 != null) {
                    }
                    if (parcelFileDescriptor != null) {
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream3 = fileInputStream2;
                    parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                    th = th;
                    fileChannel = channel;
                    fileOutputStream = fileOutputStream4;
                    fileChannel2 = channel2;
                    if (fileInputStream3 != null) {
                    }
                    if (fileChannel != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    if (fileChannel2 != null) {
                    }
                    if (parcelFileDescriptor == null) {
                    }
                }
                LogUtil.i("UriUtils", "getDataColumn  getContentFilePath final=" + str3);
                return str3;
            }
            LogUtil.i("UriUtils", "getDataColumn  getContentFilePath exist=" + str2);
            parcelFileDescriptorOpenFileDescriptor = null;
            fileChannel5 = null;
        }
        FileChannel fileChannel8 = fileChannel5;
        fileChannel6 = fileChannel8;
        fileChannel7 = fileChannel5;
        fileOutputStream3 = fileChannel8;
        if (fileInputStream4 != null) {
        }
        if (fileChannel7 != null) {
        }
        if (fileOutputStream3 != null) {
        }
        if (fileChannel6 != null) {
        }
        if (parcelFileDescriptorOpenFileDescriptor != null) {
        }
        str3 = str2;
        LogUtil.i("UriUtils", "getDataColumn  getContentFilePath final=" + str3);
        return str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        ?? r7 = 0;
        string = null;
        string = null;
        string = null;
        String string = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (cursorQuery != null) {
                        }
                        LogUtil.i("UriUtils", "getDataColumn " + string);
                        if (pu1.g(string) == 1) {
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                r7 = str;
                if (r7 != 0) {
                    r7.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r7 != 0) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        LogUtil.i("UriUtils", "getDataColumn " + string);
        return pu1.g(string) == 1 ? a(context, uri, string) : string;
    }

    public static String c(Uri uri, Context context) {
        List<PackageInfo> installedPackages;
        if ((uri != null && !uri.toString().contains("/storage/emulated/0/")) || (installedPackages = context.getPackageManager().getInstalledPackages(8)) == null) {
            return null;
        }
        String name = FileProvider.class.getName();
        Iterator<PackageInfo> it = installedPackages.iterator();
        String absolutePath = null;
        while (it.hasNext()) {
            ProviderInfo[] providerInfoArr = it.next().providers;
            if (providerInfoArr != null) {
                int length = providerInfoArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        ProviderInfo providerInfo = providerInfoArr[i];
                        if (!uri.getAuthority().equals(providerInfo.authority)) {
                            i++;
                        } else if (providerInfo.name.equalsIgnoreCase(name)) {
                            try {
                                Method declaredMethod = FileProvider.class.getDeclaredMethod("getPathStrategy", Context.class, String.class);
                                declaredMethod.setAccessible(true);
                                Object objInvoke = declaredMethod.invoke(null, context, uri.getAuthority());
                                if (objInvoke != null) {
                                    Method declaredMethod2 = Class.forName(FileProvider.class.getName() + "$PathStrategy").getDeclaredMethod("getFileForUri", Uri.class);
                                    declaredMethod2.setAccessible(true);
                                    Object objInvoke2 = declaredMethod2.invoke(objInvoke, uri);
                                    if (objInvoke2 instanceof File) {
                                        absolutePath = ((File) objInvoke2).getAbsolutePath();
                                    }
                                }
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (NoSuchMethodException e3) {
                                e3.printStackTrace();
                            } catch (InvocationTargetException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return absolutePath;
    }

    @TargetApi(19)
    public static String d(Context context, Uri uri) {
        long jLongValue;
        Uri uri2 = null;
        if (context != null && uri != null) {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (f(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (e(uri)) {
                        try {
                            jLongValue = Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue();
                        } catch (Exception unused) {
                            jLongValue = 0;
                        }
                        return b(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), jLongValue), null, null);
                    }
                    if (h(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if ("video".equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else if ("audio".equals(str)) {
                            uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        return b(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    if (g(uri)) {
                        return uri.getLastPathSegment();
                    }
                    String strC = c(uri, AppContext.getContext());
                    return !TextUtils.isEmpty(strC) ? strC : b(context, uri, null, null);
                }
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            }
        }
        return null;
    }

    public static boolean e(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean f(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean g(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean h(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}

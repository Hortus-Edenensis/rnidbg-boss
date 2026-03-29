package org.apache.cordova;

import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.oplus.tblplayer.Constants;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class FileHelper {
    private static final String LOG_TAG = "FileUtils";
    private static final String _DATA = "_data";

    public static InputStream getInputStreamFromUriString(String str, CordovaInterface cordovaInterface) throws IOException {
        if (str.startsWith("content")) {
            return cordovaInterface.getActivity().getContentResolver().openInputStream(Uri.parse(str));
        }
        if (!str.startsWith("file://")) {
            return new FileInputStream(getRealPath(str, cordovaInterface));
        }
        int iIndexOf = str.indexOf(Constants.STRING_VALUE_UNSET);
        if (iIndexOf > -1) {
            str = str.substring(0, iIndexOf);
        }
        if (!str.startsWith("file:///android_asset/")) {
            return new FileInputStream(getRealPath(str, cordovaInterface));
        }
        return cordovaInterface.getActivity().getAssets().open(Uri.parse(str).getPath().substring(15));
    }

    public static String getMimeType(String str, CordovaInterface cordovaInterface) {
        Uri uri = Uri.parse(str);
        return str.startsWith("content://") ? cordovaInterface.getActivity().getContentResolver().getType(uri) : getMimeTypeForExtension(uri.getPath());
    }

    public static String getMimeTypeForExtension(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            str = str.substring(iLastIndexOf + 1);
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.equals("3ga") ? "audio/3gpp" : MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
    }

    public static String getRealPath(String str, CordovaInterface cordovaInterface) {
        String strSubstring;
        if (str.startsWith("content://")) {
            Cursor cursorManagedQuery = cordovaInterface.getActivity().managedQuery(Uri.parse(str), new String[]{_DATA}, null, null, null);
            int columnIndexOrThrow = cursorManagedQuery.getColumnIndexOrThrow(_DATA);
            cursorManagedQuery.moveToFirst();
            strSubstring = cursorManagedQuery.getString(columnIndexOrThrow);
            if (strSubstring == null) {
                LOG.e(LOG_TAG, "Could get real path for URI string %s", str);
            }
        } else {
            if (!str.startsWith("file://")) {
                return str;
            }
            strSubstring = str.substring(7);
            if (strSubstring.startsWith("/android_asset/")) {
                LOG.e(LOG_TAG, "Cannot get real path for URI string %s because it is a file:///android_asset/ URI.", str);
                return null;
            }
        }
        return strSubstring;
    }

    public static String stripFileProtocol(String str) {
        return str.startsWith("file://") ? str.substring(7) : str;
    }

    public static String getRealPath(Uri uri, CordovaInterface cordovaInterface) {
        return getRealPath(uri.toString(), cordovaInterface);
    }
}

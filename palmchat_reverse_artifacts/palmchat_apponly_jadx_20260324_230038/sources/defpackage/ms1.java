package defpackage;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ms1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f19356a = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");

    public static MediaItem.ExtractInfo a(String str) {
        Date date;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        MediaItem.ExtractInfo extractInfo = new MediaItem.ExtractInfo();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME);
            String attribute2 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_MODEL);
            float[] fArr = new float[2];
            exifInterface.getLatLong(fArr);
            LogUtil.d("logmedia", "path = " + str);
            LogUtil.d("logmedia", "datetime = " + attribute + ", deviceModel = " + attribute2 + ", lat = " + fArr[0] + ", lng = " + fArr[1]);
            if (!TextUtils.isEmpty(attribute) && (date = f19356a.parse(attribute)) != null) {
                extractInfo.time = date.getTime();
            }
            float f = fArr[0];
            if (f != 0.0f || fArr[1] != 0.0f) {
                extractInfo.lat = f;
                extractInfo.lng = fArr[1];
            }
            extractInfo.deviceModel = attribute2;
            extractInfo.fileTime = new File(str).lastModified();
            return extractInfo;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.d("logmedia", "time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return null;
        }
    }

    public static MediaItem.ExtractInfo b(String str) {
        String strSubstring;
        String strSubstring2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        MediaItem.ExtractInfo extractInfo = new MediaItem.ExtractInfo();
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(23);
            LogUtil.d("logmedia", "path = " + str);
            LogUtil.d("logmedia", "latlng = " + strExtractMetadata);
            if (!TextUtils.isEmpty(strExtractMetadata)) {
                char[] charArray = strExtractMetadata.toCharArray();
                int i = 0;
                while (true) {
                    if (i >= charArray.length) {
                        strSubstring = null;
                        strSubstring2 = null;
                        break;
                    }
                    char c = charArray[i];
                    if ((c == '+' || c == '-') && i > 0) {
                        strSubstring2 = strExtractMetadata.substring(0, i);
                        strSubstring = TextUtils.isDigitsOnly(strExtractMetadata.substring(charArray.length + (-1))) ? strExtractMetadata.substring(i, charArray.length) : charArray.length + (-1) >= i ? strExtractMetadata.substring(i, charArray.length - 1) : null;
                    } else {
                        i++;
                    }
                }
                if (!TextUtils.isEmpty(strSubstring2) && !TextUtils.isEmpty(strSubstring)) {
                    double d = Double.parseDouble(strSubstring2);
                    double d2 = Double.parseDouble(strSubstring);
                    if (d != 0.0d || d2 != 0.0d) {
                        extractInfo.lat = (float) d;
                        extractInfo.lng = (float) d2;
                        LogUtil.d("logmedia", "lat = " + extractInfo.lat + ", lng = " + extractInfo.lng);
                    }
                }
            }
            extractInfo.time = new File(str).lastModified();
            extractInfo.deviceModel = "unknown";
            return extractInfo;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.d("logmedia", "time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return null;
        }
    }

    public static MediaItem.LocationInfo c(Context context, double d, double d2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            LogUtil.d("logmedia", "getAddress: latitude = " + d + ", longitude = " + d2);
            List<Address> fromLocation = geocoder.getFromLocation(d, d2, 1);
            if (fromLocation == null || fromLocation.size() <= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("getAddress: size = ");
                sb.append(fromLocation != null ? fromLocation.size() : 0);
                sb.append(", time = ");
                sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
                LogUtil.d("logmedia", sb.toString());
                return null;
            }
            Address address = fromLocation.get(0);
            String countryName = address.getCountryName();
            address.getCountryCode();
            String adminArea = address.getAdminArea();
            String locality = address.getLocality();
            String subLocality = address.getSubLocality();
            address.getFeatureName();
            LogUtil.d("logmedia", "getAddress: city = " + countryName + " " + adminArea + " " + locality + " " + subLocality);
            MediaItem.LocationInfo locationInfo = new MediaItem.LocationInfo();
            if (TextUtils.isEmpty(subLocality)) {
                locationInfo.city = adminArea;
                locationInfo.area = locality;
            } else {
                locationInfo.city = locality;
                locationInfo.area = subLocality;
            }
            return locationInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

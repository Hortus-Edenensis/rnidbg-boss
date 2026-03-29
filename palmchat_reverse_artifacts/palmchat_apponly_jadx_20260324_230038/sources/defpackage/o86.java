package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import com.huawei.hms.ads.dynamicloader.b;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.bh;
import com.kuaishou.weapon.p0.t;
import com.oplus.tblplayer.Constants;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import java.io.File;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class o86 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int[] f19713a = {R.drawable.soft_blue_rectangle, R.drawable.soft_green_rectangle, R.drawable.soft_red_rectangle, R.drawable.soft_yellow_rectangle};

    public static String a(String str) {
        return str.replace("/", "").replace(":", "").replace("\\", "").replace("*", "").replace("\"", "").replace(">", "").replace("<", "").replace(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "").replace(Constants.STRING_VALUE_UNSET, "").replace(ContainerUtils.FIELD_DELIMITER, "");
    }

    public static String b(long j) {
        return j < 1024 ? String.format("%d B", Long.valueOf(j)) : j < 1048576 ? String.format("%.1f KB", Float.valueOf(j / 1024.0f)) : j < 1073741824 ? String.format("%.1f MB", Float.valueOf((j / 1024.0f) / 1024.0f)) : String.format("%.1f GB", Float.valueOf(((j / 1024.0f) / 1024.0f) / 1024.0f));
    }

    public static String c(long j) {
        return j < 1024 ? String.format("%d B", Long.valueOf(j)) : j < 1048576 ? String.format("%.1f KB", Float.valueOf(j / 1024.0f)) : j < 1073741824 ? String.format("%.3f MB", Float.valueOf((j / 1024.0f) / 1024.0f)) : String.format("%.3f GB", Float.valueOf(((j / 1024.0f) / 1024.0f) / 1024.0f));
    }

    public static String d(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 - (3600 * j3);
        long j5 = j4 / 60;
        long j6 = j4 - (60 * j5);
        return j3 > 0 ? String.format("%d:%d:%02d", Long.valueOf(j3), Long.valueOf(j5), Long.valueOf(j6)) : String.format("%d:%02d", Long.valueOf(j5), Long.valueOf(j6));
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return Constants.STRING_VALUE_UNSET;
        }
        String[] strArrSplit = str.split("\\.");
        return strArrSplit.length > 1 ? strArrSplit[strArrSplit.length - 1] : Constants.STRING_VALUE_UNSET;
    }

    public static String f(File file) {
        String strG = g(file);
        if (strG == null) {
            return "file/*";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(strG);
        return !TextUtils.isEmpty(mimeTypeFromExtension) ? mimeTypeFromExtension : "file/*";
    }

    public static String g(File file) {
        int iLastIndexOf;
        if (file != null && file.exists() && !file.isDirectory()) {
            String name = file.getName();
            if (!name.equals("") && !name.endsWith(".") && (iLastIndexOf = name.lastIndexOf(".")) != -1) {
                return name.substring(iLastIndexOf + 1).toLowerCase(Locale.US);
            }
        }
        return null;
    }

    public static int h(String str) {
        String strE = e(str);
        return (strE == null || strE.length() == 0 || strE.equals(Constants.STRING_VALUE_UNSET)) ? R.drawable.ic_unknown_page : strE.equals("apk") ? R.drawable.ic_apk : strE.equals("ipa") ? R.drawable.ic_ios : strE.equals("pdf") ? R.drawable.ic_pdf : strE.equals("psd") ? R.drawable.ic_psd : (strE.equals("zip") || strE.equals("rar")) ? R.drawable.ic_zip : (strE.equals("txt") || strE.equals("html") || strE.equals("htm")) ? R.drawable.ic_txt : (strE.equals("jpg") || strE.equals(bh.V) || strE.equals("png") || strE.equals("jpeg") || strE.equals("bmp") || strE.equals("tif") || strE.equals("tiff")) ? R.drawable.ic_pic : (strE.equals("doc") || strE.equals("docx")) ? R.drawable.ic_word : (strE.equals("ppt") || strE.equals("pptx") || strE.equals("key")) ? R.drawable.ic_ppt : (strE.equals("xls") || strE.equals("xlsx")) ? R.drawable.ic_excel : (strE.equals("m4a") || strE.equals("mp3") || strE.equals("mid") || strE.equals("xmf") || strE.equals("ogg") || strE.equals("wav") || strE.equals("wma")) ? R.drawable.ic_music : (strE.equals("3gp") || strE.equals("mp4") || strE.equals("mov") || strE.equals("avi") || strE.equals("ram") || strE.equals(t.w) || strE.equals("rmvb") || strE.equals("wmv") || strE.equals("mkv") || strE.equals("swf") || strE.equals("mpeg")) ? R.drawable.ic_mp4 : R.drawable.file_blue_rectangle;
    }

    public static boolean i(MessageVo messageVo) {
        if (messageVo != null) {
            return !TextUtils.isEmpty(messageVo.data2) || j(messageVo);
        }
        return false;
    }

    public static boolean j(MessageVo messageVo) {
        if (messageVo == null) {
            return false;
        }
        File file = !TextUtils.isEmpty(messageVo.data1) ? new File(messageVo.data1) : null;
        return file != null && file.exists();
    }

    public static boolean k(String str) {
        File file = !TextUtils.isEmpty(str) ? new File(str) : null;
        return file != null && file.exists();
    }

    public static boolean l(Context context, String str) {
        File file = new File(str);
        if (file.exists() && !file.isDirectory()) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!str.toLowerCase().endsWith(b.b) || Build.VERSION.SDK_INT >= 25) {
                    intent.setDataAndType(FileProvider.getUriForFile(AppContext.getContext(), "com.zenmen.palmchat.webplatform.file.provider", file), f(file));
                    intent.addFlags(3);
                } else {
                    intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
                }
                intent.addFlags(268435456);
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    Intent intent2 = new Intent();
                    intent2.addFlags(268435456);
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setDataAndType(Uri.fromFile(file), f(file));
                    context.startActivity(intent2);
                    return true;
                } catch (Exception unused) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}

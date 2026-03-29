package defpackage;

import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class hn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f17999a = Boolean.FALSE;
    public static Boolean b = Boolean.TRUE;
    public static char c = 'v';
    public static String d = Environment.getExternalStorageDirectory().getPath() + File.separator + "wifilog";
    public static int e = 0;
    public static String f = "Log.txt";
    public static SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd");

    public static void a(String str, String str2) {
        b(str, str2, 'd');
    }

    public static void b(String str, String str2, char c2) {
        char c3;
        char c4;
        char c5;
        char c6;
        if (f17999a.booleanValue()) {
            if ('e' == c2 && ('e' == (c6 = c) || 'v' == c6)) {
                Log.e(str, str2);
            } else if ('w' == c2 && ('w' == (c5 = c) || 'v' == c5)) {
                Log.w(str, str2);
            } else if ('d' == c2 && ('d' == (c4 = c) || 'v' == c4)) {
                Log.d(str, str2);
            } else if ('i' == c2 && ('d' == (c3 = c) || 'v' == c3)) {
                Log.i(str, str2);
            } else {
                Log.v(str, str2);
            }
            if (b.booleanValue()) {
                c(String.valueOf(c2), str, str2);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Date date = new Date();
        String str4 = h.format(date);
        String str5 = g.format(date) + "    " + str + "    " + str2 + "    " + str3;
        File file = new File(d);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        try {
            FileWriter fileWriter = new FileWriter(new File(d, str4 + f), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str5);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}

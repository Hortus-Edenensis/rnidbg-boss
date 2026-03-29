package cn.fly.verify;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import cn.fly.verify.fq;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fz {
    public static File a(Context context, String str) {
        try {
            String strG = g(context);
            if (strG == null) {
                return null;
            }
            File file = new File(strG, str);
            if (!file.getParentFile().exists() || !file.getParentFile().isDirectory()) {
                file.getParentFile().delete();
                file.getParentFile().mkdirs();
            }
            return file;
        } catch (Throwable th) {
            en.a().b(th);
            return null;
        }
    }

    public static File b(Context context, String str) {
        return a(context, str, false);
    }

    public static int c(Context context) {
        return b(context)[0];
    }

    public static int d(Context context) {
        return b(context)[1];
    }

    public static double e(Context context) {
        try {
            int iC = c(context);
            int iD = d(context);
            float[] fArrA = a(context);
            if (fArrA == null || fArrA.length != 2) {
                return 0.0d;
            }
            double d = iC / fArrA[0];
            double d2 = iD / fArrA[1];
            return new BigDecimal(Math.sqrt((d * d) + (d2 * d2))).setScale(1, 4).doubleValue();
        } catch (Throwable th) {
            en.a().a(th);
            return 0.0d;
        }
    }

    public static int f(Context context) {
        try {
            int iC = c(context);
            int iD = d(context);
            return (int) Math.round(Math.sqrt((iC * iC) + (iD * iD)) / e(context));
        } catch (Throwable th) {
            en.a().a(th);
            return 0;
        }
    }

    public static String g(Context context) {
        return a(context, false);
    }

    public static String h(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + bq.a("001m") + "fvv";
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return str;
    }

    public static File a(Context context, String str, boolean z) {
        File file = new File(h(context), str);
        if (z && !file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
        return file;
    }

    public static byte[] b(File file) {
        FileChannel channel;
        FileInputStream fileInputStream;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    channel = fileInputStream.getChannel();
                    try {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) channel.size());
                        while (channel.read(byteBufferAllocate) > 0) {
                        }
                        byte[] bArrArray = byteBufferAllocate.array();
                        eg.a(channel, fileInputStream);
                        return bArrArray;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            en.a().a(th);
                            eg.a(channel, fileInputStream);
                            return null;
                        } catch (Throwable th2) {
                            eg.a(channel, fileInputStream);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    channel = null;
                }
            } catch (Throwable th4) {
                th = th4;
                channel = null;
                fileInputStream = null;
            }
        }
        return null;
    }

    public static <T> T a(Object obj) {
        return (T) a(obj, (Object) null);
    }

    public static int[] b(Context context) {
        WindowManager windowManager;
        Display defaultDisplay = null;
        try {
            windowManager = (WindowManager) fq.d.a("window");
        } catch (Throwable th) {
            en.a().b(th);
            windowManager = null;
        }
        if (windowManager == null) {
            return new int[]{0, 0};
        }
        try {
            defaultDisplay = windowManager.getDefaultDisplay();
        } catch (Throwable th2) {
            en.a().b(th2);
        }
        try {
            if (defaultDisplay == null) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
            }
            Point point = new Point();
            Method method = defaultDisplay.getClass().getMethod(bq.a("011OffBgjQhj%gehJfkejhdSg"), Point.class);
            method.setAccessible(true);
            method.invoke(defaultDisplay, point);
            return new int[]{point.x, point.y};
        } catch (Throwable th3) {
            en.a().b(th3);
            return new int[]{0, 0};
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(Object obj, T t) {
        if (obj != 0) {
            try {
                if (obj instanceof Integer) {
                    return t instanceof Long ? (T) Long.valueOf(((Integer) obj).intValue()) : obj;
                }
                return obj;
            } catch (Throwable unused) {
            }
        }
        return t;
    }

    public static Object a(String str) {
        File file;
        GZIPInputStream gZIPInputStream;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        if (!TextUtils.isEmpty(str)) {
            try {
                file = new File(str);
            } catch (Throwable th) {
                en.a().a(th);
            }
            if (!file.exists()) {
                file = null;
            }
            if (file != null) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        gZIPInputStream = new GZIPInputStream(fileInputStream);
                        try {
                            objectInputStream = new ObjectInputStream(gZIPInputStream);
                            try {
                                Object object = objectInputStream.readObject();
                                objectInputStream.close();
                                eg.a(objectInputStream, gZIPInputStream, fileInputStream);
                                return object;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    en.a().a(th);
                                    eg.a(objectInputStream, gZIPInputStream, fileInputStream);
                                    return null;
                                } catch (Throwable th3) {
                                    eg.a(objectInputStream, gZIPInputStream, fileInputStream);
                                    throw th3;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            objectInputStream = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        gZIPInputStream = null;
                        objectInputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    gZIPInputStream = null;
                    fileInputStream = null;
                    objectInputStream = null;
                }
            }
        }
        return null;
    }

    public static String a(Context context, boolean z) {
        String strH;
        if (z) {
            strH = null;
        } else {
            try {
                strH = h(context);
            } catch (Throwable th) {
                en.a().b(th);
                return null;
            }
        }
        String strA = fq.d.a();
        if (strA != null) {
            strH = strA + bq.a("001m") + "fvv";
        }
        if (TextUtils.isEmpty(strH)) {
            return null;
        }
        File file = new File(strH);
        if (!file.exists() || !file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return strH;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r13v11, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.io.Closeable[]] */
    public static ArrayList<HashMap<String, String>> a(String str, boolean z) {
        GZIPInputStream gZIPInputStream;
        InputStreamReader inputStreamReader;
        ?? r10;
        ?? bufferedReader;
        File fileA = a(ax.g(), str, false);
        if (fileA.exists() && fileA.length() > 0) {
            FileInputStream fileInputStream = null;
            try {
                ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
                FileInputStream fileInputStream2 = new FileInputStream(fileA);
                try {
                    gZIPInputStream = new GZIPInputStream(fileInputStream2);
                    try {
                        inputStreamReader = new InputStreamReader(gZIPInputStream, "utf-8");
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        eg.a((Closeable[]) new Closeable[]{bufferedReader, inputStreamReader, gZIPInputStream, fileInputStream2});
                                        return arrayList;
                                    }
                                    if (z) {
                                        line = new String(Base64.decode(line, 2), "utf-8");
                                    }
                                    arrayList.add(fv.a(line));
                                } catch (Throwable th) {
                                    th = th;
                                    fileInputStream = fileInputStream2;
                                    r10 = bufferedReader;
                                    try {
                                        en.a().a(th);
                                        eg.a((Closeable[]) new Closeable[]{r10, inputStreamReader, gZIPInputStream, fileInputStream});
                                        return new ArrayList<>();
                                    } catch (Throwable th2) {
                                        eg.a((Closeable[]) new Closeable[]{r10, inputStreamReader, gZIPInputStream, fileInputStream});
                                        throw th2;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = 0;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStreamReader = null;
                        bufferedReader = inputStreamReader;
                        fileInputStream = fileInputStream2;
                        r10 = bufferedReader;
                        en.a().a(th);
                        eg.a((Closeable[]) new Closeable[]{r10, inputStreamReader, gZIPInputStream, fileInputStream});
                        return new ArrayList<>();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    gZIPInputStream = null;
                    inputStreamReader = null;
                }
            } catch (Throwable th6) {
                th = th6;
                gZIPInputStream = null;
                inputStreamReader = null;
                r10 = 0;
            }
        }
        return new ArrayList<>();
    }

    public static void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            file.delete();
            return;
        }
        for (String str : list) {
            File file2 = new File(file, str);
            if (file2.isDirectory()) {
                a(file2);
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    public static void a(File file, byte[] bArr) {
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        if (file == null || bArr == null) {
            return;
        }
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                en.a().a(e);
            }
        }
        if (file.exists()) {
            FileChannel channel = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileChannel = null;
            }
            try {
                channel = fileOutputStream.getChannel();
                channel.write(ByteBuffer.wrap(bArr));
                channel.force(true);
                eg.a(channel, fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                fileChannel = channel;
                channel = fileOutputStream;
                try {
                    en.a().a(th);
                    eg.a(fileChannel, channel);
                } catch (Throwable th3) {
                    eg.a(fileChannel, channel);
                    throw th3;
                }
            }
        }
    }

    public static void a(ArrayList<HashMap<String, String>> arrayList, String str, boolean z) {
        GZIPOutputStream gZIPOutputStream;
        OutputStreamWriter outputStreamWriter;
        Closeable closeable = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(a(ax.g(), str, true));
            try {
                gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
                try {
                    outputStreamWriter = new OutputStreamWriter(gZIPOutputStream, "utf-8");
                    try {
                        Iterator<HashMap<String, String>> it = arrayList.iterator();
                        while (it.hasNext()) {
                            String strA = fv.a((HashMap) it.next());
                            if (z) {
                                strA = new String(Base64.encode(strA.getBytes("utf-8"), 2), "utf-8");
                            }
                            outputStreamWriter.append((CharSequence) strA).append('\n');
                        }
                        eg.a(outputStreamWriter, gZIPOutputStream, fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        closeable = fileOutputStream;
                        try {
                            en.a().a(th);
                            eg.a(outputStreamWriter, gZIPOutputStream, closeable);
                        } catch (Throwable th2) {
                            eg.a(outputStreamWriter, gZIPOutputStream, closeable);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStreamWriter = null;
                }
            } catch (Throwable th4) {
                th = th4;
                gZIPOutputStream = null;
                outputStreamWriter = null;
            }
        } catch (Throwable th5) {
            th = th5;
            gZIPOutputStream = null;
            outputStreamWriter = null;
        }
    }

    public static boolean a(String str, Object obj) {
        File file;
        GZIPOutputStream gZIPOutputStream;
        ObjectOutputStream objectOutputStream;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            try {
                file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                if (obj == null) {
                    return true;
                }
                if (!file.getParentFile().exists() || !file.getParentFile().isDirectory()) {
                    file.getParentFile().delete();
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            } catch (Throwable th) {
                en.a().a(th);
                file = null;
            }
            if (file != null) {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        gZIPOutputStream = new GZIPOutputStream(fileOutputStream2);
                        try {
                            objectOutputStream = new ObjectOutputStream(gZIPOutputStream);
                            try {
                                objectOutputStream.writeObject(obj);
                                objectOutputStream.flush();
                                objectOutputStream.close();
                                eg.a(objectOutputStream, gZIPOutputStream, fileOutputStream2);
                                return true;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                try {
                                    en.a().a(th);
                                    eg.a(objectOutputStream, gZIPOutputStream, fileOutputStream);
                                    return false;
                                } catch (Throwable th3) {
                                    eg.a(objectOutputStream, gZIPOutputStream, fileOutputStream);
                                    throw th3;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            objectOutputStream = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        gZIPOutputStream = null;
                        objectOutputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    gZIPOutputStream = null;
                    objectOutputStream = null;
                }
            }
        }
        return false;
    }

    public static float[] a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new float[]{displayMetrics.xdpi, displayMetrics.ydpi};
    }
}

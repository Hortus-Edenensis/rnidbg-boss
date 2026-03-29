package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class dd implements LoggerInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile dd f11502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f259a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f260a;
    private String b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final SimpleDateFormat f257a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f256a = "/MiPushLog";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static List<Pair<String, Throwable>> f258a = Collections.synchronizedList(new ArrayList());

    private dd(Context context) {
        this.f259a = context;
        if (context.getApplicationContext() != null) {
            this.f259a = context.getApplicationContext();
        }
        this.b = this.f259a.getPackageName() + "-" + Process.myPid();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f260a = new Handler(handlerThread.getLooper());
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.b = str;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(final String str, final Throwable th) {
        this.f260a.post(new Runnable() { // from class: com.xiaomi.push.dd.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                dd.f258a.add(new Pair(String.format("%1$s %2$s %3$s ", dd.f257a.format(new Date()), dd.this.b, str), th));
                if (dd.f258a.size() > 20000) {
                    int size = (dd.f258a.size() - 20000) + 50;
                    for (int i = 0; i < size; i++) {
                        try {
                            if (dd.f258a.size() > 0) {
                                dd.f258a.remove(0);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                    }
                    dd.f258a.add(new Pair(String.format("%1$s %2$s %3$s ", dd.f257a.format(new Date()), dd.this.b, "flush " + size + " lines logs."), null));
                }
                try {
                    dd.this.m291a();
                } catch (Exception e) {
                    Log.e(dd.this.b, "", e);
                }
            }
        });
    }

    public static dd a(Context context) {
        if (f11502a == null) {
            synchronized (dd.class) {
                if (f11502a == null) {
                    f11502a = new dd(context);
                }
            }
        }
        return f11502a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x015b -> B:102:0x0160). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m291a() throws Throwable {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock;
        File file;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    file = new File(this.f259a.getFilesDir(), f256a);
                } catch (IOException e) {
                    Log.e(this.b, "", e);
                }
            } catch (Exception e2) {
                e = e2;
                fileLockLock = null;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                fileLockLock = null;
                randomAccessFile = null;
            }
            if (!v.m788a(file)) {
                Log.w(this.b, "Cannot wirte internal file: " + file);
                return;
            }
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                Log.w(this.b, "Create mipushlog directory fail.");
                return;
            }
            File file2 = new File(file, "log.lock");
            if (!file2.exists() || file2.isDirectory()) {
                file2.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                fileLockLock = randomAccessFile.getChannel().lock();
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                    while (!f258a.isEmpty()) {
                        try {
                            Pair<String, Throwable> pairRemove = f258a.remove(0);
                            String str = (String) pairRemove.first;
                            if (pairRemove.second != null) {
                                str = (str + "\n") + Log.getStackTraceString((Throwable) pairRemove.second);
                            }
                            bufferedWriter2.write(str + "\n");
                        } catch (Exception e3) {
                            e = e3;
                            bufferedWriter = bufferedWriter2;
                            Log.e(this.b, "", e);
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e4) {
                                    Log.e(this.b, "", e4);
                                }
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e5) {
                                    Log.e(this.b, "", e5);
                                }
                            }
                            if (randomAccessFile == null) {
                                return;
                            } else {
                                randomAccessFile.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e6) {
                                    Log.e(this.b, "", e6);
                                }
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e7) {
                                    Log.e(this.b, "", e7);
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    throw th;
                                } catch (IOException e8) {
                                    Log.e(this.b, "", e8);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    File file3 = new File(file, "log1.txt");
                    if (file3.length() >= 1048576) {
                        File file4 = new File(file, "log0.txt");
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                        file3.renameTo(file4);
                    }
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e9) {
                            Log.e(this.b, "", e9);
                        }
                    }
                    randomAccessFile.close();
                } catch (Exception e10) {
                    e = e10;
                }
            } catch (Exception e11) {
                e = e11;
                fileLockLock = null;
            } catch (Throwable th3) {
                th = th3;
                fileLockLock = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}

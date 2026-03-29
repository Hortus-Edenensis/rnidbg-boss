package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.utils.time.FastDateFormat;
import defpackage.d63;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b45 implements Handler.Callback {
    public static final String d = "b45";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1646a;
    public Handler b;
    public FastDateFormat c;

    public b45(Context context) {
        this.f1646a = context;
        HandlerThread handlerThreadB = lg2.b("statslog", 10);
        handlerThreadB.start();
        this.b = new Handler(handlerThreadB.getLooper(), this);
        i();
        this.c = FastDateFormat.getInstance("yyyy-MM-dd-HH-mm-ss-SSS", Locale.US);
    }

    public void a(d63.a aVar) {
        if (aVar == null) {
            return;
        }
        this.b.obtainMessage(1, 0, 0, aVar).sendToTarget();
    }

    public final void b(File file, String str) {
        if (file != null) {
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(str);
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void c(d63.a aVar) {
        if (aVar != null) {
            e(aVar);
        }
    }

    public final synchronized void d(boolean z) {
        File[] fileArrListFiles;
        if (hx3.m(null)) {
            if (((hx3.n() || b63.a().b().e) && !c.g()) || z) {
                for (LogUtil.LogType logType : LogUtil.LogType.values()) {
                    int i = logType.value;
                    File file = new File(pu1.i + File.separator + logType.value);
                    if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
                        for (File file2 : fileArrListFiles) {
                            if (file2 != null && file2.exists()) {
                                if (!"temp".equals(pu1.i(file2))) {
                                    j(i, file2);
                                } else if ((Math.abs(f(file2) - ir5.b()) > ((long) b63.a().b().f)) || z) {
                                    File file3 = new File(file2.getAbsolutePath().replace("temp", "txt"));
                                    if (file2.renameTo(file3)) {
                                        j(i, file3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final synchronized void e(d63.a aVar) {
        if (this.f1646a != null && pu1.b) {
            if (aVar != null) {
                File fileG = g(aVar.f16984a);
                if (fileG == null) {
                } else {
                    b(fileG, aVar.b);
                }
            }
        }
    }

    public long f(File file) {
        if (file != null) {
            String name = file.getName();
            try {
                return this.c.parse(name.substring(name.lastIndexOf("_") + 1, name.lastIndexOf(".") + 1)).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public final File g(LogUtil.LogType logType) {
        try {
            return h(logType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0073 A[Catch: all -> 0x0124, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0042, B:7:0x0048, B:9:0x004c, B:11:0x0050, B:13:0x0056, B:15:0x0062, B:21:0x0073, B:24:0x0088, B:25:0x00c8, B:18:0x006d, B:26:0x00f4), top: B:32:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8 A[Catch: all -> 0x0124, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0042, B:7:0x0048, B:9:0x004c, B:11:0x0050, B:13:0x0056, B:15:0x0062, B:21:0x0073, B:24:0x0088, B:25:0x00c8, B:18:0x006d, B:26:0x00f4), top: B:32:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized File h(LogUtil.LogType logType) throws IOException {
        File file;
        File file2 = new File(pu1.i + File.separator + logType.value);
        String str = "@" + iu1.b(c.b()) + "_";
        if (file2.exists()) {
            File[] fileArrListFiles = file2.listFiles();
            if (fileArrListFiles != null) {
                int length = fileArrListFiles.length;
                for (int i = 0; i < length; i++) {
                    file = fileArrListFiles[i];
                    if (file != null && file.exists() && "temp".equals(pu1.i(file)) && file.getName().contains(str)) {
                        break;
                    }
                }
                file = null;
                if (file != null) {
                    file = new File(file2, str + this.c.format(ir5.b()) + ".temp");
                    file.createNewFile();
                } else if (file.length() >= b63.a().b().c) {
                    file.renameTo(new File(file.getAbsolutePath().replace("temp", "txt")));
                    file = new File(file2, str + this.c.format(ir5.b()) + ".temp");
                    file.createNewFile();
                }
            } else {
                file = null;
                if (file != null) {
                }
            }
        } else {
            file2.mkdirs();
            file = new File(file2, str + this.c.format(ir5.b()) + ".temp");
            file.createNewFile();
        }
        return file;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        LogUtil.i(d, "handleMessage=" + message.what);
        int i = message.what;
        if (i == 1) {
            c((d63.a) message.obj);
        } else if (i == 2) {
            d(((Boolean) message.obj).booleanValue());
        } else if (i == 3) {
            d(false);
            i();
        }
        return true;
    }

    public void i() {
        this.b.removeMessages(3);
        this.b.sendEmptyMessageDelayed(3, b63.a().b().d);
    }

    public final void j(int i, File file) {
        if (file == null || !file.exists() || file.length() == 0) {
            return;
        }
        if (Math.abs(file.lastModified() - ir5.b()) >= b63.a().b().f12158a) {
            file.delete();
            return;
        }
        try {
            JSONObject jSONObjectE = new g63().e(sk5.c, i, null, file);
            if (jSONObjectE != null && jSONObjectE.getInt("resultCode") == 0) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void k(boolean z) {
        this.b.removeMessages(2);
        Handler handler = this.b;
        handler.sendMessage(handler.obtainMessage(2, Boolean.valueOf(z)));
    }
}

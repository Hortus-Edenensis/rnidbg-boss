package cn.fly.verify;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class gb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2382a = ba.a("005Mhnffffgl%l");
    private Context b;
    private volatile a c;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        private static Handler c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private File f2383a;
        private HashMap<String, Object> b;

        static {
            String str;
            if (TextUtils.isEmpty("M-")) {
                str = null;
            } else {
                str = ek.f2243a + ba.a("002;glin");
            }
            c = em.a(str, new Handler.Callback() { // from class: cn.fly.verify.gb.a.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    FileOutputStream fileOutputStream;
                    Throwable th;
                    OutputStreamWriter outputStreamWriter;
                    try {
                        Bundle data = message.getData();
                        String string = data.getString(ba.a("0042jihjgfGg"));
                        fileOutputStream = new FileOutputStream(data.getString(ba.a("0041ghfk8ih")));
                        try {
                            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
                            try {
                                outputStreamWriter.append((CharSequence) string);
                                outputStreamWriter.flush();
                                eg.a(outputStreamWriter, fileOutputStream);
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    en.a().b(th);
                                    eg.a(outputStreamWriter, fileOutputStream);
                                } catch (Throwable th3) {
                                    eg.a(outputStreamWriter, fileOutputStream);
                                    throw th3;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            outputStreamWriter = null;
                        }
                    } catch (Throwable th5) {
                        fileOutputStream = null;
                        th = th5;
                        outputStreamWriter = null;
                    }
                    return false;
                }
            });
        }

        public a(Context context, String str) {
            this(context, str, gb.f2382a);
        }

        private Object b(String str) {
            Object obj;
            synchronized (this.b) {
                obj = this.b.get(str);
            }
            return obj;
        }

        public int a(String str, int i) {
            Object objB = b(str);
            return objB != null ? ((Number) objB).intValue() : i;
        }

        public a(Context context, String str, String str2) {
            this.b = new HashMap<>();
            if (context != null) {
                try {
                    File file = new File(new File(context.getFilesDir(), str2), str);
                    this.f2383a = file;
                    if (!file.getParentFile().exists()) {
                        this.f2383a.getParentFile().mkdirs();
                    }
                    if (!this.f2383a.exists()) {
                        this.f2383a.createNewFile();
                    }
                } catch (Throwable th) {
                    en.a().a(th);
                    return;
                }
            }
            b();
        }

        private void b() {
            InputStreamReader inputStreamReader;
            BufferedReader bufferedReader;
            Throwable th;
            FileInputStream fileInputStream;
            synchronized (this.b) {
                File file = this.f2383a;
                if (file != null && file.exists()) {
                    try {
                        fileInputStream = new FileInputStream(this.f2383a);
                        try {
                            inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                                try {
                                    StringBuilder sb = new StringBuilder();
                                    while (true) {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        if (sb.length() > 0) {
                                            sb.append("\n");
                                        }
                                        sb.append(line);
                                    }
                                    this.b = fv.a(sb.toString());
                                    eg.a(bufferedReader, inputStreamReader, fileInputStream);
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        en.a().b(th);
                                        eg.a(bufferedReader, inputStreamReader, fileInputStream);
                                    } catch (Throwable th3) {
                                        eg.a(bufferedReader, inputStreamReader, fileInputStream);
                                        throw th3;
                                    }
                                }
                            } catch (Throwable th4) {
                                bufferedReader = null;
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            bufferedReader = null;
                            th = th5;
                            inputStreamReader = null;
                        }
                    } catch (Throwable th6) {
                        inputStreamReader = null;
                        bufferedReader = null;
                        th = th6;
                        fileInputStream = null;
                    }
                }
            }
        }

        public long a(String str, long j) {
            Object objB = b(str);
            return objB != null ? ((Number) objB).longValue() : j;
        }

        public String a(String str, String str2) {
            Object objB = b(str);
            return objB != null ? (String) objB : str2;
        }

        public void b(String str, int i) {
            a(str, Integer.valueOf(i));
        }

        public HashMap<String, Object> a() {
            HashMap<String, Object> map;
            synchronized (this.b) {
                map = new HashMap<>();
                map.putAll(this.b);
            }
            return map;
        }

        public void b(String str, long j) {
            a(str, Long.valueOf(j));
        }

        public void a(String str) {
            a(str, (Object) null);
        }

        public void b(String str, String str2) {
            a(str, (Object) str2);
        }

        public void a(String str, byte b) {
            a(str, Byte.valueOf(b));
        }

        public void b(String str, boolean z) {
            a(str, z ? (byte) 1 : (byte) 0);
        }

        private void a(String str, Object obj) {
            synchronized (this.b) {
                this.b.put(str, obj);
                if (c != null && this.f2383a != null) {
                    Message message = new Message();
                    Bundle bundle = new Bundle();
                    bundle.putString(ba.a("004Gjihjgf$g"), fv.a((HashMap) this.b));
                    bundle.putString(ba.a("004Sghfk9ih"), this.f2383a.getAbsolutePath());
                    message.setData(bundle);
                    message.what = 1;
                    c.sendMessage(message);
                }
            }
        }

        public void a(HashMap<String, Object> map) {
            synchronized (this.b) {
                this.b.putAll(map);
            }
            if (c == null || this.f2383a == null) {
                return;
            }
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString(ba.a("004Rjihjgf.g"), fv.a((HashMap) this.b));
            bundle.putString(ba.a("004 ghfk1ih"), this.f2383a.getAbsolutePath());
            message.setData(bundle);
            message.what = 1;
            c.sendMessage(message);
        }

        public boolean a(String str, boolean z) {
            Object objB = b(str);
            return objB != null ? ((Number) objB).byteValue() == 1 : z;
        }
    }

    public gb(Context context) {
        if (context != null) {
            this.b = context.getApplicationContext();
        }
    }

    public long a(String str, long j) {
        return this.c != null ? this.c.a(str, j) : j;
    }

    public int b(String str, int i) {
        return this.c != null ? this.c.a(str, i) : i;
    }

    public int c(String str) {
        if (this.c != null) {
            return this.c.a(str, 0);
        }
        return 0;
    }

    public Object d(String str) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        try {
            String strA = a(str);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            try {
                byteArrayInputStream = new ByteArrayInputStream(Base64.decode(strA, 2));
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
                byteArrayInputStream = null;
            }
            try {
                Object object = objectInputStream.readObject();
                objectInputStream.close();
                eg.a(objectInputStream, byteArrayInputStream);
                return object;
            } catch (Throwable th3) {
                th = th3;
                eg.a(objectInputStream, byteArrayInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            en.a().b(th4);
            return null;
        }
    }

    public void e(String str) {
        if (this.c != null) {
            this.c.a(str);
        }
    }

    public String a(String str) {
        return this.c != null ? this.c.a(str, "") : "";
    }

    public String b(String str, String str2) {
        return this.c != null ? this.c.a(str, str2) : str2;
    }

    public HashMap<String, Object> a() {
        return this.c != null ? this.c.a() : new HashMap<>();
    }

    public boolean b(String str) {
        if (this.c != null) {
            return this.c.a(str, false);
        }
        return false;
    }

    public void a(String str, int i) {
        this.c = new a(this.b, str + "_" + i);
    }

    public void a(String str, Boolean bool) {
        if (this.c != null) {
            this.c.b(str, bool.booleanValue());
        }
    }

    public void a(String str, Integer num) {
        if (this.c != null) {
            this.c.b(str, num.intValue());
        }
    }

    public void a(String str, Long l) {
        if (this.c != null) {
            this.c.b(str, l.longValue());
        }
    }

    public void a(String str, Object obj) {
        ObjectOutputStream objectOutputStream;
        if (obj == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream2);
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    a(str, Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 2));
                    eg.a(objectOutputStream, byteArrayOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        en.a().b(th);
                        eg.a(objectOutputStream, byteArrayOutputStream);
                    } catch (Throwable th2) {
                        eg.a(objectOutputStream, byteArrayOutputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            objectOutputStream = null;
        }
    }

    public void a(String str, String str2) {
        if (this.c != null) {
            this.c.b(str, str2);
        }
    }

    public void a(String str, String str2, int i) {
        this.c = new a(this.b, str2 + "_" + i, str);
    }

    public void a(HashMap<String, Object> map) {
        if (this.c != null) {
            this.c.a(map);
        }
    }

    public boolean a(String str, boolean z) {
        return this.c != null ? this.c.a(str, z) : z;
    }
}

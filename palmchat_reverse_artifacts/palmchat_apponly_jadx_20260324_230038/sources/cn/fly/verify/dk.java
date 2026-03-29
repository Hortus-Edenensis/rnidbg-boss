package cn.fly.verify;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dk {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected ArrayList<Object> f2180a;
        protected DataInputStream b;
        protected int c;

        private a(ArrayList<Object> arrayList, DataInputStream dataInputStream, int i) {
            this.f2180a = arrayList;
            this.b = dataInputStream;
            this.c = i;
        }

        public void a() throws Throwable {
            this.b.readShort();
        }

        public <T> T b() throws Throwable {
            return (T) this.f2180a.get(this.b.readShort());
        }

        public int c() {
            return this.c;
        }

        public void a(dl dlVar) throws Throwable {
            dlVar.b = (String) this.f2180a.get(this.b.readShort());
            dlVar.c = this.b.readShort();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends a {
        private b(ArrayList<Object> arrayList, DataInputStream dataInputStream, int i) {
            super(arrayList, dataInputStream, i);
        }

        @Override // cn.fly.verify.dk.a
        public void a() throws Throwable {
            this.b.readInt();
        }

        @Override // cn.fly.verify.dk.a
        public <T> T b() throws Throwable {
            return (T) this.f2180a.get(this.b.readInt());
        }

        @Override // cn.fly.verify.dk.a
        public void a(dl dlVar) throws Throwable {
            dlVar.b = (String) this.f2180a.get(this.b.readInt());
            dlVar.c = this.b.readInt();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f2181a;

        private c(Object obj) {
            this.f2181a = new d(obj);
        }

        public c a(Object obj) {
            this.f2181a.a(obj);
            return this;
        }

        public d a(String str, Class<?> cls) {
            return this.f2181a.a(str, cls);
        }

        public d a(String str, Object obj) {
            return this.f2181a.a(str, obj);
        }

        public void a() throws Throwable {
            this.f2181a.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList<Object> f2182a;
        private ArrayList<Object> b;
        private HashMap<String, Object> c;
        private HashMap<String, Object> d;
        private String e;
        private HashMap<Class<?>, Class<? extends dg<?>>> f;

        private d(Object obj) {
            ArrayList<Object> arrayList = new ArrayList<>();
            this.f2182a = arrayList;
            arrayList.add(obj);
            this.b = new ArrayList<>();
            this.c = new HashMap<>();
            this.d = new HashMap<>();
            this.f = new HashMap<>();
            this.c.put("t_map", this.d);
        }

        public <T> d a(Class<T> cls, Class<? extends dg<T>> cls2) {
            this.f.put(cls, cls2);
            return this;
        }

        public d a(String str) {
            this.e = str;
            return this;
        }

        public d a(String str, Class<?> cls) {
            dj.f2179a.put(str, cls);
            return this;
        }

        public d a(String str, Object obj) {
            this.c.put(str, obj);
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0013, code lost:
        
            r0 = new java.io.StringWriter();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
        
            r1 = new java.io.PrintWriter(r0);
            r5.printStackTrace(r1);
            r1.flush();
            r1.close();
            r5 = r0.toString();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        
            r5 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        
            r2 = r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private String a(Throwable th) {
            String string;
            if (th == null) {
                return "";
            }
            Throwable cause = th;
            while (true) {
                StringWriter stringWriter = null;
                if (cause == null) {
                    break;
                }
                try {
                    if (cause instanceof UnknownHostException) {
                        return "";
                    }
                    cause = cause.getCause();
                } catch (Throwable th2) {
                    th = th2;
                }
                th = th2;
                try {
                    if (th instanceof OutOfMemoryError) {
                        String strA = bq.a("023>ff?gj=fk3jed emflek1edg>fkCj-ekej^fNffjgfefeeg");
                        if (stringWriter != null) {
                            try {
                                stringWriter.close();
                            } catch (Throwable unused) {
                            }
                        }
                        return strA;
                    }
                    String message = th.getMessage();
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return message;
                } catch (Throwable th3) {
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th3;
                }
            }
            return string;
        }

        private String a(byte[] bArr, String str) {
            if (bArr == null) {
                return str;
            }
            try {
                byte[] bytes = str.getBytes("UTF-8");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, bq.a("0037fmhifk"));
                StringBuilder sb = new StringBuilder();
                sb.append(bq.a("003_fmhifk"));
                sb.append(bq.a("003mXhihl"));
                sb.append(bq.a("008 gjSmRhmjdhlfkjkhm"));
                sb.append(bq.a("006e]ededejXfZff"));
                Provider provider = Security.getProvider(bq.a("002<gjhl"));
                Cipher cipher = provider != null ? Cipher.getInstance(sb.toString(), provider) : Cipher.getInstance(sb.toString(), bq.a("0028gjhl"));
                cipher.init(1, secretKeySpec);
                byte[] bArr2 = new byte[cipher.getOutputSize(bytes.length)];
                cipher.doFinal(bArr2, cipher.update(bytes, 0, bytes.length, bArr2, 0));
                return new BigInteger(1, bArr2).toString(16);
            } catch (Throwable unused) {
                return "";
            }
        }

        public void a() throws Throwable {
            byte[] bytes;
            InputStream byteArrayInputStream;
            ArrayList<dl> arrayList = new ArrayList<>();
            String str = this.e;
            if (str != null) {
                bytes = str.getBytes("UTF-8");
                System.arraycopy(bytes, 0, new byte[16], 0, Math.min(bytes.length, 16));
            } else {
                bytes = null;
            }
            try {
                dh dhVar = new dh();
                for (Object obj : this.f2182a) {
                    if (obj instanceof String) {
                        byteArrayInputStream = new FileInputStream((String) obj);
                    } else {
                        if (!(obj instanceof byte[])) {
                            throw new ClassCastException("program is not string or byte array");
                        }
                        byteArrayInputStream = new ByteArrayInputStream((byte[]) obj);
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    a(byteArrayInputStream, arrayList, dhVar);
                    this.d.put("l_t", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                }
                for (Map.Entry<Class<?>, Class<? extends dg<?>>> entry : this.f.entrySet()) {
                    dhVar.a(entry.getKey(), entry.getValue());
                }
                new dj(arrayList, this.b).a(this.c, dhVar);
            } catch (Throwable th) {
                th = th;
                if (bytes == null) {
                    throw th;
                }
                String string = th.getMessage() == null ? th.getClass().toString() : th.getMessage();
                if (th instanceof di) {
                    th = th.getCause();
                }
                throw new di(a(bytes, string + " " + a(th)), th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:107:0x01ec A[Catch: all -> 0x01f3, TRY_ENTER, TryCatch #7 {all -> 0x01f3, blocks: (B:107:0x01ec, B:108:0x01f0), top: B:127:0x01ea }] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x01f0 A[Catch: all -> 0x01f3, TRY_LEAVE, TryCatch #7 {all -> 0x01f3, blocks: (B:107:0x01ec, B:108:0x01f0), top: B:127:0x01ea }] */
        /* JADX WARN: Type inference failed for: r2v1, types: [cn.fly.verify.dk$1] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(InputStream inputStream, ArrayList<dl> arrayList, dh dhVar) throws Throwable {
            InputStream bufferedInputStream;
            long jCurrentTimeMillis;
            int i;
            InputStream gZIPInputStream;
            DataInputStream dataInputStream;
            ByteArrayInputStream byteArrayInputStream;
            ByteArrayInputStream byteArrayInputStream2;
            if (inputStream.read() != 70) {
                inputStream.close();
                return;
            }
            ?? r2 = 0;
            dataInputStream = null;
            DataInputStream dataInputStream2 = null;
            dataInputStream = null;
            DataInputStream dataInputStream3 = null;
            r2 = 0;
            r2 = 0;
            try {
                jCurrentTimeMillis = System.currentTimeMillis();
                i = inputStream.read();
                if (i == 1 || i == 2) {
                    bufferedInputStream = inputStream;
                    try {
                        gZIPInputStream = new GZIPInputStream(bufferedInputStream);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (r2 == 0) {
                                r2.close();
                            } else {
                                bufferedInputStream.close();
                            }
                        } catch (Throwable unused) {
                        }
                        throw th;
                    }
                } else {
                    gZIPInputStream = inputStream;
                }
                try {
                    bufferedInputStream = new BufferedInputStream(gZIPInputStream, 4096);
                    dataInputStream = new DataInputStream(bufferedInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = gZIPInputStream;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = inputStream;
            }
            try {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(null);
                int i2 = dataInputStream.readInt();
                for (int i3 = 0; i3 < i2; i3++) {
                    arrayList2.add(Integer.valueOf(dataInputStream.readInt()));
                }
                int i4 = dataInputStream.readInt();
                for (int i5 = 0; i5 < i4; i5++) {
                    arrayList2.add(Long.valueOf(dataInputStream.readLong()));
                }
                int i6 = dataInputStream.readInt();
                for (int i7 = 0; i7 < i6; i7++) {
                    arrayList2.add(Float.valueOf(dataInputStream.readFloat()));
                }
                int i8 = dataInputStream.readInt();
                for (int i9 = 0; i9 < i8; i9++) {
                    arrayList2.add(Double.valueOf(dataInputStream.readDouble()));
                }
                int i10 = dataInputStream.readInt();
                for (int i11 = 0; i11 < i10; i11++) {
                    arrayList2.add(Boolean.valueOf(dataInputStream.readBoolean()));
                }
                int i12 = dataInputStream.readInt();
                if (i == 2) {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr);
                    try {
                        byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                        try {
                            DataInputStream dataInputStream4 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(byteArrayInputStream2), 2048));
                            for (int i13 = 0; i13 < i12; i13++) {
                                try {
                                    arrayList2.add(dataInputStream4.readUTF());
                                } catch (Throwable th4) {
                                    th = th4;
                                    dataInputStream2 = dataInputStream4;
                                    if (dataInputStream2 != null) {
                                        dataInputStream2.close();
                                    } else if (byteArrayInputStream2 != null) {
                                        byteArrayInputStream2.close();
                                    }
                                    throw th;
                                }
                            }
                            dataInputStream4.close();
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        byteArrayInputStream2 = null;
                    }
                } else {
                    for (int i14 = 0; i14 < i12; i14++) {
                        arrayList2.add(dataInputStream.readUTF());
                    }
                }
                if (dataInputStream.readByte() != 15) {
                    throw new RuntimeException("data has offset in pos 1");
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                this.d.put("lc_t", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis));
                a bVar = dataInputStream.readBoolean() ? new b(arrayList2, dataInputStream, arrayList.size()) : new a(arrayList2, dataInputStream, arrayList.size());
                int i15 = dataInputStream.readInt();
                boolean z = dataInputStream.readBoolean();
                if (dataInputStream.readByte() != 25) {
                    throw new RuntimeException("data has offset in pos 2");
                }
                for (int i16 = 0; i16 < i15; i16++) {
                    dl dlVar = new dl();
                    dlVar.f2183a = dataInputStream.readByte();
                    if (z) {
                        bVar.a(dlVar);
                    }
                    dlVar.a(bVar);
                    arrayList.add(dlVar);
                }
                if (dataInputStream.readByte() != 39) {
                    throw new RuntimeException("data has offset in pos 3");
                }
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                this.d.put("lcmd_t", Long.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis2));
                try {
                    byte[] bArr2 = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr2);
                    if (i == 2) {
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(bArr2);
                            try {
                                DataInputStream dataInputStream5 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
                                try {
                                    byte[] bArr3 = new byte[dataInputStream5.readInt()];
                                    dataInputStream5.readFully(bArr3);
                                    dataInputStream5.close();
                                    bArr2 = bArr3;
                                } catch (Throwable th7) {
                                    th = th7;
                                    dataInputStream3 = dataInputStream5;
                                    if (dataInputStream3 != null) {
                                        dataInputStream3.close();
                                    } else if (byteArrayInputStream != null) {
                                        byteArrayInputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            byteArrayInputStream = null;
                        }
                    }
                    dhVar.a(bArr2);
                    this.d.put("mreg_t", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis3));
                } catch (Throwable unused2) {
                }
                try {
                    dataInputStream.close();
                } catch (Throwable unused3) {
                }
            } catch (Throwable th10) {
                th = th10;
                r2 = dataInputStream;
                if (r2 == 0) {
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj) {
            this.f2182a.add(obj);
        }
    }

    private dk() {
    }

    public static int a() {
        return 70;
    }

    private static c a(Object[] objArr) {
        if (objArr.length == 0) {
            return null;
        }
        c cVar = new c(objArr[0]);
        for (int i = 1; i < objArr.length; i++) {
            cVar.a(objArr[i]);
        }
        return cVar;
    }

    public static c a(String... strArr) {
        return a((Object[]) strArr);
    }

    public static c a(byte[]... bArr) {
        return a((Object[]) bArr);
    }
}

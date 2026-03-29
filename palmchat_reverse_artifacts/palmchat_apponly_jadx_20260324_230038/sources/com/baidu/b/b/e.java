package com.baidu.b.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.b.a.e;
import com.baidu.b.b.a;
import com.baidu.b.h;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e extends com.baidu.b.b.a {
    private Context d;
    private f e;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f3311a = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
        private final int b;

        private a(int i) {
            this.b = i;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return this.b - aVar.b;
        }

        public byte b() {
            return (byte) this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && a.class == obj.getClass() && this.b == ((a) obj).b;
        }

        public int hashCode() {
            return this.b;
        }

        public static a a(byte b, boolean z) {
            int i = b & UByte.MAX_VALUE;
            return a(z ? i >> 4 : i & 15);
        }

        public static a a(int i) {
            if (i >= 0 && i < 16) {
                return new a(i);
            }
            throw new IllegalArgumentException("invalid idx " + i);
        }

        public String a() {
            return f3311a[this.b];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {
        private int b = 33;
        private a[] c = new a[33];
        private int d;

        public b() {
        }

        private void b(int i) {
            a[] aVarArr = this.c;
            if (i - aVarArr.length > 0) {
                int length = aVarArr.length;
                int i2 = length + (length >> 1);
                if (i2 - i >= 0) {
                    i = i2;
                }
                this.c = (a[]) Arrays.copyOf(aVarArr, i);
            }
        }

        public int a() {
            return this.d;
        }

        public a a(int i) {
            if (i < this.d) {
                return this.c[i];
            }
            throw new IndexOutOfBoundsException("idx " + i + " size " + this.d);
        }

        public byte[] b() {
            int i;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            while (true) {
                i = this.d;
                if (i2 >= i / 2) {
                    break;
                }
                int i3 = i2 * 2;
                byteArrayOutputStream.write((byte) (((a(i3 + 1).b() & UByte.MAX_VALUE) << 4) | (a(i3).b() & UByte.MAX_VALUE)));
                i2++;
            }
            if (i % 2 != 0) {
                byteArrayOutputStream.write((byte) (a(i - 1).b() & UByte.MAX_VALUE));
            }
            return byteArrayOutputStream.toByteArray();
        }

        public void a(a aVar) {
            b(this.d + 1);
            a[] aVarArr = this.c;
            int i = this.d;
            this.d = i + 1;
            aVarArr[i] = aVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f3313a = new ArrayList();

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f3314a;
            private a b;

            public a(a aVar) {
                this.b = aVar;
            }

            public void a() {
                this.f3314a++;
            }
        }

        public List a() {
            ArrayList arrayList = new ArrayList(this.f3313a);
            Collections.sort(arrayList, new com.baidu.b.b.f(this));
            return arrayList;
        }

        public void a(a aVar) {
            this.f3313a.add(new a(aVar));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        byte[] f3315a;
        byte b;
        byte[] c;

        public d(byte[] bArr, byte b, byte[] bArr2) {
            this.f3315a = bArr;
            this.b = b;
            this.c = bArr2;
        }

        public h.a a() {
            try {
                String strA = com.baidu.b.d.b.a(this.f3315a, "", true);
                String str = new String(new byte[]{this.b}, "UTF-8");
                byte[] bArr = this.c;
                return h.a(strA, str, bArr != null ? new String(bArr, "UTF-8") : null);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.baidu.b.b.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0059e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3316a;
        public int b;
        public int c = 16;

        public String toString() {
            return "";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f3317a;
        private Method b;
        private Method c;
        private Method d;
        private Method e;

        public int a(Context context, Uri uri, int i, int i2, int i3) throws e.a {
            try {
                return ((Integer) this.f3317a.invoke(context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
            } catch (Exception e) {
                throw new e.a(e);
            }
        }

        public void a() {
            try {
                String strA = com.baidu.b.a.e.a(com.baidu.b.a.d.d());
                Class cls = Integer.TYPE;
                this.f3317a = com.baidu.b.a.e.a(Context.class, strA, new Class[]{Uri.class, cls, cls, cls});
                this.b = com.baidu.b.a.e.a(Context.class, com.baidu.b.a.e.a(com.baidu.b.a.d.e()), new Class[]{String.class, Uri.class, cls});
                this.c = com.baidu.b.a.e.a(ContentResolver.class, com.baidu.b.a.e.a(com.baidu.b.a.d.f()), new Class[]{Uri.class, cls});
                this.d = com.baidu.b.a.e.a(Context.class, com.baidu.b.a.e.a(com.baidu.b.a.d.g()), new Class[]{Uri.class, cls});
                this.e = com.baidu.b.a.e.a(ContentResolver.class, com.baidu.b.a.e.a(com.baidu.b.a.d.h()), new Class[]{Uri.class, cls});
            } catch (Exception unused) {
            }
        }
    }

    public e() {
        super("upc", 9000000L);
        f fVar = new f();
        this.e = fVar;
        fVar.a();
    }

    @Override // com.baidu.b.b.a
    public a.e a(String str, a.d dVar) throws PackageManager.NameNotFoundException {
        int packageUid;
        byte[] bArrB;
        boolean z;
        Byte bValueOf;
        Byte bValueOf2;
        if (Build.VERSION.SDK_INT < 26) {
            return a.e.a();
        }
        try {
            packageUid = this.d.getPackageManager().getPackageUid(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageUid = -1;
        }
        if (packageUid < 0) {
            return a.e.a();
        }
        C0059e c0059e = new C0059e();
        b bVar = new b();
        c cVar = new c();
        c cVar2 = new c();
        for (int i = 0; i < 16; i++) {
            a aVarA = a.a(i);
            if (a(str, aVarA, packageUid)) {
                cVar.a(aVarA);
            } else {
                cVar2.a(aVarA);
            }
        }
        for (int i2 = 0; i2 < 32; i2++) {
            a aVarA2 = a(str, i2, cVar.a(), packageUid, c0059e);
            if (aVarA2 == null) {
                aVarA2 = a(str, i2, cVar2.a(), packageUid, c0059e);
            }
            if (aVarA2 == null) {
                return a.e.a();
            }
            bVar.a(aVarA2);
        }
        byte[] bArrB2 = bVar.b();
        int i3 = 3;
        byte[] bArr = {"0".getBytes()[0], "O".getBytes()[0], ExifInterface.GPS_MEASUREMENT_INTERRUPTED.getBytes()[0]};
        int i4 = 0;
        while (true) {
            bArrB = null;
            if (i4 >= i3) {
                z = true;
                bValueOf = null;
                break;
            }
            byte b2 = bArr[i4];
            a aVarA3 = a.a(b2, false);
            int i5 = i4;
            z = true;
            byte[] bArr2 = bArr;
            if (a(str, 32, aVarA3, packageUid, c0059e)) {
                a aVarA4 = a.a(b2, true);
                if (a(str, 33, aVarA4, packageUid, c0059e)) {
                    b bVar2 = new b();
                    bVar2.a(aVarA3);
                    bVar2.a(aVarA4);
                    bValueOf = Byte.valueOf(bVar2.b()[0]);
                    break;
                }
            }
            i4 = i5 + 1;
            bArr = bArr2;
            i3 = 3;
        }
        if (bValueOf == null) {
            b bVar3 = new b();
            int i6 = 32;
            for (int i7 = 34; i6 < i7; i7 = 34) {
                int i8 = i6;
                b bVar4 = bVar3;
                a aVarA5 = a(str, i6, cVar.a(), packageUid, c0059e);
                if (aVarA5 == null) {
                    aVarA5 = a(str, i8, cVar2.a(), packageUid, c0059e);
                }
                if (aVarA5 == null) {
                    return a.e.a();
                }
                bVar4.a(aVarA5);
                i6 = i8 + 1;
                bVar3 = bVar4;
            }
            bValueOf2 = Byte.valueOf(bVar3.b()[0]);
        } else {
            bValueOf2 = bValueOf;
            z = false;
        }
        if (z) {
            b bVar5 = new b();
            for (int i9 = 34; i9 < 94; i9++) {
                a aVarA6 = a(str, i9, cVar.a(), packageUid, c0059e);
                if (aVarA6 == null) {
                    aVarA6 = a(str, i9, cVar2.a(), packageUid, c0059e);
                }
                if (aVarA6 == null) {
                    break;
                }
                bVar5.a(aVarA6);
            }
            if (bVar5.a() > 0) {
                bArrB = bVar5.b();
            }
        }
        return a.e.a(new d(bArrB2, bValueOf2.byteValue(), bArrB).a());
    }

    private a a(String str, int i, List list, int i2, C0059e c0059e) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c.a aVar = (c.a) it.next();
            if (a(str, i, aVar.b, i2, c0059e)) {
                aVar.a();
                return aVar.b;
            }
        }
        return null;
    }

    private String a(String str) {
        return str + ".cesium";
    }

    private String a(String str, int i, a aVar) {
        return String.format("content://%s/dat/v1/i%d/%s", a(str), Integer.valueOf(i), aVar.a());
    }

    private String a(String str, a aVar) {
        return String.format("content://%s/dic/v1/%s", a(str), aVar.a());
    }

    @Override // com.baidu.b.b.a
    public void a(a.c cVar) {
        this.d = this.b.f3304a;
    }

    private boolean a(String str, int i, a aVar, int i2, C0059e c0059e) {
        int iA;
        Uri uri = Uri.parse(a(str, i, aVar));
        int i3 = 0;
        while (true) {
            if (i3 >= 2) {
                iA = -1;
                break;
            }
            if (c0059e != null) {
                try {
                    c0059e.f3316a++;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i3++;
                }
            }
            iA = this.e.a(this.d, uri, 0, i2, 1);
            break;
        }
        if (iA == 0) {
            return true;
        }
        if (c0059e != null) {
            c0059e.b++;
        }
        return false;
    }

    private boolean a(String str, a aVar, int i) {
        int iA;
        Uri uri = Uri.parse(a(str, aVar));
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                iA = -1;
                break;
            }
            try {
                iA = this.e.a(this.d, uri, 0, i, 1);
                break;
            } catch (Throwable unused) {
                try {
                    Thread.sleep(5L);
                } catch (Exception unused2) {
                }
                i2++;
            }
        }
        return iA == 0;
    }
}

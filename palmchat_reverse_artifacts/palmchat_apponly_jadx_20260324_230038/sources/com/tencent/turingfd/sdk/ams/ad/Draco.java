package com.tencent.turingfd.sdk.ams.ad;

import com.umeng.analytics.pro.dn;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Draco {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f10692a;
    public String b = "GBK";

    public Draco(int i) {
        this.f10692a = ByteBuffer.allocate(i);
    }

    public byte[] a() {
        byte[] bArr = new byte[this.f10692a.position()];
        System.arraycopy(this.f10692a.array(), 0, bArr, 0, this.f10692a.position());
        return bArr;
    }

    public void b(byte b, int i) {
        if (i < 15) {
            this.f10692a.put((byte) (b | (i << 4)));
        } else {
            if (i >= 256) {
                throw new Crux(Cygnus.a("tag is too large: ", i));
            }
            this.f10692a.put((byte) (b | 240));
            this.f10692a.put((byte) i);
        }
    }

    public void a(int i) {
        if (this.f10692a.remaining() < i) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((this.f10692a.capacity() + i) * 2);
            byteBufferAllocate.put(this.f10692a.array(), 0, this.f10692a.position());
            this.f10692a = byteBufferAllocate;
        }
    }

    public void a(byte b, int i) {
        a(3);
        if (b == 0) {
            b((byte) 12, i);
        } else {
            b((byte) 0, i);
            this.f10692a.put(b);
        }
    }

    public void a(short s, int i) {
        a(4);
        if (s >= -128 && s <= 127) {
            a((byte) s, i);
        } else {
            b((byte) 1, i);
            this.f10692a.putShort(s);
        }
    }

    public void a(int i, int i2) {
        a(6);
        if (i >= -32768 && i <= 32767) {
            a((short) i, i2);
        } else {
            b((byte) 2, i2);
            this.f10692a.putInt(i);
        }
    }

    public void a(long j, int i) {
        a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            a((int) j, i);
        } else {
            b((byte) 3, i);
            this.f10692a.putLong(j);
        }
    }

    public void a(float f, int i) {
        a(6);
        b((byte) 4, i);
        this.f10692a.putFloat(f);
    }

    public void a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i);
            this.f10692a.putInt(bytes.length);
            this.f10692a.put(bytes);
        } else {
            b((byte) 6, i);
            this.f10692a.put((byte) bytes.length);
            this.f10692a.put(bytes);
        }
    }

    public <K, V> void a(Map<K, V> map, int i) {
        a(8);
        b((byte) 8, i);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    public void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        b(dn.k, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f10692a.put(bArr);
    }

    public <T> void a(Collection<T> collection, int i) {
        a(8);
        b((byte) 9, i);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                a(it.next(), 0);
            }
        }
    }

    public void a(Eridanus eridanus, int i) {
        a(2);
        b((byte) 10, i);
        eridanus.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public void a(Object obj, int i) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i);
            return;
        }
        if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0, i);
            return;
        }
        if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
            return;
        }
        if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
            return;
        }
        if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
            return;
        }
        if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i);
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            a(10);
            b((byte) 5, i);
            this.f10692a.putDouble(dDoubleValue);
            return;
        }
        if (obj instanceof String) {
            a((String) obj, i);
            return;
        }
        if (obj instanceof Map) {
            a((Map) obj, i);
            return;
        }
        if (obj instanceof List) {
            a((Collection) obj, i);
            return;
        }
        if (obj instanceof Eridanus) {
            a((Eridanus) obj, i);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, i);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            a(8);
            b((byte) 9, i);
            a(zArr.length, 0);
            for (boolean z : zArr) {
                a(z ? (byte) 1 : (byte) 0, 0);
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            b((byte) 9, i);
            a(sArr.length, 0);
            for (short s : sArr) {
                a(s, 0);
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            b((byte) 9, i);
            a(iArr.length, 0);
            for (int i2 : iArr) {
                a(i2, 0);
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            b((byte) 9, i);
            a(jArr.length, 0);
            for (long j : jArr) {
                a(j, 0);
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            b((byte) 9, i);
            a(fArr.length, 0);
            for (float f : fArr) {
                a(f, 0);
            }
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            b((byte) 9, i);
            a(dArr.length, 0);
            for (double d : dArr) {
                a(10);
                b((byte) 5, 0);
                this.f10692a.putDouble(d);
            }
            return;
        }
        if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            a(8);
            b((byte) 9, i);
            a(objArr.length, 0);
            for (Object obj2 : objArr) {
                a(obj2, 0);
            }
            return;
        }
        if (obj instanceof Collection) {
            a((Collection) obj, i);
        } else {
            StringBuilder sbA = Banana.a("write object error: unsupport type. ");
            sbA.append(obj.getClass());
            throw new Crux(sbA.toString());
        }
    }
}

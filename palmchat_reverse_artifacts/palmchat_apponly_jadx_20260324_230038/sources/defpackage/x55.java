package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a)\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ljava/io/Serializable;", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "c", ExifInterface.GPS_DIRECTION_TRUE, "bytes", "", "ignoreSUID", "a", "([BZ)Ljava/io/Serializable;", "zx-jvm"}, k = 2, mv = {1, 4, 0})
public final class x55 {
    public static final <T extends Serializable> T a(byte[] bArr, boolean z) throws ClassNotFoundException, IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            Object object = new ObjectInputStream(byteArrayInputStream).readObject();
            if (object != null) {
                return (T) object;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        } catch (InvalidClassException e) {
            if (!z) {
                throw e;
            }
            byteArrayInputStream.reset();
            Object object2 = new kj0(byteArrayInputStream).readObject();
            if (object2 != null) {
                return (T) object2;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
    }

    public static /* synthetic */ Serializable b(byte[] bArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return a(bArr, z);
    }

    public static final byte[] c(Serializable serializable) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        objectOutputStream.flush();
        objectOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkExpressionValueIsNotNull(byteArray, "stm.toByteArray()");
        return byteArray;
    }
}

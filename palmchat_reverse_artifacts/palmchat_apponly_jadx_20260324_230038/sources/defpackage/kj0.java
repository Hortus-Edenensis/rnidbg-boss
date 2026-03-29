package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"Lkj0;", "Ljava/io/ObjectInputStream;", "Ljava/io/ObjectStreamClass;", "readClassDescriptor", "Ljava/io/InputStream;", "input", "<init>", "(Ljava/io/InputStream;)V", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public final class kj0 extends ObjectInputStream {
    public kj0(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.ObjectInputStream
    public ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
        ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
        Intrinsics.checkExpressionValueIsNotNull(resultClassDescriptor, "resultClassDescriptor");
        ObjectStreamClass objectStreamClassLookup = ObjectStreamClass.lookup(Class.forName(resultClassDescriptor.getName()));
        if (objectStreamClassLookup != null) {
            return resultClassDescriptor.getSerialVersionUID() != objectStreamClassLookup.getSerialVersionUID() ? objectStreamClassLookup : resultClassDescriptor;
        }
        return resultClassDescriptor;
    }
}

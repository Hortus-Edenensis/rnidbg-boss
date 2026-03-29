package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public interface v83 extends Closeable {
    boolean isSuccessful();

    @Nullable
    String v();

    @Nullable
    String w();

    @NonNull
    InputStream z() throws IOException;
}

package defpackage;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.loader.content.Loader;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J1\u0010\r\u001a\u00020\f2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0007j\b\u0012\u0004\u0012\u00028\u0000`\b2\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u000f\u001a\u00020\f2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0007j\b\u0012\u0004\u0012\u00028\u0000`\bH&¨\u0006\u0010"}, d2 = {"Lpm2;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "id", "Landroid/os/Bundle;", "args", "Landroidx/loader/content/Loader;", "Lcom/zenmen/palmchat/zx/compat/Loader;", "onCreateLoader", "loader", "data", "", "onLoadFinished", "(Landroidx/loader/content/Loader;Ljava/lang/Object;)V", "onLoaderReset", "zx-compat_release"}, k = 1, mv = {1, 4, 0})
public interface pm2<T> {
    Loader<T> onCreateLoader(int id, Bundle args);

    void onLoadFinished(Loader<T> loader, T data);

    void onLoaderReset(Loader<T> loader);
}

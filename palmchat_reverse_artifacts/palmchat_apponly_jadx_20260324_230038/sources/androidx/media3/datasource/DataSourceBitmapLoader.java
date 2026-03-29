package androidx.media3.datasource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.datasource.DefaultDataSource;
import defpackage.c43;
import defpackage.er3;
import defpackage.qo5;
import defpackage.r33;
import defpackage.ro5;
import defpackage.tt;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class DataSourceBitmapLoader implements BitmapLoader {
    public static final qo5<c43> DEFAULT_EXECUTOR_SERVICE = ro5.a(new qo5() { // from class: zu0
        @Override // defpackage.qo5
        /* JADX INFO: renamed from: get */
        public final Object get2() {
            return DataSourceBitmapLoader.lambda$static$0();
        }
    });
    private final DataSource.Factory dataSourceFactory;
    private final c43 listeningExecutorService;
    private final int maximumOutputDimension;

    @Nullable
    private final BitmapFactory.Options options;

    public DataSourceBitmapLoader(Context context) {
        this((c43) Assertions.checkStateNotNull(DEFAULT_EXECUTOR_SERVICE.get2()), new DefaultDataSource.Factory(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bitmap lambda$decodeBitmap$1(byte[] bArr) throws Exception {
        return BitmapUtil.decode(bArr, bArr.length, this.options, this.maximumOutputDimension);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bitmap lambda$loadBitmap$2(Uri uri) throws Exception {
        return load(this.dataSourceFactory.createDataSource(), uri, this.options, this.maximumOutputDimension);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c43 lambda$static$0() {
        return er3.b(Executors.newSingleThreadExecutor());
    }

    private static Bitmap load(DataSource dataSource, Uri uri, @Nullable BitmapFactory.Options options, int i) throws IOException {
        try {
            dataSource.open(new DataSpec(uri));
            byte[] toEnd = DataSourceUtil.readToEnd(dataSource);
            return BitmapUtil.decode(toEnd, toEnd.length, options, i);
        } finally {
            dataSource.close();
        }
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public r33<Bitmap> decodeBitmap(final byte[] bArr) {
        return this.listeningExecutorService.submit(new Callable() { // from class: yu0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f22279a.lambda$decodeBitmap$1(bArr);
            }
        });
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public r33<Bitmap> loadBitmap(final Uri uri) {
        return this.listeningExecutorService.submit(new Callable() { // from class: av0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1576a.lambda$loadBitmap$2(uri);
            }
        });
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public /* synthetic */ r33 loadBitmapFromMetadata(MediaMetadata mediaMetadata) {
        return tt.a(this, mediaMetadata);
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public boolean supportsMimeType(String str) {
        return Util.isBitmapFactorySupportedMimeType(str);
    }

    public DataSourceBitmapLoader(c43 c43Var, DataSource.Factory factory) {
        this(c43Var, factory, null);
    }

    public DataSourceBitmapLoader(c43 c43Var, DataSource.Factory factory, @Nullable BitmapFactory.Options options) {
        this(c43Var, factory, options, -1);
    }

    public DataSourceBitmapLoader(c43 c43Var, DataSource.Factory factory, @Nullable BitmapFactory.Options options, int i) {
        this.listeningExecutorService = c43Var;
        this.dataSourceFactory = factory;
        this.options = options;
        this.maximumOutputDimension = i;
    }
}

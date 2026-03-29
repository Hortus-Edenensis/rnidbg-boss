package defpackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.Preconditions;
import com.huawei.hms.ads.ld;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class va3 implements DataFetcher<InputStream>, Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Call.Factory f21392a;
    public final GlideUrl b;
    public InputStream c;
    public ResponseBody d;
    public DataFetcher.DataCallback<? super InputStream> e;
    public volatile Call f;
    public boolean g = false;

    public va3(Call.Factory factory, GlideUrl glideUrl) {
        this.f21392a = factory;
        this.b = glideUrl;
    }

    public final String a(String str) {
        return str != null ? str.replace("cdnavatar.youni.im", "avatar.cdn.lianxinapp.com") : str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.g = true;
        Call call = this.f;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        try {
            InputStream inputStream = this.c;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.d;
        if (responseBody != null) {
            responseBody.close();
        }
        this.e = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        Request.Builder builderUrl = new Request.Builder().url(a(k86.S(this.b.toStringUrl(), true)));
        for (Map.Entry<String, String> entry : this.b.getHeaders().entrySet()) {
            builderUrl.addHeader(entry.getKey(), entry.getValue());
        }
        Request requestBuild = builderUrl.build();
        this.e = dataCallback;
        this.f = this.f21392a.newCall(requestBuild);
        this.f.enqueue(this);
    }

    @Override // okhttp3.Callback
    public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.e.onLoadFailed(iOException);
        if (this.g) {
            return;
        }
        HashMap map = new HashMap();
        if (this.b.toStringUrl() != null) {
            map.put(ld.f6599a, this.b.toStringUrl());
        }
        LogUtil.log4ClientError("Media_load_fail_ImageError", map, iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(@NonNull Call call, @NonNull Response response) {
        this.d = response.body();
        if (response.isSuccessful()) {
            InputStream inputStreamObtain = ContentLengthInputStream.obtain(this.d.byteStream(), ((ResponseBody) Preconditions.checkNotNull(this.d)).getContentLength());
            this.c = inputStreamObtain;
            this.e.onDataReady(inputStreamObtain);
            return;
        }
        HttpException httpException = new HttpException(response.message(), response.code());
        this.e.onLoadFailed(httpException);
        HashMap map = new HashMap();
        if (this.b.toStringUrl() != null) {
            map.put(ld.f6599a, this.b.toStringUrl());
        }
        LogUtil.log4ClientError("Media_load_fail_ImageError2", map, httpException);
    }
}

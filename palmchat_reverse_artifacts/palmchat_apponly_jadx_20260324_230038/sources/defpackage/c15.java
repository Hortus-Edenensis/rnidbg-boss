package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.http.HttpResponseCache;
import android.os.Handler;
import android.os.Looper;
import com.cdo.oaps.ad.Launcher;
import com.huawei.openalliance.ad.constant.bq;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.opensource.svgaplayer.SVGACache;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ?2\u00020\u0001:\u0004036\fB\u0011\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b=\u0010>J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J(\u0010\r\u001a\u00020\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eJ$\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"J,\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'2\u0006\u0010&\u001a\u00020%2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"J.\u0010)\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006JB\u0010+\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010*\u001a\u00020\u00172\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0018\u0010.\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00101R\"\u0010<\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lc15;", "", "Lm15;", "videoItem", "Lc15$d;", bq.f.L, "", "alias", "", "x", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "y", "cacheKey", "p", "Ljava/io/InputStream;", "inputStream", "", "A", "byteArray", "v", "bytes", "", "z", WkAdxAdConfigMg.DSP_NAME_BAIDU, "Ljava/io/File;", "outputFile", "dstDirPath", "u", "Landroid/content/Context;", "context", RXScreenCaptureService.KEY_WIDTH, "name", "Lc15$e;", "playCallback", "n", "Ljava/net/URL;", "url", "Lkotlin/Function0;", "s", t.k, "closeInputStream", "q", "a", "Landroid/content/Context;", "mContext", "", t.l, "I", "mFrameWidth", "c", "mFrameHeight", "Lc15$c;", "d", "Lc15$c;", "getFileDownloader", "()Lc15$c;", "setFileDownloader", "(Lc15$c;)V", "fileDownloader", "<init>", "(Landroid/content/Context;)V", "h", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class c15 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Context mContext;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public volatile int mFrameWidth;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public volatile int mFrameHeight;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public c fileDownloader;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final AtomicInteger e = new AtomicInteger(0);
    public static c15 f = new c15(null);
    public static ExecutorService g = Executors.newCachedThreadPool(a.f1870a);

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/lang/Thread;", t.k, "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "newThread"}, k = 3, mv = {1, 1, 15})
    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1870a = new a();

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SVGAParser-Thread-" + c15.e.getAndIncrement());
        }
    }

    /* JADX INFO: renamed from: c15$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lc15$b;", "", "Lc15;", t.l, "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "threadPoolExecutor", "Ljava/util/concurrent/ExecutorService;", "a", "()Ljava/util/concurrent/ExecutorService;", "setThreadPoolExecutor$com_opensource_svgaplayer", "(Ljava/util/concurrent/ExecutorService;)V", "", "TAG", "Ljava/lang/String;", "mShareParser", "Lc15;", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadNum", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public final ExecutorService a() {
            return c15.g;
        }

        public final c15 b() {
            return c15.f;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J`\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00042%\u0010\u000e\u001a!\u0012\u0017\u0012\u00150\u000bj\u0002`\f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0004H\u0016R\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lc15$c;", "", "Ljava/net/URL;", "url", "Lkotlin/Function1;", "Ljava/io/InputStream;", "Lkotlin/ParameterName;", "name", "inputStream", "", "complete", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "failure", "Lkotlin/Function0;", t.l, "", "a", "Z", "()Z", "setNoCache", "(Z)V", "noCache", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public boolean noCache;

        /* JADX INFO: compiled from: SearchBox */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
        public static final class a implements Runnable {
            public final /* synthetic */ URL b;
            public final /* synthetic */ Ref.BooleanRef c;
            public final /* synthetic */ Function1 d;
            public final /* synthetic */ Function1 e;

            public a(URL url, Ref.BooleanRef booleanRef, Function1 function1, Function1 function12) {
                this.b = url;
                this.c = booleanRef;
                this.d = function1;
                this.e = function12;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    h63 h63Var = h63.f17877a;
                    h63Var.e("SVGAParser", "================ svga file download start ================");
                    if (HttpResponseCache.getInstalled() == null && !c.this.getNoCache()) {
                        h63Var.b("SVGAParser", "SVGAParser can not handle cache before install HttpResponseCache. see https://github.com/yyued/SVGAPlayer-Android#cache");
                        h63Var.b("SVGAParser", "在配置 HttpResponseCache 前 SVGAParser 无法缓存. 查看 https://github.com/yyued/SVGAPlayer-Android#cache ");
                    }
                    URLConnection uRLConnectionOpenConnection = this.b.openConnection();
                    if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                        uRLConnectionOpenConnection = null;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.setConnectTimeout(20000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Connection", "close");
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    if (this.c.element) {
                                        h63.f17877a.f("SVGAParser", "================ svga file download canceled ================");
                                        break;
                                    }
                                    int i = inputStream.read(bArr, 0, 4096);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, i);
                                    }
                                }
                                if (this.c.element) {
                                    h63.f17877a.f("SVGAParser", "================ svga file download canceled ================");
                                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                                    CloseableKt.closeFinally(inputStream, null);
                                    return;
                                }
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                try {
                                    h63.f17877a.e("SVGAParser", "================ svga file download complete ================");
                                    this.d.invoke(byteArrayInputStream);
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(byteArrayInputStream, null);
                                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                                    CloseableKt.closeFinally(inputStream, null);
                                    return;
                                } finally {
                                }
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                    }
                } catch (Exception e) {
                    h63 h63Var2 = h63.f17877a;
                    h63Var2.b("SVGAParser", "================ svga file download fail ================");
                    h63Var2.b("SVGAParser", "error: " + e.getMessage());
                    e.printStackTrace();
                    this.e.invoke(e);
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", Launcher.Method.INVOKE_CALLBACK}, k = 3, mv = {1, 1, 15})
        public static final class b extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Ref.BooleanRef b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Ref.BooleanRef booleanRef) {
                super(0);
                this.b = booleanRef;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.b.element = true;
            }
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getNoCache() {
            return this.noCache;
        }

        public Function0<Unit> b(URL url, Function1<? super InputStream, Unit> complete, Function1<? super Exception, Unit> failure) {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            b bVar = new b(booleanRef);
            c15.INSTANCE.a().execute(new a(url, booleanRef, complete, failure));
            return bVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&¨\u0006\u0007"}, d2 = {"Lc15$d;", "", "Lm15;", "videoItem", "", "onComplete", "onError", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public interface d {
        void onComplete(m15 videoItem);

        void onError();
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¨\u0006\u0007"}, d2 = {"Lc15$e;", "", "", "Ljava/io/File;", "file", "", "onPlay", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public interface e {
        void onPlay(List<? extends File> file);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class f implements Runnable {
        public final /* synthetic */ String b;
        public final /* synthetic */ d c;
        public final /* synthetic */ e d;

        public f(String str, d dVar, e eVar) {
            this.b = str;
            this.c = dVar;
            this.d = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AssetManager assets;
            InputStream inputStreamOpen;
            try {
                Context context = c15.this.mContext;
                if (context == null || (assets = context.getAssets()) == null || (inputStreamOpen = assets.open(this.b)) == null) {
                    return;
                }
                c15.this.q(inputStreamOpen, SVGACache.c.c("file:///assets/" + this.b), this.c, true, this.d, this.b);
            } catch (Exception e) {
                c15.this.y(e, this.c, this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class g implements Runnable {
        public final /* synthetic */ InputStream b;
        public final /* synthetic */ String c;
        public final /* synthetic */ d d;
        public final /* synthetic */ String e;
        public final /* synthetic */ e f;
        public final /* synthetic */ boolean g;

        /* JADX INFO: compiled from: SearchBox */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/opensource/svgaplayer/SVGAParser$decodeFromInputStream$1$1$2"}, k = 3, mv = {1, 1, 15})
        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ byte[] f1875a;
            public final /* synthetic */ g b;

            public a(byte[] bArr, g gVar) {
                this.f1875a = bArr;
                this.b = gVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                File fileE = SVGACache.c.e(this.b.c);
                try {
                    File file = fileE.exists() ^ true ? fileE : null;
                    if (file != null) {
                        file.createNewFile();
                    }
                    new FileOutputStream(fileE).write(this.f1875a);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    h63.f17877a.c("SVGAParser", "create cache file fail.", e);
                    fileE.delete();
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", Launcher.Method.INVOKE_CALLBACK, "com/opensource/svgaplayer/SVGAParser$decodeFromInputStream$1$1$3$1", "com/opensource/svgaplayer/SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$1"}, k = 3, mv = {1, 1, 15})
        public static final class b extends Lambda implements Function0<Unit> {
            public final /* synthetic */ m15 b;
            public final /* synthetic */ g c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(m15 m15Var, g gVar) {
                super(0);
                this.b = m15Var;
                this.c = gVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                h63.f17877a.e("SVGAParser", "SVGAVideoEntity prepare success");
                g gVar = this.c;
                c15.this.x(this.b, gVar.d, gVar.e);
            }
        }

        public g(InputStream inputStream, String str, d dVar, String str2, e eVar, boolean z) {
            this.b = inputStream;
            this.c = str;
            this.d = dVar;
            this.e = str2;
            this.f = eVar;
            this.g = z;
        }

        @Override // java.lang.Runnable
        public final void run() throws IOException {
            h63 h63Var;
            String str;
            StringBuilder sb;
            try {
                try {
                    byte[] bArrA = c15.this.A(this.b);
                    if (bArrA == null) {
                        c15.this.y(new Exception("readAsBytes(inputStream) cause exception"), this.d, this.e);
                    } else if (c15.this.z(bArrA)) {
                        h63 h63Var2 = h63.f17877a;
                        h63Var2.e("SVGAParser", "decode from zip file");
                        SVGACache sVGACache = SVGACache.c;
                        if (!sVGACache.b(this.c).exists() || d15.b) {
                            synchronized (Integer.valueOf(d15.f16960a)) {
                                if (!sVGACache.b(this.c).exists()) {
                                    d15.b = true;
                                    h63Var2.e("SVGAParser", "no cached, prepare to unzip");
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrA);
                                    try {
                                        c15.this.B(byteArrayInputStream, this.c);
                                        d15.b = false;
                                        h63Var2.e("SVGAParser", "unzip success");
                                        Unit unit = Unit.INSTANCE;
                                        CloseableKt.closeFinally(byteArrayInputStream, null);
                                    } finally {
                                    }
                                }
                                Unit unit2 = Unit.INSTANCE;
                            }
                        }
                        c15.this.p(this.c, this.d, this.e);
                    } else {
                        if (!SVGACache.c.i()) {
                            c15.INSTANCE.a().execute(new a(bArrA, this));
                        }
                        h63 h63Var3 = h63.f17877a;
                        h63Var3.e("SVGAParser", "inflate start");
                        byte[] bArrV = c15.this.v(bArrA);
                        if (bArrV != null) {
                            h63Var3.e("SVGAParser", "inflate complete");
                            MovieEntity movieEntityDecode = MovieEntity.ADAPTER.decode(bArrV);
                            Intrinsics.checkExpressionValueIsNotNull(movieEntityDecode, "MovieEntity.ADAPTER.decode(it)");
                            m15 m15Var = new m15(movieEntityDecode, new File(this.c), c15.this.mFrameWidth, c15.this.mFrameHeight);
                            h63Var3.e("SVGAParser", "SVGAVideoEntity prepare start");
                            m15Var.u(new b(m15Var, this), this.f);
                        } else {
                            c15.this.y(new Exception("inflate(bytes) cause exception"), this.d, this.e);
                        }
                    }
                    if (this.g) {
                        this.b.close();
                    }
                    h63Var = h63.f17877a;
                    str = "SVGAParser";
                    sb = new StringBuilder();
                } catch (Exception e) {
                    c15.this.y(e, this.d, this.e);
                    if (this.g) {
                        this.b.close();
                    }
                    h63Var = h63.f17877a;
                    str = "SVGAParser";
                    sb = new StringBuilder();
                }
                sb.append("================ decode ");
                sb.append(this.e);
                sb.append(" from input stream end ================");
                h63Var.e(str, sb.toString());
            } catch (Throwable th) {
                if (this.g) {
                    this.b.close();
                }
                h63.f17877a.e("SVGAParser", "================ decode " + this.e + " from input stream end ================");
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class h implements Runnable {
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ d d;
        public final /* synthetic */ e e;

        /* JADX INFO: compiled from: SearchBox */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0005"}, d2 = {"<anonymous>", "", Launcher.Method.INVOKE_CALLBACK, "com/opensource/svgaplayer/SVGAParser$decodeFromSVGAFileCacheKey$1$1$1$1$1", "com/opensource/svgaplayer/SVGAParser$decodeFromSVGAFileCacheKey$1$$special$$inlined$let$lambda$1", "com/opensource/svgaplayer/SVGAParser$decodeFromSVGAFileCacheKey$1$$special$$inlined$let$lambda$2"}, k = 3, mv = {1, 1, 15})
        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ m15 b;
            public final /* synthetic */ h c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(m15 m15Var, h hVar) {
                super(0);
                this.b = m15Var;
                this.c = hVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                h63.f17877a.e("SVGAParser", "SVGAVideoEntity prepare success");
                h hVar = this.c;
                c15.this.x(this.b, hVar.d, hVar.b);
            }
        }

        public h(String str, String str2, d dVar, e eVar) {
            this.b = str;
            this.c = str2;
            this.d = dVar;
            this.e = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h63 h63Var;
            StringBuilder sb;
            FileInputStream fileInputStream;
            try {
                try {
                    h63Var = h63.f17877a;
                    h63Var.e("SVGAParser", "================ decode " + this.b + " from svga cachel file to entity ================");
                    fileInputStream = new FileInputStream(SVGACache.c.e(this.c));
                } catch (Exception e) {
                    c15.this.y(e, this.d, this.b);
                    h63Var = h63.f17877a;
                    sb = new StringBuilder();
                }
                try {
                    byte[] bArrA = c15.this.A(fileInputStream);
                    if (bArrA == null) {
                        c15.this.y(new Exception("readAsBytes(inputStream) cause exception"), this.d, this.b);
                    } else if (c15.this.z(bArrA)) {
                        c15.this.p(this.c, this.d, this.b);
                    } else {
                        h63Var.e("SVGAParser", "inflate start");
                        byte[] bArrV = c15.this.v(bArrA);
                        if (bArrV != null) {
                            h63Var.e("SVGAParser", "inflate complete");
                            MovieEntity movieEntityDecode = MovieEntity.ADAPTER.decode(bArrV);
                            Intrinsics.checkExpressionValueIsNotNull(movieEntityDecode, "MovieEntity.ADAPTER.decode(it)");
                            m15 m15Var = new m15(movieEntityDecode, new File(this.c), c15.this.mFrameWidth, c15.this.mFrameHeight);
                            h63Var.e("SVGAParser", "SVGAVideoEntity prepare start");
                            m15Var.u(new a(m15Var, this), this.e);
                        } else {
                            c15.this.y(new Exception("inflate(bytes) cause exception"), this.d, this.b);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    sb = new StringBuilder();
                    sb.append("================ decode ");
                    sb.append(this.b);
                    sb.append(" from svga cachel file to entity end ================");
                    h63Var.e("SVGAParser", sb.toString());
                } finally {
                }
            } catch (Throwable th) {
                h63.f17877a.e("SVGAParser", "================ decode " + this.b + " from svga cachel file to entity end ================");
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class i implements Runnable {
        public final /* synthetic */ String b;
        public final /* synthetic */ d c;
        public final /* synthetic */ String d;
        public final /* synthetic */ e e;

        public i(String str, d dVar, String str2, e eVar) {
            this.b = str;
            this.c = dVar;
            this.d = str2;
            this.e = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (SVGACache.c.i()) {
                c15.this.p(this.b, this.c, this.d);
            } else {
                c15.this.r(this.b, this.c, this.e, this.d);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/io/InputStream;", o.f, "", "a", "(Ljava/io/InputStream;)V"}, k = 3, mv = {1, 4, 0})
    public static final class j extends Lambda implements Function1<InputStream, Unit> {
        public final /* synthetic */ String c;
        public final /* synthetic */ d d;
        public final /* synthetic */ e e;
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, d dVar, e eVar, String str2) {
            super(1);
            this.c = str;
            this.d = dVar;
            this.e = eVar;
            this.f = str2;
        }

        public final void a(InputStream inputStream) {
            c15.this.q(inputStream, this.c, this.d, false, this.e, this.f);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InputStream inputStream) {
            a(inputStream);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", o.f, "", "a", "(Ljava/lang/Exception;)V"}, k = 3, mv = {1, 4, 0})
    public static final class k extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ URL c;
        public final /* synthetic */ d d;
        public final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(URL url, d dVar, String str) {
            super(1);
            this.c = url;
            this.d = dVar;
            this.e = str;
        }

        public final void a(Exception exc) {
            h63.f17877a.b("SVGAParser", "================ svga file: " + this.c + " download fail ================");
            c15.this.y(exc, this.d, this.e);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
            a(exc);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1878a;
        public final /* synthetic */ d b;
        public final /* synthetic */ m15 c;

        public l(String str, d dVar, m15 m15Var) {
            this.f1878a = str;
            this.b = dVar;
            this.c = m15Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h63.f17877a.e("SVGAParser", "================ " + this.f1878a + " parser complete ================");
            d dVar = this.b;
            if (dVar != null) {
                dVar.onComplete(this.c);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f1879a;

        public m(d dVar) {
            this.f1879a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d dVar = this.f1879a;
            if (dVar != null) {
                dVar.onError();
            }
        }
    }

    public c15(Context context) {
        this.mContext = context != null ? context.getApplicationContext() : null;
        SVGACache.c.k(context);
        this.fileDownloader = new c();
    }

    public static /* synthetic */ void o(c15 c15Var, String str, d dVar, e eVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            eVar = null;
        }
        c15Var.n(str, dVar, eVar);
    }

    public static /* synthetic */ Function0 t(c15 c15Var, URL url, d dVar, e eVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            eVar = null;
        }
        return c15Var.s(url, dVar, eVar);
    }

    public final byte[] A(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int i2 = inputStream.read(bArr, 0, 2048);
                if (i2 <= 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } finally {
        }
    }

    public final void B(InputStream inputStream, String cacheKey) throws Exception {
        ZipInputStream zipInputStream;
        h63.f17877a.e("SVGAParser", "================ unzip prepare ================");
        File fileB = SVGACache.c.b(cacheKey);
        fileB.mkdirs();
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                zipInputStream = new ZipInputStream(bufferedInputStream);
            } finally {
            }
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(zipInputStream, null);
                        CloseableKt.closeFinally(bufferedInputStream, null);
                        return;
                    }
                    String name = nextEntry.getName();
                    Intrinsics.checkExpressionValueIsNotNull(name, "zipItem.name");
                    if (!StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "../", false, 2, (Object) null)) {
                        String name2 = nextEntry.getName();
                        Intrinsics.checkExpressionValueIsNotNull(name2, "zipItem.name");
                        if (!StringsKt__StringsKt.contains$default((CharSequence) name2, (CharSequence) "/", false, 2, (Object) null)) {
                            File file = new File(fileB, nextEntry.getName());
                            String absolutePath = fileB.getAbsolutePath();
                            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "cacheDir.absolutePath");
                            u(file, absolutePath);
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[2048];
                                while (true) {
                                    int i2 = zipInputStream.read(bArr);
                                    if (i2 <= 0) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr, 0, i2);
                                    }
                                }
                                Unit unit2 = Unit.INSTANCE;
                                CloseableKt.closeFinally(fileOutputStream, null);
                                h63.f17877a.b("SVGAParser", "================ unzip complete ================");
                                zipInputStream.closeEntry();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        } catch (Exception e2) {
            h63 h63Var = h63.f17877a;
            h63Var.b("SVGAParser", "================ unzip error ================");
            h63Var.c("SVGAParser", "error", e2);
            SVGACache sVGACache = SVGACache.c;
            String absolutePath2 = fileB.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath2, "cacheDir.absolutePath");
            sVGACache.f(absolutePath2);
            fileB.delete();
            throw e2;
        }
    }

    public final void n(String name, d callback, e playCallback) {
        if (this.mContext == null) {
            h63.f17877a.b("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        h63.f17877a.e("SVGAParser", "================ decode " + name + " from assets ================");
        g.execute(new f(name, callback, playCallback));
    }

    public final void p(String cacheKey, d callback, String alias) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        h63 h63Var = h63.f17877a;
        h63Var.e("SVGAParser", "================ decode " + alias + " from cache ================");
        StringBuilder sb = new StringBuilder();
        sb.append("decodeFromCacheKey called with cacheKey : ");
        sb.append(cacheKey);
        h63Var.a("SVGAParser", sb.toString());
        if (this.mContext == null) {
            h63Var.b("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        try {
            File fileB = SVGACache.c.b(cacheKey);
            File file = new File(fileB, "movie.binary");
            if (!file.isFile()) {
                file = null;
            }
            if (file != null) {
                try {
                    h63Var.e("SVGAParser", "binary change to entity");
                    fileInputStream = new FileInputStream(file);
                    try {
                        h63Var.e("SVGAParser", "binary change to entity success");
                        MovieEntity movieEntityDecode = MovieEntity.ADAPTER.decode(fileInputStream);
                        Intrinsics.checkExpressionValueIsNotNull(movieEntityDecode, "MovieEntity.ADAPTER.decode(it)");
                        x(new m15(movieEntityDecode, fileB, this.mFrameWidth, this.mFrameHeight), callback, alias);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileInputStream, null);
                    } finally {
                    }
                } catch (Exception e2) {
                    h63.f17877a.c("SVGAParser", "binary change to entity fail", e2);
                    fileB.delete();
                    file.delete();
                    throw e2;
                }
            }
            File file2 = new File(fileB, "movie.spec");
            if (!file2.isFile()) {
                file2 = null;
            }
            if (file2 == null) {
                return;
            }
            try {
                h63Var.e("SVGAParser", "spec change to entity");
                fileInputStream = new FileInputStream(file2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i2 = fileInputStream.read(bArr, 0, 2048);
                        if (i2 == -1) {
                            JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                            h63.f17877a.e("SVGAParser", "spec change to entity success");
                            x(new m15(jSONObject, fileB, this.mFrameWidth, this.mFrameHeight), callback, alias);
                            Unit unit2 = Unit.INSTANCE;
                            CloseableKt.closeFinally(byteArrayOutputStream, null);
                            CloseableKt.closeFinally(fileInputStream, null);
                            return;
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                        throw th;
                    }
                } finally {
                }
            } catch (Exception e3) {
                h63.f17877a.c("SVGAParser", alias + " movie.spec change to entity fail", e3);
                fileB.delete();
                file2.delete();
                throw e3;
            }
        } catch (Exception e4) {
            y(e4, callback, alias);
        }
    }

    public final void q(InputStream inputStream, String cacheKey, d callback, boolean closeInputStream, e playCallback, String alias) {
        if (this.mContext == null) {
            h63.f17877a.b("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        h63.f17877a.e("SVGAParser", "================ decode " + alias + " from input stream ================");
        g.execute(new g(inputStream, cacheKey, callback, alias, playCallback, closeInputStream));
    }

    public final void r(String cacheKey, d callback, e playCallback, String alias) {
        g.execute(new h(alias, cacheKey, callback, playCallback));
    }

    public final Function0<Unit> s(URL url, d callback, e playCallback) {
        if (this.mContext == null) {
            h63.f17877a.b("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return null;
        }
        String string = url.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "url.toString()");
        h63 h63Var = h63.f17877a;
        h63Var.e("SVGAParser", "================ decode from url: " + string + " ================");
        SVGACache sVGACache = SVGACache.c;
        String strD = sVGACache.d(url);
        if (!sVGACache.h(strD)) {
            h63Var.e("SVGAParser", "no cached, prepare to download");
            return this.fileDownloader.b(url, new j(strD, callback, playCallback, string), new k(url, callback, string));
        }
        h63Var.e("SVGAParser", "this url cached");
        g.execute(new i(strD, callback, string, playCallback));
        return null;
    }

    public final void u(File outputFile, String dstDirPath) throws IOException {
        String dstDirCanonicalPath = new File(dstDirPath).getCanonicalPath();
        String outputFileCanonicalPath = outputFile.getCanonicalPath();
        Intrinsics.checkExpressionValueIsNotNull(outputFileCanonicalPath, "outputFileCanonicalPath");
        Intrinsics.checkExpressionValueIsNotNull(dstDirCanonicalPath, "dstDirCanonicalPath");
        if (StringsKt__StringsJVMKt.startsWith$default(outputFileCanonicalPath, dstDirCanonicalPath, false, 2, null)) {
            return;
        }
        throw new IOException("Found Zip Path Traversal Vulnerability with " + dstDirCanonicalPath);
    }

    public final byte[] v(byte[] byteArray) {
        Inflater inflater = new Inflater();
        inflater.setInput(byteArray, 0, byteArray.length);
        byte[] bArr = new byte[2048];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int iInflate = inflater.inflate(bArr, 0, 2048);
                if (iInflate <= 0) {
                    inflater.end();
                    byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    return byteArray2;
                }
                byteArrayOutputStream.write(bArr, 0, iInflate);
            } finally {
            }
        }
    }

    public final void w(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        SVGACache.c.k(applicationContext);
    }

    public final void x(m15 videoItem, d callback, String alias) {
        new Handler(Looper.getMainLooper()).post(new l(alias, callback, videoItem));
    }

    public final void y(Exception e2, d callback, String alias) {
        e2.printStackTrace();
        h63 h63Var = h63.f17877a;
        h63Var.b("SVGAParser", "================ " + alias + " parser error ================");
        StringBuilder sb = new StringBuilder();
        sb.append(alias);
        sb.append(" parse error");
        h63Var.c("SVGAParser", sb.toString(), e2);
        new Handler(Looper.getMainLooper()).post(new m(callback));
    }

    public final boolean z(byte[] bytes) {
        return bytes.length > 4 && bytes[0] == 80 && bytes[1] == 75 && bytes[2] == 3 && bytes[3] == 4;
    }
}

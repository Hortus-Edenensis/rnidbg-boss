package defpackage;

import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.SoundPool;
import com.amap.api.col.p0002sl.hb;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.cdo.oaps.ad.Launcher;
import com.huawei.openalliance.ad.constant.bq;
import com.kuaishou.weapon.p0.t;
import com.opensource.svgaplayer.SVGACache;
import com.opensource.svgaplayer.proto.AudioEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.opensource.svgaplayer.proto.MovieParams;
import com.opensource.svgaplayer.proto.SpriteEntity;
import com.qq.gdt.action.ActionUtils;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import defpackage.c15;
import defpackage.l15;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010r\u001a\u00020!\u0012\u0006\u0010s\u001a\u00020I\u0012\u0006\u0010t\u001a\u00020I¢\u0006\u0004\bu\u0010vB)\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010r\u001a\u00020!\u0012\u0006\u0010s\u001a\u00020I\u0012\u0006\u0010t\u001a\u00020I¢\u0006\u0004\bu\u0010wJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u001e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0002J$\u0010$\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u001e2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020!0 H\u0002J\u0018\u0010'\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0015H\u0002J\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u001c\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150 2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u001e\u0010*\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J'\u00100\u001a\u00020\u00042\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b2\b\u0010/\u001a\u0004\u0018\u00010.H\u0000¢\u0006\u0004\b0\u00101J\u0006\u00102\u001a\u00020\u0004R\u0014\u00105\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u00104R\"\u0010<\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010B\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010H\u001a\u00020C2\u0006\u0010D\u001a\u00020C8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0017\u0010E\u001a\u0004\bF\u0010GR$\u0010M\u001a\u00020I2\u0006\u0010D\u001a\u00020I8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b$\u0010J\u001a\u0004\bK\u0010LR$\u0010O\u001a\u00020I2\u0006\u0010D\u001a\u00020I8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b'\u0010J\u001a\u0004\bN\u0010LR(\u0010W\u001a\b\u0012\u0004\u0012\u00020Q0P8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR(\u0010Z\u001a\b\u0012\u0004\u0012\u00020#0P8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010R\u001a\u0004\bX\u0010T\"\u0004\bY\u0010VR$\u0010`\u001a\u0004\u0018\u00010+8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010bR.\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b8\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010jR\u0016\u0010l\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010JR\u0016\u0010m\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010JR\u0018\u0010o\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010nR\u001c\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\\\u0010p¨\u0006x"}, d2 = {"Lm15;", "", "Lorg/json/JSONObject;", "movieObject", "", "z", "Lcom/opensource/svgaplayer/proto/MovieParams;", "movieParams", "A", BodyData.TYPE_JSON, "t", "", "imgName", "imgKey", "i", "filePath", "Landroid/graphics/Bitmap;", "c", "Lcom/opensource/svgaplayer/proto/MovieEntity;", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "s", "", "byteArray", "d", RXScreenCaptureService.KEY_WIDTH, "entity", "v", "Lkotlin/Function0;", "completionBlock", "y", "Lcom/opensource/svgaplayer/proto/AudioEntity;", "audio", "Ljava/util/HashMap;", "Ljava/io/File;", "audiosFileMap", "Lr05;", "e", "audioCache", ActionUtils.PAYMENT_AMOUNT, "f", "g", "h", WkAdxAdConfigMg.DSP_NAME_BAIDU, "Landroid/media/SoundPool;", hb.j, bq.f.L, "Lc15$e;", "playCallback", "u", "(Lkotlin/jvm/functions/Function0;Lc15$e;)V", t.l, "a", "Ljava/lang/String;", "TAG", "", "Z", t.f7496a, "()Z", "x", "(Z)V", "antiAlias", "Lcom/opensource/svgaplayer/proto/MovieEntity;", "getMovieItem", "()Lcom/opensource/svgaplayer/proto/MovieEntity;", "setMovieItem", "(Lcom/opensource/svgaplayer/proto/MovieEntity;)V", "movieItem", "Li15;", "<set-?>", "Li15;", t.k, "()Li15;", "videoSize", "", "I", "m", "()I", "FPS", "n", "frames", "", "Lp15;", "Ljava/util/List;", "q", "()Ljava/util/List;", "setSpriteList$com_opensource_svgaplayer", "(Ljava/util/List;)V", "spriteList", "l", "setAudioList$com_opensource_svgaplayer", "audioList", "Landroid/media/SoundPool;", "p", "()Landroid/media/SoundPool;", "setSoundPool$com_opensource_svgaplayer", "(Landroid/media/SoundPool;)V", "soundPool", "Ll15$a;", "Ll15$a;", "soundCallback", "Ljava/util/HashMap;", "o", "()Ljava/util/HashMap;", "setImageMap$com_opensource_svgaplayer", "(Ljava/util/HashMap;)V", "imageMap", "Ljava/io/File;", "mCacheDir", "mFrameHeight", "mFrameWidth", "Lc15$e;", "mPlayCallback", "Lkotlin/jvm/functions/Function0;", "mCallback", "cacheDir", "frameWidth", "frameHeight", "<init>", "(Lorg/json/JSONObject;Ljava/io/File;II)V", "(Lcom/opensource/svgaplayer/proto/MovieEntity;Ljava/io/File;II)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class m15 {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public MovieEntity movieItem;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public int frames;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public SoundPool soundPool;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public l15.a soundCallback;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public File mCacheDir;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int mFrameHeight;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int mFrameWidth;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public c15.e mPlayCallback;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public Function0<Unit> mCallback;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String TAG = "SVGAVideoEntity";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public boolean antiAlias = true;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public i15 videoSize = new i15(0.0d, 0.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public int FPS = 15;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public List<p15> spriteList = CollectionsKt__CollectionsKt.emptyList();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public List<r05> audioList = CollectionsKt__CollectionsKt.emptyList();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public HashMap<String, Bitmap> imageMap = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", Launcher.Method.INVOKE_CALLBACK}, k = 3, mv = {1, 1, 15})
    public static final class a extends Lambda implements Function0<Unit> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            m15.a(m15.this).invoke();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"m15$b", "Ll15$a;", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class b implements l15.a {
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ MovieEntity c;
        public final /* synthetic */ Function0 d;

        public b(Ref.IntRef intRef, MovieEntity movieEntity, Function0 function0) {
            this.b = intRef;
            this.c = movieEntity;
            this.d = function0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/media/SoundPool;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "onLoadComplete"}, k = 3, mv = {1, 1, 15})
    public static final class c implements SoundPool.OnLoadCompleteListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f19125a;
        public final /* synthetic */ MovieEntity b;
        public final /* synthetic */ Function0 c;

        public c(Ref.IntRef intRef, MovieEntity movieEntity, Function0 function0) {
            this.f19125a = intRef;
            this.b = movieEntity;
            this.c = function0;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
            h63.f17877a.e("SVGAParser", "pool_complete");
            Ref.IntRef intRef = this.f19125a;
            int i3 = intRef.element + 1;
            intRef.element = i3;
            List<AudioEntity> list = this.b.audios;
            Intrinsics.checkExpressionValueIsNotNull(list, "entity.audios");
            if (i3 >= list.size()) {
                this.c.invoke();
            }
        }
    }

    public m15(JSONObject jSONObject, File file, int i, int i2) {
        this.mFrameWidth = i;
        this.mFrameHeight = i2;
        this.mCacheDir = file;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("movie");
        if (jSONObjectOptJSONObject != null) {
            z(jSONObjectOptJSONObject);
            try {
                t(jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
            w(jSONObject);
        }
    }

    public static final /* synthetic */ Function0 a(m15 m15Var) {
        Function0<Unit> function0 = m15Var.mCallback;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallback");
        }
        return function0;
    }

    public final void A(MovieParams movieParams) {
        Float f = movieParams.viewBoxWidth;
        this.videoSize = new i15(0.0d, 0.0d, f != null ? f.floatValue() : 0.0f, movieParams.viewBoxHeight != null ? r0.floatValue() : 0.0f);
        Integer num = movieParams.fps;
        this.FPS = num != null ? num.intValue() : 20;
        Integer num2 = movieParams.frames;
        this.frames = num2 != null ? num2.intValue() : 0;
    }

    public final void B(MovieEntity entity, Function0<Unit> completionBlock) {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        if (l15.e.b()) {
            this.soundCallback = new b(intRef, entity, completionBlock);
            return;
        }
        this.soundPool = j(entity);
        h63.f17877a.e("SVGAParser", "pool_start");
        SoundPool soundPool = this.soundPool;
        if (soundPool != null) {
            soundPool.setOnLoadCompleteListener(new c(intRef, entity, completionBlock));
        }
    }

    public final void b() {
        if (l15.e.b()) {
            Iterator<T> it = this.audioList.iterator();
            while (it.hasNext()) {
                Integer soundID = ((r05) it.next()).getSoundID();
                if (soundID != null) {
                    l15.e.f(soundID.intValue());
                }
            }
            this.soundCallback = null;
        }
        SoundPool soundPool = this.soundPool;
        if (soundPool != null) {
            soundPool.release();
        }
        this.soundPool = null;
        this.audioList = CollectionsKt__CollectionsKt.emptyList();
        this.spriteList = CollectionsKt__CollectionsKt.emptyList();
        this.imageMap.clear();
    }

    public final Bitmap c(String filePath) {
        return u05.f21110a.a(filePath, this.mFrameWidth, this.mFrameHeight);
    }

    public final Bitmap d(byte[] byteArray, String filePath) {
        Bitmap bitmapA = s05.f20643a.a(byteArray, this.mFrameWidth, this.mFrameHeight);
        return bitmapA != null ? bitmapA : c(filePath);
    }

    public final r05 e(AudioEntity audio, HashMap<String, File> audiosFileMap) {
        r05 r05Var = new r05(audio);
        Integer num = audio.startTime;
        double dIntValue = num != null ? num.intValue() : 0;
        Integer num2 = audio.totalTime;
        double dIntValue2 = num2 != null ? num2.intValue() : 0;
        if (((int) dIntValue2) == 0) {
            return r05Var;
        }
        c15.e eVar = this.mPlayCallback;
        if (eVar != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, File>> it = audiosFileMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
            eVar.onPlay(arrayList);
            Function0<Unit> function0 = this.mCallback;
            if (function0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCallback");
            }
            function0.invoke();
            return r05Var;
        }
        File file = audiosFileMap.get(audio.audioKey);
        if (file != null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                double dAvailable = fileInputStream.available();
                long j = (long) ((dIntValue / dIntValue2) * dAvailable);
                l15 l15Var = l15.e;
                if (l15Var.b()) {
                    r05Var.f(Integer.valueOf(l15Var.c(this.soundCallback, fileInputStream.getFD(), j, (long) dAvailable, 1)));
                } else {
                    SoundPool soundPool = this.soundPool;
                    r05Var.f(soundPool != null ? Integer.valueOf(soundPool.load(fileInputStream.getFD(), j, (long) dAvailable, 1)) : null);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileInputStream, null);
            } finally {
            }
        }
        return r05Var;
    }

    public final File f(File audioCache, byte[] value) throws IOException {
        audioCache.createNewFile();
        new FileOutputStream(audioCache).write(value);
        return audioCache;
    }

    public final HashMap<String, File> g(MovieEntity entity) throws IOException {
        HashMap<String, byte[]> mapH = h(entity);
        HashMap<String, File> map = new HashMap<>();
        if (mapH.size() > 0) {
            for (Map.Entry<String, byte[]> entry : mapH.entrySet()) {
                File fileA = SVGACache.c.a(entry.getKey());
                String key = entry.getKey();
                File fileF = fileA.exists() ? fileA : null;
                if (fileF == null) {
                    fileF = f(fileA, entry.getValue());
                }
                map.put(key, fileF);
            }
        }
        return map;
    }

    public final HashMap<String, byte[]> h(MovieEntity entity) {
        Set<Map.Entry<String, ByteString>> setEntrySet;
        HashMap<String, byte[]> map = new HashMap<>();
        Map<String, ByteString> map2 = entity.images;
        if (map2 != null && (setEntrySet = map2.entrySet()) != null) {
            Iterator<T> it = setEntrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String imageKey = (String) entry.getKey();
                byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
                Intrinsics.checkExpressionValueIsNotNull(byteArray, "byteArray");
                if (byteArray.length >= 4) {
                    List listSlice = ArraysKt___ArraysKt.slice(byteArray, new IntRange(0, 3));
                    if (((Number) listSlice.get(0)).byteValue() == 73 && ((Number) listSlice.get(1)).byteValue() == 68 && ((Number) listSlice.get(2)).byteValue() == 51) {
                        Intrinsics.checkExpressionValueIsNotNull(imageKey, "imageKey");
                        map.put(imageKey, byteArray);
                    } else if (((Number) listSlice.get(0)).byteValue() == -1 && ((Number) listSlice.get(1)).byteValue() == -5 && ((Number) listSlice.get(2)).byteValue() == -108) {
                        Intrinsics.checkExpressionValueIsNotNull(imageKey, "imageKey");
                        map.put(imageKey, byteArray);
                    }
                }
            }
        }
        return map;
    }

    public final String i(String imgName, String imgKey) {
        String str = this.mCacheDir.getAbsolutePath() + "/" + imgName;
        String str2 = str + ".png";
        String str3 = this.mCacheDir.getAbsolutePath() + "/" + imgKey + ".png";
        return new File(str).exists() ? str : new File(str2).exists() ? str2 : new File(str3).exists() ? str3 : "";
    }

    public final SoundPool j(MovieEntity entity) {
        try {
            SoundPool.Builder audioAttributes = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build());
            List<AudioEntity> list = entity.audios;
            Intrinsics.checkExpressionValueIsNotNull(list, "entity.audios");
            return audioAttributes.setMaxStreams(RangesKt___RangesKt.coerceAtMost(12, list.size())).build();
        } catch (Exception e) {
            h63.f17877a.d(this.TAG, e);
            return null;
        }
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final boolean getAntiAlias() {
        return this.antiAlias;
    }

    public final List<r05> l() {
        return this.audioList;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final int getFPS() {
        return this.FPS;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final int getFrames() {
        return this.frames;
    }

    public final HashMap<String, Bitmap> o() {
        return this.imageMap;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final SoundPool getSoundPool() {
        return this.soundPool;
    }

    public final List<p15> q() {
        return this.spriteList;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final i15 getVideoSize() {
        return this.videoSize;
    }

    public final void s(MovieEntity obj) {
        Set<Map.Entry<String, ByteString>> setEntrySet;
        Map<String, ByteString> map = obj.images;
        if (map == null || (setEntrySet = map.entrySet()) == null) {
            return;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
            Intrinsics.checkExpressionValueIsNotNull(byteArray, "byteArray");
            if (byteArray.length >= 4) {
                List listSlice = ArraysKt___ArraysKt.slice(byteArray, new IntRange(0, 3));
                if (((Number) listSlice.get(0)).byteValue() != 73 || ((Number) listSlice.get(1)).byteValue() != 68 || ((Number) listSlice.get(2)).byteValue() != 51) {
                    String strUtf8 = ((ByteString) entry.getValue()).utf8();
                    Intrinsics.checkExpressionValueIsNotNull(strUtf8, "entry.value.utf8()");
                    Object key = entry.getKey();
                    Intrinsics.checkExpressionValueIsNotNull(key, "entry.key");
                    Bitmap bitmapD = d(byteArray, i(strUtf8, (String) key));
                    if (bitmapD != null) {
                        AbstractMap abstractMap = this.imageMap;
                        Object key2 = entry.getKey();
                        Intrinsics.checkExpressionValueIsNotNull(key2, "entry.key");
                        abstractMap.put(key2, bitmapD);
                    }
                }
            }
        }
    }

    public final void t(JSONObject json) {
        JSONObject jSONObjectOptJSONObject = json.optJSONObject("images");
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            Intrinsics.checkExpressionValueIsNotNull(itKeys, "imgJson.keys()");
            while (itKeys.hasNext()) {
                String imgKey = itKeys.next();
                String string = jSONObjectOptJSONObject.get(imgKey).toString();
                Intrinsics.checkExpressionValueIsNotNull(imgKey, "imgKey");
                String strI = i(string, imgKey);
                if (strI.length() == 0) {
                    return;
                }
                String strReplace$default = StringsKt__StringsJVMKt.replace$default(imgKey, ".matte", "", false, 4, (Object) null);
                Bitmap bitmapC = c(strI);
                if (bitmapC != null) {
                    this.imageMap.put(strReplace$default, bitmapC);
                }
            }
        }
    }

    public final void u(Function0<Unit> callback, c15.e playCallback) throws IOException {
        this.mCallback = callback;
        this.mPlayCallback = playCallback;
        MovieEntity movieEntity = this.movieItem;
        if (movieEntity == null) {
            if (callback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCallback");
            }
            callback.invoke();
        } else {
            if (movieEntity == null) {
                Intrinsics.throwNpe();
            }
            y(movieEntity, new a());
        }
    }

    public final void v(MovieEntity entity) {
        List<p15> listEmptyList;
        List<SpriteEntity> list = entity.sprites;
        if (list != null) {
            List<SpriteEntity> list2 = list;
            listEmptyList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            for (SpriteEntity it : list2) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                listEmptyList.add(new p15(it));
            }
        } else {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.spriteList = listEmptyList;
    }

    public final void w(JSONObject json) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = json.optJSONArray("sprites");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new p15(jSONObjectOptJSONObject));
                }
            }
        }
        this.spriteList = CollectionsKt___CollectionsKt.toList(arrayList);
    }

    public final void x(boolean z) {
        this.antiAlias = z;
    }

    public final void y(MovieEntity entity, Function0<Unit> completionBlock) throws IOException {
        List<AudioEntity> list = entity.audios;
        if (list == null || list.isEmpty()) {
            completionBlock.invoke();
            return;
        }
        B(entity, completionBlock);
        HashMap<String, File> mapG = g(entity);
        if (mapG.size() == 0) {
            completionBlock.invoke();
            return;
        }
        List<AudioEntity> list2 = entity.audios;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        for (AudioEntity audio : list2) {
            Intrinsics.checkExpressionValueIsNotNull(audio, "audio");
            arrayList.add(e(audio, mapG));
        }
        this.audioList = arrayList;
    }

    public final void z(JSONObject movieObject) {
        JSONObject jSONObjectOptJSONObject = movieObject.optJSONObject("viewBox");
        if (jSONObjectOptJSONObject != null) {
            this.videoSize = new i15(0.0d, 0.0d, jSONObjectOptJSONObject.optDouble("width", 0.0d), jSONObjectOptJSONObject.optDouble("height", 0.0d));
        }
        this.FPS = movieObject.optInt(SharePluginInfo.ISSUE_FPS, 20);
        this.frames = movieObject.optInt("frames", 0);
    }

    public m15(MovieEntity movieEntity, File file, int i, int i2) {
        this.mFrameWidth = i;
        this.mFrameHeight = i2;
        this.mCacheDir = file;
        this.movieItem = movieEntity;
        MovieParams movieParams = movieEntity.params;
        if (movieParams != null) {
            A(movieParams);
        }
        try {
            s(movieEntity);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        v(movieEntity);
    }
}

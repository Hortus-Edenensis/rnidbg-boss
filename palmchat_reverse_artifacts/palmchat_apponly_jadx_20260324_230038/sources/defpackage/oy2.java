package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.p0002sl.hb;
import com.baidu.location.LocationConst;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.huawei.hms.ads.ContentClassification;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import defpackage.cy2;
import defpackage.v53;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003h \u0001B\u0012\u0012\u0007\u0010\u009d\u0001\u001a\u00020\u0015¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J#\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\u00020\u0010*\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b!\u0010\u001eJ\u0019\u0010#\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b#\u0010$J@\u0010,\u001a\u00020+2'\u0010)\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00100%j\u0002`(2\u0006\u0010*\u001a\u00020\u0015H\u0002¢\u0006\u0004\b,\u0010-J'\u00100\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020+H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u000202H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020+H\u0002¢\u0006\u0004\b5\u00106J\u001b\u00107\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b;\u00108J\u0019\u0010<\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0006\u001a\u00020\u0013H\u0002¢\u0006\u0004\b<\u0010=J\u001f\u0010>\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b>\u0010?J%\u0010@\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b@\u0010AJ#\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bB\u0010CJ\u0019\u0010E\u001a\u0004\u0018\u00010D2\u0006\u0010\u0006\u001a\u00020\u0013H\u0002¢\u0006\u0004\bE\u0010FJ*\u0010H\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010G\u001a\u00020D2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0082\u0010¢\u0006\u0004\bH\u0010IJ)\u0010K\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010J\u001a\u00020D2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bK\u0010LJ\u0015\u0010N\u001a\u0004\u0018\u00010D*\u00020MH\u0002¢\u0006\u0004\bN\u0010OJ\u0019\u0010Q\u001a\u00020P2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bQ\u0010RJ\u0019\u0010T\u001a\u00020\u00102\b\u0010S\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\bT\u0010UJ\r\u0010V\u001a\u00020\u0015¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\u0010H\u0014¢\u0006\u0004\bX\u0010YJ\u0011\u0010\\\u001a\u00060Zj\u0002`[¢\u0006\u0004\b\\\u0010]J#\u0010_\u001a\u00060Zj\u0002`[*\u00020\u000b2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010PH\u0004¢\u0006\u0004\b_\u0010`J6\u0010b\u001a\u00020a2'\u0010)\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00100%j\u0002`(¢\u0006\u0004\bb\u0010cJF\u0010e\u001a\u00020a2\u0006\u0010*\u001a\u00020\u00152\u0006\u0010d\u001a\u00020\u00152'\u0010)\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00100%j\u0002`(¢\u0006\u0004\be\u0010fJ\u0017\u0010g\u001a\u00020\u00102\u0006\u0010/\u001a\u00020+H\u0000¢\u0006\u0004\bg\u00106J\u001f\u0010h\u001a\u00020\u00102\u000e\u0010\u001c\u001a\n\u0018\u00010Zj\u0004\u0018\u0001`[H\u0016¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020PH\u0014¢\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\bl\u0010mJ\u0015\u0010o\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\u0003¢\u0006\u0004\bo\u0010pJ\u0017\u0010q\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\bq\u0010 J\u0017\u0010r\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\br\u0010 J\u0019\u0010s\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\bs\u0010tJ\u0013\u0010u\u001a\u00060Zj\u0002`[H\u0016¢\u0006\u0004\bu\u0010]J\u001b\u0010v\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\bv\u00108J\u0015\u0010x\u001a\u00020w2\u0006\u0010G\u001a\u00020\u0002¢\u0006\u0004\bx\u0010yJ\u0017\u0010{\u001a\u00020\u00102\u0006\u0010z\u001a\u00020\u000bH\u0010¢\u0006\u0004\b{\u0010mJ\u0019\u0010|\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b|\u0010mJ\u0017\u0010}\u001a\u00020\u00152\u0006\u0010z\u001a\u00020\u000bH\u0014¢\u0006\u0004\b}\u0010 J\u0019\u0010~\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b~\u0010\u007fJ\u001b\u0010\u0080\u0001\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0005\b\u0080\u0001\u0010\u007fJ\u0011\u0010\u0081\u0001\u001a\u00020PH\u0016¢\u0006\u0005\b\u0081\u0001\u0010kJ\u0011\u0010\u0082\u0001\u001a\u00020PH\u0007¢\u0006\u0005\b\u0082\u0001\u0010kJ\u0011\u0010\u0083\u0001\u001a\u00020PH\u0010¢\u0006\u0005\b\u0083\u0001\u0010kR\u001e\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010:R\u0019\u0010\u0089\u0001\u001a\u0007\u0012\u0002\b\u00030\u0086\u00018F¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R.\u0010\u008f\u0001\u001a\u0004\u0018\u00010w2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010w8@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0016\u0010\u0092\u0001\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010WR\u0013\u0010\u0094\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b\u0093\u0001\u0010WR\u0013\u0010\u0096\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010WR\u0016\u0010\u0098\u0001\u001a\u00020\u00158PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010WR\u0016\u0010\u009a\u0001\u001a\u00020\u00158TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b\u0099\u0001\u0010WR\u0016\u0010\u009c\u0001\u001a\u00020\u00158PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u0010W¨\u0006¡\u0001"}, d2 = {"Loy2;", "Lcy2;", "Ls50;", "Lec4;", "", "Loy2$b;", LocationConst.HDYawConst.KEY_HD_YAW_STATE, "proposedUpdate", "K", "(Loy2$b;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "exceptions", "N", "(Loy2$b;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "", "x", "(Ljava/lang/Throwable;Ljava/util/List;)V", "Lks2;", "update", "", "t0", "(Lks2;Ljava/lang/Object;)Z", "H", "(Lks2;Ljava/lang/Object;)V", "Lpy3;", "list", "cause", "f0", "(Lpy3;Ljava/lang/Throwable;)V", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/Throwable;)Z", "g0", "", "o0", "(Ljava/lang/Object;)I", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "onCancelling", "Lny2;", "c0", "(Lkotlin/jvm/functions/Function1;Z)Lny2;", "expect", "node", RXScreenCaptureService.KEY_WIDTH, "(Ljava/lang/Object;Lpy3;Lny2;)Z", "Lzl1;", "k0", "(Lzl1;)V", "l0", "(Lny2;)V", "D", "(Ljava/lang/Object;)Ljava/lang/Object;", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "(Ljava/lang/Object;)Ljava/lang/Throwable;", "a0", "Q", "(Lks2;)Lpy3;", "u0", "(Lks2;Ljava/lang/Throwable;)Z", "v0", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "w0", "(Lks2;Ljava/lang/Object;)Ljava/lang/Object;", "Lr50;", "L", "(Lks2;)Lr50;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "x0", "(Loy2$b;Lr50;Ljava/lang/Object;)Z", "lastChild", "I", "(Loy2$b;Lr50;Ljava/lang/Object;)V", "Lv53;", "e0", "(Lv53;)Lr50;", "", bq.g, "(Ljava/lang/Object;)Ljava/lang/String;", "parent", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lcy2;)V", "start", "()Z", "j0", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "s", "()Ljava/util/concurrent/CancellationException;", "message", "q0", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lne1;", "W", "(Lkotlin/jvm/functions/Function1;)Lne1;", "invokeImmediately", "l", "(ZZLkotlin/jvm/functions/Function1;)Lne1;", "m0", "a", "(Ljava/util/concurrent/CancellationException;)V", "F", "()Ljava/lang/String;", WkAdxAdConfigMg.DSP_NAME_CSJ, "(Ljava/lang/Throwable;)V", "parentJob", "h", "(Lec4;)V", WkAdxAdConfigMg.DSP_NAME_GDT, "z", WkAdxAdConfigMg.DSP_NAME_BAIDU, "(Ljava/lang/Object;)Z", "A", "b0", "Lq50;", "t", "(Ls50;)Lq50;", "exception", "U", "h0", ExifInterface.GPS_DIRECTION_TRUE, "i0", "(Ljava/lang/Object;)V", "y", "toString", "s0", "d0", "M", "exceptionOrNull", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", ActionUtils.PAYMENT_AMOUNT, "R", "()Lq50;", "n0", "(Lq50;)V", "parentHandle", ExifInterface.LATITUDE_SOUTH, "()Ljava/lang/Object;", "isActive", "Y", "isCompleted", "X", "isCancelled", "P", "onCancelComplete", "Z", "isScopedCoroutine", "O", "handlesException", "active", "<init>", "(Z)V", t.l, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class oy2 implements cy2, s50, ec4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f19898a = AtomicReferenceFieldUpdater.newUpdater(oy2.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Loy2$a;", "Lny2;", "", "cause", "", "x", "Loy2;", "e", "Loy2;", "parent", "Loy2$b;", "f", "Loy2$b;", LocationConst.HDYawConst.KEY_HD_YAW_STATE, "Lr50;", "g", "Lr50;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "", "h", "Ljava/lang/Object;", "proposedUpdate", "<init>", "(Loy2;Loy2$b;Lr50;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a extends ny2 {

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public final oy2 parent;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public final b state;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public final r50 child;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public final Object proposedUpdate;

        public a(oy2 oy2Var, b bVar, r50 r50Var, Object obj) {
            this.parent = oy2Var;
            this.state = bVar;
            this.child = r50Var;
            this.proposedUpdate = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            x(th);
            return Unit.INSTANCE;
        }

        @Override // defpackage.sj0
        public void x(Throwable cause) {
            this.parent.I(this.state, this.child, this.proposedUpdate);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u0019\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b.\u0010/J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\fR\u0011\u0010%\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b$\u0010\u001cR\u0011\u0010'\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b&\u0010\u001cR\u0014\u0010(\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001cR(\u0010-\u001a\u0004\u0018\u00010\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Loy2$b;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lks2;", "", "proposedException", "", "i", "(Ljava/lang/Throwable;)Ljava/util/List;", "exception", "", "a", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", t.l, "()Ljava/util/ArrayList;", "Lpy3;", "Lpy3;", "c", "()Lpy3;", "list", "", ActionUtils.PAYMENT_AMOUNT, "g", "()Z", hb.j, "(Z)V", "isCompleting", "e", "()Ljava/lang/Throwable;", "l", "rootCause", "h", "isSealed", "f", "isCancelling", "isActive", "d", "()Ljava/lang/Object;", t.f7496a, "(Ljava/lang/Object;)V", "exceptionsHolder", "<init>", "(Lpy3;ZLjava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class b implements ks2 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final py3 list;

        public b(py3 py3Var, boolean z, Throwable th) {
            this.list = py3Var;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        public final void a(Throwable exception) {
            Throwable thE = e();
            if (thE == null) {
                l(exception);
                return;
            }
            if (exception == thE) {
                return;
            }
            Object obj = get_exceptionsHolder();
            if (obj == null) {
                k(exception);
                return;
            }
            if (obj instanceof Throwable) {
                if (exception == obj) {
                    return;
                }
                ArrayList<Throwable> arrayListB = b();
                arrayListB.add(obj);
                arrayListB.add(exception);
                k(arrayListB);
                return;
            }
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(exception);
                return;
            }
            throw new IllegalStateException(("State is " + obj).toString());
        }

        public final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        @Override // defpackage.ks2
        /* JADX INFO: renamed from: c, reason: from getter */
        public py3 getList() {
            return this.list;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final Object get_exceptionsHolder() {
            return this._exceptionsHolder;
        }

        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            return e() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            return get_exceptionsHolder() == py2.e;
        }

        public final List<Throwable> i(Throwable proposedException) {
            ArrayList<Throwable> arrayListB;
            Object obj = get_exceptionsHolder();
            if (obj == null) {
                arrayListB = b();
            } else if (obj instanceof Throwable) {
                ArrayList<Throwable> arrayListB2 = b();
                arrayListB2.add(obj);
                arrayListB = arrayListB2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                arrayListB = (ArrayList) obj;
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListB.add(0, thE);
            }
            if (proposedException != null && !Intrinsics.areEqual(proposedException, thE)) {
                arrayListB.add(proposedException);
            }
            k(py2.e);
            return arrayListB;
        }

        @Override // defpackage.ks2
        /* JADX INFO: renamed from: isActive */
        public boolean getIsActive() {
            return e() == null;
        }

        public final void j(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        public final void k(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void l(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + get_exceptionsHolder() + ", list=" + getList() + ']';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007"}, d2 = {"oy2$c", "Lv53$a;", "Lv53;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "i", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class c extends v53.a {
        public final /* synthetic */ oy2 d;
        public final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(v53 v53Var, oy2 oy2Var, Object obj) {
            super(v53Var);
            this.d = oy2Var;
            this.e = obj;
        }

        @Override // defpackage.zi
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(v53 affected) {
            if (this.d.S() == this.e) {
                return null;
            }
            return u53.a();
        }
    }

    public oy2(boolean z) {
        this._state = z ? py2.g : py2.f;
        this._parentHandle = null;
    }

    public static /* synthetic */ CancellationException r0(oy2 oy2Var, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return oy2Var.q0(th, str);
    }

    @Override // defpackage.ec4
    public CancellationException A() {
        Throwable thE;
        Object objS = S();
        if (objS instanceof b) {
            thE = ((b) objS).e();
        } else if (objS instanceof qj0) {
            thE = ((qj0) objS).cause;
        } else {
            if (objS instanceof ks2) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objS).toString());
            }
            thE = null;
        }
        CancellationException cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + p0(objS), thE, this);
    }

    public final boolean B(Object cause) throws Throwable {
        Object objA0 = py2.f20135a;
        if (P() && (objA0 = D(cause)) == py2.b) {
            return true;
        }
        if (objA0 == py2.f20135a) {
            objA0 = a0(cause);
        }
        if (objA0 == py2.f20135a || objA0 == py2.b) {
            return true;
        }
        if (objA0 == py2.d) {
            return false;
        }
        y(objA0);
        return true;
    }

    public void C(Throwable cause) throws Throwable {
        B(cause);
    }

    public final Object D(Object cause) {
        Object objV0;
        do {
            Object objS = S();
            if (!(objS instanceof ks2) || ((objS instanceof b) && ((b) objS).g())) {
                return py2.f20135a;
            }
            objV0 = v0(objS, new qj0(J(cause), false, 2, null));
        } while (objV0 == py2.c);
        return objV0;
    }

    public final boolean E(Throwable cause) {
        if (Z()) {
            return true;
        }
        boolean z = cause instanceof CancellationException;
        q50 q50VarR = R();
        return (q50VarR == null || q50VarR == ty3.f21092a) ? z : q50VarR.b(cause) || z;
    }

    public String F() {
        return "Job was cancelled";
    }

    public boolean G(Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        return B(cause) && getHandlesException();
    }

    public final void H(ks2 state, Object update) throws Throwable {
        q50 q50VarR = R();
        if (q50VarR != null) {
            q50VarR.dispose();
            n0(ty3.f21092a);
        }
        qj0 qj0Var = update instanceof qj0 ? (qj0) update : null;
        Throwable th = qj0Var != null ? qj0Var.cause : null;
        if (!(state instanceof ny2)) {
            py3 list = state.getList();
            if (list != null) {
                g0(list, th);
                return;
            }
            return;
        }
        try {
            ((ny2) state).x(th);
        } catch (Throwable th2) {
            U(new CompletionHandlerException("Exception in completion handler " + state + " for " + this, th2));
        }
    }

    public final void I(b state, r50 lastChild, Object proposedUpdate) {
        r50 r50VarE0 = e0(lastChild);
        if (r50VarE0 == null || !x0(state, r50VarE0, proposedUpdate)) {
            y(K(state, proposedUpdate));
        }
    }

    public final Throwable J(Object cause) {
        if (cause == null ? true : cause instanceof Throwable) {
            Throwable th = (Throwable) cause;
            return th == null ? new JobCancellationException(F(), null, this) : th;
        }
        if (cause != null) {
            return ((ec4) cause).A();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    public final Object K(b state, Object proposedUpdate) throws Throwable {
        boolean zF;
        Throwable thN;
        qj0 qj0Var = proposedUpdate instanceof qj0 ? (qj0) proposedUpdate : null;
        Throwable th = qj0Var != null ? qj0Var.cause : null;
        synchronized (state) {
            zF = state.f();
            List<Throwable> listI = state.i(th);
            thN = N(state, listI);
            if (thN != null) {
                x(thN, listI);
            }
        }
        if (thN != null && thN != th) {
            proposedUpdate = new qj0(thN, false, 2, null);
        }
        if (thN != null) {
            if (E(thN) || T(thN)) {
                if (proposedUpdate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((qj0) proposedUpdate).b();
            }
        }
        if (!zF) {
            h0(thN);
        }
        i0(proposedUpdate);
        p1.a(f19898a, this, state, py2.g(proposedUpdate));
        H(state, proposedUpdate);
        return proposedUpdate;
    }

    public final r50 L(ks2 state) {
        r50 r50Var = state instanceof r50 ? (r50) state : null;
        if (r50Var != null) {
            return r50Var;
        }
        py3 list = state.getList();
        if (list != null) {
            return e0(list);
        }
        return null;
    }

    public final Throwable M(Object obj) {
        qj0 qj0Var = obj instanceof qj0 ? (qj0) obj : null;
        if (qj0Var != null) {
            return qj0Var.cause;
        }
        return null;
    }

    public final Throwable N(b state, List<? extends Throwable> exceptions) {
        Object next;
        Object obj = null;
        if (exceptions.isEmpty()) {
            if (state.f()) {
                return new JobCancellationException(F(), null, this);
            }
            return null;
        }
        List<? extends Throwable> list = exceptions;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = exceptions.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    /* JADX INFO: renamed from: O */
    public boolean getHandlesException() {
        return true;
    }

    public boolean P() {
        return false;
    }

    public final py3 Q(ks2 state) {
        py3 list = state.getList();
        if (list != null) {
            return list;
        }
        if (state instanceof zl1) {
            return new py3();
        }
        if (state instanceof ny2) {
            l0((ny2) state);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + state).toString());
    }

    public final q50 R() {
        return (q50) this._parentHandle;
    }

    public final Object S() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof d84)) {
                return obj;
            }
            ((d84) obj).c(this);
        }
    }

    public boolean T(Throwable exception) {
        return false;
    }

    public final void V(cy2 parent) {
        if (parent == null) {
            n0(ty3.f21092a);
            return;
        }
        parent.start();
        q50 q50VarT = parent.t(this);
        n0(q50VarT);
        if (Y()) {
            q50VarT.dispose();
            n0(ty3.f21092a);
        }
    }

    public final ne1 W(Function1<? super Throwable, Unit> handler) {
        return l(false, true, handler);
    }

    public final boolean X() {
        Object objS = S();
        return (objS instanceof qj0) || ((objS instanceof b) && ((b) objS).f());
    }

    public final boolean Y() {
        return !(S() instanceof ks2);
    }

    public boolean Z() {
        return false;
    }

    @Override // defpackage.cy2, defpackage.ut4
    public void a(CancellationException cause) throws Throwable {
        if (cause == null) {
            cause = new JobCancellationException(F(), null, this);
        }
        C(cause);
    }

    public final Object a0(Object cause) throws Throwable {
        Throwable thJ = null;
        while (true) {
            Object objS = S();
            if (objS instanceof b) {
                synchronized (objS) {
                    if (((b) objS).h()) {
                        return py2.d;
                    }
                    boolean zF = ((b) objS).f();
                    if (cause != null || !zF) {
                        if (thJ == null) {
                            thJ = J(cause);
                        }
                        ((b) objS).a(thJ);
                    }
                    Throwable thE = zF ^ true ? ((b) objS).e() : null;
                    if (thE != null) {
                        f0(((b) objS).getList(), thE);
                    }
                    return py2.f20135a;
                }
            }
            if (!(objS instanceof ks2)) {
                return py2.d;
            }
            if (thJ == null) {
                thJ = J(cause);
            }
            ks2 ks2Var = (ks2) objS;
            if (!ks2Var.getIsActive()) {
                Object objV0 = v0(objS, new qj0(thJ, false, 2, null));
                if (objV0 == py2.f20135a) {
                    throw new IllegalStateException(("Cannot happen in " + objS).toString());
                }
                if (objV0 != py2.c) {
                    return objV0;
                }
            } else if (u0(ks2Var, thJ)) {
                return py2.f20135a;
            }
        }
    }

    public final Object b0(Object proposedUpdate) {
        Object objV0;
        do {
            objV0 = v0(S(), proposedUpdate);
            if (objV0 == py2.f20135a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate, M(proposedUpdate));
            }
        } while (objV0 == py2.c);
        return objV0;
    }

    public final ny2 c0(Function1<? super Throwable, Unit> handler, boolean onCancelling) {
        ny2 tu2Var;
        if (onCancelling) {
            tu2Var = handler instanceof dy2 ? (dy2) handler : null;
            if (tu2Var == null) {
                tu2Var = new su2(handler);
            }
        } else {
            tu2Var = handler instanceof ny2 ? (ny2) handler : null;
            if (tu2Var == null) {
                tu2Var = new tu2(handler);
            }
        }
        tu2Var.z(this);
        return tu2Var;
    }

    public String d0() {
        return pv0.a(this);
    }

    public final r50 e0(v53 v53Var) {
        while (v53Var.r()) {
            v53Var = v53Var.o();
        }
        while (true) {
            v53Var = v53Var.n();
            if (!v53Var.r()) {
                if (v53Var instanceof r50) {
                    return (r50) v53Var;
                }
                if (v53Var instanceof py3) {
                    return null;
                }
            }
        }
    }

    public final void f0(py3 list, Throwable cause) throws Throwable {
        h0(cause);
        CompletionHandlerException completionHandlerException = null;
        for (v53 v53VarN = (v53) list.m(); !Intrinsics.areEqual(v53VarN, list); v53VarN = v53VarN.n()) {
            if (v53VarN instanceof dy2) {
                ny2 ny2Var = (ny2) v53VarN;
                try {
                    ny2Var.x(cause);
                } catch (Throwable th) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException, th);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + ny2Var + " for " + this, th);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            U(completionHandlerException);
        }
        E(cause);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) cy2.a.b(this, r, function2);
    }

    public final void g0(py3 py3Var, Throwable th) throws Throwable {
        CompletionHandlerException completionHandlerException = null;
        for (v53 v53VarN = (v53) py3Var.m(); !Intrinsics.areEqual(v53VarN, py3Var); v53VarN = v53VarN.n()) {
            if (v53VarN instanceof ny2) {
                ny2 ny2Var = (ny2) v53VarN;
                try {
                    ny2Var.x(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + ny2Var + " for " + this, th2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            U(completionHandlerException);
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) cy2.a.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return cy2.INSTANCE;
    }

    @Override // defpackage.s50
    public final void h(ec4 parentJob) throws Throwable {
        B(parentJob);
    }

    @Override // defpackage.cy2
    public boolean isActive() {
        Object objS = S();
        return (objS instanceof ks2) && ((ks2) objS).getIsActive();
    }

    public final void k0(zl1 state) {
        py3 py3Var = new py3();
        Object hs2Var = py3Var;
        if (!state.getIsActive()) {
            hs2Var = new hs2(py3Var);
        }
        p1.a(f19898a, this, state, hs2Var);
    }

    @Override // defpackage.cy2
    public final ne1 l(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler) {
        ny2 ny2VarC0 = c0(handler, onCancelling);
        while (true) {
            Object objS = S();
            if (objS instanceof zl1) {
                zl1 zl1Var = (zl1) objS;
                if (!zl1Var.getIsActive()) {
                    k0(zl1Var);
                } else if (p1.a(f19898a, this, objS, ny2VarC0)) {
                    return ny2VarC0;
                }
            } else {
                if (!(objS instanceof ks2)) {
                    if (invokeImmediately) {
                        qj0 qj0Var = objS instanceof qj0 ? (qj0) objS : null;
                        handler.invoke(qj0Var != null ? qj0Var.cause : null);
                    }
                    return ty3.f21092a;
                }
                py3 list = ((ks2) objS).getList();
                if (list != null) {
                    ne1 ne1Var = ty3.f21092a;
                    if (onCancelling && (objS instanceof b)) {
                        synchronized (objS) {
                            thE = ((b) objS).e();
                            if (thE == null || ((handler instanceof r50) && !((b) objS).g())) {
                                if (w(objS, list, ny2VarC0)) {
                                    if (thE == null) {
                                        return ny2VarC0;
                                    }
                                    ne1Var = ny2VarC0;
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    if (thE != null) {
                        if (invokeImmediately) {
                            handler.invoke(thE);
                        }
                        return ne1Var;
                    }
                    if (w(objS, list, ny2VarC0)) {
                        return ny2VarC0;
                    }
                } else {
                    if (objS == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    l0((ny2) objS);
                }
            }
        }
    }

    public final void l0(ny2 state) {
        state.i(new py3());
        p1.a(f19898a, this, state, state.n());
    }

    public final void m0(ny2 node) {
        Object objS;
        do {
            objS = S();
            if (!(objS instanceof ny2)) {
                if (!(objS instanceof ks2) || ((ks2) objS).getList() == null) {
                    return;
                }
                node.s();
                return;
            }
            if (objS != node) {
                return;
            }
        } while (!p1.a(f19898a, this, objS, py2.g));
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return cy2.a.e(this, key);
    }

    public final void n0(q50 q50Var) {
        this._parentHandle = q50Var;
    }

    public final int o0(Object state) {
        if (state instanceof zl1) {
            if (((zl1) state).getIsActive()) {
                return 0;
            }
            if (!p1.a(f19898a, this, state, py2.g)) {
                return -1;
            }
            j0();
            return 1;
        }
        if (!(state instanceof hs2)) {
            return 0;
        }
        if (!p1.a(f19898a, this, state, ((hs2) state).getList())) {
            return -1;
        }
        j0();
        return 1;
    }

    public final String p0(Object state) {
        if (!(state instanceof b)) {
            return state instanceof ks2 ? ((ks2) state).getIsActive() ? "Active" : "New" : state instanceof qj0 ? "Cancelled" : "Completed";
        }
        b bVar = (b) state;
        return bVar.f() ? "Cancelling" : bVar.g() ? "Completing" : "Active";
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return cy2.a.f(this, coroutineContext);
    }

    public final CancellationException q0(Throwable th, String str) {
        CancellationException jobCancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = F();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    @Override // defpackage.cy2
    public final CancellationException s() {
        Object objS = S();
        if (!(objS instanceof b)) {
            if (objS instanceof ks2) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objS instanceof qj0) {
                return r0(this, ((qj0) objS).cause, null, 1, null);
            }
            return new JobCancellationException(pv0.a(this) + " has completed normally", null, this);
        }
        Throwable thE = ((b) objS).e();
        if (thE != null) {
            CancellationException cancellationExceptionQ0 = q0(thE, pv0.a(this) + " is cancelling");
            if (cancellationExceptionQ0 != null) {
                return cancellationExceptionQ0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final String s0() {
        return d0() + '{' + p0(S()) + '}';
    }

    @Override // defpackage.cy2
    public final boolean start() {
        int iO0;
        do {
            iO0 = o0(S());
            if (iO0 == 0) {
                return false;
            }
        } while (iO0 != 1);
        return true;
    }

    @Override // defpackage.cy2
    public final q50 t(s50 child) {
        return (q50) cy2.a.d(this, true, false, new r50(child), 2, null);
    }

    public final boolean t0(ks2 state, Object update) throws Throwable {
        if (!p1.a(f19898a, this, state, py2.g(update))) {
            return false;
        }
        h0(null);
        i0(update);
        H(state, update);
        return true;
    }

    public String toString() {
        return s0() + '@' + pv0.b(this);
    }

    public final boolean u0(ks2 state, Throwable rootCause) throws Throwable {
        py3 py3VarQ = Q(state);
        if (py3VarQ == null) {
            return false;
        }
        if (!p1.a(f19898a, this, state, new b(py3VarQ, false, rootCause))) {
            return false;
        }
        f0(py3VarQ, rootCause);
        return true;
    }

    public final Object v0(Object state, Object proposedUpdate) {
        return !(state instanceof ks2) ? py2.f20135a : ((!(state instanceof zl1) && !(state instanceof ny2)) || (state instanceof r50) || (proposedUpdate instanceof qj0)) ? w0((ks2) state, proposedUpdate) : t0((ks2) state, proposedUpdate) ? proposedUpdate : py2.c;
    }

    public final boolean w(Object expect, py3 list, ny2 node) {
        int iW;
        c cVar = new c(node, this, expect);
        do {
            iW = list.o().w(node, list, cVar);
            if (iW == 1) {
                return true;
            }
        } while (iW != 2);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final Object w0(ks2 state, Object proposedUpdate) throws Throwable {
        py3 py3VarQ = Q(state);
        if (py3VarQ == null) {
            return py2.c;
        }
        b bVar = state instanceof b ? (b) state : null;
        if (bVar == null) {
            bVar = new b(py3VarQ, false, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (bVar) {
            if (bVar.g()) {
                return py2.f20135a;
            }
            bVar.j(true);
            if (bVar != state && !p1.a(f19898a, this, state, bVar)) {
                return py2.c;
            }
            boolean zF = bVar.f();
            qj0 qj0Var = proposedUpdate instanceof qj0 ? (qj0) proposedUpdate : null;
            if (qj0Var != null) {
                bVar.a(qj0Var.cause);
            }
            ?? E = Boolean.valueOf(zF ? false : true).booleanValue() ? bVar.e() : 0;
            objectRef.element = E;
            Unit unit = Unit.INSTANCE;
            if (E != 0) {
                f0(py3VarQ, E);
            }
            r50 r50VarL = L(state);
            return (r50VarL == null || !x0(bVar, r50VarL, proposedUpdate)) ? K(bVar, proposedUpdate) : py2.b;
        }
    }

    public final void x(Throwable rootCause, List<? extends Throwable> exceptions) {
        if (exceptions.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(exceptions.size()));
        for (Throwable th : exceptions) {
            if (th != rootCause && th != rootCause && !(th instanceof CancellationException) && setNewSetFromMap.add(th)) {
                ExceptionsKt__ExceptionsKt.addSuppressed(rootCause, th);
            }
        }
    }

    public final boolean x0(b state, r50 child, Object proposedUpdate) {
        while (cy2.a.d(child.childJob, false, false, new a(this, state, child, proposedUpdate), 1, null) == ty3.f21092a) {
            child = e0(child);
            if (child == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean z(Throwable cause) {
        return B(cause);
    }

    public void j0() {
    }

    public void U(Throwable exception) throws Throwable {
        throw exception;
    }

    public void h0(Throwable cause) {
    }

    public void i0(Object state) {
    }

    public void y(Object state) {
    }
}

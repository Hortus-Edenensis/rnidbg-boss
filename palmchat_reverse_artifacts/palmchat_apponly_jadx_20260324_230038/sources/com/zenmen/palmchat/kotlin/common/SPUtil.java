package com.zenmen.palmchat.kotlin.common;

import android.content.SharedPreferences;
import com.baidu.platform.comapi.map.MapController;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zenmen.palmchat.c;
import defpackage.v4;
import defpackage.xp3;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J \u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001J \u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\rJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u000fJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0011J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0013J \u0010\u0015\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002J \u0010\u0016\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\rJ \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u000fJ \u0010\u0018\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0011J\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001J\u001e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001J\u001e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001J\u0016\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u001aR0\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070!j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007`\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/zenmen/palmchat/kotlin/common/SPUtil;", "", "", "key", "l", "Lcom/zenmen/palmchat/kotlin/common/SPUtil$SCENE;", "SCENE", "Landroid/content/SharedPreferences;", "m", "scene", MapController.DEFAULT_LAYER_TAG, "q", "n", "", "f", "", "i", "", "a", "", "d", "p", "h", t.f7496a, "c", ActionUtils.PAYMENT_AMOUNT, "", "t", "v", "u", t.k, "s", RXScreenCaptureService.KEY_WIDTH, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", t.l, "Ljava/util/HashMap;", "PREF_LIST", "<init>", "()V", "framework_release"}, k = 1, mv = {1, 8, 0})
public final class SPUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SPUtil f14322a = new SPUtil();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final HashMap<SCENE, SharedPreferences> PREF_LIST = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b8\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8¨\u00069"}, d2 = {"Lcom/zenmen/palmchat/kotlin/common/SPUtil$SCENE;", "", "(Ljava/lang/String;I)V", "TEST", "CONTACT", "CONTACTA", "CONTACTB", "MOMENTS_ENTRY", "EXTRA_REDDOT", "NOTIFY_GUIDE", "INFO_NOTIFICATION_STATUS", "MOMENTS", "MEEYOU", "NEARBY", "PRIVACY_DIALOG", "CHAT_PAY", "BALABALA", "APP_COMMON", "USER_DIVIDE", "GIFT_QUICKSEND", "CHAT_QUICKSEND", "APP_WAKE_UP", "SMALL_VIDEO", "AD", "PEOPLE_MATCH", "MAINTAB_CONFIG", "SQUARE_CONFIG", "CHAT_RISK", "TAB_ENTRANCE_CELL_STATUS", "CHUANSHANJIA_AD", "SEEME", "VOIP", "USER_CANCELLATION_SYNC", "APP_DATABASE_RECOVER", "SQUARE", "SQUARE_FEED_IN_CHAT", "CIRCLE", "COUPLE_FACE", "BARRIER", "MYTAB", "CERT", "RECOMMEND_FOR_U", "FIND_FRIEND_TAB", "TASK_CENTER", "USER_DETAIL", "GIFT_PANEL", "TASK_1V1", "VENUS", "CHAT_GUIDE", "UPDATE", "RONGYUN_VOIP_CALL", "JSAPI", "CHATMATE", "CHATROOMMATE", "ONLINE", "MAPFIND", "LOCATION_CACHE", "framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum SCENE {
        TEST,
        CONTACT,
        CONTACTA,
        CONTACTB,
        MOMENTS_ENTRY,
        EXTRA_REDDOT,
        NOTIFY_GUIDE,
        INFO_NOTIFICATION_STATUS,
        MOMENTS,
        MEEYOU,
        NEARBY,
        PRIVACY_DIALOG,
        CHAT_PAY,
        BALABALA,
        APP_COMMON,
        USER_DIVIDE,
        GIFT_QUICKSEND,
        CHAT_QUICKSEND,
        APP_WAKE_UP,
        SMALL_VIDEO,
        AD,
        PEOPLE_MATCH,
        MAINTAB_CONFIG,
        SQUARE_CONFIG,
        CHAT_RISK,
        TAB_ENTRANCE_CELL_STATUS,
        CHUANSHANJIA_AD,
        SEEME,
        VOIP,
        USER_CANCELLATION_SYNC,
        APP_DATABASE_RECOVER,
        SQUARE,
        SQUARE_FEED_IN_CHAT,
        CIRCLE,
        COUPLE_FACE,
        BARRIER,
        MYTAB,
        CERT,
        RECOMMEND_FOR_U,
        FIND_FRIEND_TAB,
        TASK_CENTER,
        USER_DETAIL,
        GIFT_PANEL,
        TASK_1V1,
        VENUS,
        CHAT_GUIDE,
        UPDATE,
        RONGYUN_VOIP_CALL,
        JSAPI,
        CHATMATE,
        CHATROOMMATE,
        ONLINE,
        MAPFIND,
        LOCATION_CACHE
    }

    public static /* synthetic */ boolean b(SPUtil sPUtil, SCENE scene, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return sPUtil.a(scene, str, z);
    }

    public static /* synthetic */ float e(SPUtil sPUtil, SCENE scene, String str, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        return sPUtil.d(scene, str, f);
    }

    public static /* synthetic */ int g(SPUtil sPUtil, SCENE scene, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return sPUtil.f(scene, str, i);
    }

    public static /* synthetic */ long j(SPUtil sPUtil, SCENE scene, String str, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        return sPUtil.i(scene, str, j);
    }

    public static /* synthetic */ String o(SPUtil sPUtil, SCENE scene, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return sPUtil.n(scene, str, str2);
    }

    public final boolean a(SCENE scene, String key, boolean z) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Object objQ = q(scene, key, Boolean.valueOf(z));
        Intrinsics.checkNotNull(objQ, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objQ).booleanValue();
    }

    public final boolean c(SCENE scene, String key, boolean z) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        return a(scene, l(key), z);
    }

    public final float d(SCENE scene, String key, float f) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Object objQ = q(scene, key, Float.valueOf(f));
        Intrinsics.checkNotNull(objQ, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objQ).floatValue();
    }

    public final int f(SCENE scene, String key, int i) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Object objQ = q(scene, key, Integer.valueOf(i));
        Intrinsics.checkNotNull(objQ, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objQ).intValue();
    }

    public final int h(SCENE scene, String key, int i) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        return f(scene, l(key), i);
    }

    public final long i(SCENE scene, String key, long j) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Object objQ = q(scene, key, Long.valueOf(j));
        Intrinsics.checkNotNull(objQ, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) objQ).longValue();
    }

    public final long k(SCENE scene, String key, long j) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        return i(scene, l(key), j);
    }

    public final String l(String key) {
        return key + v4.e(c.b());
    }

    public final SharedPreferences m(SCENE SCENE2) {
        Intrinsics.checkNotNullParameter(SCENE2, "SCENE");
        HashMap<SCENE, SharedPreferences> map = PREF_LIST;
        SharedPreferences sharedPreferencesC = map.get(SCENE2);
        if (sharedPreferencesC == null) {
            sharedPreferencesC = xp3.c("sp_palmchat_" + SCENE2.name());
            map.put(SCENE2, sharedPreferencesC);
        }
        Intrinsics.checkNotNull(sharedPreferencesC);
        return sharedPreferencesC;
    }

    public final String n(SCENE scene, String key, String str) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        Object objQ = q(scene, key, str);
        Intrinsics.checkNotNull(objQ, "null cannot be cast to non-null type kotlin.String");
        return (String) objQ;
    }

    public final String p(SCENE scene, String key, String str) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        return n(scene, l(key), str);
    }

    public final Object q(SCENE scene, String key, Object obj) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(obj, "default");
        SharedPreferences sharedPreferencesM = m(scene);
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferencesM.getInt(key, ((Number) obj).intValue()));
        }
        if (obj instanceof String) {
            return sharedPreferencesM.getString(key, (String) obj);
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferencesM.getLong(key, ((Number) obj).longValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferencesM.getFloat(key, ((Number) obj).floatValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferencesM.getBoolean(key, ((Boolean) obj).booleanValue()));
        }
        throw new IllegalArgumentException("SharedPreferences 类型错误");
    }

    public final void r(SCENE scene, String key) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        m(scene).edit().remove(key).apply();
    }

    public final void s(SCENE scene, String key) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        m(scene).edit().remove(l(key)).apply();
    }

    public final void t(SCENE scene, String key, Object value) {
        SharedPreferences.Editor editorPutBoolean;
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor editorEdit = m(scene).edit();
        if (value instanceof Long) {
            editorPutBoolean = editorEdit.putLong(key, ((Number) value).longValue());
        } else if (value instanceof Integer) {
            editorPutBoolean = editorEdit.putInt(key, ((Number) value).intValue());
        } else if (value instanceof String) {
            editorPutBoolean = editorEdit.putString(key, (String) value);
        } else if (value instanceof Float) {
            editorPutBoolean = editorEdit.putFloat(key, ((Number) value).floatValue());
        } else {
            if (!(value instanceof Boolean)) {
                throw new IllegalArgumentException("SharedPreferences 类型错误");
            }
            editorPutBoolean = editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
        }
        editorPutBoolean.apply();
    }

    public final void u(SCENE scene, String key, Object value) {
        SharedPreferences.Editor editorPutBoolean;
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor editorEdit = m(scene).edit();
        if (value instanceof Long) {
            editorPutBoolean = editorEdit.putLong(key, ((Number) value).longValue());
        } else if (value instanceof Integer) {
            editorPutBoolean = editorEdit.putInt(key, ((Number) value).intValue());
        } else if (value instanceof String) {
            editorPutBoolean = editorEdit.putString(key, (String) value);
        } else if (value instanceof Float) {
            editorPutBoolean = editorEdit.putFloat(key, ((Number) value).floatValue());
        } else {
            if (!(value instanceof Boolean)) {
                throw new IllegalArgumentException("SharedPreferences 类型错误");
            }
            editorPutBoolean = editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
        }
        editorPutBoolean.commit();
    }

    public final void v(SCENE scene, String key, Object value) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        t(scene, l(key), value);
    }

    public final void w() {
        SPUtil sPUtil = f14322a;
        SCENE scene = SCENE.TEST;
        sPUtil.t(scene, "a", Boolean.TRUE);
        sPUtil.t(scene, t.l, "1");
        sPUtil.t(scene, "c", 1);
        sPUtil.t(scene, "e", Float.valueOf(0.1f));
        sPUtil.t(scene, "f", 11212121L);
        b(sPUtil, scene, "a", false, 4, null);
        o(sPUtil, scene, t.l, null, 4, null);
        g(sPUtil, scene, "c", 0, 4, null);
        e(sPUtil, scene, "e", 0.0f, 4, null);
        j(sPUtil, scene, "f", 0L, 4, null);
    }
}

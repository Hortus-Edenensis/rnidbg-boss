package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.iz;
import defpackage.sz3;
import defpackage.tz3;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx implements Function<SparseArray<Object>, Object> {
    private static volatile fx u;
    private Function<SparseArray<Object>, Object> fx;
    private final Context nr;

    private fx(Context context) {
        this.nr = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x04ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Map<String, Object> fx(Map<String, Object> map) {
        boolean z;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Object obj;
        boolean z2;
        Object obj2;
        Object obj3;
        String str7;
        int i2;
        int i3;
        int i4;
        RemoteViews remoteViews = new RemoteViews(this.nr.getPackageName(), this.nr.getResources().getIdentifier("tt_adl_notification_layout", "layout", this.nr.getPackageName()));
        HashMap map2 = new HashMap();
        Object obj4 = map.get("csj_enable_target_34");
        boolean zBooleanValue = obj4 != null ? ((Boolean) obj4).booleanValue() : false;
        int iJk = u.jk();
        Object obj5 = map.get("notification_type");
        Object obj6 = map.get("notification_opt_2");
        int iKj = u.kj();
        int i5 = iKj != 0 ? iKj : 0;
        if ((obj5 instanceof Integer) && (obj6 instanceof Integer)) {
            int iU = u(((Integer) obj5).intValue(), ((Integer) obj6).intValue() == 1);
            remoteViews.setImageViewResource(iJk, iU);
            if (iU != 0 && iKj == 0) {
                i5 = iU;
            }
        }
        map2.put("builder_small_icon", Integer.valueOf(i5));
        Object obj7 = map.get("click_type");
        int iIntValue = obj7 instanceof Integer ? ((Integer) obj7).intValue() : 0;
        Object obj8 = map.get("click_download_id");
        int iIntValue2 = obj8 instanceof Integer ? ((Integer) obj8).intValue() : 0;
        int iA = u.a();
        boolean z3 = obj6 instanceof Integer;
        String str8 = null;
        if (!z3 || ((Integer) obj6).intValue() == 1) {
            z = z3;
            i = iA;
        } else {
            Object obj9 = map.get("action_click_btn");
            z = z3;
            i = iA;
            remoteViews.setOnClickPendingIntent(i, u(obj9 instanceof String ? (String) obj9 : null, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj10 = map.get("action_apa");
        if (obj10 instanceof String) {
            map2.put("apa_click_content_intent", u((String) obj10, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj11 = map.get("action_complete");
        if (obj11 instanceof String) {
            map2.put("complete_click_content_intent", u((String) obj11, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj12 = map.get("action_hide");
        if (obj12 instanceof String) {
            map2.put("hide_click_content_intent", u((String) obj12, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj13 = map.get("enable_notification_ui");
        if (u(obj13)) {
            remoteViews.setInt(i, "setBackgroundResource", u.dw());
            remoteViews.setTextColor(i, -1);
        }
        Object obj14 = map.get("show_title");
        if (obj14 == null) {
            obj14 = "未命名";
        }
        if (obj14 instanceof String) {
            remoteViews.setTextViewText(u.t(), (String) obj14);
        }
        int iIz = u(obj13) ? u.iz() : u.pn();
        remoteViews.setViewVisibility(i, 0);
        Object obj15 = map.get("percent");
        Object obj16 = map.get("indeterminate");
        if (obj15 != null && obj16 != null) {
            remoteViews.setProgressBar(iIz, 100, ((Integer) obj15).intValue(), ((Boolean) obj16).booleanValue());
        }
        if (u(obj13)) {
            Object obj17 = map.get("bitmap");
            if (obj17 != null) {
                remoteViews.setInt(iJk, "setBackgroundColor", 0);
                remoteViews.setImageViewBitmap(iJk, (Bitmap) obj17);
            } else {
                remoteViews.setInt(iJk, "setBackgroundResource", u.dw());
            }
        }
        int iN = u.n();
        int iX = u.x();
        int iSx = u.sx();
        Object obj18 = map.get("is_bind_app");
        boolean z4 = (obj18 instanceof Boolean) && ((Boolean) obj18).booleanValue();
        int iIntValue3 = ((Integer) obj5).intValue();
        str = "";
        if (iIntValue3 == 1 || iIntValue3 == 4) {
            Object obj19 = map.get("download_size");
            str2 = obj19 instanceof String ? (String) obj19 : "";
            if (iIntValue3 == 1) {
                Object obj20 = map.get("download_status");
                if (obj20 instanceof Integer) {
                    if (((Integer) obj20).intValue() == 11) {
                        str3 = "处理中";
                    } else {
                        str = "正在下载";
                    }
                }
                remoteViews.setViewVisibility(iIz, 0);
                remoteViews.setViewVisibility(iX, 8);
                remoteViews.setViewVisibility(iN, 0);
                remoteViews.setViewVisibility(i, !z4 ? 8 : 0);
                if (nr(obj13)) {
                    remoteViews.setViewVisibility(i, 8);
                }
                str4 = "暂停";
                str5 = null;
                str6 = str;
            } else {
                str3 = "准备中";
            }
            str = str3;
            remoteViews.setViewVisibility(iIz, 0);
            remoteViews.setViewVisibility(iX, 8);
            remoteViews.setViewVisibility(iN, 0);
            remoteViews.setViewVisibility(i, !z4 ? 8 : 0);
            if (nr(obj13)) {
            }
            str4 = "暂停";
            str5 = null;
            str6 = str;
        } else {
            if (iIntValue3 == 2) {
                Object obj21 = map.get("download_size");
                str = obj21 instanceof String ? (String) obj21 : "";
                if (z) {
                    if (((Integer) obj6).intValue() != 1) {
                        i3 = 8;
                        remoteViews.setViewVisibility(iN, 0);
                        i4 = nr(obj13) ? 0 : 8;
                    } else if (((Integer) obj15).intValue() >= ((Integer) map.get("progress_70")).intValue()) {
                        i4 = 0;
                        remoteViews.setViewVisibility(iIz, 0);
                        iIz = iN;
                        i3 = 8;
                    } else {
                        remoteViews.setViewVisibility(iIz, 8);
                        remoteViews.setViewVisibility(iN, 8);
                        remoteViews.setViewVisibility(iX, 0);
                        remoteViews.setViewVisibility(iSx, 8);
                        str6 = "下载暂停中，点击继续。";
                        if (z4) {
                        }
                    }
                    remoteViews.setViewVisibility(iIz, i4);
                    remoteViews.setViewVisibility(iX, i3);
                    str6 = "暂停中";
                    if (z4) {
                    }
                } else {
                    str6 = "暂停中";
                    if (z4) {
                        str2 = str;
                        str = "继续";
                        remoteViews.setViewVisibility(i, 8);
                    } else {
                        remoteViews.setViewVisibility(i, 0);
                        if (nr(obj13)) {
                            Object obj22 = map.get("download_size");
                            if (obj22 instanceof String) {
                                str = (String) obj22;
                            }
                        }
                        str5 = null;
                        str2 = str;
                        str4 = "继续";
                    }
                }
            } else if (iIntValue3 == 3) {
                Object obj23 = map.get("download_status");
                boolean z5 = obj23 instanceof Integer;
                if (z5) {
                    obj = obj23;
                    int iIntValue4 = ((Integer) obj23).intValue();
                    z2 = z5;
                    Object obj24 = map.get("is_network_error");
                    Object obj25 = map.get("is_insufficient_space_error");
                    obj2 = "is_insufficient_space_error";
                    if (iIntValue4 == -1 || iIntValue4 == -4) {
                        if (nr(obj13) && iIntValue4 == -1 && (((obj24 instanceof Boolean) && ((Boolean) obj24).booleanValue()) || ((obj25 instanceof Boolean) && ((Boolean) obj25).booleanValue()))) {
                            Object obj26 = map.get("download_size");
                            if (obj26 instanceof String) {
                                str = (String) obj26;
                            }
                        }
                        remoteViews.setViewVisibility(iSx, 8);
                        Object obj27 = map.get("is_error_code_insufficient_space_error");
                        Object obj28 = map.get("is_need_show_wait_net_text");
                        if ((obj27 instanceof Boolean) && ((Boolean) obj27).booleanValue()) {
                            str7 = "SdCard空间不足, 下载失败。";
                        } else if ((obj28 instanceof Boolean) && ((Boolean) obj28).booleanValue()) {
                            Object obj29 = map.get("is_wait_wifi");
                            str7 = (obj29 instanceof Boolean) && ((Boolean) obj29).booleanValue() ? "等待wifi开始下载" : "等待网络继续下载";
                        } else {
                            str7 = "下载失败。";
                        }
                        remoteViews.setViewVisibility(i, 8);
                        if (nr(obj13) && iIntValue4 == -1) {
                            Object obj30 = map.get("is_net_work_error");
                            if ((obj30 instanceof Boolean) && ((Boolean) obj30).booleanValue()) {
                                Object obj31 = map.get("is_wait_wifi_and_in_net");
                                if ((obj31 instanceof Boolean) && ((Boolean) obj31).booleanValue()) {
                                    str7 = "无Wi-Fi 已暂停";
                                    str2 = str;
                                    str = "继续";
                                } else {
                                    str7 = "下载异常，请检查网络";
                                }
                            } else if ((obj25 instanceof Boolean) && ((Boolean) obj25).booleanValue()) {
                                Object obj32 = map.get("download_size_diff");
                                if (obj32 instanceof String) {
                                    str7 = String.format("空间不足 还需%s", (String) obj32);
                                }
                            }
                        }
                        str2 = str;
                        i2 = 8;
                        str = "重新下载";
                        remoteViews.setViewVisibility(iIz, i2);
                        remoteViews.setViewVisibility(iX, 0);
                        remoteViews.setViewVisibility(iN, i2);
                        obj3 = "is_network_error";
                    } else if (iIntValue4 == -3) {
                        Object obj33 = map.get("download_size");
                        str2 = obj33 instanceof String ? (String) obj33 : "";
                        Object obj34 = map.get("is_mime_apk");
                        if ((obj34 instanceof Boolean) && ((Boolean) obj34).booleanValue()) {
                            Object obj35 = map.get("is_apk_installed");
                            if ((obj35 instanceof Boolean) && ((Boolean) obj35).booleanValue()) {
                                str7 = "安装完成，点击打开。";
                                str = "打开";
                            } else {
                                str7 = "下载完成，点击安装。";
                                str = "安装";
                            }
                        } else {
                            Object obj36 = map.get("is_have_notification_click_callback");
                            str7 = ((obj36 instanceof Boolean) && ((Boolean) obj36).booleanValue()) ? "下载完成，点击打开。" : "下载完成";
                        }
                        String str9 = str;
                        if (((Integer) obj6).intValue() == 1) {
                            remoteViews.setTextViewText(i, str9);
                            remoteViews.setViewVisibility(iSx, 8);
                        } else {
                            remoteViews.setViewVisibility(i, 8);
                        }
                        str8 = str7;
                        str = str9;
                    } else {
                        str2 = "";
                        str7 = str2;
                    }
                    i2 = 8;
                    remoteViews.setViewVisibility(iIz, i2);
                    remoteViews.setViewVisibility(iX, 0);
                    remoteViews.setViewVisibility(iN, i2);
                    obj3 = "is_network_error";
                } else {
                    obj = obj23;
                    z2 = z5;
                    obj2 = "is_insufficient_space_error";
                    obj3 = "is_network_error";
                    str2 = "";
                    str7 = str2;
                }
                Object obj37 = map.get(obj3);
                Object obj38 = map.get(obj2);
                if (nr(obj13) && z2 && ((Integer) obj).intValue() == -1 && (((obj37 instanceof Boolean) && ((Boolean) obj37).booleanValue()) || ((obj38 instanceof Boolean) && ((Boolean) obj38).booleanValue()))) {
                    remoteViews.setViewVisibility(iIz, 0);
                    remoteViews.setViewVisibility(iX, 8);
                    remoteViews.setViewVisibility(iN, 0);
                    Object obj39 = map.get("is_wait_wifi_and_in_net");
                    if ((obj39 instanceof Boolean) && ((Boolean) obj39).booleanValue()) {
                        remoteViews.setViewVisibility(i, 0);
                        Object obj40 = map.get("download_size");
                        str2 = obj40 instanceof String ? (String) obj40 : str2;
                    } else {
                        str6 = str7;
                        remoteViews.setViewVisibility(i, 8);
                    }
                }
                str6 = str7;
            } else {
                str5 = null;
                str6 = "";
                str4 = str6;
                str2 = str4;
            }
            str5 = str8;
            str4 = str;
        }
        remoteViews.setTextViewText(u.o(), str2);
        remoteViews.setTextViewText(u.bg(), str6);
        remoteViews.setTextViewText(iSx, str2);
        remoteViews.setTextViewText(u.bq(), str6);
        if (TextUtils.isEmpty(str4)) {
            remoteViews.setViewVisibility(i, 8);
        } else {
            remoteViews.setTextViewText(i, str4);
        }
        try {
            if (nr(this.nr)) {
                remoteViews.setInt(u.b(), "setBackgroundColor", Color.parseColor("#fffafafa"));
            }
        } catch (Throwable unused) {
        }
        map2.put("remote_views", remoteViews);
        map2.put("builder_content_type", str5);
        return map2;
    }

    private Map<String, Object> nr(Map<String, Object> map) {
        String strConcat;
        String str;
        String str2;
        String str3;
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        String str4 = (String) map.get("install_app_name");
        Bitmap bitmap = (Bitmap) map.get("install_icon_bitmap");
        String str5 = (String) map.get("install_action_type");
        Object obj = map.get("install_click_type");
        String str6 = (String) map.get("install_package_name");
        String str7 = (String) map.get("install_tag");
        String str8 = (String) map.get("install_value");
        String str9 = (String) map.get("install_log_extra");
        int iIntValue = obj != null ? ((Integer) obj).intValue() : -1;
        Object obj2 = map.get("install_download_id");
        int iIntValue2 = obj2 != null ? ((Integer) obj2).intValue() : -1;
        Object obj3 = map.get("install_enable_target_34");
        boolean zBooleanValue = obj3 != null ? ((Boolean) obj3).booleanValue() : false;
        RemoteViews remoteViews = new RemoteViews(this.nr.getPackageName(), this.nr.getResources().getIdentifier("tt_install_notification_layout", "layout", this.nr.getPackageName()));
        int iMv = u.mv();
        int iL = u.l();
        int iS = u.s();
        int iK = u.k();
        int iMy = u.my();
        if (iIntValue == 1) {
            strConcat = "打开".concat(String.valueOf(str4));
            str = "应用已安装完成";
            str2 = "去打开";
        } else {
            strConcat = "安装".concat(String.valueOf(str4));
            str = "应用已下载完成";
            str2 = "去安装";
        }
        String str10 = str;
        String str11 = strConcat;
        remoteViews.setTextViewText(iL, str10);
        remoteViews.setTextViewText(iS, str11);
        remoteViews.setTextViewText(iK, str2);
        int iKj = u.kj();
        if (iKj == 0) {
            iKj = u.qq();
        }
        int i = iKj;
        remoteViews.setImageViewIcon(iMv, Icon.createWithBitmap(bitmap));
        PendingIntent pendingIntentU = u(str5, iIntValue, iIntValue2, zBooleanValue, str6, str7, str8, str9);
        remoteViews.setOnClickPendingIntent(iMy, pendingIntentU);
        remoteViews.setOnClickPendingIntent(iK, pendingIntentU);
        String str12 = "csj_" + this.nr.getPackageName();
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                tz3.a();
                NotificationChannel notificationChannelA = sz3.a(str12, "csj_install", 4);
                notificationChannelA.setShowBadge(true);
                notificationChannelA.setBypassDnd(true);
                str3 = "notification";
                try {
                    ((NotificationManager) this.nr.getSystemService(str3)).createNotificationChannel(notificationChannelA);
                } catch (Throwable th) {
                    th = th;
                    iz.u(th);
                }
            } else {
                str3 = "notification";
            }
        } catch (Throwable th2) {
            th = th2;
            str3 = "notification";
        }
        NotificationCompat.Builder builderU = u(str12);
        builderU.setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setContentIntent(pendingIntentU).setSmallIcon(i).setContentTitle(str10).setContentText(str11).setPriority(1).setDefaults(-1).setVisibility(1).setAutoCancel(true);
        Notification notificationBuild = builderU.build();
        notificationBuild.contentView = remoteViews;
        map2.put(str3, notificationBuild);
        return map2;
    }

    public static fx u() {
        return u;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public static fx u(Context context) {
        if (u == null) {
            synchronized (fx.class) {
                if (u == null) {
                    u = new fx(context);
                }
            }
        }
        return u;
    }

    public <T> T u(Class<T> cls, int i, Map<String, Object> map) {
        iz.nr("xgc_dl", "api:".concat(String.valueOf(i)));
        if (i == 0) {
            if (this.fx != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 0);
                sparseArray.put(0, map);
                return (T) this.fx.apply(sparseArray);
            }
            return (T) Boolean.FALSE;
        }
        if (i == 159) {
            if (map != null) {
                Object obj = map.get("n");
                if (obj instanceof Function) {
                    this.fx = (Function) obj;
                }
            }
            return null;
        }
        if (i == 161) {
            return (T) nr(map);
        }
        if (i == 155) {
            return (T) u((String) map.get("custom_authority"), (String) map.get("custom_file_path"));
        }
        if (i != 156) {
            return null;
        }
        return (T) u(map);
    }

    public void u(Map<String, Object> map, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(0, map);
        Function<SparseArray<Object>, Object> function = this.fx;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    private NotificationCompat.Builder u(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.nr);
        }
        try {
            return new NotificationCompat.Builder(this.nr, str);
        } catch (NoSuchMethodError unused) {
            return new NotificationCompat.Builder(this.nr);
        }
    }

    private Map<String, Object> u(Map<String, Object> map) {
        Map<String, Object> map2;
        if (map == null || (map2 = (Map) map.get("params")) == null) {
            return null;
        }
        Map<String, Object> mapFx = fx(map2);
        Object obj = mapFx.get("remote_views");
        Object obj2 = mapFx.get("builder_content_type");
        int iIntValue = ((Integer) map2.get("notification_type")).intValue();
        String str = (String) map2.get("channel_id");
        int iIntValue2 = ((Integer) map2.get("download_status")).intValue();
        NotificationCompat.Builder builderU = u(str);
        builderU.setWhen(((Long) map2.get("first_time")).longValue());
        Object obj3 = map2.get("notification_group");
        if (obj3 != null && (obj3 instanceof String)) {
            builderU.setGroup((String) obj3);
            builderU.setGroupSummary(false);
        }
        builderU.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        if (iIntValue == 1 || iIntValue == 4 || iIntValue == 2) {
            builderU.setContentIntent((PendingIntent) mapFx.get("apa_click_content_intent"));
            builderU.setAutoCancel(false);
        } else if (iIntValue == 3) {
            builderU.setAutoCancel(true);
            if (iIntValue2 == -3) {
                Object obj4 = map2.get("auto_cancel");
                if ((obj4 instanceof Boolean) && ((Boolean) obj4).booleanValue()) {
                    builderU.setAutoCancel(false);
                }
            }
            builderU.setContentIntent((PendingIntent) mapFx.get("complete_click_content_intent"));
            builderU.setDeleteIntent((PendingIntent) mapFx.get("hide_click_content_intent"));
        }
        if (iIntValue == 3 && iIntValue2 == -3 && (obj2 instanceof String)) {
            builderU.setContentText((String) obj2);
        }
        Object obj5 = mapFx.get("builder_small_icon");
        if (obj5 instanceof Integer) {
            builderU.setSmallIcon(((Integer) obj5).intValue());
        }
        Notification notificationBuild = builderU.build();
        notificationBuild.contentView = (RemoteViews) obj;
        mapFx.put("notification", notificationBuild);
        return mapFx;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:(2:24|5)|(3:26|6|(3:22|8|9))|20|11|16) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean nr(Context context) {
        TypedArray typedArrayObtainStyledAttributes;
        int color;
        if (context == null) {
            return false;
        }
        try {
            color = Color.parseColor("#7f0b0198");
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(u.fx(), new int[]{u.u(), u.nr()});
        } catch (Throwable unused) {
            typedArrayObtainStyledAttributes = null;
        }
        try {
            if (color == typedArrayObtainStyledAttributes.getColor(0, 0)) {
                try {
                    typedArrayObtainStyledAttributes.recycle();
                    return true;
                } catch (Throwable unused2) {
                    return true;
                }
            }
        } catch (Throwable unused3) {
            if (typedArrayObtainStyledAttributes != null) {
            }
            return false;
        }
        typedArrayObtainStyledAttributes.recycle();
        return false;
    }

    private boolean nr(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() >= 2;
    }

    private Pair<Intent, Boolean> u(Context context, long j, boolean z) {
        if (z) {
            return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandleNotificationActivity.class), Boolean.TRUE);
        }
        return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandlerService.class), Boolean.FALSE);
    }

    private PendingIntent u(String str, int i, int i2, boolean z, String str2) {
        Pair<Intent, Boolean> pairU = u(this.nr, i2, z);
        Intent intent = (Intent) pairU.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        return u(this.nr, pairU, i2);
    }

    private PendingIntent u(String str, int i, int i2, boolean z, String str2, String str3, String str4, String str5) {
        Pair<Intent, Boolean> pairU = u(this.nr, i2, z);
        Intent intent = (Intent) pairU.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        intent.putExtra("extra_tag", str3);
        intent.putExtra("extra_value", str4);
        intent.putExtra("extra_log_extra", str5);
        return u(this.nr, pairU, i2);
    }

    private PendingIntent u(Context context, Pair<Intent, Boolean> pair, int i) {
        if (((Boolean) pair.second).booleanValue()) {
            return PendingIntent.getActivity(context, i, (Intent) pair.first, 201326592);
        }
        return PendingIntent.getService(context, i, (Intent) pair.first, 201326592);
    }

    private boolean u(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() > 0;
    }

    private int u(int i, boolean z) {
        if (z) {
            return u.qq();
        }
        if (i == 1 || i == 4) {
            return u.c();
        }
        if (i == 2) {
            return u.q();
        }
        if (i == 3) {
            return u.qq();
        }
        return 0;
    }

    public Uri u(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 24 && !TextUtils.isEmpty(str)) {
            return FileProvider.getUriForFile(this.nr, str, new File(str2));
        }
        return Uri.fromFile(new File(str2));
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Map<String, Object> map;
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetA = wc7.k(sparseArray).a();
        int iIntValue = valueSetA.intValue(-99999987);
        Class cls = (Class) valueSetA.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return wc7.b().f(10000, 3).a().sparseArray();
        }
        if (valueSetA.objectValue(0, Map.class) != null) {
            map = (Map) valueSetA.objectValue(0, Map.class);
        } else {
            map = new HashMap<>();
        }
        return u(cls, iIntValue, map);
    }
}

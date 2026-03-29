package com.zenmen.palmchat.framework;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.kuaishou.weapon.p0.g;
import com.kuaishou.weapon.p0.t;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ir5;
import defpackage.pg4;
import defpackage.r75;
import defpackage.tg4;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class BaseActivityPermissionDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f13966a = false;
    public static boolean b = false;

    /* JADX INFO: compiled from: SearchBox */
    public enum PermissionType {
        INITA(0, new String[]{g.j, g.c}),
        INITA1(100, new String[]{g.j}),
        INITA2(101, new String[]{g.c}),
        INITB(1, new String[]{g.j, g.c}),
        PHONE_STATE(2, new String[]{g.c}),
        WRITE_SDCARD(3, new String[]{g.j}),
        CAMERA(4, new String[]{"android.permission.CAMERA"}),
        LOCATION(5, new String[]{g.g}),
        SQUARE_LOCATION(1007, new String[]{g.g}),
        FIND_FRIEND_LOCATION(1008, new String[]{g.g}),
        FIND_FRIEND_DRIFT_LOCATION(1009, new String[]{g.g}),
        FIND_FRIEND_DRIFT_MAP_SEPARATION_LOCATION(1010, new String[]{g.g}),
        FIND_NEARBY_MAP_LOCATION(1011, new String[]{g.g}),
        FIND_FRIEND_FEED_USER_MAP_LOCATION(1012, new String[]{g.g}),
        VOICE_MATCH_LOCATION(1013, new String[]{g.g}),
        FIND_FRIEND_ONLINE_LOCATION(1014, new String[]{g.g}),
        CONTACT(6, new String[]{"android.permission.READ_CONTACTS"}),
        RECORD_AUDIO(7, new String[]{"android.permission.RECORD_AUDIO"}),
        VIDEO_RECORD(8, new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"}),
        VIDEO_CALL(9, new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"}),
        AUDIO_CALL(10, new String[]{"android.permission.RECORD_AUDIO"}),
        SQUARE_VIDEO_RECORD(13, new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"}),
        SQUARE_CAMERA(14, new String[]{"android.permission.CAMERA"}),
        VENUS_AUDIO(15, new String[]{"android.permission.RECORD_AUDIO"}),
        GROUP_AUDIO_CALL(14, new String[]{"android.permission.RECORD_AUDIO"});

        public String[] permissionList;
        public int requestCode;

        PermissionType(int i, String[] strArr) {
            this.requestCode = i;
            this.permissionList = strArr;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'CHAT_SEND_IMAGE' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: SearchBox */
    public static final class PermissionUsage {
        private static final /* synthetic */ PermissionUsage[] $VALUES;
        public static final PermissionUsage AD_BTN_DOWNLOAD;
        public static final PermissionUsage AD_DOWNLOAD;
        public static final PermissionUsage AUDIO_MATCH;
        public static final PermissionUsage AUDIO_MATCH_VIDEO;
        public static final PermissionUsage CHAT_AUDIO_CALL;
        public static final PermissionUsage CHAT_ENTER;
        public static final PermissionUsage CHAT_SEND_AUDIO;
        public static final PermissionUsage CHAT_SEND_FILE;
        public static final PermissionUsage CHAT_SEND_IMAGE;
        public static final PermissionUsage CHAT_SEND_LOCATION;
        public static final PermissionUsage CHAT_SEND_VIDEO;
        public static final PermissionUsage CHAT_VIDEO_CALL;
        public static final PermissionUsage CHAT_VIDEO_RECORD_AUDIO;
        public static final PermissionUsage CIRCLE_SELECT_AVATAR_IMAGE;
        public static final PermissionUsage CIRCLE_SELECT_COVER_IMAGE;
        public static final PermissionUsage CIRCLE_SELECT_LOCATION;
        public static final PermissionUsage CIRCLE_SELECT_SAVE_IMAGE;
        public static final PermissionUsage CIRCLE_SELECT_TOOL_IMAGE;
        public static final PermissionUsage CONTACT;
        public static final PermissionUsage CONTACT_CALLLOG_SMS;
        public static final PermissionUsage FIND_FRIEND_GET_LOCATION;
        public static final PermissionUsage FIND_NEARBY_MAP_GET_LOCATION;
        public static final PermissionUsage INIT_CONTACT;
        public static final PermissionUsage MEDIA_PICK_CAMERA;
        public static final PermissionUsage MEDIA_PICK_MOMENT_CAMERA;
        public static final PermissionUsage MEDIA_PICK_QRCODE;
        public static final PermissionUsage MEDIA_PICK_STORAGE;
        public static final PermissionUsage MEDIA_PICK_STORAGE_HEADICON;
        public static final PermissionUsage MEDIA_SAVE;
        public static final PermissionUsage MOMENT_ENTER;
        public static final PermissionUsage MOMENT_PUBLISH_STORAGE;
        public static final PermissionUsage MOMENT_WALL_CAMERA;
        public static final PermissionUsage PEOPLE_MATCH_CAMERA;
        public static final PermissionUsage PEOPLE_MATCH_LOCATION;
        public static final PermissionUsage PEOPLE_NEARBY_LOCATION;
        public static final PermissionUsage PERSONAL_LOCATION_INFO;
        public static final PermissionUsage RECOMMEND_FRIENDS;
        public static final PermissionUsage RED_BUBBLE_CALENDAR;
        public static final PermissionUsage SCAN_CAMERA;
        public static final PermissionUsage SQUARE_GET_LOCATION;
        public static final PermissionUsage SQUARE_PUBLISH_ALBUM;
        public static final PermissionUsage SQUARE_PUBLISH_ALBUM_DIALOG;
        public static final PermissionUsage SQUARE_PUBLISH_CAMERA;
        public static final PermissionUsage SQUARE_PUBLISH_LOCATION;
        public static final PermissionUsage SUPER_EXPOSE_LOCATION;
        public static final PermissionUsage VENUS_AUDIO;
        public static final PermissionUsage VOICE_MATCH_LOCATION;
        public int needShowDesOnSysProcessing;
        public boolean needShowDescriptionDialog;
        public boolean needShowPermissionDeniedDialog;
        public int usageDesLayoutRes;
        public int usageDesRes;
        public int usageNum;
        public static final PermissionUsage NONE = new PermissionUsage("NONE", 0, -1, true, false, 0, 0, 0);
        public static final PermissionUsage INITA = new PermissionUsage("INITA", 1, 0, false, false, 1, 0, R$layout.layout_permission_description_init);
        public static final PermissionUsage INITA1 = new PermissionUsage("INITA1", 2, 0, false, false, 1, 0, R$layout.layout_permission_description_init1);
        public static final PermissionUsage INITA2 = new PermissionUsage("INITA2", 3, 0, false, false, 1, 0, R$layout.layout_permission_description_init2);
        public static final PermissionUsage INITB = new PermissionUsage("INITB", 4, 0, false, true, 0, 0, 0);

        private static /* synthetic */ PermissionUsage[] $values() {
            return new PermissionUsage[]{NONE, INITA, INITA1, INITA2, INITB, CHAT_SEND_IMAGE, CHAT_SEND_FILE, CHAT_SEND_LOCATION, CHAT_SEND_VIDEO, CHAT_SEND_AUDIO, CHAT_VIDEO_CALL, CHAT_AUDIO_CALL, MEDIA_PICK_CAMERA, MEDIA_PICK_STORAGE, CONTACT, PEOPLE_NEARBY_LOCATION, SCAN_CAMERA, MOMENT_WALL_CAMERA, MOMENT_PUBLISH_STORAGE, RED_BUBBLE_CALENDAR, PERSONAL_LOCATION_INFO, MEDIA_PICK_STORAGE_HEADICON, CHAT_ENTER, MOMENT_ENTER, MEDIA_PICK_MOMENT_CAMERA, MEDIA_SAVE, PEOPLE_MATCH_LOCATION, AD_DOWNLOAD, AD_BTN_DOWNLOAD, INIT_CONTACT, CONTACT_CALLLOG_SMS, MEDIA_PICK_QRCODE, PEOPLE_MATCH_CAMERA, CIRCLE_SELECT_LOCATION, CIRCLE_SELECT_AVATAR_IMAGE, CIRCLE_SELECT_COVER_IMAGE, CIRCLE_SELECT_SAVE_IMAGE, CIRCLE_SELECT_TOOL_IMAGE, SQUARE_PUBLISH_CAMERA, SQUARE_GET_LOCATION, SQUARE_PUBLISH_LOCATION, SQUARE_PUBLISH_ALBUM, SQUARE_PUBLISH_ALBUM_DIALOG, VENUS_AUDIO, FIND_FRIEND_GET_LOCATION, FIND_NEARBY_MAP_GET_LOCATION, RECOMMEND_FRIENDS, CHAT_VIDEO_RECORD_AUDIO, AUDIO_MATCH, AUDIO_MATCH_VIDEO, VOICE_MATCH_LOCATION, SUPER_EXPOSE_LOCATION};
        }

        static {
            int i = R$string.per_storage_common_des;
            CHAT_SEND_IMAGE = new PermissionUsage("CHAT_SEND_IMAGE", 5, 1, true, false, 2, i, 0);
            CHAT_SEND_FILE = new PermissionUsage("CHAT_SEND_FILE", 6, 2, true, false, 2, i, 0);
            int i2 = R$string.per_location_common_des;
            CHAT_SEND_LOCATION = new PermissionUsage("CHAT_SEND_LOCATION", 7, 3, true, false, 2, i2, 0);
            int i3 = R$string.per_camera_common_des;
            CHAT_SEND_VIDEO = new PermissionUsage("CHAT_SEND_VIDEO", 8, 4, true, false, 2, i3, 0);
            int i4 = R$string.per_audio_common_des;
            CHAT_SEND_AUDIO = new PermissionUsage("CHAT_SEND_AUDIO", 9, 5, true, false, 2, i4, 0);
            int i5 = R$string.per_usage_chat_videocall;
            CHAT_VIDEO_CALL = new PermissionUsage("CHAT_VIDEO_CALL", 10, 6, true, false, 2, i5, 0);
            CHAT_AUDIO_CALL = new PermissionUsage("CHAT_AUDIO_CALL", 11, 7, true, false, 2, i4, 0);
            MEDIA_PICK_CAMERA = new PermissionUsage("MEDIA_PICK_CAMERA", 12, 8, true, false, 2, i3, 0);
            MEDIA_PICK_STORAGE = new PermissionUsage("MEDIA_PICK_STORAGE", 13, 9, true, false, 2, i, 0);
            int i6 = R$string.per_contact_common_des;
            CONTACT = new PermissionUsage("CONTACT", 14, 10, false, false, 1, i6, 0);
            PEOPLE_NEARBY_LOCATION = new PermissionUsage("PEOPLE_NEARBY_LOCATION", 15, 11, false, false, 1, i2, 0);
            SCAN_CAMERA = new PermissionUsage("SCAN_CAMERA", 16, 12, true, false, 2, i3, 0);
            MOMENT_WALL_CAMERA = new PermissionUsage("MOMENT_WALL_CAMERA", 17, 13, true, false, 2, i3, 0);
            MOMENT_PUBLISH_STORAGE = new PermissionUsage("MOMENT_PUBLISH_STORAGE", 18, 15, true, false, 2, i, 0);
            RED_BUBBLE_CALENDAR = new PermissionUsage("RED_BUBBLE_CALENDAR", 19, 16, true, false, 0, 0, 0);
            PERSONAL_LOCATION_INFO = new PermissionUsage("PERSONAL_LOCATION_INFO", 20, 17, false, false, 1, i2, 0);
            MEDIA_PICK_STORAGE_HEADICON = new PermissionUsage("MEDIA_PICK_STORAGE_HEADICON", 21, 18, true, false, 2, i, 0);
            CHAT_ENTER = new PermissionUsage("CHAT_ENTER", 22, 19, false, false, 1, i, 0);
            MOMENT_ENTER = new PermissionUsage("MOMENT_ENTER", 23, 20, false, false, 1, R$string.per_usage_moment_enter, 0);
            MEDIA_PICK_MOMENT_CAMERA = new PermissionUsage("MEDIA_PICK_MOMENT_CAMERA", 24, 21, true, false, 1, R$string.per_usage_moment_publish_storage, 0);
            MEDIA_SAVE = new PermissionUsage("MEDIA_SAVE", 25, 22, true, false, 1, i, 0);
            PEOPLE_MATCH_LOCATION = new PermissionUsage("PEOPLE_MATCH_LOCATION", 26, 23, false, false, 1, i2, 0);
            AD_DOWNLOAD = new PermissionUsage("AD_DOWNLOAD", 27, 24, true, false, 1, 0, 0);
            AD_BTN_DOWNLOAD = new PermissionUsage("AD_BTN_DOWNLOAD", 28, 24, true, false, 1, 0, 0);
            INIT_CONTACT = new PermissionUsage("INIT_CONTACT", 29, 24, false, false, 0, 0, 0);
            CONTACT_CALLLOG_SMS = new PermissionUsage("CONTACT_CALLLOG_SMS", 30, 25, false, false, 1, 0, R$layout.layout_contact_calllog_sms_permission_description);
            MEDIA_PICK_QRCODE = new PermissionUsage("MEDIA_PICK_QRCODE", 31, 26, true, false, 1, i, 0);
            PEOPLE_MATCH_CAMERA = new PermissionUsage("PEOPLE_MATCH_CAMERA", 32, 27, false, false, 1, i3, 0);
            CIRCLE_SELECT_LOCATION = new PermissionUsage("CIRCLE_SELECT_LOCATION", 33, 28, true, false, 2, i2, 0);
            CIRCLE_SELECT_AVATAR_IMAGE = new PermissionUsage("CIRCLE_SELECT_AVATAR_IMAGE", 34, 29, true, false, 2, i, 0);
            CIRCLE_SELECT_COVER_IMAGE = new PermissionUsage("CIRCLE_SELECT_COVER_IMAGE", 35, 30, true, false, 2, i, 0);
            CIRCLE_SELECT_SAVE_IMAGE = new PermissionUsage("CIRCLE_SELECT_SAVE_IMAGE", 36, 31, true, false, 2, i, 0);
            CIRCLE_SELECT_TOOL_IMAGE = new PermissionUsage("CIRCLE_SELECT_TOOL_IMAGE", 37, 32, true, false, 2, i, 0);
            SQUARE_PUBLISH_CAMERA = new PermissionUsage("SQUARE_PUBLISH_CAMERA", 38, 33, false, false, 1, i3, 0);
            SQUARE_GET_LOCATION = new PermissionUsage("SQUARE_GET_LOCATION", 39, 34, true, false, 1, i2, 0);
            SQUARE_PUBLISH_LOCATION = new PermissionUsage("SQUARE_PUBLISH_LOCATION", 40, 35, false, false, 1, i2, 0);
            SQUARE_PUBLISH_ALBUM = new PermissionUsage("SQUARE_PUBLISH_ALBUM", 41, 36, false, false, 1, i, 0);
            SQUARE_PUBLISH_ALBUM_DIALOG = new PermissionUsage("SQUARE_PUBLISH_ALBUM_DIALOG", 42, 36, true, false, 2, i, 0);
            VENUS_AUDIO = new PermissionUsage("VENUS_AUDIO", 43, 38, false, false, 1, i4, 0);
            FIND_FRIEND_GET_LOCATION = new PermissionUsage("FIND_FRIEND_GET_LOCATION", 44, 37, true, false, 1, i2, 0);
            FIND_NEARBY_MAP_GET_LOCATION = new PermissionUsage("FIND_NEARBY_MAP_GET_LOCATION", 45, 42, true, false, 1, i2, 0);
            RECOMMEND_FRIENDS = new PermissionUsage("RECOMMEND_FRIENDS", 46, 39, false, false, 1, i6, 0);
            CHAT_VIDEO_RECORD_AUDIO = new PermissionUsage("CHAT_VIDEO_RECORD_AUDIO", 47, 40, true, false, 2, i4, 0);
            AUDIO_MATCH = new PermissionUsage("AUDIO_MATCH", 48, 41, true, false, 2, i4, 0);
            AUDIO_MATCH_VIDEO = new PermissionUsage("AUDIO_MATCH_VIDEO", 49, 45, true, false, 2, i5, 0);
            VOICE_MATCH_LOCATION = new PermissionUsage("VOICE_MATCH_LOCATION", 50, 43, true, false, 2, i2, 0);
            SUPER_EXPOSE_LOCATION = new PermissionUsage("SUPER_EXPOSE_LOCATION", 51, 50, true, false, 1, i2, 0);
            $VALUES = $values();
        }

        private PermissionUsage(String str, int i, int i2, boolean z, boolean z2, int i3, int i4, int i5) {
            this.usageNum = i2;
            this.needShowPermissionDeniedDialog = z;
            this.needShowDescriptionDialog = z2;
            this.needShowDesOnSysProcessing = i3;
            this.usageDesRes = i4;
            this.usageDesLayoutRes = i5;
        }

        public static PermissionUsage valueOf(String str) {
            return (PermissionUsage) Enum.valueOf(PermissionUsage.class, str);
        }

        public static PermissionUsage[] values() {
            return (PermissionUsage[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PermissionType f13967a;
        public final /* synthetic */ PermissionUsage b;
        public final /* synthetic */ FrameworkBaseActivity c;

        public a(PermissionType permissionType, PermissionUsage permissionUsage, FrameworkBaseActivity frameworkBaseActivity) {
            this.f13967a = permissionType;
            this.b = permissionUsage;
            this.c = frameworkBaseActivity;
        }

        @Override // com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher.b
        public void a() {
            LogUtil.onImmediateClickEvent("permission01", null, BaseActivityPermissionDispatcher.d(this.f13967a, this.b));
            FrameworkBaseActivity frameworkBaseActivity = this.c;
            PermissionType permissionType = this.f13967a;
            BaseActivityPermissionDispatcher.k(frameworkBaseActivity, permissionType.permissionList, permissionType.requestCode);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static long f13968a = 172800000;
        public static HashSet<PermissionUsage> b;

        static {
            HashSet<PermissionUsage> hashSet = new HashSet<>();
            b = hashSet;
            hashSet.add(PermissionUsage.PERSONAL_LOCATION_INFO);
        }

        public static boolean a(PermissionUsage permissionUsage) {
            return b.contains(permissionUsage);
        }

        public static boolean b(PermissionUsage permissionUsage) {
            if (a(permissionUsage)) {
                SPUtil sPUtil = SPUtil.f14322a;
                SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
                long jI = sPUtil.i(scene, "key_location_request_time" + permissionUsage.name(), 0L);
                long jB = ir5.b();
                if (Math.abs(jI - jB) < f13968a) {
                    return true;
                }
                sPUtil.t(scene, "key_location_request_time" + permissionUsage.name(), Long.valueOf(jB));
            }
            return false;
        }
    }

    public static boolean b(FrameworkBaseActivity frameworkBaseActivity, PermissionType permissionType, PermissionUsage permissionUsage) {
        boolean z = true;
        if (permissionUsage == PermissionUsage.MOMENT_ENTER) {
            if (f13966a) {
                return false;
            }
            f13966a = true;
        } else if (permissionUsage == PermissionUsage.CHAT_ENTER) {
            if (b) {
                return false;
            }
            b = true;
        }
        frameworkBaseActivity.setPermissionUsage(permissionUsage);
        if (tg4.b(frameworkBaseActivity, permissionType.permissionList)) {
            frameworkBaseActivity.onPermissionGrant(permissionType, frameworkBaseActivity.getPermissionUsage(), false);
            return true;
        }
        if (c.b(permissionUsage)) {
            frameworkBaseActivity.onPermissionDenied(permissionType, permissionUsage);
            return false;
        }
        boolean zL = l(frameworkBaseActivity, permissionType.permissionList);
        LogUtil.i("BaseActivityPermissionDispatcher", "checkPermissionAndRequestOnFail showSysPermissioDialog= " + zL);
        if (permissionUsage.needShowDescriptionDialog) {
            LogUtil.d("BaseActivityPermissionDispatcher", "needShowDescriptionDialog");
            frameworkBaseActivity.showPermissionDescriptionDialog(new a(permissionType, permissionUsage, frameworkBaseActivity), permissionType);
        } else {
            if (permissionUsage.needShowDesOnSysProcessing <= 0 || !zL) {
                z = false;
            } else {
                frameworkBaseActivity.showDescriptionDialogOnSysProcessing(permissionUsage, permissionType);
            }
            LogUtil.onImmediateClickEvent("permission01", null, f(permissionType, permissionUsage, false, z));
            k(frameworkBaseActivity, permissionType.permissionList, permissionType.requestCode);
            z = zL;
        }
        if (z) {
            i(permissionType.permissionList);
        }
        return false;
    }

    public static String[] c(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                if (!tg4.b(context, str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String d(PermissionType permissionType, PermissionUsage permissionUsage) {
        return e(permissionType, permissionUsage, false);
    }

    public static String e(PermissionType permissionType, PermissionUsage permissionUsage, boolean z) {
        return f(permissionType, permissionUsage, z, false);
    }

    public static String f(PermissionType permissionType, PermissionUsage permissionUsage, boolean z, boolean z2) {
        String[] strArrC;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene", g(permissionUsage));
            jSONObject.put("type", h(permissionType.permissionList));
            if (z && (strArrC = c(com.zenmen.palmchat.c.b(), permissionType.permissionList)) != null) {
                jSONObject.put("reject", h(strArrC));
            }
            jSONObject.put("status", pg4.a() ? "a" : t.l);
            jSONObject.put("showFloat", z2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static int g(PermissionUsage permissionUsage) {
        if (permissionUsage != null) {
            return permissionUsage.usageNum;
        }
        return -1;
    }

    public static JSONArray h(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null) {
            for (String str : strArr) {
                jSONArray.put(str.equals(g.c) ? 1 : str.equals(g.j) ? 2 : str.equals("android.permission.CAMERA") ? 3 : str.equals("android.permission.READ_CONTACTS") ? 4 : str.equals("android.permission.RECORD_AUDIO") ? 5 : str.equals(g.g) ? 6 : str.equals("android.permission.READ_CALENDAR") ? 7 : str.equals("android.permission.WRITE_CALENDAR") ? 8 : -1);
            }
        }
        return jSONArray;
    }

    public static void i(String[] strArr) {
        for (String str : strArr) {
            SharedPreferences sharedPreferences = com.zenmen.palmchat.c.b().getSharedPreferences(WifiNestConst.ThirdConst.SP_FILE_NAME, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                if (str.equals(g.j)) {
                    editorEdit.putLong(WifiNestConst.ThirdConst.SP_FILE_LAST_STORAGE_TIME, ir5.b()).apply();
                    LogUtil.d("BaseActivityPermissionDispatcher", "handleAdPermissions storage time  = " + Long.valueOf(sharedPreferences.getLong(WifiNestConst.ThirdConst.SP_FILE_LAST_STORAGE_TIME, 0L)));
                } else if (str.equals(g.c)) {
                    editorEdit.putLong(WifiNestConst.ThirdConst.SP_FILE_LAST_IMEI_TIME, ir5.b()).apply();
                    LogUtil.d("BaseActivityPermissionDispatcher", "handleAdPermissions phoneState time  = " + Long.valueOf(sharedPreferences.getLong(WifiNestConst.ThirdConst.SP_FILE_LAST_IMEI_TIME, 0L)));
                } else if (str.equals(g.g)) {
                    editorEdit.putLong(WifiNestConst.ThirdConst.SP_FILE_LAST_LOCATION_TIME, ir5.b()).apply();
                    LogUtil.d("BaseActivityPermissionDispatcher", "handleAdPermissions location time  = " + Long.valueOf(sharedPreferences.getLong(WifiNestConst.ThirdConst.SP_FILE_LAST_LOCATION_TIME, 0L)));
                }
            }
        }
    }

    public static void j(FrameworkBaseActivity frameworkBaseActivity, int i, int[] iArr) {
        PermissionType permissionType = null;
        for (PermissionType permissionType2 : PermissionType.values()) {
            if (permissionType2.requestCode == i) {
                permissionType = permissionType2;
            }
        }
        if (permissionType == null || iArr == null) {
            return;
        }
        if (tg4.e(iArr)) {
            frameworkBaseActivity.onPermissionGrant(permissionType, frameworkBaseActivity.getPermissionUsage(), true);
        } else {
            frameworkBaseActivity.onPermissionDenied(permissionType, frameworkBaseActivity.getPermissionUsage());
        }
        String[] strArr = permissionType.permissionList;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        for (String str : strArr) {
            String str2 = "firstCheckRationale" + str;
            if (r75.d(frameworkBaseActivity, str2, true)) {
                r75.o(frameworkBaseActivity, str2, false);
            }
        }
    }

    public static void k(Activity activity, String[] strArr, int i) {
        String str = Build.MODEL;
        if (str == null || !(str.equals("SM-G9250") || str.equals("Le X620"))) {
            ActivityCompat.requestPermissions(activity, strArr, i);
            return;
        }
        String[] strArrC = c(activity, strArr);
        if (strArrC == null) {
            ActivityCompat.requestPermissions(activity, strArr, i);
        } else {
            ActivityCompat.requestPermissions(activity, strArrC, i);
        }
    }

    public static boolean l(Activity activity, String... strArr) {
        boolean z = false;
        for (String str : strArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("firstCheckRationale");
            sb.append(str);
            z = z || (ActivityCompat.shouldShowRequestPermissionRationale(activity, str) || r75.d(activity, sb.toString(), true));
        }
        return z;
    }
}

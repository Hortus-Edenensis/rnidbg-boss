package com.zenmen.palmchat.database;

import android.net.Uri;
import android.text.TextUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import defpackage.fu5;
import defpackage.ho3;
import defpackage.ye2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DBUriManager {

    /* JADX INFO: compiled from: SearchBox */
    public enum MsgSaveType {
        COMMON,
        TEMP
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13881a;

        static {
            int[] iArr = new int[MsgSaveType.values().length];
            f13881a = iArr;
            try {
                iArr[MsgSaveType.TEMP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static Uri a(Class cls, int i) {
        return d(cls, f(i));
    }

    public static Uri b(Class cls, ChatItem chatItem) {
        return a(cls, chatItem != null ? chatItem.getBizType() : 0);
    }

    public static Uri c(Class cls, String str) {
        return d(cls, g(DomainHelper.n(str)));
    }

    public static Uri d(Class cls, MsgSaveType msgSaveType) {
        String strJ = j(cls);
        if (TextUtils.isEmpty(strJ)) {
            return null;
        }
        Uri.Builder builderBuildUpon = Uri.parse("content://com.zenmen.palmchat.social.provider/" + strJ).buildUpon();
        builderBuildUpon.appendQueryParameter("msg_save_type", String.valueOf(msgSaveType));
        return builderBuildUpon.build();
    }

    public static String e(Uri uri) {
        return "tb_groups";
    }

    public static MsgSaveType f(int i) {
        return fu5.t(i) ? fu5.k(i).saveInTempTable ? MsgSaveType.TEMP : MsgSaveType.COMMON : MsgSaveType.COMMON;
    }

    public static MsgSaveType g(DomainHelper.Domains domains) {
        MsgSaveType msgSaveType = MsgSaveType.COMMON;
        return (fu5.v(domains) && domains.saveInTempTable) ? MsgSaveType.TEMP : msgSaveType;
    }

    public static String h(Uri uri) {
        return a.f13881a[i(uri).ordinal()] != 1 ? "tb_messages" : "tb_temp_messages";
    }

    public static MsgSaveType i(Uri uri) {
        String queryParameter;
        MsgSaveType msgSaveType = MsgSaveType.COMMON;
        if (uri == null || (queryParameter = uri.getQueryParameter("msg_save_type")) == null || queryParameter.equals(msgSaveType.toString())) {
            return msgSaveType;
        }
        MsgSaveType msgSaveType2 = MsgSaveType.TEMP;
        return queryParameter.equals(msgSaveType2.toString()) ? msgSaveType2 : msgSaveType;
    }

    public static String j(Class cls) {
        if (cls == ho3.class) {
            return "tb_messages";
        }
        if (cls == ye2.class) {
            return "tb_groups";
        }
        return null;
    }
}

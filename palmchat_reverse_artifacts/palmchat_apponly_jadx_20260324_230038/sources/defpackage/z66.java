package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.e.comm.constants.ErrorCode;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$anim;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.fk2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class z66 {
    public static void a(ContactInfoItem contactInfoItem, SquareFeed squareFeed, NearByBean nearByBean) {
        if (contactInfoItem != null) {
            if (squareFeed != null) {
                contactInfoItem.setNickName(squareFeed.getNickname());
                contactInfoItem.setGender(squareFeed.getGender());
                contactInfoItem.setIconURL(squareFeed.getAvatar());
            } else if (nearByBean != null) {
                contactInfoItem.setNickName(nearByBean.nickname);
                contactInfoItem.setGender(nearByBean.gender);
                contactInfoItem.setIconURL(nearByBean.avatar);
                contactInfoItem.setAge(String.valueOf(nearByBean.age));
            }
        }
    }

    public static String b(ContactInfoItem contactInfoItem) {
        return TextUtils.isEmpty(contactInfoItem.getBigIconURL()) ? contactInfoItem.getIconURL() : contactInfoItem.getBigIconURL();
    }

    public static void c(int i, long j, String str, String str2, SquareFeed squareFeed, Context context) {
        fk2.a aVar = new fk2.a();
        Bundle bundle = new Bundle();
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        if (str2 == null || !str2.equals(v4.b(context))) {
            contactInfoItem.setUid(str);
        } else {
            contactInfoItem.setUid(v4.e(context));
        }
        qj5.c(i, j, str2, squareFeed != null ? squareFeed.imprId : null, squareFeed);
        contactInfoItem.setExid(str2);
        contactInfoItem.setSourceType(44);
        contactInfoItem.setBizType(64);
        if (squareFeed != null) {
            contactInfoItem.setGender(squareFeed.sex);
        }
        a(contactInfoItem, squareFeed, null);
        bundle.putParcelable("user_item_info", contactInfoItem);
        bundle.putParcelable("square_feed", squareFeed);
        bundle.putInt("from", i == 4 ? 40 : i >= 73 ? i : 33);
        aVar.b(bundle);
        Intent intentA = n5.a(context, aVar);
        if (i == 4) {
            intentA.putExtra("enter_anim", R$anim.slide_in_left);
            intentA.putExtra("out_anim", R$anim.slide_out_right);
        }
        context.startActivity(intentA);
        if (i == 4 && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(R$anim.slide_in_right, R$anim.slide_out_left);
        }
    }

    public static void d(String str, int i, Context context, int i2, long j, String str2, SquareFeed squareFeed) {
        e(str, i, context, i2, j, str2, squareFeed, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(String str, int i, Context context, int i2, long j, String str2, SquareFeed squareFeed, NearByBean nearByBean) {
        fk2.a aVar = new fk2.a();
        Bundle bundle = new Bundle();
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        if (str.equals(v4.b(context))) {
            contactInfoItem.setUid(v4.e(context));
        } else {
            contactInfoItem.setUid("");
        }
        qj5.c(i2, j, str, str2, squareFeed);
        contactInfoItem.setExid(str);
        contactInfoItem.setGender(i);
        a(contactInfoItem, squareFeed, nearByBean);
        LogUtil.i("logaddfriend", "goUserDetail");
        if (i2 == 48) {
            if (nearByBean == null || !nearByBean.isSuperExpose()) {
                contactInfoItem.setSourceType(46);
                contactInfoItem.setBizType(bj5.b().a().u(68));
                bundle.putInt("from", 48);
            } else {
                contactInfoItem.setSourceType(60);
                contactInfoItem.setBizType(bj5.b().a().u(nearByBean.getChatBizType(2)));
                bundle.putInt("from", 79);
            }
        } else if (i2 == 113) {
            contactInfoItem.setSourceType(60);
            contactInfoItem.setBizType(bj5.b().a().u(62));
            bundle.putInt("from", i2);
        } else if (i2 == 49) {
            if (nearByBean == null || !nearByBean.isSuperExpose()) {
                contactInfoItem.setSourceType(46);
                contactInfoItem.setBizType(bj5.b().a().u(65));
                bundle.putInt("from", 34);
            } else {
                contactInfoItem.setSourceType(60);
                contactInfoItem.setBizType(bj5.b().a().u(nearByBean.getChatBizType(2)));
                bundle.putInt("from", 79);
            }
        } else if (i2 == 75) {
            contactInfoItem.setSourceType(46);
            contactInfoItem.setBizType(bj5.b().a().u(5016));
            bundle.putInt("from", i2);
        } else if (i2 >= 73) {
            contactInfoItem.setSourceType(46);
            contactInfoItem.setBizType(bj5.b().a().u(64));
            bundle.putInt("from", i2);
        } else {
            contactInfoItem.setSourceType(44);
            contactInfoItem.setBizType(bj5.b().a().u(64));
            bundle.putInt("from", 33);
        }
        if (nearByBean != null) {
            int i3 = nearByBean.userType;
            int i4 = NearByBean.TAG_TYPE_FEED_SEPARATION;
            if (i3 == i4) {
                contactInfoItem.setFeedSeparation(i4);
                contactInfoItem.setSourceType(60);
                contactInfoItem.setBizType(bj5.b().a().u(5033));
                bundle.putInt("from", 88);
            } else if (nearByBean != null) {
                int i5 = nearByBean.userType;
                int i6 = NearByBean.TAG_TYPE_FEED_POLISH;
                if (i5 == i6) {
                    contactInfoItem.setFeedSeparation(i6);
                    contactInfoItem.setSourceType(60);
                    contactInfoItem.setBizType(bj5.b().a().u(ErrorCode.BIDDING_C2S_TIMEOUT));
                    bundle.putInt("from", 89);
                }
            }
        }
        if (nearByBean != null && nearByBean.isAiChat()) {
            contactInfoItem.setSourceType(60);
            int iU = bj5.b().a().u(ErrorCode.DOWNLOADED_NOT_INSTALL_APK_NOT_EXITS);
            if (i2 == 49) {
                iU = bj5.b().a().u(5066);
            } else if (i2 == 48) {
                iU = bj5.b().a().u(5065);
            }
            LogUtil.d("", "AIP从找朋友打开个人资料页 aiBizType " + iU);
            contactInfoItem.setBizType(iU);
            bundle.putInt("from", 105);
        }
        if (!TextUtils.isEmpty(str2)) {
            SquareFeed squareFeed2 = new SquareFeed();
            squareFeed2.imprId = str2;
            bundle.putParcelable("square_feed", squareFeed2);
        }
        bundle.putParcelable("user_item_info", contactInfoItem);
        aVar.b(bundle);
        Intent intentA = n5.a(context, aVar);
        if (nearByBean != null && nearByBean.isSuperExpose()) {
            intentA.putExtra("superExposeMsgTabItem", 1);
        }
        context.startActivity(intentA);
    }

    public static void f(String str, String str2, int i, int i2, int i3, int i4, Context context) {
        fk2.a aVar = new fk2.a();
        Bundle bundle = new Bundle();
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        if (!TextUtils.isEmpty(str)) {
            contactInfoItem.setUid(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            contactInfoItem.setExid(str2);
        }
        contactInfoItem.setGender(i);
        contactInfoItem.setBizType(i3);
        contactInfoItem.setSourceType(i2);
        bundle.putParcelable("user_item_info", contactInfoItem);
        bundle.putInt("from", i4);
        aVar.b(bundle);
        context.startActivity(n5.a(context, aVar));
    }

    public static void g(int i, long j, String str, String str2, SquareFeed squareFeed, Context context, int i2, int i3) {
        fk2.a aVar = new fk2.a();
        Bundle bundle = new Bundle();
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        if (str2 == null || !str2.equals(v4.b(context))) {
            contactInfoItem.setUid(str);
        } else {
            contactInfoItem.setUid(v4.e(context));
        }
        qj5.c(i, j, str2, squareFeed != null ? squareFeed.imprId : null, squareFeed);
        contactInfoItem.setExid(str2);
        contactInfoItem.setSourceType(i2);
        contactInfoItem.setBizType(i3);
        if (squareFeed != null) {
            contactInfoItem.setGender(squareFeed.sex);
        }
        a(contactInfoItem, squareFeed, null);
        bundle.putParcelable("user_item_info", contactInfoItem);
        bundle.putParcelable("square_feed", squareFeed);
        bundle.putInt("from", i == 4 ? 40 : i >= 73 ? i : 33);
        aVar.b(bundle);
        Intent intentA = n5.a(context, aVar);
        if (i == 4) {
            intentA.putExtra("enter_anim", R$anim.slide_in_left);
            intentA.putExtra("out_anim", R$anim.slide_out_right);
        }
        context.startActivity(intentA);
        if (i == 4 && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(R$anim.slide_in_right, R$anim.slide_out_left);
        }
    }
}

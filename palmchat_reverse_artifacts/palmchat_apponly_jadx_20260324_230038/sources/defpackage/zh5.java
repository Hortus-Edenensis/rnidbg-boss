package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.constants.ErrorCode;
import com.zenmen.media.SquareCameraActivity;
import com.zenmen.media.album.SquareMediaPickActivity;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.activity.find.FindNearByMapActivity;
import com.zenmen.palmchat.activity.photoview.PhotoViewActivity;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.activity.webview.TransparentCordovaWebActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.chat.temporary.SquareTempChatActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.userdetail.UserProfileGuide;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.settings.view.CompleteGenderBirthdayDialog;
import com.zenmen.palmchat.square.DynamicExposeHomeActivity;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.square.activity.SquareMultiPublishActivity;
import com.zenmen.square.bean.SquareContactBean;
import com.zenmen.square.fragment.online.OnLineDetailData;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedShareCard;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.topic.bean.TopicListBean;
import defpackage.gs2;
import defpackage.ro2;
import defpackage.zh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zh5 implements ro2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ro2.b f22420a;

        public a(ro2.b bVar) {
            this.f22420a = bVar;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f22420a.onError("");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements CompleteGenderBirthdayDialog.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ro2.a f22423a;

        public d(ro2.a aVar) {
            this.f22423a = aVar;
        }

        @Override // com.zenmen.palmchat.settings.view.CompleteGenderBirthdayDialog.g
        public void onCancel() {
            this.f22423a.onCancel();
        }

        @Override // com.zenmen.palmchat.settings.view.CompleteGenderBirthdayDialog.g
        public void onSuccess() {
            this.f22423a.onSuccess();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements zh.a<ThreadChatItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f22425a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Activity c;

        public f(ContactInfoItem contactInfoItem, int i, Activity activity) {
            this.f22425a = contactInfoItem;
            this.b = i;
            this.c = activity;
        }

        @Override // zh.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ThreadChatItem threadChatItem) {
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) SquareTempChatActivity.class);
            intent.putExtra("chat_item", this.f22425a);
            intent.putExtra("superExposeMsgTabItem", this.b);
            intent.putExtra("chat_item", this.f22425a);
            intent.putExtra("thread_biz_type", this.f22425a.getBizType());
            this.c.startActivity(intent);
            this.c.overridePendingTransition(R.anim.alpha_fade_in, R.anim.alpha_fade_out);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ro2.b f22426a;

        public g(ro2.b bVar) {
            this.f22426a = bVar;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject.optInt("resultCode") != 0) {
                this.f22426a.onError("");
                return;
            }
            try {
                ContactInfoItem contactInfoItemP = l92.p(jSONObject);
                if (contactInfoItemP == null) {
                    this.f22426a.onError("");
                    return;
                }
                ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItemP.getUid());
                if (contactInfoItemL == null || contactInfoItemL.getIsStranger()) {
                    if (contactInfoItemL != null) {
                        contactInfoItemP.setRemarkName(contactInfoItemL.getRemarkName());
                        contactInfoItemP.setDescription(contactInfoItemL.getDescription());
                    }
                    AppContext.getContext().getContentResolver().insert(ho0.f18003a, nn0.a(contactInfoItemP));
                }
                this.f22426a.a(contactInfoItemP);
            } catch (Exception e) {
                this.f22426a.onError("");
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ro2.b f22427a;

        public h(ro2.b bVar) {
            this.f22427a = bVar;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f22427a.onError("");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ro2.b f22428a;

        public i(ro2.b bVar) {
            this.f22428a = bVar;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject.optInt("resultCode") != 0) {
                this.f22428a.onError(jSONObject.optString(MediationConstant.KEY_ERROR_MSG));
                return;
            }
            try {
                ContactInfoItem contactInfoItemP = l92.p(jSONObject);
                if (contactInfoItemP == null) {
                    this.f22428a.onError("");
                    return;
                }
                ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItemP.getUid());
                if (contactInfoItemL == null || contactInfoItemL.getIsStranger()) {
                    if (contactInfoItemL != null) {
                        contactInfoItemP.setRemarkName(contactInfoItemL.getRemarkName());
                        contactInfoItemP.setDescription(contactInfoItemL.getDescription());
                    }
                    AppContext.getContext().getContentResolver().insert(ho0.f18003a, nn0.a(contactInfoItemP));
                }
                this.f22428a.a(contactInfoItemP);
            } catch (Exception e) {
                this.f22428a.onError("");
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.ro2
    public void A(Activity activity, ArrayList<ContactInfoItem> arrayList, ArrayList<ContactInfoItem> arrayList2, int i2) {
        Intent intent = new Intent(activity, (Class<?>) GroupChatInitActivity.class);
        intent.putExtra("group_choose_contact", true);
        intent.putParcelableArrayListExtra("init_choose_contact_list", arrayList);
        intent.putParcelableArrayListExtra("display_contact_list", arrayList2);
        intent.putExtra("from_type", 10);
        activity.startActivityForResult(intent, i2);
    }

    @Override // defpackage.ro2
    public void B(Activity activity, ContactInfoItem contactInfoItem, String str) {
        contactInfoItem.setBizType(0);
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
        intent.putExtra("chat_item", contactInfoItem);
        intent.putExtra("thread_biz_type", contactInfoItem.getBizType());
        intent.putExtra("extra_key_square_feed", str);
        intent.putExtra("chat_need_back_to_main", false);
        intent.putExtra("chat_back_to_greet", false);
        k86.X(intent);
        activity.startActivity(intent);
    }

    @Override // defpackage.ro2
    public int C(int i2) {
        if (i2 == 109) {
            return 5048;
        }
        if (i2 == 110) {
            return 5049;
        }
        return i2 == 111 ? 5050 : 0;
    }

    @Override // defpackage.ro2
    public void D(Context context, LocationEx locationEx, SquareFeed squareFeed, int i2) {
        if (squareFeed == null || TextUtils.isEmpty(squareFeed.feedExt)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) FindNearByMapActivity.class);
        intent.putExtra("key_last_drift_location", locationEx);
        intent.putExtra("key_trip_info", squareFeed.feedExt);
        intent.putExtra("KEY_IS_FROM_OLD_NEARBY", true);
        intent.putExtra("KEY_FROM", i2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // defpackage.ro2
    public void E(int i2, Context context, ContactInfoItem contactInfoItem) {
        gs2.g(i2, context, contactInfoItem, new c());
    }

    @Override // defpackage.ro2
    public boolean F() {
        return ew1.h0();
    }

    @Override // defpackage.ro2
    public void G(Activity activity) {
        e9.d().q(activity);
    }

    @Override // defpackage.ro2
    public void H(Activity activity, JSONObject jSONObject, int i2) {
        if (jSONObject != null) {
            ez2.a("服务已关闭");
        }
    }

    @Override // defpackage.ro2
    public void I(Activity activity, int i2, int i3, int i4, long j) {
        W(activity, tj2.x(i2, i3, i4, j), String.valueOf(i3));
    }

    @Override // defpackage.ro2
    public void J(String str, ro2.b bVar) {
        ContactInfoItem contactInfoItemA = dn0.a(str);
        if (contactInfoItemA != null) {
            bVar.a(contactInfoItemA);
            return;
        }
        try {
            new l92(new i(bVar), new a(bVar)).n(str);
        } catch (DaoException e2) {
            e2.printStackTrace();
            bVar.onError("");
        }
    }

    @Override // defpackage.ro2
    public void K(Context context, int i2, SquareFeed squareFeed) {
        DynamicExposeHomeActivity.J1(context, i2, squareFeed);
    }

    @Override // defpackage.ro2
    public String L() {
        return tj2.q();
    }

    @Override // defpackage.ro2
    public void M(FragmentActivity fragmentActivity) {
        if (fragmentActivity == null || !xc3.I()) {
            return;
        }
        xc3.M(null, fragmentActivity, 1);
    }

    @Override // defpackage.ro2
    public void N(Context context, i53 i53Var, LocationEx locationEx) {
        dw1.F("SquareImpl getRealAddressByLocation", context, i53Var, locationEx);
    }

    @Override // defpackage.ro2
    public void O(Context context, ContactInfoItem contactInfoItem) {
        if (contactInfoItem == null || TextUtils.isEmpty(contactInfoItem.getBigIconURL()) || TextUtils.isEmpty(contactInfoItem.getIconURL())) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, PhotoViewActivity.class);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        MediaItem mediaItem = new MediaItem();
        mediaItem.thumbnailPath = contactInfoItem.getIconURL();
        mediaItem.fileFullPath = contactInfoItem.getBigIconURL();
        arrayList.add(mediaItem);
        intent.putParcelableArrayListExtra("mediaList", arrayList);
        intent.putExtra("selectIndex", 0);
        intent.putExtra("from_portrait", true);
        intent.putExtra("from_personal_info", true);
        intent.putExtra("from_user_portrait", true);
        intent.putExtra("show_mode", 0);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // defpackage.ro2
    public ContactInfoItem P(SquareContactBean squareContactBean) {
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setIconURL("phone contact");
        contactInfoItem.setNickName(squareContactBean.name);
        contactInfoItem.setUid(squareContactBean.id);
        contactInfoItem.setFirstPinyin(squareContactBean.firstPinyin);
        contactInfoItem.setMobile(squareContactBean.displayNumber);
        return contactInfoItem;
    }

    @Override // defpackage.ro2
    public String Q(String str) {
        return t66.h().e(str, "A");
    }

    @Override // defpackage.ro2
    public boolean R() {
        return e9.d().h();
    }

    @Override // defpackage.ro2
    public void S(int i2) {
        e9.d().b(i2);
    }

    @Override // defpackage.ro2
    public String T(String str, String str2) {
        return t66.h().e(str, str2);
    }

    @Override // defpackage.ro2
    public String U(int i2) {
        HashMap<Integer, String> map = ew1.f;
        if (map == null || !map.containsKey(Integer.valueOf(i2))) {
            return null;
        }
        return ew1.f.get(Integer.valueOf(i2));
    }

    @Override // defpackage.ro2
    public void V(Activity activity, int i2, int i3) {
        com.zenmen.palmchat.paidservices.superexpose.a.b().g(activity, i3, i2, false);
    }

    @Override // defpackage.ro2
    public void W(Activity activity, String str, String str2) {
        b05.d("showH5Dialog");
        Intent intent = new Intent();
        intent.setClass(activity, TransparentCordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putString("page_index", str2);
        bundle.putBoolean("extra_key_full_window", true);
        bundle.putBoolean("hide_progressbar", true);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override // defpackage.ro2
    public List<ContactInfoItem> X(ContactInfoItem contactInfoItem) {
        return bo0.r().t(contactInfoItem);
    }

    @Override // defpackage.ro2
    public boolean Y(String str) {
        v8.K(str);
        return v8.j(str);
    }

    @Override // defpackage.ro2
    public void Z(Context context, int i2, int i3, long j, long j2, String str, String str2) {
        CordovaWebActivity.y2(context, i2, i3, j, j2, str, str2, 9);
    }

    @Override // defpackage.ro2
    public boolean a() {
        return TeenagersModeManager.a().d();
    }

    @Override // defpackage.ro2
    public int a0(Context context, ChatItem chatItem) {
        int count = 0;
        if (chatItem.getChatType() == 0) {
            String[] strArr = {DomainHelper.a(chatItem, false)};
            Cursor cursorQuery = context.getContentResolver().query(DBUriManager.b(ho3.class, chatItem), new String[]{"_id"}, "contact_relate=?", strArr, null);
            if (cursorQuery != null) {
                count = cursorQuery.getCount();
                try {
                    cursorQuery.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return count;
    }

    @Override // defpackage.ro2
    public boolean b(Context context) {
        return fg6.j(context);
    }

    @Override // defpackage.ro2
    public String b0(String str) {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(str);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return null;
        }
        return dynamicConfig.getExtra();
    }

    @Override // defpackage.ro2
    public void c(Activity activity, String str, boolean z) {
        ve.o(activity, str, z);
    }

    @Override // defpackage.ro2
    public void c0(Activity activity, int i2, SquareTagBean squareTagBean, TopicListBean.Topic topic, TopicListBean.Ae ae, boolean z) {
        if (com.zenmen.palmchat.videocall.c.f()) {
            return;
        }
        if (mj5.r().t()) {
            sy5.e(activity, R.string.square_publish_uploading_now, 1).g();
        } else if (vi5.b().e()) {
            k0(activity, i2, squareTagBean, topic, ae, z);
        } else {
            vi5.b().c(activity, i2, new b(activity, i2, squareTagBean, topic, ae, z));
        }
    }

    @Override // defpackage.ro2
    public void d(Context context, int i2, ro2.a aVar) {
        CompleteGenderBirthdayDialog completeGenderBirthdayDialog = new CompleteGenderBirthdayDialog(context, i2);
        completeGenderBirthdayDialog.t(me1.b(AppContext.getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME));
        completeGenderBirthdayDialog.H(new d(aVar));
        completeGenderBirthdayDialog.show();
    }

    @Override // defpackage.ro2
    public void d0(Activity activity, ArrayList<ContactInfoItem> arrayList, ContactInfoItem contactInfoItem, int i2) {
        Intent intent = new Intent(activity, (Class<?>) GroupChatInitActivity.class);
        intent.putExtra("group_choose_contact", true);
        intent.putParcelableArrayListExtra("init_choose_contact_list", arrayList);
        intent.putExtra("filter_member", contactInfoItem);
        intent.putExtra("from_type", 9);
        activity.startActivityForResult(intent, i2);
    }

    @Override // defpackage.ro2
    public boolean e(String str, String str2) {
        return ew1.M(str, str2);
    }

    @Override // defpackage.ro2
    public void e0(Activity activity, int i2) {
        UserProfileGuide.k(activity, i2);
    }

    @Override // defpackage.ro2
    public int f() {
        return dw1.D();
    }

    @Override // defpackage.ro2
    public void f0(Activity activity) {
        oc3.b(activity, 8);
    }

    @Override // defpackage.ro2
    public void g(Activity activity, ContactInfoItem contactInfoItem, String str, int i2) {
        if (contactInfoItem.getIsStranger()) {
            if (contactInfoItem.getBizType() == 0) {
                contactInfoItem.setBizType(64);
            }
            if (contactInfoItem.getSourceType() == 0) {
                contactInfoItem.setSourceType(44);
            }
        }
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
        intent.putExtra("chat_item", contactInfoItem);
        intent.putExtra("thread_biz_type", contactInfoItem.getBizType());
        intent.putExtra("extra_key_square_feed", str);
        intent.putExtra("chat_need_back_to_main", false);
        intent.putExtra("chat_back_to_greet", false);
        intent.putExtra("superExposeMsgTabItem", i2);
        k86.X(intent);
        activity.startActivity(intent);
    }

    @Override // defpackage.ro2
    public void g0(Context context, LocationEx locationEx, boolean z, boolean z2, int i2) {
        FindNearByMapActivity.I3(context, locationEx, z, z2, 0, 0, i2);
    }

    @Override // defpackage.ro2
    public String h(long j) {
        return ew1.E(j);
    }

    @Override // defpackage.ro2
    public void h0(OnLineDetailData onLineDetailData) {
        if (onLineDetailData == null || onLineDetailData.userInfo == null || onLineDetailData.scheduleInfo == null) {
            return;
        }
        ew1.V(onLineDetailData.userInfo.uid + "", onLineDetailData.scheduleInfo.scheduleOrderId, z64.f(onLineDetailData));
    }

    @Override // defpackage.ro2
    public void i(Context context, LocationEx locationEx, boolean z, int i2, int i3, boolean z2, int i4) {
        FindNearByMapActivity.I3(context, locationEx, z, z2, i2, i3, i4);
    }

    @Override // defpackage.ro2
    public void j(Activity activity, ContactInfoItem contactInfoItem, int i2) {
        nw5.g(contactInfoItem.getChatId(), new f(contactInfoItem, i2, activity));
    }

    public final SquareContactBean j0(PhoneContactItem phoneContactItem) {
        String strY = phoneContactItem.y();
        if (TextUtils.isEmpty(strY)) {
            return null;
        }
        String strReplaceAll = strY.replaceAll("-", "").replaceAll(" ", "");
        if (strReplaceAll.length() < 11) {
            return null;
        }
        try {
            SquareContactBean squareContactBean = new SquareContactBean();
            squareContactBean.id = xn3.a();
            squareContactBean.name = phoneContactItem.m();
            squareContactBean.number = phoneContactItem.y();
            squareContactBean.displayNumber = strReplaceAll.substring(0, strReplaceAll.length() - 8) + "****" + strReplaceAll.substring(strReplaceAll.length() - 4);
            squareContactBean.numberMD5 = phoneContactItem.z();
            if (TextUtils.isEmpty(squareContactBean.name)) {
                squareContactBean.name = squareContactBean.displayNumber;
            }
            squareContactBean.firstPinyin = li4.a(squareContactBean.name);
            return squareContactBean;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // defpackage.ro2
    public boolean k() {
        return zv1.b();
    }

    public final void k0(Activity activity, int i2, SquareTagBean squareTagBean, TopicListBean.Topic topic, TopicListBean.Ae ae, boolean z) {
        if (nj5.a()) {
            Intent intent = new Intent();
            intent.putExtra("key_from", i2);
            intent.putExtra("key_need_pop_media", true);
            intent.putExtra("key_publish_time", iv0.a(System.currentTimeMillis(), "yyyy·MM·dd HH:mm"));
            intent.putExtra("clear_media", false);
            intent.putExtra("key_media_source", 2);
            intent.setClass(activity, SquareMultiPublishActivity.class);
            activity.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(activity, (Class<?>) SquareCameraActivity.class);
        intent2.setClass(activity, SquareMediaPickActivity.class);
        intent2.putExtra("key_from", i2);
        intent2.putExtra("key_tag", squareTagBean);
        intent2.putExtra("key_topic", topic);
        intent2.putExtra("key_topic_enable", z);
        intent2.putExtra("key_ae", ae);
        activity.startActivity(intent2);
    }

    @Override // defpackage.ro2
    public int l() {
        return ErrorCode.NO_AD_FILL_FOR_MULTI;
    }

    @Override // defpackage.ro2
    public boolean m() {
        return lj1.b();
    }

    @Override // defpackage.ro2
    public boolean n(String str, String str2) {
        return ew1.h(str, str2);
    }

    @Override // defpackage.ro2
    public List<SquareContactBean> o() {
        SquareContactBean squareContactBeanJ0;
        SquareContactBean squareContactBeanJ02;
        ArrayList arrayList = new ArrayList();
        ArrayList<PhoneContactItem.PhoneContactNumber> arrayList2 = new ArrayList();
        try {
            Cursor cursorQuery = AppContext.getContext().getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, null, null, "raw_contact_id");
            PhoneContactItem phoneContactItem = null;
            int i2 = -1;
            while (cursorQuery != null && cursorQuery.moveToNext()) {
                int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("raw_contact_id"));
                if (i2 != i3) {
                    if (phoneContactItem == null) {
                        phoneContactItem = new PhoneContactItem();
                    } else {
                        for (PhoneContactItem.PhoneContactNumber phoneContactNumber : arrayList2) {
                            if (phoneContactNumber != null) {
                                String strB = phoneContactNumber.b();
                                String strC = phoneContactNumber.c();
                                String strA = phoneContactNumber.a();
                                if (!TextUtils.isEmpty(strB)) {
                                    PhoneContactItem phoneContactItemH = PhoneContactItem.h(phoneContactItem);
                                    phoneContactItemH.U(hs0.g().d(strB));
                                    phoneContactItemH.T(strB);
                                    phoneContactItemH.V(strC);
                                    phoneContactItemH.Q(strA);
                                    if (!TextUtils.isEmpty(phoneContactItemH.z()) && (squareContactBeanJ02 = j0(phoneContactItemH)) != null) {
                                        arrayList.add(squareContactBeanJ02);
                                    }
                                }
                            }
                        }
                        phoneContactItem = new PhoneContactItem();
                        arrayList2.clear();
                    }
                    i2 = i3;
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("mimetype"));
                StringBuilder sb = new StringBuilder();
                sb.append("mimetype: ");
                sb.append(string);
                if (string.equals("vnd.android.cursor.item/name")) {
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("data2"));
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("data3"));
                    String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data4"));
                    String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("data5"));
                    String string7 = cursorQuery.getString(cursorQuery.getColumnIndex("data6"));
                    phoneContactItem.K(string2);
                    phoneContactItem.O(string3);
                    phoneContactItem.N(string4);
                    phoneContactItem.W(string5);
                    phoneContactItem.R(string6);
                    phoneContactItem.Y(string7);
                } else if (string.equals("vnd.android.cursor.item/phone_v2")) {
                    String string8 = cursorQuery.getString(cursorQuery.getColumnIndex("_id"));
                    String string9 = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string10 = cursorQuery.getString(cursorQuery.getColumnIndex("data2"));
                    String string11 = AppContext.getContext().getString(ContactsContract.CommonDataKinds.Phone.getTypeLabelResource(Integer.parseInt(string10)));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(", number=");
                    sb2.append(string9);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(", type=");
                    sb3.append(string10);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(", label=");
                    sb4.append(string11);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(", id=");
                    sb5.append(string8);
                    arrayList2.add(new PhoneContactItem.PhoneContactNumber(string9, string8, string11));
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            for (PhoneContactItem.PhoneContactNumber phoneContactNumber2 : arrayList2) {
                if (phoneContactNumber2 != null) {
                    String strB2 = phoneContactNumber2.b();
                    String strC2 = phoneContactNumber2.c();
                    String strA2 = phoneContactNumber2.a();
                    if (!TextUtils.isEmpty(strB2)) {
                        PhoneContactItem phoneContactItemH2 = PhoneContactItem.h(phoneContactItem);
                        phoneContactItemH2.U(hs0.g().d(strB2));
                        phoneContactItemH2.T(strB2);
                        phoneContactItemH2.V(strC2);
                        phoneContactItemH2.Q(strA2);
                        if (!TextUtils.isEmpty(phoneContactItemH2.z()) && (squareContactBeanJ0 = j0(phoneContactItemH2)) != null) {
                            arrayList.add(squareContactBeanJ0);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    @Override // defpackage.ro2
    public void p(SquareFeed squareFeed, ContactInfoItem contactInfoItem) {
        try {
            ch.s().u().r(sj5.n(contactInfoItem, SquareFeedShareCard.parse(squareFeed)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // defpackage.ro2
    public void q(String str, ro2.b bVar) {
        ContactInfoItem contactInfoItemB = dn0.b(str);
        if (contactInfoItemB != null) {
            bVar.a(contactInfoItemB);
            return;
        }
        try {
            new l92(new g(bVar), new h(bVar)).o(null, str);
        } catch (DaoException e2) {
            e2.printStackTrace();
            bVar.onError("");
        }
    }

    @Override // defpackage.ro2
    public void r(Activity activity, ContactInfoItem contactInfoItem, String str) {
        if (contactInfoItem.getBizType() == 0) {
            contactInfoItem.setBizType(64);
        }
        if (contactInfoItem.getSourceType() == 0) {
            contactInfoItem.setSourceType(44);
        }
        if (vi5.b().e()) {
            SquareTempChatActivity.I1(activity, contactInfoItem, contactInfoItem.getBizType(), str);
        } else {
            vi5.b().c(activity, 100, new e(activity, contactInfoItem, str));
        }
    }

    @Override // defpackage.ro2
    public String s() {
        return vc3.c;
    }

    @Override // defpackage.ro2
    public boolean t() {
        return ff2.b();
    }

    @Override // defpackage.ro2
    public int u(int i2) {
        return yt.a(i2);
    }

    @Override // defpackage.ro2
    public void v(Activity activity, int i2, int i3) {
        e9.d().n(activity, i2, i3);
    }

    @Override // defpackage.ro2
    public void w(boolean z) {
        e9.d().g = true;
    }

    @Override // defpackage.ro2
    public String x(Context context, String str, String str2, String str3, boolean z) {
        return il5.j(context, str, str2, str3, z);
    }

    @Override // defpackage.ro2
    public String y(long j) {
        return ew1.B(j);
    }

    @Override // defpackage.ro2
    public void z(Context context, int i2, String str, int i3, int i4) {
        CordovaWebActivity.x2(context, i2, str, i3, i4);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ro2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22421a;
        public final /* synthetic */ int b;
        public final /* synthetic */ SquareTagBean c;
        public final /* synthetic */ TopicListBean.Topic d;
        public final /* synthetic */ TopicListBean.Ae e;
        public final /* synthetic */ boolean f;

        public b(Activity activity, int i, SquareTagBean squareTagBean, TopicListBean.Topic topic, TopicListBean.Ae ae, boolean z) {
            this.f22421a = activity;
            this.b = i;
            this.c = squareTagBean;
            this.d = topic;
            this.e = ae;
            this.f = z;
        }

        @Override // ro2.a
        public void onSuccess() {
            zh5.this.k0(this.f22421a, this.b, this.c, this.d, this.e, this.f);
        }

        @Override // ro2.a
        public void onCancel() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements gs2.b {
        public c() {
        }

        @Override // gs2.b
        public void a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements ro2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22424a;
        public final /* synthetic */ ContactInfoItem b;
        public final /* synthetic */ String c;

        public e(Activity activity, ContactInfoItem contactInfoItem, String str) {
            this.f22424a = activity;
            this.b = contactInfoItem;
            this.c = str;
        }

        @Override // ro2.a
        public void onSuccess() {
            Activity activity = this.f22424a;
            ContactInfoItem contactInfoItem = this.b;
            SquareTempChatActivity.I1(activity, contactInfoItem, contactInfoItem.getBizType(), this.c);
        }

        @Override // ro2.a
        public void onCancel() {
        }
    }
}

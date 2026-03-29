package defpackage;

import android.content.ContentValues;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.openalliance.ad.constant.w;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.zenmen.media.rtc.ZMRtcSessionInfo;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.media.AudioDownloader;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.smallvideo.VideoSDKPushReceiver;
import com.zenmen.palmchat.sync.AlertVo;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ap4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f1548a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<List<AlertVo>> {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Comparator<ContentValues> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ContentValues contentValues, ContentValues contentValues2) {
            if (contentValues == null || contentValues2 == null) {
                return 0;
            }
            long jLongValue = contentValues.getAsLong("resource_version").longValue() - contentValues2.getAsLong("resource_version").longValue();
            if (jLongValue > 0) {
                return 1;
            }
            return jLongValue == 0 ? 0 : -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Comparator<ContentValues> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ContentValues contentValues, ContentValues contentValues2) {
            if (contentValues == null || contentValues2 == null) {
                return 0;
            }
            long jLongValue = contentValues.getAsLong("resource_version").longValue() - contentValues2.getAsLong("resource_version").longValue();
            if (jLongValue > 0) {
                return 1;
            }
            return jLongValue == 0 ? 0 : -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Comparator<MessageProto.Message> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageProto.Message message, MessageProto.Message message2) {
            if (message == null || message2 == null) {
                return 0;
            }
            long version = message.getVersion() - message2.getVersion();
            if (version > 0) {
                return 1;
            }
            return version == 0 ? 0 : -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Comparator<MessageProto.Message> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageProto.Message message, MessageProto.Message message2) {
            if (message == null || message2 == null) {
                return 0;
            }
            long version = message.getVersion() - message2.getVersion();
            if (version > 0) {
                return 1;
            }
            return version == 0 ? 0 : -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Comparator<MessageProto.Message> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageProto.Message message, MessageProto.Message message2) {
            if (message == null || message2 == null) {
                return 0;
            }
            long version = message.getVersion() - message2.getVersion();
            if (version > 0) {
                return 1;
            }
            return version == 0 ? 0 : -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Comparator<MessageProto.Message> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageProto.Message message, MessageProto.Message message2) {
            if (message == null || message2 == null) {
                return 0;
            }
            long version = message.getVersion() - message2.getVersion();
            if (version > 0) {
                return 1;
            }
            return version == 0 ? 0 : -1;
        }
    }

    public static final ContentValues a(ContentValues contentValues, Long l, String str) {
        Long asLong = (contentValues == null || !contentValues.containsKey("resource_version")) ? null : contentValues.getAsLong("resource_version");
        boolean z = false;
        if (l != null && (asLong == null || asLong.longValue() < l.longValue())) {
            z = true;
        }
        LogUtil.i("PullResProcessor", "buildContentValuesForVersion needUpdateVersion=" + z + " dataVersion=" + asLong + " version=" + l + " restype =" + str);
        if (!z || str == null) {
            return null;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("contact_operation", (Integer) 1);
        contentValues2.put("group_operation", (Integer) 1);
        contentValues2.put("msg_type", (Integer) 1);
        contentValues2.put(CommonCode.MapKey.UPDATE_VERSION, Boolean.TRUE);
        contentValues2.put("resource_version", l);
        contentValues2.put("resource_type", str);
        return contentValues2;
    }

    public static void b(jq5 jq5Var) {
        List<String> list = jq5Var.d;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean zN = ts0.o().N();
        HashMap map = new HashMap();
        map.put("enable", Boolean.valueOf(zN));
        map.put("keys", jq5Var.e);
        zn6.j("lx_sync_reset", "view", map);
        if (zN) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("resource_type", str);
                contentValues.put("resource_version", (Integer) 0);
                contentValues.put(CommonCode.MapKey.UPDATE_VERSION, Boolean.TRUE);
                arrayList.add(contentValues);
            }
            if (arrayList.size() > 0) {
                dv.a("operateSyncKeys", hq5.f18030a, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]), false);
            }
        }
    }

    public static long c(ArrayList<ContentValues> arrayList) {
        Long asLong;
        if (arrayList == null || arrayList.size() <= 0 || (asLong = arrayList.get(arrayList.size() - 1).getAsLong(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE)) == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    public static void d(ArrayList<MessageProto.Message> arrayList, Long l, long j) {
        e(arrayList, true, l, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(ArrayList<MessageProto.Message> arrayList, boolean z, Long l, long j) {
        boolean z2;
        Pair pair;
        boolean z3;
        int i;
        MessageProto.Message message;
        ContentValues contentValues;
        boolean z4;
        JSONObject jSONObjectH;
        fw5.c(j);
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        String strP = AccountUtils.p(AppContext.getContext());
        int i2 = 21;
        int i3 = 13;
        int i4 = 12;
        if (arrayList.size() > 0) {
            ArrayList arrayList7 = new ArrayList();
            ArrayList arrayList8 = new ArrayList();
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                MessageProto.Message message2 = arrayList.get(i5);
                if (f46.e(message2)) {
                    long createTime = message2.getCreateTime();
                    if (createTime > f1548a) {
                        f1548a = createTime;
                    }
                }
            }
            z2 = false;
            int i6 = 0;
            z3 = false;
            Pair pair2 = null;
            while (i6 < arrayList.size()) {
                int type = arrayList.get(i6).getType();
                if (type == 10 || type == 12 || type == 101 || type == i3 || type == 20 || type == i2) {
                    ContentValues contentValuesA = rn0.a(arrayList.get(i6), true);
                    arrayList8.add(contentValuesA);
                    if (!TextUtils.isEmpty(contentValuesA.getAsString("rid")) && fw5.b(arrayList.get(i6))) {
                        pair2 = new Pair(contentValuesA, arrayList.get(i6).getExtension());
                    }
                } else {
                    ContentValues contentValuesF = com.zenmen.palmchat.database.b.f(arrayList.get(i6));
                    if (contentValuesF != null) {
                        arrayList7.add(contentValuesF);
                    }
                    String mid = arrayList.get(i6).getMid();
                    if (!TextUtils.isEmpty(mid) && mid.contains("square") && arrayList.get(i6).getType() == 1) {
                        z3 = true;
                    }
                    if (type == 30) {
                        arrayList2.add(arrayList.get(i6));
                    } else if (type == 102 || f46.f(arrayList.get(i6)) || f46.g(arrayList.get(i6))) {
                        LogUtil.i("lognotify", "insertSyncMessages: mPacket = " + arrayList.get(i6));
                        arrayList3.add(arrayList.get(i6));
                    } else {
                        if (f46.e(arrayList.get(i6))) {
                            z4 = true;
                        }
                        if (type == 8) {
                            LogUtil.i("PullResProcessor", "DialogMessage mPacket = " + arrayList.get(i6));
                            arrayList5.add(arrayList.get(i6));
                        }
                        if (type == 50) {
                            arrayList4.add(arrayList.get(i6));
                        }
                        if (type != 52) {
                            MessageProto.Message message3 = arrayList.get(i6);
                            try {
                                jSONObjectH = lg1.c().h(DomainHelper.q(DomainHelper.t(message3.getFrom())).equals(strP) ? DomainHelper.j(message3.getTo()) : DomainHelper.j(message3.getFrom()), new JSONObject(message3.getExtension()).optJSONObject("jieLong").optString("jlId"));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (jSONObjectH.optInt("resultCode") == 0) {
                                arrayList8.add(com.zenmen.palmchat.database.b.e(message3.toBuilder().setExtension(jSONObjectH.toString()).build()));
                                arrayList6.add(message3);
                            } else {
                                arrayList8.add(com.zenmen.palmchat.database.b.e(arrayList.get(i6)));
                            }
                            z2 = z4;
                        }
                    }
                    z4 = z2;
                    if (type == 8) {
                    }
                    if (type == 50) {
                    }
                    if (type != 52) {
                    }
                }
                i6++;
                i2 = 21;
                i3 = 13;
            }
            dv.a("insertStrangersSync", ho0.f18003a, (ContentValues[]) arrayList7.toArray(new ContentValues[arrayList7.size()]), true);
            if (arrayList8.size() > 0) {
                Collections.sort(arrayList8, new b());
                contentValues = (ContentValues) arrayList8.get(arrayList8.size() - 1);
                r(arrayList3);
                s(arrayList2, arrayList8);
                q(arrayList5);
                j(arrayList5);
            } else {
                contentValues = null;
            }
            c(arrayList8);
            ContentValues contentValuesA2 = a(contentValues, l, "3");
            if (contentValuesA2 != null) {
                arrayList8.add(contentValuesA2);
            }
            dv.a("processMessagesSync", DBUriManager.a(ho3.class, 0), (ContentValues[]) arrayList8.toArray(new ContentValues[arrayList8.size()]), true);
            pair = pair2;
        } else {
            z2 = false;
            pair = null;
            z3 = false;
        }
        if (z2) {
            Intent intent = new Intent();
            intent.setAction(mo3.n);
            LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
        }
        if (z3) {
            ds0.a().b(new oj5());
        }
        f(pair, true);
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        boolean z5 = false;
        String extension = null;
        for (MessageProto.Message message4 : arrayList) {
            if (message4.getType() == 3) {
                AudioDownloader.getInstance().downloadAudioFileByMessageId(MessageVo.buildFromMessageProtoForTmpUse(message4), false);
            } else if (message4.getType() == 10001) {
                String strA = wn3.a(message4);
                if (!TextUtils.isEmpty(strA)) {
                    arrayList9.add(strA);
                }
            } else if (message4.getType() == 45 || message4.getType() == 46 || (message4.getType() == 47 && (fu5.o(message4) == 11 || fu5.o(message4) == i4 || fu5.o(message4) == 13 || fu5.o(message4) == 41 || fu5.o(message4) == 32))) {
                arrayList10.add(message4);
            } else if (message4.getType() == 47 && fu5.o(message4) == 21) {
                arrayList12.add(message4);
            } else if (message4.getType() == 47 && fu5.o(message4) == 23) {
                arrayList14.add(message4);
            } else if (message4.getType() == 47) {
                arrayList11.add(message4);
            } else if (message4.getType() == 49) {
                extension = message4.getExtension();
                z5 = true;
            } else if (VideoSDKPushReceiver.isVideoSDKPushMsg(message4.getType())) {
                arrayList15.add(message4);
            } else if (message4.getType() == 54) {
                arrayList13.add(message4);
            }
            i4 = 12;
        }
        if (arrayList15.size() > 0) {
            VideoSDKPushReceiver.onMsg((ArrayList<MessageProto.Message>) arrayList15);
        }
        if (arrayList12.size() > 0) {
            ag2.c().d(arrayList12);
        }
        if (arrayList14.size() > 0) {
            vx3.c().d(arrayList14);
        }
        if (arrayList10.size() > 0) {
            cp4.a().b(arrayList10);
        }
        if (arrayList11.size() > 0) {
            qn0.a().e((MessageProto.Message) arrayList11.get(arrayList11.size() - 1));
        }
        if (arrayList13.size() > 0) {
            tx1.b().c(arrayList13);
        }
        if (z5) {
            Intent intent2 = new Intent();
            if (extension != null) {
                intent2.putExtra("extContent", extension);
            }
            intent2.setAction(mo3.e);
            LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent2);
        }
        ds3.c().e(arrayList);
        if (z) {
            int size = arrayList.size() - 1;
            while (true) {
                if (size < 0) {
                    message = null;
                    break;
                }
                MessageProto.Message message5 = arrayList.get(size);
                String strT = DomainHelper.t(message5.getTo());
                if (strT != null && strT.equals(strP) && !DomainHelper.r(message5.getFrom()) && ((!"88888027".equals(m40.a(message5.getFrom())) || VideoSDKPushReceiver.notifySyncedMsg()) && fw5.b(arrayList.get(size)))) {
                    message = message5;
                    break;
                }
                size--;
            }
            Intent intent3 = new Intent();
            intent3.setAction(mo3.d);
            if (message != null) {
                intent3.putExtra("key_subtype", fu5.o(message));
                intent3.putExtra("key_packet_extension", message.getExtension());
                intent3.putExtra("key_mid", message.getMid());
                intent3.putExtra("key_mimetype", message.getType());
                intent3.putExtra("key_from", message.getFrom());
                intent3.putExtra("key_body", message.getBody());
            }
            if (arrayList9.size() > 0) {
                intent3.putExtra("key_message_recall_list", arrayList9);
            }
            i = 1;
            intent3.putExtra("key_from_sync", true);
            LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent3);
        } else {
            i = 1;
        }
        for (int size2 = arrayList.size() - i; size2 >= 0; size2--) {
            MessageProto.Message message6 = arrayList.get(size2);
            xa3.e("receive", message6);
            com.zenmen.palmchat.chat.g.u(message6.getFrom(), message6.getMid(), message6.getType(), message6.getExtension());
            a65.g(message6, "sync");
        }
    }

    public static void f(Pair<ContentValues, String> pair, boolean z) {
        if (pair != null) {
            ContentValues contentValues = (ContentValues) pair.first;
            String str = (String) pair.second;
            String asString = contentValues.getAsString("rid");
            String asString2 = contentValues.getAsString("user_info");
            String asString3 = contentValues.getAsString("mid");
            if (TextUtils.isEmpty(asString) || TextUtils.isEmpty(asString2)) {
                return;
            }
            try {
                Intent intent = new Intent();
                intent.setAction(mo3.f);
                ContactInfoItem contactInfoItemD = nn0.d(new JSONObject(asString2));
                try {
                    contactInfoItemD.setSourceType(Integer.parseInt(contentValues.getAsString("source_type")));
                    contactInfoItemD.setRequestType(contentValues.getAsInteger("request_type").intValue());
                } catch (Exception unused) {
                }
                intent.putExtra("key_contact_item", contactInfoItemD);
                intent.putExtra("key_rid", asString);
                intent.putExtra("key_mid", asString3);
                intent.putExtra("key_contact_request_extension", str);
                intent.putExtra("key_from_sync", z);
                LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
            } catch (JSONException unused2) {
            }
        }
    }

    public static void g(HashMap<String, Long> map, HashMap<String, Long> map2) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("9");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("11");
        arrayList.add(BaseWrapper.ENTER_ID_MARKET);
        arrayList.add(BaseWrapper.ENTER_ID_AD_SDK);
        arrayList.add("15");
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            Long lP = eq5.p(map, map2, str);
            if (lP != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("resource_type", str);
                contentValues.put("resource_version", lP);
                arrayList2.add(contentValues);
            }
        }
        if (arrayList2.size() > 0) {
            dv.a("operateSyncKeys", hq5.f18030a, (ContentValues[]) arrayList2.toArray(new ContentValues[arrayList2.size()]), false);
        }
    }

    public static void h(JSONObject jSONObject, Long l) {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("alerts")) == null || (arrayList = (ArrayList) az2.b(jSONArrayOptJSONArray.toString(), new a().getType())) == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (((AlertVo) arrayList.get(i)).nid == 3) {
                fu3.a().b((AlertVo) arrayList.get(i));
                return;
            }
        }
    }

    public static void i(JSONObject jSONObject, Long l) throws JSONException {
        ContentValues contentValues;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("modFriend");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                ContentValues contentValuesB = co0.b(false, jSONArrayOptJSONArray.getJSONObject(i), 1);
                if (contentValuesB != null) {
                    arrayList.add(contentValuesB);
                }
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("delFriend");
        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                ContentValues contentValuesB2 = co0.b(false, jSONArrayOptJSONArray2.getJSONObject(i2), 2);
                if (contentValuesB2 != null) {
                    arrayList.add(contentValuesB2);
                }
            }
        }
        if (arrayList.size() > 0) {
            Collections.sort(arrayList, new c());
            contentValues = (ContentValues) arrayList.get(arrayList.size() - 1);
        } else {
            contentValues = null;
        }
        ContentValues contentValuesA = a(contentValues, l, "2");
        if (contentValuesA != null) {
            arrayList.add(contentValuesA);
        }
        if (arrayList.size() > 0) {
            dv.a("processContactsSync", ho0.f18003a, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]), true);
        }
    }

    public static void j(ArrayList<MessageProto.Message> arrayList) {
        LogUtil.i("logmatch", "processSyncedMeeyouMessages");
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Collections.sort(arrayList, new g());
        Iterator<MessageProto.Message> it = arrayList.iterator();
        while (it.hasNext()) {
            LogUtil.i("logmatch", "processSyncedMeeyouMessages:" + it.next());
        }
        lg1.c().j(arrayList);
    }

    public static void k(JSONObject jSONObject, Long l) throws JSONException {
        ae2.g(jSONObject, l);
    }

    public static MessageProto.Message l(JSONObject jSONObject) {
        MessageProto.Message messageD;
        if (jSONObject != null && (messageD = mb4.d(jSONObject)) != null) {
            int type = messageD.getType();
            if (type == 1 || type == 2 || type == 14 || type == 3 || type == 4 || type == 7 || type == 6 || type == 9 || type == 28 || type == 16 || type == 22 || type == 17 || type == 10 || type == 12 || type == 101 || type == 13 || type == 10001 || type == 44 || type == 10000 || type == 21 || type == 10002 || type == 10005 || type == 53 || type == 52) {
                return messageD;
            }
            if (type != 18 && type != 19 && type != 11 && type != 5) {
                if (type == 30) {
                    LogUtil.i("PullResProcessor", "sync processVideoCallMessage mid: " + messageD.getMid());
                    return messageD;
                }
                if (type == 24 || type != 56 || oc0.d()) {
                    return messageD;
                }
            }
        }
        return null;
    }

    public static void m(JSONObject jSONObject, Long l, long j) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("messages");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                MessageProto.Message messageL = l(jSONArrayOptJSONArray.getJSONObject(i));
                if (messageL != null) {
                    arrayList.add(messageL);
                }
            }
        }
        if (arrayList.size() > 0) {
            d(arrayList, l, j);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ContentValues contentValuesA = a(null, l, "3");
        if (contentValuesA != null) {
            arrayList2.add(contentValuesA);
        }
        if (arrayList2.size() > 0) {
            dv.a("processMessagesSync", DBUriManager.a(ho3.class, 0), (ContentValues[]) arrayList2.toArray(new ContentValues[arrayList2.size()]), true);
        }
    }

    public static void n(JSONObject jSONObject, Long l) throws JSONException {
        ContentValues contentValuesB;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(IMediaFormat.KEY_PROFILE);
        if (jSONObjectOptJSONObject != null) {
            LogUtil.d("PullResProcessor", "profileData = " + jSONObjectOptJSONObject.toString() + ", mode = " + Integer.valueOf(jSONObjectOptJSONObject.optInt("mode")));
            AppContext.getContext().getTrayPreferences().f(k86.w(), jSONObjectOptJSONObject.optInt("privacyConfig"));
            AppContext.getContext().getTrayPreferences().f(k86.s(), jSONObjectOptJSONObject.optInt("mode"));
            if (jSONObjectOptJSONObject.has("kidsModeCfg")) {
                TeenagersModeManager.a().f(jSONObjectOptJSONObject.optInt("kidsModeCfg"));
            }
            t34.f(t34.e(jSONObjectOptJSONObject.optString("ext")));
            contentValuesB = co0.b(true, jSONObjectOptJSONObject, 1);
            if (contentValuesB != null) {
                arrayList.add(contentValuesB);
                AccountUtils.z(AppContext.getContext(), contentValuesB);
                AccountUtils.A(AppContext.getContext(), "mobile", jSONObjectOptJSONObject.optString("phone"));
                AccountUtils.A(AppContext.getContext(), w.v, jSONObjectOptJSONObject.optString("ic"));
            }
        } else {
            contentValuesB = null;
        }
        ContentValues contentValuesA = a(contentValuesB, l, "1");
        if (contentValuesA != null) {
            arrayList.add(contentValuesA);
        }
        if (arrayList.size() > 0) {
            dv.a("processProfileSync", ho0.f18003a, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]), true);
        }
    }

    public static void o(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("serviceIds");
        if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("idList")) != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                ContentValues contentValuesD = co0.d(jSONArrayOptJSONArray.getJSONObject(i));
                if (contentValuesD != null) {
                    arrayList.add(contentValuesD);
                }
            }
        }
        if (arrayList.size() > 0) {
            dv.a("processContactsSync", ho0.f18003a, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]), true);
        }
    }

    public static void p(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("serviceIds4User");
        if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("idList")) != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                ContentValues contentValuesC = co0.c(jSONArrayOptJSONArray.getJSONObject(i));
                if (contentValuesC != null) {
                    arrayList.add(contentValuesC);
                }
            }
        }
        if (arrayList.size() > 0) {
            dv.a("processContactsSync", ho0.f18003a, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]), true);
        }
    }

    public static void q(ArrayList<MessageProto.Message> arrayList) {
        LogUtil.i("PullResProcessor", "processSyncedDialogMessages");
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Collections.sort(arrayList, new f());
        for (MessageProto.Message message : arrayList) {
            LogUtil.d("logmatch", "processSyncedDialogMessages:" + message);
            ad1.h().k(message);
        }
    }

    public static void r(ArrayList<MessageProto.Message> arrayList) {
        int i;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Collections.sort(arrayList, new e());
        int size = arrayList.size();
        while (true) {
            size--;
            i = -1;
            if (size >= 0) {
                if (f46.g(arrayList.get(size))) {
                    break;
                }
            } else {
                size = -1;
                break;
            }
        }
        int size2 = arrayList.size() - 1;
        while (true) {
            if (size2 < 0) {
                break;
            }
            if (f46.f(arrayList.get(size2))) {
                i = size2;
                break;
            }
            size2--;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            MessageProto.Message message = arrayList.get(i2);
            if (f46.f(message)) {
                if (i == i2) {
                    LogUtil.i("UnReadStatusSyncManager", "processClearMomentCmd sync clearMomentCmdIndex=" + i + "i=" + i2);
                    f46.h(message);
                }
            } else if (!f46.g(message)) {
                sq3.o().E(AppContext.getContext(), message);
            } else if (size == i2) {
                LogUtil.i("UnReadStatusSyncManager", "processClearMomentCmd sync clearMomentCmdIndex=" + size + "i=" + i2);
                f46.h(message);
            }
        }
    }

    public static void s(ArrayList<MessageProto.Message> arrayList, ArrayList<ContentValues> arrayList2) {
        long j;
        int i;
        ZMRtcSessionInfo zMRtcSessionInfo;
        int i2;
        String str;
        boolean z;
        MessageProto.Message message;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Collections.sort(arrayList, new d());
        boolean z2 = false;
        if (pa6.p().z()) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                t(arrayList.get(i3), false, false);
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            return;
        }
        long j2 = 0;
        int i4 = 0;
        MessageProto.Message message2 = null;
        while (i4 < arrayList.size()) {
            MessageProto.Message message3 = arrayList.get(i4);
            try {
                String string = new JSONObject(message3.getExtension()).getJSONObject("voipMsg").getString("data");
                zMRtcSessionInfo = new ZMRtcSessionInfo();
                pa6.p().s(string, zMRtcSessionInfo);
                LogUtil.i("VideoCallSync", zMRtcSessionInfo.toString());
                i2 = zMRtcSessionInfo.signalType;
            } catch (JSONException e3) {
                e = e3;
                j = j2;
            }
            if (i2 == ZMRtcSessionInfo.SignallingTypeOnReceive) {
                try {
                    j2 = zMRtcSessionInfo.roomId;
                    i = i4;
                    message2 = message3;
                } catch (JSONException e4) {
                    e = e4;
                    j = j2;
                    i = i4;
                    message2 = message3;
                    e.printStackTrace();
                    j2 = j;
                }
                i4 = i + 1;
                z2 = false;
            } else {
                if (i2 == ZMRtcSessionInfo.SignallingTypeOnStatusUpdate) {
                    t(message3, z2, z2);
                    j = j2;
                } else {
                    if (message2 != null) {
                        try {
                            if (j2 == zMRtcSessionInfo.roomId && i2 == ZMRtcSessionInfo.SignallingTypeOnHangup) {
                                j = j2;
                                try {
                                    MessageProto.Message messageBuild = MessageProto.Message.newBuilder(message3).setMid(xn3.a()).setFrom(String.valueOf(zMRtcSessionInfo.byUserId)).setBody(AppContext.getContext().getString(zMRtcSessionInfo.sessionType == 0 ? R.string.message_type_video_call : R.string.message_type_voice_call)).setExtension("").build();
                                    ContentValues contentValuesE = com.zenmen.palmchat.database.b.e(messageBuild);
                                    contentValuesE.put("msg_type", (Integer) 30);
                                    contentValuesE.put("read", (Integer) 0);
                                    contentValuesE.put("data1", AppContext.getContext().getString(R.string.video_call_msg_callee_cancelled));
                                    contentValuesE.put("data2", String.valueOf(zMRtcSessionInfo.sessionType));
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= arrayList2.size()) {
                                            break;
                                        }
                                        try {
                                            String asString = arrayList2.get(i5).getAsString("packet_id");
                                            if (!TextUtils.isEmpty(asString) && asString.equals(message3.getMid())) {
                                                arrayList2.remove(i5);
                                                arrayList2.add(i5, contentValuesE);
                                                break;
                                            }
                                            i5++;
                                        } catch (JSONException e5) {
                                            e = e5;
                                            i = i4;
                                            e.printStackTrace();
                                            j2 = j;
                                            i4 = i + 1;
                                            z2 = false;
                                        }
                                    }
                                    ua6.g(AppContext.getContext(), messageBuild.getFrom());
                                    try {
                                        if (com.zenmen.palmchat.videocall.c.e()) {
                                            message = null;
                                        } else {
                                            r75.o(AppContext.getContext(), k86.a("sp_video_call_enabled"), true);
                                            if (com.zenmen.palmchat.videocall.c.e()) {
                                                try {
                                                    JSONObject jSONObject = new JSONObject();
                                                    jSONObject.put(OapsKey.KEY_CALLER, String.valueOf(zMRtcSessionInfo.byUserId));
                                                    message = null;
                                                    try {
                                                        LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80", null, null, jSONObject.toString());
                                                    } catch (JSONException e6) {
                                                        e = e6;
                                                        try {
                                                            e.printStackTrace();
                                                        } catch (JSONException e7) {
                                                            e = e7;
                                                            message2 = message;
                                                            i = i4;
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                } catch (JSONException e8) {
                                                    e = e8;
                                                    message = null;
                                                }
                                            } else {
                                                message = null;
                                                LogUtil.i("PullResProcessor", "VideoCall is disabled");
                                            }
                                        }
                                        message2 = message;
                                    } catch (JSONException e9) {
                                        e = e9;
                                        message = null;
                                    }
                                } catch (JSONException e10) {
                                    e = e10;
                                    i = i4;
                                    e.printStackTrace();
                                    j2 = j;
                                    i4 = i + 1;
                                    z2 = false;
                                }
                            } else {
                                j = j2;
                                str = "msg_type";
                                z = true;
                            }
                        } catch (JSONException e11) {
                            e = e11;
                            j = j2;
                        }
                    } else {
                        j = j2;
                        str = "msg_type";
                        z = true;
                    }
                    if (i2 == ZMRtcSessionInfo.SignallingTypeOnHangup) {
                        if (zMRtcSessionInfo.sessionType != 0) {
                            z = false;
                        }
                        i = i4;
                        try {
                            MessageProto.Message messageBuild2 = MessageProto.Message.newBuilder(message3).setMid(xn3.a()).setFrom(String.valueOf(zMRtcSessionInfo.byUserId)).setBody(AppContext.getContext().getString(z ? R.string.message_type_video_call : R.string.message_type_voice_call)).setExtension("").build();
                            ContentValues contentValuesE2 = com.zenmen.palmchat.database.b.e(messageBuild2);
                            contentValuesE2.put(str, (Integer) 30);
                            contentValuesE2.put("read", (Integer) 0);
                            contentValuesE2.put("data1", AppContext.getContext().getString(R.string.video_call_msg_callee_cancelled));
                            contentValuesE2.put("data2", String.valueOf(zMRtcSessionInfo.sessionType));
                            AppContext.getContext().getContentResolver().insert(DBUriManager.c(ho3.class, messageBuild2.getFrom()), contentValuesE2);
                        } catch (JSONException e12) {
                            e = e12;
                            e.printStackTrace();
                        }
                    }
                    j2 = j;
                    i4 = i + 1;
                    z2 = false;
                }
                i = i4;
                j2 = j;
                i4 = i + 1;
                z2 = false;
            }
            e.printStackTrace();
            j2 = j;
            i4 = i + 1;
            z2 = false;
        }
        if (message2 != null) {
            t(message2, false, false);
        }
    }

    public static void t(MessageProto.Message message, boolean z, boolean z2) {
        String extension = message.getExtension();
        String from = message.getFrom();
        String strC = m40.c(message.getTo());
        LogUtil.i("VideoCall", "[processVideoCallMessage] push = " + z + " from = " + from + " to = " + strC + " extension = " + extension, 1);
        if (TextUtils.isEmpty(strC) || !strC.equals(AccountUtils.p(AppContext.getContext()))) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(extension);
            pa6.p().O(z2, message.getCreateTime());
            pa6.p().w(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void u() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("4");
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("resource_type", str);
            contentValues.put("resource_version", (Integer) 0);
            contentValues.put(CommonCode.MapKey.UPDATE_VERSION, Boolean.TRUE);
            arrayList2.add(contentValues);
        }
        if (arrayList2.size() > 0) {
            dv.a("operateSyncKeys", hq5.f18030a, (ContentValues[]) arrayList2.toArray(new ContentValues[arrayList2.size()]), false);
        }
    }

    public static void v() {
        ArrayList arrayList = new ArrayList();
        for (String str : mx4.f19387a) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("resource_type", str);
            contentValues.put("resource_version", (Long) Long.MAX_VALUE);
            contentValues.put(CommonCode.MapKey.UPDATE_VERSION, Boolean.TRUE);
            arrayList.add(contentValues);
        }
        if (arrayList.size() > 0) {
            dv.a("operateSyncKeys", hq5.f18030a, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]), false);
        }
    }
}

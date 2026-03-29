package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.umeng.ccg.a;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.chatprofile.bean.ChatProfileInfo;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class rn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20510a = "rn0";

    public static ContentValues a(MessageProto.Message message, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("resource_type", message.getSyncKey());
        contentValues.put("resource_version", Long.valueOf(message.getVersion()));
        contentValues.put("send_time", Long.valueOf(message.getCreateTime()));
        contentValues.put("mid", message.getMid());
        contentValues.put("read_status", (Long) 0L);
        contentValues.put("accept_status", (Long) 0L);
        if (z) {
            contentValues.put("msg_type", Integer.valueOf(message.getType()));
        }
        String extension = message.getExtension();
        if (extension != null) {
            try {
                JSONObject jSONObject = new JSONObject(extension);
                JSONObject jSONObject2 = jSONObject.getJSONObject("userInfo");
                int iOptInt = jSONObject.optInt("type");
                contentValues.put("from_uid", jSONObject2.optString(DeviceInfoUtil.UID_TAG));
                contentValues.put("from_nick_name", jSONObject2.optString("nickname"));
                contentValues.put("from_head_img_url", jSONObject2.optString("headIconUrl"));
                contentValues.put("from_signature", jSONObject2.optString(a.A));
                contentValues.put("user_info", jSONObject2.toString());
                contentValues.put("rid", jSONObject.optString("rid"));
                contentValues.put("request_type", Integer.valueOf(iOptInt));
                contentValues.put("identify_code", jSONObject.optString("identifyCode"));
                contentValues.put("recommendTitle", jSONObject.optString("recommendTitle"));
                contentValues.put("recommendText", jSONObject.optString("recommendText"));
                if (jSONObject.has("sourceType")) {
                    contentValues.put("source_type", Integer.valueOf(jSONObject.optInt("sourceType")));
                }
                if (message.getType() == 101) {
                    contentValues.put("request_type", (Integer) 1);
                } else if (message.getType() == 12) {
                    contentValues.put("request_type", Integer.valueOf(jSONObject.optInt("type") + 100));
                    contentValues.put("source_type", (Integer) 3);
                } else if (message.getType() == 13) {
                    int iOptInt2 = jSONObject.optInt("sourceType");
                    contentValues.put("request_type", Integer.valueOf(iOptInt2 + 200));
                    contentValues.put("source_type", Integer.valueOf(iOptInt2));
                } else if (message.getType() == 10) {
                    int iOptInt3 = jSONObject.optInt("type");
                    long jOptLong = jSONObject.optLong("applyTime");
                    long jOptLong2 = jSONObject.optLong("applyExpireSec");
                    contentValues.put("request_type", Integer.valueOf(iOptInt3));
                    contentValues.put("applyTime", Long.valueOf(jOptLong));
                    contentValues.put("applyExpireSec", Long.valueOf(jOptLong2));
                } else if (message.getType() == 20) {
                    int iOptInt4 = jSONObject.optInt("sourceType");
                    contentValues.put("request_type", Integer.valueOf(iOptInt4 + 200));
                    contentValues.put("source_type", Integer.valueOf(iOptInt4));
                } else if (message.getType() == 21) {
                    int iOptInt5 = jSONObject.optInt("sourceType");
                    contentValues.put("request_type", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR));
                    contentValues.put("source_type", Integer.valueOf(iOptInt5));
                }
                contentValues.put("request_info", jSONObject.optString("info"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contentValues;
    }

    public static List<ContentValues> b(MessageProto.Message message, boolean z) {
        ArrayList arrayList = new ArrayList();
        String extension = message.getExtension();
        if (extension != null) {
            try {
                JSONArray jSONArray = new JSONObject(extension).getJSONArray("users");
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        ContentValues contentValues = new ContentValues();
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                        contentValues.put("send_time", Long.valueOf(message.getCreateTime()));
                        contentValues.put("mid", message.getMid());
                        contentValues.put("read_status", (Long) 0L);
                        contentValues.put("accept_status", (Long) 0L);
                        if (z) {
                            contentValues.put("msg_type", Integer.valueOf(message.getType()));
                        }
                        contentValues.put("from_uid", jSONObject.optString(DeviceInfoUtil.UID_TAG));
                        contentValues.put("from_nick_name", jSONObject.optString("nickname"));
                        contentValues.put("from_head_img_url", jSONObject.optString("headIconUrl"));
                        contentValues.put("from_signature", jSONObject.optString(a.A));
                        contentValues.put("user_info", jSONObject.toString());
                        contentValues.put("rid", jSONObject.optString("rid"));
                        contentValues.put("recommendText", jSONObject.optString("recommendText"));
                        contentValues.put("commonFrds", jSONObject.optString("commonFrds"));
                        if (jSONObject.has("sourceType")) {
                            contentValues.put("source_type", Integer.valueOf(jSONObject.optInt("sourceType")));
                        }
                        contentValues.put("request_type", (Integer) 225);
                        arrayList.add(contentValues);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppContext.getContext().getContentResolver().delete(vn0.f21483a, "from_uid=?", new String[]{str});
    }

    public static void d() {
        zh.k(AppContext.getContext().getContentResolver()).g(0, null, vn0.f21483a, "source_type=? or source_type=? or source_type=?", new String[]{String.valueOf(4), String.valueOf(34), String.valueOf(14)});
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zh.k(AppContext.getContext().getContentResolver()).g(0, null, vn0.f21483a, "from_uid=? and ( source_type=? or source_type=? or source_type=? )", new String[]{str, String.valueOf(4), String.valueOf(34), String.valueOf(14)});
    }

    public static void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArr = {String.valueOf(101), str};
        ContentValues contentValues = new ContentValues();
        contentValues.put("deleteTime", String.valueOf(ir5.b()));
        zh zhVarK = zh.k(AppContext.getContext().getContentResolver());
        Uri uri = vn0.f21483a;
        zhVarK.j(0, null, uri, contentValues, "request_type = ? and from_uid = ?", strArr);
        zh.k(AppContext.getContext().getContentResolver()).g(0, null, uri, "from_uid = ? and source_type!=? and source_type!=? and source_type!=? and source_type!=? and request_type!=? and request_type!=? and request_type!=?", new String[]{str, Integer.toString(14), Integer.toString(34), Integer.toString(4), Integer.toString(28), Integer.toString(101), Integer.toString(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR), Integer.toString(301)});
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppContext.getContext().getContentResolver().delete(vn0.f21483a, "from_uid=? and request_type == ?", new String[]{str, Integer.toString(301)});
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009f  */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(String str, int i) {
        ?? r5;
        String str2;
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(vn0.f21483a, null, "from_uid = ? AND request_type < ?", new String[]{str, String.valueOf(100)}, "_id DESC");
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext() && arrayList.size() < 4) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("request_info"));
                if (TextUtils.isEmpty(string)) {
                    if (i == 2) {
                        string = AppContext.getContext().getString(R.string.notification_add_contact_request_group);
                    } else if (i == 3) {
                        string = AppContext.getContext().getString(R.string.notification_add_contact_request_contact);
                    } else if (i == 7) {
                        string = AppContext.getContext().getString(R.string.notification_add_contact_request_auto);
                    } else if (i == 14) {
                        string = AppContext.getContext().getString(R.string.notification_greeting_content);
                    } else if (i != 20) {
                        if (i != 28 && i != 34) {
                            if (i != 17) {
                                string = i != 18 ? AppContext.getContext().getString(R.string.notification_add_contact_request_content_new) : AppContext.getContext().getString(R.string.notification_add_contact_request_accurate);
                            }
                        }
                    }
                }
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("mid"));
                long j = cursorQuery.getLong(cursorQuery.getColumnIndex("send_time"));
                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("rid"));
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("request_type"));
                ContentValues contentValues = new ContentValues();
                boolean zIsSenderParseFromRid = i2 == 0 ? ContactRequestsVO.isSenderParseFromRid(string3) : i2 == 2;
                String strP = AccountUtils.p(AppContext.getContext());
                if (zIsSenderParseFromRid) {
                    str2 = strP;
                    strP = str;
                } else {
                    str2 = str;
                }
                contentValues.put("msg_type", (Integer) 1);
                if (TextUtils.isEmpty(string2)) {
                    string2 = xn3.a();
                }
                contentValues.put("packet_id", string2);
                contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(j));
                contentValues.put("dest", strP);
                contentValues.put("message", string);
                contentValues.put("read", (Integer) 1);
                contentValues.put("src", str2);
                if (zIsSenderParseFromRid) {
                    contentValues.put("type", (Integer) 2);
                } else {
                    contentValues.put("type", (Integer) 1);
                }
                contentValues.put("contact_relate", str);
                contentValues.put("msg_status", (Integer) 2);
                contentValues.put("attach_status", (Integer) 0);
                contentValues.put("is_greeting", Boolean.TRUE);
                arrayList.add(0, contentValues);
            }
            r5 = 0;
            cursorQuery.close();
        } else {
            r5 = 0;
        }
        dv.a("insertGreetingMessageToMessage", DBUriManager.a(ho3.class, r5), (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]), r5);
    }

    public static void i(ContentValues contentValues) {
        AppContext.getContext().getContentResolver().insert(vn0.f21483a, contentValues);
    }

    public static void j(ContentValues contentValues) {
        zh.k(AppContext.getContext().getContentResolver()).h(0, null, vn0.f21483a, contentValues);
    }

    public static void k(ContactInfoItem contactInfoItem, ContactRequestArgs contactRequestArgs, ChatProfileInfo chatProfileInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("send_time", Long.valueOf(ir5.b()));
        contentValues.put("from_uid", contactInfoItem.getUid());
        contentValues.put("mid", xn3.a());
        contentValues.put("from_nick_name", contactInfoItem.getNickName());
        contentValues.put("from_head_img_url", contactInfoItem.getIconURL());
        contentValues.put("from_signature", contactInfoItem.getSignature());
        contentValues.put("request_info", contactRequestArgs.g());
        String strCovert2OriData = contactInfoItem.covert2OriData();
        if (chatProfileInfo != null) {
            strCovert2OriData = px3.a(strCovert2OriData, chatProfileInfo);
        }
        contentValues.put("user_info", strCovert2OriData);
        contentValues.put("rid", AccountUtils.p(AppContext.getContext()) + "_" + contactInfoItem.getUid());
        contentValues.put("applyTime", Long.valueOf(ir5.b()));
        contentValues.put("request_type", (Integer) 0);
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(ir5.b()));
        contentValues.put("accept_status", (Long) 0L);
        contentValues.put("source_type", contactRequestArgs.h());
        contentValues.put("identify_code", contactInfoItem.getIdentifyCode());
        j(contentValues);
    }

    public static void l() {
        LogUtil.e("ContactRequestDBOperator", "markAllPhoneContactAsReadOnUI");
        String[] strArr = {String.valueOf(0L), String.valueOf(100), String.valueOf(200)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(System.currentTimeMillis()));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "read_status=? and request_type>=? and request_type<? ", strArr);
    }

    public static void m() {
        LogUtil.e("ContactRequestDBOperator", "markAllRecommendFriendAsReadOnUI");
        String[] strArr = {String.valueOf(0L), String.valueOf(200), String.valueOf(302)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(System.currentTimeMillis()));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "read_status=? and request_type>? and request_type!=? ", strArr);
    }

    public static void n() {
        LogUtil.e("ContactRequestDBOperator", "markAllRequestAsReadOnUI");
        String[] strArr = {String.valueOf(0L), String.valueOf(4), String.valueOf(14), String.valueOf(34), String.valueOf(28), Integer.toString(100)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(System.currentTimeMillis()));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "read_status=? and source_type!=? and source_type!=? and source_type!=? and source_type!=? and request_type<? ", strArr);
    }

    public static void o() {
        LogUtil.e("ContactRequestDBOperator", "markEnhancedRecommendAsReadOnUI");
        String[] strArr = {String.valueOf(0L), String.valueOf(302)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(System.currentTimeMillis()));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "read_status=? and request_type=?", strArr);
    }

    public static void p() {
        LogUtil.e("ContactRequestDBOperator", "markNearbyRequestAsReadOnUI");
        String[] strArr = {String.valueOf(0L), String.valueOf(4), String.valueOf(34), String.valueOf(14)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(System.currentTimeMillis()));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "read_status=? and (source_type=? or source_type=? or source_type=?)", strArr);
    }

    public static void q(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(System.currentTimeMillis()));
        AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "read_status=? and from_uid=?", new String[]{String.valueOf(0L), str});
    }

    public static void r(String str) {
        LogUtil.e("ContactRequestDBOperator", "markRequestAsReadOnUI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(System.currentTimeMillis()));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "read_status=? and from_uid=?", new String[]{String.valueOf(0L), str});
    }

    public static void s() {
        LogUtil.e("ContactRequestDBOperator", "markAllRequestAsReadOnUI");
        String[] strArr = {String.valueOf(0L), String.valueOf(200)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(System.currentTimeMillis()));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "read_status=? and source_type=? ", strArr);
    }

    public static void t(String str, String str2, ChatProfileInfo chatProfileInfo) {
        String strA = px3.a(str2, chatProfileInfo);
        if (strA == null || strA.equals(str2)) {
            return;
        }
        LogUtil.i(f20510a, "updateApplyRecordOnUI " + strA);
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_info", strA);
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "from_uid = ?  ", new String[]{str});
    }
}

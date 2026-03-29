package com.zenmen.palmchat.chat;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.InputItemManager;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import defpackage.fu5;
import defpackage.k86;
import defpackage.n20;
import defpackage.nx3;
import defpackage.r75;
import defpackage.zn6;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12747a;
    public String b = r75.i(AppContext.getContext(), k86.a("chatter_input_format"));

    public c(String str) {
        this.f12747a = str;
    }

    public static int b(InputItemManager.InputItemType inputItemType) {
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_IMAGE) {
            return R.drawable.ic_chat_input_header_panel_image;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_FILE) {
            return R.drawable.ic_chat_input_header_panel_file;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_LOCATION) {
            return R.drawable.ic_chat_input_header_panel_location;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_NAME_CARD) {
            return R.drawable.ic_chat_input_header_panel_vcard;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_BIG_TEXT) {
            return R.drawable.selector_icon_input_bigtext;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_SIGHT) {
            return R.drawable.ic_chat_input_header_panel_sight;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_CAMERA) {
            return R.drawable.ic_chat_input_header_panel_camera;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL) {
            return R.drawable.ic_chat_input_header_panel_video_call;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL) {
            return R.drawable.ic_chat_input_header_panel_audio_call;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_REDPACKET) {
            return R.drawable.ic_chat_input_header_panel_red_packet;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_TRANSFER) {
            return R.drawable.ic_chat_input_header_panel_transfer;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_VOUCHER) {
            return R.drawable.ic_chat_input_header_panel_voucher_red_packet;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_GIFT) {
            return R.drawable.ic_chat_input_header_panel_gift;
        }
        return 0;
    }

    public static void d(ChatItem chatItem) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", "click");
            jSONObject.put("scene", 301);
            jSONObject.put("channelId", chatItem.getChatId() + DomainHelper.m(chatItem).domain);
            jSONObject.put("type", n20.h(chatItem));
            if (fu5.q(chatItem.getBizType())) {
                jSONObject.put("bizType", chatItem.getBizType() + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        zn6.d("gift_icon", null, jSONObject.toString());
    }

    public static boolean e(InputItemManager.InputItemType inputItemType) {
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_NAME_CARD) {
            return nx3.a("key_name_card");
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_SIGHT) {
            return nx3.a("key_small_video");
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_CAMERA) {
            return nx3.a("key_new_camera");
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_REDPACKET) {
            return false;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL) {
            return nx3.a("key_video_call");
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL) {
            return nx3.a("key_new_group_voice_call");
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_VOUCHER) {
            return nx3.a("key_show_voucher_red_packet");
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_GIFT) {
            return nx3.a("key_new_gift_panel");
        }
        return false;
    }

    public void a() {
        String str;
        if (TextUtils.isEmpty(this.f12747a) || (str = this.b) == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(this.b);
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!this.f12747a.equals(jSONObject.getString("chatId"))) {
                    jSONArray2.put(jSONObject);
                }
            }
            this.b = jSONArray2.toString();
            r75.r(AppContext.getContext(), k86.a("chatter_input_format"), this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void c() {
        String str;
        if (TextUtils.isEmpty(this.f12747a) || (str = this.b) == null) {
            return;
        }
        try {
            JSONArray jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(this.b);
            if (f() == 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("chatId", this.f12747a);
                jSONArray.put(jSONObject);
                this.b = jSONArray.toString();
                r75.r(AppContext.getContext(), k86.a("chatter_input_format"), this.b);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int f() {
        if (!TextUtils.isEmpty(this.f12747a) && !TextUtils.isEmpty(this.b)) {
            try {
                JSONArray jSONArray = new JSONArray(this.b);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (this.f12747a.equals(jSONArray.getJSONObject(i).getString("chatId"))) {
                        return 1;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}

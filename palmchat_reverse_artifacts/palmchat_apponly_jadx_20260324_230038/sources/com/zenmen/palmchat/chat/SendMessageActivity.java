package com.zenmen.palmchat.chat;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.az;
import com.litesuits.async.AsyncTask;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.Vo.RichMsgExVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.photoview.PhotoObject;
import com.zenmen.palmchat.activity.photoview.PhotoViewActivity;
import com.zenmen.palmchat.activity.photoview.VideoViewFragment;
import com.zenmen.palmchat.activity.search.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.fileupload.dao.UploadResultVo;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.location.LocationViewActivity;
import com.zenmen.palmchat.media.file.FileDetailActivity;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.route.share.a;
import com.zenmen.palmchat.smallvideo.SmallVideoEntranceController;
import com.zenmen.palmchat.utils.AutoFitGridView;
import com.zenmen.palmchat.utils.ForwardGifView;
import com.zenmen.palmchat.utils.ForwardRoundView;
import com.zenmen.palmchat.utils.ForwardVideoView;
import com.zenmen.palmchat.utils.ShareLinkBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.a65;
import defpackage.az2;
import defpackage.bq6;
import defpackage.br2;
import defpackage.ch;
import defpackage.ds0;
import defpackage.dx5;
import defpackage.eb6;
import defpackage.fi0;
import defpackage.fu2;
import defpackage.g53;
import defpackage.gr2;
import defpackage.gu2;
import defpackage.ho3;
import defpackage.hr2;
import defpackage.hx3;
import defpackage.ie2;
import defpackage.il5;
import defpackage.je2;
import defpackage.jr2;
import defpackage.k86;
import defpackage.l50;
import defpackage.lf5;
import defpackage.m40;
import defpackage.mb4;
import defpackage.me3;
import defpackage.o86;
import defpackage.pu1;
import defpackage.qm5;
import defpackage.qp4;
import defpackage.rl0;
import defpackage.sd1;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.uk5;
import defpackage.v4;
import defpackage.vl1;
import defpackage.w56;
import defpackage.xn3;
import defpackage.y56;
import defpackage.ze2;
import defpackage.zo4;
import defpackage.zy4;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SendMessageActivity extends BaseActionBarActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    public static final String T = "SendMessageActivity";
    public static int U = 104857600;
    public boolean A;
    public com.zenmen.palmchat.activity.search.c K;
    public AsyncTask N;
    public String Q;
    public ListView q;
    public Toolbar r;
    public EditText s;
    public EditText t;
    public TextView u;
    public com.zenmen.palmchat.activity.search.b v;
    public MessageVo w;
    public ArrayList<MessageVo> x;
    public int y = 0;
    public int z = 0;
    public int B = 0;
    public ContactInfoItem C = null;
    public HashMap<String, GroupInfoItem> E = new HashMap<>();
    public ArrayList<ThreadChatItem> F = new ArrayList<>();
    public ArrayList<Object> G = new ArrayList<>();
    public Handler H = new Handler();
    public ArrayList<ContactInfoItem> I = new ArrayList<>();
    public MediaItem J = new MediaItem();
    public int L = 1;
    public byte M = 0;
    public String O = null;
    public String P = null;
    public boolean R = true;
    public c.d S = new k();

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f12688a;

        public b(ChatItem chatItem) {
            this.f12688a = chatItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SendMessageActivity.this.w.mimeType != 28) {
                SendMessageActivity sendMessageActivity = SendMessageActivity.this;
                sendMessageActivity.v2(sendMessageActivity.w, null, this.f12688a);
            } else {
                SendMessageActivity sendMessageActivity2 = SendMessageActivity.this;
                sendMessageActivity2.v2(sendMessageActivity2.w, 0, this.f12688a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f12689a;

        public b0(ChatItem chatItem) {
            this.f12689a = chatItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SendMessageActivity sendMessageActivity = SendMessageActivity.this;
            sendMessageActivity.v2(sendMessageActivity.w, null, this.f12689a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f12690a;
        public final /* synthetic */ Animation b;
        public final /* synthetic */ ImageView c;
        public final /* synthetic */ View d;
        public final /* synthetic */ View e;
        public final /* synthetic */ Animation f;

        public c(boolean[] zArr, Animation animation, ImageView imageView, View view, View view2, Animation animation2) {
            this.f12690a = zArr;
            this.b = animation;
            this.c = imageView;
            this.d = view;
            this.e = view2;
            this.f = animation2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f12690a[0]) {
                this.b.setFillAfter(true);
                this.c.startAnimation(this.b);
                this.d.setVisibility(0);
                this.e.setVisibility(8);
                SendMessageActivity.this.t.setVisibility(8);
                this.f12690a[0] = false;
                return;
            }
            this.f.setFillAfter(true);
            this.c.startAnimation(this.f);
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            SendMessageActivity.this.t.setVisibility(0);
            this.f12690a[0] = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f12691a;

        public c0(ChatItem chatItem) {
            this.f12691a = chatItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SendMessageActivity sendMessageActivity = SendMessageActivity.this;
            sendMessageActivity.v2(sendMessageActivity.w, null, this.f12691a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12692a;
        public final /* synthetic */ ChatItem b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MaterialDialog f12693a;

            public a(MaterialDialog materialDialog) {
                this.f12693a = materialDialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f12693a.dismiss();
                SendMessageActivity.this.finish();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MaterialDialog f12694a;

            public b(MaterialDialog materialDialog) {
                this.f12694a = materialDialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SendMessageActivity.this, MainTabsActivity.class);
                intent.putExtra("new_intent_position", "tab_msg");
                k86.Y(intent);
                SendMessageActivity.this.startActivity(intent);
                this.f12694a.dismiss();
                SendMessageActivity.this.finish();
            }
        }

        public d(int i, ChatItem chatItem) {
            this.f12692a = i;
            this.b = chatItem;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            materialDialog.dismiss();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            ArrayList<? extends Parcelable> arrayList;
            boolean z;
            if (SendMessageActivity.this.y == 2) {
                ds0.a().b(new fi0(1));
            }
            if (SendMessageActivity.this.w != null) {
                arrayList = new ArrayList<>();
                arrayList.add(SendMessageActivity.this.w);
            } else {
                arrayList = SendMessageActivity.this.x != null ? SendMessageActivity.this.x : null;
            }
            if (this.f12692a == 1) {
                Iterator<? extends Parcelable> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (((MessageVo) it.next()).mimeType == 6) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    sy5.h(SendMessageActivity.this, "群文件功能已下线，暂不支持发送群聊文件", 1);
                    return;
                }
            }
            Iterator<? extends Parcelable> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                MessageVo messageVo = (MessageVo) it2.next();
                if (SendMessageActivity.this.M == 5 || SendMessageActivity.this.M == 6 || SendMessageActivity.this.M == 3 || SendMessageActivity.this.M == 4) {
                    int i = messageVo.mimeType;
                    if (i == 6) {
                        if (pu1.g(messageVo.data1) != 1) {
                            sy5.e(AppContext.getContext(), R.string.send_file_delete, 0).g();
                            SendMessageActivity.this.finish();
                            return;
                        }
                    } else if (i == 2 && pu1.g(messageVo.data1) != 1) {
                        sy5.e(AppContext.getContext(), R.string.send_image_file_delete, 0).g();
                        SendMessageActivity.this.finish();
                        return;
                    }
                }
            }
            if (!fu2.c(this.b.getChatId(), arrayList)) {
                sy5.h(SendMessageActivity.this, gu2.a().specialsendmsg_toast, 1);
                return;
            }
            Iterator<? extends Parcelable> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                MessageVo messageVo2 = (MessageVo) it3.next();
                int i2 = messageVo2.mimeType;
                if (i2 == 1) {
                    SendMessageActivity.this.F2(this.b, messageVo2);
                } else if (i2 == 2) {
                    if (SendMessageActivity.this.M == 3 || SendMessageActivity.this.M == 4) {
                        messageVo2.data5 = SendMessageActivity.this.Q;
                    } else {
                        SendMessageActivity.this.A2(this.b, messageVo2);
                    }
                } else if (i2 == 6) {
                    SendMessageActivity.this.z2(this.b, messageVo2);
                } else if (i2 == 7) {
                    SendMessageActivity.this.C2(this.b, messageVo2);
                } else if (i2 == 14) {
                    SendMessageActivity.this.y2(this.b, messageVo2);
                } else if (i2 == 28) {
                    SendMessageActivity.this.B2(this.b, messageVo2);
                } else if (i2 == 4) {
                    SendMessageActivity.this.x2(this.b, messageVo2);
                } else if (i2 == 10002) {
                    SendMessageActivity.this.F2(this.b, messageVo2);
                } else if (i2 == 9) {
                    SendMessageActivity.this.E2(this.b, messageVo2);
                }
            }
            if (SendMessageActivity.this.L == 3) {
                Intent intent = new Intent("com.zenmen.palmchat.openapi.Intent.ACTION_SEND_MESSAGE_STATUS");
                intent.putExtra("_lxapi_errorcode", 0);
                SendMessageActivity.this.sendBroadcast(intent);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("fromwblx", 0);
                    jSONObject.put("appid", SendMessageActivity.this.P);
                    LogUtil.uploadInfoImmediate("wblx_S", null, null, jSONObject.toString());
                } catch (JSONException unused) {
                }
            }
            MessageVo messageVo3 = new MessageVo();
            String string = SendMessageActivity.this.t.getText().toString();
            messageVo3.text = string;
            if (!TextUtils.isEmpty(string) && InputFragment.d2(messageVo3.text)) {
                SendMessageActivity.this.F2(this.b, messageVo3);
            }
            if (SendMessageActivity.this.M == 3 || SendMessageActivity.this.M == 4) {
                materialDialog.cancel();
                Intent intent2 = new Intent(SendMessageActivity.this, (Class<?>) MainTabsActivity.class);
                intent2.putParcelableArrayListExtra("share_images", arrayList);
                intent2.putExtra("share_chat_item", this.b);
                k86.X(intent2);
                SendMessageActivity.this.startActivity(intent2);
                SendMessageActivity.this.finish();
                return;
            }
            if (SendMessageActivity.this.L == 1) {
                MaterialDialog materialDialogE = new sd3(SendMessageActivity.this).o(R.layout.layout_dialog_share_successful, false).h(false).e();
                materialDialogE.j().findViewById(R.id.btn_back).setOnClickListener(new a(materialDialogE));
                materialDialogE.j().findViewById(R.id.btn_stay).setOnClickListener(new b(materialDialogE));
                materialDialogE.show();
            } else if (SendMessageActivity.this.L == 0) {
                sy5.e(SendMessageActivity.this, R.string.string_forwarded, 0).g();
                SendMessageActivity.this.setResult(-1);
                SendMessageActivity.this.finish();
            } else if (SendMessageActivity.this.L == 3) {
                Intent intent3 = new Intent(SendMessageActivity.this, (Class<?>) MainTabsActivity.class);
                intent3.putExtra("new_intent_position", "tab_msg");
                k86.Y(intent3);
                SendMessageActivity.this.startActivity(intent3);
                SendMessageActivity.this.finish();
            } else {
                sy5.e(SendMessageActivity.this, R.string.string_shared, 0).g();
                SendMessageActivity.this.setResult(-1);
                SendMessageActivity.this.finish();
            }
            materialDialog.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("action", "send_message");
            put("status", "forwardText");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e0 extends BaseAdapter {

        /* JADX INFO: compiled from: SearchBox */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public ImageView f12698a;
            public TextView b;

            public a() {
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return SendMessageActivity.this.I.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return SendMessageActivity.this.I.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar = new a();
            if (view == null) {
                view = LayoutInflater.from(SendMessageActivity.this).inflate(R.layout.grid_item_group_member, (ViewGroup) null);
                aVar.f12698a = (ImageView) view.findViewById(R.id.portrait);
                aVar.b = (TextView) view.findViewById(R.id.member_nick_name);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            ContactInfoItem contactInfoItem = (ContactInfoItem) SendMessageActivity.this.I.get(i);
            String iconURL = contactInfoItem.getIconURL();
            if (TextUtils.isEmpty(iconURL)) {
                aVar.f12698a.setImageResource(R.drawable.default_portrait);
            } else {
                gr2.j().h(iconURL, aVar.f12698a, bq6.s());
            }
            aVar.b.setText(contactInfoItem.getNameForShow());
            return view;
        }

        public e0() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {
        public f() {
            put("action", "send_message");
            put("status", "forwardText");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {
        public g() {
            put("action", "send_message");
            put("status", "forwardImage");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends HashMap<String, Object> {
        public h() {
            put("action", "send_message");
            put("status", "forwardExpression");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {
        public i() {
            put("action", "send_message");
            put("status", "forwardFile");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends HashMap<String, Object> {
        public j() {
            put("action", "send_message");
            put("status", "forwardLocation");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements c.d {
        public k() {
        }

        @Override // com.zenmen.palmchat.activity.search.c.d
        public void a(c.f fVar) {
            SendMessageActivity.this.G.clear();
            if (fVar.b != null) {
                String uid = (SendMessageActivity.this.y != 1 || SendMessageActivity.this.C.getUid() == null) ? null : SendMessageActivity.this.C.getUid();
                for (ContactInfoItem contactInfoItem : fVar.b) {
                    if (contactInfoItem.getUid() != null && !contactInfoItem.getUid().equals(uid) && !a65.e(contactInfoItem)) {
                        SendMessageActivity.this.G.add(contactInfoItem);
                    }
                }
            }
            if (fVar.c != null) {
                SendMessageActivity.this.G.addAll(fVar.c.values());
                SendMessageActivity.this.v.b(fVar.d);
            }
            SendMessageActivity.this.v.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends HashMap<String, Object> {
        public l() {
            put("action", "send_message");
            put("status", "publishLink");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends HashMap<String, Object> {
        public n() {
            put("action", "send_message");
            put("status", "publicVideo");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) GroupChatInitActivity.class);
            intent.putExtra("group_choose_contact_forward", true);
            if (SendMessageActivity.this.y == 1) {
                intent.putExtra("filter_member", SendMessageActivity.this.C);
            }
            intent.putExtra("extra_key_is_show_group", SendMessageActivity.this.R);
            ArrayList arrayList = new ArrayList();
            if (SendMessageActivity.this.w != null) {
                arrayList.add(SendMessageActivity.this.w);
            } else if (SendMessageActivity.this.x != null) {
                arrayList = SendMessageActivity.this.x;
            }
            float fI = fu2.i(arrayList);
            if (fI > 0.0f) {
                intent.putExtra("extra_key_forward_intimacy_score", fI);
            }
            SendMessageActivity.this.startActivityForResult(intent, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SendMessageActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ br2 f12717a;

        public u(br2 br2Var) {
            this.f12717a = br2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            br2 br2Var = this.f12717a;
            if (br2Var.f1806a == 0 && br2Var.b.mid.equals(SendMessageActivity.this.J.mid)) {
                SendMessageActivity.this.J = this.f12717a.b;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12718a;

        public v(String str) {
            this.f12718a = str;
            put("action", "share");
            put("detail", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f12719a;

        public w(uk5 uk5Var) {
            this.f12719a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            uk5 uk5Var = this.f12719a;
            if (uk5Var.f21235a != 7) {
                return;
            }
            ArrayList<T> arrayList = uk5Var.c;
            if (SendMessageActivity.this.w != null) {
                if (arrayList == 0 || !arrayList.contains(SendMessageActivity.this.w.mid)) {
                    return;
                }
                SendMessageActivity.this.finish();
                return;
            }
            if (SendMessageActivity.this.x != null) {
                for (MessageVo messageVo : SendMessageActivity.this.x) {
                    if (arrayList != 0 && arrayList.contains(messageVo.mid)) {
                        SendMessageActivity.this.finish();
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements a.e {
        public x() {
        }

        @Override // com.zenmen.palmchat.route.share.a.e
        public void a(ShareLinkBean shareLinkBean) {
            SendMessageActivity.this.hideBaseProgressBar();
            SendMessageActivity.this.w = MessageVo.buildLinkMessage(null, null, shareLinkBean.getTitle(), shareLinkBean.getContent(), shareLinkBean.getUrl(), shareLinkBean.getIcon(), SendMessageActivity.this.O, 0);
            SendMessageActivity.this.w.data4 = SendMessageActivity.this.Q;
            LogUtil.i(SendMessageActivity.T, "callback---title:" + shareLinkBean.getTitle() + ", desc:" + shareLinkBean.getContent() + ", url:" + shareLinkBean.getUrl() + ", icon:" + shareLinkBean.getIcon());
        }

        @Override // com.zenmen.palmchat.route.share.a.e
        public void onStart() {
            SendMessageActivity.this.showBaseProgressBar(R.string.loading, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements AdapterView.OnItemClickListener {
        public y() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ChatItem chatItem = (ChatItem) adapterView.getItemAtPosition(i);
            if (chatItem == null || l50.a()) {
                return;
            }
            SendMessageActivity.this.D2(chatItem);
        }
    }

    public final void A2(ChatItem chatItem, MessageVo messageVo) {
        if (chatItem == null || messageVo == null) {
            return;
        }
        String strA = xn3.a();
        String strE = DomainHelper.e(chatItem);
        try {
            PhotoObject photoObjectBuildImageMessageSend = MessageVo.buildImageMessageSend(messageVo);
            if (photoObjectBuildImageMessageSend != null) {
                getMessagingServiceInterface().r(MessageVo.buildImageMessage(strA, strE, photoObjectBuildImageMessageSend, photoObjectBuildImageMessageSend.isOriImage, 0, this.O));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(T, 3, new g(), e2);
        }
    }

    public final void B2(ChatItem chatItem, MessageVo messageVo) {
        if (chatItem == null || messageVo == null) {
            return;
        }
        xn3.a();
        String strE = DomainHelper.e(chatItem);
        if (this.L == 3) {
            H2(messageVo, chatItem, strE);
            return;
        }
        ArrayList<MessageVo> arrayListBuildForwardLinkMessage = MessageVo.buildForwardLinkMessage(strE, messageVo, messageVo.data1, 0);
        if (arrayListBuildForwardLinkMessage != null) {
            Iterator<MessageVo> it = arrayListBuildForwardLinkMessage.iterator();
            while (it.hasNext()) {
                try {
                    getMessagingServiceInterface().r(it.next());
                    s2(chatItem, messageVo);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    LogUtil.i(T, 3, new l(), e2);
                }
            }
        }
        if (this.y == 3) {
            lf5.h(true);
        }
    }

    public final void C2(ChatItem chatItem, MessageVo messageVo) {
        if (chatItem == null || messageVo == null) {
            return;
        }
        try {
            getMessagingServiceInterface().r(MessageVo.buildForwardLocationMessage(xn3.a(), DomainHelper.e(chatItem), messageVo.data1, messageVo.data2, 0));
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(T, 3, new j(), e2);
        }
    }

    public final void D2(ChatItem chatItem) {
        chatItem.getChatId();
        int chatType = chatItem.getChatType();
        if (this.w != null || this.x != null) {
            try {
                new sd3(this).T(R.string.dialog_forward_title).p(b2(chatItem), false).O(R.string.send).K(R.string.dialog_cancel).N(R.color.Ga).J(R.color.Ge).h(false).f(new d(chatType, chatItem)).e().show();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (this.C != null) {
            Intent intent = new Intent(this, (Class<?>) ChatterActivity.class);
            if (chatItem instanceof ThreadChatItem) {
                chatItem = ((ThreadChatItem) chatItem).convert2ContactOrGroupChatInfo();
            }
            if (chatItem != null) {
                intent.putExtra("chat_item", chatItem);
                intent.putExtra("send_name_card", this.C);
                k86.X(intent);
                startActivity(intent);
                setResult(-1);
                finish();
            }
        }
    }

    public final void E2(ChatItem chatItem, MessageVo messageVo) {
        if (chatItem == null || messageVo == null) {
            return;
        }
        String strA = xn3.a();
        String strE = DomainHelper.e(chatItem);
        messageVo.mid = strA;
        messageVo.contactRelate = strE;
        messageVo.to = strE;
        try {
            getMessagingServiceInterface().r(messageVo);
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(T, 3, new e(), e2);
        }
    }

    public final void F2(ChatItem chatItem, MessageVo messageVo) {
        if (chatItem == null || messageVo == null) {
            return;
        }
        try {
            MessageVo messageVoBuildTextMessage = MessageVo.buildTextMessage(xn3.a(), DomainHelper.e(chatItem), messageVo.text, null, 0);
            messageVoBuildTextMessage.extention = c2(this.Q);
            messageVoBuildTextMessage.data4 = this.Q;
            getMessagingServiceInterface().r(messageVoBuildTextMessage);
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(T, 3, new f(), e2);
        }
    }

    public final void G2(MessageVo messageVo, ChatItem chatItem) {
        if (chatItem == null || this.y == 4) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, PhotoViewActivity.class);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(this.J);
        intent.putExtra("info_item", chatItem);
        intent.putParcelableArrayListExtra("mediaList", arrayList);
        intent.putExtra("first_item_mid", messageVo.mid);
        intent.putExtra("long_click", false);
        intent.putExtra("show_mode", 1);
        intent.putExtra("message_vo", messageVo);
        startActivity(intent);
    }

    public final void H2(MessageVo messageVo, ChatItem chatItem, String str) {
        if (zo4.f22470a) {
            m mVar = new m(messageVo, str, chatItem);
            ArrayList arrayList = new ArrayList();
            arrayList.add(com.zenmen.palmchat.route.share.a.h(getIntent()).getIcon());
            zo4.d(arrayList, false, 0, mVar);
        }
    }

    public final View b2(ChatItem chatItem) {
        View view;
        boolean[] zArr;
        View view2;
        String str;
        ArrayList<RichMsgExItemVo> arrayList;
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_forward_content, (ViewGroup) null);
        SocialPortraitView socialPortraitView = (SocialPortraitView) viewInflate.findViewById(R.id.image);
        socialPortraitView.changeShapeType(3);
        TextView textView = (TextView) viewInflate.findViewById(R.id.name);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.group_list);
        View viewFindViewById = viewInflate.findViewById(R.id.name_area);
        View viewFindViewById2 = viewInflate.findViewById(R.id.grid_area);
        AutoFitGridView autoFitGridView = (AutoFitGridView) viewInflate.findViewById(R.id.group_member);
        e0 e0Var = new e0();
        View viewFindViewById3 = viewInflate.findViewById(R.id.content);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.content_text);
        View viewFindViewById4 = viewInflate.findViewById(R.id.video);
        ForwardVideoView forwardVideoView = (ForwardVideoView) viewInflate.findViewById(R.id.content_video);
        ForwardRoundView forwardRoundView = (ForwardRoundView) viewInflate.findViewById(R.id.content_image);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.content_expression);
        this.t = (EditText) viewInflate.findViewById(R.id.edit_text);
        gr2.j().h(chatItem.getIconURL(), socialPortraitView, bq6.s());
        boolean[] zArr2 = {true};
        ArrayList<MessageVo> arrayList2 = this.x;
        if (arrayList2 != null && arrayList2.size() == 1 && this.w == null) {
            this.w = this.x.get(0);
        }
        MessageVo messageVo = this.w;
        if (messageVo != null) {
            int i2 = messageVo.mimeType;
            if (i2 != 1) {
                view = viewFindViewById2;
                if (i2 == 2) {
                    zArr = zArr2;
                    view2 = viewInflate;
                    forwardRoundView.setVisibility(0);
                    forwardRoundView.changeShapeType(3);
                    forwardRoundView.setDegreeForRoundRectangle(8, 8);
                    e2(this.w, forwardRoundView, true);
                    forwardRoundView.setOnClickListener(new b0(chatItem));
                } else if (i2 == 4) {
                    zArr = zArr2;
                    view2 = viewInflate;
                    viewFindViewById4.setVisibility(0);
                    forwardVideoView.changeShapeType(3);
                    forwardVideoView.setDegreeForRoundRectangle(8, 8);
                    e2(this.w, forwardVideoView, false);
                    forwardVideoView.setOnClickListener(new c0(chatItem));
                } else if (i2 == 9) {
                    zArr = zArr2;
                    view2 = viewInflate;
                    textView2.setVisibility(0);
                    ChatItem chatItemFromNameCardString = MessageVo.parseChatItemFromNameCardString(this.w.extention);
                    String strE = DomainHelper.e(chatItem);
                    this.w.to = strE;
                    if (m40.b(strE) == 1) {
                        this.w.from = strE + "/" + AccountUtils.p(AppContext.getContext());
                    } else {
                        this.w.from = AccountUtils.p(AppContext.getContext());
                    }
                    textView2.setText((TextUtils.isEmpty(this.w.text) ? getResources().getString(R.string.message_type_name_card) : this.w.text) + chatItemFromNameCardString.getChatName());
                } else if (i2 == 14) {
                    zArr = zArr2;
                    view2 = viewInflate;
                    imageView2.setVisibility(0);
                    d2(this.w, imageView2);
                } else if (i2 != 28) {
                    if (i2 == 6) {
                        textView2.setVisibility(0);
                        textView2.setText(getResources().getString(R.string.message_type_file) + this.w.data3);
                    } else if (i2 == 7) {
                        textView2.setVisibility(0);
                        try {
                            textView2.setText(getResources().getString(R.string.message_type_location) + new JSONObject(this.w.data1).getString("address"));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    zArr = zArr2;
                    view2 = viewInflate;
                } else {
                    RichMsgExVo richMsgExVoH = com.zenmen.palmchat.chat.g.h(messageVo);
                    RichMsgExItemVo richMsgExItemVo = (richMsgExVoH == null || (arrayList = richMsgExVoH.items) == null || arrayList.size() <= 0 || !(richMsgExVoH.items.get(0).showType == 6 || richMsgExVoH.items.get(0).showType == 15 || richMsgExVoH.items.get(0).showType == 11 || richMsgExVoH.items.get(0).showType == 14)) ? null : richMsgExVoH.items.get(0);
                    if (richMsgExItemVo != null) {
                        int i3 = richMsgExItemVo.showType;
                        if (i3 == 6 || i3 == 15) {
                            zArr = zArr2;
                            view2 = viewInflate;
                            forwardRoundView.setVisibility(0);
                            forwardRoundView.changeShapeType(3);
                            forwardRoundView.setDegreeForRoundRectangle(8, 8);
                            f2(richMsgExItemVo, forwardRoundView);
                            forwardRoundView.setOnClickListener(new d0());
                        } else {
                            View viewFindViewById5 = viewInflate.findViewById(R.id.small_video_layout);
                            viewFindViewById5.setVisibility(0);
                            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) viewFindViewById5.findViewById(R.id.smallvideo_cover);
                            TextView textView3 = (TextView) viewFindViewById5.findViewById(R.id.wine_title);
                            ImageView imageView3 = (ImageView) viewFindViewById5.findViewById(R.id.wine_head);
                            TextView textView4 = (TextView) viewFindViewById5.findViewById(R.id.wine_name);
                            ImageView imageView4 = (ImageView) viewFindViewById5.findViewById(R.id.source_icon);
                            view2 = viewInflate;
                            zArr = zArr2;
                            gr2.j().h(richMsgExItemVo.cover, effectiveShapeView, hr2.j());
                            textView3.setText(richMsgExItemVo.title);
                            textView4.setText(richMsgExItemVo.appName);
                            gr2.j().h(richMsgExItemVo.appIcon, imageView3, hr2.i());
                            gr2.j().h(lf5.c(), imageView4, hr2.i());
                            viewFindViewById5.setOnClickListener(new a());
                        }
                    } else {
                        zArr = zArr2;
                        view2 = viewInflate;
                        textView2.setVisibility(0);
                        int iIndexOf = this.w.text.indexOf("\n");
                        if (iIndexOf == -1) {
                            str = getResources().getString(R.string.message_prefix_link) + this.w.text;
                        } else {
                            str = getResources().getString(R.string.message_prefix_link) + this.w.text.substring(0, iIndexOf);
                        }
                        textView2.setText(com.zenmen.palmchat.chat.g.i(null, this.w.data1, str, null));
                    }
                }
            } else {
                view = viewFindViewById2;
                zArr = zArr2;
                view2 = viewInflate;
                textView2.setVisibility(0);
                textView2.setText(vl1.c(this.w.text, this, vl1.d));
            }
            textView2.setOnClickListener(new b(chatItem));
        } else {
            view = viewFindViewById2;
            zArr = zArr2;
            view2 = viewInflate;
            ArrayList<MessageVo> arrayList3 = this.x;
            if (arrayList3 != null && arrayList3.size() > 0) {
                textView2.setVisibility(0);
                textView2.setText(getResources().getString(R.string.message_type_more, Integer.valueOf(this.x.size())));
            }
        }
        if (chatItem.getChatType() == 1) {
            p2(chatItem);
            autoFitGridView.setHeight((this.I.size() + 3) / 4);
            autoFitGridView.setAdapter((ListAdapter) e0Var);
            imageView.setVisibility(0);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.forward_group_in);
            LinearInterpolator linearInterpolator = new LinearInterpolator();
            animationLoadAnimation.setInterpolator(linearInterpolator);
            Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.forward_group_out);
            animationLoadAnimation2.setInterpolator(linearInterpolator);
            viewFindViewById.setOnClickListener(new c(zArr, animationLoadAnimation, imageView, view, viewFindViewById3, animationLoadAnimation2));
            int iB = ze2.b(chatItem);
            if (iB > 0) {
                textView.setText(chatItem.getChatName() + getString(R.string.string_number, iB + getString(R.string.tab_ren)));
            }
        } else {
            textView.setText(chatItem.getChatName());
        }
        return view2;
    }

    public final String c2(String str) {
        String strOptString;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strOptString2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            strOptString = jSONObject.optString("sourceName");
            try {
                strOptString2 = jSONObject.optString("sourceIcon");
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (JSONException e3) {
            e = e3;
            strOptString = null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("name", strOptString);
            jSONObject2.put("icon", strOptString2);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put(az.at, jSONObject2);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("appMsg", jSONObject3);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        return jSONObject4.toString();
    }

    public final void d2(MessageVo messageVo, ImageView imageView) {
        String absolutePath;
        ForwardGifView forwardGifView = (ForwardGifView) imageView;
        String[] strArr = {null};
        String str = messageVo.data4;
        if (str != null) {
            forwardGifView.setDisplaySize(ChatterAdapter.R(str), ChatterAdapter.M(messageVo.data4));
        }
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(messageVo.data1) && new File(messageVo.data1).exists();
        if (z3) {
            absolutePath = messageVo.data1;
        } else {
            String strF = com.zenmen.palmchat.expression.a.f(messageVo);
            if (TextUtils.isEmpty(strF)) {
                forwardGifView.setRatio(1.0f);
                strArr[0] = null;
                absolutePath = null;
            } else {
                File fileB = sd1.b(strF);
                if (fileB == null || !fileB.exists()) {
                    gr2.j().i(messageVo.data2, forwardGifView, bq6.d(true), new q(strF, forwardGifView, strArr));
                    absolutePath = null;
                    z2 = false;
                } else {
                    absolutePath = fileB.getAbsolutePath();
                }
                z3 = z2;
            }
        }
        if (z3) {
            try {
                forwardGifView.setImageDrawable(new pl.droidsonroids.gif.a(absolutePath));
                strArr[0] = absolutePath;
            } catch (IOException unused) {
                strArr[0] = null;
                gr2.j().i(k86.p(absolutePath), imageView, bq6.d(false), new r());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e2(MessageVo messageVo, ImageView imageView, boolean z2) {
        String strN0;
        String str;
        if (z2) {
            ((ForwardRoundView) imageView).setRatio(ChatterAdapter.O(messageVo.data4));
        }
        boolean z3 = false;
        boolean z4 = !TextUtils.isEmpty(messageVo.data1) && new File(messageVo.data1).exists();
        String str2 = null;
        if (z4) {
            strN0 = messageVo.data1;
            this.J.localPath = strN0;
        } else {
            if (!TextUtils.isEmpty(messageVo.data3) && sd1.b(messageVo.data3) != null) {
                z3 = true;
            }
            if (!z3) {
                strN0 = messageVo.data2;
                if (hx3.g() > 2) {
                    str = messageVo.data3;
                }
                if (messageVo.mimeType != 4) {
                    strN0 = VideoViewFragment.n0(messageVo);
                } else {
                    str2 = str;
                }
                MediaItem mediaItem = this.J;
                mediaItem.fileFullPath = strN0;
                mediaItem.mid = messageVo.mid;
                mediaItem.extension = messageVo.data4;
                gr2.j().i(pu1.a(strN0), imageView, bq6.d(!z4), new p(str2, imageView));
            }
            strN0 = messageVo.data3;
        }
        str = null;
        if (messageVo.mimeType != 4) {
        }
        MediaItem mediaItem2 = this.J;
        mediaItem2.fileFullPath = strN0;
        mediaItem2.mid = messageVo.mid;
        mediaItem2.extension = messageVo.data4;
        gr2.j().i(pu1.a(strN0), imageView, bq6.d(!z4), new p(str2, imageView));
    }

    public final void f2(RichMsgExItemVo richMsgExItemVo, ImageView imageView) {
        ((ForwardRoundView) imageView).setRatio(1.25f);
        gr2.j().i(pu1.a(me3.a(richMsgExItemVo.cover, richMsgExItemVo.acode)), imageView, bq6.d(true), new o());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        if (this.y == 3) {
            lf5.h(false);
        }
        super.finish();
    }

    public void g2(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri == null) {
            this.z = 3;
            sy5.e(this, R.string.share_failed_resource, 1).g();
            finish();
            return;
        }
        String strD = w56.d(this, uri);
        if (pu1.g(strD) != 1) {
            this.z = 3;
            sy5.e(this, R.string.share_failed_resource, 1).g();
            finish();
            return;
        }
        U = rl0.h().e().f();
        long length = new File(strD).length();
        int i2 = U;
        if (length <= i2) {
            this.w = MessageVo.buildFileMessage(null, null, strD, 0);
            return;
        }
        this.z = 2;
        sy5.f(this, getString(R.string.file_share_reach_length_limit, Integer.valueOf(i2 / 1048576)), 1).g();
        finish();
    }

    public void h2(Intent intent) {
        this.w = (MessageVo) intent.getParcelableExtra("message_vo");
        this.x = intent.getParcelableArrayListExtra("message_vo_list");
        this.y = intent.getIntExtra("extra_from", 0);
        this.C = (ContactInfoItem) intent.getParcelableExtra("extra_share_contact");
    }

    public void i2(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri == null) {
            this.z = 3;
            sy5.e(this, R.string.share_failed_resource, 1).g();
            finish();
            return;
        }
        String strD = w56.d(this, uri);
        if (pu1.g(strD) != 1) {
            this.z = 3;
            sy5.e(this, R.string.share_failed_resource, 1).g();
            finish();
            return;
        }
        U = rl0.h().e().f();
        long length = new File(strD).length();
        int i2 = U;
        if (length > i2) {
            this.z = 2;
            sy5.f(this, getString(R.string.file_share_reach_length_limit, Integer.valueOf(i2 / 1048576)), 1).g();
        } else {
            PhotoObject photoObject = new PhotoObject();
            photoObject.path = strD;
            this.w = MessageVo.buildImageMessage(null, null, photoObject, false, 0, this.O);
        }
    }

    public void j2(Intent intent) {
        ShareLinkBean shareLinkBeanH = com.zenmen.palmchat.route.share.a.h(intent);
        String title = shareLinkBeanH.getTitle();
        String icon = shareLinkBeanH.getIcon();
        String content = shareLinkBeanH.getContent();
        String url = shareLinkBeanH.getUrl();
        if (this.L != 2 && (TextUtils.isEmpty(icon) || TextUtils.isEmpty(title))) {
            this.N = com.zenmen.palmchat.route.share.a.d(shareLinkBeanH, new x());
            return;
        }
        MessageVo messageVoBuildLinkMessage = MessageVo.buildLinkMessage(null, null, title, content, url, icon, this.O, 0);
        this.w = messageVoBuildLinkMessage;
        messageVoBuildLinkMessage.data4 = this.Q;
        LogUtil.i(T, "nocallback---title:" + title + ", desc:" + content + ", url:" + url + ", icon:" + icon);
    }

    public void k2(Intent intent) {
        sy5.e(this, R.string.share_not_support_multiple, 1).g();
        finish();
    }

    public void l2(Intent intent) {
        ArrayList<Uri> parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        if (parcelableArrayListExtra != null) {
            this.x = new ArrayList<>();
            for (Uri uri : parcelableArrayListExtra) {
                if (uri != null) {
                    String strD = w56.d(this, uri);
                    if (pu1.g(strD) == 1) {
                        U = rl0.h().e().f();
                        long length = new File(strD).length();
                        int i2 = U;
                        if (length > i2) {
                            this.z = 2;
                            sy5.f(this, getString(R.string.file_share_reach_length_limit, Integer.valueOf(i2 / 1048576)), 1).g();
                        } else {
                            PhotoObject photoObject = new PhotoObject();
                            photoObject.path = strD;
                            MessageVo messageVoBuildImageMessage = MessageVo.buildImageMessage(null, null, photoObject, false, 0, null);
                            messageVoBuildImageMessage.extention = c2(this.Q);
                            messageVoBuildImageMessage.data5 = this.Q;
                            this.x.add(messageVoBuildImageMessage);
                        }
                    } else {
                        this.z = 3;
                        sy5.e(this, R.string.share_failed_resource, 1).g();
                        finish();
                    }
                } else {
                    this.z = 3;
                    sy5.e(this, R.string.share_failed_resource, 1).g();
                    finish();
                }
            }
        }
    }

    public void m2(Intent intent) {
        String strI = com.zenmen.palmchat.route.share.a.i(intent);
        if (TextUtils.isEmpty(strI)) {
            this.L = -1;
            sy5.e(this, R.string.share_failed_resource, 1).g();
            finish();
        }
        if (strI == null) {
            strI = "";
        }
        MessageVo messageVoBuildTextMessage = MessageVo.buildTextMessage(null, null, strI, null, 0);
        this.w = messageVoBuildTextMessage;
        messageVoBuildTextMessage.extention = c2(this.Q);
        this.w.data4 = this.Q;
    }

    public final void n2() {
        Intent intent = getIntent();
        this.y = intent.getIntExtra("extra_from", 0);
        this.R = intent.getBooleanExtra("extra_is_show_group", true);
        int intExtra = intent.getIntExtra("extra_share_mode", 1);
        this.L = intExtra;
        if (intExtra == 3) {
            setBack2MainTab(true, "tab_msg");
        }
        this.M = com.zenmen.palmchat.route.share.a.j(intent);
        this.O = intent.getStringExtra("extra_share_source");
        this.P = intent.getStringExtra("sdk_share_appid");
        this.Q = intent.getStringExtra("extra_open_info");
        switch (this.M) {
            case 0:
                h2(intent);
                this.L = 0;
                break;
            case 1:
                m2(intent);
                break;
            case 2:
                j2(intent);
                break;
            case 3:
                i2(intent);
                break;
            case 4:
                l2(intent);
                break;
            case 5:
                g2(intent);
                break;
            case 6:
                k2(intent);
                break;
            default:
                h2(intent);
                this.L = 0;
                break;
        }
        LogUtil.i(T, 3, new v("{action:" + intent.getAction() + ", type:" + intent.getType() + ", shareType:" + ((int) this.M) + ", fileUri:" + ((Uri) intent.getParcelableExtra("android.intent.extra.STREAM")) + "}"), (Throwable) null);
    }

    public final void o2() {
        View viewInflate = getLayoutInflater().inflate(R.layout.list_headerview_forward_threads_header, (ViewGroup) null, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.createItem);
        this.u = textView;
        int i2 = this.y;
        if (i2 == 0) {
            textView.setText(R.string.create_threads);
        } else if (i2 == 1) {
            textView.setText(R.string.string_more_contact);
        }
        this.u.setOnClickListener(new s());
        this.q.addHeaderView(viewInflate);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ChatItem chatItem;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 0 || i3 != -1 || intent == null || (chatItem = (ChatItem) intent.getParcelableExtra("group_choose_contact_forward_chatitem")) == null) {
            return;
        }
        D2(chatItem);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.L == 3) {
            Intent intent = new Intent("com.zenmen.palmchat.openapi.Intent.ACTION_SEND_MESSAGE_STATUS");
            intent.putExtra("_lxapi_errorcode", 2);
            sendBroadcast(intent);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fromwblx", 2);
                jSONObject.put("appid", this.P);
                LogUtil.uploadInfoImmediate("wblx_F", null, null, jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_forward_message);
        q2();
        n2();
        r2();
        super.getLoaderManager().initLoader(0, null, this);
        this.K = new com.zenmen.palmchat.activity.search.c(this.S, this.R, false, false);
        ch.s().r().j(this);
        ds0.a().c(this);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        if (i2 != 0) {
            return null;
        }
        return new CursorLoader(this, dx5.f17178a, null, "thread_active=? and thread_contact_ready=? and thread_blacklist=? and thread_biz_type=?", new String[]{String.valueOf(1), String.valueOf(1), String.valueOf(0), String.valueOf(0)}, "thread_priority DESC , latest_message_time_stamp DESC");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.A = false;
        AsyncTask asyncTask = this.N;
        if (asyncTask != null && !asyncTask.k()) {
            this.N.f(true);
        }
        this.K.q();
        ch.s().r().l(this);
        ds0.a().d(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.A = true;
    }

    @qm5
    public void onReceiveEvent(br2 br2Var) {
        this.H.post(new u(br2Var));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.A = false;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        super.bindMessagingService();
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        this.H.post(new w(uk5Var));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        super.unBindMessagingService();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0054 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p2(ChatItem chatItem) {
        if (chatItem == null || TextUtils.isEmpty(chatItem.getChatId())) {
            return;
        }
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(je2.f18392a, null, "group_id=? and group_member_state=?", new String[]{chatItem.getChatId(), Integer.toString(0)}, null);
        this.I.clear();
        ArrayList arrayList = new ArrayList();
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    try {
                        arrayList.add(ie2.a(cursorQuery));
                    } catch (Exception e2) {
                        LogUtil.e(T, e2);
                    }
                } finally {
                    cursorQuery.close();
                }
            }
            if (cursorQuery != null) {
            }
        } else if (cursorQuery != null) {
        }
        this.I.addAll(arrayList);
    }

    public final void q2() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.photo_preview_choose);
        this.r = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
        this.r.setNavigationOnClickListener(new t());
    }

    public final void r2() {
        this.q = (ListView) findViewById(R.id.list);
        this.s = (EditText) findViewById(R.id.search_edit_text);
        o2();
        if (this.R) {
            this.E = com.zenmen.palmchat.activity.search.c.k();
        }
        com.zenmen.palmchat.activity.search.b bVar = new com.zenmen.palmchat.activity.search.b(this, this.G, this.E, this.s);
        this.v = bVar;
        this.q.setAdapter((ListAdapter) bVar);
        this.q.setOnItemClickListener(new y());
        this.q.setOnScrollListener(new z());
        this.s.addTextChangedListener(new a0());
    }

    public final void s2(ChatItem chatItem, MessageVo messageVo) {
        if (TextUtils.isEmpty(messageVo.data1)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(messageVo.data1).getJSONObject("appMsg");
            JSONArray jSONArray = jSONObject.getJSONArray("items");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2.getInt("showType") == 6) {
                    String string = jSONObject.getJSONObject(az.at).getString("id");
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("appid", string);
                    jSONObject3.put("from", 1);
                    jSONObject3.put(RemoteMessageConst.TO, chatItem.getChatId());
                    LogUtil.uploadInfoImmediate("621", null, null, jSONObject3.toString());
                    if (jSONObject2.getString("url").startsWith("zenxin://mp?")) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("toUid", chatItem.getChatId());
                        jSONObject4.put("gameid", string);
                        jSONObject4.put("type", chatItem.getChatType() == 1 ? 2 : 1);
                        LogUtil.uploadInfoImmediate("yx011", null, null, jSONObject4.toString());
                        return;
                    }
                    return;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void t2() {
        String strQ = il5.q(this.s.getText().toString().toLowerCase());
        if (!TextUtils.isEmpty(strQ)) {
            this.u.setVisibility(8);
            this.K.p(1, strQ);
        } else {
            this.G.clear();
            this.G.addAll(this.F);
            this.u.setVisibility(0);
            this.v.notifyDataSetChanged();
        }
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: u2, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (loader.getId() != 0 || cursor == null) {
            return;
        }
        this.F.clear();
        String strE = v4.e(AppContext.getContext());
        while (cursor.moveToNext()) {
            ThreadChatItem cursor2 = ThreadChatItem.parseCursor(cursor);
            if (strE == null || !strE.equals(cursor2.getChatId())) {
                if (this.y != 1 || !cursor2.relativeContact.equals(this.C.getUid())) {
                    if (!a65.f(cursor2.relativeContact) && (this.R || cursor2.getChatType() != 1)) {
                        this.F.add(cursor2);
                    }
                }
            }
        }
        t2();
    }

    public void v2(MessageVo messageVo, Object obj, ChatItem chatItem) {
        ArrayList<RichMsgExItemVo> arrayList;
        RichMsgExItemVo richMsgExItemVo;
        String str;
        Pair<Integer, ContentValues> pairG;
        int i2 = messageVo.mimeType;
        if (i2 == 1) {
            Intent intent = new Intent(this, (Class<?>) ChatterBigTextActivity.class);
            intent.putExtra("big_text", messageVo.text);
            startActivity(intent);
            return;
        }
        if (i2 == 2) {
            this.J.mimeType = 2;
            G2(messageVo, chatItem);
            return;
        }
        if (i2 == 6) {
            if (!messageVo.isSend) {
                Intent intent2 = new Intent(this, (Class<?>) FileDetailActivity.class);
                intent2.putExtra("message_key", messageVo);
                startActivity(intent2);
                return;
            } else {
                if (messageVo.status != 2) {
                    if (messageVo.sendingProgress < (TextUtils.isEmpty(messageVo.data4) ? 0 : Integer.parseInt(messageVo.data4))) {
                        return;
                    }
                    Intent intent3 = new Intent(this, (Class<?>) FileDetailActivity.class);
                    intent3.putExtra("message_key", messageVo);
                    startActivity(intent3);
                    return;
                }
                if (!TextUtils.isEmpty(messageVo.data1)) {
                    File file = new File(messageVo.data1);
                    if (file.exists()) {
                        messageVo.sendingProgress = (int) file.length();
                    }
                }
                Intent intent4 = new Intent(this, (Class<?>) FileDetailActivity.class);
                intent4.putExtra("message_key", messageVo);
                startActivity(intent4);
                return;
            }
        }
        if (i2 == 7) {
            Intent intent5 = new Intent(this, (Class<?>) LocationViewActivity.class);
            intent5.putExtra("showPopupMenu", false);
            intent5.putExtra("location", g53.b(messageVo));
            startActivity(intent5);
            return;
        }
        if (i2 != 4) {
            if (i2 == 28) {
                Integer num = (Integer) obj;
                RichMsgExVo richMsgExVoH = com.zenmen.palmchat.chat.g.h(messageVo);
                if (richMsgExVoH == null || num == null || (arrayList = richMsgExVoH.items) == null || arrayList.size() <= num.intValue() || (richMsgExItemVo = richMsgExVoH.items.get(num.intValue())) == null || SmallVideoEntranceController.n(this, null, messageVo, richMsgExItemVo) || (str = richMsgExItemVo.url) == null || (pairG = mb4.g(str)) == null) {
                    return;
                }
                w2((ContentValues) pairG.second, null, str, richMsgExItemVo);
                return;
            }
            return;
        }
        if (l50.a()) {
            return;
        }
        if (!messageVo.isSend || messageVo.status != 3) {
            if ((!eb6.e().d(messageVo.data1) || messageVo.attachStatus == 4) && messageVo.attachStatus != 5) {
                eb6.e().b(this, messageVo.contactRelate, messageVo.mid, messageVo.data3, messageVo.data4, messageVo.data5);
                return;
            } else {
                this.J.mimeType = 4;
                G2(messageVo, chatItem);
                return;
            }
        }
        try {
            String chatId = chatItem.getChatId();
            if (chatItem.getChatType() == 1) {
                chatId = chatItem.getChatId() + "@muc.youni";
            }
            getMessagingServiceInterface().r(MessageVo.buildVideoMessage(messageVo.mid, chatId, messageVo.data1, messageVo.data2, 1, messageVo.time, Long.valueOf(messageVo.data6).longValue()).setThreadBizType(this, this.B));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void w2(ContentValues contentValues, y56 y56Var, String str, RichMsgExItemVo richMsgExItemVo) {
        if (y56Var != null && !"1".equals(y56Var.a())) {
            String strB = y56Var.b();
            if ("1".equals(y56Var.k())) {
                try {
                    strB = k86.Z(strB);
                } catch (UnsupportedEncodingException unused) {
                }
            }
            str = strB;
        }
        zy4.l(this, str, richMsgExItemVo, false, false);
    }

    public final void x2(ChatItem chatItem, MessageVo messageVo) {
        long jLongValue;
        if (chatItem == null || messageVo == null || TextUtils.isEmpty(messageVo.data1)) {
            return;
        }
        Cursor cursorQuery = getContentResolver().query(DBUriManager.b(ho3.class, chatItem), new String[]{"msg_type"}, "packet_id=?", new String[]{messageVo.mid}, null);
        if (cursorQuery.moveToFirst() && cursorQuery.getInt(0) == 10001) {
            cursorQuery.close();
            return;
        }
        cursorQuery.close();
        String strA = xn3.a();
        String strE = DomainHelper.e(chatItem);
        try {
            jLongValue = Long.valueOf(messageVo.data6).longValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            jLongValue = 0;
        }
        long j2 = jLongValue;
        MessageVo messageVoBuildVideoMessage = MessageVo.buildVideoMessage(strA, strE, messageVo.data1, messageVo.data2, j2, 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video", messageVoBuildVideoMessage.data5);
            jSONObject.put("envir", chatItem.getChatType() == 1 ? "2" : messageVoBuildVideoMessage.bizType == 0 ? "1" : "3");
            jSONObject.put("qua", "3");
            messageVoBuildVideoMessage.logExtension = jSONObject.toString();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        try {
            getMessagingServiceInterface().r(MessageVo.buildVideoMessage(strA, strE, messageVo.data1, MessageVo.getVideoThumbOnForwardMsg(messageVo), j2, 0));
        } catch (Exception e4) {
            e4.printStackTrace();
            LogUtil.i(T, 3, new n(), e4);
        }
    }

    public final void y2(ChatItem chatItem, MessageVo messageVo) {
        if (chatItem == null || messageVo == null) {
            return;
        }
        String strA = xn3.a();
        String strE = DomainHelper.e(chatItem);
        try {
            ExpressionObject expressionObjectBuildExpressionMessageSend = MessageVo.buildExpressionMessageSend(messageVo);
            if (expressionObjectBuildExpressionMessageSend != null) {
                getMessagingServiceInterface().r(MessageVo.buildExpressionMessage(strA, strE, expressionObjectBuildExpressionMessageSend, 0));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(T, 3, new h(), e2);
        }
    }

    public final void z2(ChatItem chatItem, MessageVo messageVo) {
        if (chatItem == null || messageVo == null) {
            return;
        }
        String strA = xn3.a();
        String strE = DomainHelper.e(chatItem);
        try {
            if (o86.j(messageVo)) {
                getMessagingServiceInterface().r(MessageVo.buildFileMessage(strA, strE, messageVo.data1, 0));
            } else {
                sy5.e(AppContext.getContext(), R.string.send_file_delete, 0).g();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(T, 3, new i(), e2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a0 implements TextWatcher {
        public a0() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SendMessageActivity.this.t2();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d0 implements View.OnClickListener {
        public d0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements qp4.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12706a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ChatItem c;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "send_message");
                put("status", "publishLink");
            }
        }

        public m(MessageVo messageVo, String str, ChatItem chatItem) {
            this.f12706a = messageVo;
            this.b = str;
            this.c = chatItem;
        }

        @Override // qp4.f
        public void b(ArrayList<UploadResultVo> arrayList) {
            ArrayList<RichMsgExItemVo> arrayList2;
            RichMsgExItemVo richMsgExItemVo;
            LogUtil.i(SendMessageActivity.T, "updateLinkIcon success");
            for (int i = 0; i < arrayList.size(); i++) {
                String str = arrayList.get(i).thumbUrl;
                RichMsgExVo richMsgExVoG = com.zenmen.palmchat.chat.g.g(this.f12706a.data1);
                if (richMsgExVoG != null && (arrayList2 = richMsgExVoG.items) != null && arrayList2.size() > 0 && (richMsgExItemVo = richMsgExVoG.items.get(0)) != null) {
                    richMsgExItemVo.cover = str;
                }
                RichMsgVo richMsgVo = new RichMsgVo();
                richMsgVo.appMsg = richMsgExVoG;
                String strC = az2.c(richMsgVo);
                LogUtil.i(SendMessageActivity.T, "updateLinkIcon extention = " + strC);
                ArrayList<MessageVo> arrayListBuildForwardLinkMessage = MessageVo.buildForwardLinkMessage(this.b, this.f12706a, strC, 0);
                if (arrayListBuildForwardLinkMessage != null) {
                    Iterator<MessageVo> it = arrayListBuildForwardLinkMessage.iterator();
                    while (it.hasNext()) {
                        try {
                            SendMessageActivity.this.getMessagingServiceInterface().r(it.next());
                            SendMessageActivity.this.s2(this.c, this.f12706a);
                        } catch (Exception e) {
                            e.printStackTrace();
                            LogUtil.i(SendMessageActivity.T, 3, new a(), e);
                        }
                    }
                }
            }
        }

        @Override // qp4.f
        public void a(Exception exc) {
        }

        @Override // qp4.f
        public void c(UploadResultVo uploadResultVo) {
        }

        @Override // qp4.f
        public void onProgress(int i, int i2) {
        }
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12710a;
        public final /* synthetic */ ImageView b;

        public p(String str, ImageView imageView) {
            this.f12710a = str;
            this.b = imageView;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                LogUtil.i(SendMessageActivity.T, "handleImageMessage first onLoadingComplete" + bitmap.getWidth() + "*" + bitmap.getHeight());
                if (TextUtils.isEmpty(this.f12710a)) {
                    return;
                }
                gr2.j().i(pu1.a(this.f12710a), this.b, bq6.j(), new a());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements jr2 {
            public a() {
            }

            @Override // defpackage.jr2
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                if (bitmap != null) {
                    LogUtil.i(SendMessageActivity.T, "handleImageMessage second onLoadingComplete " + bitmap.getWidth() + "*" + bitmap.getHeight());
                }
            }

            @Override // defpackage.jr2
            public void onLoadingCancelled(String str, View view) {
            }

            @Override // defpackage.jr2
            public void onLoadingStarted(String str, View view) {
            }

            @Override // defpackage.jr2
            public void onLoadingFailed(String str, View view, FailReason failReason) {
            }
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12712a;
        public final /* synthetic */ ForwardGifView b;
        public final /* synthetic */ String[] c;

        public q(String str, ForwardGifView forwardGifView, String[] strArr) {
            this.f12712a = str;
            this.b = forwardGifView;
            this.c = strArr;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            gr2.j().i(this.f12712a, this.b, bq6.j(), new a());
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements jr2 {
            public a() {
            }

            @Override // defpackage.jr2
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                File fileB = sd1.b(q.this.f12712a);
                if (fileB == null || !fileB.exists()) {
                    return;
                }
                String absolutePath = fileB.getAbsolutePath();
                try {
                    q.this.b.setImageDrawable(new pl.droidsonroids.gif.a(absolutePath));
                    q.this.c[0] = absolutePath;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override // defpackage.jr2
            public void onLoadingCancelled(String str, View view) {
            }

            @Override // defpackage.jr2
            public void onLoadingStarted(String str, View view) {
            }

            @Override // defpackage.jr2
            public void onLoadingFailed(String str, View view, FailReason failReason) {
            }
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements jr2 {
        public o() {
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements jr2 {
        public r() {
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements AbsListView.OnScrollListener {
        public z() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            SendMessageActivity.this.s.clearFocus();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }
}

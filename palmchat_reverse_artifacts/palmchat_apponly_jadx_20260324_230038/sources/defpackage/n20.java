package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.chat.gift.widegt.GroupMemberGiftTopView;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.giftkit.GiftPanel;
import com.zenmen.palmchat.giftkit.bean.VoiceRoomSelectMemberItem;
import com.zenmen.palmchat.giftkit.widgit.ChatSelectMemberView;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class n20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GiftPanel f19418a;
    public fa3 b;
    public ChatSelectMemberView c;
    public GroupMemberGiftTopView d;
    public boolean e = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f19419a;
        public final /* synthetic */ ChatItem b;

        /* JADX INFO: renamed from: n20$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1250a implements c0 {
            public C1250a() {
            }

            @Override // defpackage.c0
            public void a(int i, Intent intent) {
                LogUtil.i("AResult", "resultCode" + i);
                if (i != -1 || intent == null) {
                    return;
                }
                intent.getBooleanExtra("extra_all_of", false);
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("add_group_member_result");
                if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() == 0) {
                    return;
                }
                List<VoiceRoomSelectMemberItem> listG = n20.this.g(parcelableArrayListExtra);
                n20.this.c.clearVoiceRoomMember();
                n20.this.c.addVoiceRoomMember(listG);
            }
        }

        public a(Activity activity, ChatItem chatItem) {
            this.f19419a = activity;
            this.b = chatItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(this.f19419a, (Class<?>) GroupChatInitActivity.class);
            intent.putExtra("group_info_item", (GroupInfoItem) this.b);
            intent.putExtra("from_type", 8);
            intent.putExtra("is_select_for_gift", true);
            n20 n20Var = n20.this;
            ArrayList<? extends Parcelable> arrayListF = n20Var.f(n20Var.c.getSelectedData());
            if (arrayListF != null) {
                intent.putParcelableArrayListExtra("init_choose_contact_list", arrayListF);
            }
            intent.putExtra("group_choose_contact", true);
            a0.d(this.f19419a).e(intent).b(new C1250a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements GiftPanel.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f19421a;

        public b(Activity activity) {
            this.f19421a = activity;
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.i
        public boolean a() {
            return false;
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.i
        public List<String> b() {
            ArrayList arrayList = new ArrayList();
            Set<VoiceRoomSelectMemberItem> selectedData = n20.this.c.getSelectedData();
            if (selectedData != null) {
                Iterator<VoiceRoomSelectMemberItem> it = selectedData.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().userId);
                }
            }
            return arrayList;
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.i
        public int getHeight() {
            return k86.e(this.f19421a, 48.0f);
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.i
        public View getView() {
            ViewGroup viewGroup = (ViewGroup) n20.this.c.getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            return n20.this.c;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements GiftPanel.h {
        public c() {
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.h
        public void onDismiss() {
            n20.this.c.clearVoiceRoomMember();
            n20.this.e = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements GiftPanel.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f19423a;

        public d(Activity activity) {
            this.f19423a = activity;
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.i
        public boolean a() {
            return true;
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.i
        public List<String> b() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(n20.this.d.getSelectedUid());
            return arrayList;
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.i
        public int getHeight() {
            return a46.b(this.f19423a, 146.0f);
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.i
        public View getView() {
            return n20.this.d;
        }
    }

    public static int h(ChatItem chatItem) {
        if (chatItem == null || chatItem.getChatType() != 1) {
            return 0;
        }
        return ((GroupInfoItem) chatItem).getGroupExtTypeFromExtension() == 2 ? 2 : 1;
    }

    public final ArrayList<ContactInfoItem> f(Set<VoiceRoomSelectMemberItem> set) {
        if (set == null || set.size() <= 0) {
            return null;
        }
        ArrayList<ContactInfoItem> arrayList = new ArrayList<>();
        for (VoiceRoomSelectMemberItem voiceRoomSelectMemberItem : set) {
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            contactInfoItem.setUid(voiceRoomSelectMemberItem.userId);
            contactInfoItem.setNickName(voiceRoomSelectMemberItem.userName);
            contactInfoItem.setIconURL(voiceRoomSelectMemberItem.userAvatarUrl);
            arrayList.add(contactInfoItem);
        }
        return arrayList;
    }

    public final List<VoiceRoomSelectMemberItem> g(List<ContactInfoItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (ContactInfoItem contactInfoItem : list) {
                arrayList.add(new VoiceRoomSelectMemberItem(contactInfoItem.getUid(), contactInfoItem.getChatName(), contactInfoItem.getIconURL(), 0, false, true));
            }
        }
        return arrayList;
    }

    public void i() {
        GiftPanel giftPanel = this.f19418a;
        if (giftPanel != null) {
            try {
                giftPanel.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.e = false;
    }

    public final void j(ChatItem chatItem, GiftPanel.g gVar) {
        if (chatItem != null) {
            HashMap map = new HashMap();
            int bizType = chatItem.getBizType();
            String str = DomainHelper.m(chatItem).domain;
            map.put("domain", str);
            if (DomainHelper.Domains.DOMAIN_PRIVATE.domain.equalsIgnoreCase(str) && fu5.q(bizType)) {
                map.put("bizType", Integer.valueOf(bizType + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite));
            } else {
                map.put("bizType", Integer.valueOf(bizType));
            }
            GiftPanel giftPanel = new GiftPanel();
            this.f19418a = giftPanel;
            giftPanel.h1(gVar);
            this.f19418a.p1(chatItem.getChatType() == 0);
            this.f19418a.i1(new JSONObject(map).toString());
            this.f19418a.r1(chatItem.getChatId());
            if (chatItem.getChatType() == 0) {
                this.f19418a.m1(301, chatItem.getChatId() + str, chatItem.getBizType(), str);
                return;
            }
            int iH = h(chatItem);
            this.f19418a.k1(301, iH, chatItem.getChatId() + str, null, str, chatItem.getBizType());
        }
    }

    public final void k(Activity activity, ChatItem chatItem) {
        if (this.c == null) {
            this.c = new ChatSelectMemberView(activity);
        }
        this.c.setGroupChat(new a(activity, chatItem));
        this.f19418a.K0(new b(activity));
        this.f19418a.j1(new c());
    }

    public final void l(Activity activity, ChatItem chatItem) {
        if (this.d == null) {
            this.d = new GroupMemberGiftTopView(activity);
        }
        this.d.setEventCallback(this.b);
        this.f19418a.K0(new d(activity));
    }

    public boolean m() {
        return this.e;
    }

    public void n(fa3 fa3Var) {
        this.b = fa3Var;
    }

    public void o(InputFragment inputFragment, ChatItem chatItem, List<ContactInfoItem> list, int i, GiftPanel.g gVar, int i2) {
        FragmentActivity activity = inputFragment.getActivity();
        if (this.f19418a == null) {
            j(chatItem, gVar);
        }
        int i3 = 2;
        try {
            if ((i & 2) == 2) {
                l(activity, chatItem);
                if (list != null && list.size() > 0) {
                    GroupMemberGiftTopView groupMemberGiftTopView = this.d;
                    ContactInfoItem contactInfoItem = list.get(0);
                    int i4 = ((i & 4) == 4 ? 1 : 0) | 0;
                    if ((i & 8) != 8) {
                        i3 = 0;
                    }
                    groupMemberGiftTopView.setContactItem(contactInfoItem, i4 | i3);
                }
            } else {
                if (chatItem.getChatType() != 0) {
                    k(activity, chatItem);
                }
                if (this.c != null && list != null && list.size() > 0) {
                    this.c.clearVoiceRoomMember();
                    this.c.addVoiceRoomMember(g(list));
                }
            }
            this.f19418a.s1(inputFragment.getChildFragmentManager(), i2);
            this.e = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.zenmen.palmchat.giftkit.widgit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.giftkit.R$id;
import com.zenmen.giftkit.R$layout;
import com.zenmen.palmchat.giftkit.bean.VoiceRoomSelectMemberItem;
import com.zenmen.palmchat.giftkit.event.VoiceRoomMemberSelectEvent;
import com.zenmen.palmchat.giftkit.widgit.ChatSelectMemberAdapter;
import defpackage.ds0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NotifyDataSetChanged"})
public class ChatSelectMemberView extends RelativeLayout {
    private ChatSelectMemberAdapter adapter;
    private View emptyView;
    private final List<VoiceRoomSelectMemberItem> roomMemberList;
    private TextView selectAllButton;
    private View selectAllLayout;
    private View selectDesLayout;
    private TextView selectDesTv;
    private final LinkedHashSet<VoiceRoomSelectMemberItem> selectedData;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zIsSelectedAll = ChatSelectMemberView.this.isSelectedAll();
            Iterator it = ChatSelectMemberView.this.roomMemberList.iterator();
            while (it.hasNext()) {
                ((VoiceRoomSelectMemberItem) it.next()).isSelected = !zIsSelectedAll;
            }
            if (zIsSelectedAll) {
                ChatSelectMemberView.this.selectedData.clear();
            } else {
                ChatSelectMemberView.this.selectedData.addAll(ChatSelectMemberView.this.roomMemberList);
            }
            ChatSelectMemberView.this.updateSelectedButton();
            ChatSelectMemberView.this.adapter.notifyDataSetChanged();
            ds0.a().b(new VoiceRoomMemberSelectEvent());
        }
    }

    public ChatSelectMemberView(Context context) {
        this(context, null);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        View.inflate(context, R$layout.layout_group_chat_member_select, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.rv_select_member);
        this.selectAllLayout = findViewById(R$id.layout_select_all);
        this.selectAllButton = (TextView) findViewById(R$id.tv_select_all);
        this.emptyView = findViewById(R$id.emptyView);
        this.selectDesLayout = findViewById(R$id.selectedDesLayout);
        this.selectDesTv = (TextView) findViewById(R$id.selectDesTv);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        ChatSelectMemberAdapter chatSelectMemberAdapter = new ChatSelectMemberAdapter(context, this.roomMemberList);
        this.adapter = chatSelectMemberAdapter;
        chatSelectMemberAdapter.b(new a());
        recyclerView.setAdapter(this.adapter);
        this.selectAllButton.setOnClickListener(new b());
        updateSelectedButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSelectedAll() {
        return this.roomMemberList.size() > 0 && this.roomMemberList.size() == this.selectedData.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedButton() {
        if (this.roomMemberList.size() <= 0) {
            this.emptyView.setVisibility(0);
            this.selectDesLayout.setVisibility(8);
            return;
        }
        this.emptyView.setVisibility(8);
        this.selectDesLayout.setVisibility(0);
        this.selectDesTv.setText(this.roomMemberList.size() + "人");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x0007, B:7:0x000d, B:9:0x001b, B:11:0x0024, B:12:0x002a, B:14:0x0031), top: B:20:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void addVoiceRoomMember(List<VoiceRoomSelectMemberItem> list) {
        ChatSelectMemberAdapter chatSelectMemberAdapter;
        if (list != null) {
            for (VoiceRoomSelectMemberItem voiceRoomSelectMemberItem : list) {
                if (!this.roomMemberList.contains(voiceRoomSelectMemberItem)) {
                    this.roomMemberList.add(voiceRoomSelectMemberItem);
                    if (voiceRoomSelectMemberItem.isSelected) {
                        this.selectedData.add(voiceRoomSelectMemberItem);
                    }
                }
            }
            updateSelectedButton();
            chatSelectMemberAdapter = this.adapter;
            if (chatSelectMemberAdapter != null) {
                chatSelectMemberAdapter.notifyDataSetChanged();
            }
        } else {
            updateSelectedButton();
            chatSelectMemberAdapter = this.adapter;
            if (chatSelectMemberAdapter != null) {
            }
        }
    }

    public synchronized void clearVoiceRoomMember() {
        this.roomMemberList.clear();
        this.selectedData.clear();
        updateSelectedButton();
        ChatSelectMemberAdapter chatSelectMemberAdapter = this.adapter;
        if (chatSelectMemberAdapter != null) {
            chatSelectMemberAdapter.notifyDataSetChanged();
        }
    }

    public synchronized Set<VoiceRoomSelectMemberItem> getSelectedData() {
        return this.selectedData;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025 A[Catch: all -> 0x002a, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x0007, B:7:0x000d, B:8:0x001e, B:10:0x0025), top: B:16:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void removeVoiceRoomMember(List<VoiceRoomSelectMemberItem> list) {
        ChatSelectMemberAdapter chatSelectMemberAdapter;
        if (list != null) {
            for (VoiceRoomSelectMemberItem voiceRoomSelectMemberItem : list) {
                this.roomMemberList.remove(voiceRoomSelectMemberItem);
                this.selectedData.remove(voiceRoomSelectMemberItem);
            }
            updateSelectedButton();
            chatSelectMemberAdapter = this.adapter;
            if (chatSelectMemberAdapter != null) {
                chatSelectMemberAdapter.notifyDataSetChanged();
            }
        } else {
            updateSelectedButton();
            chatSelectMemberAdapter = this.adapter;
            if (chatSelectMemberAdapter != null) {
            }
        }
    }

    public void setGroupChat(View.OnClickListener onClickListener) {
        this.emptyView.setOnClickListener(onClickListener);
        this.selectDesLayout.setOnClickListener(onClickListener);
    }

    public ChatSelectMemberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatSelectMemberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.roomMemberList = new ArrayList();
        this.selectedData = new LinkedHashSet<>();
        initView(context, attributeSet);
    }

    public ChatSelectMemberView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.roomMemberList = new ArrayList();
        this.selectedData = new LinkedHashSet<>();
        initView(context, attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[Catch: all -> 0x0019, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x000d, B:7:0x0014), top: B:13:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void removeVoiceRoomMember(VoiceRoomSelectMemberItem voiceRoomSelectMemberItem) {
        ChatSelectMemberAdapter chatSelectMemberAdapter;
        if (voiceRoomSelectMemberItem != null) {
            this.roomMemberList.remove(voiceRoomSelectMemberItem);
            this.selectedData.remove(voiceRoomSelectMemberItem);
            updateSelectedButton();
            chatSelectMemberAdapter = this.adapter;
            if (chatSelectMemberAdapter != null) {
                chatSelectMemberAdapter.notifyDataSetChanged();
            }
        } else {
            updateSelectedButton();
            chatSelectMemberAdapter = this.adapter;
            if (chatSelectMemberAdapter != null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020 A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:8:0x0014, B:9:0x0019, B:11:0x0020), top: B:17:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void addVoiceRoomMember(VoiceRoomSelectMemberItem voiceRoomSelectMemberItem) {
        ChatSelectMemberAdapter chatSelectMemberAdapter;
        if (voiceRoomSelectMemberItem != null) {
            if (!this.roomMemberList.contains(voiceRoomSelectMemberItem)) {
                this.roomMemberList.add(voiceRoomSelectMemberItem);
                if (voiceRoomSelectMemberItem.isSelected) {
                    this.selectedData.add(voiceRoomSelectMemberItem);
                }
            }
            updateSelectedButton();
            chatSelectMemberAdapter = this.adapter;
            if (chatSelectMemberAdapter != null) {
                chatSelectMemberAdapter.notifyDataSetChanged();
            }
        } else {
            updateSelectedButton();
            chatSelectMemberAdapter = this.adapter;
            if (chatSelectMemberAdapter != null) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ChatSelectMemberAdapter.b {
        public a() {
        }

        @Override // com.zenmen.palmchat.giftkit.widgit.ChatSelectMemberAdapter.b
        public void a(VoiceRoomSelectMemberItem voiceRoomSelectMemberItem) {
        }
    }
}

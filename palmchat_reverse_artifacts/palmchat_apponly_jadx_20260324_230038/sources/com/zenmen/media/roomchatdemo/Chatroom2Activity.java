package com.zenmen.media.roomchatdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchat.ZMRoomChatImp;
import com.zenmen.media.roomchat.ZMRtcParseRoomInfo;
import com.zenmen.palmchat.R;
import defpackage.qy4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Chatroom2Activity extends AppCompatActivity {
    public String q = "Chatroom2Activity";
    public Button r = null;
    public ZMRoomChatImp s = null;
    public ZMRtcParseRoomInfo t = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Chatroom2Activity.this.s = qy4.b();
                if (Chatroom2Activity.this.t != null) {
                    Chatroom2Activity.this.s.j(Chatroom2Activity.this.t.mRoomid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.manychats_activity_chatroom2);
        ((TextView) findViewById(R.id.currUser_txt)).setText("当前用户:" + RTCParameters.l());
        TextView textView = (TextView) findViewById(R.id.userlist_txt);
        ZMRtcParseRoomInfo zMRtcParseRoomInfo = (ZMRtcParseRoomInfo) getIntent().getSerializableExtra("ROOM_INFO_FROM_SDK");
        this.t = zMRtcParseRoomInfo;
        if (zMRtcParseRoomInfo != null) {
            Log.i(this.q, "显示被叫页面: ID：" + this.t.mCmd + "," + this.t.mRoomid + "," + this.t.mRoomkey);
            String str = "聊天室内用户:\n";
            for (int i = 0; i < this.t.mUserList.size(); i++) {
                ZMRtcParseRoomInfo.UserItem userItem = this.t.mUserList.get(i);
                String str2 = str + userItem.mUserID + ", " + userItem.mUserStatus;
                if (userItem.mIsInitator) {
                    str2 = str2 + " (房主)";
                }
                str = str2 + "\n\n";
            }
            Log.i("TAG", String.valueOf(str.toCharArray()));
            textView.setText(str.toCharArray(), 0, str.length());
        }
        Button button = (Button) findViewById(R.id.accept_btn);
        this.r = button;
        button.setOnClickListener(new a());
    }
}

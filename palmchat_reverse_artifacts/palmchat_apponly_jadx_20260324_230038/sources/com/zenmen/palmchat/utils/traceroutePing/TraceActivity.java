package com.zenmen.palmchat.utils.traceroutePing;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.palmchat.R;
import defpackage.kz5;
import defpackage.sy5;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class TraceActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Button f15767a;
    public EditText b;
    public ProgressBar c;
    public ListView d;
    public c e;
    public kz5 f;
    public final int g = 40;
    public List<TracerouteContainer> h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TraceActivity.this.b.getText().length() == 0) {
                TraceActivity traceActivity = TraceActivity.this;
                sy5.f(traceActivity, traceActivity.getString(R.string.no_text), 0).g();
                return;
            }
            TraceActivity.this.h.clear();
            TraceActivity.this.e.notifyDataSetChanged();
            TraceActivity.this.h();
            TraceActivity traceActivity2 = TraceActivity.this;
            traceActivity2.e(traceActivity2.b);
            TraceActivity.this.f.t(TraceActivity.this.b.getText().toString(), 40);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TracerouteContainer f15769a;

        public b(TracerouteContainer tracerouteContainer) {
            this.f15769a = tracerouteContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            TraceActivity.this.h.add(this.f15769a);
            TraceActivity.this.e.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f15770a;

        /* JADX INFO: compiled from: SearchBox */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f15771a;
            public TextView b;
            public TextView c;
            public ImageView d;

            public a() {
            }
        }

        public c(Context context) {
            this.f15770a = context;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TracerouteContainer getItem(int i) {
            return (TracerouteContainer) TraceActivity.this.h.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return TraceActivity.this.h.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.f15770a.getSystemService("layout_inflater")).inflate(R.layout.item_list_trace, (ViewGroup) null);
                TextView textView = (TextView) view.findViewById(R.id.textViewNumber);
                TextView textView2 = (TextView) view.findViewById(R.id.textViewIp);
                TextView textView3 = (TextView) view.findViewById(R.id.textViewTime);
                ImageView imageView = (ImageView) view.findViewById(R.id.imageViewStatusPing);
                aVar = new a();
                aVar.f15771a = textView;
                aVar.b = textView2;
                aVar.c = textView3;
                aVar.d = imageView;
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            TracerouteContainer item = getItem(i);
            if (i % 2 == 1) {
                view.setBackgroundColor(Color.argb(255, 240, 240, 240));
            } else {
                view.setBackgroundColor(Color.argb(255, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR));
            }
            if (item.isSuccessful()) {
                aVar.d.setBackgroundColor(-16711936);
            } else {
                aVar.d.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            }
            aVar.f15771a.setText(i + "");
            aVar.b.setText(item.getHostname() + " (" + item.getIp() + ")");
            TextView textView4 = aVar.c;
            StringBuilder sb = new StringBuilder();
            sb.append(item.getMs());
            sb.append("ms");
            textView4.setText(sb.toString());
            return view;
        }
    }

    public void e(EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 2);
        }
    }

    public final void f() {
        this.f15767a.setOnClickListener(new a());
        c cVar = new c(getApplicationContext());
        this.e = cVar;
        this.d.setAdapter((ListAdapter) cVar);
    }

    public void g(TracerouteContainer tracerouteContainer) {
        runOnUiThread(new b(tracerouteContainer));
    }

    public void h() {
        this.c.setVisibility(0);
    }

    public void i() {
        this.c.setVisibility(8);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_trace);
        this.f = new kz5(this);
        this.h = new ArrayList();
        this.f15767a = (Button) findViewById(R.id.buttonLaunch);
        this.b = (EditText) findViewById(R.id.editTextPing);
        this.d = (ListView) findViewById(R.id.listViewTraceroute);
        this.c = (ProgressBar) findViewById(R.id.progressBarPing);
        f();
    }
}

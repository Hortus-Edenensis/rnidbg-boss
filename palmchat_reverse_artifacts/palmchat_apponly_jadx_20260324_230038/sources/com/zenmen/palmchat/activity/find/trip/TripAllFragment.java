package com.zenmen.palmchat.activity.find.trip;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.zenmen.find.bean.LoadCountBean;
import com.zenmen.palmchat.R;
import defpackage.l50;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TripAllFragment extends Fragment {
    public View d = null;
    public View e = null;
    public List<LoadCountBean.MarkerBean> f = null;
    public View g = null;
    public Activity h = null;
    public String i = null;
    public FindTripNearbyRecycleView j = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (TripAllFragment.this.h != null) {
                TripAllFragment.this.h.finish();
            } else if (TripAllFragment.this.getActivity() != null) {
                TripAllFragment.this.getActivity().finish();
            }
        }
    }

    public final void E(View view) {
        this.d = view.findViewById(R.id.trip_map_nearby_data_all_error_layout);
        this.e = view.findViewById(R.id.trip_map_nearby_data_all_success_layout);
        View viewFindViewById = view.findViewById(R.id.trip_map_nearby_data_error_back);
        this.g = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        List<LoadCountBean.MarkerBean> list = this.f;
        if (list == null || list.size() == 0) {
            this.d.setVisibility(0);
            this.e.setVisibility(8);
        } else {
            this.d.setVisibility(8);
            this.e.setVisibility(0);
        }
        FindTripNearbyRecycleView findTripNearbyRecycleView = (FindTripNearbyRecycleView) view.findViewById(R.id.trip_map_nearby_data_all_recycle);
        this.j = findTripNearbyRecycleView;
        findTripNearbyRecycleView.setData(this.f, this.i, "allTag", this.h);
    }

    public void F(LoadCountBean.MarkerBean markerBean) {
        if (markerBean != null) {
            this.j.removeErrorData(markerBean);
        }
    }

    public void G(List<LoadCountBean.MarkerBean> list, Activity activity, String str) {
        this.f = list;
        this.h = activity;
        this.i = str;
    }

    public void I() {
        this.j.updateData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_map_trip_nearby_fragment_all, viewGroup, false);
        E(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FindTripNearbyRecycleView findTripNearbyRecycleView = this.j;
        if (findTripNearbyRecycleView != null) {
            findTripNearbyRecycleView.onDestroy();
        }
        List<LoadCountBean.MarkerBean> list = this.f;
        if (list != null) {
            list.clear();
        }
        this.h = null;
    }
}

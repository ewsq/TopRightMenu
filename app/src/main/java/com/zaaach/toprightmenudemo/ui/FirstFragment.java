package com.zaaach.toprightmenudemo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zaaach.toprightmenudemo.R;
import com.zaaach.toprightmenudemo.alipay.MyGridAdapter;
import com.zaaach.toprightmenudemo.alipay.MyGridView;
import com.zaaach.toprightmenudemo.view.RadarView;
import com.zaaach.toprightmenudemo.view.ScanView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mTitle;


    private ScanView mScanView;

    public static FirstFragment getInstance(String title) {
        FirstFragment sf = new FirstFragment();
        sf.mTitle = title;
        return sf;
    }

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        /*mScanView = v.findViewById(R.id.scan_view);
        mScanView.start();*/

        RadarView radarView = v.findViewById(R.id.radar);
        radarView.start();

        StringBuffer sb=new StringBuffer();
        sb.append("纬度：22.369111 \r\n");
        sb.append("经度：113.591487 \r\n");
        sb.append("海拨：5.29   精度：+-15.00 \r\n");
        sb.append("天气：晴 14~23℃ 静风 \r\n");
        TextView gpsinfo = v.findViewById(R.id.gpsinfo);
        gpsinfo.setText(sb.toString());

        TextView address = v.findViewById(R.id.address);
        address.setText("珠海市香洲区港湾大道1873号靠近大洲科技园");


        MyGridView gridview=(MyGridView) v.findViewById(R.id.gridview);
        gridview.setAdapter(new MyGridAdapter(v.getContext()));

        return v;
    }
}
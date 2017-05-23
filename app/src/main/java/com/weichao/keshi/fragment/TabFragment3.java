package com.weichao.keshi.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.weichao.keshi.R;

/**
 * Created by 郑卫超 on 2017/5/3.
 */

public class TabFragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_tab, null);
        TextView tv = (TextView) inflate.findViewById(R.id.txt);
        tv.setBackgroundColor(Color.YELLOW);
        return inflate;
    }
}

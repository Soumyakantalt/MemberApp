package com.nttdata.memberapp.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nttdata.memberapp.R;
import com.nttdata.memberapp.model.Member;
import java.util.ArrayList;

public class DashboardFragment extends Fragment implements DashboardPresenter.View {

    RecyclerView recyclerView;
    DashboardPresenter dashboardPresenter;
    DashboardAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = view.findViewById(R.id.data_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        //setting adapter to recycler view
        adapter = new DashboardAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        //creating instance of presenter class
        dashboardPresenter = new DashboardPresenter(this);

        //calling initData method of presenter class in which we added dtudent record
        dashboardPresenter.initData();

        return view;
    }

    @Override
    public void addDatas(ArrayList<Member> datas) {
        adapter.submitList(datas);
        adapter.notifyDataSetChanged();
    }
}

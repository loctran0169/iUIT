package vn.edu.uit.managementforstudents.ui.fragments.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.uit.managementforstudents.R;
import vn.edu.uit.managementforstudents.data.adapters.AdapterHistory;

public class HistoryFragment extends Fragment {

    AdapterHistory mAdapterHistory;
    RecyclerView   rcv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext())
                             .inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapterHistory = new AdapterHistory();
        rcv = view.findViewById(R.id.rcv_history);
        rcv.setLayoutManager(new LinearLayoutManager((getContext())));
        rcv.setAdapter(mAdapterHistory);
    }
}

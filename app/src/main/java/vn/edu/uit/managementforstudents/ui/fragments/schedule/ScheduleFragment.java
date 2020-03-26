package vn.edu.uit.managementforstudents.ui.fragments.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.edu.uit.managementforstudents.R;

public class ScheduleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity())
                             .inflate(R.layout.fragment_schedule, container, false);
    }
}

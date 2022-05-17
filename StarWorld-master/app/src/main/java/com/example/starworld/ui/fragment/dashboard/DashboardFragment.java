package com.example.starworld.ui.fragment.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.starworld.databinding.FragmentDashboardBinding;
import com.example.starworld.domain.model.film.Film;
import com.example.starworld.ui.fragment.dashboard.adapter.FilmAdapter;

import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    private FilmAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FilmAdapter();
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        dashboardViewModel.init();
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }
    private void initView() {
        binding.rvDashBoard.setAdapter(adapter);
//        dashboardViewModel.getPeopleMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Film>>() {
//            @Override
//            public void onChanged(List<Film> films) {
//                adapter.setList(films);
//            }
//        });
        dashboardViewModel.getPeopleMutableLiveData().observe(this, new Observer<List<Film>>() {
            @Override
            public void onChanged(List<Film> films) {
                adapter.setList(films);
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
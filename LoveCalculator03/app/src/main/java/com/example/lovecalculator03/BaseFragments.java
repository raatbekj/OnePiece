package com.example.lovecalculator03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragments<VB extends ViewBinding> extends Fragment {

    public VB binding;

    public abstract VB getBinding();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = getBinding();
        return getBinding().getRoot();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        binding=null;
    }
}

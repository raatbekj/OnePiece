package com.example.lovecalculator03;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lovecalculator03.databinding.FragmentCalcilateBinding;


public class CalculateFragment extends BaseFragments<FragmentCalcilateBinding> {


    @Override
    public FragmentCalcilateBinding getBinding() {
        return FragmentCalcilateBinding.inflate(getLayoutInflater());
    }
}
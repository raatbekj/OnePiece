package com.joma.encard02.ui.videoFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joma.encard02.data.videoModel.VideoHit;
import com.joma.encard02.databinding.ItemVideoBinding;

import java.util.ArrayList;
import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private List<VideoHit> videoHits = new ArrayList<>();

    public void setVideoHits(List<VideoHit> videoHits) {
        this.videoHits = videoHits;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemVideoBinding binding = ItemVideoBinding.inflate(LayoutInflater.
                        from(parent.getContext()),
                parent, false);
        return new VideoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.VideoViewHolder holder, int position) {
        holder.onBindVideo(videoHits.get(position));
    }

    @Override
    public int getItemCount() {
        return videoHits.size();
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder {
        ItemVideoBinding binding;

        public VideoViewHolder(@NonNull ItemVideoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBindVideo(VideoHit videoHit) {
            Log.e("ABOBA", videoHit.getVideos().getSmall().getUrl());
            binding.itemImgVideo.videoUrl(videoHit.getVideos().getSmall().getUrl())
                    .enableAutoStart();
            binding.tvItemTags.setText(videoHit.getTags());
        }
    }
}

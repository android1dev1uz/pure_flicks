package com.pure.PureFlicks;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoViewHolder> {
    private List<VideoItem> videoItems;

    public VideosAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_video,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        TextView textVideoTitle, textVideoDescription;
        ProgressBar videoProgressBar;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            textVideoTitle = itemView.findViewById(R.id.textVideoTitle);
            textVideoDescription = itemView.findViewById(R.id.textVideoDescription);
            videoProgressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        void setVideoData(VideoItem videoItem) {
            textVideoTitle.setText(videoItem.videoTitle);
            textVideoDescription.setText(videoItem.videoDescription);
            videoView.setVideoPath(videoItem.videoURL);
            videoView.setOnPreparedListener(mediaPlayer -> {
                videoProgressBar.setVisibility(View.GONE);
                mediaPlayer.start();
                float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
                float screenRatio = videoView.getWidth() / (float) videoView.getHeight();
                float scale = videoRatio / screenRatio;
                if (scale >= 1f) {
                    videoView.setScaleX(scale);
                } else {
                    videoView.setScaleY(1f / scale);
                }
            });
            videoView.setOnCompletionListener(mediaPlayer -> {
                mediaPlayer.start();
            });
        }
    }
}

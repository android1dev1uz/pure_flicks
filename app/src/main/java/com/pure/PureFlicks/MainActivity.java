package com.pure.PureFlicks;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager2 videosViewPager = findViewById(R.id.videosViewPager);
        List<VideoItem> videoItems = new ArrayList<>();
        VideoItem videoShortsItem = new VideoItem();
        videoShortsItem.videoURL = "https://videos.pexels.com/video-files/11059706/11059706-hd_1080_1920_30fps.mp4";
        videoShortsItem.videoDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        videoShortsItem.videoTitle = "Lorem ipsum";
        videoItems.add(videoShortsItem);

        VideoItem videoShortItem = new VideoItem();
        videoShortItem.videoURL = "https://videos.pexels.com/video-files/11059706/11059706-hd_1080_1920_30fps.mp4";
        videoShortItem.videoDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        videoShortItem.videoTitle = "Lorem ipsum";
        videoItems.add(videoShortItem);

        VideoItem videoShorItem = new VideoItem();
        videoShorItem.videoURL = "https://videos.pexels.com/video-files/11059706/11059706-hd_1080_1920_30fps.mp4";
        videoShorItem.videoDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        videoShorItem.videoTitle = "Lorem ipsum";
        videoItems.add(videoShorItem);
        VideosAdapter videosAdapter = new VideosAdapter(videoItems);
        videosViewPager.setAdapter(videosAdapter);
    }
}
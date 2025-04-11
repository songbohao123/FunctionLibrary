package com.example.gittestdemo.video;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import com.example.gittestdemo.R;

public class VideoMp4Activity extends AppCompatActivity {
    private ExoPlayer player;
    private PlayerView playerView;
    private boolean a;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_mp4_layout);
        //1.首先初始化player
        player = new ExoPlayer.Builder(this).build();
        //2.绑定布局的payerView
        playerView = findViewById(R.id.player_view);
        TextView text_video_start = findViewById(R.id.video_start);
        playerView.setPlayer(player);
        //3.创建播放条目
        MediaItem mediaItem = MediaItem.fromUri("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4");
        player.setMediaItem(mediaItem);
        player.prepare();
        //4.自动播放
        player.setPlayWhenReady(true);
        a = false;

        text_video_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (a){
                    a =false;
                    player.play();
                }else {
                    a =true;
                    player.pause();
                }

            }
        });


    }
}

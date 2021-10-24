package com.ysw.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MusicDownloadTest {
    @Autowired
    private MusicDownload musicDownload;

    @Test
    public void test() throws Exception {
        String music = musicDownload.getMusic();
    }

}
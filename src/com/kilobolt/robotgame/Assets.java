package com.kilobolt.robotgame;

import com.kilobolt.framework.Image;
import com.kilobolt.framework.Music;
import com.kilobolt.framework.Sound;

public class Assets {
    
    public static Image menu, splash, background, characterIdleR, characterStride1R, characterStride2R, characterStride3R, characterJumpedR, characterShootR, heliboy, heliboy2, heliboy3, heliboy4, heliboy5;
    public static Image tiledirt, tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight, characterJump, characterDown, fireball, fireball2;
    public static Image button;
    public static Sound click;
    public static Music theme;
    
    public static void load(SampleGame sampleGame) {
        // TODO Auto-generated method stub
        theme = sampleGame.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();
    }
    
}
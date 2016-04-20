package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.Screens.ScrMenu;
import com.mygdx.game.Screens.ScrPlay;
import com.mygdx.game.Screens.ScrGameover;

/**
 * Created by luke on 2016-04-20.
 */

public class Main extends Game {
    ScrMenu scrMenu;
    ScrPlay scrPlay;
    ScrGameover scrGameover;
    Music sound8bit;

    public enum GameState {
        MENU, PLAY, OVER
    }

    public GameState currentState;

    public void updateState() {
        if (currentState == GameState.MENU) {
            setScreen(scrMenu);
        } else if (currentState == GameState.PLAY) {
            setScreen(scrPlay);
        } else if (currentState == GameState.OVER) {
            setScreen(scrGameover);
        }
    }

    @Override
    public void create() {
        sound8bit = Gdx.audio.newMusic(Gdx.files.internal("8bit4.wav"));
        sound8bit.play();
        scrMenu = new ScrMenu(this);
        scrPlay = new ScrPlay(this);
        scrGameover = new ScrGameover(this);
        currentState = GameState.MENU;
        updateState();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
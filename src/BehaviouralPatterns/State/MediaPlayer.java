package BehaviouralPatterns.State;

interface PlayerState {
    void play(MediaPlayer playerCtx);

    void pause(MediaPlayer playerCtx);

    void stop(MediaPlayer playerCtx);

}

class StoppedState implements PlayerState {

    @Override
    public void play(MediaPlayer playerCtx) {
        System.out.println("Playing again after stopping");
        playerCtx.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer playerCtx) {
        throw new IllegalStateException("Cant pause when already stopped");
    }

    @Override
    public void stop(MediaPlayer playerCtx) {
        throw new IllegalStateException("Cant stop when already stopped");
    }
}

class PlayingState implements PlayerState {

    @Override
    public void play(MediaPlayer playerCtx) {
        throw new IllegalStateException("Cant play, already playing.");
    }

    @Override
    public void pause(MediaPlayer playerCtx) {
        System.out.println("Attempting to pause. From Play -> Pause");
        playerCtx.setState(new PausedState());
    }

    @Override
    public void stop(MediaPlayer playerCtx) {
        System.out.println("Attempting to stop. From Play -> Stop");
        playerCtx.setState(new StoppedState());
    }
}

class PausedState implements PlayerState {

    @Override
    public void play(MediaPlayer playerCtx) {
        System.out.println("Attempting to play. From Paused to play");
        playerCtx.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer playerCtx) {
        throw new IllegalStateException("Already paused state");
    }

    @Override
    public void stop(MediaPlayer playerCtx) {
        System.out.println("Attempting to stop, from Paused to Stopped");
        playerCtx.setState(new StoppedState());
    }
}


public class MediaPlayer {

    PlayerState state;

    public MediaPlayer() {
        this.state = new StoppedState();
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void play() {
        state.play(this);
    }

    public void pause() {
        state.pause(this);
    }

    public void stop() {
        state.stop(this);
    }

    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.stop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            mediaPlayer.play();
            mediaPlayer.pause();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\nNow setting state to Paused");

        mediaPlayer.setState(new PausedState());

        try {
            mediaPlayer.stop();
            mediaPlayer.play();
            mediaPlayer.pause();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\nNow setting state to Playing");

        mediaPlayer.setState(new PlayingState());

        try {
            mediaPlayer.stop();
            mediaPlayer.play();
            mediaPlayer.pause();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

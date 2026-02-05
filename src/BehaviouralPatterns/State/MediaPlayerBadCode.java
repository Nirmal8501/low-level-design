package BehaviouralPatterns.State;

// If in future more state comes, we have to change all the behaviours, what if someone misses to change something ?
// Since the decision flow of the methods is decided by the states, why not let the state itself decide what's good for itself
// This is the intuition for state pattern, here the function based on state takes a decisionm which is differentt from Strategy pattern,
// in strategy the client has the control over which implementation to run based on algo, but here the internal state decides.
// So lets reverse the dependency. instead of methods manipulating the states, let states decide whom to call.
//  3️⃣ This is a hidden state machine
//  You can’t “see” transitions
//  Logic is scattered across methods


public class MediaPlayerBadCode {
    private State state;

    public MediaPlayerBadCode() {
        this.state = State.STOPPED;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void play() {
        if (state == State.PAUSED || state == State.STOPPED) {
            System.out.println("Playing the song");
            state = State.PLAYING;
            return;
        }
        throw new IllegalStateException("Cant play, already playing");
    }

    public void pause() {
        if (state == State.PLAYING) {
            System.out.println("Pausing the song");
            state = State.PAUSED;
            return;
        }
        throw new IllegalStateException("Cant Pause, already paused or stopped");

    }

    public void stop() {
        if (state == State.PAUSED || state == State.PLAYING) {
            System.out.println("Stopping the song");
            state = State.STOPPED;
            return;
        }
        throw new IllegalStateException("Cant Stop, already Stopped");
    }
}

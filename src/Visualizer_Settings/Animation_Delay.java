package Visualizer_Settings;

public class Animation_Delay {

    private long searching_delay;
    private long path_delay;

    public Animation_Delay(){
        searching_delay = 300;
        path_delay = 300;
    }

    public long getSearching_delay() {
        return searching_delay;
    }

    public void setSearching_delay(long searching_delay) {
        this.searching_delay = searching_delay;
    }

    public long getPath_delay() {
        return path_delay;
    }

    public void setPath_delay(long path_delay) {
        this.path_delay = path_delay;
    }
}

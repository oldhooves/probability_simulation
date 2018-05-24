import java.awt.*;

public class AlgoVisualizer {


    private static int DELAY = 5;
    private static int blockSide = 80;
    private GameData data;
    private AlgoFrame frame;

    public AlgoVisualizer(String filename){

        data = new GameData(filename);
        final int sceneWidth = data.M() * blockSide;
        final int sceneHeight = data.N() * blockSide;

        EventQueue.invokeLater(() ->{
            frame = new AlgoFrame("move the box",sceneWidth,sceneHeight);

            new Thread(() ->{
                run();
            }).start();
        });


    }
    public void run() {
        setData();
    }

    private void setData(){
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {

        String filename = "level/boston_09.txt";

        AlgoVisualizer vis = new AlgoVisualizer(filename);
    }
}

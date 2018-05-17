/**
 * Created by ${laotizi} on 2018-05-16.
 */
import com.sun.scenario.effect.impl.prism.PrImage;

import java.awt.*;
import java.util.LinkedList;

public class AlgoVisualizer {

    private static int DELAY = 40;
    private MonteCarloPiData data;
    private AlgoFrame frame;    // 视图
    private int N;

    public AlgoVisualizer(int sceneWidth, int sceneHeight,int N){

        if (sceneHeight != sceneWidth){
            throw new IllegalArgumentException("必须是正方形");
        }

        // 初始化数据
        this.N = N;
        Circle circle = new Circle(sceneWidth / 2,sceneHeight / 2,sceneHeight/2);
        data = new MonteCarloPiData(circle);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Get PI with Monte Carlo", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        for (int i = 0;i<N;i++){

            if (i % 100 == 0){
                frame.render(data);
                AlgoVisHelper.pause(DELAY);
                System.out.println(data.estimatePi());
            }



            int x = (int) (Math.random()*frame.getCanvasWidth());
            int y = (int) (Math.random()*frame.getCanvasHeight());
            data.addPoint(new Point(x,y));
        }
    }



    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10000;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,N);
    }
}

/**
 * Created by ${laotizi} on 2018-05-16.
 */
import com.sun.scenario.effect.impl.prism.PrImage;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.IllegalFormatException;
import java.util.LinkedList;

public class AlgoVisualizer {

    private static int DELAY = 40;
    private Circle circle;
    private LinkedList<Point> points;
    private AlgoFrame frame;    // 视图
    private int N;

    public AlgoVisualizer(int sceneWidth, int sceneHeight,int N){

        if (sceneHeight != sceneWidth){
            throw new IllegalArgumentException("必须是正方形");
        }

        // 初始化数据
        this.N = N;
        circle = new Circle(sceneWidth / 2,sceneHeight / 2,sceneHeight/2);
        points = new LinkedList<Point>();

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
            frame.render(circle,points);
            AlgoVisHelper.pause(DELAY);

            int x = (int) (Math.random()*frame.getCanvasWidth());
            int y = (int) (Math.random()*frame.getCanvasHeight());
            Point p = new Point(x,y);
            points.add(p);
        }
    }



    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10000;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,N);
    }
}

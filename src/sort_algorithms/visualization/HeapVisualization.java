package sort_algorithms.visualization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class HeapVisualization {
    JLabel heapLabel;
    JLabel commentLabel;

    public boolean TurnOn=true;

    public HeapVisualization() {
        gui();
    }

    private String genText(Comparable[]array){
        String text= dump(array);
        return text;
    }

    public String dump(Comparable[]array) {
        String result="";
        int height = log2(array.length) + 1;

        for (int i = 1, len = array.length; i < len; i++) {
            String x = String.valueOf(array[i]);
            int level = log2(i) + 1;
            int spaces = (height - level + 1) * 2;

            result=result+stringOfSize(spaces, ' ');
            result=result+x;

            if((int)Math.pow(2, level) - 1 == i)result=result+"<br>";
        }
        return result;
    }

    private int log2(int x) {
        return (int)(Math.log(x) / Math.log(2)); // = log(x) with base 10 / log(2) with base 10
    }

    private String stringOfSize(int size, char ch) {
        char[] a = new char[size];
        Arrays.fill(a, ch);
        return new String(a);
    }

    public void gui(){
        JFrame frame = new JFrame("JFrame Example");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        heapLabel = new JLabel("");
        JButton button = new JButton();
        button.setText("Button");

        commentLabel = new JLabel("");


        panel.add(commentLabel);
        panel.add(new JLabel("\n"));
        panel.add(heapLabel);

        frame.add(panel);
        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void modalPause(){
        JDialog frame = new JDialog();
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton jButton=new JButton("continue");
        jButton.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();

            }
        });
        panel.add(jButton);
        panel.add(jButton);


        frame.setLocation(MouseInfo.getPointerInfo().getLocation().x-60,MouseInfo.getPointerInfo().getLocation().y-50);
        frame.setModal(true);
        frame.add(panel);
        frame.setSize(100, 100);

        frame.setAlwaysOnTop(true);
//        frame.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void markPoint(Comparable[] array, Integer from,int size,String comment) {
        if (!TurnOn)return;


        Comparable[] zeroInclude=new Comparable[array.length+1];
        for (int i = 0; i < array.length; i++)zeroInclude[i+1]=array[i];


        if (from!=null)zeroInclude[from]="{"+zeroInclude[from]+"}";

        zeroInclude[1]="<span style=\"background-color: #ccffff;\">"+zeroInclude[1];
        zeroInclude[size]=zeroInclude[size]+"</span>";


        String text=genText(zeroInclude);
        System.out.println(text);
//        text=text.replaceAll("\n","<br>");
        text=text.replaceAll("\\s","&nbsp;");
        text=text.replaceAll("<span&nbsp;style","<span style");
        text=text.replaceAll("color:&nbsp;#","color: #");


        heapLabel.setText("<html>" +text+"</html>");
        commentLabel.setText("<html>" +comment.replaceAll("\n","<br>")+"</html>");
        modalPause();

    }

    public void markPoint(Comparable[] array, int from, int lChildI,int size, String comment) {
        if (!TurnOn)return;

        Comparable[] zeroInclude=new Comparable[array.length+1];
        for (int i = 0; i < array.length; i++)zeroInclude[i+1]=array[i].toString().replaceAll("\\s","&nbsp;");;

        zeroInclude[from]="("+zeroInclude[from]+")";
        zeroInclude[lChildI]="("+zeroInclude[lChildI]+")";

        zeroInclude[1]="<span style=\"background-color: #ccffff;\">"+zeroInclude[1];
        zeroInclude[size]=zeroInclude[size]+"</span>";

        String text=genText(zeroInclude);
//        System.out.println(text);
        text=text.replaceAll("\n","<br>");
        text=text.replaceAll("\\s","&nbsp;");
        text=text.replaceAll("<span&nbsp;style","<span style");
        text=text.replaceAll("color:&nbsp;#","color: #");


        heapLabel.setText("<html>" +text+"</html>");
        commentLabel.setText(comment);
        modalPause();

    }
}

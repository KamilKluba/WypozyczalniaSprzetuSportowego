package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.app;

import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;


public class HighlightTest {

    private static class HighlightEvaluator implements IDateEvaluator {

        private final List<Date> list = new ArrayList<>();

        public void add(Date date) {
            list.add(date);
        }

        public boolean isSpecial(Date date) {
            return list.contains(date);
        }

      
        public Color getSpecialForegroundColor() {
            return Color.red.darker();
        }

       
        public Color getSpecialBackroundColor() {
            return Color.blue;
        }

       
        public String getSpecialTooltip() {
            return "Highlighted event.";
        }

      
        public boolean isInvalid(Date date) {
            return false;
        }

     
        public Color getInvalidForegroundColor() {
            return null;
        }

       
        public Color getInvalidBackroundColor() {
            return null;
        }

     
        public String getInvalidTooltip() {
            return null;
        }
    }

    private void display(int a, int b) {
        JFrame f = new JFrame("Calendar");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        int i;
        HighlightEvaluator evaluator = new HighlightEvaluator();
        for( i=a; i<=b; i++)
        {
        evaluator.add(createDate(i));
        }
        JCalendar jc = new JCalendar();
        jc.getDayChooser().addDateEvaluator(evaluator);
        jc.setCalendar(jc.getCalendar());
        f.add(jc);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private Date createDate(int d) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, d);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return (c.getTime());
    }

   
}
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharath on 4/22/2016.
 */
public class asdf {
    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add("Zara");
        a1.add("Mahnaz");
        a1.add("Ayan");
        String x = "";

        List<List> main=new <List>ArrayList();
                main.add(a1);

         for(int i=0;i<main.size();i++){
             for(int j=0;j<main.get(i).size();j++){
                 x+=main.get(i).get(j)+",";
             }
         }
        System.out.println(x);
    }
}
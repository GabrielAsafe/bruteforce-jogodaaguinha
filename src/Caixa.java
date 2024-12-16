import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Caixa {


    protected int QTDPreenchimento; //int 0 -4
    public List<String> items;
    static int tentativas = 0;



    public Caixa() {
        this.QTDPreenchimento = 0;
        this.items = new ArrayList<>();
    }


    //Usada no assign de valores no main
    public void setItems(String item) {
        this.items.add(item);
        this.QTDPreenchimento = this.items.size();
    }

    public String getTopo() {
        return items.isEmpty() ? null : items.getFirst();
    }

    public void removeTopo() {
        if (!items.isEmpty()) {
            items.removeFirst();
            this.QTDPreenchimento = this.items.size();
        }
    }

    public List<String> getItems() {
        return items;
    }

    //mover objeto de caixa 1 para caixa 2, ou de a para b
    public static void moverObjeto(Caixa a, Caixa b){

        try {
            boolean sorted = false;
            for (int j = 0; j < a.items.size(); j++) {
                LinkedList tmp = new LinkedList(a.items); // Faz uma cópia da lista original
                Collections.sort(tmp);

                sorted = sorted && tmp.get(j) == a.items.get(j);

            }
            if(sorted)
                return;



            if(a.QTDPreenchimento<=4 && b.QTDPreenchimento<4 && !a.items.isEmpty()){
                if(b.QTDPreenchimento == 0){
                    b.setItems(a.getTopo());
                    a.removeTopo();
                    return;
                }

                if(b.QTDPreenchimento >0){
                    if(a.getTopo().equals(b.getTopo())){
                        b.setItems(a.getTopo());
                        a.removeTopo();

                        tentativas = 0;
                        return;
                    }
                }

                tentativas++;
            }

        }catch (Exception e){

        }


    }
    @Override
    public String toString() {
        return "Caixa{" +
                "QTDPreenchimento=" + QTDPreenchimento +
                ", items=" + items +
                '}';
    }
}

import java.util.ArrayList;
import java.util.List;

public class Caixa {


    protected int QTDPreenchimento; //int 0 -4
    protected List<String> items;
    static int tentativas = 0;

    public Caixa(int QTDPreenchimento, List<String> items) {
        this.QTDPreenchimento = QTDPreenchimento;
        this.items = items;
    }

    public Caixa() {
        this.QTDPreenchimento = 0;
        this.items = new ArrayList<>();
    }

    public void setQTDPreenchimento(int QTDPreenchimento) {
        this.QTDPreenchimento = QTDPreenchimento;
    }

    public void setItems(String item) {
        this.items.add(item);
    }

    public String getTopo() {
        return items.isEmpty() ? null : items.getFirst();
    }

    public void removeTopo() {
        if (!items.isEmpty()) {
            items.removeFirst();
        }
    }

    //mover objeto
    public static void moverObjeto(Caixa a, Caixa b){
        try {

            if(a.QTDPreenchimento<=4 && b.QTDPreenchimento<4 && !a.items.isEmpty()){
                if(b.QTDPreenchimento == 0){
                    b.setItems(a.getTopo());
                    a.removeTopo();
                    a.QTDPreenchimento --;
                    b.QTDPreenchimento++;
                    return;
                }

                if(b.QTDPreenchimento >0){
                    if(a.getTopo().equals(b.getTopo())){
                        b.setItems(a.getTopo());
                        a.removeTopo();

                        a.QTDPreenchimento --;
                        b.QTDPreenchimento++;
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

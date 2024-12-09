import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Caixa> listaDeCaixas = new ArrayList<>();

        List<String> lista = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            lista.add("A");
            lista.add("B");
            lista.add("C");
            lista.add("D");
            lista.add("E");
            lista.add("F");
            lista.add("G");
            lista.add("H");
            lista.add("I");
            lista.add("J");

        }

        Collections.shuffle(lista);

        int QuantidadeDeCaixas = 12;
        int contador = 0;

        listaDeCaixas.add(new Caixa());
        listaDeCaixas.add(new Caixa());

        for (int i = 0; i < QuantidadeDeCaixas; i++) {
            Caixa caixa = new Caixa();
            for (int j = 0; j < 4; j++) {
                caixa.setItems(lista.get(contador));
                contador++;
            }
            listaDeCaixas.add(caixa);
        }





        while (true){
            int min=0,max=13;
            int randomNum1 = ThreadLocalRandom.current().nextInt(min, max + 1);
            int randomNum2 = ThreadLocalRandom.current().nextInt(min, max + 1);


             Caixa.moverObjeto(listaDeCaixas.get(randomNum1),listaDeCaixas.get(randomNum2));
             if(Caixa.tentativas >= 500){}
               //
            listaDeCaixas.iterator().forEachRemaining(caixa -> System.out.println(caixa.toString()));

        }





    }
}
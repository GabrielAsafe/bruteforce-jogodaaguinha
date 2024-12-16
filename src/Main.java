import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LinkedList<Caixa>listaDepreenchidos = new LinkedList<>();
        LinkedList<Caixa> listaDeCaixas = new LinkedList<>();
        LinkedList<String> lista = new LinkedList<>();
        preencher(listaDeCaixas,lista,9);//altere aqui a quantidade de caixas -> paralelo ao nível de dificuldade


        listaDeCaixas.iterator().forEachRemaining(caixa -> System.out.println(caixa.toString()));

        Caixa caixa1;
        Caixa caixa2;

        while (true){

            try {
                 caixa1 = listaDeCaixas.get(createRandom(0,listaDeCaixas.size()-1));
                 caixa2 = listaDeCaixas.get(createRandom(0,listaDeCaixas.size()-1));

                Caixa.moverObjeto(caixa1,caixa2);
                listaDeCaixas.iterator().forEachRemaining(caixa -> System.out.println(caixa.toString()));
                if(verifyIsComplete(listaDeCaixas,listaDepreenchidos))
                    break;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
    }

    /**
     * Verifica em todas as caixas se elas estão sorted
     * @param listaDeCaixas
     * @param listaDepreenchidos
     * @return
     */
    public static boolean verifyIsComplete( LinkedList<Caixa> listaDeCaixas, LinkedList<Caixa>listaDepreenchidos){
        boolean sorted = false;
        boolean controle = false;
        int emptycount = 0;
        for (int j = 0; j < listaDeCaixas.size(); j++) {

            LinkedList tmp = new LinkedList(listaDeCaixas.get(j).getItems()); // Faz uma cópia da lista original
            if(tmp.isEmpty())
                emptycount++;


            if(tmp.size() != 4)
                continue;



            for (int i = 0; i < listaDeCaixas.size(); i++) {if(listaDeCaixas.get(i).QTDPreenchimento != 4){controle = false;} }


            if(tmp.get(0) ==tmp.get(1) && tmp.get(2)==tmp.get(3) && tmp.get(2)==tmp.get(0))
                sorted = true;


            if (controle && emptycount ==2)
            {
                sorted = true;

            }

        }
        for (int i = 0; i < listaDeCaixas.size(); i++) {
            LinkedList tmp = new LinkedList(listaDeCaixas.get(i).getItems());

            if(tmp.isEmpty() || tmp.size() <4){
                sorted = false;
                continue;
            }
            if(tmp.get(0) ==tmp.get(1) && tmp.get(2)==tmp.get(3) && tmp.get(2)==tmp.get(0)){
                sorted = true;
            }

        }
        return sorted;
    }
    public static int createRandom(int min, int max){

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * vai ser parametrizado para a quantidade de letras ser proporcional a quantidade de caixas menos 2
     * @param listaDeCaixas
     * @param lista
     * @param maxCaixas
     */
    public static void preencher( List<Caixa> listaDeCaixas, List<String> lista , int maxCaixas){
        LinkedList<String>letras = new LinkedList<>();

        letras.add("A");
        letras.add("B");
        letras.add("C");
        letras.add("D");
        letras.add("E");
        letras.add("F");
        letras.add("G");
        letras.add("H");
        letras.add("I");
        letras.add("J");

        //preenche as caixas com letras baseado na quantidade de caixas
        //multiplyer: se forem 4 caixas ele vai adiconar até o 4 4 vezes
        for (int i = 0; i < maxCaixas; i++) {
            for (int j = 0; j < 4; j++) {
                lista.add(letras.get(i));

            }

        }



        Collections.shuffle(lista);

        int QuantidadeDeCaixas = maxCaixas+2;
        int contador = 0;

        listaDeCaixas.add(new Caixa());
        listaDeCaixas.add(new Caixa());

        for (int i = 0; i < maxCaixas; i++) {
            Caixa caixa = new Caixa();
            for (int j = 0; j < 4; j++) {
                caixa.setItems(lista.get(contador));
                contador++;
                caixa.QTDPreenchimento = caixa.items.size();
            }
            listaDeCaixas.add(caixa);
        }

    }
}
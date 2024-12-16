import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LinkedList<Caixa>listaDepreenchidos = new LinkedList<>();
        LinkedList<Caixa> listaDeCaixas = new LinkedList<>();
        LinkedList<String> lista = new LinkedList<>();
        preencher(listaDeCaixas,lista,2);//altere aqui a quantidade de caixas -> paralelo ao nível de dificuldade


        listaDeCaixas.iterator().forEachRemaining(caixa -> System.out.println(caixa.toString()));

        Caixa caixa1;
        Caixa caixa2;

        while (true){

            try {
                 caixa1 = listaDeCaixas.get(createRandom(0,listaDeCaixas.size()-1));
                 caixa2 = listaDeCaixas.get(createRandom(0,listaDeCaixas.size()-1));

                Caixa.moverObjeto(caixa1,caixa2);
                listaDeCaixas.iterator().forEachRemaining(caixa -> System.out.println(caixa.toString()));
                if(isListaDeCaixasSorted(listaDeCaixas))
                    break;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
    }
    public static boolean isListaDeCaixasSorted(LinkedList<Caixa> listaDeCaixas) {
        // First, check if each Caixa is internally sorted
        for (Caixa caixa : listaDeCaixas) {
            // Ensure each Caixa has exactly 4 items
            if (caixa.getItems().size() != 4) {
                return false;  // If any Caixa has fewer or more than 4 items, it's not valid
            }
            // Check if the items inside each Caixa are sorted
            if (!isCaixaSorted(caixa)) {
                return false;  // If any Caixa's items are not sorted, return false
            }
        }

        // Now, check if the list of Caixa is sorted based on the first item of each Caixa
        for (int i = 0; i < listaDeCaixas.size() - 1; i++) {
            Caixa current = listaDeCaixas.get(i);
            Caixa next = listaDeCaixas.get(i + 1);

            // Compare the first item of the current and next Caixa lexicographically
            if (current.getItems().get(0).compareTo(next.getItems().get(0)) > 0) {
                return false;  // If current first item is greater, the list is not sorted
            }
        }

        return true;  // Return true if all checks pass
    }

    private static boolean isCaixaSorted(Caixa caixa) {
        List<String> items = caixa.getItems();

        // Check if the items inside the Caixa are sorted in lexicographical order
        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i).compareTo(items.get(i + 1)) > 0) {
                return false;  // If any item is greater than the next, it's not sorted
            }
        }
        return true;  // All items are sorted
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
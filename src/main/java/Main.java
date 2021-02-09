import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Random random = new Random();

        List<Rectangle> prostokaty = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            double length = random.nextInt(150);
            double width = random.nextInt(150);

            prostokaty.add(new Rectangle(length, width));
        }

        //Podpunkt A
        System.out.println(" ");
        System.out.println("Podpunkt A");
        List<Rectangle> pola = prostokaty.stream()
                .filter(shape -> shape.getArea() > shape.getPerimeter())
                .collect(Collectors.toList());

        System.out.println(pola);

        //Podpunkt B
        System.out.println(" ");
        System.out.println("Podpunkt B");
        List<Rectangle> growing = prostokaty.stream()
                .sorted(Comparator.comparingDouble(Rectangle::getPerimeter))
                .collect(Collectors.toList());

        System.out.println(growing);

        //Podpunkt C
        System.out.println(" ");
        System.out.println("Podpunkt C");
        double avg = prostokaty.stream()
                .mapToDouble(Rectangle::getPerimeter)
                .average()
                .getAsDouble();

        System.out.println(avg);

        //Podpunkt D
        System.out.println(" ");
        System.out.println("Podpunkt D");
        double avg_pole = prostokaty.stream()
                .mapToDouble(Rectangle::getArea)
                .average()
                .getAsDouble();

        System.out.println(avg_pole);

        List<Rectangle> descending = prostokaty.stream()
                .filter(shape -> shape.getArea() < avg_pole)
                .sorted(Collections.reverseOrder(Comparator.comparingDouble(Rectangle::getArea)))
                .collect(Collectors.toList());

        System.out.println(descending);

        //Podpunkt E
        System.out.println(" ");
        System.out.println("Podpunkt E");
        double suma_pol = prostokaty.stream()
                .mapToDouble(Rectangle::getArea)
                .sum();

        System.out.println(suma_pol);

        //Mapa
        System.out.println(" ");
        System.out.println("Lista do Mapy");
        Map<Rectangle, Double> mapa_figur = prostokaty.stream()
                .collect(Collectors.toMap(shape -> shape, Rectangle::getArea));

        System.out.println(mapa_figur);

    }

}

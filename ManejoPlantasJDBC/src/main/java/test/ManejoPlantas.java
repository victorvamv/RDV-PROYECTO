package test;

import datos.PlantaJDBC;
import domain.Planta;
import java.util.List;

public class ManejoPlantas {

    public static void main(String[] args) {

        PlantaJDBC planta1 = new PlantaJDBC();
        //CONSULTA
        List<Planta> plantas = planta1.select();
        for (Planta planta : plantas) {
            System.out.println("Planta" + planta);
        }
        //INSERT
        Planta planta5 = new Planta("Heuchera americana", "Coral Bells", "América del Norte ", 15, "60 cm");
        Planta planta6 = new Planta("Aspidistra elatior", "Planta de hierro", "Asia oriental", 25, "90 cm");
        Planta planta7= new Planta("Calathea orbifolia", "Verde para siempre", "Brasil",30, "90 cm" );
        Planta planta8 = new Planta("Epipremnum aureum", "Hiedra del diablo","sudeste asiático", 10, "20 m" );
        Planta planta9 = new Planta("Dracaena fragrans", "Palma de Madagascar", "África y Asia tropical", 25,  "2 m");
        Planta planta10 = new Planta("Sansevieria trifasciata", "Lengua de suegra", "África occidental", 30, "90 cm" );

        planta1.insert(planta5);
        planta1.insert(planta6);
        planta1.insert(planta7);
        planta1.insert(planta8);
        planta1.insert(planta9);
        planta1.insert(planta10);
        //Planta planta3 = new Planta("Agapanthus", "Agapanto", "Africa", 550,  "120cm");
        //planta1.insert(planta3);
        //UPDATE
        //Planta planta = new Planta(3, "Pilea peperomioides", "Planta china del dinero", "China", 200, "40cm" );
        //planta1.update(planta);
        //DELETE
        //planta1.delete(new Planta(4));
      
    }
}

package edu.teamrocket.main;

import edu.teamrocket.logica.Planeta;

import java.util.Optional;

public class ArnoldMain {

    public static void main(String[] args) {

        Optional<Double> peso = Optional.empty();
        Optional<Planeta> pluto = Optional.empty();

        System.out.println(("Planets in the weight"));
        if (!(args.length != 2)) {
            System.out.println("Please provide your weight and a planet as arguments.Using default value and Earth \n");
        }

        try{
            peso = Optional.of(Double.parseDouble(args[0]));
            pluto = Optional.of(Planeta.valueOf(args[1]));
            System.out.printf("Your weight on %s is %f N%n" , pluto.get().name(), pluto.get().pesoSuperficie(peso.get()));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("2 arguments are required: weight and planet");
            return;
        } catch (NumberFormatException e){
            System.out.println("A valid number must be entered");
            return;
        } catch (IllegalArgumentException e){
            System.out.println("The planet does not exist");
            return;
        } catch (NullPointerException e){
            System.out.println("If a not null value is required, use Optional");
            return;
        }

        String nombre_planeta = pluto.isPresent() ? pluto.get().name() : "Earth";

        System.out.printf("Your weight on %s is %f N%n",
                pluto.orElse(Planeta.EARTH),
                pluto.orElse(Planeta.EARTH).pesoSuperficie(peso.orElse(1.0)));



        System.out.println("\nYour weight only on the terrestrial planets: ");
        for(Planeta planeta: Planeta.getPlanetasTerrestres()){
            System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso.orElse(1.0)));
        }

        System.out.println("\nYour weight only on the gas giant planets: ");
        for(Planeta planeta: Planeta.getGigantesGaseosos()){
            System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso.orElse(1.0)));
        }
    }

}

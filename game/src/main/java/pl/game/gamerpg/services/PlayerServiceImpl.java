package pl.game.gamerpg.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.game.gamerpg.components.JavaUtilObjectsDI;
import pl.game.gamerpg.model.CharacterType;
import pl.game.gamerpg.model.Player;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private Player player;
    private JavaUtilObjectsDI javaUtilObjectsDI;


    @Override
    public void sayHelloToPlayer() {
        System.out.println("Witaj w grze. Wyruszasz uratować księżniczkę która jest uwięziona przez smoka.");
        System.out.println("Po drodzę do zamku smoka możesz napotkać innych wrogów.");
        System.out.println("Bądź przygotowany do walki.");
    }

    @Override
    public void getNamePlayerFromConsole() {
        System.out.println("Nazwij swoją postać.");
        player.setName(javaUtilObjectsDI.scanner().nextLine());
        System.out.println("Twoje imię: " + player.getName());

    }

    @Override
    public void getCharacterTypeFromPlayer() {

        String i;

        System.out.println("Dostępne klasy postaci: ");
        System.out.println("1) CZARODZIEJ, 2) RYCERZ, 3) BARBARZYŃCA");
        System.out.println("Wybierz klasę wpisując jej numer (1,2,3) w konsoli i wciśnij ENTER");
        i = javaUtilObjectsDI.scanner().nextLine();

        if (i.equalsIgnoreCase(String.valueOf(1))){
            player.setCharacterType(CharacterType.CZARODZIEJ);
        } else if (i.equalsIgnoreCase(String.valueOf(2))) {
            player.setCharacterType(CharacterType.RYCERZ);
        } else if (i.equalsIgnoreCase(String.valueOf(3))) {
            player.setCharacterType(CharacterType.BARBARZYŃCA);
        }

        player.setDataToArrayPlayerAttack();

    }

    @Override
    public void statsInfo() {
        player.setLifePoints(150);


        System.out.println("Twoja klasa postaci: " + player.getCharacterType());
        System.out.println("Twoje punkty życia: " + player.getLifePoints());
        System.out.println("Dostępne ataki dla klasy postaci: " + player.getCharacterType());

        int z = 0;
        if (player.getCharacterType() != null){
            for (int i = 0; i <=2; i++) {
                z++;
                System.out.println(z + ")" + player.getAttacksArray()[i]);
            }
        }

        System.out.println("Aby wybrać atak podczas walki wpisz (1, 2, 3) w konsoli i wciśnij ENTER");
        System.out.println("Aby rozpocząć grę, wziśnij ENTER");

        String enter;
        enter = javaUtilObjectsDI.scanner().nextLine();

    }

}

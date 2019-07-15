package pl.game.gamerpg.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.game.gamerpg.components.JavaUtilObjectsDI;
import pl.game.gamerpg.model.*;

@Service
@AllArgsConstructor
public class GameLogicServiceImpl implements GameLogicService {

    private Player player;
    private Thief thief;
    private Guard guard;
    private Dragon dragon;
    private JavaUtilObjectsDI javaUtilObjectsDI;

    @Override
    public void storyAboutAdventure() {
        System.out.println("Gra rozpoczęta.");
        System.out.println("Podróżujesz przez tajemnicze krainy by uwolnić księżniczkę.");
        System.out.println("Na swojej drodze spotykasz pierwszego wroga, który chce Cię zabić");
        System.out.println("Musisz z nim walczyć.");
    }

    @Override
    public void battleWithThief() {
        thief.setStatsForThief();
        thief.setDataToArrayEnemiesAttacks();

        System.out.println("Okazuje się, że jest to okoliczny: " + thief.getCharacterType());
        System.out.println("o imieniu: " + thief.getName());

        while (true) {
            player.setAttackPoints(javaUtilObjectsDI.random().nextInt(50));
            thief.setAttackPoints(javaUtilObjectsDI.random().nextInt(50));

                System.out.println("Wybierz atak: ");

                player.playerChooseAction();
                System.out.println("Twoje punkty ataku: " + player.getAttackPoints());

                thief.setLifePointsAfterAttack(thief.getLifePoints() - player.getAttackPoints());
                thief.setLifePoints(thief.getLifePointsAfterAttack());

                if (thief.getLifePointsAfterAttack() > 0) {
                    System.out.println("Energia " + thief.getCharacterType()
                                                            + " po ataku: "
                                                            + thief.getLifePointsAfterAttack());
                }

                System.out.println(thief.getCharacterType() + " atakuje. Korzysta z: "
                                                                            + thief.enemyChooseAction()
                                                                            + " zadaje punkty obrażeń: "
                                                                            + thief.getLifePoints());

                player.setLifePointsAfterAttack(player.getLifePoints() - thief.getAttackPoints());
                player.setLifePoints(player.getLifePointsAfterAttack());

                if (player.getLifePointsAfterAttack() > 0) {
                    System.out.println("Twoja energia po ataku: " + player.getLifePointsAfterAttack());
                }

                if (player.getLifePoints() <= 0
                        || thief.getLifePoints() <= 0
                        || player.getLifePoints() == thief.getLifePoints()) {
                    System.out.println(player.resultBattle());
                }

            if (player.getLifePoints() <= 0 || thief.getLifePoints() <= 0) {
                break;
            }
        }

        if (player.resultBattle() == ResultBattle.YOU_LOSE) {
            System.out.println("MIAŁEŚ MNIEJ PUNKTÓW ŻYCIA OD"
                                                    + thief.getCharacterType()
                                                    + " ZACZYNAMY OD POCZĄTKU: ");
            player.setLifePoints(150);
            storyAboutAdventure();
            battleWithThief();
        }

    }

    @Override
    public void battleWithGuard() {
        player.setLifePoints(160);
        guard.setStatsForGuard();
        System.out.println("Posiadasz teraz " + player.getLifePoints() +" punktów energii.");
        System.out.println("Jesteś w połowie drogi do celu.");
        System.out.println("Zmierzasz w kierunku mostu na którym stoi strażnik, który nie chce Cię przepuścić.");
        System.out.println("A więc musisz walczyć: ");

        while (true) {
            player.setAttackPoints(javaUtilObjectsDI.random().nextInt(60));
            guard.setAttackPoints(javaUtilObjectsDI.random().nextInt(50));

            System.out.println("Wybierz atak: ");
            player.playerChooseAction();

            System.out.println("Twoje punkty ataku: " + player.getAttackPoints());
            guard.enemyChooseAction();

            if (guard.enemyChooseAction() == CharacterAttackEnemy.BLOKADA) {
                player.setAttackPoints(0);
                System.out.println(guard.getCharacterType() + " zablokował twój atak. "
                                                                                + " Twoje punkty ataku: "
                                                                                + player.getAttackPoints());
            }

            guard.setLifePointsAfterAttack(guard.getLifePoints() - player.getLifePointsAfterAttack());
            guard.setLifePoints(guard.getLifePointsAfterAttack());

            if (guard.getLifePointsAfterAttack() > 0){
                System.out.println("Energia " + guard.getCharacterType()
                                                                        + " po ataku "
                                                                        + guard.getLifePointsAfterAttack());
            }

            System.out.println(guard.getCharacterType() + " atakuje! Koszysta z : "
                                                                        + guard.enemyChooseAction()
                                                                        + " i zadaje punkty obrażeń: "
                                                                        + guard.getAttackPoints());

            player.setLifePointsAfterAttack(player.getLifePoints() - guard.getAttackPoints());
            player.setLifePoints(player.getLifePointsAfterAttack());

            if (player.getLifePointsAfterAttack() > 0) {
                System.out.println("Twoja energia po ataku: " + player.getLifePointsAfterAttack());
            }

            if (player.getLifePoints() <= 0 ||
                    guard.getLifePoints() <= 0 ||
                    player.getLifePoints() == guard.getLifePoints()) {
                System.out.println(player.resultBattle());
            }

            if (player.getLifePoints() <= 0 || guard.getLifePoints() <= 0) {
                break;
            }

            if (player.resultBattle() == ResultBattle.YOU_LOSE){
                System.out.println("MIAŁEŚ MNIEJ PUNKTÓW ŻYCIA OD: "
                                                    + guard.getCharacterType()
                                                    + " ZACZYNAMY OD POCZĄTKU.");
                player.setLifePoints(160);
                battleWithGuard();
        }

        }
        
    }

    @Override
    public void battleWithDragon() {
        //not implement yet
    }
}

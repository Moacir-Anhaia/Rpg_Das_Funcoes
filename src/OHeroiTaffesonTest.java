import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OHeroiTaffesonTest {

    @Test
    public void atacar() {
        int vidaFinal = OHeroiTaffeson.atacar(50, new Random());

        //Meu ataque: 8 a 12 e critico 16 a 24;
        assertTrue(vidaFinal >= 38 && vidaFinal <= 42 || vidaFinal >= 26 && vidaFinal <= 34, "Verificar valor do ataque!!");


    }

    @Test
    public void usarPocao() {
        int vidaHeroi = OHeroiTaffeson.usarPocao(50);

        assertEquals(60, vidaHeroi, "Verificar valor de cura da poçao (15)");

    }

}
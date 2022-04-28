package trabajo_grupal;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestTierra {
    Visitante u1 = new Visitante("pepito", 100, 100, TipoAtraccion.AVENTURA);

    Atraccion a1 = new Atraccion("a1", 10, 3, 0, TipoAtraccion.AVENTURA);
    Atraccion a2 = new Atraccion("a2", 4, 2.5, 0, TipoAtraccion.AVENTURA);
    Atraccion a3 = new Atraccion("a3", 2, 1, 0, TipoAtraccion.AVENTURA);
    Atraccion a4 = new Atraccion("a4", 8, 4, 0, TipoAtraccion.AVENTURA);

    Promocion p1 = new Promocion_Descuento(null, null, 0);
    Promocion p2 = new Promocion_Descuento(null, null, 0);
    Promocion p3 = new Promocion_Gratis("a1", null, a2);
    Promocion p4 = new Promocion_Descuento("a1", null, 5);

    // Test nro1
    @Test
    public void Comprar() {
        u1.comprar(p1);
        assertFalse(u1.puedeComprar(a2));
    }

    // Test nro1.5 (opcional si una promocion solo tiene atracciones del mismo tipo)
    @Test
    public void puedeCompra1() {
        u1.comprar(a1);
        assertFalse(u1.puedeComprar(p2));
    }

    // Test nro2
    @Test
    public void puedeComprar2() {
        u1.comprar(p1);
        assertFalse(u1.puedeComprar(p2));
    }

    // Test nro3
    @Test
    public void pueComprar3() {
        u1.comprar(p3);
        assertFalse(u1.puedeComprar(p4));
    }

}
